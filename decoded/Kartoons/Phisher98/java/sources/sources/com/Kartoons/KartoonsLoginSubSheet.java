package com.Kartoons;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebStorage;
import android.widget.Button;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.cloudstream3.CommonActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/Kartoons/KartoonsLoginSubSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/Kartoons/KartoonsPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "onBack", "Lkotlin/Function0;", "", "<init>", "(Lcom/Kartoons/KartoonsPlugin;Landroid/content/SharedPreferences;Lkotlin/jvm/functions/Function0;)V", "res", "Landroid/content/res/Resources;", "findView", "T", "Landroid/view/View;", "name", "", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsFragment.kt\ncom/Kartoons/KartoonsLoginSubSheet\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,460:1\n40#2,11:461\n*S KotlinDebug\n*F\n+ 1 SettingsFragment.kt\ncom/Kartoons/KartoonsLoginSubSheet\n*L\n197#1:461,11\n*E\n"})
public final class KartoonsLoginSubSheet extends BottomSheetDialogFragment {

    @NotNull
    private final Function0<Unit> onBack;

    @NotNull
    private final KartoonsPlugin plugin;

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public KartoonsLoginSubSheet(@NotNull KartoonsPlugin plugin, @NotNull SharedPreferences sharedPref, @NotNull Function0<Unit> function0) throws Exception {
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
        int layoutId = this.res.getIdentifier("login_sheet_layout", "layout", "com.phisher98");
        View view = inflater.inflate((XmlPullParser) this.res.getLayout(layoutId), container, false);
        final Button loginBtn = (Button) findView(view, "login_btn");
        Button clearLoginBtn = (Button) findView(view, "clear_login_btn");
        loginBtn.setText(!StringsKt.isBlank(KartoonsPlugin.INSTANCE.getAuthToken()) ? "✅ Logged In" : "🔐 Login to Kartoons");
        loginBtn.setOnClickListener(new View.OnClickListener() { // from class: com.Kartoons.KartoonsLoginSubSheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                KartoonsLoginSubSheet kartoonsLoginSubSheet = this.f$0;
                new KartoonsLoginDialog(kartoonsLoginSubSheet.sharedPref, new Function0() { // from class: com.Kartoons.KartoonsLoginSubSheet$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return KartoonsLoginSubSheet.onCreateView$lambda$0$0(button);
                    }
                }).show(kartoonsLoginSubSheet.getParentFragmentManager(), "kartoons_login_dialog");
            }
        });
        clearLoginBtn.setOnClickListener(new View.OnClickListener() { // from class: com.Kartoons.KartoonsLoginSubSheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                KartoonsLoginSubSheet.onCreateView$lambda$1(this.f$0, loginBtn, view2);
            }
        });
        SettingsFragmentKt.setupSaveRestart(view, this, this.plugin);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(Button $loginBtn) {
        $loginBtn.setText("✅ Logged In");
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$1(KartoonsLoginSubSheet this$0, Button $loginBtn, View it) {
        KartoonsPlugin.INSTANCE.setAuthToken("");
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.remove("auth_token");
        editor$iv.apply();
        CookieManager $this$onCreateView_u24lambda_u241_u241 = CookieManager.getInstance();
        $this$onCreateView_u24lambda_u241_u241.setCookie("https://kartoons.me", "token=; domain=kartoons.me; path=/; Max-Age=0; expires=Thu, 01 Jan 1970 00:00:00 GMT");
        $this$onCreateView_u24lambda_u241_u241.flush();
        WebStorage.getInstance().deleteAllData();
        $loginBtn.setText("🔐 Login to Kartoons");
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Login cleared", (Integer) null, 2, (Object) null);
    }

    public void onDismiss(@NotNull DialogInterface dialog) {
        super.onDismiss(dialog);
        this.onBack.invoke();
    }
}
