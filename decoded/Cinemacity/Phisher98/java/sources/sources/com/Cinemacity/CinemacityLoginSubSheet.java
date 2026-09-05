package com.Cinemacity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.cloudstream3.plugins.Plugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: CinemacitySettingsFragment.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Cinemacity/classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/Cinemacity/CinemacityLoginSubSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "onBack", "Lkotlin/Function0;", "", "<init>", "(Lcom/lagradost/cloudstream3/plugins/Plugin;Lkotlin/jvm/functions/Function0;)V", "res", "Landroid/content/res/Resources;", "getRes", "()Landroid/content/res/Resources;", "findView", "T", "Landroid/view/View;", "name", "", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "Cinemacity"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCinemacitySettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CinemacitySettingsFragment.kt\ncom/Cinemacity/CinemacityLoginSubSheet\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,337:1\n2068#2,2:338\n*S KotlinDebug\n*F\n+ 1 CinemacitySettingsFragment.kt\ncom/Cinemacity/CinemacityLoginSubSheet\n*L\n180#1:338,2\n*E\n"})
public final class CinemacityLoginSubSheet extends BottomSheetDialogFragment {

    @NotNull
    private final Function0<Unit> onBack;

    @NotNull
    private final Plugin plugin;

    public CinemacityLoginSubSheet(@NotNull Plugin plugin, @NotNull Function0<Unit> function0) {
        this.plugin = plugin;
        this.onBack = function0;
    }

    private final Resources getRes() {
        Resources resources = this.plugin.getResources();
        Intrinsics.checkNotNull(resources);
        return resources;
    }

    private final <T extends View> T findView(View view, String str) {
        return (T) view.findViewById(getRes().getIdentifier(str, "id", "com.phisher98"));
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = getRes().getIdentifier("login_sheet_layout", "layout", "com.phisher98");
        View view = inflater.inflate((XmlPullParser) getRes().getLayout(layoutId), container, false);
        final Button loginBtn = (Button) findView(view, "login_btn");
        Button clearLoginBtn = (Button) findView(view, "clear_login_btn");
        loginBtn.setText(!StringsKt.isBlank(CinemacityPlugin.INSTANCE.getLoginCookies()) ? "✅ Logged In – Refresh" : "🔐 Login to CinemaCity");
        loginBtn.setOnClickListener(new View.OnClickListener() { // from class: com.Cinemacity.CinemacityLoginSubSheet$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CinemacityLoginSubSheet.onCreateView$lambda$0(loginBtn, this, view2);
            }
        });
        clearLoginBtn.setOnClickListener(new View.OnClickListener() { // from class: com.Cinemacity.CinemacityLoginSubSheet$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CinemacityLoginSubSheet.onCreateView$lambda$1(this.f$0, loginBtn, view2);
            }
        });
        ImageView saveBtn = (ImageView) findView(view, "save");
        int saveIconId = getRes().getIdentifier("save_icon", "drawable", "com.phisher98");
        if (saveIconId != 0) {
            saveBtn.setImageDrawable(getRes().getDrawable(saveIconId, null));
        }
        int outlineId = getRes().getIdentifier("outline", "drawable", "com.phisher98");
        if (outlineId != 0) {
            saveBtn.setBackground(getRes().getDrawable(outlineId, null));
        }
        saveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.Cinemacity.CinemacityLoginSubSheet$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CinemacityLoginSubSheet.onCreateView$lambda$2(this.f$0, view2);
            }
        });
        return view;
    }

    static final void onCreateView$lambda$0(final Button $loginBtn, final CinemacityLoginSubSheet this$0, View it) {
        $loginBtn.setText("⏳ Opening login…");
        new CinemacityLoginDialog(new Function1() { // from class: com.Cinemacity.CinemacityLoginSubSheet$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return CinemacityLoginSubSheet.onCreateView$lambda$0$0($loginBtn, this$0, ((Boolean) obj).booleanValue());
            }
        }).show(this$0.getParentFragmentManager(), "cc_login_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(Button $loginBtn, CinemacityLoginSubSheet this$0, boolean z) {
        $loginBtn.setText(!StringsKt.isBlank(CinemacityPlugin.INSTANCE.getLoginCookies()) ? "✅ Logged In – Refresh" : "🔐 Login to CinemaCity");
        this$0.onBack.invoke();
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$1(final CinemacityLoginSubSheet this$0, final Button $loginBtn, View it) {
        final Context ctx = this$0.getContext();
        if (ctx != null) {
            new AlertDialog.Builder(ctx).setTitle("Clear Login?").setMessage("Remove saved login cookies and user hash? You will need to log in again.").setPositiveButton("Clear", new DialogInterface.OnClickListener() { // from class: com.Cinemacity.CinemacityLoginSubSheet$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    CinemacityLoginSubSheet.onCreateView$lambda$1$0$0($loginBtn, this$0, ctx, dialogInterface, i);
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.Cinemacity.CinemacityLoginSubSheet$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$0$0(Button $loginBtn, CinemacityLoginSubSheet this$0, Context $ctx, DialogInterface dialogInterface, int i) {
        CookieManager $this$onCreateView_u24lambda_u241_u240_u240_u240 = CookieManager.getInstance();
        Iterable $this$forEach$iv = CollectionsKt.listOf(new String[]{"dle_user_id", "dle_password", "PHPSESSID", "dle_hash"});
        for (Object element$iv : $this$forEach$iv) {
            String n = (String) element$iv;
            $this$onCreateView_u24lambda_u241_u240_u240_u240.setCookie("https://cinemacity.cc", n + "=; domain=cinemacity.cc; path=/; Max-Age=0; expires=Thu, 01 Jan 1970 00:00:00 GMT");
            $this$onCreateView_u24lambda_u241_u240_u240_u240.setCookie("https://cinemacity.cc", n + "=; domain=.cinemacity.cc; path=/; Max-Age=0; expires=Thu, 01 Jan 1970 00:00:00 GMT");
            $this$onCreateView_u24lambda_u241_u240_u240_u240.setCookie("https://cinemacity.cc", n + "=; path=/; Max-Age=0; expires=Thu, 01 Jan 1970 00:00:00 GMT");
        }
        $this$onCreateView_u24lambda_u241_u240_u240_u240.flush();
        CinemacityPlugin.INSTANCE.setLoginCookies("");
        CinemacityPlugin.INSTANCE.setUserHash("");
        $loginBtn.setText("🔐 Login to CinemaCity");
        this$0.onBack.invoke();
        Toast.makeText($ctx, "✅ Login cleared", 0).show();
    }

    static final void onCreateView$lambda$2(final CinemacityLoginSubSheet this$0, View it) {
        final Context ctx = this$0.getContext();
        if (ctx != null) {
            new AlertDialog.Builder(ctx).setTitle("Restart App?").setMessage("Save changes and restart the app?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.Cinemacity.CinemacityLoginSubSheet$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    CinemacitySettingsFragmentKt.access$restartApp(ctx);
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.Cinemacity.CinemacityLoginSubSheet$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    CinemacityLoginSubSheet.onCreateView$lambda$2$0$1(this.f$0, dialogInterface, i);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$0$1(CinemacityLoginSubSheet this$0, DialogInterface d, int i) {
        d.dismiss();
        this$0.dismiss();
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetBehavior behavior;
        BottomSheetDialog bottomSheetDialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        BottomSheetDialog bottomSheetDialog = bottomSheetDialogOnCreateDialog instanceof BottomSheetDialog ? bottomSheetDialogOnCreateDialog : null;
        if (bottomSheetDialog != null && (behavior = bottomSheetDialog.getBehavior()) != null) {
            behavior.setState(3);
        }
        return bottomSheetDialogOnCreateDialog;
    }
}
