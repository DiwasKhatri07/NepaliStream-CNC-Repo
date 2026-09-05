package com.phisher98.settings;

import android.R;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.lagradost.cloudstream3.CommonActivity;
import com.phisher98.JellyfinPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Jellyfin/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\f\u0010\u001a\u001a\u00020\u001b*\u00020\u0010H\u0002J&\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0012\u0010 \u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J@\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0017b\u0016\b#\u0012\u0012\b$\u0012\u000e\b\fJ\u0004\b\b(%J\u0004\b\b(&b\f\b'\u0012\b\b$\u0012\u0004\b\u0003\u0010.J\b\u0010(\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/phisher98/settings/SettingsFragment;", "Landroidx/fragment/app/DialogFragment;", "plugin", "Lcom/phisher98/JellyfinPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Lcom/phisher98/JellyfinPlugin;Landroid/content/SharedPreferences;)V", "res", "Landroid/content/res/Resources;", "URL", "", "Username", "Password", "findView", "T", "Landroid/view/View;", "name", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "getLayout", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "makeTvCompatible", "", "onCreateView", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onCreate", "onViewCreated", "view", "Landroid/annotation/SuppressLint;", "value", "SetJavaScriptEnabled", "SetTextI18n", "Landroidx/annotation/RequiresApi;", "restartApp", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsFragment.kt\ncom/phisher98/settings/SettingsFragment\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,192:1\n40#2,11:193\n*S KotlinDebug\n*F\n+ 1 SettingsFragment.kt\ncom/phisher98/settings/SettingsFragment\n*L\n132#1:193,11\n*E\n"})
public final class SettingsFragment extends DialogFragment {
    private String Password;
    private String URL;
    private String Username;

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public SettingsFragment(@NotNull JellyfinPlugin plugin, @NotNull SharedPreferences sharedPref) throws Exception {
        this.sharedPref = sharedPref;
        Resources resources = plugin.getResources();
        if (resources != null) {
            this.res = resources;
            return;
        }
        throw new Exception("Unable to read resources");
    }

    private final <T extends View> T findView(View view, String str) {
        int identifier = this.res.getIdentifier(str, "id", "com.phisher98");
        if (identifier == 0) {
            throw new Resources.NotFoundException("View ID " + str + " not found.");
        }
        return (T) view.findViewById(identifier);
    }

    private final View getLayout(String name, LayoutInflater inflater, ViewGroup container) {
        int id = this.res.getIdentifier(name, "layout", "com.phisher98");
        if (id == 0) {
            throw new Resources.NotFoundException("Layout " + name + " not found.");
        }
        XmlResourceParser layout = this.res.getLayout(id);
        return inflater.inflate((XmlPullParser) layout, container, false);
    }

    private final Drawable getDrawable(String name) {
        int id = this.res.getIdentifier(name, "drawable", "com.phisher98");
        Drawable drawable = this.res.getDrawable(id, null);
        if (drawable != null) {
            return drawable;
        }
        throw new Resources.NotFoundException("Drawable " + name + " not found.");
    }

    private final void makeTvCompatible(View $this$makeTvCompatible) {
        int outlineId = this.res.getIdentifier("outline", "drawable", "com.phisher98");
        $this$makeTvCompatible.setBackground(this.res.getDrawable(outlineId, null));
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayout("settings_fragment", inflater, container);
        Button saveButton = (Button) findView(view, "saveCredentialsButton");
        ImageView closeButton = (ImageView) findView(view, "closeButton");
        final EditText urlInput = (EditText) findView(view, "urlInput");
        final EditText usernameInput = (EditText) findView(view, "usernameInput");
        final EditText passwordInput = (EditText) findView(view, "passwordInput");
        final ImageView toggleVisibility = (ImageView) findView(view, "togglePasswordVisibility");
        Button resetButton = (Button) findView(view, "resetCredentialsButton");
        toggleVisibility.setImageDrawable(getDrawable("ic_visibility_off"));
        final Ref.BooleanRef isPasswordVisible = new Ref.BooleanRef();
        toggleVisibility.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.onCreateView$lambda$0(isPasswordVisible, passwordInput, toggleVisibility, this, view2);
            }
        });
        makeTvCompatible(saveButton);
        makeTvCompatible(resetButton);
        saveButton.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.onCreateView$lambda$1(this.f$0, urlInput, usernameInput, passwordInput, view2);
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.onCreateView$lambda$2(this.f$0, urlInput, usernameInput, passwordInput, view2);
            }
        });
        closeButton.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.dismiss();
            }
        });
        return view;
    }

    static final void onCreateView$lambda$0(Ref.BooleanRef $isPasswordVisible, EditText $passwordInput, ImageView $toggleVisibility, SettingsFragment this$0, View it) {
        $isPasswordVisible.element = !$isPasswordVisible.element;
        if ($isPasswordVisible.element) {
            $passwordInput.setInputType(145);
            $toggleVisibility.setImageDrawable(this$0.getDrawable("ic_visibility"));
        } else {
            $passwordInput.setInputType(129);
            $toggleVisibility.setImageDrawable(this$0.getDrawable("ic_visibility_off"));
        }
        Editable text = $passwordInput.getText();
        $passwordInput.setSelection(text != null ? text.length() : 0);
    }

    static final void onCreateView$lambda$1(final SettingsFragment this$0, EditText $urlInput, EditText $usernameInput, EditText $passwordInput, View it) {
        this$0.URL = StringsKt.trim($urlInput.getText().toString()).toString();
        this$0.Username = StringsKt.trim($usernameInput.getText().toString()).toString();
        this$0.Password = StringsKt.trim($passwordInput.getText().toString()).toString();
        String str = this$0.URL;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("URL");
            str = null;
        }
        if (!(str.length() == 0)) {
            String str2 = this$0.Username;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("Username");
                str2 = null;
            }
            if (!(str2.length() == 0)) {
                String str3 = this$0.Password;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("Password");
                    str3 = null;
                }
                if (!(str3.length() == 0)) {
                    SharedPreferences.Editor $this$onCreateView_u24lambda_u241_u240 = this$0.sharedPref.edit();
                    if ($this$onCreateView_u24lambda_u241_u240 != null) {
                        String str4 = this$0.URL;
                        if (str4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("URL");
                            str4 = null;
                        }
                        $this$onCreateView_u24lambda_u241_u240.putString("url", str4);
                        String str5 = this$0.Username;
                        if (str5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("Username");
                            str5 = null;
                        }
                        $this$onCreateView_u24lambda_u241_u240.putString("username", str5);
                        String str6 = this$0.Password;
                        if (str6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("Password");
                            str6 = null;
                        }
                        $this$onCreateView_u24lambda_u241_u240.putString("password", str6);
                        $this$onCreateView_u24lambda_u241_u240.apply();
                    }
                    CommonActivity.showToast$default(CommonActivity.INSTANCE, "Credentials Saved", (Integer) null, 2, (Object) null);
                    new AlertDialog.Builder(this$0.requireContext()).setTitle("Save & Reload").setMessage("Changes have been saved. Do you want to restart the app to apply them?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda6
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SettingsFragment.onCreateView$lambda$1$1(this.f$0, dialogInterface, i);
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda7
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.dismiss();
                        }
                    }).show();
                    return;
                }
            }
        }
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Please fill all fields", (Integer) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$1(SettingsFragment this$0, DialogInterface dialogInterface, int i) {
        this$0.dismiss();
        this$0.restartApp();
    }

    static final void onCreateView$lambda$2(final SettingsFragment this$0, EditText $urlInput, EditText $usernameInput, EditText $passwordInput, View it) {
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.clear();
        editor$iv.apply();
        $urlInput.setText("");
        $usernameInput.setText("");
        $passwordInput.setText("");
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Credentials reset", (Integer) null, 2, (Object) null);
        new AlertDialog.Builder(this$0.requireContext()).setTitle("Save & Reload").setMessage("Reset Completed. Do you want to restart the app to apply them?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SettingsFragment.onCreateView$lambda$2$1(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.dismiss();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$1(SettingsFragment this$0, DialogInterface dialogInterface, int i) {
        this$0.dismiss();
        this$0.restartApp();
    }

    public void onStart() {
        BottomSheetBehavior $this$onStart_u24lambda_u240;
        super.onStart();
        BottomSheetDialog dialog = getDialog();
        BottomSheetDialog bottomSheetDialog = dialog instanceof BottomSheetDialog ? dialog : null;
        if (bottomSheetDialog != null && ($this$onStart_u24lambda_u240 = bottomSheetDialog.getBehavior()) != null) {
            $this$onStart_u24lambda_u240.setState(3);
            $this$onStart_u24lambda_u240.setSkipCollapsed(true);
            $this$onStart_u24lambda_u240.setDraggable(false);
        }
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(1, R.style.Theme.Material.Light.Dialog.Alert);
    }

    @RequiresApi(23)
    @SuppressLint({"SetJavaScriptEnabled", "SetTextI18n"})
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
    }

    private final void restartApp() {
        Context context = requireContext().getApplicationContext();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(context.getPackageName());
        ComponentName componentName = intent != null ? intent.getComponent() : null;
        if (componentName != null) {
            Intent restartIntent = Intent.makeRestartActivityTask(componentName);
            context.startActivity(restartIntent);
            Runtime.getRuntime().exit(0);
        }
    }
}
