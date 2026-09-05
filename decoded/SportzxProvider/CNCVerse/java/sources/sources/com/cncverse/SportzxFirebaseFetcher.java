package com.cncverse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SportzxFirebaseFetcher.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/SportzxProvider/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eH\u0082@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/cncverse/SportzxFirebaseFetcher;", "", "<init>", "()V", "PACKAGE_NAME", "", "APP_ID", "API_KEY", "PROJECT_NUMBER", "APP_VERSION", "APP_BUILD", "client", "Lokhttp3/OkHttpClient;", "fetchRemoteConfig", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBaseApiUrl", "RemoteConfigResponse", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SportzxFirebaseFetcher {

    @NotNull
    private static final String API_KEY = "AIzaSyCTIFo_vw_-XrjzDeE1yG4KuAqGLchzZ0M";

    @NotNull
    private static final String APP_BUILD = "15";

    @NotNull
    private static final String APP_ID = "1:234785582029:android:f5f9299eaa7a0d73c93284";

    @NotNull
    private static final String APP_VERSION = "2.6";

    @NotNull
    private static final String PACKAGE_NAME = "com.sportzx.live";

    @NotNull
    private static final String PROJECT_NUMBER = "234785582029";

    @NotNull
    public static final SportzxFirebaseFetcher INSTANCE = new SportzxFirebaseFetcher();

    @NotNull
    private static final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();

    /* JADX INFO: renamed from: com.cncverse.SportzxFirebaseFetcher$getBaseApiUrl$1 */
    /* JADX INFO: compiled from: SportzxFirebaseFetcher.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SportzxFirebaseFetcher", f = "SportzxFirebaseFetcher.kt", i = {0}, l = {99}, m = "getBaseApiUrl", n = {"fallbackUrl"}, nl = {100}, s = {"L$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SportzxFirebaseFetcher.this.getBaseApiUrl((Continuation) this);
        }
    }

    private SportzxFirebaseFetcher() {
    }

    /* JADX INFO: compiled from: SportzxFirebaseFetcher.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0004HÖ\u0081\u0004R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/cncverse/SportzxFirebaseFetcher$RemoteConfigResponse;", "", "entries", "", "", "<init>", "(Ljava/util/Map;)V", "getEntries", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class RemoteConfigResponse {

        @Nullable
        private final Map<String, String> entries;

        /* JADX WARN: Illegal instructions before constructor call */
        public RemoteConfigResponse() {
            Map map = null;
            this(map, 1, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RemoteConfigResponse copy$default(RemoteConfigResponse remoteConfigResponse, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = remoteConfigResponse.entries;
            }
            return remoteConfigResponse.copy(map);
        }

        @Nullable
        public final Map<String, String> component1() {
            return this.entries;
        }

        @NotNull
        public final RemoteConfigResponse copy(@Nullable Map<String, String> entries) {
            return new RemoteConfigResponse(entries);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RemoteConfigResponse) && Intrinsics.areEqual(this.entries, ((RemoteConfigResponse) other).entries);
        }

        public int hashCode() {
            if (this.entries == null) {
                return 0;
            }
            return this.entries.hashCode();
        }

        @NotNull
        public String toString() {
            return "RemoteConfigResponse(entries=" + this.entries + ')';
        }

        public RemoteConfigResponse(@Nullable Map<String, String> map) {
            this.entries = map;
        }

        public /* synthetic */ RemoteConfigResponse(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : map);
        }

        @Nullable
        public final Map<String, String> getEntries() {
            return this.entries;
        }
    }

    /* JADX INFO: renamed from: com.cncverse.SportzxFirebaseFetcher$fetchRemoteConfig$2 */
    /* JADX INFO: compiled from: SportzxFirebaseFetcher.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SportzxFirebaseFetcher$fetchRemoteConfig$2", f = "SportzxFirebaseFetcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nSportzxFirebaseFetcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportzxFirebaseFetcher.kt\ncom/cncverse/SportzxFirebaseFetcher$fetchRemoteConfig$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,103:1\n63#2:104\n64#2,15:106\n1#3:105\n50#4:121\n43#4:122\n*S KotlinDebug\n*F\n+ 1 SportzxFirebaseFetcher.kt\ncom/cncverse/SportzxFirebaseFetcher$fetchRemoteConfig$2\n*L\n84#1:104\n84#1:106,15\n84#1:105\n84#1:121\n84#1:122\n*E\n"})
    static final class C00002 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends String>>, Object> {
        int label;

        C00002(Continuation<? super C00002> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00002(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, String>> continuation) {
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
                        String appInstanceId = StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, (Object) null);
                        String body = StringsKt.trimIndent("\n                    {\n                        \"appInstanceId\": \"" + appInstanceId + "\",\n                        \"appInstanceIdToken\": \"\",\n                        \"appId\": \"1:234785582029:android:f5f9299eaa7a0d73c93284\",\n                        \"countryCode\": \"IN\",\n                        \"languageCode\": \"en-IN\",\n                        \"platformVersion\": \"33\",\n                        \"timeZone\": \"Asia/Calcutta\",\n                        \"appVersion\": \"2.6\",\n                        \"appBuild\": \"15\",\n                        \"packageName\": \"com.sportzx.live\",\n                        \"sdkVersion\": \"23.1.0\",\n                        \"analyticsUserProperties\": {}\n                    }\n                ");
                        Request request = new Request.Builder().url("https://firebaseremoteconfig.googleapis.com/v1/projects/234785582029/namespaces/firebase:fetch").post(RequestBody.Companion.create(body, MediaType.Companion.get("application/json"))).header("Content-Type", "application/json").header("Accept", "application/json").header("X-Android-Package", SportzxFirebaseFetcher.PACKAGE_NAME).header("X-Goog-Api-Key", SportzxFirebaseFetcher.API_KEY).header("X-Google-GFE-Can-Retry", "yes").build();
                        Response response = SportzxFirebaseFetcher.client.newCall(request).execute();
                        if (!response.isSuccessful()) {
                            System.out.println((Object) ("SportzxFirebase: RemoteConfig failed HTTP " + response.code()));
                            return null;
                        }
                        AppUtils appUtils = AppUtils.INSTANCE;
                        String value$iv = response.body().string();
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(RemoteConfigResponse.class);
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
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RemoteConfigResponse.class), (List) null, 2, (Object) null));
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
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            } catch (SerializationException e) {
                                ArchComponentExtKt.logError(e);
                                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv.readValue(value$iv, new TypeReference<RemoteConfigResponse>() { // from class: com.cncverse.SportzxFirebaseFetcher$fetchRemoteConfig$2$invokeSuspend$$inlined$parseJson$1
                                });
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv2.readValue(value$iv, new TypeReference<RemoteConfigResponse>() { // from class: com.cncverse.SportzxFirebaseFetcher$fetchRemoteConfig$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                            break;
                        } else {
                            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv3.readValue(value$iv, new TypeReference<RemoteConfigResponse>() { // from class: com.cncverse.SportzxFirebaseFetcher$fetchRemoteConfig$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        return ((RemoteConfigResponse) objDecodeFromString).getEntries();
                    } catch (Exception e2) {
                        System.out.println((Object) ("SportzxFirebase: RemoteConfig exception — " + e2.getMessage()));
                        return null;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchRemoteConfig(Continuation<? super Map<String, String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00002(null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object getBaseApiUrl(@NotNull Continuation<? super String> continuation) {
        C00021 c00021;
        Object objFetchRemoteConfig;
        String fallbackUrl;
        String strTrimEnd;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = new C00021(continuation);
            }
        } else {
            c00021 = new C00021(continuation);
        }
        Object $result = c00021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00021.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00021.L$0 = "https://streamtvapp.top";
                c00021.label = 1;
                objFetchRemoteConfig = fetchRemoteConfig(c00021);
                if (objFetchRemoteConfig == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fallbackUrl = "https://streamtvapp.top";
                break;
                break;
            case 1:
                fallbackUrl = (String) c00021.L$0;
                ResultKt.throwOnFailure($result);
                objFetchRemoteConfig = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Map entries = (Map) objFetchRemoteConfig;
        if (entries == null) {
            return fallbackUrl;
        }
        String str = (String) entries.get("api_url");
        return (str == null || (strTrimEnd = StringsKt.trimEnd(str, new char[]{'/'})) == null) ? fallbackUrl : strTrimEnd;
    }
}
