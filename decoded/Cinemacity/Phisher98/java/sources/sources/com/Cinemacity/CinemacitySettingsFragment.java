package com.Cinemacity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.lagradost.cloudstream3.plugins.Plugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: CinemacitySettingsFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Cinemacity/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J#\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\u00020\u00102\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0011J\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0010H\u0002J\"\u0010\u0014\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0016J$\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/Cinemacity/CinemacitySettingsFragment;", "Landroidx/fragment/app/DialogFragment;", "plugin", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "(Lcom/lagradost/cloudstream3/plugins/Plugin;)V", "res", "Landroid/content/res/Resources;", "getRes", "()Landroid/content/res/Resources;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "name", "", "findView", "T", "Landroid/view/View;", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "makeTvCompatible", "", "getLayout", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onCreateView", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Cinemacity"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class CinemacitySettingsFragment extends DialogFragment {

    @NotNull
    private final Plugin plugin;

    public CinemacitySettingsFragment(@NotNull Plugin plugin) {
        this.plugin = plugin;
    }

    private final Resources getRes() {
        Resources resources = this.plugin.getResources();
        Intrinsics.checkNotNull(resources);
        return resources;
    }

    private final Drawable getDrawable(String name) {
        int id = getRes().getIdentifier(name, "drawable", "com.phisher98");
        Drawable drawable = getRes().getDrawable(id, null);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    private final <T extends View> T findView(View view, String str) {
        return (T) view.findViewById(getRes().getIdentifier(str, "id", "com.phisher98"));
    }

    private final void makeTvCompatible(View $this$makeTvCompatible) {
        $this$makeTvCompatible.setBackground(getDrawable("outline"));
    }

    private final View getLayout(String name, LayoutInflater inflater, ViewGroup container) {
        int id = getRes().getIdentifier(name, "layout", "com.phisher98");
        return inflater.inflate((XmlPullParser) getRes().getLayout(id), container, false);
    }

    public void onStart() {
        Window $this$onStart_u24lambda_u240;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && ($this$onStart_u24lambda_u240 = dialog.getWindow()) != null) {
            DisplayMetrics dm = getResources().getDisplayMetrics();
            int maxW = (int) (500.0f * dm.density);
            int width = dm.widthPixels > maxW ? maxW : (int) (dm.widthPixels * 0.9f);
            $this$onStart_u24lambda_u240.setLayout(width, -2);
            $this$onStart_u24lambda_u240.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayout("bottom_sheet_layout", inflater, container);
        int bgId = getRes().getIdentifier("dialog_background", "drawable", "com.phisher98");
        if (bgId != 0) {
            view.setBackground(getRes().getDrawable(bgId, null));
        }
        ImageView save = (ImageView) findView(view, "save");
        save.setImageDrawable(getDrawable("save_icon"));
        makeTvCompatible(save);
        save.setOnClickListener(new View.OnClickListener() { // from class: com.Cinemacity.CinemacitySettingsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CinemacitySettingsFragment.onCreateView$lambda$0(this.f$0, view2);
            }
        });
        View loginRow = findView(view, "loginRow");
        View cfRow = findView(view, "cfRow");
        ImageView loginCard = (ImageView) findView(view, "loginCard");
        ImageView cfCard = (ImageView) findView(view, "cfCard");
        loginRow.setBackground(getDrawable("settings_item_background"));
        cfRow.setBackground(getDrawable("settings_item_background"));
        loginCard.setImageDrawable(getDrawable("settings_icon"));
        cfCard.setImageDrawable(getDrawable("settings_icon"));
        final Function2 showSub = new Function2() { // from class: com.Cinemacity.CinemacitySettingsFragment$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                return CinemacitySettingsFragment.onCreateView$lambda$1(this.f$0, (Function1) obj, (String) obj2);
            }
        };
        loginRow.setOnClickListener(new View.OnClickListener() { // from class: com.Cinemacity.CinemacitySettingsFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                showSub.invoke(new Function1() { // from class: com.Cinemacity.CinemacitySettingsFragment$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return CinemacitySettingsFragment.onCreateView$lambda$2$0(this.f$0, (Function0) obj);
                    }
                }, "cc_login_sub");
            }
        });
        cfRow.setOnClickListener(new View.OnClickListener() { // from class: com.Cinemacity.CinemacitySettingsFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                showSub.invoke(new Function1() { // from class: com.Cinemacity.CinemacitySettingsFragment$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        return CinemacitySettingsFragment.onCreateView$lambda$3$0(cinemacitySettingsFragment, (Function0) obj);
                    }
                }, "cc_cf_sub");
            }
        });
        return view;
    }

    static final void onCreateView$lambda$0(final CinemacitySettingsFragment this$0, View it) {
        final Context ctx = this$0.getContext();
        if (ctx != null) {
            new AlertDialog.Builder(ctx).setTitle("Restart App?").setMessage("Save changes and restart the app?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.Cinemacity.CinemacitySettingsFragment$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    CinemacitySettingsFragmentKt.access$restartApp(ctx);
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.Cinemacity.CinemacitySettingsFragment$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    CinemacitySettingsFragment.onCreateView$lambda$0$0$1(this.f$0, dialogInterface, i);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0$0$1(CinemacitySettingsFragment this$0, DialogInterface d, int i) {
        d.dismiss();
        this$0.dismiss();
    }

    static final Unit onCreateView$lambda$1(final CinemacitySettingsFragment this$0, Function1 creator, String tag) {
        FragmentActivity activity = this$0.getActivity();
        final FragmentManager fm = activity != null ? activity.getSupportFragmentManager() : null;
        if (fm != null) {
            this$0.dismiss();
            DialogFragment frag = (DialogFragment) creator.invoke(new Function0() { // from class: com.Cinemacity.CinemacitySettingsFragment$$ExternalSyntheticLambda3
                public final Object invoke() {
                    return CinemacitySettingsFragment.onCreateView$lambda$1$0(this.f$0, fm);
                }
            });
            frag.show(fm, tag);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$1$0(CinemacitySettingsFragment this$0, FragmentManager $fm) {
        new CinemacitySettingsFragment(this$0.plugin).show($fm, "cc_main_settings");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogFragment onCreateView$lambda$2$0(CinemacitySettingsFragment this$0, Function0 cb) {
        return new CinemacityLoginSubSheet(this$0.plugin, cb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogFragment onCreateView$lambda$3$0(CinemacitySettingsFragment this$0, Function0 cb) {
        return new CinemacityCFSubSheet(this$0.plugin, cb);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
    }
}
