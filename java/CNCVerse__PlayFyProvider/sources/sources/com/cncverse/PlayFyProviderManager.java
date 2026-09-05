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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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

/* JADX INFO: compiled from: PlayFyProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/PlayFyProvider/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\fJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00130\u0012H\u0086@¢\u0006\u0002\u0010\fJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012H\u0086@¢\u0006\u0002\u0010\fJ\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012H\u0086@¢\u0006\u0002\u0010\fJ\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00122\u0006\u0010\u0018\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0019J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001c\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/cncverse/PlayFyProviderManager;", "", "<init>", "()V", "DEFAULT_BASE_URL", "", "USER_AGENT", "cachedBaseUrl", "cachedLora", "client", "Lokhttp3/OkHttpClient;", "getBaseUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLora", "fetchAndDecrypt", "url", "lora", "fetchProviders", "", "", "fetchLiveEvents", "Lcom/cncverse/PlayFyChannel;", "fetchHighlights", "fetchChannelList", "path", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchChannelStreams", "Lcom/cncverse/PlayFyStreamEntry;", "channelId", "PlayFyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlayFyProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayFyProviderManager.kt\ncom/cncverse/PlayFyProviderManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,203:1\n1#2:204\n1#2:206\n63#3:205\n64#3,15:207\n50#4:222\n43#4:223\n777#5:224\n873#5,2:225\n*S KotlinDebug\n*F\n+ 1 PlayFyProviderManager.kt\ncom/cncverse/PlayFyProviderManager\n*L\n177#1:206\n177#1:205\n177#1:207,15\n177#1:222\n177#1:223\n178#1:224\n178#1:225,2\n*E\n"})
public final class PlayFyProviderManager {

    @NotNull
    private static final String DEFAULT_BASE_URL = "https://reliablewebcenter.online";

    @NotNull
    private static final String USER_AGENT = "PLAYFy/1.7 (Android)";

    @Nullable
    private static String cachedBaseUrl;

    @Nullable
    private static String cachedLora;

    @NotNull
    public static final PlayFyProviderManager INSTANCE = new PlayFyProviderManager();

    @NotNull
    private static final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();

    /* JADX INFO: renamed from: com.cncverse.PlayFyProviderManager$fetchChannelList$1 */
    /* JADX INFO: compiled from: PlayFyProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyProviderManager", f = "PlayFyProviderManager.kt", i = {0, 1, 1}, l = {173, 174}, m = "fetchChannelList", n = {"path", "path", "lora"}, nl = {174, 175}, s = {"L$0", "L$0", "L$1"}, v = 2)
    static final class C00281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00281(Continuation<? super C00281> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayFyProviderManager.this.fetchChannelList(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyProviderManager$getBaseUrl$1 */
    /* JADX INFO: compiled from: PlayFyProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyProviderManager", f = "PlayFyProviderManager.kt", i = {}, l = {88}, m = "getBaseUrl", n = {}, nl = {89}, s = {}, v = 2)
    static final class C00351 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00351(Continuation<? super C00351> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayFyProviderManager.this.getBaseUrl((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyProviderManager$getLora$1 */
    /* JADX INFO: compiled from: PlayFyProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyProviderManager", f = "PlayFyProviderManager.kt", i = {}, l = {95}, m = "getLora", n = {}, nl = {96}, s = {}, v = 2)
    static final class C00361 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00361(Continuation<? super C00361> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayFyProviderManager.this.getLora((Continuation) this);
        }
    }

    private PlayFyProviderManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getBaseUrl(Continuation<? super String> continuation) {
        C00351 c00351;
        Object baseUrl;
        if (continuation instanceof C00351) {
            c00351 = (C00351) continuation;
            if ((c00351.label & Integer.MIN_VALUE) != 0) {
                c00351.label -= Integer.MIN_VALUE;
            } else {
                c00351 = new C00351(continuation);
            }
        } else {
            c00351 = new C00351(continuation);
        }
        Object $result = c00351.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (c00351.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String it = cachedBaseUrl;
                if (it != null) {
                    return it;
                }
                PlayFyFirebaseConfigFetcher playFyFirebaseConfigFetcher = PlayFyFirebaseConfigFetcher.INSTANCE;
                c00351.label = 1;
                baseUrl = playFyFirebaseConfigFetcher.getBaseUrl(c00351);
                if (baseUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                baseUrl = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String fb = (String) baseUrl;
        String str = fb;
        if (str != null && !StringsKt.isBlank(str)) {
            z = false;
        }
        cachedBaseUrl = !z ? fb : DEFAULT_BASE_URL;
        String str2 = cachedBaseUrl;
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getLora(Continuation<? super String> continuation) {
        C00361 c00361;
        Object lora;
        if (continuation instanceof C00361) {
            c00361 = (C00361) continuation;
            if ((c00361.label & Integer.MIN_VALUE) != 0) {
                c00361.label -= Integer.MIN_VALUE;
            } else {
                c00361 = new C00361(continuation);
            }
        } else {
            c00361 = new C00361(continuation);
        }
        Object $result = c00361.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (c00361.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String it = cachedLora;
                if (it != null) {
                    return it;
                }
                PlayFyFirebaseConfigFetcher playFyFirebaseConfigFetcher = PlayFyFirebaseConfigFetcher.INSTANCE;
                c00361.label = 1;
                lora = playFyFirebaseConfigFetcher.getLora(c00361);
                if (lora == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                lora = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String fb = (String) lora;
        String str = fb;
        if (str != null && !StringsKt.isBlank(str)) {
            z = false;
        }
        cachedLora = !z ? fb : PlayFyCryptoUtils.DEFAULT_LORA;
        String str2 = cachedLora;
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String fetchAndDecrypt(String url, String lora) {
        try {
            Request req = new Request.Builder().url(url).header("User-Agent", USER_AGENT).header("Accept", "application/json").build();
            Response resp = client.newCall(req).execute();
            if (!resp.isSuccessful()) {
                System.out.println((Object) ("PlayFy: HTTP " + resp.code() + " → " + url));
                return null;
            }
            String raw = resp.body().string();
            if (StringsKt.isBlank(raw)) {
                return null;
            }
            String encoded = PlayFyCryptoUtils.INSTANCE.extractDataField(raw);
            String t = StringsKt.trimStart(encoded).toString();
            if (!StringsKt.startsWith$default(t, "[", false, 2, (Object) null) && !StringsKt.startsWith$default(t, "{", false, 2, (Object) null)) {
                return PlayFyCryptoUtils.INSTANCE.decryptPlayFy(encoded, lora, PlayFyCryptoUtils.DEFAULT_SIG);
            }
            return encoded;
        } catch (Exception e) {
            System.out.println((Object) ("PlayFy: fetchAndDecrypt error for " + url + ": " + e.getMessage()));
            return null;
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyProviderManager$fetchProviders$2 */
    /* JADX INFO: compiled from: PlayFyProviderManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyProviderManager$fetchProviders$2", f = "PlayFyProviderManager.kt", i = {1}, l = {136, 137}, m = "invokeSuspend", n = {"lora"}, nl = {137, 138}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nPlayFyProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayFyProviderManager.kt\ncom/cncverse/PlayFyProviderManager$fetchProviders$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,203:1\n63#2:204\n64#2,15:206\n1#3:205\n1#3:237\n50#4:221\n43#4:222\n777#5:223\n873#5,2:224\n1642#5,10:226\n1915#5:236\n1916#5:238\n1652#5:239\n*S KotlinDebug\n*F\n+ 1 PlayFyProviderManager.kt\ncom/cncverse/PlayFyProviderManager$fetchProviders$2\n*L\n140#1:204\n140#1:206,15\n140#1:205\n142#1:237\n140#1:221\n140#1:222\n141#1:223\n141#1:224,2\n142#1:226,10\n142#1:236\n142#1:238\n142#1:239\n*E\n"})
    static final class C00332 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>>, Object> {
        Object L$0;
        Object L$1;
        int label;

        C00332(Continuation<? super C00332> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00332(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:102:0x0221 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:18:0x0056 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:19:0x0057  */
        /* JADX WARN: Code duplicated, block: B:22:0x0089 A[Catch: Exception -> 0x0029, TryCatch #2 {Exception -> 0x0029, blocks: (B:7:0x001d, B:20:0x0058, B:22:0x0089, B:24:0x008e, B:30:0x00c3, B:38:0x00f1, B:41:0x00f8, B:51:0x0128, B:52:0x013b, B:54:0x0141, B:56:0x015b, B:58:0x0161, B:60:0x016d, B:65:0x017e, B:67:0x0184, B:68:0x019f, B:70:0x01a5, B:84:0x021d, B:73:0x01bf, B:78:0x01d9, B:82:0x01f6, B:86:0x0228, B:50:0x0113, B:49:0x010d, B:37:0x00e6, B:29:0x00b9, B:8:0x0023, B:16:0x003e, B:13:0x0030, B:34:0x00cb, B:26:0x0094, B:44:0x00fe), top: B:92:0x000a, inners: #1, #3, #5 }] */
        /* JADX WARN: Code duplicated, block: B:24:0x008e A[Catch: Exception -> 0x0029, TRY_LEAVE, TryCatch #2 {Exception -> 0x0029, blocks: (B:7:0x001d, B:20:0x0058, B:22:0x0089, B:24:0x008e, B:30:0x00c3, B:38:0x00f1, B:41:0x00f8, B:51:0x0128, B:52:0x013b, B:54:0x0141, B:56:0x015b, B:58:0x0161, B:60:0x016d, B:65:0x017e, B:67:0x0184, B:68:0x019f, B:70:0x01a5, B:84:0x021d, B:73:0x01bf, B:78:0x01d9, B:82:0x01f6, B:86:0x0228, B:50:0x0113, B:49:0x010d, B:37:0x00e6, B:29:0x00b9, B:8:0x0023, B:16:0x003e, B:13:0x0030, B:34:0x00cb, B:26:0x0094, B:44:0x00fe), top: B:92:0x000a, inners: #1, #3, #5 }] */
        /* JADX WARN: Code duplicated, block: B:40:0x00f7  */
        /* JADX WARN: Code duplicated, block: B:50:0x0113 A[Catch: Exception -> 0x0029, TryCatch #2 {Exception -> 0x0029, blocks: (B:7:0x001d, B:20:0x0058, B:22:0x0089, B:24:0x008e, B:30:0x00c3, B:38:0x00f1, B:41:0x00f8, B:51:0x0128, B:52:0x013b, B:54:0x0141, B:56:0x015b, B:58:0x0161, B:60:0x016d, B:65:0x017e, B:67:0x0184, B:68:0x019f, B:70:0x01a5, B:84:0x021d, B:73:0x01bf, B:78:0x01d9, B:82:0x01f6, B:86:0x0228, B:50:0x0113, B:49:0x010d, B:37:0x00e6, B:29:0x00b9, B:8:0x0023, B:16:0x003e, B:13:0x0030, B:34:0x00cb, B:26:0x0094, B:44:0x00fe), top: B:92:0x000a, inners: #1, #3, #5 }] */
        /* JADX WARN: Code duplicated, block: B:54:0x0141 A[Catch: Exception -> 0x0029, TryCatch #2 {Exception -> 0x0029, blocks: (B:7:0x001d, B:20:0x0058, B:22:0x0089, B:24:0x008e, B:30:0x00c3, B:38:0x00f1, B:41:0x00f8, B:51:0x0128, B:52:0x013b, B:54:0x0141, B:56:0x015b, B:58:0x0161, B:60:0x016d, B:65:0x017e, B:67:0x0184, B:68:0x019f, B:70:0x01a5, B:84:0x021d, B:73:0x01bf, B:78:0x01d9, B:82:0x01f6, B:86:0x0228, B:50:0x0113, B:49:0x010d, B:37:0x00e6, B:29:0x00b9, B:8:0x0023, B:16:0x003e, B:13:0x0030, B:34:0x00cb, B:26:0x0094, B:44:0x00fe), top: B:92:0x000a, inners: #1, #3, #5 }] */
        /* JADX WARN: Code duplicated, block: B:56:0x015b A[Catch: Exception -> 0x0029, TryCatch #2 {Exception -> 0x0029, blocks: (B:7:0x001d, B:20:0x0058, B:22:0x0089, B:24:0x008e, B:30:0x00c3, B:38:0x00f1, B:41:0x00f8, B:51:0x0128, B:52:0x013b, B:54:0x0141, B:56:0x015b, B:58:0x0161, B:60:0x016d, B:65:0x017e, B:67:0x0184, B:68:0x019f, B:70:0x01a5, B:84:0x021d, B:73:0x01bf, B:78:0x01d9, B:82:0x01f6, B:86:0x0228, B:50:0x0113, B:49:0x010d, B:37:0x00e6, B:29:0x00b9, B:8:0x0023, B:16:0x003e, B:13:0x0030, B:34:0x00cb, B:26:0x0094, B:44:0x00fe), top: B:92:0x000a, inners: #1, #3, #5 }] */
        /* JADX WARN: Code duplicated, block: B:63:0x017b  */
        /* JADX WARN: Code duplicated, block: B:65:0x017e A[Catch: Exception -> 0x0029, TryCatch #2 {Exception -> 0x0029, blocks: (B:7:0x001d, B:20:0x0058, B:22:0x0089, B:24:0x008e, B:30:0x00c3, B:38:0x00f1, B:41:0x00f8, B:51:0x0128, B:52:0x013b, B:54:0x0141, B:56:0x015b, B:58:0x0161, B:60:0x016d, B:65:0x017e, B:67:0x0184, B:68:0x019f, B:70:0x01a5, B:84:0x021d, B:73:0x01bf, B:78:0x01d9, B:82:0x01f6, B:86:0x0228, B:50:0x0113, B:49:0x010d, B:37:0x00e6, B:29:0x00b9, B:8:0x0023, B:16:0x003e, B:13:0x0030, B:34:0x00cb, B:26:0x0094, B:44:0x00fe), top: B:92:0x000a, inners: #1, #3, #5 }] */
        /* JADX WARN: Code duplicated, block: B:70:0x01a5 A[Catch: Exception -> 0x0029, TryCatch #2 {Exception -> 0x0029, blocks: (B:7:0x001d, B:20:0x0058, B:22:0x0089, B:24:0x008e, B:30:0x00c3, B:38:0x00f1, B:41:0x00f8, B:51:0x0128, B:52:0x013b, B:54:0x0141, B:56:0x015b, B:58:0x0161, B:60:0x016d, B:65:0x017e, B:67:0x0184, B:68:0x019f, B:70:0x01a5, B:84:0x021d, B:73:0x01bf, B:78:0x01d9, B:82:0x01f6, B:86:0x0228, B:50:0x0113, B:49:0x010d, B:37:0x00e6, B:29:0x00b9, B:8:0x0023, B:16:0x003e, B:13:0x0030, B:34:0x00cb, B:26:0x0094, B:44:0x00fe), top: B:92:0x000a, inners: #1, #3, #5 }] */
        /* JADX WARN: Code duplicated, block: B:72:0x01b9  */
        /* JADX WARN: Code duplicated, block: B:73:0x01bf A[Catch: Exception -> 0x0029, TRY_LEAVE, TryCatch #2 {Exception -> 0x0029, blocks: (B:7:0x001d, B:20:0x0058, B:22:0x0089, B:24:0x008e, B:30:0x00c3, B:38:0x00f1, B:41:0x00f8, B:51:0x0128, B:52:0x013b, B:54:0x0141, B:56:0x015b, B:58:0x0161, B:60:0x016d, B:65:0x017e, B:67:0x0184, B:68:0x019f, B:70:0x01a5, B:84:0x021d, B:73:0x01bf, B:78:0x01d9, B:82:0x01f6, B:86:0x0228, B:50:0x0113, B:49:0x010d, B:37:0x00e6, B:29:0x00b9, B:8:0x0023, B:16:0x003e, B:13:0x0030, B:34:0x00cb, B:26:0x0094, B:44:0x00fe), top: B:92:0x000a, inners: #1, #3, #5 }] */
        /* JADX WARN: Code duplicated, block: B:76:0x01d0  */
        /* JADX WARN: Code duplicated, block: B:77:0x01d5  */
        /* JADX WARN: Code duplicated, block: B:80:0x01f1  */
        /* JADX WARN: Code duplicated, block: B:81:0x01f4  */
        /* JADX WARN: Code duplicated, block: B:84:0x021d A[Catch: Exception -> 0x0029, TryCatch #2 {Exception -> 0x0029, blocks: (B:7:0x001d, B:20:0x0058, B:22:0x0089, B:24:0x008e, B:30:0x00c3, B:38:0x00f1, B:41:0x00f8, B:51:0x0128, B:52:0x013b, B:54:0x0141, B:56:0x015b, B:58:0x0161, B:60:0x016d, B:65:0x017e, B:67:0x0184, B:68:0x019f, B:70:0x01a5, B:84:0x021d, B:73:0x01bf, B:78:0x01d9, B:82:0x01f6, B:86:0x0228, B:50:0x0113, B:49:0x010d, B:37:0x00e6, B:29:0x00b9, B:8:0x0023, B:16:0x003e, B:13:0x0030, B:34:0x00cb, B:26:0x0094, B:44:0x00fe), top: B:92:0x000a, inners: #1, #3, #5 }] */
        /* JADX WARN: Code duplicated, block: B:90:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:95:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:99:0x0181 A[SYNTHETIC] */
        public final Object invokeSuspend(Object $result) {
            Object lora;
            String lora2;
            StringBuilder sb;
            Object baseUrl;
            StringBuilder sb2;
            String json;
            Object obj;
            Map map;
            DeserializationStrategy deserializationStrategy;
            Object objDecodeFromString;
            List cats;
            Collection destination$iv$iv;
            Collection destination$iv$iv2;
            PlayFyCategoryData c;
            String t;
            String id;
            String str;
            String image;
            String str2;
            Map mapMapOf;
            PlayFyCategoryData it;
            boolean z;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        lora = PlayFyProviderManager.INSTANCE.getLora((Continuation) this);
                        if (lora == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        lora2 = (String) lora;
                        sb = new StringBuilder();
                        this.L$0 = lora2;
                        this.L$1 = sb;
                        this.label = 2;
                        baseUrl = PlayFyProviderManager.INSTANCE.getBaseUrl((Continuation) this);
                        if (baseUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sb2 = sb;
                        String url = sb2.append((String) baseUrl).append("/cc.json").toString();
                        System.out.println((Object) ("PlayFy: fetchProviders → " + url));
                        json = PlayFyProviderManager.INSTANCE.fetchAndDecrypt(url, lora2);
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlayFyCategoryData.class)));
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
                            } catch (SerializationException e) {
                                ArchComponentExtKt.logError(e);
                                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv.readValue(json, new TypeReference<List<? extends PlayFyCategoryData>>() { // from class: com.cncverse.PlayFyProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                });
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv2.readValue(json, new TypeReference<List<? extends PlayFyCategoryData>>() { // from class: com.cncverse.PlayFyProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv3.readValue(json, new TypeReference<List<? extends PlayFyCategoryData>>() { // from class: com.cncverse.PlayFyProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        cats = (List) objDecodeFromString;
                        List $this$filter$iv = cats;
                        destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            it = (PlayFyCategoryData) element$iv$iv;
                            if (Intrinsics.areEqual(it.getPublish(), "1") || it.getCatLink() == null || Intrinsics.areEqual(it.getCatLink(), "null") || StringsKt.isBlank(it.getCatLink())) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        Iterable $this$mapNotNull$iv = (List) destination$iv$iv;
                        destination$iv$iv2 = new ArrayList();
                        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                            c = (PlayFyCategoryData) element$iv$iv$iv;
                            t = c.getTitle();
                            if (t == null) {
                                cats = cats;
                                mapMapOf = map;
                            } else {
                                Pair[] pairArr = new Pair[5];
                                id = c.getId();
                                if (id == null) {
                                    str = "";
                                } else {
                                    str = id;
                                }
                                pairArr[0] = TuplesKt.to("id", str);
                                pairArr[1] = TuplesKt.to("title", t);
                                image = c.getImage();
                                if (image == null) {
                                    str2 = "";
                                } else {
                                    str2 = image;
                                }
                                pairArr[2] = TuplesKt.to("image", str2);
                                String catLink = c.getCatLink();
                                Intrinsics.checkNotNull(catLink);
                                pairArr[3] = TuplesKt.to("catLink", catLink);
                                pairArr[4] = TuplesKt.to("type", "m3u");
                                mapMapOf = MapsKt.mapOf(pairArr);
                            }
                            if (mapMapOf != null) {
                                destination$iv$iv2.add(mapMapOf);
                            }
                            map = null;
                            cats = cats;
                        }
                        return (List) destination$iv$iv2;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        lora = $result;
                        lora2 = (String) lora;
                        sb = new StringBuilder();
                        this.L$0 = lora2;
                        this.L$1 = sb;
                        this.label = 2;
                        baseUrl = PlayFyProviderManager.INSTANCE.getBaseUrl((Continuation) this);
                        if (baseUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sb2 = sb;
                        String url2 = sb2.append((String) baseUrl).append("/cc.json").toString();
                        System.out.println((Object) ("PlayFy: fetchProviders → " + url2));
                        json = PlayFyProviderManager.INSTANCE.fetchAndDecrypt(url2, lora2);
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils2 = AppUtils.INSTANCE;
                        Result.Companion companion5 = Result.Companion;
                        KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlayFyCategoryData.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                        map = null;
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
                            objDecodeFromString = $this$readValue$iv$iv4.readValue(json, new TypeReference<List<? extends PlayFyCategoryData>>() { // from class: com.cncverse.PlayFyProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        cats = (List) objDecodeFromString;
                        List $this$filter$iv2 = cats;
                        destination$iv$iv = new ArrayList();
                        while (r13.hasNext()) {
                            it = (PlayFyCategoryData) element$iv$iv;
                            if (Intrinsics.areEqual(it.getPublish(), "1")) {
                                z = false;
                            } else {
                                z = false;
                            }
                            if (z) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        Iterable $this$mapNotNull$iv2 = (List) destination$iv$iv;
                        destination$iv$iv2 = new ArrayList();
                        while (r13.hasNext()) {
                            c = (PlayFyCategoryData) element$iv$iv$iv;
                            t = c.getTitle();
                            if (t == null) {
                                cats = cats;
                                mapMapOf = map;
                            } else {
                                Pair[] pairArr2 = new Pair[5];
                                id = c.getId();
                                if (id == null) {
                                    str = "";
                                } else {
                                    str = id;
                                }
                                pairArr2[0] = TuplesKt.to("id", str);
                                pairArr2[1] = TuplesKt.to("title", t);
                                image = c.getImage();
                                if (image == null) {
                                    str2 = "";
                                } else {
                                    str2 = image;
                                }
                                pairArr2[2] = TuplesKt.to("image", str2);
                                String catLink2 = c.getCatLink();
                                Intrinsics.checkNotNull(catLink2);
                                pairArr2[3] = TuplesKt.to("catLink", catLink2);
                                pairArr2[4] = TuplesKt.to("type", "m3u");
                                mapMapOf = MapsKt.mapOf(pairArr2);
                            }
                            if (mapMapOf != null) {
                                destination$iv$iv2.add(mapMapOf);
                            }
                            map = null;
                            cats = cats;
                        }
                        return (List) destination$iv$iv2;
                    case 2:
                        sb2 = (StringBuilder) this.L$1;
                        lora2 = (String) this.L$0;
                        ResultKt.throwOnFailure($result);
                        baseUrl = $result;
                        String url3 = sb2.append((String) baseUrl).append("/cc.json").toString();
                        System.out.println((Object) ("PlayFy: fetchProviders → " + url3));
                        json = PlayFyProviderManager.INSTANCE.fetchAndDecrypt(url3, lora2);
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils3 = AppUtils.INSTANCE;
                        Result.Companion companion7 = Result.Companion;
                        KType kTypeTypeOf3 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlayFyCategoryData.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                        map = null;
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
                            objDecodeFromString = $this$readValue$iv$iv5.readValue(json, new TypeReference<List<? extends PlayFyCategoryData>>() { // from class: com.cncverse.PlayFyProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        cats = (List) objDecodeFromString;
                        List $this$filter$iv3 = cats;
                        destination$iv$iv = new ArrayList();
                        while (r13.hasNext()) {
                            it = (PlayFyCategoryData) element$iv$iv;
                            if (Intrinsics.areEqual(it.getPublish(), "1")) {
                                z = false;
                            } else {
                                z = false;
                            }
                            if (z) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        Iterable $this$mapNotNull$iv3 = (List) destination$iv$iv;
                        destination$iv$iv2 = new ArrayList();
                        while (r13.hasNext()) {
                            c = (PlayFyCategoryData) element$iv$iv$iv;
                            t = c.getTitle();
                            if (t == null) {
                                cats = cats;
                                mapMapOf = map;
                            } else {
                                Pair[] pairArr3 = new Pair[5];
                                id = c.getId();
                                if (id == null) {
                                    str = "";
                                } else {
                                    str = id;
                                }
                                pairArr3[0] = TuplesKt.to("id", str);
                                pairArr3[1] = TuplesKt.to("title", t);
                                image = c.getImage();
                                if (image == null) {
                                    str2 = "";
                                } else {
                                    str2 = image;
                                }
                                pairArr3[2] = TuplesKt.to("image", str2);
                                String catLink3 = c.getCatLink();
                                Intrinsics.checkNotNull(catLink3);
                                pairArr3[3] = TuplesKt.to("catLink", catLink3);
                                pairArr3[4] = TuplesKt.to("type", "m3u");
                                mapMapOf = MapsKt.mapOf(pairArr3);
                            }
                            if (mapMapOf != null) {
                                destination$iv$iv2.add(mapMapOf);
                            }
                            map = null;
                            cats = cats;
                        }
                        return (List) destination$iv$iv2;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e2) {
                System.out.println((Object) ("PlayFy: fetchProviders error: " + e2.getMessage()));
                return CollectionsKt.emptyList();
            }
        }
    }

    @Nullable
    public final Object fetchProviders(@NotNull Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00332(null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyProviderManager$fetchLiveEvents$2 */
    /* JADX INFO: compiled from: PlayFyProviderManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/cncverse/PlayFyChannel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyProviderManager$fetchLiveEvents$2", f = "PlayFyProviderManager.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00322 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PlayFyChannel>>, Object> {
        int label;

        C00322(Continuation<? super C00322> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00322(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<PlayFyChannel>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    Object objFetchChannelList = PlayFyProviderManager.INSTANCE.fetchChannelList("cats/live-events.json", (Continuation) this);
                    if (objFetchChannelList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objFetchChannelList;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Nullable
    public final Object fetchLiveEvents(@NotNull Continuation<? super List<PlayFyChannel>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00322(null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyProviderManager$fetchHighlights$2 */
    /* JADX INFO: compiled from: PlayFyProviderManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/cncverse/PlayFyChannel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyProviderManager$fetchHighlights$2", f = "PlayFyProviderManager.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00312 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PlayFyChannel>>, Object> {
        int label;

        C00312(Continuation<? super C00312> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00312(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<PlayFyChannel>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    Object objFetchChannelList = PlayFyProviderManager.INSTANCE.fetchChannelList("cats/highlights.json", (Continuation) this);
                    if (objFetchChannelList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objFetchChannelList;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Nullable
    public final Object fetchHighlights(@NotNull Continuation<? super List<PlayFyChannel>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00312(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x007f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0080  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b4 A[Catch: Exception -> 0x0055, TryCatch #6 {Exception -> 0x0055, blocks: (B:30:0x0081, B:32:0x00b4, B:34:0x00b9, B:40:0x00e2, B:48:0x0111, B:52:0x0119, B:61:0x0149, B:63:0x0151, B:64:0x0161, B:66:0x0167, B:68:0x0180, B:70:0x0188, B:71:0x0191, B:60:0x0134, B:59:0x012e, B:47:0x0106, B:39:0x00d8, B:18:0x0050, B:26:0x006a, B:44:0x00ea, B:36:0x00bf, B:54:0x011f), top: B:84:0x0050, inners: #1, #2, #7 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00b9 A[Catch: Exception -> 0x0055, TRY_LEAVE, TryCatch #6 {Exception -> 0x0055, blocks: (B:30:0x0081, B:32:0x00b4, B:34:0x00b9, B:40:0x00e2, B:48:0x0111, B:52:0x0119, B:61:0x0149, B:63:0x0151, B:64:0x0161, B:66:0x0167, B:68:0x0180, B:70:0x0188, B:71:0x0191, B:60:0x0134, B:59:0x012e, B:47:0x0106, B:39:0x00d8, B:18:0x0050, B:26:0x006a, B:44:0x00ea, B:36:0x00bf, B:54:0x011f), top: B:84:0x0050, inners: #1, #2, #7 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0117  */
    /* JADX WARN: Code duplicated, block: B:51:0x0118  */
    /* JADX WARN: Code duplicated, block: B:60:0x0134 A[Catch: Exception -> 0x0055, TryCatch #6 {Exception -> 0x0055, blocks: (B:30:0x0081, B:32:0x00b4, B:34:0x00b9, B:40:0x00e2, B:48:0x0111, B:52:0x0119, B:61:0x0149, B:63:0x0151, B:64:0x0161, B:66:0x0167, B:68:0x0180, B:70:0x0188, B:71:0x0191, B:60:0x0134, B:59:0x012e, B:47:0x0106, B:39:0x00d8, B:18:0x0050, B:26:0x006a, B:44:0x00ea, B:36:0x00bf, B:54:0x011f), top: B:84:0x0050, inners: #1, #2, #7 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0151 A[Catch: Exception -> 0x0055, TryCatch #6 {Exception -> 0x0055, blocks: (B:30:0x0081, B:32:0x00b4, B:34:0x00b9, B:40:0x00e2, B:48:0x0111, B:52:0x0119, B:61:0x0149, B:63:0x0151, B:64:0x0161, B:66:0x0167, B:68:0x0180, B:70:0x0188, B:71:0x0191, B:60:0x0134, B:59:0x012e, B:47:0x0106, B:39:0x00d8, B:18:0x0050, B:26:0x006a, B:44:0x00ea, B:36:0x00bf, B:54:0x011f), top: B:84:0x0050, inners: #1, #2, #7 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0167 A[Catch: Exception -> 0x0055, TryCatch #6 {Exception -> 0x0055, blocks: (B:30:0x0081, B:32:0x00b4, B:34:0x00b9, B:40:0x00e2, B:48:0x0111, B:52:0x0119, B:61:0x0149, B:63:0x0151, B:64:0x0161, B:66:0x0167, B:68:0x0180, B:70:0x0188, B:71:0x0191, B:60:0x0134, B:59:0x012e, B:47:0x0106, B:39:0x00d8, B:18:0x0050, B:26:0x006a, B:44:0x00ea, B:36:0x00bf, B:54:0x011f), top: B:84:0x0050, inners: #1, #2, #7 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0180 A[Catch: Exception -> 0x0055, TryCatch #6 {Exception -> 0x0055, blocks: (B:30:0x0081, B:32:0x00b4, B:34:0x00b9, B:40:0x00e2, B:48:0x0111, B:52:0x0119, B:61:0x0149, B:63:0x0151, B:64:0x0161, B:66:0x0167, B:68:0x0180, B:70:0x0188, B:71:0x0191, B:60:0x0134, B:59:0x012e, B:47:0x0106, B:39:0x00d8, B:18:0x0050, B:26:0x006a, B:44:0x00ea, B:36:0x00bf, B:54:0x011f), top: B:84:0x0050, inners: #1, #2, #7 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0191 A[Catch: Exception -> 0x0055, TRY_LEAVE, TryCatch #6 {Exception -> 0x0055, blocks: (B:30:0x0081, B:32:0x00b4, B:34:0x00b9, B:40:0x00e2, B:48:0x0111, B:52:0x0119, B:61:0x0149, B:63:0x0151, B:64:0x0161, B:66:0x0167, B:68:0x0180, B:70:0x0188, B:71:0x0191, B:60:0x0134, B:59:0x012e, B:47:0x0106, B:39:0x00d8, B:18:0x0050, B:26:0x006a, B:44:0x00ea, B:36:0x00bf, B:54:0x011f), top: B:84:0x0050, inners: #1, #2, #7 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:85:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0183 A[SYNTHETIC] */
    public final Object fetchChannelList(String path, Continuation<? super List<PlayFyChannel>> continuation) {
        C00281 c00281;
        String lora;
        Object lora2;
        String path2;
        StringBuilder sb;
        Object baseUrl;
        StringBuilder sb2;
        String json;
        Object obj;
        Object obj2;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        PlayFyChannelListResponse resp;
        Iterable channels;
        Iterable $this$filter$iv;
        Collection destination$iv$iv;
        PlayFyChannel it;
        if (continuation instanceof C00281) {
            c00281 = (C00281) continuation;
            if ((c00281.label & Integer.MIN_VALUE) != 0) {
                c00281.label -= Integer.MIN_VALUE;
            } else {
                c00281 = new C00281(continuation);
            }
        } else {
            c00281 = new C00281(continuation);
        }
        C00281 c00282 = c00281;
        Object $result = c00282.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00282.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                lora = path;
                try {
                    c00282.L$0 = lora;
                    c00282.label = 1;
                    lora2 = getLora(c00282);
                    if (lora2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    path2 = (String) lora2;
                    sb = new StringBuilder();
                    c00282.L$0 = lora;
                    c00282.L$1 = path2;
                    c00282.L$2 = sb;
                    c00282.label = 2;
                    baseUrl = getBaseUrl(c00282);
                    if (baseUrl == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sb2 = sb;
                    String url = sb2.append((String) baseUrl).append('/').append(lora).toString();
                    System.out.println((Object) ("PlayFy: fetchChannelList → " + url));
                    json = fetchAndDecrypt(url, path2);
                    if (json == null) {
                        return CollectionsKt.emptyList();
                    }
                    AppUtils appUtils = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(PlayFyChannelListResponse.class);
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
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlayFyChannelListResponse.class), (List) null, 2, (Object) null));
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
                            objDecodeFromString = $this$readValue$iv$iv.readValue(json, new TypeReference<PlayFyChannelListResponse>() { // from class: com.cncverse.PlayFyProviderManager$fetchChannelList$$inlined$parseJson$1
                            });
                        } catch (Throwable th3) {
                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv2.readValue(json, new TypeReference<PlayFyChannelListResponse>() { // from class: com.cncverse.PlayFyProviderManager$fetchChannelList$$inlined$parseJson$1
                            });
                        }
                        break;
                    } else {
                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv3.readValue(json, new TypeReference<PlayFyChannelListResponse>() { // from class: com.cncverse.PlayFyProviderManager$fetchChannelList$$inlined$parseJson$1
                        });
                    }
                    resp = (PlayFyChannelListResponse) objDecodeFromString;
                    channels = resp.getChannels();
                    if (channels == null) {
                        return CollectionsKt.emptyList();
                    }
                    $this$filter$iv = channels;
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        it = (PlayFyChannel) element$iv$iv;
                        PlayFyChannelListResponse resp2 = resp;
                        Iterable $this$filter$iv2 = $this$filter$iv;
                        if (Intrinsics.areEqual(it.getPublish(), "1")) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        resp = resp2;
                        $this$filter$iv = $this$filter$iv2;
                    }
                    return (List) destination$iv$iv;
                } catch (Exception e2) {
                    e = e2;
                    System.out.println((Object) ("PlayFy: fetchChannelList(" + lora + ") error: " + e.getMessage()));
                    return CollectionsKt.emptyList();
                }
            case 1:
                lora = (String) c00282.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    lora2 = $result;
                    path2 = (String) lora2;
                    sb = new StringBuilder();
                    c00282.L$0 = lora;
                    c00282.L$1 = path2;
                    c00282.L$2 = sb;
                    c00282.label = 2;
                    baseUrl = getBaseUrl(c00282);
                    if (baseUrl == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sb2 = sb;
                    String url2 = sb2.append((String) baseUrl).append('/').append(lora).toString();
                    System.out.println((Object) ("PlayFy: fetchChannelList → " + url2));
                    json = fetchAndDecrypt(url2, path2);
                    if (json == null) {
                        return CollectionsKt.emptyList();
                    }
                    AppUtils appUtils2 = AppUtils.INSTANCE;
                    Result.Companion companion5 = Result.Companion;
                    KType kTypeTypeOf2 = Reflection.typeOf(PlayFyChannelListResponse.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                    obj2 = null;
                    if (Result.exceptionOrNull-impl(obj) != null) {
                        Result.Companion companion6 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlayFyChannelListResponse.class), (List) null, 2, (Object) null));
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
                        objDecodeFromString = $this$readValue$iv$iv4.readValue(json, new TypeReference<PlayFyChannelListResponse>() { // from class: com.cncverse.PlayFyProviderManager$fetchChannelList$$inlined$parseJson$1
                        });
                    }
                    resp = (PlayFyChannelListResponse) objDecodeFromString;
                    channels = resp.getChannels();
                    if (channels == null) {
                        return CollectionsKt.emptyList();
                    }
                    $this$filter$iv = channels;
                    destination$iv$iv = new ArrayList();
                    while (r13.hasNext()) {
                        it = (PlayFyChannel) element$iv$iv;
                        PlayFyChannelListResponse resp3 = resp;
                        Iterable $this$filter$iv3 = $this$filter$iv;
                        if (Intrinsics.areEqual(it.getPublish(), "1")) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        resp = resp3;
                        $this$filter$iv = $this$filter$iv3;
                    }
                    return (List) destination$iv$iv;
                } catch (Exception e3) {
                    e = e3;
                    System.out.println((Object) ("PlayFy: fetchChannelList(" + lora + ") error: " + e.getMessage()));
                    return CollectionsKt.emptyList();
                }
            case 2:
                sb2 = (StringBuilder) c00282.L$2;
                String lora3 = (String) c00282.L$1;
                String path3 = (String) c00282.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    path2 = lora3;
                    lora = path3;
                    baseUrl = $result;
                    String url3 = sb2.append((String) baseUrl).append('/').append(lora).toString();
                    System.out.println((Object) ("PlayFy: fetchChannelList → " + url3));
                    json = fetchAndDecrypt(url3, path2);
                    if (json == null) {
                        return CollectionsKt.emptyList();
                    }
                    AppUtils appUtils3 = AppUtils.INSTANCE;
                    Result.Companion companion7 = Result.Companion;
                    KType kTypeTypeOf3 = Reflection.typeOf(PlayFyChannelListResponse.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                    obj2 = null;
                    if (Result.exceptionOrNull-impl(obj) != null) {
                        Result.Companion companion8 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlayFyChannelListResponse.class), (List) null, 2, (Object) null));
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
                        objDecodeFromString = $this$readValue$iv$iv5.readValue(json, new TypeReference<PlayFyChannelListResponse>() { // from class: com.cncverse.PlayFyProviderManager$fetchChannelList$$inlined$parseJson$1
                        });
                    }
                    resp = (PlayFyChannelListResponse) objDecodeFromString;
                    channels = resp.getChannels();
                    if (channels == null) {
                        return CollectionsKt.emptyList();
                    }
                    $this$filter$iv = channels;
                    destination$iv$iv = new ArrayList();
                    while (r13.hasNext()) {
                        it = (PlayFyChannel) element$iv$iv;
                        PlayFyChannelListResponse resp4 = resp;
                        Iterable $this$filter$iv4 = $this$filter$iv;
                        if (Intrinsics.areEqual(it.getPublish(), "1")) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        resp = resp4;
                        $this$filter$iv = $this$filter$iv4;
                    }
                    return (List) destination$iv$iv;
                } catch (Exception e4) {
                    e = e4;
                    lora = path3;
                    System.out.println((Object) ("PlayFy: fetchChannelList(" + lora + ") error: " + e.getMessage()));
                    return CollectionsKt.emptyList();
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyProviderManager$fetchChannelStreams$2 */
    /* JADX INFO: compiled from: PlayFyProviderManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/cncverse/PlayFyStreamEntry;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyProviderManager$fetchChannelStreams$2", f = "PlayFyProviderManager.kt", i = {1}, l = {192, 193}, m = "invokeSuspend", n = {"lora"}, nl = {193, 194}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nPlayFyProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayFyProviderManager.kt\ncom/cncverse/PlayFyProviderManager$fetchChannelStreams$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,203:1\n63#2:204\n64#2,15:206\n1#3:205\n50#4:221\n43#4:222\n*S KotlinDebug\n*F\n+ 1 PlayFyProviderManager.kt\ncom/cncverse/PlayFyProviderManager$fetchChannelStreams$2\n*L\n196#1:204\n196#1:206,15\n196#1:205\n196#1:221\n196#1:222\n*E\n"})
    static final class C00292 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PlayFyStreamEntry>>, Object> {
        final /* synthetic */ String $channelId;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00292(String str, Continuation<? super C00292> continuation) {
            super(2, continuation);
            this.$channelId = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00292(this.$channelId, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<PlayFyStreamEntry>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0052 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:19:0x0053  */
        /* JADX WARN: Code duplicated, block: B:22:0x0090 A[Catch: Exception -> 0x0024, TryCatch #2 {Exception -> 0x0024, blocks: (B:7:0x001a, B:20:0x0054, B:22:0x0090, B:24:0x0095, B:30:0x00c8, B:39:0x00f7, B:43:0x00ff, B:52:0x012f, B:51:0x011a, B:50:0x0114, B:37:0x00eb, B:29:0x00be, B:8:0x001f, B:16:0x003a, B:13:0x002b, B:34:0x00d0, B:26:0x0099, B:45:0x0105), top: B:58:0x0007, inners: #1, #3, #5 }] */
        /* JADX WARN: Code duplicated, block: B:24:0x0095 A[Catch: Exception -> 0x0024, TRY_LEAVE, TryCatch #2 {Exception -> 0x0024, blocks: (B:7:0x001a, B:20:0x0054, B:22:0x0090, B:24:0x0095, B:30:0x00c8, B:39:0x00f7, B:43:0x00ff, B:52:0x012f, B:51:0x011a, B:50:0x0114, B:37:0x00eb, B:29:0x00be, B:8:0x001f, B:16:0x003a, B:13:0x002b, B:34:0x00d0, B:26:0x0099, B:45:0x0105), top: B:58:0x0007, inners: #1, #3, #5 }] */
        /* JADX WARN: Code duplicated, block: B:41:0x00fd  */
        /* JADX WARN: Code duplicated, block: B:42:0x00fe  */
        /* JADX WARN: Code duplicated, block: B:51:0x011a A[Catch: Exception -> 0x0024, TryCatch #2 {Exception -> 0x0024, blocks: (B:7:0x001a, B:20:0x0054, B:22:0x0090, B:24:0x0095, B:30:0x00c8, B:39:0x00f7, B:43:0x00ff, B:52:0x012f, B:51:0x011a, B:50:0x0114, B:37:0x00eb, B:29:0x00be, B:8:0x001f, B:16:0x003a, B:13:0x002b, B:34:0x00d0, B:26:0x0099, B:45:0x0105), top: B:58:0x0007, inners: #1, #3, #5 }] */
        /* JADX WARN: Code duplicated, block: B:56:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:61:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        public final Object invokeSuspend(Object $result) {
            Object lora;
            String lora2;
            StringBuilder sb;
            Object baseUrl;
            StringBuilder sb2;
            String json;
            Object obj;
            Object obj2;
            Object obj3;
            DeserializationStrategy deserializationStrategy;
            Object objDecodeFromString;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        lora = PlayFyProviderManager.INSTANCE.getLora((Continuation) this);
                        if (lora == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        lora2 = (String) lora;
                        sb = new StringBuilder();
                        this.L$0 = lora2;
                        this.L$1 = sb;
                        this.label = 2;
                        baseUrl = PlayFyProviderManager.INSTANCE.getBaseUrl((Continuation) this);
                        if (baseUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sb2 = sb;
                        String url = sb2.append((String) baseUrl).append("/channels/").append(this.$channelId).append(".json").toString();
                        System.out.println((Object) ("PlayFy: fetchChannelStreams → " + url));
                        json = PlayFyProviderManager.INSTANCE.fetchAndDecrypt(url, lora2);
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlayFyStreamEntry.class)));
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
                                obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            } catch (Throwable th2) {
                                Result.Companion companion4 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th2));
                            }
                            obj = obj3;
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
                                objDecodeFromString = $this$readValue$iv$iv.readValue(json, new TypeReference<List<? extends PlayFyStreamEntry>>() { // from class: com.cncverse.PlayFyProviderManager$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$1
                                });
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv2.readValue(json, new TypeReference<List<? extends PlayFyStreamEntry>>() { // from class: com.cncverse.PlayFyProviderManager$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv3.readValue(json, new TypeReference<List<? extends PlayFyStreamEntry>>() { // from class: com.cncverse.PlayFyProviderManager$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        return (List) objDecodeFromString;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        lora = $result;
                        lora2 = (String) lora;
                        sb = new StringBuilder();
                        this.L$0 = lora2;
                        this.L$1 = sb;
                        this.label = 2;
                        baseUrl = PlayFyProviderManager.INSTANCE.getBaseUrl((Continuation) this);
                        if (baseUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sb2 = sb;
                        String url2 = sb2.append((String) baseUrl).append("/channels/").append(this.$channelId).append(".json").toString();
                        System.out.println((Object) ("PlayFy: fetchChannelStreams → " + url2));
                        json = PlayFyProviderManager.INSTANCE.fetchAndDecrypt(url2, lora2);
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils2 = AppUtils.INSTANCE;
                        Result.Companion companion5 = Result.Companion;
                        KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlayFyStreamEntry.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                        obj2 = null;
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion6 = Result.Companion;
                            obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            obj = obj3;
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
                            objDecodeFromString = $this$readValue$iv$iv4.readValue(json, new TypeReference<List<? extends PlayFyStreamEntry>>() { // from class: com.cncverse.PlayFyProviderManager$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        return (List) objDecodeFromString;
                    case 2:
                        sb2 = (StringBuilder) this.L$1;
                        lora2 = (String) this.L$0;
                        ResultKt.throwOnFailure($result);
                        baseUrl = $result;
                        String url3 = sb2.append((String) baseUrl).append("/channels/").append(this.$channelId).append(".json").toString();
                        System.out.println((Object) ("PlayFy: fetchChannelStreams → " + url3));
                        json = PlayFyProviderManager.INSTANCE.fetchAndDecrypt(url3, lora2);
                        if (json == null) {
                            return CollectionsKt.emptyList();
                        }
                        AppUtils appUtils3 = AppUtils.INSTANCE;
                        Result.Companion companion7 = Result.Companion;
                        KType kTypeTypeOf3 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlayFyStreamEntry.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                        obj2 = null;
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion8 = Result.Companion;
                            obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            obj = obj3;
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
                            objDecodeFromString = $this$readValue$iv$iv5.readValue(json, new TypeReference<List<? extends PlayFyStreamEntry>>() { // from class: com.cncverse.PlayFyProviderManager$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        return (List) objDecodeFromString;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e2) {
                System.out.println((Object) ("PlayFy: fetchChannelStreams(" + this.$channelId + ") error: " + e2.getMessage()));
                return CollectionsKt.emptyList();
            }
        }
    }

    @Nullable
    public final Object fetchChannelStreams(@NotNull String channelId, @NotNull Continuation<? super List<PlayFyStreamEntry>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00292(channelId, null), continuation);
    }
}
