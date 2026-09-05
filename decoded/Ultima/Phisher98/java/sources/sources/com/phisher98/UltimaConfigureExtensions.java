package com.phisher98;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.CommonActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: ConfigureExtensions.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0003b\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\b(\"J\"\u0010#\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\rH\u0003b\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\b(%J\u0010\u0010&\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002J#\u0010'\u001a\u0002H(\"\b\b\u0000\u0010(*\u00020\u001a*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\u0010)J\f\u0010*\u001a\u00020+*\u00020\u001aH\u0002J\u001a\u0010,\u001a\u00020+H\u0007b\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\b(-J\"\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/phisher98/UltimaConfigureExtensions;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "plugin", "Lcom/phisher98/UltimaPlugin;", "getPlugin", "()Lcom/phisher98/UltimaPlugin;", "param1", "", "param2", "sm", "Lcom/phisher98/UltimaStorageManager;", "res", "Landroid/content/res/Resources;", "extensions", "", "Lcom/phisher98/UltimaUtils$ExtensionInfo;", "[Lcom/phisher98/UltimaUtils$ExtensionInfo;", "dialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "getLayout", "Landroid/view/View;", "name", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Landroid/annotation/SuppressLint;", "value", "DiscouragedApi", "getDrawable", "Landroid/graphics/drawable/Drawable;", "UseCompatLoadingForDrawables", "getString", "findView", "T", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "makeTvCompatible", "", "show", "UseSwitchCompatOrMaterialCode", "buildExtensionView", "extension", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConfigureExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfigureExtensions.kt\ncom/phisher98/UltimaConfigureExtensions\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,174:1\n15101#2:175\n15101#2,2:176\n15102#2:178\n15101#2,2:179\n15101#2,2:181\n15101#2:183\n15101#2,2:184\n15102#2:186\n251#3:187\n*S KotlinDebug\n*F\n+ 1 ConfigureExtensions.kt\ncom/phisher98/UltimaConfigureExtensions\n*L\n29#1:175\n31#1:176,2\n29#1:178\n104#1:179,2\n166#1:181,2\n81#1:183\n83#1:184,2\n81#1:186\n160#1:187\n*E\n"})
public final class UltimaConfigureExtensions {

    @NotNull
    private final AppCompatActivity activity;
    private BottomSheetDialog dialog;

    @NotNull
    private final UltimaUtils.ExtensionInfo[] extensions;

    @Nullable
    private String param1;

    @Nullable
    private String param2;

    @NotNull
    private final UltimaPlugin plugin;

    @NotNull
    private final Resources res;

    @NotNull
    private final UltimaStorageManager sm;

    public UltimaConfigureExtensions(@NotNull AppCompatActivity activity) throws Exception {
        this.activity = activity;
        UltimaPlugin companion = UltimaPlugin.INSTANCE.getInstance();
        if (companion != null) {
            this.plugin = companion;
            this.sm = UltimaStorageManager.INSTANCE;
            Resources resources = this.plugin.getResources();
            if (resources != null) {
                this.res = resources;
                UltimaUtils.ExtensionInfo[] extensionInfoArrFetchExtensions = this.sm.fetchExtensions();
                UltimaUtils.ExtensionInfo[] it = extensionInfoArrFetchExtensions;
                int i = 0;
                Log.INSTANCE.d("UltimaDebug", "Fetched " + it.length + " extensions.");
                int length = it.length;
                int i2 = 0;
                while (i2 < length) {
                    UltimaUtils.ExtensionInfo extensionInfo = it[i2];
                    Log.INSTANCE.d("UltimaDebug", "→ Extension: " + extensionInfo.getName());
                    UltimaUtils.SectionInfo[] sections = extensionInfo.getSections();
                    if (sections != null) {
                        int length2 = sections.length;
                        int i3 = 0;
                        while (i3 < length2) {
                            UltimaUtils.SectionInfo sectionInfo = sections[i3];
                            Log.INSTANCE.d("UltimaDebug", " - Section: " + sectionInfo.getName() + ", enabled=" + sectionInfo.getEnabled());
                            i3++;
                            it = it;
                            i = i;
                        }
                    }
                    i2++;
                    it = it;
                    i = i;
                }
                this.extensions = extensionInfoArrFetchExtensions;
                return;
            }
            throw new Exception("Unable to read resources");
        }
        throw new Exception("Plugin not initialized");
    }

    @NotNull
    public final AppCompatActivity getActivity() {
        return this.activity;
    }

    @NotNull
    public final UltimaPlugin getPlugin() {
        return this.plugin;
    }

    @SuppressLint({"DiscouragedApi"})
    private final View getLayout(String name, LayoutInflater inflater, ViewGroup container) {
        int id = this.res.getIdentifier(name, "layout", "com.phisher98");
        XmlResourceParser layout = this.res.getLayout(id);
        return inflater.inflate((XmlPullParser) layout, container, false);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final Drawable getDrawable(String name) throws Exception {
        int id = this.res.getIdentifier(name, "drawable", "com.phisher98");
        Drawable drawable = this.res.getDrawable(id, null);
        if (drawable != null) {
            return drawable;
        }
        throw new Exception("Drawable " + name + " not found");
    }

    private final String getString(String name) {
        int id = this.res.getIdentifier(name, "string", "com.phisher98");
        return this.res.getString(id);
    }

    private final <T extends View> T findView(View view, String str) {
        return (T) view.findViewById(this.res.getIdentifier(str, "id", "com.phisher98"));
    }

    private final void makeTvCompatible(View $this$makeTvCompatible) {
        int outlineId = this.res.getIdentifier("outline", "drawable", "com.phisher98");
        $this$makeTvCompatible.setBackground(this.res.getDrawable(outlineId, null));
    }

    @SuppressLint({"UseSwitchCompatOrMaterialCode"})
    public final void show() {
        this.dialog = new BottomSheetDialog(this.activity);
        LayoutInflater inflater = LayoutInflater.from(this.activity);
        BottomSheetDialog bottomSheetDialog = null;
        View settings = getLayout("configure_extensions", inflater, null);
        ImageView saveBtn = (ImageView) findView(settings, "save");
        saveBtn.setImageDrawable(getDrawable("save_icon"));
        makeTvCompatible(saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaConfigureExtensions$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UltimaConfigureExtensions.show$lambda$0(this.f$0, view);
            }
        });
        final Switch extNameOnHomeBtn = (Switch) findView(settings, "ext_name_on_home_toggle");
        makeTvCompatible(extNameOnHomeBtn);
        extNameOnHomeBtn.setChecked(this.sm.getExtNameOnHome());
        extNameOnHomeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaConfigureExtensions$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.sm.setExtNameOnHome(extNameOnHomeBtn.isChecked());
            }
        });
        LinearLayout extensionsListLayout = (LinearLayout) findView(settings, "extensions_list");
        for (UltimaUtils.ExtensionInfo extensionInfo : this.extensions) {
            View extensionLayoutView = buildExtensionView(extensionInfo, inflater, null);
            extensionsListLayout.addView(extensionLayoutView);
        }
        BottomSheetDialog bottomSheetDialog2 = this.dialog;
        if (bottomSheetDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog2 = null;
        }
        bottomSheetDialog2.setContentView(settings);
        BottomSheetDialog bottomSheetDialog3 = this.dialog;
        if (bottomSheetDialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog3 = null;
        }
        bottomSheetDialog3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.phisher98.UltimaConfigureExtensions$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                UltimaConfigureExtensions.show$lambda$3(this.f$0, dialogInterface);
            }
        });
        BottomSheetDialog bottomSheetDialog4 = this.dialog;
        if (bottomSheetDialog4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
        } else {
            bottomSheetDialog = bottomSheetDialog4;
        }
        bottomSheetDialog.show();
    }

    static final void show$lambda$0(UltimaConfigureExtensions this$0, View it) {
        UltimaUtils.ExtensionInfo[] extensionInfoArr = this$0.extensions;
        int $i$f$forEach = 0;
        int length = extensionInfoArr.length;
        int i = 0;
        while (i < length) {
            UltimaUtils.ExtensionInfo extensionInfo = extensionInfoArr[i];
            Log.INSTANCE.d("UltimaDebug", "Saving Extension: " + extensionInfo.getName());
            UltimaUtils.SectionInfo[] sections = extensionInfo.getSections();
            if (sections != null) {
                int length2 = sections.length;
                int i2 = 0;
                while (i2 < length2) {
                    UltimaUtils.SectionInfo sectionInfo = sections[i2];
                    Log.INSTANCE.d("UltimaDebug", "-- Section: " + sectionInfo.getName() + " enabled=" + sectionInfo.getEnabled());
                    i2++;
                    extensionInfoArr = extensionInfoArr;
                    $i$f$forEach = $i$f$forEach;
                }
            }
            i++;
            extensionInfoArr = extensionInfoArr;
            $i$f$forEach = $i$f$forEach;
        }
        this$0.sm.setCurrentExtensions(this$0.extensions);
        this$0.plugin.reload();
        BottomSheetDialog bottomSheetDialog = null;
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Saved", (Integer) null, 2, (Object) null);
        BottomSheetDialog bottomSheetDialog2 = this$0.dialog;
        if (bottomSheetDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
        } else {
            bottomSheetDialog = bottomSheetDialog2;
        }
        bottomSheetDialog.dismiss();
    }

    static final void show$lambda$3(UltimaConfigureExtensions this$0, DialogInterface it) {
        if (!this$0.activity.isFinishing() && !this$0.activity.isDestroyed()) {
            UltimaSettings settingsDialog = new UltimaSettings(this$0.activity);
            settingsDialog.show();
        }
    }

    private static final View buildExtensionView$buildSectionView(UltimaConfigureExtensions this$0, final UltimaUtils.ExtensionInfo $extension, final UltimaUtils.SectionInfo section, LayoutInflater inflater, ViewGroup container) {
        View sectionView = this$0.getLayout("list_section_item", inflater, container);
        CheckBox checkBox = (CheckBox) this$0.findView(sectionView, "section_checkbox");
        checkBox.setText(section.getName());
        this$0.makeTvCompatible(checkBox);
        checkBox.setChecked(section.getEnabled());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.phisher98.UltimaConfigureExtensions$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                UltimaConfigureExtensions.buildExtensionView$buildSectionView$lambda$0(section, $extension, compoundButton, z);
            }
        });
        return sectionView;
    }

    static final void buildExtensionView$buildSectionView$lambda$0(UltimaUtils.SectionInfo $section, UltimaUtils.ExtensionInfo $extension, CompoundButton compoundButton, boolean isChecked) {
        $section.setEnabled(isChecked);
        Log.INSTANCE.d("UltimaDebug", "Section '" + $section.getName() + "' in '" + $extension.getName() + "' set to " + isChecked);
    }

    private final View buildExtensionView(UltimaUtils.ExtensionInfo extension, LayoutInflater inflater, ViewGroup container) {
        View extView = getLayout("list_extension_item", inflater, container);
        LinearLayout extensionDataBtn = (LinearLayout) findView(extView, "extension_data");
        final ImageView expandImage = (ImageView) findView(extView, "expand_icon");
        TextView extensionNameBtn = (TextView) findView(extensionDataBtn, "extension_name");
        final LinearLayout childList = (LinearLayout) findView(extView, "sections_list");
        expandImage.setImageDrawable(getDrawable("triangle"));
        expandImage.setRotation(90.0f);
        extensionNameBtn.setText(extension.getName());
        makeTvCompatible(extensionDataBtn);
        extensionDataBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaConfigureExtensions$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UltimaConfigureExtensions.buildExtensionView$lambda$1(childList, expandImage, view);
            }
        });
        UltimaUtils.SectionInfo[] sections = extension.getSections();
        if (sections == null) {
            return extView;
        }
        int length = sections.length;
        int i = 0;
        while (i < length) {
            View extView2 = extView;
            View sectionView = buildExtensionView$buildSectionView(this, extension, sections[i], inflater, container);
            childList.addView(sectionView);
            i++;
            extView = extView2;
        }
        return extView;
    }

    static final void buildExtensionView$lambda$1(LinearLayout $childList, ImageView $expandImage, View it) {
        LinearLayout $this$isVisible$iv = $childList;
        boolean isVisible = $this$isVisible$iv.getVisibility() == 0;
        $childList.setVisibility(isVisible ? 8 : 0);
        $expandImage.setRotation(isVisible ? 90.0f : 180.0f);
    }
}
