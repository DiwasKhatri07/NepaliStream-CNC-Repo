package com.cncverse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SportzxProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/SportzxProvider/classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t0\u0012H\u0086@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00122\u0006\u0010\u0018\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0010R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/cncverse/SportzxProviderManager;", "", "<init>", "()V", "cachedBaseUrl", "", "client", "Lokhttp3/OkHttpClient;", "baseHeaders", "", "getBaseUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidateCache", "", "fetchDecrypted", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchProviders", "", "fetchLiveEvents", "Lcom/cncverse/SportzxLiveEventData;", "path", "fetchVODCategory", "Lcom/cncverse/SportzxVODData;", "catLink", "fetchStreamData", "eventId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSportzxProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportzxProviderManager.kt\ncom/cncverse/SportzxProviderManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,382:1\n1#2:383\n*E\n"})
public final class SportzxProviderManager {

    @Nullable
    private static volatile String cachedBaseUrl;

    @NotNull
    public static final SportzxProviderManager INSTANCE = new SportzxProviderManager();

    @NotNull
    private static final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();

    @NotNull
    private static final Map<String, String> baseHeaders = MapsKt.mapOf(TuplesKt.to("User-Agent", "Dalvik/2.1.0 (Linux; Android 13)"));

    /* JADX INFO: renamed from: com.cncverse.SportzxProviderManager$fetchStreamData$2 */
    /* JADX INFO: compiled from: SportzxProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SportzxProviderManager", f = "SportzxProviderManager.kt", i = {0, 1, 1, 2, 2, 2}, l = {372, 375, 379}, m = "fetchStreamData", n = {"eventId", "eventId", "baseUrl", "eventId", "baseUrl", "primary"}, nl = {373, 376, -1}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00272 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00272(Continuation<? super C00272> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SportzxProviderManager.this.fetchStreamData((String) null, (Continuation<? super String>) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.SportzxProviderManager$getBaseUrl$1 */
    /* JADX INFO: compiled from: SportzxProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SportzxProviderManager", f = "SportzxProviderManager.kt", i = {}, l = {176}, m = "getBaseUrl", n = {}, nl = {177}, s = {}, v = 2)
    static final class C00301 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00301(Continuation<? super C00301> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SportzxProviderManager.this.getBaseUrl((Continuation) this);
        }
    }

    private SportzxProviderManager() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object getBaseUrl(@NotNull Continuation<? super String> continuation) {
        C00301 c00301;
        Object baseApiUrl;
        if (continuation instanceof C00301) {
            c00301 = (C00301) continuation;
            if ((c00301.label & Integer.MIN_VALUE) != 0) {
                c00301.label -= Integer.MIN_VALUE;
            } else {
                c00301 = new C00301(continuation);
            }
        } else {
            c00301 = new C00301(continuation);
        }
        Object $result = c00301.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00301.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String it = cachedBaseUrl;
                if (it != null) {
                    return it;
                }
                SportzxFirebaseFetcher sportzxFirebaseFetcher = SportzxFirebaseFetcher.INSTANCE;
                c00301.label = 1;
                baseApiUrl = sportzxFirebaseFetcher.getBaseApiUrl(c00301);
                if (baseApiUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                baseApiUrl = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String firebaseUrl = (String) baseApiUrl;
        String str = firebaseUrl;
        cachedBaseUrl = !(str == null || StringsKt.isBlank(str)) ? StringsKt.trimEnd(firebaseUrl, new char[]{'/'}) : "";
        String str2 = cachedBaseUrl;
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    public final void invalidateCache() {
        cachedBaseUrl = null;
    }

    /* JADX INFO: renamed from: com.cncverse.SportzxProviderManager$fetchDecrypted$2 */
    /* JADX INFO: compiled from: SportzxProviderManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SportzxProviderManager$fetchDecrypted$2", f = "SportzxProviderManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nSportzxProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportzxProviderManager.kt\ncom/cncverse/SportzxProviderManager$fetchDecrypted$2\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,382:1\n221#2,2:383\n63#3:385\n64#3,15:387\n1#4:386\n50#5:402\n43#5:403\n*S KotlinDebug\n*F\n+ 1 SportzxProviderManager.kt\ncom/cncverse/SportzxProviderManager$fetchDecrypted$2\n*L\n198#1:383,2\n212#1:385\n212#1:387,15\n212#1:386\n212#1:402\n212#1:403\n*E\n"})
    static final class C00212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00212(String str, Continuation<? super C00212> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00212 = new C00212(this.$url, continuation);
            c00212.L$0 = obj;
            return c00212;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object obj;
            Object objDecodeFromString;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        Request.Builder $this$invokeSuspend_u24lambda_u240 = new Request.Builder().url(this.$url);
                        Map $this$forEach$iv = SportzxProviderManager.baseHeaders;
                        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                            String k = (String) element$iv.getKey();
                            String v = (String) element$iv.getValue();
                            $this$invokeSuspend_u24lambda_u240.header(k, v);
                        }
                        Request request = $this$invokeSuspend_u24lambda_u240.build();
                        Response response = SportzxProviderManager.client.newCall(request).execute();
                        if (!response.isSuccessful()) {
                            System.out.println((Object) ("Sportzx: HTTP " + response.code() + " → " + this.$url));
                            return null;
                        }
                        String bodyStr = response.body().string();
                        if (StringsKt.isBlank(bodyStr)) {
                            return null;
                        }
                        try {
                            AppUtils appUtils = AppUtils.INSTANCE;
                            try {
                                Result.Companion companion = Result.Companion;
                                KType kTypeTypeOf = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                break;
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            if (Result.exceptionOrNull-impl(obj) != null) {
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                                } catch (Throwable th2) {
                                    Result.Companion companion4 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th2));
                                }
                                break;
                            }
                            if (Result.isFailure-impl(obj)) {
                                obj = null;
                            }
                            DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, bodyStr);
                                } catch (SerializationException e) {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv.readValue(bodyStr, new TypeReference<Map<String, ? extends String>>() { // from class: com.cncverse.SportzxProviderManager$fetchDecrypted$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                } catch (Throwable th3) {
                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv2.readValue(bodyStr, new TypeReference<Map<String, ? extends String>>() { // from class: com.cncverse.SportzxProviderManager$fetchDecrypted$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                }
                                break;
                            } else {
                                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv3.readValue(bodyStr, new TypeReference<Map<String, ? extends String>>() { // from class: com.cncverse.SportzxProviderManager$fetchDecrypted$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                            Map envelope = (Map) objDecodeFromString;
                            String encrypted = (String) envelope.get("data");
                            if (encrypted == null) {
                                System.out.println((Object) ("Sportzx: No 'data' field in response from " + this.$url));
                                return null;
                            }
                            String decrypted = SportzxCryptoUtils.INSTANCE.decrypt(encrypted);
                            String str = decrypted;
                            if (str == null || StringsKt.isBlank(str)) {
                                System.out.println((Object) ("Sportzx: Decryption failed for " + this.$url));
                                return null;
                            }
                            return decrypted;
                        } catch (Exception e2) {
                            System.out.println((Object) ("Sportzx: Failed to parse JSON envelope from " + this.$url + " — " + e2.getMessage()));
                            return null;
                        }
                    } catch (Exception e3) {
                        System.out.println((Object) ("Sportzx: Exception fetching " + this.$url + " — " + e3.getMessage()));
                        return null;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchDecrypted(String url, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00212(url, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.SportzxProviderManager$fetchProviders$2 */
    /* JADX INFO: compiled from: SportzxProviderManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SportzxProviderManager$fetchProviders$2", f = "SportzxProviderManager.kt", i = {1, 1}, l = {245, 250}, m = "invokeSuspend", n = {"baseUrl", "url"}, nl = {246, 252}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nSportzxProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportzxProviderManager.kt\ncom/cncverse/SportzxProviderManager$fetchProviders$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,382:1\n63#2:383\n64#2,15:385\n1#3:384\n1#3:406\n50#4:400\n43#4:401\n1606#5:402\n1617#5:403\n1924#5,2:404\n1926#5:407\n1618#5:408\n*S KotlinDebug\n*F\n+ 1 SportzxProviderManager.kt\ncom/cncverse/SportzxProviderManager$fetchProviders$2\n*L\n253#1:383\n253#1:385,15\n253#1:384\n259#1:406\n253#1:400\n253#1:401\n259#1:402\n259#1:403\n259#1:404,2\n259#1:407\n259#1:408\n*E\n"})
    static final class C00252 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>>, Object> {
        Object L$0;
        Object L$1;
        int label;

        C00252(Continuation<? super C00252> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00252(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x004a A[Catch: Exception -> 0x002a, TryCatch #1 {Exception -> 0x002a, blocks: (B:7:0x001d, B:23:0x0094, B:25:0x0098, B:56:0x013a, B:57:0x014e, B:59:0x0154, B:61:0x015c, B:62:0x015f, B:64:0x0171, B:80:0x01e2, B:67:0x0182, B:69:0x0193, B:71:0x0199, B:73:0x01a0, B:76:0x01c2, B:72:0x019e, B:82:0x01ed, B:84:0x01f5, B:8:0x0024, B:16:0x003f, B:18:0x004a, B:20:0x004f, B:13:0x0031, B:28:0x009e, B:34:0x00d2, B:42:0x0100, B:45:0x0107, B:55:0x0137, B:54:0x0122, B:53:0x011c, B:41:0x00f5, B:33:0x00c8), top: B:90:0x000a, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:20:0x004f A[Catch: Exception -> 0x002a, TryCatch #1 {Exception -> 0x002a, blocks: (B:7:0x001d, B:23:0x0094, B:25:0x0098, B:56:0x013a, B:57:0x014e, B:59:0x0154, B:61:0x015c, B:62:0x015f, B:64:0x0171, B:80:0x01e2, B:67:0x0182, B:69:0x0193, B:71:0x0199, B:73:0x01a0, B:76:0x01c2, B:72:0x019e, B:82:0x01ed, B:84:0x01f5, B:8:0x0024, B:16:0x003f, B:18:0x004a, B:20:0x004f, B:13:0x0031, B:28:0x009e, B:34:0x00d2, B:42:0x0100, B:45:0x0107, B:55:0x0137, B:54:0x0122, B:53:0x011c, B:41:0x00f5, B:33:0x00c8), top: B:90:0x000a, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:22:0x0093 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:25:0x0098 A[Catch: Exception -> 0x002a, TRY_LEAVE, TryCatch #1 {Exception -> 0x002a, blocks: (B:7:0x001d, B:23:0x0094, B:25:0x0098, B:56:0x013a, B:57:0x014e, B:59:0x0154, B:61:0x015c, B:62:0x015f, B:64:0x0171, B:80:0x01e2, B:67:0x0182, B:69:0x0193, B:71:0x0199, B:73:0x01a0, B:76:0x01c2, B:72:0x019e, B:82:0x01ed, B:84:0x01f5, B:8:0x0024, B:16:0x003f, B:18:0x004a, B:20:0x004f, B:13:0x0031, B:28:0x009e, B:34:0x00d2, B:42:0x0100, B:45:0x0107, B:55:0x0137, B:54:0x0122, B:53:0x011c, B:41:0x00f5, B:33:0x00c8), top: B:90:0x000a, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:44:0x0106  */
        /* JADX WARN: Code duplicated, block: B:54:0x0122 A[Catch: Exception -> 0x01f4, TryCatch #5 {Exception -> 0x01f4, blocks: (B:28:0x009e, B:34:0x00d2, B:42:0x0100, B:45:0x0107, B:55:0x0137, B:54:0x0122, B:53:0x011c, B:41:0x00f5, B:33:0x00c8, B:38:0x00da, B:30:0x00a3, B:48:0x010d), top: B:93:0x009e, outer: #1, inners: #0, #3, #6 }] */
        /* JADX WARN: Code duplicated, block: B:59:0x0154 A[Catch: Exception -> 0x002a, TryCatch #1 {Exception -> 0x002a, blocks: (B:7:0x001d, B:23:0x0094, B:25:0x0098, B:56:0x013a, B:57:0x014e, B:59:0x0154, B:61:0x015c, B:62:0x015f, B:64:0x0171, B:80:0x01e2, B:67:0x0182, B:69:0x0193, B:71:0x0199, B:73:0x01a0, B:76:0x01c2, B:72:0x019e, B:82:0x01ed, B:84:0x01f5, B:8:0x0024, B:16:0x003f, B:18:0x004a, B:20:0x004f, B:13:0x0031, B:28:0x009e, B:34:0x00d2, B:42:0x0100, B:45:0x0107, B:55:0x0137, B:54:0x0122, B:53:0x011c, B:41:0x00f5, B:33:0x00c8), top: B:90:0x000a, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:61:0x015c A[Catch: Exception -> 0x002a, TryCatch #1 {Exception -> 0x002a, blocks: (B:7:0x001d, B:23:0x0094, B:25:0x0098, B:56:0x013a, B:57:0x014e, B:59:0x0154, B:61:0x015c, B:62:0x015f, B:64:0x0171, B:80:0x01e2, B:67:0x0182, B:69:0x0193, B:71:0x0199, B:73:0x01a0, B:76:0x01c2, B:72:0x019e, B:82:0x01ed, B:84:0x01f5, B:8:0x0024, B:16:0x003f, B:18:0x004a, B:20:0x004f, B:13:0x0031, B:28:0x009e, B:34:0x00d2, B:42:0x0100, B:45:0x0107, B:55:0x0137, B:54:0x0122, B:53:0x011c, B:41:0x00f5, B:33:0x00c8), top: B:90:0x000a, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:64:0x0171 A[Catch: Exception -> 0x002a, TryCatch #1 {Exception -> 0x002a, blocks: (B:7:0x001d, B:23:0x0094, B:25:0x0098, B:56:0x013a, B:57:0x014e, B:59:0x0154, B:61:0x015c, B:62:0x015f, B:64:0x0171, B:80:0x01e2, B:67:0x0182, B:69:0x0193, B:71:0x0199, B:73:0x01a0, B:76:0x01c2, B:72:0x019e, B:82:0x01ed, B:84:0x01f5, B:8:0x0024, B:16:0x003f, B:18:0x004a, B:20:0x004f, B:13:0x0031, B:28:0x009e, B:34:0x00d2, B:42:0x0100, B:45:0x0107, B:55:0x0137, B:54:0x0122, B:53:0x011c, B:41:0x00f5, B:33:0x00c8), top: B:90:0x000a, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:77:0x01db A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:80:0x01e2 A[Catch: Exception -> 0x002a, TryCatch #1 {Exception -> 0x002a, blocks: (B:7:0x001d, B:23:0x0094, B:25:0x0098, B:56:0x013a, B:57:0x014e, B:59:0x0154, B:61:0x015c, B:62:0x015f, B:64:0x0171, B:80:0x01e2, B:67:0x0182, B:69:0x0193, B:71:0x0199, B:73:0x01a0, B:76:0x01c2, B:72:0x019e, B:82:0x01ed, B:84:0x01f5, B:8:0x0024, B:16:0x003f, B:18:0x004a, B:20:0x004f, B:13:0x0031, B:28:0x009e, B:34:0x00d2, B:42:0x0100, B:45:0x0107, B:55:0x0137, B:54:0x0122, B:53:0x011c, B:41:0x00f5, B:33:0x00c8), top: B:90:0x000a, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:88:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:93:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:95:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:99:0x01e6 A[SYNTHETIC] */
        public final Object invokeSuspend(Object $result) {
            Object baseUrl;
            String baseUrl2;
            Object objFetchDecrypted;
            String json;
            Object obj;
            DeserializationStrategy deserializationStrategy;
            Object objDecodeFromString;
            Collection destination$iv$iv;
            int index$iv$iv;
            String catLink;
            Map mapMapOf;
            String catLink2;
            Integer intOrNull;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        baseUrl = SportzxProviderManager.INSTANCE.getBaseUrl((Continuation) this);
                        if (baseUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        baseUrl2 = (String) baseUrl;
                        if (StringsKt.isBlank(baseUrl2)) {
                            return CollectionsKt.emptyList();
                        }
                        String url = baseUrl2 + "/cats.json";
                        System.out.println((Object) ("Sportzx: Fetching categories from " + url));
                        this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        this.label = 2;
                        objFetchDecrypted = SportzxProviderManager.INSTANCE.fetchDecrypted(url, (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        try {
                            AppUtils appUtils = AppUtils.INSTANCE;
                            try {
                                Result.Companion companion = Result.Companion;
                                KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SportzxCategoryData.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                break;
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            if (Result.exceptionOrNull-impl(obj) != null) {
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                } catch (Throwable th2) {
                                    Result.Companion companion4 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th2));
                                }
                                break;
                            }
                            if (Result.isFailure-impl(obj)) {
                                obj = null;
                            }
                            deserializationStrategy = (KSerializer) obj;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                                } catch (SerializationException e) {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv.readValue(json, new TypeReference<List<? extends SportzxCategoryData>>() { // from class: com.cncverse.SportzxProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                } catch (Throwable th3) {
                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv2.readValue(json, new TypeReference<List<? extends SportzxCategoryData>>() { // from class: com.cncverse.SportzxProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                }
                                break;
                            } else {
                                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv3.readValue(json, new TypeReference<List<? extends SportzxCategoryData>>() { // from class: com.cncverse.SportzxProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                            Iterable categories = (List) objDecodeFromString;
                            Iterable $this$mapIndexedNotNull$iv = categories;
                            destination$iv$iv = new ArrayList();
                            index$iv$iv = 0;
                            for (Object item$iv$iv$iv : $this$mapIndexedNotNull$iv) {
                                int index$iv$iv$iv = index$iv$iv + 1;
                                if (index$iv$iv < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                SportzxCategoryData cat = (SportzxCategoryData) item$iv$iv$iv;
                                int index = index$iv$iv;
                                catLink = cat.getCatLink();
                                if (catLink != null || (catLink2 = StringsKt.trim(catLink).toString()) == null) {
                                    mapMapOf = null;
                                } else {
                                    Pair[] pairArr = new Pair[4];
                                    String id = cat.getId();
                                    pairArr[0] = TuplesKt.to("id", Boxing.boxInt((id == null || (intOrNull = StringsKt.toIntOrNull(id)) == null) ? index + 1 : intOrNull.intValue()));
                                    pairArr[1] = TuplesKt.to("title", cat.getTitle());
                                    String image = cat.getImage();
                                    if (image == null) {
                                        image = "";
                                    }
                                    pairArr[2] = TuplesKt.to("image", image);
                                    pairArr[3] = TuplesKt.to("catLink", catLink2);
                                    mapMapOf = MapsKt.mapOf(pairArr);
                                }
                                if (mapMapOf != null) {
                                    destination$iv$iv.add(mapMapOf);
                                }
                                index$iv$iv = index$iv$iv$iv;
                            }
                            return (List) destination$iv$iv;
                        } catch (Exception e2) {
                            System.out.println((Object) ("Sportzx: Failed to parse categories — " + e2.getMessage()));
                            return CollectionsKt.emptyList();
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        baseUrl = $result;
                        baseUrl2 = (String) baseUrl;
                        if (StringsKt.isBlank(baseUrl2)) {
                            return CollectionsKt.emptyList();
                        }
                        String url2 = baseUrl2 + "/cats.json";
                        System.out.println((Object) ("Sportzx: Fetching categories from " + url2));
                        this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        this.label = 2;
                        objFetchDecrypted = SportzxProviderManager.INSTANCE.fetchDecrypted(url2, (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils2 = AppUtils.INSTANCE;
                        Result.Companion companion5 = Result.Companion;
                        KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SportzxCategoryData.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion6 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            break;
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv4.readValue(json, new TypeReference<List<? extends SportzxCategoryData>>() { // from class: com.cncverse.SportzxProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        Iterable categories2 = (List) objDecodeFromString;
                        Iterable $this$mapIndexedNotNull$iv2 = categories2;
                        destination$iv$iv = new ArrayList();
                        index$iv$iv = 0;
                        while (r16.hasNext()) {
                            int index$iv$iv$iv2 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            SportzxCategoryData cat2 = (SportzxCategoryData) item$iv$iv$iv;
                            int index2 = index$iv$iv;
                            catLink = cat2.getCatLink();
                            if (catLink != null) {
                            }
                            mapMapOf = null;
                            if (mapMapOf != null) {
                                destination$iv$iv.add(mapMapOf);
                            }
                            index$iv$iv = index$iv$iv$iv2;
                        }
                        return (List) destination$iv$iv;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        objFetchDecrypted = $result;
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils3 = AppUtils.INSTANCE;
                        Result.Companion companion7 = Result.Companion;
                        KType kTypeTypeOf3 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SportzxCategoryData.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion8 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            break;
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv5.readValue(json, new TypeReference<List<? extends SportzxCategoryData>>() { // from class: com.cncverse.SportzxProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        Iterable categories3 = (List) objDecodeFromString;
                        Iterable $this$mapIndexedNotNull$iv3 = categories3;
                        destination$iv$iv = new ArrayList();
                        index$iv$iv = 0;
                        while (r16.hasNext()) {
                            int index$iv$iv$iv3 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            SportzxCategoryData cat3 = (SportzxCategoryData) item$iv$iv$iv;
                            int index3 = index$iv$iv;
                            catLink = cat3.getCatLink();
                            if (catLink != null) {
                            }
                            mapMapOf = null;
                            if (mapMapOf != null) {
                                destination$iv$iv.add(mapMapOf);
                            }
                            index$iv$iv = index$iv$iv$iv3;
                        }
                        return (List) destination$iv$iv;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e3) {
                System.out.println((Object) ("Sportzx: fetchProviders exception — " + e3.getMessage()));
                return CollectionsKt.emptyList();
            }
        }
    }

    @Nullable
    public final Object fetchProviders(@NotNull Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00252(null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.SportzxProviderManager$fetchLiveEvents$2 */
    /* JADX INFO: compiled from: SportzxProviderManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/cncverse/SportzxLiveEventData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SportzxProviderManager$fetchLiveEvents$2", f = "SportzxProviderManager.kt", i = {1, 1}, l = {282, 287}, m = "invokeSuspend", n = {"baseUrl", "url"}, nl = {283, 289}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nSportzxProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportzxProviderManager.kt\ncom/cncverse/SportzxProviderManager$fetchLiveEvents$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,382:1\n63#2:383\n64#2,15:385\n1#3:384\n1#3:406\n1#3:411\n50#4:400\n43#4:401\n1606#5:402\n1617#5:403\n1924#5,2:404\n1586#5:407\n1661#5,3:408\n1926#5:412\n1618#5:413\n*S KotlinDebug\n*F\n+ 1 SportzxProviderManager.kt\ncom/cncverse/SportzxProviderManager$fetchLiveEvents$2\n*L\n290#1:383\n290#1:385,15\n290#1:384\n296#1:411\n290#1:400\n290#1:401\n296#1:402\n296#1:403\n296#1:404,2\n322#1:407\n322#1:408,3\n296#1:412\n296#1:413\n*E\n"})
    static final class C00232 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SportzxLiveEventData>>, Object> {
        final /* synthetic */ String $path;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00232(String str, Continuation<? super C00232> continuation) {
            super(2, continuation);
            this.$path = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00232(this.$path, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<SportzxLiveEventData>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:102:0x020c A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:103:0x0213  */
        /* JADX WARN: Code duplicated, block: B:106:0x021b A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:107:0x0222  */
        /* JADX WARN: Code duplicated, block: B:110:0x022e A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:112:0x0234 A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:115:0x0240 A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:120:0x0251  */
        /* JADX WARN: Code duplicated, block: B:123:0x0259 A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:124:0x0260  */
        /* JADX WARN: Code duplicated, block: B:127:0x0268 A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:132:0x0279  */
        /* JADX WARN: Code duplicated, block: B:135:0x0281 A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:136:0x0288  */
        /* JADX WARN: Code duplicated, block: B:139:0x0298  */
        /* JADX WARN: Code duplicated, block: B:141:0x029d A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:143:0x02a3 A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:144:0x02a8  */
        /* JADX WARN: Code duplicated, block: B:147:0x02b7 A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:150:0x02d4 A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:152:0x02eb A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:155:0x0300  */
        /* JADX WARN: Code duplicated, block: B:158:0x0322 A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:162:0x0343 A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:171:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:176:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:180:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:184:0x0349 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:18:0x004b A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:20:0x0050 A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:22:0x009a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:25:0x009f A[Catch: Exception -> 0x002b, TRY_LEAVE, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:44:0x010d  */
        /* JADX WARN: Code duplicated, block: B:57:0x012f A[Catch: Exception -> 0x035f, TRY_ENTER, TryCatch #1 {Exception -> 0x035f, blocks: (B:28:0x00a5, B:34:0x00d9, B:42:0x0107, B:45:0x010e, B:58:0x0144, B:57:0x012f, B:41:0x00fc, B:33:0x00cf, B:38:0x00e1, B:30:0x00aa), top: B:171:0x00a5, inners: #4, #6 }] */
        /* JADX WARN: Code duplicated, block: B:62:0x0163 A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:64:0x016b A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:67:0x0186 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:68:0x018e A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:72:0x01a2  */
        /* JADX WARN: Code duplicated, block: B:76:0x01ae A[Catch: Exception -> 0x002b, TRY_ENTER, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:85:0x01ca  */
        /* JADX WARN: Code duplicated, block: B:88:0x01d2 A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:91:0x01e0  */
        /* JADX WARN: Code duplicated, block: B:94:0x01ee A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:95:0x01f5  */
        /* JADX WARN: Code duplicated, block: B:98:0x01fd A[Catch: Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x009b, B:25:0x009f, B:59:0x0147, B:60:0x015d, B:62:0x0163, B:64:0x016b, B:65:0x016e, B:162:0x0343, B:68:0x018e, B:70:0x0194, B:73:0x01a4, B:76:0x01ae, B:78:0x01b4, B:86:0x01cc, B:88:0x01d2, B:92:0x01e2, B:94:0x01ee, B:96:0x01f7, B:98:0x01fd, B:100:0x0206, B:102:0x020c, B:104:0x0215, B:106:0x021b, B:108:0x0224, B:110:0x022e, B:113:0x0238, B:115:0x0240, B:117:0x0246, B:121:0x0253, B:123:0x0259, B:125:0x0262, B:127:0x0268, B:129:0x026e, B:133:0x027b, B:135:0x0281, B:137:0x028a, B:145:0x02aa, B:147:0x02b7, B:148:0x02ce, B:150:0x02d4, B:152:0x02eb, B:156:0x0303, B:157:0x0315, B:159:0x032a, B:158:0x0322, B:141:0x029d, B:143:0x02a3, B:112:0x0234, B:164:0x0355, B:167:0x0362, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032), top: B:173:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:99:0x0204  */
        public final Object invokeSuspend(Object $result) {
            Object baseUrl;
            String baseUrl2;
            Object objFetchDecrypted;
            String json;
            Object obj;
            DeserializationStrategy deserializationStrategy;
            Object objDecodeFromString;
            List events;
            String str;
            Collection destination$iv$iv;
            int index$iv$iv$iv;
            SportzxEventData ev;
            int index;
            Integer id;
            List events2;
            String baseUrl3;
            SportzxLiveEventData sportzxLiveEventData;
            String title;
            SportzxEventInfo eventInfo;
            String str2;
            SportzxEventInfo eventInfo2;
            String teamA;
            SportzxEventInfo eventInfo3;
            String teamB;
            SportzxEventInfo eventInfo4;
            String teamAFlag;
            SportzxEventInfo eventInfo5;
            String teamBFlag;
            SportzxEventInfo eventInfo6;
            String title2;
            SportzxEventInfo eventInfo7;
            String str3;
            SportzxEventInfo eventInfo8;
            String strIsHot;
            SportzxEventInfo eventInfo9;
            String str4;
            SportzxEventInfo eventInfo10;
            String startTime;
            SportzxEventInfo eventInfo11;
            String str5;
            String endTime;
            Iterable formatsNew;
            List listEmptyList;
            Iterable $this$map$iv;
            int $i$f$map;
            Collection destination$iv$iv2;
            String it;
            String str6;
            String it2;
            String it3;
            String it4;
            String it5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        baseUrl = SportzxProviderManager.INSTANCE.getBaseUrl((Continuation) this);
                        if (baseUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        baseUrl2 = (String) baseUrl;
                        if (StringsKt.isBlank(baseUrl2)) {
                            return CollectionsKt.emptyList();
                        }
                        String url = baseUrl2 + '/' + this.$path;
                        System.out.println((Object) ("Sportzx: Fetching events from " + url));
                        this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        this.label = 2;
                        objFetchDecrypted = SportzxProviderManager.INSTANCE.fetchDecrypted(url, (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        try {
                            AppUtils appUtils = AppUtils.INSTANCE;
                            try {
                                Result.Companion companion = Result.Companion;
                                KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SportzxEventData.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                break;
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            if (Result.exceptionOrNull-impl(obj) != null) {
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                } catch (Throwable th2) {
                                    Result.Companion companion4 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th2));
                                }
                                break;
                            }
                            if (Result.isFailure-impl(obj)) {
                                obj = null;
                            }
                            deserializationStrategy = (KSerializer) obj;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                                    break;
                                } catch (SerializationException e) {
                                    try {
                                        ArchComponentExtKt.logError(e);
                                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv.readValue(json, new TypeReference<List<? extends SportzxEventData>>() { // from class: com.cncverse.SportzxProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                                        });
                                    } catch (Exception e2) {
                                        e = e2;
                                        System.out.println((Object) ("Sportzx: Failed to parse events — " + e.getMessage()));
                                        return CollectionsKt.emptyList();
                                    }
                                } catch (Throwable th3) {
                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv2.readValue(json, new TypeReference<List<? extends SportzxEventData>>() { // from class: com.cncverse.SportzxProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                }
                            } else {
                                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv3.readValue(json, new TypeReference<List<? extends SportzxEventData>>() { // from class: com.cncverse.SportzxProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                            events = (List) objDecodeFromString;
                            List $this$mapIndexedNotNull$iv = events;
                            str = this.$path;
                            destination$iv$iv = new ArrayList();
                            index$iv$iv$iv = 0;
                            for (Object item$iv$iv$iv : $this$mapIndexedNotNull$iv) {
                                int index$iv$iv$iv2 = index$iv$iv$iv + 1;
                                if (index$iv$iv$iv < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                ev = (SportzxEventData) item$iv$iv$iv;
                                index = index$iv$iv$iv;
                                if (Intrinsics.areEqual(ev.getPublish(), "1") || (id = ev.getId()) == null) {
                                    events2 = events;
                                    baseUrl3 = baseUrl2;
                                    sportzxLiveEventData = null;
                                } else {
                                    int eventId = id.intValue();
                                    int i = index + 1;
                                    title = ev.getTitle();
                                    if (title == null) {
                                        title = "Unknown Event";
                                    }
                                    String str7 = title;
                                    eventInfo = ev.getEventInfo();
                                    if (eventInfo != null || (it5 = eventInfo.getEventBanner()) == null) {
                                        events2 = events;
                                    } else {
                                        events2 = events;
                                        if (Intrinsics.areEqual(it5, "null")) {
                                            it5 = null;
                                        }
                                        if (it5 != null) {
                                            str2 = it5;
                                        }
                                        String cat = ev.getCat();
                                        eventInfo2 = ev.getEventInfo();
                                        if (eventInfo2 != null) {
                                            teamA = eventInfo2.getTeamA();
                                        } else {
                                            teamA = null;
                                        }
                                        eventInfo3 = ev.getEventInfo();
                                        if (eventInfo3 != null) {
                                            teamB = eventInfo3.getTeamB();
                                        } else {
                                            teamB = null;
                                        }
                                        eventInfo4 = ev.getEventInfo();
                                        if (eventInfo4 != null) {
                                            teamAFlag = eventInfo4.getTeamAFlag();
                                        } else {
                                            teamAFlag = null;
                                        }
                                        eventInfo5 = ev.getEventInfo();
                                        if (eventInfo5 != null) {
                                            teamBFlag = eventInfo5.getTeamBFlag();
                                        } else {
                                            teamBFlag = null;
                                        }
                                        String cat2 = ev.getCat();
                                        eventInfo6 = ev.getEventInfo();
                                        if (eventInfo6 != null || (title2 = eventInfo6.getEventName()) == null) {
                                            title2 = ev.getTitle();
                                        }
                                        String str8 = title2;
                                        eventInfo7 = ev.getEventInfo();
                                        if (eventInfo7 != null || (it3 = eventInfo7.getEventBanner()) == null || Intrinsics.areEqual(it3, "null")) {
                                            str3 = null;
                                        } else {
                                            str3 = it3;
                                        }
                                        eventInfo8 = ev.getEventInfo();
                                        if (eventInfo8 != null) {
                                            strIsHot = eventInfo8.isHot();
                                        } else {
                                            strIsHot = null;
                                        }
                                        eventInfo9 = ev.getEventInfo();
                                        if (eventInfo9 != null || (it2 = eventInfo9.getEventType()) == null || Intrinsics.areEqual(it2, "null")) {
                                            str4 = null;
                                        } else {
                                            str4 = it2;
                                        }
                                        eventInfo10 = ev.getEventInfo();
                                        if (eventInfo10 != null) {
                                            startTime = eventInfo10.getStartTime();
                                        } else {
                                            startTime = null;
                                        }
                                        if (StringsKt.contains(str, "highlights", true)) {
                                            endTime = "1970/01/01 00:00:00 +0000";
                                        } else {
                                            eventInfo11 = ev.getEventInfo();
                                            if (eventInfo11 != null) {
                                                endTime = eventInfo11.getEndTime();
                                            } else {
                                                str5 = null;
                                            }
                                            SportzxLiveEventInfo sportzxLiveEventInfo = new SportzxLiveEventInfo(teamA, teamB, teamAFlag, teamBFlag, cat2, str8, str3, strIsHot, str4, startTime, str5);
                                            formatsNew = ev.getFormatsNew();
                                            if (formatsNew != null) {
                                                $this$map$iv = formatsNew;
                                                $i$f$map = 0;
                                                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                                for (Object item$iv$iv : $this$map$iv) {
                                                    SportzxFormat fmt = (SportzxFormat) item$iv$iv;
                                                    Iterable $this$map$iv2 = $this$map$iv;
                                                    String title3 = fmt.getTitle();
                                                    it = fmt.getLogo();
                                                    if (it != null || StringsKt.isBlank(it)) {
                                                        str6 = null;
                                                    } else {
                                                        str6 = it;
                                                    }
                                                    destination$iv$iv2.add(new SportzxLiveEventFormat(title3, str6));
                                                    $this$map$iv = $this$map$iv2;
                                                    $i$f$map = $i$f$map;
                                                    baseUrl2 = baseUrl2;
                                                }
                                                baseUrl3 = baseUrl2;
                                                listEmptyList = (List) destination$iv$iv2;
                                            } else {
                                                baseUrl3 = baseUrl2;
                                                listEmptyList = CollectionsKt.emptyList();
                                            }
                                            sportzxLiveEventData = new SportzxLiveEventData(i, str7, str2, eventId, cat, sportzxLiveEventInfo, 1, listEmptyList);
                                        }
                                        str5 = endTime;
                                        SportzxLiveEventInfo sportzxLiveEventInfo2 = new SportzxLiveEventInfo(teamA, teamB, teamAFlag, teamBFlag, cat2, str8, str3, strIsHot, str4, startTime, str5);
                                        formatsNew = ev.getFormatsNew();
                                        if (formatsNew != null) {
                                            $this$map$iv = formatsNew;
                                            $i$f$map = 0;
                                            destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                            while (r31.hasNext()) {
                                                SportzxFormat fmt2 = (SportzxFormat) item$iv$iv;
                                                Iterable $this$map$iv3 = $this$map$iv;
                                                String title4 = fmt2.getTitle();
                                                it = fmt2.getLogo();
                                                if (it != null) {
                                                    str6 = null;
                                                } else {
                                                    str6 = null;
                                                }
                                                destination$iv$iv2.add(new SportzxLiveEventFormat(title4, str6));
                                                $this$map$iv = $this$map$iv3;
                                                $i$f$map = $i$f$map;
                                                baseUrl2 = baseUrl2;
                                            }
                                            baseUrl3 = baseUrl2;
                                            listEmptyList = (List) destination$iv$iv2;
                                        } else {
                                            baseUrl3 = baseUrl2;
                                            listEmptyList = CollectionsKt.emptyList();
                                        }
                                        sportzxLiveEventData = new SportzxLiveEventData(i, str7, str2, eventId, cat, sportzxLiveEventInfo2, 1, listEmptyList);
                                    }
                                    it4 = ev.getImage();
                                    if (it4 != null || Intrinsics.areEqual(it4, "o")) {
                                        str2 = null;
                                    } else {
                                        str2 = it4;
                                    }
                                    String cat3 = ev.getCat();
                                    eventInfo2 = ev.getEventInfo();
                                    if (eventInfo2 != null) {
                                        teamA = eventInfo2.getTeamA();
                                    } else {
                                        teamA = null;
                                    }
                                    eventInfo3 = ev.getEventInfo();
                                    if (eventInfo3 != null) {
                                        teamB = eventInfo3.getTeamB();
                                    } else {
                                        teamB = null;
                                    }
                                    eventInfo4 = ev.getEventInfo();
                                    if (eventInfo4 != null) {
                                        teamAFlag = eventInfo4.getTeamAFlag();
                                    } else {
                                        teamAFlag = null;
                                    }
                                    eventInfo5 = ev.getEventInfo();
                                    if (eventInfo5 != null) {
                                        teamBFlag = eventInfo5.getTeamBFlag();
                                    } else {
                                        teamBFlag = null;
                                    }
                                    String cat4 = ev.getCat();
                                    eventInfo6 = ev.getEventInfo();
                                    if (eventInfo6 != null) {
                                        title2 = ev.getTitle();
                                    } else {
                                        title2 = ev.getTitle();
                                    }
                                    String str9 = title2;
                                    eventInfo7 = ev.getEventInfo();
                                    if (eventInfo7 != null) {
                                        str3 = null;
                                    } else {
                                        str3 = null;
                                    }
                                    eventInfo8 = ev.getEventInfo();
                                    if (eventInfo8 != null) {
                                        strIsHot = eventInfo8.isHot();
                                    } else {
                                        strIsHot = null;
                                    }
                                    eventInfo9 = ev.getEventInfo();
                                    if (eventInfo9 != null) {
                                        str4 = null;
                                    } else {
                                        str4 = null;
                                    }
                                    eventInfo10 = ev.getEventInfo();
                                    if (eventInfo10 != null) {
                                        startTime = eventInfo10.getStartTime();
                                    } else {
                                        startTime = null;
                                    }
                                    if (StringsKt.contains(str, "highlights", true)) {
                                        endTime = "1970/01/01 00:00:00 +0000";
                                    } else {
                                        eventInfo11 = ev.getEventInfo();
                                        if (eventInfo11 != null) {
                                            endTime = eventInfo11.getEndTime();
                                        } else {
                                            str5 = null;
                                        }
                                        SportzxLiveEventInfo sportzxLiveEventInfo3 = new SportzxLiveEventInfo(teamA, teamB, teamAFlag, teamBFlag, cat4, str9, str3, strIsHot, str4, startTime, str5);
                                        formatsNew = ev.getFormatsNew();
                                        if (formatsNew != null) {
                                            $this$map$iv = formatsNew;
                                            $i$f$map = 0;
                                            destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                            while (r31.hasNext()) {
                                                SportzxFormat fmt3 = (SportzxFormat) item$iv$iv;
                                                Iterable $this$map$iv4 = $this$map$iv;
                                                String title5 = fmt3.getTitle();
                                                it = fmt3.getLogo();
                                                if (it != null) {
                                                    str6 = null;
                                                } else {
                                                    str6 = null;
                                                }
                                                destination$iv$iv2.add(new SportzxLiveEventFormat(title5, str6));
                                                $this$map$iv = $this$map$iv4;
                                                $i$f$map = $i$f$map;
                                                baseUrl2 = baseUrl2;
                                            }
                                            baseUrl3 = baseUrl2;
                                            listEmptyList = (List) destination$iv$iv2;
                                        } else {
                                            baseUrl3 = baseUrl2;
                                            listEmptyList = CollectionsKt.emptyList();
                                        }
                                        sportzxLiveEventData = new SportzxLiveEventData(i, str7, str2, eventId, cat3, sportzxLiveEventInfo3, 1, listEmptyList);
                                    }
                                    str5 = endTime;
                                    SportzxLiveEventInfo sportzxLiveEventInfo4 = new SportzxLiveEventInfo(teamA, teamB, teamAFlag, teamBFlag, cat4, str9, str3, strIsHot, str4, startTime, str5);
                                    formatsNew = ev.getFormatsNew();
                                    if (formatsNew != null) {
                                        $this$map$iv = formatsNew;
                                        $i$f$map = 0;
                                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                        while (r31.hasNext()) {
                                            SportzxFormat fmt4 = (SportzxFormat) item$iv$iv;
                                            Iterable $this$map$iv5 = $this$map$iv;
                                            String title6 = fmt4.getTitle();
                                            it = fmt4.getLogo();
                                            if (it != null) {
                                                str6 = null;
                                            } else {
                                                str6 = null;
                                            }
                                            destination$iv$iv2.add(new SportzxLiveEventFormat(title6, str6));
                                            $this$map$iv = $this$map$iv5;
                                            $i$f$map = $i$f$map;
                                            baseUrl2 = baseUrl2;
                                        }
                                        baseUrl3 = baseUrl2;
                                        listEmptyList = (List) destination$iv$iv2;
                                    } else {
                                        baseUrl3 = baseUrl2;
                                        listEmptyList = CollectionsKt.emptyList();
                                    }
                                    sportzxLiveEventData = new SportzxLiveEventData(i, str7, str2, eventId, cat3, sportzxLiveEventInfo4, 1, listEmptyList);
                                }
                                if (sportzxLiveEventData != null) {
                                    destination$iv$iv.add(sportzxLiveEventData);
                                }
                                index$iv$iv$iv = index$iv$iv$iv2;
                                events = events2;
                                baseUrl2 = baseUrl3;
                            }
                            return (List) destination$iv$iv;
                        } catch (Exception e3) {
                            e = e3;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        baseUrl = $result;
                        baseUrl2 = (String) baseUrl;
                        if (StringsKt.isBlank(baseUrl2)) {
                            return CollectionsKt.emptyList();
                        }
                        String url2 = baseUrl2 + '/' + this.$path;
                        System.out.println((Object) ("Sportzx: Fetching events from " + url2));
                        this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        this.label = 2;
                        objFetchDecrypted = SportzxProviderManager.INSTANCE.fetchDecrypted(url2, (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils2 = AppUtils.INSTANCE;
                        Result.Companion companion5 = Result.Companion;
                        KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SportzxEventData.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion6 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            break;
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv4.readValue(json, new TypeReference<List<? extends SportzxEventData>>() { // from class: com.cncverse.SportzxProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        events = (List) objDecodeFromString;
                        List $this$mapIndexedNotNull$iv2 = events;
                        str = this.$path;
                        destination$iv$iv = new ArrayList();
                        index$iv$iv$iv = 0;
                        while (r16.hasNext()) {
                            int index$iv$iv$iv3 = index$iv$iv$iv + 1;
                            if (index$iv$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            ev = (SportzxEventData) item$iv$iv$iv;
                            index = index$iv$iv$iv;
                            if (Intrinsics.areEqual(ev.getPublish(), "1")) {
                                events2 = events;
                                baseUrl3 = baseUrl2;
                                sportzxLiveEventData = null;
                            } else {
                                int eventId2 = id.intValue();
                                int i2 = index + 1;
                                title = ev.getTitle();
                                if (title == null) {
                                    title = "Unknown Event";
                                }
                                String str10 = title;
                                eventInfo = ev.getEventInfo();
                                if (eventInfo != null) {
                                    events2 = events;
                                    it4 = ev.getImage();
                                    if (it4 != null) {
                                        str2 = null;
                                    } else {
                                        str2 = null;
                                    }
                                } else {
                                    events2 = events;
                                    it4 = ev.getImage();
                                    if (it4 != null) {
                                        str2 = null;
                                    } else {
                                        str2 = null;
                                    }
                                }
                                String cat5 = ev.getCat();
                                eventInfo2 = ev.getEventInfo();
                                if (eventInfo2 != null) {
                                    teamA = eventInfo2.getTeamA();
                                } else {
                                    teamA = null;
                                }
                                eventInfo3 = ev.getEventInfo();
                                if (eventInfo3 != null) {
                                    teamB = eventInfo3.getTeamB();
                                } else {
                                    teamB = null;
                                }
                                eventInfo4 = ev.getEventInfo();
                                if (eventInfo4 != null) {
                                    teamAFlag = eventInfo4.getTeamAFlag();
                                } else {
                                    teamAFlag = null;
                                }
                                eventInfo5 = ev.getEventInfo();
                                if (eventInfo5 != null) {
                                    teamBFlag = eventInfo5.getTeamBFlag();
                                } else {
                                    teamBFlag = null;
                                }
                                String cat6 = ev.getCat();
                                eventInfo6 = ev.getEventInfo();
                                if (eventInfo6 != null) {
                                    title2 = ev.getTitle();
                                } else {
                                    title2 = ev.getTitle();
                                }
                                String str11 = title2;
                                eventInfo7 = ev.getEventInfo();
                                if (eventInfo7 != null) {
                                    str3 = null;
                                } else {
                                    str3 = null;
                                }
                                eventInfo8 = ev.getEventInfo();
                                if (eventInfo8 != null) {
                                    strIsHot = eventInfo8.isHot();
                                } else {
                                    strIsHot = null;
                                }
                                eventInfo9 = ev.getEventInfo();
                                if (eventInfo9 != null) {
                                    str4 = null;
                                } else {
                                    str4 = null;
                                }
                                eventInfo10 = ev.getEventInfo();
                                if (eventInfo10 != null) {
                                    startTime = eventInfo10.getStartTime();
                                } else {
                                    startTime = null;
                                }
                                if (StringsKt.contains(str, "highlights", true)) {
                                    endTime = "1970/01/01 00:00:00 +0000";
                                } else {
                                    eventInfo11 = ev.getEventInfo();
                                    if (eventInfo11 != null) {
                                        endTime = eventInfo11.getEndTime();
                                    } else {
                                        str5 = null;
                                    }
                                    SportzxLiveEventInfo sportzxLiveEventInfo5 = new SportzxLiveEventInfo(teamA, teamB, teamAFlag, teamBFlag, cat6, str11, str3, strIsHot, str4, startTime, str5);
                                    formatsNew = ev.getFormatsNew();
                                    if (formatsNew != null) {
                                        $this$map$iv = formatsNew;
                                        $i$f$map = 0;
                                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                        while (r31.hasNext()) {
                                            SportzxFormat fmt5 = (SportzxFormat) item$iv$iv;
                                            Iterable $this$map$iv6 = $this$map$iv;
                                            String title7 = fmt5.getTitle();
                                            it = fmt5.getLogo();
                                            if (it != null) {
                                                str6 = null;
                                            } else {
                                                str6 = null;
                                            }
                                            destination$iv$iv2.add(new SportzxLiveEventFormat(title7, str6));
                                            $this$map$iv = $this$map$iv6;
                                            $i$f$map = $i$f$map;
                                            baseUrl2 = baseUrl2;
                                        }
                                        baseUrl3 = baseUrl2;
                                        listEmptyList = (List) destination$iv$iv2;
                                    } else {
                                        baseUrl3 = baseUrl2;
                                        listEmptyList = CollectionsKt.emptyList();
                                    }
                                    sportzxLiveEventData = new SportzxLiveEventData(i2, str10, str2, eventId2, cat5, sportzxLiveEventInfo5, 1, listEmptyList);
                                }
                                str5 = endTime;
                                SportzxLiveEventInfo sportzxLiveEventInfo6 = new SportzxLiveEventInfo(teamA, teamB, teamAFlag, teamBFlag, cat6, str11, str3, strIsHot, str4, startTime, str5);
                                formatsNew = ev.getFormatsNew();
                                if (formatsNew != null) {
                                    $this$map$iv = formatsNew;
                                    $i$f$map = 0;
                                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                    while (r31.hasNext()) {
                                        SportzxFormat fmt6 = (SportzxFormat) item$iv$iv;
                                        Iterable $this$map$iv7 = $this$map$iv;
                                        String title8 = fmt6.getTitle();
                                        it = fmt6.getLogo();
                                        if (it != null) {
                                            str6 = null;
                                        } else {
                                            str6 = null;
                                        }
                                        destination$iv$iv2.add(new SportzxLiveEventFormat(title8, str6));
                                        $this$map$iv = $this$map$iv7;
                                        $i$f$map = $i$f$map;
                                        baseUrl2 = baseUrl2;
                                    }
                                    baseUrl3 = baseUrl2;
                                    listEmptyList = (List) destination$iv$iv2;
                                } else {
                                    baseUrl3 = baseUrl2;
                                    listEmptyList = CollectionsKt.emptyList();
                                }
                                sportzxLiveEventData = new SportzxLiveEventData(i2, str10, str2, eventId2, cat5, sportzxLiveEventInfo6, 1, listEmptyList);
                            }
                            if (sportzxLiveEventData != null) {
                                destination$iv$iv.add(sportzxLiveEventData);
                            }
                            index$iv$iv$iv = index$iv$iv$iv3;
                            events = events2;
                            baseUrl2 = baseUrl3;
                        }
                        return (List) destination$iv$iv;
                    case 2:
                        baseUrl2 = (String) this.L$0;
                        ResultKt.throwOnFailure($result);
                        objFetchDecrypted = $result;
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils3 = AppUtils.INSTANCE;
                        Result.Companion companion7 = Result.Companion;
                        KType kTypeTypeOf3 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SportzxEventData.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion8 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            break;
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv5.readValue(json, new TypeReference<List<? extends SportzxEventData>>() { // from class: com.cncverse.SportzxProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        events = (List) objDecodeFromString;
                        List $this$mapIndexedNotNull$iv3 = events;
                        str = this.$path;
                        destination$iv$iv = new ArrayList();
                        index$iv$iv$iv = 0;
                        while (r16.hasNext()) {
                            int index$iv$iv$iv4 = index$iv$iv$iv + 1;
                            if (index$iv$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            ev = (SportzxEventData) item$iv$iv$iv;
                            index = index$iv$iv$iv;
                            if (Intrinsics.areEqual(ev.getPublish(), "1")) {
                                events2 = events;
                                baseUrl3 = baseUrl2;
                                sportzxLiveEventData = null;
                            } else {
                                int eventId3 = id.intValue();
                                int i3 = index + 1;
                                title = ev.getTitle();
                                if (title == null) {
                                    title = "Unknown Event";
                                }
                                String str12 = title;
                                eventInfo = ev.getEventInfo();
                                if (eventInfo != null) {
                                    events2 = events;
                                    it4 = ev.getImage();
                                    if (it4 != null) {
                                        str2 = null;
                                    } else {
                                        str2 = null;
                                    }
                                } else {
                                    events2 = events;
                                    it4 = ev.getImage();
                                    if (it4 != null) {
                                        str2 = null;
                                    } else {
                                        str2 = null;
                                    }
                                }
                                String cat7 = ev.getCat();
                                eventInfo2 = ev.getEventInfo();
                                if (eventInfo2 != null) {
                                    teamA = eventInfo2.getTeamA();
                                } else {
                                    teamA = null;
                                }
                                eventInfo3 = ev.getEventInfo();
                                if (eventInfo3 != null) {
                                    teamB = eventInfo3.getTeamB();
                                } else {
                                    teamB = null;
                                }
                                eventInfo4 = ev.getEventInfo();
                                if (eventInfo4 != null) {
                                    teamAFlag = eventInfo4.getTeamAFlag();
                                } else {
                                    teamAFlag = null;
                                }
                                eventInfo5 = ev.getEventInfo();
                                if (eventInfo5 != null) {
                                    teamBFlag = eventInfo5.getTeamBFlag();
                                } else {
                                    teamBFlag = null;
                                }
                                String cat8 = ev.getCat();
                                eventInfo6 = ev.getEventInfo();
                                if (eventInfo6 != null) {
                                    title2 = ev.getTitle();
                                } else {
                                    title2 = ev.getTitle();
                                }
                                String str13 = title2;
                                eventInfo7 = ev.getEventInfo();
                                if (eventInfo7 != null) {
                                    str3 = null;
                                } else {
                                    str3 = null;
                                }
                                eventInfo8 = ev.getEventInfo();
                                if (eventInfo8 != null) {
                                    strIsHot = eventInfo8.isHot();
                                } else {
                                    strIsHot = null;
                                }
                                eventInfo9 = ev.getEventInfo();
                                if (eventInfo9 != null) {
                                    str4 = null;
                                } else {
                                    str4 = null;
                                }
                                eventInfo10 = ev.getEventInfo();
                                if (eventInfo10 != null) {
                                    startTime = eventInfo10.getStartTime();
                                } else {
                                    startTime = null;
                                }
                                if (StringsKt.contains(str, "highlights", true)) {
                                    endTime = "1970/01/01 00:00:00 +0000";
                                } else {
                                    eventInfo11 = ev.getEventInfo();
                                    if (eventInfo11 != null) {
                                        endTime = eventInfo11.getEndTime();
                                    } else {
                                        str5 = null;
                                    }
                                    SportzxLiveEventInfo sportzxLiveEventInfo7 = new SportzxLiveEventInfo(teamA, teamB, teamAFlag, teamBFlag, cat8, str13, str3, strIsHot, str4, startTime, str5);
                                    formatsNew = ev.getFormatsNew();
                                    if (formatsNew != null) {
                                        $this$map$iv = formatsNew;
                                        $i$f$map = 0;
                                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                        while (r31.hasNext()) {
                                            SportzxFormat fmt7 = (SportzxFormat) item$iv$iv;
                                            Iterable $this$map$iv8 = $this$map$iv;
                                            String title9 = fmt7.getTitle();
                                            it = fmt7.getLogo();
                                            if (it != null) {
                                                str6 = null;
                                            } else {
                                                str6 = null;
                                            }
                                            destination$iv$iv2.add(new SportzxLiveEventFormat(title9, str6));
                                            $this$map$iv = $this$map$iv8;
                                            $i$f$map = $i$f$map;
                                            baseUrl2 = baseUrl2;
                                        }
                                        baseUrl3 = baseUrl2;
                                        listEmptyList = (List) destination$iv$iv2;
                                    } else {
                                        baseUrl3 = baseUrl2;
                                        listEmptyList = CollectionsKt.emptyList();
                                    }
                                    sportzxLiveEventData = new SportzxLiveEventData(i3, str12, str2, eventId3, cat7, sportzxLiveEventInfo7, 1, listEmptyList);
                                }
                                str5 = endTime;
                                SportzxLiveEventInfo sportzxLiveEventInfo8 = new SportzxLiveEventInfo(teamA, teamB, teamAFlag, teamBFlag, cat8, str13, str3, strIsHot, str4, startTime, str5);
                                formatsNew = ev.getFormatsNew();
                                if (formatsNew != null) {
                                    $this$map$iv = formatsNew;
                                    $i$f$map = 0;
                                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                    while (r31.hasNext()) {
                                        SportzxFormat fmt8 = (SportzxFormat) item$iv$iv;
                                        Iterable $this$map$iv9 = $this$map$iv;
                                        String title10 = fmt8.getTitle();
                                        it = fmt8.getLogo();
                                        if (it != null) {
                                            str6 = null;
                                        } else {
                                            str6 = null;
                                        }
                                        destination$iv$iv2.add(new SportzxLiveEventFormat(title10, str6));
                                        $this$map$iv = $this$map$iv9;
                                        $i$f$map = $i$f$map;
                                        baseUrl2 = baseUrl2;
                                    }
                                    baseUrl3 = baseUrl2;
                                    listEmptyList = (List) destination$iv$iv2;
                                } else {
                                    baseUrl3 = baseUrl2;
                                    listEmptyList = CollectionsKt.emptyList();
                                }
                                sportzxLiveEventData = new SportzxLiveEventData(i3, str12, str2, eventId3, cat7, sportzxLiveEventInfo8, 1, listEmptyList);
                            }
                            if (sportzxLiveEventData != null) {
                                destination$iv$iv.add(sportzxLiveEventData);
                            }
                            index$iv$iv$iv = index$iv$iv$iv4;
                            events = events2;
                            baseUrl2 = baseUrl3;
                        }
                        return (List) destination$iv$iv;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e4) {
                System.out.println((Object) ("Sportzx: fetchLiveEvents exception — " + e4.getMessage()));
                return CollectionsKt.emptyList();
            }
        }
    }

    public static /* synthetic */ Object fetchLiveEvents$default(SportzxProviderManager sportzxProviderManager, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "events.json";
        }
        return sportzxProviderManager.fetchLiveEvents(str, continuation);
    }

    @Nullable
    public final Object fetchLiveEvents(@NotNull String path, @NotNull Continuation<? super List<SportzxLiveEventData>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00232(path, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.SportzxProviderManager$fetchVODCategory$2 */
    /* JADX INFO: compiled from: SportzxProviderManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/cncverse/SportzxVODData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SportzxProviderManager$fetchVODCategory$2", f = "SportzxProviderManager.kt", i = {1, 1}, l = {338, 343}, m = "invokeSuspend", n = {"baseUrl", "url"}, nl = {339, 345}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nSportzxProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportzxProviderManager.kt\ncom/cncverse/SportzxProviderManager$fetchVODCategory$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,382:1\n63#2:383\n64#2,15:385\n1#3:384\n50#4:400\n43#4:401\n777#5:402\n873#5,2:403\n*S KotlinDebug\n*F\n+ 1 SportzxProviderManager.kt\ncom/cncverse/SportzxProviderManager$fetchVODCategory$2\n*L\n346#1:383\n346#1:385,15\n346#1:384\n346#1:400\n346#1:401\n352#1:402\n352#1:403,2\n*E\n"})
    static final class C00282 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SportzxVODData>>, Object> {
        final /* synthetic */ String $catLink;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00282(String str, Continuation<? super C00282> continuation) {
            super(2, continuation);
            this.$catLink = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00282(this.$catLink, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<SportzxVODData>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x004b A[Catch: Exception -> 0x002b, TryCatch #1 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x00ac, B:25:0x00b0, B:56:0x0153, B:57:0x0164, B:59:0x016a, B:61:0x017f, B:63:0x0187, B:71:0x0196, B:73:0x019b, B:75:0x01a2, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032, B:28:0x00b6, B:34:0x00ea, B:42:0x0118, B:46:0x0120, B:55:0x0150, B:54:0x013b, B:53:0x0135, B:41:0x010d, B:33:0x00e0), top: B:79:0x000a, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:20:0x0050 A[Catch: Exception -> 0x002b, TryCatch #1 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x00ac, B:25:0x00b0, B:56:0x0153, B:57:0x0164, B:59:0x016a, B:61:0x017f, B:63:0x0187, B:71:0x0196, B:73:0x019b, B:75:0x01a2, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032, B:28:0x00b6, B:34:0x00ea, B:42:0x0118, B:46:0x0120, B:55:0x0150, B:54:0x013b, B:53:0x0135, B:41:0x010d, B:33:0x00e0), top: B:79:0x000a, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:22:0x00ab A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:25:0x00b0 A[Catch: Exception -> 0x002b, TRY_LEAVE, TryCatch #1 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x00ac, B:25:0x00b0, B:56:0x0153, B:57:0x0164, B:59:0x016a, B:61:0x017f, B:63:0x0187, B:71:0x0196, B:73:0x019b, B:75:0x01a2, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032, B:28:0x00b6, B:34:0x00ea, B:42:0x0118, B:46:0x0120, B:55:0x0150, B:54:0x013b, B:53:0x0135, B:41:0x010d, B:33:0x00e0), top: B:79:0x000a, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:44:0x011e  */
        /* JADX WARN: Code duplicated, block: B:45:0x011f  */
        /* JADX WARN: Code duplicated, block: B:54:0x013b A[Catch: Exception -> 0x01a1, TryCatch #5 {Exception -> 0x01a1, blocks: (B:28:0x00b6, B:34:0x00ea, B:42:0x0118, B:46:0x0120, B:55:0x0150, B:54:0x013b, B:53:0x0135, B:41:0x010d, B:33:0x00e0, B:38:0x00f2, B:30:0x00bb, B:48:0x0126), top: B:84:0x00b6, outer: #1, inners: #3, #4, #6 }] */
        /* JADX WARN: Code duplicated, block: B:59:0x016a A[Catch: Exception -> 0x002b, TryCatch #1 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x00ac, B:25:0x00b0, B:56:0x0153, B:57:0x0164, B:59:0x016a, B:61:0x017f, B:63:0x0187, B:71:0x0196, B:73:0x019b, B:75:0x01a2, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032, B:28:0x00b6, B:34:0x00ea, B:42:0x0118, B:46:0x0120, B:55:0x0150, B:54:0x013b, B:53:0x0135, B:41:0x010d, B:33:0x00e0), top: B:79:0x000a, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:61:0x017f A[Catch: Exception -> 0x002b, TryCatch #1 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x00ac, B:25:0x00b0, B:56:0x0153, B:57:0x0164, B:59:0x016a, B:61:0x017f, B:63:0x0187, B:71:0x0196, B:73:0x019b, B:75:0x01a2, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032, B:28:0x00b6, B:34:0x00ea, B:42:0x0118, B:46:0x0120, B:55:0x0150, B:54:0x013b, B:53:0x0135, B:41:0x010d, B:33:0x00e0), top: B:79:0x000a, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:63:0x0187 A[Catch: Exception -> 0x002b, TryCatch #1 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x00ac, B:25:0x00b0, B:56:0x0153, B:57:0x0164, B:59:0x016a, B:61:0x017f, B:63:0x0187, B:71:0x0196, B:73:0x019b, B:75:0x01a2, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032, B:28:0x00b6, B:34:0x00ea, B:42:0x0118, B:46:0x0120, B:55:0x0150, B:54:0x013b, B:53:0x0135, B:41:0x010d, B:33:0x00e0), top: B:79:0x000a, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:67:0x0190  */
        /* JADX WARN: Code duplicated, block: B:69:0x0193  */
        /* JADX WARN: Code duplicated, block: B:71:0x0196 A[Catch: Exception -> 0x002b, TryCatch #1 {Exception -> 0x002b, blocks: (B:7:0x001d, B:23:0x00ac, B:25:0x00b0, B:56:0x0153, B:57:0x0164, B:59:0x016a, B:61:0x017f, B:63:0x0187, B:71:0x0196, B:73:0x019b, B:75:0x01a2, B:8:0x0025, B:16:0x0040, B:18:0x004b, B:20:0x0050, B:13:0x0032, B:28:0x00b6, B:34:0x00ea, B:42:0x0118, B:46:0x0120, B:55:0x0150, B:54:0x013b, B:53:0x0135, B:41:0x010d, B:33:0x00e0), top: B:79:0x000a, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:80:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:84:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:86:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:90:0x0199 A[SYNTHETIC] */
        public final Object invokeSuspend(Object $result) {
            Object baseUrl;
            String baseUrl2;
            Object objFetchDecrypted;
            String json;
            Object obj;
            Object obj2;
            DeserializationStrategy deserializationStrategy;
            Object objDecodeFromString;
            Collection destination$iv$iv;
            SportzxVODData it;
            boolean z;
            String id;
            boolean z2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        baseUrl = SportzxProviderManager.INSTANCE.getBaseUrl((Continuation) this);
                        if (baseUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        baseUrl2 = (String) baseUrl;
                        if (StringsKt.isBlank(baseUrl2)) {
                            return CollectionsKt.emptyList();
                        }
                        StringBuilder sbAppend = new StringBuilder().append(baseUrl2).append("/cats/");
                        String lowerCase = this.$catLink.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String url = sbAppend.append(lowerCase).append(".json").toString();
                        System.out.println((Object) ("Sportzx: Fetching VOD category from " + url));
                        this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        this.label = 2;
                        objFetchDecrypted = SportzxProviderManager.INSTANCE.fetchDecrypted(url, (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        try {
                            AppUtils appUtils = AppUtils.INSTANCE;
                            try {
                                Result.Companion companion = Result.Companion;
                                KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SportzxVODData.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                break;
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            obj2 = null;
                            if (Result.exceptionOrNull-impl(obj) != null) {
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                } catch (Throwable th2) {
                                    Result.Companion companion4 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th2));
                                }
                                break;
                            }
                            if (!Result.isFailure-impl(obj)) {
                                obj2 = obj;
                            }
                            deserializationStrategy = (KSerializer) obj2;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                                } catch (SerializationException e) {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv.readValue(json, new TypeReference<List<? extends SportzxVODData>>() { // from class: com.cncverse.SportzxProviderManager$fetchVODCategory$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                } catch (Throwable th3) {
                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv2.readValue(json, new TypeReference<List<? extends SportzxVODData>>() { // from class: com.cncverse.SportzxProviderManager$fetchVODCategory$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                }
                                break;
                            } else {
                                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv3.readValue(json, new TypeReference<List<? extends SportzxVODData>>() { // from class: com.cncverse.SportzxProviderManager$fetchVODCategory$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                            Iterable items = (List) objDecodeFromString;
                            Iterable $this$filter$iv = items;
                            destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv : $this$filter$iv) {
                                it = (SportzxVODData) element$iv$iv;
                                z = false;
                                if (Intrinsics.areEqual(it.getPublish(), "1")) {
                                    id = it.getId();
                                    if (id != null || StringsKt.isBlank(id)) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        z = true;
                                    }
                                }
                                if (z) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                            }
                            return (List) destination$iv$iv;
                        } catch (Exception e2) {
                            System.out.println((Object) ("Sportzx: Failed to parse VOD category " + this.$catLink + " — " + e2.getMessage()));
                            return CollectionsKt.emptyList();
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        baseUrl = $result;
                        baseUrl2 = (String) baseUrl;
                        if (StringsKt.isBlank(baseUrl2)) {
                            return CollectionsKt.emptyList();
                        }
                        StringBuilder sbAppend2 = new StringBuilder().append(baseUrl2).append("/cats/");
                        String lowerCase2 = this.$catLink.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        String url2 = sbAppend2.append(lowerCase2).append(".json").toString();
                        System.out.println((Object) ("Sportzx: Fetching VOD category from " + url2));
                        this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        this.label = 2;
                        objFetchDecrypted = SportzxProviderManager.INSTANCE.fetchDecrypted(url2, (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils2 = AppUtils.INSTANCE;
                        Result.Companion companion5 = Result.Companion;
                        KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SportzxVODData.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                        obj2 = null;
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion6 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            break;
                        }
                        if (!Result.isFailure-impl(obj)) {
                            obj2 = obj;
                        }
                        deserializationStrategy = (KSerializer) obj2;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv4.readValue(json, new TypeReference<List<? extends SportzxVODData>>() { // from class: com.cncverse.SportzxProviderManager$fetchVODCategory$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        Iterable items2 = (List) objDecodeFromString;
                        Iterable $this$filter$iv2 = items2;
                        destination$iv$iv = new ArrayList();
                        while (r11.hasNext()) {
                            it = (SportzxVODData) element$iv$iv;
                            z = false;
                            if (Intrinsics.areEqual(it.getPublish(), "1")) {
                                id = it.getId();
                                if (id != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    z = true;
                                }
                            }
                            if (z) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        return (List) destination$iv$iv;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        objFetchDecrypted = $result;
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils3 = AppUtils.INSTANCE;
                        Result.Companion companion7 = Result.Companion;
                        KType kTypeTypeOf3 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(SportzxVODData.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                        obj2 = null;
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion8 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            break;
                        }
                        if (!Result.isFailure-impl(obj)) {
                            obj2 = obj;
                        }
                        deserializationStrategy = (KSerializer) obj2;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv5.readValue(json, new TypeReference<List<? extends SportzxVODData>>() { // from class: com.cncverse.SportzxProviderManager$fetchVODCategory$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        Iterable items3 = (List) objDecodeFromString;
                        Iterable $this$filter$iv3 = items3;
                        destination$iv$iv = new ArrayList();
                        while (r11.hasNext()) {
                            it = (SportzxVODData) element$iv$iv;
                            z = false;
                            if (Intrinsics.areEqual(it.getPublish(), "1")) {
                                id = it.getId();
                                if (id != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    z = true;
                                }
                            }
                            if (z) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        return (List) destination$iv$iv;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e3) {
                System.out.println((Object) ("Sportzx: fetchVODCategory exception — " + e3.getMessage()));
                return CollectionsKt.emptyList();
            }
        }
    }

    @Nullable
    public final Object fetchVODCategory(@NotNull String catLink, @NotNull Continuation<? super List<SportzxVODData>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00282(catLink, null), continuation);
    }

    @Nullable
    public final Object fetchStreamData(int eventId, @NotNull Continuation<? super String> continuation) {
        return fetchStreamData(String.valueOf(eventId), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0073 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0075  */
    /* JADX WARN: Code duplicated, block: B:24:0x009d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x00a2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:30:0x00f5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object fetchStreamData(@NotNull String eventId, @NotNull Continuation<? super String> continuation) {
        C00272 c00272;
        Object baseUrl;
        String baseUrl2;
        Object objFetchDecrypted;
        String primary;
        Object objFetchDecrypted2;
        if (continuation instanceof C00272) {
            c00272 = (C00272) continuation;
            if ((c00272.label & Integer.MIN_VALUE) != 0) {
                c00272.label -= Integer.MIN_VALUE;
            } else {
                c00272 = new C00272(continuation);
            }
        } else {
            c00272 = new C00272(continuation);
        }
        Object $result = c00272.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00272.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00272.L$0 = eventId;
                c00272.label = 1;
                baseUrl = getBaseUrl(c00272);
                if (baseUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                baseUrl2 = (String) baseUrl;
                if (StringsKt.isBlank(baseUrl2)) {
                    return null;
                }
                c00272.L$0 = eventId;
                c00272.L$1 = baseUrl2;
                c00272.label = 2;
                objFetchDecrypted = fetchDecrypted(baseUrl2 + "/channels/" + eventId + ".json", c00272);
                if (objFetchDecrypted == coroutine_suspended) {
                    return coroutine_suspended;
                }
                primary = (String) objFetchDecrypted;
                if (primary != null) {
                    return primary;
                }
                System.out.println((Object) ("Sportzx: Primary channel URL failed, trying fallback " + eventId + "e.json"));
                c00272.L$0 = SpillingKt.nullOutSpilledVariable(eventId);
                c00272.L$1 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                c00272.L$2 = SpillingKt.nullOutSpilledVariable(primary);
                c00272.label = 3;
                objFetchDecrypted2 = fetchDecrypted(baseUrl2 + "/channels/" + eventId + "e.json", c00272);
                if (objFetchDecrypted2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objFetchDecrypted2;
            case 1:
                eventId = (String) c00272.L$0;
                ResultKt.throwOnFailure($result);
                baseUrl = $result;
                baseUrl2 = (String) baseUrl;
                if (StringsKt.isBlank(baseUrl2)) {
                    return null;
                }
                c00272.L$0 = eventId;
                c00272.L$1 = baseUrl2;
                c00272.label = 2;
                objFetchDecrypted = fetchDecrypted(baseUrl2 + "/channels/" + eventId + ".json", c00272);
                if (objFetchDecrypted == coroutine_suspended) {
                    return coroutine_suspended;
                }
                primary = (String) objFetchDecrypted;
                if (primary != null) {
                    return primary;
                }
                System.out.println((Object) ("Sportzx: Primary channel URL failed, trying fallback " + eventId + "e.json"));
                c00272.L$0 = SpillingKt.nullOutSpilledVariable(eventId);
                c00272.L$1 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                c00272.L$2 = SpillingKt.nullOutSpilledVariable(primary);
                c00272.label = 3;
                objFetchDecrypted2 = fetchDecrypted(baseUrl2 + "/channels/" + eventId + "e.json", c00272);
                if (objFetchDecrypted2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objFetchDecrypted2;
            case 2:
                baseUrl2 = (String) c00272.L$1;
                eventId = (String) c00272.L$0;
                ResultKt.throwOnFailure($result);
                objFetchDecrypted = $result;
                primary = (String) objFetchDecrypted;
                if (primary != null) {
                    return primary;
                }
                System.out.println((Object) ("Sportzx: Primary channel URL failed, trying fallback " + eventId + "e.json"));
                c00272.L$0 = SpillingKt.nullOutSpilledVariable(eventId);
                c00272.L$1 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                c00272.L$2 = SpillingKt.nullOutSpilledVariable(primary);
                c00272.label = 3;
                objFetchDecrypted2 = fetchDecrypted(baseUrl2 + "/channels/" + eventId + "e.json", c00272);
                if (objFetchDecrypted2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objFetchDecrypted2;
            case 3:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
