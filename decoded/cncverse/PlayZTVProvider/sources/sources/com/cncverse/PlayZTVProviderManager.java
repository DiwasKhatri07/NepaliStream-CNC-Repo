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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
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

/* JADX INFO: compiled from: PlayZTVProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/PlayZTVProvider/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\r\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0011J \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00130\u0005H\u0086@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005H\u0086@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00052\u0006\u0010\u0017\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/cncverse/PlayZTVProviderManager;", "", "<init>", "()V", "DEFAULT_BASE_URLS", "", "", "cachedBaseUrl", "client", "Lokhttp3/OkHttpClient;", "parseDateTime", "date", "time", "getBaseUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchDecrypted", "path", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchProviders", "", "fetchLiveEvents", "Lcom/cncverse/PlayZLiveEventData;", "fetchCustomEvents", "catLink", "fetchChannelStreams", "Lcom/cncverse/PlayZStreamUrl;", "slug", "PlayZTVProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlayZTVProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayZTVProviderManager.kt\ncom/cncverse/PlayZTVProviderManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,427:1\n1#2:428\n*E\n"})
public final class PlayZTVProviderManager {

    @Nullable
    private static String cachedBaseUrl;

    @NotNull
    public static final PlayZTVProviderManager INSTANCE = new PlayZTVProviderManager();

    @NotNull
    private static final List<String> DEFAULT_BASE_URLS = CollectionsKt.listOf(new String[]{"https://tourniquest.site", "https://adsflw.xyz", "https://playztv2828.store"});

    @NotNull
    private static final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();

    /* JADX INFO: renamed from: com.cncverse.PlayZTVProviderManager$getBaseUrl$1 */
    /* JADX INFO: compiled from: PlayZTVProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTVProviderManager", f = "PlayZTVProviderManager.kt", i = {}, l = {134}, m = "getBaseUrl", n = {}, nl = {135}, s = {}, v = 2)
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
            return PlayZTVProviderManager.this.getBaseUrl((Continuation) this);
        }
    }

    private PlayZTVProviderManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String parseDateTime(String date, String time) {
        if (date == null || time == null) {
            return null;
        }
        try {
            List parts = StringsKt.split$default(date, new String[]{"/"}, false, 0, 6, (Object) null);
            if (parts.size() != 3) {
                return null;
            }
            String day = (String) parts.get(0);
            String month = (String) parts.get(1);
            String year = (String) parts.get(2);
            return year + '/' + month + '/' + day + ' ' + time + " +0000";
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getBaseUrl(Continuation<? super String> continuation) {
        C00351 c00351;
        Object baseApiUrl;
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
                PlayZTVFirebaseFetcher playZTVFirebaseFetcher = PlayZTVFirebaseFetcher.INSTANCE;
                c00351.label = 1;
                baseApiUrl = playZTVFirebaseFetcher.getBaseApiUrl(c00351);
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
        if (str != null && !StringsKt.isBlank(str)) {
            z = false;
        }
        if (!z) {
            cachedBaseUrl = firebaseUrl;
            return firebaseUrl;
        }
        for (String url : DEFAULT_BASE_URLS) {
            try {
                Request req = new Request.Builder().url(url + "/categories.txt").header("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 10; SM-A505F)").head().build();
                Response resp = client.newCall(req).execute();
                if (resp.code() < 500) {
                    cachedBaseUrl = url;
                    return url;
                }
                continue;
            } catch (Exception e) {
            }
        }
        cachedBaseUrl = (String) CollectionsKt.first(DEFAULT_BASE_URLS);
        String str2 = cachedBaseUrl;
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    /* JADX INFO: renamed from: com.cncverse.PlayZTVProviderManager$fetchDecrypted$2 */
    /* JADX INFO: compiled from: PlayZTVProviderManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTVProviderManager$fetchDecrypted$2", f = "PlayZTVProviderManager.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, nl = {162}, s = {}, v = 2)
    static final class C00262 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $path;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00262(String str, Continuation<? super C00262> continuation) {
            super(2, continuation);
            this.$path = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00262(this.$path, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object baseUrl;
            String url;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    baseUrl = PlayZTVProviderManager.INSTANCE.getBaseUrl((Continuation) this);
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
            String baseUrl2 = (String) baseUrl;
            String safePath = StringsKt.removePrefix(this.$path, "/");
            if (StringsKt.startsWith(safePath, "http://", true) || StringsKt.startsWith(safePath, "https://", true)) {
                url = safePath;
            } else {
                url = baseUrl2 + '/' + safePath;
            }
            String strDecryptPlayZTV = null;
            try {
                Request request = new Request.Builder().url(url).header("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 10; SM-A505F)").build();
                Response response = PlayZTVProviderManager.client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String body = response.body().string();
                    if (!StringsKt.isBlank(body)) {
                        strDecryptPlayZTV = PlayZTVCryptoUtils.INSTANCE.decryptPlayZTV(StringsKt.trim(body).toString());
                    }
                } else {
                    System.out.println((Object) ("PlayZTV: HTTP " + response.code() + " fetching " + url));
                }
            } catch (Exception e) {
                System.out.println((Object) ("PlayZTV: Exception fetching " + url + " – " + e.getMessage()));
            }
            return strDecryptPlayZTV;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchDecrypted(String path, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00262(path, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.PlayZTVProviderManager$fetchProviders$2 */
    /* JADX INFO: compiled from: PlayZTVProviderManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTVProviderManager$fetchProviders$2", f = "PlayZTVProviderManager.kt", i = {0, 0, 1, 1, 1, 1}, l = {198, 201}, m = "invokeSuspend", n = {"providers", "providerId", "providers", "providerId", "decrypted", "wrappers"}, nl = {199, 288}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    @SourceDebugExtension({"SMAP\nPlayZTVProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayZTVProviderManager.kt\ncom/cncverse/PlayZTVProviderManager$fetchProviders$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,427:1\n63#2:428\n64#2,15:430\n1#3:429\n50#4:445\n43#4:446\n1915#5,2:447\n*S KotlinDebug\n*F\n+ 1 PlayZTVProviderManager.kt\ncom/cncverse/PlayZTVProviderManager$fetchProviders$2\n*L\n200#1:428\n200#1:430,15\n200#1:429\n200#1:445\n200#1:446\n288#1:447,2\n*E\n"})
    static final class C00302 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        C00302(Continuation<? super C00302> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00302(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x0084 A[Catch: Exception -> 0x0040, TRY_LEAVE, TryCatch #1 {Exception -> 0x0040, blocks: (B:59:0x0144, B:60:0x0154, B:62:0x015a, B:12:0x003a, B:21:0x0072, B:23:0x007a, B:28:0x0084, B:34:0x00b8, B:42:0x00e7, B:45:0x00ee, B:55:0x011e, B:54:0x0109, B:53:0x0103, B:41:0x00dc, B:33:0x00ae, B:38:0x00c1, B:30:0x0089, B:48:0x00f4), top: B:71:0x003a, inners: #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:44:0x00ed  */
        /* JADX WARN: Code duplicated, block: B:54:0x0109 A[Catch: Exception -> 0x0040, TryCatch #1 {Exception -> 0x0040, blocks: (B:59:0x0144, B:60:0x0154, B:62:0x015a, B:12:0x003a, B:21:0x0072, B:23:0x007a, B:28:0x0084, B:34:0x00b8, B:42:0x00e7, B:45:0x00ee, B:55:0x011e, B:54:0x0109, B:53:0x0103, B:41:0x00dc, B:33:0x00ae, B:38:0x00c1, B:30:0x0089, B:48:0x00f4), top: B:71:0x003a, inners: #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:57:0x0142 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:58:0x0143  */
        /* JADX WARN: Code duplicated, block: B:62:0x015a A[Catch: Exception -> 0x0040, LOOP:0: B:60:0x0154->B:62:0x015a, LOOP_END, TRY_LEAVE, TryCatch #1 {Exception -> 0x0040, blocks: (B:59:0x0144, B:60:0x0154, B:62:0x015a, B:12:0x003a, B:21:0x0072, B:23:0x007a, B:28:0x0084, B:34:0x00b8, B:42:0x00e7, B:45:0x00ee, B:55:0x011e, B:54:0x0109, B:53:0x0103, B:41:0x00dc, B:33:0x00ae, B:38:0x00c1, B:30:0x0089, B:48:0x00f4), top: B:71:0x003a, inners: #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:77:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:81:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        public final Object invokeSuspend(Object $result) {
            ArrayList providers;
            Ref.IntRef providerId;
            Object objFetchDecrypted;
            List providers2;
            Ref.IntRef providerId2;
            String decrypted;
            String str;
            Object obj;
            DeserializationStrategy deserializationStrategy;
            Object objDecodeFromString;
            Object objCoroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean z = true;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    providers = new ArrayList();
                    Ref.IntRef providerId3 = new Ref.IntRef();
                    providerId3.element = 1;
                    try {
                        this.L$0 = providers;
                        this.L$1 = providerId3;
                        this.label = 1;
                        objFetchDecrypted = PlayZTVProviderManager.INSTANCE.fetchDecrypted("categories.txt", (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        providers2 = providers;
                        providerId2 = providerId3;
                        decrypted = (String) objFetchDecrypted;
                        str = decrypted;
                        if (str != null && !StringsKt.isBlank(str)) {
                            z = false;
                        }
                        if (!z) {
                            AppUtils appUtils = AppUtils.INSTANCE;
                            try {
                                Result.Companion companion = Result.Companion;
                                KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlayZTVCategoryWrapper.class)));
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
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decrypted);
                                } catch (SerializationException e) {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv.readValue(decrypted, new TypeReference<List<? extends PlayZTVCategoryWrapper>>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                } catch (Throwable th3) {
                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv2.readValue(decrypted, new TypeReference<List<? extends PlayZTVCategoryWrapper>>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                }
                                List wrappers = (List) objDecodeFromString;
                                this.L$0 = providers2;
                                this.L$1 = providerId2;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(decrypted);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(wrappers);
                                this.label = 2;
                                objCoroutineScope = CoroutineScopeKt.coroutineScope(new PlayZTVProviderManager$fetchProviders$2$results$1(wrappers, null), (Continuation) this);
                                if (objCoroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                break;
                            } else {
                                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv3.readValue(decrypted, new TypeReference<List<? extends PlayZTVCategoryWrapper>>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                });
                                List wrappers2 = (List) objDecodeFromString;
                                this.L$0 = providers2;
                                this.L$1 = providerId2;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(decrypted);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(wrappers2);
                                this.label = 2;
                                objCoroutineScope = CoroutineScopeKt.coroutineScope(new PlayZTVProviderManager$fetchProviders$2$results$1(wrappers2, null), (Continuation) this);
                                if (objCoroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            List results = (List) objCoroutineScope;
                            Iterable $this$forEach$iv = CollectionsKt.flatten(results);
                            for (Object element$iv : $this$forEach$iv) {
                                Map item = (Map) element$iv;
                                int i = providerId2.element;
                                providerId2.element = i + 1;
                                providers2.add(MapsKt.plus(item, TuplesKt.to("id", Boxing.boxInt(i))));
                                break;
                            }
                            return providers2;
                        }
                        return CollectionsKt.emptyList();
                    } catch (Exception e2) {
                        e = e2;
                        providerId = providerId3;
                        System.out.println((Object) ("PlayZTV: fetchProviders exception – " + e.getMessage()));
                    }
                    break;
                case 1:
                    providerId2 = (Ref.IntRef) this.L$1;
                    providers2 = (List) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        objFetchDecrypted = $result;
                        decrypted = (String) objFetchDecrypted;
                        str = decrypted;
                        if (str != null) {
                            z = false;
                        }
                        if (!z) {
                            AppUtils appUtils2 = AppUtils.INSTANCE;
                            Result.Companion companion5 = Result.Companion;
                            KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlayZTVCategoryWrapper.class)));
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
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decrypted);
                                List wrappers3 = (List) objDecodeFromString;
                                this.L$0 = providers2;
                                this.L$1 = providerId2;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(decrypted);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(wrappers3);
                                this.label = 2;
                                objCoroutineScope = CoroutineScopeKt.coroutineScope(new PlayZTVProviderManager$fetchProviders$2$results$1(wrappers3, null), (Continuation) this);
                                if (objCoroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv4.readValue(decrypted, new TypeReference<List<? extends PlayZTVCategoryWrapper>>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                });
                                List wrappers4 = (List) objDecodeFromString;
                                this.L$0 = providers2;
                                this.L$1 = providerId2;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(decrypted);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(wrappers4);
                                this.label = 2;
                                objCoroutineScope = CoroutineScopeKt.coroutineScope(new PlayZTVProviderManager$fetchProviders$2$results$1(wrappers4, null), (Continuation) this);
                                if (objCoroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            List results2 = (List) objCoroutineScope;
                            Iterable $this$forEach$iv2 = CollectionsKt.flatten(results2);
                            while (r8.hasNext()) {
                                Map item2 = (Map) element$iv;
                                int i2 = providerId2.element;
                                providerId2.element = i2 + 1;
                                providers2.add(MapsKt.plus(item2, TuplesKt.to("id", Boxing.boxInt(i2))));
                                break;
                            }
                            return providers2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        providerId = providerId2;
                        providers = providers2;
                        System.out.println((Object) ("PlayZTV: fetchProviders exception – " + e.getMessage()));
                    }
                    return CollectionsKt.emptyList();
                case 2:
                    providerId = (Ref.IntRef) this.L$1;
                    providers = (List) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        providers2 = providers;
                        providerId2 = providerId;
                        objCoroutineScope = $result;
                        List results3 = (List) objCoroutineScope;
                        Iterable $this$forEach$iv3 = CollectionsKt.flatten(results3);
                        while (r8.hasNext()) {
                            Map item3 = (Map) element$iv;
                            int i3 = providerId2.element;
                            providerId2.element = i3 + 1;
                            providers2.add(MapsKt.plus(item3, TuplesKt.to("id", Boxing.boxInt(i3))));
                            break;
                        }
                        return providers2;
                    } catch (Exception e4) {
                        e = e4;
                        System.out.println((Object) ("PlayZTV: fetchProviders exception – " + e.getMessage()));
                        return CollectionsKt.emptyList();
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Nullable
    public final Object fetchProviders(@NotNull Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00302(null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.PlayZTVProviderManager$fetchLiveEvents$2 */
    /* JADX INFO: compiled from: PlayZTVProviderManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/cncverse/PlayZLiveEventData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTVProviderManager$fetchLiveEvents$2", f = "PlayZTVProviderManager.kt", i = {}, l = {304}, m = "invokeSuspend", n = {}, nl = {305}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nPlayZTVProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayZTVProviderManager.kt\ncom/cncverse/PlayZTVProviderManager$fetchLiveEvents$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,427:1\n63#2:428\n64#2,15:430\n63#2:451\n64#2,15:453\n1#3:429\n1#3:452\n1#3:474\n50#4:445\n43#4:446\n50#4:468\n43#4:469\n1606#5:447\n1617#5:448\n1924#5,2:449\n1586#5:470\n1661#5,3:471\n1926#5:475\n1618#5:476\n777#5:477\n873#5,2:478\n*S KotlinDebug\n*F\n+ 1 PlayZTVProviderManager.kt\ncom/cncverse/PlayZTVProviderManager$fetchLiveEvents$2\n*L\n306#1:428\n306#1:430,15\n309#1:451\n309#1:453,15\n306#1:429\n309#1:452\n307#1:474\n306#1:445\n306#1:446\n309#1:468\n309#1:469\n307#1:447\n307#1:448\n307#1:449,2\n330#1:470\n330#1:471,3\n307#1:475\n307#1:476\n339#1:477\n339#1:478,2\n*E\n"})
    static final class C00272 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PlayZLiveEventData>>, Object> {
        int label;

        C00272(Continuation<? super C00272> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00272(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<PlayZLiveEventData>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:112:0x024b  */
        /* JADX WARN: Code duplicated, block: B:113:0x024e  */
        /* JADX WARN: Code duplicated, block: B:116:0x0256 A[Catch: Exception -> 0x02b7, TryCatch #3 {Exception -> 0x02b7, blocks: (B:75:0x017e, B:78:0x0185, B:96:0x01c6, B:99:0x01d3, B:103:0x01e3, B:110:0x01f3, B:114:0x0250, B:116:0x0256, B:117:0x026d, B:119:0x0273, B:95:0x01ad, B:93:0x01a4, B:74:0x0174), top: B:152:0x017e }] */
        /* JADX WARN: Code duplicated, block: B:119:0x0273 A[Catch: Exception -> 0x02b7, TRY_LEAVE, TryCatch #3 {Exception -> 0x02b7, blocks: (B:75:0x017e, B:78:0x0185, B:96:0x01c6, B:99:0x01d3, B:103:0x01e3, B:110:0x01f3, B:114:0x0250, B:116:0x0256, B:117:0x026d, B:119:0x0273, B:95:0x01ad, B:93:0x01a4, B:74:0x0174), top: B:152:0x017e }] */
        /* JADX WARN: Code duplicated, block: B:123:0x02a3 A[Catch: Exception -> 0x02b5, TryCatch #4 {Exception -> 0x02b5, blocks: (B:121:0x028b, B:122:0x0298, B:124:0x02ad, B:123:0x02a3), top: B:154:0x028b }] */
        /* JADX WARN: Code duplicated, block: B:135:0x02ed A[Catch: Exception -> 0x001c, TryCatch #8 {Exception -> 0x001c, blocks: (B:6:0x0016, B:14:0x0033, B:16:0x003a, B:22:0x0046, B:28:0x0078, B:36:0x00a7, B:39:0x00ae, B:49:0x00de, B:50:0x00f7, B:52:0x00fd, B:54:0x0105, B:55:0x0108, B:132:0x02c0, B:135:0x02ed, B:137:0x02fe, B:138:0x0317, B:140:0x031d, B:145:0x0331, B:147:0x0337, B:48:0x00c9, B:47:0x00c3, B:35:0x009c, B:27:0x006e, B:11:0x0023, B:24:0x004b, B:32:0x0081, B:42:0x00b4), top: B:162:0x000b, inners: #5, #11, #15 }] */
        /* JADX WARN: Code duplicated, block: B:178:0x02f3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:98:0x01d1  */
        /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
        public final Object invokeSuspend(Object $result) {
            Object objFetchDecrypted;
            Object obj;
            Object objDecodeFromString;
            String str;
            PlayZLiveEventData playZLiveEventData;
            Object obj2;
            boolean z;
            String value$iv;
            Object objDecodeFromString2;
            PlayZTVEventData ev;
            String eventName;
            String links;
            int i;
            Iterable link_names;
            List listEmptyList;
            Collection destination$iv$iv;
            String str2 = "kotlinx.serialization.serializer.simple";
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        objFetchDecrypted = PlayZTVProviderManager.INSTANCE.fetchDecrypted("events.txt", (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        objFetchDecrypted = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String decrypted = (String) objFetchDecrypted;
                String str3 = decrypted;
                if (!(str3 == null || StringsKt.isBlank(str3))) {
                    AppUtils appUtils = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlayZTVEventWrapper.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    int i2 = 2;
                    List list = null;
                    if (Result.exceptionOrNull-impl(obj) != null) {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                        } catch (Throwable th2) {
                            Result.Companion companion4 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th2));
                        }
                    }
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                    if (deserializationStrategy != null) {
                        try {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decrypted);
                        } catch (SerializationException e) {
                            ArchComponentExtKt.logError(e);
                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv.readValue(decrypted, new TypeReference<List<? extends PlayZTVEventWrapper>>() { // from class: com.cncverse.PlayZTVProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                            });
                        } catch (Throwable th3) {
                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv2.readValue(decrypted, new TypeReference<List<? extends PlayZTVEventWrapper>>() { // from class: com.cncverse.PlayZTVProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv3.readValue(decrypted, new TypeReference<List<? extends PlayZTVEventWrapper>>() { // from class: com.cncverse.PlayZTVProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                        });
                    }
                    Iterable wrappers = (List) objDecodeFromString;
                    Iterable $this$mapIndexedNotNull$iv = wrappers;
                    Collection destination$iv$iv2 = new ArrayList();
                    int index$iv$iv$iv = 0;
                    for (Object item$iv$iv$iv : $this$mapIndexedNotNull$iv) {
                        int index$iv$iv$iv2 = index$iv$iv$iv + 1;
                        if (index$iv$iv$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        int index$iv$iv = index$iv$iv$iv;
                        PlayZTVEventWrapper wrapper = (PlayZTVEventWrapper) item$iv$iv$iv;
                        try {
                            AppUtils appUtils2 = AppUtils.INSTANCE;
                            String value$iv2 = wrapper.getEvent();
                            try {
                                Result.Companion companion5 = Result.Companion;
                                KType kTypeTypeOf2 = Reflection.typeOf(PlayZTVEventData.class);
                                MagicApiIntrinsics.voidMagicApiCall(str2);
                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                            } catch (Throwable th4) {
                                Result.Companion companion6 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th4));
                            }
                            if (Result.exceptionOrNull-impl(obj2) == null) {
                                z = true;
                            } else {
                                try {
                                    Result.Companion companion7 = Result.Companion;
                                    z = true;
                                    try {
                                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlayZTVEventData.class), list, i2, list));
                                    } catch (Throwable th5) {
                                        th = th5;
                                        Result.Companion companion8 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    z = true;
                                }
                            }
                            try {
                                if (Result.isFailure-impl(obj2)) {
                                    obj2 = list;
                                }
                                DeserializationStrategy deserializationStrategy2 = (KSerializer) obj2;
                                if (deserializationStrategy2 != null) {
                                    try {
                                        value$iv = value$iv2;
                                        try {
                                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv);
                                        } catch (SerializationException e2) {
                                            e$iv = e2;
                                            ArchComponentExtKt.logError((Throwable) e$iv);
                                            ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                            String content$iv$iv = value$iv;
                                            objDecodeFromString2 = $this$readValue$iv$iv4.readValue(content$iv$iv, new TypeReference<PlayZTVEventData>() { // from class: com.cncverse.PlayZTVProviderManager$fetchLiveEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                            });
                                        } catch (Throwable th7) {
                                            ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                            String content$iv$iv2 = value$iv;
                                            objDecodeFromString2 = $this$readValue$iv$iv5.readValue(content$iv$iv2, new TypeReference<PlayZTVEventData>() { // from class: com.cncverse.PlayZTVProviderManager$fetchLiveEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                            });
                                        }
                                    } catch (SerializationException e3) {
                                        e$iv = e3;
                                        value$iv = value$iv2;
                                    } catch (Throwable th8) {
                                        value$iv = value$iv2;
                                    }
                                    ev = (PlayZTVEventData) objDecodeFromString2;
                                    int i3 = index$iv$iv + 1;
                                    eventName = ev.getEventName();
                                    if (eventName == null) {
                                        eventName = "Unknown Event";
                                    }
                                    String str4 = eventName;
                                    String eventLogo = ev.getEventLogo();
                                    links = ev.getLinks();
                                    if (links != null || (strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(links, ".", (String) null, 2, (Object) null)) == null) {
                                        String strSubstringBeforeLast$default = "";
                                    }
                                    String str5 = strSubstringBeforeLast$default;
                                    String category = ev.getCategory();
                                    PlayZLiveEventInfo playZLiveEventInfo = new PlayZLiveEventInfo(ev.getTeamAName(), ev.getTeamBName(), ev.getTeamAFlag(), ev.getTeamBFlag(), ev.getCategory(), ev.getEventName(), ev.getEventLogo(), null, ev.getCategory(), PlayZTVProviderManager.INSTANCE.parseDateTime(ev.getDate(), ev.getTime()), PlayZTVProviderManager.INSTANCE.parseDateTime(ev.getEnd_date(), ev.getEnd_time()));
                                    if (Intrinsics.areEqual(ev.getVisible(), Boxing.boxBoolean(z))) {
                                        i = 1;
                                    } else {
                                        i = 0;
                                    }
                                    link_names = ev.getLink_names();
                                    if (link_names != null) {
                                        Iterable $this$map$iv = link_names;
                                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                        for (Object item$iv$iv : $this$map$iv) {
                                            String name = (String) item$iv$iv;
                                            PlayZTVEventData ev2 = ev;
                                            str = str2;
                                            try {
                                                destination$iv$iv.add(new PlayZLiveEventFormat(name, ev2.getLinks()));
                                                ev = ev2;
                                                str2 = str;
                                            } catch (Exception e4) {
                                                e = e4;
                                                System.out.println((Object) ("PlayZTV: Failed to parse event at " + index$iv$iv + " – " + e.getMessage()));
                                                playZLiveEventData = null;
                                                if (playZLiveEventData != null) {
                                                    destination$iv$iv2.add(playZLiveEventData);
                                                }
                                                index$iv$iv$iv = index$iv$iv$iv2;
                                                str2 = str;
                                                i2 = 2;
                                                list = null;
                                            }
                                        }
                                        str = str2;
                                        listEmptyList = (List) destination$iv$iv;
                                    } else {
                                        str = str2;
                                        listEmptyList = CollectionsKt.emptyList();
                                    }
                                    playZLiveEventData = new PlayZLiveEventData(i3, str4, eventLogo, str5, category, playZLiveEventInfo, i, listEmptyList);
                                    if (playZLiveEventData != null) {
                                        destination$iv$iv2.add(playZLiveEventData);
                                    }
                                    index$iv$iv$iv = index$iv$iv$iv2;
                                    str2 = str;
                                    i2 = 2;
                                    list = null;
                                } else {
                                    value$iv = value$iv2;
                                }
                                ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                String content$iv$iv3 = value$iv;
                                objDecodeFromString2 = $this$readValue$iv$iv6.readValue(content$iv$iv3, new TypeReference<PlayZTVEventData>() { // from class: com.cncverse.PlayZTVProviderManager$fetchLiveEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                });
                                ev = (PlayZTVEventData) objDecodeFromString2;
                                int i4 = index$iv$iv + 1;
                                eventName = ev.getEventName();
                                if (eventName == null) {
                                    eventName = "Unknown Event";
                                }
                                String str6 = eventName;
                                String eventLogo2 = ev.getEventLogo();
                                links = ev.getLinks();
                                if (links != null) {
                                }
                                String strSubstringBeforeLast$default2 = "";
                                String str7 = strSubstringBeforeLast$default2;
                                String category2 = ev.getCategory();
                                PlayZLiveEventInfo playZLiveEventInfo2 = new PlayZLiveEventInfo(ev.getTeamAName(), ev.getTeamBName(), ev.getTeamAFlag(), ev.getTeamBFlag(), ev.getCategory(), ev.getEventName(), ev.getEventLogo(), null, ev.getCategory(), PlayZTVProviderManager.INSTANCE.parseDateTime(ev.getDate(), ev.getTime()), PlayZTVProviderManager.INSTANCE.parseDateTime(ev.getEnd_date(), ev.getEnd_time()));
                                if (Intrinsics.areEqual(ev.getVisible(), Boxing.boxBoolean(z))) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                link_names = ev.getLink_names();
                                if (link_names != null) {
                                    Iterable $this$map$iv2 = link_names;
                                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                                    while (r26.hasNext()) {
                                        String name2 = (String) item$iv$iv;
                                        PlayZTVEventData ev3 = ev;
                                        str = str2;
                                        destination$iv$iv.add(new PlayZLiveEventFormat(name2, ev3.getLinks()));
                                        ev = ev3;
                                        str2 = str;
                                    }
                                    str = str2;
                                    listEmptyList = (List) destination$iv$iv;
                                } else {
                                    str = str2;
                                    listEmptyList = CollectionsKt.emptyList();
                                }
                                playZLiveEventData = new PlayZLiveEventData(i4, str6, eventLogo2, str7, category2, playZLiveEventInfo2, i, listEmptyList);
                            } catch (Exception e5) {
                                e = e5;
                                str = str2;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            str = str2;
                        }
                        if (playZLiveEventData != null) {
                            destination$iv$iv2.add(playZLiveEventData);
                        }
                        index$iv$iv$iv = index$iv$iv$iv2;
                        str2 = str;
                        i2 = 2;
                        list = null;
                    }
                    Iterable events = (List) destination$iv$iv2;
                    Iterable $this$filter$iv = events;
                    Collection destination$iv$iv3 = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        PlayZLiveEventData it = (PlayZLiveEventData) element$iv$iv;
                        if (it.getPublish() == 1) {
                            destination$iv$iv3.add(element$iv$iv);
                        }
                    }
                    return (List) destination$iv$iv3;
                }
            } catch (Exception e7) {
                System.out.println((Object) ("PlayZTV: fetchLiveEvents exception – " + e7.getMessage()));
            }
            return CollectionsKt.emptyList();
        }
    }

    @Nullable
    public final Object fetchLiveEvents(@NotNull Continuation<? super List<PlayZLiveEventData>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00272(null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.PlayZTVProviderManager$fetchCustomEvents$2 */
    /* JADX INFO: compiled from: PlayZTVProviderManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/cncverse/PlayZLiveEventData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTVProviderManager$fetchCustomEvents$2", f = "PlayZTVProviderManager.kt", i = {}, l = {349}, m = "invokeSuspend", n = {}, nl = {350}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nPlayZTVProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayZTVProviderManager.kt\ncom/cncverse/PlayZTVProviderManager$fetchCustomEvents$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,427:1\n63#2:428\n64#2,15:430\n63#2:451\n64#2,15:453\n1#3:429\n1#3:452\n1#3:475\n50#4:445\n43#4:446\n50#4:468\n43#4:469\n1606#5:447\n1617#5:448\n1924#5,2:449\n1596#5:470\n1629#5,4:471\n1926#5:476\n1618#5:477\n777#5:478\n873#5,2:479\n*S KotlinDebug\n*F\n+ 1 PlayZTVProviderManager.kt\ncom/cncverse/PlayZTVProviderManager$fetchCustomEvents$2\n*L\n351#1:428\n351#1:430,15\n354#1:451\n354#1:453,15\n351#1:429\n354#1:452\n352#1:475\n351#1:445\n351#1:446\n354#1:468\n354#1:469\n352#1:447\n352#1:448\n352#1:449,2\n380#1:470\n380#1:471,4\n352#1:476\n352#1:477\n392#1:478\n392#1:479,2\n*E\n"})
    static final class C00232 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PlayZLiveEventData>>, Object> {
        final /* synthetic */ String $catLink;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00232(String str, Continuation<? super C00232> continuation) {
            super(2, continuation);
            this.$catLink = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00232(this.$catLink, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<PlayZLiveEventData>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:105:0x01ed  */
        /* JADX WARN: Code duplicated, block: B:107:0x01f0  */
        /* JADX WARN: Code duplicated, block: B:108:0x01f6 A[Catch: Exception -> 0x0306, TryCatch #9 {Exception -> 0x0306, blocks: (B:75:0x017e, B:78:0x0185, B:96:0x01c6, B:99:0x01dc, B:101:0x01e4, B:108:0x01f6, B:111:0x0205, B:115:0x0223, B:116:0x027d, B:118:0x0283, B:120:0x028b, B:121:0x028e, B:114:0x0219, B:95:0x01ad, B:93:0x01a4, B:74:0x0174), top: B:170:0x017e }] */
        /* JADX WARN: Code duplicated, block: B:110:0x0203  */
        /* JADX WARN: Code duplicated, block: B:113:0x0214  */
        /* JADX WARN: Code duplicated, block: B:114:0x0219 A[Catch: Exception -> 0x0306, TryCatch #9 {Exception -> 0x0306, blocks: (B:75:0x017e, B:78:0x0185, B:96:0x01c6, B:99:0x01dc, B:101:0x01e4, B:108:0x01f6, B:111:0x0205, B:115:0x0223, B:116:0x027d, B:118:0x0283, B:120:0x028b, B:121:0x028e, B:114:0x0219, B:95:0x01ad, B:93:0x01a4, B:74:0x0174), top: B:170:0x017e }] */
        /* JADX WARN: Code duplicated, block: B:118:0x0283 A[Catch: Exception -> 0x0306, TryCatch #9 {Exception -> 0x0306, blocks: (B:75:0x017e, B:78:0x0185, B:96:0x01c6, B:99:0x01dc, B:101:0x01e4, B:108:0x01f6, B:111:0x0205, B:115:0x0223, B:116:0x027d, B:118:0x0283, B:120:0x028b, B:121:0x028e, B:114:0x0219, B:95:0x01ad, B:93:0x01a4, B:74:0x0174), top: B:170:0x017e }] */
        /* JADX WARN: Code duplicated, block: B:120:0x028b A[Catch: Exception -> 0x0306, TryCatch #9 {Exception -> 0x0306, blocks: (B:75:0x017e, B:78:0x0185, B:96:0x01c6, B:99:0x01dc, B:101:0x01e4, B:108:0x01f6, B:111:0x0205, B:115:0x0223, B:116:0x027d, B:118:0x0283, B:120:0x028b, B:121:0x028e, B:114:0x0219, B:95:0x01ad, B:93:0x01a4, B:74:0x0174), top: B:170:0x017e }] */
        /* JADX WARN: Code duplicated, block: B:123:0x029e  */
        /* JADX WARN: Code duplicated, block: B:130:0x02ba  */
        /* JADX WARN: Code duplicated, block: B:144:0x033c A[Catch: Exception -> 0x001c, TryCatch #7 {Exception -> 0x001c, blocks: (B:6:0x0016, B:14:0x0033, B:16:0x003a, B:22:0x0046, B:28:0x0078, B:36:0x00a7, B:39:0x00ae, B:49:0x00de, B:50:0x00f7, B:52:0x00fd, B:54:0x0105, B:55:0x0108, B:144:0x033c, B:141:0x030f, B:146:0x034d, B:147:0x0366, B:149:0x036c, B:154:0x0380, B:155:0x0384, B:48:0x00c9, B:47:0x00c3, B:35:0x009c, B:27:0x006e, B:11:0x0023, B:24:0x004b, B:32:0x0081, B:42:0x00b4), top: B:168:0x000b, inners: #4, #10, #15 }] */
        /* JADX WARN: Code duplicated, block: B:186:0x0342 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:98:0x01d6  */
        /* JADX WARN: Code duplicated, block: B:99:0x01dc A[Catch: Exception -> 0x0306, TryCatch #9 {Exception -> 0x0306, blocks: (B:75:0x017e, B:78:0x0185, B:96:0x01c6, B:99:0x01dc, B:101:0x01e4, B:108:0x01f6, B:111:0x0205, B:115:0x0223, B:116:0x027d, B:118:0x0283, B:120:0x028b, B:121:0x028e, B:114:0x0219, B:95:0x01ad, B:93:0x01a4, B:74:0x0174), top: B:170:0x017e }] */
        public final Object invokeSuspend(Object $result) {
            Object objFetchDecrypted;
            Object obj;
            Object objDecodeFromString;
            String str;
            PlayZLiveEventData playZLiveEventData;
            Object obj2;
            boolean z;
            String value$iv;
            Object objDecodeFromString2;
            PlayZTVChannelData channelData;
            String links;
            boolean z2;
            String rawLink;
            String name;
            String strSubstringBeforeLast$default;
            Collection destination$iv$iv;
            int index$iv$iv;
            List<String> link_names;
            int formatIndex;
            String str2;
            String str3 = "kotlinx.serialization.serializer.simple";
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        objFetchDecrypted = PlayZTVProviderManager.INSTANCE.fetchDecrypted(this.$catLink, (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        objFetchDecrypted = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String decrypted = (String) objFetchDecrypted;
                String str4 = decrypted;
                if (!(str4 == null || StringsKt.isBlank(str4))) {
                    AppUtils appUtils = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlayZTVChannelWrapper.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    int i = 2;
                    List list = null;
                    if (Result.exceptionOrNull-impl(obj) != null) {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                        } catch (Throwable th2) {
                            Result.Companion companion4 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th2));
                        }
                    }
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                    if (deserializationStrategy != null) {
                        try {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decrypted);
                        } catch (SerializationException e) {
                            ArchComponentExtKt.logError(e);
                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv.readValue(decrypted, new TypeReference<List<? extends PlayZTVChannelWrapper>>() { // from class: com.cncverse.PlayZTVProviderManager$fetchCustomEvents$2$invokeSuspend$$inlined$parseJson$1
                            });
                        } catch (Throwable th3) {
                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv2.readValue(decrypted, new TypeReference<List<? extends PlayZTVChannelWrapper>>() { // from class: com.cncverse.PlayZTVProviderManager$fetchCustomEvents$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv3.readValue(decrypted, new TypeReference<List<? extends PlayZTVChannelWrapper>>() { // from class: com.cncverse.PlayZTVProviderManager$fetchCustomEvents$2$invokeSuspend$$inlined$parseJson$1
                        });
                    }
                    Iterable wrappers = (List) objDecodeFromString;
                    Iterable $this$mapIndexedNotNull$iv = wrappers;
                    Collection destination$iv$iv2 = new ArrayList();
                    int index$iv$iv$iv = 0;
                    for (Object item$iv$iv$iv : $this$mapIndexedNotNull$iv) {
                        int index$iv$iv$iv2 = index$iv$iv$iv + 1;
                        if (index$iv$iv$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        int index$iv$iv2 = index$iv$iv$iv;
                        PlayZTVChannelWrapper wrapper = (PlayZTVChannelWrapper) item$iv$iv$iv;
                        try {
                            AppUtils appUtils2 = AppUtils.INSTANCE;
                            String value$iv2 = wrapper.getChannel();
                            try {
                                Result.Companion companion5 = Result.Companion;
                                KType kTypeTypeOf2 = Reflection.typeOf(PlayZTVChannelData.class);
                                MagicApiIntrinsics.voidMagicApiCall(str3);
                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                            } catch (Throwable th4) {
                                Result.Companion companion6 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th4));
                            }
                            if (Result.exceptionOrNull-impl(obj2) == null) {
                                z = false;
                            } else {
                                try {
                                    Result.Companion companion7 = Result.Companion;
                                    z = false;
                                    try {
                                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlayZTVChannelData.class), list, i, list));
                                    } catch (Throwable th5) {
                                        th = th5;
                                        Result.Companion companion8 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    z = false;
                                }
                            }
                            try {
                                if (Result.isFailure-impl(obj2)) {
                                    obj2 = list;
                                }
                                DeserializationStrategy deserializationStrategy2 = (KSerializer) obj2;
                                if (deserializationStrategy2 != null) {
                                    try {
                                        value$iv = value$iv2;
                                        try {
                                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv);
                                        } catch (SerializationException e2) {
                                            e$iv = e2;
                                            ArchComponentExtKt.logError((Throwable) e$iv);
                                            ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                            String content$iv$iv = value$iv;
                                            objDecodeFromString2 = $this$readValue$iv$iv4.readValue(content$iv$iv, new TypeReference<PlayZTVChannelData>() { // from class: com.cncverse.PlayZTVProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                            });
                                        } catch (Throwable th7) {
                                            ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                            String content$iv$iv2 = value$iv;
                                            objDecodeFromString2 = $this$readValue$iv$iv5.readValue(content$iv$iv2, new TypeReference<PlayZTVChannelData>() { // from class: com.cncverse.PlayZTVProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                            });
                                        }
                                    } catch (SerializationException e3) {
                                        e$iv = e3;
                                        value$iv = value$iv2;
                                    } catch (Throwable th8) {
                                        value$iv = value$iv2;
                                    }
                                    channelData = (PlayZTVChannelData) objDecodeFromString2;
                                    if (Intrinsics.areEqual(channelData.getVisible(), Boxing.boxBoolean(z))) {
                                        str = str3;
                                        playZLiveEventData = null;
                                    } else {
                                        links = channelData.getLinks();
                                        if (links != null || StringsKt.isBlank(links)) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            str = str3;
                                            playZLiveEventData = null;
                                        } else {
                                            rawLink = channelData.getLinks();
                                            int i2 = index$iv$iv2 + 1;
                                            name = channelData.getName();
                                            if (name == null) {
                                                name = "Unknown Channel";
                                            }
                                            String str5 = name;
                                            String logo = channelData.getLogo();
                                            if (StringsKt.startsWith(rawLink, "http", true)) {
                                                strSubstringBeforeLast$default = rawLink;
                                            } else {
                                                strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(rawLink, ".", (String) null, 2, (Object) null);
                                            }
                                            PlayZLiveEventInfo playZLiveEventInfo = new PlayZLiveEventInfo(null, null, null, null, null, channelData.getName(), channelData.getLogo(), "0", null, null, null);
                                            Iterable $this$mapIndexed$iv = StringsKt.split$default(rawLink, new String[]{","}, false, 0, 6, (Object) null);
                                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                                            index$iv$iv = 0;
                                            for (Object item$iv$iv : $this$mapIndexed$iv) {
                                                int index$iv$iv3 = index$iv$iv + 1;
                                                if (index$iv$iv < 0) {
                                                    CollectionsKt.throwIndexOverflow();
                                                }
                                                String link = (String) item$iv$iv;
                                                PlayZTVChannelData channelData2 = channelData;
                                                link_names = channelData2.getLink_names();
                                                if (link_names != null) {
                                                    str = str3;
                                                    formatIndex = index$iv$iv;
                                                    try {
                                                        str2 = (String) CollectionsKt.getOrNull(link_names, formatIndex);
                                                        if (str2 != null || (string = StringsKt.trim(str2).toString()) == null) {
                                                        }
                                                        destination$iv$iv.add(new PlayZLiveEventFormat(string, StringsKt.trim(link).toString()));
                                                        index$iv$iv = index$iv$iv3;
                                                        channelData = channelData2;
                                                        str3 = str;
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        System.out.println((Object) ("PlayZTV: Failed to parse custom event at " + index$iv$iv2 + " – " + e.getMessage()));
                                                        playZLiveEventData = null;
                                                        if (playZLiveEventData != null) {
                                                            destination$iv$iv2.add(playZLiveEventData);
                                                        }
                                                        index$iv$iv$iv = index$iv$iv$iv2;
                                                        str3 = str;
                                                        i = 2;
                                                        list = null;
                                                    }
                                                } else {
                                                    str = str3;
                                                    formatIndex = index$iv$iv;
                                                }
                                                String string = "Link " + (formatIndex + 1);
                                                destination$iv$iv.add(new PlayZLiveEventFormat(string, StringsKt.trim(link).toString()));
                                                index$iv$iv = index$iv$iv3;
                                                channelData = channelData2;
                                                str3 = str;
                                            }
                                            str = str3;
                                            playZLiveEventData = new PlayZLiveEventData(i2, str5, logo, strSubstringBeforeLast$default, "Custom", playZLiveEventInfo, 1, (List) destination$iv$iv);
                                        }
                                    }
                                    if (playZLiveEventData != null) {
                                        destination$iv$iv2.add(playZLiveEventData);
                                    }
                                    index$iv$iv$iv = index$iv$iv$iv2;
                                    str3 = str;
                                    i = 2;
                                    list = null;
                                } else {
                                    value$iv = value$iv2;
                                }
                                ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                String content$iv$iv3 = value$iv;
                                objDecodeFromString2 = $this$readValue$iv$iv6.readValue(content$iv$iv3, new TypeReference<PlayZTVChannelData>() { // from class: com.cncverse.PlayZTVProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                });
                                channelData = (PlayZTVChannelData) objDecodeFromString2;
                                if (Intrinsics.areEqual(channelData.getVisible(), Boxing.boxBoolean(z))) {
                                    str = str3;
                                    playZLiveEventData = null;
                                } else {
                                    links = channelData.getLinks();
                                    if (links != null) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        str = str3;
                                        playZLiveEventData = null;
                                    } else {
                                        rawLink = channelData.getLinks();
                                        int i3 = index$iv$iv2 + 1;
                                        name = channelData.getName();
                                        if (name == null) {
                                            name = "Unknown Channel";
                                        }
                                        String str6 = name;
                                        String logo2 = channelData.getLogo();
                                        if (StringsKt.startsWith(rawLink, "http", true)) {
                                            strSubstringBeforeLast$default = rawLink;
                                        } else {
                                            strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(rawLink, ".", (String) null, 2, (Object) null);
                                        }
                                        PlayZLiveEventInfo playZLiveEventInfo2 = new PlayZLiveEventInfo(null, null, null, null, null, channelData.getName(), channelData.getLogo(), "0", null, null, null);
                                        Iterable $this$mapIndexed$iv2 = StringsKt.split$default(rawLink, new String[]{","}, false, 0, 6, (Object) null);
                                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
                                        index$iv$iv = 0;
                                        while (r29.hasNext()) {
                                            int index$iv$iv4 = index$iv$iv + 1;
                                            if (index$iv$iv < 0) {
                                                CollectionsKt.throwIndexOverflow();
                                            }
                                            String link2 = (String) item$iv$iv;
                                            PlayZTVChannelData channelData3 = channelData;
                                            link_names = channelData3.getLink_names();
                                            if (link_names != null) {
                                                str = str3;
                                                formatIndex = index$iv$iv;
                                                str2 = (String) CollectionsKt.getOrNull(link_names, formatIndex);
                                                if (str2 != null) {
                                                }
                                                destination$iv$iv.add(new PlayZLiveEventFormat(string, StringsKt.trim(link2).toString()));
                                                index$iv$iv = index$iv$iv4;
                                                channelData = channelData3;
                                                str3 = str;
                                            } else {
                                                str = str3;
                                                formatIndex = index$iv$iv;
                                            }
                                            String string2 = "Link " + (formatIndex + 1);
                                            destination$iv$iv.add(new PlayZLiveEventFormat(string2, StringsKt.trim(link2).toString()));
                                            index$iv$iv = index$iv$iv4;
                                            channelData = channelData3;
                                            str3 = str;
                                        }
                                        str = str3;
                                        playZLiveEventData = new PlayZLiveEventData(i3, str6, logo2, strSubstringBeforeLast$default, "Custom", playZLiveEventInfo2, 1, (List) destination$iv$iv);
                                    }
                                }
                            } catch (Exception e5) {
                                e = e5;
                                str = str3;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            str = str3;
                        }
                        if (playZLiveEventData != null) {
                            destination$iv$iv2.add(playZLiveEventData);
                        }
                        index$iv$iv$iv = index$iv$iv$iv2;
                        str3 = str;
                        i = 2;
                        list = null;
                    }
                    Iterable events = (List) destination$iv$iv2;
                    Iterable $this$filter$iv = events;
                    Collection destination$iv$iv3 = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        PlayZLiveEventData it = (PlayZLiveEventData) element$iv$iv;
                        if (it.getPublish() == 1) {
                            destination$iv$iv3.add(element$iv$iv);
                        }
                    }
                    return (List) destination$iv$iv3;
                }
            } catch (Exception e7) {
                System.out.println((Object) ("PlayZTV: fetchCustomEvents exception – " + e7.getMessage()));
            }
            return CollectionsKt.emptyList();
        }
    }

    @Nullable
    public final Object fetchCustomEvents(@NotNull String catLink, @NotNull Continuation<? super List<PlayZLiveEventData>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00232(catLink, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.PlayZTVProviderManager$fetchChannelStreams$2 */
    /* JADX INFO: compiled from: PlayZTVProviderManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/cncverse/PlayZStreamUrl;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTVProviderManager$fetchChannelStreams$2", f = "PlayZTVProviderManager.kt", i = {}, l = {407}, m = "invokeSuspend", n = {}, nl = {408}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nPlayZTVProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayZTVProviderManager.kt\ncom/cncverse/PlayZTVProviderManager$fetchChannelStreams$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,427:1\n63#2:428\n64#2,15:430\n1#3:429\n50#4:445\n43#4:446\n*S KotlinDebug\n*F\n+ 1 PlayZTVProviderManager.kt\ncom/cncverse/PlayZTVProviderManager$fetchChannelStreams$2\n*L\n409#1:428\n409#1:430,15\n409#1:429\n409#1:445\n409#1:446\n*E\n"})
    static final class C00212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PlayZStreamUrl>>, Object> {
        final /* synthetic */ String $slug;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00212(String str, Continuation<? super C00212> continuation) {
            super(2, continuation);
            this.$slug = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00212(this.$slug, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<PlayZStreamUrl>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objFetchDecrypted;
            Object obj;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean z = true;
            Object objDecodeFromString = null;
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        objFetchDecrypted = PlayZTVProviderManager.INSTANCE.fetchDecrypted(this.$slug + ".txt", (Continuation) this);
                        if (objFetchDecrypted == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        objFetchDecrypted = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String decrypted = (String) objFetchDecrypted;
                String str = decrypted;
                if (str != null && !StringsKt.isBlank(str)) {
                    z = false;
                }
                if (!z) {
                    AppUtils appUtils = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlayZStreamUrl.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
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
                    }
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                    if (deserializationStrategy != null) {
                        try {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decrypted);
                            return objDecodeFromString;
                        } catch (SerializationException e) {
                            ArchComponentExtKt.logError(e);
                        } catch (Throwable th3) {
                        }
                    }
                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                    return $this$readValue$iv$iv.readValue(decrypted, new TypeReference<List<? extends PlayZStreamUrl>>() { // from class: com.cncverse.PlayZTVProviderManager$fetchChannelStreams$2$invokeSuspend$$inlined$parseJson$1
                    });
                }
            } catch (Exception e2) {
                System.out.println((Object) ("PlayZTV: fetchChannelStreams exception for " + this.$slug + " – " + e2.getMessage()));
            }
            return objDecodeFromString;
        }
    }

    @Nullable
    public final Object fetchChannelStreams(@NotNull String slug, @NotNull Continuation<? super List<PlayZStreamUrl>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00212(slug, null), continuation);
    }
}
