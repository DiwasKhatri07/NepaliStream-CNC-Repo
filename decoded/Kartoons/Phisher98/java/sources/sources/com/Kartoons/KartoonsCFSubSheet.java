package com.Kartoons;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.cloudstream3.CommonActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/Kartoons/KartoonsCFSubSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/Kartoons/KartoonsPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "onBack", "Lkotlin/Function0;", "", "<init>", "(Lcom/Kartoons/KartoonsPlugin;Landroid/content/SharedPreferences;Lkotlin/jvm/functions/Function0;)V", "res", "Landroid/content/res/Resources;", "findView", "T", "Landroid/view/View;", "name", "", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsFragment.kt\ncom/Kartoons/KartoonsCFSubSheet\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,460:1\n40#2,11:461\n40#2,11:472\n*S KotlinDebug\n*F\n+ 1 SettingsFragment.kt\ncom/Kartoons/KartoonsCFSubSheet\n*L\n243#1:461,11\n264#1:472,11\n*E\n"})
public final class KartoonsCFSubSheet extends BottomSheetDialogFragment {

    @NotNull
    private final Function0<Unit> onBack;

    @NotNull
    private final KartoonsPlugin plugin;

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public KartoonsCFSubSheet(@NotNull KartoonsPlugin plugin, @NotNull SharedPreferences sharedPref, @NotNull Function0<Unit> function0) throws Exception {
        this.plugin = plugin;
        this.sharedPref = sharedPref;
        this.onBack = function0;
        Resources resources = this.plugin.getResources();
        if (resources != null) {
            this.res = resources;
            return;
        }
        throw new Exception("Unable to read resources");
    }

    private final <T extends View> T findView(View view, String str) {
        return (T) view.findViewById(this.res.getIdentifier(str, "id", "com.phisher98"));
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = this.res.getIdentifier("cf_sheet_layout", "layout", "com.phisher98");
        View view = inflater.inflate((XmlPullParser) this.res.getLayout(layoutId), container, false);
        final Button bypassBtn = (Button) findView(view, "cf_bypass_btn");
        Button clearBtn = (Button) findView(view, "cf_clear_btn");
        Switch cfWebviewSwitch = (Switch) view.findViewById(this.res.getIdentifier("cf_webview_toggle", "id", "com.phisher98"));
        cfWebviewSwitch.setChecked(KartoonsPlugin.INSTANCE.getCfWebviewEnabled());
        cfWebviewSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.Kartoons.KartoonsCFSubSheet$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                KartoonsCFSubSheet.onCreateView$lambda$0(this.f$0, compoundButton, z);
            }
        });
        bypassBtn.setText(!StringsKt.isBlank(KartoonsPlugin.INSTANCE.getCfCookies()) ? "✅ CF Cookies Saved" : "🛡️ Bypass Cloudflare");
        bypassBtn.setOnClickListener(new View.OnClickListener() { // from class: com.Kartoons.KartoonsCFSubSheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                KartoonsCFSubSheet.onCreateView$lambda$1(bypassBtn, this, view2);
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() { // from class: com.Kartoons.KartoonsCFSubSheet$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                KartoonsCFSubSheet.onCreateView$lambda$2(this.f$0, bypassBtn, view2);
            }
        });
        SettingsFragmentKt.setupSaveRestart(view, this, this.plugin);
        return view;
    }

    static final void onCreateView$lambda$0(KartoonsCFSubSheet this$0, CompoundButton compoundButton, boolean isChecked) {
        KartoonsPlugin.INSTANCE.setCfWebviewEnabled(isChecked);
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.putBoolean("cf_webview_enabled", isChecked);
        editor$iv.apply();
    }

    static final void onCreateView$lambda$1(final Button $bypassBtn, KartoonsCFSubSheet this$0, View it) {
        $bypassBtn.setText("⏳ Solving…");
        new CloudflareWebViewDialog("https://api.kartoons.me", new Function1() { // from class: com.Kartoons.KartoonsCFSubSheet$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return KartoonsCFSubSheet.onCreateView$lambda$1$0($bypassBtn, ((Boolean) obj).booleanValue());
            }
        }, true).show(this$0.getParentFragmentManager(), "kartoons_cf_bypass");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$1$0(Button $bypassBtn, boolean saved) {
        $bypassBtn.setText(saved ? "✅ CF Cookies Saved" : "🛡️ Bypass Cloudflare");
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$2(KartoonsCFSubSheet this$0, Button $bypassBtn, View it) {
        KartoonsPlugin.INSTANCE.setCfCookies("");
        KartoonsPlugin.INSTANCE.setCfCookieHost("");
        KartoonsPlugin.INSTANCE.setCfUserAgent("");
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.remove("cf_cookies");
        editor$iv.remove("cf_user_agent");
        editor$iv.apply();
        $bypassBtn.setText("🛡️ Bypass Cloudflare");
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "CF Cookies cleared", (Integer) null, 2, (Object) null);
    }

    public void onDismiss(@NotNull DialogInterface dialog) {
        super.onDismiss(dialog);
        this.onBack.invoke();
    }
}
