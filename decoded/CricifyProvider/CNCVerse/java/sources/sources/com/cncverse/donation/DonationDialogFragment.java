package com.cncverse.donation;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DonationDialogFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CricifyProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/cncverse/donation/DonationDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "config", "Lcom/cncverse/donation/DonationConfig;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "openUrl", "url", "", "Companion", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDonationDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationDialogFragment.kt\ncom/cncverse/donation/DonationDialogFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,372:1\n1#2:373\n1915#3,2:374\n*S KotlinDebug\n*F\n+ 1 DonationDialogFragment.kt\ncom/cncverse/donation/DonationDialogFragment\n*L\n175#1:374,2\n*E\n"})
public final class DonationDialogFragment extends DialogFragment {

    @NotNull
    private static final String ARG_CONFIG = "config_parcel";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private DonationConfig config;

    /* JADX INFO: compiled from: DonationDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/cncverse/donation/DonationDialogFragment$Companion;", "", "<init>", "()V", "ARG_CONFIG", "", "newInstance", "Lcom/cncverse/donation/DonationDialogFragment;", "config", "Lcom/cncverse/donation/DonationConfig;", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final DonationDialogFragment newInstance(@NotNull DonationConfig config) {
            DonationDialogFragment frag = new DonationDialogFragment();
            Bundle $this$newInstance_u24lambda_u240 = new Bundle();
            $this$newInstance_u24lambda_u240.putBoolean("enabled", config.getEnabled());
            $this$newInstance_u24lambda_u240.putString("extensionName", config.getExtensionName());
            $this$newInstance_u24lambda_u240.putString("month", config.getMonth());
            $this$newInstance_u24lambda_u240.putString("title", config.getTitle());
            $this$newInstance_u24lambda_u240.putString("currency", config.getCurrency());
            $this$newInstance_u24lambda_u240.putDouble("targetAmount", config.getTargetAmount());
            $this$newInstance_u24lambda_u240.putDouble("currentAmount", config.getCurrentAmount());
            $this$newInstance_u24lambda_u240.putInt("supportersCount", config.getSupportersCount());
            $this$newInstance_u24lambda_u240.putInt("apiPercent", config.getApiPercent());
            $this$newInstance_u24lambda_u240.putString("primaryDonateUrl", config.getPrimaryDonateUrl());
            $this$newInstance_u24lambda_u240.putString("primaryButtonText", config.getPrimaryButtonText());
            $this$newInstance_u24lambda_u240.putString("secondaryDonateUrl", config.getSecondaryDonateUrl());
            $this$newInstance_u24lambda_u240.putString("secondaryButtonText", config.getSecondaryButtonText());
            $this$newInstance_u24lambda_u240.putString("adSupportUrl", config.getAdSupportUrl());
            $this$newInstance_u24lambda_u240.putString("adSupportButtonText", config.getAdSupportButtonText());
            frag.setArguments($this$newInstance_u24lambda_u240);
            return frag;
        }
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(1, R.style.Theme.Black.NoTitleBar);
        Bundle a = requireArguments();
        this.config = new DonationConfig(a.getBoolean("enabled", true), a.getString("extensionName", ""), a.getString("month", "Monthly Goal"), a.getString("title", "Help Keep CNCVerse Alive"), null, a.getString("currency", "$"), a.getDouble("targetAmount", 100.0d), a.getDouble("currentAmount", 0.0d), a.getInt("supportersCount", 0), a.getInt("apiPercent", -1), a.getString("primaryDonateUrl", "https://cncverse.pages.dev"), a.getString("primaryButtonText", "☕ Keep It Alive"), a.getString("secondaryDonateUrl", ""), a.getString("secondaryButtonText", "⚡ Donate via UPI / Other"), a.getString("adSupportUrl", ""), a.getString("adSupportButtonText", "🎬 Can't donate? Watch an Ad to Support ↗"), 0, 65552, null);
    }

    public void onStart() {
        Window $this$onStart_u24lambda_u240;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && ($this$onStart_u24lambda_u240 = dialog.getWindow()) != null) {
            $this$onStart_u24lambda_u240.setLayout(-1, -1);
            $this$onStart_u24lambda_u240.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#99000000")));
            $this$onStart_u24lambda_u240.setDimAmount(0.0f);
        }
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Iterable bullets;
        String primaryButtonText;
        Context ctx = requireContext();
        float dp = ctx.getResources().getDisplayMetrics().density;
        DonationConfig donationConfig = this.config;
        String str = "config";
        if (donationConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            donationConfig = null;
        }
        boolean isAchieved = donationConfig.isGoalAchieved();
        DonationConfig donationConfig2 = this.config;
        if (donationConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            donationConfig2 = null;
        }
        int pct = donationConfig2.getProgressPercentage();
        FrameLayout frame = new FrameLayout(ctx);
        frame.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frame.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.donation.DonationDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.dismissAllowingStateLoss();
            }
        });
        GradientDrawable cardBg = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#251442"), Color.parseColor("#180D2D"), Color.parseColor("#0F071B")});
        cardBg.setCornerRadius(20.0f * dp);
        cardBg.setStroke((int) (1.5f * dp), Color.parseColor("#7C3AED"));
        int maxWidthPx = Math.min((int) (ctx.getResources().getDisplayMetrics().widthPixels * 0.9f), (int) (420 * dp));
        LinearLayout card = new LinearLayout(ctx);
        card.setOrientation(1);
        card.setBackground(cardBg);
        float f = 20;
        int i = (int) (f * dp);
        int i2 = (int) (f * dp);
        int i3 = (int) (f * dp);
        float f2 = 16;
        card.setPadding(i, i2, i3, (int) (f2 * dp));
        card.setLayoutParams(new FrameLayout.LayoutParams(maxWidthPx, -2, 17));
        card.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.donation.DonationDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonationDialogFragment.onCreateView$lambda$2$0(view);
            }
        });
        GradientDrawable $this$onCreateView_u24lambda_u243 = new GradientDrawable();
        $this$onCreateView_u24lambda_u243.setColor(Color.parseColor("#3B1D6B"));
        $this$onCreateView_u24lambda_u243.setCornerRadius(dp * 100.0f);
        float f3 = 1;
        $this$onCreateView_u24lambda_u243.setStroke((int) (f3 * dp), Color.parseColor("#8B5CF6"));
        TextView $this$onCreateView_u24lambda_u244 = new TextView(ctx);
        $this$onCreateView_u24lambda_u244.setText("⚡ CNCVerse Repo • by NivinCNC ↗");
        $this$onCreateView_u24lambda_u244.setTextColor(Color.parseColor("#C4B5FD"));
        $this$onCreateView_u24lambda_u244.setTextSize(12.0f);
        $this$onCreateView_u24lambda_u244.setTypeface(Typeface.DEFAULT_BOLD);
        $this$onCreateView_u24lambda_u244.setBackground($this$onCreateView_u24lambda_u243);
        float f4 = 12;
        int ph = (int) (f4 * dp);
        int pv = (int) (5 * dp);
        $this$onCreateView_u24lambda_u244.setPadding(ph, pv, ph, pv);
        $this$onCreateView_u24lambda_u244.setClickable(true);
        $this$onCreateView_u24lambda_u244.setFocusable(true);
        $this$onCreateView_u24lambda_u244.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.donation.DonationDialogFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.openUrl("https://github.com/NivinCNC");
            }
        });
        LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-2, -2);
        it.bottomMargin = (int) (f4 * dp);
        $this$onCreateView_u24lambda_u244.setLayoutParams(it);
        TextView $this$onCreateView_u24lambda_u245 = new TextView(ctx);
        $this$onCreateView_u24lambda_u245.setText(isAchieved ? "🎉  CNCVerse Goal Achieved!" : "⚠️  Help Keep CNCVerse Alive");
        $this$onCreateView_u24lambda_u245.setTextColor(-1);
        $this$onCreateView_u24lambda_u245.setTextSize(18.0f);
        $this$onCreateView_u24lambda_u245.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams it2 = new LinearLayout.LayoutParams(-1, -2);
        float f5 = 10;
        it2.bottomMargin = (int) (f5 * dp);
        $this$onCreateView_u24lambda_u245.setLayoutParams(it2);
        if (isAchieved) {
            bullets = CollectionsKt.listOf(new String[]{"🎉 Goal achieved! Thank you for the incredible support", "🛠️ Keeps 35+ providers actively maintained", "🐞 Faster bug fixes", "💖 Extra love helps adding new extensions", "🚫 No Ads, No Subscription: CNCVerse stays 100% free for everyone."});
        } else {
            StringBuilder sbAppend = new StringBuilder().append("🚫 No Ads, No Subscription: Keeps ");
            DonationConfig donationConfig3 = this.config;
            if (donationConfig3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
                donationConfig3 = null;
            }
            bullets = CollectionsKt.listOf(new String[]{sbAppend.append(donationConfig3.getExtensionName()).append(" and all extensions 100% free.").toString(), "🛠️ Active Repo Maintenance: Maintaining 35+ providers against weekly site changes & domain blocks.", "⚠️ Goal Missed = Delayed Fixes: If monthly target isn't met, extension updates will slow down.", "💀 Zero Support = Extensions Die: Without support, providers break and links die over time."});
        }
        LinearLayout $this$onCreateView_u24lambda_u246 = new LinearLayout(ctx);
        $this$onCreateView_u24lambda_u246.setOrientation(1);
        LinearLayout.LayoutParams it3 = new LinearLayout.LayoutParams(-1, -2);
        float f6 = 14;
        it3.bottomMargin = (int) (f6 * dp);
        $this$onCreateView_u24lambda_u246.setLayoutParams(it3);
        Iterable $this$forEach$iv = bullets;
        int $i$f$forEach = 0;
        Iterator it4 = $this$forEach$iv.iterator();
        while (true) {
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            if (!it4.hasNext()) {
                break;
            }
            Object element$iv = it4.next();
            String b = (String) element$iv;
            TextView $this$onCreateView_u24lambda_u247_u240 = new TextView(ctx);
            $this$onCreateView_u24lambda_u247_u240.setText(b);
            $this$onCreateView_u24lambda_u247_u240.setTextColor(Color.parseColor("#E9D5FF"));
            $this$onCreateView_u24lambda_u247_u240.setTextSize(13.0f);
            $this$onCreateView_u24lambda_u247_u240.setLineSpacing(0.0f, 1.35f);
            LinearLayout.LayoutParams it5 = new LinearLayout.LayoutParams(-1, -2);
            it5.bottomMargin = (int) (4 * dp);
            $this$onCreateView_u24lambda_u247_u240.setLayoutParams(it5);
            $this$onCreateView_u24lambda_u246.addView($this$onCreateView_u24lambda_u247_u240);
            $this$forEach$iv = $this$forEach$iv2;
            str = str;
            $i$f$forEach = $i$f$forEach;
            cardBg = cardBg;
        }
        String str2 = str;
        GradientDrawable $this$onCreateView_u24lambda_u248 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#1E1035"), Color.parseColor("#120924")});
        $this$onCreateView_u24lambda_u248.setCornerRadius(dp * 12.0f);
        $this$onCreateView_u24lambda_u248.setStroke((int) (f3 * dp), Color.parseColor("#4C1D95"));
        LinearLayout $this$onCreateView_u24lambda_u249 = new LinearLayout(ctx);
        $this$onCreateView_u24lambda_u249.setOrientation(1);
        $this$onCreateView_u24lambda_u249.setBackground($this$onCreateView_u24lambda_u248);
        int p = (int) (f6 * dp);
        $this$onCreateView_u24lambda_u249.setPadding(p, p, p, p);
        LinearLayout.LayoutParams it6 = new LinearLayout.LayoutParams(-1, -2);
        it6.bottomMargin = (int) (f6 * dp);
        $this$onCreateView_u24lambda_u249.setLayoutParams(it6);
        LinearLayout $this$onCreateView_u24lambda_u2410 = new LinearLayout(ctx);
        $this$onCreateView_u24lambda_u2410.setOrientation(0);
        LinearLayout.LayoutParams it7 = new LinearLayout.LayoutParams(-1, -2);
        float f7 = 8;
        it7.bottomMargin = (int) (f7 * dp);
        $this$onCreateView_u24lambda_u2410.setLayoutParams(it7);
        TextView $this$onCreateView_u24lambda_u2411 = new TextView(ctx);
        StringBuilder sb = new StringBuilder();
        DonationConfig donationConfig4 = this.config;
        if (donationConfig4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            donationConfig4 = null;
        }
        $this$onCreateView_u24lambda_u2411.setText(sb.append(donationConfig4.getMonth()).append(" Goal").toString());
        $this$onCreateView_u24lambda_u2411.setTextColor(Color.parseColor("#C4B5FD"));
        $this$onCreateView_u24lambda_u2411.setTextSize(13.0f);
        $this$onCreateView_u24lambda_u2411.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView $this$onCreateView_u24lambda_u2412 = new TextView(ctx);
        DonationConfig donationConfig5 = this.config;
        if (donationConfig5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            donationConfig5 = null;
        }
        String cur = donationConfig5.getCurrency();
        StringBuilder sbAppend2 = new StringBuilder().append(cur);
        DonationConfig donationConfig6 = this.config;
        if (donationConfig6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            donationConfig6 = null;
        }
        StringBuilder sbAppend3 = sbAppend2.append((int) donationConfig6.getCurrentAmount()).append(" / ").append(cur);
        DonationConfig donationConfig7 = this.config;
        if (donationConfig7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            donationConfig7 = null;
        }
        String cur2 = sbAppend3.append((int) donationConfig7.getTargetAmount()).append("  (").append(pct).append("%)").toString();
        $this$onCreateView_u24lambda_u2412.setText(cur2);
        $this$onCreateView_u24lambda_u2412.setTextColor(Color.parseColor("#4ADE80"));
        $this$onCreateView_u24lambda_u2412.setTextSize(13.0f);
        $this$onCreateView_u24lambda_u2412.setTypeface(Typeface.DEFAULT_BOLD);
        $this$onCreateView_u24lambda_u2412.setGravity(8388613);
        $this$onCreateView_u24lambda_u2412.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        $this$onCreateView_u24lambda_u2410.addView($this$onCreateView_u24lambda_u2411);
        $this$onCreateView_u24lambda_u2410.addView($this$onCreateView_u24lambda_u2412);
        GradientDrawable $this$onCreateView_u24lambda_u2413 = new GradientDrawable();
        $this$onCreateView_u24lambda_u2413.setColor(Color.parseColor("#2A124E"));
        $this$onCreateView_u24lambda_u2413.setCornerRadius(dp * 100.0f);
        LinearLayout track = new LinearLayout(ctx);
        track.setOrientation(0);
        track.setBackground($this$onCreateView_u24lambda_u2413);
        track.setWeightSum(100.0f);
        track.setClipToOutline(true);
        float f8 = 6;
        LinearLayout.LayoutParams it8 = new LinearLayout.LayoutParams(-1, (int) (f8 * dp));
        it8.bottomMargin = (int) (f7 * dp);
        track.setLayoutParams(it8);
        GradientDrawable $this$onCreateView_u24lambda_u2415 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#22C55E"), Color.parseColor("#4ADE80")});
        $this$onCreateView_u24lambda_u2415.setCornerRadius(dp * 100.0f);
        int clampedPct = RangesKt.coerceIn(pct, 0, 100);
        View fill = new View(ctx);
        fill.setBackground($this$onCreateView_u24lambda_u2415);
        fill.setLayoutParams(new LinearLayout.LayoutParams(0, -1, clampedPct));
        View $this$onCreateView_u24lambda_u2417 = new View(ctx);
        $this$onCreateView_u24lambda_u2417.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 100 - clampedPct));
        track.addView(fill);
        track.addView($this$onCreateView_u24lambda_u2417);
        TextView $this$onCreateView_u24lambda_u2418 = new TextView(ctx);
        StringBuilder sbAppend4 = new StringBuilder().append("👥 ");
        DonationConfig donationConfig8 = this.config;
        if (donationConfig8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            donationConfig8 = null;
        }
        $this$onCreateView_u24lambda_u2418.setText(sbAppend4.append(donationConfig8.getSupportersCount()).append(" supporters this month").toString());
        $this$onCreateView_u24lambda_u2418.setTextColor(Color.parseColor("#A78BFA"));
        $this$onCreateView_u24lambda_u2418.setTextSize(12.0f);
        $this$onCreateView_u24lambda_u249.addView($this$onCreateView_u24lambda_u2410);
        $this$onCreateView_u24lambda_u249.addView(track);
        $this$onCreateView_u24lambda_u249.addView($this$onCreateView_u24lambda_u2418);
        LinearLayout actionRow = new LinearLayout(ctx);
        actionRow.setOrientation(0);
        actionRow.setGravity(8388613);
        LinearLayout.LayoutParams it9 = new LinearLayout.LayoutParams(-1, -2);
        it9.bottomMargin = (int) (f7 * dp);
        actionRow.setLayoutParams(it9);
        TextView $this$onCreateView_u24lambda_u2420 = new TextView(ctx);
        $this$onCreateView_u24lambda_u2420.setText(isAchieved ? "Awesome!" : "Maybe Later");
        $this$onCreateView_u24lambda_u2420.setTextColor(Color.parseColor("#A78BFA"));
        $this$onCreateView_u24lambda_u2420.setTextSize(14.0f);
        int p2 = (int) (f5 * dp);
        $this$onCreateView_u24lambda_u2420.setPadding(p2, p2, p2, p2);
        $this$onCreateView_u24lambda_u2420.setClickable(true);
        $this$onCreateView_u24lambda_u2420.setFocusable(true);
        $this$onCreateView_u24lambda_u2420.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.donation.DonationDialogFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.dismissAllowingStateLoss();
            }
        });
        GradientDrawable $this$onCreateView_u24lambda_u2421 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#7C3AED"), Color.parseColor("#5B21B6")});
        $this$onCreateView_u24lambda_u2421.setCornerRadius(dp * 10.0f);
        $this$onCreateView_u24lambda_u2421.setStroke((int) (f3 * dp), Color.parseColor("#8B5CF6"));
        TextView $this$onCreateView_u24lambda_u2422 = new TextView(ctx);
        if (isAchieved) {
            primaryButtonText = "💖 Send Extra Love";
        } else {
            DonationConfig donationConfig9 = this.config;
            if (donationConfig9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                donationConfig9 = null;
            }
            primaryButtonText = donationConfig9.getPrimaryButtonText();
        }
        $this$onCreateView_u24lambda_u2422.setText(primaryButtonText);
        $this$onCreateView_u24lambda_u2422.setTextColor(-1);
        $this$onCreateView_u24lambda_u2422.setTextSize(14.0f);
        $this$onCreateView_u24lambda_u2422.setTypeface(Typeface.DEFAULT_BOLD);
        $this$onCreateView_u24lambda_u2422.setBackground($this$onCreateView_u24lambda_u2421);
        int ph2 = (int) (f2 * dp);
        int pv2 = (int) (f5 * dp);
        $this$onCreateView_u24lambda_u2422.setPadding(ph2, pv2, ph2, pv2);
        $this$onCreateView_u24lambda_u2422.setClickable(true);
        $this$onCreateView_u24lambda_u2422.setFocusable(true);
        $this$onCreateView_u24lambda_u2422.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.donation.DonationDialogFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonationDialogFragment.onCreateView$lambda$22$0(this.f$0, view);
            }
        });
        LinearLayout.LayoutParams it10 = new LinearLayout.LayoutParams(-2, -2);
        it10.leftMargin = (int) (f7 * dp);
        $this$onCreateView_u24lambda_u2422.setLayoutParams(it10);
        actionRow.addView($this$onCreateView_u24lambda_u2420);
        actionRow.addView($this$onCreateView_u24lambda_u2422);
        GradientDrawable $this$onCreateView_u24lambda_u2423 = new GradientDrawable();
        $this$onCreateView_u24lambda_u2423.setColor(Color.parseColor("#1C0F32"));
        $this$onCreateView_u24lambda_u2423.setCornerRadius(dp * 100.0f);
        $this$onCreateView_u24lambda_u2423.setStroke((int) (f3 * dp), Color.parseColor("#4C1D95"));
        TextView $this$onCreateView_u24lambda_u2424 = new TextView(ctx);
        DonationConfig donationConfig10 = this.config;
        if (donationConfig10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            donationConfig10 = null;
        }
        $this$onCreateView_u24lambda_u2424.setText(donationConfig10.getAdSupportButtonText());
        $this$onCreateView_u24lambda_u2424.setTextColor(Color.parseColor("#C4B5FD"));
        $this$onCreateView_u24lambda_u2424.setTextSize(12.0f);
        $this$onCreateView_u24lambda_u2424.setGravity(17);
        $this$onCreateView_u24lambda_u2424.setBackground($this$onCreateView_u24lambda_u2423);
        int ph3 = (int) (f4 * dp);
        float f9 = 9;
        int pv3 = (int) (f9 * dp);
        $this$onCreateView_u24lambda_u2424.setPadding(ph3, pv3, ph3, pv3);
        $this$onCreateView_u24lambda_u2424.setClickable(true);
        $this$onCreateView_u24lambda_u2424.setFocusable(true);
        DonationConfig donationConfig11 = this.config;
        if (donationConfig11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            donationConfig11 = null;
        }
        $this$onCreateView_u24lambda_u2424.setVisibility(StringsKt.isBlank(donationConfig11.getAdSupportUrl()) ? 8 : 0);
        $this$onCreateView_u24lambda_u2424.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.donation.DonationDialogFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonationDialogFragment.onCreateView$lambda$24$0(this.f$0, view);
            }
        });
        LinearLayout.LayoutParams it11 = new LinearLayout.LayoutParams(-1, -2);
        it11.bottomMargin = (int) (f8 * dp);
        $this$onCreateView_u24lambda_u2424.setLayoutParams(it11);
        GradientDrawable $this$onCreateView_u24lambda_u2425 = new GradientDrawable();
        $this$onCreateView_u24lambda_u2425.setColor(0);
        $this$onCreateView_u24lambda_u2425.setCornerRadius(dp * 10.0f);
        $this$onCreateView_u24lambda_u2425.setStroke((int) (f3 * dp), Color.parseColor("#7C3AED"));
        TextView $this$onCreateView_u24lambda_u2426 = new TextView(ctx);
        DonationConfig donationConfig12 = this.config;
        if (donationConfig12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            donationConfig12 = null;
        }
        $this$onCreateView_u24lambda_u2426.setText(donationConfig12.getSecondaryButtonText());
        $this$onCreateView_u24lambda_u2426.setTextColor(Color.parseColor("#C4B5FD"));
        $this$onCreateView_u24lambda_u2426.setTextSize(13.0f);
        $this$onCreateView_u24lambda_u2426.setGravity(17);
        $this$onCreateView_u24lambda_u2426.setBackground($this$onCreateView_u24lambda_u2425);
        int ph4 = (int) (f4 * dp);
        int pv4 = (int) (f9 * dp);
        $this$onCreateView_u24lambda_u2426.setPadding(ph4, pv4, ph4, pv4);
        $this$onCreateView_u24lambda_u2426.setClickable(true);
        $this$onCreateView_u24lambda_u2426.setFocusable(true);
        DonationConfig donationConfig13 = this.config;
        if (donationConfig13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            donationConfig13 = null;
        }
        $this$onCreateView_u24lambda_u2426.setVisibility(StringsKt.isBlank(donationConfig13.getSecondaryDonateUrl()) ? 8 : 0);
        $this$onCreateView_u24lambda_u2426.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.donation.DonationDialogFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonationDialogFragment.onCreateView$lambda$26$0(this.f$0, view);
            }
        });
        $this$onCreateView_u24lambda_u2426.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        card.addView($this$onCreateView_u24lambda_u244);
        card.addView($this$onCreateView_u24lambda_u245);
        card.addView($this$onCreateView_u24lambda_u246);
        card.addView($this$onCreateView_u24lambda_u249);
        card.addView(actionRow);
        card.addView($this$onCreateView_u24lambda_u2424);
        card.addView($this$onCreateView_u24lambda_u2426);
        frame.addView(card);
        return frame;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$0(View it) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$22$0(DonationDialogFragment this$0, View it) {
        this$0.dismissAllowingStateLoss();
        DonationConfig donationConfig = this$0.config;
        if (donationConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            donationConfig = null;
        }
        this$0.openUrl(donationConfig.getPrimaryDonateUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$24$0(DonationDialogFragment this$0, View it) {
        this$0.dismissAllowingStateLoss();
        DonationConfig donationConfig = this$0.config;
        if (donationConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            donationConfig = null;
        }
        this$0.openUrl(donationConfig.getAdSupportUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$26$0(DonationDialogFragment this$0, View it) {
        this$0.dismissAllowingStateLoss();
        DonationConfig donationConfig = this$0.config;
        if (donationConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            donationConfig = null;
        }
        this$0.openUrl(donationConfig.getSecondaryDonateUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openUrl(String url) {
        if (StringsKt.isBlank(url)) {
            return;
        }
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)).addFlags(268435456));
        } catch (Exception e) {
        }
    }
}
