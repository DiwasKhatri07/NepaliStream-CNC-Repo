package com.phisher98;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: ConcurrencyBottomSheet.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\f\u0010\r\u001a\u00020\b*\u00020\u000eH\u0002J#\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u000e*\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015J&\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J,\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0017b\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\b(\"J\b\u0010#\u001a\u00020\bH\u0002J\u0010\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/phisher98/ConcurrencyBottomSheet;", "Landroidx/fragment/app/DialogFragment;", "plugin", "Lcom/phisher98/StreamPlayPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "onDismissCallback", "Lkotlin/Function0;", "", "<init>", "(Lcom/phisher98/StreamPlayPlugin;Landroid/content/SharedPreferences;Lkotlin/jvm/functions/Function0;)V", "res", "Landroid/content/res/Resources;", "makeTvCompatible", "Landroid/view/View;", "currentValue", "", "findView", "T", "name", "", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "Landroid/annotation/SuppressLint;", "value", "SetTextI18n", "saveValue", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConcurrencyBottomSheet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrencyBottomSheet.kt\ncom/phisher98/ConcurrencyBottomSheet\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,132:1\n40#2,11:133\n*S KotlinDebug\n*F\n+ 1 ConcurrencyBottomSheet.kt\ncom/phisher98/ConcurrencyBottomSheet\n*L\n123#1:133,11\n*E\n"})
public final class ConcurrencyBottomSheet extends DialogFragment {
    private int currentValue;

    @Nullable
    private final Function0<Unit> onDismissCallback;

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public ConcurrencyBottomSheet(@NotNull StreamPlayPlugin plugin, @NotNull SharedPreferences sharedPref, @Nullable Function0<Unit> function0) throws Exception {
        this.sharedPref = sharedPref;
        this.onDismissCallback = function0;
        Resources resources = plugin.getResources();
        if (resources == null) {
            throw new Exception("Unable to access plugin resources");
        }
        this.res = resources;
        this.currentValue = RangesKt.coerceIn(this.sharedPref.getInt("provider_concurrency", 20), 8, 50);
    }

    public /* synthetic */ ConcurrencyBottomSheet(StreamPlayPlugin streamPlayPlugin, SharedPreferences sharedPreferences, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(streamPlayPlugin, sharedPreferences, (i & 4) != 0 ? null : function0);
    }

    private final void makeTvCompatible(View $this$makeTvCompatible) {
        int outlineId = this.res.getIdentifier("outline", "drawable", "com.phisher98");
        $this$makeTvCompatible.setBackground(this.res.getDrawable(outlineId, null));
    }

    private final <T extends View> T findView(View view, String str) throws Exception {
        int identifier = this.res.getIdentifier(str, "id", "com.phisher98");
        if (identifier == 0) {
            throw new Exception("View ID " + str + " not found.");
        }
        return (T) view.findViewById(identifier);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = this.res.getIdentifier("concurrency_bottom_sheet", "layout", "com.phisher98");
        XmlResourceParser layout = this.res.getLayout(layoutId);
        View view = inflater.inflate((XmlPullParser) layout, container, false);
        int drawableId = this.res.getIdentifier("dialog_background", "drawable", "com.phisher98");
        if (drawableId != 0) {
            view.setBackground(this.res.getDrawable(drawableId, null));
        }
        return view;
    }

    public void onStart() {
        Window $this$onStart_u24lambda_u240;
        int width;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && ($this$onStart_u24lambda_u240 = dialog.getWindow()) != null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int maxDialogWidth = (int) (500.0f * displayMetrics.density);
            if (displayMetrics.widthPixels > 0 && displayMetrics.widthPixels > maxDialogWidth) {
                width = maxDialogWidth;
            } else {
                width = (int) (displayMetrics.widthPixels * 0.9f);
            }
            $this$onStart_u24lambda_u240.setLayout(width, -2);
            $this$onStart_u24lambda_u240.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView tvValue = (TextView) findView(view, "tv_value");
        final Button btnDecrease = (Button) findView(view, "btn_decrease");
        final Button btnIncrease = (Button) findView(view, "btn_increase");
        Button btnClose = (Button) findView(view, "btn_close");
        btnDecrease.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D32F2F")));
        btnDecrease.setTextColor(-1);
        makeTvCompatible(btnDecrease);
        btnIncrease.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E88E5")));
        btnIncrease.setTextColor(-1);
        makeTvCompatible(btnIncrease);
        btnClose.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
        btnClose.setTextColor(-1);
        makeTvCompatible(btnClose);
        btnDecrease.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.ConcurrencyBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConcurrencyBottomSheet.onViewCreated$lambda$0(this.f$0, tvValue, btnDecrease, btnIncrease, view2);
            }
        });
        btnIncrease.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.ConcurrencyBottomSheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConcurrencyBottomSheet.onViewCreated$lambda$1(this.f$0, tvValue, btnDecrease, btnIncrease, view2);
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.ConcurrencyBottomSheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.dismiss();
            }
        });
        onViewCreated$updateUI(tvValue, this, btnDecrease, btnIncrease);
    }

    private static final void onViewCreated$updateUI(TextView tvValue, ConcurrencyBottomSheet this$0, Button btnDecrease, Button btnIncrease) {
        tvValue.setText(String.valueOf(this$0.currentValue));
        btnDecrease.setEnabled(this$0.currentValue > 1);
        btnIncrease.setEnabled(this$0.currentValue < 50);
    }

    static final void onViewCreated$lambda$0(ConcurrencyBottomSheet this$0, TextView $tvValue, Button $btnDecrease, Button $btnIncrease, View it) {
        if (this$0.currentValue > 1) {
            this$0.currentValue--;
            this$0.saveValue();
            onViewCreated$updateUI($tvValue, this$0, $btnDecrease, $btnIncrease);
        }
    }

    static final void onViewCreated$lambda$1(ConcurrencyBottomSheet this$0, TextView $tvValue, Button $btnDecrease, Button $btnIncrease, View it) {
        if (this$0.currentValue < 50) {
            this$0.currentValue++;
            this$0.saveValue();
            onViewCreated$updateUI($tvValue, this$0, $btnDecrease, $btnIncrease);
        }
    }

    private final void saveValue() {
        SharedPreferences $this$edit$iv = this.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.putInt("provider_concurrency", this.currentValue);
        editor$iv.apply();
    }

    public void onDismiss(@NotNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDismissCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
