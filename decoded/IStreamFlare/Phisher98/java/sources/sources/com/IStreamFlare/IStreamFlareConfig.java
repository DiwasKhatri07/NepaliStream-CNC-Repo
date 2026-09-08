package com.IStreamFlare;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IStreamFlareConfig.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/IStreamFlare/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010#J\u000e\u0010%\u001a\u00020!H\u0082@¢\u0006\u0002\u0010&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/IStreamFlare/IStreamFlareConfig;", "", "<init>", "()V", "TAG", "", "FIREBASE_API_KEY", "FIREBASE_APP_ID", "ANDROID_CERT", "PACKAGE_NAME", "AUTH_TOKEN", "REMOTE_CONFIG_URL", "USER_AGENT", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "isFetched", "", "serverUrl", "getServerUrl", "()Ljava/lang/String;", "setServerUrl", "(Ljava/lang/String;)V", "apiKey", "getApiKey", "setApiKey", "headers", "", "getHeaders", "()Ljava/util/Map;", "DEVICE_PROFILES", "", "Lcom/IStreamFlare/IStreamFlareConfig$DeviceProfile;", "ensureConfig", "", "force", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchOnce", "fetchRemoteConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DeviceProfile", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIStreamFlareConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IStreamFlareConfig.kt\ncom/IStreamFlare/IStreamFlareConfig\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,133:1\n117#2,10:134\n1#3:144\n1#3:146\n63#4:145\n64#4,15:147\n50#5:162\n43#5:163\n*S KotlinDebug\n*F\n+ 1 IStreamFlareConfig.kt\ncom/IStreamFlare/IStreamFlareConfig\n*L\n68#1:134,10\n118#1:146\n118#1:145\n118#1:147,15\n118#1:162\n118#1:163\n*E\n"})
public final class IStreamFlareConfig {

    @NotNull
    private static final String ANDROID_CERT = "32CCE294EAE651BF6A2C34118F56762751EC5201";

    @NotNull
    private static final String AUTH_TOKEN = "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcHBJZCI6IjE6NjIwNTk5ODE3MjI5OmFuZHJvaWQ6YTY0Y2IyMzlkNzM0YjU2YjUxZDE0NCIsImV4cCI6MTc4OTAxMjAwMCwiZmlkIjoiZXVCRWJiZVhRLVNxXzFmTmp1cGYtQiIsInByb2plY3ROdW1iZXIiOjYyMDU5OTgxNzIyOX0.AB2LPV8wRQIhAII9R8_Otag9ILxDZhdGeGoK2p9ND32lpW-t_CkfoZbQAiBVjcy3bCLgdk8DUPOhFHgNqkyFEyG30yrEpbfs03haTg";

    @NotNull
    private static final List<DeviceProfile> DEVICE_PROFILES;

    @NotNull
    private static final String FIREBASE_API_KEY = "AIzaSyAbbHUfZm6tT6rx2XCSHMPFb6PJI9Sg68s";

    @NotNull
    private static final String FIREBASE_APP_ID = "1:620599817229:android:a64cb239d734b56b51d144";

    @NotNull
    private static final String PACKAGE_NAME = "mk.neptun.neptunapp";

    @NotNull
    private static final String REMOTE_CONFIG_URL = "https://firebaseremoteconfig.googleapis.com/v1/projects/620599817229/namespaces/firebase:fetch";

    @NotNull
    private static final String TAG = "IStreamFlareConfig";

    @NotNull
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";

    @NotNull
    private static String apiKey;
    private static boolean isFetched;

    @NotNull
    private static String serverUrl;

    @NotNull
    public static final IStreamFlareConfig INSTANCE = new IStreamFlareConfig();

    @NotNull
    private static final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);

    /* JADX INFO: renamed from: com.IStreamFlare.IStreamFlareConfig$fetchOnce$1 */
    /* JADX INFO: compiled from: IStreamFlareConfig.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlareConfig", f = "IStreamFlareConfig.kt", i = {0, 0, 1, 1}, l = {138, 72}, m = "fetchOnce", n = {"$this$withLock_u24default$iv", "force", "$this$withLock_u24default$iv", "force"}, nl = {139, 73}, s = {"L$0", "Z$0", "L$0", "Z$0"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IStreamFlareConfig.this.fetchOnce(false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.IStreamFlare.IStreamFlareConfig$fetchRemoteConfig$1 */
    /* JADX INFO: compiled from: IStreamFlareConfig.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.IStreamFlareConfig", f = "IStreamFlareConfig.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {104}, m = "fetchRemoteConfig", n = {"profile", "buildId", "dalvikUa", "instanceId", "country", "language", "tz", "fetchBody"}, nl = {116}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C00111(Continuation<? super C00111> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IStreamFlareConfig.this.fetchRemoteConfig((Continuation) this);
        }
    }

    private IStreamFlareConfig() {
    }

    static {
        serverUrl = StringsKt.trimEnd(StringsKt.isBlank("https://guten.hippitunes.pro") ? "https://panel.hippitunes.pro" : "https://guten.hippitunes.pro", new char[]{'/'});
        apiKey = "kC7V1f8QRaZyvYnh";
        DEVICE_PROFILES = CollectionsKt.listOf(new DeviceProfile[]{new DeviceProfile("SM-F936U", "15", "35", "UP1A"), new DeviceProfile("SM-S928B", "14", "34", "UP1A"), new DeviceProfile("SM-S918B", "14", "34", "UP1A"), new DeviceProfile("Pixel 8 Pro", "14", "34", "UD1A"), new DeviceProfile("Pixel 9", "15", "35", "AP3A"), new DeviceProfile("SM-G998B", "13", "33", "TP1A"), new DeviceProfile("CPH2581", "14", "34", "UKQ1")});
    }

    @NotNull
    public final String getServerUrl() {
        return serverUrl;
    }

    public final void setServerUrl(@NotNull String str) {
        serverUrl = str;
    }

    @NotNull
    public final String getApiKey() {
        return apiKey;
    }

    public final void setApiKey(@NotNull String str) {
        apiKey = str;
    }

    @NotNull
    public final Map<String, String> getHeaders() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", USER_AGENT), TuplesKt.to("x-api-key", apiKey)});
    }

    /* JADX INFO: compiled from: IStreamFlareConfig.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/IStreamFlare/IStreamFlareConfig$DeviceProfile;", "", "model", "", "androidVersion", "sdkInt", "buildPrefix", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getModel", "()Ljava/lang/String;", "getAndroidVersion", "getSdkInt", "getBuildPrefix", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class DeviceProfile {

        @NotNull
        private final String androidVersion;

        @NotNull
        private final String buildPrefix;

        @NotNull
        private final String model;

        @NotNull
        private final String sdkInt;

        public static /* synthetic */ DeviceProfile copy$default(DeviceProfile deviceProfile, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deviceProfile.model;
            }
            if ((i & 2) != 0) {
                str2 = deviceProfile.androidVersion;
            }
            if ((i & 4) != 0) {
                str3 = deviceProfile.sdkInt;
            }
            if ((i & 8) != 0) {
                str4 = deviceProfile.buildPrefix;
            }
            return deviceProfile.copy(str, str2, str3, str4);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getModel() {
            return this.model;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getAndroidVersion() {
            return this.androidVersion;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSdkInt() {
            return this.sdkInt;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getBuildPrefix() {
            return this.buildPrefix;
        }

        @NotNull
        public final DeviceProfile copy(@NotNull String model, @NotNull String androidVersion, @NotNull String sdkInt, @NotNull String buildPrefix) {
            return new DeviceProfile(model, androidVersion, sdkInt, buildPrefix);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeviceProfile)) {
                return false;
            }
            DeviceProfile deviceProfile = (DeviceProfile) other;
            return Intrinsics.areEqual(this.model, deviceProfile.model) && Intrinsics.areEqual(this.androidVersion, deviceProfile.androidVersion) && Intrinsics.areEqual(this.sdkInt, deviceProfile.sdkInt) && Intrinsics.areEqual(this.buildPrefix, deviceProfile.buildPrefix);
        }

        public int hashCode() {
            return (((((this.model.hashCode() * 31) + this.androidVersion.hashCode()) * 31) + this.sdkInt.hashCode()) * 31) + this.buildPrefix.hashCode();
        }

        @NotNull
        public String toString() {
            return "DeviceProfile(model=" + this.model + ", androidVersion=" + this.androidVersion + ", sdkInt=" + this.sdkInt + ", buildPrefix=" + this.buildPrefix + ')';
        }

        public DeviceProfile(@NotNull String model, @NotNull String androidVersion, @NotNull String sdkInt, @NotNull String buildPrefix) {
            this.model = model;
            this.androidVersion = androidVersion;
            this.sdkInt = sdkInt;
            this.buildPrefix = buildPrefix;
        }

        @NotNull
        public final String getModel() {
            return this.model;
        }

        @NotNull
        public final String getAndroidVersion() {
            return this.androidVersion;
        }

        @NotNull
        public final String getSdkInt() {
            return this.sdkInt;
        }

        @NotNull
        public final String getBuildPrefix() {
            return this.buildPrefix;
        }
    }

    public static /* synthetic */ Object ensureConfig$default(IStreamFlareConfig iStreamFlareConfig, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return iStreamFlareConfig.ensureConfig(z, continuation);
    }

    @Nullable
    public final Object ensureConfig(boolean force, @NotNull Continuation<? super Unit> continuation) {
        return fetchOnce(force, continuation);
    }

    public static /* synthetic */ Object fetchOnce$default(IStreamFlareConfig iStreamFlareConfig, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return iStreamFlareConfig.fetchOnce(z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0087 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0088  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00b9: INVOKE 
      (r6v0 ?? I:kotlinx.coroutines.sync.Mutex A[D('$this$withLock_u24default$iv' kotlinx.coroutines.sync.Mutex)])
      (r5 I:java.lang.Object A[D('owner$iv' java.lang.Object)])
     INTERFACE call: kotlinx.coroutines.sync.Mutex.unlock(java.lang.Object):void, block:B:48:0x00b9 */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00b9: INVOKE 
      (r6 I:kotlinx.coroutines.sync.Mutex A[D('$this$withLock_u24default$iv' kotlinx.coroutines.sync.Mutex)])
      (r5 I:java.lang.Object A[D('owner$iv' java.lang.Object)])
     INTERFACE call: kotlinx.coroutines.sync.Mutex.unlock(java.lang.Object):void, block:B:48:0x00b9 */
    @Nullable
    public final Object fetchOnce(boolean force, @NotNull Continuation<? super Unit> continuation) {
        C00101 c00101;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        Object owner$iv2;
        Mutex $this$withLock_u24default$iv2;
        IStreamFlareConfig iStreamFlareConfig;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = new C00101(continuation);
            }
        } else {
            c00101 = new C00101(continuation);
        }
        Object $result = c00101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00101.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (isFetched && !force) {
                        return Unit.INSTANCE;
                    }
                    Mutex $this$withLock_u24default$iv3 = mutex;
                    owner$iv2 = null;
                    c00101.L$0 = $this$withLock_u24default$iv3;
                    c00101.Z$0 = force;
                    c00101.label = 1;
                    if ($this$withLock_u24default$iv3.lock((Object) null, c00101) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv3;
                    if (!isFetched && !force) {
                        Unit unit = Unit.INSTANCE;
                        $this$withLock_u24default$iv2.unlock(owner$iv2);
                        return unit;
                    }
                    try {
                        iStreamFlareConfig = INSTANCE;
                        c00101.L$0 = $this$withLock_u24default$iv2;
                        c00101.Z$0 = force;
                        c00101.label = 2;
                        if (iStreamFlareConfig.fetchRemoteConfig(c00101) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        isFetched = true;
                        Unit unit2 = Unit.INSTANCE;
                        $this$withLock_u24default$iv2.unlock(owner$iv2);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        e = th;
                        Log.INSTANCE.e(TAG, "Failed to fetch Firebase Remote Config: " + e.getMessage());
                    }
                    break;
                case 1:
                    force = c00101.Z$0;
                    owner$iv2 = null;
                    $this$withLock_u24default$iv2 = (Mutex) c00101.L$0;
                    ResultKt.throwOnFailure($result);
                    if (!isFetched) {
                    }
                    iStreamFlareConfig = INSTANCE;
                    c00101.L$0 = $this$withLock_u24default$iv2;
                    c00101.Z$0 = force;
                    c00101.label = 2;
                    if (iStreamFlareConfig.fetchRemoteConfig(c00101) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isFetched = true;
                    Unit unit3 = Unit.INSTANCE;
                    $this$withLock_u24default$iv2.unlock(owner$iv2);
                    return Unit.INSTANCE;
                case 2:
                    boolean force2 = c00101.Z$0;
                    owner$iv2 = null;
                    $this$withLock_u24default$iv2 = (Mutex) c00101.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        isFetched = true;
                        break;
                    } catch (Throwable th2) {
                        e = th2;
                        Log.INSTANCE.e(TAG, "Failed to fetch Firebase Remote Config: " + e.getMessage());
                    }
                    Unit unit4 = Unit.INSTANCE;
                    $this$withLock_u24default$iv2.unlock(owner$iv2);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th3) {
            $this$withLock_u24default$iv.unlock(owner$iv);
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0136  */
    /* JADX WARN: Code duplicated, block: B:24:0x0139  */
    /* JADX WARN: Code duplicated, block: B:28:0x0151  */
    /* JADX WARN: Code duplicated, block: B:30:0x0154  */
    /* JADX WARN: Code duplicated, block: B:34:0x016c  */
    /* JADX WARN: Code duplicated, block: B:36:0x016f  */
    /* JADX WARN: Code duplicated, block: B:39:0x02e7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object fetchRemoteConfig(Continuation<? super Unit> continuation) {
        C00111 c00111;
        char c;
        boolean z;
        String language;
        String tz;
        int i;
        Object obj;
        Object obj2;
        Object obj3;
        Object objDecodeFromString;
        boolean z2;
        String fetchedServerUrl;
        String str;
        JsonNode jsonNode;
        JsonNode jsonNode2;
        String strAsText;
        if (continuation instanceof C00111) {
            c00111 = (C00111) continuation;
            if ((c00111.label & Integer.MIN_VALUE) != 0) {
                c00111.label -= Integer.MIN_VALUE;
            } else {
                c00111 = new C00111(continuation);
            }
        } else {
            c00111 = new C00111(continuation);
        }
        C00111 c00112 = c00111;
        Object $result = c00112.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00112.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DeviceProfile profile = (DeviceProfile) CollectionsKt.random(DEVICE_PROFILES, Random.Default);
                String buildId = profile.getBuildPrefix() + '.' + Random.Default.nextInt(100000, 999999) + '.' + Random.Default.nextInt(10, 99);
                String dalvikUa = "Dalvik/2.1.0 (Linux; U; Android " + profile.getAndroidVersion() + "; " + profile.getModel() + " Build/" + buildId + ')';
                String instanceId = "euB" + StringsKt.take(StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, (Object) null), 19);
                String it = Locale.getDefault().getCountry();
                if (!StringsKt.isBlank(it)) {
                    c = 0;
                    z = it.length() == 2;
                    if (!z) {
                        it = null;
                    }
                    if (it == null) {
                        it = "US";
                    }
                    String country = it;
                    language = Locale.getDefault().toLanguageTag();
                    if (StringsKt.isBlank(language)) {
                        language = null;
                    }
                    if (language == null) {
                        language = "en-US";
                    }
                    tz = TimeZone.getDefault().getID();
                    if (StringsKt.isBlank(tz)) {
                        tz = null;
                    }
                    if (tz == null) {
                        tz = "Asia/Calcutta";
                    }
                    AppUtils appUtils = AppUtils.INSTANCE;
                    Pair[] pairArr = new Pair[11];
                    pairArr[c] = TuplesKt.to("appInstanceId", instanceId);
                    pairArr[1] = TuplesKt.to("appVersion", "23.0.0");
                    pairArr[2] = TuplesKt.to("countryCode", country);
                    pairArr[3] = TuplesKt.to("analyticsUserProperties", MapsKt.emptyMap());
                    pairArr[4] = TuplesKt.to("appId", FIREBASE_APP_ID);
                    pairArr[5] = TuplesKt.to("platformVersion", profile.getSdkInt());
                    pairArr[6] = TuplesKt.to("timeZone", tz);
                    pairArr[7] = TuplesKt.to("sdkVersion", "20.0.3");
                    pairArr[8] = TuplesKt.to("packageName", PACKAGE_NAME);
                    pairArr[9] = TuplesKt.to("appInstanceIdToken", AUTH_TOKEN);
                    pairArr[10] = TuplesKt.to("languageCode", language);
                    String fetchBody = appUtils.toJson(MapsKt.mapOf(pairArr));
                    Requests app = MainActivityKt.getApp();
                    Pair[] pairArr2 = new Pair[7];
                    pairArr2[c] = TuplesKt.to("User-Agent", dalvikUa);
                    pairArr2[1] = TuplesKt.to("X-Android-Cert", ANDROID_CERT);
                    pairArr2[2] = TuplesKt.to("X-Android-Package", PACKAGE_NAME);
                    pairArr2[3] = TuplesKt.to("X-Goog-Api-Key", FIREBASE_API_KEY);
                    pairArr2[4] = TuplesKt.to("X-Goog-Firebase-Installations-Auth", AUTH_TOKEN);
                    pairArr2[5] = TuplesKt.to("X-Google-GFE-Can-Retry", "yes");
                    pairArr2[6] = TuplesKt.to("Content-Type", "application/json");
                    Map mapMapOf = MapsKt.mapOf(pairArr2);
                    RequestBody requestBodyCreate = RequestBody.Companion.create(fetchBody, MediaType.Companion.get("application/json"));
                    c00112.L$0 = SpillingKt.nullOutSpilledVariable(profile);
                    c00112.L$1 = SpillingKt.nullOutSpilledVariable(buildId);
                    c00112.L$2 = SpillingKt.nullOutSpilledVariable(dalvikUa);
                    c00112.L$3 = SpillingKt.nullOutSpilledVariable(instanceId);
                    c00112.L$4 = SpillingKt.nullOutSpilledVariable(country);
                    c00112.L$5 = SpillingKt.nullOutSpilledVariable(language);
                    c00112.L$6 = SpillingKt.nullOutSpilledVariable(tz);
                    c00112.L$7 = SpillingKt.nullOutSpilledVariable(fetchBody);
                    c00112.label = 1;
                    i = 2;
                    $result = Requests.post$default(app, REMOTE_CONFIG_URL, mapMapOf, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00112, 65276, (Object) null);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    c = 0;
                }
                if (!z) {
                    it = null;
                }
                if (it == null) {
                    it = "US";
                }
                String country2 = it;
                language = Locale.getDefault().toLanguageTag();
                if (StringsKt.isBlank(language)) {
                    language = null;
                }
                if (language == null) {
                    language = "en-US";
                }
                tz = TimeZone.getDefault().getID();
                if (StringsKt.isBlank(tz)) {
                    tz = null;
                }
                if (tz == null) {
                    tz = "Asia/Calcutta";
                }
                AppUtils appUtils2 = AppUtils.INSTANCE;
                Pair[] pairArr3 = new Pair[11];
                pairArr3[c] = TuplesKt.to("appInstanceId", instanceId);
                pairArr3[1] = TuplesKt.to("appVersion", "23.0.0");
                pairArr3[2] = TuplesKt.to("countryCode", country2);
                pairArr3[3] = TuplesKt.to("analyticsUserProperties", MapsKt.emptyMap());
                pairArr3[4] = TuplesKt.to("appId", FIREBASE_APP_ID);
                pairArr3[5] = TuplesKt.to("platformVersion", profile.getSdkInt());
                pairArr3[6] = TuplesKt.to("timeZone", tz);
                pairArr3[7] = TuplesKt.to("sdkVersion", "20.0.3");
                pairArr3[8] = TuplesKt.to("packageName", PACKAGE_NAME);
                pairArr3[9] = TuplesKt.to("appInstanceIdToken", AUTH_TOKEN);
                pairArr3[10] = TuplesKt.to("languageCode", language);
                String fetchBody2 = appUtils2.toJson(MapsKt.mapOf(pairArr3));
                Requests app2 = MainActivityKt.getApp();
                Pair[] pairArr4 = new Pair[7];
                pairArr4[c] = TuplesKt.to("User-Agent", dalvikUa);
                pairArr4[1] = TuplesKt.to("X-Android-Cert", ANDROID_CERT);
                pairArr4[2] = TuplesKt.to("X-Android-Package", PACKAGE_NAME);
                pairArr4[3] = TuplesKt.to("X-Goog-Api-Key", FIREBASE_API_KEY);
                pairArr4[4] = TuplesKt.to("X-Goog-Firebase-Installations-Auth", AUTH_TOKEN);
                pairArr4[5] = TuplesKt.to("X-Google-GFE-Can-Retry", "yes");
                pairArr4[6] = TuplesKt.to("Content-Type", "application/json");
                Map mapMapOf2 = MapsKt.mapOf(pairArr4);
                RequestBody requestBodyCreate2 = RequestBody.Companion.create(fetchBody2, MediaType.Companion.get("application/json"));
                c00112.L$0 = SpillingKt.nullOutSpilledVariable(profile);
                c00112.L$1 = SpillingKt.nullOutSpilledVariable(buildId);
                c00112.L$2 = SpillingKt.nullOutSpilledVariable(dalvikUa);
                c00112.L$3 = SpillingKt.nullOutSpilledVariable(instanceId);
                c00112.L$4 = SpillingKt.nullOutSpilledVariable(country2);
                c00112.L$5 = SpillingKt.nullOutSpilledVariable(language);
                c00112.L$6 = SpillingKt.nullOutSpilledVariable(tz);
                c00112.L$7 = SpillingKt.nullOutSpilledVariable(fetchBody2);
                c00112.label = 1;
                i = 2;
                $result = Requests.post$default(app2, REMOTE_CONFIG_URL, mapMapOf2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00112, 65276, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                i = 2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String value$iv = ((NiceResponse) $result).getText();
        AppUtils appUtils3 = AppUtils.INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            KType kTypeTypeOf = Reflection.typeOf(JsonNode.class);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) == null) {
            obj3 = obj;
        } else {
            try {
                Result.Companion companion3 = Result.Companion;
                try {
                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(JsonNode.class), (List) null, i, (Object) null));
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion4 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                }
            } catch (Throwable th3) {
                th = th3;
            }
            obj3 = obj2;
        }
        if (Result.isFailure-impl(obj3)) {
            obj3 = null;
        }
        DeserializationStrategy deserializationStrategy = (KSerializer) obj3;
        if (deserializationStrategy != null) {
            try {
                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
            } catch (SerializationException e) {
                ArchComponentExtKt.logError(e);
                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv.readValue(value$iv, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlareConfig$fetchRemoteConfig$$inlined$parseJson$1
                });
            } catch (Throwable th4) {
                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv2.readValue(value$iv, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlareConfig$fetchRemoteConfig$$inlined$parseJson$1
                });
            }
        } else {
            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
            objDecodeFromString = $this$readValue$iv$iv3.readValue(value$iv, new TypeReference<JsonNode>() { // from class: com.IStreamFlare.IStreamFlareConfig$fetchRemoteConfig$$inlined$parseJson$1
            });
        }
        JsonNode fetchNode = (JsonNode) objDecodeFromString;
        JsonNode entries = fetchNode.get("entries");
        if (entries == null || (jsonNode2 = entries.get("SERVER_URL")) == null || (strAsText = jsonNode2.asText()) == null) {
            z2 = false;
            fetchedServerUrl = null;
        } else {
            z2 = false;
            fetchedServerUrl = StringsKt.trimEnd(strAsText, new char[]{'/'});
        }
        String str2 = fetchedServerUrl;
        if (str2 == null || StringsKt.isBlank(str2)) {
            str = null;
        } else {
            str = null;
            if (StringsKt.startsWith$default(fetchedServerUrl, "http", z2, i, (Object) null)) {
                serverUrl = fetchedServerUrl;
                Log.INSTANCE.d(TAG, "Updated serverUrl to: " + serverUrl);
            }
        }
        String fetchedApiKey = (entries == null || (jsonNode = entries.get("API_KEY")) == null) ? str : jsonNode.asText();
        String str3 = fetchedApiKey;
        if (!(str3 == null || StringsKt.isBlank(str3))) {
            apiKey = fetchedApiKey;
        }
        return Unit.INSTANCE;
    }
}
