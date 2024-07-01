package zodiac.compatibility.checker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CompatibilityResultActivity extends AppCompatActivity {
    private TextView compatibilityScoreTextView;
    private TextView compatibilityInsightsTextView;
    private TextView shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compatibility_result);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        compatibilityScoreTextView = findViewById(R.id.tvCompatibilityScore);
        compatibilityInsightsTextView = findViewById(R.id.tvCompatibilityInsights);
        shareButton = findViewById(R.id.btnShare);

        Intent intent = getIntent();
        String userSign = intent.getStringExtra("USER_SIGN");
        String partnerSign = intent.getStringExtra("PARTNER_SIGN");

        int compatibilityScore = CompatibilityLogic.calculateCompatibility(userSign, partnerSign);
        String compatibilityInsights = CompatibilityLogic.getCompatibilityInsights(userSign, partnerSign);

        compatibilityScoreTextView.setText(getString(R.string.compatibility_score_label) + compatibilityScore);
        compatibilityInsightsTextView.setText(compatibilityInsights != null ? compatibilityInsights : getString(R.string.default_compatibility_insights));

        String text = shareButton.getText().toString();

        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new UnderlineSpan(), 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        shareButton.setText(spannableString);


        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change text color to black
                shareButton.setTextColor(Color.BLACK);

                // Create a Handler to delay changing the text color back to default
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Change text color back to default (assuming default color is black)
                        shareButton.setTextColor(Color.WHITE);
                    }
                }, 100); // 100 milliseconds delay
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "My compatibility with " + partnerSign + ": " + compatibilityScore + "%");
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent, getString(R.string.share_via)));
            }
        });
    }
}
