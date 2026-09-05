package com.phisher98.settings;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;
import com.lagradost.cloudstream3.CommonActivity;
import com.phisher98.StreamPlayPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: WyzieSettingsFragment.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\f\u0010\r\u001a\u00020\b*\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J#\u0010\u0013\u001a\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u000e*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0015J&\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J,\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0017b\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\b(\"J\u0010\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/phisher98/settings/WyzieSettingsFragment;", "Landroidx/fragment/app/DialogFragment;", "plugin", "Lcom/phisher98/StreamPlayPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "onDismissCallback", "Lkotlin/Function0;", "", "<init>", "(Lcom/phisher98/StreamPlayPlugin;Landroid/content/SharedPreferences;Lkotlin/jvm/functions/Function0;)V", "res", "Landroid/content/res/Resources;", "makeTvCompatible", "Landroid/view/View;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "name", "", "findView", "T", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "Landroid/annotation/SuppressLint;", "value", "SetTextI18n", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class WyzieSettingsFragment extends DialogFragment {

    @Nullable
    private final Function0<Unit> onDismissCallback;

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public WyzieSettingsFragment(@NotNull StreamPlayPlugin plugin, @NotNull SharedPreferences sharedPref, @Nullable Function0<Unit> function0) throws Exception {
        this.sharedPref = sharedPref;
        this.onDismissCallback = function0;
        Resources resources = plugin.getResources();
        if (resources != null) {
            this.res = resources;
            return;
        }
        throw new Exception("Unable to read resources");
    }

    public /* synthetic */ WyzieSettingsFragment(StreamPlayPlugin streamPlayPlugin, SharedPreferences sharedPreferences, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(streamPlayPlugin, sharedPreferences, (i & 4) != 0 ? null : function0);
    }

    private final void makeTvCompatible(View $this$makeTvCompatible) {
        int outlineId = this.res.getIdentifier("outline", "drawable", "com.phisher98");
        $this$makeTvCompatible.setBackground(this.res.getDrawable(outlineId, null));
    }

    private final Drawable getDrawable(String name) throws Exception {
        int id = this.res.getIdentifier(name, "drawable", "com.phisher98");
        Drawable drawable = this.res.getDrawable(id, null);
        if (drawable != null) {
            return drawable;
        }
        throw new Exception("Drawable " + name + " not found");
    }

    private final <T extends View> T findView(View view, String str) {
        return (T) view.findViewById(this.res.getIdentifier(str, "id", "com.phisher98"));
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int id = this.res.getIdentifier("wyzie_settings_fragment", "layout", "com.phisher98");
        XmlResourceParser layout = this.res.getLayout(id);
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
        View cardContainer = findView(view, "cardContainer");
        final EditText wyzieKeyInput = (EditText) findView(view, "wyzieKeyInput");
        Button getKeyButton = (Button) findView(view, "getKeyButton");
        Button saveButton = (Button) findView(view, "saveButton");
        Button resetButton = (Button) findView(view, "resetButton");
        cardContainer.setBackground(getDrawable("settings_item_background"));
        wyzieKeyInput.setBackground(getDrawable("input_text_selector"));
        getKeyButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4285F4")));
        getKeyButton.setTextColor(-1);
        saveButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#6200EE")));
        saveButton.setTextColor(-1);
        resetButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D32F2F")));
        resetButton.setTextColor(-1);
        String savedKey = this.sharedPref.getString("wyzie_key", null);
        String str = savedKey;
        if (!(str == null || str.length() == 0)) {
            wyzieKeyInput.setText(savedKey);
        }
        getKeyButton.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.WyzieSettingsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WyzieSettingsFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.WyzieSettingsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WyzieSettingsFragment.onViewCreated$lambda$1(wyzieKeyInput, this, view2);
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.WyzieSettingsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WyzieSettingsFragment.onViewCreated$lambda$2(this.f$0, wyzieKeyInput, view2);
            }
        });
    }

    static final void onViewCreated$lambda$0(WyzieSettingsFragment this$0, View it) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://store.wyzie.io/redeem"));
            this$0.startActivity(intent);
        } catch (Exception e) {
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Could not open browser: " + e.getMessage(), (Integer) null, 2, (Object) null);
        }
    }

    static final void onViewCreated$lambda$1(EditText $wyzieKeyInput, WyzieSettingsFragment this$0, View it) {
        String key = StringsKt.trim($wyzieKeyInput.getText().toString()).toString();
        if (key.length() > 0) {
            SharedPreferences.Editor $this$onViewCreated_u24lambda_u241_u240 = this$0.sharedPref.edit();
            if ($this$onViewCreated_u24lambda_u241_u240 != null) {
                $this$onViewCreated_u24lambda_u241_u240.putString("wyzie_key", key);
                $this$onViewCreated_u24lambda_u241_u240.apply();
            }
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Wyzie key saved successfully. Restart the app.", (Integer) null, 2, (Object) null);
            this$0.dismiss();
            return;
        }
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Please enter a valid key", (Integer) null, 2, (Object) null);
    }

    static final void onViewCreated$lambda$2(WyzieSettingsFragment this$0, EditText $wyzieKeyInput, View it) {
        SharedPreferences.Editor $this$onViewCreated_u24lambda_u242_u240 = this$0.sharedPref.edit();
        if ($this$onViewCreated_u24lambda_u242_u240 != null) {
            $this$onViewCreated_u24lambda_u242_u240.remove("wyzie_key");
            $this$onViewCreated_u24lambda_u242_u240.apply();
        }
        $wyzieKeyInput.setText("");
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Wyzie key reset successfully. Restart the app.", (Integer) null, 2, (Object) null);
        this$0.dismiss();
    }

    public void onDismiss(@NotNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDismissCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
