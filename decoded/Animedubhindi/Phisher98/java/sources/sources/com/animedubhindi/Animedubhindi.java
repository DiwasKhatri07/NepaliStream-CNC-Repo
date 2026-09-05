package com.animedubhindi;

import android.util.Log;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
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
import com.lagradost.cloudstream3.SearchResponseList;
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
import java.util.LinkedHashMap;
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
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
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

/* JADX INFO: compiled from: Animedubhindi.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Animedubhindi/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010)J\f\u0010*\u001a\u00020+*\u00020,H\u0002J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00100JF\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000e2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020705H\u0096@¢\u0006\u0002\u0010:R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006;"}, d2 = {"Lcom/animedubhindi/Animedubhindi;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Animedubhindi"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnimedubhindi.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animedubhindi.kt\ncom/animedubhindi/Animedubhindi\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,213:1\n1795#2,10:214\n2068#2:224\n2069#2:226\n1805#2:227\n1795#2,10:228\n2068#2:238\n2069#2:240\n1805#2:241\n1358#2,2:242\n1435#2,4:244\n1739#2:248\n1814#2,3:249\n1739#2:252\n1814#2,3:253\n777#2:256\n873#2,2:257\n1795#2,10:259\n2068#2:269\n1795#2,10:270\n2068#2:280\n2069#2:283\n1805#2:284\n2069#2:286\n1805#2:287\n1795#2,10:288\n2068#2:298\n1795#2,10:299\n2068#2:309\n2069#2:311\n1805#2:312\n2069#2:314\n1805#2:315\n1544#2:316\n1633#2,2:317\n1795#2,10:319\n2068#2:329\n2069#2:331\n1805#2:332\n1635#2,3:333\n1544#2:336\n1633#2,2:337\n1795#2,10:339\n2068#2:349\n2069#2:351\n1805#2:352\n1635#2,3:353\n1#3:225\n1#3:239\n1#3:281\n1#3:282\n1#3:285\n1#3:310\n1#3:313\n1#3:330\n1#3:350\n1#3:359\n1#3:379\n93#4,2:356\n63#4:358\n64#4,15:360\n95#4,2:377\n50#5:375\n43#5:376\n*S KotlinDebug\n*F\n+ 1 Animedubhindi.kt\ncom/animedubhindi/Animedubhindi\n*L\n31#1:214,10\n31#1:224\n31#1:226\n31#1:227\n45#1:228,10\n45#1:238\n45#1:240\n45#1:241\n61#1:242,2\n61#1:244,4\n68#1:248\n68#1:249,3\n74#1:252\n74#1:253,3\n85#1:256\n85#1:257,2\n89#1:259,10\n89#1:269\n97#1:270,10\n97#1:280\n97#1:283\n97#1:284\n89#1:286\n89#1:287\n118#1:288,10\n118#1:298\n125#1:299,10\n125#1:309\n125#1:311\n125#1:312\n118#1:314\n118#1:315\n156#1:316\n156#1:317,2\n159#1:319,10\n159#1:329\n159#1:331\n159#1:332\n156#1:333,3\n168#1:336\n168#1:337,2\n174#1:339,10\n174#1:349\n174#1:351\n174#1:352\n168#1:353,3\n31#1:225\n45#1:239\n97#1:282\n89#1:285\n125#1:310\n118#1:313\n159#1:330\n174#1:350\n203#1:359\n203#1:356,2\n203#1:358\n203#1:360,15\n203#1:377,2\n203#1:375\n203#1:376\n*E\n"})
public final class Animedubhindi extends MainAPI {

    @NotNull
    private String mainUrl = "https://www.animedubhindi.cc";

    @NotNull
    private String name = "AnimeDubHindi";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime, TvType.Cartoon});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("", "Home"), TuplesKt.to("category/movie", "Movies"), TuplesKt.to("category/series", "Series"), TuplesKt.to("category/genres/action", "Action"), TuplesKt.to("category/drama", "Drama"), TuplesKt.to("category/romance", "Romance"), TuplesKt.to("category/thriller", "Thriller")});

    /* JADX INFO: renamed from: com.animedubhindi.Animedubhindi$getMainPage$1 */
    /* JADX INFO: compiled from: Animedubhindi.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animedubhindi.Animedubhindi", f = "Animedubhindi.kt", i = {0, 0}, l = {30}, m = "getMainPage", n = {"request", "page"}, nl = {31}, s = {"L$0", "I$0"}, v = 2)
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
            return Animedubhindi.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.animedubhindi.Animedubhindi$load$1 */
    /* JADX INFO: compiled from: Animedubhindi.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animedubhindi.Animedubhindi", f = "Animedubhindi.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {60, 79, 144, 153, 186}, m = "load", n = {"url", "url", "doc", "infoMap", "iframe", "audio", "rawtitle", "title", "description", "backgroundposter", "rating", "genres", "contentRating", "tvtag", "url", "doc", "infoMap", "iframe", "audio", "rawtitle", "title", "description", "backgroundposter", "rating", "genres", "contentRating", "tvtag", "document", "episodes", "url", "doc", "infoMap", "iframe", "audio", "rawtitle", "title", "description", "backgroundposter", "rating", "genres", "contentRating", "tvtag", "url", "doc", "infoMap", "iframe", "audio", "rawtitle", "title", "description", "backgroundposter", "rating", "genres", "contentRating", "tvtag", "doc", "hrefs"}, nl = {61, 81, 153, 154, 78}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14"}, v = 2)
    static final class C00011 extends ContinuationImpl {
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
            return Animedubhindi.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.animedubhindi.Animedubhindi$loadLinks$1 */
    /* JADX INFO: compiled from: Animedubhindi.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animedubhindi.Animedubhindi", f = "Animedubhindi.kt", i = {0, 0, 0, 0, 0}, l = {204}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "links", "isCasting"}, nl = {209}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Animedubhindi.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.animedubhindi.Animedubhindi$search$1 */
    /* JADX INFO: compiled from: Animedubhindi.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animedubhindi.Animedubhindi", f = "Animedubhindi.kt", i = {0, 0}, l = {44}, m = "search", n = {"query", "page"}, nl = {45}, s = {"L$0", "I$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        int I$0;
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
            return Animedubhindi.this.search(null, 0, (Continuation) this);
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

    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
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
        C00001 c00001;
        MainPageRequest request2;
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
                String str = getMainUrl() + '/' + request.getData();
                c00001.L$0 = request;
                c00001.I$0 = page;
                c00001.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                int i = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("article");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, true), Boxing.boxBoolean(true));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00061 c00061;
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
        Object $result = c00061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00061.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/?s=" + query;
                c00061.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00061.I$0 = page;
                c00061.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00061.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("article");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List results = (List) destination$iv$iv;
        return MainAPIKt.toNewSearchResponseList$default(results, (Boolean) null, 1, (Object) null);
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String title = StringsKt.substringBeforeLast$default($this$toSearchResult.select("h2 a").text(), "(", (String) null, 2, (Object) null);
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("h2 a").attr("href"));
        final String posterUrl = MainAPIKt.fixUrlNull(this, $this$toSearchResult.select("img").attr("src"));
        return MainAPIKt.newMovieSearchResponse$default(this, APIHolder.INSTANCE.capitalize(title), href, TvType.Movie, false, new Function1() { // from class: com.animedubhindi.Animedubhindi$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return Animedubhindi.toSearchResult$lambda$0(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0543  */
    /* JADX WARN: Code duplicated, block: B:105:0x0591  */
    /* JADX WARN: Code duplicated, block: B:108:0x05b4  */
    /* JADX WARN: Code duplicated, block: B:110:0x05b8  */
    /* JADX WARN: Code duplicated, block: B:111:0x05c7  */
    /* JADX WARN: Code duplicated, block: B:113:0x05e4  */
    /* JADX WARN: Code duplicated, block: B:116:0x05f8  */
    /* JADX WARN: Code duplicated, block: B:118:0x0606  */
    /* JADX WARN: Code duplicated, block: B:121:0x0625  */
    /* JADX WARN: Code duplicated, block: B:122:0x062c  */
    /* JADX WARN: Code duplicated, block: B:126:0x065c  */
    /* JADX WARN: Code duplicated, block: B:127:0x065e  */
    /* JADX WARN: Code duplicated, block: B:129:0x0676  */
    /* JADX WARN: Code duplicated, block: B:134:0x06cb  */
    /* JADX WARN: Code duplicated, block: B:136:0x06e5  */
    /* JADX WARN: Code duplicated, block: B:137:0x06ea  */
    /* JADX WARN: Code duplicated, block: B:139:0x06ed  */
    /* JADX WARN: Code duplicated, block: B:143:0x072e  */
    /* JADX WARN: Code duplicated, block: B:146:0x0751  */
    /* JADX WARN: Code duplicated, block: B:148:0x0755  */
    /* JADX WARN: Code duplicated, block: B:149:0x0761  */
    /* JADX WARN: Code duplicated, block: B:151:0x077e  */
    /* JADX WARN: Code duplicated, block: B:154:0x0790  */
    /* JADX WARN: Code duplicated, block: B:156:0x079e  */
    /* JADX WARN: Code duplicated, block: B:159:0x07bb  */
    /* JADX WARN: Code duplicated, block: B:160:0x07c2  */
    /* JADX WARN: Code duplicated, block: B:164:0x07ec  */
    /* JADX WARN: Code duplicated, block: B:165:0x07ee  */
    /* JADX WARN: Code duplicated, block: B:167:0x0804  */
    /* JADX WARN: Code duplicated, block: B:171:0x08b3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:172:0x08b4  */
    /* JADX WARN: Code duplicated, block: B:174:0x08cf  */
    /* JADX WARN: Code duplicated, block: B:176:0x096c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:177:0x096d  */
    /* JADX WARN: Code duplicated, block: B:181:0x09a7  */
    /* JADX WARN: Code duplicated, block: B:184:0x09ef  */
    /* JADX WARN: Code duplicated, block: B:186:0x0a22  */
    /* JADX WARN: Code duplicated, block: B:190:0x0a33  */
    /* JADX WARN: Code duplicated, block: B:193:0x0a37  */
    /* JADX WARN: Code duplicated, block: B:195:0x0a3b  */
    /* JADX WARN: Code duplicated, block: B:196:0x0a41  */
    /* JADX WARN: Code duplicated, block: B:198:0x0a85  */
    /* JADX WARN: Code duplicated, block: B:204:0x0af6  */
    /* JADX WARN: Code duplicated, block: B:206:0x0b0d  */
    /* JADX WARN: Code duplicated, block: B:210:0x0b2e A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:213:0x0b35  */
    /* JADX WARN: Code duplicated, block: B:217:0x0b5d  */
    /* JADX WARN: Code duplicated, block: B:219:0x0b90  */
    /* JADX WARN: Code duplicated, block: B:223:0x0ba1  */
    /* JADX WARN: Code duplicated, block: B:226:0x0ba5  */
    /* JADX WARN: Code duplicated, block: B:228:0x0ba9  */
    /* JADX WARN: Code duplicated, block: B:229:0x0bb1  */
    /* JADX WARN: Code duplicated, block: B:231:0x0bf3  */
    /* JADX WARN: Code duplicated, block: B:232:0x0bfa  */
    /* JADX WARN: Code duplicated, block: B:237:0x0cd1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:238:0x0cd2  */
    /* JADX WARN: Code duplicated, block: B:241:0x0ac4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:244:0x0a89 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:249:0x04fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x023a  */
    /* JADX WARN: Code duplicated, block: B:251:0x04f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:252:0x0690 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:254:0x067a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:260:0x0808 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:266:0x026d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0268  */
    /* JADX WARN: Code duplicated, block: B:33:0x026b  */
    /* JADX WARN: Code duplicated, block: B:44:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:50:0x033a  */
    /* JADX WARN: Code duplicated, block: B:57:0x0370  */
    /* JADX WARN: Code duplicated, block: B:59:0x037a  */
    /* JADX WARN: Code duplicated, block: B:60:0x0381  */
    /* JADX WARN: Code duplicated, block: B:70:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:73:0x0401  */
    /* JADX WARN: Code duplicated, block: B:74:0x0404  */
    /* JADX WARN: Code duplicated, block: B:77:0x040a  */
    /* JADX WARN: Code duplicated, block: B:79:0x048c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x048d  */
    /* JADX WARN: Code duplicated, block: B:84:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:86:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:89:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:91:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:96:0x0524  */
    /* JADX WARN: Code duplicated, block: B:98:0x053a  */
    /* JADX WARN: Code duplicated, block: B:99:0x053f  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        String str;
        String iframe;
        String rating;
        String str2;
        String str3;
        Object obj2;
        String url2;
        Document doc;
        Map destination$iv$iv;
        String iframe2;
        String str4;
        String iframe3;
        List audio;
        String rawtitle;
        String title;
        Element elementSelectFirst;
        String string;
        String description;
        String backgroundposter;
        String str5;
        String str6;
        String str7;
        String rating2;
        String str8;
        Document doc2;
        List genres;
        String contentRating;
        TvType tvtag;
        Document doc3;
        String url3;
        List genres2;
        List audio2;
        String rawtitle2;
        TvType tvtag2;
        String iframe4;
        String str9;
        String str10;
        String str11;
        String url4;
        Object obj3;
        Map infoMap;
        String iframe5;
        String description2;
        String title2;
        String backgroundposter2;
        String url5;
        String contentRating2;
        List genres3;
        String description3;
        TvType tvtag3;
        String url6;
        List audio3;
        String rawtitle3;
        List genres4;
        String iframe6;
        Document doc4;
        Object obj4;
        Map infoMap2;
        String url7;
        Object $result;
        String contentRating3;
        String title3;
        String backgroundposter3;
        String backgroundposter4;
        List genres5;
        String description4;
        Iterable iterableSplit$default;
        String strOwnText;
        Iterable iterableSplit$default2;
        Element elementSelectFirst2;
        String key;
        String strText;
        String strRemoveSuffix;
        Document document;
        List $this$load_u24lambda_u243;
        int i;
        Object iframe7;
        Collection destination$iv$iv2;
        Iterator it;
        String title4;
        String title5;
        String url8;
        List list;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Collection destination$iv$iv3;
        Iterable $this$mapNotNullTo$iv$iv;
        Iterator it2;
        Iterable $this$mapNotNull$iv2;
        String str12;
        String str13;
        String backgroundposter5;
        Iterable $this$mapNotNull$iv3;
        int $i$f$mapNotNull2;
        Collection destination$iv$iv4;
        Iterable $this$mapNotNullTo$iv$iv2;
        int $i$f$mapNotNullTo;
        Object objNewTvSeriesLoadResponse;
        Element card;
        Element elementSelectFirst3;
        final String epText;
        final Integer epnum;
        String str14;
        Collection destination$iv$iv5;
        List links;
        Episode episodeNewEpisode;
        Element a;
        String it3;
        String href;
        Element card2;
        String str15;
        int $i$f$mapNotNullTo2;
        String rating3;
        String strText2;
        Map mapMapOf;
        Collection destination$iv$iv6;
        Element block;
        Element elementSelectFirst4;
        String strText3;
        final String epText2;
        final Integer epnum2;
        String str16;
        Iterable $this$mapNotNull$iv4;
        int $i$f$mapNotNull3;
        Collection destination$iv$iv7;
        List links2;
        Episode episodeNewEpisode2;
        Element a2;
        String it4;
        String href2;
        String str17;
        Iterable $this$mapNotNull$iv5;
        int $i$f$mapNotNull4;
        List genres6;
        String strText4;
        String str18;
        String str19;
        Map mapMapOf2;
        Collection destination$iv$iv8;
        Object element$iv$iv;
        Element block2;
        boolean z;
        Document doc5;
        AppUtils appUtils;
        Iterable $this$flatMap$iv;
        int $i$f$flatMap;
        Collection destination$iv$iv9;
        Iterator it5;
        String title6;
        String url9;
        String backgroundposter6;
        List genres7;
        String str20;
        String str21;
        Iterable $this$flatMap$iv2;
        int $i$f$flatMap2;
        Collection destination$iv$iv10;
        Iterable<Element> $this$flatMapTo$iv$iv;
        Object objNewMovieLoadResponse;
        String title7;
        String rating4;
        String contentRating4;
        String description5;
        String description6;
        Map infoMap3;
        TvType tvtag4;
        String backgroundposter7;
        List audio4;
        String rating5;
        List genres8;
        Element elementSelectFirst5;
        String quality;
        String str22;
        Iterable $this$mapNotNull$iv6;
        Collection destination$iv$iv11;
        Element a3;
        String it6;
        boolean z2;
        Map mapMapOf3;
        Collection destination$iv$iv12;
        String strText5;
        Element h4;
        String quality2;
        Iterable $this$mapNotNull$iv7;
        int $i$f$mapNotNull5;
        Collection destination$iv$iv13;
        Element a4;
        String it7;
        boolean z3;
        String str23;
        String str24;
        Map mapMapOf4;
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
        Object $result2 = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = url;
                c00012.label = 1;
                str = ".pro-btn-group a";
                iframe = "a";
                rating = "url";
                str2 = "name";
                str3 = "href";
                Object obj5 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if (obj5 == obj) {
                    return obj;
                }
                obj2 = obj5;
                url2 = url;
                doc = ((NiceResponse) obj2).getDocument();
                Iterable<Element> $this$associate$iv = doc.select("ul.wp-block-list li");
                int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
                destination$iv$iv = new LinkedHashMap(capacity$iv);
                for (Element li : $this$associate$iv) {
                    elementSelectFirst2 = li.selectFirst("strong");
                    if (elementSelectFirst2 != null || (strText = elementSelectFirst2.text()) == null || (strRemoveSuffix = StringsKt.removeSuffix(strText, ":")) == null) {
                        key = null;
                    } else {
                        key = StringsKt.trim(strRemoveSuffix).toString();
                    }
                    if (key == null) {
                        key = "";
                    }
                    String value = StringsKt.trim(li.ownText()).toString();
                    Pair pair = TuplesKt.to(key, value);
                    destination$iv$iv.put(pair.getFirst(), pair.getSecond());
                }
                iframe2 = doc.select("div.wp-block-button a").attr(str3);
                str4 = (String) destination$iv$iv.get("Audio Tracks");
                if (str4 != null || (iterableSplit$default2 = StringsKt.split$default(str4, new String[]{"|"}, false, 0, 6, (Object) null)) == null) {
                    iframe3 = iframe2;
                    audio = CollectionsKt.emptyList();
                } else {
                    Iterable $this$map$iv = iterableSplit$default2;
                    Collection destination$iv$iv14 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        String it8 = (String) item$iv$iv;
                        String iframe8 = iframe2;
                        String iframe9 = StringsKt.trim(it8).toString();
                        destination$iv$iv14.add(iframe9);
                        iframe2 = iframe8;
                    }
                    iframe3 = iframe2;
                    audio = (List) destination$iv$iv14;
                }
                rawtitle = doc.select("meta[property=og:title]").attr("content");
                title = StringsKt.trim(StringsKt.substringBeforeLast$default(rawtitle, "(", (String) null, 2, (Object) null)).toString();
                StringBuilder sb = new StringBuilder();
                elementSelectFirst = doc.selectFirst("div.entry-content p");
                if (elementSelectFirst != null || (strOwnText = elementSelectFirst.ownText()) == null) {
                    string = null;
                } else {
                    string = StringsKt.trim(strOwnText).toString();
                }
                description = sb.append(string).append('\n').append(audio).toString();
                backgroundposter = doc.select("div.entry-content img").attr("src");
                str5 = (String) destination$iv$iv.get("MAL Rating");
                if (str5 != null || (strSubstringBefore$default = StringsKt.substringBefore$default(str5, "/", (String) null, 2, (Object) null)) == null) {
                    str6 = (String) destination$iv$iv.get("IMDb Rating");
                    if (str6 != null) {
                        String strSubstringBefore$default = StringsKt.substringBefore$default(str6, "/", (String) null, 2, (Object) null);
                        str7 = strSubstringBefore$default;
                    } else {
                        str7 = null;
                    }
                } else {
                    str7 = strSubstringBefore$default;
                }
                rating2 = str7;
                str8 = (String) destination$iv$iv.get("Genres");
                if (str8 != null || (iterableSplit$default = StringsKt.split$default(str8, new String[]{"|"}, false, 0, 6, (Object) null)) == null) {
                    doc2 = doc;
                    genres = CollectionsKt.emptyList();
                } else {
                    Iterable $this$map$iv2 = iterableSplit$default;
                    Collection destination$iv$iv15 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    for (Object item$iv$iv2 : $this$map$iv2) {
                        String it9 = (String) item$iv$iv2;
                        destination$iv$iv15.add(StringsKt.trim(it9).toString());
                        doc = doc;
                    }
                    doc2 = doc;
                    genres = (List) destination$iv$iv15;
                }
                contentRating = (String) destination$iv$iv.get("Official Dub By");
                if (StringsKt.contains(rawtitle, "Movie", true)) {
                    tvtag = TvType.Movie;
                } else {
                    tvtag = TvType.TvSeries;
                }
                if (tvtag == TvType.TvSeries) {
                    Requests app2 = MainActivityKt.getApp();
                    c00012.L$0 = url2;
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc2);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(iframe3);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(audio);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(rawtitle);
                    c00012.L$6 = title;
                    c00012.L$7 = description;
                    c00012.L$8 = backgroundposter;
                    c00012.L$9 = rating2;
                    c00012.L$10 = genres;
                    c00012.L$11 = contentRating;
                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvtag);
                    c00012.label = 2;
                    C00011 c00013 = c00012;
                    tvtag3 = tvtag;
                    url6 = url2;
                    audio3 = audio;
                    rawtitle3 = rawtitle;
                    genres4 = genres;
                    iframe6 = iframe3;
                    doc4 = doc2;
                    obj4 = Requests.get$default(app2, iframe6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                    c00012 = c00013;
                    if (obj4 == obj) {
                        return obj;
                    }
                    infoMap2 = destination$iv$iv;
                    url7 = url6;
                    $result = iframe6;
                    contentRating3 = title;
                    title3 = description;
                    backgroundposter3 = backgroundposter;
                    backgroundposter4 = rating2;
                    genres5 = genres4;
                    description4 = contentRating;
                    document = ((NiceResponse) obj4).getDocument();
                    $this$load_u24lambda_u243 = CollectionsKt.createListBuilder();
                    i = 0;
                    Iterable $this$filter$iv = document.select("div.wp-block-group");
                    iframe7 = $result;
                    destination$iv$iv2 = new ArrayList();
                    it = $this$filter$iv.iterator();
                    while (true) {
                        title4 = contentRating3;
                        title5 = "h2:contains(Episode)";
                        if (it.hasNext()) {
                            String url10 = url7;
                            element$iv$iv = it.next();
                            List list2 = $this$load_u24lambda_u243;
                            block2 = (Element) element$iv$iv;
                            if (block2.selectFirst("h2:contains(Episode)") != null || block2.selectFirst("h4") == null) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                destination$iv$iv2.add(element$iv$iv);
                            }
                            url7 = url10;
                            contentRating3 = title4;
                            $this$load_u24lambda_u243 = list2;
                        } else {
                            url8 = url7;
                            list = $this$load_u24lambda_u243;
                            $this$mapNotNull$iv = (List) destination$iv$iv2;
                            $i$f$mapNotNull = 0;
                            destination$iv$iv3 = new ArrayList();
                            $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                            it2 = $this$mapNotNullTo$iv$iv.iterator();
                            while (true) {
                                $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                str12 = "Episode:";
                                if (!it2.hasNext()) {
                                    String backgroundposter8 = backgroundposter3;
                                    List genres9 = genres5;
                                    str13 = rating;
                                    backgroundposter5 = str2;
                                    List it10 = (List) destination$iv$iv3;
                                    $this$load_u24lambda_u243.addAll(it10);
                                    $this$mapNotNull$iv3 = document.select("div.pro-ep-card");
                                    $i$f$mapNotNull2 = 0;
                                    destination$iv$iv4 = new ArrayList();
                                    $this$mapNotNullTo$iv$iv2 = $this$mapNotNull$iv3;
                                    $i$f$mapNotNullTo = 0;
                                    for (Object element$iv$iv$iv : $this$mapNotNullTo$iv$iv2) {
                                        Document document2 = document;
                                        card = (Element) element$iv$iv$iv;
                                        Iterable $this$mapNotNull$iv8 = $this$mapNotNull$iv3;
                                        elementSelectFirst3 = card.selectFirst(".pro-ep-title");
                                        if (elementSelectFirst3 != null) {
                                            epText = elementSelectFirst3.text();
                                        } else {
                                            epText = null;
                                        }
                                        if (epText == null) {
                                            epText = "";
                                        }
                                        int $i$f$mapNotNull6 = $i$f$mapNotNull2;
                                        Iterable $this$mapNotNullTo$iv$iv3 = $this$mapNotNullTo$iv$iv2;
                                        epnum = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringAfter$default(epText, str12, (String) null, 2, (Object) null)).toString());
                                        str14 = str;
                                        Iterable $this$mapNotNull$iv9 = card.select(str14);
                                        destination$iv$iv5 = new ArrayList();
                                        for (Object element$iv$iv$iv2 : $this$mapNotNull$iv9) {
                                            String str25 = str12;
                                            a = (Element) element$iv$iv$iv2;
                                            it3 = a.attr(str3);
                                            if (StringsKt.isBlank(it3)) {
                                                it3 = null;
                                            }
                                            if (it3 == null) {
                                                card2 = card;
                                                str15 = str14;
                                                $i$f$mapNotNullTo2 = $i$f$mapNotNullTo;
                                                rating3 = backgroundposter4;
                                                mapMapOf = null;
                                            } else {
                                                href = it3;
                                                card2 = card;
                                                str15 = str14;
                                                $i$f$mapNotNullTo2 = $i$f$mapNotNullTo;
                                                rating3 = backgroundposter4;
                                                if (!StringsKt.contains$default(href, "hubcloud", false, 2, (Object) null) || StringsKt.contains$default(href, "gdflix", false, 2, (Object) null)) {
                                                    Pair[] pairArr = new Pair[2];
                                                    strText2 = a.text();
                                                    if (StringsKt.isBlank(strText2)) {
                                                        strText2 = "Link";
                                                    }
                                                    pairArr[0] = TuplesKt.to(backgroundposter5, strText2);
                                                    pairArr[1] = TuplesKt.to(str13, href);
                                                    mapMapOf = MapsKt.mapOf(pairArr);
                                                } else {
                                                    mapMapOf = null;
                                                }
                                            }
                                            if (mapMapOf != null) {
                                                destination$iv$iv6 = destination$iv$iv5;
                                                destination$iv$iv6.add(mapMapOf);
                                            } else {
                                                destination$iv$iv6 = destination$iv$iv5;
                                            }
                                            destination$iv$iv5 = destination$iv$iv6;
                                            str12 = str25;
                                            card = card2;
                                            str14 = str15;
                                            $i$f$mapNotNullTo = $i$f$mapNotNullTo2;
                                            backgroundposter4 = rating3;
                                        }
                                        String str26 = str12;
                                        String str27 = str14;
                                        int $i$f$mapNotNullTo3 = $i$f$mapNotNullTo;
                                        String rating6 = backgroundposter4;
                                        links = (List) destination$iv$iv5;
                                        if (links.isEmpty()) {
                                            episodeNewEpisode = null;
                                        } else {
                                            episodeNewEpisode = MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(links), new Function1() { // from class: com.animedubhindi.Animedubhindi$$ExternalSyntheticLambda1
                                                public final Object invoke(Object obj6) {
                                                    return Animedubhindi.load$lambda$3$3$1(epnum, epText, (Episode) obj6);
                                                }
                                            });
                                        }
                                        if (episodeNewEpisode != null) {
                                            destination$iv$iv4.add(episodeNewEpisode);
                                        }
                                        document = document2;
                                        $this$mapNotNull$iv3 = $this$mapNotNull$iv8;
                                        $i$f$mapNotNull2 = $i$f$mapNotNull6;
                                        $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv3;
                                        str12 = str26;
                                        str = str27;
                                        $i$f$mapNotNullTo = $i$f$mapNotNullTo3;
                                        backgroundposter4 = rating6;
                                    }
                                    List it11 = (List) destination$iv$iv4;
                                    $this$load_u24lambda_u243.addAll(it11);
                                    List episodes = CollectionsKt.build(list);
                                    TvType tvType = TvType.Anime;
                                    C00022 c00022 = new C00022(backgroundposter8, genres9, backgroundposter4, description4, title3, null);
                                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url8);
                                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc4);
                                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(infoMap2);
                                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(iframe7);
                                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(audio3);
                                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(rawtitle3);
                                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(title4);
                                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(backgroundposter8);
                                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(backgroundposter4);
                                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(genres9);
                                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(description4);
                                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvtag3);
                                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(document);
                                    c00012.L$14 = SpillingKt.nullOutSpilledVariable(episodes);
                                    c00012.label = 3;
                                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title4, url8, tvType, episodes, c00022, c00012);
                                    if (objNewTvSeriesLoadResponse == obj) {
                                        return obj;
                                    }
                                    return (LoadResponse) objNewTvSeriesLoadResponse;
                                }
                                Object element$iv$iv$iv3 = it2.next();
                                int $i$f$mapNotNull7 = $i$f$mapNotNull;
                                block = (Element) element$iv$iv$iv3;
                                elementSelectFirst4 = block.selectFirst(title5);
                                if (elementSelectFirst4 != null) {
                                    strText3 = elementSelectFirst4.text();
                                } else {
                                    strText3 = null;
                                }
                                if (strText3 == null) {
                                    strText3 = "";
                                }
                                epText2 = strText3;
                                String str28 = title5;
                                Iterable $this$mapNotNullTo$iv$iv4 = $this$mapNotNullTo$iv$iv;
                                int i2 = i;
                                String backgroundposter9 = backgroundposter3;
                                epnum2 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(StringsKt.substringAfter$default(epText2, "Episode:", (String) null, 2, (Object) null), " ", (String) null, 2, (Object) null)).toString());
                                str16 = iframe;
                                $this$mapNotNull$iv4 = block.select(str16);
                                $i$f$mapNotNull3 = 0;
                                destination$iv$iv7 = new ArrayList();
                                for (Object element$iv$iv$iv4 : $this$mapNotNull$iv4) {
                                    Element block3 = block;
                                    a2 = (Element) element$iv$iv$iv4;
                                    it4 = a2.attr(str3);
                                    if (StringsKt.isBlank(it4)) {
                                        it4 = null;
                                    }
                                    if (it4 == null) {
                                        str17 = str16;
                                        $this$mapNotNull$iv5 = $this$mapNotNull$iv4;
                                        $i$f$mapNotNull4 = $i$f$mapNotNull3;
                                        genres6 = genres5;
                                        str19 = rating;
                                        str18 = str2;
                                        mapMapOf2 = null;
                                    } else {
                                        href2 = it4;
                                        str17 = str16;
                                        $this$mapNotNull$iv5 = $this$mapNotNull$iv4;
                                        $i$f$mapNotNull4 = $i$f$mapNotNull3;
                                        genres6 = genres5;
                                        if (!StringsKt.contains$default(href2, "hubcloud", false, 2, (Object) null) || StringsKt.contains$default(href2, "gdflix", false, 2, (Object) null)) {
                                            Pair[] pairArr2 = new Pair[2];
                                            strText4 = a2.text();
                                            if (StringsKt.isBlank(strText4)) {
                                                strText4 = "Link";
                                            }
                                            str18 = str2;
                                            pairArr2[0] = TuplesKt.to(str18, strText4);
                                            str19 = rating;
                                            pairArr2[1] = TuplesKt.to(str19, href2);
                                            mapMapOf2 = MapsKt.mapOf(pairArr2);
                                        } else {
                                            str19 = rating;
                                            str18 = str2;
                                            mapMapOf2 = null;
                                        }
                                    }
                                    if (mapMapOf2 != null) {
                                        destination$iv$iv8 = destination$iv$iv7;
                                        destination$iv$iv8.add(mapMapOf2);
                                    } else {
                                        destination$iv$iv8 = destination$iv$iv7;
                                    }
                                    destination$iv$iv7 = destination$iv$iv8;
                                    str2 = str18;
                                    rating = str19;
                                    $i$f$mapNotNull3 = $i$f$mapNotNull4;
                                    block = block3;
                                    str16 = str17;
                                    $this$mapNotNull$iv4 = $this$mapNotNull$iv5;
                                    genres5 = genres6;
                                }
                                String str29 = str16;
                                List genres10 = genres5;
                                String str30 = rating;
                                String str31 = str2;
                                links2 = (List) destination$iv$iv7;
                                if (links2.isEmpty()) {
                                    episodeNewEpisode2 = null;
                                } else {
                                    episodeNewEpisode2 = MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(links2), new Function1() { // from class: com.animedubhindi.Animedubhindi$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj6) {
                                            return Animedubhindi.load$lambda$3$1$1(epnum2, epText2, (Episode) obj6);
                                        }
                                    });
                                }
                                if (episodeNewEpisode2 != null) {
                                    destination$iv$iv3.add(episodeNewEpisode2);
                                }
                                str2 = str31;
                                rating = str30;
                                $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                $i$f$mapNotNull = $i$f$mapNotNull7;
                                title5 = str28;
                                i = i2;
                                $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv4;
                                backgroundposter3 = backgroundposter9;
                                iframe = str29;
                                genres5 = genres10;
                            }
                        }
                    }
                } else {
                    doc3 = doc2;
                    url3 = url2;
                    genres2 = genres;
                    audio2 = audio;
                    rawtitle2 = rawtitle;
                    tvtag2 = tvtag;
                    iframe4 = iframe3;
                    Requests app3 = MainActivityKt.getApp();
                    c00012.L$0 = url3;
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(iframe4);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(audio2);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(rawtitle2);
                    c00012.L$6 = title;
                    c00012.L$7 = description;
                    c00012.L$8 = backgroundposter;
                    c00012.L$9 = rating2;
                    c00012.L$10 = genres2;
                    c00012.L$11 = contentRating;
                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvtag2);
                    c00012.label = 4;
                    C00011 c00014 = c00012;
                    str9 = rating;
                    str10 = str2;
                    str11 = str;
                    url4 = iframe;
                    obj3 = Requests.get$default(app3, iframe4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00014, 4094, (Object) null);
                    c00012 = c00014;
                    if (obj3 == obj) {
                        return obj;
                    }
                    infoMap = destination$iv$iv;
                    iframe5 = iframe4;
                    description2 = description;
                    title2 = backgroundposter;
                    backgroundposter2 = rating2;
                    url5 = url3;
                    contentRating2 = title;
                    genres3 = genres2;
                    description3 = contentRating;
                    doc5 = ((NiceResponse) obj3).getDocument();
                    appUtils = AppUtils.INSTANCE;
                    $this$flatMap$iv = doc5.select("div.entry-content h4");
                    $i$f$flatMap = 0;
                    destination$iv$iv9 = new ArrayList();
                    it5 = $this$flatMap$iv.iterator();
                    while (true) {
                        title6 = contentRating2;
                        if (!it5.hasNext()) {
                            url9 = url5;
                            backgroundposter6 = title2;
                            genres7 = genres3;
                            str20 = str9;
                            str21 = str10;
                            ArrayList arrayList = (List) destination$iv$iv9;
                            $this$flatMap$iv2 = doc5.select("div.pro-ep-card .pro-quality-wrapper");
                            $i$f$flatMap2 = 0;
                            destination$iv$iv10 = new ArrayList();
                            $this$flatMapTo$iv$iv = $this$flatMap$iv2;
                            for (Element sec : $this$flatMapTo$iv$iv) {
                                Document doc6 = doc5;
                                elementSelectFirst5 = sec.selectFirst(".pro-ep-quality");
                                if (elementSelectFirst5 != null || (strText5 = elementSelectFirst5.text()) == null) {
                                    quality = null;
                                } else {
                                    $this$flatMap$iv2 = $this$flatMap$iv2;
                                    $i$f$flatMap2 = $i$f$flatMap2;
                                    quality = StringsKt.removeSurrounding(strText5, "[", "]");
                                }
                                if (quality == null) {
                                    quality = "";
                                }
                                str22 = str11;
                                $this$mapNotNull$iv6 = sec.select(str22);
                                destination$iv$iv11 = new ArrayList();
                                for (Object element$iv$iv$iv5 : $this$mapNotNull$iv6) {
                                    String str32 = str22;
                                    a3 = (Element) element$iv$iv$iv5;
                                    it6 = a3.attr(str3);
                                    String str33 = str3;
                                    Iterable $this$mapNotNull$iv10 = $this$mapNotNull$iv6;
                                    Element sec2 = sec;
                                    Iterable $this$flatMapTo$iv$iv2 = $this$flatMapTo$iv$iv;
                                    if (!StringsKt.contains$default(it6, "hubcloud", false, 2, (Object) null) || StringsKt.contains$default(it6, "gdflix", false, 2, (Object) null)) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        it6 = null;
                                    }
                                    if (it6 == null) {
                                        mapMapOf3 = null;
                                    } else {
                                        mapMapOf3 = MapsKt.mapOf(new Pair[]{TuplesKt.to(str21, StringsKt.trim(a3.text() + ' ' + quality).toString()), TuplesKt.to(str20, it6)});
                                    }
                                    if (mapMapOf3 != null) {
                                        destination$iv$iv12 = destination$iv$iv11;
                                        destination$iv$iv12.add(mapMapOf3);
                                    } else {
                                        destination$iv$iv12 = destination$iv$iv11;
                                    }
                                    destination$iv$iv11 = destination$iv$iv12;
                                    sec = sec2;
                                    str3 = str33;
                                    $this$mapNotNull$iv6 = $this$mapNotNull$iv10;
                                    $this$flatMapTo$iv$iv = $this$flatMapTo$iv$iv2;
                                    str22 = str32;
                                }
                                String str34 = str3;
                                String str35 = str22;
                                Iterable list$iv$iv = (List) destination$iv$iv11;
                                CollectionsKt.addAll(destination$iv$iv10, list$iv$iv);
                                doc5 = doc6;
                                $this$flatMap$iv2 = $this$flatMap$iv2;
                                $i$f$flatMap2 = $i$f$flatMap2;
                                str3 = str34;
                                $this$flatMapTo$iv$iv = $this$flatMapTo$iv$iv;
                                str11 = str35;
                            }
                            String hrefs = appUtils.toJson(CollectionsKt.plus(arrayList, (List) destination$iv$iv10));
                            Log.d("Phisher", hrefs);
                            TvType tvType2 = TvType.Movie;
                            C00033 c00033 = new C00033(backgroundposter6, genres7, backgroundposter2, description3, description2, null);
                            c00012.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                            c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                            c00012.L$2 = SpillingKt.nullOutSpilledVariable(infoMap);
                            c00012.L$3 = SpillingKt.nullOutSpilledVariable(iframe5);
                            c00012.L$4 = SpillingKt.nullOutSpilledVariable(audio2);
                            c00012.L$5 = SpillingKt.nullOutSpilledVariable(rawtitle2);
                            c00012.L$6 = SpillingKt.nullOutSpilledVariable(title6);
                            c00012.L$7 = SpillingKt.nullOutSpilledVariable(description2);
                            c00012.L$8 = SpillingKt.nullOutSpilledVariable(backgroundposter6);
                            c00012.L$9 = SpillingKt.nullOutSpilledVariable(backgroundposter2);
                            c00012.L$10 = SpillingKt.nullOutSpilledVariable(genres7);
                            c00012.L$11 = SpillingKt.nullOutSpilledVariable(description3);
                            c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvtag2);
                            c00012.L$13 = SpillingKt.nullOutSpilledVariable(doc5);
                            c00012.L$14 = SpillingKt.nullOutSpilledVariable(hrefs);
                            c00012.label = 5;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title6, url9, tvType2, hrefs, c00033, c00012);
                            if (objNewMovieLoadResponse == obj) {
                                return obj;
                            }
                            title7 = title6;
                            rating4 = backgroundposter2;
                            contentRating4 = description3;
                            description5 = description2;
                            description6 = iframe5;
                            infoMap3 = infoMap;
                            tvtag4 = tvtag2;
                            backgroundposter7 = backgroundposter6;
                            audio4 = audio2;
                            rating5 = rawtitle2;
                            genres8 = genres7;
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        h4 = (Element) it5.next();
                        String url11 = url5;
                        Iterable $this$flatMap$iv3 = $this$flatMap$iv;
                        int $i$f$flatMap3 = $i$f$flatMap;
                        String backgroundposter10 = title2;
                        quality2 = StringsKt.trim(StringsKt.substringBefore$default(h4.ownText(), "[Size", (String) null, 2, (Object) null)).toString();
                        $this$mapNotNull$iv7 = h4.select(url4);
                        $i$f$mapNotNull5 = 0;
                        destination$iv$iv13 = new ArrayList();
                        for (Object element$iv$iv$iv6 : $this$mapNotNull$iv7) {
                            String str36 = url4;
                            a4 = (Element) element$iv$iv$iv6;
                            it7 = a4.attr(str3);
                            Element h5 = h4;
                            Iterable $this$mapNotNull$iv11 = $this$mapNotNull$iv7;
                            int $i$f$mapNotNull8 = $i$f$mapNotNull5;
                            List genres11 = genres3;
                            if (!StringsKt.contains$default(it7, "hubcloud", false, 2, (Object) null) || StringsKt.contains$default(it7, "gdflix", false, 2, (Object) null)) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!z3) {
                                it7 = null;
                            }
                            if (it7 == null) {
                                str24 = str9;
                                str23 = str10;
                                mapMapOf4 = null;
                            } else {
                                str23 = str10;
                                str24 = str9;
                                mapMapOf4 = MapsKt.mapOf(new Pair[]{TuplesKt.to(str23, StringsKt.trim(a4.text() + ' ' + quality2).toString()), TuplesKt.to(str24, it7)});
                            }
                            if (mapMapOf4 != null) {
                                destination$iv$iv13.add(mapMapOf4);
                            }
                            str9 = str24;
                            str10 = str23;
                            h4 = h5;
                            $this$mapNotNull$iv7 = $this$mapNotNull$iv11;
                            $i$f$mapNotNull5 = $i$f$mapNotNull8;
                            genres3 = genres11;
                            url4 = str36;
                        }
                        String str37 = url4;
                        Iterable list$iv$iv2 = (List) destination$iv$iv13;
                        CollectionsKt.addAll(destination$iv$iv9, list$iv$iv2);
                        contentRating2 = title6;
                        url5 = url11;
                        $this$flatMap$iv = $this$flatMap$iv3;
                        $i$f$flatMap = $i$f$flatMap3;
                        title2 = backgroundposter10;
                        genres3 = genres3;
                        url4 = str37;
                    }
                }
                break;
            case 1:
                String url12 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result2);
                url2 = url12;
                obj = coroutine_suspended;
                obj2 = $result2;
                str = ".pro-btn-group a";
                iframe = "a";
                rating = "url";
                str2 = "name";
                str3 = "href";
                doc = ((NiceResponse) obj2).getDocument();
                Iterable<Element> $this$associate$iv2 = doc.select("ul.wp-block-list li");
                int capacity$iv2 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv2, 10)), 16);
                destination$iv$iv = new LinkedHashMap(capacity$iv2);
                while (r13.hasNext()) {
                    elementSelectFirst2 = li.selectFirst("strong");
                    if (elementSelectFirst2 != null) {
                        key = null;
                    } else {
                        key = null;
                    }
                    if (key == null) {
                        key = "";
                    }
                    String value2 = StringsKt.trim(li.ownText()).toString();
                    Pair pair2 = TuplesKt.to(key, value2);
                    destination$iv$iv.put(pair2.getFirst(), pair2.getSecond());
                }
                iframe2 = doc.select("div.wp-block-button a").attr(str3);
                str4 = (String) destination$iv$iv.get("Audio Tracks");
                if (str4 != null) {
                    iframe3 = iframe2;
                    audio = CollectionsKt.emptyList();
                } else {
                    iframe3 = iframe2;
                    audio = CollectionsKt.emptyList();
                }
                rawtitle = doc.select("meta[property=og:title]").attr("content");
                title = StringsKt.trim(StringsKt.substringBeforeLast$default(rawtitle, "(", (String) null, 2, (Object) null)).toString();
                StringBuilder sb2 = new StringBuilder();
                elementSelectFirst = doc.selectFirst("div.entry-content p");
                if (elementSelectFirst != null) {
                    string = null;
                } else {
                    string = null;
                }
                description = sb2.append(string).append('\n').append(audio).toString();
                backgroundposter = doc.select("div.entry-content img").attr("src");
                str5 = (String) destination$iv$iv.get("MAL Rating");
                if (str5 != null) {
                    str6 = (String) destination$iv$iv.get("IMDb Rating");
                    if (str6 != null) {
                        String strSubstringBefore$default2 = StringsKt.substringBefore$default(str6, "/", (String) null, 2, (Object) null);
                        str7 = strSubstringBefore$default2;
                    } else {
                        str7 = null;
                    }
                } else {
                    str6 = (String) destination$iv$iv.get("IMDb Rating");
                    if (str6 != null) {
                        String strSubstringBefore$default3 = StringsKt.substringBefore$default(str6, "/", (String) null, 2, (Object) null);
                        str7 = strSubstringBefore$default3;
                    } else {
                        str7 = null;
                    }
                }
                rating2 = str7;
                str8 = (String) destination$iv$iv.get("Genres");
                if (str8 != null) {
                    doc2 = doc;
                    genres = CollectionsKt.emptyList();
                } else {
                    doc2 = doc;
                    genres = CollectionsKt.emptyList();
                }
                contentRating = (String) destination$iv$iv.get("Official Dub By");
                if (StringsKt.contains(rawtitle, "Movie", true)) {
                    tvtag = TvType.Movie;
                } else {
                    tvtag = TvType.TvSeries;
                }
                if (tvtag == TvType.TvSeries) {
                    Requests app4 = MainActivityKt.getApp();
                    c00012.L$0 = url2;
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc2);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(iframe3);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(audio);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(rawtitle);
                    c00012.L$6 = title;
                    c00012.L$7 = description;
                    c00012.L$8 = backgroundposter;
                    c00012.L$9 = rating2;
                    c00012.L$10 = genres;
                    c00012.L$11 = contentRating;
                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvtag);
                    c00012.label = 2;
                    C00011 c00015 = c00012;
                    tvtag3 = tvtag;
                    url6 = url2;
                    audio3 = audio;
                    rawtitle3 = rawtitle;
                    genres4 = genres;
                    iframe6 = iframe3;
                    doc4 = doc2;
                    obj4 = Requests.get$default(app4, iframe6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00015, 4094, (Object) null);
                    c00012 = c00015;
                    if (obj4 == obj) {
                        return obj;
                    }
                    infoMap2 = destination$iv$iv;
                    url7 = url6;
                    $result = iframe6;
                    contentRating3 = title;
                    title3 = description;
                    backgroundposter3 = backgroundposter;
                    backgroundposter4 = rating2;
                    genres5 = genres4;
                    description4 = contentRating;
                    document = ((NiceResponse) obj4).getDocument();
                    $this$load_u24lambda_u243 = CollectionsKt.createListBuilder();
                    i = 0;
                    Iterable $this$filter$iv2 = document.select("div.wp-block-group");
                    iframe7 = $result;
                    destination$iv$iv2 = new ArrayList();
                    it = $this$filter$iv2.iterator();
                    while (true) {
                        title4 = contentRating3;
                        title5 = "h2:contains(Episode)";
                        if (it.hasNext()) {
                            String url13 = url7;
                            element$iv$iv = it.next();
                            List list3 = $this$load_u24lambda_u243;
                            block2 = (Element) element$iv$iv;
                            if (block2.selectFirst("h2:contains(Episode)") != null) {
                                z = false;
                            } else {
                                z = false;
                            }
                            if (z) {
                                destination$iv$iv2.add(element$iv$iv);
                            }
                            url7 = url13;
                            contentRating3 = title4;
                            $this$load_u24lambda_u243 = list3;
                        } else {
                            url8 = url7;
                            list = $this$load_u24lambda_u243;
                            $this$mapNotNull$iv = (List) destination$iv$iv2;
                            $i$f$mapNotNull = 0;
                            destination$iv$iv3 = new ArrayList();
                            $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                            it2 = $this$mapNotNullTo$iv$iv.iterator();
                            while (true) {
                                $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                str12 = "Episode:";
                                if (!it2.hasNext()) {
                                    String backgroundposter11 = backgroundposter3;
                                    List genres12 = genres5;
                                    str13 = rating;
                                    backgroundposter5 = str2;
                                    List it12 = (List) destination$iv$iv3;
                                    $this$load_u24lambda_u243.addAll(it12);
                                    $this$mapNotNull$iv3 = document.select("div.pro-ep-card");
                                    $i$f$mapNotNull2 = 0;
                                    destination$iv$iv4 = new ArrayList();
                                    $this$mapNotNullTo$iv$iv2 = $this$mapNotNull$iv3;
                                    $i$f$mapNotNullTo = 0;
                                    while (r19.hasNext()) {
                                        Document document3 = document;
                                        card = (Element) element$iv$iv$iv;
                                        Iterable $this$mapNotNull$iv12 = $this$mapNotNull$iv3;
                                        elementSelectFirst3 = card.selectFirst(".pro-ep-title");
                                        if (elementSelectFirst3 != null) {
                                            epText = elementSelectFirst3.text();
                                        } else {
                                            epText = null;
                                        }
                                        if (epText == null) {
                                            epText = "";
                                        }
                                        int $i$f$mapNotNull9 = $i$f$mapNotNull2;
                                        Iterable $this$mapNotNullTo$iv$iv5 = $this$mapNotNullTo$iv$iv2;
                                        epnum = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringAfter$default(epText, str12, (String) null, 2, (Object) null)).toString());
                                        str14 = str;
                                        Iterable $this$mapNotNull$iv13 = card.select(str14);
                                        destination$iv$iv5 = new ArrayList();
                                        while (r53.hasNext()) {
                                            String str210 = str12;
                                            a = (Element) element$iv$iv$iv2;
                                            it3 = a.attr(str3);
                                            if (StringsKt.isBlank(it3)) {
                                                it3 = null;
                                            }
                                            if (it3 == null) {
                                                card2 = card;
                                                str15 = str14;
                                                $i$f$mapNotNullTo2 = $i$f$mapNotNullTo;
                                                rating3 = backgroundposter4;
                                                mapMapOf = null;
                                            } else {
                                                href = it3;
                                                card2 = card;
                                                str15 = str14;
                                                $i$f$mapNotNullTo2 = $i$f$mapNotNullTo;
                                                rating3 = backgroundposter4;
                                                if (StringsKt.contains$default(href, "hubcloud", false, 2, (Object) null)) {
                                                    Pair[] pairArr3 = new Pair[2];
                                                    strText2 = a.text();
                                                    if (StringsKt.isBlank(strText2)) {
                                                        strText2 = "Link";
                                                    }
                                                    pairArr3[0] = TuplesKt.to(backgroundposter5, strText2);
                                                    pairArr3[1] = TuplesKt.to(str13, href);
                                                    mapMapOf = MapsKt.mapOf(pairArr3);
                                                } else {
                                                    Pair[] pairArr4 = new Pair[2];
                                                    strText2 = a.text();
                                                    if (StringsKt.isBlank(strText2)) {
                                                        strText2 = "Link";
                                                    }
                                                    pairArr4[0] = TuplesKt.to(backgroundposter5, strText2);
                                                    pairArr4[1] = TuplesKt.to(str13, href);
                                                    mapMapOf = MapsKt.mapOf(pairArr4);
                                                }
                                            }
                                            if (mapMapOf != null) {
                                                destination$iv$iv6 = destination$iv$iv5;
                                                destination$iv$iv6.add(mapMapOf);
                                            } else {
                                                destination$iv$iv6 = destination$iv$iv5;
                                            }
                                            destination$iv$iv5 = destination$iv$iv6;
                                            str12 = str210;
                                            card = card2;
                                            str14 = str15;
                                            $i$f$mapNotNullTo = $i$f$mapNotNullTo2;
                                            backgroundposter4 = rating3;
                                        }
                                        String str211 = str12;
                                        String str212 = str14;
                                        int $i$f$mapNotNullTo4 = $i$f$mapNotNullTo;
                                        String rating7 = backgroundposter4;
                                        links = (List) destination$iv$iv5;
                                        if (links.isEmpty()) {
                                            episodeNewEpisode = null;
                                        } else {
                                            episodeNewEpisode = MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(links), new Function1() { // from class: com.animedubhindi.Animedubhindi$$ExternalSyntheticLambda1
                                                public final Object invoke(Object obj6) {
                                                    return Animedubhindi.load$lambda$3$3$1(epnum, epText, (Episode) obj6);
                                                }
                                            });
                                        }
                                        if (episodeNewEpisode != null) {
                                            destination$iv$iv4.add(episodeNewEpisode);
                                        }
                                        document = document3;
                                        $this$mapNotNull$iv3 = $this$mapNotNull$iv12;
                                        $i$f$mapNotNull2 = $i$f$mapNotNull9;
                                        $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv5;
                                        str12 = str211;
                                        str = str212;
                                        $i$f$mapNotNullTo = $i$f$mapNotNullTo4;
                                        backgroundposter4 = rating7;
                                    }
                                    List it13 = (List) destination$iv$iv4;
                                    $this$load_u24lambda_u243.addAll(it13);
                                    List episodes2 = CollectionsKt.build(list);
                                    TvType tvType3 = TvType.Anime;
                                    C00022 c00023 = new C00022(backgroundposter11, genres12, backgroundposter4, description4, title3, null);
                                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url8);
                                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc4);
                                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(infoMap2);
                                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(iframe7);
                                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(audio3);
                                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(rawtitle3);
                                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(title4);
                                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(backgroundposter11);
                                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(backgroundposter4);
                                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(genres12);
                                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(description4);
                                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvtag3);
                                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(document);
                                    c00012.L$14 = SpillingKt.nullOutSpilledVariable(episodes2);
                                    c00012.label = 3;
                                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title4, url8, tvType3, episodes2, c00023, c00012);
                                    if (objNewTvSeriesLoadResponse == obj) {
                                        return obj;
                                    }
                                    return (LoadResponse) objNewTvSeriesLoadResponse;
                                }
                                Object element$iv$iv$iv7 = it2.next();
                                int $i$f$mapNotNull10 = $i$f$mapNotNull;
                                block = (Element) element$iv$iv$iv7;
                                elementSelectFirst4 = block.selectFirst(title5);
                                if (elementSelectFirst4 != null) {
                                    strText3 = elementSelectFirst4.text();
                                } else {
                                    strText3 = null;
                                }
                                if (strText3 == null) {
                                    strText3 = "";
                                }
                                epText2 = strText3;
                                String str213 = title5;
                                Iterable $this$mapNotNullTo$iv$iv6 = $this$mapNotNullTo$iv$iv;
                                int i3 = i;
                                String backgroundposter12 = backgroundposter3;
                                epnum2 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(StringsKt.substringAfter$default(epText2, "Episode:", (String) null, 2, (Object) null), " ", (String) null, 2, (Object) null)).toString());
                                str16 = iframe;
                                $this$mapNotNull$iv4 = block.select(str16);
                                $i$f$mapNotNull3 = 0;
                                destination$iv$iv7 = new ArrayList();
                                while (r55.hasNext()) {
                                    Element block4 = block;
                                    a2 = (Element) element$iv$iv$iv4;
                                    it4 = a2.attr(str3);
                                    if (StringsKt.isBlank(it4)) {
                                        it4 = null;
                                    }
                                    if (it4 == null) {
                                        str17 = str16;
                                        $this$mapNotNull$iv5 = $this$mapNotNull$iv4;
                                        $i$f$mapNotNull4 = $i$f$mapNotNull3;
                                        genres6 = genres5;
                                        str19 = rating;
                                        str18 = str2;
                                        mapMapOf2 = null;
                                    } else {
                                        href2 = it4;
                                        str17 = str16;
                                        $this$mapNotNull$iv5 = $this$mapNotNull$iv4;
                                        $i$f$mapNotNull4 = $i$f$mapNotNull3;
                                        genres6 = genres5;
                                        if (StringsKt.contains$default(href2, "hubcloud", false, 2, (Object) null)) {
                                            Pair[] pairArr5 = new Pair[2];
                                            strText4 = a2.text();
                                            if (StringsKt.isBlank(strText4)) {
                                                strText4 = "Link";
                                            }
                                            str18 = str2;
                                            pairArr5[0] = TuplesKt.to(str18, strText4);
                                            str19 = rating;
                                            pairArr5[1] = TuplesKt.to(str19, href2);
                                            mapMapOf2 = MapsKt.mapOf(pairArr5);
                                        } else {
                                            Pair[] pairArr6 = new Pair[2];
                                            strText4 = a2.text();
                                            if (StringsKt.isBlank(strText4)) {
                                                strText4 = "Link";
                                            }
                                            str18 = str2;
                                            pairArr6[0] = TuplesKt.to(str18, strText4);
                                            str19 = rating;
                                            pairArr6[1] = TuplesKt.to(str19, href2);
                                            mapMapOf2 = MapsKt.mapOf(pairArr6);
                                        }
                                    }
                                    if (mapMapOf2 != null) {
                                        destination$iv$iv8 = destination$iv$iv7;
                                        destination$iv$iv8.add(mapMapOf2);
                                    } else {
                                        destination$iv$iv8 = destination$iv$iv7;
                                    }
                                    destination$iv$iv7 = destination$iv$iv8;
                                    str2 = str18;
                                    rating = str19;
                                    $i$f$mapNotNull3 = $i$f$mapNotNull4;
                                    block = block4;
                                    str16 = str17;
                                    $this$mapNotNull$iv4 = $this$mapNotNull$iv5;
                                    genres5 = genres6;
                                }
                                String str214 = str16;
                                List genres13 = genres5;
                                String str38 = rating;
                                String str39 = str2;
                                links2 = (List) destination$iv$iv7;
                                if (links2.isEmpty()) {
                                    episodeNewEpisode2 = null;
                                } else {
                                    episodeNewEpisode2 = MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(links2), new Function1() { // from class: com.animedubhindi.Animedubhindi$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj6) {
                                            return Animedubhindi.load$lambda$3$1$1(epnum2, epText2, (Episode) obj6);
                                        }
                                    });
                                }
                                if (episodeNewEpisode2 != null) {
                                    destination$iv$iv3.add(episodeNewEpisode2);
                                }
                                str2 = str39;
                                rating = str38;
                                $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                $i$f$mapNotNull = $i$f$mapNotNull10;
                                title5 = str213;
                                i = i3;
                                $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv6;
                                backgroundposter3 = backgroundposter12;
                                iframe = str214;
                                genres5 = genres13;
                            }
                        }
                    }
                } else {
                    doc3 = doc2;
                    url3 = url2;
                    genres2 = genres;
                    audio2 = audio;
                    rawtitle2 = rawtitle;
                    tvtag2 = tvtag;
                    iframe4 = iframe3;
                    Requests app5 = MainActivityKt.getApp();
                    c00012.L$0 = url3;
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(iframe4);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(audio2);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(rawtitle2);
                    c00012.L$6 = title;
                    c00012.L$7 = description;
                    c00012.L$8 = backgroundposter;
                    c00012.L$9 = rating2;
                    c00012.L$10 = genres2;
                    c00012.L$11 = contentRating;
                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvtag2);
                    c00012.label = 4;
                    C00011 c00016 = c00012;
                    str9 = rating;
                    str10 = str2;
                    str11 = str;
                    url4 = iframe;
                    obj3 = Requests.get$default(app5, iframe4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00016, 4094, (Object) null);
                    c00012 = c00016;
                    if (obj3 == obj) {
                        return obj;
                    }
                    infoMap = destination$iv$iv;
                    iframe5 = iframe4;
                    description2 = description;
                    title2 = backgroundposter;
                    backgroundposter2 = rating2;
                    url5 = url3;
                    contentRating2 = title;
                    genres3 = genres2;
                    description3 = contentRating;
                    doc5 = ((NiceResponse) obj3).getDocument();
                    appUtils = AppUtils.INSTANCE;
                    $this$flatMap$iv = doc5.select("div.entry-content h4");
                    $i$f$flatMap = 0;
                    destination$iv$iv9 = new ArrayList();
                    it5 = $this$flatMap$iv.iterator();
                    while (true) {
                        title6 = contentRating2;
                        if (!it5.hasNext()) {
                            url9 = url5;
                            backgroundposter6 = title2;
                            genres7 = genres3;
                            str20 = str9;
                            str21 = str10;
                            ArrayList arrayList2 = (List) destination$iv$iv9;
                            $this$flatMap$iv2 = doc5.select("div.pro-ep-card .pro-quality-wrapper");
                            $i$f$flatMap2 = 0;
                            destination$iv$iv10 = new ArrayList();
                            $this$flatMapTo$iv$iv = $this$flatMap$iv2;
                            while (r17.hasNext()) {
                                Document doc7 = doc5;
                                elementSelectFirst5 = sec.selectFirst(".pro-ep-quality");
                                if (elementSelectFirst5 != null) {
                                }
                                quality = null;
                                if (quality == null) {
                                    quality = "";
                                }
                                str22 = str11;
                                $this$mapNotNull$iv6 = sec.select(str22);
                                destination$iv$iv11 = new ArrayList();
                                while (r46.hasNext()) {
                                    String str310 = str22;
                                    a3 = (Element) element$iv$iv$iv5;
                                    it6 = a3.attr(str3);
                                    String str311 = str3;
                                    Iterable $this$mapNotNull$iv14 = $this$mapNotNull$iv6;
                                    Element sec3 = sec;
                                    Iterable $this$flatMapTo$iv$iv3 = $this$flatMapTo$iv$iv;
                                    if (StringsKt.contains$default(it6, "hubcloud", false, 2, (Object) null)) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    if (!z2) {
                                        it6 = null;
                                    }
                                    if (it6 == null) {
                                        mapMapOf3 = null;
                                    } else {
                                        mapMapOf3 = MapsKt.mapOf(new Pair[]{TuplesKt.to(str21, StringsKt.trim(a3.text() + ' ' + quality).toString()), TuplesKt.to(str20, it6)});
                                    }
                                    if (mapMapOf3 != null) {
                                        destination$iv$iv12 = destination$iv$iv11;
                                        destination$iv$iv12.add(mapMapOf3);
                                    } else {
                                        destination$iv$iv12 = destination$iv$iv11;
                                    }
                                    destination$iv$iv11 = destination$iv$iv12;
                                    sec = sec3;
                                    str3 = str311;
                                    $this$mapNotNull$iv6 = $this$mapNotNull$iv14;
                                    $this$flatMapTo$iv$iv = $this$flatMapTo$iv$iv3;
                                    str22 = str310;
                                }
                                String str312 = str3;
                                String str313 = str22;
                                Iterable list$iv$iv3 = (List) destination$iv$iv11;
                                CollectionsKt.addAll(destination$iv$iv10, list$iv$iv3);
                                doc5 = doc7;
                                $this$flatMap$iv2 = $this$flatMap$iv2;
                                $i$f$flatMap2 = $i$f$flatMap2;
                                str3 = str312;
                                $this$flatMapTo$iv$iv = $this$flatMapTo$iv$iv;
                                str11 = str313;
                            }
                            String hrefs2 = appUtils.toJson(CollectionsKt.plus(arrayList2, (List) destination$iv$iv10));
                            Log.d("Phisher", hrefs2);
                            TvType tvType4 = TvType.Movie;
                            C00033 c00034 = new C00033(backgroundposter6, genres7, backgroundposter2, description3, description2, null);
                            c00012.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                            c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                            c00012.L$2 = SpillingKt.nullOutSpilledVariable(infoMap);
                            c00012.L$3 = SpillingKt.nullOutSpilledVariable(iframe5);
                            c00012.L$4 = SpillingKt.nullOutSpilledVariable(audio2);
                            c00012.L$5 = SpillingKt.nullOutSpilledVariable(rawtitle2);
                            c00012.L$6 = SpillingKt.nullOutSpilledVariable(title6);
                            c00012.L$7 = SpillingKt.nullOutSpilledVariable(description2);
                            c00012.L$8 = SpillingKt.nullOutSpilledVariable(backgroundposter6);
                            c00012.L$9 = SpillingKt.nullOutSpilledVariable(backgroundposter2);
                            c00012.L$10 = SpillingKt.nullOutSpilledVariable(genres7);
                            c00012.L$11 = SpillingKt.nullOutSpilledVariable(description3);
                            c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvtag2);
                            c00012.L$13 = SpillingKt.nullOutSpilledVariable(doc5);
                            c00012.L$14 = SpillingKt.nullOutSpilledVariable(hrefs2);
                            c00012.label = 5;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title6, url9, tvType4, hrefs2, c00034, c00012);
                            if (objNewMovieLoadResponse == obj) {
                                return obj;
                            }
                            title7 = title6;
                            rating4 = backgroundposter2;
                            contentRating4 = description3;
                            description5 = description2;
                            description6 = iframe5;
                            infoMap3 = infoMap;
                            tvtag4 = tvtag2;
                            backgroundposter7 = backgroundposter6;
                            audio4 = audio2;
                            rating5 = rawtitle2;
                            genres8 = genres7;
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        h4 = (Element) it5.next();
                        String url14 = url5;
                        Iterable $this$flatMap$iv4 = $this$flatMap$iv;
                        int $i$f$flatMap4 = $i$f$flatMap;
                        String backgroundposter13 = title2;
                        quality2 = StringsKt.trim(StringsKt.substringBefore$default(h4.ownText(), "[Size", (String) null, 2, (Object) null)).toString();
                        $this$mapNotNull$iv7 = h4.select(url4);
                        $i$f$mapNotNull5 = 0;
                        destination$iv$iv13 = new ArrayList();
                        while (r44.hasNext()) {
                            String str314 = url4;
                            a4 = (Element) element$iv$iv$iv6;
                            it7 = a4.attr(str3);
                            Element h6 = h4;
                            Iterable $this$mapNotNull$iv15 = $this$mapNotNull$iv7;
                            int $i$f$mapNotNull11 = $i$f$mapNotNull5;
                            List genres14 = genres3;
                            if (StringsKt.contains$default(it7, "hubcloud", false, 2, (Object) null)) {
                                z3 = true;
                            } else {
                                z3 = true;
                            }
                            if (!z3) {
                                it7 = null;
                            }
                            if (it7 == null) {
                                str24 = str9;
                                str23 = str10;
                                mapMapOf4 = null;
                            } else {
                                str23 = str10;
                                str24 = str9;
                                mapMapOf4 = MapsKt.mapOf(new Pair[]{TuplesKt.to(str23, StringsKt.trim(a4.text() + ' ' + quality2).toString()), TuplesKt.to(str24, it7)});
                            }
                            if (mapMapOf4 != null) {
                                destination$iv$iv13.add(mapMapOf4);
                            }
                            str9 = str24;
                            str10 = str23;
                            h4 = h6;
                            $this$mapNotNull$iv7 = $this$mapNotNull$iv15;
                            $i$f$mapNotNull5 = $i$f$mapNotNull11;
                            genres3 = genres14;
                            url4 = str314;
                        }
                        String str315 = url4;
                        Iterable list$iv$iv4 = (List) destination$iv$iv13;
                        CollectionsKt.addAll(destination$iv$iv9, list$iv$iv4);
                        contentRating2 = title6;
                        url5 = url14;
                        $this$flatMap$iv = $this$flatMap$iv4;
                        $i$f$flatMap = $i$f$flatMap4;
                        title2 = backgroundposter13;
                        genres3 = genres3;
                        url4 = str315;
                    }
                }
                break;
            case 2:
                TvType tvtag5 = (TvType) c00012.L$12;
                String contentRating5 = (String) c00012.L$11;
                List genres15 = (List) c00012.L$10;
                String rating8 = (String) c00012.L$9;
                String backgroundposter14 = (String) c00012.L$8;
                String description7 = (String) c00012.L$7;
                String title8 = (String) c00012.L$6;
                String rawtitle4 = (String) c00012.L$5;
                List audio5 = (List) c00012.L$4;
                Object iframe10 = (String) c00012.L$3;
                Map infoMap4 = (Map) c00012.L$2;
                Document doc8 = (Document) c00012.L$1;
                String url15 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result2);
                description4 = contentRating5;
                contentRating3 = title8;
                title3 = description7;
                genres5 = genres15;
                backgroundposter3 = backgroundposter14;
                backgroundposter4 = rating8;
                str3 = "href";
                tvtag3 = tvtag5;
                rawtitle3 = rawtitle4;
                audio3 = audio5;
                infoMap2 = infoMap4;
                doc4 = doc8;
                str = ".pro-btn-group a";
                rating = "url";
                str2 = "name";
                url7 = url15;
                obj = coroutine_suspended;
                $result = iframe10;
                obj4 = $result2;
                iframe = "a";
                document = ((NiceResponse) obj4).getDocument();
                $this$load_u24lambda_u243 = CollectionsKt.createListBuilder();
                i = 0;
                Iterable $this$filter$iv3 = document.select("div.wp-block-group");
                iframe7 = $result;
                destination$iv$iv2 = new ArrayList();
                it = $this$filter$iv3.iterator();
                while (true) {
                    title4 = contentRating3;
                    title5 = "h2:contains(Episode)";
                    if (it.hasNext()) {
                        String url16 = url7;
                        element$iv$iv = it.next();
                        List list4 = $this$load_u24lambda_u243;
                        block2 = (Element) element$iv$iv;
                        if (block2.selectFirst("h2:contains(Episode)") != null) {
                            z = false;
                        } else {
                            z = false;
                        }
                        if (z) {
                            destination$iv$iv2.add(element$iv$iv);
                        }
                        url7 = url16;
                        contentRating3 = title4;
                        $this$load_u24lambda_u243 = list4;
                    } else {
                        url8 = url7;
                        list = $this$load_u24lambda_u243;
                        $this$mapNotNull$iv = (List) destination$iv$iv2;
                        $i$f$mapNotNull = 0;
                        destination$iv$iv3 = new ArrayList();
                        $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                        it2 = $this$mapNotNullTo$iv$iv.iterator();
                        while (true) {
                            $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                            str12 = "Episode:";
                            if (!it2.hasNext()) {
                                String backgroundposter15 = backgroundposter3;
                                List genres16 = genres5;
                                str13 = rating;
                                backgroundposter5 = str2;
                                List it14 = (List) destination$iv$iv3;
                                $this$load_u24lambda_u243.addAll(it14);
                                $this$mapNotNull$iv3 = document.select("div.pro-ep-card");
                                $i$f$mapNotNull2 = 0;
                                destination$iv$iv4 = new ArrayList();
                                $this$mapNotNullTo$iv$iv2 = $this$mapNotNull$iv3;
                                $i$f$mapNotNullTo = 0;
                                while (r19.hasNext()) {
                                    Document document4 = document;
                                    card = (Element) element$iv$iv$iv;
                                    Iterable $this$mapNotNull$iv16 = $this$mapNotNull$iv3;
                                    elementSelectFirst3 = card.selectFirst(".pro-ep-title");
                                    if (elementSelectFirst3 != null) {
                                        epText = elementSelectFirst3.text();
                                    } else {
                                        epText = null;
                                    }
                                    if (epText == null) {
                                        epText = "";
                                    }
                                    int $i$f$mapNotNull12 = $i$f$mapNotNull2;
                                    Iterable $this$mapNotNullTo$iv$iv7 = $this$mapNotNullTo$iv$iv2;
                                    epnum = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringAfter$default(epText, str12, (String) null, 2, (Object) null)).toString());
                                    str14 = str;
                                    Iterable $this$mapNotNull$iv17 = card.select(str14);
                                    destination$iv$iv5 = new ArrayList();
                                    while (r53.hasNext()) {
                                        String str215 = str12;
                                        a = (Element) element$iv$iv$iv2;
                                        it3 = a.attr(str3);
                                        if (StringsKt.isBlank(it3)) {
                                            it3 = null;
                                        }
                                        if (it3 == null) {
                                            card2 = card;
                                            str15 = str14;
                                            $i$f$mapNotNullTo2 = $i$f$mapNotNullTo;
                                            rating3 = backgroundposter4;
                                            mapMapOf = null;
                                        } else {
                                            href = it3;
                                            card2 = card;
                                            str15 = str14;
                                            $i$f$mapNotNullTo2 = $i$f$mapNotNullTo;
                                            rating3 = backgroundposter4;
                                            if (StringsKt.contains$default(href, "hubcloud", false, 2, (Object) null)) {
                                                Pair[] pairArr7 = new Pair[2];
                                                strText2 = a.text();
                                                if (StringsKt.isBlank(strText2)) {
                                                    strText2 = "Link";
                                                }
                                                pairArr7[0] = TuplesKt.to(backgroundposter5, strText2);
                                                pairArr7[1] = TuplesKt.to(str13, href);
                                                mapMapOf = MapsKt.mapOf(pairArr7);
                                            } else {
                                                Pair[] pairArr8 = new Pair[2];
                                                strText2 = a.text();
                                                if (StringsKt.isBlank(strText2)) {
                                                    strText2 = "Link";
                                                }
                                                pairArr8[0] = TuplesKt.to(backgroundposter5, strText2);
                                                pairArr8[1] = TuplesKt.to(str13, href);
                                                mapMapOf = MapsKt.mapOf(pairArr8);
                                            }
                                        }
                                        if (mapMapOf != null) {
                                            destination$iv$iv6 = destination$iv$iv5;
                                            destination$iv$iv6.add(mapMapOf);
                                        } else {
                                            destination$iv$iv6 = destination$iv$iv5;
                                        }
                                        destination$iv$iv5 = destination$iv$iv6;
                                        str12 = str215;
                                        card = card2;
                                        str14 = str15;
                                        $i$f$mapNotNullTo = $i$f$mapNotNullTo2;
                                        backgroundposter4 = rating3;
                                    }
                                    String str216 = str12;
                                    String str217 = str14;
                                    int $i$f$mapNotNullTo5 = $i$f$mapNotNullTo;
                                    String rating9 = backgroundposter4;
                                    links = (List) destination$iv$iv5;
                                    if (links.isEmpty()) {
                                        episodeNewEpisode = null;
                                    } else {
                                        episodeNewEpisode = MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(links), new Function1() { // from class: com.animedubhindi.Animedubhindi$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj6) {
                                                return Animedubhindi.load$lambda$3$3$1(epnum, epText, (Episode) obj6);
                                            }
                                        });
                                    }
                                    if (episodeNewEpisode != null) {
                                        destination$iv$iv4.add(episodeNewEpisode);
                                    }
                                    document = document4;
                                    $this$mapNotNull$iv3 = $this$mapNotNull$iv16;
                                    $i$f$mapNotNull2 = $i$f$mapNotNull12;
                                    $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv7;
                                    str12 = str216;
                                    str = str217;
                                    $i$f$mapNotNullTo = $i$f$mapNotNullTo5;
                                    backgroundposter4 = rating9;
                                }
                                List it15 = (List) destination$iv$iv4;
                                $this$load_u24lambda_u243.addAll(it15);
                                List episodes3 = CollectionsKt.build(list);
                                TvType tvType5 = TvType.Anime;
                                C00022 c00024 = new C00022(backgroundposter15, genres16, backgroundposter4, description4, title3, null);
                                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url8);
                                c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc4);
                                c00012.L$2 = SpillingKt.nullOutSpilledVariable(infoMap2);
                                c00012.L$3 = SpillingKt.nullOutSpilledVariable(iframe7);
                                c00012.L$4 = SpillingKt.nullOutSpilledVariable(audio3);
                                c00012.L$5 = SpillingKt.nullOutSpilledVariable(rawtitle3);
                                c00012.L$6 = SpillingKt.nullOutSpilledVariable(title4);
                                c00012.L$7 = SpillingKt.nullOutSpilledVariable(title3);
                                c00012.L$8 = SpillingKt.nullOutSpilledVariable(backgroundposter15);
                                c00012.L$9 = SpillingKt.nullOutSpilledVariable(backgroundposter4);
                                c00012.L$10 = SpillingKt.nullOutSpilledVariable(genres16);
                                c00012.L$11 = SpillingKt.nullOutSpilledVariable(description4);
                                c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvtag3);
                                c00012.L$13 = SpillingKt.nullOutSpilledVariable(document);
                                c00012.L$14 = SpillingKt.nullOutSpilledVariable(episodes3);
                                c00012.label = 3;
                                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title4, url8, tvType5, episodes3, c00024, c00012);
                                if (objNewTvSeriesLoadResponse == obj) {
                                    return obj;
                                }
                                return (LoadResponse) objNewTvSeriesLoadResponse;
                            }
                            Object element$iv$iv$iv8 = it2.next();
                            int $i$f$mapNotNull13 = $i$f$mapNotNull;
                            block = (Element) element$iv$iv$iv8;
                            elementSelectFirst4 = block.selectFirst(title5);
                            if (elementSelectFirst4 != null) {
                                strText3 = elementSelectFirst4.text();
                            } else {
                                strText3 = null;
                            }
                            if (strText3 == null) {
                                strText3 = "";
                            }
                            epText2 = strText3;
                            String str218 = title5;
                            Iterable $this$mapNotNullTo$iv$iv8 = $this$mapNotNullTo$iv$iv;
                            int i4 = i;
                            String backgroundposter16 = backgroundposter3;
                            epnum2 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(StringsKt.substringAfter$default(epText2, "Episode:", (String) null, 2, (Object) null), " ", (String) null, 2, (Object) null)).toString());
                            str16 = iframe;
                            $this$mapNotNull$iv4 = block.select(str16);
                            $i$f$mapNotNull3 = 0;
                            destination$iv$iv7 = new ArrayList();
                            while (r55.hasNext()) {
                                Element block5 = block;
                                a2 = (Element) element$iv$iv$iv4;
                                it4 = a2.attr(str3);
                                if (StringsKt.isBlank(it4)) {
                                    it4 = null;
                                }
                                if (it4 == null) {
                                    str17 = str16;
                                    $this$mapNotNull$iv5 = $this$mapNotNull$iv4;
                                    $i$f$mapNotNull4 = $i$f$mapNotNull3;
                                    genres6 = genres5;
                                    str19 = rating;
                                    str18 = str2;
                                    mapMapOf2 = null;
                                } else {
                                    href2 = it4;
                                    str17 = str16;
                                    $this$mapNotNull$iv5 = $this$mapNotNull$iv4;
                                    $i$f$mapNotNull4 = $i$f$mapNotNull3;
                                    genres6 = genres5;
                                    if (StringsKt.contains$default(href2, "hubcloud", false, 2, (Object) null)) {
                                        Pair[] pairArr9 = new Pair[2];
                                        strText4 = a2.text();
                                        if (StringsKt.isBlank(strText4)) {
                                            strText4 = "Link";
                                        }
                                        str18 = str2;
                                        pairArr9[0] = TuplesKt.to(str18, strText4);
                                        str19 = rating;
                                        pairArr9[1] = TuplesKt.to(str19, href2);
                                        mapMapOf2 = MapsKt.mapOf(pairArr9);
                                    } else {
                                        Pair[] pairArr10 = new Pair[2];
                                        strText4 = a2.text();
                                        if (StringsKt.isBlank(strText4)) {
                                            strText4 = "Link";
                                        }
                                        str18 = str2;
                                        pairArr10[0] = TuplesKt.to(str18, strText4);
                                        str19 = rating;
                                        pairArr10[1] = TuplesKt.to(str19, href2);
                                        mapMapOf2 = MapsKt.mapOf(pairArr10);
                                    }
                                }
                                if (mapMapOf2 != null) {
                                    destination$iv$iv8 = destination$iv$iv7;
                                    destination$iv$iv8.add(mapMapOf2);
                                } else {
                                    destination$iv$iv8 = destination$iv$iv7;
                                }
                                destination$iv$iv7 = destination$iv$iv8;
                                str2 = str18;
                                rating = str19;
                                $i$f$mapNotNull3 = $i$f$mapNotNull4;
                                block = block5;
                                str16 = str17;
                                $this$mapNotNull$iv4 = $this$mapNotNull$iv5;
                                genres5 = genres6;
                            }
                            String str219 = str16;
                            List genres17 = genres5;
                            String str316 = rating;
                            String str317 = str2;
                            links2 = (List) destination$iv$iv7;
                            if (links2.isEmpty()) {
                                episodeNewEpisode2 = null;
                            } else {
                                episodeNewEpisode2 = MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(links2), new Function1() { // from class: com.animedubhindi.Animedubhindi$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj6) {
                                        return Animedubhindi.load$lambda$3$1$1(epnum2, epText2, (Episode) obj6);
                                    }
                                });
                            }
                            if (episodeNewEpisode2 != null) {
                                destination$iv$iv3.add(episodeNewEpisode2);
                            }
                            str2 = str317;
                            rating = str316;
                            $this$mapNotNull$iv = $this$mapNotNull$iv2;
                            $i$f$mapNotNull = $i$f$mapNotNull13;
                            title5 = str218;
                            i = i4;
                            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv8;
                            backgroundposter3 = backgroundposter16;
                            iframe = str219;
                            genres5 = genres17;
                        }
                    }
                }
                break;
            case 3:
                ResultKt.throwOnFailure($result2);
                objNewTvSeriesLoadResponse = $result2;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 4:
                TvType tvtag6 = (TvType) c00012.L$12;
                String contentRating6 = (String) c00012.L$11;
                List genres18 = (List) c00012.L$10;
                String rating10 = (String) c00012.L$9;
                String backgroundposter17 = (String) c00012.L$8;
                String description8 = (String) c00012.L$7;
                String title9 = (String) c00012.L$6;
                String rawtitle5 = (String) c00012.L$5;
                List audio6 = (List) c00012.L$4;
                iframe5 = (String) c00012.L$3;
                infoMap = (Map) c00012.L$2;
                Document doc9 = (Document) c00012.L$1;
                String url17 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result2);
                description3 = contentRating6;
                contentRating2 = title9;
                title2 = backgroundposter17;
                backgroundposter2 = rating10;
                genres3 = genres18;
                description2 = description8;
                str9 = "url";
                str10 = "name";
                str3 = "href";
                tvtag2 = tvtag6;
                rawtitle2 = rawtitle5;
                audio2 = audio6;
                doc3 = doc9;
                str11 = ".pro-btn-group a";
                url5 = url17;
                obj = coroutine_suspended;
                url4 = "a";
                obj3 = $result2;
                doc5 = ((NiceResponse) obj3).getDocument();
                appUtils = AppUtils.INSTANCE;
                $this$flatMap$iv = doc5.select("div.entry-content h4");
                $i$f$flatMap = 0;
                destination$iv$iv9 = new ArrayList();
                it5 = $this$flatMap$iv.iterator();
                while (true) {
                    title6 = contentRating2;
                    if (!it5.hasNext()) {
                        url9 = url5;
                        backgroundposter6 = title2;
                        genres7 = genres3;
                        str20 = str9;
                        str21 = str10;
                        ArrayList arrayList3 = (List) destination$iv$iv9;
                        $this$flatMap$iv2 = doc5.select("div.pro-ep-card .pro-quality-wrapper");
                        $i$f$flatMap2 = 0;
                        destination$iv$iv10 = new ArrayList();
                        $this$flatMapTo$iv$iv = $this$flatMap$iv2;
                        while (r17.hasNext()) {
                            Document doc10 = doc5;
                            elementSelectFirst5 = sec.selectFirst(".pro-ep-quality");
                            if (elementSelectFirst5 != null) {
                            }
                            quality = null;
                            if (quality == null) {
                                quality = "";
                            }
                            str22 = str11;
                            $this$mapNotNull$iv6 = sec.select(str22);
                            destination$iv$iv11 = new ArrayList();
                            while (r46.hasNext()) {
                                String str318 = str22;
                                a3 = (Element) element$iv$iv$iv5;
                                it6 = a3.attr(str3);
                                String str319 = str3;
                                Iterable $this$mapNotNull$iv18 = $this$mapNotNull$iv6;
                                Element sec4 = sec;
                                Iterable $this$flatMapTo$iv$iv4 = $this$flatMapTo$iv$iv;
                                if (StringsKt.contains$default(it6, "hubcloud", false, 2, (Object) null)) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    it6 = null;
                                }
                                if (it6 == null) {
                                    mapMapOf3 = null;
                                } else {
                                    mapMapOf3 = MapsKt.mapOf(new Pair[]{TuplesKt.to(str21, StringsKt.trim(a3.text() + ' ' + quality).toString()), TuplesKt.to(str20, it6)});
                                }
                                if (mapMapOf3 != null) {
                                    destination$iv$iv12 = destination$iv$iv11;
                                    destination$iv$iv12.add(mapMapOf3);
                                } else {
                                    destination$iv$iv12 = destination$iv$iv11;
                                }
                                destination$iv$iv11 = destination$iv$iv12;
                                sec = sec4;
                                str3 = str319;
                                $this$mapNotNull$iv6 = $this$mapNotNull$iv18;
                                $this$flatMapTo$iv$iv = $this$flatMapTo$iv$iv4;
                                str22 = str318;
                            }
                            String str3110 = str3;
                            String str3111 = str22;
                            Iterable list$iv$iv5 = (List) destination$iv$iv11;
                            CollectionsKt.addAll(destination$iv$iv10, list$iv$iv5);
                            doc5 = doc10;
                            $this$flatMap$iv2 = $this$flatMap$iv2;
                            $i$f$flatMap2 = $i$f$flatMap2;
                            str3 = str3110;
                            $this$flatMapTo$iv$iv = $this$flatMapTo$iv$iv;
                            str11 = str3111;
                        }
                        String hrefs3 = appUtils.toJson(CollectionsKt.plus(arrayList3, (List) destination$iv$iv10));
                        Log.d("Phisher", hrefs3);
                        TvType tvType6 = TvType.Movie;
                        C00033 c00035 = new C00033(backgroundposter6, genres7, backgroundposter2, description3, description2, null);
                        c00012.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                        c00012.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                        c00012.L$2 = SpillingKt.nullOutSpilledVariable(infoMap);
                        c00012.L$3 = SpillingKt.nullOutSpilledVariable(iframe5);
                        c00012.L$4 = SpillingKt.nullOutSpilledVariable(audio2);
                        c00012.L$5 = SpillingKt.nullOutSpilledVariable(rawtitle2);
                        c00012.L$6 = SpillingKt.nullOutSpilledVariable(title6);
                        c00012.L$7 = SpillingKt.nullOutSpilledVariable(description2);
                        c00012.L$8 = SpillingKt.nullOutSpilledVariable(backgroundposter6);
                        c00012.L$9 = SpillingKt.nullOutSpilledVariable(backgroundposter2);
                        c00012.L$10 = SpillingKt.nullOutSpilledVariable(genres7);
                        c00012.L$11 = SpillingKt.nullOutSpilledVariable(description3);
                        c00012.L$12 = SpillingKt.nullOutSpilledVariable(tvtag2);
                        c00012.L$13 = SpillingKt.nullOutSpilledVariable(doc5);
                        c00012.L$14 = SpillingKt.nullOutSpilledVariable(hrefs3);
                        c00012.label = 5;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title6, url9, tvType6, hrefs3, c00035, c00012);
                        if (objNewMovieLoadResponse == obj) {
                            return obj;
                        }
                        title7 = title6;
                        rating4 = backgroundposter2;
                        contentRating4 = description3;
                        description5 = description2;
                        description6 = iframe5;
                        infoMap3 = infoMap;
                        tvtag4 = tvtag2;
                        backgroundposter7 = backgroundposter6;
                        audio4 = audio2;
                        rating5 = rawtitle2;
                        genres8 = genres7;
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    h4 = (Element) it5.next();
                    String url18 = url5;
                    Iterable $this$flatMap$iv5 = $this$flatMap$iv;
                    int $i$f$flatMap5 = $i$f$flatMap;
                    String backgroundposter18 = title2;
                    quality2 = StringsKt.trim(StringsKt.substringBefore$default(h4.ownText(), "[Size", (String) null, 2, (Object) null)).toString();
                    $this$mapNotNull$iv7 = h4.select(url4);
                    $i$f$mapNotNull5 = 0;
                    destination$iv$iv13 = new ArrayList();
                    while (r44.hasNext()) {
                        String str3112 = url4;
                        a4 = (Element) element$iv$iv$iv6;
                        it7 = a4.attr(str3);
                        Element h7 = h4;
                        Iterable $this$mapNotNull$iv19 = $this$mapNotNull$iv7;
                        int $i$f$mapNotNull14 = $i$f$mapNotNull5;
                        List genres19 = genres3;
                        if (StringsKt.contains$default(it7, "hubcloud", false, 2, (Object) null)) {
                            z3 = true;
                        } else {
                            z3 = true;
                        }
                        if (!z3) {
                            it7 = null;
                        }
                        if (it7 == null) {
                            str24 = str9;
                            str23 = str10;
                            mapMapOf4 = null;
                        } else {
                            str23 = str10;
                            str24 = str9;
                            mapMapOf4 = MapsKt.mapOf(new Pair[]{TuplesKt.to(str23, StringsKt.trim(a4.text() + ' ' + quality2).toString()), TuplesKt.to(str24, it7)});
                        }
                        if (mapMapOf4 != null) {
                            destination$iv$iv13.add(mapMapOf4);
                        }
                        str9 = str24;
                        str10 = str23;
                        h4 = h7;
                        $this$mapNotNull$iv7 = $this$mapNotNull$iv19;
                        $i$f$mapNotNull5 = $i$f$mapNotNull14;
                        genres3 = genres19;
                        url4 = str3112;
                    }
                    String str3113 = url4;
                    Iterable list$iv$iv6 = (List) destination$iv$iv13;
                    CollectionsKt.addAll(destination$iv$iv9, list$iv$iv6);
                    contentRating2 = title6;
                    url5 = url18;
                    $this$flatMap$iv = $this$flatMap$iv5;
                    $i$f$flatMap = $i$f$flatMap5;
                    title2 = backgroundposter18;
                    genres3 = genres3;
                    url4 = str3113;
                }
                break;
            case 5:
                tvtag4 = (TvType) c00012.L$12;
                contentRating4 = (String) c00012.L$11;
                genres8 = (List) c00012.L$10;
                rating4 = (String) c00012.L$9;
                backgroundposter7 = (String) c00012.L$8;
                description5 = (String) c00012.L$7;
                title7 = (String) c00012.L$6;
                rating5 = (String) c00012.L$5;
                audio4 = (List) c00012.L$4;
                description6 = (String) c00012.L$3;
                Map infoMap5 = (Map) c00012.L$2;
                String url19 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result2);
                url9 = url19;
                objNewMovieLoadResponse = $result2;
                infoMap3 = infoMap5;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:6:0x0023  */
    public static final Unit load$lambda$3$1$1(Integer $epnum, String $epText, Episode $this$newEpisode) {
        String str;
        $this$newEpisode.setEpisode($epnum);
        if ($epnum != null) {
            int it = $epnum.intValue();
            str = "Episode " + it;
            if (str == null) {
                str = $epText;
            }
        } else {
            str = $epText;
        }
        $this$newEpisode.setName(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:6:0x0023  */
    public static final Unit load$lambda$3$3$1(Integer $epnum, String $epText, Episode $this$newEpisode) {
        String str;
        $this$newEpisode.setEpisode($epnum);
        if ($epnum != null) {
            int it = $epnum.intValue();
            str = "Episode " + it;
            if (str == null) {
                str = $epText;
            }
        } else {
            str = $epText;
        }
        $this$newEpisode.setName(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.animedubhindi.Animedubhindi$load$2 */
    /* JADX INFO: compiled from: Animedubhindi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animedubhindi.Animedubhindi$load$2", f = "Animedubhindi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00022 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $backgroundposter;
        final /* synthetic */ String $contentRating;
        final /* synthetic */ String $description;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ String $rating;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(String str, List<String> list, String str2, String str3, String str4, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$backgroundposter = str;
            this.$genres = list;
            this.$rating = str2;
            this.$contentRating = str3;
            this.$description = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$backgroundposter, this.$genres, this.$rating, this.$contentRating, this.$description, continuation);
            c00022.L$0 = obj;
            return c00022;
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
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$backgroundposter);
                    $this$newTvSeriesLoadResponse.setTags(this.$genres);
                    $this$newTvSeriesLoadResponse.setScore(Score.Companion.from10(this.$rating));
                    $this$newTvSeriesLoadResponse.setContentRating(this.$contentRating);
                    $this$newTvSeriesLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.animedubhindi.Animedubhindi$load$3 */
    /* JADX INFO: compiled from: Animedubhindi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animedubhindi.Animedubhindi$load$3", f = "Animedubhindi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00033 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $backgroundposter;
        final /* synthetic */ String $contentRating;
        final /* synthetic */ String $description;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ String $rating;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00033(String str, List<String> list, String str2, String str3, String str4, Continuation<? super C00033> continuation) {
            super(2, continuation);
            this.$backgroundposter = str;
            this.$genres = list;
            this.$rating = str2;
            this.$contentRating = str3;
            this.$description = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00033 = new C00033(this.$backgroundposter, this.$genres, this.$rating, this.$contentRating, this.$description, continuation);
            c00033.L$0 = obj;
            return c00033;
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
                    $this$newMovieLoadResponse.setPosterUrl(this.$backgroundposter);
                    $this$newMovieLoadResponse.setTags(this.$genres);
                    $this$newMovieLoadResponse.setScore(Score.Companion.from10(this.$rating));
                    $this$newMovieLoadResponse.setContentRating(this.$contentRating);
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00041 c00041;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
        boolean z;
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
                Log.d("Phisher", AppUtils.INSTANCE.toJson(data));
                AppUtils appUtils = AppUtils.INSTANCE;
                if (data == null) {
                    obj2 = null;
                } else {
                    try {
                        Result.Companion companion = Result.Companion;
                        try {
                            KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)))));
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                            break;
                        } catch (Throwable th) {
                            th = th;
                            try {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            } catch (Exception e) {
                                obj2 = null;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (Result.exceptionOrNull-impl(obj) != null) {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                        } catch (Throwable th3) {
                            Result.Companion companion4 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th3));
                        }
                    }
                    DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj) ? null : obj);
                    if (deserializationStrategy != null) {
                        try {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                        } catch (SerializationException e2) {
                            ArchComponentExtKt.logError(e2);
                            ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv.readValue(data, new TypeReference<List<? extends Map<String, ? extends String>>>() { // from class: com.animedubhindi.Animedubhindi$loadLinks$$inlined$tryParseJson$1
                            });
                        } catch (Throwable th4) {
                            ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(data, new TypeReference<List<? extends Map<String, ? extends String>>>() { // from class: com.animedubhindi.Animedubhindi$loadLinks$$inlined$tryParseJson$1
                            });
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(data, new TypeReference<List<? extends Map<String, ? extends String>>>() { // from class: com.animedubhindi.Animedubhindi$loadLinks$$inlined$tryParseJson$1
                        });
                    }
                    obj2 = objDecodeFromString;
                }
                List links = (List) obj2;
                if (links == null) {
                    return Boxing.boxBoolean(false);
                }
                C00052 c00052 = new C00052(function1, function2, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(links);
                c00042.Z$0 = isCasting;
                z = true;
                c00042.label = 1;
                if (ParCollectionsKt.amap(links, c00052, c00042) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean z2 = c00042.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: renamed from: com.animedubhindi.Animedubhindi$loadLinks$2 */
    /* JADX INFO: compiled from: Animedubhindi.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "item", "", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animedubhindi.Animedubhindi$loadLinks$2", f = "Animedubhindi.kt", i = {0, 0}, l = {206}, m = "invokeSuspend", n = {"item", "url"}, nl = {208}, s = {"L$0", "L$1"}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<Map<String, ? extends String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = new C00052(this.$subtitleCallback, this.$callback, continuation);
            c00052.L$0 = obj;
            return c00052;
        }

        public final Object invoke(Map<String, String> map, Continuation<? super Unit> continuation) {
            return create(map, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Map item = (Map) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String url = (String) item.get("url");
                    if (url == null) {
                        return Unit.INSTANCE;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(item);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    this.label = 1;
                    if (ExtractorApiKt.loadExtractor(url, url, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
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
