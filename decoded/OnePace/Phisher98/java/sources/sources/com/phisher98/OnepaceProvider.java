package com.phisher98;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
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
import kotlin.ranges.IntRange;
import kotlin.reflect.KType;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: AnimedekhoOnePace.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/OnePace/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001c\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010#J\f\u0010$\u001a\u00020%*\u00020&H\u0002J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u001a2\u0006\u0010(\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)JF\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u000e2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000203012\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020301H\u0096@¢\u0006\u0002\u00106J\f\u00107\u001a\u00020\u0005*\u00020&H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00069"}, d2 = {"Lcom/phisher98/OnepaceProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getsrcAttribute", "Media", "OnePace"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnimedekhoOnePace.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimedekhoOnePace.kt\ncom/phisher98/OnepaceProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,164:1\n1739#2:165\n1814#2,3:166\n1795#2,10:169\n2068#2:179\n2069#2:181\n1805#2:182\n1544#2:183\n1633#2,2:184\n1795#2,10:186\n2068#2:196\n2069#2:198\n1805#2:199\n1635#2,3:200\n1795#2,10:222\n2068#2:232\n2069#2:234\n1805#2:235\n1#3:180\n1#3:197\n1#3:204\n1#3:233\n1#3:237\n63#4:203\n64#4,15:205\n63#4:236\n64#4,15:238\n50#5:220\n43#5:221\n50#5:253\n43#5:254\n*S KotlinDebug\n*F\n+ 1 AnimedekhoOnePace.kt\ncom/phisher98/OnepaceProvider\n*L\n34#1:165\n34#1:166,3\n74#1:169,10\n74#1:179\n74#1:181\n74#1:182\n76#1:183\n76#1:184,2\n79#1:186,10\n79#1:196\n79#1:198\n79#1:199\n76#1:200,3\n110#1:222,10\n110#1:232\n110#1:234\n110#1:235\n74#1:180\n79#1:197\n87#1:204\n110#1:233\n137#1:237\n87#1:203\n87#1:205,15\n137#1:236\n137#1:238,15\n87#1:220\n87#1:221\n137#1:253\n137#1:254\n*E\n"})
public final class OnepaceProvider extends MainAPI {

    @NotNull
    private String mainUrl = "https://onepace.co";

    @NotNull
    private String name = "OnePace AD";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Anime);

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("/series/one-pace-english-sub/", "One Pace English Sub"), TuplesKt.to("/series/one-pace-english-dub/", "One Pace English Dub")});

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$getMainPage$1 */
    /* JADX INFO: compiled from: AnimedekhoOnePace.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.OnepaceProvider", f = "AnimedekhoOnePace.kt", i = {0, 0, 0}, l = {32}, m = "getMainPage", n = {"request", "link", "page"}, nl = {34}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OnepaceProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$load$1 */
    /* JADX INFO: compiled from: AnimedekhoOnePace.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.OnepaceProvider", f = "AnimedekhoOnePace.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {88, 101, 123}, m = "load", n = {"url", "media", "url", "media", "document", "arcINT", "element", "title", "poster", "plot", "year", "lst", "url", "media", "document", "arcINT", "element", "title", "poster", "plot", "year", "lst", "episodes"}, nl = {89, 110, 100}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
    static final class C00061 extends ContinuationImpl {
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
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OnepaceProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$loadLinks$1 */
    /* JADX INFO: compiled from: AnimedekhoOnePace.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.OnepaceProvider", f = "AnimedekhoOnePace.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {138, 140}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "media", "isCasting", "data", "subtitleCallback", "callback", "media", "body", "term", "isCasting"}, nl = {139, 146}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
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
            return OnepaceProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$search$1 */
    /* JADX INFO: compiled from: AnimedekhoOnePace.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.OnepaceProvider", f = "AnimedekhoOnePace.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {72, 77}, m = "search", n = {"query", "query", "document", "links", "$this$flatMap$iv", "$this$flatMapTo$iv$iv", "destination$iv$iv", "element$iv$iv", "link"}, nl = {73, 78}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8"}, v = 2)
    static final class C00111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C00111(Continuation<? super C00111> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OnepaceProvider.this.search(null, (Continuation) this);
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

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00051 c00051;
        MainPageRequest request2;
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
                String link = getMainUrl() + request.getData();
                Requests app = MainActivityKt.getApp();
                c00051.L$0 = request;
                c00051.L$1 = SpillingKt.nullOutSpilledVariable(link);
                c00051.I$0 = page;
                c00051.label = 1;
                $result = Requests.get$default(app, link, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00051, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                int i = c00051.I$0;
                request2 = (MainPageRequest) c00051.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$map$iv = document.select("div.seasons.aa-crd > div.seasons-bx");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it = (Element) item$iv$iv;
            destination$iv$iv.add(toSearchResult(it));
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse$default(request2.getName(), home, (Boolean) null, 4, (Object) null);
    }

    private final AnimeSearchResponse toSearchResult(Element $this$toSearchResult) {
        String strText;
        final boolean dubtype;
        final boolean dubtype2;
        String str;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("img");
        String hreftitle = elementSelectFirst != null ? elementSelectFirst.attr("alt") : null;
        String href = "";
        Intrinsics.checkNotNull(hreftitle);
        if (hreftitle.length() > 0) {
            if (StringsKt.contains$default(hreftitle, "Dub", false, 2, (Object) null)) {
                str = getMainUrl() + "/series/one-pace-english-dub";
            } else {
                str = getMainUrl() + "/series/one-pace-english-sub";
            }
            href = str;
        }
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("p");
        if (elementSelectFirst2 == null || (strText = elementSelectFirst2.text()) == null) {
            strText = "";
        }
        String title = strText;
        Element elementSelectFirst3 = $this$toSearchResult.selectFirst("img");
        final String posterUrl = elementSelectFirst3 != null ? getsrcAttribute(elementSelectFirst3) : null;
        if (StringsKt.contains$default(hreftitle, "Dub", false, 2, (Object) null)) {
            dubtype = true;
            dubtype2 = false;
        } else {
            dubtype = false;
            dubtype2 = true;
        }
        return MainAPIKt.newAnimeSearchResponse(this, title, AppUtils.INSTANCE.toJson(new Media(href, posterUrl, title)), TvType.Anime, false, new Function1() { // from class: com.phisher98.OnepaceProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return OnepaceProvider.toSearchResult$lambda$0(posterUrl, dubtype, dubtype2, (AnimeSearchResponse) obj);
            }
        });
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, boolean $dubtype, boolean $subtype, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($posterUrl);
        MainAPIKt.addDubStatus$default($this$newAnimeSearchResponse, $dubtype, $subtype, (Integer) null, (Integer) null, 12, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x015c  */
    /* JADX WARN: Code duplicated, block: B:30:0x01d4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:35:0x020d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0223  */
    /* JADX WARN: Code duplicated, block: B:44:0x0228 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x01d5 -> B:32:0x01e5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object search(@org.jetbrains.annotations.NotNull java.lang.String r35, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.lagradost.cloudstream3.AnimeSearchResponse>> r36) {
        /*
            Method dump skipped, instruction units count: 600
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.OnepaceProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0316  */
    /* JADX WARN: Code duplicated, block: B:105:0x0322  */
    /* JADX WARN: Code duplicated, block: B:107:0x032c  */
    /* JADX WARN: Code duplicated, block: B:108:0x0333  */
    /* JADX WARN: Code duplicated, block: B:110:0x033f  */
    /* JADX WARN: Code duplicated, block: B:111:0x0344  */
    /* JADX WARN: Code duplicated, block: B:113:0x0386  */
    /* JADX WARN: Code duplicated, block: B:116:0x0391  */
    /* JADX WARN: Code duplicated, block: B:120:0x040f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:121:0x0410  */
    /* JADX WARN: Code duplicated, block: B:132:0x0395 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:52:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:59:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:61:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:62:0x0200  */
    /* JADX WARN: Code duplicated, block: B:70:0x0220  */
    /* JADX WARN: Code duplicated, block: B:72:0x0228  */
    /* JADX WARN: Code duplicated, block: B:75:0x0235  */
    /* JADX WARN: Code duplicated, block: B:78:0x023a  */
    /* JADX WARN: Code duplicated, block: B:79:0x023f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x0245  */
    /* JADX WARN: Code duplicated, block: B:83:0x024a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0259  */
    /* JADX WARN: Code duplicated, block: B:92:0x02c7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:93:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:95:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:98:0x02f6  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00061 c00061;
        Object obj;
        Object objDecodeFromString;
        Object obj2;
        int i;
        String url2;
        Media media;
        Document document;
        String mediaType;
        String strReplace$default;
        String arcINT;
        Element element;
        String mediaType2;
        String title;
        Element elementSelectFirst;
        Element elementSelectFirst2;
        String strAttr;
        String plot;
        Element elementSelectFirst3;
        Element elementSelectFirst4;
        String strSubstringBefore$default;
        String strAttr2;
        Integer intOrNull;
        Integer year;
        Elements elementsSelect;
        Elements lst;
        boolean z;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Collection destination$iv$iv;
        Iterable $this$mapNotNullTo$iv$iv;
        Element element2;
        String poster;
        String title2;
        String plot2;
        Elements lst2;
        Element element3;
        String plot3;
        Integer year2;
        Element it;
        Element elementSelectFirst5;
        final String name;
        Element elementSelectFirst6;
        String url3;
        Episode episodeNewEpisode;
        String href;
        Element elementSelectFirst7;
        String strText;
        String strText2;
        String strText3;
        String strSubstringAfter$default;
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
        C00061 c00062 = c00061;
        Object $result = c00062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00062.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(Media.class);
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
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Media.class), (List) null, 2, (Object) null));
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
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, url);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(url, new TypeReference<Media>() { // from class: com.phisher98.OnepaceProvider$load$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(url, new TypeReference<Media>() { // from class: com.phisher98.OnepaceProvider$load$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(url, new TypeReference<Media>() { // from class: com.phisher98.OnepaceProvider$load$$inlined$parseJson$1
                    });
                }
                Media media2 = (Media) objDecodeFromString;
                Requests app = MainActivityKt.getApp();
                String url4 = media2.getUrl();
                c00062.L$0 = url;
                c00062.L$1 = media2;
                c00062.label = 1;
                obj2 = coroutine_suspended;
                i = 2;
                $result = Requests.get$default(app, url4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4094, (Object) null);
                c00062 = c00062;
                if ($result == obj2) {
                    return obj2;
                }
                url2 = url;
                media = media2;
                document = ((NiceResponse) $result).getDocument();
                mediaType = media.getMediaType();
                if (mediaType != null || (strSubstringAfter$default = StringsKt.substringAfter$default(mediaType, "Arc ", (String) null, i, (Object) null)) == null || (strReplace$default = StringsKt.replace$default(strSubstringAfter$default, "'", "\\'", false, 4, (Object) null)) == null) {
                    strReplace$default = "";
                }
                arcINT = strReplace$default;
                element = document.selectFirst("div.seasons.aa-crd > div.seasons-bx:contains(" + arcINT + ')');
                mediaType2 = media.getMediaType();
                if (mediaType2 == null) {
                    mediaType2 = "No Title";
                }
                title = mediaType2;
                elementSelectFirst = document.selectFirst("div.entry-content p");
                if (elementSelectFirst != null || (strText3 = elementSelectFirst.text()) == null || (strAttr = StringsKt.trim(strText3).toString()) == null) {
                    elementSelectFirst2 = document.selectFirst("meta[name=twitter:description]");
                    if (elementSelectFirst2 != null) {
                        strAttr = elementSelectFirst2.attr("content");
                    } else {
                        strAttr = null;
                    }
                }
                plot = strAttr;
                elementSelectFirst3 = document.selectFirst("span.year");
                if (elementSelectFirst3 != null || (strText2 = elementSelectFirst3.text()) == null || (strSubstringBefore$default = StringsKt.trim(strText2).toString()) == null) {
                    elementSelectFirst4 = document.selectFirst("meta[property=og:updated_time]");
                    if (elementSelectFirst4 != null || (strAttr2 = elementSelectFirst4.attr("content")) == null) {
                        strSubstringBefore$default = null;
                    } else {
                        strSubstringBefore$default = StringsKt.substringBefore$default(strAttr2, "-", (String) null, i, (Object) null);
                    }
                }
                if (strSubstringBefore$default != null) {
                    intOrNull = StringsKt.toIntOrNull(strSubstringBefore$default);
                } else {
                    intOrNull = null;
                }
                year = intOrNull;
                if (element != null) {
                    elementsSelect = element.select("ul.seasons-lst.anm-a li");
                } else {
                    elementsSelect = null;
                }
                lst = elementsSelect;
                z = false;
                if (lst != null && !lst.isEmpty()) {
                    z = true;
                }
                if (!z) {
                    TvType tvType = TvType.Movie;
                    String json = AppUtils.INSTANCE.toJson(new Media(media.getUrl(), null, "1", 2, null));
                    C00072 c00072 = new C00072("https://images3.alphacoders.com/134/1342304.jpeg", plot, year, null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(media);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(document);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(arcINT);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(element);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(title);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable("https://images3.alphacoders.com/134/1342304.jpeg");
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(plot);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(year);
                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(lst);
                    c00062.label = 2;
                    $result = MainAPIKt.newMovieLoadResponse(this, title, url2, tvType, json, c00072, c00062);
                    if ($result == obj2) {
                        return obj2;
                    }
                    return (LoadResponse) $result;
                }
                $this$mapNotNull$iv = element.select("ul.seasons-lst.anm-a li");
                $i$f$mapNotNull = 0;
                destination$iv$iv = new ArrayList();
                $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                for (Object element$iv$iv$iv : $this$mapNotNullTo$iv$iv) {
                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    it = (Element) element$iv$iv$iv;
                    int $i$f$mapNotNull2 = $i$f$mapNotNull;
                    elementSelectFirst5 = it.selectFirst("h3.title");
                    if (elementSelectFirst5 != null || (name = elementSelectFirst5.ownText()) == null) {
                        name = "null";
                    }
                    String title3 = title;
                    elementSelectFirst6 = it.selectFirst("a");
                    if (elementSelectFirst6 != null) {
                        url3 = url2;
                        href = elementSelectFirst6.attr("href");
                        if (href == null) {
                            final String poster2 = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/Icons/OnePack.png";
                            elementSelectFirst7 = it.selectFirst("h3.title > span");
                            if (elementSelectFirst7 != null) {
                                strText = elementSelectFirst7.text();
                            } else {
                                strText = null;
                            }
                            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                            element = element;
                            String seasonnumber = StringsKt.substringBefore$default(StringsKt.substringAfter$default(String.valueOf(strText), "S", (String) null, 2, (Object) null), "-", (String) null, 2, (Object) null);
                            final Integer season = StringsKt.toIntOrNull(seasonnumber);
                            String seasonnumber2 = AppUtils.INSTANCE.toJson(new Media(href, null, "2", 2, null));
                            episodeNewEpisode = MainAPIKt.newEpisode(this, seasonnumber2, new Function1() { // from class: com.phisher98.OnepaceProvider$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj3) {
                                    return OnepaceProvider.load$lambda$0$0(name, poster2, season, (Episode) obj3);
                                }
                            });
                        }
                        if (episodeNewEpisode != null) {
                            destination$iv$iv.add(episodeNewEpisode);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        element = element;
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        title = title3;
                        url2 = url3;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                    } else {
                        url3 = url2;
                    }
                    episodeNewEpisode = null;
                    if (episodeNewEpisode != null) {
                        destination$iv$iv.add(episodeNewEpisode);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    element = element;
                    $i$f$mapNotNull = $i$f$mapNotNull2;
                    title = title3;
                    url2 = url3;
                    $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                }
                element2 = element;
                List episodes = (List) destination$iv$iv;
                TvType tvType2 = TvType.TvSeries;
                C00083 c00083 = new C00083("https://images3.alphacoders.com/134/1342304.jpeg", plot, year, null);
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(media);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(document);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(arcINT);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(element2);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(title);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable("https://images3.alphacoders.com/134/1342304.jpeg");
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(plot);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(year);
                c00062.L$9 = SpillingKt.nullOutSpilledVariable(lst);
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(episodes);
                c00062.label = 3;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title, url2, tvType2, episodes, c00083, c00062);
                if ($result == obj2) {
                    return obj2;
                }
                poster = "https://images3.alphacoders.com/134/1342304.jpeg";
                title2 = title;
                plot2 = plot;
                lst2 = lst;
                element3 = element2;
                plot3 = url2;
                year2 = year;
                return (LoadResponse) $result;
            case 1:
                Media media3 = (Media) c00062.L$1;
                String url5 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = coroutine_suspended;
                url2 = url5;
                i = 2;
                media = media3;
                document = ((NiceResponse) $result).getDocument();
                mediaType = media.getMediaType();
                if (mediaType != null) {
                    strReplace$default = "";
                } else {
                    strReplace$default = "";
                }
                arcINT = strReplace$default;
                element = document.selectFirst("div.seasons.aa-crd > div.seasons-bx:contains(" + arcINT + ')');
                mediaType2 = media.getMediaType();
                if (mediaType2 == null) {
                    mediaType2 = "No Title";
                }
                title = mediaType2;
                elementSelectFirst = document.selectFirst("div.entry-content p");
                if (elementSelectFirst != null) {
                    elementSelectFirst2 = document.selectFirst("meta[name=twitter:description]");
                    if (elementSelectFirst2 != null) {
                        strAttr = elementSelectFirst2.attr("content");
                    } else {
                        strAttr = null;
                    }
                } else {
                    elementSelectFirst2 = document.selectFirst("meta[name=twitter:description]");
                    if (elementSelectFirst2 != null) {
                        strAttr = elementSelectFirst2.attr("content");
                    } else {
                        strAttr = null;
                    }
                }
                plot = strAttr;
                elementSelectFirst3 = document.selectFirst("span.year");
                if (elementSelectFirst3 != null) {
                    elementSelectFirst4 = document.selectFirst("meta[property=og:updated_time]");
                    if (elementSelectFirst4 != null) {
                        strSubstringBefore$default = null;
                    } else {
                        strSubstringBefore$default = null;
                    }
                } else {
                    elementSelectFirst4 = document.selectFirst("meta[property=og:updated_time]");
                    if (elementSelectFirst4 != null) {
                        strSubstringBefore$default = null;
                    } else {
                        strSubstringBefore$default = null;
                    }
                }
                if (strSubstringBefore$default != null) {
                    intOrNull = StringsKt.toIntOrNull(strSubstringBefore$default);
                } else {
                    intOrNull = null;
                }
                year = intOrNull;
                if (element != null) {
                    elementsSelect = element.select("ul.seasons-lst.anm-a li");
                } else {
                    elementsSelect = null;
                }
                lst = elementsSelect;
                z = false;
                if (lst != null) {
                    z = true;
                }
                if (!z) {
                    TvType tvType3 = TvType.Movie;
                    String json2 = AppUtils.INSTANCE.toJson(new Media(media.getUrl(), null, "1", 2, null));
                    C00072 c00073 = new C00072("https://images3.alphacoders.com/134/1342304.jpeg", plot, year, null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(media);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(document);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(arcINT);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(element);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(title);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable("https://images3.alphacoders.com/134/1342304.jpeg");
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(plot);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(year);
                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(lst);
                    c00062.label = 2;
                    $result = MainAPIKt.newMovieLoadResponse(this, title, url2, tvType3, json2, c00073, c00062);
                    if ($result == obj2) {
                        return obj2;
                    }
                    return (LoadResponse) $result;
                }
                $this$mapNotNull$iv = element.select("ul.seasons-lst.anm-a li");
                $i$f$mapNotNull = 0;
                destination$iv$iv = new ArrayList();
                $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                while (r23.hasNext()) {
                    Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                    it = (Element) element$iv$iv$iv;
                    int $i$f$mapNotNull3 = $i$f$mapNotNull;
                    elementSelectFirst5 = it.selectFirst("h3.title");
                    if (elementSelectFirst5 != null) {
                        name = "null";
                    } else {
                        name = "null";
                    }
                    String title4 = title;
                    elementSelectFirst6 = it.selectFirst("a");
                    if (elementSelectFirst6 != null) {
                        url3 = url2;
                        href = elementSelectFirst6.attr("href");
                        if (href == null) {
                            final String poster3 = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/Icons/OnePack.png";
                            elementSelectFirst7 = it.selectFirst("h3.title > span");
                            if (elementSelectFirst7 != null) {
                                strText = elementSelectFirst7.text();
                            } else {
                                strText = null;
                            }
                            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                            element = element;
                            String seasonnumber3 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(String.valueOf(strText), "S", (String) null, 2, (Object) null), "-", (String) null, 2, (Object) null);
                            final Integer season2 = StringsKt.toIntOrNull(seasonnumber3);
                            String seasonnumber4 = AppUtils.INSTANCE.toJson(new Media(href, null, "2", 2, null));
                            episodeNewEpisode = MainAPIKt.newEpisode(this, seasonnumber4, new Function1() { // from class: com.phisher98.OnepaceProvider$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj3) {
                                    return OnepaceProvider.load$lambda$0$0(name, poster3, season2, (Episode) obj3);
                                }
                            });
                        }
                        if (episodeNewEpisode != null) {
                            destination$iv$iv.add(episodeNewEpisode);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv3;
                        element = element;
                        $i$f$mapNotNull = $i$f$mapNotNull3;
                        title = title4;
                        url2 = url3;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                    } else {
                        url3 = url2;
                    }
                    episodeNewEpisode = null;
                    if (episodeNewEpisode != null) {
                        destination$iv$iv.add(episodeNewEpisode);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                    element = element;
                    $i$f$mapNotNull = $i$f$mapNotNull3;
                    title = title4;
                    url2 = url3;
                    $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                }
                element2 = element;
                List episodes2 = (List) destination$iv$iv;
                TvType tvType4 = TvType.TvSeries;
                C00083 c00084 = new C00083("https://images3.alphacoders.com/134/1342304.jpeg", plot, year, null);
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(media);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(document);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(arcINT);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(element2);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(title);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable("https://images3.alphacoders.com/134/1342304.jpeg");
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(plot);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(year);
                c00062.L$9 = SpillingKt.nullOutSpilledVariable(lst);
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00062.label = 3;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title, url2, tvType4, episodes2, c00084, c00062);
                if ($result == obj2) {
                    return obj2;
                }
                poster = "https://images3.alphacoders.com/134/1342304.jpeg";
                title2 = title;
                plot2 = plot;
                lst2 = lst;
                element3 = element2;
                plot3 = url2;
                year2 = year;
                return (LoadResponse) $result;
            case 2:
                ResultKt.throwOnFailure($result);
                return (LoadResponse) $result;
            case 3:
                lst2 = (Elements) c00062.L$9;
                year2 = (Integer) c00062.L$8;
                plot2 = (String) c00062.L$7;
                poster = (String) c00062.L$6;
                title2 = (String) c00062.L$5;
                element3 = (Element) c00062.L$4;
                arcINT = (String) c00062.L$3;
                document = (Document) c00062.L$2;
                media = (Media) c00062.L$1;
                plot3 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                return (LoadResponse) $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$load$2 */
    /* JADX INFO: compiled from: AnimedekhoOnePace.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.OnepaceProvider$load$2", f = "AnimedekhoOnePace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00072 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $plot;
        final /* synthetic */ String $poster;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00072(String str, String str2, Integer num, Continuation<? super C00072> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$plot = str2;
            this.$year = num;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00072 = new C00072(this.$poster, this.$plot, this.$year, continuation);
            c00072.L$0 = obj;
            return c00072;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newMovieLoadResponse.setPosterUrl(this.$poster);
                    $this$newMovieLoadResponse.setPlot(this.$plot);
                    $this$newMovieLoadResponse.setYear(this.$year);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$0$0(String $name, String $poster, Integer $season, Episode $this$newEpisode) {
        $this$newEpisode.setName($name);
        $this$newEpisode.setPosterUrl($poster);
        $this$newEpisode.setSeason($season);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$load$3 */
    /* JADX INFO: compiled from: AnimedekhoOnePace.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.OnepaceProvider$load$3", f = "AnimedekhoOnePace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00083 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $plot;
        final /* synthetic */ String $poster;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00083(String str, String str2, Integer num, Continuation<? super C00083> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$plot = str2;
            this.$year = num;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00083 = new C00083(this.$poster, this.$plot, this.$year, continuation);
            c00083.L$0 = obj;
            return c00083;
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
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$poster);
                    $this$newTvSeriesLoadResponse.setPlot(this.$plot);
                    $this$newTvSeriesLoadResponse.setYear(this.$year);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) throws ErrorLoadingException {
        C00091 c00091;
        Object obj;
        Object objDecodeFromString;
        Object obj2;
        Object obj3;
        int i;
        C00091 c00092;
        String data2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Media media;
        boolean isCasting2;
        Element elementSelectFirst;
        String body;
        List groupValues;
        boolean z;
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
        C00091 c00093 = c00091;
        Object $result = c00093.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00093.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(Media.class);
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
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Media.class), (List) null, 2, (Object) null));
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
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<Media>() { // from class: com.phisher98.OnepaceProvider$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<Media>() { // from class: com.phisher98.OnepaceProvider$loadLinks$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<Media>() { // from class: com.phisher98.OnepaceProvider$loadLinks$$inlined$parseJson$1
                    });
                }
                Media media2 = (Media) objDecodeFromString;
                Requests app = MainActivityKt.getApp();
                String url = media2.getUrl();
                c00093.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00093.L$1 = function1;
                c00093.L$2 = function2;
                c00093.L$3 = media2;
                c00093.Z$0 = isCasting;
                c00093.label = 1;
                obj2 = coroutine_suspended;
                obj3 = null;
                i = 2;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00093, 4094, (Object) null);
                c00092 = c00093;
                if ($result == obj2) {
                    return obj2;
                }
                data2 = data;
                function3 = function1;
                function4 = function2;
                media = media2;
                isCasting2 = isCasting;
                elementSelectFirst = ((NiceResponse) $result).getDocument().selectFirst("body");
                if (elementSelectFirst != null || (body = elementSelectFirst.attr("class")) == null) {
                    return Boxing.boxBoolean(false);
                }
                MatchResult matchResultFind$default = Regex.find$default(new Regex("(?:term|postid)-(\\d+)"), body, 0, i, obj3);
                if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                    z = true;
                    String term = (String) groupValues.get(1);
                    if (term != null) {
                        List list = CollectionsKt.toList(new IntRange(0, 7));
                        Object obj4 = obj2;
                        C00102 c00102 = new C00102(term, media, function3, function4, null);
                        c00092.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00092.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                        c00092.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                        c00092.L$3 = SpillingKt.nullOutSpilledVariable(media);
                        c00092.L$4 = SpillingKt.nullOutSpilledVariable(body);
                        c00092.L$5 = SpillingKt.nullOutSpilledVariable(term);
                        c00092.Z$0 = isCasting2;
                        c00092.label = i;
                        return ParCollectionsKt.amap(list, c00102, c00092) == obj4 ? obj4 : Boxing.boxBoolean(z);
                    }
                }
                throw new ErrorLoadingException("no id found");
            case 1:
                isCasting2 = c00093.Z$0;
                Media media3 = (Media) c00093.L$3;
                Function1<? super ExtractorLink, Unit> function5 = (Function1) c00093.L$2;
                Function1<? super SubtitleFile, Unit> function6 = (Function1) c00093.L$1;
                data2 = (String) c00093.L$0;
                ResultKt.throwOnFailure($result);
                c00092 = c00093;
                obj2 = coroutine_suspended;
                media = media3;
                obj3 = null;
                function4 = function5;
                function3 = function6;
                i = 2;
                elementSelectFirst = ((NiceResponse) $result).getDocument().selectFirst("body");
                if (elementSelectFirst != null) {
                    break;
                }
                return Boxing.boxBoolean(false);
            case 2:
                boolean z2 = c00093.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$loadLinks$2 */
    /* JADX INFO: compiled from: AnimedekhoOnePace.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "i", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.OnepaceProvider$loadLinks$2", f = "AnimedekhoOnePace.kt", i = {0, 1, 1}, l = {141, 144}, m = "invokeSuspend", n = {"i", "link", "i"}, nl = {142, 145}, s = {"I$0", "L$0", "I$0"}, v = 2)
    static final class C00102 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Media $media;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ String $term;
        /* synthetic */ int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00102(String str, Media media, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00102> continuation) {
            super(2, continuation);
            this.$term = str;
            this.$media = media;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00102 = OnepaceProvider.this.new C00102(this.$term, this.$media, this.$subtitleCallback, this.$callback, continuation);
            c00102.I$0 = ((Number) obj).intValue();
            return c00102;
        }

        public final Object invoke(int i, Continuation<? super Unit> continuation) {
            return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).intValue(), (Continuation<? super Unit>) obj2);
        }

        public final Object invokeSuspend(Object $result) {
            Object obj;
            Element elementSelectFirst;
            String link;
            int i = this.I$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.I$0 = i;
                    this.label = 1;
                    obj = Requests.get$default(MainActivityKt.getApp(), OnepaceProvider.this.getMainUrl() + "/?trdekho=" + i + "&trid=" + this.$term + "&trtype=" + this.$media.getMediaType(), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    elementSelectFirst = ((NiceResponse) obj).getDocument().selectFirst("iframe");
                    if (elementSelectFirst != null || (link = elementSelectFirst.attr("src")) == null) {
                        return Unit.INSTANCE;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(link);
                    this.I$0 = i;
                    this.label = 2;
                    if (ExtractorApiKt.loadExtractor(link, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    elementSelectFirst = ((NiceResponse) obj).getDocument().selectFirst("iframe");
                    if (elementSelectFirst != null) {
                        break;
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: AnimedekhoOnePace.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/OnepaceProvider$Media;", "", "url", "", "poster", "mediaType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getPoster", "getMediaType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "OnePace"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Media {

        @Nullable
        private final String mediaType;

        @Nullable
        private final String poster;

        @NotNull
        private final String url;

        public static /* synthetic */ Media copy$default(Media media, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = media.url;
            }
            if ((i & 2) != 0) {
                str2 = media.poster;
            }
            if ((i & 4) != 0) {
                str3 = media.mediaType;
            }
            return media.copy(str, str2, str3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMediaType() {
            return this.mediaType;
        }

        @NotNull
        public final Media copy(@NotNull String url, @Nullable String poster, @Nullable String mediaType) {
            return new Media(url, poster, mediaType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Media)) {
                return false;
            }
            Media media = (Media) other;
            return Intrinsics.areEqual(this.url, media.url) && Intrinsics.areEqual(this.poster, media.poster) && Intrinsics.areEqual(this.mediaType, media.mediaType);
        }

        public int hashCode() {
            return (((this.url.hashCode() * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.mediaType != null ? this.mediaType.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Media(url=" + this.url + ", poster=" + this.poster + ", mediaType=" + this.mediaType + ')';
        }

        public Media(@NotNull String url, @Nullable String poster, @Nullable String mediaType) {
            this.url = url;
            this.poster = poster;
            this.mediaType = mediaType;
        }

        public /* synthetic */ Media(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getMediaType() {
            return this.mediaType;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }
    }

    private final String getsrcAttribute(Element $this$getsrcAttribute) {
        String src = $this$getsrcAttribute.attr("src");
        String dataSrc = $this$getsrcAttribute.attr("data-src");
        String lazysrc = $this$getsrcAttribute.attr("data-lazy-src");
        if (StringsKt.startsWith$default(src, "http", false, 2, (Object) null)) {
            return src;
        }
        if (StringsKt.startsWith$default(dataSrc, "http", false, 2, (Object) null)) {
            return dataSrc;
        }
        return StringsKt.startsWith$default(lazysrc, "http", false, 2, (Object) null) ? lazysrc : "";
    }
}
