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

/* JADX INFO: compiled from: PlayFyFirebaseConfigFetcher.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/PlayFyProvider/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/cncverse/PlayFyFirebaseConfigFetcher;", "", "<init>", "()V", "PACKAGE_NAME", "", "PROJECT_NUMBER", "API_KEY", "APP_ID", "ANDROID_CERT", "client", "Lokhttp3/OkHttpClient;", "fetchRemoteConfig", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLora", "getBaseUrl", "RemoteConfigResponse", "PlayFyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PlayFyFirebaseConfigFetcher {

    @NotNull
    private static final String ANDROID_CERT = "31CD6939D1BEAE32D1B0EF2D9460B170116A1885";

    @NotNull
    private static final String API_KEY = "AIzaSyDdHIwVAD3XgP5bEwZOcR1QIz7gO5q5EoM";

    @NotNull
    private static final String APP_ID = "1:239487160038:android:308875071ce6f0fd48f527";

    @NotNull
    private static final String PACKAGE_NAME = "com.playfy.tv";

    @NotNull
    private static final String PROJECT_NUMBER = "239487160038";

    @NotNull
    public static final PlayFyFirebaseConfigFetcher INSTANCE = new PlayFyFirebaseConfigFetcher();

    @NotNull
    private static final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();

    /* JADX INFO: renamed from: com.cncverse.PlayFyFirebaseConfigFetcher$getBaseUrl$1 */
    /* JADX INFO: compiled from: PlayFyFirebaseConfigFetcher.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyFirebaseConfigFetcher", f = "PlayFyFirebaseConfigFetcher.kt", i = {}, l = {111}, m = "getBaseUrl", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00131 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00131(Continuation<? super C00131> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayFyFirebaseConfigFetcher.this.getBaseUrl((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyFirebaseConfigFetcher$getLora$1 */
    /* JADX INFO: compiled from: PlayFyFirebaseConfigFetcher.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyFirebaseConfigFetcher", f = "PlayFyFirebaseConfigFetcher.kt", i = {}, l = {104}, m = "getLora", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00141 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00141(Continuation<? super C00141> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayFyFirebaseConfigFetcher.this.getLora((Continuation) this);
        }
    }

    private PlayFyFirebaseConfigFetcher() {
    }

    /* JADX INFO: compiled from: PlayFyFirebaseConfigFetcher.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0004HÖ\u0081\u0004R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/cncverse/PlayFyFirebaseConfigFetcher$RemoteConfigResponse;", "", "entries", "", "", "state", "templateVersion", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getEntries", "()Ljava/util/Map;", "getState", "()Ljava/lang/String;", "getTemplateVersion", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "PlayFyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class RemoteConfigResponse {

        @Nullable
        private final Map<String, String> entries;

        @Nullable
        private final String state;

        @Nullable
        private final String templateVersion;

        public RemoteConfigResponse() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RemoteConfigResponse copy$default(RemoteConfigResponse remoteConfigResponse, Map map, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                map = remoteConfigResponse.entries;
            }
            if ((i & 2) != 0) {
                str = remoteConfigResponse.state;
            }
            if ((i & 4) != 0) {
                str2 = remoteConfigResponse.templateVersion;
            }
            return remoteConfigResponse.copy(map, str, str2);
        }

        @Nullable
        public final Map<String, String> component1() {
            return this.entries;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getState() {
            return this.state;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTemplateVersion() {
            return this.templateVersion;
        }

        @NotNull
        public final RemoteConfigResponse copy(@Nullable Map<String, String> entries, @Nullable String state, @Nullable String templateVersion) {
            return new RemoteConfigResponse(entries, state, templateVersion);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RemoteConfigResponse)) {
                return false;
            }
            RemoteConfigResponse remoteConfigResponse = (RemoteConfigResponse) other;
            return Intrinsics.areEqual(this.entries, remoteConfigResponse.entries) && Intrinsics.areEqual(this.state, remoteConfigResponse.state) && Intrinsics.areEqual(this.templateVersion, remoteConfigResponse.templateVersion);
        }

        public int hashCode() {
            return ((((this.entries == null ? 0 : this.entries.hashCode()) * 31) + (this.state == null ? 0 : this.state.hashCode())) * 31) + (this.templateVersion != null ? this.templateVersion.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "RemoteConfigResponse(entries=" + this.entries + ", state=" + this.state + ", templateVersion=" + this.templateVersion + ')';
        }

        public RemoteConfigResponse(@Nullable Map<String, String> map, @Nullable String state, @Nullable String templateVersion) {
            this.entries = map;
            this.state = state;
            this.templateVersion = templateVersion;
        }

        public /* synthetic */ RemoteConfigResponse(Map map, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
        }

        @Nullable
        public final Map<String, String> getEntries() {
            return this.entries;
        }

        @Nullable
        public final String getState() {
            return this.state;
        }

        @Nullable
        public final String getTemplateVersion() {
            return this.templateVersion;
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayFyFirebaseConfigFetcher$fetchRemoteConfig$2 */
    /* JADX INFO: compiled from: PlayFyFirebaseConfigFetcher.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayFyFirebaseConfigFetcher$fetchRemoteConfig$2", f = "PlayFyFirebaseConfigFetcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nPlayFyFirebaseConfigFetcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayFyFirebaseConfigFetcher.kt\ncom/cncverse/PlayFyFirebaseConfigFetcher$fetchRemoteConfig$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,114:1\n63#2:115\n64#2,15:117\n1#3:116\n50#4:132\n43#4:133\n*S KotlinDebug\n*F\n+ 1 PlayFyFirebaseConfigFetcher.kt\ncom/cncverse/PlayFyFirebaseConfigFetcher$fetchRemoteConfig$2\n*L\n88#1:115\n88#1:117,15\n88#1:116\n88#1:132\n88#1:133\n*E\n"})
    static final class C00112 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends String>>, Object> {
        int label;

        C00112(Continuation<? super C00112> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00112(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, String>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object obj;
            Object obj2;
            Object objDecodeFromString;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        String appInstanceId = StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, (Object) null);
                        String payload = StringsKt.trimIndent("\n                    {\n                        \"appVersion\": \"1.7\",\n                        \"appInstanceIdToken\": \"\",\n                        \"languageCode\": \"en-IN\",\n                        \"appBuild\": \"8\",\n                        \"appInstanceId\": \"" + appInstanceId + "\",\n                        \"countryCode\": \"IN\",\n                        \"analyticsUserProperties\": {},\n                        \"appId\": \"1:239487160038:android:308875071ce6f0fd48f527\",\n                        \"platformVersion\": \"33\",\n                        \"sdkVersion\": \"22.1.2\",\n                        \"packageName\": \"com.playfy.tv\"\n                    }\n                ");
                        Request request = new Request.Builder().url("https://firebaseremoteconfig.googleapis.com/v1/projects/239487160038/namespaces/firebase:fetch").post(RequestBody.Companion.create(payload, MediaType.Companion.get("application/json"))).header("Accept", "application/json").header("Connection", "Keep-Alive").header("Content-Type", "application/json").header("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 13; Pixel 5 Build/TQ3A.230901.001)").header("X-Android-Cert", PlayFyFirebaseConfigFetcher.ANDROID_CERT).header("X-Android-Package", PlayFyFirebaseConfigFetcher.PACKAGE_NAME).header("X-Firebase-RC-Fetch-Type", "BASE/1").header("X-Goog-Api-Key", PlayFyFirebaseConfigFetcher.API_KEY).header("X-Google-GFE-Can-Retry", "yes").build();
                        Response response = PlayFyFirebaseConfigFetcher.client.newCall(request).execute();
                        if (!response.isSuccessful()) {
                            return null;
                        }
                        String body = response.body().string();
                        if (StringsKt.isBlank(body)) {
                            return null;
                        }
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(RemoteConfigResponse.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                            break;
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj2) != null) {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(RemoteConfigResponse.class), (List) null, 2, (Object) null));
                            } catch (Throwable th2) {
                                Result.Companion companion4 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                            }
                            break;
                        }
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = null;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj2;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, body);
                                obj = null;
                            } catch (SerializationException e) {
                                ArchComponentExtKt.logError(e);
                                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                obj = null;
                                try {
                                    objDecodeFromString = $this$readValue$iv$iv.readValue(body, new TypeReference<RemoteConfigResponse>() { // from class: com.cncverse.PlayFyFirebaseConfigFetcher$fetchRemoteConfig$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                obj = null;
                                objDecodeFromString = $this$readValue$iv$iv2.readValue(body, new TypeReference<RemoteConfigResponse>() { // from class: com.cncverse.PlayFyFirebaseConfigFetcher$fetchRemoteConfig$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                            obj = null;
                            objDecodeFromString = $this$readValue$iv$iv3.readValue(body, new TypeReference<RemoteConfigResponse>() { // from class: com.cncverse.PlayFyFirebaseConfigFetcher$fetchRemoteConfig$2$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        RemoteConfigResponse cfg = (RemoteConfigResponse) objDecodeFromString;
                        return cfg.getEntries();
                    } catch (Exception e3) {
                        e = e3;
                        obj = null;
                    }
                    System.out.println((Object) ("PlayFy: Firebase remote config fetch failed: " + e.getMessage()));
                    return obj;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Nullable
    public final Object fetchRemoteConfig(@NotNull Continuation<? super Map<String, String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00112(null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object getLora(@NotNull Continuation<? super String> continuation) {
        C00141 c00141;
        Object objFetchRemoteConfig;
        if (continuation instanceof C00141) {
            c00141 = (C00141) continuation;
            if ((c00141.label & Integer.MIN_VALUE) != 0) {
                c00141.label -= Integer.MIN_VALUE;
            } else {
                c00141 = new C00141(continuation);
            }
        } else {
            c00141 = new C00141(continuation);
        }
        Object $result = c00141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00141.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00141.label = 1;
                objFetchRemoteConfig = fetchRemoteConfig(c00141);
                if (objFetchRemoteConfig == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objFetchRemoteConfig = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Map map = (Map) objFetchRemoteConfig;
        if (map != null) {
            return (String) map.get("lora");
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object getBaseUrl(@NotNull Continuation<? super String> continuation) {
        C00131 c00131;
        Object objFetchRemoteConfig;
        String str;
        if (continuation instanceof C00131) {
            c00131 = (C00131) continuation;
            if ((c00131.label & Integer.MIN_VALUE) != 0) {
                c00131.label -= Integer.MIN_VALUE;
            } else {
                c00131 = new C00131(continuation);
            }
        } else {
            c00131 = new C00131(continuation);
        }
        Object $result = c00131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00131.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00131.label = 1;
                objFetchRemoteConfig = fetchRemoteConfig(c00131);
                if (objFetchRemoteConfig == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objFetchRemoteConfig = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Map map = (Map) objFetchRemoteConfig;
        if (map == null || (str = (String) map.get("baseUrl")) == null) {
            return null;
        }
        return StringsKt.trimEnd(str, new char[]{'/'});
    }
}
