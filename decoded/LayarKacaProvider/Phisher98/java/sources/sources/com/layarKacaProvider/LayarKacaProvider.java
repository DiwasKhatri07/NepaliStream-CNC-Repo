package com.layarKacaProvider;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.AnimeSearchResponse;
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
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.network.CloudflareKiller;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import com.phisher98.donation.DonationManager;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: LayarKacaProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/LayarKacaProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001f\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0096@¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010)J\u000e\u0010*\u001a\u0004\u0018\u00010+*\u00020,H\u0002J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\u001d2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)J\u0016\u0010/\u001a\u0002002\u0006\u0010(\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)JF\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00112\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020705H\u0096@¢\u0006\u0002\u0010:J\u0012\u0010;\u001a\u00020\u0005*\u00020\u0005H\u0082@¢\u0006\u0002\u0010)J\u0016\u0010<\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010)J\f\u0010=\u001a\u00020\u0005*\u00020,H\u0002J\u0010\u0010>\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0005R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006@"}, d2 = {"Lcom/layarKacaProvider/LayarKacaProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "value", "", "mainUrl", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "seriesUrl", "searchurl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProperLink", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIframe", "fetchURL", "getImageAttr", "getBaseUrl", "Companion", "LayarKacaProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLayarKacaProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayarKacaProvider.kt\ncom/layarKacaProvider/LayarKacaProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 5 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n+ 6 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,435:1\n1795#2,10:436\n2068#2:446\n2069#2:448\n1805#2:449\n1849#2,8:450\n1795#2,10:465\n2068#2:475\n2069#2:477\n1805#2:478\n1849#2,8:479\n1739#2:487\n1814#2,3:488\n1795#2,10:491\n2068#2:501\n2069#2:503\n1805#2:504\n1849#2,8:505\n2068#2:516\n2069#2:523\n2068#2,2:524\n2068#2,2:526\n2068#2:528\n2069#2:531\n1#3:447\n1#3:458\n1#3:476\n1#3:502\n1#3:513\n437#4:459\n513#4,5:460\n437#4:517\n513#4,5:518\n32#5,2:514\n1505#6,2:529\n*S KotlinDebug\n*F\n+ 1 LayarKacaProvider.kt\ncom/layarKacaProvider/LayarKacaProvider\n*L\n73#1:436,10\n73#1:446\n73#1:448\n73#1:449\n75#1:450,8\n166#1:465,10\n166#1:475\n166#1:477\n166#1:478\n171#1:479,8\n182#1:487\n182#1:488,3\n195#1:491,10\n195#1:501\n195#1:503\n195#1:504\n203#1:505,8\n228#1:516\n228#1:523\n285#1:524,2\n310#1:526,2\n319#1:528\n319#1:531\n73#1:447\n166#1:476\n195#1:502\n105#1:459\n105#1:460,5\n230#1:517\n230#1:518,5\n210#1:514,2\n321#1:529,2\n*E\n"})
public final class LayarKacaProvider extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String DEFAULT_UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36";

    @NotNull
    private String seriesUrl = "https://tv1.layanfilem.my";

    @NotNull
    private String searchurl = "https://gudangvape.com";

    @NotNull
    private String name = "LayarKaca";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "id";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.AsianDrama});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/populer/page/", "Film Terplopuler"), TuplesKt.to(getMainUrl() + "/rating/page/", "Film Berdasarkan IMDb Rating"), TuplesKt.to(getMainUrl() + "/most-commented/page/", "Film Dengan Komentar Terbanyak"), TuplesKt.to(this.seriesUrl + "/latest-series/page/", "Series Terbaru"), TuplesKt.to(this.seriesUrl + "/series/asian/page/", "Film Asian Terbaru"), TuplesKt.to(getMainUrl() + "/latest/page/", "Film Upload Terbaru")});

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$fetchURL$1 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider", f = "LayarKacaProvider.kt", i = {0}, l = {410}, m = "fetchURL", n = {"url"}, nl = {411}, s = {"L$0"}, v = 2)
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
            return LayarKacaProvider.this.fetchURL(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$getIframe$1 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider", f = "LayarKacaProvider.kt", i = {0, 0}, l = {390}, m = "getIframe", n = {"$this$getIframe", "base"}, nl = {391}, s = {"L$0", "L$1"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayarKacaProvider.this.getIframe(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$getMainPage$1 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider", f = "LayarKacaProvider.kt", i = {0, 0}, l = {72}, m = "getMainPage", n = {"request", "page"}, nl = {73}, s = {"L$0", "I$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayarKacaProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$getProperLink$1 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider", f = "LayarKacaProvider.kt", i = {0}, l = {82}, m = "getProperLink", n = {"url"}, nl = {83}, s = {"L$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayarKacaProvider.this.getProperLink(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$load$1 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider", f = "LayarKacaProvider.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {175, 176, 177, 241, 252}, m = "load", n = {"url", "url", "fixUrl", "url", "fixUrl", "document", "url", "fixUrl", "document", "baseurl", "title", "poster", "tags", "posterheaders", "year", "tvType", "description", "trailer", "rating", "recommendations", "json", "episodes", "url", "fixUrl", "document", "baseurl", "title", "poster", "tags", "posterheaders", "year", "tvType", "description", "trailer", "rating", "recommendations"}, nl = {176, 177, 178, 252, 205}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
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

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayarKacaProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$loadLinks$1 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider", f = "LayarKacaProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {271, 332}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "playerUrls", "scriptRegex", "distinctUrls", "isCasting"}, nl = {272, 384}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayarKacaProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$search$1 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider", f = "LayarKacaProvider.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {125, 132, 165}, m = "search", n = {"query", "results", "query", "results", "refer", "query", "results", "refer", "res", "trimmed", "$this$search_u24lambda_u243"}, nl = {126, 133, 165}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00111(Continuation<? super C00111> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayarKacaProvider.this.search(null, (Continuation) this);
        }
    }

    @NotNull
    public String getMainUrl() {
        return LayarKacaProviderPlugin.INSTANCE.getCurrentMainUrl();
    }

    public void setMainUrl(@NotNull String value) {
        LayarKacaProviderPlugin.INSTANCE.setCurrentMainUrl(value);
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

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/layarKacaProvider/LayarKacaProvider$Companion;", "", "<init>", "()V", "DEFAULT_UA", "", "appGet", "Lcom/lagradost/nicehttp/NiceResponse;", "url", "headers", "", "referer", "allowRedirects", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LayarKacaProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object appGet$default(Companion companion, String str, Map map, String str2, boolean z, Continuation continuation, int i, Object obj) {
            return companion.appGet(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? true : z, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x0193 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:40:0x0194  */
        /* JADX WARN: Code duplicated, block: B:7:0x001a  */
        @Nullable
        public final Object appGet(@NotNull String url, @NotNull Map<String, String> map, @Nullable String referer, boolean allowRedirects, @NotNull Continuation<? super NiceResponse> continuation) {
            LayarKacaProvider$Companion$appGet$1 layarKacaProvider$Companion$appGet$1;
            Object obj;
            int i;
            String url2;
            String referer2;
            boolean allowRedirects2;
            Map allHeaders;
            Map allHeaders2;
            Map<String, String> map2;
            Object obj2;
            String url3;
            Map<String, String> map3;
            String referer3;
            boolean allowRedirects3;
            Map allHeaders3;
            Object obj3;
            Map<String, String> map4;
            String url4;
            boolean allowRedirects4;
            if (continuation instanceof LayarKacaProvider$Companion$appGet$1) {
                layarKacaProvider$Companion$appGet$1 = (LayarKacaProvider$Companion$appGet$1) continuation;
                if ((layarKacaProvider$Companion$appGet$1.label & Integer.MIN_VALUE) != 0) {
                    layarKacaProvider$Companion$appGet$1.label -= Integer.MIN_VALUE;
                } else {
                    layarKacaProvider$Companion$appGet$1 = new LayarKacaProvider$Companion$appGet$1(this, continuation);
                }
            } else {
                layarKacaProvider$Companion$appGet$1 = new LayarKacaProvider$Companion$appGet$1(this, continuation);
            }
            LayarKacaProvider$Companion$appGet$1 layarKacaProvider$Companion$appGet$2 = layarKacaProvider$Companion$appGet$1;
            Object $result = layarKacaProvider$Companion$appGet$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (layarKacaProvider$Companion$appGet$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Map allHeaders4 = MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36"), TuplesKt.to("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8"), TuplesKt.to("accept-language", "en-US,en;q=0.9"), TuplesKt.to("sec-ch-ua-mobile", "?0"), TuplesKt.to("sec-ch-ua-platform", "\"Windows\"")}), map);
                    try {
                        Requests app = MainActivityKt.getApp();
                        boolean z = allowRedirects;
                        Interceptor cloudflareKiller = new CloudflareKiller();
                        layarKacaProvider$Companion$appGet$2.L$0 = url;
                        layarKacaProvider$Companion$appGet$2.L$1 = SpillingKt.nullOutSpilledVariable(map);
                        layarKacaProvider$Companion$appGet$2.L$2 = referer;
                        layarKacaProvider$Companion$appGet$2.L$3 = allHeaders4;
                        layarKacaProvider$Companion$appGet$2.Z$0 = allowRedirects;
                        layarKacaProvider$Companion$appGet$2.label = 1;
                        obj = coroutine_suspended;
                        i = 2;
                        try {
                            obj2 = Requests.get$default(app, url, allHeaders4, referer, (Map) null, (Map) null, z, 0, (TimeUnit) null, 0L, cloudflareKiller, false, (ResponseParser) null, layarKacaProvider$Companion$appGet$2, 3544, (Object) null);
                            layarKacaProvider$Companion$appGet$2 = layarKacaProvider$Companion$appGet$2;
                            if (obj2 == obj) {
                                return obj;
                            }
                            url3 = url;
                            map3 = map;
                            referer3 = referer;
                            allowRedirects3 = allowRedirects;
                            allHeaders = allHeaders4;
                            try {
                                return (NiceResponse) obj2;
                            } catch (Throwable th) {
                                allHeaders2 = th;
                                referer2 = referer3;
                                map2 = map3;
                                allowRedirects2 = allowRedirects3;
                                url2 = url3;
                                Map map5 = allHeaders2;
                                Requests app2 = MainActivityKt.getApp();
                                layarKacaProvider$Companion$appGet$2.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                layarKacaProvider$Companion$appGet$2.L$1 = SpillingKt.nullOutSpilledVariable(map2);
                                layarKacaProvider$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                                layarKacaProvider$Companion$appGet$2.L$3 = SpillingKt.nullOutSpilledVariable(allHeaders);
                                layarKacaProvider$Companion$appGet$2.L$4 = SpillingKt.nullOutSpilledVariable(map5);
                                layarKacaProvider$Companion$appGet$2.Z$0 = allowRedirects2;
                                layarKacaProvider$Companion$appGet$2.label = i;
                                allHeaders3 = allHeaders;
                                obj3 = Requests.get$default(app2, url2, allHeaders3, referer2, (Map) null, (Map) null, allowRedirects2, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, layarKacaProvider$Companion$appGet$2, 4056, (Object) null);
                                if (obj3 == obj) {
                                    return obj;
                                }
                                map4 = map2;
                                url4 = url2;
                                allowRedirects4 = allowRedirects2;
                                $result = obj3;
                                return (NiceResponse) $result;
                            }
                        } catch (Throwable th2) {
                            layarKacaProvider$Companion$appGet$2 = layarKacaProvider$Companion$appGet$2;
                            url2 = url;
                            referer2 = referer;
                            allowRedirects2 = allowRedirects;
                            allHeaders = allHeaders4;
                            allHeaders2 = th2;
                            map2 = map;
                            Map map6 = allHeaders2;
                            Requests app3 = MainActivityKt.getApp();
                            layarKacaProvider$Companion$appGet$2.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            layarKacaProvider$Companion$appGet$2.L$1 = SpillingKt.nullOutSpilledVariable(map2);
                            layarKacaProvider$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                            layarKacaProvider$Companion$appGet$2.L$3 = SpillingKt.nullOutSpilledVariable(allHeaders);
                            layarKacaProvider$Companion$appGet$2.L$4 = SpillingKt.nullOutSpilledVariable(map6);
                            layarKacaProvider$Companion$appGet$2.Z$0 = allowRedirects2;
                            layarKacaProvider$Companion$appGet$2.label = i;
                            allHeaders3 = allHeaders;
                            obj3 = Requests.get$default(app3, url2, allHeaders3, referer2, (Map) null, (Map) null, allowRedirects2, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, layarKacaProvider$Companion$appGet$2, 4056, (Object) null);
                            if (obj3 == obj) {
                                return obj;
                            }
                            map4 = map2;
                            url4 = url2;
                            allowRedirects4 = allowRedirects2;
                            $result = obj3;
                            return (NiceResponse) $result;
                        }
                    } catch (Throwable th3) {
                        obj = coroutine_suspended;
                        i = 2;
                        url2 = url;
                        referer2 = referer;
                        allowRedirects2 = allowRedirects;
                        allHeaders = allHeaders4;
                        allHeaders2 = th3;
                        map2 = map;
                    }
                    break;
                case 1:
                    boolean allowRedirects5 = layarKacaProvider$Companion$appGet$2.Z$0;
                    allHeaders = (Map) layarKacaProvider$Companion$appGet$2.L$3;
                    referer3 = (String) layarKacaProvider$Companion$appGet$2.L$2;
                    map3 = (Map) layarKacaProvider$Companion$appGet$2.L$1;
                    url3 = (String) layarKacaProvider$Companion$appGet$2.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        obj2 = $result;
                        i = 2;
                        allowRedirects3 = allowRedirects5;
                        obj = coroutine_suspended;
                        return (NiceResponse) obj2;
                    } catch (Throwable th4) {
                        allHeaders2 = th4;
                        map2 = map3;
                        allowRedirects2 = allowRedirects5;
                        obj = coroutine_suspended;
                        referer2 = referer3;
                        url2 = url3;
                        i = 2;
                        Map map7 = allHeaders2;
                        Requests app4 = MainActivityKt.getApp();
                        layarKacaProvider$Companion$appGet$2.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        layarKacaProvider$Companion$appGet$2.L$1 = SpillingKt.nullOutSpilledVariable(map2);
                        layarKacaProvider$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                        layarKacaProvider$Companion$appGet$2.L$3 = SpillingKt.nullOutSpilledVariable(allHeaders);
                        layarKacaProvider$Companion$appGet$2.L$4 = SpillingKt.nullOutSpilledVariable(map7);
                        layarKacaProvider$Companion$appGet$2.Z$0 = allowRedirects2;
                        layarKacaProvider$Companion$appGet$2.label = i;
                        allHeaders3 = allHeaders;
                        obj3 = Requests.get$default(app4, url2, allHeaders3, referer2, (Map) null, (Map) null, allowRedirects2, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, layarKacaProvider$Companion$appGet$2, 4056, (Object) null);
                        if (obj3 == obj) {
                            return obj;
                        }
                        map4 = map2;
                        url4 = url2;
                        allowRedirects4 = allowRedirects2;
                        $result = obj3;
                        return (NiceResponse) $result;
                    }
                case 2:
                    allowRedirects4 = layarKacaProvider$Companion$appGet$2.Z$0;
                    allHeaders3 = (Map) layarKacaProvider$Companion$appGet$2.L$3;
                    referer2 = (String) layarKacaProvider$Companion$appGet$2.L$2;
                    map4 = (Map) layarKacaProvider$Companion$appGet$2.L$1;
                    url4 = (String) layarKacaProvider$Companion$appGet$2.L$0;
                    ResultKt.throwOnFailure($result);
                    return (NiceResponse) $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws IOException {
        C00041 c00041;
        MainPageRequest request2;
        Object objAppGet$default;
        int page2 = page;
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
        Object $result = c00042.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00042.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow(getName());
                Companion companion = INSTANCE;
                String str = request.getData() + page2;
                request2 = request;
                c00042.L$0 = request2;
                c00042.I$0 = page2;
                c00042.label = 1;
                objAppGet$default = Companion.appGet$default(companion, str, null, null, false, c00042, 14, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                page2 = c00042.I$0;
                MainPageRequest request3 = (MainPageRequest) c00042.L$0;
                ResultKt.throwOnFailure($result);
                request2 = request3;
                objAppGet$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) objAppGet$default).getDocument();
        Iterable $this$mapNotNull$iv = document.select("article");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        Iterable $this$distinctBy$iv = (List) destination$iv$iv;
        HashSet set$iv = new HashSet();
        ArrayList list$iv = new ArrayList();
        for (Object e$iv : $this$distinctBy$iv) {
            SearchResponse it2 = (SearchResponse) e$iv;
            page2 = page2;
            if (set$iv.add(StringsKt.trimEnd(it2.getUrl(), new char[]{'/'}))) {
                list$iv.add(e$iv);
            }
        }
        ArrayList home = list$iv;
        return MainAPIKt.newHomePageResponse$default(request2.getName(), home, (Boolean) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x007d A[Catch: all -> 0x00a1, TRY_LEAVE, TryCatch #0 {all -> 0x00a1, blocks: (B:26:0x0061, B:28:0x007d, B:31:0x0087, B:33:0x008d, B:35:0x0095, B:23:0x005a), top: B:48:0x005a }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0095 A[Catch: all -> 0x00a1, TRY_LEAVE, TryCatch #0 {all -> 0x00a1, blocks: (B:26:0x0061, B:28:0x007d, B:31:0x0087, B:33:0x008d, B:35:0x0095, B:23:0x005a), top: B:48:0x005a }] */
    /* JADX WARN: Code duplicated, block: B:38:0x009c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getProperLink(String url, Continuation<? super String> continuation) {
        C00051 c00051;
        String url2;
        Object objAppGet$default;
        Document res;
        Element elementSelectFirst;
        String strAttr;
        String strAttr2;
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
        C00051 c00052 = c00051;
        Object $result = c00052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00052.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    if (StringsKt.startsWith$default(url, this.seriesUrl, false, 2, (Object) null)) {
                        return url;
                    }
                    Companion companion = INSTANCE;
                    c00052.L$0 = url;
                    c00052.label = 1;
                    url2 = url;
                    try {
                        objAppGet$default = Companion.appGet$default(companion, url2, null, null, false, c00052, 14, null);
                        if (objAppGet$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        res = ((NiceResponse) objAppGet$default).getDocument();
                        if (StringsKt.contains(res.select("title").text(), "Nontondrama", true)) {
                            elementSelectFirst = res.selectFirst("a#openNow");
                            if (elementSelectFirst == null && (strAttr2 = elementSelectFirst.attr("href")) != null) {
                                return strAttr2;
                            }
                            Element elementSelectFirst2 = res.selectFirst("div.links a");
                            strAttr = elementSelectFirst2 != null ? elementSelectFirst2.attr("href") : null;
                            if (strAttr != null) {
                                return strAttr;
                            }
                            break;
                        }
                        return url2;
                    } catch (Throwable th) {
                        url = url2;
                        return url;
                    }
                } catch (Throwable th2) {
                    return url;
                }
            case 1:
                url = (String) c00052.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    url2 = url;
                    objAppGet$default = $result;
                    res = ((NiceResponse) objAppGet$default).getDocument();
                    if (StringsKt.contains(res.select("title").text(), "Nontondrama", true)) {
                        elementSelectFirst = res.selectFirst("a#openNow");
                        if (elementSelectFirst == null) {
                        }
                        Element elementSelectFirst3 = res.selectFirst("div.links a");
                        if (elementSelectFirst3 != null) {
                        }
                        if (strAttr != null) {
                            return strAttr;
                        }
                        break;
                    }
                    return url2;
                } catch (Throwable th3) {
                    return url;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004c  */
    private final SearchResponse toSearchResult(Element $this$toSearchResult) throws IOException {
        Element elementSelectFirst;
        String strText;
        String string;
        CharSequence $this$filter$iv;
        String strOwnText;
        String string2;
        String strText2;
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("h3, h1, .grid-title, .entry-title");
        final Integer episode = null;
        if (elementSelectFirst2 == null || (strOwnText = elementSelectFirst2.ownText()) == null || (string2 = StringsKt.trim(strOwnText).toString()) == null) {
            elementSelectFirst = $this$toSearchResult.selectFirst("h3, h1, .grid-title, .entry-title");
            if (elementSelectFirst != null || (strText = elementSelectFirst.text()) == null) {
                return null;
            }
            string = StringsKt.trim(strText).toString();
        } else {
            String string3 = string2;
            if (string3.length() == 0) {
                Element elementSelectFirst3 = $this$toSearchResult.selectFirst("h3, h1, .grid-title, .entry-title");
                string3 = (elementSelectFirst3 == null || (strText2 = elementSelectFirst3.text()) == null) ? null : StringsKt.trim(strText2).toString();
            }
            string = string3;
            if (string == null) {
                elementSelectFirst = $this$toSearchResult.selectFirst("h3, h1, .grid-title, .entry-title");
                if (elementSelectFirst != null) {
                }
                return null;
            }
        }
        String title = string;
        LayarKacaProvider layarKacaProvider = this;
        Element elementSelectFirst4 = $this$toSearchResult.selectFirst("a");
        String href = MainAPIKt.fixUrlNull(layarKacaProvider, elementSelectFirst4 != null ? elementSelectFirst4.attr("href") : null);
        if (href == null) {
            return null;
        }
        LayarKacaProvider layarKacaProvider2 = this;
        Element elementSelectFirst5 = $this$toSearchResult.selectFirst("img");
        final String posterUrl = MainAPIKt.fixUrlNull(layarKacaProvider2, elementSelectFirst5 != null ? getImageAttr(elementSelectFirst5) : null);
        TvType type = $this$toSearchResult.selectFirst("span.episode, .episode") == null ? TvType.Movie : TvType.TvSeries;
        final Map posterheaders = MapsKt.mapOf(TuplesKt.to("Referer", getBaseUrl(posterUrl)));
        if (type != TvType.TvSeries) {
            final String quality = StringsKt.trim($this$toSearchResult.select("div.quality, span.quality").text()).toString();
            return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return LayarKacaProvider.toSearchResult$lambda$3(posterUrl, posterheaders, quality, (MovieSearchResponse) obj);
                }
            }, 8, (Object) null);
        }
        Element elementSelectFirst6 = $this$toSearchResult.selectFirst("span.episode strong, span.episode, .episode");
        if (elementSelectFirst6 != null && ($this$filter$iv = elementSelectFirst6.text()) != null) {
            CharSequence $this$filterTo$iv$iv = $this$filter$iv;
            Appendable destination$iv$iv = new StringBuilder();
            int length = $this$filterTo$iv$iv.length();
            for (int index$iv$iv = 0; index$iv$iv < length; index$iv$iv++) {
                char element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
                if (Character.isDigit(element$iv$iv)) {
                    destination$iv$iv.append(element$iv$iv);
                }
            }
            String $this$filter$iv2 = ((StringBuilder) destination$iv$iv).toString();
            if ($this$filter$iv2 != null) {
                episode = StringsKt.toIntOrNull($this$filter$iv2);
            }
        }
        return MainAPIKt.newAnimeSearchResponse$default(this, title, href, TvType.TvSeries, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return LayarKacaProvider.toSearchResult$lambda$2(posterUrl, posterheaders, episode, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$2(String $posterUrl, Map $posterheaders, Integer $episode, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($posterUrl);
        $this$newAnimeSearchResponse.setPosterHeaders($posterheaders);
        MainAPIKt.addSub($this$newAnimeSearchResponse, $episode);
        return Unit.INSTANCE;
    }

    static final Unit toSearchResult$lambda$3(String $posterUrl, Map $posterheaders, String $quality, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setPosterHeaders($posterheaders);
        MainAPIKt.addQuality((SearchResponse) $this$newMovieSearchResponse, $quality);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x032b  */
    /* JADX WARN: Code duplicated, block: B:109:0x032e  */
    /* JADX WARN: Code duplicated, block: B:113:0x034a  */
    /* JADX WARN: Code duplicated, block: B:130:0x0234 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:0x035d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x0344 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x00f6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:59:0x0150  */
    /* JADX WARN: Code duplicated, block: B:62:0x0155  */
    /* JADX WARN: Code duplicated, block: B:63:0x015c  */
    /* JADX WARN: Code duplicated, block: B:65:0x015f  */
    /* JADX WARN: Code duplicated, block: B:67:0x0166  */
    /* JADX WARN: Code duplicated, block: B:69:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:72:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:75:0x0227  */
    /* JADX WARN: Code duplicated, block: B:76:0x022c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:83:0x028d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:84:0x028e  */
    /* JADX WARN: Code duplicated, block: B:94:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:95:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:98:0x02d6  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws JSONException, IOException {
        C00111 c00111;
        String query2;
        List results;
        Object objAppGet$default;
        String refer;
        List results2;
        String query3;
        String refer2;
        List results3;
        String query4;
        String query5;
        Object objAppGet$default2;
        String text;
        String refer3;
        List results4;
        String query6;
        String res;
        String trimmed;
        Object obj;
        JSONObject root;
        JSONArray arr;
        String trimmed2;
        int i;
        int length;
        String title;
        String slug;
        String type;
        final String posterUrl;
        String trimmed3;
        String query7;
        List results5;
        String refer4;
        String res2;
        String trimmed4;
        List results6;
        String query8;
        Object objAppGet$default3;
        Object obj2;
        HashSet set$iv;
        ArrayList list$iv;
        SearchResponse it;
        Object obj3;
        Document searchDoc;
        Iterable iterableSelect;
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
                List results7 = new ArrayList();
                try {
                    Companion companion = INSTANCE;
                    String mainUrl = getMainUrl();
                    c00112.L$0 = query;
                    c00112.L$1 = results7;
                    c00112.label = 1;
                    objAppGet$default = Companion.appGet$default(companion, mainUrl, null, null, false, c00112, 14, null);
                    if (objAppGet$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    query2 = query;
                    results = results7;
                    refer = ((NiceResponse) objAppGet$default).getUrl();
                    results2 = results;
                    query3 = query2;
                    try {
                        Companion companion2 = INSTANCE;
                        String str = this.searchurl + "/search.php?s=" + query3;
                        c00112.L$0 = query3;
                        c00112.L$1 = results2;
                        c00112.L$2 = SpillingKt.nullOutSpilledVariable(refer);
                        c00112.label = 2;
                        query5 = query3;
                        try {
                            objAppGet$default2 = Companion.appGet$default(companion2, str, null, refer, false, c00112, 10, null);
                            if (objAppGet$default2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            refer2 = refer;
                            results3 = results2;
                            query4 = query5;
                            text = ((NiceResponse) objAppGet$default2).getText();
                            refer3 = refer2;
                            results4 = results3;
                            query6 = query4;
                            res = text;
                            trimmed = StringsKt.trim(res).toString();
                            if (StringsKt.startsWith$default(trimmed, "{", false, 2, (Object) null)) {
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    LayarKacaProvider layarKacaProvider = this;
                                    obj = Result.constructor-impl(new JSONObject(trimmed));
                                } catch (Throwable th) {
                                    Result.Companion companion4 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                                if (Result.isFailure-impl(obj)) {
                                    obj = null;
                                }
                                root = (JSONObject) obj;
                                if (root != null) {
                                    arr = root.optJSONArray("data");
                                } else {
                                    arr = null;
                                }
                                if (arr != null) {
                                    i = 0;
                                    length = arr.length();
                                    while (i < length) {
                                        JSONObject item = arr.getJSONObject(i);
                                        title = item.getString("title");
                                        slug = item.getString("slug");
                                        type = item.getString("type");
                                        JSONObject root2 = root;
                                        posterUrl = "https://static-jpg.lk21.party/wp-content/uploads/" + item.optString("poster");
                                        if (Intrinsics.areEqual(type, "series")) {
                                            trimmed3 = trimmed;
                                            results4.add(MainAPIKt.newTvSeriesSearchResponse$default(this, title, this.seriesUrl + '/' + slug, TvType.TvSeries, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda2
                                                public final Object invoke(Object obj4) {
                                                    return LayarKacaProvider.search$lambda$1(posterUrl, (TvSeriesSearchResponse) obj4);
                                                }
                                            }, 8, (Object) null));
                                        } else {
                                            trimmed3 = trimmed;
                                            if (Intrinsics.areEqual(type, "movie")) {
                                                results4.add(MainAPIKt.newMovieSearchResponse$default(this, title, getMainUrl() + '/' + slug, TvType.Movie, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda3
                                                    public final Object invoke(Object obj4) {
                                                        return LayarKacaProvider.search$lambda$2(posterUrl, (MovieSearchResponse) obj4);
                                                    }
                                                }, 8, (Object) null));
                                            }
                                        }
                                        i++;
                                        root = root2;
                                        trimmed = trimmed3;
                                    }
                                    trimmed2 = trimmed;
                                } else {
                                    trimmed2 = trimmed;
                                }
                                break;
                            } else {
                                trimmed2 = trimmed;
                            }
                            if (results4.isEmpty()) {
                                try {
                                    Result.Companion companion5 = Result.Companion;
                                    LayarKacaProvider $this$search_u24lambda_u243 = this;
                                    Companion companion6 = INSTANCE;
                                    String str2 = $this$search_u24lambda_u243.getMainUrl() + "/?s=" + query6;
                                    c00112.L$0 = SpillingKt.nullOutSpilledVariable(query6);
                                    c00112.L$1 = results4;
                                    c00112.L$2 = SpillingKt.nullOutSpilledVariable(refer3);
                                    c00112.L$3 = SpillingKt.nullOutSpilledVariable(res);
                                    c00112.L$4 = SpillingKt.nullOutSpilledVariable(trimmed2);
                                    c00112.L$5 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u243);
                                    c00112.label = 3;
                                    results6 = results4;
                                    query8 = query6;
                                    try {
                                        objAppGet$default3 = Companion.appGet$default(companion6, str2, null, null, false, c00112, 14, null);
                                        if (objAppGet$default3 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        query7 = query8;
                                        results5 = results6;
                                        refer4 = refer3;
                                        res2 = res;
                                        trimmed4 = trimmed2;
                                        obj2 = Result.constructor-impl(((NiceResponse) objAppGet$default3).getDocument());
                                        results4 = results5;
                                        if (Result.isFailure-impl(obj2)) {
                                            obj3 = null;
                                        } else {
                                            obj3 = obj2;
                                        }
                                        searchDoc = (Document) obj3;
                                        if (searchDoc == null && (iterableSelect = searchDoc.select("article")) != null) {
                                            Iterable $this$mapNotNull$iv = iterableSelect;
                                            Collection destination$iv$iv = new ArrayList();
                                            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                                Document searchDoc2 = searchDoc;
                                                Element it2 = (Element) element$iv$iv$iv;
                                                SearchResponse searchResult = toSearchResult(it2);
                                                if (searchResult != null) {
                                                    destination$iv$iv.add(searchResult);
                                                }
                                                searchDoc = searchDoc2;
                                            }
                                            List it3 = (List) destination$iv$iv;
                                            Boxing.boxBoolean(results4.addAll(it3));
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        query7 = query8;
                                        results5 = results6;
                                        refer4 = refer3;
                                        res2 = res;
                                        trimmed4 = trimmed2;
                                        Result.Companion companion7 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    query7 = query6;
                                    results5 = results4;
                                    refer4 = refer3;
                                    res2 = res;
                                    trimmed4 = trimmed2;
                                }
                            }
                            Iterable $this$distinctBy$iv = results4;
                            set$iv = new HashSet();
                            list$iv = new ArrayList();
                            for (Object e$iv : $this$distinctBy$iv) {
                                it = (SearchResponse) e$iv;
                                if (set$iv.add(it.getUrl())) {
                                    list$iv.add(e$iv);
                                }
                            }
                            ArrayList $this$distinctBy$iv2 = list$iv;
                            return $this$distinctBy$iv2;
                        } catch (Throwable th4) {
                            refer2 = refer;
                            results3 = results2;
                            query4 = query5;
                            text = "";
                            refer3 = refer2;
                            results4 = results3;
                            query6 = query4;
                        }
                    } catch (Throwable th5) {
                        String str3 = query3;
                        refer2 = refer;
                        results3 = results2;
                        query4 = str3;
                    }
                } catch (Throwable th6) {
                    query2 = query;
                    results = results7;
                    refer = getMainUrl();
                    results2 = results;
                    query3 = query2;
                }
                break;
            case 1:
                results = (List) c00112.L$1;
                query2 = (String) c00112.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objAppGet$default = $result;
                    refer = ((NiceResponse) objAppGet$default).getUrl();
                    results2 = results;
                    query3 = query2;
                } catch (Throwable th7) {
                    refer = getMainUrl();
                    results2 = results;
                    query3 = query2;
                }
                Companion companion8 = INSTANCE;
                String str4 = this.searchurl + "/search.php?s=" + query3;
                c00112.L$0 = query3;
                c00112.L$1 = results2;
                c00112.L$2 = SpillingKt.nullOutSpilledVariable(refer);
                c00112.label = 2;
                query5 = query3;
                objAppGet$default2 = Companion.appGet$default(companion8, str4, null, refer, false, c00112, 10, null);
                if (objAppGet$default2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                refer2 = refer;
                results3 = results2;
                query4 = query5;
                text = ((NiceResponse) objAppGet$default2).getText();
                refer3 = refer2;
                results4 = results3;
                query6 = query4;
                res = text;
                trimmed = StringsKt.trim(res).toString();
                if (StringsKt.startsWith$default(trimmed, "{", false, 2, (Object) null)) {
                    Result.Companion companion9 = Result.Companion;
                    LayarKacaProvider layarKacaProvider2 = this;
                    obj = Result.constructor-impl(new JSONObject(trimmed));
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    root = (JSONObject) obj;
                    if (root != null) {
                        arr = root.optJSONArray("data");
                    } else {
                        arr = null;
                    }
                    if (arr != null) {
                        i = 0;
                        length = arr.length();
                        while (i < length) {
                            JSONObject item2 = arr.getJSONObject(i);
                            title = item2.getString("title");
                            slug = item2.getString("slug");
                            type = item2.getString("type");
                            JSONObject root3 = root;
                            posterUrl = "https://static-jpg.lk21.party/wp-content/uploads/" + item2.optString("poster");
                            if (Intrinsics.areEqual(type, "series")) {
                                trimmed3 = trimmed;
                                results4.add(MainAPIKt.newTvSeriesSearchResponse$default(this, title, this.seriesUrl + '/' + slug, TvType.TvSeries, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj4) {
                                        return LayarKacaProvider.search$lambda$1(posterUrl, (TvSeriesSearchResponse) obj4);
                                    }
                                }, 8, (Object) null));
                            } else {
                                trimmed3 = trimmed;
                                if (Intrinsics.areEqual(type, "movie")) {
                                    results4.add(MainAPIKt.newMovieSearchResponse$default(this, title, getMainUrl() + '/' + slug, TvType.Movie, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda3
                                        public final Object invoke(Object obj4) {
                                            return LayarKacaProvider.search$lambda$2(posterUrl, (MovieSearchResponse) obj4);
                                        }
                                    }, 8, (Object) null));
                                }
                            }
                            i++;
                            root = root3;
                            trimmed = trimmed3;
                        }
                        trimmed2 = trimmed;
                    } else {
                        trimmed2 = trimmed;
                    }
                } else {
                    trimmed2 = trimmed;
                }
                if (results4.isEmpty()) {
                    Result.Companion companion10 = Result.Companion;
                    LayarKacaProvider $this$search_u24lambda_u244 = this;
                    Companion companion11 = INSTANCE;
                    String str5 = $this$search_u24lambda_u244.getMainUrl() + "/?s=" + query6;
                    c00112.L$0 = SpillingKt.nullOutSpilledVariable(query6);
                    c00112.L$1 = results4;
                    c00112.L$2 = SpillingKt.nullOutSpilledVariable(refer3);
                    c00112.L$3 = SpillingKt.nullOutSpilledVariable(res);
                    c00112.L$4 = SpillingKt.nullOutSpilledVariable(trimmed2);
                    c00112.L$5 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u244);
                    c00112.label = 3;
                    results6 = results4;
                    query8 = query6;
                    objAppGet$default3 = Companion.appGet$default(companion11, str5, null, null, false, c00112, 14, null);
                    if (objAppGet$default3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    query7 = query8;
                    results5 = results6;
                    refer4 = refer3;
                    res2 = res;
                    trimmed4 = trimmed2;
                    obj2 = Result.constructor-impl(((NiceResponse) objAppGet$default3).getDocument());
                    results4 = results5;
                    if (Result.isFailure-impl(obj2)) {
                        obj3 = null;
                    } else {
                        obj3 = obj2;
                    }
                    searchDoc = (Document) obj3;
                    if (searchDoc == null) {
                    }
                }
                Iterable $this$distinctBy$iv3 = results4;
                set$iv = new HashSet();
                list$iv = new ArrayList();
                while (r9.hasNext()) {
                    it = (SearchResponse) e$iv;
                    if (set$iv.add(it.getUrl())) {
                        list$iv.add(e$iv);
                    }
                }
                ArrayList $this$distinctBy$iv4 = list$iv;
                return $this$distinctBy$iv4;
            case 2:
                refer2 = (String) c00112.L$2;
                results3 = (List) c00112.L$1;
                query4 = (String) c00112.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objAppGet$default2 = $result;
                    text = ((NiceResponse) objAppGet$default2).getText();
                    refer3 = refer2;
                    results4 = results3;
                    query6 = query4;
                } catch (Throwable th8) {
                    text = "";
                    refer3 = refer2;
                    results4 = results3;
                    query6 = query4;
                }
                res = text;
                trimmed = StringsKt.trim(res).toString();
                if (StringsKt.startsWith$default(trimmed, "{", false, 2, (Object) null)) {
                    Result.Companion companion12 = Result.Companion;
                    LayarKacaProvider layarKacaProvider3 = this;
                    obj = Result.constructor-impl(new JSONObject(trimmed));
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    root = (JSONObject) obj;
                    if (root != null) {
                        arr = root.optJSONArray("data");
                    } else {
                        arr = null;
                    }
                    if (arr != null) {
                        i = 0;
                        length = arr.length();
                        while (i < length) {
                            JSONObject item3 = arr.getJSONObject(i);
                            title = item3.getString("title");
                            slug = item3.getString("slug");
                            type = item3.getString("type");
                            JSONObject root4 = root;
                            posterUrl = "https://static-jpg.lk21.party/wp-content/uploads/" + item3.optString("poster");
                            if (Intrinsics.areEqual(type, "series")) {
                                trimmed3 = trimmed;
                                results4.add(MainAPIKt.newTvSeriesSearchResponse$default(this, title, this.seriesUrl + '/' + slug, TvType.TvSeries, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj4) {
                                        return LayarKacaProvider.search$lambda$1(posterUrl, (TvSeriesSearchResponse) obj4);
                                    }
                                }, 8, (Object) null));
                            } else {
                                trimmed3 = trimmed;
                                if (Intrinsics.areEqual(type, "movie")) {
                                    results4.add(MainAPIKt.newMovieSearchResponse$default(this, title, getMainUrl() + '/' + slug, TvType.Movie, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda3
                                        public final Object invoke(Object obj4) {
                                            return LayarKacaProvider.search$lambda$2(posterUrl, (MovieSearchResponse) obj4);
                                        }
                                    }, 8, (Object) null));
                                }
                            }
                            i++;
                            root = root4;
                            trimmed = trimmed3;
                        }
                        trimmed2 = trimmed;
                    } else {
                        trimmed2 = trimmed;
                    }
                } else {
                    trimmed2 = trimmed;
                }
                if (results4.isEmpty()) {
                    Result.Companion companion13 = Result.Companion;
                    LayarKacaProvider $this$search_u24lambda_u245 = this;
                    Companion companion14 = INSTANCE;
                    String str6 = $this$search_u24lambda_u245.getMainUrl() + "/?s=" + query6;
                    c00112.L$0 = SpillingKt.nullOutSpilledVariable(query6);
                    c00112.L$1 = results4;
                    c00112.L$2 = SpillingKt.nullOutSpilledVariable(refer3);
                    c00112.L$3 = SpillingKt.nullOutSpilledVariable(res);
                    c00112.L$4 = SpillingKt.nullOutSpilledVariable(trimmed2);
                    c00112.L$5 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u245);
                    c00112.label = 3;
                    results6 = results4;
                    query8 = query6;
                    objAppGet$default3 = Companion.appGet$default(companion14, str6, null, null, false, c00112, 14, null);
                    if (objAppGet$default3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    query7 = query8;
                    results5 = results6;
                    refer4 = refer3;
                    res2 = res;
                    trimmed4 = trimmed2;
                    obj2 = Result.constructor-impl(((NiceResponse) objAppGet$default3).getDocument());
                    results4 = results5;
                    if (Result.isFailure-impl(obj2)) {
                        obj3 = null;
                    } else {
                        obj3 = obj2;
                    }
                    searchDoc = (Document) obj3;
                    if (searchDoc == null) {
                    }
                }
                Iterable $this$distinctBy$iv5 = results4;
                set$iv = new HashSet();
                list$iv = new ArrayList();
                while (r9.hasNext()) {
                    it = (SearchResponse) e$iv;
                    if (set$iv.add(it.getUrl())) {
                        list$iv.add(e$iv);
                    }
                }
                ArrayList $this$distinctBy$iv6 = list$iv;
                return $this$distinctBy$iv6;
            case 3:
                trimmed4 = (String) c00112.L$4;
                res2 = (String) c00112.L$3;
                refer4 = (String) c00112.L$2;
                results5 = (List) c00112.L$1;
                query7 = (String) c00112.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objAppGet$default3 = $result;
                    obj2 = Result.constructor-impl(((NiceResponse) objAppGet$default3).getDocument());
                    break;
                } catch (Throwable th9) {
                    th = th9;
                    Result.Companion companion15 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                }
                results4 = results5;
                if (Result.isFailure-impl(obj2)) {
                    obj3 = null;
                } else {
                    obj3 = obj2;
                }
                searchDoc = (Document) obj3;
                if (searchDoc == null) {
                }
                Iterable $this$distinctBy$iv7 = results4;
                set$iv = new HashSet();
                list$iv = new ArrayList();
                while (r9.hasNext()) {
                    it = (SearchResponse) e$iv;
                    if (set$iv.add(it.getUrl())) {
                        list$iv.add(e$iv);
                    }
                }
                ArrayList $this$distinctBy$iv8 = list$iv;
                return $this$distinctBy$iv8;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final Unit search$lambda$1(String $posterUrl, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    static final Unit search$lambda$2(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0343  */
    /* JADX WARN: Code duplicated, block: B:105:0x0372  */
    /* JADX WARN: Code duplicated, block: B:111:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:113:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:114:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:123:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:126:0x0402  */
    /* JADX WARN: Code duplicated, block: B:140:0x04c1  */
    /* JADX WARN: Code duplicated, block: B:142:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:145:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:148:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:150:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:151:0x0507  */
    /* JADX WARN: Code duplicated, block: B:153:0x052d  */
    /* JADX WARN: Code duplicated, block: B:155:0x0541  */
    /* JADX WARN: Code duplicated, block: B:159:0x055e  */
    /* JADX WARN: Code duplicated, block: B:160:0x0563  */
    /* JADX WARN: Code duplicated, block: B:166:0x0618 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:167:0x0619  */
    /* JADX WARN: Code duplicated, block: B:169:0x0630  */
    /* JADX WARN: Code duplicated, block: B:171:0x06ab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:172:0x06ac  */
    /* JADX WARN: Code duplicated, block: B:175:0x03db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x0347 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x03a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x039a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x0545 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0131 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0132  */
    /* JADX WARN: Code duplicated, block: B:26:0x0150 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0151  */
    /* JADX WARN: Code duplicated, block: B:30:0x0161  */
    /* JADX WARN: Code duplicated, block: B:33:0x0172  */
    /* JADX WARN: Code duplicated, block: B:36:0x018b  */
    /* JADX WARN: Code duplicated, block: B:37:0x018d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0192  */
    /* JADX WARN: Code duplicated, block: B:42:0x019e  */
    /* JADX WARN: Code duplicated, block: B:43:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:46:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:51:0x01d3 A[LOOP:0: B:49:0x01cd->B:51:0x01d3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x0229  */
    /* JADX WARN: Code duplicated, block: B:57:0x0238  */
    /* JADX WARN: Code duplicated, block: B:60:0x024a  */
    /* JADX WARN: Code duplicated, block: B:61:0x024d  */
    /* JADX WARN: Code duplicated, block: B:64:0x0258  */
    /* JADX WARN: Code duplicated, block: B:67:0x026b  */
    /* JADX WARN: Code duplicated, block: B:70:0x0277  */
    /* JADX WARN: Code duplicated, block: B:71:0x027e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0288  */
    /* JADX WARN: Code duplicated, block: B:75:0x028f  */
    /* JADX WARN: Code duplicated, block: B:79:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:97:0x033e A[ADDED_TO_REGION, REMOVE] */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws JSONException, IOException {
        C00061 c00061;
        String url2;
        Object properLink;
        String fixUrl;
        C00061 c00062;
        Object objAppGet$default;
        String fixUrl2;
        String url3;
        Document document;
        Object objFetchURL;
        String fixUrl3;
        Object obj;
        Document document2;
        String url4;
        String baseurl;
        Element elementSelectFirst;
        String string;
        String title;
        String strAttr;
        boolean z;
        String poster;
        Iterable $this$map$iv;
        Collection destination$iv$iv;
        List tags;
        final Map posterheaders;
        MatchResult matchResultFind$default;
        String str;
        Integer year;
        TvType tvType;
        TvType tvType2;
        Element elementSelectFirst2;
        String description;
        Element elementSelectFirst3;
        String trailer;
        Element elementSelectFirst4;
        String rating;
        Iterable $this$mapNotNull$iv;
        Collection destination$iv$iv2;
        String fixUrl4;
        String title2;
        Iterable $this$distinctBy$iv;
        int $i$f$distinctBy;
        HashSet set$iv;
        ArrayList list$iv;
        Map posterheaders2;
        ArrayList recommendations;
        Map posterheaders3;
        Object objNewMovieLoadResponse;
        TvType tvType3;
        String title3;
        String fixUrl5;
        String poster2;
        Integer year2;
        String fixUrl6;
        String rating2;
        List recommendations2;
        String title4;
        String baseurl2;
        Element elementSelectFirst5;
        String strData;
        String json;
        List episodes;
        Object obj2;
        JSONObject root;
        String json2;
        TvType tvType4;
        String baseurl3;
        Iterator<String> itKeys;
        TvType tvType5;
        String baseurl4;
        Object objNewTvSeriesLoadResponse;
        Iterable $this$forEach$iv;
        int $i$f$forEach;
        Iterator it;
        Element it2;
        String href;
        CharSequence $this$filterTo$iv$iv;
        Appendable destination$iv$iv3;
        int length;
        int index$iv$iv;
        Integer intOrNull;
        final int epNum;
        char element$iv$iv;
        char c;
        Element elementSelectFirst6;
        TvSeriesSearchResponse tvSeriesSearchResponseNewTvSeriesSearchResponse$default;
        String strText;
        String recName;
        String strAttr2;
        String strText2;
        List groupValues;
        Element elementSelectFirst7;
        String imageAttr;
        String strFixUrlNull;
        String strText3;
        if (continuation instanceof C00061) {
            c00061 = (C00061) continuation;
            if ((c00061.label & Integer.MIN_VALUE) != 0) {
                c00061.label -= Integer.MIN_VALUE;
            } else {
                c00061 = new C00061(continuation);
            }
        } else {
            c00061 = new C00061(continuation);
        }
        C00061 c00063 = c00061;
        Object $result = c00063.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00063.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00063.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00063.label = 1;
                url2 = url;
                properLink = getProperLink(url2, c00063);
                if (properLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fixUrl = (String) properLink;
                Companion companion = INSTANCE;
                c00063.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00063.L$1 = fixUrl;
                c00063.label = 2;
                c00062 = c00063;
                objAppGet$default = Companion.appGet$default(companion, fixUrl, null, null, false, c00062, 14, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fixUrl2 = url2;
                url3 = fixUrl;
                document = ((NiceResponse) objAppGet$default).getDocument();
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(fixUrl2);
                c00062.L$1 = url3;
                c00062.L$2 = document;
                c00062.label = 3;
                objFetchURL = fetchURL(url3, c00062);
                if (objFetchURL == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fixUrl3 = url3;
                obj = objFetchURL;
                document2 = document;
                url4 = fixUrl2;
                baseurl = (String) obj;
                elementSelectFirst = document2.selectFirst("div.movie-info h1, h1.entry-title, h1");
                if (elementSelectFirst != null || (strText3 = elementSelectFirst.text()) == null) {
                    string = null;
                } else {
                    string = StringsKt.trim(strText3).toString();
                }
                title = String.valueOf(string);
                strAttr = document2.select("meta[property=og:image]").attr("content");
                if (strAttr.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    LayarKacaProvider layarKacaProvider = this;
                    elementSelectFirst7 = document2.selectFirst("div.movie-info img, img.attachment-post-thumbnail");
                    if (elementSelectFirst7 != null) {
                        imageAttr = getImageAttr(elementSelectFirst7);
                    } else {
                        imageAttr = null;
                    }
                    strFixUrlNull = MainAPIKt.fixUrlNull(layarKacaProvider, imageAttr);
                    if (strFixUrlNull == null) {
                        strAttr = "";
                    } else {
                        strAttr = strFixUrlNull;
                    }
                }
                poster = strAttr;
                $this$map$iv = document2.select("div.tag-list span, .genre a");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    destination$iv$iv.add(((Element) item$iv$iv).text());
                    $this$map$iv = $this$map$iv;
                }
                tags = (List) destination$iv$iv;
                posterheaders = MapsKt.mapOf(TuplesKt.to("Referer", getBaseUrl(poster)));
                matchResultFind$default = Regex.find$default(new Regex("\\d, (\\d+)"), StringsKt.trim(document2.select("div.movie-info h1, h1").text()).toString(), 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
                    str = null;
                } else {
                    str = (String) groupValues.get(1);
                }
                year = StringsKt.toIntOrNull(String.valueOf(str));
                if (document2.selectFirst("#season-data, div.episode-list, div.serial-wrapper") != null) {
                    tvType = TvType.TvSeries;
                } else {
                    tvType = TvType.Movie;
                }
                tvType2 = tvType;
                elementSelectFirst2 = document2.selectFirst("div.meta-info, div.entry-content, p.desc");
                if (elementSelectFirst2 != null || (strText2 = elementSelectFirst2.text()) == null) {
                    description = null;
                } else {
                    description = StringsKt.trim(strText2).toString();
                }
                elementSelectFirst3 = document2.selectFirst("ul.action-left > li:nth-child(3) > a, a.trailer");
                if (elementSelectFirst3 != null) {
                    trailer = elementSelectFirst3.attr("href");
                } else {
                    trailer = null;
                }
                elementSelectFirst4 = document2.selectFirst("div.info-tag strong, span.rating, .imdb-rating");
                if (elementSelectFirst4 != null) {
                    rating = elementSelectFirst4.text();
                } else {
                    rating = null;
                }
                $this$mapNotNull$iv = document2.select("#slider article, .slider article, #related-posts article, .related article, ul.slider li article");
                destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    Element it3 = (Element) element$iv$iv$iv;
                    String fixUrl7 = fixUrl3;
                    elementSelectFirst6 = it3.selectFirst("h3, h1, .grid-title");
                    if (elementSelectFirst6 == null && (strText = elementSelectFirst6.text()) != null && (recName = StringsKt.trim(strText).toString()) != null) {
                        StringBuilder sbAppend = new StringBuilder().append(baseurl);
                        title = title;
                        Element elementSelectFirst8 = it3.selectFirst("a");
                        if (elementSelectFirst8 == null || (strAttr2 = elementSelectFirst8.attr("href")) == null) {
                            tvSeriesSearchResponseNewTvSeriesSearchResponse$default = null;
                        } else {
                            String recHref = sbAppend.append(strAttr2).toString();
                            LayarKacaProvider layarKacaProvider2 = this;
                            Element elementSelectFirst9 = it3.selectFirst("img");
                            final String recPosterUrl = MainAPIKt.fixUrl(layarKacaProvider2, String.valueOf(elementSelectFirst9 != null ? getImageAttr(elementSelectFirst9) : null));
                            tvSeriesSearchResponseNewTvSeriesSearchResponse$default = MainAPIKt.newTvSeriesSearchResponse$default(this, recName, recHref, TvType.TvSeries, false, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj3) {
                                    return LayarKacaProvider.load$lambda$2$0(recPosterUrl, posterheaders, (TvSeriesSearchResponse) obj3);
                                }
                            }, 8, (Object) null);
                        }
                    }
                    if (tvSeriesSearchResponseNewTvSeriesSearchResponse$default != null) {
                        destination$iv$iv2.add(tvSeriesSearchResponseNewTvSeriesSearchResponse$default);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    fixUrl3 = fixUrl7;
                    title = title;
                }
                fixUrl4 = fixUrl3;
                title2 = title;
                $this$distinctBy$iv = (List) destination$iv$iv2;
                $i$f$distinctBy = 0;
                set$iv = new HashSet();
                list$iv = new ArrayList();
                for (Object e$iv : $this$distinctBy$iv) {
                    $this$distinctBy$iv = $this$distinctBy$iv;
                    $i$f$distinctBy = $i$f$distinctBy;
                    posterheaders = posterheaders;
                    if (set$iv.add(StringsKt.trimEnd(((TvSeriesSearchResponse) e$iv).getUrl(), new char[]{'/'}))) {
                        list$iv.add(e$iv);
                    }
                }
                posterheaders2 = posterheaders;
                recommendations = list$iv;
                if (tvType2 == TvType.TvSeries) {
                    posterheaders3 = posterheaders2;
                    TvType tvType6 = TvType.Movie;
                    C00085 c00085 = new C00085(poster, posterheaders3, year, description, tags, rating, recommendations, trailer, null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl4);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(baseurl);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders3);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(year);
                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(description);
                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00062.label = 5;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, fixUrl4, tvType6, fixUrl4, c00085, c00062);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    tvType3 = tvType2;
                    title3 = title2;
                    fixUrl5 = fixUrl4;
                    poster2 = poster;
                    year2 = year;
                    fixUrl6 = description;
                    rating2 = rating;
                    recommendations2 = recommendations;
                    title4 = trailer;
                    baseurl2 = baseurl;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                elementSelectFirst5 = document2.selectFirst("script#season-data");
                if (elementSelectFirst5 != null) {
                    strData = elementSelectFirst5.data();
                } else {
                    strData = null;
                }
                json = strData;
                episodes = new ArrayList();
                if (json != null) {
                    try {
                        Result.Companion companion2 = Result.Companion;
                        LayarKacaProvider layarKacaProvider3 = this;
                        obj2 = Result.constructor-impl(new JSONObject(json));
                    } catch (Throwable th) {
                        Result.Companion companion3 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.isFailure-impl(obj2)) {
                        obj2 = null;
                    }
                    root = (JSONObject) obj2;
                    if (root != null || (itKeys = root.keys()) == null) {
                        json2 = json;
                        tvType4 = tvType2;
                        baseurl3 = baseurl;
                    } else {
                        while (itKeys.hasNext()) {
                            Object element$iv = itKeys.next();
                            String seasonKey = (String) element$iv;
                            JSONArray jSONArrayOptJSONArray = root.optJSONArray(seasonKey);
                            if (jSONArrayOptJSONArray == null) {
                                tvType5 = tvType2;
                                baseurl4 = baseurl;
                            } else {
                                JSONArray seasonArr = jSONArrayOptJSONArray;
                                int length2 = seasonArr.length();
                                int episodeNo = 0;
                                while (episodeNo < length2) {
                                    int i = length2;
                                    JSONArray seasonArr2 = seasonArr;
                                    TvType tvType7 = tvType2;
                                    JSONObject ep = seasonArr2.getJSONObject(episodeNo);
                                    int i2 = episodeNo;
                                    String baseurl5 = baseurl;
                                    String href2 = MainAPIKt.fixUrl(this, baseurl + '/' + ep.getString("slug"));
                                    final int episodeNo2 = ep.optInt("episode_no");
                                    final int seasonNo = ep.optInt("s");
                                    episodes.add(MainAPIKt.newEpisode(this, href2, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda5
                                        public final Object invoke(Object obj3) {
                                            return LayarKacaProvider.load$lambda$5$0(episodeNo2, seasonNo, (Episode) obj3);
                                        }
                                    }));
                                    episodeNo = i2 + 1;
                                    tvType2 = tvType7;
                                    length2 = i;
                                    seasonArr = seasonArr2;
                                    baseurl = baseurl5;
                                    seasonKey = seasonKey;
                                }
                                tvType5 = tvType2;
                                baseurl4 = baseurl;
                            }
                            tvType2 = tvType5;
                            root = root;
                            json = json;
                            baseurl = baseurl4;
                        }
                        json2 = json;
                        tvType4 = tvType2;
                        baseurl3 = baseurl;
                        Unit unit = Unit.INSTANCE;
                    }
                    break;
                } else {
                    json2 = json;
                    tvType4 = tvType2;
                    baseurl3 = baseurl;
                }
                if (episodes.isEmpty()) {
                    $this$forEach$iv = document2.select("div.episode-list > a, ul.episode-list > li a, div.serial-wrapper a");
                    $i$f$forEach = 0;
                    for (it = $this$forEach$iv.iterator(); it.hasNext(); it = it) {
                        Object element$iv2 = it.next();
                        it2 = (Element) element$iv2;
                        href = MainAPIKt.fixUrlNull(this, it2.attr("href"));
                        if (href == null) {
                            CharSequence $this$filter$iv = it2.text();
                            $this$filterTo$iv$iv = $this$filter$iv;
                            destination$iv$iv3 = new StringBuilder();
                            length = $this$filterTo$iv$iv.length();
                            index$iv$iv = 0;
                            while (index$iv$iv < length) {
                                int i3 = length;
                                element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
                                CharSequence $this$filterTo$iv$iv2 = $this$filterTo$iv$iv;
                                c = element$iv$iv;
                                int index$iv$iv2 = index$iv$iv;
                                if (Character.isDigit(c)) {
                                    destination$iv$iv3.append(element$iv$iv);
                                }
                                index$iv$iv = index$iv$iv2 + 1;
                                length = i3;
                                $this$filterTo$iv$iv = $this$filterTo$iv$iv2;
                            }
                            intOrNull = StringsKt.toIntOrNull(((StringBuilder) destination$iv$iv3).toString());
                            if (intOrNull != null) {
                                epNum = intOrNull.intValue();
                            } else {
                                epNum = 1;
                            }
                            final Integer season = StringsKt.toIntOrNull(StringsKt.substringBefore(StringsKt.substringAfter(it2.attr("href"), "season-", ""), "-", ""));
                            episodes.add(MainAPIKt.newEpisode(this, href, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda6
                                public final Object invoke(Object obj3) {
                                    return LayarKacaProvider.load$lambda$6$1(epNum, season, (Episode) obj3);
                                }
                            }));
                        }
                        $this$forEach$iv = $this$forEach$iv;
                        $i$f$forEach = $i$f$forEach;
                    }
                }
                TvType tvType8 = TvType.TvSeries;
                C00074 c00074 = new C00074(poster, posterheaders2, year, description, tags, rating, recommendations, trailer, null);
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl4);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(baseurl3);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders2);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(year);
                c00062.L$9 = SpillingKt.nullOutSpilledVariable(tvType4);
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(description);
                c00062.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                c00062.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                c00062.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00062.L$14 = SpillingKt.nullOutSpilledVariable(json2);
                c00062.L$15 = SpillingKt.nullOutSpilledVariable(episodes);
                c00062.label = 4;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, fixUrl4, tvType8, episodes, c00074, c00062);
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 1:
                url2 = (String) c00063.L$0;
                ResultKt.throwOnFailure($result);
                properLink = $result;
                fixUrl = (String) properLink;
                Companion companion4 = INSTANCE;
                c00063.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00063.L$1 = fixUrl;
                c00063.label = 2;
                c00062 = c00063;
                objAppGet$default = Companion.appGet$default(companion4, fixUrl, null, null, false, c00062, 14, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fixUrl2 = url2;
                url3 = fixUrl;
                document = ((NiceResponse) objAppGet$default).getDocument();
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(fixUrl2);
                c00062.L$1 = url3;
                c00062.L$2 = document;
                c00062.label = 3;
                objFetchURL = fetchURL(url3, c00062);
                if (objFetchURL == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fixUrl3 = url3;
                obj = objFetchURL;
                document2 = document;
                url4 = fixUrl2;
                baseurl = (String) obj;
                elementSelectFirst = document2.selectFirst("div.movie-info h1, h1.entry-title, h1");
                if (elementSelectFirst != null) {
                    string = null;
                } else {
                    string = null;
                }
                title = String.valueOf(string);
                strAttr = document2.select("meta[property=og:image]").attr("content");
                if (strAttr.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    LayarKacaProvider layarKacaProvider4 = this;
                    elementSelectFirst7 = document2.selectFirst("div.movie-info img, img.attachment-post-thumbnail");
                    if (elementSelectFirst7 != null) {
                        imageAttr = getImageAttr(elementSelectFirst7);
                    } else {
                        imageAttr = null;
                    }
                    strFixUrlNull = MainAPIKt.fixUrlNull(layarKacaProvider4, imageAttr);
                    if (strFixUrlNull == null) {
                        strAttr = "";
                    } else {
                        strAttr = strFixUrlNull;
                    }
                }
                poster = strAttr;
                $this$map$iv = document2.select("div.tag-list span, .genre a");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r20.hasNext()) {
                    destination$iv$iv.add(((Element) item$iv$iv).text());
                    $this$map$iv = $this$map$iv;
                }
                tags = (List) destination$iv$iv;
                posterheaders = MapsKt.mapOf(TuplesKt.to("Referer", getBaseUrl(poster)));
                matchResultFind$default = Regex.find$default(new Regex("\\d, (\\d+)"), StringsKt.trim(document2.select("div.movie-info h1, h1").text()).toString(), 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    str = null;
                } else {
                    str = null;
                }
                year = StringsKt.toIntOrNull(String.valueOf(str));
                if (document2.selectFirst("#season-data, div.episode-list, div.serial-wrapper") != null) {
                    tvType = TvType.TvSeries;
                } else {
                    tvType = TvType.Movie;
                }
                tvType2 = tvType;
                elementSelectFirst2 = document2.selectFirst("div.meta-info, div.entry-content, p.desc");
                if (elementSelectFirst2 != null) {
                    description = null;
                } else {
                    description = null;
                }
                elementSelectFirst3 = document2.selectFirst("ul.action-left > li:nth-child(3) > a, a.trailer");
                if (elementSelectFirst3 != null) {
                    trailer = elementSelectFirst3.attr("href");
                } else {
                    trailer = null;
                }
                elementSelectFirst4 = document2.selectFirst("div.info-tag strong, span.rating, .imdb-rating");
                if (elementSelectFirst4 != null) {
                    rating = elementSelectFirst4.text();
                } else {
                    rating = null;
                }
                $this$mapNotNull$iv = document2.select("#slider article, .slider article, #related-posts article, .related article, ul.slider li article");
                destination$iv$iv2 = new ArrayList();
                while (r28.hasNext()) {
                    Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                    Element it4 = (Element) element$iv$iv$iv;
                    String fixUrl8 = fixUrl3;
                    elementSelectFirst6 = it4.selectFirst("h3, h1, .grid-title");
                    tvSeriesSearchResponseNewTvSeriesSearchResponse$default = elementSelectFirst6 == null ? null : null;
                    if (tvSeriesSearchResponseNewTvSeriesSearchResponse$default != null) {
                        destination$iv$iv2.add(tvSeriesSearchResponseNewTvSeriesSearchResponse$default);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                    fixUrl3 = fixUrl8;
                    title = title;
                }
                fixUrl4 = fixUrl3;
                title2 = title;
                $this$distinctBy$iv = (List) destination$iv$iv2;
                $i$f$distinctBy = 0;
                set$iv = new HashSet();
                list$iv = new ArrayList();
                while (r13.hasNext()) {
                    $this$distinctBy$iv = $this$distinctBy$iv;
                    $i$f$distinctBy = $i$f$distinctBy;
                    posterheaders = posterheaders;
                    if (set$iv.add(StringsKt.trimEnd(((TvSeriesSearchResponse) e$iv).getUrl(), new char[]{'/'}))) {
                        list$iv.add(e$iv);
                    }
                }
                posterheaders2 = posterheaders;
                recommendations = list$iv;
                if (tvType2 == TvType.TvSeries) {
                    posterheaders3 = posterheaders2;
                    TvType tvType9 = TvType.Movie;
                    C00085 c00086 = new C00085(poster, posterheaders3, year, description, tags, rating, recommendations, trailer, null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl4);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(baseurl);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders3);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(year);
                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(description);
                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00062.label = 5;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, fixUrl4, tvType9, fixUrl4, c00086, c00062);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    tvType3 = tvType2;
                    title3 = title2;
                    fixUrl5 = fixUrl4;
                    poster2 = poster;
                    year2 = year;
                    fixUrl6 = description;
                    rating2 = rating;
                    recommendations2 = recommendations;
                    title4 = trailer;
                    baseurl2 = baseurl;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                elementSelectFirst5 = document2.selectFirst("script#season-data");
                if (elementSelectFirst5 != null) {
                    strData = elementSelectFirst5.data();
                } else {
                    strData = null;
                }
                json = strData;
                episodes = new ArrayList();
                if (json != null) {
                    Result.Companion companion5 = Result.Companion;
                    LayarKacaProvider layarKacaProvider5 = this;
                    obj2 = Result.constructor-impl(new JSONObject(json));
                    if (Result.isFailure-impl(obj2)) {
                        obj2 = null;
                    }
                    root = (JSONObject) obj2;
                    if (root != null) {
                        json2 = json;
                        tvType4 = tvType2;
                        baseurl3 = baseurl;
                    } else {
                        json2 = json;
                        tvType4 = tvType2;
                        baseurl3 = baseurl;
                    }
                } else {
                    json2 = json;
                    tvType4 = tvType2;
                    baseurl3 = baseurl;
                }
                if (episodes.isEmpty()) {
                    $this$forEach$iv = document2.select("div.episode-list > a, ul.episode-list > li a, div.serial-wrapper a");
                    $i$f$forEach = 0;
                    while (it.hasNext()) {
                        Object element$iv3 = it.next();
                        it2 = (Element) element$iv3;
                        href = MainAPIKt.fixUrlNull(this, it2.attr("href"));
                        if (href == null) {
                            CharSequence $this$filter$iv2 = it2.text();
                            $this$filterTo$iv$iv = $this$filter$iv2;
                            destination$iv$iv3 = new StringBuilder();
                            length = $this$filterTo$iv$iv.length();
                            index$iv$iv = 0;
                            while (index$iv$iv < length) {
                                int i4 = length;
                                element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
                                CharSequence $this$filterTo$iv$iv3 = $this$filterTo$iv$iv;
                                c = element$iv$iv;
                                int index$iv$iv3 = index$iv$iv;
                                if (Character.isDigit(c)) {
                                    destination$iv$iv3.append(element$iv$iv);
                                }
                                index$iv$iv = index$iv$iv3 + 1;
                                length = i4;
                                $this$filterTo$iv$iv = $this$filterTo$iv$iv3;
                            }
                            intOrNull = StringsKt.toIntOrNull(((StringBuilder) destination$iv$iv3).toString());
                            if (intOrNull != null) {
                                epNum = intOrNull.intValue();
                            } else {
                                epNum = 1;
                            }
                            final Integer season2 = StringsKt.toIntOrNull(StringsKt.substringBefore(StringsKt.substringAfter(it2.attr("href"), "season-", ""), "-", ""));
                            episodes.add(MainAPIKt.newEpisode(this, href, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda6
                                public final Object invoke(Object obj3) {
                                    return LayarKacaProvider.load$lambda$6$1(epNum, season2, (Episode) obj3);
                                }
                            }));
                        }
                        $this$forEach$iv = $this$forEach$iv;
                        $i$f$forEach = $i$f$forEach;
                    }
                }
                TvType tvType10 = TvType.TvSeries;
                C00074 c00075 = new C00074(poster, posterheaders2, year, description, tags, rating, recommendations, trailer, null);
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl4);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(baseurl3);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders2);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(year);
                c00062.L$9 = SpillingKt.nullOutSpilledVariable(tvType4);
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(description);
                c00062.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                c00062.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                c00062.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00062.L$14 = SpillingKt.nullOutSpilledVariable(json2);
                c00062.L$15 = SpillingKt.nullOutSpilledVariable(episodes);
                c00062.label = 4;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, fixUrl4, tvType10, episodes, c00075, c00062);
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 2:
                url3 = (String) c00063.L$1;
                String url5 = (String) c00063.L$0;
                ResultKt.throwOnFailure($result);
                fixUrl2 = url5;
                c00062 = c00063;
                objAppGet$default = $result;
                document = ((NiceResponse) objAppGet$default).getDocument();
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(fixUrl2);
                c00062.L$1 = url3;
                c00062.L$2 = document;
                c00062.label = 3;
                objFetchURL = fetchURL(url3, c00062);
                if (objFetchURL == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fixUrl3 = url3;
                obj = objFetchURL;
                document2 = document;
                url4 = fixUrl2;
                baseurl = (String) obj;
                elementSelectFirst = document2.selectFirst("div.movie-info h1, h1.entry-title, h1");
                if (elementSelectFirst != null) {
                    string = null;
                } else {
                    string = null;
                }
                title = String.valueOf(string);
                strAttr = document2.select("meta[property=og:image]").attr("content");
                if (strAttr.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    LayarKacaProvider layarKacaProvider6 = this;
                    elementSelectFirst7 = document2.selectFirst("div.movie-info img, img.attachment-post-thumbnail");
                    if (elementSelectFirst7 != null) {
                        imageAttr = getImageAttr(elementSelectFirst7);
                    } else {
                        imageAttr = null;
                    }
                    strFixUrlNull = MainAPIKt.fixUrlNull(layarKacaProvider6, imageAttr);
                    if (strFixUrlNull == null) {
                        strAttr = "";
                    } else {
                        strAttr = strFixUrlNull;
                    }
                }
                poster = strAttr;
                $this$map$iv = document2.select("div.tag-list span, .genre a");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r20.hasNext()) {
                    destination$iv$iv.add(((Element) item$iv$iv).text());
                    $this$map$iv = $this$map$iv;
                }
                tags = (List) destination$iv$iv;
                posterheaders = MapsKt.mapOf(TuplesKt.to("Referer", getBaseUrl(poster)));
                matchResultFind$default = Regex.find$default(new Regex("\\d, (\\d+)"), StringsKt.trim(document2.select("div.movie-info h1, h1").text()).toString(), 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    str = null;
                } else {
                    str = null;
                }
                year = StringsKt.toIntOrNull(String.valueOf(str));
                if (document2.selectFirst("#season-data, div.episode-list, div.serial-wrapper") != null) {
                    tvType = TvType.TvSeries;
                } else {
                    tvType = TvType.Movie;
                }
                tvType2 = tvType;
                elementSelectFirst2 = document2.selectFirst("div.meta-info, div.entry-content, p.desc");
                if (elementSelectFirst2 != null) {
                    description = null;
                } else {
                    description = null;
                }
                elementSelectFirst3 = document2.selectFirst("ul.action-left > li:nth-child(3) > a, a.trailer");
                if (elementSelectFirst3 != null) {
                    trailer = elementSelectFirst3.attr("href");
                } else {
                    trailer = null;
                }
                elementSelectFirst4 = document2.selectFirst("div.info-tag strong, span.rating, .imdb-rating");
                if (elementSelectFirst4 != null) {
                    rating = elementSelectFirst4.text();
                } else {
                    rating = null;
                }
                $this$mapNotNull$iv = document2.select("#slider article, .slider article, #related-posts article, .related article, ul.slider li article");
                destination$iv$iv2 = new ArrayList();
                while (r28.hasNext()) {
                    Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                    Element it5 = (Element) element$iv$iv$iv;
                    String fixUrl9 = fixUrl3;
                    elementSelectFirst6 = it5.selectFirst("h3, h1, .grid-title");
                    if (elementSelectFirst6 == null) {
                    }
                    if (tvSeriesSearchResponseNewTvSeriesSearchResponse$default != null) {
                        destination$iv$iv2.add(tvSeriesSearchResponseNewTvSeriesSearchResponse$default);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv4;
                    fixUrl3 = fixUrl9;
                    title = title;
                }
                fixUrl4 = fixUrl3;
                title2 = title;
                $this$distinctBy$iv = (List) destination$iv$iv2;
                $i$f$distinctBy = 0;
                set$iv = new HashSet();
                list$iv = new ArrayList();
                while (r13.hasNext()) {
                    $this$distinctBy$iv = $this$distinctBy$iv;
                    $i$f$distinctBy = $i$f$distinctBy;
                    posterheaders = posterheaders;
                    if (set$iv.add(StringsKt.trimEnd(((TvSeriesSearchResponse) e$iv).getUrl(), new char[]{'/'}))) {
                        list$iv.add(e$iv);
                    }
                }
                posterheaders2 = posterheaders;
                recommendations = list$iv;
                if (tvType2 == TvType.TvSeries) {
                    posterheaders3 = posterheaders2;
                    TvType tvType11 = TvType.Movie;
                    C00085 c00087 = new C00085(poster, posterheaders3, year, description, tags, rating, recommendations, trailer, null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl4);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(baseurl);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders3);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(year);
                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(description);
                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00062.label = 5;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, fixUrl4, tvType11, fixUrl4, c00087, c00062);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    tvType3 = tvType2;
                    title3 = title2;
                    fixUrl5 = fixUrl4;
                    poster2 = poster;
                    year2 = year;
                    fixUrl6 = description;
                    rating2 = rating;
                    recommendations2 = recommendations;
                    title4 = trailer;
                    baseurl2 = baseurl;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                elementSelectFirst5 = document2.selectFirst("script#season-data");
                if (elementSelectFirst5 != null) {
                    strData = elementSelectFirst5.data();
                } else {
                    strData = null;
                }
                json = strData;
                episodes = new ArrayList();
                if (json != null) {
                    Result.Companion companion6 = Result.Companion;
                    LayarKacaProvider layarKacaProvider7 = this;
                    obj2 = Result.constructor-impl(new JSONObject(json));
                    if (Result.isFailure-impl(obj2)) {
                        obj2 = null;
                    }
                    root = (JSONObject) obj2;
                    if (root != null) {
                        json2 = json;
                        tvType4 = tvType2;
                        baseurl3 = baseurl;
                    } else {
                        json2 = json;
                        tvType4 = tvType2;
                        baseurl3 = baseurl;
                    }
                } else {
                    json2 = json;
                    tvType4 = tvType2;
                    baseurl3 = baseurl;
                }
                if (episodes.isEmpty()) {
                    $this$forEach$iv = document2.select("div.episode-list > a, ul.episode-list > li a, div.serial-wrapper a");
                    $i$f$forEach = 0;
                    while (it.hasNext()) {
                        Object element$iv4 = it.next();
                        it2 = (Element) element$iv4;
                        href = MainAPIKt.fixUrlNull(this, it2.attr("href"));
                        if (href == null) {
                            CharSequence $this$filter$iv3 = it2.text();
                            $this$filterTo$iv$iv = $this$filter$iv3;
                            destination$iv$iv3 = new StringBuilder();
                            length = $this$filterTo$iv$iv.length();
                            index$iv$iv = 0;
                            while (index$iv$iv < length) {
                                int i5 = length;
                                element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
                                CharSequence $this$filterTo$iv$iv4 = $this$filterTo$iv$iv;
                                c = element$iv$iv;
                                int index$iv$iv4 = index$iv$iv;
                                if (Character.isDigit(c)) {
                                    destination$iv$iv3.append(element$iv$iv);
                                }
                                index$iv$iv = index$iv$iv4 + 1;
                                length = i5;
                                $this$filterTo$iv$iv = $this$filterTo$iv$iv4;
                            }
                            intOrNull = StringsKt.toIntOrNull(((StringBuilder) destination$iv$iv3).toString());
                            if (intOrNull != null) {
                                epNum = intOrNull.intValue();
                            } else {
                                epNum = 1;
                            }
                            final Integer season3 = StringsKt.toIntOrNull(StringsKt.substringBefore(StringsKt.substringAfter(it2.attr("href"), "season-", ""), "-", ""));
                            episodes.add(MainAPIKt.newEpisode(this, href, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda6
                                public final Object invoke(Object obj3) {
                                    return LayarKacaProvider.load$lambda$6$1(epNum, season3, (Episode) obj3);
                                }
                            }));
                        }
                        $this$forEach$iv = $this$forEach$iv;
                        $i$f$forEach = $i$f$forEach;
                    }
                }
                TvType tvType12 = TvType.TvSeries;
                C00074 c00076 = new C00074(poster, posterheaders2, year, description, tags, rating, recommendations, trailer, null);
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl4);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(baseurl3);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders2);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(year);
                c00062.L$9 = SpillingKt.nullOutSpilledVariable(tvType4);
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(description);
                c00062.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                c00062.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                c00062.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00062.L$14 = SpillingKt.nullOutSpilledVariable(json2);
                c00062.L$15 = SpillingKt.nullOutSpilledVariable(episodes);
                c00062.label = 4;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, fixUrl4, tvType12, episodes, c00076, c00062);
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 3:
                Document document3 = (Document) c00063.L$2;
                String fixUrl10 = (String) c00063.L$1;
                String url6 = (String) c00063.L$0;
                ResultKt.throwOnFailure($result);
                document2 = document3;
                fixUrl3 = fixUrl10;
                c00062 = c00063;
                obj = $result;
                url4 = url6;
                baseurl = (String) obj;
                elementSelectFirst = document2.selectFirst("div.movie-info h1, h1.entry-title, h1");
                if (elementSelectFirst != null) {
                    string = null;
                } else {
                    string = null;
                }
                title = String.valueOf(string);
                strAttr = document2.select("meta[property=og:image]").attr("content");
                if (strAttr.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    LayarKacaProvider layarKacaProvider8 = this;
                    elementSelectFirst7 = document2.selectFirst("div.movie-info img, img.attachment-post-thumbnail");
                    if (elementSelectFirst7 != null) {
                        imageAttr = getImageAttr(elementSelectFirst7);
                    } else {
                        imageAttr = null;
                    }
                    strFixUrlNull = MainAPIKt.fixUrlNull(layarKacaProvider8, imageAttr);
                    if (strFixUrlNull == null) {
                        strAttr = "";
                    } else {
                        strAttr = strFixUrlNull;
                    }
                }
                poster = strAttr;
                $this$map$iv = document2.select("div.tag-list span, .genre a");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r20.hasNext()) {
                    destination$iv$iv.add(((Element) item$iv$iv).text());
                    $this$map$iv = $this$map$iv;
                }
                tags = (List) destination$iv$iv;
                posterheaders = MapsKt.mapOf(TuplesKt.to("Referer", getBaseUrl(poster)));
                matchResultFind$default = Regex.find$default(new Regex("\\d, (\\d+)"), StringsKt.trim(document2.select("div.movie-info h1, h1").text()).toString(), 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    str = null;
                } else {
                    str = null;
                }
                year = StringsKt.toIntOrNull(String.valueOf(str));
                if (document2.selectFirst("#season-data, div.episode-list, div.serial-wrapper") != null) {
                    tvType = TvType.TvSeries;
                } else {
                    tvType = TvType.Movie;
                }
                tvType2 = tvType;
                elementSelectFirst2 = document2.selectFirst("div.meta-info, div.entry-content, p.desc");
                if (elementSelectFirst2 != null) {
                    description = null;
                } else {
                    description = null;
                }
                elementSelectFirst3 = document2.selectFirst("ul.action-left > li:nth-child(3) > a, a.trailer");
                if (elementSelectFirst3 != null) {
                    trailer = elementSelectFirst3.attr("href");
                } else {
                    trailer = null;
                }
                elementSelectFirst4 = document2.selectFirst("div.info-tag strong, span.rating, .imdb-rating");
                if (elementSelectFirst4 != null) {
                    rating = elementSelectFirst4.text();
                } else {
                    rating = null;
                }
                $this$mapNotNull$iv = document2.select("#slider article, .slider article, #related-posts article, .related article, ul.slider li article");
                destination$iv$iv2 = new ArrayList();
                while (r28.hasNext()) {
                    Iterable $this$mapNotNull$iv5 = $this$mapNotNull$iv;
                    Element it6 = (Element) element$iv$iv$iv;
                    String fixUrl11 = fixUrl3;
                    elementSelectFirst6 = it6.selectFirst("h3, h1, .grid-title");
                    if (elementSelectFirst6 == null) {
                    }
                    if (tvSeriesSearchResponseNewTvSeriesSearchResponse$default != null) {
                        destination$iv$iv2.add(tvSeriesSearchResponseNewTvSeriesSearchResponse$default);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv5;
                    fixUrl3 = fixUrl11;
                    title = title;
                }
                fixUrl4 = fixUrl3;
                title2 = title;
                $this$distinctBy$iv = (List) destination$iv$iv2;
                $i$f$distinctBy = 0;
                set$iv = new HashSet();
                list$iv = new ArrayList();
                while (r13.hasNext()) {
                    $this$distinctBy$iv = $this$distinctBy$iv;
                    $i$f$distinctBy = $i$f$distinctBy;
                    posterheaders = posterheaders;
                    if (set$iv.add(StringsKt.trimEnd(((TvSeriesSearchResponse) e$iv).getUrl(), new char[]{'/'}))) {
                        list$iv.add(e$iv);
                    }
                }
                posterheaders2 = posterheaders;
                recommendations = list$iv;
                if (tvType2 == TvType.TvSeries) {
                    posterheaders3 = posterheaders2;
                    TvType tvType13 = TvType.Movie;
                    C00085 c00088 = new C00085(poster, posterheaders3, year, description, tags, rating, recommendations, trailer, null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl4);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(baseurl);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders3);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(year);
                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(description);
                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00062.label = 5;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, fixUrl4, tvType13, fixUrl4, c00088, c00062);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    tvType3 = tvType2;
                    title3 = title2;
                    fixUrl5 = fixUrl4;
                    poster2 = poster;
                    year2 = year;
                    fixUrl6 = description;
                    rating2 = rating;
                    recommendations2 = recommendations;
                    title4 = trailer;
                    baseurl2 = baseurl;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                elementSelectFirst5 = document2.selectFirst("script#season-data");
                if (elementSelectFirst5 != null) {
                    strData = elementSelectFirst5.data();
                } else {
                    strData = null;
                }
                json = strData;
                episodes = new ArrayList();
                if (json != null) {
                    Result.Companion companion7 = Result.Companion;
                    LayarKacaProvider layarKacaProvider9 = this;
                    obj2 = Result.constructor-impl(new JSONObject(json));
                    if (Result.isFailure-impl(obj2)) {
                        obj2 = null;
                    }
                    root = (JSONObject) obj2;
                    if (root != null) {
                        json2 = json;
                        tvType4 = tvType2;
                        baseurl3 = baseurl;
                    } else {
                        json2 = json;
                        tvType4 = tvType2;
                        baseurl3 = baseurl;
                    }
                } else {
                    json2 = json;
                    tvType4 = tvType2;
                    baseurl3 = baseurl;
                }
                if (episodes.isEmpty()) {
                    $this$forEach$iv = document2.select("div.episode-list > a, ul.episode-list > li a, div.serial-wrapper a");
                    $i$f$forEach = 0;
                    while (it.hasNext()) {
                        Object element$iv5 = it.next();
                        it2 = (Element) element$iv5;
                        href = MainAPIKt.fixUrlNull(this, it2.attr("href"));
                        if (href == null) {
                            CharSequence $this$filter$iv4 = it2.text();
                            $this$filterTo$iv$iv = $this$filter$iv4;
                            destination$iv$iv3 = new StringBuilder();
                            length = $this$filterTo$iv$iv.length();
                            index$iv$iv = 0;
                            while (index$iv$iv < length) {
                                int i6 = length;
                                element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
                                CharSequence $this$filterTo$iv$iv5 = $this$filterTo$iv$iv;
                                c = element$iv$iv;
                                int index$iv$iv5 = index$iv$iv;
                                if (Character.isDigit(c)) {
                                    destination$iv$iv3.append(element$iv$iv);
                                }
                                index$iv$iv = index$iv$iv5 + 1;
                                length = i6;
                                $this$filterTo$iv$iv = $this$filterTo$iv$iv5;
                            }
                            intOrNull = StringsKt.toIntOrNull(((StringBuilder) destination$iv$iv3).toString());
                            if (intOrNull != null) {
                                epNum = intOrNull.intValue();
                            } else {
                                epNum = 1;
                            }
                            final Integer season4 = StringsKt.toIntOrNull(StringsKt.substringBefore(StringsKt.substringAfter(it2.attr("href"), "season-", ""), "-", ""));
                            episodes.add(MainAPIKt.newEpisode(this, href, new Function1() { // from class: com.layarKacaProvider.LayarKacaProvider$$ExternalSyntheticLambda6
                                public final Object invoke(Object obj3) {
                                    return LayarKacaProvider.load$lambda$6$1(epNum, season4, (Episode) obj3);
                                }
                            }));
                        }
                        $this$forEach$iv = $this$forEach$iv;
                        $i$f$forEach = $i$f$forEach;
                    }
                }
                TvType tvType14 = TvType.TvSeries;
                C00074 c00077 = new C00074(poster, posterheaders2, year, description, tags, rating, recommendations, trailer, null);
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(fixUrl4);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(baseurl3);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(posterheaders2);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(year);
                c00062.L$9 = SpillingKt.nullOutSpilledVariable(tvType4);
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(description);
                c00062.L$11 = SpillingKt.nullOutSpilledVariable(trailer);
                c00062.L$12 = SpillingKt.nullOutSpilledVariable(rating);
                c00062.L$13 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00062.L$14 = SpillingKt.nullOutSpilledVariable(json2);
                c00062.L$15 = SpillingKt.nullOutSpilledVariable(episodes);
                c00062.label = 4;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, fixUrl4, tvType14, episodes, c00077, c00062);
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 4:
                ResultKt.throwOnFailure($result);
                objNewTvSeriesLoadResponse = $result;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 5:
                List recommendations3 = (List) c00063.L$13;
                rating2 = (String) c00063.L$12;
                title4 = (String) c00063.L$11;
                fixUrl6 = (String) c00063.L$10;
                tvType3 = (TvType) c00063.L$9;
                year2 = (Integer) c00063.L$8;
                Map posterheaders4 = (Map) c00063.L$7;
                List tags2 = (List) c00063.L$6;
                poster2 = (String) c00063.L$5;
                title3 = (String) c00063.L$4;
                baseurl2 = (String) c00063.L$3;
                recommendations2 = recommendations3;
                fixUrl5 = (String) c00063.L$1;
                ResultKt.throwOnFailure($result);
                posterheaders3 = posterheaders4;
                tags = tags2;
                objNewMovieLoadResponse = $result;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2$0(String $recPosterUrl, Map $posterheaders, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($recPosterUrl);
        $this$newTvSeriesSearchResponse.setPosterHeaders($posterheaders);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$5$0(int $episodeNo, int $seasonNo, Episode $this$newEpisode) {
        $this$newEpisode.setName("Episode " + $episodeNo);
        $this$newEpisode.setSeason(Integer.valueOf($seasonNo));
        $this$newEpisode.setEpisode(Integer.valueOf($episodeNo));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$6$1(int $epNum, Integer $season, Episode $this$newEpisode) {
        $this$newEpisode.setName("Episode " + $epNum);
        $this$newEpisode.setSeason($season);
        $this$newEpisode.setEpisode(Integer.valueOf($epNum));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$load$4 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider$load$4", f = "LayarKacaProvider.kt", i = {0}, l = {249}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {250}, s = {"L$0"}, v = 2)
    static final class C00074 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ Map<String, String> $posterheaders;
        final /* synthetic */ String $rating;
        final /* synthetic */ List<TvSeriesSearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00074(String str, Map<String, String> map, Integer num, String str2, List<String> list, String str3, List<TvSeriesSearchResponse> list2, String str4, Continuation<? super C00074> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$posterheaders = map;
            this.$year = num;
            this.$description = str2;
            this.$tags = list;
            this.$rating = str3;
            this.$recommendations = list2;
            this.$trailer = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00074 = new C00074(this.$poster, this.$posterheaders, this.$year, this.$description, this.$tags, this.$rating, this.$recommendations, this.$trailer, continuation);
            c00074.L$0 = obj;
            return c00074;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setPosterHeaders(this.$posterheaders);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setScore(Score.Companion.from10(this.$rating));
                    loadResponse.setRecommendations(this.$recommendations);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
                    this.label = 1;
                    if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, this.$trailer, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$load$5 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider$load$5", f = "LayarKacaProvider.kt", i = {0}, l = {260}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {261}, s = {"L$0"}, v = 2)
    static final class C00085 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ Map<String, String> $posterheaders;
        final /* synthetic */ String $rating;
        final /* synthetic */ List<TvSeriesSearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00085(String str, Map<String, String> map, Integer num, String str2, List<String> list, String str3, List<TvSeriesSearchResponse> list2, String str4, Continuation<? super C00085> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$posterheaders = map;
            this.$year = num;
            this.$description = str2;
            this.$tags = list;
            this.$rating = str3;
            this.$recommendations = list2;
            this.$trailer = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00085 = new C00085(this.$poster, this.$posterheaders, this.$year, this.$description, this.$tags, this.$rating, this.$recommendations, this.$trailer, continuation);
            c00085.L$0 = obj;
            return c00085;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setPosterHeaders(this.$posterheaders);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setScore(Score.Companion.from10(this.$rating));
                    loadResponse.setRecommendations(this.$recommendations);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
                    this.label = 1;
                    if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, this.$trailer, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
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

    /* JADX WARN: Code duplicated, block: B:21:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:23:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:26:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:29:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:36:0x0119  */
    /* JADX WARN: Code duplicated, block: B:48:0x015b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0179  */
    /* JADX WARN: Code duplicated, block: B:57:0x0192  */
    /* JADX WARN: Code duplicated, block: B:59:0x0195  */
    /* JADX WARN: Code duplicated, block: B:64:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:69:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:72:0x020c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:84:0x0280  */
    /* JADX WARN: Code duplicated, block: B:89:0x0318 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:90:0x0319  */
    /* JADX WARN: Code duplicated, block: B:93:0x0141 A[SYNTHETIC] */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00091 c00091;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        boolean isCasting2;
        Object objAppGet$default;
        String data2;
        Document document;
        List playerUrls;
        Iterable $this$forEach$iv;
        int $i$f$forEach;
        Iterator it;
        String str;
        Object $result;
        Iterable $this$forEach$iv2;
        int $i$f$forEach2;
        Iterator it2;
        Regex scriptRegex;
        Iterable $this$forEach$iv3;
        int $i$f$forEach3;
        Iterator it3;
        List distinctUrls;
        C00105 c00105;
        Sequence $this$forEach$iv4;
        int $i$f$forEach4;
        Iterator it4;
        String foundUrl;
        Element it5;
        String strAttr;
        String src;
        String str2;
        boolean z;
        String str3;
        Iterator it6;
        String data3;
        Element it7;
        String strAttr2;
        String strAttr3;
        String strAttr4;
        String href;
        String str4;
        boolean z2;
        if (continuation instanceof C00091) {
            c00091 = (C00091) continuation;
            if ((c00091.label & Integer.MIN_VALUE) != 0) {
                c00091.label -= Integer.MIN_VALUE;
            } else {
                c00091 = new C00091(continuation);
            }
        } else {
            c00091 = new C00091(continuation);
        }
        C00091 c00092 = c00091;
        Object $result2 = c00092.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00092.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                Companion companion = INSTANCE;
                c00092.L$0 = SpillingKt.nullOutSpilledVariable(data);
                function3 = function1;
                c00092.L$1 = function3;
                function4 = function2;
                c00092.L$2 = function4;
                isCasting2 = isCasting;
                c00092.Z$0 = isCasting2;
                c00092.label = 1;
                objAppGet$default = Companion.appGet$default(companion, data, null, null, false, c00092, 14, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data2 = data;
                document = ((NiceResponse) objAppGet$default).getDocument();
                playerUrls = new ArrayList();
                $this$forEach$iv = document.select("ul#player-list > li a, select#player-select option, div.player-options a, ul#loadProviders > li a, ul.nav-tabs > li a, .player-list a, div#player-list a, div.server-list a, ul.server-list > li a");
                $i$f$forEach = 0;
                it = $this$forEach$iv.iterator();
                while (true) {
                    str = "data-src";
                    $result = $result2;
                    if (it.hasNext()) {
                        $this$forEach$iv2 = document.select("div.embed-container iframe, iframe#main-player, div.embed iframe, .embed iframe, #player iframe, #content-embed iframe, iframe[src*='stream'], iframe[src*='api'], iframe[src*='embed'], iframe[src*='videonode'], iframe");
                        $i$f$forEach2 = 0;
                        it2 = $this$forEach$iv2.iterator();
                        while (it2.hasNext()) {
                            Object element$iv = it2.next();
                            it5 = (Element) element$iv;
                            Iterable $this$forEach$iv5 = $this$forEach$iv2;
                            LayarKacaProvider layarKacaProvider = this;
                            int $i$f$forEach5 = $i$f$forEach2;
                            strAttr = it5.attr("src");
                            if (StringsKt.isBlank(strAttr)) {
                                strAttr = it5.attr(str);
                            }
                            src = MainAPIKt.fixUrlNull(layarKacaProvider, strAttr);
                            str2 = src;
                            if (str2 != null || StringsKt.isBlank(str2)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                str3 = str;
                                it6 = it2;
                                data3 = data2;
                            } else {
                                str3 = str;
                                it6 = it2;
                                data3 = data2;
                                if (StringsKt.startsWith$default(src, "about:", false, 2, (Object) null) && !StringsKt.startsWith$default(src, "javascript:", false, 2, (Object) null)) {
                                    playerUrls.add(src);
                                }
                            }
                            $this$forEach$iv2 = $this$forEach$iv5;
                            $i$f$forEach2 = $i$f$forEach5;
                            str = str3;
                            it2 = it6;
                            data2 = data3;
                        }
                        String data4 = data2;
                        scriptRegex = new Regex("(?:src|file|link)\\s*[:=]\\s*[\"'](https?://[^\"']+)[\"']");
                        $this$forEach$iv3 = document.select("script:not([src])");
                        $i$f$forEach3 = 0;
                        it3 = $this$forEach$iv3.iterator();
                        while (it3.hasNext()) {
                            Object element$iv2 = it3.next();
                            Element script = (Element) element$iv2;
                            String dataStr = script.data();
                            Iterable $this$forEach$iv6 = $this$forEach$iv3;
                            int $i$f$forEach6 = $i$f$forEach3;
                            Iterator it8 = it3;
                            $this$forEach$iv4 = Regex.findAll$default(scriptRegex, dataStr, 0, 2, (Object) null);
                            $i$f$forEach4 = 0;
                            it4 = $this$forEach$iv4.iterator();
                            while (it4.hasNext()) {
                                Object element$iv3 = it4.next();
                                MatchResult match = (MatchResult) element$iv3;
                                Sequence $this$forEach$iv7 = $this$forEach$iv4;
                                int $i$f$forEach7 = $i$f$forEach4;
                                foundUrl = (String) match.getGroupValues().get(1);
                                Iterator it9 = it4;
                                Regex scriptRegex2 = scriptRegex;
                                Document document2 = document;
                                if (StringsKt.contains$default(foundUrl, "embed", false, 2, (Object) null) || StringsKt.contains$default(foundUrl, "stream", false, 2, (Object) null) || StringsKt.contains$default(foundUrl, "player", false, 2, (Object) null) || StringsKt.contains$default(foundUrl, "api.php", false, 2, (Object) null) || StringsKt.contains$default(foundUrl, ".m3u8", false, 2, (Object) null) || StringsKt.contains$default(foundUrl, "videonode", false, 2, (Object) null)) {
                                    playerUrls.add(foundUrl);
                                }
                                $this$forEach$iv4 = $this$forEach$iv7;
                                $i$f$forEach4 = $i$f$forEach7;
                                scriptRegex = scriptRegex2;
                                it4 = it9;
                                document = document2;
                            }
                            $this$forEach$iv3 = $this$forEach$iv6;
                            $i$f$forEach3 = $i$f$forEach6;
                            it3 = it8;
                            document = document;
                        }
                        distinctUrls = CollectionsKt.distinct(playerUrls);
                        Log.INSTANCE.d("LayarKaca", "Found " + distinctUrls.size() + " player targets: " + distinctUrls);
                        c00105 = new C00105(function4, function3, null);
                        c00092.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                        c00092.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                        c00092.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                        c00092.L$3 = SpillingKt.nullOutSpilledVariable(document);
                        c00092.L$4 = SpillingKt.nullOutSpilledVariable(playerUrls);
                        c00092.L$5 = SpillingKt.nullOutSpilledVariable(scriptRegex);
                        c00092.L$6 = SpillingKt.nullOutSpilledVariable(distinctUrls);
                        c00092.Z$0 = isCasting2;
                        c00092.label = 2;
                        if (ParCollectionsKt.amap(distinctUrls, c00105, c00092) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Boxing.boxBoolean(true);
                    }
                    Object element$iv4 = it.next();
                    it7 = (Element) element$iv4;
                    Iterable $this$forEach$iv8 = $this$forEach$iv;
                    LayarKacaProvider layarKacaProvider2 = this;
                    int $i$f$forEach8 = $i$f$forEach;
                    strAttr2 = it7.attr("href");
                    if (StringsKt.isBlank(strAttr2)) {
                        strAttr2 = it7.attr("data-url");
                    }
                    strAttr3 = strAttr2;
                    if (StringsKt.isBlank(strAttr3)) {
                        strAttr3 = it7.attr("data-src");
                    }
                    strAttr4 = strAttr3;
                    if (StringsKt.isBlank(strAttr4)) {
                        strAttr4 = it7.attr("value");
                    }
                    href = MainAPIKt.fixUrlNull(layarKacaProvider2, strAttr4);
                    str4 = href;
                    if (str4 != null || StringsKt.isBlank(str4)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2 && !StringsKt.startsWith$default(href, "javascript:", false, 2, (Object) null) && !StringsKt.startsWith$default(href, "#", false, 2, (Object) null)) {
                        playerUrls.add(href);
                    }
                    $this$forEach$iv = $this$forEach$iv8;
                    $result2 = $result;
                    $i$f$forEach = $i$f$forEach8;
                }
                break;
            case 1:
                boolean isCasting3 = c00092.Z$0;
                Function1<? super ExtractorLink, Unit> function5 = (Function1) c00092.L$2;
                Function1<? super SubtitleFile, Unit> function6 = (Function1) c00092.L$1;
                data2 = (String) c00092.L$0;
                ResultKt.throwOnFailure($result2);
                isCasting2 = isCasting3;
                function4 = function5;
                function3 = function6;
                objAppGet$default = $result2;
                document = ((NiceResponse) objAppGet$default).getDocument();
                playerUrls = new ArrayList();
                $this$forEach$iv = document.select("ul#player-list > li a, select#player-select option, div.player-options a, ul#loadProviders > li a, ul.nav-tabs > li a, .player-list a, div#player-list a, div.server-list a, ul.server-list > li a");
                $i$f$forEach = 0;
                it = $this$forEach$iv.iterator();
                while (true) {
                    str = "data-src";
                    $result = $result2;
                    if (it.hasNext()) {
                        $this$forEach$iv2 = document.select("div.embed-container iframe, iframe#main-player, div.embed iframe, .embed iframe, #player iframe, #content-embed iframe, iframe[src*='stream'], iframe[src*='api'], iframe[src*='embed'], iframe[src*='videonode'], iframe");
                        $i$f$forEach2 = 0;
                        it2 = $this$forEach$iv2.iterator();
                        while (it2.hasNext()) {
                            Object element$iv5 = it2.next();
                            it5 = (Element) element$iv5;
                            Iterable $this$forEach$iv9 = $this$forEach$iv2;
                            LayarKacaProvider layarKacaProvider3 = this;
                            int $i$f$forEach9 = $i$f$forEach2;
                            strAttr = it5.attr("src");
                            if (StringsKt.isBlank(strAttr)) {
                                strAttr = it5.attr(str);
                            }
                            src = MainAPIKt.fixUrlNull(layarKacaProvider3, strAttr);
                            str2 = src;
                            if (str2 != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (z) {
                                str3 = str;
                                it6 = it2;
                                data3 = data2;
                                if (StringsKt.startsWith$default(src, "about:", false, 2, (Object) null)) {
                                }
                            } else {
                                str3 = str;
                                it6 = it2;
                                data3 = data2;
                            }
                            $this$forEach$iv2 = $this$forEach$iv9;
                            $i$f$forEach2 = $i$f$forEach9;
                            str = str3;
                            it2 = it6;
                            data2 = data3;
                        }
                        String data5 = data2;
                        scriptRegex = new Regex("(?:src|file|link)\\s*[:=]\\s*[\"'](https?://[^\"']+)[\"']");
                        $this$forEach$iv3 = document.select("script:not([src])");
                        $i$f$forEach3 = 0;
                        it3 = $this$forEach$iv3.iterator();
                        while (it3.hasNext()) {
                            Object element$iv6 = it3.next();
                            Element script2 = (Element) element$iv6;
                            String dataStr2 = script2.data();
                            Iterable $this$forEach$iv10 = $this$forEach$iv3;
                            int $i$f$forEach10 = $i$f$forEach3;
                            Iterator it10 = it3;
                            $this$forEach$iv4 = Regex.findAll$default(scriptRegex, dataStr2, 0, 2, (Object) null);
                            $i$f$forEach4 = 0;
                            it4 = $this$forEach$iv4.iterator();
                            while (it4.hasNext()) {
                                Object element$iv7 = it4.next();
                                MatchResult match2 = (MatchResult) element$iv7;
                                Sequence $this$forEach$iv11 = $this$forEach$iv4;
                                int $i$f$forEach11 = $i$f$forEach4;
                                foundUrl = (String) match2.getGroupValues().get(1);
                                Iterator it11 = it4;
                                Regex scriptRegex3 = scriptRegex;
                                Document document3 = document;
                                if (StringsKt.contains$default(foundUrl, "embed", false, 2, (Object) null)) {
                                    playerUrls.add(foundUrl);
                                } else {
                                    playerUrls.add(foundUrl);
                                }
                                $this$forEach$iv4 = $this$forEach$iv11;
                                $i$f$forEach4 = $i$f$forEach11;
                                scriptRegex = scriptRegex3;
                                it4 = it11;
                                document = document3;
                            }
                            $this$forEach$iv3 = $this$forEach$iv10;
                            $i$f$forEach3 = $i$f$forEach10;
                            it3 = it10;
                            document = document;
                        }
                        distinctUrls = CollectionsKt.distinct(playerUrls);
                        Log.INSTANCE.d("LayarKaca", "Found " + distinctUrls.size() + " player targets: " + distinctUrls);
                        c00105 = new C00105(function4, function3, null);
                        c00092.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                        c00092.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                        c00092.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                        c00092.L$3 = SpillingKt.nullOutSpilledVariable(document);
                        c00092.L$4 = SpillingKt.nullOutSpilledVariable(playerUrls);
                        c00092.L$5 = SpillingKt.nullOutSpilledVariable(scriptRegex);
                        c00092.L$6 = SpillingKt.nullOutSpilledVariable(distinctUrls);
                        c00092.Z$0 = isCasting2;
                        c00092.label = 2;
                        if (ParCollectionsKt.amap(distinctUrls, c00105, c00092) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Boxing.boxBoolean(true);
                    }
                    Object element$iv8 = it.next();
                    it7 = (Element) element$iv8;
                    Iterable $this$forEach$iv12 = $this$forEach$iv;
                    LayarKacaProvider layarKacaProvider4 = this;
                    int $i$f$forEach12 = $i$f$forEach;
                    strAttr2 = it7.attr("href");
                    if (StringsKt.isBlank(strAttr2)) {
                        strAttr2 = it7.attr("data-url");
                    }
                    strAttr3 = strAttr2;
                    if (StringsKt.isBlank(strAttr3)) {
                        strAttr3 = it7.attr("data-src");
                    }
                    strAttr4 = strAttr3;
                    if (StringsKt.isBlank(strAttr4)) {
                        strAttr4 = it7.attr("value");
                    }
                    href = MainAPIKt.fixUrlNull(layarKacaProvider4, strAttr4);
                    str4 = href;
                    if (str4 != null) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        playerUrls.add(href);
                    }
                    $this$forEach$iv = $this$forEach$iv12;
                    $result2 = $result;
                    $i$f$forEach = $i$f$forEach12;
                }
                break;
            case 2:
                boolean z3 = c00092.Z$0;
                ResultKt.throwOnFailure($result2);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.layarKacaProvider.LayarKacaProvider$loadLinks$5 */
    /* JADX INFO: compiled from: LayarKacaProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "rawLink", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.LayarKacaProvider$loadLinks$5", f = "LayarKacaProvider.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15}, l = {338, 341, 349, 350, 352, 353, 355, 356, 360, 367, 369, 370, 372, 373, 375, 376}, m = "invokeSuspend", n = {"rawLink", "base", "referer", "rawLink", "base", "referer", "rawLink", "base", "referer", "rawLink", "base", "referer", "rawLink", "base", "referer", "rawLink", "base", "referer", "rawLink", "base", "referer", "rawLink", "base", "referer", "rawLink", "base", "referer", "rawLink", "base", "referer", "iframeUrl", "iframeBase", "iframeReferer", "rawLink", "base", "referer", "iframeUrl", "iframeBase", "iframeReferer", "rawLink", "base", "referer", "iframeUrl", "iframeBase", "iframeReferer", "rawLink", "base", "referer", "iframeUrl", "iframeBase", "iframeReferer", "rawLink", "base", "referer", "iframeUrl", "iframeBase", "iframeReferer", "rawLink", "base", "referer", "iframeUrl", "iframeBase", "iframeReferer", "rawLink", "base", "referer", "iframeUrl", "iframeBase", "iframeReferer"}, nl = {436, 340, 350, 351, 353, 355, 356, 360, 361, 438, 370, 371, 373, 375, 376, 379}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    @SourceDebugExtension({"SMAP\nLayarKacaProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayarKacaProvider.kt\ncom/layarKacaProvider/LayarKacaProvider$loadLinks$5\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,435:1\n2068#2,2:436\n2068#2,2:438\n*S KotlinDebug\n*F\n+ 1 LayarKacaProvider.kt\ncom/layarKacaProvider/LayarKacaProvider$loadLinks$5\n*L\n338#1:436,2\n367#1:438,2\n*E\n"})
    static final class C00105 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00105(Function1<? super ExtractorLink, Unit> function1, Function1<? super SubtitleFile, Unit> function2, Continuation<? super C00105> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$subtitleCallback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00105 = LayarKacaProvider.this.new C00105(this.$callback, this.$subtitleCallback, continuation);
            c00105.L$0 = obj;
            return c00105;
        }

        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:112:0x03a8 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:119:0x03e6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:123:0x0403 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:124:0x0404  */
        /* JADX WARN: Code duplicated, block: B:127:0x0411 A[Catch: all -> 0x034d, TryCatch #5 {all -> 0x034d, blocks: (B:125:0x0406, B:127:0x0411, B:129:0x0417, B:131:0x0426, B:133:0x043e, B:121:0x03e8, B:110:0x038d, B:117:0x03cc, B:95:0x0330, B:91:0x0326, B:101:0x0352, B:103:0x0361, B:106:0x036f, B:113:0x03a9), top: B:193:0x001e }] */
        /* JADX WARN: Code duplicated, block: B:144:0x04d2 A[Catch: all -> 0x04e0, LOOP:0: B:142:0x04cc->B:144:0x04d2, LOOP_END, TryCatch #0 {all -> 0x04e0, blocks: (B:168:0x05b4, B:176:0x0627, B:154:0x052d, B:141:0x04c3, B:142:0x04cc, B:144:0x04d2, B:145:0x04da, B:135:0x0467, B:137:0x0477, B:148:0x04e3, B:150:0x04f2, B:159:0x0566, B:161:0x0573, B:164:0x0582, B:172:0x05ec), top: B:190:0x0467 }] */
        /* JADX WARN: Code duplicated, block: B:156:0x055e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:157:0x055f  */
        /* JADX WARN: Code duplicated, block: B:170:0x05e5 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:171:0x05e6  */
        /* JADX WARN: Code duplicated, block: B:178:0x0658 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:179:0x0659  */
        /* JADX WARN: Code duplicated, block: B:71:0x0284 A[Catch: all -> 0x0295, LOOP:1: B:69:0x027e->B:71:0x0284, LOOP_END, TryCatch #2 {all -> 0x0295, blocks: (B:85:0x02f3, B:68:0x0275, B:69:0x027e, B:71:0x0284, B:72:0x028c, B:65:0x026d, B:81:0x02c1), top: B:193:0x001e }] */
        /* JADX WARN: Code duplicated, block: B:97:0x034a A[RETURN] */
        /* JADX WARN: Not initialized variable reg: 22, insn: 0x0297: MOVE (r10 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY]), block:B:75:0x0296 */
        public final Object invokeSuspend(Object $result) {
            String str;
            String str2;
            String referer;
            String base;
            String str3;
            boolean z;
            int i;
            String str4;
            Object obj;
            String rawLink;
            String referer2;
            String base2;
            Object obj2;
            Function1<ExtractorLink, Unit> function1;
            String base3;
            String rawLink2;
            Object objGenerateM3u8$default;
            String base4;
            Function1<ExtractorLink, Unit> function2;
            Object iframe;
            String iframeUrl;
            String referer3;
            String iframeUrl2;
            String iframeBase;
            String iframeBase2;
            String iframeReferer;
            String iframeReferer2;
            String iframeBase3;
            String iframeUrl3;
            String iframeBase4;
            String iframeBase5;
            String iframeReferer3;
            Object objGenerateM3u8$default2;
            String iframeUrl4;
            Function1<ExtractorLink, Unit> function3;
            String rawLink3 = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String str5 = "hydrax";
            String str6 = "abyss";
            String str7 = "videonode.de";
            String str8 = ".m3u8";
            try {
                try {
                    try {
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                String base5 = LayarKacaProvider.this.getBaseUrl(rawLink3);
                                referer = (!StringsKt.isBlank(base5) ? new StringBuilder().append(base5).append('/') : new StringBuilder().append(LayarKacaProvider.this.getMainUrl()).append('/')).toString();
                                if (StringsKt.contains$default(rawLink3, ".m3u8", false, 2, (Object) null)) {
                                    try {
                                        M3u8Helper.Companion companion = M3u8Helper.Companion;
                                        String name = LayarKacaProvider.this.getName();
                                        Continuation continuation = (Continuation) this;
                                        this.L$0 = rawLink3;
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(base5);
                                        this.L$2 = referer;
                                        this.label = 1;
                                        base3 = base5;
                                        rawLink2 = rawLink3;
                                        obj = null;
                                        str4 = "https://nganunganu.sbs";
                                        z = false;
                                        str3 = "LayarKaca";
                                        i = 2;
                                        objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion, name, rawLink2, referer, (Integer) null, (Map) null, (String) null, continuation, 56, (Object) null);
                                        base4 = referer;
                                        if (objGenerateM3u8$default == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        Iterable $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                                        function2 = this.$callback;
                                        for (Object element$iv : $this$forEach$iv) {
                                            function2.invoke(element$iv);
                                        }
                                        Unit unit = Unit.INSTANCE;
                                        rawLink3 = rawLink2;
                                        referer2 = base4;
                                        base2 = base3;
                                        this.L$0 = rawLink3;
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                        this.L$2 = referer2;
                                        this.L$3 = obj;
                                        this.label = 9;
                                        iframe = LayarKacaProvider.this.getIframe(rawLink3, (Continuation) this);
                                        if (iframe == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        iframeUrl = referer2;
                                        referer3 = base2;
                                        iframeUrl2 = (String) iframe;
                                        if (StringsKt.isBlank(iframeUrl2) && !Intrinsics.areEqual(iframeUrl2, rawLink3)) {
                                            String iframeBase6 = LayarKacaProvider.this.getBaseUrl(iframeUrl2);
                                            String iframeReferer4 = !StringsKt.isBlank(iframeBase6) ? iframeBase6 + '/' : iframeUrl;
                                            str = str3;
                                            try {
                                                Log.INSTANCE.d(str, "Extracted iframe: " + iframeUrl2 + " (referer: " + iframeReferer4 + ')');
                                                if (StringsKt.contains$default(iframeUrl2, str8, z, i, obj)) {
                                                    this.L$0 = rawLink3;
                                                    this.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(iframeUrl);
                                                    this.L$3 = SpillingKt.nullOutSpilledVariable(iframeUrl2);
                                                    this.L$4 = SpillingKt.nullOutSpilledVariable(iframeBase6);
                                                    this.L$5 = SpillingKt.nullOutSpilledVariable(iframeReferer4);
                                                    this.label = 10;
                                                    objGenerateM3u8$default2 = M3u8Helper.Companion.generateM3u8$default(M3u8Helper.Companion, LayarKacaProvider.this.getName(), iframeUrl2, iframeReferer4, (Integer) null, (Map) null, (String) null, (Continuation) this, 56, (Object) null);
                                                    iframeUrl4 = iframeUrl2;
                                                    if (objGenerateM3u8$default2 == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    Iterable $this$forEach$iv2 = (Iterable) objGenerateM3u8$default2;
                                                    function3 = this.$callback;
                                                    for (Object element$iv2 : $this$forEach$iv2) {
                                                        function3.invoke(element$iv2);
                                                    }
                                                    Unit unit2 = Unit.INSTANCE;
                                                } else if (StringsKt.contains$default(iframeUrl2, str7, z, i, obj)) {
                                                    this.L$0 = rawLink3;
                                                    this.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(iframeUrl);
                                                    this.L$3 = iframeUrl2;
                                                    this.L$4 = SpillingKt.nullOutSpilledVariable(iframeBase6);
                                                    this.L$5 = iframeReferer4;
                                                    this.label = 11;
                                                    if (new VideoNode().getUrl(iframeUrl2, iframeReferer4, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    iframeBase4 = iframeBase6;
                                                    iframeBase5 = iframeReferer4;
                                                    iframeReferer3 = iframeUrl2;
                                                    this.L$0 = rawLink3;
                                                    this.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(iframeUrl);
                                                    this.L$3 = SpillingKt.nullOutSpilledVariable(iframeReferer3);
                                                    this.L$4 = SpillingKt.nullOutSpilledVariable(iframeBase4);
                                                    this.L$5 = SpillingKt.nullOutSpilledVariable(iframeBase5);
                                                    this.label = 12;
                                                    if (ExtractorApiKt.loadExtractor(iframeReferer3, iframeBase5, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                } else {
                                                    if (!StringsKt.contains$default(iframeUrl2, str6, z, i, obj) && !StringsKt.contains$default(iframeUrl2, str5, z, i, obj)) {
                                                        this.L$0 = rawLink3;
                                                        this.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                                                        this.L$2 = SpillingKt.nullOutSpilledVariable(iframeUrl);
                                                        this.L$3 = iframeUrl2;
                                                        this.L$4 = SpillingKt.nullOutSpilledVariable(iframeBase6);
                                                        this.L$5 = SpillingKt.nullOutSpilledVariable(iframeReferer4);
                                                        this.label = 15;
                                                        if (ExtractorApiKt.loadExtractor(iframeUrl2, iframeReferer4, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        iframeReferer2 = iframeBase6;
                                                        iframeBase3 = iframeReferer4;
                                                        iframeUrl3 = iframeUrl2;
                                                        this.L$0 = rawLink3;
                                                        this.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                                                        this.L$2 = SpillingKt.nullOutSpilledVariable(iframeUrl);
                                                        this.L$3 = SpillingKt.nullOutSpilledVariable(iframeUrl3);
                                                        this.L$4 = SpillingKt.nullOutSpilledVariable(iframeReferer2);
                                                        this.L$5 = SpillingKt.nullOutSpilledVariable(iframeBase3);
                                                        this.label = 16;
                                                        if (ExtractorApiKt.loadExtractor(iframeUrl3, str4, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                    }
                                                    this.L$0 = rawLink3;
                                                    this.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(iframeUrl);
                                                    this.L$3 = iframeUrl2;
                                                    this.L$4 = SpillingKt.nullOutSpilledVariable(iframeBase6);
                                                    this.L$5 = iframeReferer4;
                                                    this.label = 13;
                                                    if (new Abyass().getUrl(iframeUrl2, iframeReferer4, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    iframeBase = iframeBase6;
                                                    iframeBase2 = iframeReferer4;
                                                    iframeReferer = iframeUrl2;
                                                    this.L$0 = rawLink3;
                                                    this.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(iframeUrl);
                                                    this.L$3 = SpillingKt.nullOutSpilledVariable(iframeReferer);
                                                    this.L$4 = SpillingKt.nullOutSpilledVariable(iframeBase);
                                                    this.L$5 = SpillingKt.nullOutSpilledVariable(iframeBase2);
                                                    this.label = 14;
                                                    if (ExtractorApiKt.loadExtractor(iframeReferer, iframeBase2, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                e = th;
                                                Log.INSTANCE.e(str, "Failed to extract link for " + rawLink3 + ": " + e.getMessage());
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    } catch (Throwable th2) {
                                        e = th2;
                                        str = "LayarKaca";
                                    }
                                } else {
                                    base = base5;
                                    str3 = "LayarKaca";
                                    str5 = "hydrax";
                                    str6 = "abyss";
                                    str7 = "videonode.de";
                                    str8 = ".m3u8";
                                    z = false;
                                    i = 2;
                                    str4 = "https://nganunganu.sbs";
                                    obj = null;
                                    rawLink = rawLink3;
                                    try {
                                        if (StringsKt.contains$default(rawLink, ".mp4", false, 2, (Object) null)) {
                                            Function1<ExtractorLink, Unit> function4 = this.$callback;
                                            this.L$0 = rawLink;
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(base);
                                            this.L$2 = referer;
                                            this.L$3 = function4;
                                            this.label = 2;
                                            Object objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(LayarKacaProvider.this.getName(), LayarKacaProvider.this.getName(), rawLink, ExtractorApiKt.getINFER_TYPE(), (Function2) null, (Continuation) this, 16, (Object) null);
                                            if (objNewExtractorLink$default == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            obj2 = objNewExtractorLink$default;
                                            function1 = function4;
                                            function1.invoke(obj2);
                                            Unit unit3 = Unit.INSTANCE;
                                            rawLink3 = rawLink;
                                            referer2 = referer;
                                            base2 = base;
                                            this.L$0 = rawLink3;
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                            this.L$2 = referer2;
                                            this.L$3 = obj;
                                            this.label = 9;
                                            iframe = LayarKacaProvider.this.getIframe(rawLink3, (Continuation) this);
                                            if (iframe == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            iframeUrl = referer2;
                                            referer3 = base2;
                                            iframeUrl2 = (String) iframe;
                                            if (StringsKt.isBlank(iframeUrl2)) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                        if (StringsKt.contains$default(rawLink, str7, false, 2, (Object) null)) {
                                            VideoNode videoNode = new VideoNode();
                                            Function1<SubtitleFile, Unit> function5 = this.$subtitleCallback;
                                            Function1<ExtractorLink, Unit> function6 = this.$callback;
                                            Continuation<? super Unit> continuation2 = (Continuation) this;
                                            this.L$0 = rawLink;
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(base);
                                            this.L$2 = referer;
                                            this.label = 3;
                                            rawLink3 = rawLink;
                                            if (videoNode.getUrl(rawLink3, referer, function5, function6, continuation2) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            referer2 = referer;
                                            base2 = base;
                                            this.L$0 = rawLink3;
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                            this.L$2 = referer2;
                                            this.label = 4;
                                            if (ExtractorApiKt.loadExtractor(rawLink3, referer2, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            this.L$0 = rawLink3;
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                            this.L$2 = referer2;
                                            this.L$3 = obj;
                                            this.label = 9;
                                            iframe = LayarKacaProvider.this.getIframe(rawLink3, (Continuation) this);
                                            if (iframe == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            iframeUrl = referer2;
                                            referer3 = base2;
                                            iframeUrl2 = (String) iframe;
                                            if (StringsKt.isBlank(iframeUrl2)) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                        rawLink3 = rawLink;
                                        if (!StringsKt.contains$default(rawLink3, str6, false, 2, (Object) null) && !StringsKt.contains$default(rawLink3, str5, false, 2, (Object) null)) {
                                            this.L$0 = rawLink3;
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(base);
                                            this.L$2 = referer;
                                            this.label = 7;
                                            if (ExtractorApiKt.loadExtractor(rawLink3, referer, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            referer2 = referer;
                                            base2 = base;
                                            this.L$0 = rawLink3;
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                            this.L$2 = referer2;
                                            this.label = 8;
                                            if (ExtractorApiKt.loadExtractor(rawLink3, str4, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            this.L$0 = rawLink3;
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                            this.L$2 = referer2;
                                            this.L$3 = obj;
                                            this.label = 9;
                                            iframe = LayarKacaProvider.this.getIframe(rawLink3, (Continuation) this);
                                            if (iframe == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            iframeUrl = referer2;
                                            referer3 = base2;
                                            iframeUrl2 = (String) iframe;
                                            if (StringsKt.isBlank(iframeUrl2)) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                        this.L$0 = rawLink3;
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(base);
                                        this.L$2 = referer;
                                        this.label = 5;
                                        if (new Abyass().getUrl(rawLink3, referer, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        referer2 = referer;
                                        base2 = base;
                                        this.L$0 = rawLink3;
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                        this.L$2 = referer2;
                                        this.label = 6;
                                        if (ExtractorApiKt.loadExtractor(rawLink3, referer2, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        this.L$0 = rawLink3;
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                        this.L$2 = referer2;
                                        this.L$3 = obj;
                                        this.label = 9;
                                        iframe = LayarKacaProvider.this.getIframe(rawLink3, (Continuation) this);
                                        if (iframe == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        iframeUrl = referer2;
                                        referer3 = base2;
                                        iframeUrl2 = (String) iframe;
                                        if (StringsKt.isBlank(iframeUrl2)) {
                                        }
                                        return Unit.INSTANCE;
                                    } catch (Throwable th3) {
                                        e = th3;
                                        rawLink3 = rawLink;
                                        str = str3;
                                    }
                                }
                                Log.INSTANCE.e(str, "Failed to extract link for " + rawLink3 + ": " + e.getMessage());
                                return Unit.INSTANCE;
                            case 1:
                                String referer4 = (String) this.L$2;
                                String base6 = (String) this.L$1;
                                ResultKt.throwOnFailure($result);
                                str3 = "LayarKaca";
                                base3 = base6;
                                z = false;
                                i = 2;
                                base4 = referer4;
                                str4 = "https://nganunganu.sbs";
                                obj = null;
                                objGenerateM3u8$default = $result;
                                rawLink2 = rawLink3;
                                Iterable $this$forEach$iv3 = (Iterable) objGenerateM3u8$default;
                                function2 = this.$callback;
                                while (r6.hasNext()) {
                                    function2.invoke(element$iv);
                                }
                                Unit unit4 = Unit.INSTANCE;
                                rawLink3 = rawLink2;
                                referer2 = base4;
                                base2 = base3;
                                this.L$0 = rawLink3;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                this.L$2 = referer2;
                                this.L$3 = obj;
                                this.label = 9;
                                iframe = LayarKacaProvider.this.getIframe(rawLink3, (Continuation) this);
                                if (iframe == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                iframeUrl = referer2;
                                referer3 = base2;
                                iframeUrl2 = (String) iframe;
                                if (StringsKt.isBlank(iframeUrl2)) {
                                    break;
                                }
                                return Unit.INSTANCE;
                            case 2:
                                function1 = (Function1) this.L$3;
                                referer = (String) this.L$2;
                                String base7 = (String) this.L$1;
                                ResultKt.throwOnFailure($result);
                                str3 = "LayarKaca";
                                base = base7;
                                str5 = "hydrax";
                                str6 = "abyss";
                                str7 = "videonode.de";
                                str8 = ".m3u8";
                                z = false;
                                i = 2;
                                str4 = "https://nganunganu.sbs";
                                obj = null;
                                rawLink = rawLink3;
                                obj2 = $result;
                                function1.invoke(obj2);
                                Unit unit5 = Unit.INSTANCE;
                                rawLink3 = rawLink;
                                referer2 = referer;
                                base2 = base;
                                this.L$0 = rawLink3;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                this.L$2 = referer2;
                                this.L$3 = obj;
                                this.label = 9;
                                iframe = LayarKacaProvider.this.getIframe(rawLink3, (Continuation) this);
                                if (iframe == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                iframeUrl = referer2;
                                referer3 = base2;
                                iframeUrl2 = (String) iframe;
                                if (StringsKt.isBlank(iframeUrl2)) {
                                    break;
                                }
                                return Unit.INSTANCE;
                            case 3:
                                referer2 = (String) this.L$2;
                                base2 = (String) this.L$1;
                                ResultKt.throwOnFailure($result);
                                str3 = "LayarKaca";
                                str5 = "hydrax";
                                str6 = "abyss";
                                str7 = "videonode.de";
                                str8 = ".m3u8";
                                z = false;
                                i = 2;
                                str4 = "https://nganunganu.sbs";
                                obj = null;
                                this.L$0 = rawLink3;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                this.L$2 = referer2;
                                this.label = 4;
                                if (ExtractorApiKt.loadExtractor(rawLink3, referer2, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                this.L$0 = rawLink3;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                this.L$2 = referer2;
                                this.L$3 = obj;
                                this.label = 9;
                                iframe = LayarKacaProvider.this.getIframe(rawLink3, (Continuation) this);
                                if (iframe == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                iframeUrl = referer2;
                                referer3 = base2;
                                iframeUrl2 = (String) iframe;
                                if (StringsKt.isBlank(iframeUrl2)) {
                                    break;
                                }
                                return Unit.INSTANCE;
                            case 4:
                                referer2 = (String) this.L$2;
                                base2 = (String) this.L$1;
                                ResultKt.throwOnFailure($result);
                                str3 = "LayarKaca";
                                str5 = "hydrax";
                                str6 = "abyss";
                                str7 = "videonode.de";
                                str8 = ".m3u8";
                                z = false;
                                i = 2;
                                str4 = "https://nganunganu.sbs";
                                obj = null;
                                this.L$0 = rawLink3;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                this.L$2 = referer2;
                                this.L$3 = obj;
                                this.label = 9;
                                iframe = LayarKacaProvider.this.getIframe(rawLink3, (Continuation) this);
                                if (iframe == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                iframeUrl = referer2;
                                referer3 = base2;
                                iframeUrl2 = (String) iframe;
                                if (StringsKt.isBlank(iframeUrl2)) {
                                    break;
                                }
                                return Unit.INSTANCE;
                            case 5:
                                referer2 = (String) this.L$2;
                                base2 = (String) this.L$1;
                                ResultKt.throwOnFailure($result);
                                str3 = "LayarKaca";
                                str5 = "hydrax";
                                str6 = "abyss";
                                str7 = "videonode.de";
                                str8 = ".m3u8";
                                z = false;
                                i = 2;
                                str4 = "https://nganunganu.sbs";
                                obj = null;
                                this.L$0 = rawLink3;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                this.L$2 = referer2;
                                this.label = 6;
                                if (ExtractorApiKt.loadExtractor(rawLink3, referer2, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                this.L$0 = rawLink3;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                this.L$2 = referer2;
                                this.L$3 = obj;
                                this.label = 9;
                                iframe = LayarKacaProvider.this.getIframe(rawLink3, (Continuation) this);
                                if (iframe == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                iframeUrl = referer2;
                                referer3 = base2;
                                iframeUrl2 = (String) iframe;
                                if (StringsKt.isBlank(iframeUrl2)) {
                                    break;
                                }
                                return Unit.INSTANCE;
                            case 6:
                                referer2 = (String) this.L$2;
                                base2 = (String) this.L$1;
                                ResultKt.throwOnFailure($result);
                                str3 = "LayarKaca";
                                str5 = "hydrax";
                                str6 = "abyss";
                                str7 = "videonode.de";
                                str8 = ".m3u8";
                                z = false;
                                i = 2;
                                str4 = "https://nganunganu.sbs";
                                obj = null;
                                this.L$0 = rawLink3;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                this.L$2 = referer2;
                                this.L$3 = obj;
                                this.label = 9;
                                iframe = LayarKacaProvider.this.getIframe(rawLink3, (Continuation) this);
                                if (iframe == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                iframeUrl = referer2;
                                referer3 = base2;
                                iframeUrl2 = (String) iframe;
                                if (StringsKt.isBlank(iframeUrl2)) {
                                    break;
                                }
                                return Unit.INSTANCE;
                            case 7:
                                referer2 = (String) this.L$2;
                                base2 = (String) this.L$1;
                                ResultKt.throwOnFailure($result);
                                str3 = "LayarKaca";
                                str5 = "hydrax";
                                str6 = "abyss";
                                str7 = "videonode.de";
                                str8 = ".m3u8";
                                z = false;
                                i = 2;
                                str4 = "https://nganunganu.sbs";
                                obj = null;
                                this.L$0 = rawLink3;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                this.L$2 = referer2;
                                this.label = 8;
                                if (ExtractorApiKt.loadExtractor(rawLink3, str4, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                this.L$0 = rawLink3;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                this.L$2 = referer2;
                                this.L$3 = obj;
                                this.label = 9;
                                iframe = LayarKacaProvider.this.getIframe(rawLink3, (Continuation) this);
                                if (iframe == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                iframeUrl = referer2;
                                referer3 = base2;
                                iframeUrl2 = (String) iframe;
                                if (StringsKt.isBlank(iframeUrl2)) {
                                    break;
                                }
                                return Unit.INSTANCE;
                            case 8:
                                referer2 = (String) this.L$2;
                                base2 = (String) this.L$1;
                                ResultKt.throwOnFailure($result);
                                str3 = "LayarKaca";
                                str5 = "hydrax";
                                str6 = "abyss";
                                str7 = "videonode.de";
                                str8 = ".m3u8";
                                z = false;
                                i = 2;
                                str4 = "https://nganunganu.sbs";
                                obj = null;
                                this.L$0 = rawLink3;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                                this.L$2 = referer2;
                                this.L$3 = obj;
                                this.label = 9;
                                iframe = LayarKacaProvider.this.getIframe(rawLink3, (Continuation) this);
                                if (iframe == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                iframeUrl = referer2;
                                referer3 = base2;
                                iframeUrl2 = (String) iframe;
                                if (StringsKt.isBlank(iframeUrl2)) {
                                    break;
                                }
                                return Unit.INSTANCE;
                            case 9:
                                String referer5 = (String) this.L$2;
                                String base8 = (String) this.L$1;
                                ResultKt.throwOnFailure($result);
                                str3 = "LayarKaca";
                                str5 = "hydrax";
                                str6 = "abyss";
                                str7 = "videonode.de";
                                str8 = ".m3u8";
                                z = false;
                                i = 2;
                                str4 = "https://nganunganu.sbs";
                                obj = null;
                                iframe = $result;
                                iframeUrl = referer5;
                                referer3 = base8;
                                iframeUrl2 = (String) iframe;
                                if (StringsKt.isBlank(iframeUrl2)) {
                                    break;
                                }
                                return Unit.INSTANCE;
                            case 10:
                                String iframeUrl5 = (String) this.L$3;
                                ResultKt.throwOnFailure($result);
                                iframeUrl4 = iframeUrl5;
                                objGenerateM3u8$default2 = $result;
                                Iterable $this$forEach$iv4 = (Iterable) objGenerateM3u8$default2;
                                function3 = this.$callback;
                                while (r11.hasNext()) {
                                    function3.invoke(element$iv2);
                                }
                                Unit unit6 = Unit.INSTANCE;
                                return Unit.INSTANCE;
                            case 11:
                                iframeBase5 = (String) this.L$5;
                                iframeBase4 = (String) this.L$4;
                                iframeReferer3 = (String) this.L$3;
                                iframeUrl = (String) this.L$2;
                                referer3 = (String) this.L$1;
                                ResultKt.throwOnFailure($result);
                                this.L$0 = rawLink3;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(iframeUrl);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(iframeReferer3);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(iframeBase4);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(iframeBase5);
                                this.label = 12;
                                if (ExtractorApiKt.loadExtractor(iframeReferer3, iframeBase5, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            case 12:
                                ResultKt.throwOnFailure($result);
                                return Unit.INSTANCE;
                            case 13:
                                iframeBase2 = (String) this.L$5;
                                iframeBase = (String) this.L$4;
                                iframeReferer = (String) this.L$3;
                                iframeUrl = (String) this.L$2;
                                referer3 = (String) this.L$1;
                                ResultKt.throwOnFailure($result);
                                this.L$0 = rawLink3;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(iframeUrl);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(iframeReferer);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(iframeBase);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(iframeBase2);
                                this.label = 14;
                                if (ExtractorApiKt.loadExtractor(iframeReferer, iframeBase2, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            case 14:
                                ResultKt.throwOnFailure($result);
                                return Unit.INSTANCE;
                            case 15:
                                iframeBase3 = (String) this.L$5;
                                iframeReferer2 = (String) this.L$4;
                                String iframeUrl6 = (String) this.L$3;
                                String referer6 = (String) this.L$2;
                                String base9 = (String) this.L$1;
                                ResultKt.throwOnFailure($result);
                                str4 = "https://nganunganu.sbs";
                                iframeUrl3 = iframeUrl6;
                                iframeUrl = referer6;
                                referer3 = base9;
                                this.L$0 = rawLink3;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(iframeUrl);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(iframeUrl3);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(iframeReferer2);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(iframeBase3);
                                this.label = 16;
                                if (ExtractorApiKt.loadExtractor(iframeUrl3, str4, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            case 16:
                                ResultKt.throwOnFailure($result);
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } catch (Throwable th4) {
                        e = th4;
                        rawLink3 = "https://nganunganu.sbs";
                        str = str2;
                    }
                } catch (Throwable th5) {
                    e = th5;
                    str = "LayarKaca";
                }
            } catch (Throwable th6) {
                e = th6;
                str = str3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00be A[Catch: all -> 0x00c7, TRY_LEAVE, TryCatch #0 {all -> 0x00c7, blocks: (B:30:0x0089, B:32:0x0098, B:34:0x00a0, B:36:0x00a8, B:37:0x00b0, B:40:0x00b5, B:42:0x00be, B:26:0x0081), top: B:50:0x0081 }] */
    /* JADX WARN: Code duplicated, block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getIframe(String $this$getIframe, Continuation<? super String> continuation) {
        C00031 c00031;
        String $this$getIframe2;
        Object objAppGet$default;
        Element iframe;
        String src;
        String strAttr;
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
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00032.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        String base = getBaseUrl($this$getIframe);
                        Companion companion = INSTANCE;
                        String str = !StringsKt.isBlank(base) ? base + '/' : null;
                        c00032.L$0 = SpillingKt.nullOutSpilledVariable($this$getIframe);
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(base);
                        c00032.label = 1;
                        $this$getIframe2 = $this$getIframe;
                        try {
                            objAppGet$default = Companion.appGet$default(companion, $this$getIframe2, null, str, false, c00032, 10, null);
                            if (objAppGet$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Document doc = ((NiceResponse) objAppGet$default).getDocument();
                            iframe = doc.selectFirst("div.embed-container iframe, div.embed iframe, .embed iframe, #player iframe, #content-embed iframe, iframe[src*='stream'], iframe[src*='api'], iframe[src*='embed'], iframe");
                            if (iframe != null || (strAttr = iframe.attr("src")) == null) {
                                src = "";
                            } else {
                                String strAttr2 = strAttr;
                                if (StringsKt.isBlank(strAttr2)) {
                                    strAttr2 = iframe.attr("data-src");
                                }
                                src = strAttr2;
                                if (src == null) {
                                    src = "";
                                }
                            }
                            if (StringsKt.isBlank(src)) {
                                return "";
                            }
                            return MainAPIKt.fixUrl(this, src);
                        } catch (Throwable th) {
                            $this$getIframe = $this$getIframe2;
                            return "";
                        }
                    } catch (Throwable th2) {
                        return "";
                    }
                case 1:
                    String $this$getIframe3 = (String) c00032.L$0;
                    ResultKt.throwOnFailure($result);
                    $this$getIframe2 = $this$getIframe3;
                    objAppGet$default = $result;
                    Document doc2 = ((NiceResponse) objAppGet$default).getDocument();
                    iframe = doc2.selectFirst("div.embed-container iframe, div.embed iframe, .embed iframe, #player iframe, #content-embed iframe, iframe[src*='stream'], iframe[src*='api'], iframe[src*='embed'], iframe");
                    if (iframe != null) {
                        src = "";
                    } else {
                        src = "";
                    }
                    if (StringsKt.isBlank(src)) {
                        return MainAPIKt.fixUrl(this, src);
                    }
                    return "";
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchURL(String url, Continuation<? super String> continuation) {
        C00021 c00021;
        String url2;
        Object objAppGet$default;
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
        C00021 c00022 = c00021;
        Object $result = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Companion companion = INSTANCE;
                c00022.L$0 = url;
                c00022.label = 1;
                url2 = url;
                objAppGet$default = Companion.appGet$default(companion, url2, null, null, false, c00022, 6, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                String url3 = (String) c00022.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url3;
                objAppGet$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse res = (NiceResponse) objAppGet$default;
        String href = res.getHeaders().get("location");
        if (href != null) {
            URI it = new URI(href);
            return it.getScheme() + "://" + it.getHost();
        }
        return url2;
    }

    private final String getImageAttr(Element $this$getImageAttr) {
        if ($this$getImageAttr.hasAttr("src")) {
            return $this$getImageAttr.attr("src");
        }
        if ($this$getImageAttr.hasAttr("data-src")) {
            return $this$getImageAttr.attr("data-src");
        }
        return $this$getImageAttr.attr("src");
    }

    @NotNull
    public final String getBaseUrl(@Nullable String url) {
        URI it = new URI(url);
        return it.getScheme() + "://" + it.getHost();
    }
}
