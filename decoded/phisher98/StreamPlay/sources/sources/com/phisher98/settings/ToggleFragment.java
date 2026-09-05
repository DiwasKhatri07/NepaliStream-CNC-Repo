package com.phisher98.settings;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import androidx.fragment.app.DialogFragment;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.MainAPI;
import com.phisher98.StreamPlay;
import com.phisher98.StreamPlayAnime;
import com.phisher98.StreamPlayPlugin;
import com.phisher98.StreamPlayStremioCatelog;
import com.phisher98.StreamPlayStremioCatelogFrag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: ToggleFragment.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\bH\u0016J4\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003b\u0010\b\u0016\u0012\f\b\u0017\u0012\b\b\fJ\u0004\b\b(\u0018J\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003b\u0010\b\u0016\u0012\f\b\u0017\u0012\b\b\fJ\u0004\b\b(\u001bJ#\u0010\u001c\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u000f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u001eJ\f\u0010\u001f\u001a\u00020\b*\u00020\u000fH\u0002J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J6\u0010#\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010$\u001a\u0004\u0018\u00010%H\u0017b\u0010\b\u0016\u0012\f\b\u0017\u0012\b\b\fJ\u0004\b\b(&J\u0010\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020)H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/phisher98/settings/ToggleFragment;", "Landroidx/fragment/app/DialogFragment;", "plugin", "Lcom/phisher98/StreamPlayPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "onDismissCallback", "Lkotlin/Function0;", "", "<init>", "(Lcom/phisher98/StreamPlayPlugin;Landroid/content/SharedPreferences;Lkotlin/jvm/functions/Function0;)V", "onStart", "res", "Landroid/content/res/Resources;", "getLayout", "Landroid/view/View;", "name", "", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Landroid/annotation/SuppressLint;", "value", "DiscouragedApi", "getDrawable", "Landroid/graphics/drawable/Drawable;", "UseCompatLoadingForDrawables", "findView", "T", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "makeTvCompatible", "loadStremioLinks", "", "Lcom/phisher98/StreamPlayStremioCatelogFrag$LinkItem;", "onCreateView", "savedInstanceState", "Landroid/os/Bundle;", "UseSwitchCompatOrMaterialCode", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nToggleFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ToggleFragment.kt\ncom/phisher98/settings/ToggleFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,189:1\n2068#2,2:190\n1739#2:192\n1814#2,3:193\n40#3,11:196\n*S KotlinDebug\n*F\n+ 1 ToggleFragment.kt\ncom/phisher98/settings/ToggleFragment\n*L\n116#1:190,2\n130#1:192\n130#1:193,3\n173#1:196,11\n*E\n"})
public final class ToggleFragment extends DialogFragment {

    @Nullable
    private final Function0<Unit> onDismissCallback;

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public ToggleFragment(@NotNull StreamPlayPlugin plugin, @NotNull SharedPreferences sharedPref, @Nullable Function0<Unit> function0) throws Exception {
        this.sharedPref = sharedPref;
        this.onDismissCallback = function0;
        Resources resources = plugin.getResources();
        if (resources != null) {
            this.res = resources;
            return;
        }
        throw new Exception("Unable to access plugin resources");
    }

    public /* synthetic */ ToggleFragment(StreamPlayPlugin streamPlayPlugin, SharedPreferences sharedPreferences, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(streamPlayPlugin, sharedPreferences, (i & 4) != 0 ? null : function0);
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

    @SuppressLint({"DiscouragedApi"})
    private final View getLayout(String name, LayoutInflater inflater, ViewGroup container) throws Exception {
        int id = this.res.getIdentifier(name, "layout", "com.phisher98");
        if (id == 0) {
            throw new Exception("Layout " + name + " not found.");
        }
        XmlResourceParser layout = this.res.getLayout(id);
        return inflater.inflate((XmlPullParser) layout, container, false);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final Drawable getDrawable(String name) {
        int id = this.res.getIdentifier(name, "drawable", "com.phisher98");
        Drawable drawable = this.res.getDrawable(id, null);
        if (drawable != null) {
            return drawable;
        }
        throw new Resources.NotFoundException("Drawable " + name + " not found.");
    }

    private final <T extends View> T findView(View view, String str) {
        int identifier = this.res.getIdentifier(str, "id", "com.phisher98");
        if (identifier == 0) {
            throw new Resources.NotFoundException("View ID " + str + " not found.");
        }
        return (T) view.findViewById(identifier);
    }

    private final void makeTvCompatible(View $this$makeTvCompatible) {
        int outlineId = this.res.getIdentifier("outline", "drawable", "com.phisher98");
        $this$makeTvCompatible.setBackground(this.res.getDrawable(outlineId, null));
    }

    private final List<StreamPlayStremioCatelogFrag.LinkItem> loadStremioLinks() {
        String json = this.sharedPref.getString("streamplay_stremio_saved_links", null);
        if (json == null) {
            return CollectionsKt.emptyList();
        }
        List list = new ArrayList();
        try {
            JSONArray arr = new JSONArray(json);
            int length = arr.length();
            for (int i = 0; i < length; i++) {
                JSONObject obj = arr.getJSONObject(i);
                list.add(new StreamPlayStremioCatelogFrag.LinkItem(obj.optLong("id", System.currentTimeMillis()), obj.optString("name", ""), obj.optString("link", ""), obj.optString("type", "StremioC")));
            }
            return list;
        } catch (Exception e) {
            return CollectionsKt.emptyList();
        }
    }

    @SuppressLint({"UseSwitchCompatOrMaterialCode"})
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) throws Exception {
        List list;
        Set currentSet;
        View root = getLayout("fragment_toggle_extensions", inflater, container);
        int drawableId = this.res.getIdentifier("dialog_background", "drawable", "com.phisher98");
        if (drawableId != 0) {
            root.setBackground(this.res.getDrawable(drawableId, null));
        }
        final LinearLayout extensionList = (LinearLayout) findView(root, "toggle_list_container");
        List stremioLinks = loadStremioLinks();
        List $this$onCreateView_u24lambda_u240 = CollectionsKt.createListBuilder();
        $this$onCreateView_u24lambda_u240.add(new StreamPlay(this.sharedPref));
        $this$onCreateView_u24lambda_u240.add(new StreamPlayAnime());
        if (stremioLinks.isEmpty()) {
            list = $this$onCreateView_u24lambda_u240;
        } else {
            List $this$forEach$iv = stremioLinks;
            for (Object element$iv : $this$forEach$iv) {
                StreamPlayStremioCatelogFrag.LinkItem link = (StreamPlayStremioCatelogFrag.LinkItem) element$iv;
                $this$onCreateView_u24lambda_u240.add(new StreamPlayStremioCatelog(link.getLink(), link.getName(), this.sharedPref));
                drawableId = drawableId;
                stremioLinks = stremioLinks;
                $this$onCreateView_u24lambda_u240 = $this$onCreateView_u24lambda_u240;
            }
            list = $this$onCreateView_u24lambda_u240;
        }
        List<MainAPI> apis = CollectionsKt.build(list);
        final String savedKey = "enabled_plugins_saved";
        Set<String> stringSet = this.sharedPref.getStringSet("enabled_plugins_saved", null);
        List $this$map$iv = apis;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            MainAPI it = (MainAPI) item$iv$iv;
            destination$iv$iv.add(it.getName());
        }
        Set defaultEnabled = CollectionsKt.toSet((List) destination$iv$iv);
        if (stringSet == null || (currentSet = CollectionsKt.toSet(stringSet)) == null) {
            currentSet = defaultEnabled;
        }
        for (MainAPI api : apis) {
            View toggleItem = getLayout("list_toggle_item", inflater, container);
            final Switch toggleSwitch = (Switch) findView(toggleItem, "toggle_item");
            makeTvCompatible(toggleItem);
            toggleSwitch.setText(api.getName());
            toggleSwitch.setChecked(currentSet.contains(api.getName()));
            makeTvCompatible(toggleSwitch);
            toggleItem.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.ToggleFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Switch r0 = toggleSwitch;
                    r0.setChecked(!r0.isChecked());
                }
            });
            extensionList.addView(toggleItem);
        }
        ImageView saveBtn = (ImageView) findView(root, "saveIcon");
        saveBtn.setImageDrawable(getDrawable("save_icon"));
        makeTvCompatible(saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.ToggleFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToggleFragment.onCreateView$lambda$3(extensionList, this, savedKey, view);
            }
        });
        return root;
    }

    static final void onCreateView$lambda$3(LinearLayout $extensionList, ToggleFragment this$0, String $savedKey, View it) {
        List enabledPluginNames = new ArrayList();
        int childCount = $extensionList.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View toggleItem = $extensionList.getChildAt(i);
            Switch toggleSwitch = (Switch) toggleItem.findViewById(this$0.res.getIdentifier("toggle_item", "id", "com.phisher98"));
            if (toggleSwitch.isChecked()) {
                enabledPluginNames.add(toggleSwitch.getText().toString());
            }
        }
        if (enabledPluginNames.isEmpty()) {
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "At least one extension must stay enabled", (Integer) null, 2, (Object) null);
            return;
        }
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.putStringSet($savedKey, CollectionsKt.toSet(enabledPluginNames));
        editor$iv.commit();
        editor$iv.apply();
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Settings saved", (Integer) null, 2, (Object) null);
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
