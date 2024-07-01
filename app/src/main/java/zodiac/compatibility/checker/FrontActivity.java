package zodiac.compatibility.checker;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FrontActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find each zodiac ImageView and set onClickListener
        ImageView ariesImageView = findViewById(R.id.Aries);
        ImageView taurusImageView = findViewById(R.id.Taurus);
        ImageView geminiImageView = findViewById(R.id.Gemini);
        ImageView cancerImageView = findViewById(R.id.Cancer);
        ImageView leoImageView = findViewById(R.id.Leo);
        ImageView virgoImageView = findViewById(R.id.Virgo);
        ImageView libraImageView = findViewById(R.id.Libra);
        ImageView scorpioImageView = findViewById(R.id.Scorpio);
        ImageView sagittariusImageView = findViewById(R.id.Sagittarius);
        ImageView capricornImageView = findViewById(R.id.Capricorn);
        ImageView aquariusImageView = findViewById(R.id.Aquarius);
        ImageView piscesImageView = findViewById(R.id.Pisces);

        // Set click listeners for zodiac ImageViews
        setZodiacImageClickListener(ariesImageView, "Aries");
        setZodiacImageClickListener(taurusImageView, "Taurus");
        setZodiacImageClickListener(geminiImageView, "Gemini");
        setZodiacImageClickListener(cancerImageView, "Cancer");
        setZodiacImageClickListener(leoImageView, "Leo");
        setZodiacImageClickListener(virgoImageView, "Virgo");
        setZodiacImageClickListener(libraImageView, "Libra");
        setZodiacImageClickListener(scorpioImageView, "Scorpio");
        setZodiacImageClickListener(sagittariusImageView, "Sagittarius");
        setZodiacImageClickListener(capricornImageView, "Capricorn");
        setZodiacImageClickListener(aquariusImageView, "Aquarius");
        setZodiacImageClickListener(piscesImageView, "Pisces");



        TextView btnCheckCompatibility = findViewById(R.id.btnCheckCompatibility);
        String text = btnCheckCompatibility.getText().toString();

        TextView btnFindYourZodiacSign = findViewById(R.id.btnFindYourZodiacSign);
        String text1 = btnFindYourZodiacSign.getText().toString();



        SpannableString spannableString = new SpannableString(text);
        SpannableString spannableString1 = new SpannableString(text1);

        spannableString.setSpan(new UnderlineSpan(), 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString1.setSpan(new UnderlineSpan(), 0, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        btnCheckCompatibility.setText(spannableString);
        btnFindYourZodiacSign.setText(spannableString1);


        btnCheckCompatibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change text color to black
                btnCheckCompatibility.setTextColor(Color.BLACK);

                // Create a Handler to delay changing the text color back to default
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Change text color back to default (assuming default color is black)
                        btnCheckCompatibility.setTextColor(Color.WHITE);

                        Intent intent = new Intent(FrontActivity.this, CheckActivity.class);
                        startActivity(intent);
                    }
                }, 100); // 100 milliseconds delay
            }
        });

        btnFindYourZodiacSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change text color to black
                btnFindYourZodiacSign.setTextColor(Color.BLACK);

                // Create a Handler to delay changing the text color back to default
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Change text color back to default (assuming default color is black)
                        btnFindYourZodiacSign.setTextColor(Color.WHITE);

                        Intent intent = new Intent(FrontActivity.this, ZodiacActivity.class);
                        startActivity(intent);
                    }
                }, 100); // 100 milliseconds delay
            }
        });


    }



    // Method to set onClickListener for each zodiac ImageView
    private void setZodiacImageClickListener(ImageView imageView, final String zodiacSign) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation bounceAnimation = AnimationUtils.loadAnimation(FrontActivity.this, R.anim.bounce);
                imageView.startAnimation(bounceAnimation);
                // Call method to show dialog with zodiac definition
                showZodiacDefinitionDialog(zodiacSign);
            }
        });
    }

    // Method to show dialog with zodiac sign's definition
    private void showZodiacDefinitionDialog(String zodiacSign) {
        // Example definitions (replace with actual definitions)
        String zodiacDefinition = getZodiacDefinition(zodiacSign);

        // Create dialog
        Dialog dialog = new Dialog(FrontActivity.this);
        dialog.setContentView(R.layout.dialog_zodiac_definition);

        // Set dialog title
        TextView dialogTitle = dialog.findViewById(R.id.dialogTitle);
        dialogTitle.setText(zodiacSign);

        // Set zodiac definition
        TextView dialogDefinition = dialog.findViewById(R.id.dialogDefinition);
        dialogDefinition.setText(zodiacDefinition);

        // Set close button click listener
        TextView dialogCloseButton = dialog.findViewById(R.id.dialogCloseButton);
        dialogCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); // Dismiss dialog when close button is clicked
            }
        });

        // Show dialog
        dialog.show();
    }

    // Method to retrieve zodiac definition based on zodiac sign
    private String getZodiacDefinition(String zodiacSign) {
        // Replace with your actual zodiac definitions
        switch (zodiacSign) {
            case "Aries":
                return "Aries individuals are characterized by their courage, independence, and passion for life. They are natural leaders who thrive on challenges and enjoy pushing boundaries to achieve their goals. While their assertive nature can sometimes be seen as intimidating, it is their authenticity and zest for life that often draws others to them.";
            case "Taurus":
                return "Taurus individuals are characterized by their practicality, determination, and loyalty. They value stability and security in all aspects of life and are dedicated to achieving their goals with persistence and reliability.";
            case "Gemini":
                return "Gemini individuals are characterized by their adaptability, curiosity, and sociability. They have a dual nature that allows them to navigate various aspects of life with ease, though they may need to focus on consistency and decision-making to achieve their long-term goals.";
            case "Cancer":
                return "Cancer individuals are characterized by their nurturing nature, emotional depth, and strong family values. They are intuitive and empathetic, often creating supportive environments where others feel understood and cared for.";
            case "Leo":
                return "Leo individuals are characterized by their confidence, generosity, and creativity. They thrive in social settings and enjoy being the center of attention. While their strong personalities can sometimes lead to misunderstandings, it is their warmth and enthusiasm that often draw others to them.";
            case "Virgo":
                return "Virgo individuals are characterized by their practicality, intelligence, and attention to detail. They excel in roles that require precision and analytical thinking, and they value loyalty and reliability in their relationships.";
            case "Libra":
                return "Libra individuals are characterized by their diplomatic nature, social charm, and appreciation for beauty and harmony. They excel in roles that require mediation and teamwork, and they prioritize creating balanced and harmonious relationships.";
            case "Scorpio":
                return "Scorpio individuals are characterized by their intensity, determination, and depth. They thrive in roles that require resilience and strategic thinking, and they value deep emotional connections and loyalty in their relationships.";
            case "Sagittarius":
                return "Sagittarius individuals are characterized by their optimism, independence, and love for adventure. They thrive in environments that allow them to explore new ideas and experiences, and they value honesty and intellectual stimulation in their relationships.";
            case "Capricorn":
                return "Capricorn individuals are characterized by their discipline, ambition, and practicality. They excel in roles that require responsibility and long-term commitment and value loyalty and stability in their relationships.";
            case "Aquarius":
                return "Aquarius individuals are characterized by their innovation, independence, and humanitarian values. They excel in roles that allow them to explore new ideas and contribute to societal progress, and they value intellectual stimulation and independence in their relationships.";
            case "Pisces":
                return "Pisces individuals are characterized by their empathy, creativity, and adaptability. They excel in roles that allow them to express their compassion and creativity, and they value deep emotional connections and nurturing relationships.";
            // Add definitions for other zodiac signsc
            default:
                return "No definition found.";
        }
    }

    /**
     * Called when the activity has detected the user's press of the back key.
     */
    @Override
    public void onBackPressed() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(Html.fromHtml("<font color='#000'>Exit</font>"))
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", (dialog, which) -> finish())
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                .create();

        // Set background color
        alertDialog.getWindow().setBackgroundDrawableResource(R.color.dwhite);

        // Set text color for title and message
        int blackColor = ContextCompat.getColor(this, R.color.black);
        alertDialog.setOnShowListener(dialogInterface -> {
            TextView titleView = alertDialog.findViewById(android.R.id.title);
            if (titleView != null) {
                titleView.setTextColor(blackColor);
            }

            TextView messageView = alertDialog.findViewById(android.R.id.message);
            if (messageView != null) {
                messageView.setTextColor(blackColor);
            }

            // Set text color for buttons
            Button positiveButton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
            if (positiveButton != null) {
                positiveButton.setTextColor(blackColor);
            }
            Button negativeButton = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
            if (negativeButton != null) {
                negativeButton.setTextColor(blackColor);
            }
        });

        alertDialog.show();
    }

}