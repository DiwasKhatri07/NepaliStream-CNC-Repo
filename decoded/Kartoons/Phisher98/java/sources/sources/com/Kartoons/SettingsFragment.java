package com.Kartoons;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u000fJ$\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017b\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010.R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/Kartoons/SettingsFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/Kartoons/KartoonsPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Lcom/Kartoons/KartoonsPlugin;Landroid/content/SharedPreferences;)V", "res", "Landroid/content/res/Resources;", "findView", "T", "Landroid/view/View;", "name", "", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onViewCreated", "view", "Landroidx/annotation/RequiresApi;", "value", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class SettingsFragment extends BottomSheetDialogFragment {

    @NotNull
    private final KartoonsPlugin plugin;

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public SettingsFragment(@NotNull KartoonsPlugin plugin, @NotNull SharedPreferences sharedPref) throws Exception {
        this.plugin = plugin;
        this.sharedPref = sharedPref;
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
        int id = this.res.getIdentifier("settings_fragment", "layout", "com.phisher98");
        return inflater.inflate((XmlPullParser) this.res.getLayout(id), container, false);
    }

    public void onStart() {
        BottomSheetBehavior $this$onStart_u24lambda_u240;
        super.onStart();
        BottomSheetDialog dialog = getDialog();
        BottomSheetDialog bottomSheetDialog = dialog instanceof BottomSheetDialog ? dialog : null;
        if (bottomSheetDialog == null || ($this$onStart_u24lambda_u240 = bottomSheetDialog.getBehavior()) == null) {
            return;
        }
        $this$onStart_u24lambda_u240.setState(3);
        $this$onStart_u24lambda_u240.setSkipCollapsed(true);
    }

    @RequiresApi(23)
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        View loginRow = findView(view, "loginButton");
        View cfRow = findView(view, "cfBypassButton");
        TextView loginSub = (TextView) findView(view, "login_status_sub");
        TextView cfSub = (TextView) findView(view, "cf_status_sub");
        loginSub.setText(!StringsKt.isBlank(KartoonsPlugin.INSTANCE.getAuthToken()) ? "✅ Logged In – Tap to Manage" : "🔐 Tap to Login to Kartoons");
        cfSub.setText(!StringsKt.isBlank(KartoonsPlugin.INSTANCE.getCfCookies()) ? "✅ CF Cookies Saved" : "🛡️ Tap to Bypass Cloudflare");
        final Function2 showSub = new Function2() { // from class: com.Kartoons.SettingsFragment$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                return SettingsFragment.onViewCreated$lambda$0(this.f$0, (Function1) obj, (String) obj2);
            }
        };
        SettingsFragmentKt.setupSaveRestart(view, this, this.plugin);
        loginRow.setOnClickListener(new View.OnClickListener() { // from class: com.Kartoons.SettingsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                showSub.invoke(new Function1() { // from class: com.Kartoons.SettingsFragment$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        return SettingsFragment.onViewCreated$lambda$1$0(this.f$0, (Function0) obj);
                    }
                }, "kartoons_login_sub");
            }
        });
        cfRow.setOnClickListener(new View.OnClickListener() { // from class: com.Kartoons.SettingsFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                showSub.invoke(new Function1() { // from class: com.Kartoons.SettingsFragment$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        return SettingsFragment.onViewCreated$lambda$2$0(this.f$0, (Function0) obj);
                    }
                }, "kartoons_cf_sub");
            }
        });
    }

    static final Unit onViewCreated$lambda$0(final SettingsFragment this$0, Function1 creator, String tag) {
        FragmentActivity activity = this$0.getActivity();
        final FragmentManager fm = activity != null ? activity.getSupportFragmentManager() : null;
        if (fm != null) {
            this$0.dismiss();
            BottomSheetDialogFragment frag = (BottomSheetDialogFragment) creator.invoke(new Function0() { // from class: com.Kartoons.SettingsFragment$$ExternalSyntheticLambda0
                public final Object invoke() {
                    return SettingsFragment.onViewCreated$lambda$0$0(this.f$0, fm);
                }
            });
            frag.show(fm, tag);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0(SettingsFragment this$0, FragmentManager $fm) {
        new SettingsFragment(this$0.plugin, this$0.sharedPref).show($fm, "kartoons_main_settings");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BottomSheetDialogFragment onViewCreated$lambda$1$0(SettingsFragment this$0, Function0 cb) {
        return new KartoonsLoginSubSheet(this$0.plugin, this$0.sharedPref, cb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BottomSheetDialogFragment onViewCreated$lambda$2$0(SettingsFragment this$0, Function0 cb) {
        return new KartoonsCFSubSheet(this$0.plugin, this$0.sharedPref, cb);
    }
}
