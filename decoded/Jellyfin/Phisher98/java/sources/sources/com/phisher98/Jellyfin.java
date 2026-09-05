package com.phisher98;

import android.content.SharedPreferences;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;
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

/* JADX INFO: compiled from: Jellyfin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Jellyfin/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\"\u001a\u00020\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010$\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010%JL\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u001f2\"\u0010*\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0,\u0012\u0006\u0012\u0004\u0018\u00010-0+H\u0082@¢\u0006\u0002\u0010.J.\u0010/\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0082@¢\u0006\u0002\u00100J\u001e\u00104\u001a\u0002062\u0006\u00107\u001a\u00020!2\u0006\u00108\u001a\u000209H\u0096@¢\u0006\u0002\u0010:J*\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010>\u001a\u0004\u0018\u00010\u00072\u0006\u0010?\u001a\u00020\u0007H\u0002J\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020<022\u0006\u0010A\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010BJ\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020<022\u0006\u0010A\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010BJ\u0018\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010\u0019\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010BJF\u0010F\u001a\u00020\r2\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\r2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L0J2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020L0JH\u0096@¢\u0006\u0002\u0010OJ\u001e\u0010P\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010QJ\u0016\u0010R\u001a\u0004\u0018\u00010\u0007*\u00020S2\u0006\u0010T\u001a\u00020\u0007H\u0002JJ\u0010U\u001a\u0004\u0018\u0001H'\"\u0004\b\u0000\u0010'2\b\b\u0002\u0010V\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u001f2\u001e\u0010*\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H'0,\u0012\u0006\u0012\u0004\u0018\u00010-0JH\u0082@¢\u0006\u0002\u0010WR\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020302X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u0006X"}, d2 = {"Lcom/phisher98/Jellyfin;", "Lcom/lagradost/cloudstream3/MainAPI;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "hasMainPage", "", "getHasMainPage", "()Z", "instantLinkLoading", "getInstantLinkLoading", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "url", "username", "password", "cachedAuth", "Lcom/phisher98/Authparser;", "lastAuthTime", "", "authCacheDuration", "", "buildAuthHeader", "token", "getValidAuth", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withAuthRetry", "T", "retries", "delayMillis", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(IJLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authenticateJellyfin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResponseBase", "Lcom/lagradost/cloudstream3/SearchResponse;", "id", "typeStr", "userId", "quickSearch", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPlaybackInfo", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPosterUrl", "Lcom/phisher98/EpisodeItem;", "baseUrl", "retryRequest", "times", "(IJLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nJellyfin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Jellyfin.kt\ncom/phisher98/Jellyfin\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,301:1\n73#2,5:302\n63#3:307\n64#3,15:309\n1#4:308\n1#4:326\n50#5:324\n43#5:325\n*S KotlinDebug\n*F\n+ 1 Jellyfin.kt\ncom/phisher98/Jellyfin\n*L\n89#1:302,5\n152#1:307\n152#1:309,15\n152#1:308\n152#1:324\n152#1:325\n*E\n"})
public class Jellyfin extends MainAPI {
    private final int authCacheDuration;

    @Nullable
    private Authparser cachedAuth;
    private final boolean hasMainPage;
    private final boolean hasQuickSearch;
    private final boolean instantLinkLoading;
    private long lastAuthTime;

    @NotNull
    private final List<MainPageData> mainPage;

    @NotNull
    private String name;

    @Nullable
    private final String password;

    @NotNull
    private final Set<TvType> supportedTypes;

    @Nullable
    private final String url;

    @Nullable
    private final String username;

    /* JADX INFO: renamed from: com.phisher98.Jellyfin$authenticateJellyfin$1 */
    /* JADX INFO: compiled from: Jellyfin.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Jellyfin", f = "Jellyfin.kt", i = {0, 0, 0, 0, 0, 0}, l = {89}, m = "authenticateJellyfin", n = {"username", "password", "url", "requestUrl", "headers", "jsonInput"}, nl = {302}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Jellyfin.this.authenticateJellyfin(null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Jellyfin$getValidAuth$1 */
    /* JADX INFO: compiled from: Jellyfin.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Jellyfin", f = "Jellyfin.kt", i = {0}, l = {49}, m = "getValidAuth", n = {"currentTime"}, nl = {50}, s = {"J$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Jellyfin.this.getValidAuth((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Jellyfin$retryRequest$1 */
    /* JADX INFO: compiled from: Jellyfin.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Jellyfin", f = "Jellyfin.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {289, 294, 296}, m = "retryRequest", n = {"block", "times", "delayMillis", "it", "block", "times", "delayMillis", "it", "block", "times", "delayMillis"}, nl = {290, 295, 297}, s = {"L$0", "I$0", "J$0", "I$3", "L$0", "I$0", "J$0", "I$3", "L$0", "I$0", "J$0"}, v = 2)
    static final class C00061<T> extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Jellyfin.this.retryRequest(0, 0L, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Jellyfin$withAuthRetry$1 */
    /* JADX INFO: compiled from: Jellyfin.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Jellyfin", f = "Jellyfin.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {63, 63, 73, 76, 76}, m = "withAuthRetry", n = {"block", "retries", "delayMillis", "it", "block", "retries", "delayMillis", "it", "block", "e", "msg", "retries", "delayMillis", "it", "block", "retries", "delayMillis", "block", "retries", "delayMillis"}, nl = {63, 64, 75, 76, -1}, s = {"L$0", "I$0", "J$0", "I$3", "L$0", "I$0", "J$0", "I$3", "L$0", "L$1", "L$2", "I$0", "J$0", "I$3", "L$0", "I$0", "J$0", "L$0", "I$0", "J$0"}, v = 2)
    static final class C00081<T> extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Jellyfin.this.withAuthRetry(0, 0L, null, (Continuation) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Jellyfin() {
        SharedPreferences sharedPreferences = null;
        this(sharedPreferences, 1, sharedPreferences);
    }

    @Nullable
    public Object getMainPage(int i, @NotNull MainPageRequest mainPageRequest, @NotNull Continuation<? super HomePageResponse> continuation) {
        return getMainPage$suspendImpl(this, i, mainPageRequest, continuation);
    }

    @Nullable
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) {
        return load$suspendImpl(this, str, continuation);
    }

    @Nullable
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        return loadLinks$suspendImpl(this, str, z, function1, function2, continuation);
    }

    @Nullable
    public Object quickSearch(@NotNull String str, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        return search(str, continuation);
    }

    @Nullable
    public Object search(@NotNull String str, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        return search$suspendImpl(this, str, continuation);
    }

    public Jellyfin(@Nullable SharedPreferences sharedPref) {
        this.name = "Jellyfin";
        this.hasMainPage = true;
        this.instantLinkLoading = true;
        this.hasQuickSearch = true;
        this.supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime, TvType.Cartoon});
        this.url = sharedPref != null ? sharedPref.getString("url", null) : null;
        this.username = sharedPref != null ? sharedPref.getString("username", null) : null;
        this.password = sharedPref != null ? sharedPref.getString("password", null) : null;
        this.authCacheDuration = 1800000;
        this.mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("HomePage", "HomePage")});
    }

    public /* synthetic */ Jellyfin(SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : sharedPreferences);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    public boolean getInstantLinkLoading() {
        return this.instantLinkLoading;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    static /* synthetic */ String buildAuthHeader$default(Jellyfin jellyfin, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildAuthHeader");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return jellyfin.buildAuthHeader(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildAuthHeader(String token) {
        StringBuilder $this$buildAuthHeader_u24lambda_u240 = new StringBuilder();
        $this$buildAuthHeader_u24lambda_u240.append("MediaBrowser Client=\"Jellyfin Web\", Device=\"Chrome\", DeviceId=\"Example\", Version=\"10.10.7\"");
        String str = token;
        if (!(str == null || str.length() == 0)) {
            $this$buildAuthHeader_u24lambda_u240.append(", Token=\"" + token + '\"');
        }
        return $this$buildAuthHeader_u24lambda_u240.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getValidAuth(Continuation<? super Authparser> continuation) throws Exception {
        C00031 c00031;
        Object objAuthenticateJellyfin;
        long currentTime;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = new C00031(continuation);
            }
        } else {
            c00031 = new C00031(continuation);
        }
        Object $result = c00031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00031.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                long currentTime2 = System.currentTimeMillis();
                if (this.cachedAuth != null && currentTime2 - this.lastAuthTime < this.authCacheDuration) {
                    Authparser authparser = this.cachedAuth;
                    Intrinsics.checkNotNull(authparser);
                    return authparser;
                }
                String str = this.username;
                String str2 = this.password;
                String str3 = this.url;
                c00031.J$0 = currentTime2;
                c00031.label = 1;
                objAuthenticateJellyfin = authenticateJellyfin(str, str2, str3, c00031);
                if (objAuthenticateJellyfin == coroutine_suspended) {
                    return coroutine_suspended;
                }
                currentTime = currentTime2;
                break;
                break;
            case 1:
                currentTime = c00031.J$0;
                ResultKt.throwOnFailure($result);
                objAuthenticateJellyfin = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Authparser newAuth = (Authparser) objAuthenticateJellyfin;
        if (newAuth == null) {
            throw new Exception("Authentication failed. Check Jellyfin credentials.");
        }
        this.cachedAuth = newAuth;
        this.lastAuthTime = currentTime;
        return newAuth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(4:25|73|26|(1:28)(7:29|71|30|31|69|32|(1:34)(2:35|36))) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:29|71|30|31|69|32|(1:34)(2:35|36)) */
    /* JADX WARN: Code duplicated, block: B:25:0x00db  */
    /* JADX WARN: Code duplicated, block: B:28:0x00f7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:34:0x0121 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x0122  */
    /* JADX WARN: Code duplicated, block: B:45:0x0157  */
    /* JADX WARN: Code duplicated, block: B:48:0x0197  */
    /* JADX WARN: Code duplicated, block: B:56:0x01de A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x01df  */
    /* JADX WARN: Code duplicated, block: B:59:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:61:0x0216 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x0217  */
    /* JADX WARN: Code duplicated, block: B:65:0x0237 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x0238  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0129, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x012a, code lost:
    
        r4 = r8;
        r1 = r10;
        r8 = r11;
        r11 = r12;
        r13 = r14;
        r14 = r15;
        r15 = r6;
        r10 = r7;
        r6 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0135, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0136, code lost:
    
        r22 = r1;
        r4 = r8;
        r1 = r10;
        r8 = r11;
        r11 = r12;
        r13 = r14;
        r14 = r15;
        r15 = r6;
        r10 = r7;
        r6 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0143, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0144, code lost:
    
        r14 = r5;
        r5 = r10;
        r10 = r14;
        r9 = r1;
        r1 = r12;
        r18 = r3;
        r3 = r7;
        r4 = r8;
        r8 = r11;
        r11 = r18;
     */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x00c3: MOVE (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:22:0x00bf */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x00c0: MOVE (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r13 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('retries' int)]), block:B:22:0x00bf */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00bf: MOVE (r15 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$a$-repeat-Jellyfin$withAuthRetry$2' int)]), block:B:22:0x00bf */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00c4: MOVE (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('it' int)]), block:B:22:0x00bf */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x01df -> B:58:0x01ed). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object withAuthRetry(int retries, long delayMillis, Function2<? super Authparser, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Exception {
        C00081 c00081;
        Jellyfin jellyfin;
        int i;
        int i2;
        int retries2;
        int retries3;
        Continuation<? super T> continuation2;
        Jellyfin jellyfin2;
        int i3;
        int it;
        Function2<? super Authparser, ? super Continuation<? super T>, ? extends Object> function3;
        long delayMillis2;
        int i4;
        Continuation<? super T> continuation3;
        C00081 c00082;
        Object obj;
        Function2<? super Authparser, ? super Continuation<? super T>, ? extends Object> function4;
        Jellyfin jellyfin3;
        int i5;
        int retries4;
        int retries5;
        Object $result;
        Function2<? super Authparser, ? super Continuation<? super T>, ? extends Object> function5;
        Jellyfin jellyfin4;
        long delayMillis3;
        int i6;
        int i7;
        int it2;
        int i8;
        Function2<? super Authparser, ? super Continuation<? super T>, ? extends Object> function6;
        Object $result2;
        int i9;
        Object obj2;
        long delayMillis4;
        Object validAuth;
        int retries6;
        Function2<? super Authparser, ? super Continuation<? super T>, ? extends Object> function7;
        long delayMillis5;
        Function2<? super Authparser, ? super Continuation<? super T>, ? extends Object> function8;
        int it3;
        Object validAuth2;
        Object $result3;
        Continuation<? super T> continuation4 = continuation;
        if (continuation4 instanceof C00081) {
            c00081 = (C00081) continuation4;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
                jellyfin = this;
            } else {
                jellyfin = this;
                c00081 = jellyfin.new C00081(continuation4);
            }
        } else {
            jellyfin = this;
            c00081 = jellyfin.new C00081(continuation4);
        }
        C00081 c00083 = c00081;
        Object $result4 = c00083.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object obj3 = null;
        try {
            switch (c00083.label) {
                case 0:
                    ResultKt.throwOnFailure($result4);
                    i9 = retries - 1;
                    continuation2 = continuation4;
                    jellyfin2 = jellyfin;
                    c00082 = c00083;
                    $result = $result4;
                    obj2 = coroutine_suspended;
                    i6 = 0;
                    retries4 = retries;
                    delayMillis4 = delayMillis;
                    function4 = function2;
                    if (i6 < i9) {
                        c00082.L$0 = SpillingKt.nullOutSpilledVariable(function4);
                        c00082.L$1 = function4;
                        c00082.L$2 = null;
                        c00082.I$0 = retries4;
                        c00082.J$0 = delayMillis4;
                        c00082.label = 4;
                        validAuth = jellyfin2.getValidAuth(c00082);
                        if (validAuth == obj2) {
                            return obj2;
                        }
                        long j = delayMillis4;
                        $result4 = validAuth;
                        retries6 = retries4;
                        function7 = function4;
                        c00083 = c00082;
                        delayMillis5 = j;
                        function8 = function7;
                        c00083.L$0 = SpillingKt.nullOutSpilledVariable(function8);
                        c00083.L$1 = null;
                        c00083.I$0 = retries6;
                        c00083.J$0 = delayMillis5;
                        c00083.label = 5;
                        $result3 = function7.invoke($result4, c00083);
                        if ($result3 == obj2) {
                            return obj2;
                        }
                        return $result3;
                    }
                    it3 = i6;
                    i2 = 0;
                    c00082.L$0 = function4;
                    c00082.L$1 = function4;
                    c00082.L$2 = obj3;
                    c00082.I$0 = retries4;
                    c00082.J$0 = delayMillis4;
                    c00082.I$1 = i9;
                    c00082.I$2 = i6;
                    c00082.I$3 = it3;
                    c00082.label = 1;
                    validAuth2 = jellyfin2.getValidAuth(c00082);
                    if (validAuth2 == obj2) {
                        return obj2;
                    }
                    retries3 = retries4;
                    continuation4 = continuation2;
                    i8 = 0;
                    function5 = function4;
                    coroutine_suspended = obj2;
                    i7 = i9;
                    long j2 = delayMillis4;
                    $result4 = validAuth2;
                    function6 = function5;
                    c00083 = c00082;
                    it2 = it3;
                    jellyfin4 = jellyfin2;
                    delayMillis3 = j2;
                    c00083.L$0 = function5;
                    Continuation<? super T> continuation5 = continuation4;
                    c00083.L$1 = null;
                    c00083.I$0 = retries3;
                    c00083.J$0 = delayMillis3;
                    c00083.I$1 = i7;
                    c00083.I$2 = i6;
                    c00083.I$3 = it2;
                    c00083.label = 2;
                    $result2 = function6.invoke($result4, c00083);
                    if ($result2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return $result2;
                case 1:
                    i8 = 0;
                    it2 = c00083.I$3;
                    int i10 = c00083.I$2;
                    i7 = c00083.I$1;
                    long delayMillis6 = c00083.J$0;
                    int retries7 = c00083.I$0;
                    function6 = (Function2) c00083.L$1;
                    Function2<? super Authparser, ? super Continuation<? super T>, ? extends Object> function9 = (Function2) c00083.L$0;
                    ResultKt.throwOnFailure($result4);
                    retries3 = retries7;
                    function5 = function9;
                    jellyfin4 = jellyfin;
                    delayMillis3 = delayMillis6;
                    i6 = i10;
                    $result = $result4;
                    c00083.L$0 = function5;
                    Continuation<? super T> continuation6 = continuation4;
                    c00083.L$1 = null;
                    c00083.I$0 = retries3;
                    c00083.J$0 = delayMillis3;
                    c00083.I$1 = i7;
                    c00083.I$2 = i6;
                    c00083.I$3 = it2;
                    c00083.label = 2;
                    $result2 = function6.invoke($result4, c00083);
                    if ($result2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return $result2;
                case 2:
                    int i11 = c00083.I$3;
                    int i12 = c00083.I$2;
                    int i13 = c00083.I$1;
                    long j3 = c00083.J$0;
                    int i14 = c00083.I$0;
                    ResultKt.throwOnFailure($result4);
                    return $result4;
                case 3:
                    int i15 = c00083.I$3;
                    int i16 = c00083.I$2;
                    int i17 = c00083.I$1;
                    long delayMillis7 = c00083.J$0;
                    int retries8 = c00083.I$0;
                    Function2<? super Authparser, ? super Continuation<? super T>, ? extends Object> function10 = (Function2) c00083.L$0;
                    ResultKt.throwOnFailure($result4);
                    c00082 = c00083;
                    obj = coroutine_suspended;
                    function4 = function10;
                    retries5 = i16;
                    $result = $result4;
                    Jellyfin jellyfin5 = jellyfin;
                    continuation3 = continuation4;
                    retries4 = retries8;
                    jellyfin3 = jellyfin5;
                    i5 = i17;
                    delayMillis2 = delayMillis7;
                    int i18 = retries5 + 1;
                    continuation2 = continuation3;
                    obj2 = obj;
                    delayMillis4 = delayMillis2;
                    i9 = i5;
                    jellyfin2 = jellyfin3;
                    obj3 = null;
                    i6 = i18;
                    if (i6 < i9) {
                        c00082.L$0 = SpillingKt.nullOutSpilledVariable(function4);
                        c00082.L$1 = function4;
                        c00082.L$2 = null;
                        c00082.I$0 = retries4;
                        c00082.J$0 = delayMillis4;
                        c00082.label = 4;
                        validAuth = jellyfin2.getValidAuth(c00082);
                        if (validAuth == obj2) {
                            return obj2;
                        }
                        long j4 = delayMillis4;
                        $result4 = validAuth;
                        retries6 = retries4;
                        function7 = function4;
                        c00083 = c00082;
                        delayMillis5 = j4;
                        function8 = function7;
                        c00083.L$0 = SpillingKt.nullOutSpilledVariable(function8);
                        c00083.L$1 = null;
                        c00083.I$0 = retries6;
                        c00083.J$0 = delayMillis5;
                        c00083.label = 5;
                        $result3 = function7.invoke($result4, c00083);
                        if ($result3 == obj2) {
                            return obj2;
                        }
                        return $result3;
                    }
                    it3 = i6;
                    i2 = 0;
                    c00082.L$0 = function4;
                    c00082.L$1 = function4;
                    c00082.L$2 = obj3;
                    c00082.I$0 = retries4;
                    c00082.J$0 = delayMillis4;
                    c00082.I$1 = i9;
                    c00082.I$2 = i6;
                    c00082.I$3 = it3;
                    c00082.label = 1;
                    validAuth2 = jellyfin2.getValidAuth(c00082);
                    if (validAuth2 == obj2) {
                        return obj2;
                    }
                    retries3 = retries4;
                    continuation4 = continuation2;
                    i8 = 0;
                    function5 = function4;
                    coroutine_suspended = obj2;
                    i7 = i9;
                    long j5 = delayMillis4;
                    $result4 = validAuth2;
                    function6 = function5;
                    c00083 = c00082;
                    it2 = it3;
                    jellyfin4 = jellyfin2;
                    delayMillis3 = j5;
                    c00083.L$0 = function5;
                    Continuation<? super T> continuation7 = continuation4;
                    c00083.L$1 = null;
                    c00083.I$0 = retries3;
                    c00083.J$0 = delayMillis3;
                    c00083.I$1 = i7;
                    c00083.I$2 = i6;
                    c00083.I$3 = it2;
                    c00083.label = 2;
                    $result2 = function6.invoke($result4, c00083);
                    if ($result2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return $result2;
                case 4:
                    long delayMillis8 = c00083.J$0;
                    retries6 = c00083.I$0;
                    Function2<? super Authparser, ? super Continuation<? super T>, ? extends Object> function11 = (Function2) c00083.L$1;
                    Function2<? super Authparser, ? super Continuation<? super T>, ? extends Object> function12 = (Function2) c00083.L$0;
                    ResultKt.throwOnFailure($result4);
                    obj2 = coroutine_suspended;
                    delayMillis5 = delayMillis8;
                    function8 = function12;
                    function7 = function11;
                    $result = $result4;
                    c00083.L$0 = SpillingKt.nullOutSpilledVariable(function8);
                    c00083.L$1 = null;
                    c00083.I$0 = retries6;
                    c00083.J$0 = delayMillis5;
                    c00083.label = 5;
                    $result3 = function7.invoke($result4, c00083);
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    return $result3;
                case 5:
                    long j6 = c00083.J$0;
                    int i19 = c00083.I$0;
                    ResultKt.throwOnFailure($result4);
                    return $result4;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
            e = e;
            i2 = i;
            retries3 = retries2;
            continuation2 = continuation4;
            jellyfin2 = jellyfin;
            int retries9 = i3;
            int it4 = it;
            String msg = e.getMessage();
            if (msg == null) {
                msg = "";
            }
            Exception e2 = e;
            Object $result5 = $result4;
            Log.INSTANCE.d("AuthRetry", "Auth attempt " + (it4 + 1) + " failed: " + msg);
            Continuation<? super T> continuation8 = continuation2;
            String msg2 = msg;
            if (StringsKt.contains$default(msg, "401", false, 2, (Object) null) && !StringsKt.contains$default(msg2, "403", false, 2, (Object) null) && !StringsKt.contains(msg2, "token", true)) {
                throw e2;
            }
            jellyfin2.cachedAuth = null;
            jellyfin2.lastAuthTime = 0L;
            c00083.L$0 = function3;
            c00083.L$1 = SpillingKt.nullOutSpilledVariable(e2);
            c00083.L$2 = SpillingKt.nullOutSpilledVariable(msg2);
            c00083.I$0 = retries3;
            c00083.J$0 = delayMillis2;
            c00083.I$1 = retries9;
            c00083.I$2 = i4;
            c00083.I$3 = it4;
            c00083.label = 3;
            if (DelayKt.delay(delayMillis2, c00083) == coroutine_suspended) {
                return coroutine_suspended;
            }
            continuation3 = continuation8;
            c00082 = c00083;
            obj = coroutine_suspended;
            function4 = function3;
            jellyfin3 = jellyfin2;
            i5 = retries9;
            retries4 = retries3;
            retries5 = i4;
            $result = $result5;
        }
    }

    static /* synthetic */ Object withAuthRetry$default(Jellyfin jellyfin, int i, long j, Function2 function2, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withAuthRetry");
        }
        if ((i2 & 1) != 0) {
            i = 3;
        }
        if ((i2 & 2) != 0) {
            j = 300;
        }
        return jellyfin.withAuthRetry(i, j, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object authenticateJellyfin(String username, String password, String url, Continuation<? super Authparser> continuation) {
        C00001 c00001;
        Object obj;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = new C00001(continuation);
            }
        } else {
            c00001 = new C00001(continuation);
        }
        C00001 c00002 = c00001;
        Object $result = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String requestUrl = url + "/Users/authenticatebyname";
                Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("Authorization", buildAuthHeader$default(this, null, 1, null)), TuplesKt.to("Content-Type", "application/json"), TuplesKt.to("User-Agent", "Mozilla/5.0")});
                String jsonInput = "{\"Username\":\"" + username + "\",\"Pw\":\"" + password + "\"}";
                Requests app = MainActivityKt.getApp();
                RequestBody requestBodyCreate$default = RequestBody.Companion.create$default(RequestBody.Companion, jsonInput, (MediaType) null, 1, (Object) null);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(username);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(password);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(url);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(requestUrl);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(jsonInput);
                c00002.label = 1;
                obj = null;
                Object objPost$default = Requests.post$default(app, requestUrl, headers, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate$default, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 65276, (Object) null);
                if (objPost$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = objPost$default;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj = null;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            return parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Authparser.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            return obj;
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    static /* synthetic */ Object getMainPage$suspendImpl(Jellyfin $this, int page, MainPageRequest request, Continuation<? super HomePageResponse> continuation) throws Exception {
        String str = $this.username;
        if (!(str == null || StringsKt.isBlank(str))) {
            String str2 = $this.password;
            if (!(str2 == null || StringsKt.isBlank(str2))) {
                String str3 = $this.url;
                if (!(str3 == null || StringsKt.isBlank(str3))) {
                    return withAuthRetry$default($this, 0, 0L, $this.new C00022(request, null), continuation, 3, null);
                }
            }
        }
        throw new Exception("Please configure the extension with a valid URL, username, and password.");
    }

    /* JADX INFO: renamed from: com.phisher98.Jellyfin$getMainPage$2 */
    /* JADX INFO: compiled from: Jellyfin.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/HomePageResponse;", "auth", "Lcom/phisher98/Authparser;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Jellyfin$getMainPage$2", f = "Jellyfin.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {104, 109}, m = "invokeSuspend", n = {"auth", "headers", "api", "auth", "headers", "api", "userViews", "$this$mapNotNull$iv", "$this$mapNotNullTo$iv$iv", "destination$iv$iv", "$this$forEach$iv$iv$iv", "element$iv$iv$iv", "element$iv$iv", "parentItem", "itemsApi"}, nl = {302, 318}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13"}, v = 2)
    @SourceDebugExtension({"SMAP\nJellyfin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Jellyfin.kt\ncom/phisher98/Jellyfin$getMainPage$2\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,301:1\n73#2,5:302\n73#2,5:318\n1795#3,10:307\n2068#3:317\n1739#3:323\n1814#3,3:324\n2069#3:328\n1805#3:329\n1#4:327\n*S KotlinDebug\n*F\n+ 1 Jellyfin.kt\ncom/phisher98/Jellyfin$getMainPage$2\n*L\n104#1:302,5\n109#1:318,5\n107#1:307,10\n107#1:317\n111#1:323\n111#1:324,3\n107#1:328\n107#1:329\n107#1:327\n*E\n"})
    static final class C00022 extends SuspendLambda implements Function2<Authparser, Continuation<? super HomePageResponse>, Object> {
        final /* synthetic */ MainPageRequest $request;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(MainPageRequest mainPageRequest, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$request = mainPageRequest;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = Jellyfin.this.new C00022(this.$request, continuation);
            c00022.L$0 = obj;
            return c00022;
        }

        public final Object invoke(Authparser authparser, Continuation<? super HomePageResponse> continuation) {
            return create(authparser, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0164  */
        /* JADX WARN: Code duplicated, block: B:26:0x0213 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x0214  */
        /* JADX WARN: Code duplicated, block: B:40:0x025b  */
        /* JADX WARN: Code duplicated, block: B:41:0x0260  */
        /* JADX WARN: Code duplicated, block: B:43:0x0263  */
        /* JADX WARN: Code duplicated, block: B:46:0x026d  */
        /* JADX WARN: Code duplicated, block: B:47:0x0275  */
        /* JADX WARN: Code duplicated, block: B:50:0x0297 A[LOOP:0: B:48:0x0291->B:50:0x0297, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:53:0x02eb  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0214 -> B:28:0x0230). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r45) {
            /*
                Method dump skipped, instruction units count: 832
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.Jellyfin.C00022.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:22:0x005e  */
    /* JADX WARN: Code duplicated, block: B:26:0x006b  */
    /* JADX WARN: Code duplicated, block: B:27:0x006f  */
    public final SearchResponse toSearchResponseBase(String id, String name, String typeStr, String userId) {
        String lowerCase;
        TvType type;
        final String poster = this.url + "/Items/" + id + "/Images/Primary";
        if (typeStr != null) {
            lowerCase = typeStr.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            switch (lowerCase) {
                case "movies":
                    type = TvType.Movie;
                    break;
                case "tvshows":
                case "series":
                    type = TvType.TvSeries;
                    break;
                case "movie":
                    type = TvType.Movie;
                    break;
                case "shows":
                    type = TvType.TvSeries;
                    break;
                default:
                    type = TvType.Movie;
                    break;
            }
        } else {
            type = TvType.Movie;
        }
        return MainAPIKt.newMovieSearchResponse$default(this, name, AppUtils.INSTANCE.toJson(new LoadData(name, poster, type, id, userId)), type, false, new Function1() { // from class: com.phisher98.Jellyfin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Jellyfin.toSearchResponseBase$lambda$0(poster, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponseBase$lambda$0(String $poster, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($poster);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.Jellyfin$search$2 */
    /* JADX INFO: compiled from: Jellyfin.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "auth", "Lcom/phisher98/Authparser;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Jellyfin$search$2", f = "Jellyfin.kt", i = {0, 0}, l = {142}, m = "invokeSuspend", n = {"auth", "headers"}, nl = {145}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nJellyfin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Jellyfin.kt\ncom/phisher98/Jellyfin$search$2\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,301:1\n73#2,5:302\n1739#3:307\n1814#3,3:308\n*S KotlinDebug\n*F\n+ 1 Jellyfin.kt\ncom/phisher98/Jellyfin$search$2\n*L\n145#1:302,5\n147#1:307\n147#1:308,3\n*E\n"})
    static final class C00072 extends SuspendLambda implements Function2<Authparser, Continuation<? super List<? extends SearchResponse>>, Object> {
        final /* synthetic */ String $query;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00072(String str, Continuation<? super C00072> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00072 = Jellyfin.this.new C00072(this.$query, continuation);
            c00072.L$0 = obj;
            return c00072;
        }

        public final Object invoke(Authparser authparser, Continuation<? super List<? extends SearchResponse>> continuation) {
            return create(authparser, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object obj;
            Object safe;
            Iterable items;
            Authparser auth = (Authparser) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "application/json"), TuplesKt.to("Authorization", Jellyfin.this.buildAuthHeader(auth.getAccessToken())), TuplesKt.to("Content-Type", "application/json")});
                    this.L$0 = auth;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(headers);
                    this.label = 1;
                    obj = Requests.get$default(MainActivityKt.getApp(), Jellyfin.this.url + "/Items?userId=" + auth.getUser().getId() + "&limit=100&recursive=true&searchTerm=" + this.$query, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            NiceResponse this_$iv = (NiceResponse) obj;
            try {
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(SearchResult.class));
            } catch (Exception e$iv) {
                e$iv.printStackTrace();
                safe = null;
            }
            SearchResult response = (SearchResult) safe;
            if (response == null || (items = response.getItems()) == null) {
                return CollectionsKt.emptyList();
            }
            Iterable $this$map$iv = items;
            Jellyfin jellyfin = Jellyfin.this;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                SearchItem it = (SearchItem) item$iv$iv;
                destination$iv$iv.add(jellyfin.toSearchResponseBase(it.getId(), it.getName(), it.getType(), auth.getUser().getId()));
                response = response;
            }
            return (List) destination$iv$iv;
        }
    }

    static /* synthetic */ Object search$suspendImpl(Jellyfin $this, String query, Continuation<? super List<? extends SearchResponse>> continuation) {
        return withAuthRetry$default($this, 0, 0L, $this.new C00072(query, null), continuation, 3, null);
    }

    static /* synthetic */ Object load$suspendImpl(Jellyfin $this, String url, Continuation<? super LoadResponse> continuation) throws Exception {
        Object obj;
        Object objDecodeFromString;
        AppUtils appUtils = AppUtils.INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            KType kTypeTypeOf = Reflection.typeOf(LoadData.class);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            try {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadData.class), (List) null, 2, (Object) null));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th2));
            }
        }
        DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj) ? null : obj);
        if (deserializationStrategy != null) {
            try {
                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, url);
            } catch (SerializationException e) {
                ArchComponentExtKt.logError(e);
                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv.readValue(url, new TypeReference<LoadData>() { // from class: com.phisher98.Jellyfin$load$suspendImpl$$inlined$parseJson$1
                });
            } catch (Throwable th3) {
                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv2.readValue(url, new TypeReference<LoadData>() { // from class: com.phisher98.Jellyfin$load$suspendImpl$$inlined$parseJson$1
                });
            }
        } else {
            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
            objDecodeFromString = $this$readValue$iv$iv3.readValue(url, new TypeReference<LoadData>() { // from class: com.phisher98.Jellyfin$load$suspendImpl$$inlined$parseJson$1
            });
        }
        LoadData loadData = (LoadData) objDecodeFromString;
        String baseUrl = $this.url;
        if (baseUrl == null) {
            throw new Exception("Jellyfin URL is not configured.");
        }
        return withAuthRetry$default($this, 0, 0L, $this.new C00042(loadData, baseUrl, url, null), continuation, 3, null);
    }

    /* JADX INFO: renamed from: com.phisher98.Jellyfin$load$2 */
    /* JADX INFO: compiled from: Jellyfin.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/LoadResponse;", "auth", "Lcom/phisher98/Authparser;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Jellyfin$load$2", f = "Jellyfin.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5}, l = {166, 169, 170, 176, 191, 202}, m = "invokeSuspend", n = {"auth", "headers", "id", "userId", "type", "movieApi", "auth", "headers", "id", "userId", "type", "movieApi", "moviefetch", "auth", "headers", "id", "userId", "type", "movieApi", "moviefetch", "parentId", "auth", "headers", "id", "userId", "type", "movieApi", "moviefetch", "parentId", "seasons", "$this$flatMap$iv", "$this$flatMapTo$iv$iv", "destination$iv$iv", "element$iv$iv", "seasonId", "auth", "headers", "id", "userId", "type", "movieApi", "moviefetch", "parentId", "seasons", "episodes", "auth", "headers", "id", "userId", "type", "movieApi", "moviefetch"}, nl = {302, 307, 171, 178, 202, 212}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$12", "L$13", "L$15", "L$16", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    @SourceDebugExtension({"SMAP\nJellyfin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Jellyfin.kt\ncom/phisher98/Jellyfin$load$2\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,301:1\n73#2,5:302\n73#2,5:307\n73#2,5:312\n73#2,5:327\n777#3:317\n873#3,2:318\n1739#3:320\n1814#3,3:321\n1544#3:324\n1633#3,2:325\n1739#3:332\n1814#3,3:333\n1635#3,3:336\n*S KotlinDebug\n*F\n+ 1 Jellyfin.kt\ncom/phisher98/Jellyfin$load$2\n*L\n166#1:302,5\n169#1:307,5\n171#1:312,5\n178#1:327,5\n172#1:317\n172#1:318,2\n173#1:320\n173#1:321,3\n175#1:324\n175#1:325,2\n180#1:332\n180#1:333,3\n175#1:336,3\n*E\n"})
    static final class C00042 extends SuspendLambda implements Function2<Authparser, Continuation<? super LoadResponse>, Object> {
        final /* synthetic */ String $baseUrl;
        final /* synthetic */ LoadData $loadData;
        final /* synthetic */ String $url;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(LoadData loadData, String str, String str2, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$loadData = loadData;
            this.$baseUrl = str;
            this.$url = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = Jellyfin.this.new C00042(this.$loadData, this.$baseUrl, this.$url, continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(Authparser authparser, Continuation<? super LoadResponse> continuation) {
            return create(authparser, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:102:0x0584  */
        /* JADX WARN: Code duplicated, block: B:65:0x0423  */
        /* JADX WARN: Code duplicated, block: B:67:0x04d4 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:68:0x04d5  */
        /* JADX WARN: Code duplicated, block: B:85:0x0514  */
        /* JADX WARN: Code duplicated, block: B:86:0x0519  */
        /* JADX WARN: Code duplicated, block: B:88:0x051c  */
        /* JADX WARN: Code duplicated, block: B:92:0x0545  */
        /* JADX WARN: Code duplicated, block: B:94:0x0560  */
        /* JADX WARN: Code duplicated, block: B:97:0x0573  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x04d5 -> B:69:0x04de). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r48) {
            /*
                Method dump skipped, instruction units count: 1750
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.Jellyfin.C00042.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2$0$0(EpisodeItem $item, int $season, Jellyfin this$0, String $baseUrl, Episode $this$newEpisode) {
            $this$newEpisode.setName($item.getName());
            $this$newEpisode.setEpisode($item.getIndexNumber());
            $this$newEpisode.setSeason(Integer.valueOf($season));
            $this$newEpisode.setPosterUrl(this$0.getPosterUrl($item, $baseUrl));
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.phisher98.Jellyfin$load$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Jellyfin.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.Jellyfin$load$2$1", f = "Jellyfin.kt", i = {0}, l = {199}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {200}, s = {"L$0"}, v = 2)
        @SourceDebugExtension({"SMAP\nJellyfin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Jellyfin.kt\ncom/phisher98/Jellyfin$load$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,301:1\n1739#2:302\n1814#2,3:303\n296#2,2:306\n296#2,2:308\n*S KotlinDebug\n*F\n+ 1 Jellyfin.kt\ncom/phisher98/Jellyfin$load$2$1\n*L\n195#1:302\n195#1:303,3\n198#1:306,2\n199#1:308,2\n*E\n"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
            final /* synthetic */ LoadData $loadData;
            final /* synthetic */ MovieMetadata $moviefetch;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(LoadData loadData, MovieMetadata movieMetadata, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$loadData = loadData;
                this.$moviefetch = movieMetadata;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$loadData, this.$moviefetch, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
                return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:50:0x00ee  */
            /* JADX WARN: Code duplicated, block: B:51:0x00f3  */
            /* JADX WARN: Code duplicated, block: B:65:0x0131  */
            public final Object invokeSuspend(Object $result) {
                ArrayList arrayList;
                String url;
                Iterable remoteTrailers;
                Object element$iv;
                RemoteTrailer remoteTrailer;
                RemoteTrailer it;
                Iterable externalUrls;
                Object element$iv2;
                ExternalUrl externalUrl;
                ExternalUrl it2;
                ProviderIds providerIds;
                ProviderIds providerIds2;
                Iterable people;
                LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        loadResponse.setPosterUrl(this.$loadData.getPosterurl());
                        MovieMetadata movieMetadata = this.$moviefetch;
                        String url2 = null;
                        loadResponse.setPlot(movieMetadata != null ? movieMetadata.getOverview() : null);
                        MovieMetadata movieMetadata2 = this.$moviefetch;
                        loadResponse.setTags(movieMetadata2 != null ? movieMetadata2.getGenres() : null);
                        LoadResponse.Companion companion = LoadResponse.Companion;
                        LoadResponse loadResponse2 = loadResponse;
                        MovieMetadata movieMetadata3 = this.$moviefetch;
                        if (movieMetadata3 == null || (people = movieMetadata3.getPeople()) == null) {
                            arrayList = null;
                        } else {
                            Iterable $this$map$iv = people;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                MovieMetadataPerson it3 = (MovieMetadataPerson) item$iv$iv;
                                destination$iv$iv.add(it3.getName());
                            }
                            arrayList = (List) destination$iv$iv;
                        }
                        companion.addActorNames(loadResponse2, arrayList);
                        LoadResponse.Companion companion2 = LoadResponse.Companion;
                        LoadResponse loadResponse3 = loadResponse;
                        MovieMetadata movieMetadata4 = this.$moviefetch;
                        companion2.addImdbId(loadResponse3, (movieMetadata4 == null || (providerIds2 = movieMetadata4.getProviderIds()) == null) ? null : providerIds2.getImdb());
                        LoadResponse.Companion companion3 = LoadResponse.Companion;
                        LoadResponse loadResponse4 = loadResponse;
                        MovieMetadata movieMetadata5 = this.$moviefetch;
                        companion3.addImdbId(loadResponse4, (movieMetadata5 == null || (providerIds = movieMetadata5.getProviderIds()) == null) ? null : providerIds.getTmdb());
                        LoadResponse.Companion companion4 = LoadResponse.Companion;
                        LoadResponse loadResponse5 = loadResponse;
                        MovieMetadata movieMetadata6 = this.$moviefetch;
                        if (movieMetadata6 == null || (externalUrls = movieMetadata6.getExternalUrls()) == null) {
                            url = null;
                        } else {
                            Iterable $this$firstOrNull$iv = externalUrls;
                            Iterator it4 = $this$firstOrNull$iv.iterator();
                            do {
                                if (it4.hasNext()) {
                                    element$iv2 = it4.next();
                                    it2 = (ExternalUrl) element$iv2;
                                } else {
                                    element$iv2 = null;
                                }
                                externalUrl = (ExternalUrl) element$iv2;
                                if (externalUrl != null) {
                                    url = externalUrl.getUrl();
                                } else {
                                    url = null;
                                }
                            } while (!StringsKt.equals(it2.getName(), "IMDb", true));
                            externalUrl = (ExternalUrl) element$iv2;
                            if (externalUrl != null) {
                                url = externalUrl.getUrl();
                            } else {
                                url = null;
                            }
                        }
                        companion4.addImdbUrl(loadResponse5, url);
                        LoadResponse.Companion companion5 = LoadResponse.Companion;
                        LoadResponse loadResponse6 = loadResponse;
                        MovieMetadata movieMetadata7 = this.$moviefetch;
                        if (movieMetadata7 != null && (remoteTrailers = movieMetadata7.getRemoteTrailers()) != null) {
                            Iterable $this$firstOrNull$iv2 = remoteTrailers;
                            Iterator it5 = $this$firstOrNull$iv2.iterator();
                            do {
                                if (it5.hasNext()) {
                                    element$iv = it5.next();
                                    it = (RemoteTrailer) element$iv;
                                } else {
                                    element$iv = null;
                                }
                                remoteTrailer = (RemoteTrailer) element$iv;
                                if (remoteTrailer != null) {
                                    url2 = remoteTrailer.getUrl();
                                }
                            } while (!StringsKt.contains(it.getUrl(), "youtube", true));
                            remoteTrailer = (RemoteTrailer) element$iv;
                            if (remoteTrailer != null) {
                                url2 = remoteTrailer.getUrl();
                            }
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
                        this.label = 1;
                        if (LoadResponse.Companion.addTrailer$default(companion5, loadResponse6, url2, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.phisher98.Jellyfin$load$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: Jellyfin.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.Jellyfin$load$2$2", f = "Jellyfin.kt", i = {0}, l = {210}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {211}, s = {"L$0"}, v = 2)
        @SourceDebugExtension({"SMAP\nJellyfin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Jellyfin.kt\ncom/phisher98/Jellyfin$load$2$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,301:1\n1739#2:302\n1814#2,3:303\n296#2,2:306\n296#2,2:308\n*S KotlinDebug\n*F\n+ 1 Jellyfin.kt\ncom/phisher98/Jellyfin$load$2$2\n*L\n206#1:302\n206#1:303,3\n209#1:306,2\n210#1:308,2\n*E\n"})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
            final /* synthetic */ LoadData $loadData;
            final /* synthetic */ MovieMetadata $moviefetch;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(LoadData loadData, MovieMetadata movieMetadata, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$loadData = loadData;
                this.$moviefetch = movieMetadata;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.$loadData, this.$moviefetch, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
                return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:50:0x00ee  */
            /* JADX WARN: Code duplicated, block: B:51:0x00f3  */
            /* JADX WARN: Code duplicated, block: B:65:0x0131  */
            public final Object invokeSuspend(Object $result) {
                ArrayList arrayList;
                String url;
                Iterable remoteTrailers;
                Object element$iv;
                RemoteTrailer remoteTrailer;
                RemoteTrailer it;
                Iterable externalUrls;
                Object element$iv2;
                ExternalUrl externalUrl;
                ExternalUrl it2;
                ProviderIds providerIds;
                ProviderIds providerIds2;
                Iterable people;
                LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        loadResponse.setPosterUrl(this.$loadData.getPosterurl());
                        MovieMetadata movieMetadata = this.$moviefetch;
                        String url2 = null;
                        loadResponse.setPlot(movieMetadata != null ? movieMetadata.getOverview() : null);
                        MovieMetadata movieMetadata2 = this.$moviefetch;
                        loadResponse.setTags(movieMetadata2 != null ? movieMetadata2.getGenres() : null);
                        LoadResponse.Companion companion = LoadResponse.Companion;
                        LoadResponse loadResponse2 = loadResponse;
                        MovieMetadata movieMetadata3 = this.$moviefetch;
                        if (movieMetadata3 == null || (people = movieMetadata3.getPeople()) == null) {
                            arrayList = null;
                        } else {
                            Iterable $this$map$iv = people;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                MovieMetadataPerson it3 = (MovieMetadataPerson) item$iv$iv;
                                destination$iv$iv.add(it3.getName());
                            }
                            arrayList = (List) destination$iv$iv;
                        }
                        companion.addActorNames(loadResponse2, arrayList);
                        LoadResponse.Companion companion2 = LoadResponse.Companion;
                        LoadResponse loadResponse3 = loadResponse;
                        MovieMetadata movieMetadata4 = this.$moviefetch;
                        companion2.addImdbId(loadResponse3, (movieMetadata4 == null || (providerIds2 = movieMetadata4.getProviderIds()) == null) ? null : providerIds2.getImdb());
                        LoadResponse.Companion companion3 = LoadResponse.Companion;
                        LoadResponse loadResponse4 = loadResponse;
                        MovieMetadata movieMetadata5 = this.$moviefetch;
                        companion3.addImdbId(loadResponse4, (movieMetadata5 == null || (providerIds = movieMetadata5.getProviderIds()) == null) ? null : providerIds.getTmdb());
                        LoadResponse.Companion companion4 = LoadResponse.Companion;
                        LoadResponse loadResponse5 = loadResponse;
                        MovieMetadata movieMetadata6 = this.$moviefetch;
                        if (movieMetadata6 == null || (externalUrls = movieMetadata6.getExternalUrls()) == null) {
                            url = null;
                        } else {
                            Iterable $this$firstOrNull$iv = externalUrls;
                            Iterator it4 = $this$firstOrNull$iv.iterator();
                            do {
                                if (it4.hasNext()) {
                                    element$iv2 = it4.next();
                                    it2 = (ExternalUrl) element$iv2;
                                } else {
                                    element$iv2 = null;
                                }
                                externalUrl = (ExternalUrl) element$iv2;
                                if (externalUrl != null) {
                                    url = externalUrl.getUrl();
                                } else {
                                    url = null;
                                }
                            } while (!StringsKt.equals(it2.getName(), "IMDb", true));
                            externalUrl = (ExternalUrl) element$iv2;
                            if (externalUrl != null) {
                                url = externalUrl.getUrl();
                            } else {
                                url = null;
                            }
                        }
                        companion4.addImdbUrl(loadResponse5, url);
                        LoadResponse.Companion companion5 = LoadResponse.Companion;
                        LoadResponse loadResponse6 = loadResponse;
                        MovieMetadata movieMetadata7 = this.$moviefetch;
                        if (movieMetadata7 != null && (remoteTrailers = movieMetadata7.getRemoteTrailers()) != null) {
                            Iterable $this$firstOrNull$iv2 = remoteTrailers;
                            Iterator it5 = $this$firstOrNull$iv2.iterator();
                            do {
                                if (it5.hasNext()) {
                                    element$iv = it5.next();
                                    it = (RemoteTrailer) element$iv;
                                } else {
                                    element$iv = null;
                                }
                                remoteTrailer = (RemoteTrailer) element$iv;
                                if (remoteTrailer != null) {
                                    url2 = remoteTrailer.getUrl();
                                }
                            } while (!StringsKt.contains(it.getUrl(), "youtube", true));
                            remoteTrailer = (RemoteTrailer) element$iv;
                            if (remoteTrailer != null) {
                                url2 = remoteTrailer.getUrl();
                            }
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
                        this.label = 1;
                        if (LoadResponse.Companion.addTrailer$default(companion5, loadResponse6, url2, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Jellyfin$loadLinks$2 */
    /* JADX INFO: compiled from: Jellyfin.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "auth", "Lcom/phisher98/Authparser;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Jellyfin$loadLinks$2", f = "Jellyfin.kt", i = {0, 1, 1}, l = {223, 224}, m = "invokeSuspend", n = {"auth", "auth", "streamUrl"}, nl = {224, 227}, s = {"L$0", "L$0", "L$1"}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<Authparser, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $data;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(String str, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$data = str;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = Jellyfin.this.new C00052(this.$data, this.$callback, continuation);
            c00052.L$0 = obj;
            return c00052;
        }

        public final Object invoke(Authparser authparser, Continuation<? super Boolean> continuation) {
            return create(authparser, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0086 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0087  */
        public final Object invokeSuspend(Object $result) {
            Object objFetchPlaybackInfo;
            Function1<ExtractorLink, Unit> function1;
            Object objNewExtractorLink;
            Function1<ExtractorLink, Unit> function2;
            Authparser auth = (Authparser) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(auth);
                    this.label = 1;
                    objFetchPlaybackInfo = Jellyfin.this.fetchPlaybackInfo(StringsKt.substringAfter$default(this.$data, "/", (String) null, 2, (Object) null), auth.getUser().getId(), (Continuation) this);
                    if (objFetchPlaybackInfo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    String streamUrl = (String) objFetchPlaybackInfo;
                    function1 = this.$callback;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(auth);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(streamUrl);
                    this.L$2 = function1;
                    this.label = 2;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(Jellyfin.this.getName(), Jellyfin.this.getName(), streamUrl, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass1(streamUrl, null), (Continuation) this);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function2 = function1;
                    function2.invoke(objNewExtractorLink);
                    return Boxing.boxBoolean(true);
                case 1:
                    ResultKt.throwOnFailure($result);
                    objFetchPlaybackInfo = $result;
                    String streamUrl2 = (String) objFetchPlaybackInfo;
                    function1 = this.$callback;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(auth);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(streamUrl2);
                    this.L$2 = function1;
                    this.label = 2;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(Jellyfin.this.getName(), Jellyfin.this.getName(), streamUrl2, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass1(streamUrl2, null), (Continuation) this);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function2 = function1;
                    function2.invoke(objNewExtractorLink);
                    return Boxing.boxBoolean(true);
                case 2:
                    function2 = (Function1) this.L$2;
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink = $result;
                    function2.invoke(objNewExtractorLink);
                    return Boxing.boxBoolean(true);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.phisher98.Jellyfin$loadLinks$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Jellyfin.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.Jellyfin$loadLinks$2$1", f = "Jellyfin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $streamUrl;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$streamUrl = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$streamUrl, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
                return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$streamUrl));
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    static /* synthetic */ Object loadLinks$suspendImpl(Jellyfin $this, String data, boolean isCasting, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) {
        return withAuthRetry$default($this, 0, 0L, $this.new C00052(data, function2, null), continuation, 3, null);
    }

    /* JADX INFO: renamed from: com.phisher98.Jellyfin$fetchPlaybackInfo$2 */
    /* JADX INFO: compiled from: Jellyfin.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "auth", "Lcom/phisher98/Authparser;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Jellyfin$fetchPlaybackInfo$2", f = "Jellyfin.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {248, 262}, m = "invokeSuspend", n = {"auth", "apiUrl", "headers", "body", "auth", "apiUrl", "headers", "body", "response", "mediaSource", "httpPath"}, nl = {253, 263}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00012 extends SuspendLambda implements Function2<Authparser, Continuation<? super String>, Object> {
        final /* synthetic */ String $id;
        final /* synthetic */ String $userId;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00012(String str, String str2, Continuation<? super C00012> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$userId = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00012 = Jellyfin.this.new C00012(this.$id, this.$userId, continuation);
            c00012.L$0 = obj;
            return c00012;
        }

        public final Object invoke(Authparser authparser, Continuation<? super String> continuation) {
            return create(authparser, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0112  */
        /* JADX WARN: Code duplicated, block: B:19:0x0115  */
        /* JADX WARN: Code duplicated, block: B:34:0x0195  */
        /* JADX WARN: Code duplicated, block: B:37:0x01a0  */
        /* JADX WARN: Code duplicated, block: B:39:0x01a3  */
        /* JADX WARN: Code duplicated, block: B:40:0x01a5  */
        public final Object invokeSuspend(Object $result) {
            Map headers;
            Object objRetryRequest$default;
            String body;
            String apiUrl;
            LoadURL response;
            MediaSource mediaSource;
            String httpPath;
            String transcodingUrl;
            Object obj;
            String httpPath2;
            List<MediaSource> mediaSources;
            String redirectUrl;
            Authparser auth = (Authparser) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String apiUrl2 = Jellyfin.this.url + "/Items/" + this.$id + "/PlaybackInfo";
                    headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("Authorization", Jellyfin.this.buildAuthHeader(auth.getAccessToken())), TuplesKt.to("Content-Type", "application/json")});
                    String body2 = StringsKt.trimIndent("\n            {\n                \"UserId\": \"" + this.$userId + "\",\n                \"StartTimeTicks\": 0,\n                \"IsPlayback\": true,\n                \"AutoOpenLiveStream\": true,\n                \"MediaSourceId\": \"" + this.$id + "\"\n            }\n            ");
                    this.L$0 = SpillingKt.nullOutSpilledVariable(auth);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(apiUrl2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(headers);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                    this.label = 1;
                    objRetryRequest$default = Jellyfin.retryRequest$default(Jellyfin.this, 0, 0L, new Jellyfin$fetchPlaybackInfo$2$response$1(apiUrl2, headers, body2, null), (Continuation) this, 3, null);
                    if (objRetryRequest$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    body = apiUrl2;
                    apiUrl = body2;
                    response = (LoadURL) objRetryRequest$default;
                    if (response != null || (mediaSources = response.getMediaSources()) == null) {
                        mediaSource = null;
                    } else {
                        mediaSource = (MediaSource) CollectionsKt.firstOrNull(mediaSources);
                    }
                    httpPath = mediaSource != null ? mediaSource.getPath() : null;
                    if (httpPath != null || !StringsKt.startsWith(httpPath, "http", true) || !mediaSource.getSupportsDirectPlay() || !StringsKt.equals(mediaSource.getProtocol(), "http", true)) {
                        if (mediaSource != null || (transcodingUrl = mediaSource.getTranscodingUrl()) == null) {
                            return Jellyfin.this.url + "/Videos/" + this.$id + "/stream.mp4?Static=true&mediaSourceId=" + this.$id;
                        }
                        return StringsKt.startsWith(transcodingUrl, "http", true) ? transcodingUrl : Jellyfin.this.url + transcodingUrl;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(auth);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(body);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(headers);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(apiUrl);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(response);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(mediaSource);
                    this.L$6 = httpPath;
                    this.label = 2;
                    obj = Requests.get$default(MainActivityKt.getApp(), httpPath, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4062, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    httpPath2 = httpPath;
                    redirectUrl = ((NiceResponse) obj).getHeaders().get("location");
                    if (redirectUrl == null) {
                        redirectUrl = "";
                    }
                    return redirectUrl.length() > 0 ? redirectUrl : httpPath2;
                case 1:
                    apiUrl = (String) this.L$3;
                    headers = (Map) this.L$2;
                    body = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objRetryRequest$default = $result;
                    response = (LoadURL) objRetryRequest$default;
                    if (response != null) {
                        mediaSource = null;
                    } else {
                        mediaSource = null;
                    }
                    httpPath = mediaSource != null ? mediaSource.getPath() : null;
                    if (httpPath != null) {
                        break;
                    }
                    if (mediaSource != null) {
                        break;
                    }
                    return Jellyfin.this.url + "/Videos/" + this.$id + "/stream.mp4?Static=true&mediaSourceId=" + this.$id;
                case 2:
                    httpPath2 = (String) this.L$6;
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    redirectUrl = ((NiceResponse) obj).getHeaders().get("location");
                    if (redirectUrl == null) {
                        redirectUrl = "";
                    }
                    if (redirectUrl.length() > 0) {
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchPlaybackInfo(String id, String userId, Continuation<? super String> continuation) {
        return withAuthRetry$default(this, 0, 0L, new C00012(id, userId, null), continuation, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPosterUrl(EpisodeItem $this$getPosterUrl, String baseUrl) {
        String it;
        EpisodeImageTags imageTags = $this$getPosterUrl.getImageTags();
        if (imageTags == null || (it = imageTags.getPrimary()) == null) {
            return null;
        }
        return baseUrl + "/Items/" + $this$getPosterUrl.getId() + "/Images/Primary?tag=" + it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:28:0x00c5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:32:0x00dc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:44:0x013a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:0x013b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x013b -> B:46:0x0148). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final <T> java.lang.Object retryRequest(int r23, long r24, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r26, kotlin.coroutines.Continuation<? super T> r27) {
        /*
            Method dump skipped, instruction units count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.Jellyfin.retryRequest(int, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object retryRequest$default(Jellyfin jellyfin, int i, long j, Function1 function1, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retryRequest");
        }
        if ((i2 & 1) != 0) {
            i = 3;
        }
        if ((i2 & 2) != 0) {
            j = 300;
        }
        return jellyfin.retryRequest(i, j, function1, continuation);
    }
}
