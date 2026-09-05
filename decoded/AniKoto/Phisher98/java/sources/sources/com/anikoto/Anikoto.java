package com.anikoto;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: AnikotoProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniKoto/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001f2\u0006\u0010!\u001a\u00020\u0005H\u0002J\u001e\u0010\u001c\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u001a2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+JF\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00112\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0096@¢\u0006\u0002\u00108JN\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0082@¢\u0006\u0002\u0010<JV\u0010=\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00052\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0082@¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010\u00052\u0006\u0010B\u001a\u00020\u0005H\u0002J\u000e\u0010D\u001a\u0004\u0018\u00010E*\u00020FH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/anikoto/Anikoto;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "browserHeaders", "", "ajaxHeaders", "referer", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveServers", "serverIds", "audioType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveEmbed", "serverName", "serverType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "jsonResultString", "json", "jsonResultUrl", "toSearchResult", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "Lorg/jsoup/nodes/Element;", "ServerEntry", "AniKoto"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnikotoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnikotoProvider.kt\ncom/anikoto/Anikoto\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,355:1\n1795#2,10:356\n2068#2:366\n2069#2:368\n1805#2:369\n1795#2,10:370\n2068#2:380\n2069#2:382\n1805#2:383\n1739#2:385\n1814#2,3:386\n2068#2,2:389\n2077#2,3:391\n296#2,2:394\n1544#2:396\n1633#2,2:397\n1739#2:399\n1814#2,3:400\n1635#2,3:403\n1739#2:406\n1814#2,3:407\n777#2:410\n873#2,2:411\n1#3:367\n1#3:381\n1#3:384\n*S KotlinDebug\n*F\n+ 1 AnikotoProvider.kt\ncom/anikoto/Anikoto\n*L\n41#1:356,10\n41#1:366\n41#1:368\n41#1:369\n50#1:370,10\n50#1:380\n50#1:382\n50#1:383\n64#1:385\n64#1:386,3\n99#1:389,2\n144#1:391,3\n153#1:394,2\n239#1:396\n239#1:397,2\n241#1:399\n241#1:400,3\n239#1:403,3\n249#1:406\n249#1:407,3\n252#1:410\n252#1:411,2\n41#1:367\n50#1:381\n*E\n"})
public final class Anikoto extends MainAPI {

    @NotNull
    private String mainUrl = "https://anikototv.to";

    @NotNull
    private String name = "AniKoto";

    @NotNull
    private String lang = "en";
    private final boolean hasMainPage = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/latest-updated", "Latest Updated"), TuplesKt.to(getMainUrl() + "/most-viewed", "Most Popular"), TuplesKt.to(getMainUrl() + "/status/currently-airing", "Ongoing"), TuplesKt.to(getMainUrl() + "/type/movie", "Movies")});

    @NotNull
    private final Map<String, String> browserHeaders = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/149.0.0.0 Safari/537.36"), TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"), TuplesKt.to("Accept-Language", "en-US,en;q=0.5")});

    /* JADX INFO: renamed from: com.anikoto.Anikoto$getMainPage$1 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.Anikoto", f = "AnikotoProvider.kt", i = {0, 0}, l = {40}, m = "getMainPage", n = {"request", "page"}, nl = {41}, s = {"L$0", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Anikoto.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anikoto.Anikoto$load$1 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.Anikoto", f = "AnikotoProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {54, 81, 95, 159}, m = "load", n = {"url", "url", "doc", "title", "poster", "description", "genres", "animeId", "subEpisodes", "dubEpisodes", "malId", "animeMetaData", "$this$load_u24lambda_u242", "isMovie", "url", "doc", "title", "poster", "description", "genres", "animeId", "subEpisodes", "dubEpisodes", "malId", "animeMetaData", "episodeListHtml", "epDoc", "$this$load_u24lambda_u244", "isMovie", "url", "doc", "title", "poster", "description", "genres", "animeId", "subEpisodes", "dubEpisodes", "malId", "animeMetaData", "backgroundPoster", "tvType", "isMovie"}, nl = {56, 84, 94, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
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

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Anikoto.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anikoto.Anikoto$loadLinks$1 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.Anikoto", f = "AnikotoProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {187, 191, 199, 209}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "cleanData", "parts", "referer", "serverIds", "audioType", "isCasting", "data", "subtitleCallback", "callback", "cleanData", "$this$loadLinks_u24lambda_u243", "isCasting", "data", "subtitleCallback", "callback", "cleanData", "$this$loadLinks_u24lambda_u243", "doc", "animeId", "isCasting", "epNum", "data", "subtitleCallback", "callback", "cleanData", "$this$loadLinks_u24lambda_u243", "doc", "html", "serverIds", "epEl", "audioType", "animeId", "isCasting", "epNum"}, nl = {190, 192, 198, 190}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "I$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int I$0;
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

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Anikoto.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anikoto.Anikoto$resolveEmbed$1 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.Anikoto", f = "AnikotoProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {293, 309, 314}, m = "resolveEmbed", n = {"url", "referer", "serverName", "serverType", "subtitleCallback", "callback", "normalizedUrl", "typeLabel", "m3u8", "url", "referer", "serverName", "serverType", "subtitleCallback", "callback", "normalizedUrl", "typeLabel", "domain", "host", "label", "$this$resolveEmbed_u24lambda_u241", "isMegaPlayDomain", "url", "referer", "serverName", "serverType", "subtitleCallback", "callback", "normalizedUrl", "typeLabel", "domain", "$this$resolveEmbed_u24lambda_u243", "isMegaPlayDomain"}, nl = {297, 310, 313}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
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

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Anikoto.this.resolveEmbed(null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anikoto.Anikoto$resolveServers$1 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.Anikoto", f = "AnikotoProvider.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {224, 257}, m = "resolveServers", n = {"serverIds", "referer", "audioType", "subtitleCallback", "callback", "$this$resolveServers_u24lambda_u240", "serverIds", "referer", "audioType", "subtitleCallback", "callback", "serverListHtml", "serverDoc", "typeSelectors", "entries", "found"}, nl = {227, 273}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
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

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Anikoto.this.resolveServers(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anikoto.Anikoto$search$1 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.Anikoto", f = "AnikotoProvider.kt", i = {0}, l = {46}, m = "search", n = {"query"}, nl = {49}, s = {"L$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Anikoto.this.search(null, (Continuation) this);
        }
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

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> ajaxHeaders(String referer) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/149.0.0.0 Safari/537.36"), TuplesKt.to("X-Requested-With", "XMLHttpRequest"), TuplesKt.to("Accept", "application/json, text/javascript, */*; q=0.01"), TuplesKt.to("Referer", referer)});
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        MainPageRequest request2;
        int page2 = page;
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
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = request.getData() + "?page=" + page2;
                Map<String, String> map = this.browserHeaders;
                c00001.L$0 = request;
                c00001.I$0 = page2;
                c00001.label = 1;
                $result = Requests.get$default(app, str, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4092, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = doc.select("div.ani.items > div.item");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            int page3 = page2;
            Element it = (Element) element$iv$iv$iv;
            AnimeSearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
            page2 = page3;
        }
        List items = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse$default(request2.getName(), items, (Boolean) null, 4, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00071 c00071;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = new C00071(continuation);
            }
        } else {
            c00071 = new C00071(continuation);
        }
        Object $result = c00071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00071.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/filter?keyword=" + query;
                Map<String, String> map = this.browserHeaders;
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00071.label = 1;
                $result = Requests.get$default(app, str, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00071, 4092, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = doc.select("div.ani.items > div.item");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            AnimeSearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x036f  */
    /* JADX WARN: Code duplicated, block: B:124:0x047d  */
    /* JADX WARN: Code duplicated, block: B:127:0x048e  */
    /* JADX WARN: Code duplicated, block: B:129:0x049c  */
    /* JADX WARN: Code duplicated, block: B:132:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:140:0x054b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:141:0x054c  */
    /* JADX WARN: Code duplicated, block: B:153:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:155:0x05c5  */
    /* JADX WARN: Code duplicated, block: B:159:0x05e9  */
    /* JADX WARN: Code duplicated, block: B:162:0x060b  */
    /* JADX WARN: Code duplicated, block: B:164:0x060e  */
    /* JADX WARN: Code duplicated, block: B:165:0x0616  */
    /* JADX WARN: Code duplicated, block: B:167:0x063e  */
    /* JADX WARN: Code duplicated, block: B:169:0x0650  */
    /* JADX WARN: Code duplicated, block: B:172:0x0663  */
    /* JADX WARN: Code duplicated, block: B:173:0x0667  */
    /* JADX WARN: Code duplicated, block: B:175:0x066c  */
    /* JADX WARN: Code duplicated, block: B:181:0x0685  */
    /* JADX WARN: Code duplicated, block: B:183:0x0689  */
    /* JADX WARN: Code duplicated, block: B:186:0x0698  */
    /* JADX WARN: Code duplicated, block: B:188:0x069b  */
    /* JADX WARN: Code duplicated, block: B:189:0x069d  */
    /* JADX WARN: Code duplicated, block: B:192:0x06ac  */
    /* JADX WARN: Code duplicated, block: B:194:0x06af  */
    /* JADX WARN: Code duplicated, block: B:196:0x06b7  */
    /* JADX WARN: Code duplicated, block: B:204:0x06d6  */
    /* JADX WARN: Code duplicated, block: B:206:0x06d9  */
    /* JADX WARN: Code duplicated, block: B:208:0x06df  */
    /* JADX WARN: Code duplicated, block: B:210:0x06e9  */
    /* JADX WARN: Code duplicated, block: B:216:0x0702  */
    /* JADX WARN: Code duplicated, block: B:219:0x0707  */
    /* JADX WARN: Code duplicated, block: B:221:0x070d  */
    /* JADX WARN: Code duplicated, block: B:229:0x072e  */
    /* JADX WARN: Code duplicated, block: B:231:0x0731  */
    /* JADX WARN: Code duplicated, block: B:233:0x073e  */
    /* JADX WARN: Code duplicated, block: B:234:0x0741  */
    /* JADX WARN: Code duplicated, block: B:236:0x074e  */
    /* JADX WARN: Code duplicated, block: B:238:0x0753 A[PHI: r3
      0x0753: PHI (r3v26 java.lang.String) = (r3v25 java.lang.String), (r3v29 java.lang.String) binds: [B:187:0x0699, B:193:0x06ad] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:242:0x075a  */
    /* JADX WARN: Code duplicated, block: B:243:0x0761  */
    /* JADX WARN: Code duplicated, block: B:245:0x0765  */
    /* JADX WARN: Code duplicated, block: B:246:0x076c  */
    /* JADX WARN: Code duplicated, block: B:248:0x0770  */
    /* JADX WARN: Code duplicated, block: B:251:0x0780  */
    /* JADX WARN: Code duplicated, block: B:253:0x0784  */
    /* JADX WARN: Code duplicated, block: B:254:0x078b  */
    /* JADX WARN: Code duplicated, block: B:256:0x078f  */
    /* JADX WARN: Code duplicated, block: B:257:0x0796  */
    /* JADX WARN: Code duplicated, block: B:260:0x079c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:263:0x07a2  */
    /* JADX WARN: Code duplicated, block: B:265:0x07d9  */
    /* JADX WARN: Code duplicated, block: B:269:0x0830  */
    /* JADX WARN: Code duplicated, block: B:270:0x0848  */
    /* JADX WARN: Code duplicated, block: B:273:0x086e  */
    /* JADX WARN: Code duplicated, block: B:283:0x08d2  */
    /* JADX WARN: Code duplicated, block: B:286:0x08de  */
    /* JADX WARN: Code duplicated, block: B:299:0x091b  */
    /* JADX WARN: Code duplicated, block: B:302:0x091f  */
    /* JADX WARN: Code duplicated, block: B:305:0x092c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:310:0x09c4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:311:0x09c5  */
    /* JADX WARN: Code duplicated, block: B:333:0x02cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:335:0x04b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:344:0x080d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x019c  */
    /* JADX WARN: Code duplicated, block: B:36:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:41:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:44:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:45:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:49:0x0206 A[LOOP:3: B:47:0x0200->B:49:0x0206, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x0235  */
    /* JADX WARN: Code duplicated, block: B:59:0x0252  */
    /* JADX WARN: Code duplicated, block: B:62:0x0256  */
    /* JADX WARN: Code duplicated, block: B:63:0x0258  */
    /* JADX WARN: Code duplicated, block: B:70:0x0270  */
    /* JADX WARN: Code duplicated, block: B:72:0x0278  */
    /* JADX WARN: Code duplicated, block: B:73:0x027d  */
    /* JADX WARN: Code duplicated, block: B:75:0x0280  */
    /* JADX WARN: Code duplicated, block: B:77:0x0297  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:81:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:99:0x036e A[RETURN] */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        String url2;
        Document doc;
        Element elementSelectFirst;
        Element elementSelectFirst2;
        String strText;
        String string;
        String title;
        Elements it;
        String strAttr;
        String poster;
        Element elementSelectFirst3;
        String strText2;
        String description;
        Iterable $this$map$iv;
        Collection destination$iv$iv;
        List genres;
        int i;
        int i2;
        Element elementSelectFirst4;
        Element elementSelectFirst5;
        String strAttr2;
        MatchResult matchResultFind$default;
        List groupValues;
        String animeId;
        List subEpisodes;
        List dubEpisodes;
        Ref.ObjectRef malId;
        Ref.ObjectRef animeMetaData;
        Object obj2;
        List dubEpisodes2;
        C00011 c00012;
        List subEpisodes2;
        Ref.ObjectRef malId2;
        Document doc2;
        String title2;
        String description2;
        String poster2;
        String url3;
        List genres2;
        String url4;
        int i3;
        Ref.ObjectRef animeMetaData2;
        Anikoto $this$load_u24lambda_u242;
        Ref.ObjectRef malId3;
        Object obj3;
        Anikoto anikoto;
        Object obj4;
        int i4;
        String title3;
        Ref.ObjectRef animeMetaData3;
        String description3;
        String url5;
        List dubEpisodes3;
        List subEpisodes3;
        Ref.ObjectRef malId4;
        Document doc3;
        String url6;
        List subEpisodes4;
        String animeId2;
        Element elementSelectFirst6;
        boolean z;
        String strText3;
        String strText4;
        Object obj5;
        int i5;
        List subEpisodes5;
        String animeId3;
        List genres3;
        String description4;
        String poster3;
        String title4;
        String url7;
        List dubEpisodes4;
        String episodeListHtml;
        Document epDoc;
        Element elementSelectFirst7;
        Integer intOrNull;
        Ref.ObjectRef malId5;
        List genres4;
        String description5;
        Ref.ObjectRef animeMetaData4;
        String title5;
        String animeId4;
        Document doc4;
        String url8;
        String poster4;
        String title6;
        Document doc5;
        String url9;
        String poster5;
        C00011 c00013;
        Object obj6;
        List genres5;
        int i6;
        String url10;
        String description6;
        String strAttr3;
        Object obj7;
        String poster6;
        String description7;
        MetaAnimeData metaAnimeData;
        String backgroundPoster;
        TvType tvType;
        Object obj8;
        Object objNewAnimeLoadResponse$default;
        Iterable images;
        Object element$iv;
        Iterable $this$forEach$iv;
        int $i$f$forEach;
        Element el;
        String serverIds;
        Object obj9;
        final Integer episodeNum;
        Iterable $this$forEach$iv2;
        boolean hasSub;
        boolean hasDub;
        boolean hasDub2;
        MetaEpisode meta;
        MetaEpisode meta2;
        String str;
        int $i$f$forEach2;
        final String episodeName;
        Element elementSelectFirst8;
        String str2;
        Element elementParent;
        Element elementSelectFirst9;
        Object obj10;
        String strAttr4;
        String string2;
        String strAttr5;
        String string3;
        String strText5;
        String string4;
        Map<String, String> title7;
        Map<String, String> title8;
        final String epThumb;
        final String epDesc;
        final Score epRating;
        final Integer epRuntime;
        final String epAirDate;
        String it2;
        Map<String, String> title9;
        MetaAnimeData metaAnimeData2;
        Map<String, MetaEpisode> episodes;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = new C00011(continuation);
            }
        } else {
            c00011 = new C00011(continuation);
        }
        C00011 c00014 = c00011;
        Object $result = c00014.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00014.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                Map<String, String> map = this.browserHeaders;
                c00014.L$0 = url;
                c00014.label = 1;
                obj = Requests.get$default(app, url, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00014, 4092, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url2 = url;
                doc = ((NiceResponse) obj).getDocument();
                elementSelectFirst = doc.selectFirst("#w-info h1.title, h1[itemprop=name], .title[itemprop=name]");
                if (elementSelectFirst != null || (strText4 = elementSelectFirst.text()) == null || (string = StringsKt.trim(strText4).toString()) == null) {
                    elementSelectFirst2 = doc.selectFirst("h1.title");
                    if (elementSelectFirst2 != null || (strText = elementSelectFirst2.text()) == null) {
                        return null;
                    }
                    string = StringsKt.trim(strText).toString();
                }
                title = string;
                it = doc.select("#w-info .poster img, img[itemprop=image], .poster img");
                strAttr = it.attr("data-src");
                if (StringsKt.isBlank(strAttr)) {
                    strAttr = it.attr("src");
                }
                poster = strAttr;
                elementSelectFirst3 = doc.selectFirst("#w-info .synopsis .content, #w-info .synopsis, .synopsis .content");
                if (elementSelectFirst3 != null) {
                    strText2 = elementSelectFirst3.text();
                } else {
                    strText2 = null;
                }
                description = strText2;
                $this$map$iv = doc.select("#w-info a[href*='/genre/'], .meta a[href*='/genre/']");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    destination$iv$iv.add(StringsKt.trim(((Element) item$iv$iv).text()).toString());
                    $this$map$iv = $this$map$iv;
                }
                genres = (List) destination$iv$iv;
                if (doc.selectFirst("#w-info a[href*='/type/movie']") != null) {
                    i = 1;
                } else {
                    elementSelectFirst6 = doc.selectFirst(".bmeta");
                    if (elementSelectFirst6 == null && (strText3 = elementSelectFirst6.text()) != null && StringsKt.contains(strText3, "Movie", true)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                }
                i2 = i;
                elementSelectFirst4 = doc.selectFirst("#watch-main");
                if (elementSelectFirst4 != null || (strAttr2 = elementSelectFirst4.attr("data-id")) == null) {
                    elementSelectFirst5 = doc.selectFirst("[data-id]");
                    if (elementSelectFirst5 != null) {
                        strAttr2 = elementSelectFirst5.attr("data-id");
                    } else {
                        strAttr2 = null;
                    }
                    if (strAttr2 == null) {
                        matchResultFind$default = Regex.find$default(new Regex("data-id=[\"'](\\d+)[\"']"), doc.html(), 0, 2, (Object) null);
                        if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
                            strAttr2 = null;
                        } else {
                            strAttr2 = (String) groupValues.get(1);
                        }
                    }
                }
                animeId = strAttr2;
                subEpisodes = new ArrayList();
                dubEpisodes = new ArrayList();
                malId = new Ref.ObjectRef();
                animeMetaData = new Ref.ObjectRef();
                if (animeId != null) {
                    try {
                        Result.Companion companion = Result.Companion;
                        $this$load_u24lambda_u242 = this;
                        Requests app2 = MainActivityKt.getApp();
                        obj2 = "";
                        try {
                            String str3 = $this$load_u24lambda_u242.getMainUrl() + "/ajax/episode/list/" + animeId;
                            Map<String, String> mapAjaxHeaders = $this$load_u24lambda_u242.ajaxHeaders(url2);
                            c00014.L$0 = url2;
                            c00014.L$1 = doc;
                            c00014.L$2 = title;
                            c00014.L$3 = poster;
                            c00014.L$4 = description;
                            c00014.L$5 = genres;
                            try {
                                c00014.L$6 = SpillingKt.nullOutSpilledVariable(animeId);
                                c00014.L$7 = subEpisodes;
                                c00014.L$8 = dubEpisodes;
                                malId3 = malId;
                                try {
                                    c00014.L$9 = malId3;
                                    try {
                                        c00014.L$10 = animeMetaData;
                                        dubEpisodes2 = dubEpisodes;
                                        try {
                                            c00014.L$11 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u242);
                                            c00014.L$12 = $this$load_u24lambda_u242;
                                            c00014.I$0 = i2;
                                            c00014.label = 2;
                                            try {
                                                obj3 = Requests.get$default(app2, str3, mapAjaxHeaders, url2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00014, 4088, (Object) null);
                                                c00012 = c00014;
                                                if (obj3 == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                subEpisodes2 = subEpisodes;
                                                doc2 = doc;
                                                title2 = title;
                                                description2 = description;
                                                poster2 = poster;
                                                url3 = url2;
                                                genres2 = genres;
                                                url4 = animeId;
                                                anikoto = $this$load_u24lambda_u242;
                                                i3 = i2;
                                                animeMetaData2 = animeMetaData;
                                                try {
                                                    obj5 = Result.constructor-impl(anikoto.jsonResultString(((NiceResponse) obj3).getText()));
                                                    i5 = i3;
                                                    subEpisodes5 = subEpisodes2;
                                                    animeId3 = url4;
                                                    genres3 = genres2;
                                                    description4 = description2;
                                                    poster3 = poster2;
                                                    title4 = title2;
                                                    doc3 = doc2;
                                                    url7 = url3;
                                                    dubEpisodes4 = dubEpisodes2;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    malId2 = malId3;
                                                    Result.Companion companion2 = Result.Companion;
                                                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                    malId3 = malId2;
                                                    i5 = i3;
                                                    subEpisodes5 = subEpisodes2;
                                                    animeId3 = url4;
                                                    genres3 = genres2;
                                                    description4 = description2;
                                                    poster3 = poster2;
                                                    title4 = title2;
                                                    doc3 = doc2;
                                                    url7 = url3;
                                                    dubEpisodes4 = dubEpisodes2;
                                                }
                                                if (Result.exceptionOrNull-impl(obj5) != null) {
                                                    obj5 = obj2;
                                                }
                                                episodeListHtml = (String) obj5;
                                                if (StringsKt.isBlank(episodeListHtml)) {
                                                    animeId2 = animeId3;
                                                    obj4 = coroutine_suspended;
                                                    String poster7 = poster3;
                                                    url5 = url7;
                                                    List list = subEpisodes5;
                                                    subEpisodes4 = genres3;
                                                    description3 = description4;
                                                    subEpisodes3 = list;
                                                    animeMetaData3 = animeMetaData2;
                                                    title3 = title4;
                                                    i4 = i5;
                                                    dubEpisodes3 = dubEpisodes4;
                                                    malId4 = malId3;
                                                    url6 = poster7;
                                                } else {
                                                    animeId2 = animeId3;
                                                    epDoc = Jsoup.parse(episodeListHtml);
                                                    elementSelectFirst7 = epDoc.selectFirst("a[data-mal]");
                                                    if (elementSelectFirst7 != null || (strAttr3 = elementSelectFirst7.attr("data-mal")) == null) {
                                                        intOrNull = null;
                                                    } else {
                                                        intOrNull = StringsKt.toIntOrNull(strAttr3);
                                                    }
                                                    malId3.element = intOrNull;
                                                    if (malId3.element != null) {
                                                        try {
                                                            Result.Companion companion3 = Result.Companion;
                                                            Anikoto $this$load_u24lambda_u244 = this;
                                                            Requests app3 = MainActivityKt.getApp();
                                                            String str4 = "https://api.ani.zip/mappings?mal_id=" + ((Number) malId3.element).intValue();
                                                            c00012.L$0 = url7;
                                                            c00012.L$1 = doc3;
                                                            c00012.L$2 = title4;
                                                            c00012.L$3 = poster3;
                                                            c00012.L$4 = description4;
                                                            c00012.L$5 = genres3;
                                                            c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeId2);
                                                            c00012.L$7 = subEpisodes5;
                                                            c00012.L$8 = dubEpisodes4;
                                                            c00012.L$9 = malId3;
                                                            c00012.L$10 = animeMetaData2;
                                                            c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodeListHtml);
                                                            c00012.L$12 = epDoc;
                                                            c00012.L$13 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u244);
                                                            c00012.L$14 = animeMetaData2;
                                                            c00012.I$0 = i5;
                                                            c00012.label = 3;
                                                            title6 = title4;
                                                            doc5 = doc3;
                                                            url9 = url7;
                                                            poster5 = poster3;
                                                            c00013 = c00012;
                                                            try {
                                                                obj6 = Requests.get$default(app3, str4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                                                                c00012 = c00013;
                                                                if (obj6 == coroutine_suspended) {
                                                                    return coroutine_suspended;
                                                                }
                                                                malId5 = malId3;
                                                                genres4 = genres3;
                                                                description5 = description4;
                                                                animeMetaData4 = animeMetaData2;
                                                                title3 = title6;
                                                                title5 = episodeListHtml;
                                                                animeId4 = animeId2;
                                                                doc4 = doc5;
                                                                url8 = url9;
                                                                poster4 = poster5;
                                                                try {
                                                                    obj7 = Result.constructor-impl(AnikotoUtilsKt.parseAnimeData(((NiceResponse) obj6).getText()));
                                                                } catch (Throwable th2) {
                                                                    th = th2;
                                                                    Result.Companion companion4 = Result.Companion;
                                                                    obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                }
                                                                if (Result.isFailure-impl(obj7)) {
                                                                    obj7 = null;
                                                                }
                                                                animeMetaData2.element = obj7;
                                                                i6 = i5;
                                                                animeMetaData2 = animeMetaData4;
                                                                animeId2 = animeId4;
                                                                genres5 = genres4;
                                                                description6 = description5;
                                                                doc3 = doc4;
                                                                url10 = url8;
                                                            } catch (Throwable th3) {
                                                                th = th3;
                                                                c00012 = c00013;
                                                                malId5 = malId3;
                                                                genres4 = genres3;
                                                                description5 = description4;
                                                                animeMetaData4 = animeMetaData2;
                                                                title3 = title6;
                                                                title5 = episodeListHtml;
                                                                animeId4 = animeId2;
                                                                doc4 = doc5;
                                                                url8 = url9;
                                                                poster4 = poster5;
                                                                Result.Companion companion5 = Result.Companion;
                                                                obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                if (Result.isFailure-impl(obj7)) {
                                                                    obj7 = null;
                                                                }
                                                                animeMetaData2.element = obj7;
                                                                i6 = i5;
                                                                animeMetaData2 = animeMetaData4;
                                                                animeId2 = animeId4;
                                                                genres5 = genres4;
                                                                description6 = description5;
                                                                doc3 = doc4;
                                                                url10 = url8;
                                                                $this$forEach$iv = epDoc.select("a[data-ids]");
                                                                $i$f$forEach = 0;
                                                                for (Object element$iv2 : $this$forEach$iv) {
                                                                    int i7 = i6;
                                                                    el = (Element) element$iv2;
                                                                    Document epDoc2 = epDoc;
                                                                    serverIds = el.attr("data-ids");
                                                                    if (StringsKt.isBlank(serverIds)) {
                                                                        serverIds = null;
                                                                    }
                                                                    if (serverIds == null) {
                                                                        obj9 = coroutine_suspended;
                                                                        $this$forEach$iv2 = $this$forEach$iv;
                                                                        $i$f$forEach2 = $i$f$forEach;
                                                                    } else {
                                                                        obj9 = coroutine_suspended;
                                                                        episodeNum = StringsKt.toIntOrNull(el.attr("data-num"));
                                                                        $this$forEach$iv2 = $this$forEach$iv;
                                                                        hasSub = Intrinsics.areEqual(el.attr("data-sub"), "1");
                                                                        hasDub = Intrinsics.areEqual(el.attr("data-dub"), "1");
                                                                        if (episodeNum != null) {
                                                                            int it3 = episodeNum.intValue();
                                                                            hasDub2 = hasDub;
                                                                            metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                                                            if (metaAnimeData2 != null) {
                                                                                meta = null;
                                                                            } else {
                                                                                meta = null;
                                                                            }
                                                                        } else {
                                                                            hasDub2 = hasDub;
                                                                            meta = null;
                                                                        }
                                                                        if (meta != null) {
                                                                            meta2 = meta;
                                                                            if (meta2 != null) {
                                                                                str = null;
                                                                            } else {
                                                                                str = null;
                                                                            }
                                                                            if (str != null) {
                                                                                $i$f$forEach2 = $i$f$forEach;
                                                                                episodeName = str;
                                                                            } else {
                                                                                if (meta2 != null) {
                                                                                    str = null;
                                                                                } else {
                                                                                    str = null;
                                                                                }
                                                                                if (str == null) {
                                                                                    elementSelectFirst8 = el.selectFirst(".d-title");
                                                                                    if (elementSelectFirst8 != null) {
                                                                                        str2 = null;
                                                                                    } else {
                                                                                        str2 = null;
                                                                                    }
                                                                                    if (str2 == null) {
                                                                                        elementParent = el.parent();
                                                                                        if (elementParent != null) {
                                                                                            $i$f$forEach2 = $i$f$forEach;
                                                                                            strAttr5 = elementParent.attr("title");
                                                                                            if (strAttr5 == null) {
                                                                                            }
                                                                                            if (str2 == null) {
                                                                                                elementSelectFirst9 = el.selectFirst(".d-title");
                                                                                                if (elementSelectFirst9 != null) {
                                                                                                    str = null;
                                                                                                } else {
                                                                                                    str = null;
                                                                                                }
                                                                                                if (str == null) {
                                                                                                    StringBuilder sbAppend = new StringBuilder().append("Episode ");
                                                                                                    if (episodeNum == null) {
                                                                                                        obj10 = obj2;
                                                                                                    } else {
                                                                                                        obj10 = episodeNum;
                                                                                                    }
                                                                                                    episodeName = sbAppend.append(obj10).toString();
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            $i$f$forEach2 = $i$f$forEach;
                                                                                        }
                                                                                        str2 = null;
                                                                                        if (str2 == null) {
                                                                                            elementSelectFirst9 = el.selectFirst(".d-title");
                                                                                            if (elementSelectFirst9 != null) {
                                                                                                str = null;
                                                                                            } else {
                                                                                                str = null;
                                                                                            }
                                                                                            if (str == null) {
                                                                                                StringBuilder sbAppend2 = new StringBuilder().append("Episode ");
                                                                                                if (episodeNum == null) {
                                                                                                    obj10 = obj2;
                                                                                                } else {
                                                                                                    obj10 = episodeNum;
                                                                                                }
                                                                                                episodeName = sbAppend2.append(obj10).toString();
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        $i$f$forEach2 = $i$f$forEach;
                                                                                    }
                                                                                    episodeName = str2;
                                                                                } else {
                                                                                    $i$f$forEach2 = $i$f$forEach;
                                                                                }
                                                                                episodeName = str;
                                                                            }
                                                                        } else {
                                                                            meta2 = meta;
                                                                            if (meta2 != null) {
                                                                                str = null;
                                                                            } else {
                                                                                str = null;
                                                                            }
                                                                            if (str != null) {
                                                                                $i$f$forEach2 = $i$f$forEach;
                                                                                episodeName = str;
                                                                            } else {
                                                                                if (meta2 != null) {
                                                                                    str = null;
                                                                                } else {
                                                                                    str = null;
                                                                                }
                                                                                if (str == null) {
                                                                                    elementSelectFirst8 = el.selectFirst(".d-title");
                                                                                    if (elementSelectFirst8 != null) {
                                                                                        str2 = null;
                                                                                    } else {
                                                                                        str2 = null;
                                                                                    }
                                                                                    if (str2 == null) {
                                                                                        elementParent = el.parent();
                                                                                        if (elementParent != null) {
                                                                                            $i$f$forEach2 = $i$f$forEach;
                                                                                            strAttr5 = elementParent.attr("title");
                                                                                            if (strAttr5 == null) {
                                                                                            }
                                                                                            if (str2 == null) {
                                                                                                elementSelectFirst9 = el.selectFirst(".d-title");
                                                                                                if (elementSelectFirst9 != null) {
                                                                                                    str = null;
                                                                                                } else {
                                                                                                    str = null;
                                                                                                }
                                                                                                if (str == null) {
                                                                                                    StringBuilder sbAppend3 = new StringBuilder().append("Episode ");
                                                                                                    if (episodeNum == null) {
                                                                                                        obj10 = obj2;
                                                                                                    } else {
                                                                                                        obj10 = episodeNum;
                                                                                                    }
                                                                                                    episodeName = sbAppend3.append(obj10).toString();
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            $i$f$forEach2 = $i$f$forEach;
                                                                                        }
                                                                                        str2 = null;
                                                                                        if (str2 == null) {
                                                                                            elementSelectFirst9 = el.selectFirst(".d-title");
                                                                                            if (elementSelectFirst9 != null) {
                                                                                                str = null;
                                                                                            } else {
                                                                                                str = null;
                                                                                            }
                                                                                            if (str == null) {
                                                                                                StringBuilder sbAppend4 = new StringBuilder().append("Episode ");
                                                                                                if (episodeNum == null) {
                                                                                                    obj10 = obj2;
                                                                                                } else {
                                                                                                    obj10 = episodeNum;
                                                                                                }
                                                                                                episodeName = sbAppend4.append(obj10).toString();
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        $i$f$forEach2 = $i$f$forEach;
                                                                                    }
                                                                                    episodeName = str2;
                                                                                } else {
                                                                                    $i$f$forEach2 = $i$f$forEach;
                                                                                }
                                                                                episodeName = str;
                                                                            }
                                                                        }
                                                                        if (meta2 != null) {
                                                                            epThumb = meta2.getImage();
                                                                        } else {
                                                                            epThumb = null;
                                                                        }
                                                                        if (meta2 != null) {
                                                                            epDesc = meta2.getOverview();
                                                                        } else {
                                                                            epDesc = null;
                                                                        }
                                                                        if (meta2 != null) {
                                                                            epRating = null;
                                                                        } else {
                                                                            epRating = null;
                                                                        }
                                                                        if (meta2 != null) {
                                                                            epRuntime = meta2.getRuntime();
                                                                        } else {
                                                                            epRuntime = null;
                                                                        }
                                                                        if (meta2 != null) {
                                                                            epAirDate = meta2.getAirDateUtc();
                                                                        } else {
                                                                            epAirDate = null;
                                                                        }
                                                                        if (hasSub) {
                                                                            subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                                                                public final Object invoke(Object obj11) {
                                                                                    return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                                                                }
                                                                            }));
                                                                        } else {
                                                                            subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                                                                public final Object invoke(Object obj11) {
                                                                                    return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                                                                }
                                                                            }));
                                                                        }
                                                                        if (hasDub2) {
                                                                            dubEpisodes4.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|dub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda2
                                                                                public final Object invoke(Object obj11) {
                                                                                    return Anikoto.load$lambda$5$7(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                                                                }
                                                                            }));
                                                                        }
                                                                    }
                                                                    i6 = i7;
                                                                    epDoc = epDoc2;
                                                                    coroutine_suspended = obj9;
                                                                    $this$forEach$iv = $this$forEach$iv2;
                                                                    $i$f$forEach = $i$f$forEach2;
                                                                }
                                                                obj4 = coroutine_suspended;
                                                                url5 = url10;
                                                                subEpisodes3 = subEpisodes5;
                                                                description3 = description6;
                                                                subEpisodes4 = genres5;
                                                                i4 = i6;
                                                                url6 = poster4;
                                                                dubEpisodes3 = dubEpisodes4;
                                                                animeMetaData3 = animeMetaData2;
                                                                malId4 = malId5;
                                                                if (subEpisodes3.isEmpty()) {
                                                                    poster6 = url6;
                                                                    description7 = description3;
                                                                } else {
                                                                    poster6 = url6;
                                                                    description7 = description3;
                                                                }
                                                                metaAnimeData = (MetaAnimeData) animeMetaData3.element;
                                                                if (metaAnimeData != null) {
                                                                    backgroundPoster = null;
                                                                } else {
                                                                    backgroundPoster = null;
                                                                }
                                                                tvType = i4 == 0 ? TvType.AnimeMovie : TvType.AnimeMovie;
                                                                TvType tvType2 = tvType;
                                                                Ref.ObjectRef animeMetaData5 = animeMetaData3;
                                                                obj8 = obj4;
                                                                Ref.ObjectRef malId6 = malId4;
                                                                C00025 c00025 = new C00025(poster6, backgroundPoster, description7, subEpisodes4, malId4, subEpisodes3, dubEpisodes3, null);
                                                                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                                                                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                                                                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                                                                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster6);
                                                                c00012.L$4 = SpillingKt.nullOutSpilledVariable(description7);
                                                                c00012.L$5 = SpillingKt.nullOutSpilledVariable(subEpisodes4);
                                                                c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeId2);
                                                                c00012.L$7 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                                                                c00012.L$8 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                                                                c00012.L$9 = SpillingKt.nullOutSpilledVariable(malId6);
                                                                c00012.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData5);
                                                                c00012.L$11 = SpillingKt.nullOutSpilledVariable(backgroundPoster);
                                                                c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvType2);
                                                                c00012.L$13 = null;
                                                                c00012.L$14 = null;
                                                                c00012.I$0 = i4;
                                                                c00012.label = 4;
                                                                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title3, url5, tvType2, false, c00025, c00012, 8, (Object) null);
                                                                if (objNewAnimeLoadResponse$default == obj8) {
                                                                    return obj8;
                                                                }
                                                                return objNewAnimeLoadResponse$default;
                                                            }
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            Document document = doc3;
                                                            String str5 = url7;
                                                            malId5 = malId3;
                                                            genres4 = genres3;
                                                            description5 = description4;
                                                            animeMetaData4 = animeMetaData2;
                                                            title3 = title4;
                                                            title5 = episodeListHtml;
                                                            animeId4 = animeId2;
                                                            doc4 = document;
                                                            url8 = str5;
                                                            poster4 = poster3;
                                                        }
                                                    } else {
                                                        String poster8 = poster3;
                                                        String url11 = url7;
                                                        malId5 = malId3;
                                                        genres5 = genres3;
                                                        i6 = i5;
                                                        title3 = title4;
                                                        url10 = url11;
                                                        poster4 = poster8;
                                                        description6 = description4;
                                                    }
                                                    $this$forEach$iv = epDoc.select("a[data-ids]");
                                                    $i$f$forEach = 0;
                                                    while (r10.hasNext()) {
                                                        int i8 = i6;
                                                        el = (Element) element$iv2;
                                                        Document epDoc3 = epDoc;
                                                        serverIds = el.attr("data-ids");
                                                        if (StringsKt.isBlank(serverIds)) {
                                                            serverIds = null;
                                                        }
                                                        if (serverIds == null) {
                                                            obj9 = coroutine_suspended;
                                                            $this$forEach$iv2 = $this$forEach$iv;
                                                            $i$f$forEach2 = $i$f$forEach;
                                                        } else {
                                                            obj9 = coroutine_suspended;
                                                            episodeNum = StringsKt.toIntOrNull(el.attr("data-num"));
                                                            $this$forEach$iv2 = $this$forEach$iv;
                                                            hasSub = Intrinsics.areEqual(el.attr("data-sub"), "1");
                                                            hasDub = Intrinsics.areEqual(el.attr("data-dub"), "1");
                                                            if (episodeNum != null) {
                                                                int it4 = episodeNum.intValue();
                                                                hasDub2 = hasDub;
                                                                metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                                                if (metaAnimeData2 != null || (episodes = metaAnimeData2.getEpisodes()) == null) {
                                                                    meta = null;
                                                                } else {
                                                                    meta = episodes.get(String.valueOf(it4));
                                                                }
                                                            } else {
                                                                hasDub2 = hasDub;
                                                                meta = null;
                                                            }
                                                            if (meta != null || (title9 = meta.getTitle()) == null) {
                                                                meta2 = meta;
                                                            } else {
                                                                meta2 = meta;
                                                                String str6 = title9.get("en");
                                                                if (str6 != null) {
                                                                    episodeName = str6;
                                                                    $i$f$forEach2 = $i$f$forEach;
                                                                }
                                                                if (meta2 != null) {
                                                                    epThumb = meta2.getImage();
                                                                } else {
                                                                    epThumb = null;
                                                                }
                                                                if (meta2 != null) {
                                                                    epDesc = meta2.getOverview();
                                                                } else {
                                                                    epDesc = null;
                                                                }
                                                                if (meta2 != null || (it2 = meta2.getRating()) == null) {
                                                                    epRating = null;
                                                                } else {
                                                                    epRating = Score.Companion.from10(it2);
                                                                }
                                                                if (meta2 != null) {
                                                                    epRuntime = meta2.getRuntime();
                                                                } else {
                                                                    epRuntime = null;
                                                                }
                                                                if (meta2 != null) {
                                                                    epAirDate = meta2.getAirDateUtc();
                                                                } else {
                                                                    epAirDate = null;
                                                                }
                                                                if (hasSub || !hasDub2) {
                                                                    subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                                                        public final Object invoke(Object obj11) {
                                                                            return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                                                        }
                                                                    }));
                                                                }
                                                                if (hasDub2) {
                                                                    dubEpisodes4.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|dub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda2
                                                                        public final Object invoke(Object obj11) {
                                                                            return Anikoto.load$lambda$5$7(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                                                        }
                                                                    }));
                                                                }
                                                            }
                                                            if (meta2 != null || (title8 = meta2.getTitle()) == null) {
                                                                str = null;
                                                            } else {
                                                                str = title8.get("x-jat");
                                                            }
                                                            if (str != null) {
                                                                $i$f$forEach2 = $i$f$forEach;
                                                                episodeName = str;
                                                            } else {
                                                                if (meta2 != null || (title7 = meta2.getTitle()) == null) {
                                                                    str = null;
                                                                } else {
                                                                    str = title7.get("ja");
                                                                }
                                                                if (str == null) {
                                                                    elementSelectFirst8 = el.selectFirst(".d-title");
                                                                    if (elementSelectFirst8 != null || (strText5 = elementSelectFirst8.text()) == null || (string4 = StringsKt.trim(strText5).toString()) == null) {
                                                                        str2 = null;
                                                                    } else {
                                                                        String str7 = string4;
                                                                        if (StringsKt.isBlank(str7)) {
                                                                            str7 = null;
                                                                        }
                                                                        str2 = str7;
                                                                    }
                                                                    if (str2 == null) {
                                                                        elementParent = el.parent();
                                                                        if (elementParent != null) {
                                                                            $i$f$forEach2 = $i$f$forEach;
                                                                            strAttr5 = elementParent.attr("title");
                                                                            if (strAttr5 == null && (string3 = StringsKt.trim(strAttr5).toString()) != null) {
                                                                                String str8 = string3;
                                                                                if (StringsKt.isBlank(str8)) {
                                                                                    str8 = null;
                                                                                }
                                                                                str2 = str8;
                                                                            }
                                                                            if (str2 == null) {
                                                                                elementSelectFirst9 = el.selectFirst(".d-title");
                                                                                if (elementSelectFirst9 != null || (strAttr4 = elementSelectFirst9.attr("data-jp")) == null || (string2 = StringsKt.trim(strAttr4).toString()) == null) {
                                                                                    str = null;
                                                                                } else {
                                                                                    String str9 = string2;
                                                                                    if (StringsKt.isBlank(str9)) {
                                                                                        str9 = null;
                                                                                    }
                                                                                    str = str9;
                                                                                }
                                                                                if (str == null) {
                                                                                    StringBuilder sbAppend5 = new StringBuilder().append("Episode ");
                                                                                    if (episodeNum == null) {
                                                                                        obj10 = obj2;
                                                                                    } else {
                                                                                        obj10 = episodeNum;
                                                                                    }
                                                                                    episodeName = sbAppend5.append(obj10).toString();
                                                                                }
                                                                            }
                                                                        } else {
                                                                            $i$f$forEach2 = $i$f$forEach;
                                                                        }
                                                                        str2 = null;
                                                                        if (str2 == null) {
                                                                            elementSelectFirst9 = el.selectFirst(".d-title");
                                                                            if (elementSelectFirst9 != null) {
                                                                                str = null;
                                                                            } else {
                                                                                str = null;
                                                                            }
                                                                            if (str == null) {
                                                                                StringBuilder sbAppend6 = new StringBuilder().append("Episode ");
                                                                                if (episodeNum == null) {
                                                                                    obj10 = obj2;
                                                                                } else {
                                                                                    obj10 = episodeNum;
                                                                                }
                                                                                episodeName = sbAppend6.append(obj10).toString();
                                                                            }
                                                                        }
                                                                    } else {
                                                                        $i$f$forEach2 = $i$f$forEach;
                                                                    }
                                                                    episodeName = str2;
                                                                } else {
                                                                    $i$f$forEach2 = $i$f$forEach;
                                                                }
                                                                episodeName = str;
                                                            }
                                                            if (meta2 != null) {
                                                                epThumb = meta2.getImage();
                                                            } else {
                                                                epThumb = null;
                                                            }
                                                            if (meta2 != null) {
                                                                epDesc = meta2.getOverview();
                                                            } else {
                                                                epDesc = null;
                                                            }
                                                            if (meta2 != null) {
                                                                epRating = null;
                                                            } else {
                                                                epRating = null;
                                                            }
                                                            if (meta2 != null) {
                                                                epRuntime = meta2.getRuntime();
                                                            } else {
                                                                epRuntime = null;
                                                            }
                                                            if (meta2 != null) {
                                                                epAirDate = meta2.getAirDateUtc();
                                                            } else {
                                                                epAirDate = null;
                                                            }
                                                            if (hasSub) {
                                                                subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                                                    public final Object invoke(Object obj11) {
                                                                        return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                                                    }
                                                                }));
                                                            } else {
                                                                subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                                                    public final Object invoke(Object obj11) {
                                                                        return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                                                    }
                                                                }));
                                                            }
                                                            if (hasDub2) {
                                                                dubEpisodes4.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|dub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda2
                                                                    public final Object invoke(Object obj11) {
                                                                        return Anikoto.load$lambda$5$7(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                                                    }
                                                                }));
                                                            }
                                                        }
                                                        i6 = i8;
                                                        epDoc = epDoc3;
                                                        coroutine_suspended = obj9;
                                                        $this$forEach$iv = $this$forEach$iv2;
                                                        $i$f$forEach = $i$f$forEach2;
                                                    }
                                                    obj4 = coroutine_suspended;
                                                    url5 = url10;
                                                    subEpisodes3 = subEpisodes5;
                                                    description3 = description6;
                                                    subEpisodes4 = genres5;
                                                    i4 = i6;
                                                    url6 = poster4;
                                                    dubEpisodes3 = dubEpisodes4;
                                                    animeMetaData3 = animeMetaData2;
                                                    malId4 = malId5;
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                                c00012 = c00014;
                                                subEpisodes2 = subEpisodes;
                                                malId2 = malId3;
                                                doc2 = doc;
                                                title2 = title;
                                                description2 = description;
                                                poster2 = poster;
                                                url3 = url2;
                                                genres2 = genres;
                                                url4 = animeId;
                                                i3 = i2;
                                                animeMetaData2 = animeMetaData;
                                                Result.Companion companion6 = Result.Companion;
                                                obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                malId3 = malId2;
                                                i5 = i3;
                                                subEpisodes5 = subEpisodes2;
                                                animeId3 = url4;
                                                genres3 = genres2;
                                                description4 = description2;
                                                poster3 = poster2;
                                                title4 = title2;
                                                doc3 = doc2;
                                                url7 = url3;
                                                dubEpisodes4 = dubEpisodes2;
                                                if (Result.exceptionOrNull-impl(obj5) != null) {
                                                    obj5 = obj2;
                                                }
                                                episodeListHtml = (String) obj5;
                                                if (StringsKt.isBlank(episodeListHtml)) {
                                                    animeId2 = animeId3;
                                                    epDoc = Jsoup.parse(episodeListHtml);
                                                    elementSelectFirst7 = epDoc.selectFirst("a[data-mal]");
                                                    if (elementSelectFirst7 != null) {
                                                        intOrNull = null;
                                                    } else {
                                                        intOrNull = null;
                                                    }
                                                    malId3.element = intOrNull;
                                                    if (malId3.element != null) {
                                                        Result.Companion companion7 = Result.Companion;
                                                        Anikoto $this$load_u24lambda_u245 = this;
                                                        Requests app4 = MainActivityKt.getApp();
                                                        String str10 = "https://api.ani.zip/mappings?mal_id=" + ((Number) malId3.element).intValue();
                                                        c00012.L$0 = url7;
                                                        c00012.L$1 = doc3;
                                                        c00012.L$2 = title4;
                                                        c00012.L$3 = poster3;
                                                        c00012.L$4 = description4;
                                                        c00012.L$5 = genres3;
                                                        c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeId2);
                                                        c00012.L$7 = subEpisodes5;
                                                        c00012.L$8 = dubEpisodes4;
                                                        c00012.L$9 = malId3;
                                                        c00012.L$10 = animeMetaData2;
                                                        c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodeListHtml);
                                                        c00012.L$12 = epDoc;
                                                        c00012.L$13 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u245);
                                                        c00012.L$14 = animeMetaData2;
                                                        c00012.I$0 = i5;
                                                        c00012.label = 3;
                                                        title6 = title4;
                                                        doc5 = doc3;
                                                        url9 = url7;
                                                        poster5 = poster3;
                                                        c00013 = c00012;
                                                        obj6 = Requests.get$default(app4, str10, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                                                        c00012 = c00013;
                                                        if (obj6 == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        malId5 = malId3;
                                                        genres4 = genres3;
                                                        description5 = description4;
                                                        animeMetaData4 = animeMetaData2;
                                                        title3 = title6;
                                                        title5 = episodeListHtml;
                                                        animeId4 = animeId2;
                                                        doc4 = doc5;
                                                        url8 = url9;
                                                        poster4 = poster5;
                                                        obj7 = Result.constructor-impl(AnikotoUtilsKt.parseAnimeData(((NiceResponse) obj6).getText()));
                                                        if (Result.isFailure-impl(obj7)) {
                                                            obj7 = null;
                                                        }
                                                        animeMetaData2.element = obj7;
                                                        i6 = i5;
                                                        animeMetaData2 = animeMetaData4;
                                                        animeId2 = animeId4;
                                                        genres5 = genres4;
                                                        description6 = description5;
                                                        doc3 = doc4;
                                                        url10 = url8;
                                                    } else {
                                                        String poster9 = poster3;
                                                        String url12 = url7;
                                                        malId5 = malId3;
                                                        genres5 = genres3;
                                                        i6 = i5;
                                                        title3 = title4;
                                                        url10 = url12;
                                                        poster4 = poster9;
                                                        description6 = description4;
                                                    }
                                                    $this$forEach$iv = epDoc.select("a[data-ids]");
                                                    $i$f$forEach = 0;
                                                    while (r10.hasNext()) {
                                                        int i9 = i6;
                                                        el = (Element) element$iv2;
                                                        Document epDoc4 = epDoc;
                                                        serverIds = el.attr("data-ids");
                                                        if (StringsKt.isBlank(serverIds)) {
                                                            serverIds = null;
                                                        }
                                                        if (serverIds == null) {
                                                            obj9 = coroutine_suspended;
                                                            $this$forEach$iv2 = $this$forEach$iv;
                                                            $i$f$forEach2 = $i$f$forEach;
                                                        } else {
                                                            obj9 = coroutine_suspended;
                                                            episodeNum = StringsKt.toIntOrNull(el.attr("data-num"));
                                                            $this$forEach$iv2 = $this$forEach$iv;
                                                            hasSub = Intrinsics.areEqual(el.attr("data-sub"), "1");
                                                            hasDub = Intrinsics.areEqual(el.attr("data-dub"), "1");
                                                            if (episodeNum != null) {
                                                                int it5 = episodeNum.intValue();
                                                                hasDub2 = hasDub;
                                                                metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                                                if (metaAnimeData2 != null) {
                                                                    meta = null;
                                                                } else {
                                                                    meta = null;
                                                                }
                                                            } else {
                                                                hasDub2 = hasDub;
                                                                meta = null;
                                                            }
                                                            if (meta != null) {
                                                                meta2 = meta;
                                                                if (meta2 != null) {
                                                                    str = null;
                                                                } else {
                                                                    str = null;
                                                                }
                                                                if (str != null) {
                                                                    $i$f$forEach2 = $i$f$forEach;
                                                                    episodeName = str;
                                                                } else {
                                                                    if (meta2 != null) {
                                                                        str = null;
                                                                    } else {
                                                                        str = null;
                                                                    }
                                                                    if (str == null) {
                                                                        elementSelectFirst8 = el.selectFirst(".d-title");
                                                                        if (elementSelectFirst8 != null) {
                                                                            str2 = null;
                                                                        } else {
                                                                            str2 = null;
                                                                        }
                                                                        if (str2 == null) {
                                                                            elementParent = el.parent();
                                                                            if (elementParent != null) {
                                                                                $i$f$forEach2 = $i$f$forEach;
                                                                                strAttr5 = elementParent.attr("title");
                                                                                if (strAttr5 == null) {
                                                                                }
                                                                                if (str2 == null) {
                                                                                    elementSelectFirst9 = el.selectFirst(".d-title");
                                                                                    if (elementSelectFirst9 != null) {
                                                                                        str = null;
                                                                                    } else {
                                                                                        str = null;
                                                                                    }
                                                                                    if (str == null) {
                                                                                        StringBuilder sbAppend7 = new StringBuilder().append("Episode ");
                                                                                        if (episodeNum == null) {
                                                                                            obj10 = obj2;
                                                                                        } else {
                                                                                            obj10 = episodeNum;
                                                                                        }
                                                                                        episodeName = sbAppend7.append(obj10).toString();
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                $i$f$forEach2 = $i$f$forEach;
                                                                            }
                                                                            str2 = null;
                                                                            if (str2 == null) {
                                                                                elementSelectFirst9 = el.selectFirst(".d-title");
                                                                                if (elementSelectFirst9 != null) {
                                                                                    str = null;
                                                                                } else {
                                                                                    str = null;
                                                                                }
                                                                                if (str == null) {
                                                                                    StringBuilder sbAppend8 = new StringBuilder().append("Episode ");
                                                                                    if (episodeNum == null) {
                                                                                        obj10 = obj2;
                                                                                    } else {
                                                                                        obj10 = episodeNum;
                                                                                    }
                                                                                    episodeName = sbAppend8.append(obj10).toString();
                                                                                }
                                                                            }
                                                                        } else {
                                                                            $i$f$forEach2 = $i$f$forEach;
                                                                        }
                                                                        episodeName = str2;
                                                                    } else {
                                                                        $i$f$forEach2 = $i$f$forEach;
                                                                    }
                                                                    episodeName = str;
                                                                }
                                                            } else {
                                                                meta2 = meta;
                                                                if (meta2 != null) {
                                                                    str = null;
                                                                } else {
                                                                    str = null;
                                                                }
                                                                if (str != null) {
                                                                    $i$f$forEach2 = $i$f$forEach;
                                                                    episodeName = str;
                                                                } else {
                                                                    if (meta2 != null) {
                                                                        str = null;
                                                                    } else {
                                                                        str = null;
                                                                    }
                                                                    if (str == null) {
                                                                        elementSelectFirst8 = el.selectFirst(".d-title");
                                                                        if (elementSelectFirst8 != null) {
                                                                            str2 = null;
                                                                        } else {
                                                                            str2 = null;
                                                                        }
                                                                        if (str2 == null) {
                                                                            elementParent = el.parent();
                                                                            if (elementParent != null) {
                                                                                $i$f$forEach2 = $i$f$forEach;
                                                                                strAttr5 = elementParent.attr("title");
                                                                                if (strAttr5 == null) {
                                                                                }
                                                                                if (str2 == null) {
                                                                                    elementSelectFirst9 = el.selectFirst(".d-title");
                                                                                    if (elementSelectFirst9 != null) {
                                                                                        str = null;
                                                                                    } else {
                                                                                        str = null;
                                                                                    }
                                                                                    if (str == null) {
                                                                                        StringBuilder sbAppend9 = new StringBuilder().append("Episode ");
                                                                                        if (episodeNum == null) {
                                                                                            obj10 = obj2;
                                                                                        } else {
                                                                                            obj10 = episodeNum;
                                                                                        }
                                                                                        episodeName = sbAppend9.append(obj10).toString();
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                $i$f$forEach2 = $i$f$forEach;
                                                                            }
                                                                            str2 = null;
                                                                            if (str2 == null) {
                                                                                elementSelectFirst9 = el.selectFirst(".d-title");
                                                                                if (elementSelectFirst9 != null) {
                                                                                    str = null;
                                                                                } else {
                                                                                    str = null;
                                                                                }
                                                                                if (str == null) {
                                                                                    StringBuilder sbAppend10 = new StringBuilder().append("Episode ");
                                                                                    if (episodeNum == null) {
                                                                                        obj10 = obj2;
                                                                                    } else {
                                                                                        obj10 = episodeNum;
                                                                                    }
                                                                                    episodeName = sbAppend10.append(obj10).toString();
                                                                                }
                                                                            }
                                                                        } else {
                                                                            $i$f$forEach2 = $i$f$forEach;
                                                                        }
                                                                        episodeName = str2;
                                                                    } else {
                                                                        $i$f$forEach2 = $i$f$forEach;
                                                                    }
                                                                    episodeName = str;
                                                                }
                                                            }
                                                            if (meta2 != null) {
                                                                epThumb = meta2.getImage();
                                                            } else {
                                                                epThumb = null;
                                                            }
                                                            if (meta2 != null) {
                                                                epDesc = meta2.getOverview();
                                                            } else {
                                                                epDesc = null;
                                                            }
                                                            if (meta2 != null) {
                                                                epRating = null;
                                                            } else {
                                                                epRating = null;
                                                            }
                                                            if (meta2 != null) {
                                                                epRuntime = meta2.getRuntime();
                                                            } else {
                                                                epRuntime = null;
                                                            }
                                                            if (meta2 != null) {
                                                                epAirDate = meta2.getAirDateUtc();
                                                            } else {
                                                                epAirDate = null;
                                                            }
                                                            if (hasSub) {
                                                                subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                                                    public final Object invoke(Object obj11) {
                                                                        return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                                                    }
                                                                }));
                                                            } else {
                                                                subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                                                    public final Object invoke(Object obj11) {
                                                                        return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                                                    }
                                                                }));
                                                            }
                                                            if (hasDub2) {
                                                                dubEpisodes4.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|dub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda2
                                                                    public final Object invoke(Object obj11) {
                                                                        return Anikoto.load$lambda$5$7(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                                                    }
                                                                }));
                                                            }
                                                        }
                                                        i6 = i9;
                                                        epDoc = epDoc4;
                                                        coroutine_suspended = obj9;
                                                        $this$forEach$iv = $this$forEach$iv2;
                                                        $i$f$forEach = $i$f$forEach2;
                                                    }
                                                    obj4 = coroutine_suspended;
                                                    url5 = url10;
                                                    subEpisodes3 = subEpisodes5;
                                                    description3 = description6;
                                                    subEpisodes4 = genres5;
                                                    i4 = i6;
                                                    url6 = poster4;
                                                    dubEpisodes3 = dubEpisodes4;
                                                    animeMetaData3 = animeMetaData2;
                                                    malId4 = malId5;
                                                } else {
                                                    animeId2 = animeId3;
                                                    obj4 = coroutine_suspended;
                                                    String poster10 = poster3;
                                                    url5 = url7;
                                                    List list2 = subEpisodes5;
                                                    subEpisodes4 = genres3;
                                                    description3 = description4;
                                                    subEpisodes3 = list2;
                                                    animeMetaData3 = animeMetaData2;
                                                    title3 = title4;
                                                    i4 = i5;
                                                    dubEpisodes3 = dubEpisodes4;
                                                    malId4 = malId3;
                                                    url6 = poster10;
                                                }
                                                if (subEpisodes3.isEmpty()) {
                                                    poster6 = url6;
                                                    description7 = description3;
                                                } else {
                                                    poster6 = url6;
                                                    description7 = description3;
                                                }
                                                metaAnimeData = (MetaAnimeData) animeMetaData3.element;
                                                if (metaAnimeData != null) {
                                                    backgroundPoster = null;
                                                } else {
                                                    backgroundPoster = null;
                                                }
                                                if (i4 == 0) {
                                                }
                                                TvType tvType3 = tvType;
                                                Ref.ObjectRef animeMetaData6 = animeMetaData3;
                                                obj8 = obj4;
                                                Ref.ObjectRef malId7 = malId4;
                                                C00025 c00026 = new C00025(poster6, backgroundPoster, description7, subEpisodes4, malId4, subEpisodes3, dubEpisodes3, null);
                                                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                                                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                                                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                                                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster6);
                                                c00012.L$4 = SpillingKt.nullOutSpilledVariable(description7);
                                                c00012.L$5 = SpillingKt.nullOutSpilledVariable(subEpisodes4);
                                                c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeId2);
                                                c00012.L$7 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                                                c00012.L$8 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                                                c00012.L$9 = SpillingKt.nullOutSpilledVariable(malId7);
                                                c00012.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData6);
                                                c00012.L$11 = SpillingKt.nullOutSpilledVariable(backgroundPoster);
                                                c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvType3);
                                                c00012.L$13 = null;
                                                c00012.L$14 = null;
                                                c00012.I$0 = i4;
                                                c00012.label = 4;
                                                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title3, url5, tvType3, false, c00026, c00012, 8, (Object) null);
                                                if (objNewAnimeLoadResponse$default == obj8) {
                                                    return obj8;
                                                }
                                                return objNewAnimeLoadResponse$default;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            c00012 = c00014;
                                            subEpisodes2 = subEpisodes;
                                            malId2 = malId3;
                                            doc2 = doc;
                                            title2 = title;
                                            description2 = description;
                                            poster2 = poster;
                                            url3 = url2;
                                            genres2 = genres;
                                            url4 = animeId;
                                            i3 = i2;
                                            animeMetaData2 = animeMetaData;
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        dubEpisodes2 = dubEpisodes;
                                        c00012 = c00014;
                                        subEpisodes2 = subEpisodes;
                                        malId2 = malId3;
                                        doc2 = doc;
                                        title2 = title;
                                        description2 = description;
                                        poster2 = poster;
                                        url3 = url2;
                                        genres2 = genres;
                                        url4 = animeId;
                                        i3 = i2;
                                        animeMetaData2 = animeMetaData;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    dubEpisodes2 = dubEpisodes;
                                    c00012 = c00014;
                                    subEpisodes2 = subEpisodes;
                                    malId2 = malId3;
                                    doc2 = doc;
                                    title2 = title;
                                    description2 = description;
                                    poster2 = poster;
                                    url3 = url2;
                                    genres2 = genres;
                                    url4 = animeId;
                                    i3 = i2;
                                    animeMetaData2 = animeMetaData;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                dubEpisodes2 = dubEpisodes;
                                c00012 = c00014;
                                subEpisodes2 = subEpisodes;
                                malId2 = malId;
                                doc2 = doc;
                                title2 = title;
                                description2 = description;
                                poster2 = poster;
                                url3 = url2;
                                genres2 = genres;
                                url4 = animeId;
                                i3 = i2;
                                animeMetaData2 = animeMetaData;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            dubEpisodes2 = dubEpisodes;
                            c00012 = c00014;
                            subEpisodes2 = subEpisodes;
                            malId2 = malId;
                            doc2 = doc;
                            title2 = title;
                            description2 = description;
                            poster2 = poster;
                            url3 = url2;
                            genres2 = genres;
                            url4 = animeId;
                            i3 = i2;
                            animeMetaData2 = animeMetaData;
                            Result.Companion companion8 = Result.Companion;
                            obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                            malId3 = malId2;
                            i5 = i3;
                            subEpisodes5 = subEpisodes2;
                            animeId3 = url4;
                            genres3 = genres2;
                            description4 = description2;
                            poster3 = poster2;
                            title4 = title2;
                            doc3 = doc2;
                            url7 = url3;
                            dubEpisodes4 = dubEpisodes2;
                            if (Result.exceptionOrNull-impl(obj5) != null) {
                                obj5 = obj2;
                            }
                            episodeListHtml = (String) obj5;
                            if (StringsKt.isBlank(episodeListHtml)) {
                                animeId2 = animeId3;
                                epDoc = Jsoup.parse(episodeListHtml);
                                elementSelectFirst7 = epDoc.selectFirst("a[data-mal]");
                                if (elementSelectFirst7 != null) {
                                    intOrNull = null;
                                } else {
                                    intOrNull = null;
                                }
                                malId3.element = intOrNull;
                                if (malId3.element != null) {
                                    Result.Companion companion9 = Result.Companion;
                                    Anikoto $this$load_u24lambda_u246 = this;
                                    Requests app5 = MainActivityKt.getApp();
                                    String str11 = "https://api.ani.zip/mappings?mal_id=" + ((Number) malId3.element).intValue();
                                    c00012.L$0 = url7;
                                    c00012.L$1 = doc3;
                                    c00012.L$2 = title4;
                                    c00012.L$3 = poster3;
                                    c00012.L$4 = description4;
                                    c00012.L$5 = genres3;
                                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeId2);
                                    c00012.L$7 = subEpisodes5;
                                    c00012.L$8 = dubEpisodes4;
                                    c00012.L$9 = malId3;
                                    c00012.L$10 = animeMetaData2;
                                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodeListHtml);
                                    c00012.L$12 = epDoc;
                                    c00012.L$13 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u246);
                                    c00012.L$14 = animeMetaData2;
                                    c00012.I$0 = i5;
                                    c00012.label = 3;
                                    title6 = title4;
                                    doc5 = doc3;
                                    url9 = url7;
                                    poster5 = poster3;
                                    c00013 = c00012;
                                    obj6 = Requests.get$default(app5, str11, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                                    c00012 = c00013;
                                    if (obj6 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    malId5 = malId3;
                                    genres4 = genres3;
                                    description5 = description4;
                                    animeMetaData4 = animeMetaData2;
                                    title3 = title6;
                                    title5 = episodeListHtml;
                                    animeId4 = animeId2;
                                    doc4 = doc5;
                                    url8 = url9;
                                    poster4 = poster5;
                                    obj7 = Result.constructor-impl(AnikotoUtilsKt.parseAnimeData(((NiceResponse) obj6).getText()));
                                    if (Result.isFailure-impl(obj7)) {
                                        obj7 = null;
                                    }
                                    animeMetaData2.element = obj7;
                                    i6 = i5;
                                    animeMetaData2 = animeMetaData4;
                                    animeId2 = animeId4;
                                    genres5 = genres4;
                                    description6 = description5;
                                    doc3 = doc4;
                                    url10 = url8;
                                } else {
                                    String poster11 = poster3;
                                    String url13 = url7;
                                    malId5 = malId3;
                                    genres5 = genres3;
                                    i6 = i5;
                                    title3 = title4;
                                    url10 = url13;
                                    poster4 = poster11;
                                    description6 = description4;
                                }
                                $this$forEach$iv = epDoc.select("a[data-ids]");
                                $i$f$forEach = 0;
                                while (r10.hasNext()) {
                                    int i10 = i6;
                                    el = (Element) element$iv2;
                                    Document epDoc5 = epDoc;
                                    serverIds = el.attr("data-ids");
                                    if (StringsKt.isBlank(serverIds)) {
                                        serverIds = null;
                                    }
                                    if (serverIds == null) {
                                        obj9 = coroutine_suspended;
                                        $this$forEach$iv2 = $this$forEach$iv;
                                        $i$f$forEach2 = $i$f$forEach;
                                    } else {
                                        obj9 = coroutine_suspended;
                                        episodeNum = StringsKt.toIntOrNull(el.attr("data-num"));
                                        $this$forEach$iv2 = $this$forEach$iv;
                                        hasSub = Intrinsics.areEqual(el.attr("data-sub"), "1");
                                        hasDub = Intrinsics.areEqual(el.attr("data-dub"), "1");
                                        if (episodeNum != null) {
                                            int it6 = episodeNum.intValue();
                                            hasDub2 = hasDub;
                                            metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                            if (metaAnimeData2 != null) {
                                                meta = null;
                                            } else {
                                                meta = null;
                                            }
                                        } else {
                                            hasDub2 = hasDub;
                                            meta = null;
                                        }
                                        if (meta != null) {
                                            meta2 = meta;
                                            if (meta2 != null) {
                                                str = null;
                                            } else {
                                                str = null;
                                            }
                                            if (str != null) {
                                                $i$f$forEach2 = $i$f$forEach;
                                                episodeName = str;
                                            } else {
                                                if (meta2 != null) {
                                                    str = null;
                                                } else {
                                                    str = null;
                                                }
                                                if (str == null) {
                                                    elementSelectFirst8 = el.selectFirst(".d-title");
                                                    if (elementSelectFirst8 != null) {
                                                        str2 = null;
                                                    } else {
                                                        str2 = null;
                                                    }
                                                    if (str2 == null) {
                                                        elementParent = el.parent();
                                                        if (elementParent != null) {
                                                            $i$f$forEach2 = $i$f$forEach;
                                                            strAttr5 = elementParent.attr("title");
                                                            if (strAttr5 == null) {
                                                            }
                                                            if (str2 == null) {
                                                                elementSelectFirst9 = el.selectFirst(".d-title");
                                                                if (elementSelectFirst9 != null) {
                                                                    str = null;
                                                                } else {
                                                                    str = null;
                                                                }
                                                                if (str == null) {
                                                                    StringBuilder sbAppend11 = new StringBuilder().append("Episode ");
                                                                    if (episodeNum == null) {
                                                                        obj10 = obj2;
                                                                    } else {
                                                                        obj10 = episodeNum;
                                                                    }
                                                                    episodeName = sbAppend11.append(obj10).toString();
                                                                }
                                                            }
                                                        } else {
                                                            $i$f$forEach2 = $i$f$forEach;
                                                        }
                                                        str2 = null;
                                                        if (str2 == null) {
                                                            elementSelectFirst9 = el.selectFirst(".d-title");
                                                            if (elementSelectFirst9 != null) {
                                                                str = null;
                                                            } else {
                                                                str = null;
                                                            }
                                                            if (str == null) {
                                                                StringBuilder sbAppend12 = new StringBuilder().append("Episode ");
                                                                if (episodeNum == null) {
                                                                    obj10 = obj2;
                                                                } else {
                                                                    obj10 = episodeNum;
                                                                }
                                                                episodeName = sbAppend12.append(obj10).toString();
                                                            }
                                                        }
                                                    } else {
                                                        $i$f$forEach2 = $i$f$forEach;
                                                    }
                                                    episodeName = str2;
                                                } else {
                                                    $i$f$forEach2 = $i$f$forEach;
                                                }
                                                episodeName = str;
                                            }
                                        } else {
                                            meta2 = meta;
                                            if (meta2 != null) {
                                                str = null;
                                            } else {
                                                str = null;
                                            }
                                            if (str != null) {
                                                $i$f$forEach2 = $i$f$forEach;
                                                episodeName = str;
                                            } else {
                                                if (meta2 != null) {
                                                    str = null;
                                                } else {
                                                    str = null;
                                                }
                                                if (str == null) {
                                                    elementSelectFirst8 = el.selectFirst(".d-title");
                                                    if (elementSelectFirst8 != null) {
                                                        str2 = null;
                                                    } else {
                                                        str2 = null;
                                                    }
                                                    if (str2 == null) {
                                                        elementParent = el.parent();
                                                        if (elementParent != null) {
                                                            $i$f$forEach2 = $i$f$forEach;
                                                            strAttr5 = elementParent.attr("title");
                                                            if (strAttr5 == null) {
                                                            }
                                                            if (str2 == null) {
                                                                elementSelectFirst9 = el.selectFirst(".d-title");
                                                                if (elementSelectFirst9 != null) {
                                                                    str = null;
                                                                } else {
                                                                    str = null;
                                                                }
                                                                if (str == null) {
                                                                    StringBuilder sbAppend13 = new StringBuilder().append("Episode ");
                                                                    if (episodeNum == null) {
                                                                        obj10 = obj2;
                                                                    } else {
                                                                        obj10 = episodeNum;
                                                                    }
                                                                    episodeName = sbAppend13.append(obj10).toString();
                                                                }
                                                            }
                                                        } else {
                                                            $i$f$forEach2 = $i$f$forEach;
                                                        }
                                                        str2 = null;
                                                        if (str2 == null) {
                                                            elementSelectFirst9 = el.selectFirst(".d-title");
                                                            if (elementSelectFirst9 != null) {
                                                                str = null;
                                                            } else {
                                                                str = null;
                                                            }
                                                            if (str == null) {
                                                                StringBuilder sbAppend14 = new StringBuilder().append("Episode ");
                                                                if (episodeNum == null) {
                                                                    obj10 = obj2;
                                                                } else {
                                                                    obj10 = episodeNum;
                                                                }
                                                                episodeName = sbAppend14.append(obj10).toString();
                                                            }
                                                        }
                                                    } else {
                                                        $i$f$forEach2 = $i$f$forEach;
                                                    }
                                                    episodeName = str2;
                                                } else {
                                                    $i$f$forEach2 = $i$f$forEach;
                                                }
                                                episodeName = str;
                                            }
                                        }
                                        if (meta2 != null) {
                                            epThumb = meta2.getImage();
                                        } else {
                                            epThumb = null;
                                        }
                                        if (meta2 != null) {
                                            epDesc = meta2.getOverview();
                                        } else {
                                            epDesc = null;
                                        }
                                        if (meta2 != null) {
                                            epRating = null;
                                        } else {
                                            epRating = null;
                                        }
                                        if (meta2 != null) {
                                            epRuntime = meta2.getRuntime();
                                        } else {
                                            epRuntime = null;
                                        }
                                        if (meta2 != null) {
                                            epAirDate = meta2.getAirDateUtc();
                                        } else {
                                            epAirDate = null;
                                        }
                                        if (hasSub) {
                                            subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                                public final Object invoke(Object obj11) {
                                                    return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                                }
                                            }));
                                        } else {
                                            subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                                public final Object invoke(Object obj11) {
                                                    return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                                }
                                            }));
                                        }
                                        if (hasDub2) {
                                            dubEpisodes4.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|dub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda2
                                                public final Object invoke(Object obj11) {
                                                    return Anikoto.load$lambda$5$7(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                                }
                                            }));
                                        }
                                    }
                                    i6 = i10;
                                    epDoc = epDoc5;
                                    coroutine_suspended = obj9;
                                    $this$forEach$iv = $this$forEach$iv2;
                                    $i$f$forEach = $i$f$forEach2;
                                }
                                obj4 = coroutine_suspended;
                                url5 = url10;
                                subEpisodes3 = subEpisodes5;
                                description3 = description6;
                                subEpisodes4 = genres5;
                                i4 = i6;
                                url6 = poster4;
                                dubEpisodes3 = dubEpisodes4;
                                animeMetaData3 = animeMetaData2;
                                malId4 = malId5;
                            } else {
                                animeId2 = animeId3;
                                obj4 = coroutine_suspended;
                                String poster12 = poster3;
                                url5 = url7;
                                List list3 = subEpisodes5;
                                subEpisodes4 = genres3;
                                description3 = description4;
                                subEpisodes3 = list3;
                                animeMetaData3 = animeMetaData2;
                                title3 = title4;
                                i4 = i5;
                                dubEpisodes3 = dubEpisodes4;
                                malId4 = malId3;
                                url6 = poster12;
                            }
                            if (subEpisodes3.isEmpty()) {
                                poster6 = url6;
                                description7 = description3;
                            } else {
                                poster6 = url6;
                                description7 = description3;
                            }
                            metaAnimeData = (MetaAnimeData) animeMetaData3.element;
                            if (metaAnimeData != null) {
                                backgroundPoster = null;
                            } else {
                                backgroundPoster = null;
                            }
                            if (i4 == 0) {
                            }
                            TvType tvType4 = tvType;
                            Ref.ObjectRef animeMetaData7 = animeMetaData3;
                            obj8 = obj4;
                            Ref.ObjectRef malId8 = malId4;
                            C00025 c00027 = new C00025(poster6, backgroundPoster, description7, subEpisodes4, malId4, subEpisodes3, dubEpisodes3, null);
                            c00012.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                            c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                            c00012.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                            c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster6);
                            c00012.L$4 = SpillingKt.nullOutSpilledVariable(description7);
                            c00012.L$5 = SpillingKt.nullOutSpilledVariable(subEpisodes4);
                            c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeId2);
                            c00012.L$7 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                            c00012.L$8 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                            c00012.L$9 = SpillingKt.nullOutSpilledVariable(malId8);
                            c00012.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData7);
                            c00012.L$11 = SpillingKt.nullOutSpilledVariable(backgroundPoster);
                            c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvType4);
                            c00012.L$13 = null;
                            c00012.L$14 = null;
                            c00012.I$0 = i4;
                            c00012.label = 4;
                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title3, url5, tvType4, false, c00027, c00012, 8, (Object) null);
                            if (objNewAnimeLoadResponse$default == obj8) {
                                return obj8;
                            }
                            return objNewAnimeLoadResponse$default;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        obj2 = "";
                    }
                    break;
                } else {
                    obj4 = coroutine_suspended;
                    c00012 = c00014;
                    i4 = i2;
                    title3 = title;
                    animeMetaData3 = animeMetaData;
                    description3 = description;
                    url5 = url2;
                    dubEpisodes3 = dubEpisodes;
                    subEpisodes3 = subEpisodes;
                    malId4 = malId;
                    doc3 = doc;
                    url6 = poster;
                    subEpisodes4 = genres;
                    animeId2 = animeId;
                }
                if (subEpisodes3.isEmpty() || !dubEpisodes3.isEmpty()) {
                    poster6 = url6;
                    description7 = description3;
                } else {
                    Iterable $this$forEachIndexed$iv = doc3.select("a[href*='/ep-']");
                    int $i$f$forEachIndexed = 0;
                    final int i11 = 0;
                    for (Object item$iv : $this$forEachIndexed$iv) {
                        int index$iv = i11 + 1;
                        if (i11 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                        final Element el2 = (Element) item$iv;
                        subEpisodes3.add(MainAPIKt.newEpisode(this, MainAPIKt.fixUrl(this, el2.attr("href")), new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj11) {
                                return Anikoto.load$lambda$6$0(i11, el2, (Episode) obj11);
                            }
                        }));
                        i11 = index$iv;
                        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                        $i$f$forEachIndexed = $i$f$forEachIndexed;
                        url6 = url6;
                        description3 = description3;
                    }
                    poster6 = url6;
                    description7 = description3;
                }
                metaAnimeData = (MetaAnimeData) animeMetaData3.element;
                if (metaAnimeData != null || (images = metaAnimeData.getImages()) == null) {
                    backgroundPoster = null;
                } else {
                    Iterable $this$firstOrNull$iv = images;
                    int $i$f$firstOrNull = 0;
                    Iterator it7 = $this$firstOrNull$iv.iterator();
                    while (true) {
                        if (it7.hasNext()) {
                            element$iv = it7.next();
                            int $i$f$firstOrNull2 = $i$f$firstOrNull;
                            if (!StringsKt.equals(((ImageData) element$iv).getCoverType(), "Fanart", true)) {
                                $i$f$firstOrNull = $i$f$firstOrNull2;
                            }
                        } else {
                            element$iv = null;
                        }
                    }
                    ImageData imageData = (ImageData) element$iv;
                    if (imageData != null) {
                        backgroundPoster = imageData.getUrl();
                    } else {
                        backgroundPoster = null;
                    }
                }
                if ((i4 == 0 && !dubEpisodes3.isEmpty()) || i4 == 0) {
                    tvType = TvType.Anime;
                }
                TvType tvType5 = tvType;
                Ref.ObjectRef animeMetaData8 = animeMetaData3;
                obj8 = obj4;
                Ref.ObjectRef malId9 = malId4;
                C00025 c00028 = new C00025(poster6, backgroundPoster, description7, subEpisodes4, malId4, subEpisodes3, dubEpisodes3, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster6);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(description7);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(subEpisodes4);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeId2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData8);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(backgroundPoster);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvType5);
                c00012.L$13 = null;
                c00012.L$14 = null;
                c00012.I$0 = i4;
                c00012.label = 4;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title3, url5, tvType5, false, c00028, c00012, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj8) {
                    return obj8;
                }
                return objNewAnimeLoadResponse$default;
            case 1:
                String url14 = (String) c00014.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url14;
                obj = $result;
                doc = ((NiceResponse) obj).getDocument();
                elementSelectFirst = doc.selectFirst("#w-info h1.title, h1[itemprop=name], .title[itemprop=name]");
                if (elementSelectFirst != null) {
                    elementSelectFirst2 = doc.selectFirst("h1.title");
                    if (elementSelectFirst2 != null) {
                        break;
                    }
                    return null;
                }
                elementSelectFirst2 = doc.selectFirst("h1.title");
                if (elementSelectFirst2 != null) {
                    break;
                }
                return null;
                title = string;
                it = doc.select("#w-info .poster img, img[itemprop=image], .poster img");
                strAttr = it.attr("data-src");
                if (StringsKt.isBlank(strAttr)) {
                    strAttr = it.attr("src");
                }
                poster = strAttr;
                elementSelectFirst3 = doc.selectFirst("#w-info .synopsis .content, #w-info .synopsis, .synopsis .content");
                if (elementSelectFirst3 != null) {
                    strText2 = elementSelectFirst3.text();
                } else {
                    strText2 = null;
                }
                description = strText2;
                $this$map$iv = doc.select("#w-info a[href*='/genre/'], .meta a[href*='/genre/']");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r16.hasNext()) {
                    destination$iv$iv.add(StringsKt.trim(((Element) item$iv$iv).text()).toString());
                    $this$map$iv = $this$map$iv;
                }
                genres = (List) destination$iv$iv;
                if (doc.selectFirst("#w-info a[href*='/type/movie']") != null) {
                    i = 1;
                } else {
                    elementSelectFirst6 = doc.selectFirst(".bmeta");
                    if (elementSelectFirst6 == null) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                }
                i2 = i;
                elementSelectFirst4 = doc.selectFirst("#watch-main");
                if (elementSelectFirst4 != null) {
                    elementSelectFirst5 = doc.selectFirst("[data-id]");
                    if (elementSelectFirst5 != null) {
                        strAttr2 = elementSelectFirst5.attr("data-id");
                    } else {
                        strAttr2 = null;
                    }
                    if (strAttr2 == null) {
                        matchResultFind$default = Regex.find$default(new Regex("data-id=[\"'](\\d+)[\"']"), doc.html(), 0, 2, (Object) null);
                        if (matchResultFind$default != null) {
                            strAttr2 = null;
                        } else {
                            strAttr2 = null;
                        }
                    }
                } else {
                    elementSelectFirst5 = doc.selectFirst("[data-id]");
                    if (elementSelectFirst5 != null) {
                        strAttr2 = elementSelectFirst5.attr("data-id");
                    } else {
                        strAttr2 = null;
                    }
                    if (strAttr2 == null) {
                        matchResultFind$default = Regex.find$default(new Regex("data-id=[\"'](\\d+)[\"']"), doc.html(), 0, 2, (Object) null);
                        if (matchResultFind$default != null) {
                            strAttr2 = null;
                        } else {
                            strAttr2 = null;
                        }
                    }
                }
                animeId = strAttr2;
                subEpisodes = new ArrayList();
                dubEpisodes = new ArrayList();
                malId = new Ref.ObjectRef();
                animeMetaData = new Ref.ObjectRef();
                if (animeId != null) {
                    Result.Companion companion10 = Result.Companion;
                    $this$load_u24lambda_u242 = this;
                    Requests app6 = MainActivityKt.getApp();
                    obj2 = "";
                    String str12 = $this$load_u24lambda_u242.getMainUrl() + "/ajax/episode/list/" + animeId;
                    Map<String, String> mapAjaxHeaders2 = $this$load_u24lambda_u242.ajaxHeaders(url2);
                    c00014.L$0 = url2;
                    c00014.L$1 = doc;
                    c00014.L$2 = title;
                    c00014.L$3 = poster;
                    c00014.L$4 = description;
                    c00014.L$5 = genres;
                    c00014.L$6 = SpillingKt.nullOutSpilledVariable(animeId);
                    c00014.L$7 = subEpisodes;
                    c00014.L$8 = dubEpisodes;
                    malId3 = malId;
                    c00014.L$9 = malId3;
                    c00014.L$10 = animeMetaData;
                    dubEpisodes2 = dubEpisodes;
                    c00014.L$11 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u242);
                    c00014.L$12 = $this$load_u24lambda_u242;
                    c00014.I$0 = i2;
                    c00014.label = 2;
                    obj3 = Requests.get$default(app6, str12, mapAjaxHeaders2, url2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00014, 4088, (Object) null);
                    c00012 = c00014;
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    subEpisodes2 = subEpisodes;
                    doc2 = doc;
                    title2 = title;
                    description2 = description;
                    poster2 = poster;
                    url3 = url2;
                    genres2 = genres;
                    url4 = animeId;
                    anikoto = $this$load_u24lambda_u242;
                    i3 = i2;
                    animeMetaData2 = animeMetaData;
                    obj5 = Result.constructor-impl(anikoto.jsonResultString(((NiceResponse) obj3).getText()));
                    i5 = i3;
                    subEpisodes5 = subEpisodes2;
                    animeId3 = url4;
                    genres3 = genres2;
                    description4 = description2;
                    poster3 = poster2;
                    title4 = title2;
                    doc3 = doc2;
                    url7 = url3;
                    dubEpisodes4 = dubEpisodes2;
                    if (Result.exceptionOrNull-impl(obj5) != null) {
                        obj5 = obj2;
                    }
                    episodeListHtml = (String) obj5;
                    if (StringsKt.isBlank(episodeListHtml)) {
                        animeId2 = animeId3;
                        epDoc = Jsoup.parse(episodeListHtml);
                        elementSelectFirst7 = epDoc.selectFirst("a[data-mal]");
                        if (elementSelectFirst7 != null) {
                            intOrNull = null;
                        } else {
                            intOrNull = null;
                        }
                        malId3.element = intOrNull;
                        if (malId3.element != null) {
                            Result.Companion companion11 = Result.Companion;
                            Anikoto $this$load_u24lambda_u247 = this;
                            Requests app7 = MainActivityKt.getApp();
                            String str13 = "https://api.ani.zip/mappings?mal_id=" + ((Number) malId3.element).intValue();
                            c00012.L$0 = url7;
                            c00012.L$1 = doc3;
                            c00012.L$2 = title4;
                            c00012.L$3 = poster3;
                            c00012.L$4 = description4;
                            c00012.L$5 = genres3;
                            c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeId2);
                            c00012.L$7 = subEpisodes5;
                            c00012.L$8 = dubEpisodes4;
                            c00012.L$9 = malId3;
                            c00012.L$10 = animeMetaData2;
                            c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodeListHtml);
                            c00012.L$12 = epDoc;
                            c00012.L$13 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u247);
                            c00012.L$14 = animeMetaData2;
                            c00012.I$0 = i5;
                            c00012.label = 3;
                            title6 = title4;
                            doc5 = doc3;
                            url9 = url7;
                            poster5 = poster3;
                            c00013 = c00012;
                            obj6 = Requests.get$default(app7, str13, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                            c00012 = c00013;
                            if (obj6 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            malId5 = malId3;
                            genres4 = genres3;
                            description5 = description4;
                            animeMetaData4 = animeMetaData2;
                            title3 = title6;
                            title5 = episodeListHtml;
                            animeId4 = animeId2;
                            doc4 = doc5;
                            url8 = url9;
                            poster4 = poster5;
                            obj7 = Result.constructor-impl(AnikotoUtilsKt.parseAnimeData(((NiceResponse) obj6).getText()));
                            if (Result.isFailure-impl(obj7)) {
                                obj7 = null;
                            }
                            animeMetaData2.element = obj7;
                            i6 = i5;
                            animeMetaData2 = animeMetaData4;
                            animeId2 = animeId4;
                            genres5 = genres4;
                            description6 = description5;
                            doc3 = doc4;
                            url10 = url8;
                        } else {
                            String poster13 = poster3;
                            String url15 = url7;
                            malId5 = malId3;
                            genres5 = genres3;
                            i6 = i5;
                            title3 = title4;
                            url10 = url15;
                            poster4 = poster13;
                            description6 = description4;
                        }
                        $this$forEach$iv = epDoc.select("a[data-ids]");
                        $i$f$forEach = 0;
                        while (r10.hasNext()) {
                            int i12 = i6;
                            el = (Element) element$iv2;
                            Document epDoc6 = epDoc;
                            serverIds = el.attr("data-ids");
                            if (StringsKt.isBlank(serverIds)) {
                                serverIds = null;
                            }
                            if (serverIds == null) {
                                obj9 = coroutine_suspended;
                                $this$forEach$iv2 = $this$forEach$iv;
                                $i$f$forEach2 = $i$f$forEach;
                            } else {
                                obj9 = coroutine_suspended;
                                episodeNum = StringsKt.toIntOrNull(el.attr("data-num"));
                                $this$forEach$iv2 = $this$forEach$iv;
                                hasSub = Intrinsics.areEqual(el.attr("data-sub"), "1");
                                hasDub = Intrinsics.areEqual(el.attr("data-dub"), "1");
                                if (episodeNum != null) {
                                    int it8 = episodeNum.intValue();
                                    hasDub2 = hasDub;
                                    metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData2 != null) {
                                        meta = null;
                                    } else {
                                        meta = null;
                                    }
                                } else {
                                    hasDub2 = hasDub;
                                    meta = null;
                                }
                                if (meta != null) {
                                    meta2 = meta;
                                    if (meta2 != null) {
                                        str = null;
                                    } else {
                                        str = null;
                                    }
                                    if (str != null) {
                                        $i$f$forEach2 = $i$f$forEach;
                                        episodeName = str;
                                    } else {
                                        if (meta2 != null) {
                                            str = null;
                                        } else {
                                            str = null;
                                        }
                                        if (str == null) {
                                            elementSelectFirst8 = el.selectFirst(".d-title");
                                            if (elementSelectFirst8 != null) {
                                                str2 = null;
                                            } else {
                                                str2 = null;
                                            }
                                            if (str2 == null) {
                                                elementParent = el.parent();
                                                if (elementParent != null) {
                                                    $i$f$forEach2 = $i$f$forEach;
                                                    strAttr5 = elementParent.attr("title");
                                                    if (strAttr5 == null) {
                                                    }
                                                    if (str2 == null) {
                                                        elementSelectFirst9 = el.selectFirst(".d-title");
                                                        if (elementSelectFirst9 != null) {
                                                            str = null;
                                                        } else {
                                                            str = null;
                                                        }
                                                        if (str == null) {
                                                            StringBuilder sbAppend15 = new StringBuilder().append("Episode ");
                                                            if (episodeNum == null) {
                                                                obj10 = obj2;
                                                            } else {
                                                                obj10 = episodeNum;
                                                            }
                                                            episodeName = sbAppend15.append(obj10).toString();
                                                        }
                                                    }
                                                } else {
                                                    $i$f$forEach2 = $i$f$forEach;
                                                }
                                                str2 = null;
                                                if (str2 == null) {
                                                    elementSelectFirst9 = el.selectFirst(".d-title");
                                                    if (elementSelectFirst9 != null) {
                                                        str = null;
                                                    } else {
                                                        str = null;
                                                    }
                                                    if (str == null) {
                                                        StringBuilder sbAppend16 = new StringBuilder().append("Episode ");
                                                        if (episodeNum == null) {
                                                            obj10 = obj2;
                                                        } else {
                                                            obj10 = episodeNum;
                                                        }
                                                        episodeName = sbAppend16.append(obj10).toString();
                                                    }
                                                }
                                            } else {
                                                $i$f$forEach2 = $i$f$forEach;
                                            }
                                            episodeName = str2;
                                        } else {
                                            $i$f$forEach2 = $i$f$forEach;
                                        }
                                        episodeName = str;
                                    }
                                } else {
                                    meta2 = meta;
                                    if (meta2 != null) {
                                        str = null;
                                    } else {
                                        str = null;
                                    }
                                    if (str != null) {
                                        $i$f$forEach2 = $i$f$forEach;
                                        episodeName = str;
                                    } else {
                                        if (meta2 != null) {
                                            str = null;
                                        } else {
                                            str = null;
                                        }
                                        if (str == null) {
                                            elementSelectFirst8 = el.selectFirst(".d-title");
                                            if (elementSelectFirst8 != null) {
                                                str2 = null;
                                            } else {
                                                str2 = null;
                                            }
                                            if (str2 == null) {
                                                elementParent = el.parent();
                                                if (elementParent != null) {
                                                    $i$f$forEach2 = $i$f$forEach;
                                                    strAttr5 = elementParent.attr("title");
                                                    if (strAttr5 == null) {
                                                    }
                                                    if (str2 == null) {
                                                        elementSelectFirst9 = el.selectFirst(".d-title");
                                                        if (elementSelectFirst9 != null) {
                                                            str = null;
                                                        } else {
                                                            str = null;
                                                        }
                                                        if (str == null) {
                                                            StringBuilder sbAppend17 = new StringBuilder().append("Episode ");
                                                            if (episodeNum == null) {
                                                                obj10 = obj2;
                                                            } else {
                                                                obj10 = episodeNum;
                                                            }
                                                            episodeName = sbAppend17.append(obj10).toString();
                                                        }
                                                    }
                                                } else {
                                                    $i$f$forEach2 = $i$f$forEach;
                                                }
                                                str2 = null;
                                                if (str2 == null) {
                                                    elementSelectFirst9 = el.selectFirst(".d-title");
                                                    if (elementSelectFirst9 != null) {
                                                        str = null;
                                                    } else {
                                                        str = null;
                                                    }
                                                    if (str == null) {
                                                        StringBuilder sbAppend18 = new StringBuilder().append("Episode ");
                                                        if (episodeNum == null) {
                                                            obj10 = obj2;
                                                        } else {
                                                            obj10 = episodeNum;
                                                        }
                                                        episodeName = sbAppend18.append(obj10).toString();
                                                    }
                                                }
                                            } else {
                                                $i$f$forEach2 = $i$f$forEach;
                                            }
                                            episodeName = str2;
                                        } else {
                                            $i$f$forEach2 = $i$f$forEach;
                                        }
                                        episodeName = str;
                                    }
                                }
                                if (meta2 != null) {
                                    epThumb = meta2.getImage();
                                } else {
                                    epThumb = null;
                                }
                                if (meta2 != null) {
                                    epDesc = meta2.getOverview();
                                } else {
                                    epDesc = null;
                                }
                                if (meta2 != null) {
                                    epRating = null;
                                } else {
                                    epRating = null;
                                }
                                if (meta2 != null) {
                                    epRuntime = meta2.getRuntime();
                                } else {
                                    epRuntime = null;
                                }
                                if (meta2 != null) {
                                    epAirDate = meta2.getAirDateUtc();
                                } else {
                                    epAirDate = null;
                                }
                                if (hasSub) {
                                    subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj11) {
                                            return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                        }
                                    }));
                                } else {
                                    subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj11) {
                                            return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                        }
                                    }));
                                }
                                if (hasDub2) {
                                    dubEpisodes4.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|dub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda2
                                        public final Object invoke(Object obj11) {
                                            return Anikoto.load$lambda$5$7(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                        }
                                    }));
                                }
                            }
                            i6 = i12;
                            epDoc = epDoc6;
                            coroutine_suspended = obj9;
                            $this$forEach$iv = $this$forEach$iv2;
                            $i$f$forEach = $i$f$forEach2;
                            break;
                        }
                        obj4 = coroutine_suspended;
                        url5 = url10;
                        subEpisodes3 = subEpisodes5;
                        description3 = description6;
                        subEpisodes4 = genres5;
                        i4 = i6;
                        url6 = poster4;
                        dubEpisodes3 = dubEpisodes4;
                        animeMetaData3 = animeMetaData2;
                        malId4 = malId5;
                    } else {
                        animeId2 = animeId3;
                        obj4 = coroutine_suspended;
                        String poster14 = poster3;
                        url5 = url7;
                        List list4 = subEpisodes5;
                        subEpisodes4 = genres3;
                        description3 = description4;
                        subEpisodes3 = list4;
                        animeMetaData3 = animeMetaData2;
                        title3 = title4;
                        i4 = i5;
                        dubEpisodes3 = dubEpisodes4;
                        malId4 = malId3;
                        url6 = poster14;
                    }
                } else {
                    obj4 = coroutine_suspended;
                    c00012 = c00014;
                    i4 = i2;
                    title3 = title;
                    animeMetaData3 = animeMetaData;
                    description3 = description;
                    url5 = url2;
                    dubEpisodes3 = dubEpisodes;
                    subEpisodes3 = subEpisodes;
                    malId4 = malId;
                    doc3 = doc;
                    url6 = poster;
                    subEpisodes4 = genres;
                    animeId2 = animeId;
                }
                if (subEpisodes3.isEmpty()) {
                    poster6 = url6;
                    description7 = description3;
                } else {
                    poster6 = url6;
                    description7 = description3;
                }
                metaAnimeData = (MetaAnimeData) animeMetaData3.element;
                if (metaAnimeData != null) {
                    backgroundPoster = null;
                } else {
                    backgroundPoster = null;
                }
                if (i4 == 0) {
                }
                TvType tvType6 = tvType;
                Ref.ObjectRef animeMetaData9 = animeMetaData3;
                obj8 = obj4;
                Ref.ObjectRef malId10 = malId4;
                C00025 c00029 = new C00025(poster6, backgroundPoster, description7, subEpisodes4, malId4, subEpisodes3, dubEpisodes3, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster6);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(description7);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(subEpisodes4);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeId2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(malId10);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData9);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(backgroundPoster);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvType6);
                c00012.L$13 = null;
                c00012.L$14 = null;
                c00012.I$0 = i4;
                c00012.label = 4;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title3, url5, tvType6, false, c00029, c00012, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj8) {
                    return obj8;
                }
                return objNewAnimeLoadResponse$default;
            case 2:
                i3 = c00014.I$0;
                anikoto = (Anikoto) c00014.L$12;
                animeMetaData2 = (Ref.ObjectRef) c00014.L$10;
                malId2 = (Ref.ObjectRef) c00014.L$9;
                List dubEpisodes5 = (List) c00014.L$8;
                subEpisodes2 = (List) c00014.L$7;
                url4 = (String) c00014.L$6;
                genres2 = (List) c00014.L$5;
                description2 = (String) c00014.L$4;
                poster2 = (String) c00014.L$3;
                title2 = (String) c00014.L$2;
                doc2 = (Document) c00014.L$1;
                url3 = (String) c00014.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj2 = "";
                    dubEpisodes2 = dubEpisodes5;
                    c00012 = c00014;
                    malId3 = malId2;
                    obj3 = $result;
                    obj5 = Result.constructor-impl(anikoto.jsonResultString(((NiceResponse) obj3).getText()));
                    i5 = i3;
                    subEpisodes5 = subEpisodes2;
                    animeId3 = url4;
                    genres3 = genres2;
                    description4 = description2;
                    poster3 = poster2;
                    title4 = title2;
                    doc3 = doc2;
                    url7 = url3;
                    dubEpisodes4 = dubEpisodes2;
                } catch (Throwable th12) {
                    th = th12;
                    obj2 = "";
                    dubEpisodes2 = dubEpisodes5;
                    c00012 = c00014;
                    Result.Companion companion12 = Result.Companion;
                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                    malId3 = malId2;
                    i5 = i3;
                    subEpisodes5 = subEpisodes2;
                    animeId3 = url4;
                    genres3 = genres2;
                    description4 = description2;
                    poster3 = poster2;
                    title4 = title2;
                    doc3 = doc2;
                    url7 = url3;
                    dubEpisodes4 = dubEpisodes2;
                    if (Result.exceptionOrNull-impl(obj5) != null) {
                        obj5 = obj2;
                    }
                    episodeListHtml = (String) obj5;
                    if (StringsKt.isBlank(episodeListHtml)) {
                        animeId2 = animeId3;
                        epDoc = Jsoup.parse(episodeListHtml);
                        elementSelectFirst7 = epDoc.selectFirst("a[data-mal]");
                        if (elementSelectFirst7 != null) {
                            intOrNull = null;
                        } else {
                            intOrNull = null;
                        }
                        malId3.element = intOrNull;
                        if (malId3.element != null) {
                            Result.Companion companion13 = Result.Companion;
                            Anikoto $this$load_u24lambda_u248 = this;
                            Requests app8 = MainActivityKt.getApp();
                            String str14 = "https://api.ani.zip/mappings?mal_id=" + ((Number) malId3.element).intValue();
                            c00012.L$0 = url7;
                            c00012.L$1 = doc3;
                            c00012.L$2 = title4;
                            c00012.L$3 = poster3;
                            c00012.L$4 = description4;
                            c00012.L$5 = genres3;
                            c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeId2);
                            c00012.L$7 = subEpisodes5;
                            c00012.L$8 = dubEpisodes4;
                            c00012.L$9 = malId3;
                            c00012.L$10 = animeMetaData2;
                            c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodeListHtml);
                            c00012.L$12 = epDoc;
                            c00012.L$13 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u248);
                            c00012.L$14 = animeMetaData2;
                            c00012.I$0 = i5;
                            c00012.label = 3;
                            title6 = title4;
                            doc5 = doc3;
                            url9 = url7;
                            poster5 = poster3;
                            c00013 = c00012;
                            obj6 = Requests.get$default(app8, str14, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                            c00012 = c00013;
                            if (obj6 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            malId5 = malId3;
                            genres4 = genres3;
                            description5 = description4;
                            animeMetaData4 = animeMetaData2;
                            title3 = title6;
                            title5 = episodeListHtml;
                            animeId4 = animeId2;
                            doc4 = doc5;
                            url8 = url9;
                            poster4 = poster5;
                            obj7 = Result.constructor-impl(AnikotoUtilsKt.parseAnimeData(((NiceResponse) obj6).getText()));
                            if (Result.isFailure-impl(obj7)) {
                                obj7 = null;
                            }
                            animeMetaData2.element = obj7;
                            i6 = i5;
                            animeMetaData2 = animeMetaData4;
                            animeId2 = animeId4;
                            genres5 = genres4;
                            description6 = description5;
                            doc3 = doc4;
                            url10 = url8;
                        } else {
                            String poster15 = poster3;
                            String url16 = url7;
                            malId5 = malId3;
                            genres5 = genres3;
                            i6 = i5;
                            title3 = title4;
                            url10 = url16;
                            poster4 = poster15;
                            description6 = description4;
                        }
                        $this$forEach$iv = epDoc.select("a[data-ids]");
                        $i$f$forEach = 0;
                        while (r10.hasNext()) {
                            int i13 = i6;
                            el = (Element) element$iv2;
                            Document epDoc7 = epDoc;
                            serverIds = el.attr("data-ids");
                            if (StringsKt.isBlank(serverIds)) {
                                serverIds = null;
                            }
                            if (serverIds == null) {
                                obj9 = coroutine_suspended;
                                $this$forEach$iv2 = $this$forEach$iv;
                                $i$f$forEach2 = $i$f$forEach;
                            } else {
                                obj9 = coroutine_suspended;
                                episodeNum = StringsKt.toIntOrNull(el.attr("data-num"));
                                $this$forEach$iv2 = $this$forEach$iv;
                                hasSub = Intrinsics.areEqual(el.attr("data-sub"), "1");
                                hasDub = Intrinsics.areEqual(el.attr("data-dub"), "1");
                                if (episodeNum != null) {
                                    int it9 = episodeNum.intValue();
                                    hasDub2 = hasDub;
                                    metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                    if (metaAnimeData2 != null) {
                                        meta = null;
                                    } else {
                                        meta = null;
                                    }
                                } else {
                                    hasDub2 = hasDub;
                                    meta = null;
                                }
                                if (meta != null) {
                                    meta2 = meta;
                                    if (meta2 != null) {
                                        str = null;
                                    } else {
                                        str = null;
                                    }
                                    if (str != null) {
                                        $i$f$forEach2 = $i$f$forEach;
                                        episodeName = str;
                                    } else {
                                        if (meta2 != null) {
                                            str = null;
                                        } else {
                                            str = null;
                                        }
                                        if (str == null) {
                                            elementSelectFirst8 = el.selectFirst(".d-title");
                                            if (elementSelectFirst8 != null) {
                                                str2 = null;
                                            } else {
                                                str2 = null;
                                            }
                                            if (str2 == null) {
                                                elementParent = el.parent();
                                                if (elementParent != null) {
                                                    $i$f$forEach2 = $i$f$forEach;
                                                    strAttr5 = elementParent.attr("title");
                                                    if (strAttr5 == null) {
                                                    }
                                                    if (str2 == null) {
                                                        elementSelectFirst9 = el.selectFirst(".d-title");
                                                        if (elementSelectFirst9 != null) {
                                                            str = null;
                                                        } else {
                                                            str = null;
                                                        }
                                                        if (str == null) {
                                                            StringBuilder sbAppend19 = new StringBuilder().append("Episode ");
                                                            if (episodeNum == null) {
                                                                obj10 = obj2;
                                                            } else {
                                                                obj10 = episodeNum;
                                                            }
                                                            episodeName = sbAppend19.append(obj10).toString();
                                                        }
                                                    }
                                                } else {
                                                    $i$f$forEach2 = $i$f$forEach;
                                                }
                                                str2 = null;
                                                if (str2 == null) {
                                                    elementSelectFirst9 = el.selectFirst(".d-title");
                                                    if (elementSelectFirst9 != null) {
                                                        str = null;
                                                    } else {
                                                        str = null;
                                                    }
                                                    if (str == null) {
                                                        StringBuilder sbAppend110 = new StringBuilder().append("Episode ");
                                                        if (episodeNum == null) {
                                                            obj10 = obj2;
                                                        } else {
                                                            obj10 = episodeNum;
                                                        }
                                                        episodeName = sbAppend110.append(obj10).toString();
                                                    }
                                                }
                                            } else {
                                                $i$f$forEach2 = $i$f$forEach;
                                            }
                                            episodeName = str2;
                                        } else {
                                            $i$f$forEach2 = $i$f$forEach;
                                        }
                                        episodeName = str;
                                    }
                                } else {
                                    meta2 = meta;
                                    if (meta2 != null) {
                                        str = null;
                                    } else {
                                        str = null;
                                    }
                                    if (str != null) {
                                        $i$f$forEach2 = $i$f$forEach;
                                        episodeName = str;
                                    } else {
                                        if (meta2 != null) {
                                            str = null;
                                        } else {
                                            str = null;
                                        }
                                        if (str == null) {
                                            elementSelectFirst8 = el.selectFirst(".d-title");
                                            if (elementSelectFirst8 != null) {
                                                str2 = null;
                                            } else {
                                                str2 = null;
                                            }
                                            if (str2 == null) {
                                                elementParent = el.parent();
                                                if (elementParent != null) {
                                                    $i$f$forEach2 = $i$f$forEach;
                                                    strAttr5 = elementParent.attr("title");
                                                    if (strAttr5 == null) {
                                                    }
                                                    if (str2 == null) {
                                                        elementSelectFirst9 = el.selectFirst(".d-title");
                                                        if (elementSelectFirst9 != null) {
                                                            str = null;
                                                        } else {
                                                            str = null;
                                                        }
                                                        if (str == null) {
                                                            StringBuilder sbAppend111 = new StringBuilder().append("Episode ");
                                                            if (episodeNum == null) {
                                                                obj10 = obj2;
                                                            } else {
                                                                obj10 = episodeNum;
                                                            }
                                                            episodeName = sbAppend111.append(obj10).toString();
                                                        }
                                                    }
                                                } else {
                                                    $i$f$forEach2 = $i$f$forEach;
                                                }
                                                str2 = null;
                                                if (str2 == null) {
                                                    elementSelectFirst9 = el.selectFirst(".d-title");
                                                    if (elementSelectFirst9 != null) {
                                                        str = null;
                                                    } else {
                                                        str = null;
                                                    }
                                                    if (str == null) {
                                                        StringBuilder sbAppend112 = new StringBuilder().append("Episode ");
                                                        if (episodeNum == null) {
                                                            obj10 = obj2;
                                                        } else {
                                                            obj10 = episodeNum;
                                                        }
                                                        episodeName = sbAppend112.append(obj10).toString();
                                                    }
                                                }
                                            } else {
                                                $i$f$forEach2 = $i$f$forEach;
                                            }
                                            episodeName = str2;
                                        } else {
                                            $i$f$forEach2 = $i$f$forEach;
                                        }
                                        episodeName = str;
                                    }
                                }
                                if (meta2 != null) {
                                    epThumb = meta2.getImage();
                                } else {
                                    epThumb = null;
                                }
                                if (meta2 != null) {
                                    epDesc = meta2.getOverview();
                                } else {
                                    epDesc = null;
                                }
                                if (meta2 != null) {
                                    epRating = null;
                                } else {
                                    epRating = null;
                                }
                                if (meta2 != null) {
                                    epRuntime = meta2.getRuntime();
                                } else {
                                    epRuntime = null;
                                }
                                if (meta2 != null) {
                                    epAirDate = meta2.getAirDateUtc();
                                } else {
                                    epAirDate = null;
                                }
                                if (hasSub) {
                                    subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj11) {
                                            return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                        }
                                    }));
                                } else {
                                    subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj11) {
                                            return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                        }
                                    }));
                                }
                                if (hasDub2) {
                                    dubEpisodes4.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|dub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda2
                                        public final Object invoke(Object obj11) {
                                            return Anikoto.load$lambda$5$7(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                        }
                                    }));
                                }
                            }
                            i6 = i13;
                            epDoc = epDoc7;
                            coroutine_suspended = obj9;
                            $this$forEach$iv = $this$forEach$iv2;
                            $i$f$forEach = $i$f$forEach2;
                            break;
                        }
                        obj4 = coroutine_suspended;
                        url5 = url10;
                        subEpisodes3 = subEpisodes5;
                        description3 = description6;
                        subEpisodes4 = genres5;
                        i4 = i6;
                        url6 = poster4;
                        dubEpisodes3 = dubEpisodes4;
                        animeMetaData3 = animeMetaData2;
                        malId4 = malId5;
                    } else {
                        animeId2 = animeId3;
                        obj4 = coroutine_suspended;
                        String poster16 = poster3;
                        url5 = url7;
                        List list5 = subEpisodes5;
                        subEpisodes4 = genres3;
                        description3 = description4;
                        subEpisodes3 = list5;
                        animeMetaData3 = animeMetaData2;
                        title3 = title4;
                        i4 = i5;
                        dubEpisodes3 = dubEpisodes4;
                        malId4 = malId3;
                        url6 = poster16;
                    }
                    if (subEpisodes3.isEmpty()) {
                        poster6 = url6;
                        description7 = description3;
                    } else {
                        poster6 = url6;
                        description7 = description3;
                    }
                    metaAnimeData = (MetaAnimeData) animeMetaData3.element;
                    if (metaAnimeData != null) {
                        backgroundPoster = null;
                    } else {
                        backgroundPoster = null;
                    }
                    if (i4 == 0) {
                    }
                    TvType tvType7 = tvType;
                    Ref.ObjectRef animeMetaData10 = animeMetaData3;
                    obj8 = obj4;
                    Ref.ObjectRef malId11 = malId4;
                    C00025 c000210 = new C00025(poster6, backgroundPoster, description7, subEpisodes4, malId4, subEpisodes3, dubEpisodes3, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster6);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(description7);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(subEpisodes4);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeId2);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(malId11);
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData10);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(backgroundPoster);
                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvType7);
                    c00012.L$13 = null;
                    c00012.L$14 = null;
                    c00012.I$0 = i4;
                    c00012.label = 4;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title3, url5, tvType7, false, c000210, c00012, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj8) {
                        return obj8;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                if (Result.exceptionOrNull-impl(obj5) != null) {
                    obj5 = obj2;
                }
                episodeListHtml = (String) obj5;
                if (StringsKt.isBlank(episodeListHtml)) {
                    animeId2 = animeId3;
                    epDoc = Jsoup.parse(episodeListHtml);
                    elementSelectFirst7 = epDoc.selectFirst("a[data-mal]");
                    if (elementSelectFirst7 != null) {
                        intOrNull = null;
                    } else {
                        intOrNull = null;
                    }
                    malId3.element = intOrNull;
                    if (malId3.element != null) {
                        Result.Companion companion14 = Result.Companion;
                        Anikoto $this$load_u24lambda_u249 = this;
                        Requests app9 = MainActivityKt.getApp();
                        String str15 = "https://api.ani.zip/mappings?mal_id=" + ((Number) malId3.element).intValue();
                        c00012.L$0 = url7;
                        c00012.L$1 = doc3;
                        c00012.L$2 = title4;
                        c00012.L$3 = poster3;
                        c00012.L$4 = description4;
                        c00012.L$5 = genres3;
                        c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeId2);
                        c00012.L$7 = subEpisodes5;
                        c00012.L$8 = dubEpisodes4;
                        c00012.L$9 = malId3;
                        c00012.L$10 = animeMetaData2;
                        c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodeListHtml);
                        c00012.L$12 = epDoc;
                        c00012.L$13 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u249);
                        c00012.L$14 = animeMetaData2;
                        c00012.I$0 = i5;
                        c00012.label = 3;
                        title6 = title4;
                        doc5 = doc3;
                        url9 = url7;
                        poster5 = poster3;
                        c00013 = c00012;
                        obj6 = Requests.get$default(app9, str15, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                        c00012 = c00013;
                        if (obj6 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        malId5 = malId3;
                        genres4 = genres3;
                        description5 = description4;
                        animeMetaData4 = animeMetaData2;
                        title3 = title6;
                        title5 = episodeListHtml;
                        animeId4 = animeId2;
                        doc4 = doc5;
                        url8 = url9;
                        poster4 = poster5;
                        obj7 = Result.constructor-impl(AnikotoUtilsKt.parseAnimeData(((NiceResponse) obj6).getText()));
                        if (Result.isFailure-impl(obj7)) {
                            obj7 = null;
                        }
                        animeMetaData2.element = obj7;
                        i6 = i5;
                        animeMetaData2 = animeMetaData4;
                        animeId2 = animeId4;
                        genres5 = genres4;
                        description6 = description5;
                        doc3 = doc4;
                        url10 = url8;
                    } else {
                        String poster17 = poster3;
                        String url17 = url7;
                        malId5 = malId3;
                        genres5 = genres3;
                        i6 = i5;
                        title3 = title4;
                        url10 = url17;
                        poster4 = poster17;
                        description6 = description4;
                    }
                    $this$forEach$iv = epDoc.select("a[data-ids]");
                    $i$f$forEach = 0;
                    while (r10.hasNext()) {
                        int i14 = i6;
                        el = (Element) element$iv2;
                        Document epDoc8 = epDoc;
                        serverIds = el.attr("data-ids");
                        if (StringsKt.isBlank(serverIds)) {
                            serverIds = null;
                        }
                        if (serverIds == null) {
                            obj9 = coroutine_suspended;
                            $this$forEach$iv2 = $this$forEach$iv;
                            $i$f$forEach2 = $i$f$forEach;
                        } else {
                            obj9 = coroutine_suspended;
                            episodeNum = StringsKt.toIntOrNull(el.attr("data-num"));
                            $this$forEach$iv2 = $this$forEach$iv;
                            hasSub = Intrinsics.areEqual(el.attr("data-sub"), "1");
                            hasDub = Intrinsics.areEqual(el.attr("data-dub"), "1");
                            if (episodeNum != null) {
                                int it10 = episodeNum.intValue();
                                hasDub2 = hasDub;
                                metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData2 != null) {
                                    meta = null;
                                } else {
                                    meta = null;
                                }
                            } else {
                                hasDub2 = hasDub;
                                meta = null;
                            }
                            if (meta != null) {
                                meta2 = meta;
                                if (meta2 != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                    $i$f$forEach2 = $i$f$forEach;
                                    episodeName = str;
                                } else {
                                    if (meta2 != null) {
                                        str = null;
                                    } else {
                                        str = null;
                                    }
                                    if (str == null) {
                                        elementSelectFirst8 = el.selectFirst(".d-title");
                                        if (elementSelectFirst8 != null) {
                                            str2 = null;
                                        } else {
                                            str2 = null;
                                        }
                                        if (str2 == null) {
                                            elementParent = el.parent();
                                            if (elementParent != null) {
                                                $i$f$forEach2 = $i$f$forEach;
                                                strAttr5 = elementParent.attr("title");
                                                if (strAttr5 == null) {
                                                }
                                                if (str2 == null) {
                                                    elementSelectFirst9 = el.selectFirst(".d-title");
                                                    if (elementSelectFirst9 != null) {
                                                        str = null;
                                                    } else {
                                                        str = null;
                                                    }
                                                    if (str == null) {
                                                        StringBuilder sbAppend113 = new StringBuilder().append("Episode ");
                                                        if (episodeNum == null) {
                                                            obj10 = obj2;
                                                        } else {
                                                            obj10 = episodeNum;
                                                        }
                                                        episodeName = sbAppend113.append(obj10).toString();
                                                    }
                                                }
                                            } else {
                                                $i$f$forEach2 = $i$f$forEach;
                                            }
                                            str2 = null;
                                            if (str2 == null) {
                                                elementSelectFirst9 = el.selectFirst(".d-title");
                                                if (elementSelectFirst9 != null) {
                                                    str = null;
                                                } else {
                                                    str = null;
                                                }
                                                if (str == null) {
                                                    StringBuilder sbAppend114 = new StringBuilder().append("Episode ");
                                                    if (episodeNum == null) {
                                                        obj10 = obj2;
                                                    } else {
                                                        obj10 = episodeNum;
                                                    }
                                                    episodeName = sbAppend114.append(obj10).toString();
                                                }
                                            }
                                        } else {
                                            $i$f$forEach2 = $i$f$forEach;
                                        }
                                        episodeName = str2;
                                    } else {
                                        $i$f$forEach2 = $i$f$forEach;
                                    }
                                    episodeName = str;
                                }
                            } else {
                                meta2 = meta;
                                if (meta2 != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                    $i$f$forEach2 = $i$f$forEach;
                                    episodeName = str;
                                } else {
                                    if (meta2 != null) {
                                        str = null;
                                    } else {
                                        str = null;
                                    }
                                    if (str == null) {
                                        elementSelectFirst8 = el.selectFirst(".d-title");
                                        if (elementSelectFirst8 != null) {
                                            str2 = null;
                                        } else {
                                            str2 = null;
                                        }
                                        if (str2 == null) {
                                            elementParent = el.parent();
                                            if (elementParent != null) {
                                                $i$f$forEach2 = $i$f$forEach;
                                                strAttr5 = elementParent.attr("title");
                                                if (strAttr5 == null) {
                                                }
                                                if (str2 == null) {
                                                    elementSelectFirst9 = el.selectFirst(".d-title");
                                                    if (elementSelectFirst9 != null) {
                                                        str = null;
                                                    } else {
                                                        str = null;
                                                    }
                                                    if (str == null) {
                                                        StringBuilder sbAppend115 = new StringBuilder().append("Episode ");
                                                        if (episodeNum == null) {
                                                            obj10 = obj2;
                                                        } else {
                                                            obj10 = episodeNum;
                                                        }
                                                        episodeName = sbAppend115.append(obj10).toString();
                                                    }
                                                }
                                            } else {
                                                $i$f$forEach2 = $i$f$forEach;
                                            }
                                            str2 = null;
                                            if (str2 == null) {
                                                elementSelectFirst9 = el.selectFirst(".d-title");
                                                if (elementSelectFirst9 != null) {
                                                    str = null;
                                                } else {
                                                    str = null;
                                                }
                                                if (str == null) {
                                                    StringBuilder sbAppend116 = new StringBuilder().append("Episode ");
                                                    if (episodeNum == null) {
                                                        obj10 = obj2;
                                                    } else {
                                                        obj10 = episodeNum;
                                                    }
                                                    episodeName = sbAppend116.append(obj10).toString();
                                                }
                                            }
                                        } else {
                                            $i$f$forEach2 = $i$f$forEach;
                                        }
                                        episodeName = str2;
                                    } else {
                                        $i$f$forEach2 = $i$f$forEach;
                                    }
                                    episodeName = str;
                                }
                            }
                            if (meta2 != null) {
                                epThumb = meta2.getImage();
                            } else {
                                epThumb = null;
                            }
                            if (meta2 != null) {
                                epDesc = meta2.getOverview();
                            } else {
                                epDesc = null;
                            }
                            if (meta2 != null) {
                                epRating = null;
                            } else {
                                epRating = null;
                            }
                            if (meta2 != null) {
                                epRuntime = meta2.getRuntime();
                            } else {
                                epRuntime = null;
                            }
                            if (meta2 != null) {
                                epAirDate = meta2.getAirDateUtc();
                            } else {
                                epAirDate = null;
                            }
                            if (hasSub) {
                                subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj11) {
                                        return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                    }
                                }));
                            } else {
                                subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj11) {
                                        return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                    }
                                }));
                            }
                            if (hasDub2) {
                                dubEpisodes4.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|dub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj11) {
                                        return Anikoto.load$lambda$5$7(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                    }
                                }));
                            }
                        }
                        i6 = i14;
                        epDoc = epDoc8;
                        coroutine_suspended = obj9;
                        $this$forEach$iv = $this$forEach$iv2;
                        $i$f$forEach = $i$f$forEach2;
                        break;
                    }
                    obj4 = coroutine_suspended;
                    url5 = url10;
                    subEpisodes3 = subEpisodes5;
                    description3 = description6;
                    subEpisodes4 = genres5;
                    i4 = i6;
                    url6 = poster4;
                    dubEpisodes3 = dubEpisodes4;
                    animeMetaData3 = animeMetaData2;
                    malId4 = malId5;
                } else {
                    animeId2 = animeId3;
                    obj4 = coroutine_suspended;
                    String poster18 = poster3;
                    url5 = url7;
                    List list6 = subEpisodes5;
                    subEpisodes4 = genres3;
                    description3 = description4;
                    subEpisodes3 = list6;
                    animeMetaData3 = animeMetaData2;
                    title3 = title4;
                    i4 = i5;
                    dubEpisodes3 = dubEpisodes4;
                    malId4 = malId3;
                    url6 = poster18;
                }
                if (subEpisodes3.isEmpty()) {
                    poster6 = url6;
                    description7 = description3;
                } else {
                    poster6 = url6;
                    description7 = description3;
                }
                metaAnimeData = (MetaAnimeData) animeMetaData3.element;
                if (metaAnimeData != null) {
                    backgroundPoster = null;
                } else {
                    backgroundPoster = null;
                }
                if (i4 == 0) {
                }
                TvType tvType8 = tvType;
                Ref.ObjectRef animeMetaData11 = animeMetaData3;
                obj8 = obj4;
                Ref.ObjectRef malId12 = malId4;
                C00025 c000211 = new C00025(poster6, backgroundPoster, description7, subEpisodes4, malId4, subEpisodes3, dubEpisodes3, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster6);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(description7);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(subEpisodes4);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeId2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(malId12);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData11);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(backgroundPoster);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvType8);
                c00012.L$13 = null;
                c00012.L$14 = null;
                c00012.I$0 = i4;
                c00012.label = 4;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title3, url5, tvType8, false, c000211, c00012, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj8) {
                    return obj8;
                }
                return objNewAnimeLoadResponse$default;
            case 3:
                i5 = c00014.I$0;
                animeMetaData2 = (Ref.ObjectRef) c00014.L$14;
                Document epDoc9 = (Document) c00014.L$12;
                title5 = (String) c00014.L$11;
                animeMetaData4 = (Ref.ObjectRef) c00014.L$10;
                malId5 = (Ref.ObjectRef) c00014.L$9;
                dubEpisodes4 = (List) c00014.L$8;
                subEpisodes5 = (List) c00014.L$7;
                animeId4 = (String) c00014.L$6;
                genres4 = (List) c00014.L$5;
                description5 = (String) c00014.L$4;
                poster4 = (String) c00014.L$3;
                title3 = (String) c00014.L$2;
                doc4 = (Document) c00014.L$1;
                url8 = (String) c00014.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj6 = $result;
                    obj2 = "";
                    epDoc = epDoc9;
                    c00012 = c00014;
                    obj7 = Result.constructor-impl(AnikotoUtilsKt.parseAnimeData(((NiceResponse) obj6).getText()));
                    break;
                } catch (Throwable th13) {
                    th = th13;
                    obj2 = "";
                    epDoc = epDoc9;
                    c00012 = c00014;
                    Result.Companion companion15 = Result.Companion;
                    obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.isFailure-impl(obj7)) {
                        obj7 = null;
                    }
                    animeMetaData2.element = obj7;
                    i6 = i5;
                    animeMetaData2 = animeMetaData4;
                    animeId2 = animeId4;
                    genres5 = genres4;
                    description6 = description5;
                    doc3 = doc4;
                    url10 = url8;
                    $this$forEach$iv = epDoc.select("a[data-ids]");
                    $i$f$forEach = 0;
                    while (r10.hasNext()) {
                        int i15 = i6;
                        el = (Element) element$iv2;
                        Document epDoc10 = epDoc;
                        serverIds = el.attr("data-ids");
                        if (StringsKt.isBlank(serverIds)) {
                            serverIds = null;
                        }
                        if (serverIds == null) {
                            obj9 = coroutine_suspended;
                            $this$forEach$iv2 = $this$forEach$iv;
                            $i$f$forEach2 = $i$f$forEach;
                        } else {
                            obj9 = coroutine_suspended;
                            episodeNum = StringsKt.toIntOrNull(el.attr("data-num"));
                            $this$forEach$iv2 = $this$forEach$iv;
                            hasSub = Intrinsics.areEqual(el.attr("data-sub"), "1");
                            hasDub = Intrinsics.areEqual(el.attr("data-dub"), "1");
                            if (episodeNum != null) {
                                int it11 = episodeNum.intValue();
                                hasDub2 = hasDub;
                                metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                                if (metaAnimeData2 != null) {
                                    meta = null;
                                } else {
                                    meta = null;
                                }
                            } else {
                                hasDub2 = hasDub;
                                meta = null;
                            }
                            if (meta != null) {
                                meta2 = meta;
                                if (meta2 != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                    $i$f$forEach2 = $i$f$forEach;
                                    episodeName = str;
                                } else {
                                    if (meta2 != null) {
                                        str = null;
                                    } else {
                                        str = null;
                                    }
                                    if (str == null) {
                                        elementSelectFirst8 = el.selectFirst(".d-title");
                                        if (elementSelectFirst8 != null) {
                                            str2 = null;
                                        } else {
                                            str2 = null;
                                        }
                                        if (str2 == null) {
                                            elementParent = el.parent();
                                            if (elementParent != null) {
                                                $i$f$forEach2 = $i$f$forEach;
                                                strAttr5 = elementParent.attr("title");
                                                if (strAttr5 == null) {
                                                }
                                                if (str2 == null) {
                                                    elementSelectFirst9 = el.selectFirst(".d-title");
                                                    if (elementSelectFirst9 != null) {
                                                        str = null;
                                                    } else {
                                                        str = null;
                                                    }
                                                    if (str == null) {
                                                        StringBuilder sbAppend117 = new StringBuilder().append("Episode ");
                                                        if (episodeNum == null) {
                                                            obj10 = obj2;
                                                        } else {
                                                            obj10 = episodeNum;
                                                        }
                                                        episodeName = sbAppend117.append(obj10).toString();
                                                    }
                                                }
                                            } else {
                                                $i$f$forEach2 = $i$f$forEach;
                                            }
                                            str2 = null;
                                            if (str2 == null) {
                                                elementSelectFirst9 = el.selectFirst(".d-title");
                                                if (elementSelectFirst9 != null) {
                                                    str = null;
                                                } else {
                                                    str = null;
                                                }
                                                if (str == null) {
                                                    StringBuilder sbAppend118 = new StringBuilder().append("Episode ");
                                                    if (episodeNum == null) {
                                                        obj10 = obj2;
                                                    } else {
                                                        obj10 = episodeNum;
                                                    }
                                                    episodeName = sbAppend118.append(obj10).toString();
                                                }
                                            }
                                        } else {
                                            $i$f$forEach2 = $i$f$forEach;
                                        }
                                        episodeName = str2;
                                    } else {
                                        $i$f$forEach2 = $i$f$forEach;
                                    }
                                    episodeName = str;
                                }
                            } else {
                                meta2 = meta;
                                if (meta2 != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                    $i$f$forEach2 = $i$f$forEach;
                                    episodeName = str;
                                } else {
                                    if (meta2 != null) {
                                        str = null;
                                    } else {
                                        str = null;
                                    }
                                    if (str == null) {
                                        elementSelectFirst8 = el.selectFirst(".d-title");
                                        if (elementSelectFirst8 != null) {
                                            str2 = null;
                                        } else {
                                            str2 = null;
                                        }
                                        if (str2 == null) {
                                            elementParent = el.parent();
                                            if (elementParent != null) {
                                                $i$f$forEach2 = $i$f$forEach;
                                                strAttr5 = elementParent.attr("title");
                                                if (strAttr5 == null) {
                                                }
                                                if (str2 == null) {
                                                    elementSelectFirst9 = el.selectFirst(".d-title");
                                                    if (elementSelectFirst9 != null) {
                                                        str = null;
                                                    } else {
                                                        str = null;
                                                    }
                                                    if (str == null) {
                                                        StringBuilder sbAppend119 = new StringBuilder().append("Episode ");
                                                        if (episodeNum == null) {
                                                            obj10 = obj2;
                                                        } else {
                                                            obj10 = episodeNum;
                                                        }
                                                        episodeName = sbAppend119.append(obj10).toString();
                                                    }
                                                }
                                            } else {
                                                $i$f$forEach2 = $i$f$forEach;
                                            }
                                            str2 = null;
                                            if (str2 == null) {
                                                elementSelectFirst9 = el.selectFirst(".d-title");
                                                if (elementSelectFirst9 != null) {
                                                    str = null;
                                                } else {
                                                    str = null;
                                                }
                                                if (str == null) {
                                                    StringBuilder sbAppend1110 = new StringBuilder().append("Episode ");
                                                    if (episodeNum == null) {
                                                        obj10 = obj2;
                                                    } else {
                                                        obj10 = episodeNum;
                                                    }
                                                    episodeName = sbAppend1110.append(obj10).toString();
                                                }
                                            }
                                        } else {
                                            $i$f$forEach2 = $i$f$forEach;
                                        }
                                        episodeName = str2;
                                    } else {
                                        $i$f$forEach2 = $i$f$forEach;
                                    }
                                    episodeName = str;
                                }
                            }
                            if (meta2 != null) {
                                epThumb = meta2.getImage();
                            } else {
                                epThumb = null;
                            }
                            if (meta2 != null) {
                                epDesc = meta2.getOverview();
                            } else {
                                epDesc = null;
                            }
                            if (meta2 != null) {
                                epRating = null;
                            } else {
                                epRating = null;
                            }
                            if (meta2 != null) {
                                epRuntime = meta2.getRuntime();
                            } else {
                                epRuntime = null;
                            }
                            if (meta2 != null) {
                                epAirDate = meta2.getAirDateUtc();
                            } else {
                                epAirDate = null;
                            }
                            if (hasSub) {
                                subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj11) {
                                        return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                    }
                                }));
                            } else {
                                subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj11) {
                                        return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                    }
                                }));
                            }
                            if (hasDub2) {
                                dubEpisodes4.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|dub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj11) {
                                        return Anikoto.load$lambda$5$7(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                    }
                                }));
                            }
                        }
                        i6 = i15;
                        epDoc = epDoc10;
                        coroutine_suspended = obj9;
                        $this$forEach$iv = $this$forEach$iv2;
                        $i$f$forEach = $i$f$forEach2;
                        break;
                    }
                    obj4 = coroutine_suspended;
                    url5 = url10;
                    subEpisodes3 = subEpisodes5;
                    description3 = description6;
                    subEpisodes4 = genres5;
                    i4 = i6;
                    url6 = poster4;
                    dubEpisodes3 = dubEpisodes4;
                    animeMetaData3 = animeMetaData2;
                    malId4 = malId5;
                    if (subEpisodes3.isEmpty()) {
                        poster6 = url6;
                        description7 = description3;
                    } else {
                        poster6 = url6;
                        description7 = description3;
                    }
                    metaAnimeData = (MetaAnimeData) animeMetaData3.element;
                    if (metaAnimeData != null) {
                        backgroundPoster = null;
                    } else {
                        backgroundPoster = null;
                    }
                    if (i4 == 0) {
                    }
                    TvType tvType9 = tvType;
                    Ref.ObjectRef animeMetaData12 = animeMetaData3;
                    obj8 = obj4;
                    Ref.ObjectRef malId13 = malId4;
                    C00025 c000212 = new C00025(poster6, backgroundPoster, description7, subEpisodes4, malId4, subEpisodes3, dubEpisodes3, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster6);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(description7);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(subEpisodes4);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeId2);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(malId13);
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData12);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(backgroundPoster);
                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvType9);
                    c00012.L$13 = null;
                    c00012.L$14 = null;
                    c00012.I$0 = i4;
                    c00012.label = 4;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title3, url5, tvType9, false, c000212, c00012, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj8) {
                        return obj8;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                if (Result.isFailure-impl(obj7)) {
                    obj7 = null;
                }
                animeMetaData2.element = obj7;
                i6 = i5;
                animeMetaData2 = animeMetaData4;
                animeId2 = animeId4;
                genres5 = genres4;
                description6 = description5;
                doc3 = doc4;
                url10 = url8;
                $this$forEach$iv = epDoc.select("a[data-ids]");
                $i$f$forEach = 0;
                while (r10.hasNext()) {
                    int i16 = i6;
                    el = (Element) element$iv2;
                    Document epDoc11 = epDoc;
                    serverIds = el.attr("data-ids");
                    if (StringsKt.isBlank(serverIds)) {
                        serverIds = null;
                    }
                    if (serverIds == null) {
                        obj9 = coroutine_suspended;
                        $this$forEach$iv2 = $this$forEach$iv;
                        $i$f$forEach2 = $i$f$forEach;
                    } else {
                        obj9 = coroutine_suspended;
                        episodeNum = StringsKt.toIntOrNull(el.attr("data-num"));
                        $this$forEach$iv2 = $this$forEach$iv;
                        hasSub = Intrinsics.areEqual(el.attr("data-sub"), "1");
                        hasDub = Intrinsics.areEqual(el.attr("data-dub"), "1");
                        if (episodeNum != null) {
                            int it12 = episodeNum.intValue();
                            hasDub2 = hasDub;
                            metaAnimeData2 = (MetaAnimeData) animeMetaData2.element;
                            if (metaAnimeData2 != null) {
                                meta = null;
                            } else {
                                meta = null;
                            }
                        } else {
                            hasDub2 = hasDub;
                            meta = null;
                        }
                        if (meta != null) {
                            meta2 = meta;
                            if (meta2 != null) {
                                str = null;
                            } else {
                                str = null;
                            }
                            if (str != null) {
                                $i$f$forEach2 = $i$f$forEach;
                                episodeName = str;
                            } else {
                                if (meta2 != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                if (str == null) {
                                    elementSelectFirst8 = el.selectFirst(".d-title");
                                    if (elementSelectFirst8 != null) {
                                        str2 = null;
                                    } else {
                                        str2 = null;
                                    }
                                    if (str2 == null) {
                                        elementParent = el.parent();
                                        if (elementParent != null) {
                                            $i$f$forEach2 = $i$f$forEach;
                                            strAttr5 = elementParent.attr("title");
                                            if (strAttr5 == null) {
                                            }
                                            if (str2 == null) {
                                                elementSelectFirst9 = el.selectFirst(".d-title");
                                                if (elementSelectFirst9 != null) {
                                                    str = null;
                                                } else {
                                                    str = null;
                                                }
                                                if (str == null) {
                                                    StringBuilder sbAppend1111 = new StringBuilder().append("Episode ");
                                                    if (episodeNum == null) {
                                                        obj10 = obj2;
                                                    } else {
                                                        obj10 = episodeNum;
                                                    }
                                                    episodeName = sbAppend1111.append(obj10).toString();
                                                }
                                            }
                                        } else {
                                            $i$f$forEach2 = $i$f$forEach;
                                        }
                                        str2 = null;
                                        if (str2 == null) {
                                            elementSelectFirst9 = el.selectFirst(".d-title");
                                            if (elementSelectFirst9 != null) {
                                                str = null;
                                            } else {
                                                str = null;
                                            }
                                            if (str == null) {
                                                StringBuilder sbAppend1112 = new StringBuilder().append("Episode ");
                                                if (episodeNum == null) {
                                                    obj10 = obj2;
                                                } else {
                                                    obj10 = episodeNum;
                                                }
                                                episodeName = sbAppend1112.append(obj10).toString();
                                            }
                                        }
                                    } else {
                                        $i$f$forEach2 = $i$f$forEach;
                                    }
                                    episodeName = str2;
                                } else {
                                    $i$f$forEach2 = $i$f$forEach;
                                }
                                episodeName = str;
                            }
                        } else {
                            meta2 = meta;
                            if (meta2 != null) {
                                str = null;
                            } else {
                                str = null;
                            }
                            if (str != null) {
                                $i$f$forEach2 = $i$f$forEach;
                                episodeName = str;
                            } else {
                                if (meta2 != null) {
                                    str = null;
                                } else {
                                    str = null;
                                }
                                if (str == null) {
                                    elementSelectFirst8 = el.selectFirst(".d-title");
                                    if (elementSelectFirst8 != null) {
                                        str2 = null;
                                    } else {
                                        str2 = null;
                                    }
                                    if (str2 == null) {
                                        elementParent = el.parent();
                                        if (elementParent != null) {
                                            $i$f$forEach2 = $i$f$forEach;
                                            strAttr5 = elementParent.attr("title");
                                            if (strAttr5 == null) {
                                            }
                                            if (str2 == null) {
                                                elementSelectFirst9 = el.selectFirst(".d-title");
                                                if (elementSelectFirst9 != null) {
                                                    str = null;
                                                } else {
                                                    str = null;
                                                }
                                                if (str == null) {
                                                    StringBuilder sbAppend1113 = new StringBuilder().append("Episode ");
                                                    if (episodeNum == null) {
                                                        obj10 = obj2;
                                                    } else {
                                                        obj10 = episodeNum;
                                                    }
                                                    episodeName = sbAppend1113.append(obj10).toString();
                                                }
                                            }
                                        } else {
                                            $i$f$forEach2 = $i$f$forEach;
                                        }
                                        str2 = null;
                                        if (str2 == null) {
                                            elementSelectFirst9 = el.selectFirst(".d-title");
                                            if (elementSelectFirst9 != null) {
                                                str = null;
                                            } else {
                                                str = null;
                                            }
                                            if (str == null) {
                                                StringBuilder sbAppend1114 = new StringBuilder().append("Episode ");
                                                if (episodeNum == null) {
                                                    obj10 = obj2;
                                                } else {
                                                    obj10 = episodeNum;
                                                }
                                                episodeName = sbAppend1114.append(obj10).toString();
                                            }
                                        }
                                    } else {
                                        $i$f$forEach2 = $i$f$forEach;
                                    }
                                    episodeName = str2;
                                } else {
                                    $i$f$forEach2 = $i$f$forEach;
                                }
                                episodeName = str;
                            }
                        }
                        if (meta2 != null) {
                            epThumb = meta2.getImage();
                        } else {
                            epThumb = null;
                        }
                        if (meta2 != null) {
                            epDesc = meta2.getOverview();
                        } else {
                            epDesc = null;
                        }
                        if (meta2 != null) {
                            epRating = null;
                        } else {
                            epRating = null;
                        }
                        if (meta2 != null) {
                            epRuntime = meta2.getRuntime();
                        } else {
                            epRuntime = null;
                        }
                        if (meta2 != null) {
                            epAirDate = meta2.getAirDateUtc();
                        } else {
                            epAirDate = null;
                        }
                        if (hasSub) {
                            subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj11) {
                                    return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                }
                            }));
                        } else {
                            subEpisodes5.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj11) {
                                    return Anikoto.load$lambda$5$6(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                }
                            }));
                        }
                        if (hasDub2) {
                            dubEpisodes4.add(MainAPIKt.newEpisode(this, "anikoto|" + url10 + '|' + serverIds + "|dub", new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj11) {
                                    return Anikoto.load$lambda$5$7(episodeNum, episodeName, epThumb, epDesc, epRating, epRuntime, epAirDate, (Episode) obj11);
                                }
                            }));
                        }
                    }
                    i6 = i16;
                    epDoc = epDoc11;
                    coroutine_suspended = obj9;
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach2;
                    break;
                }
                obj4 = coroutine_suspended;
                url5 = url10;
                subEpisodes3 = subEpisodes5;
                description3 = description6;
                subEpisodes4 = genres5;
                i4 = i6;
                url6 = poster4;
                dubEpisodes3 = dubEpisodes4;
                animeMetaData3 = animeMetaData2;
                malId4 = malId5;
                if (subEpisodes3.isEmpty()) {
                    poster6 = url6;
                    description7 = description3;
                } else {
                    poster6 = url6;
                    description7 = description3;
                }
                metaAnimeData = (MetaAnimeData) animeMetaData3.element;
                if (metaAnimeData != null) {
                    backgroundPoster = null;
                } else {
                    backgroundPoster = null;
                }
                if (i4 == 0) {
                }
                TvType tvType10 = tvType;
                Ref.ObjectRef animeMetaData13 = animeMetaData3;
                obj8 = obj4;
                Ref.ObjectRef malId14 = malId4;
                C00025 c000213 = new C00025(poster6, backgroundPoster, description7, subEpisodes4, malId4, subEpisodes3, dubEpisodes3, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster6);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(description7);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(subEpisodes4);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeId2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(malId14);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData13);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(backgroundPoster);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvType10);
                c00012.L$13 = null;
                c00012.L$14 = null;
                c00012.I$0 = i4;
                c00012.label = 4;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title3, url5, tvType10, false, c000213, c00012, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj8) {
                    return obj8;
                }
                return objNewAnimeLoadResponse$default;
            case 4:
                int i17 = c00014.I$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$5$6(Integer $episodeNum, String $episodeName, String $epThumb, String $epDesc, Score $epRating, Integer $epRuntime, String $epAirDate, Episode $this$newEpisode) {
        $this$newEpisode.setEpisode($episodeNum);
        $this$newEpisode.setName($episodeName);
        $this$newEpisode.setPosterUrl($epThumb);
        $this$newEpisode.setDescription($epDesc);
        $this$newEpisode.setScore($epRating);
        $this$newEpisode.setRunTime($epRuntime);
        MainAPIKt.addDate$default($this$newEpisode, $epAirDate, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$5$7(Integer $episodeNum, String $episodeName, String $epThumb, String $epDesc, Score $epRating, Integer $epRuntime, String $epAirDate, Episode $this$newEpisode) {
        $this$newEpisode.setEpisode($episodeNum);
        $this$newEpisode.setName($episodeName);
        $this$newEpisode.setPosterUrl($epThumb);
        $this$newEpisode.setDescription($epDesc);
        $this$newEpisode.setScore($epRating);
        $this$newEpisode.setRunTime($epRuntime);
        MainAPIKt.addDate$default($this$newEpisode, $epAirDate, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$6$0(int $i, Element $el, Episode $this$newEpisode) {
        $this$newEpisode.setEpisode(Integer.valueOf($i + 1));
        String strText = $el.text();
        if (StringsKt.isBlank(strText)) {
            strText = "Episode " + ($i + 1);
        }
        $this$newEpisode.setName(strText);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.anikoto.Anikoto$load$5 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.Anikoto$load$5", f = "AnikotoProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00025 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $backgroundPoster;
        final /* synthetic */ String $description;
        final /* synthetic */ List<Episode> $dubEpisodes;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ Ref.ObjectRef<Integer> $malId;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<Episode> $subEpisodes;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00025(String str, String str2, String str3, List<String> list, Ref.ObjectRef<Integer> objectRef, List<Episode> list2, List<Episode> list3, Continuation<? super C00025> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$backgroundPoster = str2;
            this.$description = str3;
            this.$genres = list;
            this.$malId = objectRef;
            this.$subEpisodes = list2;
            this.$dubEpisodes = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00025 = Anikoto.this.new C00025(this.$poster, this.$backgroundPoster, this.$description, this.$genres, this.$malId, this.$subEpisodes, this.$dubEpisodes, continuation);
            c00025.L$0 = obj;
            return c00025;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(MainAPIKt.fixUrl(Anikoto.this, this.$poster));
                    loadResponse.setBackgroundPosterUrl(this.$backgroundPoster);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$genres);
                    LoadResponse.Companion.addMalId(loadResponse, (Integer) this.$malId.element);
                    if (!this.$subEpisodes.isEmpty()) {
                        MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$subEpisodes);
                    }
                    if (!this.$dubEpisodes.isEmpty()) {
                        MainAPIKt.addEpisodes(loadResponse, DubStatus.Dubbed, this.$dubEpisodes);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0325  */
    /* JADX WARN: Code duplicated, block: B:102:0x0327  */
    /* JADX WARN: Code duplicated, block: B:106:0x033e A[Catch: all -> 0x02df, TRY_ENTER, TryCatch #14 {all -> 0x02df, blocks: (B:81:0x02d5, B:106:0x033e, B:108:0x0344, B:110:0x034d, B:112:0x0353, B:89:0x02f1, B:92:0x02f9, B:94:0x030f, B:96:0x0315, B:99:0x0320), top: B:231:0x02d5 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0358  */
    /* JADX WARN: Code duplicated, block: B:122:0x03db A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:123:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:127:0x0402  */
    /* JADX WARN: Code duplicated, block: B:129:0x0405 A[Catch: all -> 0x040a, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x040a, blocks: (B:129:0x0405, B:137:0x0429, B:150:0x0462, B:152:0x046c, B:160:0x0488, B:140:0x0448), top: B:212:0x0403 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0413  */
    /* JADX WARN: Code duplicated, block: B:137:0x0429 A[Catch: all -> 0x040a, TRY_ENTER, TryCatch #4 {all -> 0x040a, blocks: (B:129:0x0405, B:137:0x0429, B:150:0x0462, B:152:0x046c, B:160:0x0488, B:140:0x0448), top: B:212:0x0403 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0447  */
    /* JADX WARN: Code duplicated, block: B:140:0x0448 A[Catch: all -> 0x040a, TRY_LEAVE, TryCatch #4 {all -> 0x040a, blocks: (B:129:0x0405, B:137:0x0429, B:150:0x0462, B:152:0x046c, B:160:0x0488, B:140:0x0448), top: B:212:0x0403 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0454 A[LOOP:0: B:135:0x0423->B:146:0x0454, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:150:0x0462 A[Catch: all -> 0x040a, TRY_ENTER, TryCatch #4 {all -> 0x040a, blocks: (B:129:0x0405, B:137:0x0429, B:150:0x0462, B:152:0x046c, B:160:0x0488, B:140:0x0448), top: B:212:0x0403 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x0483  */
    /* JADX WARN: Code duplicated, block: B:158:0x0485  */
    /* JADX WARN: Code duplicated, block: B:160:0x0488 A[Catch: all -> 0x040a, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x040a, blocks: (B:129:0x0405, B:137:0x0429, B:150:0x0462, B:152:0x046c, B:160:0x0488, B:140:0x0448), top: B:212:0x0403 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x048d A[Catch: all -> 0x052b, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x052b, blocks: (B:124:0x03ea, B:134:0x0415, B:135:0x0423, B:148:0x045e, B:155:0x0472, B:162:0x048d, B:167:0x04a0), top: B:213:0x03ea }] */
    /* JADX WARN: Code duplicated, block: B:164:0x049b  */
    /* JADX WARN: Code duplicated, block: B:166:0x049e  */
    /* JADX WARN: Code duplicated, block: B:172:0x04fb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:173:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:202:0x0582  */
    /* JADX WARN: Code duplicated, block: B:231:0x02d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:232:0x045e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:233:0x0459 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:235:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code duplicated, block: B:84:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:87:0x02e9 A[Catch: all -> 0x053d, TRY_ENTER, TRY_LEAVE, TryCatch #13 {all -> 0x053d, blocks: (B:78:0x02c5, B:104:0x032a, B:117:0x035c, B:87:0x02e9), top: B:229:0x02c5 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x02f1 A[Catch: all -> 0x02df, TRY_ENTER, TryCatch #14 {all -> 0x02df, blocks: (B:81:0x02d5, B:106:0x033e, B:108:0x0344, B:110:0x034d, B:112:0x0353, B:89:0x02f1, B:92:0x02f9, B:94:0x030f, B:96:0x0315, B:99:0x0320), top: B:231:0x02d5 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:92:0x02f9 A[Catch: all -> 0x02df, TryCatch #14 {all -> 0x02df, blocks: (B:81:0x02d5, B:106:0x033e, B:108:0x0344, B:110:0x034d, B:112:0x0353, B:89:0x02f1, B:92:0x02f9, B:94:0x030f, B:96:0x0315, B:99:0x0320), top: B:231:0x02d5 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x030f A[Catch: all -> 0x02df, TryCatch #14 {all -> 0x02df, blocks: (B:81:0x02d5, B:106:0x033e, B:108:0x0344, B:110:0x034d, B:112:0x0353, B:89:0x02f1, B:92:0x02f9, B:94:0x030f, B:96:0x0315, B:99:0x0320), top: B:231:0x02d5 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x031d  */
    /* JADX WARN: Code duplicated, block: B:99:0x0320 A[Catch: all -> 0x02df, TRY_LEAVE, TryCatch #14 {all -> 0x02df, blocks: (B:81:0x02d5, B:106:0x033e, B:108:0x0344, B:110:0x034d, B:112:0x0353, B:89:0x02f1, B:92:0x02f9, B:94:0x030f, B:96:0x0315, B:99:0x0320), top: B:231:0x02d5 }] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean, int] */
    @Nullable
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00031 c00031;
        boolean z2;
        Function1<? super ExtractorLink, Unit> function3;
        Function1<? super SubtitleFile, Unit> function4;
        Function1<? super SubtitleFile, Unit> function5;
        Object obj;
        int i;
        ?? r7;
        C00031 c00032;
        String str2;
        char c;
        boolean z3;
        Anikoto anikoto;
        String str3;
        Document document;
        Element elementSelectFirst;
        String strAttr;
        String str4;
        char c2;
        MatchResult matchResultFind$default;
        int iIntValue;
        boolean z4;
        Object obj2;
        C00031 c00033;
        String str5;
        Function1<? super ExtractorLink, Unit> function6;
        Document document2;
        Anikoto anikoto2;
        Object obj3;
        int i2;
        Function1<? super SubtitleFile, Unit> function7;
        String str6;
        String str7;
        char c3;
        List groupValues;
        Integer intOrNull;
        Element elementSelectFirst2;
        MatchResult matchResultFind$default2;
        String str8;
        List groupValues2;
        String str9;
        String strJsonResultString;
        String str10;
        Iterator it;
        char c4;
        Anikoto anikoto3;
        Object next;
        Element elementSelectFirst3;
        Element element;
        String strAttr2;
        String str11;
        String str12;
        Object obj4;
        Object objResolveServers;
        Function1<? super SubtitleFile, Unit> function8;
        Function1<? super ExtractorLink, Unit> function9;
        Function1<? super SubtitleFile, Unit> function10;
        Integer intOrNull2;
        Object obj5;
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
        C00031 c00034 = c00031;
        Object obj6 = c00034.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str13 = "sub";
        switch (c00034.label) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                String strRemovePrefix = StringsKt.startsWith$default(str, getMainUrl() + "/anikoto|", false, 2, (Object) null) ? StringsKt.removePrefix(str, getMainUrl() + '/') : StringsKt.startsWith$default(str, "/anikoto|", false, 2, (Object) null) ? StringsKt.removePrefix(str, "/") : str;
                if (StringsKt.startsWith$default(strRemovePrefix, "anikoto|", false, 2, (Object) null)) {
                    List listSplit$default = StringsKt.split$default(strRemovePrefix, new String[]{"|"}, false, 4, 2, (Object) null);
                    if (!(listSplit$default.size() >= 4)) {
                        listSplit$default = null;
                    }
                    if (listSplit$default == null) {
                        return Boxing.boxBoolean(false);
                    }
                    String str14 = (String) listSplit$default.get(1);
                    Object obj7 = listSplit$default.get(2);
                    if (StringsKt.isBlank((String) obj7)) {
                        obj7 = null;
                    }
                    String str15 = (String) obj7;
                    if (str15 == null) {
                        return Boxing.boxBoolean(false);
                    }
                    CharSequence charSequence = (CharSequence) listSplit$default.get(3);
                    String str16 = (String) (StringsKt.isBlank(charSequence) ? str13 : charSequence);
                    c00034.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    c00034.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00034.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    c00034.L$3 = SpillingKt.nullOutSpilledVariable(strRemovePrefix);
                    c00034.L$4 = SpillingKt.nullOutSpilledVariable(listSplit$default);
                    c00034.L$5 = SpillingKt.nullOutSpilledVariable(str14);
                    c00034.L$6 = SpillingKt.nullOutSpilledVariable(str15);
                    c00034.L$7 = SpillingKt.nullOutSpilledVariable(str16);
                    c00034.Z$0 = z;
                    c00034.label = 1;
                    Object objResolveServers2 = resolveServers(str15, str14, str16, function1, function2, c00034);
                    return objResolveServers2 == coroutine_suspended ? coroutine_suspended : objResolveServers2;
                }
                z2 = false;
                try {
                    Result.Companion companion = Result.Companion;
                    Anikoto anikoto4 = this;
                    try {
                        Requests app = MainActivityKt.getApp();
                        Map<String, String> map = anikoto4.browserHeaders;
                        c00034.L$0 = str;
                        function5 = function1;
                        try {
                            c00034.L$1 = function5;
                            function3 = function2;
                            try {
                                c00034.L$2 = function3;
                                c00034.L$3 = strRemovePrefix;
                                c00034.L$4 = anikoto4;
                                c00034.Z$0 = z;
                                c00034.label = 2;
                                obj = coroutine_suspended;
                                i = 2;
                                r7 = 0;
                                try {
                                    obj6 = Requests.get$default(app, strRemovePrefix, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00034, 4092, (Object) null);
                                    c00032 = c00034;
                                    if (obj6 == obj) {
                                        return obj;
                                    }
                                    str2 = str;
                                    c = 0;
                                    z3 = z;
                                    anikoto = anikoto4;
                                    str3 = strRemovePrefix;
                                    try {
                                        document = ((NiceResponse) obj6).getDocument();
                                        elementSelectFirst = document.selectFirst("#watch-main");
                                        if (elementSelectFirst != null) {
                                            try {
                                                strAttr = elementSelectFirst.attr("data-id");
                                                if (strAttr == null) {
                                                    elementSelectFirst2 = document.selectFirst("[data-id]");
                                                    if (elementSelectFirst2 != null) {
                                                        strAttr = elementSelectFirst2.attr("data-id");
                                                    } else {
                                                        strAttr = null;
                                                    }
                                                    if (strAttr != null) {
                                                        matchResultFind$default2 = Regex.find$default(new Regex("data-id=[\"'](\\d+)[\"']"), document.html(), (int) r7, i, (Object) null);
                                                        if (matchResultFind$default2 != null || (groupValues2 = matchResultFind$default2.getGroupValues()) == null) {
                                                            str8 = null;
                                                        } else {
                                                            str8 = (String) groupValues2.get(1);
                                                        }
                                                        if (str8 == null) {
                                                            return Boxing.boxBoolean((boolean) r7);
                                                        }
                                                        strAttr = str8;
                                                    }
                                                }
                                                str4 = strAttr;
                                                c2 = c;
                                                matchResultFind$default = Regex.find$default(new Regex("/ep-(\\d+)"), str3, (int) r7, i, (Object) null);
                                                try {
                                                    if (matchResultFind$default == null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                                                        String str17 = (String) groupValues.get(1);
                                                        if (str17 != null && (intOrNull = StringsKt.toIntOrNull(str17)) != null) {
                                                            iIntValue = intOrNull.intValue();
                                                        }
                                                        Requests app2 = MainActivityKt.getApp();
                                                        z4 = false;
                                                        String str18 = anikoto.getMainUrl() + "/ajax/episode/list/" + str4;
                                                        Map<String, String> mapAjaxHeaders = anikoto.ajaxHeaders(str2);
                                                        c00032.L$0 = str2;
                                                        c00032.L$1 = function5;
                                                        c00032.L$2 = function3;
                                                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                                                        c00032.L$4 = anikoto;
                                                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(document);
                                                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(str4);
                                                        c00032.L$7 = anikoto;
                                                        c00032.Z$0 = z3;
                                                        c00032.I$0 = iIntValue;
                                                        c00032.label = 3;
                                                        C00031 c00035 = c00032;
                                                        obj2 = Requests.get$default(app2, str18, mapAjaxHeaders, str2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00035, 4088, (Object) null);
                                                        c00033 = c00035;
                                                        if (obj2 == obj) {
                                                            return obj;
                                                        }
                                                        str5 = str4;
                                                        function6 = function3;
                                                        document2 = document;
                                                        anikoto2 = anikoto;
                                                        obj3 = obj2;
                                                        i2 = iIntValue;
                                                        function7 = function5;
                                                        str6 = str2;
                                                        str7 = str3;
                                                        c3 = c2;
                                                        str9 = str13;
                                                        try {
                                                            strJsonResultString = anikoto.jsonResultString(((NiceResponse) obj3).getText());
                                                            if (StringsKt.isBlank(strJsonResultString)) {
                                                                strJsonResultString = null;
                                                            }
                                                            try {
                                                                if (strJsonResultString == null) {
                                                                    return Boxing.boxBoolean(z4);
                                                                }
                                                                str10 = strJsonResultString;
                                                                it = Jsoup.parse(str10).select("a[data-ids]").iterator();
                                                                while (true) {
                                                                    if (it.hasNext()) {
                                                                        next = it.next();
                                                                        c4 = c3;
                                                                        anikoto3 = anikoto2;
                                                                        intOrNull2 = StringsKt.toIntOrNull(((Element) next).attr("data-num"));
                                                                        if (intOrNull2 == null && intOrNull2.intValue() == i2) {
                                                                            c3 = c4;
                                                                            anikoto2 = anikoto3;
                                                                        }
                                                                    } else {
                                                                        c4 = c3;
                                                                        anikoto3 = anikoto2;
                                                                        next = null;
                                                                    }
                                                                }
                                                                elementSelectFirst3 = (Element) next;
                                                                if (elementSelectFirst3 != null && (elementSelectFirst3 = Jsoup.parse(str10).selectFirst("a[data-ids]")) == null) {
                                                                    return Boxing.boxBoolean(z4);
                                                                }
                                                                element = elementSelectFirst3;
                                                                strAttr2 = element.attr("data-ids");
                                                                if (StringsKt.isBlank(strAttr2)) {
                                                                    str11 = null;
                                                                } else {
                                                                    str11 = strAttr2;
                                                                }
                                                                if (str11 == null) {
                                                                    return Boxing.boxBoolean(z4);
                                                                }
                                                                if (Intrinsics.areEqual(element.attr("data-dub"), "1")) {
                                                                    str12 = "dub";
                                                                } else {
                                                                    str12 = str9;
                                                                }
                                                                c00033.L$0 = SpillingKt.nullOutSpilledVariable(str6);
                                                                c00033.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                                                                c00033.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                                                                c00033.L$3 = SpillingKt.nullOutSpilledVariable(str7);
                                                                c00033.L$4 = SpillingKt.nullOutSpilledVariable(anikoto3);
                                                                c00033.L$5 = SpillingKt.nullOutSpilledVariable(document2);
                                                                c00033.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                                                                c00033.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                                                c00033.L$8 = SpillingKt.nullOutSpilledVariable(element);
                                                                c00033.L$9 = SpillingKt.nullOutSpilledVariable(str12);
                                                                c00033.L$10 = SpillingKt.nullOutSpilledVariable(str5);
                                                                c00033.Z$0 = z3;
                                                                c00033.I$0 = i2;
                                                                c00033.label = 4;
                                                                obj4 = obj;
                                                                z2 = false;
                                                                try {
                                                                    objResolveServers = anikoto3.resolveServers(str11, str6, str12, function7, function6, c00033);
                                                                    function8 = function7;
                                                                    if (objResolveServers == obj4) {
                                                                        return obj4;
                                                                    }
                                                                    function9 = function6;
                                                                    function10 = function8;
                                                                    try {
                                                                        obj5 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) objResolveServers).booleanValue()));
                                                                    } catch (Throwable th) {
                                                                        th = th;
                                                                        function3 = function9;
                                                                        function4 = function10;
                                                                        Result.Companion companion2 = Result.Companion;
                                                                        obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                    }
                                                                } catch (Throwable th2) {
                                                                    th = th2;
                                                                    function4 = function7;
                                                                    function3 = function6;
                                                                }
                                                            } catch (Throwable th3) {
                                                                th = th3;
                                                                function4 = function7;
                                                                function3 = function6;
                                                                z2 = false;
                                                            }
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            function4 = function7;
                                                            z2 = false;
                                                            function3 = function6;
                                                        }
                                                        Result.Companion companion3 = Result.Companion;
                                                        obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                        break;
                                                    }
                                                    obj2 = Requests.get$default(app2, str18, mapAjaxHeaders, str2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00035, 4088, (Object) null);
                                                    c00033 = c00035;
                                                    if (obj2 == obj) {
                                                        return obj;
                                                    }
                                                    str5 = str4;
                                                    function6 = function3;
                                                    document2 = document;
                                                    anikoto2 = anikoto;
                                                    obj3 = obj2;
                                                    i2 = iIntValue;
                                                    function7 = function5;
                                                    str6 = str2;
                                                    str7 = str3;
                                                    c3 = c2;
                                                    str9 = str13;
                                                    strJsonResultString = anikoto.jsonResultString(((NiceResponse) obj3).getText());
                                                    if (StringsKt.isBlank(strJsonResultString)) {
                                                        strJsonResultString = null;
                                                    }
                                                    if (strJsonResultString == null) {
                                                        return Boxing.boxBoolean(z4);
                                                    }
                                                    str10 = strJsonResultString;
                                                    it = Jsoup.parse(str10).select("a[data-ids]").iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            next = it.next();
                                                            c4 = c3;
                                                            anikoto3 = anikoto2;
                                                            intOrNull2 = StringsKt.toIntOrNull(((Element) next).attr("data-num"));
                                                            if (intOrNull2 == null && intOrNull2.intValue() == i2) {
                                                                c3 = c4;
                                                                anikoto2 = anikoto3;
                                                            }
                                                        } else {
                                                            c4 = c3;
                                                            anikoto3 = anikoto2;
                                                            next = null;
                                                        }
                                                    }
                                                    elementSelectFirst3 = (Element) next;
                                                    if (elementSelectFirst3 != null) {
                                                    }
                                                    element = elementSelectFirst3;
                                                    strAttr2 = element.attr("data-ids");
                                                    if (StringsKt.isBlank(strAttr2)) {
                                                        str11 = strAttr2;
                                                    } else {
                                                        str11 = null;
                                                    }
                                                    if (str11 == null) {
                                                        return Boxing.boxBoolean(z4);
                                                    }
                                                    if (Intrinsics.areEqual(element.attr("data-dub"), "1")) {
                                                        str12 = "dub";
                                                    } else {
                                                        str12 = str9;
                                                    }
                                                    c00033.L$0 = SpillingKt.nullOutSpilledVariable(str6);
                                                    c00033.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00033.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                                                    c00033.L$3 = SpillingKt.nullOutSpilledVariable(str7);
                                                    c00033.L$4 = SpillingKt.nullOutSpilledVariable(anikoto3);
                                                    c00033.L$5 = SpillingKt.nullOutSpilledVariable(document2);
                                                    c00033.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                                                    c00033.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                                    c00033.L$8 = SpillingKt.nullOutSpilledVariable(element);
                                                    c00033.L$9 = SpillingKt.nullOutSpilledVariable(str12);
                                                    c00033.L$10 = SpillingKt.nullOutSpilledVariable(str5);
                                                    c00033.Z$0 = z3;
                                                    c00033.I$0 = i2;
                                                    c00033.label = 4;
                                                    obj4 = obj;
                                                    z2 = false;
                                                    objResolveServers = anikoto3.resolveServers(str11, str6, str12, function7, function6, c00033);
                                                    function8 = function7;
                                                    if (objResolveServers == obj4) {
                                                        return obj4;
                                                    }
                                                    function9 = function6;
                                                    function10 = function8;
                                                    obj5 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) objResolveServers).booleanValue()));
                                                    Result.Companion companion4 = Result.Companion;
                                                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    z2 = false;
                                                    function4 = function5;
                                                }
                                                Requests app3 = MainActivityKt.getApp();
                                                z4 = false;
                                                String str19 = anikoto.getMainUrl() + "/ajax/episode/list/" + str4;
                                                Map<String, String> mapAjaxHeaders2 = anikoto.ajaxHeaders(str2);
                                                c00032.L$0 = str2;
                                                c00032.L$1 = function5;
                                                c00032.L$2 = function3;
                                                c00032.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                                                c00032.L$4 = anikoto;
                                                c00032.L$5 = SpillingKt.nullOutSpilledVariable(document);
                                                c00032.L$6 = SpillingKt.nullOutSpilledVariable(str4);
                                                c00032.L$7 = anikoto;
                                                c00032.Z$0 = z3;
                                                c00032.I$0 = iIntValue;
                                                c00032.label = 3;
                                                C00031 c00036 = c00032;
                                            } catch (Throwable th6) {
                                                th = th6;
                                                function4 = function5;
                                                z2 = false;
                                            }
                                        } else {
                                            elementSelectFirst2 = document.selectFirst("[data-id]");
                                            if (elementSelectFirst2 != null) {
                                                strAttr = elementSelectFirst2.attr("data-id");
                                            } else {
                                                strAttr = null;
                                            }
                                            if (strAttr != null) {
                                                matchResultFind$default2 = Regex.find$default(new Regex("data-id=[\"'](\\d+)[\"']"), document.html(), (int) r7, i, (Object) null);
                                                if (matchResultFind$default2 != null) {
                                                    str8 = null;
                                                } else {
                                                    str8 = null;
                                                }
                                                if (str8 == null) {
                                                    return Boxing.boxBoolean((boolean) r7);
                                                }
                                                strAttr = str8;
                                            }
                                            str4 = strAttr;
                                            c2 = c;
                                            matchResultFind$default = Regex.find$default(new Regex("/ep-(\\d+)"), str3, (int) r7, i, (Object) null);
                                            iIntValue = matchResultFind$default == null ? 1 : 1;
                                            Requests app4 = MainActivityKt.getApp();
                                            z4 = false;
                                            String str110 = anikoto.getMainUrl() + "/ajax/episode/list/" + str4;
                                            Map<String, String> mapAjaxHeaders3 = anikoto.ajaxHeaders(str2);
                                            c00032.L$0 = str2;
                                            c00032.L$1 = function5;
                                            c00032.L$2 = function3;
                                            c00032.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                                            c00032.L$4 = anikoto;
                                            c00032.L$5 = SpillingKt.nullOutSpilledVariable(document);
                                            c00032.L$6 = SpillingKt.nullOutSpilledVariable(str4);
                                            c00032.L$7 = anikoto;
                                            c00032.Z$0 = z3;
                                            c00032.I$0 = iIntValue;
                                            c00032.label = 3;
                                            C00031 c00037 = c00032;
                                            obj2 = Requests.get$default(app4, str110, mapAjaxHeaders3, str2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00037, 4088, (Object) null);
                                            c00033 = c00037;
                                            if (obj2 == obj) {
                                                return obj;
                                            }
                                            str5 = str4;
                                            function6 = function3;
                                            document2 = document;
                                            anikoto2 = anikoto;
                                            obj3 = obj2;
                                            i2 = iIntValue;
                                            function7 = function5;
                                            str6 = str2;
                                            str7 = str3;
                                            c3 = c2;
                                            str9 = str13;
                                            strJsonResultString = anikoto.jsonResultString(((NiceResponse) obj3).getText());
                                            if (StringsKt.isBlank(strJsonResultString)) {
                                                strJsonResultString = null;
                                            }
                                            if (strJsonResultString == null) {
                                                return Boxing.boxBoolean(z4);
                                            }
                                            str10 = strJsonResultString;
                                            it = Jsoup.parse(str10).select("a[data-ids]").iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    next = it.next();
                                                    c4 = c3;
                                                    anikoto3 = anikoto2;
                                                    intOrNull2 = StringsKt.toIntOrNull(((Element) next).attr("data-num"));
                                                    if (intOrNull2 == null && intOrNull2.intValue() == i2) {
                                                        c3 = c4;
                                                        anikoto2 = anikoto3;
                                                    }
                                                } else {
                                                    c4 = c3;
                                                    anikoto3 = anikoto2;
                                                    next = null;
                                                }
                                            }
                                            elementSelectFirst3 = (Element) next;
                                            if (elementSelectFirst3 != null) {
                                            }
                                            element = elementSelectFirst3;
                                            strAttr2 = element.attr("data-ids");
                                            if (StringsKt.isBlank(strAttr2)) {
                                                str11 = strAttr2;
                                            } else {
                                                str11 = null;
                                            }
                                            if (str11 == null) {
                                                return Boxing.boxBoolean(z4);
                                            }
                                            if (Intrinsics.areEqual(element.attr("data-dub"), "1")) {
                                                str12 = "dub";
                                            } else {
                                                str12 = str9;
                                            }
                                            c00033.L$0 = SpillingKt.nullOutSpilledVariable(str6);
                                            c00033.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00033.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                                            c00033.L$3 = SpillingKt.nullOutSpilledVariable(str7);
                                            c00033.L$4 = SpillingKt.nullOutSpilledVariable(anikoto3);
                                            c00033.L$5 = SpillingKt.nullOutSpilledVariable(document2);
                                            c00033.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                                            c00033.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                            c00033.L$8 = SpillingKt.nullOutSpilledVariable(element);
                                            c00033.L$9 = SpillingKt.nullOutSpilledVariable(str12);
                                            c00033.L$10 = SpillingKt.nullOutSpilledVariable(str5);
                                            c00033.Z$0 = z3;
                                            c00033.I$0 = i2;
                                            c00033.label = 4;
                                            obj4 = obj;
                                            z2 = false;
                                            objResolveServers = anikoto3.resolveServers(str11, str6, str12, function7, function6, c00033);
                                            function8 = function7;
                                            if (objResolveServers == obj4) {
                                                return obj4;
                                            }
                                            function9 = function6;
                                            function10 = function8;
                                            obj5 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) objResolveServers).booleanValue()));
                                            Result.Companion companion5 = Result.Companion;
                                            obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                        break;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        z2 = false;
                                        function4 = function5;
                                    }
                                    if (Result.exceptionOrNull-impl(obj5) == null) {
                                        return obj5;
                                    }
                                    return Boxing.boxBoolean(z2);
                                } catch (Throwable th8) {
                                    th = th8;
                                    z2 = false;
                                    function4 = function5;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                function4 = function5;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            function3 = function2;
                            function4 = function5;
                            Result.Companion companion6 = Result.Companion;
                            obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                            if (Result.exceptionOrNull-impl(obj5) == null) {
                                return obj5;
                            }
                            return Boxing.boxBoolean(z2);
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        function5 = function1;
                    }
                } catch (Throwable th12) {
                    th = th12;
                    function3 = function2;
                    function4 = function1;
                }
                break;
            case 1:
                boolean z5 = c00034.Z$0;
                ResultKt.throwOnFailure(obj6);
                return obj6;
            case 2:
                z3 = c00034.Z$0;
                Anikoto anikoto5 = (Anikoto) c00034.L$4;
                String str20 = (String) c00034.L$3;
                Function1<? super ExtractorLink, Unit> function11 = (Function1) c00034.L$2;
                function4 = (Function1) c00034.L$1;
                String str21 = (String) c00034.L$0;
                try {
                    ResultKt.throwOnFailure(obj6);
                    anikoto = anikoto5;
                    function5 = function4;
                    function3 = function11;
                    c00032 = c00034;
                    str2 = str21;
                    obj = coroutine_suspended;
                    str3 = str20;
                    r7 = 0;
                    c = 0;
                    i = 2;
                    document = ((NiceResponse) obj6).getDocument();
                    elementSelectFirst = document.selectFirst("#watch-main");
                    if (elementSelectFirst != null) {
                        strAttr = elementSelectFirst.attr("data-id");
                        if (strAttr == null) {
                            elementSelectFirst2 = document.selectFirst("[data-id]");
                            if (elementSelectFirst2 != null) {
                                strAttr = elementSelectFirst2.attr("data-id");
                            } else {
                                strAttr = null;
                            }
                            if (strAttr != null) {
                                matchResultFind$default2 = Regex.find$default(new Regex("data-id=[\"'](\\d+)[\"']"), document.html(), (int) r7, i, (Object) null);
                                if (matchResultFind$default2 != null) {
                                    str8 = null;
                                } else {
                                    str8 = null;
                                }
                                if (str8 == null) {
                                    return Boxing.boxBoolean((boolean) r7);
                                }
                                strAttr = str8;
                            }
                        }
                        str4 = strAttr;
                        c2 = c;
                        matchResultFind$default = Regex.find$default(new Regex("/ep-(\\d+)"), str3, (int) r7, i, (Object) null);
                        if (matchResultFind$default == null) {
                        }
                        Requests app5 = MainActivityKt.getApp();
                        z4 = false;
                        String str111 = anikoto.getMainUrl() + "/ajax/episode/list/" + str4;
                        Map<String, String> mapAjaxHeaders4 = anikoto.ajaxHeaders(str2);
                        c00032.L$0 = str2;
                        c00032.L$1 = function5;
                        c00032.L$2 = function3;
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                        c00032.L$4 = anikoto;
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(document);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(str4);
                        c00032.L$7 = anikoto;
                        c00032.Z$0 = z3;
                        c00032.I$0 = iIntValue;
                        c00032.label = 3;
                        C00031 c00038 = c00032;
                        obj2 = Requests.get$default(app5, str111, mapAjaxHeaders4, str2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00038, 4088, (Object) null);
                        c00033 = c00038;
                        if (obj2 == obj) {
                            return obj;
                        }
                        str5 = str4;
                        function6 = function3;
                        document2 = document;
                        anikoto2 = anikoto;
                        obj3 = obj2;
                        i2 = iIntValue;
                        function7 = function5;
                        str6 = str2;
                        str7 = str3;
                        c3 = c2;
                        str9 = str13;
                        strJsonResultString = anikoto.jsonResultString(((NiceResponse) obj3).getText());
                        if (StringsKt.isBlank(strJsonResultString)) {
                            strJsonResultString = null;
                        }
                        if (strJsonResultString == null) {
                            return Boxing.boxBoolean(z4);
                        }
                        str10 = strJsonResultString;
                        it = Jsoup.parse(str10).select("a[data-ids]").iterator();
                        while (true) {
                            if (it.hasNext()) {
                                next = it.next();
                                c4 = c3;
                                anikoto3 = anikoto2;
                                intOrNull2 = StringsKt.toIntOrNull(((Element) next).attr("data-num"));
                                if (intOrNull2 == null && intOrNull2.intValue() == i2) {
                                    c3 = c4;
                                    anikoto2 = anikoto3;
                                }
                            } else {
                                c4 = c3;
                                anikoto3 = anikoto2;
                                next = null;
                            }
                        }
                        elementSelectFirst3 = (Element) next;
                        if (elementSelectFirst3 != null) {
                        }
                        element = elementSelectFirst3;
                        strAttr2 = element.attr("data-ids");
                        if (StringsKt.isBlank(strAttr2)) {
                            str11 = strAttr2;
                        } else {
                            str11 = null;
                        }
                        if (str11 == null) {
                            return Boxing.boxBoolean(z4);
                        }
                        if (Intrinsics.areEqual(element.attr("data-dub"), "1")) {
                            str12 = "dub";
                        } else {
                            str12 = str9;
                        }
                        c00033.L$0 = SpillingKt.nullOutSpilledVariable(str6);
                        c00033.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                        c00033.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                        c00033.L$3 = SpillingKt.nullOutSpilledVariable(str7);
                        c00033.L$4 = SpillingKt.nullOutSpilledVariable(anikoto3);
                        c00033.L$5 = SpillingKt.nullOutSpilledVariable(document2);
                        c00033.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                        c00033.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                        c00033.L$8 = SpillingKt.nullOutSpilledVariable(element);
                        c00033.L$9 = SpillingKt.nullOutSpilledVariable(str12);
                        c00033.L$10 = SpillingKt.nullOutSpilledVariable(str5);
                        c00033.Z$0 = z3;
                        c00033.I$0 = i2;
                        c00033.label = 4;
                        obj4 = obj;
                        z2 = false;
                        objResolveServers = anikoto3.resolveServers(str11, str6, str12, function7, function6, c00033);
                        function8 = function7;
                        if (objResolveServers == obj4) {
                            return obj4;
                        }
                        function9 = function6;
                        function10 = function8;
                        obj5 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) objResolveServers).booleanValue()));
                        Result.Companion companion7 = Result.Companion;
                        obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                    } else {
                        elementSelectFirst2 = document.selectFirst("[data-id]");
                        if (elementSelectFirst2 != null) {
                            strAttr = elementSelectFirst2.attr("data-id");
                        } else {
                            strAttr = null;
                        }
                        if (strAttr != null) {
                            matchResultFind$default2 = Regex.find$default(new Regex("data-id=[\"'](\\d+)[\"']"), document.html(), (int) r7, i, (Object) null);
                            if (matchResultFind$default2 != null) {
                                str8 = null;
                            } else {
                                str8 = null;
                            }
                            if (str8 == null) {
                                return Boxing.boxBoolean((boolean) r7);
                            }
                            strAttr = str8;
                        }
                        str4 = strAttr;
                        c2 = c;
                        matchResultFind$default = Regex.find$default(new Regex("/ep-(\\d+)"), str3, (int) r7, i, (Object) null);
                        if (matchResultFind$default == null) {
                        }
                        Requests app6 = MainActivityKt.getApp();
                        z4 = false;
                        String str112 = anikoto.getMainUrl() + "/ajax/episode/list/" + str4;
                        Map<String, String> mapAjaxHeaders5 = anikoto.ajaxHeaders(str2);
                        c00032.L$0 = str2;
                        c00032.L$1 = function5;
                        c00032.L$2 = function3;
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                        c00032.L$4 = anikoto;
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(document);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(str4);
                        c00032.L$7 = anikoto;
                        c00032.Z$0 = z3;
                        c00032.I$0 = iIntValue;
                        c00032.label = 3;
                        C00031 c00039 = c00032;
                        obj2 = Requests.get$default(app6, str112, mapAjaxHeaders5, str2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00039, 4088, (Object) null);
                        c00033 = c00039;
                        if (obj2 == obj) {
                            return obj;
                        }
                        str5 = str4;
                        function6 = function3;
                        document2 = document;
                        anikoto2 = anikoto;
                        obj3 = obj2;
                        i2 = iIntValue;
                        function7 = function5;
                        str6 = str2;
                        str7 = str3;
                        c3 = c2;
                        str9 = str13;
                        strJsonResultString = anikoto.jsonResultString(((NiceResponse) obj3).getText());
                        if (StringsKt.isBlank(strJsonResultString)) {
                            strJsonResultString = null;
                        }
                        if (strJsonResultString == null) {
                            return Boxing.boxBoolean(z4);
                        }
                        str10 = strJsonResultString;
                        it = Jsoup.parse(str10).select("a[data-ids]").iterator();
                        while (true) {
                            if (it.hasNext()) {
                                next = it.next();
                                c4 = c3;
                                anikoto3 = anikoto2;
                                intOrNull2 = StringsKt.toIntOrNull(((Element) next).attr("data-num"));
                                if (intOrNull2 == null && intOrNull2.intValue() == i2) {
                                    c3 = c4;
                                    anikoto2 = anikoto3;
                                }
                            } else {
                                c4 = c3;
                                anikoto3 = anikoto2;
                                next = null;
                            }
                        }
                        elementSelectFirst3 = (Element) next;
                        if (elementSelectFirst3 != null) {
                        }
                        element = elementSelectFirst3;
                        strAttr2 = element.attr("data-ids");
                        if (StringsKt.isBlank(strAttr2)) {
                            str11 = strAttr2;
                        } else {
                            str11 = null;
                        }
                        if (str11 == null) {
                            return Boxing.boxBoolean(z4);
                        }
                        if (Intrinsics.areEqual(element.attr("data-dub"), "1")) {
                            str12 = "dub";
                        } else {
                            str12 = str9;
                        }
                        c00033.L$0 = SpillingKt.nullOutSpilledVariable(str6);
                        c00033.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                        c00033.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                        c00033.L$3 = SpillingKt.nullOutSpilledVariable(str7);
                        c00033.L$4 = SpillingKt.nullOutSpilledVariable(anikoto3);
                        c00033.L$5 = SpillingKt.nullOutSpilledVariable(document2);
                        c00033.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                        c00033.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                        c00033.L$8 = SpillingKt.nullOutSpilledVariable(element);
                        c00033.L$9 = SpillingKt.nullOutSpilledVariable(str12);
                        c00033.L$10 = SpillingKt.nullOutSpilledVariable(str5);
                        c00033.Z$0 = z3;
                        c00033.I$0 = i2;
                        c00033.label = 4;
                        obj4 = obj;
                        z2 = false;
                        objResolveServers = anikoto3.resolveServers(str11, str6, str12, function7, function6, c00033);
                        function8 = function7;
                        if (objResolveServers == obj4) {
                            return obj4;
                        }
                        function9 = function6;
                        function10 = function8;
                        obj5 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) objResolveServers).booleanValue()));
                        Result.Companion companion8 = Result.Companion;
                        obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    break;
                } catch (Throwable th13) {
                    th = th13;
                    function3 = function11;
                    z2 = false;
                }
                if (Result.exceptionOrNull-impl(obj5) == null) {
                    return obj5;
                }
                return Boxing.boxBoolean(z2);
            case 3:
                int i3 = c00034.I$0;
                boolean z6 = c00034.Z$0;
                Anikoto anikoto6 = (Anikoto) c00034.L$7;
                str5 = (String) c00034.L$6;
                Document document3 = (Document) c00034.L$5;
                Anikoto anikoto7 = (Anikoto) c00034.L$4;
                str7 = (String) c00034.L$3;
                Function1<? super ExtractorLink, Unit> function12 = (Function1) c00034.L$2;
                Function1<? super SubtitleFile, Unit> function13 = (Function1) c00034.L$1;
                String str22 = (String) c00034.L$0;
                try {
                    ResultKt.throwOnFailure(obj6);
                    document2 = document3;
                    obj = coroutine_suspended;
                    function6 = function12;
                    str9 = "sub";
                    anikoto2 = anikoto7;
                    z4 = false;
                    str6 = str22;
                    c3 = 0;
                    i2 = i3;
                    z3 = z6;
                    obj3 = obj6;
                    anikoto = anikoto6;
                    c00033 = c00034;
                    function7 = function13;
                    strJsonResultString = anikoto.jsonResultString(((NiceResponse) obj3).getText());
                    if (StringsKt.isBlank(strJsonResultString)) {
                        strJsonResultString = null;
                    }
                    if (strJsonResultString == null) {
                        return Boxing.boxBoolean(z4);
                    }
                    str10 = strJsonResultString;
                    it = Jsoup.parse(str10).select("a[data-ids]").iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            c4 = c3;
                            anikoto3 = anikoto2;
                            intOrNull2 = StringsKt.toIntOrNull(((Element) next).attr("data-num"));
                            if (intOrNull2 == null && intOrNull2.intValue() == i2) {
                                c3 = c4;
                                anikoto2 = anikoto3;
                            }
                        } else {
                            c4 = c3;
                            anikoto3 = anikoto2;
                            next = null;
                        }
                    }
                    elementSelectFirst3 = (Element) next;
                    if (elementSelectFirst3 != null) {
                        break;
                    }
                    element = elementSelectFirst3;
                    strAttr2 = element.attr("data-ids");
                    if (StringsKt.isBlank(strAttr2)) {
                        str11 = strAttr2;
                    } else {
                        str11 = null;
                    }
                    if (str11 == null) {
                        return Boxing.boxBoolean(z4);
                    }
                    if (Intrinsics.areEqual(element.attr("data-dub"), "1")) {
                        str12 = "dub";
                    } else {
                        str12 = str9;
                    }
                    c00033.L$0 = SpillingKt.nullOutSpilledVariable(str6);
                    c00033.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                    c00033.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                    c00033.L$3 = SpillingKt.nullOutSpilledVariable(str7);
                    c00033.L$4 = SpillingKt.nullOutSpilledVariable(anikoto3);
                    c00033.L$5 = SpillingKt.nullOutSpilledVariable(document2);
                    c00033.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                    c00033.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                    c00033.L$8 = SpillingKt.nullOutSpilledVariable(element);
                    c00033.L$9 = SpillingKt.nullOutSpilledVariable(str12);
                    c00033.L$10 = SpillingKt.nullOutSpilledVariable(str5);
                    c00033.Z$0 = z3;
                    c00033.I$0 = i2;
                    c00033.label = 4;
                    obj4 = obj;
                    z2 = false;
                    objResolveServers = anikoto3.resolveServers(str11, str6, str12, function7, function6, c00033);
                    function8 = function7;
                    if (objResolveServers == obj4) {
                        return obj4;
                    }
                    function9 = function6;
                    function10 = function8;
                    obj5 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) objResolveServers).booleanValue()));
                    if (Result.exceptionOrNull-impl(obj5) == null) {
                        return obj5;
                    }
                    return Boxing.boxBoolean(z2);
                } catch (Throwable th14) {
                    th = th14;
                    function3 = function12;
                    z2 = false;
                    function4 = function13;
                }
                Result.Companion companion9 = Result.Companion;
                obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                if (Result.exceptionOrNull-impl(obj5) == null) {
                    return obj5;
                }
                return Boxing.boxBoolean(z2);
            case 4:
                int i4 = c00034.I$0;
                boolean z7 = c00034.Z$0;
                function9 = (Function1) c00034.L$2;
                function10 = (Function1) c00034.L$1;
                try {
                    ResultKt.throwOnFailure(obj6);
                    z2 = false;
                    objResolveServers = obj6;
                    obj5 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) objResolveServers).booleanValue()));
                    break;
                } catch (Throwable th15) {
                    th = th15;
                    function3 = function9;
                    function4 = function10;
                    z2 = false;
                    break;
                }
                if (Result.exceptionOrNull-impl(obj5) == null) {
                    return obj5;
                }
                return Boxing.boxBoolean(z2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/anikoto/Anikoto$ServerEntry;", "", "linkId", "", "serverName", "serverType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLinkId", "()Ljava/lang/String;", "getServerName", "getServerType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AniKoto"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class ServerEntry {

        @NotNull
        private final String linkId;

        @NotNull
        private final String serverName;

        @NotNull
        private final String serverType;

        public static /* synthetic */ ServerEntry copy$default(ServerEntry serverEntry, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = serverEntry.linkId;
            }
            if ((i & 2) != 0) {
                str2 = serverEntry.serverName;
            }
            if ((i & 4) != 0) {
                str3 = serverEntry.serverType;
            }
            return serverEntry.copy(str, str2, str3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLinkId() {
            return this.linkId;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getServerName() {
            return this.serverName;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getServerType() {
            return this.serverType;
        }

        @NotNull
        public final ServerEntry copy(@NotNull String linkId, @NotNull String serverName, @NotNull String serverType) {
            return new ServerEntry(linkId, serverName, serverType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServerEntry)) {
                return false;
            }
            ServerEntry serverEntry = (ServerEntry) other;
            return Intrinsics.areEqual(this.linkId, serverEntry.linkId) && Intrinsics.areEqual(this.serverName, serverEntry.serverName) && Intrinsics.areEqual(this.serverType, serverEntry.serverType);
        }

        public int hashCode() {
            return (((this.linkId.hashCode() * 31) + this.serverName.hashCode()) * 31) + this.serverType.hashCode();
        }

        @NotNull
        public String toString() {
            return "ServerEntry(linkId=" + this.linkId + ", serverName=" + this.serverName + ", serverType=" + this.serverType + ')';
        }

        public ServerEntry(@NotNull String linkId, @NotNull String serverName, @NotNull String serverType) {
            this.linkId = linkId;
            this.serverName = serverName;
            this.serverType = serverType;
        }

        @NotNull
        public final String getLinkId() {
            return this.linkId;
        }

        @NotNull
        public final String getServerName() {
            return this.serverName;
        }

        @NotNull
        public final String getServerType() {
            return this.serverType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:107:0x0292 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x0259 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x02f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x0344 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x032a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0170  */
    /* JADX WARN: Code duplicated, block: B:43:0x017c  */
    /* JADX WARN: Code duplicated, block: B:45:0x0181  */
    /* JADX WARN: Code duplicated, block: B:47:0x018d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0194  */
    /* JADX WARN: Code duplicated, block: B:52:0x01be  */
    /* JADX WARN: Code duplicated, block: B:54:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:59:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:64:0x022c  */
    /* JADX WARN: Code duplicated, block: B:66:0x0255  */
    /* JADX WARN: Code duplicated, block: B:71:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:74:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:76:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:82:0x0330  */
    /* JADX WARN: Code duplicated, block: B:87:0x0354  */
    /* JADX WARN: Code duplicated, block: B:89:0x035a  */
    /* JADX WARN: Code duplicated, block: B:91:0x03b2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:92:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:95:0x03be  */
    public final Object resolveServers(String serverIds, String referer, String audioType, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) {
        C00051 c00051;
        C00051 c00052;
        Object obj;
        String serverIds2;
        String referer2;
        String audioType2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Anikoto anikoto;
        Object obj2;
        String referer3;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        String serverListHtml;
        Document serverDoc;
        Iterable iterableListOf;
        Iterable typeSelectors;
        Iterable list$iv$iv;
        int $i$f$flatMap;
        Collection destination$iv$iv;
        Iterator it;
        Iterable $this$flatMap$iv;
        Object obj3;
        String referer4;
        Function1<? super SubtitleFile, Unit> function7;
        Function1<? super ExtractorLink, Unit> function8;
        ArrayList arrayList;
        Collection destination$iv$iv2;
        List entries;
        Ref.BooleanRef found;
        C00062 c00062;
        Ref.BooleanRef found2;
        ServerEntry it2;
        int i;
        Iterable $this$map$iv;
        int $i$f$map;
        Collection destination$iv$iv3;
        String string;
        String sel;
        MatchResult matchResultFind$default;
        String sType;
        Iterable $this$map$iv2;
        int $i$f$map2;
        Collection destination$iv$iv4;
        String string2;
        List groupValues;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
            } else {
                c00051 = new C00051(continuation);
            }
        } else {
            c00051 = new C00051(continuation);
        }
        C00051 c00053 = c00051;
        Object $result = c00053.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00053.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Result.Companion companion = Result.Companion;
                    Anikoto $this$resolveServers_u24lambda_u240 = this;
                    Requests app = MainActivityKt.getApp();
                    String str = $this$resolveServers_u24lambda_u240.getMainUrl() + "/ajax/server/list?servers=" + serverIds;
                    try {
                        Map<String, String> mapAjaxHeaders = $this$resolveServers_u24lambda_u240.ajaxHeaders(referer);
                        c00053.L$0 = SpillingKt.nullOutSpilledVariable(serverIds);
                        c00053.L$1 = referer;
                        c00053.L$2 = audioType;
                        c00053.L$3 = function1;
                        c00053.L$4 = function2;
                        c00053.L$5 = SpillingKt.nullOutSpilledVariable($this$resolveServers_u24lambda_u240);
                        c00053.L$6 = $this$resolveServers_u24lambda_u240;
                        c00053.label = 1;
                        obj = coroutine_suspended;
                        try {
                            $result = Requests.get$default(app, str, mapAjaxHeaders, referer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00053, 4088, (Object) null);
                            c00052 = c00053;
                            if ($result == obj) {
                                return obj;
                            }
                            serverIds2 = serverIds;
                            referer2 = referer;
                            audioType2 = audioType;
                            function3 = function1;
                            function4 = function2;
                            anikoto = $this$resolveServers_u24lambda_u240;
                            try {
                                obj2 = Result.constructor-impl(anikoto.jsonResultString(((NiceResponse) $result).getText()));
                            } catch (Throwable th) {
                                th = th;
                                Result.Companion companion2 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            referer3 = referer2;
                            function5 = function4;
                            function6 = function3;
                            if (Result.exceptionOrNull-impl(obj2) == null) {
                                return Boxing.boxBoolean(false);
                            }
                            serverListHtml = (String) obj2;
                            if (StringsKt.isBlank(serverListHtml)) {
                                return Boxing.boxBoolean(false);
                            }
                            serverDoc = Jsoup.parse(serverListHtml);
                            if (Intrinsics.areEqual(audioType2, "dub")) {
                                iterableListOf = CollectionsKt.listOf("div.type[data-type=dub]");
                            } else {
                                iterableListOf = CollectionsKt.listOf(new String[]{"div.type[data-type=sub]", "div.type[data-type=hsub]"});
                            }
                            typeSelectors = iterableListOf;
                            list$iv$iv = typeSelectors;
                            $i$f$flatMap = 0;
                            destination$iv$iv = new ArrayList();
                            it = list$iv$iv.iterator();
                            while (true) {
                                $this$flatMap$iv = list$iv$iv;
                                if (it.hasNext()) {
                                    obj3 = obj;
                                    referer4 = referer3;
                                    function7 = function6;
                                    function8 = function5;
                                    arrayList = (List) destination$iv$iv;
                                    if (arrayList.isEmpty()) {
                                        i = 0;
                                        $this$map$iv = serverDoc.select("li[data-link-id]");
                                        $i$f$map = 0;
                                        destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                        for (Object item$iv$iv : $this$map$iv) {
                                            Element li = (Element) item$iv$iv;
                                            int i2 = i;
                                            String strAttr = li.attr("data-link-id");
                                            string = StringsKt.trim(li.text()).toString();
                                            if (StringsKt.isBlank(string)) {
                                                string = "Server";
                                            }
                                            destination$iv$iv3.add(new ServerEntry(strAttr, string, audioType2));
                                            i = i2;
                                            $this$map$iv = $this$map$iv;
                                            $i$f$map = $i$f$map;
                                        }
                                        arrayList = (List) destination$iv$iv3;
                                    }
                                    ArrayList $this$filter$iv = arrayList;
                                    destination$iv$iv2 = new ArrayList();
                                    for (Object element$iv$iv : $this$filter$iv) {
                                        it2 = (ServerEntry) element$iv$iv;
                                        if (!StringsKt.isBlank(it2.getLinkId())) {
                                            destination$iv$iv2.add(element$iv$iv);
                                        }
                                    }
                                    entries = (List) destination$iv$iv2;
                                    if (entries.isEmpty()) {
                                        return Boxing.boxBoolean(false);
                                    }
                                    found = new Ref.BooleanRef();
                                    c00062 = new C00062(referer4, function7, function8, found, null);
                                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(serverIds2);
                                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(referer4);
                                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(audioType2);
                                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(serverListHtml);
                                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(serverDoc);
                                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(typeSelectors);
                                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(entries);
                                    c00052.L$9 = found;
                                    c00052.label = 2;
                                    if (ParCollectionsKt.amap(entries, c00062, c00052) == obj3) {
                                        return obj3;
                                    }
                                    found2 = found;
                                    return Boxing.boxBoolean(found2.element);
                                }
                                sel = (String) it.next();
                                Object obj4 = obj;
                                String referer5 = referer3;
                                Function1<? super SubtitleFile, Unit> function9 = function6;
                                Function1<? super ExtractorLink, Unit> function10 = function5;
                                int $i$f$flatMap2 = $i$f$flatMap;
                                matchResultFind$default = Regex.find$default(new Regex("data-type=(\\w+)"), sel, 0, 2, (Object) null);
                                if (matchResultFind$default == null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                                    sType = (String) groupValues.get(1);
                                    if (sType == null) {
                                    }
                                    $this$map$iv2 = serverDoc.select(sel + " li[data-link-id]");
                                    $i$f$map2 = 0;
                                    destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                                    for (Object item$iv$iv2 : $this$map$iv2) {
                                        String sel2 = sel;
                                        Element li2 = (Element) item$iv$iv2;
                                        Iterable $this$map$iv3 = $this$map$iv2;
                                        String strAttr2 = li2.attr("data-link-id");
                                        string2 = StringsKt.trim(li2.text()).toString();
                                        if (StringsKt.isBlank(string2)) {
                                            string2 = "Server";
                                        }
                                        destination$iv$iv4.add(new ServerEntry(strAttr2, string2, sType));
                                        sel = sel2;
                                        $this$map$iv2 = $this$map$iv3;
                                        $i$f$map2 = $i$f$map2;
                                    }
                                    CollectionsKt.addAll(destination$iv$iv, (List) destination$iv$iv4);
                                    list$iv$iv = $this$flatMap$iv;
                                    $i$f$flatMap = $i$f$flatMap2;
                                    referer3 = referer5;
                                    function6 = function9;
                                    obj = obj4;
                                    function5 = function10;
                                }
                                $this$map$iv2 = serverDoc.select(sel + " li[data-link-id]");
                                $i$f$map2 = 0;
                                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                                while (r25.hasNext()) {
                                    String sel3 = sel;
                                    Element li3 = (Element) item$iv$iv2;
                                    Iterable $this$map$iv4 = $this$map$iv2;
                                    String strAttr3 = li3.attr("data-link-id");
                                    string2 = StringsKt.trim(li3.text()).toString();
                                    if (StringsKt.isBlank(string2)) {
                                        string2 = "Server";
                                    }
                                    destination$iv$iv4.add(new ServerEntry(strAttr3, string2, sType));
                                    sel = sel3;
                                    $this$map$iv2 = $this$map$iv4;
                                    $i$f$map2 = $i$f$map2;
                                }
                                CollectionsKt.addAll(destination$iv$iv, (List) destination$iv$iv4);
                                list$iv$iv = $this$flatMap$iv;
                                $i$f$flatMap = $i$f$flatMap2;
                                referer3 = referer5;
                                function6 = function9;
                                obj = obj4;
                                function5 = function10;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            c00052 = c00053;
                            serverIds2 = serverIds;
                            referer2 = referer;
                            audioType2 = audioType;
                            function3 = function1;
                            function4 = function2;
                            Result.Companion companion3 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            referer3 = referer2;
                            function5 = function4;
                            function6 = function3;
                            if (Result.exceptionOrNull-impl(obj2) == null) {
                                return Boxing.boxBoolean(false);
                            }
                            serverListHtml = (String) obj2;
                            if (StringsKt.isBlank(serverListHtml)) {
                                return Boxing.boxBoolean(false);
                            }
                            serverDoc = Jsoup.parse(serverListHtml);
                            if (Intrinsics.areEqual(audioType2, "dub")) {
                                iterableListOf = CollectionsKt.listOf("div.type[data-type=dub]");
                            } else {
                                iterableListOf = CollectionsKt.listOf(new String[]{"div.type[data-type=sub]", "div.type[data-type=hsub]"});
                            }
                            typeSelectors = iterableListOf;
                            list$iv$iv = typeSelectors;
                            $i$f$flatMap = 0;
                            destination$iv$iv = new ArrayList();
                            it = list$iv$iv.iterator();
                            while (true) {
                                $this$flatMap$iv = list$iv$iv;
                                if (it.hasNext()) {
                                    obj3 = obj;
                                    referer4 = referer3;
                                    function7 = function6;
                                    function8 = function5;
                                    arrayList = (List) destination$iv$iv;
                                    if (arrayList.isEmpty()) {
                                        i = 0;
                                        $this$map$iv = serverDoc.select("li[data-link-id]");
                                        $i$f$map = 0;
                                        destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                        while (r14.hasNext()) {
                                            Element li4 = (Element) item$iv$iv;
                                            int i3 = i;
                                            String strAttr4 = li4.attr("data-link-id");
                                            string = StringsKt.trim(li4.text()).toString();
                                            if (StringsKt.isBlank(string)) {
                                                string = "Server";
                                            }
                                            destination$iv$iv3.add(new ServerEntry(strAttr4, string, audioType2));
                                            i = i3;
                                            $this$map$iv = $this$map$iv;
                                            $i$f$map = $i$f$map;
                                        }
                                        arrayList = (List) destination$iv$iv3;
                                    }
                                    ArrayList $this$filter$iv2 = arrayList;
                                    destination$iv$iv2 = new ArrayList();
                                    while (r5.hasNext()) {
                                        it2 = (ServerEntry) element$iv$iv;
                                        if (!StringsKt.isBlank(it2.getLinkId())) {
                                            destination$iv$iv2.add(element$iv$iv);
                                        }
                                    }
                                    entries = (List) destination$iv$iv2;
                                    if (entries.isEmpty()) {
                                        return Boxing.boxBoolean(false);
                                    }
                                    found = new Ref.BooleanRef();
                                    c00062 = new C00062(referer4, function7, function8, found, null);
                                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(serverIds2);
                                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(referer4);
                                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(audioType2);
                                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(serverListHtml);
                                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(serverDoc);
                                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(typeSelectors);
                                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(entries);
                                    c00052.L$9 = found;
                                    c00052.label = 2;
                                    if (ParCollectionsKt.amap(entries, c00062, c00052) == obj3) {
                                        return obj3;
                                    }
                                    found2 = found;
                                    return Boxing.boxBoolean(found2.element);
                                }
                                sel = (String) it.next();
                                Object obj5 = obj;
                                String referer6 = referer3;
                                Function1<? super SubtitleFile, Unit> function11 = function6;
                                Function1<? super ExtractorLink, Unit> function12 = function5;
                                int $i$f$flatMap3 = $i$f$flatMap;
                                matchResultFind$default = Regex.find$default(new Regex("data-type=(\\w+)"), sel, 0, 2, (Object) null);
                                sType = matchResultFind$default == null ? audioType2 : audioType2;
                                $this$map$iv2 = serverDoc.select(sel + " li[data-link-id]");
                                $i$f$map2 = 0;
                                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                                while (r25.hasNext()) {
                                    String sel4 = sel;
                                    Element li5 = (Element) item$iv$iv2;
                                    Iterable $this$map$iv5 = $this$map$iv2;
                                    String strAttr5 = li5.attr("data-link-id");
                                    string2 = StringsKt.trim(li5.text()).toString();
                                    if (StringsKt.isBlank(string2)) {
                                        string2 = "Server";
                                    }
                                    destination$iv$iv4.add(new ServerEntry(strAttr5, string2, sType));
                                    sel = sel4;
                                    $this$map$iv2 = $this$map$iv5;
                                    $i$f$map2 = $i$f$map2;
                                }
                                CollectionsKt.addAll(destination$iv$iv, (List) destination$iv$iv4);
                                list$iv$iv = $this$flatMap$iv;
                                $i$f$flatMap = $i$f$flatMap3;
                                referer3 = referer6;
                                function6 = function11;
                                obj = obj5;
                                function5 = function12;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        c00052 = c00053;
                        obj = coroutine_suspended;
                        serverIds2 = serverIds;
                        referer2 = referer;
                        audioType2 = audioType;
                        function3 = function1;
                        function4 = function2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    c00052 = c00053;
                    obj = coroutine_suspended;
                    serverIds2 = serverIds;
                    referer2 = referer;
                    audioType2 = audioType;
                    function3 = function1;
                    function4 = function2;
                }
                break;
            case 1:
                anikoto = (Anikoto) c00053.L$6;
                function4 = (Function1) c00053.L$4;
                function3 = (Function1) c00053.L$3;
                audioType2 = (String) c00053.L$2;
                referer2 = (String) c00053.L$1;
                serverIds2 = (String) c00053.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    c00052 = c00053;
                    obj = coroutine_suspended;
                    obj2 = Result.constructor-impl(anikoto.jsonResultString(((NiceResponse) $result).getText()));
                } catch (Throwable th5) {
                    th = th5;
                    c00052 = c00053;
                    obj = coroutine_suspended;
                    Result.Companion companion4 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                    referer3 = referer2;
                    function5 = function4;
                    function6 = function3;
                    if (Result.exceptionOrNull-impl(obj2) == null) {
                        return Boxing.boxBoolean(false);
                    }
                    serverListHtml = (String) obj2;
                    if (StringsKt.isBlank(serverListHtml)) {
                        return Boxing.boxBoolean(false);
                    }
                    serverDoc = Jsoup.parse(serverListHtml);
                    if (Intrinsics.areEqual(audioType2, "dub")) {
                        iterableListOf = CollectionsKt.listOf("div.type[data-type=dub]");
                    } else {
                        iterableListOf = CollectionsKt.listOf(new String[]{"div.type[data-type=sub]", "div.type[data-type=hsub]"});
                    }
                    typeSelectors = iterableListOf;
                    list$iv$iv = typeSelectors;
                    $i$f$flatMap = 0;
                    destination$iv$iv = new ArrayList();
                    it = list$iv$iv.iterator();
                    while (true) {
                        $this$flatMap$iv = list$iv$iv;
                        if (it.hasNext()) {
                            obj3 = obj;
                            referer4 = referer3;
                            function7 = function6;
                            function8 = function5;
                            arrayList = (List) destination$iv$iv;
                            if (arrayList.isEmpty()) {
                                i = 0;
                                $this$map$iv = serverDoc.select("li[data-link-id]");
                                $i$f$map = 0;
                                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                while (r14.hasNext()) {
                                    Element li6 = (Element) item$iv$iv;
                                    int i4 = i;
                                    String strAttr6 = li6.attr("data-link-id");
                                    string = StringsKt.trim(li6.text()).toString();
                                    if (StringsKt.isBlank(string)) {
                                        string = "Server";
                                    }
                                    destination$iv$iv3.add(new ServerEntry(strAttr6, string, audioType2));
                                    i = i4;
                                    $this$map$iv = $this$map$iv;
                                    $i$f$map = $i$f$map;
                                }
                                arrayList = (List) destination$iv$iv3;
                            }
                            ArrayList $this$filter$iv3 = arrayList;
                            destination$iv$iv2 = new ArrayList();
                            while (r5.hasNext()) {
                                it2 = (ServerEntry) element$iv$iv;
                                if (!StringsKt.isBlank(it2.getLinkId())) {
                                    destination$iv$iv2.add(element$iv$iv);
                                }
                            }
                            entries = (List) destination$iv$iv2;
                            if (entries.isEmpty()) {
                                return Boxing.boxBoolean(false);
                            }
                            found = new Ref.BooleanRef();
                            c00062 = new C00062(referer4, function7, function8, found, null);
                            c00052.L$0 = SpillingKt.nullOutSpilledVariable(serverIds2);
                            c00052.L$1 = SpillingKt.nullOutSpilledVariable(referer4);
                            c00052.L$2 = SpillingKt.nullOutSpilledVariable(audioType2);
                            c00052.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                            c00052.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                            c00052.L$5 = SpillingKt.nullOutSpilledVariable(serverListHtml);
                            c00052.L$6 = SpillingKt.nullOutSpilledVariable(serverDoc);
                            c00052.L$7 = SpillingKt.nullOutSpilledVariable(typeSelectors);
                            c00052.L$8 = SpillingKt.nullOutSpilledVariable(entries);
                            c00052.L$9 = found;
                            c00052.label = 2;
                            if (ParCollectionsKt.amap(entries, c00062, c00052) == obj3) {
                                return obj3;
                            }
                            found2 = found;
                            return Boxing.boxBoolean(found2.element);
                        }
                        sel = (String) it.next();
                        Object obj6 = obj;
                        String referer7 = referer3;
                        Function1<? super SubtitleFile, Unit> function13 = function6;
                        Function1<? super ExtractorLink, Unit> function14 = function5;
                        int $i$f$flatMap4 = $i$f$flatMap;
                        matchResultFind$default = Regex.find$default(new Regex("data-type=(\\w+)"), sel, 0, 2, (Object) null);
                        if (matchResultFind$default == null) {
                        }
                        $this$map$iv2 = serverDoc.select(sel + " li[data-link-id]");
                        $i$f$map2 = 0;
                        destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                        while (r25.hasNext()) {
                            String sel5 = sel;
                            Element li7 = (Element) item$iv$iv2;
                            Iterable $this$map$iv6 = $this$map$iv2;
                            String strAttr7 = li7.attr("data-link-id");
                            string2 = StringsKt.trim(li7.text()).toString();
                            if (StringsKt.isBlank(string2)) {
                                string2 = "Server";
                            }
                            destination$iv$iv4.add(new ServerEntry(strAttr7, string2, sType));
                            sel = sel5;
                            $this$map$iv2 = $this$map$iv6;
                            $i$f$map2 = $i$f$map2;
                        }
                        CollectionsKt.addAll(destination$iv$iv, (List) destination$iv$iv4);
                        list$iv$iv = $this$flatMap$iv;
                        $i$f$flatMap = $i$f$flatMap4;
                        referer3 = referer7;
                        function6 = function13;
                        obj = obj6;
                        function5 = function14;
                    }
                }
                referer3 = referer2;
                function5 = function4;
                function6 = function3;
                if (Result.exceptionOrNull-impl(obj2) == null) {
                    return Boxing.boxBoolean(false);
                }
                serverListHtml = (String) obj2;
                if (StringsKt.isBlank(serverListHtml)) {
                    return Boxing.boxBoolean(false);
                }
                serverDoc = Jsoup.parse(serverListHtml);
                if (Intrinsics.areEqual(audioType2, "dub")) {
                    iterableListOf = CollectionsKt.listOf("div.type[data-type=dub]");
                } else {
                    iterableListOf = CollectionsKt.listOf(new String[]{"div.type[data-type=sub]", "div.type[data-type=hsub]"});
                }
                typeSelectors = iterableListOf;
                list$iv$iv = typeSelectors;
                $i$f$flatMap = 0;
                destination$iv$iv = new ArrayList();
                it = list$iv$iv.iterator();
                while (true) {
                    $this$flatMap$iv = list$iv$iv;
                    if (it.hasNext()) {
                        obj3 = obj;
                        referer4 = referer3;
                        function7 = function6;
                        function8 = function5;
                        arrayList = (List) destination$iv$iv;
                        if (arrayList.isEmpty()) {
                            i = 0;
                            $this$map$iv = serverDoc.select("li[data-link-id]");
                            $i$f$map = 0;
                            destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            while (r14.hasNext()) {
                                Element li8 = (Element) item$iv$iv;
                                int i5 = i;
                                String strAttr8 = li8.attr("data-link-id");
                                string = StringsKt.trim(li8.text()).toString();
                                if (StringsKt.isBlank(string)) {
                                    string = "Server";
                                }
                                destination$iv$iv3.add(new ServerEntry(strAttr8, string, audioType2));
                                i = i5;
                                $this$map$iv = $this$map$iv;
                                $i$f$map = $i$f$map;
                            }
                            arrayList = (List) destination$iv$iv3;
                        }
                        ArrayList $this$filter$iv4 = arrayList;
                        destination$iv$iv2 = new ArrayList();
                        while (r5.hasNext()) {
                            it2 = (ServerEntry) element$iv$iv;
                            if (!StringsKt.isBlank(it2.getLinkId())) {
                                destination$iv$iv2.add(element$iv$iv);
                            }
                        }
                        entries = (List) destination$iv$iv2;
                        if (entries.isEmpty()) {
                            return Boxing.boxBoolean(false);
                        }
                        found = new Ref.BooleanRef();
                        c00062 = new C00062(referer4, function7, function8, found, null);
                        c00052.L$0 = SpillingKt.nullOutSpilledVariable(serverIds2);
                        c00052.L$1 = SpillingKt.nullOutSpilledVariable(referer4);
                        c00052.L$2 = SpillingKt.nullOutSpilledVariable(audioType2);
                        c00052.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                        c00052.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                        c00052.L$5 = SpillingKt.nullOutSpilledVariable(serverListHtml);
                        c00052.L$6 = SpillingKt.nullOutSpilledVariable(serverDoc);
                        c00052.L$7 = SpillingKt.nullOutSpilledVariable(typeSelectors);
                        c00052.L$8 = SpillingKt.nullOutSpilledVariable(entries);
                        c00052.L$9 = found;
                        c00052.label = 2;
                        if (ParCollectionsKt.amap(entries, c00062, c00052) == obj3) {
                            return obj3;
                        }
                        found2 = found;
                        return Boxing.boxBoolean(found2.element);
                    }
                    sel = (String) it.next();
                    Object obj7 = obj;
                    String referer8 = referer3;
                    Function1<? super SubtitleFile, Unit> function15 = function6;
                    Function1<? super ExtractorLink, Unit> function16 = function5;
                    int $i$f$flatMap5 = $i$f$flatMap;
                    matchResultFind$default = Regex.find$default(new Regex("data-type=(\\w+)"), sel, 0, 2, (Object) null);
                    if (matchResultFind$default == null) {
                    }
                    $this$map$iv2 = serverDoc.select(sel + " li[data-link-id]");
                    $i$f$map2 = 0;
                    destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    while (r25.hasNext()) {
                        String sel6 = sel;
                        Element li9 = (Element) item$iv$iv2;
                        Iterable $this$map$iv7 = $this$map$iv2;
                        String strAttr9 = li9.attr("data-link-id");
                        string2 = StringsKt.trim(li9.text()).toString();
                        if (StringsKt.isBlank(string2)) {
                            string2 = "Server";
                        }
                        destination$iv$iv4.add(new ServerEntry(strAttr9, string2, sType));
                        sel = sel6;
                        $this$map$iv2 = $this$map$iv7;
                        $i$f$map2 = $i$f$map2;
                    }
                    CollectionsKt.addAll(destination$iv$iv, (List) destination$iv$iv4);
                    list$iv$iv = $this$flatMap$iv;
                    $i$f$flatMap = $i$f$flatMap5;
                    referer3 = referer8;
                    function6 = function15;
                    obj = obj7;
                    function5 = function16;
                }
                break;
            case 2:
                found2 = (Ref.BooleanRef) c00053.L$9;
                ResultKt.throwOnFailure($result);
                return Boxing.boxBoolean(found2.element);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.anikoto.Anikoto$resolveServers$2 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "entry", "Lcom/anikoto/Anikoto$ServerEntry;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.Anikoto$resolveServers$2", f = "AnikotoProvider.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {261, 270}, m = "invokeSuspend", n = {"entry", "$this$invokeSuspend_u24lambda_u240", "encodedLinkId", "entry", "$this$invokeSuspend_u24lambda_u240", "encodedLinkId", "embedUrl"}, nl = {264, 271}, s = {"L$0", "L$5", "L$6", "L$0", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00062 extends SuspendLambda implements Function2<ServerEntry, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Ref.BooleanRef $found;
        final /* synthetic */ String $referer;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Ref.BooleanRef booleanRef, Continuation<? super C00062> continuation) {
            super(2, continuation);
            this.$referer = str;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$found = booleanRef;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00062 = Anikoto.this.new C00062(this.$referer, this.$subtitleCallback, this.$callback, this.$found, continuation);
            c00062.L$0 = obj;
            return c00062;
        }

        public final Object invoke(ServerEntry serverEntry, Continuation<? super Unit> continuation) {
            return create(serverEntry, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x010e A[Catch: all -> 0x01b1, TryCatch #0 {all -> 0x01b1, blocks: (B:39:0x019f, B:41:0x01a7, B:42:0x01aa, B:21:0x0102, B:23:0x010e, B:25:0x0111, B:27:0x011f, B:29:0x012c, B:35:0x0162, B:30:0x013c, B:32:0x0146, B:34:0x0153, B:17:0x00ef), top: B:51:0x00ef }] */
        /* JADX WARN: Code duplicated, block: B:25:0x0111 A[Catch: all -> 0x01b1, TryCatch #0 {all -> 0x01b1, blocks: (B:39:0x019f, B:41:0x01a7, B:42:0x01aa, B:21:0x0102, B:23:0x010e, B:25:0x0111, B:27:0x011f, B:29:0x012c, B:35:0x0162, B:30:0x013c, B:32:0x0146, B:34:0x0153, B:17:0x00ef), top: B:51:0x00ef }] */
        /* JADX WARN: Code duplicated, block: B:30:0x013c A[Catch: all -> 0x01b1, TryCatch #0 {all -> 0x01b1, blocks: (B:39:0x019f, B:41:0x01a7, B:42:0x01aa, B:21:0x0102, B:23:0x010e, B:25:0x0111, B:27:0x011f, B:29:0x012c, B:35:0x0162, B:30:0x013c, B:32:0x0146, B:34:0x0153, B:17:0x00ef), top: B:51:0x00ef }] */
        /* JADX WARN: Code duplicated, block: B:32:0x0146 A[Catch: all -> 0x01b1, TryCatch #0 {all -> 0x01b1, blocks: (B:39:0x019f, B:41:0x01a7, B:42:0x01aa, B:21:0x0102, B:23:0x010e, B:25:0x0111, B:27:0x011f, B:29:0x012c, B:35:0x0162, B:30:0x013c, B:32:0x0146, B:34:0x0153, B:17:0x00ef), top: B:51:0x00ef }] */
        /* JADX WARN: Code duplicated, block: B:37:0x0198 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:38:0x0199  */
        /* JADX WARN: Code duplicated, block: B:41:0x01a7 A[Catch: all -> 0x01b1, TryCatch #0 {all -> 0x01b1, blocks: (B:39:0x019f, B:41:0x01a7, B:42:0x01aa, B:21:0x0102, B:23:0x010e, B:25:0x0111, B:27:0x011f, B:29:0x012c, B:35:0x0162, B:30:0x013c, B:32:0x0146, B:34:0x0153, B:17:0x00ef), top: B:51:0x00ef }] */
        public final Object invokeSuspend(Object $result) {
            int i;
            String encodedLinkId;
            Object obj;
            Object obj2;
            String str;
            Ref.BooleanRef booleanRef;
            Anikoto anikoto;
            Anikoto $this$invokeSuspend_u24lambda_u240;
            Function1<SubtitleFile, Unit> function1;
            Function1<ExtractorLink, Unit> function2;
            String strJsonResultUrl;
            String embedUrl;
            Object obj3;
            Object objResolveEmbed;
            Ref.BooleanRef booleanRef2;
            C00062 c00062 = this;
            ServerEntry entry = (ServerEntry) c00062.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (c00062.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Anikoto $this$invokeSuspend_u24lambda_u241 = Anikoto.this;
                        String str2 = c00062.$referer;
                        Function1<SubtitleFile, Unit> function3 = c00062.$subtitleCallback;
                        Function1<ExtractorLink, Unit> function4 = c00062.$callback;
                        Ref.BooleanRef booleanRef3 = c00062.$found;
                        try {
                            Result.Companion companion = Result.Companion;
                            i = 0;
                            String encodedLinkId2 = URLEncoder.encode(entry.getLinkId(), "UTF-8");
                            Requests app = MainActivityKt.getApp();
                            String str3 = $this$invokeSuspend_u24lambda_u241.getMainUrl() + "/ajax/server?get=" + encodedLinkId2;
                            Map mapAjaxHeaders = $this$invokeSuspend_u24lambda_u241.ajaxHeaders(str2);
                            c00062.L$0 = entry;
                            c00062.L$1 = str2;
                            c00062.L$2 = function3;
                            c00062.L$3 = function4;
                            c00062.L$4 = booleanRef3;
                            c00062.L$5 = $this$invokeSuspend_u24lambda_u241;
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(encodedLinkId2);
                            c00062.L$7 = $this$invokeSuspend_u24lambda_u241;
                            c00062.label = 1;
                            encodedLinkId = encodedLinkId2;
                            obj = coroutine_suspended;
                            try {
                                obj2 = Requests.get$default(app, str3, mapAjaxHeaders, str2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4088, (Object) null);
                                c00062 = this;
                                if (obj2 == obj) {
                                    return obj;
                                }
                                str = str2;
                                booleanRef = booleanRef3;
                                anikoto = $this$invokeSuspend_u24lambda_u241;
                                $this$invokeSuspend_u24lambda_u240 = anikoto;
                                function1 = function3;
                                function2 = function4;
                                strJsonResultUrl = anikoto.jsonResultUrl(((NiceResponse) obj2).getText());
                                if (strJsonResultUrl == null) {
                                    return Unit.INSTANCE;
                                }
                                embedUrl = strJsonResultUrl;
                                if (!Intrinsics.areEqual(entry.getServerType(), "dub") && StringsKt.contains$default(embedUrl, "/sub", false, 2, (Object) null)) {
                                    embedUrl = StringsKt.replace$default(embedUrl, "/sub", "/dub", false, 4, (Object) null);
                                } else if (!Intrinsics.areEqual(entry.getServerType(), "dub") && StringsKt.contains$default(embedUrl, "/dub", false, 2, (Object) null)) {
                                    embedUrl = StringsKt.replace$default(embedUrl, "/dub", "/sub", false, 4, (Object) null);
                                }
                                String serverName = entry.getServerName();
                                String serverType = entry.getServerType();
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(entry);
                                c00062.L$1 = booleanRef;
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u240);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(encodedLinkId);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(embedUrl);
                                c00062.L$5 = null;
                                c00062.L$6 = null;
                                c00062.L$7 = null;
                                c00062.label = 2;
                                Function1<SubtitleFile, Unit> function5 = function1;
                                obj3 = obj;
                                objResolveEmbed = $this$invokeSuspend_u24lambda_u240.resolveEmbed(embedUrl, str, serverName, serverType, function5, function2, c00062);
                                if (objResolveEmbed == obj3) {
                                    return obj3;
                                }
                                booleanRef2 = booleanRef;
                                if (((Boolean) objResolveEmbed).booleanValue()) {
                                    booleanRef2.element = true;
                                }
                                Result.constructor-impl(Unit.INSTANCE);
                                return Unit.INSTANCE;
                            } catch (Throwable th) {
                                th = th;
                                Result.Companion companion2 = Result.Companion;
                                Result.constructor-impl(ResultKt.createFailure(th));
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        break;
                    case 1:
                        anikoto = (Anikoto) c00062.L$7;
                        String encodedLinkId3 = (String) c00062.L$6;
                        $this$invokeSuspend_u24lambda_u240 = (Anikoto) c00062.L$5;
                        booleanRef = (Ref.BooleanRef) c00062.L$4;
                        Function1<ExtractorLink, Unit> function6 = (Function1) c00062.L$3;
                        function1 = (Function1) c00062.L$2;
                        str = (String) c00062.L$1;
                        ResultKt.throwOnFailure($result);
                        obj = coroutine_suspended;
                        i = 0;
                        encodedLinkId = encodedLinkId3;
                        function2 = function6;
                        obj2 = $result;
                        strJsonResultUrl = anikoto.jsonResultUrl(((NiceResponse) obj2).getText());
                        if (strJsonResultUrl == null) {
                            return Unit.INSTANCE;
                        }
                        embedUrl = strJsonResultUrl;
                        if (!Intrinsics.areEqual(entry.getServerType(), "dub")) {
                            if (!Intrinsics.areEqual(entry.getServerType(), "dub")) {
                                embedUrl = StringsKt.replace$default(embedUrl, "/dub", "/sub", false, 4, (Object) null);
                            }
                        } else if (!Intrinsics.areEqual(entry.getServerType(), "dub")) {
                            embedUrl = StringsKt.replace$default(embedUrl, "/dub", "/sub", false, 4, (Object) null);
                        }
                        String serverName2 = entry.getServerName();
                        String serverType2 = entry.getServerType();
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(entry);
                        c00062.L$1 = booleanRef;
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u240);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(encodedLinkId);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(embedUrl);
                        c00062.L$5 = null;
                        c00062.L$6 = null;
                        c00062.L$7 = null;
                        c00062.label = 2;
                        Function1<SubtitleFile, Unit> function7 = function1;
                        obj3 = obj;
                        objResolveEmbed = $this$invokeSuspend_u24lambda_u240.resolveEmbed(embedUrl, str, serverName2, serverType2, function7, function2, c00062);
                        if (objResolveEmbed == obj3) {
                            return obj3;
                        }
                        booleanRef2 = booleanRef;
                        if (((Boolean) objResolveEmbed).booleanValue()) {
                            booleanRef2.element = true;
                        }
                        Result.constructor-impl(Unit.INSTANCE);
                        return Unit.INSTANCE;
                    case 2:
                        booleanRef2 = (Ref.BooleanRef) c00062.L$1;
                        ResultKt.throwOnFailure($result);
                        objResolveEmbed = $result;
                        if (((Boolean) objResolveEmbed).booleanValue()) {
                            booleanRef2.element = true;
                        }
                        Result.constructor-impl(Unit.INSTANCE);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:76:0x0317  */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code duplicated, block: B:98:0x03d0  */
    public final Object resolveEmbed(String url, String referer, String serverName, String serverType, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) {
        C00041 c00041;
        String str;
        String str2;
        int i;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        String normalizedUrl;
        String domain;
        Object $result;
        String typeLabel;
        String referer3;
        int i2;
        Object typeLabel2;
        boolean z;
        List groupValues;
        Object obj;
        boolean z2;
        Object objBoxBoolean;
        boolean zBooleanValue;
        Object objBoxBoolean2;
        Function1<? super ExtractorLink, Unit> function4 = function2;
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
            } else {
                c00041 = new C00041(continuation);
            }
        } else {
            c00041 = new C00041(continuation);
        }
        C00041 c00042 = c00041;
        Object $result2 = c00042.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00042.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                if (StringsKt.startsWith$default(url, "//", false, 2, (Object) null)) {
                    str = "https:" + url;
                } else {
                    str = StringsKt.startsWith$default(url, "/", false, 2, (Object) null) ? getMainUrl() + url : url;
                }
                String normalizedUrl2 = str;
                String typeLabel3 = AnikotoExtractorsKt.serverTypeLabel(serverType);
                String m3u8 = AnikotoExtractorsKt.getHashM3u8(normalizedUrl2);
                if (m3u8 != null) {
                    ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                    Anikoto$resolveEmbed$2$1 anikoto$resolveEmbed$2$1 = new Anikoto$resolveEmbed$2$1(normalizedUrl2, null);
                    c00042.L$0 = SpillingKt.nullOutSpilledVariable(url);
                    c00042.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                    c00042.L$2 = SpillingKt.nullOutSpilledVariable(serverName);
                    c00042.L$3 = SpillingKt.nullOutSpilledVariable(serverType);
                    c00042.L$4 = SpillingKt.nullOutSpilledVariable(function1);
                    c00042.L$5 = SpillingKt.nullOutSpilledVariable(function4);
                    c00042.L$6 = SpillingKt.nullOutSpilledVariable(normalizedUrl2);
                    c00042.L$7 = SpillingKt.nullOutSpilledVariable(typeLabel3);
                    c00042.L$8 = SpillingKt.nullOutSpilledVariable(m3u8);
                    c00042.L$9 = function4;
                    c00042.label = 1;
                    Object objNewExtractorLink = ExtractorApiKt.newExtractorLink("AniKoto", serverName + " [" + typeLabel3 + ']', m3u8, extractorLinkType, anikoto$resolveEmbed$2$1, c00042);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objNewExtractorLink;
                    z2 = true;
                    function4.invoke(obj);
                    return Boxing.boxBoolean(z2);
                }
                MatchResult matchResultFind$default = Regex.find$default(new Regex("https?://([^/]+)"), normalizedUrl2, 0, 2, (Object) null);
                if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) groupValues.get(1)) == null) {
                    str2 = "";
                }
                String domain2 = str2;
                int i3 = (StringsKt.contains(domain2, "megaplay", true) || StringsKt.contains(domain2, "vidwish", true) || StringsKt.contains(domain2, "vidtube", true)) ? 1 : 0;
                if (i3 != 0) {
                    String host = "https://" + domain2;
                    String label = serverName + " [" + typeLabel3 + ']';
                    try {
                        Result.Companion companion = Result.Companion;
                        Anikoto $this$resolveEmbed_u24lambda_u241 = this;
                        c00042.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        c00042.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                        c00042.L$2 = SpillingKt.nullOutSpilledVariable(serverName);
                        c00042.L$3 = SpillingKt.nullOutSpilledVariable(serverType);
                        c00042.L$4 = SpillingKt.nullOutSpilledVariable(function1);
                        c00042.L$5 = SpillingKt.nullOutSpilledVariable(function4);
                        c00042.L$6 = SpillingKt.nullOutSpilledVariable(normalizedUrl2);
                        c00042.L$7 = SpillingKt.nullOutSpilledVariable(typeLabel3);
                        c00042.L$8 = SpillingKt.nullOutSpilledVariable(domain2);
                        c00042.L$9 = SpillingKt.nullOutSpilledVariable(host);
                        c00042.L$10 = SpillingKt.nullOutSpilledVariable(label);
                        c00042.L$11 = SpillingKt.nullOutSpilledVariable($this$resolveEmbed_u24lambda_u241);
                        c00042.I$0 = i3;
                        c00042.label = 2;
                        z = true;
                        try {
                            if (AnikotoExtractorsKt.extractMegaPlayUrl(normalizedUrl2, referer, host, label, function1, function4, c00042) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            try {
                                objBoxBoolean = Result.constructor-impl(Boxing.boxBoolean(z));
                                break;
                            } catch (Throwable th) {
                                th = th;
                                Object $result3 = Result.Companion;
                                objBoxBoolean = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            if (Result.exceptionOrNull-impl(objBoxBoolean) != null) {
                                objBoxBoolean = Boxing.boxBoolean(false);
                            }
                            zBooleanValue = ((Boolean) objBoxBoolean).booleanValue();
                            return Boxing.boxBoolean(zBooleanValue);
                        } catch (Throwable th2) {
                            th = th2;
                            Object $result4 = Result.Companion;
                            objBoxBoolean = Result.constructor-impl(ResultKt.createFailure(th));
                            if (Result.exceptionOrNull-impl(objBoxBoolean) != null) {
                                objBoxBoolean = Boxing.boxBoolean(false);
                            }
                            zBooleanValue = ((Boolean) objBoxBoolean).booleanValue();
                            return Boxing.boxBoolean(zBooleanValue);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    i = i3;
                    try {
                        Result.Companion companion2 = Result.Companion;
                        Anikoto $this$resolveEmbed_u24lambda_u243 = this;
                        c00042.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        c00042.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                        c00042.L$2 = SpillingKt.nullOutSpilledVariable(serverName);
                        c00042.L$3 = SpillingKt.nullOutSpilledVariable(serverType);
                        c00042.L$4 = SpillingKt.nullOutSpilledVariable(function1);
                        c00042.L$5 = SpillingKt.nullOutSpilledVariable(function4);
                        c00042.L$6 = SpillingKt.nullOutSpilledVariable(normalizedUrl2);
                        c00042.L$7 = SpillingKt.nullOutSpilledVariable(typeLabel3);
                        c00042.L$8 = SpillingKt.nullOutSpilledVariable(domain2);
                        c00042.L$9 = SpillingKt.nullOutSpilledVariable($this$resolveEmbed_u24lambda_u243);
                        c00042.I$0 = i;
                        c00042.label = 3;
                        referer2 = referer;
                        function3 = function1;
                        try {
                            Object objLoadExtractor = ExtractorApiKt.loadExtractor(normalizedUrl2, referer2, function3, function4, c00042);
                            if (objLoadExtractor == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            normalizedUrl = normalizedUrl2;
                            $result2 = objLoadExtractor;
                            domain = domain2;
                            referer3 = referer2;
                            i2 = i;
                            typeLabel2 = typeLabel3;
                            typeLabel = serverType;
                            try {
                                objBoxBoolean2 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) $result2).booleanValue()));
                            } catch (Throwable th4) {
                                th = th4;
                                $result = typeLabel2;
                                i = i2;
                                referer2 = referer3;
                                Result.Companion companion3 = Result.Companion;
                                objBoxBoolean2 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            if (Result.exceptionOrNull-impl(objBoxBoolean2) != null) {
                                objBoxBoolean2 = Boxing.boxBoolean(false);
                            }
                            zBooleanValue = ((Boolean) objBoxBoolean2).booleanValue();
                            return Boxing.boxBoolean(zBooleanValue);
                        } catch (Throwable th5) {
                            th = th5;
                            normalizedUrl = normalizedUrl2;
                            domain = domain2;
                            $result = typeLabel3;
                            typeLabel = serverType;
                            Result.Companion companion4 = Result.Companion;
                            objBoxBoolean2 = Result.constructor-impl(ResultKt.createFailure(th));
                            if (Result.exceptionOrNull-impl(objBoxBoolean2) != null) {
                                objBoxBoolean2 = Boxing.boxBoolean(false);
                            }
                            zBooleanValue = ((Boolean) objBoxBoolean2).booleanValue();
                            return Boxing.boxBoolean(zBooleanValue);
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        referer2 = referer;
                        function3 = function1;
                    }
                }
                break;
            case 1:
                Function1<? super ExtractorLink, Unit> function5 = (Function1) c00042.L$9;
                ResultKt.throwOnFailure($result2);
                function4 = function5;
                obj = $result2;
                z2 = true;
                function4.invoke(obj);
                return Boxing.boxBoolean(z2);
            case 2:
                int i4 = c00042.I$0;
                try {
                    ResultKt.throwOnFailure($result2);
                    z = true;
                    objBoxBoolean = Result.constructor-impl(Boxing.boxBoolean(z));
                    break;
                } catch (Throwable th7) {
                    th = th7;
                    Object $result5 = Result.Companion;
                    objBoxBoolean = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.exceptionOrNull-impl(objBoxBoolean) != null) {
                        objBoxBoolean = Boxing.boxBoolean(false);
                    }
                    zBooleanValue = ((Boolean) objBoxBoolean).booleanValue();
                    return Boxing.boxBoolean(zBooleanValue);
                }
                if (Result.exceptionOrNull-impl(objBoxBoolean) != null) {
                    objBoxBoolean = Boxing.boxBoolean(false);
                }
                zBooleanValue = ((Boolean) objBoxBoolean).booleanValue();
                return Boxing.boxBoolean(zBooleanValue);
            case 3:
                i2 = c00042.I$0;
                domain = (String) c00042.L$8;
                Object typeLabel4 = (String) c00042.L$7;
                String normalizedUrl3 = (String) c00042.L$6;
                function4 = (Function1) c00042.L$5;
                Function1<? super SubtitleFile, Unit> function6 = (Function1) c00042.L$4;
                typeLabel = (String) c00042.L$3;
                referer3 = (String) c00042.L$1;
                try {
                    ResultKt.throwOnFailure($result2);
                    typeLabel2 = typeLabel4;
                    function3 = function6;
                    normalizedUrl = normalizedUrl3;
                    objBoxBoolean2 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) $result2).booleanValue()));
                } catch (Throwable th8) {
                    th = th8;
                    $result = typeLabel4;
                    function3 = function6;
                    normalizedUrl = normalizedUrl3;
                    i = i2;
                    referer2 = referer3;
                    Result.Companion companion5 = Result.Companion;
                    objBoxBoolean2 = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.exceptionOrNull-impl(objBoxBoolean2) != null) {
                        objBoxBoolean2 = Boxing.boxBoolean(false);
                    }
                    zBooleanValue = ((Boolean) objBoxBoolean2).booleanValue();
                    return Boxing.boxBoolean(zBooleanValue);
                }
                if (Result.exceptionOrNull-impl(objBoxBoolean2) != null) {
                    objBoxBoolean2 = Boxing.boxBoolean(false);
                }
                zBooleanValue = ((Boolean) objBoxBoolean2).booleanValue();
                return Boxing.boxBoolean(zBooleanValue);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final String jsonResultString(String json) {
        Object obj;
        String asString;
        Object obj2 = "";
        try {
            Result.Companion companion = Result.Companion;
            Anikoto anikoto = this;
            JsonObject obj3 = JsonParser.parseString(json).getAsJsonObject();
            JsonElement jsonElement = obj3.get("status");
            boolean z = false;
            if (jsonElement != null && jsonElement.getAsInt() == 200) {
                z = true;
            }
            if (z) {
                JsonElement jsonElement2 = obj3.get("result");
                asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
                if (asString == null) {
                    asString = "";
                }
            } else {
                asString = "";
            }
            obj = Result.constructor-impl(asString);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) == null) {
            obj2 = obj;
        }
        return (String) obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String jsonResultUrl(String json) {
        Object obj;
        JsonElement jsonElement;
        JsonObject asJsonObject;
        JsonElement jsonElement2;
        Object obj2 = null;
        try {
            Result.Companion companion = Result.Companion;
            Anikoto anikoto = this;
            JsonObject obj3 = JsonParser.parseString(json).getAsJsonObject();
            JsonElement jsonElement3 = obj3.get("status");
            boolean z = false;
            if (jsonElement3 != null && jsonElement3.getAsInt() == 200) {
                z = true;
            }
            String asString = (!z || (jsonElement = obj3.get("result")) == null || (asJsonObject = jsonElement.getAsJsonObject()) == null || (jsonElement2 = asJsonObject.get("url")) == null) ? null : jsonElement2.getAsString();
            obj = Result.constructor-impl(asString);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) == null) {
            obj2 = obj;
        }
        return (String) obj2;
    }

    private final AnimeSearchResponse toSearchResult(Element $this$toSearchResult) {
        String strText;
        String string;
        String strText2;
        String string2;
        String strText3;
        Element titleEl = $this$toSearchResult.selectFirst("a.name.d-title");
        Integer intOrNull = null;
        if (titleEl == null && (titleEl = $this$toSearchResult.selectFirst("a[title]")) == null && (titleEl = $this$toSearchResult.selectFirst("a[href*='/watch/']")) == null) {
            return null;
        }
        String strAttr = titleEl.attr("href");
        if (StringsKt.isBlank(strAttr)) {
            Element elementSelectFirst = $this$toSearchResult.selectFirst("div.poster a, a");
            String strAttr2 = elementSelectFirst != null ? elementSelectFirst.attr("href") : null;
            if (strAttr2 == null) {
                strAttr2 = "";
            }
            strAttr = strAttr2;
        }
        String href = strAttr;
        String string3 = StringsKt.trim(titleEl.text()).toString();
        if (StringsKt.isBlank(string3)) {
            string3 = StringsKt.trim(titleEl.attr("title")).toString();
        }
        String title = string3;
        if (StringsKt.isBlank(href) || StringsKt.isBlank(title)) {
            return null;
        }
        Elements it = $this$toSearchResult.select("div.poster img, img");
        String strAttr3 = it.attr("data-src");
        if (StringsKt.isBlank(strAttr3)) {
            strAttr3 = it.attr("src");
        }
        final String poster = strAttr3;
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst(".type, .right");
        TvType type = elementSelectFirst2 != null && (strText3 = elementSelectFirst2.text()) != null && StringsKt.contains(strText3, "Movie", true) ? TvType.AnimeMovie : TvType.Anime;
        String metaText = $this$toSearchResult.select(".meta, .info, .type, .right").text();
        final boolean hasDub = $this$toSearchResult.selectFirst(".dub, i.dub, .fa-microphone") != null || StringsKt.contains(metaText, "Dub", true);
        final boolean hasSub = ($this$toSearchResult.selectFirst(".sub, i.sub, .fa-closed-captioning") == null && !StringsKt.contains(metaText, "Sub", true) && hasDub) ? false : true;
        Element elementSelectFirst3 = $this$toSearchResult.selectFirst("span.ep-status.sub span");
        final Integer subCount = (elementSelectFirst3 == null || (strText2 = elementSelectFirst3.text()) == null || (string2 = StringsKt.trim(strText2).toString()) == null) ? null : StringsKt.toIntOrNull(string2);
        Element elementSelectFirst4 = $this$toSearchResult.selectFirst("span.ep-status.dub span");
        if (elementSelectFirst4 != null && (strText = elementSelectFirst4.text()) != null && (string = StringsKt.trim(strText).toString()) != null) {
            intOrNull = StringsKt.toIntOrNull(string);
        }
        final Integer dubCount = intOrNull;
        return MainAPIKt.newAnimeSearchResponse$default(this, title, MainAPIKt.fixUrl(this, href), type, false, new Function1() { // from class: com.anikoto.Anikoto$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Anikoto.toSearchResult$lambda$3(this.f$0, poster, hasDub, hasSub, dubCount, subCount, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$3(Anikoto this$0, String $poster, boolean $hasDub, boolean $hasSub, Integer $dubCount, Integer $subCount, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl(MainAPIKt.fixUrl(this$0, $poster));
        MainAPIKt.addDubStatus($this$newAnimeSearchResponse, $hasDub, $hasSub, $dubCount, $subCount);
        return Unit.INSTANCE;
    }
}
