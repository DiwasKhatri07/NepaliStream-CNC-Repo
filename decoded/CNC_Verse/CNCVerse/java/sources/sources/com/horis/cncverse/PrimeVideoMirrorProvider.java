package com.horis.cncverse;

import android.content.Context;
import com.cncverse.donation.DonationManager;
import com.horis.cncverse.entities.PostData;
import com.horis.cncverse.entities.SearchData;
import com.horis.cncverse.entities.SearchResult;
import com.horis.cncverse.entities.Season;
import com.horis.cncverse.entities.Suggest;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
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
import kotlin.Pair;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CNC_Verse/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 B2\u00020\u0001:\u0003BCDB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J\f\u0010#\u001a\u00020$*\u00020%H\u0002J\u000e\u0010&\u001a\u0004\u0018\u00010'*\u00020%H\u0002J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020'0)2\u0006\u0010*\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010+J4\u0010/\u001a\b\u0012\u0004\u0012\u0002000)2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u00104JF\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\u00162\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;09H\u0096@¢\u0006\u0002\u0010>J\u0012\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020=H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/horis/cncverse/PrimeVideoMirrorProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "cookie_value", "headers", "", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHomePageList", "Lcom/lagradost/cloudstream3/HomePageList;", "Lorg/jsoup/nodes/Element;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "search", "", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "getEpisodes", "Lcom/lagradost/cloudstream3/Episode;", "title", "eid", "sid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoInterceptor", "Lokhttp3/Interceptor;", "extractorLink", "Companion", "Id", "LoadData", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPrimeVideoMirrorProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PrimeVideoMirrorProvider.kt\ncom/horis/cncverse/PrimeVideoMirrorProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 5 Utils.kt\ncom/horis/cncverse/UtilsKt\n*L\n1#1,287:1\n1586#2:288\n1661#2,3:289\n1642#2,10:292\n1915#2:302\n1916#2:304\n1652#2:305\n1586#2:307\n1661#2,3:308\n1586#2:313\n1661#2,3:314\n1586#2:317\n1661#2,3:318\n1586#2:321\n1661#2,3:322\n777#2:325\n873#2,2:326\n1586#2:328\n1661#2,3:329\n1661#2,3:332\n1661#2,3:336\n1#3:303\n62#4:306\n62#4:312\n62#4:335\n62#4:340\n62#4:341\n66#5:311\n66#5:339\n*S KotlinDebug\n*F\n+ 1 PrimeVideoMirrorProvider.kt\ncom/horis/cncverse/PrimeVideoMirrorProvider\n*L\n72#1:288\n72#1:289,3\n80#1:292,10\n80#1:302\n80#1:304\n80#1:305\n108#1:307\n108#1:308,3\n135#1:313\n135#1:314,3\n136#1:317\n136#1:318,3\n142#1:321\n142#1:322,3\n143#1:325\n143#1:326,2\n148#1:328\n148#1:329,3\n160#1:332,3\n213#1:336,3\n80#1:303\n106#1:306\n130#1:312\n212#1:335\n241#1:340\n248#1:341\n119#1:311\n236#1:339\n*E\n"})
public final class PrimeVideoMirrorProvider extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Context context;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime, TvType.AsianDrama});

    @NotNull
    private String lang = "ta";

    @NotNull
    private String mainUrl = "https://net52.cc";

    @NotNull
    private String name = "Prime Video";
    private final boolean hasMainPage = true;

    @NotNull
    private String cookie_value = "";

    @NotNull
    private final Map<String, String> headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"), TuplesKt.to("Accept-Language", "en-IN,en-US;q=0.9,en;q=0.8"), TuplesKt.to("Cache-Control", "max-age=0"), TuplesKt.to("Connection", "keep-alive"), TuplesKt.to("sec-ch-ua", "\"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"144\", \"Android WebView\";v=\"144\""), TuplesKt.to("sec-ch-ua-mobile", "?0"), TuplesKt.to("sec-ch-ua-platform", "\"Android\""), TuplesKt.to("Sec-Fetch-Dest", "document"), TuplesKt.to("Sec-Fetch-Mode", "navigate"), TuplesKt.to("Sec-Fetch-Site", "same-origin"), TuplesKt.to("Sec-Fetch-User", "?1"), TuplesKt.to("Upgrade-Insecure-Requests", "1"), TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 13; Pixel 5 Build/TQ3A.230901.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/144.0.7559.132 Safari/537.36 /OS.Gatu v3.0"), TuplesKt.to("X-Requested-With", "XMLHttpRequest")});

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$getEpisodes$1 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider", f = "PrimeVideoMirrorProvider.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {207}, m = "getEpisodes", n = {"title", "eid", "sid", "episodes", "cookies", "page", "pg"}, nl = {212}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 2)
    static final class C00311 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00311(Continuation<? super C00311> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoMirrorProvider.this.getEpisodes(null, null, null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$getMainPage$1 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider", f = "PrimeVideoMirrorProvider.kt", i = {0, 0, 1, 1, 1}, l = {60, 66}, m = "getMainPage", n = {"request", "page", "request", "cookies", "page"}, nl = {62, 71}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"}, v = 2)
    static final class C00321 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00321(Continuation<? super C00321> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoMirrorProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$load$1 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider", f = "PrimeVideoMirrorProvider.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {118, 125, 171, 174, 181}, m = "load", n = {"url", "url", "id", "cookies", "url", "id", "cookies", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "runTime", "url", "id", "cookies", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "runTime", "url", "id", "cookies", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "type", "runTime"}, nl = {119, 130, 174, 179, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0"}, v = 2)
    static final class C00341 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00341(Continuation<? super C00341> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoMirrorProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$loadLinks$1 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider", f = "PrimeVideoMirrorProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5}, l = {235, 237, 238, 244, 245, 254}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "apiBase", "id", "isCasting", "data", "subtitleCallback", "callback", "apiBase", "id", "userToken", "response", "isCasting", "data", "subtitleCallback", "callback", "apiBase", "id", "userToken", "response", "isCasting", "data", "subtitleCallback", "callback", "apiBase", "id", "userToken", "response", "isCasting", "data", "subtitleCallback", "callback", "apiBase", "id", "userToken", "response", "isCasting"}, nl = {236, 238, 241, 245, 248, 253}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
    static final class C00371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00371(Continuation<? super C00371> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoMirrorProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$search$1 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider", f = "PrimeVideoMirrorProvider.kt", i = {0, 1, 1, 1}, l = {99, 106}, m = "search", n = {"query", "query", "cookies", "url"}, nl = {101, 288}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00391 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00391(Continuation<? super C00391> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoMirrorProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/horis/cncverse/PrimeVideoMirrorProvider$Companion;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Context getContext() {
            return PrimeVideoMirrorProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            PrimeVideoMirrorProvider.context = context;
        }
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
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

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0147 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0148  */
    /* JADX WARN: Code duplicated, block: B:32:0x0176 A[LOOP:0: B:30:0x0170->B:32:0x0176, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws Exception {
        C00321 c00321;
        String str;
        int page2;
        MainPageRequest request2;
        PrimeVideoMirrorProvider primeVideoMirrorProvider;
        Object obj;
        MainPageRequest request3;
        Collection destination$iv$iv;
        if (continuation instanceof C00321) {
            c00321 = (C00321) continuation;
            if ((c00321.label & Integer.MIN_VALUE) != 0) {
                c00321.label -= Integer.MIN_VALUE;
            } else {
                c00321 = new C00321(continuation);
            }
        } else {
            c00321 = new C00321(continuation);
        }
        Object $result = c00321.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00321.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow(getName());
                if (this.cookie_value.length() == 0) {
                    String mainUrl = getMainUrl();
                    c00321.L$0 = SpillingKt.nullOutSpilledVariable(request);
                    c00321.L$1 = this;
                    c00321.I$0 = page;
                    c00321.label = 1;
                    Object objBypass = UtilsKt.bypass(mainUrl, c00321);
                    if (objBypass == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objBypass;
                    page2 = page;
                    request3 = request;
                    primeVideoMirrorProvider = this;
                    str = (String) obj;
                    request2 = request3;
                } else {
                    str = this.cookie_value;
                    page2 = page;
                    request2 = request;
                    primeVideoMirrorProvider = this;
                }
                primeVideoMirrorProvider.cookie_value = str;
                Map cookies = MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", this.cookie_value), TuplesKt.to("ott", "pv"), TuplesKt.to("hd", "on")});
                Requests app = UtilsKt.getApp();
                String str2 = getMainUrl() + "/mobile/home?app=1";
                Map<String, String> map = this.headers;
                String str3 = getMainUrl() + "/mobile/home?app=1";
                c00321.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00321.L$1 = SpillingKt.nullOutSpilledVariable(cookies);
                c00321.I$0 = page2;
                c00321.label = 2;
                $result = Requests.get$default(app, str2, map, str3, (Map) null, cookies, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00321, 4072, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Document document = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv = document.select(".tray-container, #top10");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Element it = (Element) item$iv$iv;
                    destination$iv$iv.add(toHomePageList(it));
                }
                List items = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(items, Boxing.boxBoolean(false));
            case 1:
                page2 = c00321.I$0;
                PrimeVideoMirrorProvider primeVideoMirrorProvider2 = (PrimeVideoMirrorProvider) c00321.L$1;
                request3 = (MainPageRequest) c00321.L$0;
                ResultKt.throwOnFailure($result);
                primeVideoMirrorProvider = primeVideoMirrorProvider2;
                obj = $result;
                str = (String) obj;
                request2 = request3;
                primeVideoMirrorProvider.cookie_value = str;
                Map cookies2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", this.cookie_value), TuplesKt.to("ott", "pv"), TuplesKt.to("hd", "on")});
                Requests app2 = UtilsKt.getApp();
                String str4 = getMainUrl() + "/mobile/home?app=1";
                Map<String, String> map2 = this.headers;
                String str5 = getMainUrl() + "/mobile/home?app=1";
                c00321.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00321.L$1 = SpillingKt.nullOutSpilledVariable(cookies2);
                c00321.I$0 = page2;
                c00321.label = 2;
                $result = Requests.get$default(app2, str4, map2, str5, (Map) null, cookies2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00321, 4072, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Document document2 = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv2 = document2.select(".tray-container, #top10");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r11.hasNext()) {
                    Element it2 = (Element) item$iv$iv;
                    destination$iv$iv.add(toHomePageList(it2));
                }
                List items2 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(items2, Boxing.boxBoolean(false));
            case 2:
                int i = c00321.I$0;
                ResultKt.throwOnFailure($result);
                Document document3 = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv3 = document3.select(".tray-container, #top10");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r11.hasNext()) {
                    Element it3 = (Element) item$iv$iv;
                    destination$iv$iv.add(toHomePageList(it3));
                }
                List items3 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(items3, Boxing.boxBoolean(false));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final HomePageList toHomePageList(Element $this$toHomePageList) {
        String name = $this$toHomePageList.select("h2, span").text();
        Iterable $this$mapNotNull$iv = $this$toHomePageList.select("article, .top10-post");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List items = (List) destination$iv$iv;
        return new HomePageList(name, items, false);
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        final String id;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("a");
        if (elementSelectFirst == null || (id = elementSelectFirst.attr("data-post")) == null) {
            id = $this$toSearchResult.attr("data-post");
        }
        return MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(id)), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return PrimeVideoMirrorProvider.toSearchResult$lambda$0(id, this, (AnimeSearchResponse) obj);
            }
        }, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSearchResult$lambda$0(String $id, PrimeVideoMirrorProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://imgcdn.kim/pv/v/" + $id + ".jpg");
        $this$newAnimeSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this$0.getMainUrl() + "/home")));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0141 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0142  */
    /* JADX WARN: Code duplicated, block: B:32:0x0180 A[LOOP:0: B:30:0x017a->B:32:0x0180, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws Exception {
        C00391 c00391;
        String str;
        String query2;
        PrimeVideoMirrorProvider primeVideoMirrorProvider;
        String query3;
        Object obj;
        PrimeVideoMirrorProvider primeVideoMirrorProvider2;
        SearchData data;
        Collection destination$iv$iv;
        if (continuation instanceof C00391) {
            c00391 = (C00391) continuation;
            if ((c00391.label & Integer.MIN_VALUE) != 0) {
                c00391.label -= Integer.MIN_VALUE;
            } else {
                c00391 = new C00391(continuation);
            }
        } else {
            c00391 = new C00391(continuation);
        }
        Object $result = c00391.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00391.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.cookie_value.length() == 0) {
                    String mainUrl = getMainUrl();
                    query3 = query;
                    c00391.L$0 = query3;
                    c00391.L$1 = this;
                    c00391.label = 1;
                    Object objBypass = UtilsKt.bypass(mainUrl, c00391);
                    if (objBypass == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objBypass;
                    primeVideoMirrorProvider2 = this;
                    str = (String) obj;
                    String str2 = query3;
                    primeVideoMirrorProvider = primeVideoMirrorProvider2;
                    query2 = str2;
                } else {
                    str = this.cookie_value;
                    query2 = query;
                    primeVideoMirrorProvider = this;
                }
                primeVideoMirrorProvider.cookie_value = str;
                Map cookies = MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", this.cookie_value), TuplesKt.to("hd", "on"), TuplesKt.to("ott", "pv")});
                String url = getMainUrl() + "/mobile/pv/search.php?s=" + query2 + "&t=" + APIHolder.INSTANCE.getUnixTime();
                Requests app = UtilsKt.getApp();
                String str3 = getMainUrl() + "/home";
                c00391.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00391.L$1 = SpillingKt.nullOutSpilledVariable(cookies);
                c00391.L$2 = SpillingKt.nullOutSpilledVariable(url);
                c00391.label = 2;
                $result = Requests.get$default(app, url, (Map) null, str3, (Map) null, cookies, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00391, 4074, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                NiceResponse this_$iv = (NiceResponse) $result;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                data = (SearchData) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(SearchData.class));
                Iterable $this$map$iv = data.getSearchResult();
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    final SearchResult it = (SearchResult) item$iv$iv;
                    destination$iv$iv.add(MainAPIKt.newAnimeSearchResponse$default(this, it.getT(), AppUtils.INSTANCE.toJson(new Id(it.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj2) {
                            return PrimeVideoMirrorProvider.search$lambda$0$0(it, this, (AnimeSearchResponse) obj2);
                        }
                    }, 12, (Object) null));
                    data = data;
                }
                return (List) destination$iv$iv;
            case 1:
                primeVideoMirrorProvider2 = (PrimeVideoMirrorProvider) c00391.L$1;
                query3 = (String) c00391.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                str = (String) obj;
                String str4 = query3;
                primeVideoMirrorProvider = primeVideoMirrorProvider2;
                query2 = str4;
                primeVideoMirrorProvider.cookie_value = str;
                Map cookies2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", this.cookie_value), TuplesKt.to("hd", "on"), TuplesKt.to("ott", "pv")});
                String url2 = getMainUrl() + "/mobile/pv/search.php?s=" + query2 + "&t=" + APIHolder.INSTANCE.getUnixTime();
                Requests app2 = UtilsKt.getApp();
                String str5 = getMainUrl() + "/home";
                c00391.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00391.L$1 = SpillingKt.nullOutSpilledVariable(cookies2);
                c00391.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                c00391.label = 2;
                $result = Requests.get$default(app2, url2, (Map) null, str5, (Map) null, cookies2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00391, 4074, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                NiceResponse this_$iv2 = (NiceResponse) $result;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                data = (SearchData) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(SearchData.class));
                Iterable $this$map$iv2 = data.getSearchResult();
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r11.hasNext()) {
                    final SearchResult it2 = (SearchResult) item$iv$iv;
                    destination$iv$iv.add(MainAPIKt.newAnimeSearchResponse$default(this, it2.getT(), AppUtils.INSTANCE.toJson(new Id(it2.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj2) {
                            return PrimeVideoMirrorProvider.search$lambda$0$0(it2, this, (AnimeSearchResponse) obj2);
                        }
                    }, 12, (Object) null));
                    data = data;
                }
                return (List) destination$iv$iv;
            case 2:
                ResultKt.throwOnFailure($result);
                NiceResponse this_$iv3 = (NiceResponse) $result;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                data = (SearchData) parser3.parse(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(SearchData.class));
                Iterable $this$map$iv3 = data.getSearchResult();
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r11.hasNext()) {
                    final SearchResult it3 = (SearchResult) item$iv$iv;
                    destination$iv$iv.add(MainAPIKt.newAnimeSearchResponse$default(this, it3.getT(), AppUtils.INSTANCE.toJson(new Id(it3.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj2) {
                            return PrimeVideoMirrorProvider.search$lambda$0$0(it3, this, (AnimeSearchResponse) obj2);
                        }
                    }, 12, (Object) null));
                    data = data;
                }
                return (List) destination$iv$iv;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(SearchResult $it, PrimeVideoMirrorProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://imgcdn.kim/pv/v/" + $it.getId() + ".jpg");
        $this$newAnimeSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this$0.getMainUrl() + "/home")));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x05af  */
    /* JADX WARN: Code duplicated, block: B:110:0x05b2  */
    /* JADX WARN: Code duplicated, block: B:113:0x062f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:114:0x0630  */
    /* JADX WARN: Code duplicated, block: B:30:0x01fe A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:34:0x0234  */
    /* JADX WARN: Code duplicated, block: B:41:0x0287  */
    /* JADX WARN: Code duplicated, block: B:45:0x02ab A[LOOP:1: B:43:0x02a5->B:45:0x02ab, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:48:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:65:0x038f  */
    /* JADX WARN: Code duplicated, block: B:68:0x0397  */
    /* JADX WARN: Code duplicated, block: B:69:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:72:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:75:0x03d9 A[LOOP:4: B:73:0x03d3->B:75:0x03d9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x042d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x043d  */
    /* JADX WARN: Code duplicated, block: B:81:0x0465  */
    /* JADX WARN: Code duplicated, block: B:84:0x047f A[LOOP:5: B:82:0x0479->B:84:0x047f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x04bc A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:88:0x04c4  */
    /* JADX WARN: Code duplicated, block: B:92:0x0508 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:93:0x0509  */
    /* JADX WARN: Code duplicated, block: B:99:0x053e  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws Exception {
        C00341 c00341;
        String url2;
        String str;
        PrimeVideoMirrorProvider primeVideoMirrorProvider;
        Object obj;
        String id;
        Map cookies;
        Object obj2;
        C00341 c00342;
        String url3;
        String url4;
        final PostData data;
        ArrayList episodes;
        String title;
        String cast;
        List destination$iv$iv;
        List castList;
        List $this$map$iv;
        Collection destination$iv$iv2;
        Iterable $this$mapTo$iv$iv;
        List cast2;
        String genre;
        ArrayList arrayList;
        List genre2;
        String match;
        String strReplace$default;
        String rating;
        int runTime;
        Iterable suggest;
        Object obj3;
        List castList2;
        ArrayList arrayList2;
        List suggest2;
        Iterable $this$mapTo$iv;
        ArrayList destination$iv;
        int $i$f$mapTo;
        Iterator it;
        Integer nextPageShow;
        String url5;
        Object episodes2;
        int runTime2;
        Map cookies2;
        String url6;
        String id2;
        PostData data2;
        List genre3;
        String rating2;
        String title2;
        ArrayList arrayList3;
        ArrayList episodes3;
        List cast3;
        List cast4;
        String id3;
        String title3;
        String url7;
        ArrayList episodes4;
        int runTime3;
        String id4;
        List cast5;
        PostData data3;
        List genre4;
        String title4;
        ArrayList genre5;
        String title5;
        List cast6;
        String id5;
        Iterable $this$map$iv2;
        Collection destination$iv$iv3;
        Iterable $this$mapTo$iv$iv2;
        Iterable iterableSplit$default;
        Iterable iterableSplit$default2;
        List<Season> season;
        List listDropLast;
        Object objAmap;
        ArrayList episodes5;
        List suggest3;
        PostData data4;
        Map cookies3;
        String title6;
        int runTime4;
        String title7;
        List castList3;
        String rating3;
        TvType tvType;
        if (continuation instanceof C00341) {
            c00341 = (C00341) continuation;
            if ((c00341.label & Integer.MIN_VALUE) != 0) {
                c00341.label -= Integer.MIN_VALUE;
            } else {
                c00341 = new C00341(continuation);
            }
        } else {
            c00341 = new C00341(continuation);
        }
        C00341 c00343 = c00341;
        Object $result = c00343.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00343.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.cookie_value.length() == 0) {
                    String mainUrl = getMainUrl();
                    url2 = url;
                    c00343.L$0 = url2;
                    c00343.L$1 = this;
                    c00343.label = 1;
                    Object objBypass = UtilsKt.bypass(mainUrl, c00343);
                    if (objBypass == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objBypass;
                    primeVideoMirrorProvider = this;
                    str = (String) obj;
                } else {
                    url2 = url;
                    str = this.cookie_value;
                    primeVideoMirrorProvider = this;
                }
                primeVideoMirrorProvider.cookie_value = str;
                String text$iv = url2;
                id = ((Id) UtilsKt.getJSONParser().parse(text$iv, Reflection.getOrCreateKotlinClass(Id.class))).getId();
                cookies = MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", this.cookie_value), TuplesKt.to("hd", "on"), TuplesKt.to("ott", "pv")});
                Requests app = UtilsKt.getApp();
                String str2 = getMainUrl() + "/mobile/pv/post.php?id=" + id + "&t=" + APIHolder.INSTANCE.getUnixTime();
                Map<String, String> map = this.headers;
                String str3 = getMainUrl() + "/home";
                c00343.L$0 = url2;
                c00343.L$1 = id;
                c00343.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                c00343.label = 2;
                obj2 = Requests.get$default(app, str2, map, str3, (Map) null, cookies, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00343, 4072, (Object) null);
                c00342 = c00343;
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                String str4 = url2;
                url3 = id;
                url4 = str4;
                NiceResponse this_$iv = (NiceResponse) obj2;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                data = (PostData) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(PostData.class));
                episodes = new ArrayList();
                title = data.getTitle();
                cast = data.getCast();
                if (cast != null || (iterableSplit$default2 = StringsKt.split$default(cast, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                    destination$iv$iv = CollectionsKt.emptyList();
                } else {
                    Iterable $this$map$iv3 = iterableSplit$default2;
                    Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    for (Object item$iv$iv : $this$map$iv3) {
                        destination$iv$iv4.add(StringsKt.trim((String) item$iv$iv).toString());
                    }
                    destination$iv$iv = (List) destination$iv$iv4;
                }
                castList = destination$iv$iv;
                $this$map$iv = castList;
                int $i$f$map = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                destination$iv$iv2 = new ArrayList($i$f$map);
                $this$mapTo$iv$iv = $this$map$iv;
                for (Object item$iv$iv2 : $this$mapTo$iv$iv) {
                    destination$iv$iv2.add(new ActorData(new Actor((String) item$iv$iv2, (String) null, 2, (DefaultConstructorMarker) null), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                    $this$map$iv = $this$map$iv;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    $result = $result;
                }
                cast2 = (List) destination$iv$iv2;
                genre = data.getGenre();
                if (genre != null || (iterableSplit$default = StringsKt.split$default(genre, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                    arrayList = null;
                } else {
                    Iterable $this$map$iv4 = iterableSplit$default;
                    Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                    for (Object item$iv$iv3 : $this$map$iv4) {
                        destination$iv$iv5.add(StringsKt.trim((String) item$iv$iv3).toString());
                        $this$map$iv4 = $this$map$iv4;
                    }
                    Iterable $this$filter$iv = (List) destination$iv$iv5;
                    Collection destination$iv$iv6 = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        Iterable $this$filter$iv2 = $this$filter$iv;
                        if (((String) element$iv$iv).length() > 0) {
                            destination$iv$iv6.add(element$iv$iv);
                        }
                        $this$filter$iv = $this$filter$iv2;
                    }
                    arrayList = (List) destination$iv$iv6;
                }
                genre2 = arrayList;
                match = data.getMatch();
                if (match != null) {
                    strReplace$default = StringsKt.replace$default(match, "IMDb ", "", false, 4, (Object) null);
                } else {
                    strReplace$default = null;
                }
                rating = strReplace$default;
                runTime = UtilsKt.convertRuntimeToMinutes(String.valueOf(data.getRuntime()));
                suggest = data.getSuggest();
                if (suggest != null) {
                    $this$map$iv2 = suggest;
                    destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv2 = $this$map$iv2;
                    for (Object item$iv$iv4 : $this$mapTo$iv$iv2) {
                        Iterable $this$map$iv5 = $this$map$iv2;
                        final Suggest it2 = (Suggest) item$iv$iv4;
                        destination$iv$iv3.add(MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(it2.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj4) {
                                return PrimeVideoMirrorProvider.load$lambda$4$0(it2, this, (AnimeSearchResponse) obj4);
                            }
                        }, 12, (Object) null));
                        $this$map$iv2 = $this$map$iv5;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                        castList = castList;
                        coroutine_suspended = coroutine_suspended;
                    }
                    obj3 = coroutine_suspended;
                    castList2 = castList;
                    arrayList2 = (List) destination$iv$iv3;
                } else {
                    obj3 = coroutine_suspended;
                    castList2 = castList;
                    arrayList2 = null;
                }
                suggest2 = arrayList2;
                if (CollectionsKt.first(data.getEpisodes()) == null) {
                    Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode(this, new LoadData(title, url3), new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj4) {
                            return PrimeVideoMirrorProvider.load$lambda$5(data, (Episode) obj4);
                        }
                    })));
                    runTime3 = runTime;
                    id4 = url3;
                    cast5 = suggest2;
                    c00342 = c00342;
                    data3 = data;
                    genre4 = genre2;
                    obj3 = obj3;
                    title4 = url4;
                    genre5 = episodes;
                    title5 = title;
                    cast6 = cast2;
                    id5 = rating;
                } else {
                    $this$mapTo$iv = CollectionsKt.filterNotNull(data.getEpisodes());
                    destination$iv = episodes;
                    $i$f$mapTo = 0;
                    for (it = $this$mapTo$iv.iterator(); it.hasNext(); it = it) {
                        Object item$iv = it.next();
                        final com.horis.cncverse.entities.Episode it3 = (com.horis.cncverse.entities.Episode) item$iv;
                        destination$iv.add(MainAPIKt.newEpisode(this, new LoadData(title, it3.getId()), new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj4) {
                                return PrimeVideoMirrorProvider.load$lambda$6$0(it3, (Episode) obj4);
                            }
                        }));
                        $this$mapTo$iv = $this$mapTo$iv;
                        $i$f$mapTo = $i$f$mapTo;
                    }
                    nextPageShow = data.getNextPageShow();
                    if (nextPageShow == null && nextPageShow.intValue() == 1) {
                        String nextPageSeason = data.getNextPageSeason();
                        Intrinsics.checkNotNull(nextPageSeason);
                        c00342.L$0 = url4;
                        c00342.L$1 = url3;
                        c00342.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                        c00342.L$3 = data;
                        c00342.L$4 = episodes;
                        c00342.L$5 = title;
                        c00342.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                        c00342.L$7 = cast2;
                        c00342.L$8 = genre2;
                        c00342.L$9 = rating;
                        c00342.L$10 = suggest2;
                        c00342.L$11 = episodes;
                        c00342.I$0 = runTime;
                        c00342.label = 3;
                        C00341 c00344 = c00342;
                        url5 = url4;
                        episodes2 = getEpisodes(title, url5, nextPageSeason, 2, c00344);
                        c00342 = c00344;
                        obj3 = obj3;
                        if (episodes2 == obj3) {
                            return obj3;
                        }
                        Map map2 = cookies;
                        runTime2 = runTime;
                        cookies2 = map2;
                        url6 = url5;
                        id2 = url3;
                        data2 = data;
                        genre3 = genre2;
                        rating2 = rating;
                        title2 = title;
                        arrayList3 = episodes;
                        episodes3 = arrayList3;
                        cast3 = cast2;
                        arrayList3.addAll((Collection) episodes2);
                        int i = runTime2;
                        cookies = cookies2;
                        runTime = i;
                        title3 = title2;
                        episodes4 = episodes3;
                        id3 = id2;
                        rating = rating2;
                        genre2 = genre3;
                        url7 = url6;
                        data = data2;
                        cast4 = cast3;
                        season = data.getSeason();
                        if (season != null || (listDropLast = CollectionsKt.dropLast(season, 1)) == null) {
                            title5 = title3;
                            cast6 = cast4;
                            data3 = data;
                            title4 = url7;
                            cast5 = suggest2;
                            runTime3 = runTime;
                            genre4 = genre2;
                            genre5 = episodes4;
                            id4 = id3;
                            id5 = rating;
                        } else {
                            C00354 c00354 = new C00354(episodes4, this, title3, url7, null);
                            c00342.L$0 = url7;
                            c00342.L$1 = id3;
                            c00342.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                            c00342.L$3 = data;
                            c00342.L$4 = episodes4;
                            c00342.L$5 = title3;
                            c00342.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                            c00342.L$7 = cast4;
                            c00342.L$8 = genre2;
                            c00342.L$9 = rating;
                            c00342.L$10 = suggest2;
                            c00342.L$11 = null;
                            c00342.I$0 = runTime;
                            c00342.label = 4;
                            objAmap = ParCollectionsKt.amap(listDropLast, c00354, c00342);
                            if (objAmap == obj3) {
                                return obj3;
                            }
                            episodes5 = episodes4;
                            suggest3 = suggest2;
                            data4 = data;
                            cookies3 = cookies;
                            title6 = title3;
                            runTime4 = runTime;
                            title7 = rating;
                            castList3 = castList2;
                            rating3 = id3;
                            String str5 = title6;
                            title4 = url7;
                            genre4 = genre2;
                            genre5 = episodes5;
                            title5 = str5;
                            id5 = title7;
                            castList2 = castList3;
                            runTime3 = runTime4;
                            data3 = data4;
                            cookies = cookies3;
                            cast6 = cast4;
                            cast5 = suggest3;
                            id4 = rating3;
                        }
                    } else {
                        String str6 = url3;
                        cast4 = cast2;
                        id3 = str6;
                        title3 = title;
                        url7 = url4;
                        episodes4 = episodes;
                        season = data.getSeason();
                        if (season != null) {
                        }
                        title5 = title3;
                        cast6 = cast4;
                        data3 = data;
                        title4 = url7;
                        cast5 = suggest2;
                        runTime3 = runTime;
                        genre4 = genre2;
                        genre5 = episodes4;
                        id4 = id3;
                        id5 = rating;
                    }
                }
                if (CollectionsKt.first(data3.getEpisodes()) == null) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                TvType type = tvType;
                String rating4 = id5;
                C00365 c00365 = new C00365(id4, this, data3, genre4, cast6, id5, runTime3, cast5, null);
                c00342.L$0 = SpillingKt.nullOutSpilledVariable(title4);
                c00342.L$1 = SpillingKt.nullOutSpilledVariable(id4);
                c00342.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                c00342.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00342.L$4 = SpillingKt.nullOutSpilledVariable(genre5);
                c00342.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                c00342.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                c00342.L$7 = SpillingKt.nullOutSpilledVariable(cast6);
                c00342.L$8 = SpillingKt.nullOutSpilledVariable(genre4);
                c00342.L$9 = SpillingKt.nullOutSpilledVariable(rating4);
                c00342.L$10 = SpillingKt.nullOutSpilledVariable(cast5);
                c00342.L$11 = SpillingKt.nullOutSpilledVariable(type);
                c00342.I$0 = runTime3;
                c00342.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title5, title4, type, genre5, c00365, c00342);
                if ($result == obj3) {
                    return obj3;
                }
                return $result;
            case 1:
                primeVideoMirrorProvider = (PrimeVideoMirrorProvider) c00343.L$1;
                url2 = (String) c00343.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                str = (String) obj;
                primeVideoMirrorProvider.cookie_value = str;
                String text$iv2 = url2;
                id = ((Id) UtilsKt.getJSONParser().parse(text$iv2, Reflection.getOrCreateKotlinClass(Id.class))).getId();
                cookies = MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", this.cookie_value), TuplesKt.to("hd", "on"), TuplesKt.to("ott", "pv")});
                Requests app2 = UtilsKt.getApp();
                String str7 = getMainUrl() + "/mobile/pv/post.php?id=" + id + "&t=" + APIHolder.INSTANCE.getUnixTime();
                Map<String, String> map3 = this.headers;
                String str8 = getMainUrl() + "/home";
                c00343.L$0 = url2;
                c00343.L$1 = id;
                c00343.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                c00343.label = 2;
                obj2 = Requests.get$default(app2, str7, map3, str8, (Map) null, cookies, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00343, 4072, (Object) null);
                c00342 = c00343;
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                String str9 = url2;
                url3 = id;
                url4 = str9;
                NiceResponse this_$iv2 = (NiceResponse) obj2;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                data = (PostData) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(PostData.class));
                episodes = new ArrayList();
                title = data.getTitle();
                cast = data.getCast();
                if (cast != null) {
                    destination$iv$iv = CollectionsKt.emptyList();
                } else {
                    destination$iv$iv = CollectionsKt.emptyList();
                }
                castList = destination$iv$iv;
                $this$map$iv = castList;
                int $i$f$map2 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                destination$iv$iv2 = new ArrayList($i$f$map2);
                $this$mapTo$iv$iv = $this$map$iv;
                while (r20.hasNext()) {
                    destination$iv$iv2.add(new ActorData(new Actor((String) item$iv$iv2, (String) null, 2, (DefaultConstructorMarker) null), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                    $this$map$iv = $this$map$iv;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    $result = $result;
                }
                cast2 = (List) destination$iv$iv2;
                genre = data.getGenre();
                if (genre != null) {
                    arrayList = null;
                } else {
                    arrayList = null;
                }
                genre2 = arrayList;
                match = data.getMatch();
                if (match != null) {
                    strReplace$default = StringsKt.replace$default(match, "IMDb ", "", false, 4, (Object) null);
                } else {
                    strReplace$default = null;
                }
                rating = strReplace$default;
                runTime = UtilsKt.convertRuntimeToMinutes(String.valueOf(data.getRuntime()));
                suggest = data.getSuggest();
                if (suggest != null) {
                    $this$map$iv2 = suggest;
                    destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv2 = $this$map$iv2;
                    while (r18.hasNext()) {
                        Iterable $this$map$iv6 = $this$map$iv2;
                        final Suggest it4 = (Suggest) item$iv$iv4;
                        destination$iv$iv3.add(MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(it4.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj4) {
                                return PrimeVideoMirrorProvider.load$lambda$4$0(it4, this, (AnimeSearchResponse) obj4);
                            }
                        }, 12, (Object) null));
                        $this$map$iv2 = $this$map$iv6;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                        castList = castList;
                        coroutine_suspended = coroutine_suspended;
                    }
                    obj3 = coroutine_suspended;
                    castList2 = castList;
                    arrayList2 = (List) destination$iv$iv3;
                } else {
                    obj3 = coroutine_suspended;
                    castList2 = castList;
                    arrayList2 = null;
                }
                suggest2 = arrayList2;
                if (CollectionsKt.first(data.getEpisodes()) == null) {
                    $this$mapTo$iv = CollectionsKt.filterNotNull(data.getEpisodes());
                    destination$iv = episodes;
                    $i$f$mapTo = 0;
                    while (it.hasNext()) {
                        Object item$iv2 = it.next();
                        final com.horis.cncverse.entities.Episode it5 = (com.horis.cncverse.entities.Episode) item$iv2;
                        destination$iv.add(MainAPIKt.newEpisode(this, new LoadData(title, it5.getId()), new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj4) {
                                return PrimeVideoMirrorProvider.load$lambda$6$0(it5, (Episode) obj4);
                            }
                        }));
                        $this$mapTo$iv = $this$mapTo$iv;
                        $i$f$mapTo = $i$f$mapTo;
                    }
                    nextPageShow = data.getNextPageShow();
                    if (nextPageShow == null) {
                        String nextPageSeason2 = data.getNextPageSeason();
                        Intrinsics.checkNotNull(nextPageSeason2);
                        c00342.L$0 = url4;
                        c00342.L$1 = url3;
                        c00342.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                        c00342.L$3 = data;
                        c00342.L$4 = episodes;
                        c00342.L$5 = title;
                        c00342.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                        c00342.L$7 = cast2;
                        c00342.L$8 = genre2;
                        c00342.L$9 = rating;
                        c00342.L$10 = suggest2;
                        c00342.L$11 = episodes;
                        c00342.I$0 = runTime;
                        c00342.label = 3;
                        C00341 c00345 = c00342;
                        url5 = url4;
                        episodes2 = getEpisodes(title, url5, nextPageSeason2, 2, c00345);
                        c00342 = c00345;
                        obj3 = obj3;
                        if (episodes2 == obj3) {
                            return obj3;
                        }
                        Map map4 = cookies;
                        runTime2 = runTime;
                        cookies2 = map4;
                        url6 = url5;
                        id2 = url3;
                        data2 = data;
                        genre3 = genre2;
                        rating2 = rating;
                        title2 = title;
                        arrayList3 = episodes;
                        episodes3 = arrayList3;
                        cast3 = cast2;
                        arrayList3.addAll((Collection) episodes2);
                        int i2 = runTime2;
                        cookies = cookies2;
                        runTime = i2;
                        title3 = title2;
                        episodes4 = episodes3;
                        id3 = id2;
                        rating = rating2;
                        genre2 = genre3;
                        url7 = url6;
                        data = data2;
                        cast4 = cast3;
                        season = data.getSeason();
                        if (season != null) {
                        }
                        title5 = title3;
                        cast6 = cast4;
                        data3 = data;
                        title4 = url7;
                        cast5 = suggest2;
                        runTime3 = runTime;
                        genre4 = genre2;
                        genre5 = episodes4;
                        id4 = id3;
                        id5 = rating;
                        break;
                    }
                    String str10 = url3;
                    cast4 = cast2;
                    id3 = str10;
                    title3 = title;
                    url7 = url4;
                    episodes4 = episodes;
                    season = data.getSeason();
                    if (season != null) {
                    }
                    title5 = title3;
                    cast6 = cast4;
                    data3 = data;
                    title4 = url7;
                    cast5 = suggest2;
                    runTime3 = runTime;
                    genre4 = genre2;
                    genre5 = episodes4;
                    id4 = id3;
                    id5 = rating;
                    break;
                } else {
                    Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode(this, new LoadData(title, url3), new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj4) {
                            return PrimeVideoMirrorProvider.load$lambda$5(data, (Episode) obj4);
                        }
                    })));
                    runTime3 = runTime;
                    id4 = url3;
                    cast5 = suggest2;
                    c00342 = c00342;
                    data3 = data;
                    genre4 = genre2;
                    obj3 = obj3;
                    title4 = url4;
                    genre5 = episodes;
                    title5 = title;
                    cast6 = cast2;
                    id5 = rating;
                }
                if (CollectionsKt.first(data3.getEpisodes()) == null) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                TvType type2 = tvType;
                String rating5 = id5;
                C00365 c00366 = new C00365(id4, this, data3, genre4, cast6, id5, runTime3, cast5, null);
                c00342.L$0 = SpillingKt.nullOutSpilledVariable(title4);
                c00342.L$1 = SpillingKt.nullOutSpilledVariable(id4);
                c00342.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                c00342.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00342.L$4 = SpillingKt.nullOutSpilledVariable(genre5);
                c00342.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                c00342.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                c00342.L$7 = SpillingKt.nullOutSpilledVariable(cast6);
                c00342.L$8 = SpillingKt.nullOutSpilledVariable(genre4);
                c00342.L$9 = SpillingKt.nullOutSpilledVariable(rating5);
                c00342.L$10 = SpillingKt.nullOutSpilledVariable(cast5);
                c00342.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                c00342.I$0 = runTime3;
                c00342.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title5, title4, type2, genre5, c00366, c00342);
                if ($result == obj3) {
                    return obj3;
                }
                return $result;
            case 2:
                Map cookies4 = (Map) c00343.L$2;
                url3 = (String) c00343.L$1;
                String url8 = (String) c00343.L$0;
                ResultKt.throwOnFailure($result);
                cookies = cookies4;
                url4 = url8;
                c00342 = c00343;
                obj2 = $result;
                NiceResponse this_$iv3 = (NiceResponse) obj2;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                data = (PostData) parser3.parse(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(PostData.class));
                episodes = new ArrayList();
                title = data.getTitle();
                cast = data.getCast();
                if (cast != null) {
                    destination$iv$iv = CollectionsKt.emptyList();
                } else {
                    destination$iv$iv = CollectionsKt.emptyList();
                }
                castList = destination$iv$iv;
                $this$map$iv = castList;
                int $i$f$map3 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                destination$iv$iv2 = new ArrayList($i$f$map3);
                $this$mapTo$iv$iv = $this$map$iv;
                while (r20.hasNext()) {
                    destination$iv$iv2.add(new ActorData(new Actor((String) item$iv$iv2, (String) null, 2, (DefaultConstructorMarker) null), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                    $this$map$iv = $this$map$iv;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    $result = $result;
                }
                cast2 = (List) destination$iv$iv2;
                genre = data.getGenre();
                if (genre != null) {
                    arrayList = null;
                } else {
                    arrayList = null;
                }
                genre2 = arrayList;
                match = data.getMatch();
                if (match != null) {
                    strReplace$default = StringsKt.replace$default(match, "IMDb ", "", false, 4, (Object) null);
                } else {
                    strReplace$default = null;
                }
                rating = strReplace$default;
                runTime = UtilsKt.convertRuntimeToMinutes(String.valueOf(data.getRuntime()));
                suggest = data.getSuggest();
                if (suggest != null) {
                    $this$map$iv2 = suggest;
                    destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv2 = $this$map$iv2;
                    while (r18.hasNext()) {
                        Iterable $this$map$iv7 = $this$map$iv2;
                        final Suggest it6 = (Suggest) item$iv$iv4;
                        destination$iv$iv3.add(MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(it6.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj4) {
                                return PrimeVideoMirrorProvider.load$lambda$4$0(it6, this, (AnimeSearchResponse) obj4);
                            }
                        }, 12, (Object) null));
                        $this$map$iv2 = $this$map$iv7;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                        castList = castList;
                        coroutine_suspended = coroutine_suspended;
                    }
                    obj3 = coroutine_suspended;
                    castList2 = castList;
                    arrayList2 = (List) destination$iv$iv3;
                } else {
                    obj3 = coroutine_suspended;
                    castList2 = castList;
                    arrayList2 = null;
                }
                suggest2 = arrayList2;
                if (CollectionsKt.first(data.getEpisodes()) == null) {
                    $this$mapTo$iv = CollectionsKt.filterNotNull(data.getEpisodes());
                    destination$iv = episodes;
                    $i$f$mapTo = 0;
                    while (it.hasNext()) {
                        Object item$iv3 = it.next();
                        final com.horis.cncverse.entities.Episode it7 = (com.horis.cncverse.entities.Episode) item$iv3;
                        destination$iv.add(MainAPIKt.newEpisode(this, new LoadData(title, it7.getId()), new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj4) {
                                return PrimeVideoMirrorProvider.load$lambda$6$0(it7, (Episode) obj4);
                            }
                        }));
                        $this$mapTo$iv = $this$mapTo$iv;
                        $i$f$mapTo = $i$f$mapTo;
                    }
                    nextPageShow = data.getNextPageShow();
                    if (nextPageShow == null) {
                        String nextPageSeason3 = data.getNextPageSeason();
                        Intrinsics.checkNotNull(nextPageSeason3);
                        c00342.L$0 = url4;
                        c00342.L$1 = url3;
                        c00342.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                        c00342.L$3 = data;
                        c00342.L$4 = episodes;
                        c00342.L$5 = title;
                        c00342.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                        c00342.L$7 = cast2;
                        c00342.L$8 = genre2;
                        c00342.L$9 = rating;
                        c00342.L$10 = suggest2;
                        c00342.L$11 = episodes;
                        c00342.I$0 = runTime;
                        c00342.label = 3;
                        C00341 c00346 = c00342;
                        url5 = url4;
                        episodes2 = getEpisodes(title, url5, nextPageSeason3, 2, c00346);
                        c00342 = c00346;
                        obj3 = obj3;
                        if (episodes2 == obj3) {
                            return obj3;
                        }
                        Map map5 = cookies;
                        runTime2 = runTime;
                        cookies2 = map5;
                        url6 = url5;
                        id2 = url3;
                        data2 = data;
                        genre3 = genre2;
                        rating2 = rating;
                        title2 = title;
                        arrayList3 = episodes;
                        episodes3 = arrayList3;
                        cast3 = cast2;
                        arrayList3.addAll((Collection) episodes2);
                        int i3 = runTime2;
                        cookies = cookies2;
                        runTime = i3;
                        title3 = title2;
                        episodes4 = episodes3;
                        id3 = id2;
                        rating = rating2;
                        genre2 = genre3;
                        url7 = url6;
                        data = data2;
                        cast4 = cast3;
                        season = data.getSeason();
                        if (season != null) {
                        }
                        title5 = title3;
                        cast6 = cast4;
                        data3 = data;
                        title4 = url7;
                        cast5 = suggest2;
                        runTime3 = runTime;
                        genre4 = genre2;
                        genre5 = episodes4;
                        id4 = id3;
                        id5 = rating;
                        break;
                    }
                    String str11 = url3;
                    cast4 = cast2;
                    id3 = str11;
                    title3 = title;
                    url7 = url4;
                    episodes4 = episodes;
                    season = data.getSeason();
                    if (season != null) {
                    }
                    title5 = title3;
                    cast6 = cast4;
                    data3 = data;
                    title4 = url7;
                    cast5 = suggest2;
                    runTime3 = runTime;
                    genre4 = genre2;
                    genre5 = episodes4;
                    id4 = id3;
                    id5 = rating;
                    break;
                } else {
                    Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode(this, new LoadData(title, url3), new Function1() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj4) {
                            return PrimeVideoMirrorProvider.load$lambda$5(data, (Episode) obj4);
                        }
                    })));
                    runTime3 = runTime;
                    id4 = url3;
                    cast5 = suggest2;
                    c00342 = c00342;
                    data3 = data;
                    genre4 = genre2;
                    obj3 = obj3;
                    title4 = url4;
                    genre5 = episodes;
                    title5 = title;
                    cast6 = cast2;
                    id5 = rating;
                }
                if (CollectionsKt.first(data3.getEpisodes()) == null) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                TvType type3 = tvType;
                String rating6 = id5;
                C00365 c00367 = new C00365(id4, this, data3, genre4, cast6, id5, runTime3, cast5, null);
                c00342.L$0 = SpillingKt.nullOutSpilledVariable(title4);
                c00342.L$1 = SpillingKt.nullOutSpilledVariable(id4);
                c00342.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                c00342.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00342.L$4 = SpillingKt.nullOutSpilledVariable(genre5);
                c00342.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                c00342.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                c00342.L$7 = SpillingKt.nullOutSpilledVariable(cast6);
                c00342.L$8 = SpillingKt.nullOutSpilledVariable(genre4);
                c00342.L$9 = SpillingKt.nullOutSpilledVariable(rating6);
                c00342.L$10 = SpillingKt.nullOutSpilledVariable(cast5);
                c00342.L$11 = SpillingKt.nullOutSpilledVariable(type3);
                c00342.I$0 = runTime3;
                c00342.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title5, title4, type3, genre5, c00367, c00342);
                if ($result == obj3) {
                    return obj3;
                }
                return $result;
            case 3:
                int runTime5 = c00343.I$0;
                arrayList3 = (ArrayList) c00343.L$11;
                List suggest4 = (List) c00343.L$10;
                rating2 = (String) c00343.L$9;
                genre3 = (List) c00343.L$8;
                cast3 = (List) c00343.L$7;
                List castList4 = (List) c00343.L$6;
                title2 = (String) c00343.L$5;
                episodes3 = (ArrayList) c00343.L$4;
                data2 = (PostData) c00343.L$3;
                cookies2 = (Map) c00343.L$2;
                runTime2 = runTime5;
                id2 = (String) c00343.L$1;
                url6 = (String) c00343.L$0;
                ResultKt.throwOnFailure($result);
                c00342 = c00343;
                castList2 = castList4;
                obj3 = coroutine_suspended;
                suggest2 = suggest4;
                episodes2 = $result;
                arrayList3.addAll((Collection) episodes2);
                int i4 = runTime2;
                cookies = cookies2;
                runTime = i4;
                title3 = title2;
                episodes4 = episodes3;
                id3 = id2;
                rating = rating2;
                genre2 = genre3;
                url7 = url6;
                data = data2;
                cast4 = cast3;
                season = data.getSeason();
                if (season != null) {
                    break;
                }
                title5 = title3;
                cast6 = cast4;
                data3 = data;
                title4 = url7;
                cast5 = suggest2;
                runTime3 = runTime;
                genre4 = genre2;
                genre5 = episodes4;
                id4 = id3;
                id5 = rating;
                if (CollectionsKt.first(data3.getEpisodes()) == null) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                TvType type4 = tvType;
                String rating7 = id5;
                C00365 c00368 = new C00365(id4, this, data3, genre4, cast6, id5, runTime3, cast5, null);
                c00342.L$0 = SpillingKt.nullOutSpilledVariable(title4);
                c00342.L$1 = SpillingKt.nullOutSpilledVariable(id4);
                c00342.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                c00342.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00342.L$4 = SpillingKt.nullOutSpilledVariable(genre5);
                c00342.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                c00342.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                c00342.L$7 = SpillingKt.nullOutSpilledVariable(cast6);
                c00342.L$8 = SpillingKt.nullOutSpilledVariable(genre4);
                c00342.L$9 = SpillingKt.nullOutSpilledVariable(rating7);
                c00342.L$10 = SpillingKt.nullOutSpilledVariable(cast5);
                c00342.L$11 = SpillingKt.nullOutSpilledVariable(type4);
                c00342.I$0 = runTime3;
                c00342.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title5, title4, type4, genre5, c00368, c00342);
                if ($result == obj3) {
                    return obj3;
                }
                return $result;
            case 4:
                int runTime6 = c00343.I$0;
                suggest3 = (List) c00343.L$10;
                title7 = (String) c00343.L$9;
                List genre6 = (List) c00343.L$8;
                cast4 = (List) c00343.L$7;
                castList3 = (List) c00343.L$6;
                title6 = (String) c00343.L$5;
                episodes5 = (ArrayList) c00343.L$4;
                PostData data5 = (PostData) c00343.L$3;
                Map cookies5 = (Map) c00343.L$2;
                rating3 = (String) c00343.L$1;
                runTime4 = runTime6;
                String url9 = (String) c00343.L$0;
                ResultKt.throwOnFailure($result);
                c00342 = c00343;
                data4 = data5;
                cookies3 = cookies5;
                genre2 = genre6;
                obj3 = coroutine_suspended;
                url7 = url9;
                objAmap = $result;
                String str12 = title6;
                title4 = url7;
                genre4 = genre2;
                genre5 = episodes5;
                title5 = str12;
                id5 = title7;
                castList2 = castList3;
                runTime3 = runTime4;
                data3 = data4;
                cookies = cookies3;
                cast6 = cast4;
                cast5 = suggest3;
                id4 = rating3;
                if (CollectionsKt.first(data3.getEpisodes()) == null) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                TvType type5 = tvType;
                String rating8 = id5;
                C00365 c00369 = new C00365(id4, this, data3, genre4, cast6, id5, runTime3, cast5, null);
                c00342.L$0 = SpillingKt.nullOutSpilledVariable(title4);
                c00342.L$1 = SpillingKt.nullOutSpilledVariable(id4);
                c00342.L$2 = SpillingKt.nullOutSpilledVariable(cookies);
                c00342.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00342.L$4 = SpillingKt.nullOutSpilledVariable(genre5);
                c00342.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                c00342.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                c00342.L$7 = SpillingKt.nullOutSpilledVariable(cast6);
                c00342.L$8 = SpillingKt.nullOutSpilledVariable(genre4);
                c00342.L$9 = SpillingKt.nullOutSpilledVariable(rating8);
                c00342.L$10 = SpillingKt.nullOutSpilledVariable(cast5);
                c00342.L$11 = SpillingKt.nullOutSpilledVariable(type5);
                c00342.I$0 = runTime3;
                c00342.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title5, title4, type5, genre5, c00369, c00342);
                if ($result == obj3) {
                    return obj3;
                }
                return $result;
            case 5:
                int i5 = c00343.I$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$4$0(Suggest $it, PrimeVideoMirrorProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://imgcdn.kim/pv/v/" + $it.getId() + ".jpg");
        $this$newAnimeSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this$0.getMainUrl() + "/home")));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$5(PostData $data, Episode $this$newEpisode) {
        $this$newEpisode.setName($data.getTitle());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$6$0(com.horis.cncverse.entities.Episode $it, Episode $this$newEpisode) {
        $this$newEpisode.setName($it.getT());
        $this$newEpisode.setEpisode(StringsKt.toIntOrNull(StringsKt.replace$default($it.getEp(), "E", "", false, 4, (Object) null)));
        $this$newEpisode.setSeason(StringsKt.toIntOrNull(StringsKt.replace$default($it.getS(), "S", "", false, 4, (Object) null)));
        $this$newEpisode.setPosterUrl("https://imgcdn.kim/pvepimg/" + $it.getId() + ".jpg");
        $this$newEpisode.setRunTime(StringsKt.toIntOrNull(StringsKt.replace$default($it.getTime(), "m", "", false, 4, (Object) null)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$load$4 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/horis/cncverse/entities/Season;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider$load$4", f = "PrimeVideoMirrorProvider.kt", i = {0}, l = {175}, m = "invokeSuspend", n = {"it"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class C00354 extends SuspendLambda implements Function2<Season, Continuation<? super Boolean>, Object> {
        final /* synthetic */ ArrayList<Episode> $episodes;
        final /* synthetic */ String $title;
        final /* synthetic */ String $url;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ PrimeVideoMirrorProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00354(ArrayList<Episode> arrayList, PrimeVideoMirrorProvider primeVideoMirrorProvider, String str, String str2, Continuation<? super C00354> continuation) {
            super(2, continuation);
            this.$episodes = arrayList;
            this.this$0 = primeVideoMirrorProvider;
            this.$title = str;
            this.$url = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00354 = new C00354(this.$episodes, this.this$0, this.$title, this.$url, continuation);
            c00354.L$0 = obj;
            return c00354;
        }

        public final Object invoke(Season season, Continuation<? super Boolean> continuation) {
            return create(season, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object episodes;
            ArrayList<Episode> arrayList;
            Season it = (Season) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    ArrayList<Episode> arrayList2 = this.$episodes;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = arrayList2;
                    this.label = 1;
                    episodes = this.this$0.getEpisodes(this.$title, this.$url, it.getId(), 1, (Continuation) this);
                    if (episodes == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    arrayList = arrayList2;
                    break;
                    break;
                case 1:
                    arrayList = (ArrayList) this.L$1;
                    ResultKt.throwOnFailure($result);
                    episodes = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Boxing.boxBoolean(arrayList.addAll((Collection) episodes));
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$load$5 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider$load$5", f = "PrimeVideoMirrorProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00365 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $cast;
        final /* synthetic */ PostData $data;
        final /* synthetic */ List<String> $genre;
        final /* synthetic */ String $id;
        final /* synthetic */ String $rating;
        final /* synthetic */ int $runTime;
        final /* synthetic */ List<AnimeSearchResponse> $suggest;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PrimeVideoMirrorProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00365(String str, PrimeVideoMirrorProvider primeVideoMirrorProvider, PostData postData, List<String> list, List<ActorData> list2, String str2, int i, List<AnimeSearchResponse> list3, Continuation<? super C00365> continuation) {
            super(2, continuation);
            this.$id = str;
            this.this$0 = primeVideoMirrorProvider;
            this.$data = postData;
            this.$genre = list;
            this.$cast = list2;
            this.$rating = str2;
            this.$runTime = i;
            this.$suggest = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00365 = new C00365(this.$id, this.this$0, this.$data, this.$genre, this.$cast, this.$rating, this.$runTime, this.$suggest, continuation);
            c00365.L$0 = obj;
            return c00365;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newTvSeriesLoadResponse.setPosterUrl("https://imgcdn.kim/pv/v/" + this.$id + ".jpg");
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl("https://imgcdn.kim/pv/h/" + this.$id + ".jpg");
                    $this$newTvSeriesLoadResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this.this$0.getMainUrl() + "/home")));
                    $this$newTvSeriesLoadResponse.setPlot(this.$data.getDesc());
                    $this$newTvSeriesLoadResponse.setYear(StringsKt.toIntOrNull(this.$data.getYear()));
                    $this$newTvSeriesLoadResponse.setTags(this.$genre);
                    $this$newTvSeriesLoadResponse.setActors(this.$cast);
                    $this$newTvSeriesLoadResponse.setScore(Score.Companion.from10(this.$rating));
                    $this$newTvSeriesLoadResponse.setDuration(Boxing.boxInt(this.$runTime));
                    $this$newTvSeriesLoadResponse.setContentRating(this.$data.getUa());
                    $this$newTvSeriesLoadResponse.setRecommendations(this.$suggest);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x0149 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:17:0x014a  */
    /* JADX WARN: Code duplicated, block: B:20:0x0172  */
    /* JADX WARN: Code duplicated, block: B:23:0x0183 A[LOOP:0: B:21:0x017d->B:23:0x0183, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:28:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x014a -> B:18:0x0150). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.attributes.nodes.LoopInfo.getExitEdges(LoopInfo.java:64)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:265)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        */
    public final java.lang.Object getEpisodes(java.lang.String r29, java.lang.String r30, java.lang.String r31, int r32, kotlin.coroutines.Continuation<? super java.util.List<com.lagradost.cloudstream3.Episode>> r33) {
        /*
            Method dump skipped, instruction units count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cncverse.PrimeVideoMirrorProvider.getEpisodes(java.lang.String, java.lang.String, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getEpisodes$lambda$0$0(com.horis.cncverse.entities.Episode $it, Episode $this$newEpisode) {
        $this$newEpisode.setName($it.getT());
        $this$newEpisode.setEpisode(StringsKt.toIntOrNull(StringsKt.replace$default($it.getEp(), "E", "", false, 4, (Object) null)));
        $this$newEpisode.setSeason(StringsKt.toIntOrNull(StringsKt.replace$default($it.getS(), "S", "", false, 4, (Object) null)));
        $this$newEpisode.setPosterUrl("https://imgcdn.kim/pvepimg/" + $it.getId() + ".jpg");
        $this$newEpisode.setRunTime(StringsKt.toIntOrNull(StringsKt.replace$default($it.getTime(), "m", "", false, 4, (Object) null)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x01a8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:28:0x0248 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0249  */
    /* JADX WARN: Code duplicated, block: B:32:0x0284  */
    /* JADX WARN: Code duplicated, block: B:34:0x02af A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:38:0x0341 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x0342  */
    /* JADX WARN: Code duplicated, block: B:41:0x0372  */
    /* JADX WARN: Code duplicated, block: B:44:0x0386  */
    /* JADX WARN: Code duplicated, block: B:48:0x038f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0392  */
    /* JADX WARN: Code duplicated, block: B:52:0x0397  */
    /* JADX WARN: Code duplicated, block: B:54:0x03f1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00371 c00371;
        PrimeVideoMirrorProvider primeVideoMirrorProvider;
        String data2;
        Function1<? super ExtractorLink, Unit> function3;
        Object objResolveApiUrl;
        Function1<? super SubtitleFile, Unit> function4;
        boolean isCasting2;
        String apiBase;
        String id;
        Function1<? super ExtractorLink, Unit> function5;
        Object newTvUserToken$default;
        String apiBase2;
        String id2;
        boolean isCasting3;
        Function1<? super SubtitleFile, Unit> function6;
        Function1<? super ExtractorLink, Unit> function7;
        Ref.ObjectRef response;
        String data3;
        String apiBase3;
        Function1<? super ExtractorLink, Unit> function8;
        boolean isCasting4;
        String userToken;
        Object obj;
        Object obj2;
        String str;
        String str2;
        String id3;
        Object obj3;
        Object obj4;
        Function1<? super SubtitleFile, Unit> function9;
        String apiBase4;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef response2;
        String id4;
        boolean isCasting5;
        Function1<? super ExtractorLink, Unit> function10;
        String data4;
        boolean isCasting6;
        String apiBase5;
        Function1<? super ExtractorLink, Unit> function11;
        Function1<? super SubtitleFile, Unit> function12;
        String data5;
        String apiBase6;
        Ref.ObjectRef response3;
        String str3;
        Object newTvUserToken;
        String data6;
        boolean isCasting7;
        Ref.ObjectRef response4;
        String apiBase7;
        String id5;
        Function1<? super ExtractorLink, Unit> function13;
        Function1<? super SubtitleFile, Unit> function14;
        String userToken2;
        String id6;
        String apiBase8;
        Function1<? super ExtractorLink, Unit> function15;
        Ref.ObjectRef response5;
        boolean isCasting8;
        Object obj5;
        String userToken3;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef response6;
        String id7;
        String video_link;
        boolean z;
        Object objNewExtractorLink;
        Function1<? super ExtractorLink, Unit> function16;
        if (continuation instanceof C00371) {
            c00371 = (C00371) continuation;
            if ((c00371.label & Integer.MIN_VALUE) != 0) {
                c00371.label -= Integer.MIN_VALUE;
                primeVideoMirrorProvider = this;
            } else {
                primeVideoMirrorProvider = this;
                c00371 = primeVideoMirrorProvider.new C00371(continuation);
            }
        } else {
            primeVideoMirrorProvider = this;
            c00371 = primeVideoMirrorProvider.new C00371(continuation);
        }
        C00371 c00372 = c00371;
        Object $result = c00372.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00372.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                data2 = data;
                c00372.L$0 = data2;
                c00372.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                function3 = function2;
                c00372.L$2 = function3;
                c00372.Z$0 = isCasting;
                c00372.label = 1;
                objResolveApiUrl = UtilsKt.resolveApiUrl(c00372);
                if (objResolveApiUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function4 = function1;
                isCasting2 = isCasting;
                apiBase = (String) objResolveApiUrl;
                String text$iv = data2;
                id = ((LoadData) UtilsKt.getJSONParser().parse(text$iv, Reflection.getOrCreateKotlinClass(LoadData.class))).getId();
                c00372.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00372.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                c00372.L$2 = function3;
                c00372.L$3 = apiBase;
                c00372.L$4 = id;
                c00372.Z$0 = isCasting2;
                c00372.label = 2;
                function5 = function3;
                newTvUserToken$default = UtilsKt.getNewTvUserToken$default(apiBase, "pv", false, c00372, 4, null);
                if (newTvUserToken$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiBase2 = apiBase;
                id2 = id;
                isCasting3 = isCasting2;
                function6 = function4;
                function7 = function5;
                String userToken4 = (String) newTvUserToken$default;
                response = new Ref.ObjectRef();
                data3 = data2;
                Map<String, String> mapBuildNewTvHeaders = UtilsKt.buildNewTvHeaders("pv", MapsKt.mapOf(TuplesKt.to("Usertoken", userToken4)));
                c00372.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00372.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00372.L$2 = function7;
                c00372.L$3 = apiBase2;
                c00372.L$4 = id2;
                c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken4);
                c00372.L$6 = response;
                c00372.L$7 = response;
                c00372.Z$0 = isCasting3;
                c00372.label = 3;
                apiBase3 = apiBase2;
                function8 = function7;
                isCasting4 = isCasting3;
                userToken = userToken4;
                obj = coroutine_suspended;
                obj2 = "Usertoken";
                str = "/newtv/player.php?id=";
                str2 = "pv";
                id3 = id2;
                obj3 = Requests.get$default(UtilsKt.getApp(), apiBase2 + "/newtv/player.php?id=" + id2, mapBuildNewTvHeaders, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00372, 4092, (Object) null);
                c00372 = c00372;
                if (obj3 == obj) {
                    return obj;
                }
                obj4 = obj3;
                function9 = function6;
                apiBase4 = apiBase3;
                objectRef = response;
                response2 = objectRef;
                id4 = id3;
                isCasting5 = isCasting4;
                function10 = function8;
                data4 = data3;
                NiceResponse this_$iv = (NiceResponse) obj4;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                objectRef.element = parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                if (Intrinsics.areEqual(((NewTvPlayerResponse) response2.element).getStatus(), "otp")) {
                    c00372.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00372.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    c00372.L$2 = function10;
                    c00372.L$3 = apiBase4;
                    c00372.L$4 = id4;
                    c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                    c00372.L$6 = response2;
                    c00372.L$7 = null;
                    c00372.Z$0 = isCasting5;
                    c00372.label = 4;
                    str3 = str2;
                    newTvUserToken = UtilsKt.getNewTvUserToken(apiBase4, str3, true, c00372);
                    if (newTvUserToken == obj) {
                        return obj;
                    }
                    data6 = data4;
                    isCasting7 = isCasting5;
                    response4 = response2;
                    apiBase7 = id4;
                    id5 = apiBase4;
                    function13 = function10;
                    function14 = function9;
                    userToken2 = (String) newTvUserToken;
                    Map<String, String> mapBuildNewTvHeaders2 = UtilsKt.buildNewTvHeaders(str3, MapsKt.mapOf(TuplesKt.to(obj2, userToken2)));
                    c00372.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                    c00372.L$1 = SpillingKt.nullOutSpilledVariable(function14);
                    c00372.L$2 = function13;
                    c00372.L$3 = id5;
                    c00372.L$4 = SpillingKt.nullOutSpilledVariable(apiBase7);
                    c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken2);
                    c00372.L$6 = response4;
                    c00372.L$7 = response4;
                    c00372.Z$0 = isCasting7;
                    c00372.label = 5;
                    C00371 c00373 = c00372;
                    id6 = apiBase7;
                    apiBase8 = id5;
                    function15 = function13;
                    response5 = response4;
                    isCasting8 = isCasting7;
                    obj5 = Requests.get$default(UtilsKt.getApp(), id5 + str + apiBase7, mapBuildNewTvHeaders2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00373, 4092, (Object) null);
                    c00372 = c00373;
                    if (obj5 == obj) {
                        return obj;
                    }
                    userToken3 = userToken2;
                    function12 = function14;
                    data5 = data6;
                    apiBase5 = apiBase8;
                    function11 = function15;
                    objectRef2 = response5;
                    response6 = objectRef2;
                    id7 = id6;
                    NiceResponse this_$iv2 = (NiceResponse) obj5;
                    ResponseParser parser2 = this_$iv2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    objectRef2.element = parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                    response3 = response6;
                    apiBase6 = id7;
                    isCasting6 = isCasting8;
                    userToken = userToken3;
                } else {
                    isCasting6 = isCasting5;
                    apiBase5 = apiBase4;
                    function11 = function10;
                    function12 = function9;
                    data5 = data4;
                    apiBase6 = id4;
                    response3 = response2;
                }
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null || StringsKt.isBlank(video_link)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return Boxing.boxBoolean(false);
                }
                String name = primeVideoMirrorProvider.getName();
                String name2 = primeVideoMirrorProvider.getName();
                String video_link2 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                C00382 c00382 = new C00382(response3, apiBase5, null);
                c00372.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                c00372.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                c00372.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00372.L$3 = SpillingKt.nullOutSpilledVariable(apiBase5);
                c00372.L$4 = SpillingKt.nullOutSpilledVariable(apiBase6);
                c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                c00372.L$6 = SpillingKt.nullOutSpilledVariable(response3);
                c00372.L$7 = function11;
                c00372.Z$0 = isCasting6;
                c00372.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, video_link2, extractorLinkType, c00382, c00372);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function16 = function11;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 1:
                boolean isCasting9 = c00372.Z$0;
                function3 = (Function1) c00372.L$2;
                Function1<? super SubtitleFile, Unit> function17 = (Function1) c00372.L$1;
                String data7 = (String) c00372.L$0;
                ResultKt.throwOnFailure($result);
                isCasting2 = isCasting9;
                function4 = function17;
                data2 = data7;
                objResolveApiUrl = $result;
                apiBase = (String) objResolveApiUrl;
                String text$iv2 = data2;
                id = ((LoadData) UtilsKt.getJSONParser().parse(text$iv2, Reflection.getOrCreateKotlinClass(LoadData.class))).getId();
                c00372.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00372.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                c00372.L$2 = function3;
                c00372.L$3 = apiBase;
                c00372.L$4 = id;
                c00372.Z$0 = isCasting2;
                c00372.label = 2;
                function5 = function3;
                newTvUserToken$default = UtilsKt.getNewTvUserToken$default(apiBase, "pv", false, c00372, 4, null);
                if (newTvUserToken$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiBase2 = apiBase;
                id2 = id;
                isCasting3 = isCasting2;
                function6 = function4;
                function7 = function5;
                String userToken5 = (String) newTvUserToken$default;
                response = new Ref.ObjectRef();
                data3 = data2;
                Map<String, String> mapBuildNewTvHeaders3 = UtilsKt.buildNewTvHeaders("pv", MapsKt.mapOf(TuplesKt.to("Usertoken", userToken5)));
                c00372.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00372.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00372.L$2 = function7;
                c00372.L$3 = apiBase2;
                c00372.L$4 = id2;
                c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken5);
                c00372.L$6 = response;
                c00372.L$7 = response;
                c00372.Z$0 = isCasting3;
                c00372.label = 3;
                apiBase3 = apiBase2;
                function8 = function7;
                isCasting4 = isCasting3;
                userToken = userToken5;
                obj = coroutine_suspended;
                obj2 = "Usertoken";
                str = "/newtv/player.php?id=";
                str2 = "pv";
                id3 = id2;
                obj3 = Requests.get$default(UtilsKt.getApp(), apiBase2 + "/newtv/player.php?id=" + id2, mapBuildNewTvHeaders3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00372, 4092, (Object) null);
                c00372 = c00372;
                if (obj3 == obj) {
                    return obj;
                }
                obj4 = obj3;
                function9 = function6;
                apiBase4 = apiBase3;
                objectRef = response;
                response2 = objectRef;
                id4 = id3;
                isCasting5 = isCasting4;
                function10 = function8;
                data4 = data3;
                NiceResponse this_$iv3 = (NiceResponse) obj4;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                objectRef.element = parser3.parse(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                if (Intrinsics.areEqual(((NewTvPlayerResponse) response2.element).getStatus(), "otp")) {
                    c00372.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00372.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    c00372.L$2 = function10;
                    c00372.L$3 = apiBase4;
                    c00372.L$4 = id4;
                    c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                    c00372.L$6 = response2;
                    c00372.L$7 = null;
                    c00372.Z$0 = isCasting5;
                    c00372.label = 4;
                    str3 = str2;
                    newTvUserToken = UtilsKt.getNewTvUserToken(apiBase4, str3, true, c00372);
                    if (newTvUserToken == obj) {
                        return obj;
                    }
                    data6 = data4;
                    isCasting7 = isCasting5;
                    response4 = response2;
                    apiBase7 = id4;
                    id5 = apiBase4;
                    function13 = function10;
                    function14 = function9;
                    userToken2 = (String) newTvUserToken;
                    Map<String, String> mapBuildNewTvHeaders4 = UtilsKt.buildNewTvHeaders(str3, MapsKt.mapOf(TuplesKt.to(obj2, userToken2)));
                    c00372.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                    c00372.L$1 = SpillingKt.nullOutSpilledVariable(function14);
                    c00372.L$2 = function13;
                    c00372.L$3 = id5;
                    c00372.L$4 = SpillingKt.nullOutSpilledVariable(apiBase7);
                    c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken2);
                    c00372.L$6 = response4;
                    c00372.L$7 = response4;
                    c00372.Z$0 = isCasting7;
                    c00372.label = 5;
                    C00371 c00374 = c00372;
                    id6 = apiBase7;
                    apiBase8 = id5;
                    function15 = function13;
                    response5 = response4;
                    isCasting8 = isCasting7;
                    obj5 = Requests.get$default(UtilsKt.getApp(), id5 + str + apiBase7, mapBuildNewTvHeaders4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00374, 4092, (Object) null);
                    c00372 = c00374;
                    if (obj5 == obj) {
                        return obj;
                    }
                    userToken3 = userToken2;
                    function12 = function14;
                    data5 = data6;
                    apiBase5 = apiBase8;
                    function11 = function15;
                    objectRef2 = response5;
                    response6 = objectRef2;
                    id7 = id6;
                    NiceResponse this_$iv4 = (NiceResponse) obj5;
                    ResponseParser parser4 = this_$iv4.getParser();
                    Intrinsics.checkNotNull(parser4);
                    objectRef2.element = parser4.parse(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                    response3 = response6;
                    apiBase6 = id7;
                    isCasting6 = isCasting8;
                    userToken = userToken3;
                } else {
                    isCasting6 = isCasting5;
                    apiBase5 = apiBase4;
                    function11 = function10;
                    function12 = function9;
                    data5 = data4;
                    apiBase6 = id4;
                    response3 = response2;
                }
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    return Boxing.boxBoolean(false);
                }
                String name3 = primeVideoMirrorProvider.getName();
                String name4 = primeVideoMirrorProvider.getName();
                String video_link3 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                C00382 c00383 = new C00382(response3, apiBase5, null);
                c00372.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                c00372.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                c00372.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00372.L$3 = SpillingKt.nullOutSpilledVariable(apiBase5);
                c00372.L$4 = SpillingKt.nullOutSpilledVariable(apiBase6);
                c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                c00372.L$6 = SpillingKt.nullOutSpilledVariable(response3);
                c00372.L$7 = function11;
                c00372.Z$0 = isCasting6;
                c00372.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name3, name4, video_link3, extractorLinkType2, c00383, c00372);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function16 = function11;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 2:
                boolean isCasting10 = c00372.Z$0;
                String id8 = (String) c00372.L$4;
                String apiBase9 = (String) c00372.L$3;
                Function1<? super ExtractorLink, Unit> function18 = (Function1) c00372.L$2;
                Function1<? super SubtitleFile, Unit> function19 = (Function1) c00372.L$1;
                String data8 = (String) c00372.L$0;
                ResultKt.throwOnFailure($result);
                isCasting3 = isCasting10;
                data2 = data8;
                function7 = function18;
                id2 = id8;
                function6 = function19;
                apiBase2 = apiBase9;
                newTvUserToken$default = $result;
                String userToken6 = (String) newTvUserToken$default;
                response = new Ref.ObjectRef();
                data3 = data2;
                Map<String, String> mapBuildNewTvHeaders5 = UtilsKt.buildNewTvHeaders("pv", MapsKt.mapOf(TuplesKt.to("Usertoken", userToken6)));
                c00372.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00372.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00372.L$2 = function7;
                c00372.L$3 = apiBase2;
                c00372.L$4 = id2;
                c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken6);
                c00372.L$6 = response;
                c00372.L$7 = response;
                c00372.Z$0 = isCasting3;
                c00372.label = 3;
                apiBase3 = apiBase2;
                function8 = function7;
                isCasting4 = isCasting3;
                userToken = userToken6;
                obj = coroutine_suspended;
                obj2 = "Usertoken";
                str = "/newtv/player.php?id=";
                str2 = "pv";
                id3 = id2;
                obj3 = Requests.get$default(UtilsKt.getApp(), apiBase2 + "/newtv/player.php?id=" + id2, mapBuildNewTvHeaders5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00372, 4092, (Object) null);
                c00372 = c00372;
                if (obj3 == obj) {
                    return obj;
                }
                obj4 = obj3;
                function9 = function6;
                apiBase4 = apiBase3;
                objectRef = response;
                response2 = objectRef;
                id4 = id3;
                isCasting5 = isCasting4;
                function10 = function8;
                data4 = data3;
                NiceResponse this_$iv5 = (NiceResponse) obj4;
                ResponseParser parser5 = this_$iv5.getParser();
                Intrinsics.checkNotNull(parser5);
                objectRef.element = parser5.parse(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                if (Intrinsics.areEqual(((NewTvPlayerResponse) response2.element).getStatus(), "otp")) {
                    c00372.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00372.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    c00372.L$2 = function10;
                    c00372.L$3 = apiBase4;
                    c00372.L$4 = id4;
                    c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                    c00372.L$6 = response2;
                    c00372.L$7 = null;
                    c00372.Z$0 = isCasting5;
                    c00372.label = 4;
                    str3 = str2;
                    newTvUserToken = UtilsKt.getNewTvUserToken(apiBase4, str3, true, c00372);
                    if (newTvUserToken == obj) {
                        return obj;
                    }
                    data6 = data4;
                    isCasting7 = isCasting5;
                    response4 = response2;
                    apiBase7 = id4;
                    id5 = apiBase4;
                    function13 = function10;
                    function14 = function9;
                    userToken2 = (String) newTvUserToken;
                    Map<String, String> mapBuildNewTvHeaders6 = UtilsKt.buildNewTvHeaders(str3, MapsKt.mapOf(TuplesKt.to(obj2, userToken2)));
                    c00372.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                    c00372.L$1 = SpillingKt.nullOutSpilledVariable(function14);
                    c00372.L$2 = function13;
                    c00372.L$3 = id5;
                    c00372.L$4 = SpillingKt.nullOutSpilledVariable(apiBase7);
                    c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken2);
                    c00372.L$6 = response4;
                    c00372.L$7 = response4;
                    c00372.Z$0 = isCasting7;
                    c00372.label = 5;
                    C00371 c00375 = c00372;
                    id6 = apiBase7;
                    apiBase8 = id5;
                    function15 = function13;
                    response5 = response4;
                    isCasting8 = isCasting7;
                    obj5 = Requests.get$default(UtilsKt.getApp(), id5 + str + apiBase7, mapBuildNewTvHeaders6, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00375, 4092, (Object) null);
                    c00372 = c00375;
                    if (obj5 == obj) {
                        return obj;
                    }
                    userToken3 = userToken2;
                    function12 = function14;
                    data5 = data6;
                    apiBase5 = apiBase8;
                    function11 = function15;
                    objectRef2 = response5;
                    response6 = objectRef2;
                    id7 = id6;
                    NiceResponse this_$iv6 = (NiceResponse) obj5;
                    ResponseParser parser6 = this_$iv6.getParser();
                    Intrinsics.checkNotNull(parser6);
                    objectRef2.element = parser6.parse(this_$iv6.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                    response3 = response6;
                    apiBase6 = id7;
                    isCasting6 = isCasting8;
                    userToken = userToken3;
                } else {
                    isCasting6 = isCasting5;
                    apiBase5 = apiBase4;
                    function11 = function10;
                    function12 = function9;
                    data5 = data4;
                    apiBase6 = id4;
                    response3 = response2;
                }
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    return Boxing.boxBoolean(false);
                }
                String name5 = primeVideoMirrorProvider.getName();
                String name6 = primeVideoMirrorProvider.getName();
                String video_link4 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType3 = ExtractorLinkType.M3U8;
                C00382 c00384 = new C00382(response3, apiBase5, null);
                c00372.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                c00372.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                c00372.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00372.L$3 = SpillingKt.nullOutSpilledVariable(apiBase5);
                c00372.L$4 = SpillingKt.nullOutSpilledVariable(apiBase6);
                c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                c00372.L$6 = SpillingKt.nullOutSpilledVariable(response3);
                c00372.L$7 = function11;
                c00372.Z$0 = isCasting6;
                c00372.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name5, name6, video_link4, extractorLinkType3, c00384, c00372);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function16 = function11;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 3:
                boolean isCasting11 = c00372.Z$0;
                Ref.ObjectRef objectRef3 = (Ref.ObjectRef) c00372.L$7;
                Ref.ObjectRef response7 = (Ref.ObjectRef) c00372.L$6;
                String userToken7 = (String) c00372.L$5;
                String id9 = (String) c00372.L$4;
                apiBase4 = (String) c00372.L$3;
                function10 = (Function1) c00372.L$2;
                function9 = (Function1) c00372.L$1;
                String data9 = (String) c00372.L$0;
                ResultKt.throwOnFailure($result);
                data4 = data9;
                obj = coroutine_suspended;
                id4 = id9;
                response2 = response7;
                isCasting5 = isCasting11;
                userToken = userToken7;
                obj2 = "Usertoken";
                str = "/newtv/player.php?id=";
                str2 = "pv";
                objectRef = objectRef3;
                obj4 = $result;
                NiceResponse this_$iv7 = (NiceResponse) obj4;
                ResponseParser parser7 = this_$iv7.getParser();
                Intrinsics.checkNotNull(parser7);
                objectRef.element = parser7.parse(this_$iv7.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                if (Intrinsics.areEqual(((NewTvPlayerResponse) response2.element).getStatus(), "otp")) {
                    c00372.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00372.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    c00372.L$2 = function10;
                    c00372.L$3 = apiBase4;
                    c00372.L$4 = id4;
                    c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                    c00372.L$6 = response2;
                    c00372.L$7 = null;
                    c00372.Z$0 = isCasting5;
                    c00372.label = 4;
                    str3 = str2;
                    newTvUserToken = UtilsKt.getNewTvUserToken(apiBase4, str3, true, c00372);
                    if (newTvUserToken == obj) {
                        return obj;
                    }
                    data6 = data4;
                    isCasting7 = isCasting5;
                    response4 = response2;
                    apiBase7 = id4;
                    id5 = apiBase4;
                    function13 = function10;
                    function14 = function9;
                    userToken2 = (String) newTvUserToken;
                    Map<String, String> mapBuildNewTvHeaders7 = UtilsKt.buildNewTvHeaders(str3, MapsKt.mapOf(TuplesKt.to(obj2, userToken2)));
                    c00372.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                    c00372.L$1 = SpillingKt.nullOutSpilledVariable(function14);
                    c00372.L$2 = function13;
                    c00372.L$3 = id5;
                    c00372.L$4 = SpillingKt.nullOutSpilledVariable(apiBase7);
                    c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken2);
                    c00372.L$6 = response4;
                    c00372.L$7 = response4;
                    c00372.Z$0 = isCasting7;
                    c00372.label = 5;
                    C00371 c00376 = c00372;
                    id6 = apiBase7;
                    apiBase8 = id5;
                    function15 = function13;
                    response5 = response4;
                    isCasting8 = isCasting7;
                    obj5 = Requests.get$default(UtilsKt.getApp(), id5 + str + apiBase7, mapBuildNewTvHeaders7, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00376, 4092, (Object) null);
                    c00372 = c00376;
                    if (obj5 == obj) {
                        return obj;
                    }
                    userToken3 = userToken2;
                    function12 = function14;
                    data5 = data6;
                    apiBase5 = apiBase8;
                    function11 = function15;
                    objectRef2 = response5;
                    response6 = objectRef2;
                    id7 = id6;
                    NiceResponse this_$iv8 = (NiceResponse) obj5;
                    ResponseParser parser8 = this_$iv8.getParser();
                    Intrinsics.checkNotNull(parser8);
                    objectRef2.element = parser8.parse(this_$iv8.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                    response3 = response6;
                    apiBase6 = id7;
                    isCasting6 = isCasting8;
                    userToken = userToken3;
                } else {
                    isCasting6 = isCasting5;
                    apiBase5 = apiBase4;
                    function11 = function10;
                    function12 = function9;
                    data5 = data4;
                    apiBase6 = id4;
                    response3 = response2;
                }
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    return Boxing.boxBoolean(false);
                }
                String name7 = primeVideoMirrorProvider.getName();
                String name8 = primeVideoMirrorProvider.getName();
                String video_link5 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType4 = ExtractorLinkType.M3U8;
                C00382 c00385 = new C00382(response3, apiBase5, null);
                c00372.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                c00372.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                c00372.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00372.L$3 = SpillingKt.nullOutSpilledVariable(apiBase5);
                c00372.L$4 = SpillingKt.nullOutSpilledVariable(apiBase6);
                c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                c00372.L$6 = SpillingKt.nullOutSpilledVariable(response3);
                c00372.L$7 = function11;
                c00372.Z$0 = isCasting6;
                c00372.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name7, name8, video_link5, extractorLinkType4, c00385, c00372);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function16 = function11;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 4:
                isCasting7 = c00372.Z$0;
                response4 = (Ref.ObjectRef) c00372.L$6;
                String id10 = (String) c00372.L$4;
                String apiBase10 = (String) c00372.L$3;
                Function1<? super ExtractorLink, Unit> function20 = (Function1) c00372.L$2;
                Function1<? super SubtitleFile, Unit> function21 = (Function1) c00372.L$1;
                String data10 = (String) c00372.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                function14 = function21;
                obj2 = "Usertoken";
                str = "/newtv/player.php?id=";
                data6 = data10;
                function13 = function20;
                id5 = apiBase10;
                str3 = "pv";
                apiBase7 = id10;
                newTvUserToken = $result;
                userToken2 = (String) newTvUserToken;
                Map<String, String> mapBuildNewTvHeaders8 = UtilsKt.buildNewTvHeaders(str3, MapsKt.mapOf(TuplesKt.to(obj2, userToken2)));
                c00372.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                c00372.L$1 = SpillingKt.nullOutSpilledVariable(function14);
                c00372.L$2 = function13;
                c00372.L$3 = id5;
                c00372.L$4 = SpillingKt.nullOutSpilledVariable(apiBase7);
                c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken2);
                c00372.L$6 = response4;
                c00372.L$7 = response4;
                c00372.Z$0 = isCasting7;
                c00372.label = 5;
                C00371 c00377 = c00372;
                id6 = apiBase7;
                apiBase8 = id5;
                function15 = function13;
                response5 = response4;
                isCasting8 = isCasting7;
                obj5 = Requests.get$default(UtilsKt.getApp(), id5 + str + apiBase7, mapBuildNewTvHeaders8, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00377, 4092, (Object) null);
                c00372 = c00377;
                if (obj5 == obj) {
                    return obj;
                }
                userToken3 = userToken2;
                function12 = function14;
                data5 = data6;
                apiBase5 = apiBase8;
                function11 = function15;
                objectRef2 = response5;
                response6 = objectRef2;
                id7 = id6;
                NiceResponse this_$iv9 = (NiceResponse) obj5;
                ResponseParser parser9 = this_$iv9.getParser();
                Intrinsics.checkNotNull(parser9);
                objectRef2.element = parser9.parse(this_$iv9.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                response3 = response6;
                apiBase6 = id7;
                isCasting6 = isCasting8;
                userToken = userToken3;
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    return Boxing.boxBoolean(false);
                }
                String name9 = primeVideoMirrorProvider.getName();
                String name10 = primeVideoMirrorProvider.getName();
                String video_link6 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType5 = ExtractorLinkType.M3U8;
                C00382 c00386 = new C00382(response3, apiBase5, null);
                c00372.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                c00372.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                c00372.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00372.L$3 = SpillingKt.nullOutSpilledVariable(apiBase5);
                c00372.L$4 = SpillingKt.nullOutSpilledVariable(apiBase6);
                c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                c00372.L$6 = SpillingKt.nullOutSpilledVariable(response3);
                c00372.L$7 = function11;
                c00372.Z$0 = isCasting6;
                c00372.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name9, name10, video_link6, extractorLinkType5, c00386, c00372);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function16 = function11;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 5:
                boolean isCasting12 = c00372.Z$0;
                objectRef2 = (Ref.ObjectRef) c00372.L$7;
                response6 = (Ref.ObjectRef) c00372.L$6;
                userToken3 = (String) c00372.L$5;
                id7 = (String) c00372.L$4;
                apiBase5 = (String) c00372.L$3;
                function11 = (Function1) c00372.L$2;
                function12 = (Function1) c00372.L$1;
                data5 = (String) c00372.L$0;
                ResultKt.throwOnFailure($result);
                isCasting8 = isCasting12;
                obj = coroutine_suspended;
                obj5 = $result;
                NiceResponse this_$iv10 = (NiceResponse) obj5;
                ResponseParser parser10 = this_$iv10.getParser();
                Intrinsics.checkNotNull(parser10);
                objectRef2.element = parser10.parse(this_$iv10.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                response3 = response6;
                apiBase6 = id7;
                isCasting6 = isCasting8;
                userToken = userToken3;
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    return Boxing.boxBoolean(false);
                }
                String name11 = primeVideoMirrorProvider.getName();
                String name12 = primeVideoMirrorProvider.getName();
                String video_link7 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType6 = ExtractorLinkType.M3U8;
                C00382 c00387 = new C00382(response3, apiBase5, null);
                c00372.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                c00372.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                c00372.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00372.L$3 = SpillingKt.nullOutSpilledVariable(apiBase5);
                c00372.L$4 = SpillingKt.nullOutSpilledVariable(apiBase6);
                c00372.L$5 = SpillingKt.nullOutSpilledVariable(userToken);
                c00372.L$6 = SpillingKt.nullOutSpilledVariable(response3);
                c00372.L$7 = function11;
                c00372.Z$0 = isCasting6;
                c00372.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name11, name12, video_link7, extractorLinkType6, c00387, c00372);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function16 = function11;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 6:
                boolean z2 = c00372.Z$0;
                function16 = (Function1) c00372.L$7;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.PrimeVideoMirrorProvider$loadLinks$2 */
    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.PrimeVideoMirrorProvider$loadLinks$2", f = "PrimeVideoMirrorProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00382 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $apiBase;
        final /* synthetic */ Ref.ObjectRef<NewTvPlayerResponse> $response;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00382(Ref.ObjectRef<NewTvPlayerResponse> objectRef, String str, Continuation<? super C00382> continuation) {
            super(2, continuation);
            this.$response = objectRef;
            this.$apiBase = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00382 = new C00382(this.$response, this.$apiBase, continuation);
            c00382.L$0 = obj;
            return c00382;
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
                    String referer = ((NewTvPlayerResponse) this.$response.element).getReferer();
                    if (referer == null) {
                        referer = this.$apiBase;
                    }
                    $this$newExtractorLink.setReferer(referer);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Nullable
    public Interceptor getVideoInterceptor(@NotNull ExtractorLink extractorLink) {
        return new Interceptor() { // from class: com.horis.cncverse.PrimeVideoMirrorProvider.getVideoInterceptor.1
            public Response intercept(Interceptor.Chain chain) {
                Request request = chain.request();
                if (StringsKt.contains$default(request.url().toString(), ".m3u8", false, 2, (Object) null)) {
                    Request newRequest = request.newBuilder().header("Cookie", "hd=on").build();
                    return chain.proceed(newRequest);
                }
                return chain.proceed(request);
            }
        };
    }

    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/horis/cncverse/PrimeVideoMirrorProvider$Id;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Id {

        @NotNull
        private final String id;

        public static /* synthetic */ Id copy$default(Id id, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = id.id;
            }
            return id.copy(str);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final Id copy(@NotNull String id) {
            return new Id(id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Id) && Intrinsics.areEqual(this.id, ((Id) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        @NotNull
        public String toString() {
            return "Id(id=" + this.id + ')';
        }

        public Id(@NotNull String id) {
            this.id = id;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }
    }

    /* JADX INFO: compiled from: PrimeVideoMirrorProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/horis/cncverse/PrimeVideoMirrorProvider$LoadData;", "", "title", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class LoadData {

        @NotNull
        private final String id;

        @NotNull
        private final String title;

        public static /* synthetic */ LoadData copy$default(LoadData loadData, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadData.title;
            }
            if ((i & 2) != 0) {
                str2 = loadData.id;
            }
            return loadData.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final LoadData copy(@NotNull String title, @NotNull String id) {
            return new LoadData(title, id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadData)) {
                return false;
            }
            LoadData loadData = (LoadData) other;
            return Intrinsics.areEqual(this.title, loadData.title) && Intrinsics.areEqual(this.id, loadData.id);
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.id.hashCode();
        }

        @NotNull
        public String toString() {
            return "LoadData(title=" + this.title + ", id=" + this.id + ')';
        }

        public LoadData(@NotNull String title, @NotNull String id) {
            this.title = title;
            this.id = id;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }
    }
}
