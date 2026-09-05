package com.phisher98;

import android.content.SharedPreferences;
import androidx.annotation.RequiresApi;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
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
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u000eCDEFGHIJKLMNOPB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010%JT\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00172\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020/0-H\u0097@b\f\b3\u0012\b\b4\u0012\u0004\b\u0003\u00104¢\u0006\u0002\u00102J\f\u00105\u001a\u000206*\u000207H\u0002J\u0014\u00108\u001a\u0004\u0018\u00010\u0003*\u000207H\u0086@¢\u0006\u0002\u00109J\"\u0010:\u001a\u0004\u0018\u00010\u00032\u0006\u0010;\u001a\u00020\u00032\b\u0010<\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0002\u0010=J\u0018\u0010>\u001a\u0004\u0018\u00010\u00032\u0006\u0010?\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010%J\"\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\u00032\b\u0010<\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0002\u0010=R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006Q"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelog;", "Lcom/lagradost/cloudstream3/MainAPI;", "mainUrl", "", "name", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/SharedPreferences;)V", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "getName", "setName", "getSharedPref", "()Landroid/content/SharedPreferences;", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "hasMainPage", "", "getHasMainPage", "()Z", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/annotation/RequiresApi;", "value", "toLinkData", "Lcom/phisher98/StreamPlay$LinkData;", "Lcom/phisher98/StreamPlayStremioCatelog$LoadData;", "resolveImdbId", "(Lcom/phisher98/StreamPlayStremioCatelog$LoadData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tmdbToImdb", "tmdbId", "type", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kitsuToImdb", "kitsuId", "fetchCinemetaMeta", "Lcom/phisher98/StreamPlayStremioCatelog$CinemetaMetaData;", "imdbId", "LoadData", "Manifest", "Catalog", "CatalogResponse", "Trailer", "CatalogEntry", "Video", "TmdbExternalIds", "AniZipResponse", "AniZipMappings", "CinemetaResponse", "CinemetaMeta", "CinemetaLink", "CinemetaMetaData", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStreamPlayStremioCatelog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayStremioCatelog.kt\ncom/phisher98/StreamPlayStremioCatelog\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 7 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,451:1\n73#2,5:452\n73#2,5:457\n73#2,5:500\n73#2,5:505\n73#2,5:542\n73#2,5:547\n73#2,5:552\n63#3:462\n64#3,15:464\n63#3:481\n64#3,15:483\n63#3:512\n64#3,15:514\n1#4:463\n1#4:482\n1#4:513\n50#5:479\n43#5:480\n50#5:498\n43#5:499\n50#5:529\n43#5:530\n296#6,2:510\n777#6:531\n873#6,2:532\n1739#6:534\n1814#6,3:535\n296#6,2:557\n37#7,2:538\n37#7,2:540\n*S KotlinDebug\n*F\n+ 1 StreamPlayStremioCatelog.kt\ncom/phisher98/StreamPlayStremioCatelog\n*L\n61#1:452,5\n84#1:457,5\n103#1:500,5\n107#1:505,5\n380#1:542,5\n395#1:547,5\n416#1:552,5\n94#1:462\n94#1:464,15\n98#1:481\n98#1:483,15\n125#1:512\n125#1:514,15\n94#1:463\n98#1:482\n125#1:513\n94#1:479\n94#1:480\n98#1:498\n98#1:499\n125#1:529\n125#1:530\n111#1:510,2\n139#1:531\n139#1:532,2\n164#1:534\n164#1:535,3\n422#1:557,2\n178#1:538,2\n179#1:540,2\n*E\n"})
public final class StreamPlayStremioCatelog extends MainAPI {
    private final boolean hasMainPage;

    @NotNull
    private String mainUrl;

    @NotNull
    private String name;

    @Nullable
    private final SharedPreferences sharedPref;

    @NotNull
    private final Set<TvType> supportedTypes;

    /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioCatelog$fetchCinemetaMeta$1 */
    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayStremioCatelog", f = "StreamPlayStremioCatelog.kt", i = {0, 0, 0}, l = {414}, m = "fetchCinemetaMeta", n = {"imdbId", "type", "mediaType"}, nl = {416}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C02551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02551(Continuation<? super C02551> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayStremioCatelog.this.fetchCinemetaMeta(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioCatelog$getMainPage$1 */
    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayStremioCatelog", f = "StreamPlayStremioCatelog.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {60, 65}, m = "getMainPage", n = {"request", "page", "pageSize", "skip", "request", "manifest", "lists", "page", "pageSize", "skip"}, nl = {61, 77}, s = {"L$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "I$1", "I$2"}, v = 2)
    static final class C02561 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02561(Continuation<? super C02561> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayStremioCatelog.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioCatelog$kitsuToImdb$1 */
    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayStremioCatelog", f = "StreamPlayStremioCatelog.kt", i = {0, 0}, l = {392}, m = "kitsuToImdb", n = {"kitsuId", "id"}, nl = {395}, s = {"L$0", "L$1"}, v = 2)
    static final class C02581 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02581(Continuation<? super C02581> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayStremioCatelog.this.kitsuToImdb(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioCatelog$load$1 */
    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayStremioCatelog", f = "StreamPlayStremioCatelog.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {96, 102, 106, 115}, m = "load", n = {"url", "url", "res", "encodedId", "url", "res", "encodedId", "response", "url", "res", "encodedId", "response", "entry"}, nl = {97, 103, 107, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C02591 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C02591(Continuation<? super C02591> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayStremioCatelog.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioCatelog$loadLinks$1 */
    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayStremioCatelog", f = "StreamPlayStremioCatelog.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {126, 128, 149}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "res", "isCasting", "data", "subtitleCallback", "callback", "res", "imdb", "it", "isCasting", "data", "subtitleCallback", "callback", "res", "imdb", "cinemeta", "resolved", "disabledProviderIds", "providersList", "stremioAddons", "authToken", "isCasting"}, nl = {127, 127, 182}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0"}, v = 2)
    static final class C02601 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C02601(Continuation<? super C02601> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayStremioCatelog.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioCatelog$search$1 */
    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayStremioCatelog", f = "StreamPlayStremioCatelog.kt", i = {0, 1, 1, 1}, l = {84, 86}, m = "search", n = {"query", "query", "res", "list"}, nl = {452, 89}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 2)
    static final class C02631 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02631(Continuation<? super C02631> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayStremioCatelog.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioCatelog$tmdbToImdb$1 */
    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayStremioCatelog", f = "StreamPlayStremioCatelog.kt", i = {0, 0, 0}, l = {377}, m = "tmdbToImdb", n = {"tmdbId", "type", "mediaType"}, nl = {380}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C02651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02651(Continuation<? super C02651> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayStremioCatelog.this.tmdbToImdb(null, null, (Continuation) this);
        }
    }

    public StreamPlayStremioCatelog(@NotNull String mainUrl, @NotNull String name, @Nullable SharedPreferences sharedPref) {
        this.mainUrl = mainUrl;
        this.name = name;
        this.sharedPref = sharedPref;
        this.supportedTypes = SetsKt.setOf(new TvType[]{TvType.Others, TvType.Movie, TvType.TvSeries});
        this.hasMainPage = true;
    }

    public /* synthetic */ StreamPlayStremioCatelog(String str, String str2, SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : sharedPreferences);
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @Nullable
    public final SharedPreferences getSharedPref() {
        return this.sharedPref;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0153 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x0154  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C02561 c02561;
        boolean z;
        Object obj;
        C02561 c02562;
        int page2;
        Object obj2;
        MainPageRequest request2;
        int pageSize;
        int pageSize2;
        Object safe;
        Manifest manifest;
        ArrayList lists;
        List<Catalog> catalogs;
        Object objAmap;
        Manifest manifest2;
        int page3;
        MainPageRequest request3;
        if (continuation instanceof C02561) {
            c02561 = (C02561) continuation;
            if ((c02561.label & Integer.MIN_VALUE) != 0) {
                c02561.label -= Integer.MIN_VALUE;
            } else {
                c02561 = new C02561(continuation);
            }
        } else {
            c02561 = new C02561(continuation);
        }
        Object $result = c02561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02561.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (getMainUrl().length() == 0) {
                    throw new IllegalArgumentException("Configure in StreamPlay Catalogs Addon in Extension Settings\n");
                }
                setMainUrl(StreamPlayUtilsKt.fixSourceUrl(getMainUrl()));
                int skip = (page - 1) * 100;
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/manifest.json";
                c02561.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c02561.I$0 = page;
                c02561.I$1 = 100;
                c02561.I$2 = skip;
                c02561.label = 1;
                z = true;
                C02561 c02563 = c02561;
                obj = coroutine_suspended;
                Object obj3 = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02563, 4094, (Object) null);
                c02562 = c02563;
                if (obj3 == obj) {
                    return obj;
                }
                page2 = page;
                obj2 = obj3;
                request2 = request;
                pageSize = 100;
                pageSize2 = skip;
                NiceResponse this_$iv = (NiceResponse) obj2;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Manifest.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                manifest = (Manifest) safe;
                lists = new ArrayList();
                if (manifest != null && (catalogs = manifest.getCatalogs()) != null) {
                    C02572 c02572 = new C02572(pageSize2, lists, null);
                    c02562.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                    c02562.L$1 = SpillingKt.nullOutSpilledVariable(manifest);
                    c02562.L$2 = lists;
                    c02562.I$0 = page2;
                    c02562.I$1 = pageSize;
                    c02562.I$2 = pageSize2;
                    c02562.label = 2;
                    objAmap = ParCollectionsKt.amap(catalogs, c02572, c02562);
                    if (objAmap == obj) {
                        return obj;
                    }
                    MainPageRequest mainPageRequest = request2;
                    manifest2 = manifest;
                    page3 = page2;
                    $result = objAmap;
                    request3 = mainPageRequest;
                }
                return MainAPIKt.newHomePageResponse(lists, Boxing.boxBoolean(z));
            case 1:
                pageSize2 = c02561.I$2;
                pageSize = c02561.I$1;
                int page4 = c02561.I$0;
                request2 = (MainPageRequest) c02561.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                z = true;
                c02562 = c02561;
                page2 = page4;
                obj2 = $result;
                NiceResponse this_$iv2 = (NiceResponse) obj2;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Manifest.class));
                manifest = (Manifest) safe;
                lists = new ArrayList();
                if (manifest != null) {
                    C02572 c02573 = new C02572(pageSize2, lists, null);
                    c02562.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                    c02562.L$1 = SpillingKt.nullOutSpilledVariable(manifest);
                    c02562.L$2 = lists;
                    c02562.I$0 = page2;
                    c02562.I$1 = pageSize;
                    c02562.I$2 = pageSize2;
                    c02562.label = 2;
                    objAmap = ParCollectionsKt.amap(catalogs, c02573, c02562);
                    if (objAmap == obj) {
                        return obj;
                    }
                    MainPageRequest mainPageRequest2 = request2;
                    manifest2 = manifest;
                    page3 = page2;
                    $result = objAmap;
                    request3 = mainPageRequest2;
                }
                return MainAPIKt.newHomePageResponse(lists, Boxing.boxBoolean(z));
            case 2:
                int i = c02561.I$2;
                int i2 = c02561.I$1;
                page3 = c02561.I$0;
                List lists2 = (List) c02561.L$2;
                manifest2 = (Manifest) c02561.L$1;
                request3 = (MainPageRequest) c02561.L$0;
                ResultKt.throwOnFailure($result);
                lists = lists2;
                z = true;
                return MainAPIKt.newHomePageResponse(lists, Boxing.boxBoolean(z));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioCatelog$getMainPage$2 */
    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "catalog", "Lcom/phisher98/StreamPlayStremioCatelog$Catalog;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayStremioCatelog$getMainPage$2", f = "StreamPlayStremioCatelog.kt", i = {0}, l = {66}, m = "invokeSuspend", n = {"catalog"}, nl = {69}, s = {"L$0"}, v = 2)
    static final class C02572 extends SuspendLambda implements Function2<Catalog, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<HomePageList> $lists;
        final /* synthetic */ int $skip;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02572(int i, List<HomePageList> list, Continuation<? super C02572> continuation) {
            super(2, continuation);
            this.$skip = i;
            this.$lists = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c02572 = StreamPlayStremioCatelog.this.new C02572(this.$skip, this.$lists, continuation);
            c02572.L$0 = obj;
            return c02572;
        }

        public final Object invoke(Catalog catalog, Continuation<? super Unit> continuation) {
            return create(catalog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object homePageList;
            Catalog catalog = (Catalog) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(catalog);
                    this.label = 1;
                    homePageList = catalog.toHomePageList(StreamPlayStremioCatelog.this, this.$skip, (Continuation) this);
                    if (homePageList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    homePageList = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List<HomePageList> list = this.$lists;
            HomePageList it = (HomePageList) homePageList;
            if (!it.getList().isEmpty()) {
                list.add(it);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x010a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x010b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C02631 c02631;
        Object obj;
        Object obj2;
        String query2;
        Object safe;
        Manifest res;
        List list;
        List<Catalog> catalogs;
        Object objAmap;
        String query3;
        if (continuation instanceof C02631) {
            c02631 = (C02631) continuation;
            if ((c02631.label & Integer.MIN_VALUE) != 0) {
                c02631.label -= Integer.MIN_VALUE;
            } else {
                c02631 = new C02631(continuation);
            }
        } else {
            c02631 = new C02631(continuation);
        }
        C02631 c02632 = c02631;
        Object $result = c02632.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02632.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                setMainUrl(StreamPlayUtilsKt.fixSourceUrl(getMainUrl()));
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/manifest.json";
                c02632.L$0 = query;
                c02632.label = 1;
                obj = coroutine_suspended;
                Object obj3 = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02632, 4094, (Object) null);
                c02632 = c02632;
                if (obj3 == obj) {
                    return obj;
                }
                obj2 = obj3;
                query2 = query;
                NiceResponse this_$iv = (NiceResponse) obj2;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Manifest.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                res = (Manifest) safe;
                list = new ArrayList();
                if (res != null && (catalogs = res.getCatalogs()) != null) {
                    C02642 c02642 = new C02642(list, query2, this, null);
                    c02632.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                    c02632.L$1 = SpillingKt.nullOutSpilledVariable(res);
                    c02632.L$2 = list;
                    c02632.label = 2;
                    objAmap = ParCollectionsKt.amap(catalogs, c02642, c02632);
                    if (objAmap == obj) {
                        return obj;
                    }
                    query3 = query2;
                    $result = objAmap;
                }
                return CollectionsKt.distinct(list);
            case 1:
                String query4 = (String) c02632.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                query2 = query4;
                obj2 = $result;
                NiceResponse this_$iv2 = (NiceResponse) obj2;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Manifest.class));
                res = (Manifest) safe;
                list = new ArrayList();
                if (res != null) {
                    C02642 c02643 = new C02642(list, query2, this, null);
                    c02632.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                    c02632.L$1 = SpillingKt.nullOutSpilledVariable(res);
                    c02632.L$2 = list;
                    c02632.label = 2;
                    objAmap = ParCollectionsKt.amap(catalogs, c02643, c02632);
                    if (objAmap == obj) {
                        return obj;
                    }
                    query3 = query2;
                    $result = objAmap;
                }
                return CollectionsKt.distinct(list);
            case 2:
                list = (List) c02632.L$2;
                query3 = (String) c02632.L$0;
                ResultKt.throwOnFailure($result);
                return CollectionsKt.distinct(list);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioCatelog$search$2 */
    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "catalog", "Lcom/phisher98/StreamPlayStremioCatelog$Catalog;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayStremioCatelog$search$2", f = "StreamPlayStremioCatelog.kt", i = {0}, l = {87}, m = "invokeSuspend", n = {"catalog"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class C02642 extends SuspendLambda implements Function2<Catalog, Continuation<? super Boolean>, Object> {
        final /* synthetic */ List<SearchResponse> $list;
        final /* synthetic */ String $query;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ StreamPlayStremioCatelog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02642(List<SearchResponse> list, String str, StreamPlayStremioCatelog streamPlayStremioCatelog, Continuation<? super C02642> continuation) {
            super(2, continuation);
            this.$list = list;
            this.$query = str;
            this.this$0 = streamPlayStremioCatelog;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c02642 = new C02642(this.$list, this.$query, this.this$0, continuation);
            c02642.L$0 = obj;
            return c02642;
        }

        public final Object invoke(Catalog catalog, Continuation<? super Boolean> continuation) {
            return create(catalog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objSearch;
            List<SearchResponse> list;
            Catalog catalog = (Catalog) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    List<SearchResponse> list2 = this.$list;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(catalog);
                    this.L$1 = list2;
                    this.label = 1;
                    objSearch = catalog.search(this.$query, this.this$0, (Continuation) this);
                    if (objSearch == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list = list2;
                    break;
                    break;
                case 1:
                    list = (List) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objSearch = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Boxing.boxBoolean(list.addAll((Collection) objSearch));
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0385  */
    /* JADX WARN: Code duplicated, block: B:102:0x038d  */
    /* JADX WARN: Code duplicated, block: B:105:0x039c  */
    /* JADX WARN: Code duplicated, block: B:107:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:110:0x03af  */
    /* JADX WARN: Code duplicated, block: B:115:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:117:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:119:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:120:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:123:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:128:0x0418 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:130:0x01d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:0x020a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:0x03c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:66:0x0203  */
    /* JADX WARN: Code duplicated, block: B:75:0x021f  */
    /* JADX WARN: Code duplicated, block: B:79:0x02b3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:88:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:90:0x0356 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:91:0x0357  */
    /* JADX WARN: Code duplicated, block: B:99:0x0383  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C02591 c02591;
        Object obj;
        int i;
        String str;
        Object obj2;
        String $result;
        Object obj3;
        Object objDecodeFromString;
        CatalogEntry catalogEntry;
        CatalogEntry res;
        String url2;
        String encodedId;
        CatalogEntry res2;
        CatalogEntry catalogEntry2;
        String encodedId2;
        String encodedId3;
        CatalogEntry res3;
        String url3;
        String metaJson;
        Object obj4;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString2;
        Object safe;
        CatalogResponse response;
        CatalogResponse response2;
        String encodedId4;
        String url4;
        CatalogEntry res4;
        String encodedId5;
        CatalogEntry res5;
        CatalogEntry entry;
        Object loadResponse;
        Iterable metas;
        CatalogEntry catalogEntry3;
        List<CatalogEntry> metas2;
        Iterator it;
        Object element$iv;
        CatalogEntry it2;
        Object safe2;
        CatalogResponse catalogResponse;
        if (continuation instanceof C02591) {
            c02591 = (C02591) continuation;
            if ((c02591.label & Integer.MIN_VALUE) != 0) {
                c02591.label -= Integer.MIN_VALUE;
            } else {
                c02591 = new C02591(continuation);
            }
        } else {
            c02591 = new C02591(continuation);
        }
        C02591 c02592 = c02591;
        Object $result2 = c02592.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02592.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                if (!StringsKt.startsWith$default(url, "{", false, 2, (Object) null)) {
                    Requests app = MainActivityKt.getApp();
                    c02592.L$0 = SpillingKt.nullOutSpilledVariable(url);
                    c02592.label = 1;
                    obj = coroutine_suspended;
                    i = 2;
                    str = ".json";
                    obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02592, 4094, (Object) null);
                    if (obj2 == obj) {
                        c02592 = c02592;
                        return obj;
                    }
                    c02592 = c02592;
                    $result = url;
                    String json = ((NiceResponse) obj2).getText();
                    metaJson = new JSONObject(json).getJSONObject("meta").toString();
                    AppUtils appUtils = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(CatalogEntry.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.exceptionOrNull-impl(obj4) != null) {
                        catalogEntry = null;
                    } else {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            catalogEntry = null;
                            try {
                                obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(CatalogEntry.class), (List) null, i, (Object) null));
                            } catch (Throwable th2) {
                                th = th2;
                                Result.Companion companion4 = Result.Companion;
                                obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            catalogEntry = null;
                        }
                    }
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = catalogEntry;
                    }
                    deserializationStrategy = (KSerializer) obj4;
                    if (deserializationStrategy != null) {
                        try {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, metaJson);
                        } catch (SerializationException e) {
                            ArchComponentExtKt.logError(e);
                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv.readValue(metaJson, new TypeReference<CatalogEntry>() { // from class: com.phisher98.StreamPlayStremioCatelog$load$$inlined$parseJson$2
                            });
                        } catch (Throwable th4) {
                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv2.readValue(metaJson, new TypeReference<CatalogEntry>() { // from class: com.phisher98.StreamPlayStremioCatelog$load$$inlined$parseJson$2
                            });
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv3.readValue(metaJson, new TypeReference<CatalogEntry>() { // from class: com.phisher98.StreamPlayStremioCatelog$load$$inlined$parseJson$2
                        });
                    }
                    String str2 = $result;
                    res = (CatalogEntry) objDecodeFromString2;
                    url2 = str2;
                    break;
                } else {
                    AppUtils appUtils2 = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion5 = Result.Companion;
                        KType kTypeTypeOf2 = Reflection.typeOf(CatalogEntry.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                    } catch (Throwable th5) {
                        Result.Companion companion6 = Result.Companion;
                        obj3 = Result.constructor-impl(ResultKt.createFailure(th5));
                    }
                    if (Result.exceptionOrNull-impl(obj3) != null) {
                        try {
                            Result.Companion companion7 = Result.Companion;
                            obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(CatalogEntry.class), (List) null, 2, (Object) null));
                        } catch (Throwable th6) {
                            Result.Companion companion8 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th6));
                        }
                    }
                    if (Result.isFailure-impl(obj3)) {
                        obj3 = null;
                    }
                    DeserializationStrategy deserializationStrategy2 = (KSerializer) obj3;
                    if (deserializationStrategy2 != null) {
                        try {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, url);
                        } catch (SerializationException e2) {
                            ArchComponentExtKt.logError(e2);
                            ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv4.readValue(url, new TypeReference<CatalogEntry>() { // from class: com.phisher98.StreamPlayStremioCatelog$load$$inlined$parseJson$1
                            });
                        } catch (Throwable th7) {
                            ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv5.readValue(url, new TypeReference<CatalogEntry>() { // from class: com.phisher98.StreamPlayStremioCatelog$load$$inlined$parseJson$1
                            });
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv6.readValue(url, new TypeReference<CatalogEntry>() { // from class: com.phisher98.StreamPlayStremioCatelog$load$$inlined$parseJson$1
                        });
                    }
                    obj = coroutine_suspended;
                    str = ".json";
                    catalogEntry = null;
                    i = 2;
                    res = (CatalogEntry) objDecodeFromString;
                    url2 = url;
                    break;
                }
                encodedId = res.getId();
                Requests app2 = MainActivityKt.getApp();
                String str3 = str;
                String str4 = getMainUrl() + "/meta/" + res.getType() + '/' + encodedId + str3;
                c02592.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c02592.L$1 = res;
                c02592.L$2 = encodedId;
                c02592.label = i;
                C02591 c02593 = c02592;
                res2 = res;
                catalogEntry2 = catalogEntry;
                encodedId2 = str3;
                $result2 = Requests.get$default(app2, str4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02593, 4094, (Object) null);
                c02592 = c02593;
                if ($result2 == obj) {
                    return obj;
                }
                encodedId3 = encodedId;
                res3 = res2;
                url3 = url2;
                NiceResponse this_$iv = (NiceResponse) $result2;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(CatalogResponse.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = catalogEntry2;
                }
                response = (CatalogResponse) safe;
                if (response == null) {
                    Requests app3 = MainActivityKt.getApp();
                    String encodedId6 = "https://v3-cinemeta.strem.io/meta/" + res3.getType() + '/' + encodedId3 + encodedId2;
                    c02592.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c02592.L$1 = res3;
                    c02592.L$2 = SpillingKt.nullOutSpilledVariable(encodedId3);
                    c02592.L$3 = SpillingKt.nullOutSpilledVariable(response);
                    c02592.label = 3;
                    encodedId5 = encodedId3;
                    res5 = res3;
                    C02591 c02594 = c02592;
                    $result2 = Requests.get$default(app3, encodedId6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02594, 4094, (Object) null);
                    c02592 = c02594;
                    if ($result2 == obj) {
                        return obj;
                    }
                    encodedId4 = encodedId5;
                    url4 = url3;
                    res4 = res5;
                    NiceResponse this_$iv2 = (NiceResponse) $result2;
                    try {
                        ResponseParser parser2 = this_$iv2.getParser();
                        Intrinsics.checkNotNull(parser2);
                        safe2 = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(CatalogResponse.class));
                    } catch (Exception e$iv2) {
                        e$iv2.printStackTrace();
                        safe2 = catalogEntry2;
                    }
                    catalogResponse = (CatalogResponse) safe2;
                    if (catalogResponse != null) {
                        throw new RuntimeException("Failed to load meta");
                    }
                    response2 = catalogResponse;
                    break;
                } else {
                    String encodedId7 = encodedId3;
                    CatalogEntry res6 = res3;
                    response2 = response;
                    encodedId4 = encodedId7;
                    url4 = url3;
                    res4 = res6;
                }
                entry = response2.getMeta();
                if (entry == null) {
                    metas = response2.getMetas();
                    if (metas != null) {
                        Iterable $this$firstOrNull$iv = metas;
                        it = $this$firstOrNull$iv.iterator();
                        do {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                it2 = (CatalogEntry) element$iv;
                            } else {
                                element$iv = catalogEntry2;
                            }
                            catalogEntry3 = (CatalogEntry) element$iv;
                        } while (!Intrinsics.areEqual(it2.getId(), res4.getId()));
                        catalogEntry3 = (CatalogEntry) element$iv;
                    } else {
                        catalogEntry3 = catalogEntry2;
                    }
                    if (catalogEntry3 == null) {
                        metas2 = response2.getMetas();
                        if (metas2 != null) {
                            catalogEntry3 = (CatalogEntry) CollectionsKt.firstOrNull(metas2);
                        } else {
                            catalogEntry3 = catalogEntry2;
                        }
                        if (catalogEntry3 == null) {
                            throw new RuntimeException("Meta not found");
                        }
                    }
                    entry = catalogEntry3;
                }
                String id = res4.getId();
                c02592.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c02592.L$1 = SpillingKt.nullOutSpilledVariable(res4);
                c02592.L$2 = SpillingKt.nullOutSpilledVariable(encodedId4);
                c02592.L$3 = SpillingKt.nullOutSpilledVariable(response2);
                c02592.L$4 = SpillingKt.nullOutSpilledVariable(entry);
                c02592.label = 4;
                loadResponse = entry.toLoadResponse(this, id, c02592);
                if (loadResponse == obj) {
                    return obj;
                }
                return loadResponse;
            case 1:
                String url5 = (String) c02592.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                str = ".json";
                i = 2;
                $result = url5;
                obj2 = $result2;
                String json2 = ((NiceResponse) obj2).getText();
                metaJson = new JSONObject(json2).getJSONObject("meta").toString();
                AppUtils appUtils3 = AppUtils.INSTANCE;
                Result.Companion companion9 = Result.Companion;
                KType kTypeTypeOf3 = Reflection.typeOf(CatalogEntry.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                if (Result.exceptionOrNull-impl(obj4) != null) {
                    Result.Companion companion10 = Result.Companion;
                    catalogEntry = null;
                    obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(CatalogEntry.class), (List) null, i, (Object) null));
                    break;
                } else {
                    catalogEntry = null;
                }
                if (Result.isFailure-impl(obj4)) {
                    obj4 = catalogEntry;
                }
                deserializationStrategy = (KSerializer) obj4;
                if (deserializationStrategy != null) {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, metaJson);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv7.readValue(metaJson, new TypeReference<CatalogEntry>() { // from class: com.phisher98.StreamPlayStremioCatelog$load$$inlined$parseJson$2
                    });
                }
                String str5 = $result;
                res = (CatalogEntry) objDecodeFromString2;
                url2 = str5;
                encodedId = res.getId();
                Requests app4 = MainActivityKt.getApp();
                String str6 = str;
                String str7 = getMainUrl() + "/meta/" + res.getType() + '/' + encodedId + str6;
                c02592.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c02592.L$1 = res;
                c02592.L$2 = encodedId;
                c02592.label = i;
                C02591 c02595 = c02592;
                res2 = res;
                catalogEntry2 = catalogEntry;
                encodedId2 = str6;
                $result2 = Requests.get$default(app4, str7, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02595, 4094, (Object) null);
                c02592 = c02595;
                if ($result2 == obj) {
                    return obj;
                }
                encodedId3 = encodedId;
                res3 = res2;
                url3 = url2;
                NiceResponse this_$iv3 = (NiceResponse) $result2;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(CatalogResponse.class));
                response = (CatalogResponse) safe;
                if (response == null) {
                    Requests app5 = MainActivityKt.getApp();
                    String encodedId8 = "https://v3-cinemeta.strem.io/meta/" + res3.getType() + '/' + encodedId3 + encodedId2;
                    c02592.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c02592.L$1 = res3;
                    c02592.L$2 = SpillingKt.nullOutSpilledVariable(encodedId3);
                    c02592.L$3 = SpillingKt.nullOutSpilledVariable(response);
                    c02592.label = 3;
                    encodedId5 = encodedId3;
                    res5 = res3;
                    C02591 c02596 = c02592;
                    $result2 = Requests.get$default(app5, encodedId8, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02596, 4094, (Object) null);
                    c02592 = c02596;
                    if ($result2 == obj) {
                        return obj;
                    }
                    encodedId4 = encodedId5;
                    url4 = url3;
                    res4 = res5;
                    NiceResponse this_$iv4 = (NiceResponse) $result2;
                    ResponseParser parser4 = this_$iv4.getParser();
                    Intrinsics.checkNotNull(parser4);
                    safe2 = parser4.parseSafe(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(CatalogResponse.class));
                    catalogResponse = (CatalogResponse) safe2;
                    if (catalogResponse != null) {
                        throw new RuntimeException("Failed to load meta");
                    }
                    response2 = catalogResponse;
                } else {
                    String encodedId9 = encodedId3;
                    CatalogEntry res7 = res3;
                    response2 = response;
                    encodedId4 = encodedId9;
                    url4 = url3;
                    res4 = res7;
                }
                entry = response2.getMeta();
                if (entry == null) {
                    metas = response2.getMetas();
                    if (metas != null) {
                        Iterable $this$firstOrNull$iv2 = metas;
                        it = $this$firstOrNull$iv2.iterator();
                        do {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                it2 = (CatalogEntry) element$iv;
                            } else {
                                element$iv = catalogEntry2;
                            }
                            catalogEntry3 = (CatalogEntry) element$iv;
                        } while (!Intrinsics.areEqual(it2.getId(), res4.getId()));
                        catalogEntry3 = (CatalogEntry) element$iv;
                    } else {
                        catalogEntry3 = catalogEntry2;
                    }
                    if (catalogEntry3 == null) {
                        metas2 = response2.getMetas();
                        if (metas2 != null) {
                            catalogEntry3 = (CatalogEntry) CollectionsKt.firstOrNull(metas2);
                        } else {
                            catalogEntry3 = catalogEntry2;
                        }
                        if (catalogEntry3 == null) {
                            throw new RuntimeException("Meta not found");
                        }
                    }
                    entry = catalogEntry3;
                }
                String id2 = res4.getId();
                c02592.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c02592.L$1 = SpillingKt.nullOutSpilledVariable(res4);
                c02592.L$2 = SpillingKt.nullOutSpilledVariable(encodedId4);
                c02592.L$3 = SpillingKt.nullOutSpilledVariable(response2);
                c02592.L$4 = SpillingKt.nullOutSpilledVariable(entry);
                c02592.label = 4;
                loadResponse = entry.toLoadResponse(this, id2, c02592);
                if (loadResponse == obj) {
                    return obj;
                }
                return loadResponse;
            case 2:
                String encodedId10 = (String) c02592.L$2;
                CatalogEntry res8 = (CatalogEntry) c02592.L$1;
                String url6 = (String) c02592.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                encodedId2 = ".json";
                res3 = res8;
                catalogEntry2 = null;
                url3 = url6;
                encodedId3 = encodedId10;
                NiceResponse this_$iv5 = (NiceResponse) $result2;
                ResponseParser parser5 = this_$iv5.getParser();
                Intrinsics.checkNotNull(parser5);
                safe = parser5.parseSafe(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(CatalogResponse.class));
                response = (CatalogResponse) safe;
                if (response == null) {
                    Requests app6 = MainActivityKt.getApp();
                    String encodedId11 = "https://v3-cinemeta.strem.io/meta/" + res3.getType() + '/' + encodedId3 + encodedId2;
                    c02592.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c02592.L$1 = res3;
                    c02592.L$2 = SpillingKt.nullOutSpilledVariable(encodedId3);
                    c02592.L$3 = SpillingKt.nullOutSpilledVariable(response);
                    c02592.label = 3;
                    encodedId5 = encodedId3;
                    res5 = res3;
                    C02591 c02597 = c02592;
                    $result2 = Requests.get$default(app6, encodedId11, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02597, 4094, (Object) null);
                    c02592 = c02597;
                    if ($result2 == obj) {
                        return obj;
                    }
                    encodedId4 = encodedId5;
                    url4 = url3;
                    res4 = res5;
                    NiceResponse this_$iv6 = (NiceResponse) $result2;
                    ResponseParser parser6 = this_$iv6.getParser();
                    Intrinsics.checkNotNull(parser6);
                    safe2 = parser6.parseSafe(this_$iv6.getText(), Reflection.getOrCreateKotlinClass(CatalogResponse.class));
                    catalogResponse = (CatalogResponse) safe2;
                    if (catalogResponse != null) {
                        throw new RuntimeException("Failed to load meta");
                    }
                    response2 = catalogResponse;
                } else {
                    String encodedId12 = encodedId3;
                    CatalogEntry res9 = res3;
                    response2 = response;
                    encodedId4 = encodedId12;
                    url4 = url3;
                    res4 = res9;
                }
                entry = response2.getMeta();
                if (entry == null) {
                    metas = response2.getMetas();
                    if (metas != null) {
                        Iterable $this$firstOrNull$iv3 = metas;
                        it = $this$firstOrNull$iv3.iterator();
                        do {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                it2 = (CatalogEntry) element$iv;
                            } else {
                                element$iv = catalogEntry2;
                            }
                            catalogEntry3 = (CatalogEntry) element$iv;
                        } while (!Intrinsics.areEqual(it2.getId(), res4.getId()));
                        catalogEntry3 = (CatalogEntry) element$iv;
                    } else {
                        catalogEntry3 = catalogEntry2;
                    }
                    if (catalogEntry3 == null) {
                        metas2 = response2.getMetas();
                        if (metas2 != null) {
                            catalogEntry3 = (CatalogEntry) CollectionsKt.firstOrNull(metas2);
                        } else {
                            catalogEntry3 = catalogEntry2;
                        }
                        if (catalogEntry3 == null) {
                            throw new RuntimeException("Meta not found");
                        }
                    }
                    entry = catalogEntry3;
                }
                String id3 = res4.getId();
                c02592.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c02592.L$1 = SpillingKt.nullOutSpilledVariable(res4);
                c02592.L$2 = SpillingKt.nullOutSpilledVariable(encodedId4);
                c02592.L$3 = SpillingKt.nullOutSpilledVariable(response2);
                c02592.L$4 = SpillingKt.nullOutSpilledVariable(entry);
                c02592.label = 4;
                loadResponse = entry.toLoadResponse(this, id3, c02592);
                if (loadResponse == obj) {
                    return obj;
                }
                return loadResponse;
            case 3:
                encodedId4 = (String) c02592.L$2;
                res4 = (CatalogEntry) c02592.L$1;
                url4 = (String) c02592.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                catalogEntry2 = null;
                NiceResponse this_$iv7 = (NiceResponse) $result2;
                ResponseParser parser7 = this_$iv7.getParser();
                Intrinsics.checkNotNull(parser7);
                safe2 = parser7.parseSafe(this_$iv7.getText(), Reflection.getOrCreateKotlinClass(CatalogResponse.class));
                catalogResponse = (CatalogResponse) safe2;
                if (catalogResponse != null) {
                    throw new RuntimeException("Failed to load meta");
                }
                response2 = catalogResponse;
                entry = response2.getMeta();
                if (entry == null) {
                    metas = response2.getMetas();
                    if (metas != null) {
                        Iterable $this$firstOrNull$iv4 = metas;
                        it = $this$firstOrNull$iv4.iterator();
                        do {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                it2 = (CatalogEntry) element$iv;
                            } else {
                                element$iv = catalogEntry2;
                            }
                            catalogEntry3 = (CatalogEntry) element$iv;
                        } while (!Intrinsics.areEqual(it2.getId(), res4.getId()));
                        catalogEntry3 = (CatalogEntry) element$iv;
                    } else {
                        catalogEntry3 = catalogEntry2;
                    }
                    if (catalogEntry3 == null) {
                        metas2 = response2.getMetas();
                        if (metas2 != null) {
                            catalogEntry3 = (CatalogEntry) CollectionsKt.firstOrNull(metas2);
                        } else {
                            catalogEntry3 = catalogEntry2;
                        }
                        if (catalogEntry3 == null) {
                            throw new RuntimeException("Meta not found");
                        }
                    }
                    entry = catalogEntry3;
                }
                String id4 = res4.getId();
                c02592.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c02592.L$1 = SpillingKt.nullOutSpilledVariable(res4);
                c02592.L$2 = SpillingKt.nullOutSpilledVariable(encodedId4);
                c02592.L$3 = SpillingKt.nullOutSpilledVariable(response2);
                c02592.L$4 = SpillingKt.nullOutSpilledVariable(entry);
                c02592.label = 4;
                loadResponse = entry.toLoadResponse(this, id4, c02592);
                if (loadResponse == obj) {
                    return obj;
                }
                return loadResponse;
            case 4:
                ResultKt.throwOnFailure($result2);
                return $result2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x015e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0182 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x0183  */
    /* JADX WARN: Code duplicated, block: B:50:0x0195  */
    /* JADX WARN: Code duplicated, block: B:53:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:54:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:57:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:62:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:66:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:68:0x0215  */
    /* JADX WARN: Code duplicated, block: B:73:0x028e A[LOOP:1: B:71:0x0288->B:73:0x028e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:76:0x0356 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:77:0x0357  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:88:0x0218 A[SYNTHETIC] */
    @RequiresApi(26)
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C02601 c02601;
        Object obj;
        Object objDecodeFromString;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        LoadData res;
        boolean isCasting2;
        Object obj2;
        String data2;
        String imdb;
        String it;
        String imdb2;
        CinemetaMetaData cinemetaMetaData;
        boolean isCasting3;
        LoadData res2;
        Object objFetchCinemetaMeta;
        Function1<? super SubtitleFile, Unit> function5;
        Function1<? super ExtractorLink, Unit> function6;
        String imdb3;
        boolean isCasting4;
        CinemetaMetaData cinemeta;
        String title;
        LoadData resolved;
        SharedPreferences sharedPreferences;
        Set disabledProviderIds;
        Iterable $this$filter$iv;
        Collection destination$iv$iv;
        Function1<? super ExtractorLink, Unit> function7;
        String imdb4;
        Function1<? super SubtitleFile, Unit> function8;
        String authToken;
        SpreadBuilder spreadBuilder;
        Iterable $this$map$iv;
        Set disabledProviderIds2;
        Collection destination$iv$iv2;
        Function1[] function1Arr;
        Provider it2;
        Set<String> stringSet;
        if (continuation instanceof C02601) {
            c02601 = (C02601) continuation;
            if ((c02601.label & Integer.MIN_VALUE) != 0) {
                c02601.label -= Integer.MIN_VALUE;
            } else {
                c02601 = new C02601(continuation);
            }
        } else {
            c02601 = new C02601(continuation);
        }
        C02601 c02602 = c02601;
        Object $result = c02602.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02602.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(LoadData.class);
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
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadData.class), (List) null, 2, (Object) null));
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
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<LoadData>() { // from class: com.phisher98.StreamPlayStremioCatelog$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<LoadData>() { // from class: com.phisher98.StreamPlayStremioCatelog$loadLinks$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<LoadData>() { // from class: com.phisher98.StreamPlayStremioCatelog$loadLinks$$inlined$parseJson$1
                    });
                }
                LoadData res3 = (LoadData) objDecodeFromString;
                c02602.L$0 = SpillingKt.nullOutSpilledVariable(data);
                function3 = function1;
                c02602.L$1 = function3;
                function4 = function2;
                c02602.L$2 = function4;
                c02602.L$3 = res3;
                c02602.Z$0 = isCasting;
                c02602.label = 1;
                Object objResolveImdbId = resolveImdbId(res3, c02602);
                if (objResolveImdbId == coroutine_suspended) {
                    return coroutine_suspended;
                }
                res = res3;
                isCasting2 = isCasting;
                obj2 = objResolveImdbId;
                data2 = data;
                imdb = (String) obj2;
                if (imdb != null) {
                    String type = res.getType();
                    c02602.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c02602.L$1 = function3;
                    c02602.L$2 = function4;
                    c02602.L$3 = res;
                    c02602.L$4 = imdb;
                    c02602.L$5 = SpillingKt.nullOutSpilledVariable(imdb);
                    c02602.Z$0 = isCasting2;
                    c02602.label = 2;
                    objFetchCinemetaMeta = fetchCinemetaMeta(imdb, type, c02602);
                    if (objFetchCinemetaMeta == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function5 = function3;
                    it = data2;
                    function6 = function4;
                    imdb3 = imdb;
                    isCasting4 = isCasting2;
                    cinemetaMetaData = (CinemetaMetaData) objFetchCinemetaMeta;
                    imdb2 = imdb3;
                    function4 = function6;
                    function3 = function5;
                    isCasting3 = isCasting4;
                    res2 = res;
                } else {
                    it = data2;
                    imdb2 = imdb;
                    cinemetaMetaData = null;
                    isCasting3 = isCasting2;
                    res2 = res;
                }
                cinemeta = cinemetaMetaData;
                if (cinemeta != null) {
                    title = cinemeta.getTitle();
                } else {
                    title = null;
                }
                String imdb5 = imdb2;
                resolved = LoadData.copy$default(res2, null, null, null, null, imdb5, null, title, 47, null);
                LoadData res4 = res2;
                sharedPreferences = this.sharedPref;
                if (sharedPreferences != null || (stringSet = sharedPreferences.getStringSet("disabled_providers", SetsKt.emptySet())) == null || (disabledProviderIds = CollectionsKt.toSet(stringSet)) == null) {
                    disabledProviderIds = SetsKt.emptySet();
                }
                $this$filter$iv = ProvidersListKt.buildProviders();
                destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    Iterable $this$filter$iv2 = $this$filter$iv;
                    it2 = (Provider) element$iv$iv;
                    Function1<? super SubtitleFile, Unit> function9 = function3;
                    if (!disabledProviderIds.contains(it2.getId())) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $this$filter$iv = $this$filter$iv2;
                    function3 = function9;
                }
                Function1<? super SubtitleFile, Unit> function10 = function3;
                Iterable providersList = (List) destination$iv$iv;
                function7 = function4;
                imdb4 = imdb5;
                function8 = function10;
                Collection<Function1<Continuation<? super Unit>, Object>> collectionValues = StreamPlayStremioAddonSettings.INSTANCE.getDynamicStremioMap(this.sharedPref, imdb5, resolved.getSeason(), resolved.getEpisode(), function10, function7).values();
                authToken = StreamPlayExtractor.INSTANCE.getToken();
                spreadBuilder = new SpreadBuilder(4);
                spreadBuilder.add(new C02612(imdb4, resolved, function8, null));
                spreadBuilder.add(new C02623(imdb4, res4, function8, null));
                $this$map$iv = providersList;
                disabledProviderIds2 = disabledProviderIds;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    SpreadBuilder spreadBuilder2 = spreadBuilder;
                    Provider provider = (Provider) item$iv$iv;
                    Collection destination$iv$iv3 = destination$iv$iv2;
                    Function1<? super ExtractorLink, Unit> function11 = function7;
                    String imdb6 = imdb4;
                    Function1<? super SubtitleFile, Unit> function12 = function8;
                    destination$iv$iv3.add(new StreamPlayStremioCatelog$loadLinks$4$1(provider, this, resolved, function12, function11, authToken, null));
                    function8 = function12;
                    imdb4 = imdb6;
                    function7 = function11;
                    spreadBuilder = spreadBuilder2;
                    destination$iv$iv2 = destination$iv$iv3;
                    disabledProviderIds2 = disabledProviderIds2;
                    $this$map$iv = $this$map$iv;
                    $result = $result;
                }
                SpreadBuilder spreadBuilder3 = spreadBuilder;
                Collection $this$toTypedArray$iv = (List) destination$iv$iv2;
                spreadBuilder3.addSpread($this$toTypedArray$iv.toArray(new Function1[0]));
                spreadBuilder3.addSpread(collectionValues.toArray(new Function1[0]));
                function1Arr = (Function1[]) spreadBuilder3.toArray(new Function1[spreadBuilder3.size()]);
                c02602.L$0 = SpillingKt.nullOutSpilledVariable(it);
                c02602.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                c02602.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                c02602.L$3 = SpillingKt.nullOutSpilledVariable(res4);
                c02602.L$4 = SpillingKt.nullOutSpilledVariable(imdb4);
                c02602.L$5 = SpillingKt.nullOutSpilledVariable(cinemeta);
                c02602.L$6 = SpillingKt.nullOutSpilledVariable(resolved);
                c02602.L$7 = SpillingKt.nullOutSpilledVariable(disabledProviderIds2);
                c02602.L$8 = SpillingKt.nullOutSpilledVariable(providersList);
                c02602.L$9 = SpillingKt.nullOutSpilledVariable(collectionValues);
                c02602.L$10 = SpillingKt.nullOutSpilledVariable(authToken);
                c02602.Z$0 = isCasting3;
                c02602.label = 3;
                if (StreamPlayUtilsKt.runLimitedAsync(10, function1Arr, c02602) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            case 1:
                isCasting2 = c02602.Z$0;
                LoadData res5 = (LoadData) c02602.L$3;
                function4 = (Function1) c02602.L$2;
                Function1<? super SubtitleFile, Unit> function13 = (Function1) c02602.L$1;
                data2 = (String) c02602.L$0;
                ResultKt.throwOnFailure($result);
                res = res5;
                function3 = function13;
                obj2 = $result;
                imdb = (String) obj2;
                if (imdb != null) {
                    String type2 = res.getType();
                    c02602.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c02602.L$1 = function3;
                    c02602.L$2 = function4;
                    c02602.L$3 = res;
                    c02602.L$4 = imdb;
                    c02602.L$5 = SpillingKt.nullOutSpilledVariable(imdb);
                    c02602.Z$0 = isCasting2;
                    c02602.label = 2;
                    objFetchCinemetaMeta = fetchCinemetaMeta(imdb, type2, c02602);
                    if (objFetchCinemetaMeta == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function5 = function3;
                    it = data2;
                    function6 = function4;
                    imdb3 = imdb;
                    isCasting4 = isCasting2;
                    cinemetaMetaData = (CinemetaMetaData) objFetchCinemetaMeta;
                    imdb2 = imdb3;
                    function4 = function6;
                    function3 = function5;
                    isCasting3 = isCasting4;
                    res2 = res;
                } else {
                    it = data2;
                    imdb2 = imdb;
                    cinemetaMetaData = null;
                    isCasting3 = isCasting2;
                    res2 = res;
                }
                cinemeta = cinemetaMetaData;
                if (cinemeta != null) {
                    title = cinemeta.getTitle();
                } else {
                    title = null;
                }
                String imdb7 = imdb2;
                resolved = LoadData.copy$default(res2, null, null, null, null, imdb7, null, title, 47, null);
                LoadData res6 = res2;
                sharedPreferences = this.sharedPref;
                if (sharedPreferences != null) {
                    disabledProviderIds = SetsKt.emptySet();
                } else {
                    disabledProviderIds = SetsKt.emptySet();
                }
                $this$filter$iv = ProvidersListKt.buildProviders();
                destination$iv$iv = new ArrayList();
                while (r20.hasNext()) {
                    Iterable $this$filter$iv3 = $this$filter$iv;
                    it2 = (Provider) element$iv$iv;
                    Function1<? super SubtitleFile, Unit> function14 = function3;
                    if (!disabledProviderIds.contains(it2.getId())) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $this$filter$iv = $this$filter$iv3;
                    function3 = function14;
                }
                Function1<? super SubtitleFile, Unit> function15 = function3;
                Iterable providersList2 = (List) destination$iv$iv;
                function7 = function4;
                imdb4 = imdb7;
                function8 = function15;
                Collection<Function1<Continuation<? super Unit>, Object>> collectionValues2 = StreamPlayStremioAddonSettings.INSTANCE.getDynamicStremioMap(this.sharedPref, imdb7, resolved.getSeason(), resolved.getEpisode(), function15, function7).values();
                authToken = StreamPlayExtractor.INSTANCE.getToken();
                spreadBuilder = new SpreadBuilder(4);
                spreadBuilder.add(new C02612(imdb4, resolved, function8, null));
                spreadBuilder.add(new C02623(imdb4, res6, function8, null));
                $this$map$iv = providersList2;
                disabledProviderIds2 = disabledProviderIds;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r21.hasNext()) {
                    SpreadBuilder spreadBuilder4 = spreadBuilder;
                    Provider provider2 = (Provider) item$iv$iv;
                    Collection destination$iv$iv4 = destination$iv$iv2;
                    Function1<? super ExtractorLink, Unit> function16 = function7;
                    String imdb8 = imdb4;
                    Function1<? super SubtitleFile, Unit> function17 = function8;
                    destination$iv$iv4.add(new StreamPlayStremioCatelog$loadLinks$4$1(provider2, this, resolved, function17, function16, authToken, null));
                    function8 = function17;
                    imdb4 = imdb8;
                    function7 = function16;
                    spreadBuilder = spreadBuilder4;
                    destination$iv$iv2 = destination$iv$iv4;
                    disabledProviderIds2 = disabledProviderIds2;
                    $this$map$iv = $this$map$iv;
                    $result = $result;
                }
                SpreadBuilder spreadBuilder5 = spreadBuilder;
                Collection $this$toTypedArray$iv2 = (List) destination$iv$iv2;
                spreadBuilder5.addSpread($this$toTypedArray$iv2.toArray(new Function1[0]));
                spreadBuilder5.addSpread(collectionValues2.toArray(new Function1[0]));
                function1Arr = (Function1[]) spreadBuilder5.toArray(new Function1[spreadBuilder5.size()]);
                c02602.L$0 = SpillingKt.nullOutSpilledVariable(it);
                c02602.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                c02602.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                c02602.L$3 = SpillingKt.nullOutSpilledVariable(res6);
                c02602.L$4 = SpillingKt.nullOutSpilledVariable(imdb4);
                c02602.L$5 = SpillingKt.nullOutSpilledVariable(cinemeta);
                c02602.L$6 = SpillingKt.nullOutSpilledVariable(resolved);
                c02602.L$7 = SpillingKt.nullOutSpilledVariable(disabledProviderIds2);
                c02602.L$8 = SpillingKt.nullOutSpilledVariable(providersList2);
                c02602.L$9 = SpillingKt.nullOutSpilledVariable(collectionValues2);
                c02602.L$10 = SpillingKt.nullOutSpilledVariable(authToken);
                c02602.Z$0 = isCasting3;
                c02602.label = 3;
                if (StreamPlayUtilsKt.runLimitedAsync(10, function1Arr, c02602) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            case 2:
                boolean isCasting5 = c02602.Z$0;
                imdb3 = (String) c02602.L$4;
                res = (LoadData) c02602.L$3;
                function6 = (Function1) c02602.L$2;
                function5 = (Function1) c02602.L$1;
                it = (String) c02602.L$0;
                ResultKt.throwOnFailure($result);
                isCasting4 = isCasting5;
                objFetchCinemetaMeta = $result;
                cinemetaMetaData = (CinemetaMetaData) objFetchCinemetaMeta;
                imdb2 = imdb3;
                function4 = function6;
                function3 = function5;
                isCasting3 = isCasting4;
                res2 = res;
                cinemeta = cinemetaMetaData;
                if (cinemeta != null) {
                    title = cinemeta.getTitle();
                } else {
                    title = null;
                }
                String imdb9 = imdb2;
                resolved = LoadData.copy$default(res2, null, null, null, null, imdb9, null, title, 47, null);
                LoadData res7 = res2;
                sharedPreferences = this.sharedPref;
                if (sharedPreferences != null) {
                    disabledProviderIds = SetsKt.emptySet();
                } else {
                    disabledProviderIds = SetsKt.emptySet();
                }
                $this$filter$iv = ProvidersListKt.buildProviders();
                destination$iv$iv = new ArrayList();
                while (r20.hasNext()) {
                    Iterable $this$filter$iv4 = $this$filter$iv;
                    it2 = (Provider) element$iv$iv;
                    Function1<? super SubtitleFile, Unit> function18 = function3;
                    if (!disabledProviderIds.contains(it2.getId())) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $this$filter$iv = $this$filter$iv4;
                    function3 = function18;
                }
                Function1<? super SubtitleFile, Unit> function19 = function3;
                Iterable providersList3 = (List) destination$iv$iv;
                function7 = function4;
                imdb4 = imdb9;
                function8 = function19;
                Collection<Function1<Continuation<? super Unit>, Object>> collectionValues3 = StreamPlayStremioAddonSettings.INSTANCE.getDynamicStremioMap(this.sharedPref, imdb9, resolved.getSeason(), resolved.getEpisode(), function19, function7).values();
                authToken = StreamPlayExtractor.INSTANCE.getToken();
                spreadBuilder = new SpreadBuilder(4);
                spreadBuilder.add(new C02612(imdb4, resolved, function8, null));
                spreadBuilder.add(new C02623(imdb4, res7, function8, null));
                $this$map$iv = providersList3;
                disabledProviderIds2 = disabledProviderIds;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r21.hasNext()) {
                    SpreadBuilder spreadBuilder6 = spreadBuilder;
                    Provider provider3 = (Provider) item$iv$iv;
                    Collection destination$iv$iv5 = destination$iv$iv2;
                    Function1<? super ExtractorLink, Unit> function110 = function7;
                    String imdb10 = imdb4;
                    Function1<? super SubtitleFile, Unit> function111 = function8;
                    destination$iv$iv5.add(new StreamPlayStremioCatelog$loadLinks$4$1(provider3, this, resolved, function111, function110, authToken, null));
                    function8 = function111;
                    imdb4 = imdb10;
                    function7 = function110;
                    spreadBuilder = spreadBuilder6;
                    destination$iv$iv2 = destination$iv$iv5;
                    disabledProviderIds2 = disabledProviderIds2;
                    $this$map$iv = $this$map$iv;
                    $result = $result;
                }
                SpreadBuilder spreadBuilder7 = spreadBuilder;
                Collection $this$toTypedArray$iv3 = (List) destination$iv$iv2;
                spreadBuilder7.addSpread($this$toTypedArray$iv3.toArray(new Function1[0]));
                spreadBuilder7.addSpread(collectionValues3.toArray(new Function1[0]));
                function1Arr = (Function1[]) spreadBuilder7.toArray(new Function1[spreadBuilder7.size()]);
                c02602.L$0 = SpillingKt.nullOutSpilledVariable(it);
                c02602.L$1 = SpillingKt.nullOutSpilledVariable(function8);
                c02602.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                c02602.L$3 = SpillingKt.nullOutSpilledVariable(res7);
                c02602.L$4 = SpillingKt.nullOutSpilledVariable(imdb4);
                c02602.L$5 = SpillingKt.nullOutSpilledVariable(cinemeta);
                c02602.L$6 = SpillingKt.nullOutSpilledVariable(resolved);
                c02602.L$7 = SpillingKt.nullOutSpilledVariable(disabledProviderIds2);
                c02602.L$8 = SpillingKt.nullOutSpilledVariable(providersList3);
                c02602.L$9 = SpillingKt.nullOutSpilledVariable(collectionValues3);
                c02602.L$10 = SpillingKt.nullOutSpilledVariable(authToken);
                c02602.Z$0 = isCasting3;
                c02602.label = 3;
                if (StreamPlayUtilsKt.runLimitedAsync(10, function1Arr, c02602) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            case 3:
                boolean z = c02602.Z$0;
                ResultKt.throwOnFailure($result);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioCatelog$loadLinks$2 */
    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayStremioCatelog$loadLinks$2", f = "StreamPlayStremioCatelog.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, nl = {153}, s = {}, v = 2)
    static final class C02612 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $imdb;
        final /* synthetic */ LoadData $resolved;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02612(String str, LoadData loadData, Function1<? super SubtitleFile, Unit> function1, Continuation<? super C02612> continuation) {
            super(1, continuation);
            this.$imdb = str;
            this.$resolved = loadData;
            this.$subtitleCallback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C02612(this.$imdb, this.$resolved, this.$subtitleCallback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (StreamPlayExtractor.INSTANCE.invokeSubtitleAPI(this.$imdb, this.$resolved.getSeason(), this.$resolved.getEpisode(), this.$subtitleCallback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioCatelog$loadLinks$3 */
    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayStremioCatelog$loadLinks$3", f = "StreamPlayStremioCatelog.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, nl = {160}, s = {}, v = 2)
    static final class C02623 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $imdb;
        final /* synthetic */ LoadData $res;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02623(String str, LoadData loadData, Function1<? super SubtitleFile, Unit> function1, Continuation<? super C02623> continuation) {
            super(1, continuation);
            this.$imdb = str;
            this.$res = loadData;
            this.$subtitleCallback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C02623(this.$imdb, this.$res, this.$subtitleCallback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (StreamPlayExtractor.INSTANCE.invokeWYZIESubs(this.$imdb, this.$res.getSeason(), this.$res.getEpisode(), this.$subtitleCallback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelog$LoadData;", "", "type", "", "id", "season", "", "episode", "imdbId", "year", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getId", "getSeason", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisode", "getImdbId", "getYear", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/StreamPlayStremioCatelog$LoadData;", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LoadData {

        @Nullable
        private final Integer episode;

        @Nullable
        private final String id;

        @Nullable
        private final String imdbId;

        @Nullable
        private final Integer season;

        @Nullable
        private final String title;

        @Nullable
        private final String type;

        @Nullable
        private final Integer year;

        public LoadData() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ LoadData copy$default(LoadData loadData, String str, String str2, Integer num, Integer num2, String str3, Integer num3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadData.type;
            }
            if ((i & 2) != 0) {
                str2 = loadData.id;
            }
            if ((i & 4) != 0) {
                num = loadData.season;
            }
            if ((i & 8) != 0) {
                num2 = loadData.episode;
            }
            if ((i & 16) != 0) {
                str3 = loadData.imdbId;
            }
            if ((i & 32) != 0) {
                num3 = loadData.year;
            }
            if ((i & 64) != 0) {
                str4 = loadData.title;
            }
            Integer num4 = num3;
            String str5 = str4;
            String str6 = str3;
            Integer num5 = num;
            return loadData.copy(str, str2, num5, num2, str6, num4, str5);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final LoadData copy(@Nullable String type, @Nullable String id, @Nullable Integer season, @Nullable Integer episode, @Nullable String imdbId, @Nullable Integer year, @Nullable String title) {
            return new LoadData(type, id, season, episode, imdbId, year, title);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadData)) {
                return false;
            }
            LoadData loadData = (LoadData) other;
            return Intrinsics.areEqual(this.type, loadData.type) && Intrinsics.areEqual(this.id, loadData.id) && Intrinsics.areEqual(this.season, loadData.season) && Intrinsics.areEqual(this.episode, loadData.episode) && Intrinsics.areEqual(this.imdbId, loadData.imdbId) && Intrinsics.areEqual(this.year, loadData.year) && Intrinsics.areEqual(this.title, loadData.title);
        }

        public int hashCode() {
            return ((((((((((((this.type == null ? 0 : this.type.hashCode()) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.title != null ? this.title.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "LoadData(type=" + this.type + ", id=" + this.id + ", season=" + this.season + ", episode=" + this.episode + ", imdbId=" + this.imdbId + ", year=" + this.year + ", title=" + this.title + ')';
        }

        public LoadData(@Nullable String type, @Nullable String id, @Nullable Integer season, @Nullable Integer episode, @Nullable String imdbId, @Nullable Integer year, @Nullable String title) {
            this.type = type;
            this.id = id;
            this.season = season;
            this.episode = episode;
            this.imdbId = imdbId;
            this.year = year;
            this.title = title;
        }

        public /* synthetic */ LoadData(String str, String str2, Integer num, Integer num2, String str3, Integer num3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : num3, (i & 64) != 0 ? null : str4);
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreamPlay.LinkData toLinkData(LoadData $this$toLinkData) {
        return new StreamPlay.LinkData(null, $this$toLinkData.getImdbId(), null, $this$toLinkData.getType(), $this$toLinkData.getSeason(), $this$toLinkData.getEpisode(), null, null, null, $this$toLinkData.getTitle(), $this$toLinkData.getYear(), null, false, null, null, null, null, null, null, false, false, false, null, null, false, null, 67107269, null);
    }

    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelog$Manifest;", "", "catalogs", "", "Lcom/phisher98/StreamPlayStremioCatelog$Catalog;", "<init>", "(Ljava/util/List;)V", "getCatalogs", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class Manifest {

        @NotNull
        private final List<Catalog> catalogs;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Manifest copy$default(Manifest manifest, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = manifest.catalogs;
            }
            return manifest.copy(list);
        }

        @NotNull
        public final List<Catalog> component1() {
            return this.catalogs;
        }

        @NotNull
        public final Manifest copy(@NotNull List<Catalog> catalogs) {
            return new Manifest(catalogs);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Manifest) && Intrinsics.areEqual(this.catalogs, ((Manifest) other).catalogs);
        }

        public int hashCode() {
            return this.catalogs.hashCode();
        }

        @NotNull
        public String toString() {
            return "Manifest(catalogs=" + this.catalogs + ')';
        }

        public Manifest(@NotNull List<Catalog> list) {
            this.catalogs = list;
        }

        @NotNull
        public final List<Catalog> getCatalogs() {
            return this.catalogs;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001dJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J;\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0003HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006("}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelog$Catalog;", "", "name", "", "id", "type", "types", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getId", "getType", "getTypes", "()Ljava/util/List;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "provider", "Lcom/phisher98/StreamPlayStremioCatelog;", "(Ljava/lang/String;Lcom/phisher98/StreamPlayStremioCatelog;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHomePageList", "Lcom/lagradost/cloudstream3/HomePageList;", "skip", "", "(Lcom/phisher98/StreamPlayStremioCatelog;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nStreamPlayStremioCatelog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayStremioCatelog.kt\ncom/phisher98/StreamPlayStremioCatelog$Catalog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,451:1\n2068#2:452\n2068#2,2:458\n2069#2:460\n2068#2:461\n2068#2,2:467\n2069#2:469\n73#3,5:453\n73#3,5:462\n*S KotlinDebug\n*F\n+ 1 StreamPlayStremioCatelog.kt\ncom/phisher98/StreamPlayStremioCatelog$Catalog\n*L\n220#1:452\n225#1:458,2\n220#1:460\n235#1:461\n247#1:467,2\n235#1:469\n224#1:453,5\n245#1:462,5\n*E\n"})
    static final /* data */ class Catalog {

        @NotNull
        private final String id;

        @Nullable
        private String name;

        @Nullable
        private final String type;

        @NotNull
        private final List<String> types;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Catalog copy$default(Catalog catalog, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = catalog.name;
            }
            if ((i & 2) != 0) {
                str2 = catalog.id;
            }
            if ((i & 4) != 0) {
                str3 = catalog.type;
            }
            if ((i & 8) != 0) {
                list = catalog.types;
            }
            return catalog.copy(str, str2, str3, list);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final List<String> component4() {
            return this.types;
        }

        @NotNull
        public final Catalog copy(@Nullable String name, @NotNull String id, @Nullable String type, @NotNull List<String> types) {
            return new Catalog(name, id, type, types);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Catalog)) {
                return false;
            }
            Catalog catalog = (Catalog) other;
            return Intrinsics.areEqual(this.name, catalog.name) && Intrinsics.areEqual(this.id, catalog.id) && Intrinsics.areEqual(this.type, catalog.type) && Intrinsics.areEqual(this.types, catalog.types);
        }

        public int hashCode() {
            return ((((((this.name == null ? 0 : this.name.hashCode()) * 31) + this.id.hashCode()) * 31) + (this.type != null ? this.type.hashCode() : 0)) * 31) + this.types.hashCode();
        }

        @NotNull
        public String toString() {
            return "Catalog(name=" + this.name + ", id=" + this.id + ", type=" + this.type + ", types=" + this.types + ')';
        }

        public Catalog(@Nullable String name, @NotNull String id, @Nullable String type, @NotNull List<String> list) {
            this.name = name;
            this.id = id;
            this.type = type;
            this.types = list;
            if (this.type != null) {
                this.types.add(this.type);
            }
        }

        public /* synthetic */ Catalog(String str, String str2, String str3, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i & 8) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        public final void setName(@Nullable String str) {
            this.name = str;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final List<String> getTypes() {
            return this.types;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x008e  */
        /* JADX WARN: Code duplicated, block: B:18:0x012a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:19:0x012b  */
        /* JADX WARN: Code duplicated, block: B:27:0x015d  */
        /* JADX WARN: Code duplicated, block: B:32:0x0170 A[LOOP:0: B:30:0x016a->B:32:0x0170, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:7:0x0018  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x012b -> B:20:0x0137). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object search(@org.jetbrains.annotations.NotNull java.lang.String r33, @org.jetbrains.annotations.NotNull com.phisher98.StreamPlayStremioCatelog r34, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r35) {
            /*
                Method dump skipped, instruction units count: 404
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayStremioCatelog.Catalog.search(java.lang.String, com.phisher98.StreamPlayStremioCatelog, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Code duplicated, block: B:16:0x008e  */
        /* JADX WARN: Code duplicated, block: B:18:0x00a0  */
        /* JADX WARN: Code duplicated, block: B:19:0x00d2  */
        /* JADX WARN: Code duplicated, block: B:22:0x015c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x015d  */
        /* JADX WARN: Code duplicated, block: B:31:0x0192  */
        /* JADX WARN: Code duplicated, block: B:42:0x01d5  */
        /* JADX WARN: Code duplicated, block: B:7:0x0018  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x015d -> B:24:0x016c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object toHomePageList(@org.jetbrains.annotations.NotNull com.phisher98.StreamPlayStremioCatelog r38, int r39, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageList> r40) {
            /*
                Method dump skipped, instruction units count: 526
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayStremioCatelog.Catalog.toHomePageList(com.phisher98.StreamPlayStremioCatelog, int, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelog$CatalogResponse;", "", "metas", "", "Lcom/phisher98/StreamPlayStremioCatelog$CatalogEntry;", "meta", "<init>", "(Ljava/util/List;Lcom/phisher98/StreamPlayStremioCatelog$CatalogEntry;)V", "getMetas", "()Ljava/util/List;", "getMeta", "()Lcom/phisher98/StreamPlayStremioCatelog$CatalogEntry;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class CatalogResponse {

        @Nullable
        private final CatalogEntry meta;

        @Nullable
        private final List<CatalogEntry> metas;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CatalogResponse copy$default(CatalogResponse catalogResponse, List list, CatalogEntry catalogEntry, int i, Object obj) {
            if ((i & 1) != 0) {
                list = catalogResponse.metas;
            }
            if ((i & 2) != 0) {
                catalogEntry = catalogResponse.meta;
            }
            return catalogResponse.copy(list, catalogEntry);
        }

        @Nullable
        public final List<CatalogEntry> component1() {
            return this.metas;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CatalogEntry getMeta() {
            return this.meta;
        }

        @NotNull
        public final CatalogResponse copy(@Nullable List<CatalogEntry> metas, @Nullable CatalogEntry meta) {
            return new CatalogResponse(metas, meta);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CatalogResponse)) {
                return false;
            }
            CatalogResponse catalogResponse = (CatalogResponse) other;
            return Intrinsics.areEqual(this.metas, catalogResponse.metas) && Intrinsics.areEqual(this.meta, catalogResponse.meta);
        }

        public int hashCode() {
            return ((this.metas == null ? 0 : this.metas.hashCode()) * 31) + (this.meta != null ? this.meta.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CatalogResponse(metas=" + this.metas + ", meta=" + this.meta + ')';
        }

        public CatalogResponse(@Nullable List<CatalogEntry> list, @Nullable CatalogEntry meta) {
            this.metas = list;
            this.meta = meta;
        }

        @Nullable
        public final CatalogEntry getMeta() {
            return this.meta;
        }

        @Nullable
        public final List<CatalogEntry> getMetas() {
            return this.metas;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelog$Trailer;", "", "source", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class Trailer {

        @Nullable
        private final String source;

        @Nullable
        private final String type;

        public static /* synthetic */ Trailer copy$default(Trailer trailer, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = trailer.source;
            }
            if ((i & 2) != 0) {
                str2 = trailer.type;
            }
            return trailer.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final Trailer copy(@Nullable String source, @Nullable String type) {
            return new Trailer(source, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Trailer)) {
                return false;
            }
            Trailer trailer = (Trailer) other;
            return Intrinsics.areEqual(this.source, trailer.source) && Intrinsics.areEqual(this.type, trailer.type);
        }

        public int hashCode() {
            return ((this.source == null ? 0 : this.source.hashCode()) * 31) + (this.type != null ? this.type.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Trailer(source=" + this.source + ", type=" + this.type + ')';
        }

        public Trailer(@Nullable String source, @Nullable String type) {
            this.source = source;
            this.type = type;
        }

        @Nullable
        public final String getSource() {
            return this.source;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001Bí\u0002\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u001e\b\u0001\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u001e\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u001c\b\u0003\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u001c\b\u0003\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u001c\b\u0003\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+J \u0010,\u001a\u00020-2\u0006\u0010*\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0002\u0010/J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00130\rHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jï\u0002\u0010=\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u001e\b\u0003\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u001e\b\u0003\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u001c\b\u0003\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u001c\b\u0003\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u001c\b\u0003\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00142\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016HÆ\u0001J\u0014\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010A\u001a\u00020BHÖ\u0081\u0004J\n\u0010C\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001a¨\u0006D"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelog$CatalogEntry;", "", "name", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "id", "poster", "background", "description", "imdbRating", "type", "videos", "", "Lcom/phisher98/StreamPlayStremioCatelog$Video;", "genre", "genres", "cast", "trailersSources", "Lcom/phisher98/StreamPlayStremioCatelog$Trailer;", "trailers", "yearNum", "year", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getId", "getPoster", "getBackground", "getDescription", "getImdbRating", "getType", "getVideos", "()Ljava/util/List;", "getGenre", "getGenres", "getCast", "getTrailersSources", "getYearNum", "toSearchResponse", "Lcom/lagradost/cloudstream3/SearchResponse;", "provider", "Lcom/phisher98/StreamPlayStremioCatelog;", "toLoadResponse", "Lcom/lagradost/cloudstream3/LoadResponse;", "imdbId", "(Lcom/phisher98/StreamPlayStremioCatelog;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nStreamPlayStremioCatelog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayStremioCatelog.kt\ncom/phisher98/StreamPlayStremioCatelog$CatalogEntry\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,451:1\n1739#2:452\n1814#2,3:453\n*S KotlinDebug\n*F\n+ 1 StreamPlayStremioCatelog.kt\ncom/phisher98/StreamPlayStremioCatelog$CatalogEntry\n*L\n316#1:452\n316#1:453,3\n*E\n"})
    static final /* data */ class CatalogEntry {

        @Nullable
        private final String background;

        @NotNull
        private final List<String> cast;

        @Nullable
        private final String description;

        @Nullable
        private final List<String> genre;

        @NotNull
        private final List<String> genres;

        @NotNull
        private final String id;

        @Nullable
        private final String imdbRating;

        @NotNull
        private final String name;

        @Nullable
        private final String poster;

        @NotNull
        private final List<Trailer> trailersSources;

        @Nullable
        private final String type;

        @Nullable
        private final List<Video> videos;

        @Nullable
        private final String yearNum;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CatalogEntry copy$default(CatalogEntry catalogEntry, String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, List list2, List list3, List list4, List list5, String str8, int i, Object obj) {
            if ((i & 1) != 0) {
                str = catalogEntry.name;
            }
            return catalogEntry.copy(str, (i & 2) != 0 ? catalogEntry.id : str2, (i & 4) != 0 ? catalogEntry.poster : str3, (i & 8) != 0 ? catalogEntry.background : str4, (i & 16) != 0 ? catalogEntry.description : str5, (i & 32) != 0 ? catalogEntry.imdbRating : str6, (i & 64) != 0 ? catalogEntry.type : str7, (i & 128) != 0 ? catalogEntry.videos : list, (i & 256) != 0 ? catalogEntry.genre : list2, (i & 512) != 0 ? catalogEntry.genres : list3, (i & 1024) != 0 ? catalogEntry.cast : list4, (i & 2048) != 0 ? catalogEntry.trailersSources : list5, (i & 4096) != 0 ? catalogEntry.yearNum : str8);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final List<String> component10() {
            return this.genres;
        }

        @NotNull
        public final List<String> component11() {
            return this.cast;
        }

        @NotNull
        public final List<Trailer> component12() {
            return this.trailersSources;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getYearNum() {
            return this.yearNum;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getBackground() {
            return this.background;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final List<Video> component8() {
            return this.videos;
        }

        @Nullable
        public final List<String> component9() {
            return this.genre;
        }

        @NotNull
        public final CatalogEntry copy(@JsonProperty("name") @NotNull String name, @JsonProperty("id") @NotNull String id, @JsonProperty("poster") @Nullable String poster, @JsonProperty("background") @Nullable String background, @JsonProperty("description") @Nullable String description, @JsonProperty("imdbRating") @Nullable String imdbRating, @JsonProperty("type") @Nullable String type, @JsonProperty("videos") @Nullable List<Video> videos, @JsonProperty("genre") @Nullable List<String> genre, @JsonProperty("genres") @NotNull List<String> genres, @JsonProperty("cast") @NotNull List<String> cast, @JsonProperty("trailers") @NotNull List<Trailer> trailersSources, @JsonProperty("year") @Nullable String yearNum) {
            return new CatalogEntry(name, id, poster, background, description, imdbRating, type, videos, genre, genres, cast, trailersSources, yearNum);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CatalogEntry)) {
                return false;
            }
            CatalogEntry catalogEntry = (CatalogEntry) other;
            return Intrinsics.areEqual(this.name, catalogEntry.name) && Intrinsics.areEqual(this.id, catalogEntry.id) && Intrinsics.areEqual(this.poster, catalogEntry.poster) && Intrinsics.areEqual(this.background, catalogEntry.background) && Intrinsics.areEqual(this.description, catalogEntry.description) && Intrinsics.areEqual(this.imdbRating, catalogEntry.imdbRating) && Intrinsics.areEqual(this.type, catalogEntry.type) && Intrinsics.areEqual(this.videos, catalogEntry.videos) && Intrinsics.areEqual(this.genre, catalogEntry.genre) && Intrinsics.areEqual(this.genres, catalogEntry.genres) && Intrinsics.areEqual(this.cast, catalogEntry.cast) && Intrinsics.areEqual(this.trailersSources, catalogEntry.trailersSources) && Intrinsics.areEqual(this.yearNum, catalogEntry.yearNum);
        }

        public int hashCode() {
            return (((((((((((((((((((((((this.name.hashCode() * 31) + this.id.hashCode()) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.background == null ? 0 : this.background.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.videos == null ? 0 : this.videos.hashCode())) * 31) + (this.genre == null ? 0 : this.genre.hashCode())) * 31) + this.genres.hashCode()) * 31) + this.cast.hashCode()) * 31) + this.trailersSources.hashCode()) * 31) + (this.yearNum != null ? this.yearNum.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CatalogEntry(name=").append(this.name).append(", id=").append(this.id).append(", poster=").append(this.poster).append(", background=").append(this.background).append(", description=").append(this.description).append(", imdbRating=").append(this.imdbRating).append(", type=").append(this.type).append(", videos=").append(this.videos).append(", genre=").append(this.genre).append(", genres=").append(this.genres).append(", cast=").append(this.cast).append(", trailersSources=");
            sb.append(this.trailersSources).append(", yearNum=").append(this.yearNum).append(')');
            return sb.toString();
        }

        public CatalogEntry(@JsonProperty("name") @NotNull String name, @JsonProperty("id") @NotNull String id, @JsonProperty("poster") @Nullable String poster, @JsonProperty("background") @Nullable String background, @JsonProperty("description") @Nullable String description, @JsonProperty("imdbRating") @Nullable String imdbRating, @JsonProperty("type") @Nullable String type, @JsonProperty("videos") @Nullable List<Video> list, @JsonProperty("genre") @Nullable List<String> list2, @JsonProperty("genres") @NotNull List<String> list3, @JsonProperty("cast") @NotNull List<String> list4, @JsonProperty("trailers") @NotNull List<Trailer> list5, @JsonProperty("year") @Nullable String yearNum) {
            this.name = name;
            this.id = id;
            this.poster = poster;
            this.background = background;
            this.description = description;
            this.imdbRating = imdbRating;
            this.type = type;
            this.videos = list;
            this.genre = list2;
            this.genres = list3;
            this.cast = list4;
            this.trailersSources = list5;
            this.yearNum = yearNum;
        }

        public /* synthetic */ CatalogEntry(String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, List list2, List list3, List list4, List list5, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, str6, str7, list, list2, (i & 512) != 0 ? CollectionsKt.emptyList() : list3, (i & 1024) != 0 ? CollectionsKt.emptyList() : list4, (i & 2048) != 0 ? CollectionsKt.emptyList() : list5, (i & 4096) != 0 ? null : str8);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        public final String getBackground() {
            return this.background;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final List<Video> getVideos() {
            return this.videos;
        }

        @Nullable
        public final List<String> getGenre() {
            return this.genre;
        }

        @NotNull
        public final List<String> getGenres() {
            return this.genres;
        }

        @NotNull
        public final List<String> getCast() {
            return this.cast;
        }

        @NotNull
        public final List<Trailer> getTrailersSources() {
            return this.trailersSources;
        }

        @Nullable
        public final String getYearNum() {
            return this.yearNum;
        }

        @NotNull
        public final SearchResponse toSearchResponse(@NotNull StreamPlayStremioCatelog provider) {
            return MainAPIKt.newMovieSearchResponse$default(provider, this.name, AppUtils.INSTANCE.toJson(this), TvType.Others, false, new Function1() { // from class: com.phisher98.StreamPlayStremioCatelog$CatalogEntry$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return StreamPlayStremioCatelog.CatalogEntry.toSearchResponse$lambda$0(this.f$0, (MovieSearchResponse) obj);
                }
            }, 8, (Object) null);
        }

        static final Unit toSearchResponse$lambda$0(CatalogEntry this$0, MovieSearchResponse $this$newMovieSearchResponse) {
            $this$newMovieSearchResponse.setPosterUrl(this$0.poster);
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object toLoadResponse(@NotNull StreamPlayStremioCatelog provider, @Nullable String imdbId, @NotNull Continuation<? super LoadResponse> continuation) {
            List<Video> list = this.videos;
            if (list == null || list.isEmpty()) {
                StreamPlayStremioCatelog streamPlayStremioCatelog = provider;
                String str = this.name;
                String str2 = provider.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                TvType tvType = TvType.Movie;
                String str3 = this.type;
                String str4 = this.id;
                String str5 = this.yearNum;
                return MainAPIKt.newMovieLoadResponse(streamPlayStremioCatelog, str, str2, tvType, new LoadData(str3, str4, null, null, imdbId, str5 != null ? StringsKt.toIntOrNull(str5) : null, null, 76, null), new StreamPlayStremioCatelog$CatalogEntry$toLoadResponse$2(this, imdbId, null), continuation);
            }
            StreamPlayStremioCatelog streamPlayStremioCatelog2 = provider;
            String str6 = this.name;
            String str7 = provider.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
            TvType tvType2 = TvType.TvSeries;
            Iterable $this$map$iv = this.videos;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Video it = (Video) item$iv$iv;
                destination$iv$iv.add(it.toEpisode(provider, this.type, imdbId));
            }
            return MainAPIKt.newTvSeriesLoadResponse(streamPlayStremioCatelog2, str6, str7, tvType2, (List) destination$iv$iv, new StreamPlayStremioCatelog$CatalogEntry$toLoadResponse$4(this, imdbId, null), continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jø\u0001\u0010-\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000fHÆ\u0001¢\u0006\u0002\u0010.J\u0014\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00102\u001a\u00020\tHÖ\u0081\u0004J\n\u00103\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013¨\u00064"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelog$Video;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "title", "name", "seasonNumber", "", "season", "number", "episode", "thumbnail", "overview", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getName", "getSeasonNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNumber", "getEpisode", "getThumbnail", "getOverview", "getDescription", "toEpisode", "Lcom/lagradost/cloudstream3/Episode;", "provider", "Lcom/phisher98/StreamPlayStremioCatelog;", "type", "imdbId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/StreamPlayStremioCatelog$Video;", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class Video {

        @Nullable
        private final String description;

        @Nullable
        private final Integer episode;

        @Nullable
        private final String id;

        @Nullable
        private final String name;

        @Nullable
        private final Integer number;

        @Nullable
        private final String overview;

        @Nullable
        private final Integer seasonNumber;

        @Nullable
        private final String thumbnail;

        @Nullable
        private final String title;

        public Video() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public static /* synthetic */ Video copy$default(Video video, String str, String str2, String str3, Integer num, Integer num2, Integer num3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = video.id;
            }
            if ((i & 2) != 0) {
                str2 = video.title;
            }
            if ((i & 4) != 0) {
                str3 = video.name;
            }
            if ((i & 8) != 0) {
                num = video.seasonNumber;
            }
            if ((i & 16) != 0) {
                num2 = video.number;
            }
            if ((i & 32) != 0) {
                num3 = video.episode;
            }
            if ((i & 64) != 0) {
                str4 = video.thumbnail;
            }
            if ((i & 128) != 0) {
                str5 = video.overview;
            }
            if ((i & 256) != 0) {
                str6 = video.description;
            }
            String str7 = str5;
            String str8 = str6;
            Integer num4 = num3;
            String str9 = str4;
            Integer num5 = num2;
            String str10 = str3;
            return video.copy(str, str2, str10, num, num5, num4, str9, str7, str8);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getNumber() {
            return this.number;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final Video copy(@JsonProperty("id") @Nullable String id, @JsonProperty("title") @Nullable String title, @JsonProperty("name") @Nullable String name, @JsonProperty("season") @Nullable Integer seasonNumber, @JsonProperty("number") @Nullable Integer number, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("thumbnail") @Nullable String thumbnail, @JsonProperty("overview") @Nullable String overview, @JsonProperty("description") @Nullable String description) {
            return new Video(id, title, name, seasonNumber, number, episode, thumbnail, overview, description);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Video)) {
                return false;
            }
            Video video = (Video) other;
            return Intrinsics.areEqual(this.id, video.id) && Intrinsics.areEqual(this.title, video.title) && Intrinsics.areEqual(this.name, video.name) && Intrinsics.areEqual(this.seasonNumber, video.seasonNumber) && Intrinsics.areEqual(this.number, video.number) && Intrinsics.areEqual(this.episode, video.episode) && Intrinsics.areEqual(this.thumbnail, video.thumbnail) && Intrinsics.areEqual(this.overview, video.overview) && Intrinsics.areEqual(this.description, video.description);
        }

        public int hashCode() {
            return ((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.number == null ? 0 : this.number.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.description != null ? this.description.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Video(id=" + this.id + ", title=" + this.title + ", name=" + this.name + ", seasonNumber=" + this.seasonNumber + ", number=" + this.number + ", episode=" + this.episode + ", thumbnail=" + this.thumbnail + ", overview=" + this.overview + ", description=" + this.description + ')';
        }

        public Video(@JsonProperty("id") @Nullable String id, @JsonProperty("title") @Nullable String title, @JsonProperty("name") @Nullable String name, @JsonProperty("season") @Nullable Integer seasonNumber, @JsonProperty("number") @Nullable Integer number, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("thumbnail") @Nullable String thumbnail, @JsonProperty("overview") @Nullable String overview, @JsonProperty("description") @Nullable String description) {
            this.id = id;
            this.title = title;
            this.name = name;
            this.seasonNumber = seasonNumber;
            this.number = number;
            this.episode = episode;
            this.thumbnail = thumbnail;
            this.overview = overview;
            this.description = description;
        }

        public /* synthetic */ Video(String str, String str2, String str3, Integer num, Integer num2, Integer num3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : num3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6);
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @Nullable
        public final Integer getNumber() {
            return this.number;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final Episode toEpisode(@NotNull StreamPlayStremioCatelog provider, @Nullable String type, @Nullable String imdbId) {
            StreamPlayStremioCatelog streamPlayStremioCatelog = provider;
            String str = this.id;
            Integer num = this.seasonNumber;
            Integer num2 = this.episode;
            if (num2 == null) {
                num2 = this.number;
            }
            return MainAPIKt.newEpisode(streamPlayStremioCatelog, new LoadData(type, str, num, num2, imdbId, null, null, 96, null), new Function1() { // from class: com.phisher98.StreamPlayStremioCatelog$Video$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return StreamPlayStremioCatelog.Video.toEpisode$lambda$0(this.f$0, (Episode) obj);
                }
            });
        }

        static final Unit toEpisode$lambda$0(Video this$0, Episode $this$newEpisode) {
            String str = this$0.name;
            if (str == null) {
                str = this$0.title;
            }
            $this$newEpisode.setName(str);
            $this$newEpisode.setPosterUrl(this$0.thumbnail);
            String str2 = this$0.overview;
            if (str2 == null) {
                str2 = this$0.description;
            }
            $this$newEpisode.setDescription(str2);
            $this$newEpisode.setSeason(this$0.seasonNumber);
            Integer num = this$0.episode;
            if (num == null) {
                num = this$0.number;
            }
            $this$newEpisode.setEpisode(num);
            return Unit.INSTANCE;
        }
    }

    @Nullable
    public final Object resolveImdbId(@NotNull LoadData $this$resolveImdbId, @NotNull Continuation<? super String> continuation) {
        String source = $this$resolveImdbId.getImdbId();
        if (source == null && (source = $this$resolveImdbId.getId()) == null) {
            return null;
        }
        String imdb = MainAPIKt.imdbUrlToIdNullable(source);
        if (imdb != null) {
            return imdb;
        }
        if (StringsKt.startsWith$default(source, "tt", false, 2, (Object) null)) {
            return source;
        }
        if (StringsKt.startsWith$default(source, "tmdb:", false, 2, (Object) null)) {
            return tmdbToImdb(StringsKt.removePrefix(source, "tmdb:"), $this$resolveImdbId.getType(), continuation);
        }
        if (StringsKt.startsWith$default(source, "kitsu:", false, 2, (Object) null)) {
            return kitsuToImdb(StringsKt.removePrefix(source, "kitsu:"), continuation);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object tmdbToImdb(@NotNull String tmdbId, @Nullable String type, @NotNull Continuation<? super String> continuation) {
        C02651 c02651;
        Object safe;
        if (continuation instanceof C02651) {
            c02651 = (C02651) continuation;
            if ((c02651.label & Integer.MIN_VALUE) != 0) {
                c02651.label -= Integer.MIN_VALUE;
            } else {
                c02651 = new C02651(continuation);
            }
        } else {
            c02651 = new C02651(continuation);
        }
        C02651 c02652 = c02651;
        Object $result = c02652.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02652.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String mediaType = Intrinsics.areEqual(type, "series") ? "tv" : "movie";
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("api_key", "98ae14df2b8d8f8f8136499daf79f0e0"));
                c02652.L$0 = SpillingKt.nullOutSpilledVariable(tmdbId);
                c02652.L$1 = SpillingKt.nullOutSpilledVariable(type);
                c02652.L$2 = SpillingKt.nullOutSpilledVariable(mediaType);
                c02652.label = 1;
                $result = Requests.get$default(MainActivityKt.getApp(), "https://api.themoviedb.org/3/" + mediaType + '/' + tmdbId + "/external_ids", (Map) null, (String) null, mapMapOf, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02652, 4086, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(TmdbExternalIds.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        TmdbExternalIds res = (TmdbExternalIds) safe;
        if (res != null) {
            return res.getImdb_id();
        }
        return null;
    }

    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelog$TmdbExternalIds;", "", "imdb_id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/lang/String;)V", "getImdb_id", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class TmdbExternalIds {

        @Nullable
        private final String imdb_id;

        public static /* synthetic */ TmdbExternalIds copy$default(TmdbExternalIds tmdbExternalIds, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tmdbExternalIds.imdb_id;
            }
            return tmdbExternalIds.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @NotNull
        public final TmdbExternalIds copy(@JsonProperty("imdb_id") @Nullable String imdb_id) {
            return new TmdbExternalIds(imdb_id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TmdbExternalIds) && Intrinsics.areEqual(this.imdb_id, ((TmdbExternalIds) other).imdb_id);
        }

        public int hashCode() {
            if (this.imdb_id == null) {
                return 0;
            }
            return this.imdb_id.hashCode();
        }

        @NotNull
        public String toString() {
            return "TmdbExternalIds(imdb_id=" + this.imdb_id + ')';
        }

        public TmdbExternalIds(@JsonProperty("imdb_id") @Nullable String imdb_id) {
            this.imdb_id = imdb_id;
        }

        @Nullable
        public final String getImdb_id() {
            return this.imdb_id;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object kitsuToImdb(@NotNull String kitsuId, @NotNull Continuation<? super String> continuation) {
        C02581 c02581;
        Object safe;
        AniZipMappings mappings;
        if (continuation instanceof C02581) {
            c02581 = (C02581) continuation;
            if ((c02581.label & Integer.MIN_VALUE) != 0) {
                c02581.label -= Integer.MIN_VALUE;
            } else {
                c02581 = new C02581(continuation);
            }
        } else {
            c02581 = new C02581(continuation);
        }
        C02581 c02582 = c02581;
        Object $result = c02582.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02582.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String id = StringsKt.removePrefix(kitsuId, "kitsu:");
                Requests app = MainActivityKt.getApp();
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("kitsu_id", id));
                c02582.L$0 = SpillingKt.nullOutSpilledVariable(kitsuId);
                c02582.L$1 = SpillingKt.nullOutSpilledVariable(id);
                c02582.label = 1;
                $result = Requests.get$default(app, "https://api.ani.zip/mappings", (Map) null, (String) null, mapMapOf, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02582, 4086, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(AniZipResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        AniZipResponse res = (AniZipResponse) safe;
        if (res == null || (mappings = res.getMappings()) == null) {
            return null;
        }
        return mappings.getImdb_id();
    }

    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelog$AniZipResponse;", "", "mappings", "Lcom/phisher98/StreamPlayStremioCatelog$AniZipMappings;", "<init>", "(Lcom/phisher98/StreamPlayStremioCatelog$AniZipMappings;)V", "getMappings", "()Lcom/phisher98/StreamPlayStremioCatelog$AniZipMappings;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniZipResponse {

        @Nullable
        private final AniZipMappings mappings;

        public static /* synthetic */ AniZipResponse copy$default(AniZipResponse aniZipResponse, AniZipMappings aniZipMappings, int i, Object obj) {
            if ((i & 1) != 0) {
                aniZipMappings = aniZipResponse.mappings;
            }
            return aniZipResponse.copy(aniZipMappings);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AniZipMappings getMappings() {
            return this.mappings;
        }

        @NotNull
        public final AniZipResponse copy(@Nullable AniZipMappings mappings) {
            return new AniZipResponse(mappings);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AniZipResponse) && Intrinsics.areEqual(this.mappings, ((AniZipResponse) other).mappings);
        }

        public int hashCode() {
            if (this.mappings == null) {
                return 0;
            }
            return this.mappings.hashCode();
        }

        @NotNull
        public String toString() {
            return "AniZipResponse(mappings=" + this.mappings + ')';
        }

        public AniZipResponse(@Nullable AniZipMappings mappings) {
            this.mappings = mappings;
        }

        @Nullable
        public final AniZipMappings getMappings() {
            return this.mappings;
        }
    }

    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelog$AniZipMappings;", "", "imdb_id", "", "<init>", "(Ljava/lang/String;)V", "getImdb_id", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniZipMappings {

        @Nullable
        private final String imdb_id;

        public static /* synthetic */ AniZipMappings copy$default(AniZipMappings aniZipMappings, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aniZipMappings.imdb_id;
            }
            return aniZipMappings.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @NotNull
        public final AniZipMappings copy(@Nullable String imdb_id) {
            return new AniZipMappings(imdb_id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AniZipMappings) && Intrinsics.areEqual(this.imdb_id, ((AniZipMappings) other).imdb_id);
        }

        public int hashCode() {
            if (this.imdb_id == null) {
                return 0;
            }
            return this.imdb_id.hashCode();
        }

        @NotNull
        public String toString() {
            return "AniZipMappings(imdb_id=" + this.imdb_id + ')';
        }

        public AniZipMappings(@Nullable String imdb_id) {
            this.imdb_id = imdb_id;
        }

        @Nullable
        public final String getImdb_id() {
            return this.imdb_id;
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x013a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object fetchCinemetaMeta(@NotNull String imdbId, @Nullable String type, @NotNull Continuation<? super CinemetaMetaData> continuation) {
        C02551 c02551;
        Object safe;
        CinemetaMeta it;
        Integer intOrNull;
        Object element$iv;
        CinemetaLink cinemetaLink;
        String id;
        CinemetaLink link;
        if (continuation instanceof C02551) {
            c02551 = (C02551) continuation;
            if ((c02551.label & Integer.MIN_VALUE) != 0) {
                c02551.label -= Integer.MIN_VALUE;
            } else {
                c02551 = new C02551(continuation);
            }
        } else {
            c02551 = new C02551(continuation);
        }
        C02551 c02552 = c02551;
        Object $result = c02552.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02552.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String mediaType = Intrinsics.areEqual(type, "series") ? "series" : "movie";
                c02552.L$0 = SpillingKt.nullOutSpilledVariable(imdbId);
                c02552.L$1 = SpillingKt.nullOutSpilledVariable(type);
                c02552.L$2 = SpillingKt.nullOutSpilledVariable(mediaType);
                c02552.label = 1;
                $result = Requests.get$default(MainActivityKt.getApp(), "https://v3-cinemeta.strem.io/meta/" + mediaType + '/' + imdbId + ".json", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02552, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(CinemetaResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        CinemetaResponse res = (CinemetaResponse) safe;
        if (res == null || (it = res.getMeta()) == null) {
            return null;
        }
        String name = it.getName();
        Iterable links = it.getLinks();
        if (links != null) {
            Iterable $this$firstOrNull$iv = links;
            Iterator it2 = $this$firstOrNull$iv.iterator();
            do {
                if (it2.hasNext()) {
                    element$iv = it2.next();
                    link = (CinemetaLink) element$iv;
                } else {
                    element$iv = null;
                }
                cinemetaLink = (CinemetaLink) element$iv;
                if (cinemetaLink != null || (id = cinemetaLink.getId()) == null) {
                    intOrNull = null;
                } else {
                    intOrNull = StringsKt.toIntOrNull(id);
                }
            } while (!Intrinsics.areEqual(link.getCategory(), "tmdb"));
            cinemetaLink = (CinemetaLink) element$iv;
            if (cinemetaLink != null) {
                intOrNull = null;
            } else {
                intOrNull = null;
            }
        } else {
            intOrNull = null;
        }
        return new CinemetaMetaData(name, intOrNull);
    }

    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelog$CinemetaResponse;", "", "meta", "Lcom/phisher98/StreamPlayStremioCatelog$CinemetaMeta;", "<init>", "(Lcom/phisher98/StreamPlayStremioCatelog$CinemetaMeta;)V", "getMeta", "()Lcom/phisher98/StreamPlayStremioCatelog$CinemetaMeta;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class CinemetaResponse {

        @Nullable
        private final CinemetaMeta meta;

        public static /* synthetic */ CinemetaResponse copy$default(CinemetaResponse cinemetaResponse, CinemetaMeta cinemetaMeta, int i, Object obj) {
            if ((i & 1) != 0) {
                cinemetaMeta = cinemetaResponse.meta;
            }
            return cinemetaResponse.copy(cinemetaMeta);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CinemetaMeta getMeta() {
            return this.meta;
        }

        @NotNull
        public final CinemetaResponse copy(@Nullable CinemetaMeta meta) {
            return new CinemetaResponse(meta);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CinemetaResponse) && Intrinsics.areEqual(this.meta, ((CinemetaResponse) other).meta);
        }

        public int hashCode() {
            if (this.meta == null) {
                return 0;
            }
            return this.meta.hashCode();
        }

        @NotNull
        public String toString() {
            return "CinemetaResponse(meta=" + this.meta + ')';
        }

        public CinemetaResponse(@Nullable CinemetaMeta meta) {
            this.meta = meta;
        }

        @Nullable
        public final CinemetaMeta getMeta() {
            return this.meta;
        }
    }

    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelog$CinemetaMeta;", "", "name", "", "links", "", "Lcom/phisher98/StreamPlayStremioCatelog$CinemetaLink;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getLinks", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class CinemetaMeta {

        @Nullable
        private final List<CinemetaLink> links;

        @Nullable
        private final String name;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CinemetaMeta copy$default(CinemetaMeta cinemetaMeta, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cinemetaMeta.name;
            }
            if ((i & 2) != 0) {
                list = cinemetaMeta.links;
            }
            return cinemetaMeta.copy(str, list);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final List<CinemetaLink> component2() {
            return this.links;
        }

        @NotNull
        public final CinemetaMeta copy(@Nullable String name, @Nullable List<CinemetaLink> links) {
            return new CinemetaMeta(name, links);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CinemetaMeta)) {
                return false;
            }
            CinemetaMeta cinemetaMeta = (CinemetaMeta) other;
            return Intrinsics.areEqual(this.name, cinemetaMeta.name) && Intrinsics.areEqual(this.links, cinemetaMeta.links);
        }

        public int hashCode() {
            return ((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.links != null ? this.links.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CinemetaMeta(name=" + this.name + ", links=" + this.links + ')';
        }

        public CinemetaMeta(@Nullable String name, @Nullable List<CinemetaLink> list) {
            this.name = name;
            this.links = list;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final List<CinemetaLink> getLinks() {
            return this.links;
        }
    }

    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelog$CinemetaLink;", "", "category", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class CinemetaLink {

        @Nullable
        private final String category;

        @Nullable
        private final String id;

        public static /* synthetic */ CinemetaLink copy$default(CinemetaLink cinemetaLink, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cinemetaLink.category;
            }
            if ((i & 2) != 0) {
                str2 = cinemetaLink.id;
            }
            return cinemetaLink.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCategory() {
            return this.category;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final CinemetaLink copy(@Nullable String category, @Nullable String id) {
            return new CinemetaLink(category, id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CinemetaLink)) {
                return false;
            }
            CinemetaLink cinemetaLink = (CinemetaLink) other;
            return Intrinsics.areEqual(this.category, cinemetaLink.category) && Intrinsics.areEqual(this.id, cinemetaLink.id);
        }

        public int hashCode() {
            return ((this.category == null ? 0 : this.category.hashCode()) * 31) + (this.id != null ? this.id.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CinemetaLink(category=" + this.category + ", id=" + this.id + ')';
        }

        public CinemetaLink(@Nullable String category, @Nullable String id) {
            this.category = category;
            this.id = id;
        }

        @Nullable
        public final String getCategory() {
            return this.category;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }
    }

    /* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/phisher98/StreamPlayStremioCatelog$CinemetaMetaData;", "", "title", "", "tmdbId", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getTitle", "()Ljava/lang/String;", "getTmdbId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/StreamPlayStremioCatelog$CinemetaMetaData;", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class CinemetaMetaData {

        @Nullable
        private final String title;

        @Nullable
        private final Integer tmdbId;

        public static /* synthetic */ CinemetaMetaData copy$default(CinemetaMetaData cinemetaMetaData, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cinemetaMetaData.title;
            }
            if ((i & 2) != 0) {
                num = cinemetaMetaData.tmdbId;
            }
            return cinemetaMetaData.copy(str, num);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @NotNull
        public final CinemetaMetaData copy(@Nullable String title, @Nullable Integer tmdbId) {
            return new CinemetaMetaData(title, tmdbId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CinemetaMetaData)) {
                return false;
            }
            CinemetaMetaData cinemetaMetaData = (CinemetaMetaData) other;
            return Intrinsics.areEqual(this.title, cinemetaMetaData.title) && Intrinsics.areEqual(this.tmdbId, cinemetaMetaData.tmdbId);
        }

        public int hashCode() {
            return ((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.tmdbId != null ? this.tmdbId.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CinemetaMetaData(title=" + this.title + ", tmdbId=" + this.tmdbId + ')';
        }

        public CinemetaMetaData(@Nullable String title, @Nullable Integer tmdbId) {
            this.title = title;
            this.tmdbId = tmdbId;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final Integer getTmdbId() {
            return this.tmdbId;
        }
    }
}
