package com.moringaschool.android_ip_1.UI;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.moringaschool.android_ip_1.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = SignUpActivity.class.getSimpleName();

    private String userName;

    private FirebaseAuth firebaseAuth;

    private FirebaseAuth.AuthStateListener firebaseAuthListener;  /* AuthStateListener simply listens for an account being successfully authenticated, or un-authenticated through Firebase. Firebase can also automatically authenticate user accounts upon registration. Therefore, our users can submit the registration form and if their account is created successfully they will be logged in automatically, and this listener will be triggered.*/

    @BindView(R.id.tvSignUpName) TextView tvSignUpName;
    @BindView(R.id.tvSignUpEmail) TextView tvSignUpEmail;
    @BindView(R.id.tvSignUpPassword) TextView tvSignUpPassword;
    @BindView(R.id.tvSignUpConfirmPassword) TextView tvSignUpConfirmPassword;
    @BindView(R.id.clSignUpCreateAccount) ConstraintLayout clSignUpCreateAccount;
    @BindView(R.id.tvSignUpSignIn) TextView tvSignUpSignIn;
//    @BindView(R.id.pbSignInProgressBar) ProgressBar pbSignInProgressBar;
//    @BindView(R.id.tvLoadingSignUp) TextView tvLoadingSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);

        clSignUpCreateAccount.setOnClickListener(this);
        tvSignUpSignIn.setOnClickListener(this);

        firebaseAuth=FirebaseAuth.getInstance();

        createAuthStateListener();

    }

    private void createAuthStateListener() {

        firebaseAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                final FirebaseUser firebaseUser= firebaseAuth.getCurrentUser();

                if (firebaseUser!=null){

                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();

                }

            }
        };

    }

    @Override
    public void onClick(View view) {

        if (view ==clSignUpCreateAccount){

            createNewUser();

        }

        if (view==tvSignUpSignIn){

            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); /*FLAG_ACTIVITY_CLEAR_TASK will cause any existing task that would be associated with the activity to be cleared before the activity is started. This prevents this Activity from being unnecessarily accessed via the system back button. FLAG_ACTIVITY_NEW_TASK will make the activity we are navigating to the start of a brand new task on this history stack.*/
            startActivity(intent);
            finish();

        }

    }

    private void createNewUser() {

        userName = tvSignUpName.getText().toString().trim();

        //capture input from user.
        final String name = tvSignUpName.getText().toString().trim();
        final String email = tvSignUpEmail.getText().toString().trim();
        String password = tvSignUpPassword.getText().toString().trim();
        String confirmPassword = tvSignUpConfirmPassword.getText().toString().trim();

        boolean validEmail = isValidEmail(email);
        boolean validUserName = isValidUserName(name);
        boolean validPassword = isValidPassword(password, confirmPassword);
        if (!validEmail || !validUserName || !validPassword) return;

        showProgressBar();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, task -> {

            if (task.isSuccessful()){

                Log.d(TAG, "Firebase Authentication is successful.");

                hideProgressBar();

                createFirebaseUserProfile(Objects.requireNonNull(task.getResult().getUser()));

                Toast.makeText(SignUpActivity.this, "Firebase Authentication is successful.", Toast.LENGTH_SHORT).show();

            }else {

                Toast.makeText(SignUpActivity.this, "Firebase Authentication has failed.", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (firebaseAuthListener != null) {
            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        }
    }

    private boolean isValidUserName(String name) {

        if (name.equals("")) {

            tvSignUpName.setError("Please enter your name");
            return false;

        }

        return true;

    }

    private boolean isValidEmail(String email) {

        boolean isGoodEmail =(email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches());

        if (!isGoodEmail) {

            tvSignUpEmail.setError("Please enter a valid email address");
            return false;

        }
        return isGoodEmail;

    }

    private boolean isValidPassword(String password, String confirmPassword) {

        if (password.length() < 6) {

            tvSignUpPassword.setError("Please create a password containing at least 6 characters");
            return false;

        } else if (!password.equals(confirmPassword)) {

            tvSignUpConfirmPassword.setError("Passwords do not match");
            return false;

        }

        return true;

    }

    private void showProgressBar() {

//        pbSignInProgressBar.setVisibility(View.VISIBLE);
//        tvLoadingSignUp.setVisibility(View.VISIBLE);
//        tvLoadingSignUp.setText("Give us a second to set up your account.");

    }

    private void hideProgressBar() {

//        pbSignInProgressBar.setVisibility(View.GONE);
//        tvLoadingSignUp.setVisibility(View.GONE);

    }

    private void createFirebaseUserProfile(final FirebaseUser firebaseUser) {

        UserProfileChangeRequest addProfileName = new UserProfileChangeRequest.Builder().setDisplayName(userName).build();

        firebaseUser.updateProfile(addProfileName).addOnCompleteListener(new OnCompleteListener<Void>() {

            @Override
            public void onComplete(@NonNull Task<Void> task) {


                if (task.isSuccessful()) {

                    Log.d(TAG, Objects.requireNonNull(firebaseUser.getDisplayName()));

                    String inputFirebaseUserName = Objects.requireNonNull(firebaseUser.getDisplayName());

                    Toast.makeText(SignUpActivity.this, "The display name has been set", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(SignUpActivity.this, MovieSearchActivity.class);
                    intent.putExtra("inputFirebaseUserName", inputFirebaseUserName);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); /*FLAG_ACTIVITY_CLEAR_TASK will cause any existing task that would be associated with the activity to be cleared before the activity is started. This prevents this Activity from being unnecessarily accessed via the system back button. FLAG_ACTIVITY_NEW_TASK will make the activity we are navigating to the start of a brand new task on this history stack.*/
                    startActivity(intent);

                    finish();

                }

            }

        });

    }

}