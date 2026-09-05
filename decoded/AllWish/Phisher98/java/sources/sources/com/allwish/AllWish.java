package com.allwish;

import androidx.annotation.RequiresApi;
import com.fleeksoft.ksoup.Ksoup;
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
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
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
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.Serializable;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: AllWish.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AllWish/classes.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Q2\u00020\u0001:\u0004QRSTB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020%0 2\u0006\u0010&\u001a\u00020'H\u0002J\u001e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J \u0010\"\u001a\u0004\u0018\u00010.2\u0006\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u000200H\u0096@¢\u0006\u0002\u00101J$\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005H\u0097@b\f\b6\u0012\b\b7\u0012\u0004\b\u0003\u00104¢\u0006\u0002\u00105JF\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u001a2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>0<2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020>0<H\u0096@¢\u0006\u0002\u0010AJ2\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020,2\u0006\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020\u0005H\u0002J\"\u0010J\u001a\u00020\u00052\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010F\u001a\u00020,H\u0002J4\u0010M\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0 \u0012\n\u0012\b\u0012\u0004\u0012\u00020C0 0N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010D\u001a\u0004\u0018\u00010EH\u0002R\u001c\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u0010\n\u0002\b\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\u0005X\u0096\u000e¢\u0006\u0010\n\u0002\b\u000e\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u0014\u0010\u0019\u001a\u00020\u001aX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006U"}, d2 = {"Lcom/allwish/AllWish;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "mainUrl$1", "name", "getName", "setName", "name$1", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "setSupportedTypes", "(Ljava/util/Set;)V", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "searchResponseBuilder", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "res", "Lorg/jsoup/nodes/Document;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "page", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/annotation/RequiresApi;", "value", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createEpisode", "Lcom/lagradost/cloudstream3/Episode;", "animeMetaData", "Lcom/allwish/MetaAnimeData;", "episodeNumber", "epId", "isDub", "htmlTitle", "resolveTitle", "epData", "Lcom/allwish/MetaEpisode;", "parseEpisodes", "Lkotlin/Pair;", "epRes", "Lcom/allwish/AllWish$APIResponse;", "Companion", "APIResponse", "APIResponseUrl", "ServerUrl", "AllWish"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAllWish.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllWish.kt\ncom/allwish/AllWish\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,262:1\n2068#2,2:263\n1739#2:280\n1814#2,3:281\n2068#2,2:290\n117#3,10:265\n73#4,5:275\n73#4,5:284\n1#5:289\n*S KotlinDebug\n*F\n+ 1 AllWish.kt\ncom/allwish/AllWish\n*L\n60#1:263,2\n107#1:280\n107#1:281,3\n230#1:290,2\n79#1:265,10\n93#1:275,5\n141#1:284,5\n*E\n"})
public final class AllWish extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String mainUrl = "https://all-wish.me";

    @NotNull
    private static String name = "AllWish";

    @NotNull
    private static final Map<String, String> xmlHeader = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));

    /* JADX INFO: renamed from: mainUrl$1, reason: from kotlin metadata */
    @NotNull
    private String mainUrl = mainUrl;

    /* JADX INFO: renamed from: name$1, reason: from kotlin metadata */
    @NotNull
    private String name = name;

    @NotNull
    private Set<? extends TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});

    @NotNull
    private String lang = "en";
    private final boolean hasMainPage = true;

    @NotNull
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/filter?keyword=&type=&status[]=currently-airing&country=&sort=latest-updated&page=", "Currently Airing"), TuplesKt.to(getMainUrl() + "/filter?keyword=&term_type[]=Movie&type=&country=&sort=latest-updated&page=", "Movies"), TuplesKt.to(getMainUrl() + "/filter?keyword=&term_type[]=Special&type=&country=&sort=latest-updated&page=", "Specials"), TuplesKt.to(getMainUrl() + "/filter?keyword=&term_type[]=TV&type=&country=&sort=latest-updated&page=", "TV Shows")});

    /* JADX INFO: renamed from: com.allwish.AllWish$getMainPage$1 */
    /* JADX INFO: compiled from: AllWish.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.allwish.AllWish", f = "AllWish.kt", i = {0, 0, 0, 1, 1, 1}, l = {267, 80}, m = "getMainPage", n = {"request", "$this$withLock_u24default$iv", "page", "request", "$this$withLock_u24default$iv", "page"}, nl = {268, 269}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AllWish.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.allwish.AllWish$load$1 */
    /* JADX INFO: compiled from: AllWish.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.allwish.AllWish", f = "AllWish.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {88, 92, 98, 111}, m = "load", n = {"url", "url", "res", "id", "vrf", "url", "res", "id", "vrf", "epRes", "malId", "url", "res", "id", "vrf", "epRes", "malId", "syncMetaData", "animeMetaData", "data", "name", "posterRegex", "subEpisodes", "dubEpisodes", "status", "genres", "content", "year"}, nl = {89, 93, 99, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
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
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AllWish.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.allwish.AllWish$loadLinks$1 */
    /* JADX INFO: compiled from: AllWish.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.allwish.AllWish", f = "AllWish.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {141, 144}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "type", "id", "isCasting", "data", "subtitleCallback", "callback", "type", "id", "res", "isCasting"}, nl = {263, 167}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
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
            return AllWish.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.allwish.AllWish$search$1 */
    /* JADX INFO: compiled from: AllWish.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.allwish.AllWish", f = "AllWish.kt", i = {0, 0}, l = {74}, m = "search", n = {"query", "page"}, nl = {75}, s = {"L$0", "I$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        int I$0;
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
            return AllWish.this.search(null, 0, (Continuation) this);
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
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    public void setSupportedTypes(@NotNull Set<? extends TvType> set) {
        this.supportedTypes = set;
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

    /* JADX INFO: compiled from: AllWish.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/allwish/AllWish$Companion;", "", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "name", "getName", "setName", "(Ljava/lang/String;)V", "xmlHeader", "", "getXmlHeader", "()Ljava/util/Map;", "AllWish"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final String getMainUrl() {
            return AllWish.mainUrl;
        }

        @NotNull
        public final String getName() {
            return AllWish.name;
        }

        public final void setName(@NotNull String str) {
            AllWish.name = str;
        }

        @NotNull
        public final Map<String, String> getXmlHeader() {
            return AllWish.xmlHeader;
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    private final List<AnimeSearchResponse> searchResponseBuilder(Document res) {
        String strText;
        String strText2;
        String strText3;
        String strAttr;
        String strSubstringBeforeLast$default;
        List results = new ArrayList();
        Iterable $this$forEach$iv = res.select("div.item");
        for (Object element$iv : $this$forEach$iv) {
            final Element item = (Element) element$iv;
            Element elementSelectFirst = item.selectFirst("div.name > a");
            if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null) {
                strText = "";
            }
            String name2 = strText;
            Element elementSelectFirst2 = item.selectFirst("div.name > a");
            final Integer dubCount = null;
            String url = (elementSelectFirst2 == null || (strAttr = elementSelectFirst2.attr("href")) == null || (strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(strAttr, "/", (String) null, 2, (Object) null)) == null) ? "" : strSubstringBeforeLast$default;
            Element elementSelectFirst3 = item.selectFirst("div.dub-sub-total > span.sub");
            final Integer subCount = (elementSelectFirst3 == null || (strText3 = elementSelectFirst3.text()) == null) ? null : StringsKt.toIntOrNull(strText3);
            Element elementSelectFirst4 = item.selectFirst("div.dub-sub-total > span.dub");
            if (elementSelectFirst4 != null && (strText2 = elementSelectFirst4.text()) != null) {
                dubCount = StringsKt.toIntOrNull(strText2);
            }
            results.add(MainAPIKt.newAnimeSearchResponse$default(this, name2, url, (TvType) null, false, new Function1() { // from class: com.allwish.AllWish$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return AllWish.searchResponseBuilder$lambda$0$0(item, dubCount, subCount, (AnimeSearchResponse) obj);
                }
            }, 12, (Object) null));
        }
        return results;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchResponseBuilder$lambda$0$0(Element $item, Integer $dubCount, Integer $subCount, AnimeSearchResponse $this$newAnimeSearchResponse) {
        Element elementSelectFirst = $item.selectFirst("a.poster img");
        $this$newAnimeSearchResponse.setPosterUrl(elementSelectFirst != null ? elementSelectFirst.attr("data-src") : null);
        MainAPIKt.addDubStatus($this$newAnimeSearchResponse, $dubCount != null, $subCount != null, $dubCount, $subCount);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00051 c00051;
        int page2;
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
        Object $result = c00051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00051.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/filter?keyword=" + query + "&page=" + page;
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00051.I$0 = page;
                c00051.label = 1;
                page2 = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00051, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                int i = c00051.I$0;
                ResultKt.throwOnFailure($result);
                page2 = 1;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document res = ((NiceResponse) $result).getDocument();
        return MainAPIKt.toNewSearchResponseList$default(searchResponseBuilder(res), (Boolean) null, page2, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00e0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws Throwable {
        C00001 c00001;
        Mutex owner$iv;
        int $i$f$withLock;
        MainPageRequest request2;
        Mutex $this$withLock_u24default$iv;
        int $i$f$withLock2;
        Mutex $this$withLock_u24default$iv2;
        Mutex $this$withLock_u24default$iv3;
        MainPageRequest request3;
        Mutex $this$withLock_u24default$iv4;
        boolean z;
        MainPageRequest request4;
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
                Mutex $this$withLock_u24default$iv5 = this.mutex;
                c00002.L$0 = request;
                c00002.L$1 = $this$withLock_u24default$iv5;
                c00002.I$0 = page;
                c00002.label = 1;
                if ($this$withLock_u24default$iv5.lock((Object) null, c00002) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                owner$iv = null;
                $i$f$withLock = 0;
                request2 = request;
                $this$withLock_u24default$iv = $this$withLock_u24default$iv5;
                $i$f$withLock2 = page;
                try {
                    Requests app = MainActivityKt.getApp();
                    String str = request2.getData() + $i$f$withLock2;
                    c00002.L$0 = request2;
                    c00002.L$1 = $this$withLock_u24default$iv;
                    c00002.I$0 = $i$f$withLock2;
                    c00002.label = 2;
                    request3 = request2;
                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv;
                    z = true;
                    try {
                        $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$withLock_u24default$iv2 = owner$iv;
                        $this$withLock_u24default$iv3 = $this$withLock_u24default$iv4;
                        request4 = request3;
                        try {
                            Document res = ((NiceResponse) $result).getDocument();
                            $this$withLock_u24default$iv3.unlock($this$withLock_u24default$iv2);
                            return MainAPIKt.newHomePageResponse(request4.getName(), searchResponseBuilder(res), Boxing.boxBoolean(z));
                        } catch (Throwable th) {
                            th = th;
                            $this$withLock_u24default$iv3.unlock($this$withLock_u24default$iv2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        $this$withLock_u24default$iv2 = owner$iv;
                        $this$withLock_u24default$iv3 = $this$withLock_u24default$iv4;
                        $this$withLock_u24default$iv3.unlock($this$withLock_u24default$iv2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    Mutex mutex = $this$withLock_u24default$iv;
                    $this$withLock_u24default$iv2 = owner$iv;
                    $this$withLock_u24default$iv3 = mutex;
                }
                break;
            case 1:
                int page2 = c00002.I$0;
                Mutex $this$withLock_u24default$iv6 = (Mutex) c00002.L$1;
                MainPageRequest request5 = (MainPageRequest) c00002.L$0;
                ResultKt.throwOnFailure($result);
                $i$f$withLock = 0;
                $i$f$withLock2 = page2;
                owner$iv = null;
                $this$withLock_u24default$iv = $this$withLock_u24default$iv6;
                request2 = request5;
                Requests app2 = MainActivityKt.getApp();
                String str2 = request2.getData() + $i$f$withLock2;
                c00002.L$0 = request2;
                c00002.L$1 = $this$withLock_u24default$iv;
                c00002.I$0 = $i$f$withLock2;
                c00002.label = 2;
                request3 = request2;
                $this$withLock_u24default$iv4 = $this$withLock_u24default$iv;
                z = true;
                $result = Requests.get$default(app2, str2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$withLock_u24default$iv2 = owner$iv;
                $this$withLock_u24default$iv3 = $this$withLock_u24default$iv4;
                request4 = request3;
                Document res2 = ((NiceResponse) $result).getDocument();
                $this$withLock_u24default$iv3.unlock($this$withLock_u24default$iv2);
                return MainAPIKt.newHomePageResponse(request4.getName(), searchResponseBuilder(res2), Boxing.boxBoolean(z));
            case 2:
                int i = c00002.I$0;
                $this$withLock_u24default$iv2 = null;
                $this$withLock_u24default$iv3 = (Mutex) c00002.L$1;
                request4 = (MainPageRequest) c00002.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    z = true;
                    Document res3 = ((NiceResponse) $result).getDocument();
                    $this$withLock_u24default$iv3.unlock($this$withLock_u24default$iv2);
                    return MainAPIKt.newHomePageResponse(request4.getName(), searchResponseBuilder(res3), Boxing.boxBoolean(z));
                } catch (Throwable th4) {
                    th = th4;
                    $this$withLock_u24default$iv3.unlock($this$withLock_u24default$iv2);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x01ae A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x01af  */
    /* JADX WARN: Code duplicated, block: B:31:0x01db  */
    /* JADX WARN: Code duplicated, block: B:38:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:41:0x0258 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x0259  */
    /* JADX WARN: Code duplicated, block: B:45:0x0271  */
    /* JADX WARN: Code duplicated, block: B:53:0x029b  */
    /* JADX WARN: Code duplicated, block: B:56:0x02be  */
    /* JADX WARN: Code duplicated, block: B:61:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:64:0x02de  */
    /* JADX WARN: Code duplicated, block: B:71:0x031c  */
    /* JADX WARN: Code duplicated, block: B:74:0x0321  */
    /* JADX WARN: Code duplicated, block: B:77:0x0330  */
    /* JADX WARN: Code duplicated, block: B:79:0x0334  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:88:0x035f  */
    /* JADX WARN: Code duplicated, block: B:92:0x03ee A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:93:0x03ef  */
    @RequiresApi(26)
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        int i;
        String url2;
        Document res;
        String vrf;
        String id;
        String url3;
        Document res2;
        Object safe;
        APIResponse epRes;
        Integer intOrNull;
        Integer malId;
        String url4;
        Document res3;
        Document res4;
        String url5;
        Integer malId2;
        com.fleeksoft.ksoup.nodes.Document html;
        com.fleeksoft.ksoup.nodes.Element elementSelectFirst;
        String strAttr;
        Element data;
        String name2;
        String string;
        List genres;
        String content;
        Integer num;
        Integer year;
        Elements elementsSelect;
        String strText;
        String string2;
        Elements elementsSelect2;
        Iterable iterableSelect;
        Elements elementsSelect3;
        String strText2;
        Element elementSelectFirst2;
        String strText3;
        String string3;
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
        C00011 c00012 = c00011;
        Object $result = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = url;
                c00012.label = 1;
                obj = coroutine_suspended;
                i = 2;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if ($result == obj) {
                    return obj;
                }
                url2 = url;
                res = ((NiceResponse) $result).getDocument();
                String id2 = res.select("main > div.container").attr("data-id");
                String vrf2 = AllWishUtilsKt.generateEpisodeVrf(id2);
                Requests app2 = MainActivityKt.getApp();
                String str = getMainUrl() + "/ajax/episode/list/" + id2 + "?vrf=" + vrf2;
                Map<String, String> map = xmlHeader;
                c00012.L$0 = url2;
                c00012.L$1 = res;
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id2);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(vrf2);
                c00012.label = i;
                C00011 c00013 = c00012;
                vrf = vrf2;
                id = id2;
                $result = Requests.get$default(app2, str, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4092, (Object) null);
                c00012 = c00013;
                if ($result == obj) {
                    return obj;
                }
                url3 = url2;
                res2 = res;
                NiceResponse this_$iv = (NiceResponse) $result;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(APIResponse.class));
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                epRes = (APIResponse) safe;
                if (epRes != null || (html = epRes.getHtml()) == null || (elementSelectFirst = html.selectFirst("div.range > div > a")) == null || (strAttr = elementSelectFirst.attr("data-mal")) == null) {
                    intOrNull = null;
                } else {
                    intOrNull = StringsKt.toIntOrNull(strAttr);
                }
                malId = intOrNull;
                c00012.L$0 = url3;
                c00012.L$1 = res2;
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(vrf);
                c00012.L$4 = epRes;
                c00012.L$5 = malId;
                c00012.label = 3;
                url4 = url3;
                res3 = res2;
                C00011 c00014 = c00012;
                $result = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?mal_id=" + malId, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00014, 4094, (Object) null);
                c00012 = c00014;
                if ($result == obj) {
                    return obj;
                }
                res4 = res3;
                url5 = url4;
                malId2 = malId;
                String syncMetaData = ((NiceResponse) $result).getText();
                MetaAnimeData animeMetaData = AllWishUtilsKt.parseAnimeData(syncMetaData);
                data = res4.selectFirst("div#media-info");
                if (data != null || (elementSelectFirst2 = data.selectFirst("h1.title")) == null || (strText3 = elementSelectFirst2.text()) == null || (string3 = StringsKt.trim(strText3).toString()) == null || (name2 = StringsKt.replace$default(string3, " (Dub)", "", false, 4, (Object) null)) == null) {
                    name2 = "";
                }
                Regex posterRegex = new Regex("/'(.*)'/gm");
                Pair<List<Episode>, List<Episode>> episodes = parseEpisodes(epRes, animeMetaData);
                List subEpisodes = (List) episodes.component1();
                List dubEpisodes = (List) episodes.component2();
                if (data != null || (elementsSelect3 = data.select("div:contains(Status:) > span > a")) == null || (strText2 = elementsSelect3.text()) == null) {
                    string = null;
                } else {
                    string = StringsKt.trim(strText2).toString();
                }
                ShowStatus status = AllWishUtilsKt.getStatus(string);
                if (data != null || (iterableSelect = data.select("div:contains(Genre:) > span > a")) == null) {
                    genres = null;
                } else {
                    Iterable $this$map$iv = iterableSelect;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        Element it = (Element) item$iv$iv;
                        destination$iv$iv.add(it.text());
                    }
                    genres = (List) destination$iv$iv;
                }
                if (data != null || (elementsSelect2 = data.select("div.status > span.rating.mini-status")) == null) {
                    content = null;
                } else {
                    content = elementsSelect2.text();
                }
                if (data == null && (elementsSelect = data.select("div:contains(Premiered:) > span > a")) != null && (strText = elementsSelect.text()) != null && (string2 = StringsKt.trim(strText).toString()) != null) {
                    num = null;
                    String strSubstringAfterLast$default = StringsKt.substringAfterLast$default(string2, " ", (String) null, 2, (Object) null);
                    if (strSubstringAfterLast$default != null) {
                        year = StringsKt.toIntOrNull(strSubstringAfterLast$default);
                    }
                    String name3 = name2;
                    TvType tvType = TvType.Anime;
                    Document res5 = res4;
                    C00022 c00022 = new C00022(subEpisodes, dubEpisodes, malId2, status, genres, data, content, year, animeMetaData, posterRegex, res5, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(res5);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(id);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(vrf);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(epRes);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(malId2);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(data);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(name3);
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(posterRegex);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(status);
                    c00012.L$14 = SpillingKt.nullOutSpilledVariable(genres);
                    c00012.L$15 = SpillingKt.nullOutSpilledVariable(content);
                    c00012.L$16 = SpillingKt.nullOutSpilledVariable(year);
                    c00012.label = 4;
                    $result = MainAPIKt.newAnimeLoadResponse$default(this, name3, url5, tvType, false, c00022, c00012, 8, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    return $result;
                }
                num = null;
                year = num;
                String name4 = name2;
                TvType tvType2 = TvType.Anime;
                Document res6 = res4;
                C00022 c00023 = new C00022(subEpisodes, dubEpisodes, malId2, status, genres, data, content, year, animeMetaData, posterRegex, res6, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(res6);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(vrf);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(epRes);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(malId2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(data);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(name4);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(posterRegex);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(status);
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(genres);
                c00012.L$15 = SpillingKt.nullOutSpilledVariable(content);
                c00012.L$16 = SpillingKt.nullOutSpilledVariable(year);
                c00012.label = 4;
                $result = MainAPIKt.newAnimeLoadResponse$default(this, name4, url5, tvType2, false, c00023, c00012, 8, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                return $result;
            case 1:
                url2 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                i = 2;
                res = ((NiceResponse) $result).getDocument();
                String id3 = res.select("main > div.container").attr("data-id");
                String vrf3 = AllWishUtilsKt.generateEpisodeVrf(id3);
                Requests app3 = MainActivityKt.getApp();
                String str2 = getMainUrl() + "/ajax/episode/list/" + id3 + "?vrf=" + vrf3;
                Map<String, String> map2 = xmlHeader;
                c00012.L$0 = url2;
                c00012.L$1 = res;
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id3);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(vrf3);
                c00012.label = i;
                C00011 c00015 = c00012;
                vrf = vrf3;
                id = id3;
                $result = Requests.get$default(app3, str2, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00015, 4092, (Object) null);
                c00012 = c00015;
                if ($result == obj) {
                    return obj;
                }
                url3 = url2;
                res2 = res;
                NiceResponse this_$iv2 = (NiceResponse) $result;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(APIResponse.class));
                epRes = (APIResponse) safe;
                if (epRes != null) {
                    intOrNull = null;
                } else {
                    intOrNull = null;
                }
                malId = intOrNull;
                c00012.L$0 = url3;
                c00012.L$1 = res2;
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(vrf);
                c00012.L$4 = epRes;
                c00012.L$5 = malId;
                c00012.label = 3;
                url4 = url3;
                res3 = res2;
                C00011 c00016 = c00012;
                $result = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?mal_id=" + malId, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00016, 4094, (Object) null);
                c00012 = c00016;
                if ($result == obj) {
                    return obj;
                }
                res4 = res3;
                url5 = url4;
                malId2 = malId;
                String syncMetaData2 = ((NiceResponse) $result).getText();
                MetaAnimeData animeMetaData2 = AllWishUtilsKt.parseAnimeData(syncMetaData2);
                data = res4.selectFirst("div#media-info");
                if (data != null) {
                    name2 = "";
                } else {
                    name2 = "";
                }
                Regex posterRegex2 = new Regex("/'(.*)'/gm");
                Pair<List<Episode>, List<Episode>> episodes2 = parseEpisodes(epRes, animeMetaData2);
                List subEpisodes2 = (List) episodes2.component1();
                List dubEpisodes2 = (List) episodes2.component2();
                if (data != null) {
                    string = null;
                } else {
                    string = null;
                }
                ShowStatus status2 = AllWishUtilsKt.getStatus(string);
                if (data != null) {
                    genres = null;
                } else {
                    genres = null;
                }
                if (data != null) {
                    content = null;
                } else {
                    content = null;
                }
                if (data == null) {
                    num = null;
                    year = num;
                } else {
                    num = null;
                    year = num;
                }
                String name5 = name2;
                TvType tvType3 = TvType.Anime;
                Document res7 = res4;
                C00022 c00024 = new C00022(subEpisodes2, dubEpisodes2, malId2, status2, genres, data, content, year, animeMetaData2, posterRegex2, res7, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(res7);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(vrf);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(epRes);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(malId2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(syncMetaData2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(data);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(name5);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(posterRegex2);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(subEpisodes2);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(dubEpisodes2);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(status2);
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(genres);
                c00012.L$15 = SpillingKt.nullOutSpilledVariable(content);
                c00012.L$16 = SpillingKt.nullOutSpilledVariable(year);
                c00012.label = 4;
                $result = MainAPIKt.newAnimeLoadResponse$default(this, name5, url5, tvType3, false, c00024, c00012, 8, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                return $result;
            case 2:
                String vrf4 = (String) c00012.L$3;
                String id4 = (String) c00012.L$2;
                Document res8 = (Document) c00012.L$1;
                String url6 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                vrf = vrf4;
                obj = coroutine_suspended;
                id = id4;
                res2 = res8;
                url3 = url6;
                NiceResponse this_$iv3 = (NiceResponse) $result;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(APIResponse.class));
                epRes = (APIResponse) safe;
                if (epRes != null) {
                    intOrNull = null;
                } else {
                    intOrNull = null;
                }
                malId = intOrNull;
                c00012.L$0 = url3;
                c00012.L$1 = res2;
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(vrf);
                c00012.L$4 = epRes;
                c00012.L$5 = malId;
                c00012.label = 3;
                url4 = url3;
                res3 = res2;
                C00011 c00017 = c00012;
                $result = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?mal_id=" + malId, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00017, 4094, (Object) null);
                c00012 = c00017;
                if ($result == obj) {
                    return obj;
                }
                res4 = res3;
                url5 = url4;
                malId2 = malId;
                String syncMetaData3 = ((NiceResponse) $result).getText();
                MetaAnimeData animeMetaData3 = AllWishUtilsKt.parseAnimeData(syncMetaData3);
                data = res4.selectFirst("div#media-info");
                if (data != null) {
                    name2 = "";
                } else {
                    name2 = "";
                }
                Regex posterRegex3 = new Regex("/'(.*)'/gm");
                Pair<List<Episode>, List<Episode>> episodes3 = parseEpisodes(epRes, animeMetaData3);
                List subEpisodes3 = (List) episodes3.component1();
                List dubEpisodes3 = (List) episodes3.component2();
                if (data != null) {
                    string = null;
                } else {
                    string = null;
                }
                ShowStatus status3 = AllWishUtilsKt.getStatus(string);
                if (data != null) {
                    genres = null;
                } else {
                    genres = null;
                }
                if (data != null) {
                    content = null;
                } else {
                    content = null;
                }
                if (data == null) {
                    num = null;
                    year = num;
                } else {
                    num = null;
                    year = num;
                }
                String name6 = name2;
                TvType tvType4 = TvType.Anime;
                Document res9 = res4;
                C00022 c00025 = new C00022(subEpisodes3, dubEpisodes3, malId2, status3, genres, data, content, year, animeMetaData3, posterRegex3, res9, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(res9);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(vrf);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(epRes);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(malId2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(syncMetaData3);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(animeMetaData3);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(data);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(name6);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(posterRegex3);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(status3);
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(genres);
                c00012.L$15 = SpillingKt.nullOutSpilledVariable(content);
                c00012.L$16 = SpillingKt.nullOutSpilledVariable(year);
                c00012.label = 4;
                $result = MainAPIKt.newAnimeLoadResponse$default(this, name6, url5, tvType4, false, c00025, c00012, 8, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                return $result;
            case 3:
                Integer malId3 = (Integer) c00012.L$5;
                APIResponse epRes2 = (APIResponse) c00012.L$4;
                String vrf5 = (String) c00012.L$3;
                String id5 = (String) c00012.L$2;
                res4 = (Document) c00012.L$1;
                String url7 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                malId2 = malId3;
                obj = coroutine_suspended;
                epRes = epRes2;
                vrf = vrf5;
                id = id5;
                url5 = url7;
                String syncMetaData4 = ((NiceResponse) $result).getText();
                MetaAnimeData animeMetaData4 = AllWishUtilsKt.parseAnimeData(syncMetaData4);
                data = res4.selectFirst("div#media-info");
                if (data != null) {
                    name2 = "";
                } else {
                    name2 = "";
                }
                Regex posterRegex4 = new Regex("/'(.*)'/gm");
                Pair<List<Episode>, List<Episode>> episodes4 = parseEpisodes(epRes, animeMetaData4);
                List subEpisodes4 = (List) episodes4.component1();
                List dubEpisodes4 = (List) episodes4.component2();
                if (data != null) {
                    string = null;
                } else {
                    string = null;
                }
                ShowStatus status4 = AllWishUtilsKt.getStatus(string);
                if (data != null) {
                    genres = null;
                } else {
                    genres = null;
                }
                if (data != null) {
                    content = null;
                } else {
                    content = null;
                }
                if (data == null) {
                    num = null;
                    year = num;
                } else {
                    num = null;
                    year = num;
                }
                String name7 = name2;
                TvType tvType5 = TvType.Anime;
                Document res10 = res4;
                C00022 c00026 = new C00022(subEpisodes4, dubEpisodes4, malId2, status4, genres, data, content, year, animeMetaData4, posterRegex4, res10, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(res10);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(vrf);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(epRes);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(malId2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(syncMetaData4);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(animeMetaData4);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(data);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(name7);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(posterRegex4);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(subEpisodes4);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(dubEpisodes4);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(status4);
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(genres);
                c00012.L$15 = SpillingKt.nullOutSpilledVariable(content);
                c00012.L$16 = SpillingKt.nullOutSpilledVariable(year);
                c00012.label = 4;
                $result = MainAPIKt.newAnimeLoadResponse$default(this, name7, url5, tvType5, false, c00026, c00012, 8, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                return $result;
            case 4:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.allwish.AllWish$load$2 */
    /* JADX INFO: compiled from: AllWish.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.allwish.AllWish$load$2", f = "AllWish.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nAllWish.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllWish.kt\ncom/allwish/AllWish$load$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,262:1\n296#2,2:263\n296#2,2:265\n1#3:267\n*S KotlinDebug\n*F\n+ 1 AllWish.kt\ncom/allwish/AllWish$load$2\n*L\n121#1:263,2\n126#1:265,2\n*E\n"})
    static final class C00022 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ MetaAnimeData $animeMetaData;
        final /* synthetic */ String $content;
        final /* synthetic */ Element $data;
        final /* synthetic */ List<Episode> $dubEpisodes;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ Integer $malId;
        final /* synthetic */ Regex $posterRegex;
        final /* synthetic */ Document $res;
        final /* synthetic */ ShowStatus $status;
        final /* synthetic */ List<Episode> $subEpisodes;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(List<Episode> list, List<Episode> list2, Integer num, ShowStatus showStatus, List<String> list3, Element element, String str, Integer num2, MetaAnimeData metaAnimeData, Regex regex, Document document, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$subEpisodes = list;
            this.$dubEpisodes = list2;
            this.$malId = num;
            this.$status = showStatus;
            this.$genres = list3;
            this.$data = element;
            this.$content = str;
            this.$year = num2;
            this.$animeMetaData = metaAnimeData;
            this.$posterRegex = regex;
            this.$res = document;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$subEpisodes, this.$dubEpisodes, this.$malId, this.$status, this.$genres, this.$data, this.$content, this.$year, this.$animeMetaData, this.$posterRegex, this.$res, continuation);
            c00022.L$0 = obj;
            return c00022;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x00a3  */
        /* JADX WARN: Code duplicated, block: B:32:0x00b2  */
        /* JADX WARN: Code duplicated, block: B:34:0x00ba  */
        /* JADX WARN: Code duplicated, block: B:37:0x00c6  */
        /* JADX WARN: Code duplicated, block: B:42:0x00db  */
        /* JADX WARN: Code duplicated, block: B:44:0x00de  */
        /* JADX WARN: Code duplicated, block: B:46:0x00e2  */
        /* JADX WARN: Code duplicated, block: B:49:0x00ef  */
        /* JADX WARN: Code duplicated, block: B:51:0x00f2  */
        /* JADX WARN: Code duplicated, block: B:72:0x013d  */
        /* JADX WARN: Code duplicated, block: B:73:0x0142  */
        public final Object invokeSuspend(Object $result) {
            Element elementSelectFirst;
            String strAttr;
            MatchResult matchResultFind$default;
            String strAttr2;
            Element element;
            Element elementSelectFirst2;
            MatchResult.Destructured destructured;
            List list;
            String url;
            Iterable images;
            Object element$iv;
            ImageData imageData;
            ImageData it;
            Iterable iterableSelect;
            Object next;
            Element element2;
            String strText;
            Element it2;
            Element elementSelectFirst3;
            Iterable images2;
            Object element$iv2;
            ImageData imageData2;
            ImageData it3;
            Element elementSelectFirst4;
            String strText2;
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$subEpisodes);
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Dubbed, this.$dubEpisodes);
                    LoadResponse.Companion.addMalId(loadResponse, this.$malId);
                    loadResponse.setShowStatus(this.$status);
                    loadResponse.setTags(this.$genres);
                    Element element3 = this.$data;
                    Integer intOrNull = null;
                    loadResponse.setPlot((element3 == null || (elementSelectFirst4 = element3.selectFirst("div.description > div.full > div")) == null || (strText2 = elementSelectFirst4.text()) == null) ? null : StringsKt.trim(strText2).toString());
                    loadResponse.setContentRating(this.$content);
                    loadResponse.setYear(this.$year);
                    MetaAnimeData metaAnimeData = this.$animeMetaData;
                    if (metaAnimeData == null || (images2 = metaAnimeData.getImages()) == null) {
                        Regex regex = this.$posterRegex;
                        elementSelectFirst = this.$res.selectFirst("div.media-bg");
                        if (elementSelectFirst != null || (strAttr = elementSelectFirst.attr("style")) == null) {
                            strAttr = "";
                        }
                        matchResultFind$default = Regex.find$default(regex, strAttr, 0, 2, (Object) null);
                        if (matchResultFind$default != null || (destructured = matchResultFind$default.getDestructured()) == null || (list = destructured.toList()) == null) {
                            strAttr2 = null;
                        } else {
                            strAttr2 = (String) CollectionsKt.getOrNull(list, 0);
                        }
                        if (strAttr2 == null) {
                            element = this.$data;
                            if (element != null || (elementSelectFirst2 = element.selectFirst("div.poster img")) == null) {
                                strAttr2 = null;
                            } else {
                                strAttr2 = elementSelectFirst2.attr("src");
                            }
                            if (strAttr2 == null) {
                                strAttr2 = "";
                            }
                        }
                    } else {
                        Iterable $this$firstOrNull$iv = images2;
                        Iterator it4 = $this$firstOrNull$iv.iterator();
                        do {
                            if (it4.hasNext()) {
                                element$iv2 = it4.next();
                                it3 = (ImageData) element$iv2;
                            } else {
                                element$iv2 = null;
                            }
                            imageData2 = (ImageData) element$iv2;
                            if (imageData2 != null || (strAttr2 = imageData2.getUrl()) == null) {
                                Regex regex2 = this.$posterRegex;
                                elementSelectFirst = this.$res.selectFirst("div.media-bg");
                                if (elementSelectFirst != null) {
                                    strAttr = "";
                                } else {
                                    strAttr = "";
                                }
                                matchResultFind$default = Regex.find$default(regex2, strAttr, 0, 2, (Object) null);
                                if (matchResultFind$default != null) {
                                    strAttr2 = null;
                                } else {
                                    strAttr2 = null;
                                }
                                if (strAttr2 == null) {
                                    element = this.$data;
                                    if (element != null) {
                                        strAttr2 = null;
                                    } else {
                                        strAttr2 = null;
                                    }
                                    if (strAttr2 == null) {
                                        strAttr2 = "";
                                    }
                                }
                            }
                        } while (!Intrinsics.areEqual(it3.getCoverType(), "Fanart"));
                        imageData2 = (ImageData) element$iv2;
                        if (imageData2 != null) {
                            Regex regex3 = this.$posterRegex;
                            elementSelectFirst = this.$res.selectFirst("div.media-bg");
                            if (elementSelectFirst != null) {
                                strAttr = "";
                            } else {
                                strAttr = "";
                            }
                            matchResultFind$default = Regex.find$default(regex3, strAttr, 0, 2, (Object) null);
                            if (matchResultFind$default != null) {
                                strAttr2 = null;
                            } else {
                                strAttr2 = null;
                            }
                            if (strAttr2 == null) {
                                element = this.$data;
                                if (element != null) {
                                    strAttr2 = null;
                                } else {
                                    strAttr2 = null;
                                }
                                if (strAttr2 == null) {
                                    strAttr2 = "";
                                }
                            }
                        } else {
                            Regex regex4 = this.$posterRegex;
                            elementSelectFirst = this.$res.selectFirst("div.media-bg");
                            if (elementSelectFirst != null) {
                                strAttr = "";
                            } else {
                                strAttr = "";
                            }
                            matchResultFind$default = Regex.find$default(regex4, strAttr, 0, 2, (Object) null);
                            if (matchResultFind$default != null) {
                                strAttr2 = null;
                            } else {
                                strAttr2 = null;
                            }
                            if (strAttr2 == null) {
                                element = this.$data;
                                if (element != null) {
                                    strAttr2 = null;
                                } else {
                                    strAttr2 = null;
                                }
                                if (strAttr2 == null) {
                                    strAttr2 = "";
                                }
                            }
                        }
                    }
                    loadResponse.setBackgroundPosterUrl(strAttr2);
                    Element element4 = this.$data;
                    if (element4 == null || (elementSelectFirst3 = element4.selectFirst("#media-info div.poster img")) == null || (url = elementSelectFirst3.attr("src")) == null) {
                        MetaAnimeData metaAnimeData2 = this.$animeMetaData;
                        if (metaAnimeData2 == null || (images = metaAnimeData2.getImages()) == null) {
                            url = null;
                        } else {
                            Iterable $this$firstOrNull$iv2 = images;
                            Iterator it5 = $this$firstOrNull$iv2.iterator();
                            do {
                                if (it5.hasNext()) {
                                    element$iv = it5.next();
                                    it = (ImageData) element$iv;
                                } else {
                                    element$iv = null;
                                }
                                imageData = (ImageData) element$iv;
                                if (imageData != null) {
                                    url = imageData.getUrl();
                                } else {
                                    url = null;
                                }
                            } while (!StringsKt.equals(it.getCoverType(), "Poster", true));
                            imageData = (ImageData) element$iv;
                            if (imageData != null) {
                                url = imageData.getUrl();
                            } else {
                                url = null;
                            }
                        }
                    }
                    loadResponse.setPosterUrl(url);
                    Element element5 = this.$data;
                    if (element5 != null && (iterableSelect = element5.select("div.meta > div > span")) != null) {
                        Iterator it6 = iterableSelect.iterator();
                        do {
                            if (it6.hasNext()) {
                                next = it6.next();
                                it2 = (Element) next;
                            } else {
                                next = null;
                            }
                            element2 = (Element) next;
                            if (element2 != null && (strText = element2.text()) != null) {
                                intOrNull = StringsKt.toIntOrNull(strText);
                            }
                        } while (!Intrinsics.areEqual(it2.attr("itemprop"), "dateCreated"));
                        element2 = (Element) next;
                        if (element2 != null) {
                            intOrNull = StringsKt.toIntOrNull(strText);
                        }
                    }
                    loadResponse.setYear(intOrNull);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:34:0x01fc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:37:0x020c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00031 c00031;
        AllWish allWish;
        boolean z;
        boolean z2;
        Object obj;
        C00031 c00032;
        String data2;
        boolean isCasting2;
        Function1<? super ExtractorLink, Unit> function3;
        String id;
        Object $result;
        Object obj2;
        List type;
        Function1<? super SubtitleFile, Unit> function4;
        Object safe;
        APIResponse res;
        List listSelect;
        Object obj3;
        C00042 c00042;
        APIResponse res2;
        boolean isCasting3;
        Function1<? super ExtractorLink, Unit> function5;
        String id2;
        Function1<? super SubtitleFile, Unit> function6;
        String data3;
        Integer status;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
                allWish = this;
            } else {
                allWish = this;
                c00031 = allWish.new C00031(continuation);
            }
        } else {
            allWish = this;
            c00031 = allWish.new C00031(continuation);
        }
        C00031 c00033 = c00031;
        Object $result2 = c00033.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00033.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                List type2 = StringsKt.split$default((CharSequence) StringsKt.split$default(StringsKt.replace$default(data, allWish.getMainUrl() + '/', "", false, 4, (Object) null), new String[]{"|"}, false, 0, 6, (Object) null).get(0), new String[]{","}, false, 0, 6, (Object) null);
                String id3 = (String) StringsKt.split$default(StringsKt.replace$default(data, allWish.getMainUrl() + '/', "", false, 4, (Object) null), new String[]{"|"}, false, 0, 6, (Object) null).get(1);
                Requests app = MainActivityKt.getApp();
                String str = allWish.getMainUrl() + "/ajax/server/list?servers=" + id3;
                Map<String, String> map = xmlHeader;
                c00033.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00033.L$1 = function1;
                c00033.L$2 = function2;
                c00033.L$3 = type2;
                c00033.L$4 = SpillingKt.nullOutSpilledVariable(id3);
                c00033.Z$0 = isCasting;
                c00033.label = 1;
                z = false;
                z2 = true;
                obj = coroutine_suspended;
                Object obj4 = Requests.get$default(app, str, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00033, 4092, (Object) null);
                c00032 = c00033;
                if (obj4 == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function2;
                id = id3;
                $result = $result2;
                obj2 = obj4;
                type = type2;
                function4 = function1;
                NiceResponse this_$iv = (NiceResponse) obj2;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(APIResponse.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                res = (APIResponse) safe;
                if (res != null && (status = res.getStatus()) != null && status.intValue() == 200) {
                    z = true;
                }
                if (z) {
                    listSelect = res.getHtml().select("div.server-type");
                    obj3 = obj;
                    c00042 = new C00042(type, allWish, function4, function3, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(type);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(id);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(res);
                    c00032.Z$0 = isCasting2;
                    c00032.label = 2;
                    if (ParCollectionsKt.amap(listSelect, c00042, c00032) == obj3) {
                        return obj3;
                    }
                    Function1<? super SubtitleFile, Unit> function7 = function4;
                    res2 = res;
                    isCasting3 = isCasting2;
                    function5 = function3;
                    id2 = id;
                    function6 = function7;
                    data3 = data2;
                }
                return Boxing.boxBoolean(z2);
            case 1:
                boolean isCasting4 = c00033.Z$0;
                String id4 = (String) c00033.L$4;
                List type3 = (List) c00033.L$3;
                Function1<? super ExtractorLink, Unit> function8 = (Function1) c00033.L$2;
                Function1<? super SubtitleFile, Unit> function9 = (Function1) c00033.L$1;
                data2 = (String) c00033.L$0;
                ResultKt.throwOnFailure($result2);
                $result = $result2;
                function3 = function8;
                z = false;
                z2 = true;
                id = id4;
                type = type3;
                isCasting2 = isCasting4;
                c00032 = c00033;
                obj2 = $result;
                obj = coroutine_suspended;
                function4 = function9;
                NiceResponse this_$iv2 = (NiceResponse) obj2;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(APIResponse.class));
                res = (APIResponse) safe;
                if (res != null) {
                    z = true;
                }
                if (z) {
                    listSelect = res.getHtml().select("div.server-type");
                    obj3 = obj;
                    c00042 = new C00042(type, allWish, function4, function3, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(type);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(id);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(res);
                    c00032.Z$0 = isCasting2;
                    c00032.label = 2;
                    if (ParCollectionsKt.amap(listSelect, c00042, c00032) == obj3) {
                        return obj3;
                    }
                    Function1<? super SubtitleFile, Unit> function10 = function4;
                    res2 = res;
                    isCasting3 = isCasting2;
                    function5 = function3;
                    id2 = id;
                    function6 = function10;
                    data3 = data2;
                }
                return Boxing.boxBoolean(z2);
            case 2:
                isCasting3 = c00033.Z$0;
                res2 = (APIResponse) c00033.L$5;
                id2 = (String) c00033.L$4;
                function5 = (Function1) c00033.L$2;
                function6 = (Function1) c00033.L$1;
                data3 = (String) c00033.L$0;
                ResultKt.throwOnFailure($result2);
                z2 = true;
                return Boxing.boxBoolean(z2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.allwish.AllWish$loadLinks$2 */
    /* JADX INFO: compiled from: AllWish.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "section", "Lcom/fleeksoft/ksoup/nodes/Element;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.allwish.AllWish$loadLinks$2", f = "AllWish.kt", i = {0, 0, 0}, l = {149}, m = "invokeSuspend", n = {"section", "sectionType", "isHardSub"}, nl = {164}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<com.fleeksoft.ksoup.nodes.Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ List<String> $type;
        int I$0;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AllWish this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(List<String> list, AllWish allWish, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$type = list;
            this.this$0 = allWish;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$type, this.this$0, this.$subtitleCallback, this.$callback, continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(com.fleeksoft.ksoup.nodes.Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        public final Object invokeSuspend(Object obj) {
            ?? r1;
            String str;
            String strText;
            com.fleeksoft.ksoup.nodes.Element element = (com.fleeksoft.ksoup.nodes.Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    String strAttr = element.attr("data-type");
                    com.fleeksoft.ksoup.nodes.Element elementSelectFirst = element.selectFirst("span");
                    ?? Contains = (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null) ? 0 : StringsKt.contains(strText, "H-Sub", true);
                    if (this.$type.contains(strAttr)) {
                        List listSelect = element.select("div.server-list > div.server");
                        AllWish allWish = this.this$0;
                        boolean z = Contains != 0;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(strAttr);
                        this.I$0 = Contains;
                        this.label = 1;
                        if (ParCollectionsKt.amap(listSelect, new AnonymousClass1(allWish, strAttr, z, this.$subtitleCallback, this.$callback, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        r1 = Contains;
                        str = strAttr;
                    }
                    return Unit.INSTANCE;
                case 1:
                    int i = this.I$0;
                    str = (String) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    r1 = i;
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.allwish.AllWish$loadLinks$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: AllWish.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "server", "Lcom/fleeksoft/ksoup/nodes/Element;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.allwish.AllWish$loadLinks$2$1", f = "AllWish.kt", i = {0, 0, 1, 1, 1, 1, 1}, l = {152, 161}, m = "invokeSuspend", n = {"server", "dataId", "server", "dataId", "apiRes", "realUrl", "epIdWithType"}, nl = {153, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
        @SourceDebugExtension({"SMAP\nAllWish.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllWish.kt\ncom/allwish/AllWish$loadLinks$2$1\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,262:1\n73#2,5:263\n*S KotlinDebug\n*F\n+ 1 AllWish.kt\ncom/allwish/AllWish$loadLinks$2$1\n*L\n153#1:263,5\n*E\n"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<com.fleeksoft.ksoup.nodes.Element, Continuation<? super Boolean>, Object> {
            final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
            final /* synthetic */ boolean $isHardSub;
            final /* synthetic */ String $sectionType;
            final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
            /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;
            final /* synthetic */ AllWish this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AllWish allWish, String str, boolean z, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = allWish;
                this.$sectionType = str;
                this.$isHardSub = z;
                this.$subtitleCallback = function1;
                this.$callback = function2;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, this.$sectionType, this.$isHardSub, this.$subtitleCallback, this.$callback, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(com.fleeksoft.ksoup.nodes.Element element, Continuation<? super Boolean> continuation) {
                return create(element, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                Object obj;
                String dataId;
                Object safe;
                String realUrl;
                ServerUrl result;
                com.fleeksoft.ksoup.nodes.Element server = (com.fleeksoft.ksoup.nodes.Element) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String dataId2 = server.attr("data-link-id");
                        this.L$0 = SpillingKt.nullOutSpilledVariable(server);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(dataId2);
                        this.label = 1;
                        obj = Requests.get$default(MainActivityKt.getApp(), this.this$0.getMainUrl() + "/ajax/server?get=" + dataId2, AllWish.INSTANCE.getXmlHeader(), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dataId = dataId2;
                        break;
                    case 1:
                        String dataId3 = (String) this.L$1;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        dataId = dataId3;
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                NiceResponse this_$iv = (NiceResponse) obj;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(APIResponseUrl.class));
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                APIResponseUrl apiRes = (APIResponseUrl) safe;
                if (apiRes == null || (result = apiRes.getResult()) == null || (realUrl = result.getUrl()) == null) {
                    realUrl = "";
                }
                String str = this.$sectionType;
                String epIdWithType = Intrinsics.areEqual(str, "dub") ? "[Dub]" : (Intrinsics.areEqual(str, "sub") && this.$isHardSub) ? "[Hard Sub]" : "[Sub]";
                this.L$0 = SpillingKt.nullOutSpilledVariable(server);
                this.L$1 = SpillingKt.nullOutSpilledVariable(dataId);
                this.L$2 = SpillingKt.nullOutSpilledVariable(apiRes);
                this.L$3 = SpillingKt.nullOutSpilledVariable(realUrl);
                this.L$4 = SpillingKt.nullOutSpilledVariable(epIdWithType);
                this.label = 2;
                Object objLoadExtractor = ExtractorApiKt.loadExtractor(realUrl, epIdWithType, this.$subtitleCallback, this.$callback, (Continuation) this);
                return objLoadExtractor == coroutine_suspended ? coroutine_suspended : objLoadExtractor;
            }
        }
    }

    /* JADX INFO: compiled from: AllWish.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010Ê\u0001\u0002\b\u001b¨\u0006\u001a"}, d2 = {"Lcom/allwish/AllWish$APIResponse;", "", "status", "", "result", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResult", "()Ljava/lang/String;", "html", "Lcom/fleeksoft/ksoup/nodes/Document;", "getHtml", "()Lcom/fleeksoft/ksoup/nodes/Document;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/allwish/AllWish$APIResponse;", "equals", "", "other", "hashCode", "toString", "AllWish", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class APIResponse {

        @Nullable
        private final String result;

        @Nullable
        private final Integer status;

        /* JADX WARN: Multi-variable type inference failed */
        public APIResponse() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ APIResponse copy$default(APIResponse aPIResponse, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                num = aPIResponse.status;
            }
            if ((i & 2) != 0) {
                str = aPIResponse.result;
            }
            return aPIResponse.copy(num, str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getStatus() {
            return this.status;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getResult() {
            return this.result;
        }

        @NotNull
        public final APIResponse copy(@Nullable Integer status, @Nullable String result) {
            return new APIResponse(status, result);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof APIResponse)) {
                return false;
            }
            APIResponse aPIResponse = (APIResponse) other;
            return Intrinsics.areEqual(this.status, aPIResponse.status) && Intrinsics.areEqual(this.result, aPIResponse.result);
        }

        public int hashCode() {
            return ((this.status == null ? 0 : this.status.hashCode()) * 31) + (this.result != null ? this.result.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "APIResponse(status=" + this.status + ", result=" + this.result + ')';
        }

        public APIResponse(@Nullable Integer status, @Nullable String result) {
            this.status = status;
            this.result = result;
        }

        public /* synthetic */ APIResponse(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
        }

        @Nullable
        public final Integer getStatus() {
            return this.status;
        }

        @Nullable
        public final String getResult() {
            return this.result;
        }

        @NotNull
        public final com.fleeksoft.ksoup.nodes.Document getHtml() {
            Ksoup ksoup = Ksoup.INSTANCE;
            String str = this.result;
            if (str == null) {
                str = "";
            }
            return Ksoup.parse$default(ksoup, str, (String) null, 2, (Object) null);
        }
    }

    /* JADX INFO: compiled from: AllWish.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fÊ\u0001\u0002\b\u0018¨\u0006\u0017"}, d2 = {"Lcom/allwish/AllWish$APIResponseUrl;", "", "status", "", "result", "Lcom/allwish/AllWish$ServerUrl;", "<init>", "(Ljava/lang/Integer;Lcom/allwish/AllWish$ServerUrl;)V", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResult", "()Lcom/allwish/AllWish$ServerUrl;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/allwish/AllWish$ServerUrl;)Lcom/allwish/AllWish$APIResponseUrl;", "equals", "", "other", "hashCode", "toString", "", "AllWish", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class APIResponseUrl {

        @Nullable
        private final ServerUrl result;

        @Nullable
        private final Integer status;

        /* JADX WARN: Multi-variable type inference failed */
        public APIResponseUrl() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ APIResponseUrl copy$default(APIResponseUrl aPIResponseUrl, Integer num, ServerUrl serverUrl, int i, Object obj) {
            if ((i & 1) != 0) {
                num = aPIResponseUrl.status;
            }
            if ((i & 2) != 0) {
                serverUrl = aPIResponseUrl.result;
            }
            return aPIResponseUrl.copy(num, serverUrl);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getStatus() {
            return this.status;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ServerUrl getResult() {
            return this.result;
        }

        @NotNull
        public final APIResponseUrl copy(@Nullable Integer status, @Nullable ServerUrl result) {
            return new APIResponseUrl(status, result);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof APIResponseUrl)) {
                return false;
            }
            APIResponseUrl aPIResponseUrl = (APIResponseUrl) other;
            return Intrinsics.areEqual(this.status, aPIResponseUrl.status) && Intrinsics.areEqual(this.result, aPIResponseUrl.result);
        }

        public int hashCode() {
            return ((this.status == null ? 0 : this.status.hashCode()) * 31) + (this.result != null ? this.result.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "APIResponseUrl(status=" + this.status + ", result=" + this.result + ')';
        }

        public APIResponseUrl(@Nullable Integer status, @Nullable ServerUrl result) {
            this.status = status;
            this.result = result;
        }

        public /* synthetic */ APIResponseUrl(Integer num, ServerUrl serverUrl, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : serverUrl);
        }

        @Nullable
        public final Integer getStatus() {
            return this.status;
        }

        @Nullable
        public final ServerUrl getResult() {
            return this.result;
        }
    }

    /* JADX INFO: compiled from: AllWish.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\u0002\b\u0011¨\u0006\u0010"}, d2 = {"Lcom/allwish/AllWish$ServerUrl;", "", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "AllWish", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ServerUrl {

        @Nullable
        private final String url;

        /* JADX WARN: Illegal instructions before constructor call */
        public ServerUrl() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ ServerUrl copy$default(ServerUrl serverUrl, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = serverUrl.url;
            }
            return serverUrl.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final ServerUrl copy(@Nullable String url) {
            return new ServerUrl(url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ServerUrl) && Intrinsics.areEqual(this.url, ((ServerUrl) other).url);
        }

        public int hashCode() {
            if (this.url == null) {
                return 0;
            }
            return this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "ServerUrl(url=" + this.url + ')';
        }

        public ServerUrl(@Nullable String url) {
            this.url = url;
        }

        public /* synthetic */ ServerUrl(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }
    }

    private final Episode createEpisode(final MetaAnimeData animeMetaData, final int episodeNumber, String epId, boolean isDub, final String htmlTitle) {
        String prefix;
        Map<String, MetaEpisode> episodes;
        final MetaEpisode epData = (animeMetaData == null || (episodes = animeMetaData.getEpisodes()) == null) ? null : episodes.get(String.valueOf(episodeNumber));
        if (isDub) {
            prefix = "dub";
        } else {
            prefix = StringsKt.contains$default(epId, "|HSub", false, 2, (Object) null) ? "hardsub" : "sub";
        }
        return MainAPIKt.newEpisode(this, prefix + '|' + epId, new Function1() { // from class: com.allwish.AllWish$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return AllWish.createEpisode$lambda$0(episodeNumber, this, epData, htmlTitle, animeMetaData, (Episode) obj);
            }
        });
    }

    static final Unit createEpisode$lambda$0(int $episodeNumber, AllWish this$0, MetaEpisode $epData, String $htmlTitle, MetaAnimeData $animeMetaData, Episode $this$newEpisode) {
        String url;
        List<ImageData> images;
        ImageData imageData;
        String overview;
        $this$newEpisode.setEpisode(Integer.valueOf($episodeNumber));
        $this$newEpisode.setName(this$0.resolveTitle($epData, $htmlTitle, $episodeNumber));
        if ($epData == null || (url = $epData.getImage()) == null) {
            url = ($animeMetaData == null || (images = $animeMetaData.getImages()) == null || (imageData = (ImageData) CollectionsKt.firstOrNull(images)) == null) ? null : imageData.getUrl();
            if (url == null) {
                url = "";
            }
        }
        $this$newEpisode.setPosterUrl(url);
        if ($epData == null || (overview = $epData.getOverview()) == null) {
            overview = "No summary available";
        }
        $this$newEpisode.setDescription(overview);
        $this$newEpisode.setScore(Score.Companion.from10($epData != null ? $epData.getRating() : null));
        $this$newEpisode.setRunTime($epData != null ? $epData.getRuntime() : null);
        MainAPIKt.addDate$default($this$newEpisode, $epData != null ? $epData.getAirDateUtc() : null, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    private final String resolveTitle(MetaEpisode epData, String htmlTitle, int episodeNumber) {
        String jsonTitle;
        Map<String, String> title;
        Map<String, String> title2;
        Map<String, String> title3;
        if (epData == null || (title3 = epData.getTitle()) == null || (jsonTitle = title3.get("en")) == null) {
            jsonTitle = null;
            String str = (epData == null || (title2 = epData.getTitle()) == null) ? null : title2.get("ja");
            if (str == null) {
                if (epData != null && (title = epData.getTitle()) != null) {
                    jsonTitle = title.get("x-jat");
                }
                if (jsonTitle == null) {
                    jsonTitle = htmlTitle;
                }
            } else {
                jsonTitle = str;
            }
        }
        String str2 = jsonTitle;
        if (StringsKt.isBlank(str2)) {
            str2 = "Episode " + episodeNumber;
        }
        return str2;
    }

    private final Pair<List<Episode>, List<Episode>> parseEpisodes(APIResponse epRes, MetaAnimeData animeMetaData) {
        Integer status;
        List subEpisodes = new ArrayList();
        List dubEpisodes = new ArrayList();
        if ((epRes == null || (status = epRes.getStatus()) == null || status.intValue() != 200) ? false : true) {
            Iterable $this$forEach$iv = epRes.getHtml().select("div.range > div > a");
            for (Object element$iv : $this$forEach$iv) {
                com.fleeksoft.ksoup.nodes.Element element = (com.fleeksoft.ksoup.nodes.Element) element$iv;
                String epId = element.attr("data-ids");
                String title = element.attr("title");
                Integer intOrNull = StringsKt.toIntOrNull(element.attr("data-slug"));
                int episodeNumber = intOrNull != null ? intOrNull.intValue() : 0;
                boolean hasSub = Intrinsics.areEqual(element.attr("data-sub"), "1");
                boolean hasDub = Intrinsics.areEqual(element.attr("data-dub"), "1");
                if (hasSub) {
                    subEpisodes.add(createEpisode(animeMetaData, episodeNumber, epId, false, title + " (Sub)"));
                }
                if (hasDub) {
                    dubEpisodes.add(createEpisode(animeMetaData, episodeNumber, epId, true, title + " (Dub)"));
                }
            }
        }
        return new Pair<>(subEpisodes, dubEpisodes);
    }
}
