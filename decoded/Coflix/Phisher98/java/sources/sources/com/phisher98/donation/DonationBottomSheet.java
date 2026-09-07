package com.phisher98.donation;

import android.R;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DonationBottomSheet.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Coflix/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0017b\u0010\b\u0013\u0012\f\b\u0014\u0012\b\b\fJ\u0004\b\b(\u0015J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/phisher98/donation/DonationBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "config", "Lcom/phisher98/donation/DonationConfig;", "onDismissCallback", "Lkotlin/Function0;", "", "<init>", "(Lcom/phisher98/donation/DonationConfig;Lkotlin/jvm/functions/Function0;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Landroid/annotation/SuppressLint;", "value", "SetTextI18n", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "openUrl", "context", "Landroid/content/Context;", "url", "", "Coflix"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDonationBottomSheet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationBottomSheet.kt\ncom/phisher98/donation/DonationBottomSheet\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,322:1\n432#2:323\n432#2:324\n432#2:326\n432#2:327\n432#2:328\n432#2:329\n432#2:330\n432#2:331\n432#2:332\n432#2:333\n432#2:334\n432#2:335\n432#2:336\n432#2:337\n432#2:338\n432#2:339\n432#2:340\n432#2:341\n432#2:342\n432#2:343\n432#2:344\n1#3:325\n*S KotlinDebug\n*F\n+ 1 DonationBottomSheet.kt\ncom/phisher98/donation/DonationBottomSheet\n*L\n55#1:323\n72#1:324\n100#1:326\n114#1:327\n116#1:328\n137#1:329\n141#1:330\n155#1:331\n166#1:332\n171#1:333\n201#1:334\n215#1:335\n234#1:336\n260#1:337\n264#1:338\n266#1:339\n288#1:340\n239#1:341\n240#1:342\n270#1:343\n293#1:344\n*E\n"})
public final class DonationBottomSheet extends BottomSheetDialogFragment {

    @NotNull
    private final DonationConfig config;

    @Nullable
    private final Function0<Unit> onDismissCallback;

    public DonationBottomSheet(@NotNull DonationConfig config, @Nullable Function0<Unit> function0) {
        this.config = config;
        this.onDismissCallback = function0;
    }

    public /* synthetic */ DonationBottomSheet(DonationConfig donationConfig, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(donationConfig, (i & 2) != 0 ? null : function0);
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetBehavior $this$onCreateDialog_u24lambda_u240;
        BottomSheetDialog bottomSheetDialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        BottomSheetDialog bottomSheetDialog = bottomSheetDialogOnCreateDialog instanceof BottomSheetDialog ? bottomSheetDialogOnCreateDialog : null;
        if (bottomSheetDialog != null && ($this$onCreateDialog_u24lambda_u240 = bottomSheetDialog.getBehavior()) != null) {
            $this$onCreateDialog_u24lambda_u240.setState(3);
            $this$onCreateDialog_u24lambda_u240.setSkipCollapsed(true);
        }
        return bottomSheetDialogOnCreateDialog;
    }

    @SuppressLint({"SetTextI18n"})
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Context ctx = requireContext();
        final float density = ctx.getResources().getDisplayMetrics().density;
        LinearLayout root = new LinearLayout(ctx);
        root.setOrientation(1);
        root.setPadding(onCreateView$dp(density, 20), onCreateView$dp(density, 12), onCreateView$dp(density, 20), onCreateView$dp(density, 24));
        GradientDrawable $this$onCreateView_u24lambda_u240_u240 = new GradientDrawable();
        $this$onCreateView_u24lambda_u240_u240.setColor(Color.parseColor("#161922"));
        $this$onCreateView_u24lambda_u240_u240.setCornerRadii(new float[]{onCreateView$dp(density, 20), onCreateView$dp(density, 20), onCreateView$dp(density, 20), onCreateView$dp(density, 20), 0.0f, 0.0f, 0.0f, 0.0f});
        root.setBackground($this$onCreateView_u24lambda_u240_u240);
        root.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View handle = new View(ctx);
        GradientDrawable $this$onCreateView_u24lambda_u241_u240 = new GradientDrawable();
        $this$onCreateView_u24lambda_u241_u240.setColor(Color.parseColor("#374151"));
        $this$onCreateView_u24lambda_u241_u240.setCornerRadius(onCreateView$dp(density, 3));
        handle.setBackground($this$onCreateView_u24lambda_u241_u240);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u241_u241 = new LinearLayout.LayoutParams(onCreateView$dp(density, 40), onCreateView$dp(density, 4));
        $this$onCreateView_u24lambda_u241_u241.gravity = 1;
        $this$onCreateView_u24lambda_u241_u241.bottomMargin = onCreateView$dp(density, 16);
        handle.setLayoutParams($this$onCreateView_u24lambda_u241_u241);
        root.addView(handle);
        TextView $this$onCreateView_u24lambda_u242 = new TextView(ctx);
        $this$onCreateView_u24lambda_u242.setText("💖  " + this.config.getTitle());
        $this$onCreateView_u24lambda_u242.setTextSize(18.0f);
        $this$onCreateView_u24lambda_u242.setTextColor(-1);
        $this$onCreateView_u24lambda_u242.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u242_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u242_u240.bottomMargin = onCreateView$dp(density, 6);
        $this$onCreateView_u24lambda_u242.setLayoutParams($this$onCreateView_u24lambda_u242_u240);
        root.addView($this$onCreateView_u24lambda_u242);
        TextView $this$onCreateView_u24lambda_u243 = new TextView(ctx);
        $this$onCreateView_u24lambda_u243.setText(this.config.getDescription());
        $this$onCreateView_u24lambda_u243.setTextSize(13.5f);
        $this$onCreateView_u24lambda_u243.setTextColor(Color.parseColor("#94A3B8"));
        $this$onCreateView_u24lambda_u243.setLineSpacing(onCreateView$dp(density, 3), 1.1f);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u243_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u243_u240.bottomMargin = onCreateView$dp(density, 18);
        $this$onCreateView_u24lambda_u243.setLayoutParams($this$onCreateView_u24lambda_u243_u240);
        root.addView($this$onCreateView_u24lambda_u243);
        LinearLayout goalCard = new LinearLayout(ctx);
        goalCard.setOrientation(1);
        goalCard.setPadding(onCreateView$dp(density, 16), onCreateView$dp(density, 14), onCreateView$dp(density, 16), onCreateView$dp(density, 14));
        GradientDrawable $this$onCreateView_u24lambda_u244_u240 = new GradientDrawable();
        $this$onCreateView_u24lambda_u244_u240.setColor(Color.parseColor("#1F2432"));
        $this$onCreateView_u24lambda_u244_u240.setCornerRadius(onCreateView$dp(density, 12));
        $this$onCreateView_u24lambda_u244_u240.setStroke(onCreateView$dp(density, 1), Color.parseColor("#2D3446"));
        goalCard.setBackground($this$onCreateView_u24lambda_u244_u240);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u244_u241 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u244_u241.bottomMargin = onCreateView$dp(density, 20);
        goalCard.setLayoutParams($this$onCreateView_u24lambda_u244_u241);
        LinearLayout badgeRow = new LinearLayout(ctx);
        badgeRow.setOrientation(0);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u245_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u245_u240.bottomMargin = onCreateView$dp(density, 10);
        badgeRow.setLayoutParams($this$onCreateView_u24lambda_u245_u240);
        TextView $this$onCreateView_u24lambda_u246 = new TextView(ctx);
        $this$onCreateView_u24lambda_u246.setText(this.config.getMonth());
        $this$onCreateView_u24lambda_u246.setTextSize(11.5f);
        $this$onCreateView_u24lambda_u246.setTextColor(Color.parseColor("#C7D2FE"));
        $this$onCreateView_u24lambda_u246.setTypeface(Typeface.DEFAULT_BOLD);
        $this$onCreateView_u24lambda_u246.setPadding(onCreateView$dp(density, 8), onCreateView$dp(density, 4), onCreateView$dp(density, 8), onCreateView$dp(density, 4));
        GradientDrawable $this$onCreateView_u24lambda_u246_u240 = new GradientDrawable();
        $this$onCreateView_u24lambda_u246_u240.setColor(Color.parseColor("#2E3852"));
        $this$onCreateView_u24lambda_u246_u240.setCornerRadius(onCreateView$dp(density, 6));
        $this$onCreateView_u24lambda_u246.setBackground($this$onCreateView_u24lambda_u246_u240);
        badgeRow.addView($this$onCreateView_u24lambda_u246);
        View spacer = new View(ctx);
        spacer.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0f));
        badgeRow.addView(spacer);
        TextView $this$onCreateView_u24lambda_u248 = new TextView(ctx);
        $this$onCreateView_u24lambda_u248.setText(new StringBuilder().append(this.config.getProgressPercentage()).append('%').toString());
        $this$onCreateView_u24lambda_u248.setTextSize(15.0f);
        $this$onCreateView_u24lambda_u248.setTextColor(Color.parseColor("#00E5FF"));
        $this$onCreateView_u24lambda_u248.setTypeface(Typeface.DEFAULT_BOLD);
        badgeRow.addView($this$onCreateView_u24lambda_u248);
        goalCard.addView(badgeRow);
        ProgressBar $this$onCreateView_u24lambda_u249 = new ProgressBar(ctx, null, R.attr.progressBarStyleHorizontal);
        $this$onCreateView_u24lambda_u249.setMax(100);
        $this$onCreateView_u24lambda_u249.setProgress(this.config.getProgressPercentage());
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(Color.parseColor("#2A3142"));
        bg.setCornerRadius(onCreateView$dp(density, 6));
        GradientDrawable $this$onCreateView_u24lambda_u249_u241 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#7C4DFF"), Color.parseColor("#00E5FF")});
        $this$onCreateView_u24lambda_u249_u241.setCornerRadius(onCreateView$dp(density, 6));
        ClipDrawable clipFill = new ClipDrawable($this$onCreateView_u24lambda_u249_u241, 8388611, 1);
        LayerDrawable $this$onCreateView_u24lambda_u249_u242 = new LayerDrawable(new Drawable[]{bg, clipFill});
        $this$onCreateView_u24lambda_u249_u242.setId(0, R.id.background);
        $this$onCreateView_u24lambda_u249_u242.setId(1, R.id.progress);
        $this$onCreateView_u24lambda_u249.setProgressDrawable($this$onCreateView_u24lambda_u249_u242);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u249_u243 = new LinearLayout.LayoutParams(-1, onCreateView$dp(density, 12));
        $this$onCreateView_u24lambda_u249_u243.bottomMargin = onCreateView$dp(density, 10);
        $this$onCreateView_u24lambda_u249.setLayoutParams($this$onCreateView_u24lambda_u249_u243);
        goalCard.addView($this$onCreateView_u24lambda_u249);
        LinearLayout amountRow = new LinearLayout(ctx);
        amountRow.setOrientation(0);
        amountRow.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TextView $this$onCreateView_u24lambda_u2411 = new TextView(ctx);
        boolean z = this.config.getCurrentAmount() % 1.0d == 0.0d;
        DonationConfig donationConfig = this.config;
        String cur = z ? String.valueOf((int) donationConfig.getCurrentAmount()) : String.valueOf(donationConfig.getCurrentAmount());
        boolean z2 = this.config.getTargetAmount() % 1.0d == 0.0d;
        DonationConfig donationConfig2 = this.config;
        String tgt = z2 ? String.valueOf((int) donationConfig2.getTargetAmount()) : String.valueOf(donationConfig2.getTargetAmount());
        $this$onCreateView_u24lambda_u2411.setText(this.config.getCurrency() + cur + " of " + this.config.getCurrency() + tgt + " reached");
        $this$onCreateView_u24lambda_u2411.setTextSize(12.5f);
        $this$onCreateView_u24lambda_u2411.setTextColor(Color.parseColor("#E2E8F0"));
        $this$onCreateView_u24lambda_u2411.setTypeface(Typeface.DEFAULT_BOLD);
        amountRow.addView($this$onCreateView_u24lambda_u2411);
        View spacer2 = new View(ctx);
        spacer2.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0f));
        amountRow.addView(spacer2);
        if (this.config.getSupportersCount() > 0) {
            TextView $this$onCreateView_u24lambda_u2413 = new TextView(ctx);
            $this$onCreateView_u24lambda_u2413.setText("🙌 " + this.config.getSupportersCount() + " supporters");
            $this$onCreateView_u24lambda_u2413.setTextSize(12.0f);
            $this$onCreateView_u24lambda_u2413.setTextColor(Color.parseColor("#94A3B8"));
            amountRow.addView($this$onCreateView_u24lambda_u2413);
        }
        goalCard.addView(amountRow);
        root.addView(goalCard);
        if (!StringsKt.isBlank(this.config.getPrimaryDonateUrl())) {
            final Button $this$onCreateView_u24lambda_u2414 = new Button(ctx);
            $this$onCreateView_u24lambda_u2414.setText(this.config.getPrimaryButtonText());
            $this$onCreateView_u24lambda_u2414.setTextSize(14.5f);
            $this$onCreateView_u24lambda_u2414.setTextColor(-1);
            $this$onCreateView_u24lambda_u2414.setAllCaps(false);
            $this$onCreateView_u24lambda_u2414.setTypeface(Typeface.DEFAULT_BOLD);
            $this$onCreateView_u24lambda_u2414.setFocusable(true);
            final GradientDrawable $this$onCreateView_u24lambda_u2414_u240 = new GradientDrawable();
            $this$onCreateView_u24lambda_u2414_u240.setColor(Color.parseColor("#7C4DFF"));
            $this$onCreateView_u24lambda_u2414_u240.setCornerRadius(onCreateView$dp(density, 10));
            $this$onCreateView_u24lambda_u2414.setBackground($this$onCreateView_u24lambda_u2414_u240);
            $this$onCreateView_u24lambda_u2414.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.phisher98.donation.DonationBottomSheet$$ExternalSyntheticLambda0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z3) {
                    DonationBottomSheet.onCreateView$lambda$14$1($this$onCreateView_u24lambda_u2414_u240, $this$onCreateView_u24lambda_u2414, density, view, z3);
                }
            });
            $this$onCreateView_u24lambda_u2414.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.donation.DonationBottomSheet$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonationBottomSheet.onCreateView$lambda$14$2(this.f$0, ctx, view);
                }
            });
            LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2414_u243 = new LinearLayout.LayoutParams(-1, onCreateView$dp(density, 48));
            $this$onCreateView_u24lambda_u2414_u243.bottomMargin = onCreateView$dp(density, 10);
            $this$onCreateView_u24lambda_u2414.setLayoutParams($this$onCreateView_u24lambda_u2414_u243);
            root.addView($this$onCreateView_u24lambda_u2414);
        }
        if (!StringsKt.isBlank(this.config.getSecondaryDonateUrl())) {
            Button $this$onCreateView_u24lambda_u2415 = new Button(ctx);
            $this$onCreateView_u24lambda_u2415.setText(this.config.getSecondaryButtonText());
            $this$onCreateView_u24lambda_u2415.setTextSize(14.0f);
            $this$onCreateView_u24lambda_u2415.setTextColor(Color.parseColor("#E2E8F0"));
            $this$onCreateView_u24lambda_u2415.setAllCaps(false);
            $this$onCreateView_u24lambda_u2415.setFocusable(true);
            final GradientDrawable $this$onCreateView_u24lambda_u2415_u240 = new GradientDrawable();
            $this$onCreateView_u24lambda_u2415_u240.setColor(Color.parseColor("#232938"));
            $this$onCreateView_u24lambda_u2415_u240.setCornerRadius(onCreateView$dp(density, 10));
            $this$onCreateView_u24lambda_u2415_u240.setStroke(onCreateView$dp(density, 1), Color.parseColor("#384156"));
            $this$onCreateView_u24lambda_u2415.setBackground($this$onCreateView_u24lambda_u2415_u240);
            $this$onCreateView_u24lambda_u2415.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.phisher98.donation.DonationBottomSheet$$ExternalSyntheticLambda2
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z3) {
                    DonationBottomSheet.onCreateView$lambda$15$1($this$onCreateView_u24lambda_u2415_u240, view, z3);
                }
            });
            $this$onCreateView_u24lambda_u2415.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.donation.DonationBottomSheet$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonationBottomSheet.onCreateView$lambda$15$2(this.f$0, ctx, view);
                }
            });
            LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2415_u243 = new LinearLayout.LayoutParams(-1, onCreateView$dp(density, 46));
            $this$onCreateView_u24lambda_u2415_u243.bottomMargin = onCreateView$dp(density, 8);
            $this$onCreateView_u24lambda_u2415.setLayoutParams($this$onCreateView_u24lambda_u2415_u243);
            root.addView($this$onCreateView_u24lambda_u2415);
        }
        final TextView $this$onCreateView_u24lambda_u2416 = new TextView(ctx);
        $this$onCreateView_u24lambda_u2416.setText("Maybe Later");
        $this$onCreateView_u24lambda_u2416.setTextSize(13.0f);
        $this$onCreateView_u24lambda_u2416.setTextColor(Color.parseColor("#64748B"));
        $this$onCreateView_u24lambda_u2416.setGravity(17);
        $this$onCreateView_u24lambda_u2416.setFocusable(true);
        $this$onCreateView_u24lambda_u2416.setPadding(onCreateView$dp(density, 12), onCreateView$dp(density, 10), onCreateView$dp(density, 12), onCreateView$dp(density, 10));
        $this$onCreateView_u24lambda_u2416.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.phisher98.donation.DonationBottomSheet$$ExternalSyntheticLambda4
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z3) {
                DonationBottomSheet.onCreateView$lambda$16$0($this$onCreateView_u24lambda_u2416, view, z3);
            }
        });
        $this$onCreateView_u24lambda_u2416.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.donation.DonationBottomSheet$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.dismissAllowingStateLoss();
            }
        });
        $this$onCreateView_u24lambda_u2416.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        root.addView($this$onCreateView_u24lambda_u2416);
        return root;
    }

    private static final int onCreateView$dp(float density, int v) {
        return (int) (v * density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$14$1(GradientDrawable $btnBg, Button $this_apply, float $density, View view, boolean hasFocus) {
        $btnBg.setColor(hasFocus ? Color.parseColor("#9366FF") : Color.parseColor("#7C4DFF"));
        if (hasFocus) {
            $this_apply.setShadowLayer(onCreateView$dp($density, 8), 0.0f, 0.0f, Color.parseColor("#7C4DFF"));
        } else {
            $this_apply.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$14$2(DonationBottomSheet this$0, Context $ctx, View it) {
        this$0.openUrl($ctx, this$0.config.getPrimaryDonateUrl());
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$15$1(GradientDrawable $secBg, View view, boolean hasFocus) {
        $secBg.setColor(hasFocus ? Color.parseColor("#30384D") : Color.parseColor("#232938"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$15$2(DonationBottomSheet this$0, Context $ctx, View it) {
        this$0.openUrl($ctx, this$0.config.getSecondaryDonateUrl());
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$16$0(TextView $this_apply, View view, boolean hasFocus) {
        $this_apply.setTextColor(hasFocus ? -1 : Color.parseColor("#64748B"));
    }

    public void onDismiss(@NotNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDismissCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void openUrl(Context context, String url) {
        try {
            Result.Companion companion = Result.Companion;
            DonationBottomSheet donationBottomSheet = this;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            intent.setFlags(268435456);
            context.startActivity(intent);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }
}
