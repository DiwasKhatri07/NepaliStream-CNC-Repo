package com.cncverse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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

/* JADX INFO: compiled from: LivXowProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/LivXowProvider/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0011J \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n0\u0013H\u0086@¢\u0006\u0002\u0010\fJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0013H\u0086@¢\u0006\u0002\u0010\fJ\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0017\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u001a\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/cncverse/LivXowProviderManager;", "", "<init>", "()V", "DEFAULT_BASE_URL", "", "cachedBaseUrl", "client", "Lokhttp3/OkHttpClient;", "baseHeaders", "", "getBaseUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidateCache", "", "fetchDecrypted", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchProviders", "", "fetchLiveEvents", "Lcom/cncverse/LiveEventData;", "fetchCustomEvents", "catLink", "fetchStreamData", "slug", "getTelegramUrl", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLivXowProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowProviderManager.kt\ncom/cncverse/LivXowProviderManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,465:1\n1#2:466\n*E\n"})
public final class LivXowProviderManager {

    @NotNull
    private static final String DEFAULT_BASE_URL = "https://sohaidoegeve2.shop/";

    @Nullable
    private static volatile String cachedBaseUrl;

    @NotNull
    public static final LivXowProviderManager INSTANCE = new LivXowProviderManager();

    @NotNull
    private static final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();

    @NotNull
    private static final Map<String, String> baseHeaders = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "okhttp/4.9.2"), TuplesKt.to("Accept", "*/*")});

    /* JADX INFO: renamed from: com.cncverse.LivXowProviderManager$fetchStreamData$1 */
    /* JADX INFO: compiled from: LivXowProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProviderManager", f = "LivXowProviderManager.kt", i = {0, 1, 1, 2, 2}, l = {454, 455, 456}, m = "fetchStreamData", n = {"slug", "slug", "baseUrl", "slug", "baseUrl"}, nl = {455, 456, 457}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 2)
    static final class C00551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00551(Continuation<? super C00551> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LivXowProviderManager.this.fetchStreamData(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProviderManager$getBaseUrl$1 */
    /* JADX INFO: compiled from: LivXowProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProviderManager", f = "LivXowProviderManager.kt", i = {}, l = {182}, m = "getBaseUrl", n = {}, nl = {183}, s = {}, v = 2)
    static final class C00561 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00561(Continuation<? super C00561> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LivXowProviderManager.this.getBaseUrl((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProviderManager$getTelegramUrl$1 */
    /* JADX INFO: compiled from: LivXowProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProviderManager", f = "LivXowProviderManager.kt", i = {}, l = {460}, m = "getTelegramUrl", n = {}, nl = {461}, s = {}, v = 2)
    static final class C00571 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00571(Continuation<? super C00571> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LivXowProviderManager.this.getTelegramUrl((Continuation) this);
        }
    }

    private LivXowProviderManager() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object getBaseUrl(@NotNull Continuation<? super String> continuation) {
        C00561 c00561;
        Object baseApiUrl;
        String str;
        if (continuation instanceof C00561) {
            c00561 = (C00561) continuation;
            if ((c00561.label & Integer.MIN_VALUE) != 0) {
                c00561.label -= Integer.MIN_VALUE;
            } else {
                c00561 = new C00561(continuation);
            }
        } else {
            c00561 = new C00561(continuation);
        }
        Object $result = c00561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (c00561.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String it = cachedBaseUrl;
                if (it != null) {
                    return it;
                }
                LivXowFirebaseFetcher livXowFirebaseFetcher = LivXowFirebaseFetcher.INSTANCE;
                c00561.label = 1;
                baseApiUrl = livXowFirebaseFetcher.getBaseApiUrl(c00561);
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
        String str2 = firebaseUrl;
        if (str2 != null && !StringsKt.isBlank(str2)) {
            z = false;
        }
        if (!z) {
            str = StringsKt.endsWith$default(firebaseUrl, "/", false, 2, (Object) null) ? firebaseUrl : firebaseUrl + '/';
        } else {
            str = DEFAULT_BASE_URL;
        }
        cachedBaseUrl = str;
        String str3 = cachedBaseUrl;
        Intrinsics.checkNotNull(str3);
        return str3;
    }

    public final void invalidateCache() {
        cachedBaseUrl = null;
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProviderManager$fetchDecrypted$2 */
    /* JADX INFO: compiled from: LivXowProviderManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProviderManager$fetchDecrypted$2", f = "LivXowProviderManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nLivXowProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowProviderManager.kt\ncom/cncverse/LivXowProviderManager$fetchDecrypted$2\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,465:1\n221#2,2:466\n*S KotlinDebug\n*F\n+ 1 LivXowProviderManager.kt\ncom/cncverse/LivXowProviderManager$fetchDecrypted$2\n*L\n205#1:466,2\n*E\n"})
    static final class C00482 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00482(String str, Continuation<? super C00482> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00482(this.$url, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        Request.Builder $this$invokeSuspend_u24lambda_u240 = new Request.Builder().url(this.$url);
                        Map $this$forEach$iv = LivXowProviderManager.baseHeaders;
                        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                            String k = (String) element$iv.getKey();
                            String v = (String) element$iv.getValue();
                            $this$invokeSuspend_u24lambda_u240.header(k, v);
                        }
                        Request request = $this$invokeSuspend_u24lambda_u240.build();
                        Response response = LivXowProviderManager.client.newCall(request).execute();
                        if (!response.isSuccessful()) {
                            System.out.println((Object) ("LivXow: HTTP " + response.code() + " → " + this.$url));
                            return null;
                        }
                        String body = response.body().string();
                        if (StringsKt.isBlank(body)) {
                            return null;
                        }
                        String decrypted = LivXowCryptoUtils.INSTANCE.decrypt(body);
                        String str = decrypted;
                        if (str == null || StringsKt.isBlank(str)) {
                            System.out.println((Object) ("LivXow: Decryption failed for " + this.$url));
                            return null;
                        }
                        return decrypted;
                    } catch (Exception e) {
                        System.out.println((Object) ("LivXow: Exception fetching " + this.$url + " — " + e.getMessage()));
                        return null;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchDecrypted(String url, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00482(url, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProviderManager$fetchProviders$2 */
    /* JADX INFO: compiled from: LivXowProviderManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProviderManager$fetchProviders$2", f = "LivXowProviderManager.kt", i = {1, 1}, l = {235, 239}, m = "invokeSuspend", n = {"baseUrl", "url"}, nl = {236, 242}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nLivXowProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowProviderManager.kt\ncom/cncverse/LivXowProviderManager$fetchProviders$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,465:1\n63#2:466\n64#2,15:468\n63#2:489\n64#2,15:491\n1#3:467\n1#3:490\n1#3:508\n50#4:483\n43#4:484\n50#4:506\n43#4:507\n1606#5:485\n1617#5:486\n1924#5,2:487\n1926#5:509\n1618#5:510\n*S KotlinDebug\n*F\n+ 1 LivXowProviderManager.kt\ncom/cncverse/LivXowProviderManager$fetchProviders$2\n*L\n242#1:466\n242#1:468,15\n247#1:489\n247#1:491,15\n242#1:467\n247#1:490\n244#1:508\n242#1:483\n242#1:484\n247#1:506\n247#1:507\n244#1:485\n244#1:486\n244#1:487,2\n244#1:509\n244#1:510\n*E\n"})
    static final class C00522 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>>, Object> {
        Object L$0;
        Object L$1;
        int label;

        C00522(Continuation<? super C00522> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00522(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:100:0x0217  */
        /* JADX WARN: Code duplicated, block: B:105:0x0244  */
        /* JADX WARN: Code duplicated, block: B:106:0x0249 A[Catch: Exception -> 0x002c, TryCatch #1 {Exception -> 0x002c, blocks: (B:7:0x001f, B:19:0x0088, B:21:0x008c, B:23:0x0091, B:29:0x00c3, B:37:0x00f1, B:40:0x00f8, B:50:0x012e, B:51:0x0147, B:53:0x014d, B:55:0x0155, B:56:0x0158, B:126:0x02e8, B:103:0x0235, B:106:0x0249, B:108:0x024f, B:111:0x025e, B:114:0x0288, B:117:0x02a5, B:124:0x02bb, B:128:0x02f6, B:49:0x0115, B:48:0x010f, B:36:0x00e6, B:28:0x00b9, B:8:0x0026, B:16:0x0041, B:13:0x0033, B:33:0x00cb, B:43:0x00fe, B:25:0x0096), top: B:134:0x000c, inners: #3, #8, #12, #13 }] */
        /* JADX WARN: Code duplicated, block: B:108:0x024f A[Catch: Exception -> 0x002c, TryCatch #1 {Exception -> 0x002c, blocks: (B:7:0x001f, B:19:0x0088, B:21:0x008c, B:23:0x0091, B:29:0x00c3, B:37:0x00f1, B:40:0x00f8, B:50:0x012e, B:51:0x0147, B:53:0x014d, B:55:0x0155, B:56:0x0158, B:126:0x02e8, B:103:0x0235, B:106:0x0249, B:108:0x024f, B:111:0x025e, B:114:0x0288, B:117:0x02a5, B:124:0x02bb, B:128:0x02f6, B:49:0x0115, B:48:0x010f, B:36:0x00e6, B:28:0x00b9, B:8:0x0026, B:16:0x0041, B:13:0x0033, B:33:0x00cb, B:43:0x00fe, B:25:0x0096), top: B:134:0x000c, inners: #3, #8, #12, #13 }] */
        /* JADX WARN: Code duplicated, block: B:118:0x02b2 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:126:0x02e8 A[Catch: Exception -> 0x002c, TryCatch #1 {Exception -> 0x002c, blocks: (B:7:0x001f, B:19:0x0088, B:21:0x008c, B:23:0x0091, B:29:0x00c3, B:37:0x00f1, B:40:0x00f8, B:50:0x012e, B:51:0x0147, B:53:0x014d, B:55:0x0155, B:56:0x0158, B:126:0x02e8, B:103:0x0235, B:106:0x0249, B:108:0x024f, B:111:0x025e, B:114:0x0288, B:117:0x02a5, B:124:0x02bb, B:128:0x02f6, B:49:0x0115, B:48:0x010f, B:36:0x00e6, B:28:0x00b9, B:8:0x0026, B:16:0x0041, B:13:0x0033, B:33:0x00cb, B:43:0x00fe, B:25:0x0096), top: B:134:0x000c, inners: #3, #8, #12, #13 }] */
        /* JADX WARN: Code duplicated, block: B:135:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:137:0x017e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:147:0x01b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:151:0x01f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:153:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:157:0x02ec A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:18:0x0087 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:21:0x008c A[Catch: Exception -> 0x002c, TryCatch #1 {Exception -> 0x002c, blocks: (B:7:0x001f, B:19:0x0088, B:21:0x008c, B:23:0x0091, B:29:0x00c3, B:37:0x00f1, B:40:0x00f8, B:50:0x012e, B:51:0x0147, B:53:0x014d, B:55:0x0155, B:56:0x0158, B:126:0x02e8, B:103:0x0235, B:106:0x0249, B:108:0x024f, B:111:0x025e, B:114:0x0288, B:117:0x02a5, B:124:0x02bb, B:128:0x02f6, B:49:0x0115, B:48:0x010f, B:36:0x00e6, B:28:0x00b9, B:8:0x0026, B:16:0x0041, B:13:0x0033, B:33:0x00cb, B:43:0x00fe, B:25:0x0096), top: B:134:0x000c, inners: #3, #8, #12, #13 }] */
        /* JADX WARN: Code duplicated, block: B:23:0x0091 A[Catch: Exception -> 0x002c, TRY_LEAVE, TryCatch #1 {Exception -> 0x002c, blocks: (B:7:0x001f, B:19:0x0088, B:21:0x008c, B:23:0x0091, B:29:0x00c3, B:37:0x00f1, B:40:0x00f8, B:50:0x012e, B:51:0x0147, B:53:0x014d, B:55:0x0155, B:56:0x0158, B:126:0x02e8, B:103:0x0235, B:106:0x0249, B:108:0x024f, B:111:0x025e, B:114:0x0288, B:117:0x02a5, B:124:0x02bb, B:128:0x02f6, B:49:0x0115, B:48:0x010f, B:36:0x00e6, B:28:0x00b9, B:8:0x0026, B:16:0x0041, B:13:0x0033, B:33:0x00cb, B:43:0x00fe, B:25:0x0096), top: B:134:0x000c, inners: #3, #8, #12, #13 }] */
        /* JADX WARN: Code duplicated, block: B:39:0x00f7  */
        /* JADX WARN: Code duplicated, block: B:49:0x0115 A[Catch: Exception -> 0x002c, TryCatch #1 {Exception -> 0x002c, blocks: (B:7:0x001f, B:19:0x0088, B:21:0x008c, B:23:0x0091, B:29:0x00c3, B:37:0x00f1, B:40:0x00f8, B:50:0x012e, B:51:0x0147, B:53:0x014d, B:55:0x0155, B:56:0x0158, B:126:0x02e8, B:103:0x0235, B:106:0x0249, B:108:0x024f, B:111:0x025e, B:114:0x0288, B:117:0x02a5, B:124:0x02bb, B:128:0x02f6, B:49:0x0115, B:48:0x010f, B:36:0x00e6, B:28:0x00b9, B:8:0x0026, B:16:0x0041, B:13:0x0033, B:33:0x00cb, B:43:0x00fe, B:25:0x0096), top: B:134:0x000c, inners: #3, #8, #12, #13 }] */
        /* JADX WARN: Code duplicated, block: B:53:0x014d A[Catch: Exception -> 0x002c, TryCatch #1 {Exception -> 0x002c, blocks: (B:7:0x001f, B:19:0x0088, B:21:0x008c, B:23:0x0091, B:29:0x00c3, B:37:0x00f1, B:40:0x00f8, B:50:0x012e, B:51:0x0147, B:53:0x014d, B:55:0x0155, B:56:0x0158, B:126:0x02e8, B:103:0x0235, B:106:0x0249, B:108:0x024f, B:111:0x025e, B:114:0x0288, B:117:0x02a5, B:124:0x02bb, B:128:0x02f6, B:49:0x0115, B:48:0x010f, B:36:0x00e6, B:28:0x00b9, B:8:0x0026, B:16:0x0041, B:13:0x0033, B:33:0x00cb, B:43:0x00fe, B:25:0x0096), top: B:134:0x000c, inners: #3, #8, #12, #13 }] */
        /* JADX WARN: Code duplicated, block: B:55:0x0155 A[Catch: Exception -> 0x002c, TryCatch #1 {Exception -> 0x002c, blocks: (B:7:0x001f, B:19:0x0088, B:21:0x008c, B:23:0x0091, B:29:0x00c3, B:37:0x00f1, B:40:0x00f8, B:50:0x012e, B:51:0x0147, B:53:0x014d, B:55:0x0155, B:56:0x0158, B:126:0x02e8, B:103:0x0235, B:106:0x0249, B:108:0x024f, B:111:0x025e, B:114:0x0288, B:117:0x02a5, B:124:0x02bb, B:128:0x02f6, B:49:0x0115, B:48:0x010f, B:36:0x00e6, B:28:0x00b9, B:8:0x0026, B:16:0x0041, B:13:0x0033, B:33:0x00cb, B:43:0x00fe, B:25:0x0096), top: B:134:0x000c, inners: #3, #8, #12, #13 }] */
        /* JADX WARN: Code duplicated, block: B:58:0x0176  */
        /* JADX WARN: Code duplicated, block: B:68:0x01b3  */
        /* JADX WARN: Code duplicated, block: B:83:0x01f0  */
        public final Object invokeSuspend(Object $result) {
            Object baseUrl;
            Object objFetchDecrypted;
            String json;
            Object obj;
            Map map;
            DeserializationStrategy deserializationStrategy;
            Object objDecodeFromString;
            char c;
            Collection destination$iv$iv;
            int index$iv$iv$iv;
            LivXowCategoryWrapper wrapper;
            String str;
            Map mapMapOf;
            String value$iv;
            Object obj2;
            Map map2;
            DeserializationStrategy deserializationStrategy2;
            String value$iv2;
            Object objDecodeFromString2;
            LivXowCategoryData cat;
            String api;
            String api2;
            String str2 = "kotlinx.serialization.serializer.simple";
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        baseUrl = LivXowProviderManager.INSTANCE.getBaseUrl((Continuation) this);
                        if (baseUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        String baseUrl2 = (String) baseUrl;
                        String url = baseUrl2 + "categories.txt";
                        System.out.println((Object) ("LivXow: Fetching categories from " + url));
                        this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        this.label = 2;
                        objFetchDecrypted = LivXowProviderManager.INSTANCE.fetchDecrypted(url, (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LivXowCategoryWrapper.class)));
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                            break;
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        map = null;
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
                                c = 1;
                            } catch (SerializationException e) {
                                ArchComponentExtKt.logError(e);
                                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                c = 1;
                                objDecodeFromString = $this$readValue$iv$iv.readValue(json, new TypeReference<List<? extends LivXowCategoryWrapper>>() { // from class: com.cncverse.LivXowProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                });
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                c = 1;
                                objDecodeFromString = $this$readValue$iv$iv2.readValue(json, new TypeReference<List<? extends LivXowCategoryWrapper>>() { // from class: com.cncverse.LivXowProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                            c = 1;
                            objDecodeFromString = $this$readValue$iv$iv3.readValue(json, new TypeReference<List<? extends LivXowCategoryWrapper>>() { // from class: com.cncverse.LivXowProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        Iterable wrappers = (List) objDecodeFromString;
                        Iterable $this$mapIndexedNotNull$iv = wrappers;
                        destination$iv$iv = new ArrayList();
                        index$iv$iv$iv = 0;
                        for (Object item$iv$iv$iv : $this$mapIndexedNotNull$iv) {
                            int index$iv$iv$iv2 = index$iv$iv$iv + 1;
                            if (index$iv$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            int index$iv$iv = index$iv$iv$iv;
                            wrapper = (LivXowCategoryWrapper) item$iv$iv$iv;
                            if (StringsKt.isBlank(wrapper.getCat())) {
                                str = str2;
                                mapMapOf = map;
                            } else {
                                try {
                                    AppUtils appUtils2 = AppUtils.INSTANCE;
                                    value$iv = wrapper.getCat();
                                    try {
                                        Result.Companion companion5 = Result.Companion;
                                        KType kTypeTypeOf2 = Reflection.typeOf(LivXowCategoryData.class);
                                        MagicApiIntrinsics.voidMagicApiCall(str2);
                                        obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                    } catch (Throwable th4) {
                                        Result.Companion companion6 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th4));
                                    }
                                    if (Result.exceptionOrNull-impl(obj2) == null) {
                                        str = str2;
                                        map2 = map;
                                    } else {
                                        try {
                                            Result.Companion companion7 = Result.Companion;
                                            try {
                                                str = str2;
                                                map2 = null;
                                                try {
                                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LivXowCategoryData.class), (List) null, 2, (Object) null));
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    Result.Companion companion8 = Result.Companion;
                                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                str = str2;
                                                map2 = null;
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            str = str2;
                                            map2 = map;
                                        }
                                    }
                                    try {
                                        if (Result.isFailure-impl(obj2)) {
                                            obj2 = map2;
                                        }
                                        deserializationStrategy2 = (KSerializer) obj2;
                                        if (deserializationStrategy2 != null) {
                                            try {
                                                value$iv2 = value$iv;
                                                try {
                                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                                } catch (SerializationException e2) {
                                                    e$iv = e2;
                                                    ArchComponentExtKt.logError((Throwable) e$iv);
                                                    ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                                    String content$iv$iv = value$iv2;
                                                    objDecodeFromString2 = $this$readValue$iv$iv4.readValue(content$iv$iv, new TypeReference<LivXowCategoryData>() { // from class: com.cncverse.LivXowProviderManager$fetchProviders$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                    });
                                                } catch (Throwable th8) {
                                                    ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                                    String content$iv$iv2 = value$iv2;
                                                    objDecodeFromString2 = $this$readValue$iv$iv5.readValue(content$iv$iv2, new TypeReference<LivXowCategoryData>() { // from class: com.cncverse.LivXowProviderManager$fetchProviders$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                    });
                                                }
                                            } catch (SerializationException e3) {
                                                e$iv = e3;
                                                value$iv2 = value$iv;
                                            } catch (Throwable th9) {
                                                value$iv2 = value$iv;
                                            }
                                            cat = (LivXowCategoryData) objDecodeFromString2;
                                            if (Intrinsics.areEqual(cat.getVisible(), Boxing.boxBoolean(false))) {
                                                mapMapOf = null;
                                            } else {
                                                api = cat.getApi();
                                                if (api != null || (api2 = StringsKt.trim(api).toString()) == null) {
                                                    mapMapOf = null;
                                                } else {
                                                    Pair[] pairArr = new Pair[5];
                                                    pairArr[0] = TuplesKt.to("id", Boxing.boxInt(index$iv$iv + 1));
                                                    pairArr[c] = TuplesKt.to("title", cat.getName());
                                                    String logo = cat.getLogo();
                                                    if (logo == null) {
                                                        logo = "";
                                                    }
                                                    pairArr[2] = TuplesKt.to("image", logo);
                                                    pairArr[3] = TuplesKt.to("catLink", api2);
                                                    String type = cat.getType();
                                                    if (type == null) {
                                                        type = "custom";
                                                    }
                                                    pairArr[4] = TuplesKt.to("type", type);
                                                    mapMapOf = MapsKt.mapOf(pairArr);
                                                }
                                            }
                                        } else {
                                            value$iv2 = value$iv;
                                        }
                                        ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                        String content$iv$iv3 = value$iv2;
                                        objDecodeFromString2 = $this$readValue$iv$iv6.readValue(content$iv$iv3, new TypeReference<LivXowCategoryData>() { // from class: com.cncverse.LivXowProviderManager$fetchProviders$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                        });
                                        cat = (LivXowCategoryData) objDecodeFromString2;
                                        if (Intrinsics.areEqual(cat.getVisible(), Boxing.boxBoolean(false))) {
                                            mapMapOf = null;
                                        } else {
                                            api = cat.getApi();
                                            if (api != null) {
                                            }
                                            mapMapOf = null;
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        System.out.println((Object) ("LivXow: Failed to parse category at index " + index$iv$iv + ": " + e.getMessage()));
                                        mapMapOf = null;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    str = str2;
                                    System.out.println((Object) ("LivXow: Failed to parse category at index " + index$iv$iv + ": " + e.getMessage()));
                                    mapMapOf = null;
                                    if (mapMapOf != null) {
                                        destination$iv$iv.add(mapMapOf);
                                    }
                                    index$iv$iv$iv = index$iv$iv$iv2;
                                    str2 = str;
                                    map = null;
                                }
                            }
                            if (mapMapOf != null) {
                                destination$iv$iv.add(mapMapOf);
                            }
                            index$iv$iv$iv = index$iv$iv$iv2;
                            str2 = str;
                            map = null;
                            break;
                        }
                        return (List) destination$iv$iv;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        baseUrl = $result;
                        String baseUrl3 = (String) baseUrl;
                        String url2 = baseUrl3 + "categories.txt";
                        System.out.println((Object) ("LivXow: Fetching categories from " + url2));
                        this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl3);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        this.label = 2;
                        objFetchDecrypted = LivXowProviderManager.INSTANCE.fetchDecrypted(url2, (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils3 = AppUtils.INSTANCE;
                        Result.Companion companion9 = Result.Companion;
                        KType kTypeTypeOf3 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LivXowCategoryWrapper.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                        map = null;
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion10 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            break;
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                            c = 1;
                        } else {
                            ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                            c = 1;
                            objDecodeFromString = $this$readValue$iv$iv7.readValue(json, new TypeReference<List<? extends LivXowCategoryWrapper>>() { // from class: com.cncverse.LivXowProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        Iterable wrappers2 = (List) objDecodeFromString;
                        Iterable $this$mapIndexedNotNull$iv2 = wrappers2;
                        destination$iv$iv = new ArrayList();
                        index$iv$iv$iv = 0;
                        while (r16.hasNext()) {
                            int index$iv$iv$iv3 = index$iv$iv$iv + 1;
                            if (index$iv$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            int index$iv$iv2 = index$iv$iv$iv;
                            wrapper = (LivXowCategoryWrapper) item$iv$iv$iv;
                            if (StringsKt.isBlank(wrapper.getCat())) {
                                str = str2;
                                mapMapOf = map;
                            } else {
                                AppUtils appUtils4 = AppUtils.INSTANCE;
                                value$iv = wrapper.getCat();
                                Result.Companion companion11 = Result.Companion;
                                KType kTypeTypeOf4 = Reflection.typeOf(LivXowCategoryData.class);
                                MagicApiIntrinsics.voidMagicApiCall(str2);
                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                                if (Result.exceptionOrNull-impl(obj2) == null) {
                                    Result.Companion companion12 = Result.Companion;
                                    str = str2;
                                    map2 = null;
                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LivXowCategoryData.class), (List) null, 2, (Object) null));
                                } else {
                                    str = str2;
                                    map2 = map;
                                }
                                if (Result.isFailure-impl(obj2)) {
                                    obj2 = map2;
                                }
                                deserializationStrategy2 = (KSerializer) obj2;
                                if (deserializationStrategy2 != null) {
                                    value$iv2 = value$iv;
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                    cat = (LivXowCategoryData) objDecodeFromString2;
                                    if (Intrinsics.areEqual(cat.getVisible(), Boxing.boxBoolean(false))) {
                                        mapMapOf = null;
                                    } else {
                                        api = cat.getApi();
                                        if (api != null) {
                                        }
                                        mapMapOf = null;
                                    }
                                } else {
                                    value$iv2 = value$iv;
                                }
                                ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                                String content$iv$iv4 = value$iv2;
                                objDecodeFromString2 = $this$readValue$iv$iv8.readValue(content$iv$iv4, new TypeReference<LivXowCategoryData>() { // from class: com.cncverse.LivXowProviderManager$fetchProviders$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                });
                                cat = (LivXowCategoryData) objDecodeFromString2;
                                if (Intrinsics.areEqual(cat.getVisible(), Boxing.boxBoolean(false))) {
                                    mapMapOf = null;
                                } else {
                                    api = cat.getApi();
                                    if (api != null) {
                                    }
                                    mapMapOf = null;
                                }
                            }
                            if (mapMapOf != null) {
                                destination$iv$iv.add(mapMapOf);
                            }
                            index$iv$iv$iv = index$iv$iv$iv3;
                            str2 = str;
                            map = null;
                            break;
                        }
                        return (List) destination$iv$iv;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        objFetchDecrypted = $result;
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils5 = AppUtils.INSTANCE;
                        Result.Companion companion13 = Result.Companion;
                        KType kTypeTypeOf5 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LivXowCategoryWrapper.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                        map = null;
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion14 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            break;
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                            c = 1;
                        } else {
                            ObjectMapper $this$readValue$iv$iv9 = MainAPIKt.getMapper();
                            c = 1;
                            objDecodeFromString = $this$readValue$iv$iv9.readValue(json, new TypeReference<List<? extends LivXowCategoryWrapper>>() { // from class: com.cncverse.LivXowProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        Iterable wrappers3 = (List) objDecodeFromString;
                        Iterable $this$mapIndexedNotNull$iv3 = wrappers3;
                        destination$iv$iv = new ArrayList();
                        index$iv$iv$iv = 0;
                        while (r16.hasNext()) {
                            int index$iv$iv$iv4 = index$iv$iv$iv + 1;
                            if (index$iv$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            int index$iv$iv3 = index$iv$iv$iv;
                            wrapper = (LivXowCategoryWrapper) item$iv$iv$iv;
                            if (StringsKt.isBlank(wrapper.getCat())) {
                                str = str2;
                                mapMapOf = map;
                            } else {
                                AppUtils appUtils6 = AppUtils.INSTANCE;
                                value$iv = wrapper.getCat();
                                Result.Companion companion15 = Result.Companion;
                                KType kTypeTypeOf6 = Reflection.typeOf(LivXowCategoryData.class);
                                MagicApiIntrinsics.voidMagicApiCall(str2);
                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                                if (Result.exceptionOrNull-impl(obj2) == null) {
                                    Result.Companion companion16 = Result.Companion;
                                    str = str2;
                                    map2 = null;
                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LivXowCategoryData.class), (List) null, 2, (Object) null));
                                } else {
                                    str = str2;
                                    map2 = map;
                                }
                                if (Result.isFailure-impl(obj2)) {
                                    obj2 = map2;
                                }
                                deserializationStrategy2 = (KSerializer) obj2;
                                if (deserializationStrategy2 != null) {
                                    value$iv2 = value$iv;
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                    cat = (LivXowCategoryData) objDecodeFromString2;
                                    if (Intrinsics.areEqual(cat.getVisible(), Boxing.boxBoolean(false))) {
                                        mapMapOf = null;
                                    } else {
                                        api = cat.getApi();
                                        if (api != null) {
                                        }
                                        mapMapOf = null;
                                    }
                                } else {
                                    value$iv2 = value$iv;
                                }
                                ObjectMapper $this$readValue$iv$iv10 = MainAPIKt.getMapper();
                                String content$iv$iv5 = value$iv2;
                                objDecodeFromString2 = $this$readValue$iv$iv10.readValue(content$iv$iv5, new TypeReference<LivXowCategoryData>() { // from class: com.cncverse.LivXowProviderManager$fetchProviders$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                });
                                cat = (LivXowCategoryData) objDecodeFromString2;
                                if (Intrinsics.areEqual(cat.getVisible(), Boxing.boxBoolean(false))) {
                                    mapMapOf = null;
                                } else {
                                    api = cat.getApi();
                                    if (api != null) {
                                    }
                                    mapMapOf = null;
                                }
                            }
                            if (mapMapOf != null) {
                                destination$iv$iv.add(mapMapOf);
                            }
                            index$iv$iv$iv = index$iv$iv$iv4;
                            str2 = str;
                            map = null;
                            break;
                        }
                        return (List) destination$iv$iv;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e6) {
                System.out.println((Object) ("LivXow: fetchProviders exception: " + e6.getMessage()));
                return CollectionsKt.emptyList();
            }
        }
    }

    @Nullable
    public final Object fetchProviders(@NotNull Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00522(null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProviderManager$fetchLiveEvents$2 */
    /* JADX INFO: compiled from: LivXowProviderManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/cncverse/LiveEventData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProviderManager$fetchLiveEvents$2", f = "LivXowProviderManager.kt", i = {1, 1, 1}, l = {279, 284}, m = "invokeSuspend", n = {"baseUrl", "slug", "url"}, nl = {280, 287}, s = {"L$0", "L$1", "L$2"}, v = 2)
    @SourceDebugExtension({"SMAP\nLivXowProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowProviderManager.kt\ncom/cncverse/LivXowProviderManager$fetchLiveEvents$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,465:1\n63#2:466\n64#2,15:468\n63#2:489\n64#2,15:491\n1#3:467\n1#3:490\n1#3:519\n1#3:522\n50#4:483\n43#4:484\n50#4:506\n43#4:507\n1606#5:485\n1617#5:486\n1924#5,2:487\n1642#5,10:508\n1915#5:518\n1916#5:520\n1652#5:521\n1926#5:523\n1618#5:524\n*S KotlinDebug\n*F\n+ 1 LivXowProviderManager.kt\ncom/cncverse/LivXowProviderManager$fetchLiveEvents$2\n*L\n287#1:466\n287#1:468,15\n292#1:489\n292#1:491,15\n287#1:467\n292#1:490\n322#1:519\n289#1:522\n287#1:483\n287#1:484\n292#1:506\n292#1:507\n289#1:485\n289#1:486\n289#1:487,2\n322#1:508,10\n322#1:518\n322#1:520\n322#1:521\n289#1:523\n289#1:524\n*E\n"})
    static final class C00492 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends LiveEventData>>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C00492(Continuation<? super C00492> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00492(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<LiveEventData>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:100:0x0222  */
        /* JADX WARN: Code duplicated, block: B:105:0x0251 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:106:0x0257 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:111:0x0297 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:114:0x02b9 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:117:0x02d5 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:119:0x02ec A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:121:0x02fb A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:122:0x02ff  */
        /* JADX WARN: Code duplicated, block: B:123:0x0301 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:125:0x0307 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:126:0x030b  */
        /* JADX WARN: Code duplicated, block: B:129:0x030f A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:130:0x0319  */
        /* JADX WARN: Code duplicated, block: B:132:0x031f A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:135:0x033d A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:143:0x0391 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:154:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:156:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:164:0x01bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:168:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:170:0x01fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:174:0x0395 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:177:0x0323 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:18:0x0092 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:21:0x0097 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:23:0x009c A[Catch: Exception -> 0x002f, TRY_LEAVE, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:39:0x0102  */
        /* JADX WARN: Code duplicated, block: B:49:0x011e A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:53:0x0154 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:55:0x015c A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0022, B:19:0x0093, B:21:0x0097, B:23:0x009c, B:29:0x00ce, B:37:0x00fc, B:40:0x0103, B:50:0x0135, B:51:0x014e, B:53:0x0154, B:55:0x015c, B:56:0x015f, B:143:0x0391, B:103:0x0242, B:106:0x0257, B:109:0x0269, B:111:0x0297, B:112:0x029b, B:114:0x02b9, B:115:0x02cf, B:117:0x02d5, B:119:0x02ec, B:121:0x02fb, B:129:0x030f, B:132:0x031f, B:123:0x0301, B:125:0x0307, B:134:0x032c, B:136:0x0348, B:135:0x033d, B:141:0x0366, B:145:0x03a0, B:49:0x011e, B:48:0x0118, B:36:0x00f1, B:28:0x00c4, B:8:0x0029, B:16:0x0045, B:13:0x0036, B:25:0x00a1, B:43:0x0109, B:33:0x00d6), top: B:149:0x000b, inners: #1, #4, #8, #14 }] */
        /* JADX WARN: Code duplicated, block: B:58:0x017b  */
        /* JADX WARN: Code duplicated, block: B:68:0x01b9  */
        /* JADX WARN: Code duplicated, block: B:80:0x01f3  */
        /* JADX WARN: Code duplicated, block: B:81:0x01f5  */
        public final Object invokeSuspend(Object $result) {
            Object baseUrl;
            String slug;
            Object objFetchDecrypted;
            String json;
            Object obj;
            LiveEventData liveEventData;
            DeserializationStrategy deserializationStrategy;
            Object objDecodeFromString;
            Collection destination$iv$iv;
            int index$iv$iv$iv;
            int index$iv$iv;
            LivXowEventWrapper wrapper;
            String str;
            LiveEventData liveEventData2;
            LiveEventData liveEventData3;
            String value$iv;
            Object obj2;
            Object obj3;
            DeserializationStrategy deserializationStrategy2;
            String value$iv2;
            Object objDecodeFromString2;
            LivXowEvent ev;
            String eventName;
            Iterable link_names;
            List listEmptyList;
            Iterable $this$mapNotNull$iv;
            int $i$f$mapNotNull;
            Collection destination$iv$iv2;
            int $i$f$mapNotNull2;
            String title;
            LiveEventFormat liveEventFormat;
            Object obj4;
            String str2 = "kotlinx.serialization.serializer.simple";
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        baseUrl = LivXowProviderManager.INSTANCE.getBaseUrl((Continuation) this);
                        if (baseUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        String baseUrl2 = (String) baseUrl;
                        slug = "events.txt";
                        String url = baseUrl2 + "events.txt";
                        System.out.println((Object) ("LivXow: Fetching events from " + url));
                        this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable("events.txt");
                        this.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        this.label = 2;
                        objFetchDecrypted = LivXowProviderManager.INSTANCE.fetchDecrypted(url, (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LivXowEventWrapper.class)));
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                            break;
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        liveEventData = null;
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
                                objDecodeFromString = $this$readValue$iv$iv.readValue(json, new TypeReference<List<? extends LivXowEventWrapper>>() { // from class: com.cncverse.LivXowProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                                });
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv2.readValue(json, new TypeReference<List<? extends LivXowEventWrapper>>() { // from class: com.cncverse.LivXowProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv3.readValue(json, new TypeReference<List<? extends LivXowEventWrapper>>() { // from class: com.cncverse.LivXowProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        Iterable wrappers = (List) objDecodeFromString;
                        Iterable $this$mapIndexedNotNull$iv = wrappers;
                        destination$iv$iv = new ArrayList();
                        index$iv$iv$iv = 0;
                        for (Object item$iv$iv$iv : $this$mapIndexedNotNull$iv) {
                            int index$iv$iv$iv2 = index$iv$iv$iv + 1;
                            if (index$iv$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            index$iv$iv = index$iv$iv$iv;
                            wrapper = (LivXowEventWrapper) item$iv$iv$iv;
                            if (StringsKt.isBlank(wrapper.getEvent())) {
                                str = str2;
                                slug = slug;
                                liveEventData3 = liveEventData;
                                liveEventData2 = liveEventData3;
                            } else {
                                try {
                                    AppUtils appUtils2 = AppUtils.INSTANCE;
                                    value$iv = wrapper.getEvent();
                                    try {
                                        Result.Companion companion5 = Result.Companion;
                                        KType kTypeTypeOf2 = Reflection.typeOf(LivXowEvent.class);
                                        MagicApiIntrinsics.voidMagicApiCall(str2);
                                        obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                    } catch (Throwable th4) {
                                        Result.Companion companion6 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th4));
                                    }
                                    if (Result.exceptionOrNull-impl(obj2) == null) {
                                        str = str2;
                                    } else {
                                        try {
                                            Result.Companion companion7 = Result.Companion;
                                            str = str2;
                                            try {
                                                obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LivXowEvent.class), (List) null, 2, (Object) null));
                                            } catch (Throwable th5) {
                                                th = th5;
                                                Result.Companion companion8 = Result.Companion;
                                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            str = str2;
                                        }
                                    }
                                    try {
                                        if (Result.isFailure-impl(obj2)) {
                                            obj3 = null;
                                        } else {
                                            obj3 = obj2;
                                        }
                                        deserializationStrategy2 = (KSerializer) obj3;
                                        if (deserializationStrategy2 != null) {
                                            try {
                                                value$iv2 = value$iv;
                                                try {
                                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                                    break;
                                                } catch (SerializationException e2) {
                                                    e$iv = e2;
                                                    try {
                                                        ArchComponentExtKt.logError((Throwable) e$iv);
                                                        ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                                        String content$iv$iv = value$iv2;
                                                        objDecodeFromString2 = $this$readValue$iv$iv4.readValue(content$iv$iv, new TypeReference<LivXowEvent>() { // from class: com.cncverse.LivXowProviderManager$fetchLiveEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                        });
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        liveEventData2 = null;
                                                        System.out.println((Object) ("LivXow: Failed to parse inner event at index " + index$iv$iv + ": " + e.getMessage()));
                                                        liveEventData3 = liveEventData2;
                                                    }
                                                } catch (Throwable th7) {
                                                    ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                                    String content$iv$iv2 = value$iv2;
                                                    objDecodeFromString2 = $this$readValue$iv$iv5.readValue(content$iv$iv2, new TypeReference<LivXowEvent>() { // from class: com.cncverse.LivXowProviderManager$fetchLiveEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                    });
                                                }
                                            } catch (SerializationException e4) {
                                                e$iv = e4;
                                                value$iv2 = value$iv;
                                            } catch (Throwable th8) {
                                                value$iv2 = value$iv;
                                            }
                                            ev = (LivXowEvent) objDecodeFromString2;
                                            if (Intrinsics.areEqual(ev.getVisible(), Boxing.boxBoolean(false)) && !StringsKt.isBlank(ev.getStreamSlug())) {
                                                int i = index$iv$iv + 1;
                                                String displayName = ev.getDisplayName();
                                                String thumbUrl = ev.getThumbUrl();
                                                String streamSlug = ev.getStreamSlug();
                                                String categoryName = ev.getCategoryName();
                                                String teamAName = ev.getTeamAName();
                                                String teamBName = ev.getTeamBName();
                                                String teamAFlag = ev.getTeamAFlag();
                                                String teamBFlag = ev.getTeamBFlag();
                                                String categoryName2 = ev.getCategoryName();
                                                eventName = ev.getEventName();
                                                if (eventName == null) {
                                                    eventName = ev.getDisplayName();
                                                }
                                                LiveEventInfo liveEventInfo = new LiveEventInfo(teamAName, teamBName, teamAFlag, teamBFlag, categoryName2, eventName, ev.getThumbUrl(), null, ev.getCategoryName(), ev.startTimeString(), ev.endTimeString());
                                                link_names = ev.getLink_names();
                                                if (link_names != null) {
                                                    $this$mapNotNull$iv = link_names;
                                                    $i$f$mapNotNull = 0;
                                                    destination$iv$iv2 = new ArrayList();
                                                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                                        LivXowEvent ev2 = ev;
                                                        Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                                        if (element$iv$iv$iv instanceof Map) {
                                                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                            obj4 = ((Map) element$iv$iv$iv).get("name");
                                                            if (obj4 instanceof String) {
                                                                title = (String) obj4;
                                                            } else {
                                                                title = null;
                                                            }
                                                        } else {
                                                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                            if (element$iv$iv$iv instanceof String) {
                                                                title = (String) element$iv$iv$iv;
                                                            } else {
                                                                title = null;
                                                            }
                                                        }
                                                        if (title != null) {
                                                            liveEventFormat = new LiveEventFormat(title, null);
                                                        } else {
                                                            liveEventFormat = null;
                                                        }
                                                        if (liveEventFormat != null) {
                                                            destination$iv$iv2.add(liveEventFormat);
                                                        }
                                                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                                        ev = ev2;
                                                        $i$f$mapNotNull = $i$f$mapNotNull2;
                                                        slug = slug;
                                                    }
                                                    slug = slug;
                                                    liveEventData2 = null;
                                                    listEmptyList = (List) destination$iv$iv2;
                                                } else {
                                                    slug = slug;
                                                    liveEventData2 = null;
                                                    listEmptyList = CollectionsKt.emptyList();
                                                }
                                                liveEventData3 = new LiveEventData(i, displayName, thumbUrl, streamSlug, categoryName, liveEventInfo, 1, listEmptyList);
                                            } else {
                                                slug = slug;
                                                liveEventData3 = null;
                                                liveEventData2 = null;
                                            }
                                        } else {
                                            value$iv2 = value$iv;
                                        }
                                        ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                        String content$iv$iv3 = value$iv2;
                                        objDecodeFromString2 = $this$readValue$iv$iv6.readValue(content$iv$iv3, new TypeReference<LivXowEvent>() { // from class: com.cncverse.LivXowProviderManager$fetchLiveEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                        });
                                        ev = (LivXowEvent) objDecodeFromString2;
                                        if (Intrinsics.areEqual(ev.getVisible(), Boxing.boxBoolean(false))) {
                                            slug = slug;
                                            liveEventData3 = null;
                                            liveEventData2 = null;
                                        } else {
                                            int i2 = index$iv$iv + 1;
                                            String displayName2 = ev.getDisplayName();
                                            String thumbUrl2 = ev.getThumbUrl();
                                            String streamSlug2 = ev.getStreamSlug();
                                            String categoryName3 = ev.getCategoryName();
                                            String teamAName2 = ev.getTeamAName();
                                            String teamBName2 = ev.getTeamBName();
                                            String teamAFlag2 = ev.getTeamAFlag();
                                            String teamBFlag2 = ev.getTeamBFlag();
                                            String categoryName4 = ev.getCategoryName();
                                            eventName = ev.getEventName();
                                            if (eventName == null) {
                                                eventName = ev.getDisplayName();
                                            }
                                            LiveEventInfo liveEventInfo2 = new LiveEventInfo(teamAName2, teamBName2, teamAFlag2, teamBFlag2, categoryName4, eventName, ev.getThumbUrl(), null, ev.getCategoryName(), ev.startTimeString(), ev.endTimeString());
                                            link_names = ev.getLink_names();
                                            if (link_names != null) {
                                                $this$mapNotNull$iv = link_names;
                                                $i$f$mapNotNull = 0;
                                                destination$iv$iv2 = new ArrayList();
                                                while (r31.hasNext()) {
                                                    LivXowEvent ev3 = ev;
                                                    Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                                                    if (element$iv$iv$iv instanceof Map) {
                                                        $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                        obj4 = ((Map) element$iv$iv$iv).get("name");
                                                        if (obj4 instanceof String) {
                                                            title = (String) obj4;
                                                        } else {
                                                            title = null;
                                                        }
                                                    } else {
                                                        $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                        if (element$iv$iv$iv instanceof String) {
                                                            title = (String) element$iv$iv$iv;
                                                        } else {
                                                            title = null;
                                                        }
                                                    }
                                                    if (title != null) {
                                                        liveEventFormat = new LiveEventFormat(title, null);
                                                    } else {
                                                        liveEventFormat = null;
                                                    }
                                                    if (liveEventFormat != null) {
                                                        destination$iv$iv2.add(liveEventFormat);
                                                    }
                                                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                                                    ev = ev3;
                                                    $i$f$mapNotNull = $i$f$mapNotNull2;
                                                    slug = slug;
                                                }
                                                slug = slug;
                                                liveEventData2 = null;
                                                listEmptyList = (List) destination$iv$iv2;
                                            } else {
                                                slug = slug;
                                                liveEventData2 = null;
                                                listEmptyList = CollectionsKt.emptyList();
                                            }
                                            liveEventData3 = new LiveEventData(i2, displayName2, thumbUrl2, streamSlug2, categoryName3, liveEventInfo2, 1, listEmptyList);
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        liveEventData2 = null;
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    str = str2;
                                    liveEventData2 = liveEventData;
                                    System.out.println((Object) ("LivXow: Failed to parse inner event at index " + index$iv$iv + ": " + e.getMessage()));
                                    liveEventData3 = liveEventData2;
                                    if (liveEventData3 != null) {
                                        destination$iv$iv.add(liveEventData3);
                                    }
                                    liveEventData = liveEventData2;
                                    str2 = str;
                                    index$iv$iv$iv = index$iv$iv$iv2;
                                    slug = slug;
                                }
                            }
                            if (liveEventData3 != null) {
                                destination$iv$iv.add(liveEventData3);
                            }
                            liveEventData = liveEventData2;
                            str2 = str;
                            index$iv$iv$iv = index$iv$iv$iv2;
                            slug = slug;
                            break;
                        }
                        return (List) destination$iv$iv;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        baseUrl = $result;
                        String baseUrl3 = (String) baseUrl;
                        slug = "events.txt";
                        String url2 = baseUrl3 + "events.txt";
                        System.out.println((Object) ("LivXow: Fetching events from " + url2));
                        this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl3);
                        this.L$1 = SpillingKt.nullOutSpilledVariable("events.txt");
                        this.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                        this.label = 2;
                        objFetchDecrypted = LivXowProviderManager.INSTANCE.fetchDecrypted(url2, (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils3 = AppUtils.INSTANCE;
                        Result.Companion companion9 = Result.Companion;
                        KType kTypeTypeOf3 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LivXowEventWrapper.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                        liveEventData = null;
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion10 = Result.Companion;
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
                            ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv7.readValue(json, new TypeReference<List<? extends LivXowEventWrapper>>() { // from class: com.cncverse.LivXowProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        Iterable wrappers2 = (List) objDecodeFromString;
                        Iterable $this$mapIndexedNotNull$iv2 = wrappers2;
                        destination$iv$iv = new ArrayList();
                        index$iv$iv$iv = 0;
                        while (r16.hasNext()) {
                            int index$iv$iv$iv3 = index$iv$iv$iv + 1;
                            if (index$iv$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            index$iv$iv = index$iv$iv$iv;
                            wrapper = (LivXowEventWrapper) item$iv$iv$iv;
                            if (StringsKt.isBlank(wrapper.getEvent())) {
                                str = str2;
                                slug = slug;
                                liveEventData3 = liveEventData;
                                liveEventData2 = liveEventData3;
                            } else {
                                AppUtils appUtils4 = AppUtils.INSTANCE;
                                value$iv = wrapper.getEvent();
                                Result.Companion companion11 = Result.Companion;
                                KType kTypeTypeOf4 = Reflection.typeOf(LivXowEvent.class);
                                MagicApiIntrinsics.voidMagicApiCall(str2);
                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                                if (Result.exceptionOrNull-impl(obj2) == null) {
                                    Result.Companion companion12 = Result.Companion;
                                    str = str2;
                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LivXowEvent.class), (List) null, 2, (Object) null));
                                } else {
                                    str = str2;
                                }
                                if (Result.isFailure-impl(obj2)) {
                                    obj3 = null;
                                } else {
                                    obj3 = obj2;
                                }
                                deserializationStrategy2 = (KSerializer) obj3;
                                if (deserializationStrategy2 != null) {
                                    value$iv2 = value$iv;
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                    ev = (LivXowEvent) objDecodeFromString2;
                                    if (Intrinsics.areEqual(ev.getVisible(), Boxing.boxBoolean(false))) {
                                        slug = slug;
                                        liveEventData3 = null;
                                        liveEventData2 = null;
                                    } else {
                                        int i3 = index$iv$iv + 1;
                                        String displayName3 = ev.getDisplayName();
                                        String thumbUrl3 = ev.getThumbUrl();
                                        String streamSlug3 = ev.getStreamSlug();
                                        String categoryName5 = ev.getCategoryName();
                                        String teamAName3 = ev.getTeamAName();
                                        String teamBName3 = ev.getTeamBName();
                                        String teamAFlag3 = ev.getTeamAFlag();
                                        String teamBFlag3 = ev.getTeamBFlag();
                                        String categoryName6 = ev.getCategoryName();
                                        eventName = ev.getEventName();
                                        if (eventName == null) {
                                            eventName = ev.getDisplayName();
                                        }
                                        LiveEventInfo liveEventInfo3 = new LiveEventInfo(teamAName3, teamBName3, teamAFlag3, teamBFlag3, categoryName6, eventName, ev.getThumbUrl(), null, ev.getCategoryName(), ev.startTimeString(), ev.endTimeString());
                                        link_names = ev.getLink_names();
                                        if (link_names != null) {
                                            $this$mapNotNull$iv = link_names;
                                            $i$f$mapNotNull = 0;
                                            destination$iv$iv2 = new ArrayList();
                                            while (r31.hasNext()) {
                                                LivXowEvent ev4 = ev;
                                                Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                                                if (element$iv$iv$iv instanceof Map) {
                                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                    obj4 = ((Map) element$iv$iv$iv).get("name");
                                                    if (obj4 instanceof String) {
                                                        title = (String) obj4;
                                                    } else {
                                                        title = null;
                                                    }
                                                } else {
                                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                    if (element$iv$iv$iv instanceof String) {
                                                        title = (String) element$iv$iv$iv;
                                                    } else {
                                                        title = null;
                                                    }
                                                }
                                                if (title != null) {
                                                    liveEventFormat = new LiveEventFormat(title, null);
                                                } else {
                                                    liveEventFormat = null;
                                                }
                                                if (liveEventFormat != null) {
                                                    destination$iv$iv2.add(liveEventFormat);
                                                }
                                                $this$mapNotNull$iv = $this$mapNotNull$iv4;
                                                ev = ev4;
                                                $i$f$mapNotNull = $i$f$mapNotNull2;
                                                slug = slug;
                                            }
                                            slug = slug;
                                            liveEventData2 = null;
                                            listEmptyList = (List) destination$iv$iv2;
                                        } else {
                                            slug = slug;
                                            liveEventData2 = null;
                                            listEmptyList = CollectionsKt.emptyList();
                                        }
                                        liveEventData3 = new LiveEventData(i3, displayName3, thumbUrl3, streamSlug3, categoryName5, liveEventInfo3, 1, listEmptyList);
                                    }
                                } else {
                                    value$iv2 = value$iv;
                                }
                                ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                                String content$iv$iv4 = value$iv2;
                                objDecodeFromString2 = $this$readValue$iv$iv8.readValue(content$iv$iv4, new TypeReference<LivXowEvent>() { // from class: com.cncverse.LivXowProviderManager$fetchLiveEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                });
                                ev = (LivXowEvent) objDecodeFromString2;
                                if (Intrinsics.areEqual(ev.getVisible(), Boxing.boxBoolean(false))) {
                                    slug = slug;
                                    liveEventData3 = null;
                                    liveEventData2 = null;
                                } else {
                                    int i4 = index$iv$iv + 1;
                                    String displayName4 = ev.getDisplayName();
                                    String thumbUrl4 = ev.getThumbUrl();
                                    String streamSlug4 = ev.getStreamSlug();
                                    String categoryName7 = ev.getCategoryName();
                                    String teamAName4 = ev.getTeamAName();
                                    String teamBName4 = ev.getTeamBName();
                                    String teamAFlag4 = ev.getTeamAFlag();
                                    String teamBFlag4 = ev.getTeamBFlag();
                                    String categoryName8 = ev.getCategoryName();
                                    eventName = ev.getEventName();
                                    if (eventName == null) {
                                        eventName = ev.getDisplayName();
                                    }
                                    LiveEventInfo liveEventInfo4 = new LiveEventInfo(teamAName4, teamBName4, teamAFlag4, teamBFlag4, categoryName8, eventName, ev.getThumbUrl(), null, ev.getCategoryName(), ev.startTimeString(), ev.endTimeString());
                                    link_names = ev.getLink_names();
                                    if (link_names != null) {
                                        $this$mapNotNull$iv = link_names;
                                        $i$f$mapNotNull = 0;
                                        destination$iv$iv2 = new ArrayList();
                                        while (r31.hasNext()) {
                                            LivXowEvent ev5 = ev;
                                            Iterable $this$mapNotNull$iv5 = $this$mapNotNull$iv;
                                            if (element$iv$iv$iv instanceof Map) {
                                                $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                obj4 = ((Map) element$iv$iv$iv).get("name");
                                                if (obj4 instanceof String) {
                                                    title = (String) obj4;
                                                } else {
                                                    title = null;
                                                }
                                            } else {
                                                $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                if (element$iv$iv$iv instanceof String) {
                                                    title = (String) element$iv$iv$iv;
                                                } else {
                                                    title = null;
                                                }
                                            }
                                            if (title != null) {
                                                liveEventFormat = new LiveEventFormat(title, null);
                                            } else {
                                                liveEventFormat = null;
                                            }
                                            if (liveEventFormat != null) {
                                                destination$iv$iv2.add(liveEventFormat);
                                            }
                                            $this$mapNotNull$iv = $this$mapNotNull$iv5;
                                            ev = ev5;
                                            $i$f$mapNotNull = $i$f$mapNotNull2;
                                            slug = slug;
                                        }
                                        slug = slug;
                                        liveEventData2 = null;
                                        listEmptyList = (List) destination$iv$iv2;
                                    } else {
                                        slug = slug;
                                        liveEventData2 = null;
                                        listEmptyList = CollectionsKt.emptyList();
                                    }
                                    liveEventData3 = new LiveEventData(i4, displayName4, thumbUrl4, streamSlug4, categoryName7, liveEventInfo4, 1, listEmptyList);
                                }
                            }
                            if (liveEventData3 != null) {
                                destination$iv$iv.add(liveEventData3);
                            }
                            liveEventData = liveEventData2;
                            str2 = str;
                            index$iv$iv$iv = index$iv$iv$iv3;
                            slug = slug;
                            break;
                        }
                        return (List) destination$iv$iv;
                    case 2:
                        slug = (String) this.L$1;
                        ResultKt.throwOnFailure($result);
                        objFetchDecrypted = $result;
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils5 = AppUtils.INSTANCE;
                        Result.Companion companion13 = Result.Companion;
                        KType kTypeTypeOf5 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LivXowEventWrapper.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                        liveEventData = null;
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion14 = Result.Companion;
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
                            ObjectMapper $this$readValue$iv$iv9 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv9.readValue(json, new TypeReference<List<? extends LivXowEventWrapper>>() { // from class: com.cncverse.LivXowProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        Iterable wrappers3 = (List) objDecodeFromString;
                        Iterable $this$mapIndexedNotNull$iv3 = wrappers3;
                        destination$iv$iv = new ArrayList();
                        index$iv$iv$iv = 0;
                        while (r16.hasNext()) {
                            int index$iv$iv$iv4 = index$iv$iv$iv + 1;
                            if (index$iv$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            index$iv$iv = index$iv$iv$iv;
                            wrapper = (LivXowEventWrapper) item$iv$iv$iv;
                            if (StringsKt.isBlank(wrapper.getEvent())) {
                                str = str2;
                                slug = slug;
                                liveEventData3 = liveEventData;
                                liveEventData2 = liveEventData3;
                            } else {
                                AppUtils appUtils6 = AppUtils.INSTANCE;
                                value$iv = wrapper.getEvent();
                                Result.Companion companion15 = Result.Companion;
                                KType kTypeTypeOf6 = Reflection.typeOf(LivXowEvent.class);
                                MagicApiIntrinsics.voidMagicApiCall(str2);
                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                                if (Result.exceptionOrNull-impl(obj2) == null) {
                                    Result.Companion companion16 = Result.Companion;
                                    str = str2;
                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LivXowEvent.class), (List) null, 2, (Object) null));
                                } else {
                                    str = str2;
                                }
                                if (Result.isFailure-impl(obj2)) {
                                    obj3 = null;
                                } else {
                                    obj3 = obj2;
                                }
                                deserializationStrategy2 = (KSerializer) obj3;
                                if (deserializationStrategy2 != null) {
                                    value$iv2 = value$iv;
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                    ev = (LivXowEvent) objDecodeFromString2;
                                    if (Intrinsics.areEqual(ev.getVisible(), Boxing.boxBoolean(false))) {
                                        slug = slug;
                                        liveEventData3 = null;
                                        liveEventData2 = null;
                                    } else {
                                        int i5 = index$iv$iv + 1;
                                        String displayName5 = ev.getDisplayName();
                                        String thumbUrl5 = ev.getThumbUrl();
                                        String streamSlug5 = ev.getStreamSlug();
                                        String categoryName9 = ev.getCategoryName();
                                        String teamAName5 = ev.getTeamAName();
                                        String teamBName5 = ev.getTeamBName();
                                        String teamAFlag5 = ev.getTeamAFlag();
                                        String teamBFlag5 = ev.getTeamBFlag();
                                        String categoryName10 = ev.getCategoryName();
                                        eventName = ev.getEventName();
                                        if (eventName == null) {
                                            eventName = ev.getDisplayName();
                                        }
                                        LiveEventInfo liveEventInfo5 = new LiveEventInfo(teamAName5, teamBName5, teamAFlag5, teamBFlag5, categoryName10, eventName, ev.getThumbUrl(), null, ev.getCategoryName(), ev.startTimeString(), ev.endTimeString());
                                        link_names = ev.getLink_names();
                                        if (link_names != null) {
                                            $this$mapNotNull$iv = link_names;
                                            $i$f$mapNotNull = 0;
                                            destination$iv$iv2 = new ArrayList();
                                            while (r31.hasNext()) {
                                                LivXowEvent ev6 = ev;
                                                Iterable $this$mapNotNull$iv6 = $this$mapNotNull$iv;
                                                if (element$iv$iv$iv instanceof Map) {
                                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                    obj4 = ((Map) element$iv$iv$iv).get("name");
                                                    if (obj4 instanceof String) {
                                                        title = (String) obj4;
                                                    } else {
                                                        title = null;
                                                    }
                                                } else {
                                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                    if (element$iv$iv$iv instanceof String) {
                                                        title = (String) element$iv$iv$iv;
                                                    } else {
                                                        title = null;
                                                    }
                                                }
                                                if (title != null) {
                                                    liveEventFormat = new LiveEventFormat(title, null);
                                                } else {
                                                    liveEventFormat = null;
                                                }
                                                if (liveEventFormat != null) {
                                                    destination$iv$iv2.add(liveEventFormat);
                                                }
                                                $this$mapNotNull$iv = $this$mapNotNull$iv6;
                                                ev = ev6;
                                                $i$f$mapNotNull = $i$f$mapNotNull2;
                                                slug = slug;
                                            }
                                            slug = slug;
                                            liveEventData2 = null;
                                            listEmptyList = (List) destination$iv$iv2;
                                        } else {
                                            slug = slug;
                                            liveEventData2 = null;
                                            listEmptyList = CollectionsKt.emptyList();
                                        }
                                        liveEventData3 = new LiveEventData(i5, displayName5, thumbUrl5, streamSlug5, categoryName9, liveEventInfo5, 1, listEmptyList);
                                    }
                                } else {
                                    value$iv2 = value$iv;
                                }
                                ObjectMapper $this$readValue$iv$iv10 = MainAPIKt.getMapper();
                                String content$iv$iv5 = value$iv2;
                                objDecodeFromString2 = $this$readValue$iv$iv10.readValue(content$iv$iv5, new TypeReference<LivXowEvent>() { // from class: com.cncverse.LivXowProviderManager$fetchLiveEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                });
                                ev = (LivXowEvent) objDecodeFromString2;
                                if (Intrinsics.areEqual(ev.getVisible(), Boxing.boxBoolean(false))) {
                                    slug = slug;
                                    liveEventData3 = null;
                                    liveEventData2 = null;
                                } else {
                                    int i6 = index$iv$iv + 1;
                                    String displayName6 = ev.getDisplayName();
                                    String thumbUrl6 = ev.getThumbUrl();
                                    String streamSlug6 = ev.getStreamSlug();
                                    String categoryName11 = ev.getCategoryName();
                                    String teamAName6 = ev.getTeamAName();
                                    String teamBName6 = ev.getTeamBName();
                                    String teamAFlag6 = ev.getTeamAFlag();
                                    String teamBFlag6 = ev.getTeamBFlag();
                                    String categoryName12 = ev.getCategoryName();
                                    eventName = ev.getEventName();
                                    if (eventName == null) {
                                        eventName = ev.getDisplayName();
                                    }
                                    LiveEventInfo liveEventInfo6 = new LiveEventInfo(teamAName6, teamBName6, teamAFlag6, teamBFlag6, categoryName12, eventName, ev.getThumbUrl(), null, ev.getCategoryName(), ev.startTimeString(), ev.endTimeString());
                                    link_names = ev.getLink_names();
                                    if (link_names != null) {
                                        $this$mapNotNull$iv = link_names;
                                        $i$f$mapNotNull = 0;
                                        destination$iv$iv2 = new ArrayList();
                                        while (r31.hasNext()) {
                                            LivXowEvent ev7 = ev;
                                            Iterable $this$mapNotNull$iv7 = $this$mapNotNull$iv;
                                            if (element$iv$iv$iv instanceof Map) {
                                                $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                obj4 = ((Map) element$iv$iv$iv).get("name");
                                                if (obj4 instanceof String) {
                                                    title = (String) obj4;
                                                } else {
                                                    title = null;
                                                }
                                            } else {
                                                $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                if (element$iv$iv$iv instanceof String) {
                                                    title = (String) element$iv$iv$iv;
                                                } else {
                                                    title = null;
                                                }
                                            }
                                            if (title != null) {
                                                liveEventFormat = new LiveEventFormat(title, null);
                                            } else {
                                                liveEventFormat = null;
                                            }
                                            if (liveEventFormat != null) {
                                                destination$iv$iv2.add(liveEventFormat);
                                            }
                                            $this$mapNotNull$iv = $this$mapNotNull$iv7;
                                            ev = ev7;
                                            $i$f$mapNotNull = $i$f$mapNotNull2;
                                            slug = slug;
                                        }
                                        slug = slug;
                                        liveEventData2 = null;
                                        listEmptyList = (List) destination$iv$iv2;
                                    } else {
                                        slug = slug;
                                        liveEventData2 = null;
                                        listEmptyList = CollectionsKt.emptyList();
                                    }
                                    liveEventData3 = new LiveEventData(i6, displayName6, thumbUrl6, streamSlug6, categoryName11, liveEventInfo6, 1, listEmptyList);
                                }
                            }
                            if (liveEventData3 != null) {
                                destination$iv$iv.add(liveEventData3);
                            }
                            liveEventData = liveEventData2;
                            str2 = str;
                            index$iv$iv$iv = index$iv$iv$iv4;
                            slug = slug;
                            break;
                        }
                        return (List) destination$iv$iv;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e7) {
                System.out.println((Object) ("LivXow: fetchLiveEvents exception: " + e7.getMessage()));
                return CollectionsKt.emptyList();
            }
        }
    }

    @Nullable
    public final Object fetchLiveEvents(@NotNull Continuation<? super List<LiveEventData>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00492(null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.LivXowProviderManager$fetchCustomEvents$2 */
    /* JADX INFO: compiled from: LivXowProviderManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/cncverse/LiveEventData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.LivXowProviderManager$fetchCustomEvents$2", f = "LivXowProviderManager.kt", i = {1, 1}, l = {340, 344}, m = "invokeSuspend", n = {"baseUrl", "url"}, nl = {341, 346}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nLivXowProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowProviderManager.kt\ncom/cncverse/LivXowProviderManager$fetchCustomEvents$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,465:1\n63#2:466\n64#2,15:468\n63#2:489\n64#2,15:491\n63#2:513\n64#2,15:515\n1#3:467\n1#3:490\n1#3:514\n1#3:543\n1#3:546\n50#4:483\n43#4:484\n50#4:506\n43#4:507\n50#4:530\n43#4:531\n1606#5:485\n1617#5:486\n1924#5,2:487\n1596#5:508\n1629#5,4:509\n1642#5,10:532\n1915#5:542\n1916#5:544\n1652#5:545\n1926#5:547\n1618#5:548\n*S KotlinDebug\n*F\n+ 1 LivXowProviderManager.kt\ncom/cncverse/LivXowProviderManager$fetchCustomEvents$2\n*L\n346#1:466\n346#1:468,15\n351#1:489\n351#1:491,15\n389#1:513\n389#1:515,15\n346#1:467\n351#1:490\n389#1:514\n417#1:543\n348#1:546\n346#1:483\n346#1:484\n351#1:506\n351#1:507\n389#1:530\n389#1:531\n348#1:485\n348#1:486\n348#1:487,2\n380#1:508\n380#1:509,4\n417#1:532,10\n417#1:542\n417#1:544\n417#1:545\n348#1:547\n348#1:548\n*E\n"})
    static final class C00442 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends LiveEventData>>, Object> {
        final /* synthetic */ String $catLink;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00442(String str, Continuation<? super C00442> continuation) {
            super(2, continuation);
            this.$catLink = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00442(this.$catLink, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<LiveEventData>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:104:0x021d  */
        /* JADX WARN: Code duplicated, block: B:109:0x024b  */
        /* JADX WARN: Code duplicated, block: B:110:0x0255 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:112:0x025d A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:116:0x0266  */
        /* JADX WARN: Code duplicated, block: B:118:0x0269  */
        /* JADX WARN: Code duplicated, block: B:119:0x0273 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:121:0x027b  */
        /* JADX WARN: Code duplicated, block: B:124:0x0289 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:126:0x0293  */
        /* JADX WARN: Code duplicated, block: B:129:0x02c4 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:147:0x0365 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:154:0x03c0 A[Catch: Exception -> 0x002e, TRY_LEAVE, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:164:0x0402  */
        /* JADX WARN: Code duplicated, block: B:180:0x044f  */
        /* JADX WARN: Code duplicated, block: B:18:0x004f A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:190:0x046b A[Catch: Exception -> 0x0592, TryCatch #13 {Exception -> 0x0592, blocks: (B:178:0x0449, B:181:0x0450, B:191:0x0484, B:190:0x046b, B:189:0x0465, B:177:0x043f, B:184:0x0456), top: B:259:0x0449, inners: #22 }] */
        /* JADX WARN: Code duplicated, block: B:194:0x0495 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:195:0x0499 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:19:0x0052 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:200:0x04d7 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:203:0x04f7 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:206:0x0510 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:208:0x0527 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:210:0x0536 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:211:0x0539  */
        /* JADX WARN: Code duplicated, block: B:212:0x053b A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:214:0x0541 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:215:0x0545  */
        /* JADX WARN: Code duplicated, block: B:218:0x0549 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:219:0x0552  */
        /* JADX WARN: Code duplicated, block: B:221:0x0558 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:224:0x0576 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:22:0x0096 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:231:0x05c3  */
        /* JADX WARN: Code duplicated, block: B:234:0x05d0 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:243:0x01c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:245:0x0189 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:251:0x03d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:25:0x009b A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:265:0x040a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:267:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:269:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:271:0x0456 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:275:0x01fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:279:0x05d4 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:27:0x00a0 A[Catch: Exception -> 0x002e, TRY_LEAVE, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:282:0x055c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:47:0x010b  */
        /* JADX WARN: Code duplicated, block: B:57:0x0127 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:61:0x015d A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:63:0x0165 A[Catch: Exception -> 0x002e, TryCatch #3 {Exception -> 0x002e, blocks: (B:7:0x0021, B:23:0x0097, B:25:0x009b, B:27:0x00a0, B:38:0x00d8, B:45:0x0105, B:48:0x010c, B:58:0x013e, B:59:0x0157, B:61:0x015d, B:63:0x0165, B:64:0x0168, B:107:0x023d, B:234:0x05d0, B:110:0x0255, B:112:0x025d, B:119:0x0273, B:122:0x027d, B:124:0x0289, B:127:0x0295, B:129:0x02c4, B:131:0x02dc, B:132:0x02f5, B:134:0x02fb, B:136:0x0303, B:137:0x0306, B:139:0x031a, B:144:0x032e, B:145:0x0345, B:146:0x0358, B:148:0x036d, B:147:0x0365, B:153:0x0390, B:154:0x03c0, B:192:0x0487, B:195:0x0499, B:198:0x04a9, B:200:0x04d7, B:201:0x04db, B:203:0x04f7, B:204:0x050a, B:206:0x0510, B:208:0x0527, B:210:0x0536, B:218:0x0549, B:221:0x0558, B:212:0x053b, B:214:0x0541, B:223:0x0565, B:225:0x057f, B:224:0x0576, B:230:0x059d, B:236:0x05e4, B:57:0x0127, B:56:0x0121, B:44:0x00fa, B:37:0x00ce, B:8:0x0028, B:16:0x0043, B:18:0x004f, B:20:0x0065, B:19:0x0052, B:13:0x0035, B:41:0x00df, B:51:0x0112), top: B:242:0x000e, inners: #20, #23 }] */
        /* JADX WARN: Code duplicated, block: B:75:0x01be  */
        /* JADX WARN: Code duplicated, block: B:87:0x01f6  */
        public final Object invokeSuspend(Object $result) {
            Object baseUrl;
            String baseUrl2;
            String url;
            Object objFetchDecrypted;
            String json;
            boolean z;
            Object obj;
            DeserializationStrategy deserializationStrategy;
            Object objDecodeFromString;
            List wrappers;
            Iterable $this$mapIndexedNotNull$iv;
            Collection destination$iv$iv;
            int index$iv$iv$iv;
            int index$iv$iv;
            LivXowChannelWrapper wrapper;
            String str;
            String baseUrl3;
            List wrappers2;
            Iterable $this$mapIndexedNotNull$iv2;
            LiveEventData liveEventData;
            LiveEventData liveEventData2;
            String value$iv;
            Object obj2;
            DeserializationStrategy deserializationStrategy2;
            String value$iv2;
            Object objDecodeFromString2;
            LivXowChannelData channelData;
            String links;
            boolean z2;
            String name;
            String links2;
            String strRemoveSuffix;
            String links3;
            List listEmptyList;
            LiveEventData liveEventData3;
            Iterable iterableSplit$default;
            int $i$f$mapIndexed;
            int $i$f$mapIndexed2;
            String str2;
            String value$iv3;
            Object obj3;
            DeserializationStrategy deserializationStrategy3;
            Object objDecodeFromString3;
            LivXowEvent ev;
            String eventName;
            Iterable link_names;
            List listEmptyList2;
            Iterable $this$mapNotNull$iv;
            int $i$f$mapNotNull;
            Collection destination$iv$iv2;
            int $i$f$mapNotNullTo;
            int $i$f$mapNotNull2;
            String title;
            LiveEventFormat liveEventFormat;
            Object obj4;
            String str3 = "kotlinx.serialization.serializer.simple";
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        baseUrl = LivXowProviderManager.INSTANCE.getBaseUrl((Continuation) this);
                        if (baseUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        baseUrl2 = (String) baseUrl;
                        if (StringsKt.startsWith$default(this.$catLink, "http", false, 2, (Object) null)) {
                            url = this.$catLink;
                        } else {
                            url = baseUrl2 + this.$catLink;
                        }
                        System.out.println((Object) ("LivXow: Fetching custom events from " + url));
                        this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        this.label = 2;
                        objFetchDecrypted = LivXowProviderManager.INSTANCE.fetchDecrypted(url, (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            z = false;
                            try {
                                KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LivXowChannelWrapper.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                            } catch (Throwable th) {
                                th = th;
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                            z = false;
                        }
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            } catch (Throwable th3) {
                                Result.Companion companion4 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th3));
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
                                objDecodeFromString = $this$readValue$iv$iv.readValue(json, new TypeReference<List<? extends LivXowChannelWrapper>>() { // from class: com.cncverse.LivXowProviderManager$fetchCustomEvents$2$invokeSuspend$$inlined$parseJson$1
                                });
                            } catch (Throwable th4) {
                                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv2.readValue(json, new TypeReference<List<? extends LivXowChannelWrapper>>() { // from class: com.cncverse.LivXowProviderManager$fetchCustomEvents$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv3.readValue(json, new TypeReference<List<? extends LivXowChannelWrapper>>() { // from class: com.cncverse.LivXowProviderManager$fetchCustomEvents$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        wrappers = (List) objDecodeFromString;
                        $this$mapIndexedNotNull$iv = wrappers;
                        destination$iv$iv = new ArrayList();
                        index$iv$iv$iv = 0;
                        for (Object item$iv$iv$iv : $this$mapIndexedNotNull$iv) {
                            int index$iv$iv$iv2 = index$iv$iv$iv + 1;
                            if (index$iv$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            index$iv$iv = index$iv$iv$iv;
                            wrapper = (LivXowChannelWrapper) item$iv$iv$iv;
                            if (StringsKt.isBlank(wrapper.getChannel())) {
                                str = str3;
                                if (StringsKt.isBlank(wrapper.getHighlight())) {
                                    baseUrl3 = baseUrl2;
                                    wrappers2 = wrappers;
                                    $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                    liveEventData2 = null;
                                    liveEventData3 = null;
                                } else {
                                    try {
                                        AppUtils appUtils2 = AppUtils.INSTANCE;
                                        value$iv3 = wrapper.getHighlight();
                                        try {
                                            Result.Companion companion5 = Result.Companion;
                                            KType kTypeTypeOf2 = Reflection.typeOf(LivXowEvent.class);
                                            MagicApiIntrinsics.voidMagicApiCall(str);
                                            obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                        } catch (Throwable th5) {
                                            Result.Companion companion6 = Result.Companion;
                                            obj3 = Result.constructor-impl(ResultKt.createFailure(th5));
                                        }
                                        if (Result.exceptionOrNull-impl(obj3) == null) {
                                            baseUrl3 = baseUrl2;
                                            wrappers2 = wrappers;
                                            $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                        } else {
                                            try {
                                                Result.Companion companion7 = Result.Companion;
                                                baseUrl3 = baseUrl2;
                                                try {
                                                    wrappers2 = wrappers;
                                                    $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                                    try {
                                                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LivXowEvent.class), (List) null, 2, (Object) null));
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        Result.Companion companion8 = Result.Companion;
                                                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                                    }
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    wrappers2 = wrappers;
                                                    $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                                }
                                            } catch (Throwable th8) {
                                                th = th8;
                                                baseUrl3 = baseUrl2;
                                                wrappers2 = wrappers;
                                                $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                            }
                                        }
                                        try {
                                            if (Result.isFailure-impl(obj3)) {
                                                obj3 = null;
                                            }
                                            deserializationStrategy3 = (KSerializer) obj3;
                                            if (deserializationStrategy3 != null) {
                                                try {
                                                    objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, value$iv3);
                                                } catch (SerializationException e2) {
                                                    ArchComponentExtKt.logError(e2);
                                                    ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                                    objDecodeFromString3 = $this$readValue$iv$iv4.readValue(value$iv3, new TypeReference<LivXowEvent>() { // from class: com.cncverse.LivXowProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$2
                                                    });
                                                } catch (Throwable th9) {
                                                    ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                                    objDecodeFromString3 = $this$readValue$iv$iv5.readValue(value$iv3, new TypeReference<LivXowEvent>() { // from class: com.cncverse.LivXowProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$2
                                                    });
                                                }
                                            } else {
                                                ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                                objDecodeFromString3 = $this$readValue$iv$iv6.readValue(value$iv3, new TypeReference<LivXowEvent>() { // from class: com.cncverse.LivXowProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$2
                                                });
                                            }
                                            ev = (LivXowEvent) objDecodeFromString3;
                                            if (Intrinsics.areEqual(ev.getVisible(), Boxing.boxBoolean(z)) && !StringsKt.isBlank(ev.getStreamSlug())) {
                                                int i = index$iv$iv + 1;
                                                String displayName = ev.getDisplayName();
                                                String thumbUrl = ev.getThumbUrl();
                                                String streamSlug = ev.getStreamSlug();
                                                String categoryName = ev.getCategoryName();
                                                String teamAName = ev.getTeamAName();
                                                String teamBName = ev.getTeamBName();
                                                String teamAFlag = ev.getTeamAFlag();
                                                String teamBFlag = ev.getTeamBFlag();
                                                String categoryName2 = ev.getCategoryName();
                                                eventName = ev.getEventName();
                                                if (eventName == null) {
                                                    eventName = ev.getDisplayName();
                                                }
                                                LiveEventInfo liveEventInfo = new LiveEventInfo(teamAName, teamBName, teamAFlag, teamBFlag, categoryName2, eventName, ev.getThumbUrl(), null, ev.getCategoryName(), ev.startTimeString(), "1970/01/01 00:00:00 +0000");
                                                link_names = ev.getLink_names();
                                                if (link_names != null) {
                                                    $this$mapNotNull$iv = link_names;
                                                    $i$f$mapNotNull = 0;
                                                    destination$iv$iv2 = new ArrayList();
                                                    $i$f$mapNotNullTo = 0;
                                                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                                        LivXowEvent ev2 = ev;
                                                        Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                                        if (element$iv$iv$iv instanceof Map) {
                                                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                            obj4 = ((Map) element$iv$iv$iv).get("name");
                                                            if (obj4 instanceof String) {
                                                                title = (String) obj4;
                                                            } else {
                                                                title = null;
                                                            }
                                                        } else {
                                                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                            if (element$iv$iv$iv instanceof String) {
                                                                title = (String) element$iv$iv$iv;
                                                            } else {
                                                                title = null;
                                                            }
                                                        }
                                                        if (title != null) {
                                                            liveEventFormat = new LiveEventFormat(title, null);
                                                        } else {
                                                            liveEventFormat = null;
                                                        }
                                                        if (liveEventFormat != null) {
                                                            destination$iv$iv2.add(liveEventFormat);
                                                        }
                                                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                                        ev = ev2;
                                                        $i$f$mapNotNull = $i$f$mapNotNull2;
                                                        $i$f$mapNotNullTo = $i$f$mapNotNullTo;
                                                    }
                                                    liveEventData2 = null;
                                                    listEmptyList2 = (List) destination$iv$iv2;
                                                } else {
                                                    liveEventData2 = null;
                                                    listEmptyList2 = CollectionsKt.emptyList();
                                                }
                                                liveEventData3 = new LiveEventData(i, displayName, thumbUrl, streamSlug, categoryName, liveEventInfo, 1, listEmptyList2);
                                            } else {
                                                liveEventData = null;
                                                liveEventData2 = null;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            liveEventData2 = null;
                                            System.out.println((Object) ("LivXow: Failed to parse inner highlight at index " + index$iv$iv + ": " + e.getMessage()));
                                            liveEventData = liveEventData2;
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        baseUrl3 = baseUrl2;
                                        wrappers2 = wrappers;
                                        $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                        liveEventData2 = null;
                                    }
                                }
                                liveEventData = liveEventData3;
                                break;
                            } else {
                                try {
                                    AppUtils appUtils3 = AppUtils.INSTANCE;
                                    value$iv = wrapper.getChannel();
                                    try {
                                        Result.Companion companion9 = Result.Companion;
                                        KType kTypeTypeOf3 = Reflection.typeOf(LivXowChannelData.class);
                                        MagicApiIntrinsics.voidMagicApiCall(str3);
                                        obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                    } catch (Throwable th10) {
                                        Result.Companion companion10 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th10));
                                    }
                                    if (Result.exceptionOrNull-impl(obj2) == null) {
                                        str = str3;
                                    } else {
                                        try {
                                            Result.Companion companion11 = Result.Companion;
                                            str = str3;
                                            try {
                                                obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LivXowChannelData.class), (List) null, 2, (Object) null));
                                            } catch (Throwable th11) {
                                                th = th11;
                                                Result.Companion companion12 = Result.Companion;
                                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                            }
                                        } catch (Throwable th12) {
                                            th = th12;
                                            str = str3;
                                        }
                                    }
                                    try {
                                        if (Result.isFailure-impl(obj2)) {
                                            obj2 = null;
                                        }
                                        deserializationStrategy2 = (KSerializer) obj2;
                                        if (deserializationStrategy2 != null) {
                                            try {
                                                value$iv2 = value$iv;
                                                try {
                                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                                } catch (SerializationException e5) {
                                                    e$iv = e5;
                                                    ArchComponentExtKt.logError((Throwable) e$iv);
                                                    ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                                                    String content$iv$iv = value$iv2;
                                                    objDecodeFromString2 = $this$readValue$iv$iv7.readValue(content$iv$iv, new TypeReference<LivXowChannelData>() { // from class: com.cncverse.LivXowProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                    });
                                                } catch (Throwable th13) {
                                                    ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                                                    String content$iv$iv2 = value$iv2;
                                                    objDecodeFromString2 = $this$readValue$iv$iv8.readValue(content$iv$iv2, new TypeReference<LivXowChannelData>() { // from class: com.cncverse.LivXowProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                    });
                                                }
                                            } catch (SerializationException e6) {
                                                e$iv = e6;
                                                value$iv2 = value$iv;
                                            } catch (Throwable th14) {
                                                value$iv2 = value$iv;
                                            }
                                            channelData = (LivXowChannelData) objDecodeFromString2;
                                            if (Intrinsics.areEqual(channelData.getVisible(), Boxing.boxBoolean(z))) {
                                                baseUrl3 = baseUrl2;
                                                wrappers2 = wrappers;
                                                $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                                liveEventData = null;
                                                liveEventData2 = null;
                                            } else {
                                                links = channelData.getLinks();
                                                if (links != null || StringsKt.isBlank(links)) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                if (z2) {
                                                    baseUrl3 = baseUrl2;
                                                    wrappers2 = wrappers;
                                                    $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                                    liveEventData = null;
                                                    liveEventData2 = null;
                                                } else {
                                                    int i2 = index$iv$iv + 1;
                                                    name = channelData.getName();
                                                    if (name == null) {
                                                        name = "Unknown Channel";
                                                    }
                                                    String str4 = name;
                                                    String logo = channelData.getLogo();
                                                    links2 = channelData.getLinks();
                                                    if (links2 != null || (strRemoveSuffix = StringsKt.removeSuffix(links2, ".txt")) == null) {
                                                        strRemoveSuffix = "";
                                                    }
                                                    String str5 = strRemoveSuffix;
                                                    LiveEventInfo liveEventInfo2 = new LiveEventInfo(null, null, null, null, null, channelData.getName(), channelData.getLogo(), "0", null, null, null);
                                                    links3 = channelData.getLinks();
                                                    if (links3 != null || (iterableSplit$default = StringsKt.split$default(links3, new String[]{", "}, false, 0, 6, (Object) null)) == null) {
                                                        listEmptyList = CollectionsKt.emptyList();
                                                    } else {
                                                        Iterable $this$mapIndexed$iv = iterableSplit$default;
                                                        int $i$f$mapIndexed3 = 0;
                                                        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                                                        int index$iv$iv2 = 0;
                                                        for (Object item$iv$iv : $this$mapIndexed$iv) {
                                                            int index$iv$iv3 = index$iv$iv2 + 1;
                                                            if (index$iv$iv2 < 0) {
                                                                CollectionsKt.throwIndexOverflow();
                                                            }
                                                            String link = (String) item$iv$iv;
                                                            LivXowChannelData channelData2 = channelData;
                                                            Iterable $this$mapIndexed$iv2 = $this$mapIndexed$iv;
                                                            List<String> link_names2 = channelData2.getLink_names();
                                                            if (link_names2 != null) {
                                                                $i$f$mapIndexed = $i$f$mapIndexed3;
                                                                $i$f$mapIndexed2 = index$iv$iv2;
                                                                str2 = (String) CollectionsKt.getOrNull(link_names2, $i$f$mapIndexed2);
                                                                if (str2 == null) {
                                                                }
                                                                destination$iv$iv3.add(new LiveEventFormat(str2, link));
                                                                index$iv$iv2 = index$iv$iv3;
                                                                $this$mapIndexed$iv = $this$mapIndexed$iv2;
                                                                channelData = channelData2;
                                                                $i$f$mapIndexed3 = $i$f$mapIndexed;
                                                            } else {
                                                                $i$f$mapIndexed = $i$f$mapIndexed3;
                                                                $i$f$mapIndexed2 = index$iv$iv2;
                                                            }
                                                            int formatIndex = $i$f$mapIndexed2;
                                                            str2 = "Link " + (formatIndex + 1);
                                                            destination$iv$iv3.add(new LiveEventFormat(str2, link));
                                                            index$iv$iv2 = index$iv$iv3;
                                                            $this$mapIndexed$iv = $this$mapIndexed$iv2;
                                                            channelData = channelData2;
                                                            $i$f$mapIndexed3 = $i$f$mapIndexed;
                                                        }
                                                        listEmptyList = (List) destination$iv$iv3;
                                                    }
                                                    liveEventData3 = new LiveEventData(i2, str4, logo, str5, "Custom", liveEventInfo2, 1, listEmptyList);
                                                    baseUrl3 = baseUrl2;
                                                    wrappers2 = wrappers;
                                                    $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                                    liveEventData2 = null;
                                                    liveEventData = liveEventData3;
                                                }
                                            }
                                        } else {
                                            value$iv2 = value$iv;
                                        }
                                        ObjectMapper $this$readValue$iv$iv9 = MainAPIKt.getMapper();
                                        String content$iv$iv3 = value$iv2;
                                        objDecodeFromString2 = $this$readValue$iv$iv9.readValue(content$iv$iv3, new TypeReference<LivXowChannelData>() { // from class: com.cncverse.LivXowProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                        });
                                        channelData = (LivXowChannelData) objDecodeFromString2;
                                        if (Intrinsics.areEqual(channelData.getVisible(), Boxing.boxBoolean(z))) {
                                            baseUrl3 = baseUrl2;
                                            wrappers2 = wrappers;
                                            $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                            liveEventData = null;
                                            liveEventData2 = null;
                                        } else {
                                            links = channelData.getLinks();
                                            if (links != null) {
                                                z2 = true;
                                            } else {
                                                z2 = true;
                                            }
                                            if (z2) {
                                                baseUrl3 = baseUrl2;
                                                wrappers2 = wrappers;
                                                $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                                liveEventData = null;
                                                liveEventData2 = null;
                                            } else {
                                                int i3 = index$iv$iv + 1;
                                                name = channelData.getName();
                                                if (name == null) {
                                                    name = "Unknown Channel";
                                                }
                                                String str6 = name;
                                                String logo2 = channelData.getLogo();
                                                links2 = channelData.getLinks();
                                                if (links2 != null) {
                                                    strRemoveSuffix = "";
                                                } else {
                                                    strRemoveSuffix = "";
                                                }
                                                String str7 = strRemoveSuffix;
                                                LiveEventInfo liveEventInfo3 = new LiveEventInfo(null, null, null, null, null, channelData.getName(), channelData.getLogo(), "0", null, null, null);
                                                links3 = channelData.getLinks();
                                                if (links3 != null) {
                                                    listEmptyList = CollectionsKt.emptyList();
                                                } else {
                                                    listEmptyList = CollectionsKt.emptyList();
                                                }
                                                liveEventData3 = new LiveEventData(i3, str6, logo2, str7, "Custom", liveEventInfo3, 1, listEmptyList);
                                                baseUrl3 = baseUrl2;
                                                wrappers2 = wrappers;
                                                $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                                liveEventData2 = null;
                                                liveEventData = liveEventData3;
                                            }
                                        }
                                    } catch (Exception e7) {
                                        e = e7;
                                        System.out.println((Object) ("LivXow: Failed to parse inner custom event at index " + index$iv$iv + ": " + e.getMessage()));
                                        baseUrl3 = baseUrl2;
                                        wrappers2 = wrappers;
                                        $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                        liveEventData = null;
                                        liveEventData2 = null;
                                    }
                                } catch (Exception e8) {
                                    e = e8;
                                    str = str3;
                                }
                            }
                            if (liveEventData != null) {
                                destination$iv$iv.add(liveEventData);
                            }
                            index$iv$iv$iv = index$iv$iv$iv2;
                            $this$mapIndexedNotNull$iv = $this$mapIndexedNotNull$iv2;
                            wrappers = wrappers2;
                            baseUrl2 = baseUrl3;
                            str3 = str;
                            break;
                        }
                        return (List) destination$iv$iv;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        baseUrl = $result;
                        baseUrl2 = (String) baseUrl;
                        if (StringsKt.startsWith$default(this.$catLink, "http", false, 2, (Object) null)) {
                            url = this.$catLink;
                        } else {
                            url = baseUrl2 + this.$catLink;
                        }
                        System.out.println((Object) ("LivXow: Fetching custom events from " + url));
                        this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        this.label = 2;
                        objFetchDecrypted = LivXowProviderManager.INSTANCE.fetchDecrypted(url, (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        json = (String) objFetchDecrypted;
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils4 = AppUtils.INSTANCE;
                        Result.Companion companion13 = Result.Companion;
                        z = false;
                        KType kTypeTypeOf4 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LivXowChannelWrapper.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion14 = Result.Companion;
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
                            ObjectMapper $this$readValue$iv$iv10 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv10.readValue(json, new TypeReference<List<? extends LivXowChannelWrapper>>() { // from class: com.cncverse.LivXowProviderManager$fetchCustomEvents$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        wrappers = (List) objDecodeFromString;
                        $this$mapIndexedNotNull$iv = wrappers;
                        destination$iv$iv = new ArrayList();
                        index$iv$iv$iv = 0;
                        while (r16.hasNext()) {
                            int index$iv$iv$iv3 = index$iv$iv$iv + 1;
                            if (index$iv$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            index$iv$iv = index$iv$iv$iv;
                            wrapper = (LivXowChannelWrapper) item$iv$iv$iv;
                            if (StringsKt.isBlank(wrapper.getChannel())) {
                                str = str3;
                                if (StringsKt.isBlank(wrapper.getHighlight())) {
                                    AppUtils appUtils5 = AppUtils.INSTANCE;
                                    value$iv3 = wrapper.getHighlight();
                                    Result.Companion companion15 = Result.Companion;
                                    KType kTypeTypeOf5 = Reflection.typeOf(LivXowEvent.class);
                                    MagicApiIntrinsics.voidMagicApiCall(str);
                                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                                    if (Result.exceptionOrNull-impl(obj3) == null) {
                                        Result.Companion companion16 = Result.Companion;
                                        baseUrl3 = baseUrl2;
                                        wrappers2 = wrappers;
                                        $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LivXowEvent.class), (List) null, 2, (Object) null));
                                    } else {
                                        baseUrl3 = baseUrl2;
                                        wrappers2 = wrappers;
                                        $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                    }
                                    if (Result.isFailure-impl(obj3)) {
                                        obj3 = null;
                                    }
                                    deserializationStrategy3 = (KSerializer) obj3;
                                    if (deserializationStrategy3 != null) {
                                        objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, value$iv3);
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv11 = MainAPIKt.getMapper();
                                        objDecodeFromString3 = $this$readValue$iv$iv11.readValue(value$iv3, new TypeReference<LivXowEvent>() { // from class: com.cncverse.LivXowProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$2
                                        });
                                    }
                                    ev = (LivXowEvent) objDecodeFromString3;
                                    if (Intrinsics.areEqual(ev.getVisible(), Boxing.boxBoolean(z))) {
                                        liveEventData = null;
                                        liveEventData2 = null;
                                    } else {
                                        int i4 = index$iv$iv + 1;
                                        String displayName2 = ev.getDisplayName();
                                        String thumbUrl2 = ev.getThumbUrl();
                                        String streamSlug2 = ev.getStreamSlug();
                                        String categoryName3 = ev.getCategoryName();
                                        String teamAName2 = ev.getTeamAName();
                                        String teamBName2 = ev.getTeamBName();
                                        String teamAFlag2 = ev.getTeamAFlag();
                                        String teamBFlag2 = ev.getTeamBFlag();
                                        String categoryName4 = ev.getCategoryName();
                                        eventName = ev.getEventName();
                                        if (eventName == null) {
                                            eventName = ev.getDisplayName();
                                        }
                                        LiveEventInfo liveEventInfo4 = new LiveEventInfo(teamAName2, teamBName2, teamAFlag2, teamBFlag2, categoryName4, eventName, ev.getThumbUrl(), null, ev.getCategoryName(), ev.startTimeString(), "1970/01/01 00:00:00 +0000");
                                        link_names = ev.getLink_names();
                                        if (link_names != null) {
                                            $this$mapNotNull$iv = link_names;
                                            $i$f$mapNotNull = 0;
                                            destination$iv$iv2 = new ArrayList();
                                            $i$f$mapNotNullTo = 0;
                                            while (r27.hasNext()) {
                                                LivXowEvent ev3 = ev;
                                                Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                                                if (element$iv$iv$iv instanceof Map) {
                                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                    obj4 = ((Map) element$iv$iv$iv).get("name");
                                                    if (obj4 instanceof String) {
                                                        title = (String) obj4;
                                                    } else {
                                                        title = null;
                                                    }
                                                } else {
                                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                    if (element$iv$iv$iv instanceof String) {
                                                        title = (String) element$iv$iv$iv;
                                                    } else {
                                                        title = null;
                                                    }
                                                }
                                                if (title != null) {
                                                    liveEventFormat = new LiveEventFormat(title, null);
                                                } else {
                                                    liveEventFormat = null;
                                                }
                                                if (liveEventFormat != null) {
                                                    destination$iv$iv2.add(liveEventFormat);
                                                }
                                                $this$mapNotNull$iv = $this$mapNotNull$iv3;
                                                ev = ev3;
                                                $i$f$mapNotNull = $i$f$mapNotNull2;
                                                $i$f$mapNotNullTo = $i$f$mapNotNullTo;
                                            }
                                            liveEventData2 = null;
                                            listEmptyList2 = (List) destination$iv$iv2;
                                        } else {
                                            liveEventData2 = null;
                                            listEmptyList2 = CollectionsKt.emptyList();
                                        }
                                        liveEventData3 = new LiveEventData(i4, displayName2, thumbUrl2, streamSlug2, categoryName3, liveEventInfo4, 1, listEmptyList2);
                                    }
                                } else {
                                    baseUrl3 = baseUrl2;
                                    wrappers2 = wrappers;
                                    $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                    liveEventData2 = null;
                                    liveEventData3 = null;
                                }
                                liveEventData = liveEventData3;
                                break;
                            } else {
                                AppUtils appUtils6 = AppUtils.INSTANCE;
                                value$iv = wrapper.getChannel();
                                Result.Companion companion17 = Result.Companion;
                                KType kTypeTypeOf6 = Reflection.typeOf(LivXowChannelData.class);
                                MagicApiIntrinsics.voidMagicApiCall(str3);
                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                                if (Result.exceptionOrNull-impl(obj2) == null) {
                                    Result.Companion companion18 = Result.Companion;
                                    str = str3;
                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LivXowChannelData.class), (List) null, 2, (Object) null));
                                } else {
                                    str = str3;
                                }
                                if (Result.isFailure-impl(obj2)) {
                                    obj2 = null;
                                }
                                deserializationStrategy2 = (KSerializer) obj2;
                                if (deserializationStrategy2 != null) {
                                    value$iv2 = value$iv;
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                    channelData = (LivXowChannelData) objDecodeFromString2;
                                    if (Intrinsics.areEqual(channelData.getVisible(), Boxing.boxBoolean(z))) {
                                        baseUrl3 = baseUrl2;
                                        wrappers2 = wrappers;
                                        $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                        liveEventData = null;
                                        liveEventData2 = null;
                                    } else {
                                        links = channelData.getLinks();
                                        if (links != null) {
                                            z2 = true;
                                        } else {
                                            z2 = true;
                                        }
                                        if (z2) {
                                            baseUrl3 = baseUrl2;
                                            wrappers2 = wrappers;
                                            $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                            liveEventData = null;
                                            liveEventData2 = null;
                                        } else {
                                            int i5 = index$iv$iv + 1;
                                            name = channelData.getName();
                                            if (name == null) {
                                                name = "Unknown Channel";
                                            }
                                            String str8 = name;
                                            String logo3 = channelData.getLogo();
                                            links2 = channelData.getLinks();
                                            if (links2 != null) {
                                                strRemoveSuffix = "";
                                            } else {
                                                strRemoveSuffix = "";
                                            }
                                            String str9 = strRemoveSuffix;
                                            LiveEventInfo liveEventInfo5 = new LiveEventInfo(null, null, null, null, null, channelData.getName(), channelData.getLogo(), "0", null, null, null);
                                            links3 = channelData.getLinks();
                                            if (links3 != null) {
                                                listEmptyList = CollectionsKt.emptyList();
                                            } else {
                                                listEmptyList = CollectionsKt.emptyList();
                                            }
                                            liveEventData3 = new LiveEventData(i5, str8, logo3, str9, "Custom", liveEventInfo5, 1, listEmptyList);
                                            baseUrl3 = baseUrl2;
                                            wrappers2 = wrappers;
                                            $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                            liveEventData2 = null;
                                            liveEventData = liveEventData3;
                                        }
                                    }
                                } else {
                                    value$iv2 = value$iv;
                                }
                                ObjectMapper $this$readValue$iv$iv12 = MainAPIKt.getMapper();
                                String content$iv$iv4 = value$iv2;
                                objDecodeFromString2 = $this$readValue$iv$iv12.readValue(content$iv$iv4, new TypeReference<LivXowChannelData>() { // from class: com.cncverse.LivXowProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                });
                                channelData = (LivXowChannelData) objDecodeFromString2;
                                if (Intrinsics.areEqual(channelData.getVisible(), Boxing.boxBoolean(z))) {
                                    baseUrl3 = baseUrl2;
                                    wrappers2 = wrappers;
                                    $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                    liveEventData = null;
                                    liveEventData2 = null;
                                } else {
                                    links = channelData.getLinks();
                                    if (links != null) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        baseUrl3 = baseUrl2;
                                        wrappers2 = wrappers;
                                        $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                        liveEventData = null;
                                        liveEventData2 = null;
                                    } else {
                                        int i6 = index$iv$iv + 1;
                                        name = channelData.getName();
                                        if (name == null) {
                                            name = "Unknown Channel";
                                        }
                                        String str10 = name;
                                        String logo4 = channelData.getLogo();
                                        links2 = channelData.getLinks();
                                        if (links2 != null) {
                                            strRemoveSuffix = "";
                                        } else {
                                            strRemoveSuffix = "";
                                        }
                                        String str11 = strRemoveSuffix;
                                        LiveEventInfo liveEventInfo6 = new LiveEventInfo(null, null, null, null, null, channelData.getName(), channelData.getLogo(), "0", null, null, null);
                                        links3 = channelData.getLinks();
                                        if (links3 != null) {
                                            listEmptyList = CollectionsKt.emptyList();
                                        } else {
                                            listEmptyList = CollectionsKt.emptyList();
                                        }
                                        liveEventData3 = new LiveEventData(i6, str10, logo4, str11, "Custom", liveEventInfo6, 1, listEmptyList);
                                        baseUrl3 = baseUrl2;
                                        wrappers2 = wrappers;
                                        $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                        liveEventData2 = null;
                                        liveEventData = liveEventData3;
                                    }
                                }
                            }
                            if (liveEventData != null) {
                                destination$iv$iv.add(liveEventData);
                            }
                            index$iv$iv$iv = index$iv$iv$iv3;
                            $this$mapIndexedNotNull$iv = $this$mapIndexedNotNull$iv2;
                            wrappers = wrappers2;
                            baseUrl2 = baseUrl3;
                            str3 = str;
                            break;
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
                        AppUtils appUtils7 = AppUtils.INSTANCE;
                        Result.Companion companion19 = Result.Companion;
                        z = false;
                        KType kTypeTypeOf7 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LivXowChannelWrapper.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf7));
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion110 = Result.Companion;
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
                            ObjectMapper $this$readValue$iv$iv13 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv13.readValue(json, new TypeReference<List<? extends LivXowChannelWrapper>>() { // from class: com.cncverse.LivXowProviderManager$fetchCustomEvents$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        wrappers = (List) objDecodeFromString;
                        $this$mapIndexedNotNull$iv = wrappers;
                        destination$iv$iv = new ArrayList();
                        index$iv$iv$iv = 0;
                        while (r16.hasNext()) {
                            int index$iv$iv$iv4 = index$iv$iv$iv + 1;
                            if (index$iv$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            index$iv$iv = index$iv$iv$iv;
                            wrapper = (LivXowChannelWrapper) item$iv$iv$iv;
                            if (StringsKt.isBlank(wrapper.getChannel())) {
                                str = str3;
                                if (StringsKt.isBlank(wrapper.getHighlight())) {
                                    AppUtils appUtils8 = AppUtils.INSTANCE;
                                    value$iv3 = wrapper.getHighlight();
                                    Result.Companion companion111 = Result.Companion;
                                    KType kTypeTypeOf8 = Reflection.typeOf(LivXowEvent.class);
                                    MagicApiIntrinsics.voidMagicApiCall(str);
                                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf8));
                                    if (Result.exceptionOrNull-impl(obj3) == null) {
                                        Result.Companion companion112 = Result.Companion;
                                        baseUrl3 = baseUrl2;
                                        wrappers2 = wrappers;
                                        $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LivXowEvent.class), (List) null, 2, (Object) null));
                                    } else {
                                        baseUrl3 = baseUrl2;
                                        wrappers2 = wrappers;
                                        $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                    }
                                    if (Result.isFailure-impl(obj3)) {
                                        obj3 = null;
                                    }
                                    deserializationStrategy3 = (KSerializer) obj3;
                                    if (deserializationStrategy3 != null) {
                                        objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, value$iv3);
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv14 = MainAPIKt.getMapper();
                                        objDecodeFromString3 = $this$readValue$iv$iv14.readValue(value$iv3, new TypeReference<LivXowEvent>() { // from class: com.cncverse.LivXowProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$2
                                        });
                                    }
                                    ev = (LivXowEvent) objDecodeFromString3;
                                    if (Intrinsics.areEqual(ev.getVisible(), Boxing.boxBoolean(z))) {
                                        liveEventData = null;
                                        liveEventData2 = null;
                                    } else {
                                        int i7 = index$iv$iv + 1;
                                        String displayName3 = ev.getDisplayName();
                                        String thumbUrl3 = ev.getThumbUrl();
                                        String streamSlug3 = ev.getStreamSlug();
                                        String categoryName5 = ev.getCategoryName();
                                        String teamAName3 = ev.getTeamAName();
                                        String teamBName3 = ev.getTeamBName();
                                        String teamAFlag3 = ev.getTeamAFlag();
                                        String teamBFlag3 = ev.getTeamBFlag();
                                        String categoryName6 = ev.getCategoryName();
                                        eventName = ev.getEventName();
                                        if (eventName == null) {
                                            eventName = ev.getDisplayName();
                                        }
                                        LiveEventInfo liveEventInfo7 = new LiveEventInfo(teamAName3, teamBName3, teamAFlag3, teamBFlag3, categoryName6, eventName, ev.getThumbUrl(), null, ev.getCategoryName(), ev.startTimeString(), "1970/01/01 00:00:00 +0000");
                                        link_names = ev.getLink_names();
                                        if (link_names != null) {
                                            $this$mapNotNull$iv = link_names;
                                            $i$f$mapNotNull = 0;
                                            destination$iv$iv2 = new ArrayList();
                                            $i$f$mapNotNullTo = 0;
                                            while (r27.hasNext()) {
                                                LivXowEvent ev4 = ev;
                                                Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                                                if (element$iv$iv$iv instanceof Map) {
                                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                    obj4 = ((Map) element$iv$iv$iv).get("name");
                                                    if (obj4 instanceof String) {
                                                        title = (String) obj4;
                                                    } else {
                                                        title = null;
                                                    }
                                                } else {
                                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                    if (element$iv$iv$iv instanceof String) {
                                                        title = (String) element$iv$iv$iv;
                                                    } else {
                                                        title = null;
                                                    }
                                                }
                                                if (title != null) {
                                                    liveEventFormat = new LiveEventFormat(title, null);
                                                } else {
                                                    liveEventFormat = null;
                                                }
                                                if (liveEventFormat != null) {
                                                    destination$iv$iv2.add(liveEventFormat);
                                                }
                                                $this$mapNotNull$iv = $this$mapNotNull$iv4;
                                                ev = ev4;
                                                $i$f$mapNotNull = $i$f$mapNotNull2;
                                                $i$f$mapNotNullTo = $i$f$mapNotNullTo;
                                            }
                                            liveEventData2 = null;
                                            listEmptyList2 = (List) destination$iv$iv2;
                                        } else {
                                            liveEventData2 = null;
                                            listEmptyList2 = CollectionsKt.emptyList();
                                        }
                                        liveEventData3 = new LiveEventData(i7, displayName3, thumbUrl3, streamSlug3, categoryName5, liveEventInfo7, 1, listEmptyList2);
                                    }
                                } else {
                                    baseUrl3 = baseUrl2;
                                    wrappers2 = wrappers;
                                    $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                    liveEventData2 = null;
                                    liveEventData3 = null;
                                }
                                liveEventData = liveEventData3;
                                break;
                            } else {
                                AppUtils appUtils9 = AppUtils.INSTANCE;
                                value$iv = wrapper.getChannel();
                                Result.Companion companion113 = Result.Companion;
                                KType kTypeTypeOf9 = Reflection.typeOf(LivXowChannelData.class);
                                MagicApiIntrinsics.voidMagicApiCall(str3);
                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf9));
                                if (Result.exceptionOrNull-impl(obj2) == null) {
                                    Result.Companion companion114 = Result.Companion;
                                    str = str3;
                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LivXowChannelData.class), (List) null, 2, (Object) null));
                                } else {
                                    str = str3;
                                }
                                if (Result.isFailure-impl(obj2)) {
                                    obj2 = null;
                                }
                                deserializationStrategy2 = (KSerializer) obj2;
                                if (deserializationStrategy2 != null) {
                                    value$iv2 = value$iv;
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv2);
                                    channelData = (LivXowChannelData) objDecodeFromString2;
                                    if (Intrinsics.areEqual(channelData.getVisible(), Boxing.boxBoolean(z))) {
                                        baseUrl3 = baseUrl2;
                                        wrappers2 = wrappers;
                                        $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                        liveEventData = null;
                                        liveEventData2 = null;
                                    } else {
                                        links = channelData.getLinks();
                                        if (links != null) {
                                            z2 = true;
                                        } else {
                                            z2 = true;
                                        }
                                        if (z2) {
                                            baseUrl3 = baseUrl2;
                                            wrappers2 = wrappers;
                                            $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                            liveEventData = null;
                                            liveEventData2 = null;
                                        } else {
                                            int i8 = index$iv$iv + 1;
                                            name = channelData.getName();
                                            if (name == null) {
                                                name = "Unknown Channel";
                                            }
                                            String str12 = name;
                                            String logo5 = channelData.getLogo();
                                            links2 = channelData.getLinks();
                                            if (links2 != null) {
                                                strRemoveSuffix = "";
                                            } else {
                                                strRemoveSuffix = "";
                                            }
                                            String str13 = strRemoveSuffix;
                                            LiveEventInfo liveEventInfo8 = new LiveEventInfo(null, null, null, null, null, channelData.getName(), channelData.getLogo(), "0", null, null, null);
                                            links3 = channelData.getLinks();
                                            if (links3 != null) {
                                                listEmptyList = CollectionsKt.emptyList();
                                            } else {
                                                listEmptyList = CollectionsKt.emptyList();
                                            }
                                            liveEventData3 = new LiveEventData(i8, str12, logo5, str13, "Custom", liveEventInfo8, 1, listEmptyList);
                                            baseUrl3 = baseUrl2;
                                            wrappers2 = wrappers;
                                            $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                            liveEventData2 = null;
                                            liveEventData = liveEventData3;
                                        }
                                    }
                                } else {
                                    value$iv2 = value$iv;
                                }
                                ObjectMapper $this$readValue$iv$iv15 = MainAPIKt.getMapper();
                                String content$iv$iv5 = value$iv2;
                                objDecodeFromString2 = $this$readValue$iv$iv15.readValue(content$iv$iv5, new TypeReference<LivXowChannelData>() { // from class: com.cncverse.LivXowProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                });
                                channelData = (LivXowChannelData) objDecodeFromString2;
                                if (Intrinsics.areEqual(channelData.getVisible(), Boxing.boxBoolean(z))) {
                                    baseUrl3 = baseUrl2;
                                    wrappers2 = wrappers;
                                    $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                    liveEventData = null;
                                    liveEventData2 = null;
                                } else {
                                    links = channelData.getLinks();
                                    if (links != null) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        baseUrl3 = baseUrl2;
                                        wrappers2 = wrappers;
                                        $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                        liveEventData = null;
                                        liveEventData2 = null;
                                    } else {
                                        int i9 = index$iv$iv + 1;
                                        name = channelData.getName();
                                        if (name == null) {
                                            name = "Unknown Channel";
                                        }
                                        String str14 = name;
                                        String logo6 = channelData.getLogo();
                                        links2 = channelData.getLinks();
                                        if (links2 != null) {
                                            strRemoveSuffix = "";
                                        } else {
                                            strRemoveSuffix = "";
                                        }
                                        String str15 = strRemoveSuffix;
                                        LiveEventInfo liveEventInfo9 = new LiveEventInfo(null, null, null, null, null, channelData.getName(), channelData.getLogo(), "0", null, null, null);
                                        links3 = channelData.getLinks();
                                        if (links3 != null) {
                                            listEmptyList = CollectionsKt.emptyList();
                                        } else {
                                            listEmptyList = CollectionsKt.emptyList();
                                        }
                                        liveEventData3 = new LiveEventData(i9, str14, logo6, str15, "Custom", liveEventInfo9, 1, listEmptyList);
                                        baseUrl3 = baseUrl2;
                                        wrappers2 = wrappers;
                                        $this$mapIndexedNotNull$iv2 = $this$mapIndexedNotNull$iv;
                                        liveEventData2 = null;
                                        liveEventData = liveEventData3;
                                    }
                                }
                            }
                            if (liveEventData != null) {
                                destination$iv$iv.add(liveEventData);
                            }
                            index$iv$iv$iv = index$iv$iv$iv4;
                            $this$mapIndexedNotNull$iv = $this$mapIndexedNotNull$iv2;
                            wrappers = wrappers2;
                            baseUrl2 = baseUrl3;
                            str3 = str;
                            break;
                        }
                        return (List) destination$iv$iv;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e9) {
                System.out.println((Object) ("LivXow: fetchCustomEvents exception: " + e9.getMessage()));
                return CollectionsKt.emptyList();
            }
        }
    }

    @Nullable
    public final Object fetchCustomEvents(@NotNull String catLink, @NotNull Continuation<? super List<LiveEventData>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00442(catLink, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0088 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x008d  */
    /* JADX WARN: Code duplicated, block: B:25:0x00b3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object fetchStreamData(@NotNull String slug, @NotNull Continuation<? super String> continuation) {
        C00551 c00551;
        Object baseUrl;
        String baseUrl2;
        Object objFetchDecrypted;
        String str;
        Object objFetchDecrypted2;
        if (continuation instanceof C00551) {
            c00551 = (C00551) continuation;
            if ((c00551.label & Integer.MIN_VALUE) != 0) {
                c00551.label -= Integer.MIN_VALUE;
            } else {
                c00551 = new C00551(continuation);
            }
        } else {
            c00551 = new C00551(continuation);
        }
        Object $result = c00551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00551.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00551.L$0 = slug;
                c00551.label = 1;
                baseUrl = getBaseUrl(c00551);
                if (baseUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                baseUrl2 = (String) baseUrl;
                c00551.L$0 = slug;
                c00551.L$1 = baseUrl2;
                c00551.label = 2;
                objFetchDecrypted = fetchDecrypted(baseUrl2 + slug + ".txt", c00551);
                if (objFetchDecrypted == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = (String) objFetchDecrypted;
                if (str != null) {
                    return str;
                }
                c00551.L$0 = SpillingKt.nullOutSpilledVariable(slug);
                c00551.L$1 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                c00551.label = 3;
                objFetchDecrypted2 = fetchDecrypted(baseUrl2 + slug, c00551);
                if (objFetchDecrypted2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objFetchDecrypted2;
            case 1:
                slug = (String) c00551.L$0;
                ResultKt.throwOnFailure($result);
                baseUrl = $result;
                baseUrl2 = (String) baseUrl;
                c00551.L$0 = slug;
                c00551.L$1 = baseUrl2;
                c00551.label = 2;
                objFetchDecrypted = fetchDecrypted(baseUrl2 + slug + ".txt", c00551);
                if (objFetchDecrypted == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = (String) objFetchDecrypted;
                if (str != null) {
                    return str;
                }
                c00551.L$0 = SpillingKt.nullOutSpilledVariable(slug);
                c00551.L$1 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                c00551.label = 3;
                objFetchDecrypted2 = fetchDecrypted(baseUrl2 + slug, c00551);
                if (objFetchDecrypted2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objFetchDecrypted2;
            case 2:
                baseUrl2 = (String) c00551.L$1;
                slug = (String) c00551.L$0;
                ResultKt.throwOnFailure($result);
                objFetchDecrypted = $result;
                str = (String) objFetchDecrypted;
                if (str != null) {
                    return str;
                }
                c00551.L$0 = SpillingKt.nullOutSpilledVariable(slug);
                c00551.L$1 = SpillingKt.nullOutSpilledVariable(baseUrl2);
                c00551.label = 3;
                objFetchDecrypted2 = fetchDecrypted(baseUrl2 + slug, c00551);
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

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object getTelegramUrl(@NotNull Continuation<? super String> continuation) {
        C00571 c00571;
        Object telegramUrl;
        if (continuation instanceof C00571) {
            c00571 = (C00571) continuation;
            if ((c00571.label & Integer.MIN_VALUE) != 0) {
                c00571.label -= Integer.MIN_VALUE;
            } else {
                c00571 = new C00571(continuation);
            }
        } else {
            c00571 = new C00571(continuation);
        }
        Object $result = c00571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (c00571.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LivXowFirebaseFetcher livXowFirebaseFetcher = LivXowFirebaseFetcher.INSTANCE;
                c00571.label = 1;
                telegramUrl = livXowFirebaseFetcher.getTelegramUrl(c00571);
                if (telegramUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                telegramUrl = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String firebaseTelegram = (String) telegramUrl;
        String str = firebaseTelegram;
        if (str != null && !StringsKt.isBlank(str)) {
            z = false;
        }
        return !z ? firebaseTelegram : "https://t.me/LivXowofficial";
    }
}
