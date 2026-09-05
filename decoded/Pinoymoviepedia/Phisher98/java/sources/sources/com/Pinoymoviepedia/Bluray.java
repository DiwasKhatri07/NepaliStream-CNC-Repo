package com.Pinoymoviepedia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Bluray7.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Pinoymoviepedia/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0015JF\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00172\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001d0\u001bH\u0096@¢\u0006\u0002\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/Pinoymoviepedia/Bluray;", "Lcom/Pinoymoviepedia/Pinoymoviepedia;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LinkData", "ResponseHash", "Pinoymoviepedia"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBluray7.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Bluray7.kt\ncom/Pinoymoviepedia/Bluray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 6 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,96:1\n1739#2:97\n1814#2,3:98\n93#3,2:101\n63#3:103\n64#3,15:105\n95#3,2:122\n1#4:104\n50#5:120\n43#5:121\n68#6:124\n*S KotlinDebug\n*F\n+ 1 Bluray7.kt\ncom/Pinoymoviepedia/Bluray\n*L\n47#1:97\n47#1:98,3\n70#1:101,2\n70#1:103\n70#1:105,15\n70#1:122,2\n70#1:104\n70#1:120\n70#1:121\n76#1:124\n*E\n"})
public final class Bluray extends Pinoymoviepedia {

    @NotNull
    private String mainUrl = "https://bluray7.com";

    @NotNull
    private String name = "Bluray7";

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("trending", "Trending"), TuplesKt.to("movies", "Movies"), TuplesKt.to("genre/action", "Action"), TuplesKt.to("genre/comedy", "Comedy"), TuplesKt.to("genre/drama", "Drama"), TuplesKt.to("genre/romance", "Romance"), TuplesKt.to("genre/thriller", "Thriller"), TuplesKt.to("genre/adventure", "Adventure"), TuplesKt.to("genre/horror", "Horror"), TuplesKt.to("genre/war", "War"), TuplesKt.to("genre/science-fiction", "Science Fiction")});

    /* JADX INFO: renamed from: com.Pinoymoviepedia.Bluray$load$1 */
    /* JADX INFO: compiled from: Bluray7.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pinoymoviepedia.Bluray", f = "Bluray7.kt", i = {0, 1, 1, 1, 1, 1, 1, 1}, l = {36, 58}, m = "load", n = {"url", "url", "request", "document", "title", "posterUrl", "description", "episodes"}, nl = {37, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Bluray.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Pinoymoviepedia.Bluray$loadLinks$1 */
    /* JADX INFO: compiled from: Bluray7.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pinoymoviepedia.Bluray", f = "Bluray7.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {72, 77}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "loadData", "isCasting", "data", "subtitleCallback", "callback", "loadData", "source", "isCasting"}, nl = {76, 83}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Bluray.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    @Override // com.Pinoymoviepedia.Pinoymoviepedia
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.Pinoymoviepedia.Pinoymoviepedia
    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @Override // com.Pinoymoviepedia.Pinoymoviepedia
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.Pinoymoviepedia.Pinoymoviepedia
    public void setName(@NotNull String str) {
        this.name = str;
    }

    @Override // com.Pinoymoviepedia.Pinoymoviepedia
    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // com.Pinoymoviepedia.Pinoymoviepedia
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00001 c00001;
        boolean z;
        Object obj;
        Object obj2;
        String url2;
        String strText;
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
                Requests app = MainActivityKt.getApp();
                c00002.L$0 = url;
                c00002.label = 1;
                z = true;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                c00002 = c00002;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                break;
                break;
            case 1:
                String url3 = (String) c00002.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                url2 = url3;
                z = true;
                obj2 = $result;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse request = (NiceResponse) obj2;
        Document document = request.getDocument();
        Element elementSelectFirst = document.selectFirst("div.data > h1");
        String title = String.valueOf((elementSelectFirst == null || (strText = elementSelectFirst.text()) == null) ? null : StringsKt.trim(strText).toString());
        Ref.ObjectRef posterUrl = new Ref.ObjectRef();
        Bluray bluray = this;
        Element elementSelectFirst2 = document.selectFirst("meta[property=og:image]");
        posterUrl.element = MainAPIKt.fixUrlNull(bluray, elementSelectFirst2 != null ? elementSelectFirst2.attr("content") : null);
        CharSequence charSequence = (CharSequence) posterUrl.element;
        if (charSequence != null && charSequence.length() != 0) {
            z = false;
        }
        if (z) {
            posterUrl.element = MainAPIKt.fixUrlNull(this, document.select("div.poster img").attr("src"));
        }
        String description = StringsKt.trim(document.select("div.wp-content > p").text()).toString();
        Iterable $this$map$iv = document.select("ul#playeroptionsul > li");
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it = (Element) item$iv$iv;
            Element elementSelectFirst3 = it.selectFirst("span.title");
            final String name = elementSelectFirst3 != null ? elementSelectFirst3.text() : null;
            Object $result2 = $result;
            String type = it.attr("data-type");
            String title2 = title;
            String post = it.attr("data-post");
            String url4 = url2;
            String nume = it.attr("data-nume");
            destination$iv$iv.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(new LinkData(type, post, nume)), new Function1() { // from class: com.Pinoymoviepedia.Bluray$$ExternalSyntheticLambda0
                public final Object invoke(Object obj3) {
                    return Bluray.load$lambda$0$0(name, (Episode) obj3);
                }
            }));
            $result = $result2;
            title = title2;
            url2 = url4;
            $this$map$iv = $this$map$iv;
            $i$f$map = $i$f$map;
        }
        String title3 = title;
        List episodes = (List) destination$iv$iv;
        TvType tvType = TvType.TvSeries;
        C00012 c00012 = new C00012(posterUrl, description, null);
        c00002.L$0 = SpillingKt.nullOutSpilledVariable(url2);
        c00002.L$1 = SpillingKt.nullOutSpilledVariable(request);
        c00002.L$2 = SpillingKt.nullOutSpilledVariable(document);
        c00002.L$3 = SpillingKt.nullOutSpilledVariable(title3);
        c00002.L$4 = SpillingKt.nullOutSpilledVariable(posterUrl);
        c00002.L$5 = SpillingKt.nullOutSpilledVariable(description);
        c00002.L$6 = SpillingKt.nullOutSpilledVariable(episodes);
        c00002.label = 2;
        Object objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title3, url2, tvType, episodes, c00012, c00002);
        return objNewTvSeriesLoadResponse == obj ? obj : objNewTvSeriesLoadResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$0$0(String $name, Episode $this$newEpisode) {
        $this$newEpisode.setName($name);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Pinoymoviepedia.Bluray$load$2 */
    /* JADX INFO: compiled from: Bluray7.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pinoymoviepedia.Bluray$load$2", f = "Bluray7.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00012 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ Ref.ObjectRef<String> $posterUrl;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00012(Ref.ObjectRef<String> objectRef, String str, Continuation<? super C00012> continuation) {
            super(2, continuation);
            this.$posterUrl = objectRef;
            this.$description = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00012 = new C00012(this.$posterUrl, this.$description, continuation);
            c00012.L$0 = obj;
            return c00012;
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
                    $this$newTvSeriesLoadResponse.setPosterUrl((String) this.$posterUrl.element);
                    $this$newTvSeriesLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:51:0x0109 A[Catch: Exception -> 0x0123, TRY_LEAVE, TryCatch #6 {Exception -> 0x0123, blocks: (B:39:0x00e7, B:42:0x00ee, B:51:0x0109, B:50:0x0103, B:38:0x00dd, B:45:0x00f4), top: B:90:0x00dd, inners: #8 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0163  */
    /* JADX WARN: Code duplicated, block: B:63:0x0168  */
    /* JADX WARN: Code duplicated, block: B:66:0x0177  */
    /* JADX WARN: Code duplicated, block: B:67:0x017c  */
    /* JADX WARN: Code duplicated, block: B:70:0x0211 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:71:0x0212  */
    /* JADX WARN: Code duplicated, block: B:74:0x024d  */
    /* JADX WARN: Code duplicated, block: B:76:0x0277 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:77:0x0278  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.Pinoymoviepedia.Pinoymoviepedia
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00021 c00021;
        Bluray bluray;
        char c;
        char c2;
        Object obj;
        Object objDecodeFromString;
        DeserializationStrategy deserializationStrategy;
        LinkData loadData;
        String post;
        String nume;
        boolean z;
        Object obj2;
        boolean z2;
        String data2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        LinkData loadData2;
        boolean isCasting2;
        String source;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        String data3;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
                bluray = this;
            } else {
                bluray = this;
                c00021 = bluray.new C00021(continuation);
            }
        } else {
            bluray = this;
            c00021 = bluray.new C00021(continuation);
        }
        C00021 c00022 = c00021;
        Object $result = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                if (data != null) {
                    try {
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(LinkData.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            c = 0;
                            c2 = 1;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                c = 0;
                                try {
                                    c2 = 1;
                                    try {
                                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LinkData.class), (List) null, 2, (Object) null));
                                        break;
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
                                    c2 = 1;
                                    Result.Companion companion5 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                    if (Result.isFailure-impl(obj)) {
                                        obj = null;
                                    }
                                    deserializationStrategy = (KSerializer) obj;
                                    if (deserializationStrategy != null) {
                                        try {
                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                                        } catch (SerializationException e2) {
                                            ArchComponentExtKt.logError(e2);
                                            ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv$iv.readValue(data, new TypeReference<LinkData>() { // from class: com.Pinoymoviepedia.Bluray$loadLinks$$inlined$tryParseJson$1
                                            });
                                        } catch (Throwable th4) {
                                            ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(data, new TypeReference<LinkData>() { // from class: com.Pinoymoviepedia.Bluray$loadLinks$$inlined$tryParseJson$1
                                            });
                                        }
                                        break;
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(data, new TypeReference<LinkData>() { // from class: com.Pinoymoviepedia.Bluray$loadLinks$$inlined$tryParseJson$1
                                        });
                                    }
                                    loadData = (LinkData) objDecodeFromString;
                                    Log.INSTANCE.d("Phisher", String.valueOf(loadData));
                                    Requests app = MainActivityKt.getApp();
                                    String str = bluray.getMainUrl() + "/wp-admin/admin-ajax.php";
                                    Pair[] pairArr = new Pair[4];
                                    pairArr[c] = TuplesKt.to("action", "doo_player_ajax");
                                    if (loadData != null) {
                                        post = loadData.getPost();
                                    } else {
                                        post = null;
                                    }
                                    pairArr[c2] = TuplesKt.to("post", String.valueOf(post));
                                    if (loadData != null) {
                                        nume = loadData.getNume();
                                    } else {
                                        nume = null;
                                    }
                                    pairArr[2] = TuplesKt.to("nume", String.valueOf(nume));
                                    pairArr[3] = TuplesKt.to("type", "movie");
                                    Map mapMapOf = MapsKt.mapOf(pairArr);
                                    Pair[] pairArr2 = new Pair[2];
                                    pairArr2[c] = TuplesKt.to("Accept", "*/*");
                                    pairArr2[c2] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                                    Map mapMapOf2 = MapsKt.mapOf(pairArr2);
                                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(data);
                                    c00022.L$1 = function1;
                                    c00022.L$2 = function2;
                                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(loadData);
                                    c00022.Z$0 = isCasting;
                                    c00022.label = 1;
                                    z = true;
                                    obj2 = coroutine_suspended;
                                    z2 = false;
                                    $result = Requests.post$default(app, str, mapMapOf2, (String) null, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65500, (Object) null);
                                    c00022 = c00022;
                                    if ($result == obj2) {
                                        return obj2;
                                    }
                                    data2 = data;
                                    function3 = function1;
                                    function4 = function2;
                                    loadData2 = loadData;
                                    isCasting2 = isCasting;
                                    NiceResponse this_$iv = (NiceResponse) $result;
                                    ResponseParser parser = this_$iv.getParser();
                                    Intrinsics.checkNotNull(parser);
                                    source = ((ResponseHash) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(ResponseHash.class))).getEmbed_url();
                                    if (!StringsKt.contains$default(source, "youtube", z2, 2, (Object) null)) {
                                        c00022.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(loadData2);
                                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(source);
                                        c00022.Z$0 = isCasting2;
                                        c00022.label = 2;
                                        if (ExtractorApiKt.loadExtractor(source, "", function3, function4, c00022) == obj2) {
                                            return obj2;
                                        }
                                        function5 = function4;
                                        function6 = function3;
                                        data3 = data2;
                                    }
                                    return Boxing.boxBoolean(z);
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                c = 0;
                            }
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(data, new TypeReference<LinkData>() { // from class: com.Pinoymoviepedia.Bluray$loadLinks$$inlined$tryParseJson$1
                            });
                        }
                    } catch (Exception e3) {
                        c = 0;
                        c2 = 1;
                        objDecodeFromString = null;
                        loadData = (LinkData) objDecodeFromString;
                        Log.INSTANCE.d("Phisher", String.valueOf(loadData));
                        Requests app2 = MainActivityKt.getApp();
                        String str2 = bluray.getMainUrl() + "/wp-admin/admin-ajax.php";
                        Pair[] pairArr3 = new Pair[4];
                        pairArr3[c] = TuplesKt.to("action", "doo_player_ajax");
                        if (loadData != null) {
                            post = loadData.getPost();
                        } else {
                            post = null;
                        }
                        pairArr3[c2] = TuplesKt.to("post", String.valueOf(post));
                        if (loadData != null) {
                            nume = loadData.getNume();
                        } else {
                            nume = null;
                        }
                        pairArr3[2] = TuplesKt.to("nume", String.valueOf(nume));
                        pairArr3[3] = TuplesKt.to("type", "movie");
                        Map mapMapOf3 = MapsKt.mapOf(pairArr3);
                        Pair[] pairArr4 = new Pair[2];
                        pairArr4[c] = TuplesKt.to("Accept", "*/*");
                        pairArr4[c2] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                        Map mapMapOf4 = MapsKt.mapOf(pairArr4);
                        c00022.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        c00022.L$1 = function1;
                        c00022.L$2 = function2;
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(loadData);
                        c00022.Z$0 = isCasting;
                        c00022.label = 1;
                        z = true;
                        obj2 = coroutine_suspended;
                        z2 = false;
                        $result = Requests.post$default(app2, str2, mapMapOf4, (String) null, (Map) null, (Map) null, mapMapOf3, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65500, (Object) null);
                        c00022 = c00022;
                        if ($result == obj2) {
                            return obj2;
                        }
                        data2 = data;
                        function3 = function1;
                        function4 = function2;
                        loadData2 = loadData;
                        isCasting2 = isCasting;
                        NiceResponse this_$iv2 = (NiceResponse) $result;
                        ResponseParser parser2 = this_$iv2.getParser();
                        Intrinsics.checkNotNull(parser2);
                        source = ((ResponseHash) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(ResponseHash.class))).getEmbed_url();
                        if (!StringsKt.contains$default(source, "youtube", z2, 2, (Object) null)) {
                            c00022.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(loadData2);
                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(source);
                            c00022.Z$0 = isCasting2;
                            c00022.label = 2;
                            if (ExtractorApiKt.loadExtractor(source, "", function3, function4, c00022) == obj2) {
                                return obj2;
                            }
                            function5 = function4;
                            function6 = function3;
                            data3 = data2;
                        }
                        return Boxing.boxBoolean(z);
                    }
                    break;
                } else {
                    objDecodeFromString = null;
                    c = 0;
                    c2 = 1;
                }
                loadData = (LinkData) objDecodeFromString;
                Log.INSTANCE.d("Phisher", String.valueOf(loadData));
                Requests app3 = MainActivityKt.getApp();
                String str3 = bluray.getMainUrl() + "/wp-admin/admin-ajax.php";
                Pair[] pairArr5 = new Pair[4];
                pairArr5[c] = TuplesKt.to("action", "doo_player_ajax");
                if (loadData != null) {
                    post = loadData.getPost();
                } else {
                    post = null;
                }
                pairArr5[c2] = TuplesKt.to("post", String.valueOf(post));
                if (loadData != null) {
                    nume = loadData.getNume();
                } else {
                    nume = null;
                }
                pairArr5[2] = TuplesKt.to("nume", String.valueOf(nume));
                pairArr5[3] = TuplesKt.to("type", "movie");
                Map mapMapOf5 = MapsKt.mapOf(pairArr5);
                Pair[] pairArr6 = new Pair[2];
                pairArr6[c] = TuplesKt.to("Accept", "*/*");
                pairArr6[c2] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                Map mapMapOf6 = MapsKt.mapOf(pairArr6);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00022.L$1 = function1;
                c00022.L$2 = function2;
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(loadData);
                c00022.Z$0 = isCasting;
                c00022.label = 1;
                z = true;
                obj2 = coroutine_suspended;
                z2 = false;
                $result = Requests.post$default(app3, str3, mapMapOf6, (String) null, (Map) null, (Map) null, mapMapOf5, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65500, (Object) null);
                c00022 = c00022;
                if ($result == obj2) {
                    return obj2;
                }
                data2 = data;
                function3 = function1;
                function4 = function2;
                loadData2 = loadData;
                isCasting2 = isCasting;
                NiceResponse this_$iv3 = (NiceResponse) $result;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                source = ((ResponseHash) parser3.parse(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(ResponseHash.class))).getEmbed_url();
                if (!StringsKt.contains$default(source, "youtube", z2, 2, (Object) null)) {
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(loadData2);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(source);
                    c00022.Z$0 = isCasting2;
                    c00022.label = 2;
                    if (ExtractorApiKt.loadExtractor(source, "", function3, function4, c00022) == obj2) {
                        return obj2;
                    }
                    function5 = function4;
                    function6 = function3;
                    data3 = data2;
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00022.Z$0;
                LinkData loadData3 = (LinkData) c00022.L$3;
                function4 = (Function1) c00022.L$2;
                function3 = (Function1) c00022.L$1;
                data2 = (String) c00022.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = coroutine_suspended;
                loadData2 = loadData3;
                z2 = false;
                z = true;
                NiceResponse this_$iv4 = (NiceResponse) $result;
                ResponseParser parser4 = this_$iv4.getParser();
                Intrinsics.checkNotNull(parser4);
                source = ((ResponseHash) parser4.parse(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(ResponseHash.class))).getEmbed_url();
                if (!StringsKt.contains$default(source, "youtube", z2, 2, (Object) null)) {
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(loadData2);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(source);
                    c00022.Z$0 = isCasting2;
                    c00022.label = 2;
                    if (ExtractorApiKt.loadExtractor(source, "", function3, function4, c00022) == obj2) {
                        return obj2;
                    }
                    function5 = function4;
                    function6 = function3;
                    data3 = data2;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z3 = c00022.Z$0;
                function5 = (Function1) c00022.L$2;
                function6 = (Function1) c00022.L$1;
                data3 = (String) c00022.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Bluray7.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/Pinoymoviepedia/Bluray$LinkData;", "", "type", "", "post", "nume", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getPost", "getNume", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Pinoymoviepedia"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LinkData {

        @Nullable
        private final String nume;

        @Nullable
        private final String post;

        @Nullable
        private final String type;

        public LinkData() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ LinkData copy$default(LinkData linkData, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = linkData.type;
            }
            if ((i & 2) != 0) {
                str2 = linkData.post;
            }
            if ((i & 4) != 0) {
                str3 = linkData.nume;
            }
            return linkData.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPost() {
            return this.post;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getNume() {
            return this.nume;
        }

        @NotNull
        public final LinkData copy(@Nullable String type, @Nullable String post, @Nullable String nume) {
            return new LinkData(type, post, nume);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkData)) {
                return false;
            }
            LinkData linkData = (LinkData) other;
            return Intrinsics.areEqual(this.type, linkData.type) && Intrinsics.areEqual(this.post, linkData.post) && Intrinsics.areEqual(this.nume, linkData.nume);
        }

        public int hashCode() {
            return ((((this.type == null ? 0 : this.type.hashCode()) * 31) + (this.post == null ? 0 : this.post.hashCode())) * 31) + (this.nume != null ? this.nume.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "LinkData(type=" + this.type + ", post=" + this.post + ", nume=" + this.nume + ')';
        }

        public LinkData(@Nullable String type, @Nullable String post, @Nullable String nume) {
            this.type = type;
            this.post = post;
            this.nume = nume;
        }

        public /* synthetic */ LinkData(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getPost() {
            return this.post;
        }

        @Nullable
        public final String getNume() {
            return this.nume;
        }
    }

    /* JADX INFO: compiled from: Bluray7.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J;\u0010\u000e\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/Pinoymoviepedia/Bluray$ResponseHash;", "", "embed_url", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmbed_url", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Pinoymoviepedia"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ResponseHash {

        @NotNull
        private final String embed_url;

        @Nullable
        private final String type;

        public static /* synthetic */ ResponseHash copy$default(ResponseHash responseHash, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = responseHash.embed_url;
            }
            if ((i & 2) != 0) {
                str2 = responseHash.type;
            }
            return responseHash.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEmbed_url() {
            return this.embed_url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final ResponseHash copy(@JsonProperty("embed_url") @NotNull String embed_url, @JsonProperty("type") @Nullable String type) {
            return new ResponseHash(embed_url, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResponseHash)) {
                return false;
            }
            ResponseHash responseHash = (ResponseHash) other;
            return Intrinsics.areEqual(this.embed_url, responseHash.embed_url) && Intrinsics.areEqual(this.type, responseHash.type);
        }

        public int hashCode() {
            return (this.embed_url.hashCode() * 31) + (this.type == null ? 0 : this.type.hashCode());
        }

        @NotNull
        public String toString() {
            return "ResponseHash(embed_url=" + this.embed_url + ", type=" + this.type + ')';
        }

        public ResponseHash(@JsonProperty("embed_url") @NotNull String embed_url, @JsonProperty("type") @Nullable String type) {
            this.embed_url = embed_url;
            this.type = type;
        }

        @NotNull
        public final String getEmbed_url() {
            return this.embed_url;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }
    }
}
