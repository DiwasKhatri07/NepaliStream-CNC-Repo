package com.AniVortex;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.CloudStreamApp;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStore;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AniVortexPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002Ê\u0001\u0002\b\u0013¨\u0006\u0012"}, d2 = {"Lcom/AniVortex/AniVortexPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "context", "Landroid/content/Context;", "showExportDialog", "ctx", "showImportDialog", "runRegistration", "force", "", "runTestConnection", "toast", "msg", "", "AniVortex", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAniVortexPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexPlugin.kt\ncom/AniVortex/AniVortexPlugin\n+ 2 CloudStreamApp.kt\ncom/lagradost/cloudstream3/CloudStreamApp$Companion\n+ 3 DataStore.kt\ncom/lagradost/cloudstream3/utils/DataStore\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,173:1\n144#2:174\n144#2:200\n231#3:175\n222#3,3:176\n225#3,2:198\n231#3:201\n222#3,3:202\n225#3,2:224\n63#4:179\n64#4,15:181\n63#4:205\n64#4,15:207\n1#5:180\n1#5:206\n1#5:226\n50#6:196\n43#6:197\n50#6:222\n43#6:223\n*S KotlinDebug\n*F\n+ 1 AniVortexPlugin.kt\ncom/AniVortex/AniVortexPlugin\n*L\n68#1:174\n23#1:200\n68#1:175\n68#1:176,3\n68#1:198,2\n23#1:201\n23#1:202,3\n23#1:224,2\n68#1:179\n68#1:181,15\n23#1:205\n23#1:207,15\n68#1:180\n23#1:206\n68#1:196\n68#1:197\n23#1:222\n23#1:223\n*E\n"})
public final class AniVortexPlugin extends Plugin {
    public void load(@NotNull Context context) {
        registerMainAPI(new AniVortexProvider());
        setOpenSettings(new Function1() { // from class: com.AniVortex.AniVortexPlugin$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return AniVortexPlugin.load$lambda$0(this.f$0, (Context) obj);
            }
        });
    }

    static final Unit load$lambda$0(final AniVortexPlugin this$0, final Context ctx) {
        boolean isReg;
        char c;
        boolean useKs;
        Object obj;
        Object objDecodeFromString;
        Object obj2;
        String str;
        boolean isReg2 = AniVortexRegistration.INSTANCE.hasCredentials();
        String id = AniVortexAuth.INSTANCE.getInstallationId();
        String keyId = AniVortexAuth.INSTANCE.getKeyId();
        try {
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context = this_$iv.getContext();
            if (context != null) {
                Object obj3 = null;
                c = 0;
                try {
                    try {
                        try {
                            String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIVORTEX_USE_KEYSTORE", null);
                            if (string == null) {
                                isReg = isReg2;
                                obj = obj3;
                            } else {
                                AppUtils appUtils = AppUtils.INSTANCE;
                                try {
                                    Result.Companion companion = Result.Companion;
                                    KType kTypeTypeOf = Reflection.typeOf(Boolean.TYPE);
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                } catch (Throwable th) {
                                    Result.Companion companion2 = Result.Companion;
                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                                if (Result.exceptionOrNull-impl(obj2) == null) {
                                    isReg = isReg2;
                                } else {
                                    try {
                                        Result.Companion companion3 = Result.Companion;
                                        isReg = isReg2;
                                        try {
                                            obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Boolean.class), (List) null, 2, (Object) null));
                                        } catch (Throwable th2) {
                                            th = th2;
                                            try {
                                                try {
                                                    Result.Companion companion4 = Result.Companion;
                                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                                } catch (Throwable th3) {
                                                    useKs = false;
                                                }
                                            } catch (Exception e) {
                                                objDecodeFromString = null;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        isReg = isReg2;
                                    }
                                }
                                DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj2) ? null : obj2);
                                if (deserializationStrategy != null) {
                                    try {
                                        str = string;
                                        try {
                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str);
                                        } catch (SerializationException e2) {
                                            e = e2;
                                            ArchComponentExtKt.logError((Throwable) e);
                                            objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<Boolean>() { // from class: com.AniVortex.AniVortexPlugin$load$lambda$0$$inlined$getKey$1
                                            });
                                        } catch (Throwable th5) {
                                            objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<Boolean>() { // from class: com.AniVortex.AniVortexPlugin$load$lambda$0$$inlined$getKey$1
                                            });
                                        }
                                    } catch (SerializationException e3) {
                                        e = e3;
                                        str = string;
                                    } catch (Throwable th6) {
                                        str = string;
                                    }
                                    obj3 = objDecodeFromString;
                                    obj = obj3;
                                } else {
                                    str = string;
                                }
                                objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<Boolean>() { // from class: com.AniVortex.AniVortexPlugin$load$lambda$0$$inlined$getKey$1
                                });
                                obj3 = objDecodeFromString;
                                obj = obj3;
                            }
                        } catch (Exception e4) {
                            isReg = isReg2;
                        }
                    } catch (Exception e5) {
                        isReg = isReg2;
                    }
                    obj3 = objDecodeFromString;
                    obj = obj3;
                } catch (Throwable th7) {
                    isReg = isReg2;
                    useKs = false;
                }
                objDecodeFromString = null;
            } else {
                isReg = isReg2;
                c = 0;
                obj = null;
            }
            Boolean bool = (Boolean) obj;
            useKs = bool != null ? bool.booleanValue() : false;
        } catch (Throwable th8) {
            isReg = isReg2;
            c = 0;
        }
        StringBuilder $this$load_u24lambda_u240_u240 = new StringBuilder();
        $this$load_u24lambda_u240_u240.append("Registered: ").append(isReg ? "YES" : "NO");
        if (!StringsKt.isBlank(id)) {
            $this$load_u24lambda_u240_u240.append("\nInstall ID: ").append(StringsKt.take(id, 16)).append("…");
        }
        if (!StringsKt.isBlank(keyId)) {
            $this$load_u24lambda_u240_u240.append("\nKey ID: ").append(StringsKt.take(keyId, 16)).append("…");
        }
        if (isReg) {
            $this$load_u24lambda_u240_u240.append("\nKey Type: ").append(useKs ? "Hardware KeyStore" : "Software Key");
        }
        String it = AniVortexRegistration.INSTANCE.getLastFailure();
        if (it != null) {
            $this$load_u24lambda_u240_u240.append("\n\nLast failure:\n").append(it);
        }
        String status = $this$load_u24lambda_u240_u240.toString();
        CharSequence[] actions = new CharSequence[6];
        actions[c] = "Register (if needed)";
        actions[1] = "Force re-register (fresh credentials)";
        actions[2] = "Test API connection";
        actions[3] = "Export credentials";
        actions[4] = "Import credentials manually";
        actions[5] = "Clear credentials";
        new AlertDialog.Builder(ctx).setTitle("AniVortex Debug & Test").setMessage(status).setItems(actions, new DialogInterface.OnClickListener() { // from class: com.AniVortex.AniVortexPlugin$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AniVortexPlugin.load$lambda$0$1(this.f$0, ctx, dialogInterface, i);
            }
        }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void load$lambda$0$1(AniVortexPlugin this$0, Context $ctx, DialogInterface dialog, int which) {
        dialog.dismiss();
        switch (which) {
            case 0:
                this$0.runRegistration($ctx, false);
                break;
            case 1:
                this$0.runRegistration($ctx, true);
                break;
            case 2:
                this$0.runTestConnection($ctx);
                break;
            case 3:
                this$0.showExportDialog($ctx);
                break;
            case 4:
                this$0.showImportDialog($ctx);
                break;
            case 5:
                AniVortexAuth.INSTANCE.markCurrentCredentialsInvalid();
                AniVortexRegistration.INSTANCE.clearKeystoreKey();
                this$0.toast($ctx, "Credentials cleared — a fresh registration will run on next use");
                break;
        }
    }

    private final void showExportDialog(final Context ctx) {
        String str;
        String priv;
        Object obj;
        Object objDecodeFromString;
        Object obj2;
        String str2;
        String id = AniVortexAuth.INSTANCE.getInstallationId();
        String keyId = AniVortexAuth.INSTANCE.getKeyId();
        try {
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context = this_$iv.getContext();
            if (context == null) {
                str = "";
                obj = null;
            } else {
                Object obj3 = null;
                try {
                    str = "";
                    try {
                        try {
                            String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIVORTEX_PRIVATE_KEY", null);
                            if (string != null) {
                                AppUtils appUtils = AppUtils.INSTANCE;
                                try {
                                    Result.Companion companion = Result.Companion;
                                    KType kTypeTypeOf = Reflection.typeOf(String.class);
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                } catch (Throwable th) {
                                    Result.Companion companion2 = Result.Companion;
                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                                if (Result.exceptionOrNull-impl(obj2) != null) {
                                    try {
                                        Result.Companion companion3 = Result.Companion;
                                        try {
                                            obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(String.class), (List) null, 2, (Object) null));
                                        } catch (Throwable th2) {
                                            th = th2;
                                            try {
                                                Result.Companion companion4 = Result.Companion;
                                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                            } catch (Exception e) {
                                                objDecodeFromString = null;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                }
                                DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj2) ? null : obj2);
                                if (deserializationStrategy == null) {
                                    str2 = string;
                                } else {
                                    try {
                                        str2 = string;
                                        try {
                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str2);
                                        } catch (SerializationException e2) {
                                            e = e2;
                                            ArchComponentExtKt.logError((Throwable) e);
                                            objDecodeFromString = MainAPIKt.getMapper().readValue(str2, new TypeReference<String>() { // from class: com.AniVortex.AniVortexPlugin$showExportDialog$$inlined$getKey$1
                                            });
                                        } catch (Throwable th4) {
                                            objDecodeFromString = MainAPIKt.getMapper().readValue(str2, new TypeReference<String>() { // from class: com.AniVortex.AniVortexPlugin$showExportDialog$$inlined$getKey$1
                                            });
                                        }
                                    } catch (SerializationException e3) {
                                        e = e3;
                                        str2 = string;
                                    } catch (Throwable th5) {
                                        str2 = string;
                                    }
                                    obj3 = objDecodeFromString;
                                }
                                objDecodeFromString = MainAPIKt.getMapper().readValue(str2, new TypeReference<String>() { // from class: com.AniVortex.AniVortexPlugin$showExportDialog$$inlined$getKey$1
                                });
                                obj3 = objDecodeFromString;
                            }
                        } catch (Exception e4) {
                        }
                        obj = obj3;
                    } catch (Throwable th6) {
                        priv = str;
                    }
                } catch (Exception e5) {
                    str = "";
                }
            }
            String str3 = (String) obj;
            priv = str3 == null ? str : str3;
        } catch (Throwable th7) {
            str = "";
        }
        if (StringsKt.isBlank(id) || StringsKt.isBlank(keyId)) {
            toast(ctx, "No credentials stored yet. Register first.");
        } else {
            final String text = "Installation ID:\n" + id + "\n\nKey ID:\n" + keyId + "\n\nPrivate Key (PKCS#8 Base64):\n" + (!StringsKt.isBlank(priv) ? priv : "(Hardware KeyStore key)");
            new AlertDialog.Builder(ctx).setTitle("AniVortex Credentials").setMessage(text).setPositiveButton("Copy", new DialogInterface.OnClickListener() { // from class: com.AniVortex.AniVortexPlugin$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AniVortexPlugin.showExportDialog$lambda$0(ctx, text, this, dialogInterface, i);
                }
            }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
        }
    }

    static final void showExportDialog$lambda$0(Context $ctx, String $text, AniVortexPlugin this$0, DialogInterface dialogInterface, int i) {
        Object systemService = $ctx.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboard = (ClipboardManager) systemService;
        ClipData clip = ClipData.newPlainText("AniVortex Credentials", $text);
        clipboard.setPrimaryClip(clip);
        this$0.toast($ctx, "Credentials copied to clipboard");
    }

    private final void showImportDialog(final Context ctx) {
        float density = ctx.getResources().getDisplayMetrics().density;
        LinearLayout layout = new LinearLayout(ctx);
        layout.setOrientation(1);
        int pad = (int) (16.0f * density);
        layout.setPadding(pad, pad, pad, 0);
        final EditText installEdit = showImportDialog$addEdit$default(ctx, layout, "Installation ID", false, 8, null);
        final EditText keyIdEdit = showImportDialog$addEdit$default(ctx, layout, "Key ID", false, 8, null);
        final EditText privEdit = showImportDialog$addEdit(ctx, layout, "Private key (PKCS8 base64)", false);
        new AlertDialog.Builder(ctx).setTitle("Import AniVortex credentials").setView(layout).setPositiveButton("Import", new DialogInterface.OnClickListener() { // from class: com.AniVortex.AniVortexPlugin$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AniVortexPlugin.showImportDialog$lambda$1(installEdit, keyIdEdit, privEdit, this, ctx, dialogInterface, i);
            }
        }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }

    static /* synthetic */ EditText showImportDialog$addEdit$default(Context context, LinearLayout linearLayout, String str, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return showImportDialog$addEdit(context, linearLayout, str, z);
    }

    private static final EditText showImportDialog$addEdit(Context $ctx, LinearLayout layout, String hint, boolean singleLine) {
        EditText edit = new EditText($ctx);
        edit.setHint(hint);
        edit.setSingleLine(singleLine);
        layout.addView(edit);
        return edit;
    }

    static final void showImportDialog$lambda$1(EditText $installEdit, EditText $keyIdEdit, EditText $privEdit, AniVortexPlugin this$0, Context $ctx, DialogInterface dialogInterface, int i) {
        String install = StringsKt.trim($installEdit.getText().toString()).toString();
        String keyId = StringsKt.trim($keyIdEdit.getText().toString()).toString();
        String priv = StringsKt.trim($privEdit.getText().toString()).toString();
        if (!(install.length() == 0)) {
            if (!(keyId.length() == 0)) {
                if (priv.length() == 0) {
                    this$0.toast($ctx, "Private key is required unless this device holds the keystore key");
                    return;
                }
                CloudStreamApp.Companion.setKey("ANIVORTEX_INSTALL_ID", install);
                CloudStreamApp.Companion.setKey("ANIVORTEX_KEY_ID", keyId);
                CloudStreamApp.Companion.setKey("ANIVORTEX_PRIVATE_KEY", priv);
                CloudStreamApp.Companion.setKey("ANIVORTEX_USE_KEYSTORE", false);
                AniVortexAuth.INSTANCE.invalidateCache();
                this$0.toast($ctx, "Credentials imported — now use 'Test API connection' to verify");
                return;
            }
        }
        this$0.toast($ctx, "Installation ID and Key ID are required");
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexPlugin$runRegistration$1 */
    /* JADX INFO: compiled from: AniVortexPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexPlugin$runRegistration$1", f = "AniVortexPlugin.kt", i = {2, 2}, l = {139, 139, 145}, m = "invokeSuspend", n = {"msg", "ok"}, nl = {139, 140, 152}, s = {"L$0", "Z$0"}, v = 2)
    static final class C00001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $ctx;
        final /* synthetic */ boolean $force;
        Object L$0;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00001(boolean z, Context context, Continuation<? super C00001> continuation) {
            super(2, continuation);
            this.$force = z;
            this.$ctx = context;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00001(this.$force, this.$ctx, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x004f  */
        /* JADX WARN: Code duplicated, block: B:19:0x0089  */
        /* JADX WARN: Code duplicated, block: B:21:0x009c  */
        /* JADX WARN: Code duplicated, block: B:26:0x00b4  */
        /* JADX WARN: Code duplicated, block: B:29:0x00cf A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:30:0x00d0  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object objEnsureRegistered;
            boolean ok;
            String lastFailure;
            String msg;
            CoroutineContext main;
            Context context;
            boolean z;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$force) {
                        this.label = 1;
                        objEnsureRegistered = AniVortexRegistration.INSTANCE.reRegister((Continuation) this);
                        if (objEnsureRegistered == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        this.label = 2;
                        objEnsureRegistered = AniVortexRegistration.INSTANCE.ensureRegistered((Continuation) this);
                        if (objEnsureRegistered == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    ok = ((Boolean) objEnsureRegistered).booleanValue();
                    if (ok) {
                        msg = "Registration OK!\n\nInstallation ID: " + StringsKt.take(AniVortexAuth.INSTANCE.getInstallationId(), 16) + "…\nKey ID: " + StringsKt.take(AniVortexAuth.INSTANCE.getKeyId(), 16) + (char) 8230;
                    } else {
                        StringBuilder sbAppend = new StringBuilder().append("Registration FAILED:\n\n");
                        lastFailure = AniVortexRegistration.INSTANCE.getLastFailure();
                        if (lastFailure == null) {
                            lastFailure = "unknown error (check logcat tag AniVortexReg)";
                        }
                        msg = sbAppend.append(lastFailure).toString();
                    }
                    main = Dispatchers.getMain();
                    context = this.$ctx;
                    z = ok;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(msg);
                    this.Z$0 = ok;
                    this.label = 3;
                    if (BuildersKt.withContext(main, new AnonymousClass1(context, z, msg, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                case 2:
                    ResultKt.throwOnFailure($result);
                    objEnsureRegistered = $result;
                    ok = ((Boolean) objEnsureRegistered).booleanValue();
                    if (ok) {
                        msg = "Registration OK!\n\nInstallation ID: " + StringsKt.take(AniVortexAuth.INSTANCE.getInstallationId(), 16) + "…\nKey ID: " + StringsKt.take(AniVortexAuth.INSTANCE.getKeyId(), 16) + (char) 8230;
                    } else {
                        StringBuilder sbAppend2 = new StringBuilder().append("Registration FAILED:\n\n");
                        lastFailure = AniVortexRegistration.INSTANCE.getLastFailure();
                        if (lastFailure == null) {
                            lastFailure = "unknown error (check logcat tag AniVortexReg)";
                        }
                        msg = sbAppend2.append(lastFailure).toString();
                    }
                    main = Dispatchers.getMain();
                    context = this.$ctx;
                    if (ok) {
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(msg);
                    this.Z$0 = ok;
                    this.label = 3;
                    if (BuildersKt.withContext(main, new AnonymousClass1(context, z, msg, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 3:
                    boolean z2 = this.Z$0;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.AniVortex.AniVortexPlugin$runRegistration$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: AniVortexPlugin.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.AniVortex.AniVortexPlugin$runRegistration$1$1", f = "AniVortexPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $ctx;
            final /* synthetic */ String $msg;
            final /* synthetic */ boolean $ok;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Context context, boolean z, String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$ctx = context;
                this.$ok = z;
                this.$msg = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$ctx, this.$ok, this.$msg, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        new AlertDialog.Builder(this.$ctx).setTitle(this.$ok ? "Registration Succeeded" : "Registration Failed").setMessage(this.$msg).setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null).show();
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    private final void runRegistration(Context ctx, boolean force) {
        toast(ctx, force ? "Re-registering…" : "Registering…");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00001(force, ctx, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexPlugin$runTestConnection$1 */
    /* JADX INFO: compiled from: AniVortexPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexPlugin$runTestConnection$1", f = "AniVortexPlugin.kt", i = {1, 1}, l = {158, 159}, m = "invokeSuspend", n = {"msg", "ok"}, nl = {159, 166}, s = {"L$0", "Z$0"}, v = 2)
    static final class C00011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $ctx;
        Object L$0;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00011(Context context, Continuation<? super C00011> continuation) {
            super(2, continuation);
            this.$ctx = context;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00011(this.$ctx, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0068 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0069  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object objTestApiConnection;
            boolean ok;
            String msg;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    objTestApiConnection = AniVortexRegistration.INSTANCE.testApiConnection((Continuation) this);
                    if (objTestApiConnection == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Pair pair = (Pair) objTestApiConnection;
                    ok = ((Boolean) pair.component1()).booleanValue();
                    msg = (String) pair.component2();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(msg);
                    this.Z$0 = ok;
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$ctx, ok, msg, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objTestApiConnection = $result;
                    Pair pair2 = (Pair) objTestApiConnection;
                    ok = ((Boolean) pair2.component1()).booleanValue();
                    msg = (String) pair2.component2();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(msg);
                    this.Z$0 = ok;
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$ctx, ok, msg, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 2:
                    boolean z = this.Z$0;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.AniVortex.AniVortexPlugin$runTestConnection$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: AniVortexPlugin.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.AniVortex.AniVortexPlugin$runTestConnection$1$1", f = "AniVortexPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $ctx;
            final /* synthetic */ String $msg;
            final /* synthetic */ boolean $ok;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Context context, boolean z, String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$ctx = context;
                this.$ok = z;
                this.$msg = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$ctx, this.$ok, this.$msg, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        new AlertDialog.Builder(this.$ctx).setTitle(this.$ok ? "API Test Passed" : "API Test Failed").setMessage(this.$msg).setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null).show();
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    private final void runTestConnection(Context ctx) {
        toast(ctx, "Testing API connection…");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00011(ctx, null), 3, (Object) null);
    }

    private final void toast(Context ctx, String msg) {
        Toast.makeText(ctx, msg, 1).show();
    }
}
