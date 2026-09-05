package com.phisher98;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import com.lagradost.cloudstream3.CommonActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: ProvidersFragment.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001BB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u001d\u001a\u0002H\u001e\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u00020\u001f2\u0006\u0010 \u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010!J\"\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001aH\u0003b\u0010\b$\u0012\f\b%\u0012\b\b\fJ\u0004\b\b(&J\u001e\u0010'\u001a\u00020\b*\u00020\u001fH\u0003b\u0010\b$\u0012\f\b%\u0012\b\b\fJ\u0004\b\b(&J\"\u0010(\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\b\u0010\u0014\u001a\u0004\u0018\u00010+H\u0002J$\u0010,\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\b\u0010\u0014\u001a\u0004\u0018\u00010+2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\bH\u0016J\u001a\u00100\u001a\u00020\bH\u0003b\u0010\b$\u0012\f\b%\u0012\b\b\fJ\u0004\b\b(1J:\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010.H\u0017b\f\b4\u0012\b\b%\u0012\u0004\b\u0003\u00104b\u0010\b$\u0012\f\b%\u0012\b\b\fJ\u0004\b\b(1J\b\u00105\u001a\u00020\bH\u0002J\b\u00106\u001a\u00020\bH\u0002J\u0010\u00107\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001aH\u0002J\u001a\u00108\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0:09H\u0002J\u0010\u0010;\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0010\u0010<\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0010\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u001aH\u0002J\u0010\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020AH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/phisher98/ProvidersFragment;", "Landroidx/fragment/app/DialogFragment;", "plugin", "Lcom/phisher98/StreamPlayPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "onDismissCallback", "Lkotlin/Function0;", "", "<init>", "(Lcom/phisher98/StreamPlayPlugin;Landroid/content/SharedPreferences;Lkotlin/jvm/functions/Function0;)V", "res", "Landroid/content/res/Resources;", "btnSave", "Landroid/widget/ImageButton;", "btnSelectAll", "Landroid/widget/Button;", "btnDeselectAll", "adapter", "Lcom/phisher98/ProvidersFragment$ProviderAdapter;", "container", "Landroid/widget/LinearLayout;", "providers", "", "Lcom/phisher98/Provider;", "PREFS_DISABLED", "", "tvProviderCount", "Landroid/widget/TextView;", "findView", "T", "Landroid/view/View;", "name", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "Landroid/annotation/SuppressLint;", "value", "UseCompatLoadingForDrawables", "makeTvCompatible", "getLayout", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "onCreateView", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "updateProviderCount", "SetTextI18n", "onViewCreated", "view", "Landroidx/annotation/RequiresApi;", "updateUI", "dismissFragment", "saveProfile", "getAllProfiles", "", "", "loadProfile", "deleteProfile", "showMessage", "msg", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "ProviderAdapter", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nProvidersFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProvidersFragment.kt\ncom/phisher98/ProvidersFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 4 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n+ 5 View.kt\nandroidx/core/view/ViewKt\n+ 6 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 7 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,373:1\n1987#2,4:374\n1221#2:378\n2068#2,2:392\n2068#2,2:405\n71#3,10:379\n93#3,3:389\n40#4,11:394\n40#4,11:407\n40#4,11:418\n40#4,11:430\n40#4,11:447\n251#5:429\n50#6:441\n50#6:444\n37#7,2:442\n37#7,2:445\n*S KotlinDebug\n*F\n+ 1 ProvidersFragment.kt\ncom/phisher98/ProvidersFragment\n*L\n93#1:374,4\n115#1:378\n157#1:392,2\n322#1:405,2\n120#1:379,10\n120#1:389,3\n314#1:394,11\n341#1:407,11\n356#1:418,11\n149#1:430,11\n343#1:447,11\n137#1:429\n177#1:441\n262#1:444\n232#1:442,2\n248#1:445,2\n*E\n"})
public final class ProvidersFragment extends DialogFragment {

    @NotNull
    private final String PREFS_DISABLED;
    private ProviderAdapter adapter;
    private Button btnDeselectAll;
    private ImageButton btnSave;
    private Button btnSelectAll;
    private LinearLayout container;

    @Nullable
    private final Function0<Unit> onDismissCallback;

    @NotNull
    private final StreamPlayPlugin plugin;

    @NotNull
    private List<Provider> providers;

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;
    private TextView tvProviderCount;

    public ProvidersFragment(@NotNull StreamPlayPlugin plugin, @NotNull SharedPreferences sharedPref, @Nullable Function0<Unit> function0) throws Exception {
        this.plugin = plugin;
        this.sharedPref = sharedPref;
        this.onDismissCallback = function0;
        Resources resources = this.plugin.getResources();
        if (resources == null) {
            throw new Exception("Unable to access plugin resources");
        }
        this.res = resources;
        this.providers = CollectionsKt.emptyList();
        this.PREFS_DISABLED = "disabled_providers";
    }

    public /* synthetic */ ProvidersFragment(StreamPlayPlugin streamPlayPlugin, SharedPreferences sharedPreferences, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(streamPlayPlugin, sharedPreferences, (i & 4) != 0 ? null : function0);
    }

    private final <T extends View> T findView(View view, String str) throws Exception {
        int identifier = this.res.getIdentifier(str, "id", "com.phisher98");
        if (identifier == 0) {
            throw new Exception("View ID " + str + " not found.");
        }
        return (T) view.findViewById(identifier);
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

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayout("fragment_providers", inflater, container);
        int drawableId = this.res.getIdentifier("dialog_background", "drawable", "com.phisher98");
        if (drawableId != 0) {
            view.setBackground(this.res.getDrawable(drawableId, null));
        }
        return view;
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

    @SuppressLint({"SetTextI18n"})
    private final void updateProviderCount() {
        int count$iv;
        Iterable $this$count$iv = this.providers;
        TextView textView = null;
        if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
            count$iv = 0;
        } else {
            count$iv = 0;
            for (Object element$iv : $this$count$iv) {
                Provider it = (Provider) element$iv;
                ProviderAdapter providerAdapter = this.adapter;
                if (providerAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    providerAdapter = null;
                }
                if (!providerAdapter.isDisabled(it.getId()) && (count$iv = count$iv + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        int total = this.providers.size();
        TextView textView2 = this.tvProviderCount;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvProviderCount");
        } else {
            textView = textView2;
        }
        textView.setText(count$iv + " / " + total + " enabled");
    }

    @RequiresApi(26)
    @SuppressLint({"SetTextI18n"})
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        ImageButton imageButton;
        super.onViewCreated(view, savedInstanceState);
        this.tvProviderCount = (TextView) findView(view, "tv_provider_count");
        this.btnSave = (ImageButton) findView(view, "btn_save");
        ImageButton imageButton2 = this.btnSave;
        String str = "btnSave";
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSave");
            imageButton2 = null;
        }
        imageButton2.setImageDrawable(getDrawable("save_icon"));
        ImageButton imageButton3 = this.btnSave;
        if (imageButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSave");
            imageButton3 = null;
        }
        makeTvCompatible(imageButton3);
        this.btnSelectAll = (Button) findView(view, "btn_select_all");
        this.btnDeselectAll = (Button) findView(view, "btn_deselect_all");
        Button button = this.btnSelectAll;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSelectAll");
            button = null;
        }
        button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1F6FEB")));
        Button button2 = this.btnSelectAll;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSelectAll");
            button2 = null;
        }
        button2.setTextColor(-1);
        Button button3 = this.btnDeselectAll;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDeselectAll");
            button3 = null;
        }
        button3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#BB2D3B")));
        Button button4 = this.btnDeselectAll;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDeselectAll");
            button4 = null;
        }
        button4.setTextColor(-1);
        this.container = (LinearLayout) findView(view, "list_container");
        LinearLayout linearLayout = this.container;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            linearLayout = null;
        }
        makeTvCompatible(linearLayout);
        Iterable $this$sortedBy$iv = ProvidersListKt.buildProviders();
        this.providers = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.phisher98.ProvidersFragment$onViewCreated$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Provider it = (Provider) t;
                String lowerCase = it.getName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                Provider it2 = (Provider) t2;
                String lowerCase2 = it2.getName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                return ComparisonsKt.compareValues(lowerCase, lowerCase2);
            }
        });
        EditText etSearch = (EditText) findView(view, "ext_search");
        EditText $this$addTextChangedListener$iv = etSearch;
        $this$addTextChangedListener$iv.addTextChangedListener(new TextWatcher() { // from class: com.phisher98.ProvidersFragment$onViewCreated$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s) {
                String lowerCase = String.valueOf(s).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String query = StringsKt.trim(lowerCase).toString();
                int chkId = this.this$0.res.getIdentifier("chk_provider", "id", "com.phisher98");
                LinearLayout linearLayout2 = this.this$0.container;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("container");
                    linearLayout2 = null;
                }
                int childCount = linearLayout2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    LinearLayout linearLayout3 = this.this$0.container;
                    if (linearLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("container");
                        linearLayout3 = null;
                    }
                    View item = linearLayout3.getChildAt(i);
                    CheckBox chk = (CheckBox) item.findViewById(chkId);
                    int i2 = 0;
                    if (!(query.length() == 0)) {
                        String lowerCase2 = chk.getText().toString().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        if (!StringsKt.contains$default(lowerCase2, query, false, 2, (Object) null)) {
                            i2 = 8;
                        }
                    }
                    item.setVisibility(i2);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            }
        });
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return ProvidersFragment.onViewCreated$lambda$2(this.f$0, textView, i, keyEvent);
            }
        });
        Set<String> stringSet = this.sharedPref.getStringSet(this.PREFS_DISABLED, SetsKt.emptySet());
        if (stringSet == null) {
            stringSet = SetsKt.emptySet();
        }
        this.adapter = new ProviderAdapter(this.providers, stringSet, new Function1() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return ProvidersFragment.onViewCreated$lambda$3(this.f$0, (Set) obj);
            }
        });
        int chkId = this.res.getIdentifier("chk_provider", "id", "com.phisher98");
        Iterable $this$forEach$iv = this.providers;
        for (Object element$iv : $this$forEach$iv) {
            final Provider provider = (Provider) element$iv;
            LayoutInflater layoutInflater = getLayoutInflater();
            LinearLayout linearLayout2 = this.container;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("container");
                linearLayout2 = null;
            }
            EditText etSearch2 = etSearch;
            View item = getLayout("item_provider_checkbox", layoutInflater, linearLayout2);
            final CheckBox chk = (CheckBox) item.findViewById(chkId);
            makeTvCompatible(item);
            makeTvCompatible(chk);
            chk.setText(provider.getName());
            ProviderAdapter providerAdapter = this.adapter;
            if (providerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                providerAdapter = null;
            }
            String str2 = str;
            chk.setChecked(!providerAdapter.isDisabled(provider.getId()));
            item.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    chk.toggle();
                }
            });
            chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda5
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ProvidersFragment.onViewCreated$lambda$4$1(this.f$0, provider, compoundButton, z);
                }
            });
            LinearLayout linearLayout3 = this.container;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("container");
                linearLayout3 = null;
            }
            linearLayout3.addView(item);
            updateProviderCount();
            etSearch = etSearch2;
            str = str2;
        }
        String str3 = str;
        LinearLayout linearLayout4 = this.container;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            linearLayout4 = null;
        }
        linearLayout4.post(new Runnable() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                ProvidersFragment.onViewCreated$lambda$5(this.f$0);
            }
        });
        Button button5 = this.btnSelectAll;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSelectAll");
            button5 = null;
        }
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProvidersFragment.onViewCreated$lambda$6(this.f$0, view2);
            }
        });
        Button button6 = this.btnDeselectAll;
        if (button6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDeselectAll");
            button6 = null;
        }
        button6.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProvidersFragment.onViewCreated$lambda$7(this.f$0, view2);
            }
        });
        ImageButton imageButton4 = this.btnSave;
        if (imageButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str3);
            imageButton = null;
        } else {
            imageButton = imageButton4;
        }
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.dismissFragment();
            }
        });
        Button btnSaveProfile = (Button) findView(view, "btn_save_profile");
        Button btnLoadProfile = (Button) findView(view, "btn_load_profile");
        Button btnDeleteProfile = (Button) findView(view, "btn_delete_profile");
        btnSaveProfile.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E88E5")));
        btnSaveProfile.setTextColor(-1);
        btnLoadProfile.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2E7D32")));
        btnLoadProfile.setTextColor(-1);
        btnDeleteProfile.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C62828")));
        btnDeleteProfile.setTextColor(-1);
        btnSaveProfile.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProvidersFragment.onViewCreated$lambda$9(this.f$0, view2);
            }
        });
        btnLoadProfile.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProvidersFragment.onViewCreated$lambda$10(this.f$0, view2);
            }
        });
        btnDeleteProfile.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProvidersFragment.onViewCreated$lambda$11(this.f$0, view2);
            }
        });
    }

    static final boolean onViewCreated$lambda$2(ProvidersFragment this$0, TextView textView, int i, KeyEvent keyEvent) {
        LinearLayout linearLayout = this$0.container;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            linearLayout = null;
        }
        int childCount = linearLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            LinearLayout linearLayout2 = this$0.container;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("container");
                linearLayout2 = null;
            }
            View item = linearLayout2.getChildAt(i2);
            if (item.getVisibility() == 0) {
                item.requestFocus();
                break;
            }
        }
        return true;
    }

    static final Unit onViewCreated$lambda$3(ProvidersFragment this$0, Set disabled) {
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.putStringSet(this$0.PREFS_DISABLED, disabled);
        editor$iv.apply();
        this$0.updateUI();
        this$0.updateProviderCount();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4$1(ProvidersFragment this$0, Provider $provider, CompoundButton compoundButton, boolean isChecked) {
        ProviderAdapter providerAdapter = this$0.adapter;
        if (providerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            providerAdapter = null;
        }
        providerAdapter.setDisabled($provider.getId(), !isChecked);
    }

    static final void onViewCreated$lambda$5(ProvidersFragment this$0) {
        ViewGroup viewGroup = this$0.container;
        ImageButton imageButton = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            viewGroup = null;
        }
        ViewGroup $this$isNotEmpty$iv = viewGroup;
        if ($this$isNotEmpty$iv.getChildCount() != 0) {
            LinearLayout linearLayout = this$0.container;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("container");
                linearLayout = null;
            }
            View firstItem = linearLayout.getChildAt(0);
            firstItem.setFocusable(true);
            firstItem.requestFocusFromTouch();
            ImageButton imageButton2 = this$0.btnSave;
            if (imageButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnSave");
            } else {
                imageButton = imageButton2;
            }
            firstItem.setNextFocusUpId(imageButton.getId());
        }
    }

    static final void onViewCreated$lambda$6(ProvidersFragment this$0, View it) {
        ProviderAdapter providerAdapter = this$0.adapter;
        if (providerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            providerAdapter = null;
        }
        providerAdapter.setAll(true);
    }

    static final void onViewCreated$lambda$7(ProvidersFragment this$0, View it) {
        ProviderAdapter providerAdapter = this$0.adapter;
        if (providerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            providerAdapter = null;
        }
        providerAdapter.setAll(false);
    }

    static final void onViewCreated$lambda$9(final ProvidersFragment this$0, View it) {
        final EditText input = new EditText(this$0.requireContext());
        AlertDialog dialog = new AlertDialog.Builder(this$0.requireContext()).setTitle("Save Profile").setMessage("Enter a name for your profile:").setView(input).setPositiveButton("Save", new DialogInterface.OnClickListener() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ProvidersFragment.onViewCreated$lambda$9$0(input, this$0, dialogInterface, i);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda18
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ProvidersFragment.onViewCreated$lambda$9$1(input, dialogInterface);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9$0(EditText $input, ProvidersFragment this$0, DialogInterface dialogInterface, int i) {
        String name = StringsKt.trim($input.getText().toString()).toString();
        if (name.length() > 0) {
            this$0.saveProfile(name);
            this$0.showMessage("Profile \"" + name + "\" saved.");
        } else {
            this$0.showMessage("Profile name cannot be empty.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9$1(EditText $input, DialogInterface it) {
        $input.setFocusableInTouchMode(true);
        $input.requestFocus();
    }

    static final void onViewCreated$lambda$10(final ProvidersFragment this$0, View it) {
        Collection $this$toTypedArray$iv = this$0.getAllProfiles().keySet();
        final String[] profiles = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
        if (profiles.length == 0) {
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "No profiles saved.", (Integer) null, 2, (Object) null);
        } else {
            new AlertDialog.Builder(this$0.requireContext()).setTitle("Select Profile").setItems(profiles, new DialogInterface.OnClickListener() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda13
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ProvidersFragment.onViewCreated$lambda$10$0(this.f$0, profiles, dialogInterface, i);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$0(ProvidersFragment this$0, String[] $profiles, DialogInterface dialogInterface, int which) {
        this$0.loadProfile($profiles[which]);
    }

    static final void onViewCreated$lambda$11(final ProvidersFragment this$0, View it) {
        Collection $this$toTypedArray$iv = this$0.getAllProfiles().keySet();
        final String[] profiles = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
        if (profiles.length == 0) {
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "No profiles to delete.", (Integer) null, 2, (Object) null);
            return;
        }
        final AlertDialog dialog = new AlertDialog.Builder(this$0.requireContext()).setTitle("Delete Profile").setItems(profiles, new DialogInterface.OnClickListener() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ProvidersFragment.onViewCreated$lambda$11$0(this.f$0, profiles, dialogInterface, i);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ProvidersFragment.onViewCreated$lambda$11$1(dialog, dialogInterface);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$11$0(ProvidersFragment this$0, String[] $profiles, DialogInterface dialogInterface, int which) {
        this$0.deleteProfile($profiles[which]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$11$1(AlertDialog $dialog, DialogInterface it) {
        View childAt;
        ListView list = $dialog.getListView();
        if (list != null) {
            ListView $this$isNotEmpty$iv = list;
            if (!($this$isNotEmpty$iv.getChildCount() != 0) || (childAt = list.getChildAt(0)) == null) {
                return;
            }
            childAt.requestFocus();
        }
    }

    private final void updateUI() {
        int chkId = this.res.getIdentifier("chk_provider", "id", "com.phisher98");
        LinearLayout linearLayout = this.container;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            linearLayout = null;
        }
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            LinearLayout linearLayout2 = this.container;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("container");
                linearLayout2 = null;
            }
            CheckBox chk = (CheckBox) linearLayout2.getChildAt(i).findViewById(chkId);
            ProviderAdapter providerAdapter = this.adapter;
            if (providerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                providerAdapter = null;
            }
            chk.setChecked(!providerAdapter.isDisabled(this.providers.get(i).getId()));
        }
        updateProviderCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissFragment() {
        dismiss();
    }

    /* JADX INFO: compiled from: ProvidersFragment.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0010R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/phisher98/ProvidersFragment$ProviderAdapter;", "", "items", "", "Lcom/phisher98/Provider;", "initiallyDisabled", "", "", "onChange", "Lkotlin/Function1;", "", "<init>", "(Lcom/phisher98/ProvidersFragment;Ljava/util/List;Ljava/util/Set;Lkotlin/jvm/functions/Function1;)V", "disabled", "", "isDisabled", "", "id", "setDisabled", "value", "setAll", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nProvidersFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProvidersFragment.kt\ncom/phisher98/ProvidersFragment$ProviderAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,373:1\n1739#2:374\n1814#2,3:375\n*S KotlinDebug\n*F\n+ 1 ProvidersFragment.kt\ncom/phisher98/ProvidersFragment$ProviderAdapter\n*L\n300#1:374\n300#1:375,3\n*E\n"})
    public final class ProviderAdapter {

        @NotNull
        private final Set<String> disabled;

        @NotNull
        private final List<Provider> items;

        @NotNull
        private final Function1<Set<String>, Unit> onChange;

        /* JADX WARN: Multi-variable type inference failed */
        public ProviderAdapter(@NotNull List<Provider> list, @NotNull Set<String> set, Function1<? super Set<String>, Unit> function1) {
            this.items = list;
            this.onChange = function1;
            this.disabled = CollectionsKt.toMutableSet(set);
        }

        public final boolean isDisabled(@NotNull String id) {
            return this.disabled.contains(id);
        }

        public final void setDisabled(@NotNull String id, boolean value) {
            Set<String> set = this.disabled;
            if (value) {
                set.add(id);
            } else {
                set.remove(id);
            }
            this.onChange.invoke(this.disabled);
        }

        public final void setAll(boolean value) {
            this.disabled.clear();
            if (!value) {
                Set<String> set = this.disabled;
                Iterable $this$map$iv = this.items;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Provider it = (Provider) item$iv$iv;
                    destination$iv$iv.add(it.getId());
                }
                set.addAll((List) destination$iv$iv);
            }
            this.onChange.invoke(this.disabled);
        }
    }

    private final void saveProfile(String name) {
        Set<String> stringSet = this.sharedPref.getStringSet(this.PREFS_DISABLED, SetsKt.emptySet());
        if (stringSet == null) {
            stringSet = SetsKt.emptySet();
        }
        Map allProfiles = MapsKt.toMutableMap(getAllProfiles());
        allProfiles.put(name, stringSet);
        String encoded = CollectionsKt.joinToString$default(allProfiles.entrySet(), "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                return ProvidersFragment.saveProfile$lambda$0((Map.Entry) obj);
            }
        }, 30, (Object) null);
        SharedPreferences $this$edit$iv = this.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.putString(ProvidersFragmentKt.PREFS_PROFILES, encoded);
        editor$iv.apply();
    }

    static final CharSequence saveProfile$lambda$0(Map.Entry entry) {
        String key = (String) entry.getKey();
        Set value = (Set) entry.getValue();
        return key + ':' + CollectionsKt.joinToString$default(value, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private final Map<String, Set<String>> getAllProfiles() {
        Set ids;
        String encoded = this.sharedPref.getString(ProvidersFragmentKt.PREFS_PROFILES, "");
        if (encoded == null) {
            return MapsKt.emptyMap();
        }
        if (encoded.length() == 0) {
            return MapsKt.emptyMap();
        }
        Map $this$getAllProfiles_u24lambda_u240 = MapsKt.createMapBuilder();
        Iterable $this$forEach$iv = StringsKt.split$default(encoded, new String[]{"|"}, false, 0, 6, (Object) null);
        for (Object element$iv : $this$forEach$iv) {
            String entry = (String) element$iv;
            int separatorIndex = StringsKt.indexOf$default(entry, ':', 0, false, 6, (Object) null);
            if (separatorIndex >= 0) {
                String name = entry.substring(0, separatorIndex);
                Intrinsics.checkNotNullExpressionValue(name, "substring(...)");
                String idsPart = entry.substring(separatorIndex + 1);
                Intrinsics.checkNotNullExpressionValue(idsPart, "substring(...)");
                if (idsPart.length() == 0) {
                    ids = SetsKt.emptySet();
                } else {
                    ids = CollectionsKt.toSet(StringsKt.split$default(idsPart, new String[]{","}, false, 0, 6, (Object) null));
                }
                $this$getAllProfiles_u24lambda_u240.put(name, ids);
            }
        }
        return MapsKt.build($this$getAllProfiles_u24lambda_u240);
    }

    private final void loadProfile(String name) {
        Set<String> set = getAllProfiles().get(name);
        if (set == null) {
            return;
        }
        SharedPreferences $this$edit$iv = this.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.putStringSet(this.PREFS_DISABLED, set);
        editor$iv.apply();
        this.adapter = new ProviderAdapter(this.providers, set, new Function1() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda16
            public final Object invoke(Object obj) {
                return ProvidersFragment.loadProfile$lambda$1(this.f$0, (Set) obj);
            }
        });
        updateUI();
        showMessage("Profile \"" + name + "\" loaded.");
    }

    static final Unit loadProfile$lambda$1(ProvidersFragment this$0, Set updated) {
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.putStringSet(this$0.PREFS_DISABLED, updated);
        editor$iv.apply();
        this$0.updateUI();
        return Unit.INSTANCE;
    }

    private final void deleteProfile(String name) {
        Map allProfiles = MapsKt.toMutableMap(getAllProfiles());
        if (allProfiles.remove(name) != null) {
            String encoded = CollectionsKt.joinToString$default(allProfiles.entrySet(), "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.ProvidersFragment$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return ProvidersFragment.deleteProfile$lambda$0((Map.Entry) obj);
                }
            }, 30, (Object) null);
            SharedPreferences $this$edit$iv = this.sharedPref;
            SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
            Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
            editor$iv.putString(ProvidersFragmentKt.PREFS_PROFILES, encoded);
            editor$iv.apply();
            showMessage("Profile \"" + name + "\" deleted.");
            return;
        }
        showMessage("Profile not found.");
    }

    static final CharSequence deleteProfile$lambda$0(Map.Entry entry) {
        String key = (String) entry.getKey();
        Set value = (Set) entry.getValue();
        return key + ':' + CollectionsKt.joinToString$default(value, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private final void showMessage(String msg) {
        Toast.makeText(requireContext(), msg, 0).show();
    }

    public void onDismiss(@NotNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDismissCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
