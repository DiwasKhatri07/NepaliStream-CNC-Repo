package com.AniVortex;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
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
import kotlin.ranges.RangesKt;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002Ê\u0001\u0002\b\u0014¨\u0006\u0013"}, d2 = {"Lcom/AniVortex/AniVortexPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "context", "Landroid/content/Context;", "showExportDialog", "ctx", "showImportDialog", "runRegistration", "force", "", "runSyncHeartbeat", "runTestConnection", "toast", "msg", "", "AniVortex", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAniVortexPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexPlugin.kt\ncom/AniVortex/AniVortexPlugin\n+ 2 CloudStreamApp.kt\ncom/lagradost/cloudstream3/CloudStreamApp$Companion\n+ 3 DataStore.kt\ncom/lagradost/cloudstream3/utils/DataStore\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,206:1\n144#2:207\n144#2:233\n144#2:259\n231#3:208\n222#3,3:209\n225#3,2:231\n231#3:234\n222#3,3:235\n225#3,2:257\n231#3:260\n222#3,3:261\n225#3,2:283\n63#4:212\n64#4,15:214\n63#4:238\n64#4,15:240\n63#4:264\n64#4,15:266\n77#4:286\n1#5:213\n1#5:239\n1#5:265\n1#5:285\n50#6:229\n43#6:230\n50#6:255\n43#6:256\n50#6:281\n43#6:282\n*S KotlinDebug\n*F\n+ 1 AniVortexPlugin.kt\ncom/AniVortex/AniVortexPlugin\n*L\n91#1:207\n35#1:233\n39#1:259\n91#1:208\n91#1:209,3\n91#1:231,2\n35#1:234\n35#1:235,3\n35#1:257,2\n39#1:260\n39#1:261,3\n39#1:283,2\n91#1:212\n91#1:214,15\n35#1:238\n35#1:240,15\n39#1:264\n39#1:266,15\n35#1:286\n91#1:213\n35#1:239\n39#1:265\n91#1:229\n91#1:230\n35#1:255\n35#1:256\n39#1:281\n39#1:282\n*E\n"})
public final class AniVortexPlugin extends Plugin {
    public void load(@NotNull Context context) {
        registerMainAPI(new AniVortexProvider());
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00001(null), 3, (Object) null);
        setOpenSettings(new Function1() { // from class: com.AniVortex.AniVortexPlugin$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return AniVortexPlugin.load$lambda$0(this.f$0, (Context) obj);
            }
        });
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexPlugin$load$1 */
    /* JADX INFO: compiled from: AniVortexPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexPlugin$load$1", f = "AniVortexPlugin.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, nl = {25}, s = {}, v = 2)
    static final class C00001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00001(Continuation<? super C00001> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00001(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (AniVortexRegistration.INSTANCE.hasCredentials()) {
                            this.label = 1;
                            if (AniVortexRegistration.INSTANCE.syncInstallationPush(true, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable e) {
                Log.w("AniVortexReg", "Launch heartbeat failed: " + e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:111:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:127:0x0216  */
    /* JADX WARN: Code duplicated, block: B:139:0x0245  */
    /* JADX WARN: Code duplicated, block: B:142:0x0250 A[Catch: all -> 0x0258, TRY_LEAVE, TryCatch #23 {all -> 0x0258, blocks: (B:140:0x024c, B:142:0x0250, B:109:0x01e8, B:112:0x01ef, B:128:0x0218, B:126:0x020f, B:107:0x01dd), top: B:181:0x01dd }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0255  */
    /* JADX WARN: Code duplicated, block: B:152:0x0266  */
    /* JADX WARN: Code duplicated, block: B:153:0x0289  */
    /* JADX WARN: Code duplicated, block: B:156:0x029b  */
    /* JADX WARN: Code duplicated, block: B:157:0x029e  */
    /* JADX WARN: Code duplicated, block: B:160:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:163:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:165:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:167:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:168:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:171:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:174:0x0300  */
    /* JADX WARN: Code duplicated, block: B:195:0x01aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:201:0x01f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x014a A[Catch: all -> 0x025a, TRY_LEAVE, TryCatch #25 {all -> 0x025a, blocks: (B:79:0x013e, B:81:0x014a), top: B:198:0x013e }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0168  */
    /* JADX WARN: Code duplicated, block: B:86:0x0170 A[Catch: all -> 0x0236, Exception -> 0x023a, TRY_LEAVE, TryCatch #26 {Exception -> 0x023a, all -> 0x0236, blocks: (B:83:0x015d, B:86:0x0170, B:92:0x019c, B:91:0x0192, B:88:0x0179), top: B:203:0x015d, inners: #18 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01a2  */
    static final Unit load$lambda$0(final AniVortexPlugin this$0, final Context ctx) {
        Object obj;
        boolean isReg;
        char c;
        boolean zBooleanValue;
        boolean useKs;
        boolean useKs2;
        long j;
        long lastSync;
        String syncText;
        StringBuilder $this$load_u24lambda_u240_u240;
        String str;
        String it;
        String str2;
        Context context;
        Object objDecodeFromString;
        Long l;
        String string;
        Object obj2;
        Object obj3;
        Object obj4;
        DeserializationStrategy deserializationStrategy;
        String str3;
        Object obj5;
        Object objDecodeFromString2;
        Object obj6;
        String str4;
        boolean isReg2 = AniVortexRegistration.INSTANCE.hasCredentials();
        String id = AniVortexAuth.INSTANCE.getInstallationId();
        String keyId = AniVortexAuth.INSTANCE.getKeyId();
        try {
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context2 = this_$iv.getContext();
            if (context2 != null) {
                obj5 = null;
                c = 0;
                try {
                    obj = "kotlinx.serialization.serializer.simple";
                    try {
                        String string2 = DataStore.INSTANCE.getSharedPrefs(context2).getString("ANIVORTEX_USE_KEYSTORE", null);
                        if (string2 == null) {
                            isReg = isReg2;
                        } else {
                            AppUtils appUtils = AppUtils.INSTANCE;
                            try {
                                Result.Companion companion = Result.Companion;
                                KType kTypeTypeOf = Reflection.typeOf(Boolean.TYPE);
                                MagicApiIntrinsics.voidMagicApiCall(obj);
                                obj6 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            if (Result.exceptionOrNull-impl(obj6) == null) {
                                isReg = isReg2;
                            } else {
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    isReg = isReg2;
                                    try {
                                        obj6 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Boolean.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            try {
                                                Result.Companion companion4 = Result.Companion;
                                                obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                            } catch (Throwable th3) {
                                                zBooleanValue = false;
                                            }
                                        } catch (Exception e) {
                                            objDecodeFromString2 = null;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    isReg = isReg2;
                                }
                            }
                            if (Result.isFailure-impl(obj6)) {
                                obj6 = null;
                            }
                            DeserializationStrategy deserializationStrategy2 = (KSerializer) obj6;
                            if (deserializationStrategy2 != null) {
                                try {
                                    str4 = string2;
                                    try {
                                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, str4);
                                    } catch (SerializationException e2) {
                                        e = e2;
                                        ArchComponentExtKt.logError((Throwable) e);
                                        objDecodeFromString2 = MainAPIKt.getMapper().readValue(str4, new TypeReference<Boolean>() { // from class: com.AniVortex.AniVortexPlugin$load$lambda$0$$inlined$getKey$1
                                        });
                                    } catch (Throwable th5) {
                                        objDecodeFromString2 = MainAPIKt.getMapper().readValue(str4, new TypeReference<Boolean>() { // from class: com.AniVortex.AniVortexPlugin$load$lambda$0$$inlined$getKey$1
                                        });
                                    }
                                } catch (SerializationException e3) {
                                    e = e3;
                                    str4 = string2;
                                } catch (Throwable th6) {
                                    str4 = string2;
                                }
                                obj5 = objDecodeFromString2;
                            } else {
                                str4 = string2;
                            }
                            objDecodeFromString2 = MainAPIKt.getMapper().readValue(str4, new TypeReference<Boolean>() { // from class: com.AniVortex.AniVortexPlugin$load$lambda$0$$inlined$getKey$1
                            });
                            obj5 = objDecodeFromString2;
                        }
                    } catch (Exception e4) {
                        isReg = isReg2;
                    } catch (Throwable th7) {
                        isReg = isReg2;
                        zBooleanValue = false;
                        useKs = zBooleanValue;
                        CloudStreamApp.Companion this_$iv2 = CloudStreamApp.Companion;
                        context = this_$iv2.getContext();
                        if (context != null) {
                            j = 0;
                            try {
                                string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIVORTEX_LAST_PUSH_SYNC", null);
                                if (string == null) {
                                    useKs2 = useKs;
                                    objDecodeFromString = null;
                                } else {
                                    AppUtils appUtils2 = AppUtils.INSTANCE;
                                    try {
                                        Result.Companion companion5 = Result.Companion;
                                        KType kTypeTypeOf2 = Reflection.typeOf(Long.TYPE);
                                        MagicApiIntrinsics.voidMagicApiCall(obj);
                                        obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                    } catch (Throwable th8) {
                                        Result.Companion companion6 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th8));
                                    }
                                    if (Result.exceptionOrNull-impl(obj2) == null) {
                                        useKs2 = useKs;
                                        obj4 = obj2;
                                    } else {
                                        try {
                                            Result.Companion companion7 = Result.Companion;
                                            useKs2 = useKs;
                                            try {
                                                try {
                                                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Long.class), (List) null, 2, (Object) null));
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    try {
                                                        try {
                                                            Result.Companion companion8 = Result.Companion;
                                                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                                        } catch (Exception e5) {
                                                            objDecodeFromString = null;
                                                        }
                                                    } catch (Throwable th10) {
                                                        lastSync = j;
                                                    }
                                                }
                                            } catch (Throwable th11) {
                                                th = th11;
                                            }
                                        } catch (Throwable th12) {
                                            th = th12;
                                            useKs2 = useKs;
                                        }
                                        obj4 = obj3;
                                    }
                                    if (Result.isFailure-impl(obj4)) {
                                        obj4 = null;
                                    }
                                    deserializationStrategy = (KSerializer) obj4;
                                    if (deserializationStrategy != null) {
                                        try {
                                            str3 = string;
                                            try {
                                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str3);
                                            } catch (SerializationException e6) {
                                                e = e6;
                                                ArchComponentExtKt.logError((Throwable) e);
                                                objDecodeFromString = MainAPIKt.getMapper().readValue(str3, new TypeReference<Long>() { // from class: com.AniVortex.AniVortexPlugin$load$lambda$0$$inlined$getKey$2
                                                });
                                            } catch (Throwable th13) {
                                                objDecodeFromString = MainAPIKt.getMapper().readValue(str3, new TypeReference<Long>() { // from class: com.AniVortex.AniVortexPlugin$load$lambda$0$$inlined$getKey$2
                                                });
                                            }
                                        } catch (SerializationException e7) {
                                            e = e7;
                                            str3 = string;
                                        } catch (Throwable th14) {
                                            str3 = string;
                                        }
                                    } else {
                                        str3 = string;
                                    }
                                    objDecodeFromString = MainAPIKt.getMapper().readValue(str3, new TypeReference<Long>() { // from class: com.AniVortex.AniVortexPlugin$load$lambda$0$$inlined$getKey$2
                                    });
                                }
                            } catch (Exception e8) {
                                useKs2 = useKs;
                                objDecodeFromString = null;
                                l = (Long) objDecodeFromString;
                                if (l != null) {
                                    lastSync = l.longValue();
                                } else {
                                    lastSync = j;
                                }
                                if (lastSync > j) {
                                    long agoMins = RangesKt.coerceAtLeast((System.currentTimeMillis() - lastSync) / 60000, j);
                                    syncText = agoMins + "m ago";
                                } else {
                                    syncText = "Never";
                                }
                                $this$load_u24lambda_u240_u240 = new StringBuilder();
                                StringBuilder sbAppend = $this$load_u24lambda_u240_u240.append("Registered: ");
                                if (isReg) {
                                    str = "YES";
                                } else {
                                    str = "NO";
                                }
                                sbAppend.append(str);
                                if (!StringsKt.isBlank(id)) {
                                    $this$load_u24lambda_u240_u240.append("\nInstall ID: ").append(StringsKt.take(id, 16)).append("…");
                                }
                                if (!StringsKt.isBlank(keyId)) {
                                    $this$load_u24lambda_u240_u240.append("\nKey ID: ").append(StringsKt.take(keyId, 16)).append("…");
                                }
                                if (isReg) {
                                    StringBuilder sbAppend2 = $this$load_u24lambda_u240_u240.append("\nKey Type: ");
                                    if (useKs2) {
                                        str2 = "Hardware KeyStore";
                                    } else {
                                        str2 = "Software Key";
                                    }
                                    sbAppend2.append(str2);
                                }
                                if (isReg) {
                                    $this$load_u24lambda_u240_u240.append("\nHeartbeat (PUT): ").append(syncText);
                                }
                                it = AniVortexRegistration.INSTANCE.getLastFailure();
                                if (it != null) {
                                    $this$load_u24lambda_u240_u240.append("\n\nLast failure:\n").append(it);
                                }
                                String status = $this$load_u24lambda_u240_u240.toString();
                                CharSequence[] actions = new CharSequence[7];
                                actions[c] = "Register (if needed)";
                                actions[1] = "Force re-register (fresh credentials)";
                                actions[2] = "Sync heartbeat now (PUT push)";
                                actions[3] = "Test API connection";
                                actions[4] = "Export credentials";
                                actions[5] = "Import credentials manually";
                                actions[6] = "Clear credentials";
                                new AlertDialog.Builder(ctx).setTitle("AniVortex Debug & Test").setMessage(status).setItems(actions, new DialogInterface.OnClickListener() { // from class: com.AniVortex.AniVortexPlugin$$ExternalSyntheticLambda3
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AniVortexPlugin.load$lambda$0$1(this.f$0, ctx, dialogInterface, i);
                                    }
                                }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
                                return Unit.INSTANCE;
                            } catch (Throwable th15) {
                                useKs2 = useKs;
                                lastSync = j;
                                if (lastSync > j) {
                                    long agoMins2 = RangesKt.coerceAtLeast((System.currentTimeMillis() - lastSync) / 60000, j);
                                    syncText = agoMins2 + "m ago";
                                } else {
                                    syncText = "Never";
                                }
                                $this$load_u24lambda_u240_u240 = new StringBuilder();
                                StringBuilder sbAppend3 = $this$load_u24lambda_u240_u240.append("Registered: ");
                                if (isReg) {
                                    str = "YES";
                                } else {
                                    str = "NO";
                                }
                                sbAppend3.append(str);
                                if (!StringsKt.isBlank(id)) {
                                    $this$load_u24lambda_u240_u240.append("\nInstall ID: ").append(StringsKt.take(id, 16)).append("…");
                                }
                                if (!StringsKt.isBlank(keyId)) {
                                    $this$load_u24lambda_u240_u240.append("\nKey ID: ").append(StringsKt.take(keyId, 16)).append("…");
                                }
                                if (isReg) {
                                    StringBuilder sbAppend4 = $this$load_u24lambda_u240_u240.append("\nKey Type: ");
                                    if (useKs2) {
                                        str2 = "Hardware KeyStore";
                                    } else {
                                        str2 = "Software Key";
                                    }
                                    sbAppend4.append(str2);
                                }
                                if (isReg) {
                                    $this$load_u24lambda_u240_u240.append("\nHeartbeat (PUT): ").append(syncText);
                                }
                                it = AniVortexRegistration.INSTANCE.getLastFailure();
                                if (it != null) {
                                    $this$load_u24lambda_u240_u240.append("\n\nLast failure:\n").append(it);
                                }
                                String status2 = $this$load_u24lambda_u240_u240.toString();
                                CharSequence[] actions2 = new CharSequence[7];
                                actions2[c] = "Register (if needed)";
                                actions2[1] = "Force re-register (fresh credentials)";
                                actions2[2] = "Sync heartbeat now (PUT push)";
                                actions2[3] = "Test API connection";
                                actions2[4] = "Export credentials";
                                actions2[5] = "Import credentials manually";
                                actions2[6] = "Clear credentials";
                                new AlertDialog.Builder(ctx).setTitle("AniVortex Debug & Test").setMessage(status2).setItems(actions2, new DialogInterface.OnClickListener() { // from class: com.AniVortex.AniVortexPlugin$$ExternalSyntheticLambda3
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AniVortexPlugin.load$lambda$0$1(this.f$0, ctx, dialogInterface, i);
                                    }
                                }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
                                return Unit.INSTANCE;
                            }
                        } else {
                            useKs2 = useKs;
                            j = 0;
                            objDecodeFromString = null;
                        }
                        l = (Long) objDecodeFromString;
                        if (l != null) {
                            lastSync = l.longValue();
                        } else {
                            lastSync = j;
                        }
                        if (lastSync > j) {
                            long agoMins3 = RangesKt.coerceAtLeast((System.currentTimeMillis() - lastSync) / 60000, j);
                            syncText = agoMins3 + "m ago";
                        } else {
                            syncText = "Never";
                        }
                        $this$load_u24lambda_u240_u240 = new StringBuilder();
                        StringBuilder sbAppend5 = $this$load_u24lambda_u240_u240.append("Registered: ");
                        if (isReg) {
                            str = "YES";
                        } else {
                            str = "NO";
                        }
                        sbAppend5.append(str);
                        if (!StringsKt.isBlank(id)) {
                            $this$load_u24lambda_u240_u240.append("\nInstall ID: ").append(StringsKt.take(id, 16)).append("…");
                        }
                        if (!StringsKt.isBlank(keyId)) {
                            $this$load_u24lambda_u240_u240.append("\nKey ID: ").append(StringsKt.take(keyId, 16)).append("…");
                        }
                        if (isReg) {
                            StringBuilder sbAppend6 = $this$load_u24lambda_u240_u240.append("\nKey Type: ");
                            if (useKs2) {
                                str2 = "Hardware KeyStore";
                            } else {
                                str2 = "Software Key";
                            }
                            sbAppend6.append(str2);
                        }
                        if (isReg) {
                            $this$load_u24lambda_u240_u240.append("\nHeartbeat (PUT): ").append(syncText);
                        }
                        it = AniVortexRegistration.INSTANCE.getLastFailure();
                        if (it != null) {
                            $this$load_u24lambda_u240_u240.append("\n\nLast failure:\n").append(it);
                        }
                        String status3 = $this$load_u24lambda_u240_u240.toString();
                        CharSequence[] actions3 = new CharSequence[7];
                        actions3[c] = "Register (if needed)";
                        actions3[1] = "Force re-register (fresh credentials)";
                        actions3[2] = "Sync heartbeat now (PUT push)";
                        actions3[3] = "Test API connection";
                        actions3[4] = "Export credentials";
                        actions3[5] = "Import credentials manually";
                        actions3[6] = "Clear credentials";
                        new AlertDialog.Builder(ctx).setTitle("AniVortex Debug & Test").setMessage(status3).setItems(actions3, new DialogInterface.OnClickListener() { // from class: com.AniVortex.AniVortexPlugin$$ExternalSyntheticLambda3
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AniVortexPlugin.load$lambda$0$1(this.f$0, ctx, dialogInterface, i);
                            }
                        }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
                        return Unit.INSTANCE;
                    }
                } catch (Exception e9) {
                    obj = "kotlinx.serialization.serializer.simple";
                    isReg = isReg2;
                } catch (Throwable th16) {
                    obj = "kotlinx.serialization.serializer.simple";
                }
                objDecodeFromString2 = null;
                obj5 = objDecodeFromString2;
            } else {
                obj = "kotlinx.serialization.serializer.simple";
                isReg = isReg2;
                c = 0;
                obj5 = null;
            }
            Boolean bool = (Boolean) obj5;
            zBooleanValue = bool != null ? bool.booleanValue() : false;
        } catch (Throwable th17) {
            obj = "kotlinx.serialization.serializer.simple";
            isReg = isReg2;
            c = 0;
        }
        useKs = zBooleanValue;
        try {
            CloudStreamApp.Companion this_$iv3 = CloudStreamApp.Companion;
            context = this_$iv3.getContext();
            if (context != null) {
                j = 0;
                string = DataStore.INSTANCE.getSharedPrefs(context).getString("ANIVORTEX_LAST_PUSH_SYNC", null);
                if (string == null) {
                    useKs2 = useKs;
                    objDecodeFromString = null;
                } else {
                    AppUtils appUtils3 = AppUtils.INSTANCE;
                    Result.Companion companion9 = Result.Companion;
                    KType kTypeTypeOf3 = Reflection.typeOf(Long.TYPE);
                    MagicApiIntrinsics.voidMagicApiCall(obj);
                    obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                    if (Result.exceptionOrNull-impl(obj2) == null) {
                        useKs2 = useKs;
                        obj4 = obj2;
                    } else {
                        Result.Companion companion10 = Result.Companion;
                        useKs2 = useKs;
                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Long.class), (List) null, 2, (Object) null));
                        obj4 = obj3;
                    }
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = null;
                    }
                    deserializationStrategy = (KSerializer) obj4;
                    if (deserializationStrategy != null) {
                        str3 = string;
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str3);
                    } else {
                        str3 = string;
                    }
                    objDecodeFromString = MainAPIKt.getMapper().readValue(str3, new TypeReference<Long>() { // from class: com.AniVortex.AniVortexPlugin$load$lambda$0$$inlined$getKey$2
                    });
                }
            } else {
                useKs2 = useKs;
                j = 0;
                objDecodeFromString = null;
            }
            l = (Long) objDecodeFromString;
            if (l != null) {
                lastSync = l.longValue();
            } else {
                lastSync = j;
            }
        } catch (Throwable th18) {
            useKs2 = useKs;
            j = 0;
        }
        if (lastSync > j) {
            long agoMins4 = RangesKt.coerceAtLeast((System.currentTimeMillis() - lastSync) / 60000, j);
            syncText = agoMins4 + "m ago";
        } else {
            syncText = "Never";
        }
        $this$load_u24lambda_u240_u240 = new StringBuilder();
        StringBuilder sbAppend7 = $this$load_u24lambda_u240_u240.append("Registered: ");
        if (isReg) {
            str = "YES";
        } else {
            str = "NO";
        }
        sbAppend7.append(str);
        if (!StringsKt.isBlank(id)) {
            $this$load_u24lambda_u240_u240.append("\nInstall ID: ").append(StringsKt.take(id, 16)).append("…");
        }
        if (!StringsKt.isBlank(keyId)) {
            $this$load_u24lambda_u240_u240.append("\nKey ID: ").append(StringsKt.take(keyId, 16)).append("…");
        }
        if (isReg) {
            StringBuilder sbAppend8 = $this$load_u24lambda_u240_u240.append("\nKey Type: ");
            if (useKs2) {
                str2 = "Hardware KeyStore";
            } else {
                str2 = "Software Key";
            }
            sbAppend8.append(str2);
        }
        if (isReg) {
            $this$load_u24lambda_u240_u240.append("\nHeartbeat (PUT): ").append(syncText);
        }
        it = AniVortexRegistration.INSTANCE.getLastFailure();
        if (it != null) {
            $this$load_u24lambda_u240_u240.append("\n\nLast failure:\n").append(it);
        }
        String status4 = $this$load_u24lambda_u240_u240.toString();
        CharSequence[] actions4 = new CharSequence[7];
        actions4[c] = "Register (if needed)";
        actions4[1] = "Force re-register (fresh credentials)";
        actions4[2] = "Sync heartbeat now (PUT push)";
        actions4[3] = "Test API connection";
        actions4[4] = "Export credentials";
        actions4[5] = "Import credentials manually";
        actions4[6] = "Clear credentials";
        new AlertDialog.Builder(ctx).setTitle("AniVortex Debug & Test").setMessage(status4).setItems(actions4, new DialogInterface.OnClickListener() { // from class: com.AniVortex.AniVortexPlugin$$ExternalSyntheticLambda3
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
                this$0.runSyncHeartbeat($ctx);
                break;
            case 3:
                this$0.runTestConnection($ctx);
                break;
            case 4:
                this$0.showExportDialog($ctx);
                break;
            case 5:
                this$0.showImportDialog($ctx);
                break;
            case 6:
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
    @DebugMetadata(c = "com.AniVortex.AniVortexPlugin$runRegistration$1", f = "AniVortexPlugin.kt", i = {2, 2}, l = {162, 162, 168}, m = "invokeSuspend", n = {"msg", "ok"}, nl = {162, 163, 175}, s = {"L$0", "Z$0"}, v = 2)
    static final class C00011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $ctx;
        final /* synthetic */ boolean $force;
        Object L$0;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00011(boolean z, Context context, Continuation<? super C00011> continuation) {
            super(2, continuation);
            this.$force = z;
            this.$ctx = context;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00011(this.$force, this.$ctx, continuation);
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
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00011(force, ctx, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexPlugin$runSyncHeartbeat$1 */
    /* JADX INFO: compiled from: AniVortexPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexPlugin$runSyncHeartbeat$1", f = "AniVortexPlugin.kt", i = {1}, l = {181, 182}, m = "invokeSuspend", n = {"ok"}, nl = {182, 185}, s = {"Z$0"}, v = 2)
    static final class C00021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $ctx;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00021(Context context, Continuation<? super C00021> continuation) {
            super(2, continuation);
            this.$ctx = context;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AniVortexPlugin.this.new C00021(this.$ctx, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0055 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0056  */
        public final Object invokeSuspend(Object $result) {
            Object objSyncInstallationPush$default;
            boolean ok;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    objSyncInstallationPush$default = AniVortexRegistration.syncInstallationPush$default(AniVortexRegistration.INSTANCE, false, (Continuation) this, 1, null);
                    if (objSyncInstallationPush$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ok = ((Boolean) objSyncInstallationPush$default).booleanValue();
                    this.Z$0 = ok;
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(AniVortexPlugin.this, this.$ctx, ok, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objSyncInstallationPush$default = $result;
                    ok = ((Boolean) objSyncInstallationPush$default).booleanValue();
                    this.Z$0 = ok;
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(AniVortexPlugin.this, this.$ctx, ok, null), (Continuation) this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.AniVortex.AniVortexPlugin$runSyncHeartbeat$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: AniVortexPlugin.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.AniVortex.AniVortexPlugin$runSyncHeartbeat$1$1", f = "AniVortexPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $ctx;
            final /* synthetic */ boolean $ok;
            int label;
            final /* synthetic */ AniVortexPlugin this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AniVortexPlugin aniVortexPlugin, Context context, boolean z, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = aniVortexPlugin;
                this.$ctx = context;
                this.$ok = z;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$ctx, this.$ok, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.this$0.toast(this.$ctx, this.$ok ? "Heartbeat sync succeeded!" : "Heartbeat sync failed (check logcat)");
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    private final void runSyncHeartbeat(Context ctx) {
        toast(ctx, "Syncing installation heartbeat…");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00021(ctx, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexPlugin$runTestConnection$1 */
    /* JADX INFO: compiled from: AniVortexPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexPlugin$runTestConnection$1", f = "AniVortexPlugin.kt", i = {1, 1}, l = {191, 192}, m = "invokeSuspend", n = {"msg", "ok"}, nl = {192, 199}, s = {"L$0", "Z$0"}, v = 2)
    static final class C00031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $ctx;
        Object L$0;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00031(Context context, Continuation<? super C00031> continuation) {
            super(2, continuation);
            this.$ctx = context;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00031(this.$ctx, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0068 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0069  */
        public final Object invokeSuspend(Object $result) {
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
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00031(ctx, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toast(Context ctx, String msg) {
        Toast.makeText(ctx, msg, 1).show();
    }
}
