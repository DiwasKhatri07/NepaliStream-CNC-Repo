package com.phisher98;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.lagradost.cloudstream3.CommonActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: Reorder.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\"\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\rH\u0003b\u0010\b\"\u0012\f\b#\u0012\b\b\fJ\u0004\b\b($J\u0010\u0010%\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002J5\u0010&\u001a\u0002H'\"\b\b\u0000\u0010'*\u00020\u001a*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0003b\u0010\b\"\u0012\f\b#\u0012\b\b\fJ\u0004\b\b($¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020**\u00020\u001aH\u0003b\u0010\b\"\u0012\f\b#\u0012\b\b\fJ\u0004\b\b($J\u0006\u0010+\u001a\u00020*J]\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001022\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00106\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u00107R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/phisher98/UltimaReorder;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "plugin", "Lcom/phisher98/UltimaPlugin;", "getPlugin", "()Lcom/phisher98/UltimaPlugin;", "param1", "", "param2", "sm", "Lcom/phisher98/UltimaStorageManager;", "extensions", "", "Lcom/phisher98/UltimaUtils$ExtensionInfo;", "[Lcom/phisher98/UltimaUtils$ExtensionInfo;", "res", "Landroid/content/res/Resources;", "dialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "getLayout", "Landroid/view/View;", "name", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "Landroid/annotation/SuppressLint;", "value", "UseCompatLoadingForDrawables", "getString", "findView", "T", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "makeTvCompatible", "", "show", "updateSectionList", "sectionsListView", "Landroid/widget/LinearLayout;", "noSectionWarning", "Landroid/widget/TextView;", "currentSections", "", "Lcom/phisher98/UltimaUtils$SectionInfo;", "focusingSection", "", "focusOn", "(Landroid/widget/LinearLayout;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/widget/TextView;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReorder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reorder.kt\ncom/phisher98/UltimaReorder\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,286:1\n15101#2:287\n3938#2:288\n4474#2,2:289\n15102#2:292\n15101#2:294\n3938#2:295\n4474#2,2:296\n15102#2:298\n1#3:291\n1233#4:293\n1233#4:299\n2068#4,2:300\n2077#4,3:302\n2077#4,3:305\n2077#4,3:308\n*S KotlinDebug\n*F\n+ 1 Reorder.kt\ncom/phisher98/UltimaReorder\n*L\n114#1:287\n115#1:288\n115#1:289,2\n114#1:292\n130#1:294\n131#1:295\n131#1:296,2\n130#1:298\n125#1:293\n134#1:299\n141#1:300,2\n193#1:302,3\n236#1:305,3\n261#1:308,3\n*E\n"})
public final class UltimaReorder {

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

    public UltimaReorder(@NotNull AppCompatActivity activity) throws Exception {
        this.activity = activity;
        UltimaPlugin companion = UltimaPlugin.INSTANCE.getInstance();
        if (companion == null) {
            throw new Exception("Plugin not initialized");
        }
        this.plugin = companion;
        this.sm = UltimaStorageManager.INSTANCE;
        this.extensions = this.sm.fetchExtensions();
        Resources resources = this.plugin.getResources();
        if (resources != null) {
            this.res = resources;
            return;
        }
        throw new Exception("Unable to read resources");
    }

    @NotNull
    public final AppCompatActivity getActivity() {
        return this.activity;
    }

    @NotNull
    public final UltimaPlugin getPlugin() {
        return this.plugin;
    }

    private final View getLayout(String name, LayoutInflater inflater, ViewGroup container) {
        int id = this.res.getIdentifier(name, "layout", "com.phisher98");
        return inflater.inflate((XmlPullParser) this.res.getLayout(id), container, false);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final Drawable getDrawable(String name) throws Exception {
        int id = this.res.getIdentifier(name, "drawable", "com.phisher98");
        Drawable drawable = this.res.getDrawable(id, null);
        if (drawable != null) {
            return drawable;
        }
        throw new Exception("Unable to find drawable " + name);
    }

    private final String getString(String name) {
        int id = this.res.getIdentifier(name, "string", "com.phisher98");
        return this.res.getString(id);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final <T extends View> T findView(View view, String str) {
        return (T) view.findViewById(this.res.getIdentifier(str, "id", "com.phisher98"));
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void makeTvCompatible(View $this$makeTvCompatible) {
        int outlineId = this.res.getIdentifier("outline", "drawable", "com.phisher98");
        $this$makeTvCompatible.setBackground(this.res.getDrawable(outlineId, null));
    }

    public final void show() {
        this.dialog = new BottomSheetDialog(this.activity);
        LayoutInflater inflater = LayoutInflater.from(this.activity);
        BottomSheetDialog bottomSheetDialog = null;
        View root = getLayout("reorder", inflater, null);
        ImageView saveBtn = (ImageView) findView(root, "save");
        saveBtn.setImageDrawable(getDrawable("save_icon"));
        makeTvCompatible(saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaReorder$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UltimaReorder ultimaReorder = this.f$0;
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ultimaReorder.activity), (CoroutineContext) null, (CoroutineStart) null, new UltimaReorder$show$1$1(ultimaReorder, null), 3, (Object) null);
            }
        });
        TextView noSectionWarning = (TextView) findView(root, "no_section_warning");
        LinearLayout sectionsListView = (LinearLayout) findView(root, "section_list");
        updateSectionList$default(this, sectionsListView, inflater, null, noSectionWarning, null, null, null, 112, null);
        BottomSheetDialog bottomSheetDialog2 = this.dialog;
        if (bottomSheetDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog2 = null;
        }
        bottomSheetDialog2.setContentView(root);
        BottomSheetDialog bottomSheetDialog3 = this.dialog;
        if (bottomSheetDialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog3 = null;
        }
        bottomSheetDialog3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.phisher98.UltimaReorder$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                UltimaReorder.show$lambda$1(this.f$0, dialogInterface);
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

    static final void show$lambda$1(UltimaReorder this$0, DialogInterface it) {
        if (!this$0.activity.isFinishing() && !this$0.activity.isDestroyed()) {
            UltimaSettings settingsDialog = new UltimaSettings(this$0.activity);
            settingsDialog.show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void updateSectionList$default(UltimaReorder ultimaReorder, LinearLayout linearLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, TextView textView, List list, Integer num, String str, int i, Object obj) {
        if ((i & 8) != 0) {
            textView = null;
        }
        if ((i & 16) != 0) {
            list = null;
        }
        if ((i & 32) != 0) {
            num = null;
        }
        if ((i & 64) != 0) {
            str = null;
        }
        ultimaReorder.updateSectionList(linearLayout, layoutInflater, viewGroup, textView, list, num, str);
    }

    private final void updateSectionList(final LinearLayout sectionsListView, final LayoutInflater inflater, final ViewGroup container, TextView noSectionWarning, List<UltimaUtils.SectionInfo> currentSections, Integer focusingSection, String focusOn) {
        List<UltimaUtils.SectionInfo> listEmptyList;
        int counter;
        List freshSections;
        Collection destination$iv$iv;
        final UltimaReorder ultimaReorder = this;
        final TextView textView = noSectionWarning;
        sectionsListView.removeAllViews();
        if (currentSections == null) {
            UltimaReorder $this$updateSectionList_u24lambda_u240 = ultimaReorder;
            int i = 0;
            listEmptyList = CollectionsKt.emptyList();
            UltimaUtils.ExtensionInfo[] extensionInfoArr = $this$updateSectionList_u24lambda_u240.extensions;
            int length = extensionInfoArr.length;
            int i2 = 0;
            while (i2 < length) {
                UltimaUtils.SectionInfo[] sections = extensionInfoArr[i2].getSections();
                if (sections != null) {
                    Collection destination$iv$iv2 = new ArrayList();
                    int length2 = sections.length;
                    int i3 = 0;
                    while (i3 < length2) {
                        int i4 = length2;
                        UltimaUtils.SectionInfo sectionInfo = sections[i3];
                        if (sectionInfo.getEnabled()) {
                            destination$iv$iv2.add(sectionInfo);
                        }
                        i3++;
                        length2 = i4;
                    }
                    List it = (List) destination$iv$iv2;
                    listEmptyList = CollectionsKt.plus(listEmptyList, it);
                }
                i2++;
                $this$updateSectionList_u24lambda_u240 = $this$updateSectionList_u24lambda_u240;
                i = i;
            }
        } else {
            listEmptyList = currentSections;
        }
        List<UltimaUtils.SectionInfo> list = listEmptyList;
        if (list.isEmpty()) {
            if (textView != null) {
                textView.setVisibility(0);
                return;
            }
            return;
        }
        List<UltimaUtils.SectionInfo> $this$sortedByDescending$iv = list;
        int counter2 = CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: com.phisher98.UltimaReorder$updateSectionList$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                UltimaUtils.SectionInfo it2 = (UltimaUtils.SectionInfo) t2;
                UltimaUtils.SectionInfo it3 = (UltimaUtils.SectionInfo) t;
                return ComparisonsKt.compareValues(Integer.valueOf(it2.getPriority()), Integer.valueOf(it3.getPriority()));
            }
        }).size();
        if (currentSections == null) {
            UltimaReorder $this$updateSectionList_u24lambda_u242 = ultimaReorder;
            freshSections = CollectionsKt.toMutableList(CollectionsKt.emptyList());
            UltimaUtils.ExtensionInfo[] extensionInfoArr2 = $this$updateSectionList_u24lambda_u242.extensions;
            int length3 = extensionInfoArr2.length;
            int i5 = 0;
            while (i5 < length3) {
                UltimaUtils.SectionInfo[] sections2 = extensionInfoArr2[i5].getSections();
                if (sections2 != null) {
                    Collection destination$iv$iv3 = new ArrayList();
                    Collection destination$iv$iv4 = destination$iv$iv3;
                    int i6 = 0;
                    for (int length4 = sections2.length; i6 < length4; length4 = length4) {
                        int i7 = i6;
                        UltimaUtils.SectionInfo sectionInfo2 = sections2[i7];
                        if (sectionInfo2.getEnabled()) {
                            destination$iv$iv = destination$iv$iv4;
                            destination$iv$iv.add(sectionInfo2);
                        } else {
                            destination$iv$iv = destination$iv$iv4;
                        }
                        i6 = i7 + 1;
                        destination$iv$iv4 = destination$iv$iv;
                    }
                    List it2 = (List) destination$iv$iv4;
                    CollectionsKt.addAll(freshSections, it2);
                }
                i5++;
                $this$updateSectionList_u24lambda_u242 = $this$updateSectionList_u24lambda_u242;
                counter2 = counter2;
            }
            counter = counter2;
        } else {
            counter = counter2;
            freshSections = currentSections;
        }
        List $this$sortedByDescending$iv2 = freshSections;
        final List displaySections = CollectionsKt.sortedWith($this$sortedByDescending$iv2, new Comparator() { // from class: com.phisher98.UltimaReorder$updateSectionList$$inlined$sortedByDescending$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                UltimaUtils.SectionInfo it3 = (UltimaUtils.SectionInfo) t2;
                UltimaUtils.SectionInfo it4 = (UltimaUtils.SectionInfo) t;
                return ComparisonsKt.compareValues(Integer.valueOf(it3.getPriority()), Integer.valueOf(it4.getPriority()));
            }
        });
        if (displaySections.isEmpty()) {
            if (textView != null) {
                textView.setVisibility(0);
                return;
            }
            return;
        }
        List $this$forEach$iv = displaySections;
        int counter3 = counter;
        for (Object element$iv : $this$forEach$iv) {
            final UltimaUtils.SectionInfo section = (UltimaUtils.SectionInfo) element$iv;
            View sectionView = ultimaReorder.getLayout("list_section_reorder_item", inflater, container);
            TextView sectionName = (TextView) ultimaReorder.findView(sectionView, "section_name");
            if (section.getPriority() == 0) {
                section.setPriority(counter3);
            }
            final List displaySections2 = displaySections;
            sectionName.setText(section.getPluginName() + ": " + section.getName());
            Drawable[] drawableArr = new Drawable[2];
            drawableArr[0] = new ColorDrawable(Intrinsics.areEqual(section, ReorderKt.selectedSection) ? 570490624 : 0);
            drawableArr[1] = ultimaReorder.getDrawable("outline");
            sectionView.setBackground(new LayerDrawable(drawableArr));
            final TextView textView2 = textView;
            final UltimaReorder ultimaReorder2 = ultimaReorder;
            displaySections = displaySections2;
            sectionView.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaReorder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UltimaReorder.updateSectionList$lambda$4$0(section, ultimaReorder2, sectionsListView, inflater, container, textView2, displaySections2, view);
                }
            });
            final ImageView increaseBtn = (ImageView) ultimaReorder2.findView(sectionView, "increase");
            final ImageView decreaseBtn = (ImageView) ultimaReorder2.findView(sectionView, "decrease");
            increaseBtn.setImageDrawable(ultimaReorder2.getDrawable("triangle"));
            decreaseBtn.setImageDrawable(ultimaReorder2.getDrawable("triangle"));
            decreaseBtn.setRotation(180.0f);
            ultimaReorder2.makeTvCompatible(increaseBtn);
            ultimaReorder2.makeTvCompatible(decreaseBtn);
            textView = noSectionWarning;
            increaseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaReorder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UltimaReorder.updateSectionList$lambda$4$1(displaySections, section, increaseBtn, ultimaReorder2, sectionsListView, inflater, container, textView, view);
                }
            });
            ultimaReorder = this;
            decreaseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaReorder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UltimaReorder.updateSectionList$lambda$4$2(displaySections, section, decreaseBtn, ultimaReorder, sectionsListView, inflater, container, textView, view);
                }
            });
            counter3--;
            sectionsListView.addView(sectionView);
            list = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSectionList$lambda$4$0(final UltimaUtils.SectionInfo $section, final UltimaReorder this$0, LinearLayout $sectionsListView, LayoutInflater $inflater, ViewGroup $container, TextView $noSectionWarning, List $displaySections, View it) {
        final LinearLayout linearLayout;
        UltimaUtils.SectionInfo sectionInfo = ReorderKt.selectedSection;
        if (sectionInfo == null) {
            ReorderKt.selectedSection = $section;
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Picked! Now tap a target.", (Integer) null, 2, (Object) null);
            linearLayout = $sectionsListView;
            updateSectionList$default(this$0, linearLayout, $inflater, $container, $noSectionWarning, $displaySections, null, null, 96, null);
        } else if (Intrinsics.areEqual(sectionInfo, $section)) {
            ReorderKt.selectedSection = null;
            linearLayout = $sectionsListView;
            updateSectionList$default(this$0, linearLayout, $inflater, $container, $noSectionWarning, $displaySections, null, null, 96, null);
        } else {
            UltimaUtils.SectionInfo selected = ReorderKt.selectedSection;
            Intrinsics.checkNotNull(selected);
            List sectionsMutable = CollectionsKt.toMutableList($displaySections);
            int selectedIndex = sectionsMutable.indexOf(selected);
            int targetIndex = sectionsMutable.indexOf($section);
            if (selectedIndex == targetIndex) {
                CommonActivity.showToast$default(CommonActivity.INSTANCE, "Already in this position", (Integer) null, 2, (Object) null);
                return;
            }
            sectionsMutable.remove(selectedIndex);
            sectionsMutable.add(targetIndex, selected);
            List $this$forEachIndexed$iv = sectionsMutable;
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                UltimaUtils.SectionInfo sec = (UltimaUtils.SectionInfo) item$iv;
                sec.setPriority(sectionsMutable.size() - index);
                index = index$iv;
            }
            ReorderKt.selectedSection = null;
            linearLayout = $sectionsListView;
            updateSectionList$default(this$0, linearLayout, $inflater, $container, $noSectionWarning, sectionsMutable, null, null, 96, null);
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Section moved to position " + (targetIndex + 1), (Integer) null, 2, (Object) null);
        }
        linearLayout.post(new Runnable() { // from class: com.phisher98.UltimaReorder$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                UltimaReorder.updateSectionList$lambda$4$0$1(linearLayout, this$0, $section);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSectionList$lambda$4$0$1(LinearLayout $sectionsListView, UltimaReorder this$0, UltimaUtils.SectionInfo $section) {
        int childCount = $sectionsListView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = $sectionsListView.getChildAt(i);
            TextView nameView = (TextView) this$0.findView(child, "section_name");
            if (StringsKt.contains(nameView.getText(), $section.getName(), true)) {
                child.requestFocus();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSectionList$lambda$4$1(List $displaySections, final UltimaUtils.SectionInfo $section, ImageView $increaseBtn, final UltimaReorder this$0, final LinearLayout $sectionsListView, LayoutInflater $inflater, ViewGroup $container, TextView $noSectionWarning, View it) {
        int idx = $displaySections.indexOf($section);
        if (idx > 0) {
            List newList = CollectionsKt.toMutableList($displaySections);
            newList.remove(idx);
            newList.add(idx - 1, $section);
            List $this$forEachIndexed$iv = newList;
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                UltimaUtils.SectionInfo sec = (UltimaUtils.SectionInfo) item$iv;
                sec.setPriority(newList.size() - index);
                index = index$iv;
            }
            $increaseBtn.setContentDescription("Move " + $section.getName() + " up");
            updateSectionList$default(this$0, $sectionsListView, $inflater, $container, $noSectionWarning, newList, null, null, 96, null);
            $sectionsListView.post(new Runnable() { // from class: com.phisher98.UltimaReorder$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    UltimaReorder.updateSectionList$lambda$4$1$1($sectionsListView, this$0, $section);
                }
            });
            return;
        }
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Already at the top", (Integer) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSectionList$lambda$4$1$1(LinearLayout $sectionsListView, UltimaReorder this$0, UltimaUtils.SectionInfo $section) {
        int childCount = $sectionsListView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = $sectionsListView.getChildAt(i);
            TextView nameView = (TextView) this$0.findView(child, "section_name");
            if (StringsKt.contains(nameView.getText(), $section.getName(), true)) {
                ((ImageView) this$0.findView(child, "increase")).requestFocus();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSectionList$lambda$4$2(List $displaySections, final UltimaUtils.SectionInfo $section, ImageView $decreaseBtn, final UltimaReorder this$0, final LinearLayout $sectionsListView, LayoutInflater $inflater, ViewGroup $container, TextView $noSectionWarning, View it) {
        int idx = $displaySections.indexOf($section);
        if (idx < CollectionsKt.getLastIndex($displaySections)) {
            List newList = CollectionsKt.toMutableList($displaySections);
            newList.remove(idx);
            newList.add(idx + 1, $section);
            List $this$forEachIndexed$iv = newList;
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                UltimaUtils.SectionInfo sec = (UltimaUtils.SectionInfo) item$iv;
                sec.setPriority(newList.size() - index);
                index = index$iv;
            }
            $decreaseBtn.setContentDescription("Move " + $section.getName() + " down");
            updateSectionList$default(this$0, $sectionsListView, $inflater, $container, $noSectionWarning, newList, null, null, 96, null);
            $sectionsListView.post(new Runnable() { // from class: com.phisher98.UltimaReorder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    UltimaReorder.updateSectionList$lambda$4$2$1($sectionsListView, this$0, $section);
                }
            });
            return;
        }
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Already at the bottom", (Integer) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSectionList$lambda$4$2$1(LinearLayout $sectionsListView, UltimaReorder this$0, UltimaUtils.SectionInfo $section) {
        int childCount = $sectionsListView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = $sectionsListView.getChildAt(i);
            TextView nameView = (TextView) this$0.findView(child, "section_name");
            if (StringsKt.contains(nameView.getText(), $section.getName(), true)) {
                ((ImageView) this$0.findView(child, "decrease")).requestFocus();
                return;
            }
        }
    }
}
