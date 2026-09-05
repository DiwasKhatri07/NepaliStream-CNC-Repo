package com.horis.cncverse;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lagradost.cloudstream3.ui.settings.Globals;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CNC_Verse/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/horis/cncverse/SubscriptionHelper;", "", "<init>", "()V", "PREFS_NAME", "", "KEY_MODE", "KEY_DONT_SHOW", "SUB_URL", "popupShown", "", "getPopupShown", "()Z", "setPopupShown", "(Z)V", "isSubscribed", "ctx", "Landroid/content/Context;", "showPopupIfNeeded", "", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/horis/cncverse/SubscriptionHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,773:1\n1#2:774\n*E\n"})
public final class SubscriptionHelper {

    @NotNull
    public static final SubscriptionHelper INSTANCE = new SubscriptionHelper();

    @NotNull
    private static final String KEY_DONT_SHOW = "dont_show_ads_popup";

    @NotNull
    private static final String KEY_MODE = "mode";

    @NotNull
    private static final String PREFS_NAME = "CNCVerseSubscription";

    @NotNull
    private static final String SUB_URL = "https://cncverse-sub.pages.dev";
    private static volatile boolean popupShown;

    private SubscriptionHelper() {
    }

    public final boolean getPopupShown() {
        return popupShown;
    }

    public final void setPopupShown(boolean z) {
        popupShown = z;
    }

    public final boolean isSubscribed(@Nullable Context ctx) {
        SharedPreferences sharedPreferences;
        return Intrinsics.areEqual((ctx == null || (sharedPreferences = ctx.getSharedPreferences(PREFS_NAME, 0)) == null) ? null : sharedPreferences.getString(KEY_MODE, "ads"), "subscription");
    }

    public final void showPopupIfNeeded(@Nullable final Context ctx) {
        if (ctx == null || popupShown || isSubscribed(ctx)) {
            return;
        }
        SharedPreferences prefs = ctx.getSharedPreferences(PREFS_NAME, 0);
        if (prefs.getBoolean(KEY_DONT_SHOW, false)) {
            popupShown = true;
            return;
        }
        try {
            boolean isTV = Globals.INSTANCE.isLayout(2);
            if (isTV) {
                return;
            }
        } catch (Exception e) {
        }
        popupShown = true;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.horis.cncverse.SubscriptionHelper$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SubscriptionHelper.showPopupIfNeeded$lambda$0(ctx);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopupIfNeeded$lambda$0(final Context $ctx) {
        try {
            float dp = $ctx.getResources().getDisplayMetrics().density;
            GradientDrawable $this$showPopupIfNeeded_u24lambda_u240_u240 = new GradientDrawable();
            $this$showPopupIfNeeded_u24lambda_u240_u240.setColor(Color.parseColor("#1A1A2E"));
            $this$showPopupIfNeeded_u24lambda_u240_u240.setCornerRadius(16.0f * dp);
            LinearLayout root = new LinearLayout($ctx);
            root.setOrientation(1);
            float f = 24;
            root.setPadding((int) (f * dp), (int) (20 * dp), (int) (f * dp), (int) (16 * dp));
            root.setBackground($this$showPopupIfNeeded_u24lambda_u240_u240);
            TextView $this$showPopupIfNeeded_u24lambda_u240_u242 = new TextView($ctx);
            $this$showPopupIfNeeded_u24lambda_u240_u242.setText("📺 You're in Ads Mode");
            $this$showPopupIfNeeded_u24lambda_u240_u242.setTextColor(-1);
            $this$showPopupIfNeeded_u24lambda_u240_u242.setTextSize(17.0f);
            $this$showPopupIfNeeded_u24lambda_u240_u242.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-1, -2);
            it.bottomMargin = (int) (8 * dp);
            $this$showPopupIfNeeded_u24lambda_u240_u242.setLayoutParams(it);
            View divider = new View($ctx);
            divider.setBackgroundColor(Color.parseColor("#2D2D4A"));
            LinearLayout.LayoutParams it2 = new LinearLayout.LayoutParams(-1, 1);
            it2.bottomMargin = (int) (12 * dp);
            divider.setLayoutParams(it2);
            TextView $this$showPopupIfNeeded_u24lambda_u240_u244 = new TextView($ctx);
            $this$showPopupIfNeeded_u24lambda_u240_u244.setText("All CNCVerse extensions currently run with ads.\n\nSubscribe to remove ads across all extensions from just ₹20/month.\n\nYou can manage your subscription from Settings > Extensions > CNCVerse Cloudstream Repo > Subscription Manager extension.");
            $this$showPopupIfNeeded_u24lambda_u240_u244.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showPopupIfNeeded_u24lambda_u240_u244.setTextSize(14.0f);
            $this$showPopupIfNeeded_u24lambda_u240_u244.setLineSpacing(0.0f, 1.4f);
            LinearLayout.LayoutParams it3 = new LinearLayout.LayoutParams(-1, -2);
            it3.bottomMargin = (int) (18 * dp);
            $this$showPopupIfNeeded_u24lambda_u240_u244.setLayoutParams(it3);
            LinearLayout dontShowRow = new LinearLayout($ctx);
            dontShowRow.setOrientation(0);
            dontShowRow.setGravity(8388627);
            LinearLayout.LayoutParams it4 = new LinearLayout.LayoutParams(-1, -2);
            float f2 = 10;
            it4.bottomMargin = (int) (f2 * dp);
            dontShowRow.setLayoutParams(it4);
            final CheckBox $this$showPopupIfNeeded_u24lambda_u240_u246 = new CheckBox($ctx);
            $this$showPopupIfNeeded_u24lambda_u240_u246.setChecked(false);
            $this$showPopupIfNeeded_u24lambda_u240_u246.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#A78BFA")));
            TextView $this$showPopupIfNeeded_u24lambda_u240_u247 = new TextView($ctx);
            $this$showPopupIfNeeded_u24lambda_u240_u247.setText("Don't show me again");
            $this$showPopupIfNeeded_u24lambda_u240_u247.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showPopupIfNeeded_u24lambda_u240_u247.setTextSize(13.0f);
            $this$showPopupIfNeeded_u24lambda_u240_u247.setPadding((int) (6 * dp), 0, 0, 0);
            dontShowRow.addView($this$showPopupIfNeeded_u24lambda_u240_u246);
            dontShowRow.addView($this$showPopupIfNeeded_u24lambda_u240_u247);
            LinearLayout btnRow = new LinearLayout($ctx);
            btnRow.setOrientation(0);
            btnRow.setGravity(8388613);
            TextView laterTv = new TextView($ctx);
            laterTv.setText("Maybe Later");
            laterTv.setTextColor(Color.parseColor("#808090"));
            laterTv.setTextSize(14.0f);
            int p = (int) (f2 * dp);
            laterTv.setPadding(p, p, p, p);
            laterTv.setClickable(true);
            laterTv.setFocusable(true);
            TextView subscribeTv = new TextView($ctx);
            subscribeTv.setText("Subscribe Now");
            subscribeTv.setTextColor(Color.parseColor("#A78BFA"));
            subscribeTv.setTextSize(14.0f);
            subscribeTv.setTypeface(Typeface.DEFAULT_BOLD);
            int p2 = (int) (f2 * dp);
            subscribeTv.setPadding(p2, p2, 0, p2);
            subscribeTv.setClickable(true);
            subscribeTv.setFocusable(true);
            btnRow.addView(laterTv);
            btnRow.addView(subscribeTv);
            root.addView($this$showPopupIfNeeded_u24lambda_u240_u242);
            root.addView(divider);
            root.addView($this$showPopupIfNeeded_u24lambda_u240_u244);
            root.addView(dontShowRow);
            root.addView(btnRow);
            final AlertDialog dialog = new AlertDialog.Builder($ctx).setView(root).setCancelable(true).create();
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.horis.cncverse.SubscriptionHelper$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubscriptionHelper.showPopupIfNeeded$lambda$0$11($this$showPopupIfNeeded_u24lambda_u240_u246, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.horis.cncverse.SubscriptionHelper$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubscriptionHelper.showPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
                }
            });
            dialog.show();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopupIfNeeded$lambda$0$11(CheckBox $dontShowCb, Context $ctx, AlertDialog $dialog, View it) {
        if ($dontShowCb.isChecked()) {
            $ctx.getSharedPreferences(PREFS_NAME, 0).edit().putBoolean(KEY_DONT_SHOW, true).apply();
        }
        $dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopupIfNeeded$lambda$0$12(AlertDialog $dialog, Context $ctx, View it) {
        $dialog.dismiss();
        try {
            Intent i = new Intent("android.intent.action.VIEW", Uri.parse(SUB_URL));
            i.addFlags(268435456);
            $ctx.startActivity(i);
        } catch (Exception e) {
        }
    }
}
