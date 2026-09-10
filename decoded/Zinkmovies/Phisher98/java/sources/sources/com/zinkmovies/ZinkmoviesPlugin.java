package com.zinkmovies;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.CloudStreamApp;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.extractors.StreamTape;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ZinkmoviesPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Zinkmovies/Phisher98/java/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016Ê\u0001\u0002\b\b¨\u0006\u0007"}, d2 = {"Lcom/zinkmovies/ZinkmoviesPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "Companion", "Zinkmovies", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class ZinkmoviesPlugin extends Plugin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";

    @Nullable
    private static Companion.Domains cachedDomains;

    public void load() {
        registerMainAPI(new Zinkmovies());
        registerExtractorAPI((ExtractorApi) new StreamTape());
        registerExtractorAPI(new HubCloud());
        registerExtractorAPI(new Hubdrive());
        registerExtractorAPI(new HUBCDN());
        registerExtractorAPI((ExtractorApi) new PixelDrainDev());
        registerExtractorAPI(new Hubcloudone());
        registerExtractorAPI(new TpiLi());
        setOpenSettings(new Function1() { // from class: com.zinkmovies.ZinkmoviesPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return ZinkmoviesPlugin.load$lambda$0(this.f$0, (Context) obj);
            }
        });
    }

    static final Unit load$lambda$0(ZinkmoviesPlugin this$0, Context ctx) {
        Intrinsics.checkNotNull(ctx, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity activity = (AppCompatActivity) ctx;
        ZinkmoviesSettingsFragment frag = new ZinkmoviesSettingsFragment(this$0);
        frag.show(activity.getSupportFragmentManager(), "zinkmovies_settings");
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: ZinkmoviesPlugin.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001!B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R$\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/zinkmovies/ZinkmoviesPlugin$Companion;", "", "<init>", "()V", "DOMAINS_URL", "", "cachedDomains", "Lcom/zinkmovies/ZinkmoviesPlugin$Companion$Domains;", "getCachedDomains", "()Lcom/zinkmovies/ZinkmoviesPlugin$Companion$Domains;", "setCachedDomains", "(Lcom/zinkmovies/ZinkmoviesPlugin$Companion$Domains;)V", "getDomains", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "cfCookies", "getCfCookies", "()Ljava/lang/String;", "setCfCookies", "(Ljava/lang/String;)V", "cfUserAgent", "getCfUserAgent", "setCfUserAgent", "cfCookieHost", "getCfCookieHost", "setCfCookieHost", "cfWebviewEnabled", "getCfWebviewEnabled", "()Z", "setCfWebviewEnabled", "(Z)V", "Domains", "Zinkmovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nZinkmoviesPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZinkmoviesPlugin.kt\ncom/zinkmovies/ZinkmoviesPlugin$Companion\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 CloudStreamApp.kt\ncom/lagradost/cloudstream3/CloudStreamApp$Companion\n+ 4 DataStore.kt\ncom/lagradost/cloudstream3/utils/DataStore\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 7 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,80:1\n73#2,5:81\n144#3:86\n144#3:112\n144#3:138\n144#3:164\n231#4:87\n222#4,3:88\n225#4,2:110\n231#4:113\n222#4,3:114\n225#4,2:136\n231#4:139\n222#4,3:140\n225#4,2:162\n231#4:165\n222#4,3:166\n225#4,2:188\n63#5:91\n64#5,15:93\n63#5:117\n64#5,15:119\n63#5:143\n64#5,15:145\n63#5:169\n64#5,15:171\n1#6:92\n1#6:118\n1#6:144\n1#6:170\n50#7:108\n43#7:109\n50#7:134\n43#7:135\n50#7:160\n43#7:161\n50#7:186\n43#7:187\n*S KotlinDebug\n*F\n+ 1 ZinkmoviesPlugin.kt\ncom/zinkmovies/ZinkmoviesPlugin$Companion\n*L\n38#1:81,5\n54#1:86\n61#1:112\n68#1:138\n75#1:164\n54#1:87\n54#1:88,3\n54#1:110,2\n61#1:113\n61#1:114,3\n61#1:136,2\n68#1:139\n68#1:140,3\n68#1:162,2\n75#1:165\n75#1:166,3\n75#1:188,2\n54#1:91\n54#1:93,15\n61#1:117\n61#1:119,15\n68#1:143\n68#1:145,15\n75#1:169\n75#1:171,15\n54#1:92\n61#1:118\n68#1:144\n75#1:170\n54#1:108\n54#1:109\n61#1:134\n61#1:135\n68#1:160\n68#1:161\n75#1:186\n75#1:187\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Domains getCachedDomains() {
            return ZinkmoviesPlugin.cachedDomains;
        }

        public final void setCachedDomains(@Nullable Domains domains) {
            ZinkmoviesPlugin.cachedDomains = domains;
        }

        public static /* synthetic */ Object getDomains$default(Companion companion, boolean z, Continuation continuation, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.getDomains(z, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x001a  */
        @Nullable
        public final Object getDomains(boolean forceRefresh, @NotNull Continuation<? super Domains> continuation) {
            ZinkmoviesPlugin$Companion$getDomains$1 zinkmoviesPlugin$Companion$getDomains$1;
            Companion companion;
            Object safe;
            if (continuation instanceof ZinkmoviesPlugin$Companion$getDomains$1) {
                zinkmoviesPlugin$Companion$getDomains$1 = (ZinkmoviesPlugin$Companion$getDomains$1) continuation;
                if ((zinkmoviesPlugin$Companion$getDomains$1.label & Integer.MIN_VALUE) != 0) {
                    zinkmoviesPlugin$Companion$getDomains$1.label -= Integer.MIN_VALUE;
                } else {
                    zinkmoviesPlugin$Companion$getDomains$1 = new ZinkmoviesPlugin$Companion$getDomains$1(this, continuation);
                }
            } else {
                zinkmoviesPlugin$Companion$getDomains$1 = new ZinkmoviesPlugin$Companion$getDomains$1(this, continuation);
            }
            ZinkmoviesPlugin$Companion$getDomains$1 zinkmoviesPlugin$Companion$getDomains$2 = zinkmoviesPlugin$Companion$getDomains$1;
            Object $result = zinkmoviesPlugin$Companion$getDomains$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (zinkmoviesPlugin$Companion$getDomains$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (getCachedDomains() == null || forceRefresh) {
                        try {
                            Requests app = MainActivityKt.getApp();
                            try {
                                zinkmoviesPlugin$Companion$getDomains$2.L$0 = this;
                                zinkmoviesPlugin$Companion$getDomains$2.Z$0 = forceRefresh;
                                zinkmoviesPlugin$Companion$getDomains$2.label = 1;
                                try {
                                    $result = Requests.get$default(app, ZinkmoviesPlugin.DOMAINS_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, zinkmoviesPlugin$Companion$getDomains$2, 4094, (Object) null);
                                    if ($result == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    companion = this;
                                    try {
                                        NiceResponse this_$iv = (NiceResponse) $result;
                                        try {
                                            ResponseParser parser = this_$iv.getParser();
                                            Intrinsics.checkNotNull(parser);
                                            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Domains.class));
                                        } catch (Exception e$iv) {
                                            e$iv.printStackTrace();
                                            safe = null;
                                        }
                                        companion.setCachedDomains((Domains) safe);
                                    } catch (Exception e) {
                                        e = e;
                                        e.printStackTrace();
                                        return null;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    return null;
                                }
                            } catch (Exception e3) {
                                e = e3;
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                        break;
                    }
                    return getCachedDomains();
                case 1:
                    boolean z = zinkmoviesPlugin$Companion$getDomains$2.Z$0;
                    Companion companion2 = (Companion) zinkmoviesPlugin$Companion$getDomains$2.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        companion = companion2;
                        NiceResponse this_$iv2 = (NiceResponse) $result;
                        ResponseParser parser2 = this_$iv2.getParser();
                        Intrinsics.checkNotNull(parser2);
                        safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Domains.class));
                        companion.setCachedDomains((Domains) safe);
                        return getCachedDomains();
                    } catch (Exception e5) {
                        e = e5;
                        e.printStackTrace();
                        return null;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: ZinkmoviesPlugin.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/zinkmovies/ZinkmoviesPlugin$Companion$Domains;", "", "hubcloud", "", "zinkmovies", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getHubcloud", "()Ljava/lang/String;", "getZinkmovies", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Zinkmovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Domains {

            @Nullable
            private final String hubcloud;

            @Nullable
            private final String zinkmovies;

            /* JADX WARN: Illegal instructions before constructor call */
            public Domains() {
                String str = null;
                this(str, str, 3, str);
            }

            public static /* synthetic */ Domains copy$default(Domains domains, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = domains.hubcloud;
                }
                if ((i & 2) != 0) {
                    str2 = domains.zinkmovies;
                }
                return domains.copy(str, str2);
            }

            @Nullable
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getHubcloud() {
                return this.hubcloud;
            }

            @Nullable
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getZinkmovies() {
                return this.zinkmovies;
            }

            @NotNull
            public final Domains copy(@Nullable String hubcloud, @Nullable String zinkmovies) {
                return new Domains(hubcloud, zinkmovies);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Domains)) {
                    return false;
                }
                Domains domains = (Domains) other;
                return Intrinsics.areEqual(this.hubcloud, domains.hubcloud) && Intrinsics.areEqual(this.zinkmovies, domains.zinkmovies);
            }

            public int hashCode() {
                return ((this.hubcloud == null ? 0 : this.hubcloud.hashCode()) * 31) + (this.zinkmovies != null ? this.zinkmovies.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "Domains(hubcloud=" + this.hubcloud + ", zinkmovies=" + this.zinkmovies + ')';
            }

            public Domains(@Nullable String hubcloud, @Nullable String zinkmovies) {
                this.hubcloud = hubcloud;
                this.zinkmovies = zinkmovies;
            }

            public /* synthetic */ Domains(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
            }

            @Nullable
            public final String getHubcloud() {
                return this.hubcloud;
            }

            @Nullable
            public final String getZinkmovies() {
                return this.zinkmovies;
            }
        }

        @NotNull
        public final String getCfCookies() {
            Object objDecodeFromString;
            Object obj;
            String path$iv;
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context = this_$iv.getContext();
            if (context != null) {
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ZINKMOVIES_CF_COOKIES", null);
                    if (string == null) {
                        objDecodeFromString = null;
                    } else {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(String.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            path$iv = null;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                try {
                                    path$iv = null;
                                    try {
                                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(String.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            Result.Companion companion4 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        } catch (Exception e) {
                                            objDecodeFromString = null;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    path$iv = null;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                path$iv = null;
                            }
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = path$iv;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, string);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.zinkmovies.ZinkmoviesPlugin$Companion$special$$inlined$getKey$1
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.zinkmovies.ZinkmoviesPlugin$Companion$special$$inlined$getKey$1
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.zinkmovies.ZinkmoviesPlugin$Companion$special$$inlined$getKey$1
                            });
                        }
                    }
                } catch (Exception e3) {
                }
            } else {
                objDecodeFromString = null;
            }
            String str = (String) objDecodeFromString;
            return str == null ? "" : str;
        }

        public final void setCfCookies(@NotNull String value) {
            CloudStreamApp.Companion.setKey("ZINKMOVIES_CF_COOKIES", value);
        }

        @NotNull
        public final String getCfUserAgent() {
            Object objDecodeFromString;
            Object obj;
            String path$iv;
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context = this_$iv.getContext();
            if (context != null) {
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ZINKMOVIES_CF_USER_AGENT", null);
                    if (string == null) {
                        objDecodeFromString = null;
                    } else {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(String.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            path$iv = null;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                try {
                                    path$iv = null;
                                    try {
                                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(String.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            Result.Companion companion4 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        } catch (Exception e) {
                                            objDecodeFromString = null;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    path$iv = null;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                path$iv = null;
                            }
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = path$iv;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, string);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.zinkmovies.ZinkmoviesPlugin$Companion$special$$inlined$getKey$2
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.zinkmovies.ZinkmoviesPlugin$Companion$special$$inlined$getKey$2
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.zinkmovies.ZinkmoviesPlugin$Companion$special$$inlined$getKey$2
                            });
                        }
                    }
                } catch (Exception e3) {
                }
            } else {
                objDecodeFromString = null;
            }
            String str = (String) objDecodeFromString;
            return str == null ? "" : str;
        }

        public final void setCfUserAgent(@NotNull String value) {
            CloudStreamApp.Companion.setKey("ZINKMOVIES_CF_USER_AGENT", value);
        }

        @NotNull
        public final String getCfCookieHost() {
            Object objDecodeFromString;
            Object obj;
            String path$iv;
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context = this_$iv.getContext();
            if (context != null) {
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ZINKMOVIES_CF_COOKIE_HOST", null);
                    if (string == null) {
                        objDecodeFromString = null;
                    } else {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(String.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            path$iv = null;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                try {
                                    path$iv = null;
                                    try {
                                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(String.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            Result.Companion companion4 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        } catch (Exception e) {
                                            objDecodeFromString = null;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    path$iv = null;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                path$iv = null;
                            }
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = path$iv;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, string);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.zinkmovies.ZinkmoviesPlugin$Companion$special$$inlined$getKey$3
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.zinkmovies.ZinkmoviesPlugin$Companion$special$$inlined$getKey$3
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<String>() { // from class: com.zinkmovies.ZinkmoviesPlugin$Companion$special$$inlined$getKey$3
                            });
                        }
                    }
                } catch (Exception e3) {
                }
            } else {
                objDecodeFromString = null;
            }
            String str = (String) objDecodeFromString;
            return str == null ? "" : str;
        }

        public final void setCfCookieHost(@NotNull String value) {
            CloudStreamApp.Companion.setKey("ZINKMOVIES_CF_COOKIE_HOST", value);
        }

        public final boolean getCfWebviewEnabled() {
            Object objDecodeFromString;
            Object obj;
            String path$iv;
            CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
            Context context = this_$iv.getContext();
            if (context != null) {
                try {
                    String string = DataStore.INSTANCE.getSharedPrefs(context).getString("ZINKMOVIES_CF_WEBVIEW_ENABLED", null);
                    if (string == null) {
                        objDecodeFromString = null;
                    } else {
                        AppUtils appUtils = AppUtils.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(Boolean.TYPE);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            path$iv = null;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                try {
                                    path$iv = null;
                                    try {
                                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Boolean.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            Result.Companion companion4 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        } catch (Exception e) {
                                            objDecodeFromString = null;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    path$iv = null;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                path$iv = null;
                            }
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = path$iv;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, string);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.zinkmovies.ZinkmoviesPlugin$Companion$special$$inlined$getKey$4
                                });
                            } catch (Throwable th5) {
                                objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.zinkmovies.ZinkmoviesPlugin$Companion$special$$inlined$getKey$4
                                });
                            }
                        } else {
                            objDecodeFromString = MainAPIKt.getMapper().readValue(string, new TypeReference<Boolean>() { // from class: com.zinkmovies.ZinkmoviesPlugin$Companion$special$$inlined$getKey$4
                            });
                        }
                    }
                } catch (Exception e3) {
                }
            } else {
                objDecodeFromString = null;
            }
            Boolean bool = (Boolean) objDecodeFromString;
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }

        public final void setCfWebviewEnabled(boolean value) {
            CloudStreamApp.Companion.setKey("ZINKMOVIES_CF_WEBVIEW_ENABLED", Boolean.valueOf(value));
        }
    }
}
