package com.phisher98.donation;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DonationDialogFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Fibwatch/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J6\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0017b\u0010\b\u0014\u0012\f\b\u0015\u0012\b\b\fJ\u0004\b\b(\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/phisher98/donation/DonationDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "config", "Lcom/phisher98/donation/DonationConfig;", "onDismissCallback", "Lkotlin/Function0;", "", "<init>", "(Lcom/phisher98/donation/DonationConfig;Lkotlin/jvm/functions/Function0;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Landroid/annotation/SuppressLint;", "value", "SetTextI18n", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroy", "openUrl", "context", "Landroid/content/Context;", "url", "", "Fibwatch"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDonationDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationDialogFragment.kt\ncom/phisher98/donation/DonationDialogFragment\n+ 2 ColorDrawable.kt\nandroidx/core/graphics/drawable/ColorDrawableKt\n+ 3 Color.kt\nandroidx/core/graphics/ColorKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,470:1\n27#2:471\n432#3:472\n432#3:473\n432#3:474\n432#3:475\n432#3:477\n432#3:478\n432#3:479\n432#3:480\n432#3:481\n432#3:482\n432#3:483\n432#3:484\n432#3:485\n432#3:486\n432#3:487\n432#3:488\n432#3:489\n432#3:490\n432#3:491\n432#3:492\n432#3:493\n432#3:494\n432#3:495\n432#3:497\n432#3:498\n432#3:499\n432#3:500\n432#3:501\n432#3:502\n1#4:476\n29#5:496\n*S KotlinDebug\n*F\n+ 1 DonationDialogFragment.kt\ncom/phisher98/donation/DonationDialogFragment\n*L\n37#1:471\n71#1:472\n73#1:473\n84#1:474\n86#1:475\n106#1:477\n182#1:478\n186#1:479\n201#1:480\n203#1:481\n225#1:482\n236#1:483\n247#1:484\n261#1:485\n294#1:486\n316#1:487\n342#1:488\n368#1:489\n378#1:490\n380#1:491\n409#1:492\n413#1:493\n415#1:494\n437#1:495\n321#1:497\n348#1:498\n386#1:499\n387#1:500\n388#1:501\n419#1:502\n463#1:496\n*E\n"})
public final class DonationDialogFragment extends DialogFragment {

    @NotNull
    private final DonationConfig config;

    @Nullable
    private final Function0<Unit> onDismissCallback;

    public DonationDialogFragment(@NotNull DonationConfig config, @Nullable Function0<Unit> function0) {
        this.config = config;
        this.onDismissCallback = function0;
    }

    public /* synthetic */ DonationDialogFragment(DonationConfig donationConfig, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(donationConfig, (i & 2) != 0 ? null : function0);
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(1);
        Window $this$onCreateDialog_u24lambda_u240 = dialog.getWindow();
        if ($this$onCreateDialog_u24lambda_u240 != null) {
            $this$onCreateDialog_u24lambda_u240.setBackgroundDrawable(new ColorDrawable(0));
            $this$onCreateDialog_u24lambda_u240.setDimAmount(0.65f);
        }
        return dialog;
    }

    public void onStart() {
        Window $this$onStart_u24lambda_u240;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && ($this$onStart_u24lambda_u240 = dialog.getWindow()) != null) {
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            int maxAllowedWidth = (int) (420.0f * metrics.density);
            int screenWidth = (int) (((double) metrics.widthPixels) * 0.9d);
            int finalWidth = Math.min(screenWidth, maxAllowedWidth);
            $this$onStart_u24lambda_u240.setLayout(finalWidth, -2);
            $this$onStart_u24lambda_u240.setGravity(17);
        }
    }

    @SuppressLint({"SetTextI18n"})
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String cur;
        String supportersText;
        final Context ctx = requireContext();
        final float density = ctx.getResources().getDisplayMetrics().density;
        LinearLayout root = new LinearLayout(ctx);
        root.setOrientation(1);
        root.setPadding(onCreateView$dp(density, 20), onCreateView$dp(density, 18), onCreateView$dp(density, 20), onCreateView$dp(density, 18));
        GradientDrawable $this$onCreateView_u24lambda_u240_u240 = new GradientDrawable();
        $this$onCreateView_u24lambda_u240_u240.setColor(Color.parseColor("#181B24"));
        $this$onCreateView_u24lambda_u240_u240.setCornerRadius(onCreateView$dp(density, 20));
        $this$onCreateView_u24lambda_u240_u240.setStroke(onCreateView$dp(density, 1), Color.parseColor("#242A3A"));
        root.setBackground($this$onCreateView_u24lambda_u240_u240);
        root.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        GradientDrawable $this$onCreateView_u24lambda_u241 = new GradientDrawable();
        $this$onCreateView_u24lambda_u241.setColor(Color.parseColor("#1E293B"));
        $this$onCreateView_u24lambda_u241.setCornerRadius(onCreateView$dp(density, 8));
        $this$onCreateView_u24lambda_u241.setStroke(onCreateView$dp(density, 1), Color.parseColor("#334155"));
        LinearLayout badgeContainer = new LinearLayout(ctx);
        badgeContainer.setOrientation(1);
        badgeContainer.setPadding(onCreateView$dp(density, 10), onCreateView$dp(density, 7), onCreateView$dp(density, 12), onCreateView$dp(density, 7));
        badgeContainer.setBackground($this$onCreateView_u24lambda_u241);
        badgeContainer.setClickable(true);
        badgeContainer.setFocusable(true);
        badgeContainer.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.openUrl(ctx, "https://github.com/phisher98");
            }
        });
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u242_u241 = new LinearLayout.LayoutParams(-2, -2);
        $this$onCreateView_u24lambda_u242_u241.bottomMargin = onCreateView$dp(density, 12);
        badgeContainer.setLayoutParams($this$onCreateView_u24lambda_u242_u241);
        TextView badgeTitle = new TextView(ctx);
        badgeTitle.setText("⚡ Phisher Repo  •  by phisher98 ↗");
        badgeTitle.setTextSize(11.5f);
        badgeTitle.setTypeface(Typeface.DEFAULT_BOLD);
        badgeTitle.setTextColor(Color.parseColor("#93C5FD"));
        badgeContainer.addView(badgeTitle);
        root.addView(badgeContainer);
        String displayTitle = this.config.isGoalAchieved() ? "🎉  Phisher Repo Goal Achieved!" : "⚠️  Help Keep Phisher Repo Alive";
        TextView $this$onCreateView_u24lambda_u244 = new TextView(ctx);
        $this$onCreateView_u24lambda_u244.setText(displayTitle);
        $this$onCreateView_u24lambda_u244.setTextSize(16.5f);
        $this$onCreateView_u24lambda_u244.setTextColor(-1);
        $this$onCreateView_u24lambda_u244.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u244_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u244_u240.bottomMargin = onCreateView$dp(density, 14);
        $this$onCreateView_u24lambda_u244.setLayoutParams($this$onCreateView_u24lambda_u244_u240);
        root.addView($this$onCreateView_u24lambda_u244);
        List bullets = this.config.isGoalAchieved() ? CollectionsKt.listOf(new Triple[]{new Triple("🎉", "100% Funded for " + this.config.getMonth() + ':', "Monthly repo & extension maintenance is fully funded!"), new Triple("🚀", "80+ Extensions on Track:", "Fast fixes, domain bypasses, and updates continue across all providers."), new Triple("💖", "Thank You, Community:", "Massive thanks to every supporter who stepped up this month!")}) : CollectionsKt.listOf(new Triple[]{new Triple("🟢", "100% Free Forever:", "No ads, no paywalls, no VIP crap across 80+ extensions."), new Triple("🔧", "Active Repo Maintenance:", "Maintaining 80+ providers against weekly site changes & domain blocks."), new Triple("⌛", "Goal Missed = Delayed Fixes:", "If monthly target isn't met, extension updates will slow down."), new Triple("💀", "Zero Support = Extensions Die:", "Without donations, scrapers break and links die over time.")});
        LinearLayout bulletsContainer = new LinearLayout(ctx);
        bulletsContainer.setOrientation(1);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u245_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u245_u240.bottomMargin = onCreateView$dp(density, 16);
        bulletsContainer.setLayoutParams($this$onCreateView_u24lambda_u245_u240);
        Iterator it = bullets.iterator();
        while (it.hasNext()) {
            Triple triple = (Triple) it.next();
            String icon = (String) triple.component1();
            String head = (String) triple.component2();
            String body = (String) triple.component3();
            LinearLayout $this$onCreateView_u24lambda_u246 = new LinearLayout(ctx);
            $this$onCreateView_u24lambda_u246.setOrientation(0);
            $this$onCreateView_u24lambda_u246.setGravity(48);
            Iterator it2 = it;
            LinearLayout.LayoutParams $this$onCreateView_u24lambda_u246_u240 = new LinearLayout.LayoutParams(-1, -2);
            $this$onCreateView_u24lambda_u246_u240.bottomMargin = onCreateView$dp(density, 8);
            $this$onCreateView_u24lambda_u246.setLayoutParams($this$onCreateView_u24lambda_u246_u240);
            TextView $this$onCreateView_u24lambda_u247 = new TextView(ctx);
            $this$onCreateView_u24lambda_u247.setText(icon);
            $this$onCreateView_u24lambda_u247.setTextSize(12.0f);
            LinearLayout.LayoutParams $this$onCreateView_u24lambda_u247_u240 = new LinearLayout.LayoutParams(-2, -2);
            TextView badgeTitle2 = badgeTitle;
            String displayTitle2 = displayTitle;
            $this$onCreateView_u24lambda_u247_u240.rightMargin = onCreateView$dp(density, 8);
            $this$onCreateView_u24lambda_u247_u240.topMargin = onCreateView$dp(density, 1);
            $this$onCreateView_u24lambda_u247.setLayoutParams($this$onCreateView_u24lambda_u247_u240);
            $this$onCreateView_u24lambda_u246.addView($this$onCreateView_u24lambda_u247);
            TextView $this$onCreateView_u24lambda_u248 = new TextView(ctx);
            $this$onCreateView_u24lambda_u248.setTextSize(12.5f);
            $this$onCreateView_u24lambda_u248.setLineSpacing(onCreateView$dp(density, 1), 1.15f);
            SpannableStringBuilder $this$onCreateView_u24lambda_u248_u240 = new SpannableStringBuilder();
            int start = $this$onCreateView_u24lambda_u248_u240.length();
            $this$onCreateView_u24lambda_u248_u240.append((CharSequence) head);
            $this$onCreateView_u24lambda_u248_u240.setSpan(new StyleSpan(1), start, $this$onCreateView_u24lambda_u248_u240.length(), 33);
            $this$onCreateView_u24lambda_u248_u240.setSpan(new ForegroundColorSpan(Color.parseColor("#F1F5F9")), start, $this$onCreateView_u24lambda_u248_u240.length(), 33);
            $this$onCreateView_u24lambda_u248_u240.append((CharSequence) " ");
            int descStart = $this$onCreateView_u24lambda_u248_u240.length();
            $this$onCreateView_u24lambda_u248_u240.append((CharSequence) body);
            $this$onCreateView_u24lambda_u248_u240.setSpan(new ForegroundColorSpan(Color.parseColor("#94A3B8")), descStart, $this$onCreateView_u24lambda_u248_u240.length(), 33);
            $this$onCreateView_u24lambda_u248.setText($this$onCreateView_u24lambda_u248_u240);
            $this$onCreateView_u24lambda_u248.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            $this$onCreateView_u24lambda_u246.addView($this$onCreateView_u24lambda_u248);
            bulletsContainer.addView($this$onCreateView_u24lambda_u246);
            it = it2;
            badgeTitle = badgeTitle2;
            displayTitle = displayTitle2;
            bullets = bullets;
        }
        root.addView(bulletsContainer);
        LinearLayout goalCard = new LinearLayout(ctx);
        goalCard.setOrientation(1);
        goalCard.setPadding(onCreateView$dp(density, 14), onCreateView$dp(density, 12), onCreateView$dp(density, 14), onCreateView$dp(density, 12));
        GradientDrawable $this$onCreateView_u24lambda_u249_u240 = new GradientDrawable();
        $this$onCreateView_u24lambda_u249_u240.setColor(Color.parseColor("#0F1118"));
        $this$onCreateView_u24lambda_u249_u240.setCornerRadius(onCreateView$dp(density, 12));
        $this$onCreateView_u24lambda_u249_u240.setStroke(onCreateView$dp(density, 1), Color.parseColor("#1F2433"));
        goalCard.setBackground($this$onCreateView_u24lambda_u249_u240);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u249_u241 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u249_u241.bottomMargin = onCreateView$dp(density, 18);
        goalCard.setLayoutParams($this$onCreateView_u24lambda_u249_u241);
        LinearLayout goalHeaderRow = new LinearLayout(ctx);
        goalHeaderRow.setOrientation(0);
        goalHeaderRow.setGravity(16);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2410_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u2410_u240.bottomMargin = onCreateView$dp(density, 8);
        goalHeaderRow.setLayoutParams($this$onCreateView_u24lambda_u2410_u240);
        TextView $this$onCreateView_u24lambda_u2411 = new TextView(ctx);
        $this$onCreateView_u24lambda_u2411.setText(this.config.isGoalAchieved() ? "🎉 Goal Completed!" : "Monthly Maintenance Goal");
        $this$onCreateView_u24lambda_u2411.setTextSize(12.5f);
        $this$onCreateView_u24lambda_u2411.setTextColor(this.config.isGoalAchieved() ? Color.parseColor("#86EFAC") : Color.parseColor("#94A3B8"));
        $this$onCreateView_u24lambda_u2411.setTypeface(Typeface.DEFAULT_BOLD);
        $this$onCreateView_u24lambda_u2411.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        goalHeaderRow.addView($this$onCreateView_u24lambda_u2411);
        boolean z = this.config.getCurrentAmount() % 1.0d == 0.0d;
        DonationConfig donationConfig = this.config;
        if (z) {
            cur = String.valueOf((int) donationConfig.getCurrentAmount());
        } else {
            cur = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(donationConfig.getCurrentAmount())}, 1));
            Intrinsics.checkNotNullExpressionValue(cur, "format(...)");
        }
        String tgt = String.valueOf((int) this.config.getTargetAmount());
        TextView $this$onCreateView_u24lambda_u2412 = new TextView(ctx);
        $this$onCreateView_u24lambda_u2412.setText(this.config.getCurrency() + cur + " / " + this.config.getCurrency() + tgt + " (" + this.config.getProgressPercentage() + "%)");
        $this$onCreateView_u24lambda_u2412.setTextSize(13.0f);
        $this$onCreateView_u24lambda_u2412.setTextColor(this.config.isGoalAchieved() ? Color.parseColor("#4ADE80") : Color.parseColor("#22C55E"));
        $this$onCreateView_u24lambda_u2412.setTypeface(Typeface.DEFAULT_BOLD);
        goalHeaderRow.addView($this$onCreateView_u24lambda_u2412);
        goalCard.addView(goalHeaderRow);
        LinearLayout progressTrack = new LinearLayout(ctx);
        progressTrack.setOrientation(0);
        progressTrack.setWeightSum(100.0f);
        GradientDrawable $this$onCreateView_u24lambda_u2413_u240 = new GradientDrawable();
        $this$onCreateView_u24lambda_u2413_u240.setColor(Color.parseColor("#1E2330"));
        $this$onCreateView_u24lambda_u2413_u240.setCornerRadius(onCreateView$dp(density, 4));
        progressTrack.setBackground($this$onCreateView_u24lambda_u2413_u240);
        progressTrack.setClipToOutline(true);
        progressTrack.setLayoutParams(new LinearLayout.LayoutParams(-1, onCreateView$dp(density, 8)));
        int pct = RangesKt.coerceIn(this.config.getProgressPercentage(), 0, 100);
        if (pct > 0) {
            View $this$onCreateView_u24lambda_u2414 = new View(ctx);
            GradientDrawable $this$onCreateView_u24lambda_u2414_u240 = new GradientDrawable();
            $this$onCreateView_u24lambda_u2414_u240.setColor(this.config.isGoalAchieved() ? Color.parseColor("#4ADE80") : Color.parseColor("#22C55E"));
            $this$onCreateView_u24lambda_u2414_u240.setCornerRadius(onCreateView$dp(density, 4));
            $this$onCreateView_u24lambda_u2414.setBackground($this$onCreateView_u24lambda_u2414_u240);
            $this$onCreateView_u24lambda_u2414.setLayoutParams(new LinearLayout.LayoutParams(0, -1, pct));
            progressTrack.addView($this$onCreateView_u24lambda_u2414);
        }
        if (pct < 100) {
            View emptyView = new View(ctx);
            emptyView.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 100 - pct));
            progressTrack.addView(emptyView);
        }
        goalCard.addView(progressTrack);
        if (this.config.isGoalAchieved()) {
            supportersText = "🙌 " + this.config.getSupportersCount() + " supporters made this happen!";
        } else if (this.config.getSupportersCount() > 0) {
            supportersText = "🙌 " + this.config.getSupportersCount() + " supporter" + (this.config.getSupportersCount() == 1 ? "" : "s") + " this month";
        } else {
            supportersText = "🙌 Be the first supporter this month!";
        }
        TextView $this$onCreateView_u24lambda_u2416 = new TextView(ctx);
        $this$onCreateView_u24lambda_u2416.setText(supportersText);
        $this$onCreateView_u24lambda_u2416.setTextSize(11.0f);
        $this$onCreateView_u24lambda_u2416.setTextColor(Color.parseColor("#64748B"));
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2416_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u2416_u240.topMargin = onCreateView$dp(density, 6);
        $this$onCreateView_u24lambda_u2416.setLayoutParams($this$onCreateView_u24lambda_u2416_u240);
        goalCard.addView($this$onCreateView_u24lambda_u2416);
        root.addView(goalCard);
        LinearLayout actionsRow = new LinearLayout(ctx);
        actionsRow.setOrientation(0);
        actionsRow.setGravity(8388629);
        actionsRow.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        final TextView $this$onCreateView_u24lambda_u2418 = new TextView(ctx);
        $this$onCreateView_u24lambda_u2418.setText(this.config.isGoalAchieved() ? "Awesome!" : "Maybe Later");
        $this$onCreateView_u24lambda_u2418.setTextSize(13.5f);
        $this$onCreateView_u24lambda_u2418.setTextColor(Color.parseColor("#94A3B8"));
        $this$onCreateView_u24lambda_u2418.setGravity(17);
        $this$onCreateView_u24lambda_u2418.setFocusable(true);
        $this$onCreateView_u24lambda_u2418.setPadding(onCreateView$dp(density, 14), onCreateView$dp(density, 10), onCreateView$dp(density, 14), onCreateView$dp(density, 10));
        $this$onCreateView_u24lambda_u2418.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z2) {
                DonationDialogFragment.onCreateView$lambda$18$0($this$onCreateView_u24lambda_u2418, view, z2);
            }
        });
        $this$onCreateView_u24lambda_u2418.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.dismissAllowingStateLoss();
            }
        });
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2418_u242 = new LinearLayout.LayoutParams(-2, -2);
        $this$onCreateView_u24lambda_u2418_u242.rightMargin = onCreateView$dp(density, 8);
        $this$onCreateView_u24lambda_u2418.setLayoutParams($this$onCreateView_u24lambda_u2418_u242);
        actionsRow.addView($this$onCreateView_u24lambda_u2418);
        if (!StringsKt.isBlank(this.config.getPrimaryDonateUrl())) {
            Button $this$onCreateView_u24lambda_u2419 = new Button(ctx);
            $this$onCreateView_u24lambda_u2419.setText(this.config.getPrimaryButtonText());
            $this$onCreateView_u24lambda_u2419.setTextSize(13.5f);
            $this$onCreateView_u24lambda_u2419.setTextColor(-1);
            $this$onCreateView_u24lambda_u2419.setAllCaps(false);
            $this$onCreateView_u24lambda_u2419.setTypeface(Typeface.DEFAULT_BOLD);
            $this$onCreateView_u24lambda_u2419.setFocusable(true);
            final GradientDrawable $this$onCreateView_u24lambda_u2419_u240 = new GradientDrawable();
            $this$onCreateView_u24lambda_u2419_u240.setColor(Color.parseColor("#5865F2"));
            $this$onCreateView_u24lambda_u2419_u240.setCornerRadius(onCreateView$dp(density, 12));
            $this$onCreateView_u24lambda_u2419.setBackground($this$onCreateView_u24lambda_u2419_u240);
            $this$onCreateView_u24lambda_u2419.setPadding(onCreateView$dp(density, 18), onCreateView$dp(density, 8), onCreateView$dp(density, 18), onCreateView$dp(density, 8));
            $this$onCreateView_u24lambda_u2419.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z2) {
                    DonationDialogFragment.onCreateView$lambda$19$1($this$onCreateView_u24lambda_u2419_u240, view, z2);
                }
            });
            $this$onCreateView_u24lambda_u2419.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonationDialogFragment.onCreateView$lambda$19$2(this.f$0, ctx, view);
                }
            });
            $this$onCreateView_u24lambda_u2419.setLayoutParams(new LinearLayout.LayoutParams(-2, onCreateView$dp(density, 42)));
            actionsRow.addView($this$onCreateView_u24lambda_u2419);
        }
        root.addView(actionsRow);
        if (!StringsKt.isBlank(this.config.getAdSupportUrl())) {
            final TextView $this$onCreateView_u24lambda_u2420 = new TextView(ctx);
            $this$onCreateView_u24lambda_u2420.setText(this.config.getAdSupportButtonText());
            $this$onCreateView_u24lambda_u2420.setTextSize(12.5f);
            $this$onCreateView_u24lambda_u2420.setTextColor(Color.parseColor("#93C5FD"));
            $this$onCreateView_u24lambda_u2420.setTypeface(Typeface.DEFAULT_BOLD);
            $this$onCreateView_u24lambda_u2420.setGravity(17);
            LinearLayout $this$onCreateView_u24lambda_u2421 = new LinearLayout(ctx);
            $this$onCreateView_u24lambda_u2421.setOrientation(0);
            $this$onCreateView_u24lambda_u2421.setGravity(17);
            $this$onCreateView_u24lambda_u2421.setPadding(onCreateView$dp(density, 12), onCreateView$dp(density, 10), onCreateView$dp(density, 12), onCreateView$dp(density, 10));
            final GradientDrawable $this$onCreateView_u24lambda_u2421_u240 = new GradientDrawable();
            $this$onCreateView_u24lambda_u2421_u240.setColor(Color.parseColor("#161B26"));
            $this$onCreateView_u24lambda_u2421_u240.setCornerRadius(onCreateView$dp(density, 10));
            $this$onCreateView_u24lambda_u2421_u240.setStroke(onCreateView$dp(density, 1), Color.parseColor("#2D3748"));
            $this$onCreateView_u24lambda_u2421.setBackground($this$onCreateView_u24lambda_u2421_u240);
            $this$onCreateView_u24lambda_u2421.setClickable(true);
            $this$onCreateView_u24lambda_u2421.setFocusable(true);
            $this$onCreateView_u24lambda_u2421.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z2) {
                    DonationDialogFragment.onCreateView$lambda$21$1($this$onCreateView_u24lambda_u2421_u240, $this$onCreateView_u24lambda_u2420, density, view, z2);
                }
            });
            $this$onCreateView_u24lambda_u2421.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonationDialogFragment.onCreateView$lambda$21$2(this.f$0, ctx, view);
                }
            });
            LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2421_u243 = new LinearLayout.LayoutParams(-1, -2);
            $this$onCreateView_u24lambda_u2421_u243.topMargin = onCreateView$dp(density, 12);
            $this$onCreateView_u24lambda_u2421.setLayoutParams($this$onCreateView_u24lambda_u2421_u243);
            $this$onCreateView_u24lambda_u2421.addView($this$onCreateView_u24lambda_u2420);
            root.addView($this$onCreateView_u24lambda_u2421);
        }
        if (!StringsKt.isBlank(this.config.getSecondaryDonateUrl())) {
            Button $this$onCreateView_u24lambda_u2422 = new Button(ctx);
            $this$onCreateView_u24lambda_u2422.setText(this.config.getSecondaryButtonText());
            $this$onCreateView_u24lambda_u2422.setTextSize(13.0f);
            $this$onCreateView_u24lambda_u2422.setTextColor(Color.parseColor("#E2E8F0"));
            $this$onCreateView_u24lambda_u2422.setAllCaps(false);
            $this$onCreateView_u24lambda_u2422.setFocusable(true);
            final GradientDrawable $this$onCreateView_u24lambda_u2422_u240 = new GradientDrawable();
            $this$onCreateView_u24lambda_u2422_u240.setColor(Color.parseColor("#212634"));
            $this$onCreateView_u24lambda_u2422_u240.setCornerRadius(onCreateView$dp(density, 10));
            $this$onCreateView_u24lambda_u2422_u240.setStroke(onCreateView$dp(density, 1), Color.parseColor("#323A4E"));
            $this$onCreateView_u24lambda_u2422.setBackground($this$onCreateView_u24lambda_u2422_u240);
            $this$onCreateView_u24lambda_u2422.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z2) {
                    DonationDialogFragment.onCreateView$lambda$22$1($this$onCreateView_u24lambda_u2422_u240, view, z2);
                }
            });
            $this$onCreateView_u24lambda_u2422.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonationDialogFragment.onCreateView$lambda$22$2(this.f$0, ctx, view);
                }
            });
            LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2422_u243 = new LinearLayout.LayoutParams(-1, onCreateView$dp(density, 40));
            $this$onCreateView_u24lambda_u2422_u243.topMargin = onCreateView$dp(density, 10);
            $this$onCreateView_u24lambda_u2422.setLayoutParams($this$onCreateView_u24lambda_u2422_u243);
            root.addView($this$onCreateView_u24lambda_u2422);
        }
        TextView $this$onCreateView_u24lambda_u2423 = new TextView(ctx);
        $this$onCreateView_u24lambda_u2423.setText("Not affiliated with the CloudStream app or team");
        $this$onCreateView_u24lambda_u2423.setTextSize(11.0f);
        $this$onCreateView_u24lambda_u2423.setTextColor(Color.parseColor("#64748B"));
        $this$onCreateView_u24lambda_u2423.setGravity(17);
        $this$onCreateView_u24lambda_u2423.setTypeface(null, 2);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2423_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u2423_u240.topMargin = onCreateView$dp(density, 14);
        $this$onCreateView_u24lambda_u2423.setLayoutParams($this$onCreateView_u24lambda_u2423_u240);
        root.addView($this$onCreateView_u24lambda_u2423);
        return root;
    }

    private static final int onCreateView$dp(float density, int v) {
        return (int) (v * density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$18$0(TextView $this_apply, View view, boolean hasFocus) {
        $this_apply.setTextColor(hasFocus ? -1 : Color.parseColor("#94A3B8"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$19$1(GradientDrawable $btnBg, View view, boolean hasFocus) {
        $btnBg.setColor(hasFocus ? Color.parseColor("#6D7AF8") : Color.parseColor("#5865F2"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$19$2(DonationDialogFragment this$0, Context $ctx, View it) {
        this$0.openUrl($ctx, this$0.config.getPrimaryDonateUrl());
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$21$1(GradientDrawable $adBg, TextView $adText, float $density, View view, boolean hasFocus) {
        $adBg.setColor(hasFocus ? Color.parseColor("#1E293B") : Color.parseColor("#161B26"));
        $adBg.setStroke(onCreateView$dp($density, 1), hasFocus ? Color.parseColor("#60A5FA") : Color.parseColor("#2D3748"));
        $adText.setTextColor(hasFocus ? -1 : Color.parseColor("#93C5FD"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$21$2(DonationDialogFragment this$0, Context $ctx, View it) {
        this$0.openUrl($ctx, this$0.config.getAdSupportUrl());
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$22$1(GradientDrawable $secBg, View view, boolean hasFocus) {
        $secBg.setColor(hasFocus ? Color.parseColor("#2B3245") : Color.parseColor("#212634"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$22$2(DonationDialogFragment this$0, Context $ctx, View it) {
        this$0.openUrl($ctx, this$0.config.getSecondaryDonateUrl());
        this$0.dismissAllowingStateLoss();
    }

    public void onDismiss(@NotNull DialogInterface dialog) {
        super.onDismiss(dialog);
        DonationManager.INSTANCE.setDialogShowing(false);
        Function0<Unit> function0 = this.onDismissCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        DonationManager.INSTANCE.setDialogShowing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openUrl(Context context, String url) {
        try {
            Result.Companion companion = Result.Companion;
            DonationDialogFragment donationDialogFragment = this;
            Uri uri = Uri.parse(url);
            Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.parse(this)");
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.setFlags(268435456);
            context.startActivity(intent);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }
}
