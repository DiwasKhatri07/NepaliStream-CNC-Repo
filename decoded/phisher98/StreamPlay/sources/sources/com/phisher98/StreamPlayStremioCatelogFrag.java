package com.phisher98;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.CommonActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: StreamPlayStremioCatelogFrag.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u000201B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0002J#\u0010\u0013\u001a\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u00020\u00152\u0006\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\b*\u00020\u0015H\u0003b\u0010\b\u0018\u0012\f\b\u0019\u0012\b\b\fJ\u0004\b\b(\u001aJ\"\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J6\u0010 \u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0017b\u0010\b\u0018\u0012\f\b\u0019\u0012\b\b\fJ\u0004\b\b(#J\u001a\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020\bH\u0002J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J\u0016\u0010*\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020)0,H\u0002J\u0010\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelogFrag;", "Landroidx/fragment/app/DialogFragment;", "plugin", "Lcom/phisher98/StreamPlayPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "onDismissCallback", "Lkotlin/Function0;", "", "<init>", "(Lcom/phisher98/StreamPlayPlugin;Landroid/content/SharedPreferences;Lkotlin/jvm/functions/Function0;)V", "onStart", "PREF_KEY_LINKS", "", "res", "Landroid/content/res/Resources;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "name", "findView", "T", "Landroid/view/View;", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "makeTvCompatible", "Landroid/annotation/SuppressLint;", "value", "UseCompatLoadingForDrawables", "getLayout", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCreateView", "savedInstanceState", "Landroid/os/Bundle;", "DiscouragedApi", "onViewCreated", "view", "restartApp", "loadLinks", "", "Lcom/phisher98/StreamPlayStremioCatelogFrag$LinkItem;", "saveLinks", "list", "", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "LinkItem", "LinksAdapter", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStreamPlayStremioCatelogFrag.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayStremioCatelogFrag.kt\ncom/phisher98/StreamPlayStremioCatelogFrag\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n+ 4 Uri.kt\nandroidx/core/net/UriKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,345:1\n2068#2,2:346\n40#3,11:348\n29#4:359\n1#5:360\n*S KotlinDebug\n*F\n+ 1 StreamPlayStremioCatelogFrag.kt\ncom/phisher98/StreamPlayStremioCatelogFrag\n*L\n83#1:346,2\n296#1:348,11\n142#1:359\n*E\n"})
public final class StreamPlayStremioCatelogFrag extends DialogFragment {

    @NotNull
    private final String PREF_KEY_LINKS;

    @Nullable
    private final Function0<Unit> onDismissCallback;

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public StreamPlayStremioCatelogFrag(@NotNull StreamPlayPlugin plugin, @NotNull SharedPreferences sharedPref, @Nullable Function0<Unit> function0) throws Exception {
        this.sharedPref = sharedPref;
        this.onDismissCallback = function0;
        this.PREF_KEY_LINKS = "streamplay_stremio_saved_links";
        Resources resources = plugin.getResources();
        if (resources != null) {
            this.res = resources;
            return;
        }
        throw new Exception("Unable to access plugin resources");
    }

    public /* synthetic */ StreamPlayStremioCatelogFrag(StreamPlayPlugin streamPlayPlugin, SharedPreferences sharedPreferences, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    private final Drawable getDrawable(String name) throws Exception {
        int id = this.res.getIdentifier(name, "drawable", "com.phisher98");
        Drawable drawable = this.res.getDrawable(id, null);
        if (drawable != null) {
            return drawable;
        }
        throw new Exception("Drawable " + name + " not found");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends View> T findView(View view, String str) throws Exception {
        int identifier = this.res.getIdentifier(str, "id", "com.phisher98");
        if (identifier == 0) {
            throw new Exception("View ID " + str + " not found.");
        }
        return (T) view.findViewById(identifier);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void makeTvCompatible(View $this$makeTvCompatible) {
        int outlineId = this.res.getIdentifier("outline", "drawable", "com.phisher98");
        $this$makeTvCompatible.setBackground(this.res.getDrawable(outlineId, null));
    }

    private final View getLayout(String name, LayoutInflater inflater, ViewGroup container) {
        int id = this.res.getIdentifier(name, "layout", "com.phisher98");
        XmlResourceParser layout = this.res.getLayout(id);
        return inflater.inflate((XmlPullParser) layout, container, false);
    }

    @SuppressLint({"DiscouragedApi"})
    @NotNull
    public View onCreateView(@NotNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) throws Exception {
        View view = getLayout("stremio_bottom_sheet_layout", inflater, container);
        String str = "com.phisher98";
        int id = this.res.getIdentifier("dialog_background", "drawable", "com.phisher98");
        if (id != 0) {
            view.setBackground(this.res.getDrawable(id, null));
        }
        Iterable $this$forEach$iv = CollectionsKt.listOf(new String[]{"addlinks", "showlinks", "saveIcon"});
        int $i$f$forEach = 0;
        for (Object element$iv : $this$forEach$iv) {
            String name = (String) element$iv;
            int drawableId = id;
            int id2 = this.res.getIdentifier(name, "id", str);
            String str2 = str;
            if (id2 == 0) {
                Log.INSTANCE.w("StreamPlayStremioCatelogFrag", "View id '" + name + "' not found");
            } else {
                Log.INSTANCE.d("StreamPlayStremioCatelogFrag", "View id '" + name + "' -> " + id2);
            }
            id = drawableId;
            str = str2;
            $this$forEach$iv = $this$forEach$iv;
            $i$f$forEach = $i$f$forEach;
        }
        try {
            ImageView addlinks = (ImageView) findView(view, "addlinks");
            try {
                ImageView showlinks = (ImageView) findView(view, "showlinks");
                try {
                    ImageView saveIcon = (ImageView) findView(view, "saveIcon");
                    addlinks.setImageDrawable(getDrawable("settings_icon"));
                    showlinks.setImageDrawable(getDrawable("settings_icon"));
                    saveIcon.setImageDrawable(getDrawable("save_icon"));
                    makeTvCompatible(addlinks);
                    makeTvCompatible(showlinks);
                    makeTvCompatible(saveIcon);
                    addlinks.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.StreamPlayStremioCatelogFrag$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            StreamPlayStremioCatelogFrag.onCreateView$lambda$1(this.f$0, inflater, container, view2);
                        }
                    });
                    showlinks.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.StreamPlayStremioCatelogFrag$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) throws Exception {
                            StreamPlayStremioCatelogFrag.onCreateView$lambda$2(this.f$0, inflater, container, view2);
                        }
                    });
                    saveIcon.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.StreamPlayStremioCatelogFrag$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            StreamPlayStremioCatelogFrag.onCreateView$lambda$3(this.f$0, view2);
                        }
                    });
                    return view;
                } catch (Throwable e) {
                    throw new Exception("saveIcon ImageView not found in bottom_sheet_layout", e);
                }
            } catch (Throwable e2) {
                throw new Exception("showlinks ImageView not found in bottom_sheet_layout", e2);
            }
        } catch (Throwable e3) {
            throw new Exception("addlinks ImageView not found in bottom_sheet_layout", e3);
        }
    }

    static final void onCreateView$lambda$1(final StreamPlayStremioCatelogFrag this$0, LayoutInflater $inflater, ViewGroup $container, View it) {
        View dialogView = this$0.getLayout("streamio_addon_addlinks", $inflater, $container);
        try {
            final EditText etName = (EditText) this$0.findView(dialogView, "etName");
            final EditText etLink = (EditText) this$0.findView(dialogView, "etLink");
            final AlertDialog dlg = new AlertDialog.Builder(this$0.requireContext()).setView(dialogView).setPositiveButton("Save", (DialogInterface.OnClickListener) null).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create();
            dlg.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.phisher98.StreamPlayStremioCatelogFrag$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    StreamPlayStremioCatelogFrag.onCreateView$lambda$1$0(dlg, etName, etLink, this$0, dialogInterface);
                }
            });
            dlg.show();
        } catch (Throwable t) {
            Toast.makeText(this$0.requireContext(), "Dialog fields not found", 0).show();
            Log.INSTANCE.e("SettingsBottomFragment", "Missing dialog views " + t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$0(final AlertDialog $dlg, final EditText $etName, final EditText $etLink, final StreamPlayStremioCatelogFrag this$0, DialogInterface it) {
        Button btnSave = $dlg.getButton(-1);
        btnSave.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.StreamPlayStremioCatelogFrag$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StreamPlayStremioCatelogFrag.onCreateView$lambda$1$0$0($etName, $etLink, this$0, $dlg, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$0$0(EditText $etName, EditText $etLink, StreamPlayStremioCatelogFrag this$0, AlertDialog $dlg, View it) {
        String scheme;
        String name = StringsKt.trim($etName.getText().toString()).toString();
        String link = StringsKt.trim($etLink.getText().toString()).toString();
        String type = "StremioC";
        boolean z = true;
        if (link.length() == 0) {
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Please enter a link", (Integer) null, 2, (Object) null);
            return;
        }
        try {
            Uri uri = Uri.parse(link);
            Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.parse(this)");
            String scheme2 = uri.getScheme();
            if (scheme2 != null) {
                scheme = scheme2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(scheme, "toLowerCase(...)");
            } else {
                scheme = null;
            }
            if (!Intrinsics.areEqual(scheme, "http") && !Intrinsics.areEqual(scheme, "https")) {
                z = false;
            }
        } catch (Exception e) {
            z = false;
        }
        boolean valid = z;
        if (!valid) {
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Enter a valid URL (http/https)", (Integer) null, 2, (Object) null);
            return;
        }
        String str = name;
        if (StringsKt.isBlank(str)) {
            str = link;
        }
        LinkItem item = new LinkItem(0L, str, link, type, 1, null);
        try {
            List<LinkItem> mutableList = CollectionsKt.toMutableList(this$0.loadLinks());
            mutableList.add(0, item);
            try {
                this$0.saveLinks(mutableList);
                Toast.makeText(this$0.requireContext(), "Link saved", 0).show();
                $dlg.dismiss();
            } catch (Throwable th) {
                e = th;
                Log.INSTANCE.e("SettingsBottomFragment", "Failed to save link " + e);
                CommonActivity.showToast$default(CommonActivity.INSTANCE, "Failed to save link", (Integer) null, 2, (Object) null);
            }
        } catch (Throwable th2) {
            e = th2;
        }
    }

    static final void onCreateView$lambda$2(final StreamPlayStremioCatelogFrag this$0, LayoutInflater $inflater, ViewGroup $container, View it) throws Exception {
        View dialogView = this$0.getLayout("stremio_dialog_list_links", $inflater, $container);
        AlertDialog dlg = new AlertDialog.Builder(this$0.requireContext()).setView(dialogView).setPositiveButton("Close", (DialogInterface.OnClickListener) null).create();
        final RecyclerView rv = this$0.findView(dialogView, "rvLinks");
        final TextView tvNoLinks = (TextView) this$0.findView(dialogView, "tvNoLinks");
        List list = CollectionsKt.toMutableList(this$0.loadLinks());
        Log.INSTANCE.d("SettingsBottomFragment", "Loaded " + list.size() + " saved links");
        if (list.isEmpty()) {
            tvNoLinks.setVisibility(0);
            rv.setVisibility(8);
        } else {
            tvNoLinks.setVisibility(8);
            rv.setVisibility(0);
            rv.setLayoutManager(new LinearLayoutManager(this$0.requireContext()));
            LinksAdapter adapter = this$0.new LinksAdapter(list, new Function1() { // from class: com.phisher98.StreamPlayStremioCatelogFrag$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    return StreamPlayStremioCatelogFrag.onCreateView$lambda$2$0(this.f$0, rv, tvNoLinks, (StreamPlayStremioCatelogFrag.LinkItem) obj);
                }
            });
            rv.setAdapter(adapter);
        }
        dlg.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$0(StreamPlayStremioCatelogFrag this$0, RecyclerView $rv, TextView $tvNoLinks, final LinkItem itemToDelete) throws JSONException {
        List<LinkItem> mutableList = CollectionsKt.toMutableList(this$0.loadLinks());
        boolean removed = CollectionsKt.removeAll(mutableList, new Function1() { // from class: com.phisher98.StreamPlayStremioCatelogFrag$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StreamPlayStremioCatelogFrag.onCreateView$lambda$2$0$0(itemToDelete, (StreamPlayStremioCatelogFrag.LinkItem) obj));
            }
        });
        if (removed) {
            this$0.saveLinks(mutableList);
            RecyclerView.Adapter adapter = $rv.getAdapter();
            LinksAdapter linksAdapter = adapter instanceof LinksAdapter ? (LinksAdapter) adapter : null;
            if (linksAdapter != null) {
                linksAdapter.remove(itemToDelete);
            }
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Deleted", (Integer) null, 2, (Object) null);
            if (mutableList.isEmpty()) {
                $tvNoLinks.setVisibility(0);
                $rv.setVisibility(8);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$2$0$0(LinkItem $itemToDelete, LinkItem it) {
        return it.getId() == $itemToDelete.getId();
    }

    static final void onCreateView$lambda$3(final StreamPlayStremioCatelogFrag this$0, View it) {
        Context context = this$0.getContext();
        if (context == null) {
            return;
        }
        new AlertDialog.Builder(context).setTitle("Save & Reload").setMessage("Changes have been saved. Do you want to restart the app to apply them?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.phisher98.StreamPlayStremioCatelogFrag$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                StreamPlayStremioCatelogFrag.onCreateView$lambda$3$0(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton("No", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3$0(StreamPlayStremioCatelogFrag this$0, DialogInterface dialogInterface, int i) {
        this$0.dismiss();
        this$0.restartApp();
    }

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

    /* JADX INFO: compiled from: StreamPlayStremioCatelogFrag.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelogFrag$LinkItem;", "", "id", "", "name", "", "link", "type", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getLink", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LinkItem {
        private final long id;

        @NotNull
        private final String link;

        @NotNull
        private final String name;

        @NotNull
        private final String type;

        public static /* synthetic */ LinkItem copy$default(LinkItem linkItem, long j, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = linkItem.id;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = linkItem.name;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = linkItem.link;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = linkItem.type;
            }
            return linkItem.copy(j2, str4, str5, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final LinkItem copy(long id, @NotNull String name, @NotNull String link, @NotNull String type) {
            return new LinkItem(id, name, link, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkItem)) {
                return false;
            }
            LinkItem linkItem = (LinkItem) other;
            return this.id == linkItem.id && Intrinsics.areEqual(this.name, linkItem.name) && Intrinsics.areEqual(this.link, linkItem.link) && Intrinsics.areEqual(this.type, linkItem.type);
        }

        public int hashCode() {
            return (((((C0266x37150983.m31m(this.id) * 31) + this.name.hashCode()) * 31) + this.link.hashCode()) * 31) + this.type.hashCode();
        }

        @NotNull
        public String toString() {
            return "LinkItem(id=" + this.id + ", name=" + this.name + ", link=" + this.link + ", type=" + this.type + ')';
        }

        public LinkItem(long id, @NotNull String name, @NotNull String link, @NotNull String type) {
            this.id = id;
            this.name = name;
            this.link = link;
            this.type = type;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ LinkItem(long j, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            long jCurrentTimeMillis;
            if ((i & 1) == 0) {
                jCurrentTimeMillis = j;
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            this(jCurrentTimeMillis, str, str2, str3);
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getLink() {
            return this.link;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    private final List<LinkItem> loadLinks() {
        String json = this.sharedPref.getString(this.PREF_KEY_LINKS, null);
        if (json == null) {
            return new ArrayList();
        }
        List list = new ArrayList();
        try {
            JSONArray arr = new JSONArray(json);
            int length = arr.length();
            for (int i = 0; i < length; i++) {
                JSONObject obj = arr.getJSONObject(i);
                list.add(new LinkItem(obj.optLong("id", System.currentTimeMillis()), obj.optString("name", ""), obj.optString("link", ""), obj.optString("type", "StremioX")));
            }
            return list;
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    private final void saveLinks(List<LinkItem> list) throws JSONException {
        JSONArray arr = new JSONArray();
        for (LinkItem item : list) {
            JSONObject obj = new JSONObject();
            obj.put("id", item.getId());
            obj.put("name", item.getName());
            obj.put("link", item.getLink());
            obj.put("type", item.getType());
            arr.put(obj);
        }
        SharedPreferences $this$edit$iv = this.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.putString(this.PREF_KEY_LINKS, arr.toString());
        editor$iv.apply();
    }

    /* JADX INFO: compiled from: StreamPlayStremioCatelogFrag.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0017B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ \u0010\f\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\t2\u000e\u0010\u0012\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelogFrag$LinksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/phisher98/StreamPlayStremioCatelogFrag$LinksAdapter$VH;", "Lcom/phisher98/StreamPlayStremioCatelogFrag;", "items", "", "Lcom/phisher98/StreamPlayStremioCatelogFrag$LinkItem;", "onDelete", "Lkotlin/Function1;", "", "<init>", "(Lcom/phisher98/StreamPlayStremioCatelogFrag;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "remove", "item", "VH", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nStreamPlayStremioCatelogFrag.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayStremioCatelogFrag.kt\ncom/phisher98/StreamPlayStremioCatelogFrag$LinksAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,345:1\n363#2,7:346\n*S KotlinDebug\n*F\n+ 1 StreamPlayStremioCatelogFrag.kt\ncom/phisher98/StreamPlayStremioCatelogFrag$LinksAdapter\n*L\n332#1:346,7\n*E\n"})
    public final class LinksAdapter extends RecyclerView.Adapter<C0268VH> {

        @NotNull
        private final List<LinkItem> items;

        @NotNull
        private final Function1<LinkItem, Unit> onDelete;

        /* JADX WARN: Multi-variable type inference failed */
        public LinksAdapter(@NotNull List<LinkItem> list, Function1<? super LinkItem, Unit> function1) {
            this.items = list;
            this.onDelete = function1;
        }

        /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioCatelogFrag$LinksAdapter$VH */
        /* JADX INFO: compiled from: StreamPlayStremioCatelogFrag.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelogFrag$LinksAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "<init>", "(Lcom/phisher98/StreamPlayStremioCatelogFrag$LinksAdapter;Landroid/view/View;)V", "tvName", "Landroid/widget/TextView;", "getTvName", "()Landroid/widget/TextView;", "tvLink", "getTvLink", "tvType", "getTvType", "btnDelete", "Landroid/widget/ImageButton;", "getBtnDelete", "()Landroid/widget/ImageButton;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public final class C0268VH extends RecyclerView.ViewHolder {

            @NotNull
            private final ImageButton btnDelete;

            @NotNull
            private final TextView tvLink;

            @NotNull
            private final TextView tvName;

            @NotNull
            private final TextView tvType;

            public C0268VH(View v) {
                super(v);
                this.tvName = (TextView) StreamPlayStremioCatelogFrag.this.findView(v, "tvName");
                this.tvLink = (TextView) StreamPlayStremioCatelogFrag.this.findView(v, "tvLink");
                this.tvType = (TextView) StreamPlayStremioCatelogFrag.this.findView(v, "tvType");
                this.btnDelete = (ImageButton) StreamPlayStremioCatelogFrag.this.findView(v, "btnDelete");
            }

            @NotNull
            public final TextView getTvName() {
                return this.tvName;
            }

            @NotNull
            public final TextView getTvLink() {
                return this.tvLink;
            }

            @NotNull
            public final TextView getTvType() {
                return this.tvType;
            }

            @NotNull
            public final ImageButton getBtnDelete() {
                return this.btnDelete;
            }
        }

        @NotNull
        public C0268VH onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            int layoutId = StreamPlayStremioCatelogFrag.this.res.getIdentifier("stremio_item_saved_link", "layout", "com.phisher98");
            View v = StreamPlayStremioCatelogFrag.this.getLayoutInflater().inflate((XmlPullParser) StreamPlayStremioCatelogFrag.this.res.getLayout(layoutId), parent, false);
            return new C0268VH(v);
        }

        public void onBindViewHolder(@NotNull C0268VH holder, int position) {
            final LinkItem item = this.items.get(position);
            holder.getTvName().setText(item.getName());
            holder.getTvLink().setText(item.getLink());
            holder.getTvType().setText(item.getType());
            holder.getBtnDelete().setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.StreamPlayStremioCatelogFrag$LinksAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.onDelete.invoke(item);
                }
            });
        }

        public int getItemCount() {
            return this.items.size();
        }

        public final void remove(@NotNull LinkItem item) {
            int index$iv = 0;
            Iterator<LinkItem> it = this.items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    index$iv = -1;
                    break;
                }
                Object item$iv = it.next();
                LinkItem it2 = (LinkItem) item$iv;
                if (it2.getId() == item.getId()) {
                    break;
                } else {
                    index$iv++;
                }
            }
            if (index$iv >= 0) {
                this.items.remove(index$iv);
                notifyItemRemoved(index$iv);
            }
        }
    }

    public void onDismiss(@NotNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDismissCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
