package zodiac.compatibility.checker;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CheckActivity extends AppCompatActivity {

    private AutoCompleteTextView userSignAutoComplete;
    private AutoCompleteTextView partnerSignAutoComplete;
    private TextView checkCompatibilityButton;

    private String[] signs; // Array to hold zodiac signs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Initialize views
        userSignAutoComplete = findViewById(R.id.autoCompleteTextViewUserSign);
        partnerSignAutoComplete = findViewById(R.id.autoCompleteTextViewPartnerSign);
        checkCompatibilityButton = findViewById(R.id.btnCheckCompatibility);

        // Initialize zodiac signs array from resources
        signs = getResources().getStringArray(R.array.zodiac_signs);

        // Set adapter for AutoCompleteTextViews
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_dropdown_item, R.id.text1, signs) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                return view;
            }
        };


        userSignAutoComplete.setAdapter(adapter);
        partnerSignAutoComplete.setAdapter(adapter);

        // Underline the button text
        String buttonText = checkCompatibilityButton.getText().toString();
        SpannableString spannableString = new SpannableString(buttonText);
        spannableString.setSpan(new UnderlineSpan(), 0, buttonText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        checkCompatibilityButton.setText(spannableString);

        // Set click listener for the button to check compatibility
        checkCompatibilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change text color to black
                checkCompatibilityButton.setTextColor(Color.BLACK);

                // Create a Handler to delay changing the text color back to default
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Change text color back to default (assuming default color is black)
                        checkCompatibilityButton.setTextColor(Color.WHITE);
                    }
                }, 100); // 100 milliseconds delay
                String userSign = userSignAutoComplete.getText().toString().trim();
                String partnerSign = partnerSignAutoComplete.getText().toString().trim();

                // Find the TextView by its ID
                TextView errorMessageTextView = findViewById(R.id.errorMessageTextView);

                if (userSign.isEmpty() || partnerSign.isEmpty()) {
                    // If either userSign or partnerSign is empty, show the error message TextView
                    errorMessageTextView.setVisibility(View.VISIBLE);
                    return;
                } else {
                    // If both signs are selected, hide the error message TextView
                    errorMessageTextView.setVisibility(View.GONE);
                }


                // Start CompatibilityResultActivity
                Intent intent = new Intent(CheckActivity.this, CompatibilityResultActivity.class);
                intent.putExtra("USER_SIGN", userSign);
                intent.putExtra("PARTNER_SIGN", partnerSign);
                startActivity(intent);
            }
        });


        // Set click listener for AutoCompleteTextViews to show AlertDialog
        userSignAutoComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showZodiacSignDialog(userSignAutoComplete);
            }
        });

        partnerSignAutoComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showZodiacSignDialog(partnerSignAutoComplete);
            }
        });
    }

    // Method to show AlertDialog with zodiac sign options
    private void showZodiacSignDialog(final AutoCompleteTextView autoCompleteTextView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Your Zodiac Sign");

        // Prepare custom ArrayAdapter with image and text
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_dropdown_item, R.id.text1, signs) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ImageView imageView = view.findViewById(R.id.imageView);
                // Set image for each zodiac sign
                imageView.setImageResource(getImageResourceForSign(signs[position]));
                return view;
            }
        };

        // Set the adapter to the AlertDialog
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selectedSign = signs[which];
                autoCompleteTextView.setText(selectedSign);
            }
        });

        // Show the AlertDialog
        builder.show();
    }

    // Method to map each zodiac sign to its corresponding image resource
    private int getImageResourceForSign(String sign) {
        switch (sign) {
            case "Aries":
                return R.drawable.aries; // Replace with your actual drawable resource IDs
            case "Taurus":
                return R.drawable.taurus;
            case "Gemini":
                return R.drawable.gemini;
            case "Cancer":
                return R.drawable.cancer;
            case "Leo":
                return R.drawable.leo;
            case "Virgo":
                return R.drawable.virgo;
            case "Libra":
                return R.drawable.libra;
            case "Scorpio":
                return R.drawable.scorpio;
            case "Sagittarius":
                return R.drawable.sagittarius;
            case "Capricorn":
                return R.drawable.capricorn;
            case "Aquarius":
                return R.drawable.aquarius;
            case "Pisces":
                return R.drawable.pisces;
            default:
                return R.drawable.aries; // Default placeholder image
        }
    }


}
