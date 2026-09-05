package com.PublicSportsIPTV;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LiveSearchResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
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
import kotlin.Result;
import kotlin.ResultKt;
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

/* JADX INFO: compiled from: PublicSportsIPTV.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/PublicSportsIPTV/classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u001fJ\f\u0010 \u001a\u00020!*\u00020\"H\u0002J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010&JF\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u000e2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020-0+H\u0096@¢\u0006\u0002\u00100R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u00062"}, d2 = {"Lcom/PublicSportsIPTV/PublicSportsIPTV;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/PublicSportsIPTV/Match;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "PublicSportsIPTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPublicSportsIPTV.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PublicSportsIPTV.kt\ncom/PublicSportsIPTV/PublicSportsIPTV\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,102:1\n68#2:103\n777#3:104\n873#3,2:105\n777#3:107\n873#3,2:108\n1739#3:110\n1814#3,3:111\n1739#3:114\n1814#3,3:115\n2077#3,3:164\n93#4,2:118\n63#4:120\n64#4,15:122\n95#4,2:139\n93#4,2:141\n63#4:143\n64#4,15:145\n95#4,2:162\n1#5:121\n1#5:144\n50#6:137\n43#6:138\n50#6:160\n43#6:161\n*S KotlinDebug\n*F\n+ 1 PublicSportsIPTV.kt\ncom/PublicSportsIPTV/PublicSportsIPTV\n*L\n24#1:103\n27#1:104\n27#1:105,2\n31#1:107\n31#1:108,2\n35#1:110\n35#1:111,3\n36#1:114\n36#1:115,3\n84#1:164,3\n57#1:118,2\n57#1:120\n57#1:122,15\n57#1:139,2\n74#1:141,2\n74#1:143\n74#1:145,15\n74#1:162,2\n57#1:121\n74#1:144\n57#1:137\n57#1:138\n74#1:160\n74#1:161\n*E\n"})
public final class PublicSportsIPTV extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String Referer = MainAPIKt.base64Decode("aHR0cHM6Ly9mYW5jb2RlLmNvbS8=");

    @NotNull
    private static final String User_Agent = "ReactNativeVideo/8.0.0 (Linux;Android/13) AndroidXMedia3/1.1.1";

    @NotNull
    private String mainUrl = "https://raw.githubusercontent.com/Jitendra-unatti/fancode/refs/heads/main/data/fancode.json";

    @NotNull
    private String name = "PublicSportsIPTV";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Live);

    /* JADX INFO: renamed from: com.PublicSportsIPTV.PublicSportsIPTV$getMainPage$1 */
    /* JADX INFO: compiled from: PublicSportsIPTV.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.PublicSportsIPTV.PublicSportsIPTV", f = "PublicSportsIPTV.kt", i = {0, 0}, l = {24}, m = "getMainPage", n = {"request", "page"}, nl = {103}, s = {"L$0", "I$0"}, v = 2)
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
            return PublicSportsIPTV.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.PublicSportsIPTV.PublicSportsIPTV$loadLinks$1 */
    /* JADX INFO: compiled from: PublicSportsIPTV.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.PublicSportsIPTV.PublicSportsIPTV", f = "PublicSportsIPTV.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {87}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "parsed", "urls", "$this$forEachIndexed$iv", "item$iv", "url", "isCasting", "index$iv", "index"}, nl = {86}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "Z$0", "I$0", "I$1"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return PublicSportsIPTV.this.loadLinks(null, false, null, null, (Continuation) this);
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

    /* JADX INFO: compiled from: PublicSportsIPTV.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/PublicSportsIPTV/PublicSportsIPTV$Companion;", "", "<init>", "()V", "User_Agent", "", "Referer", "getReferer", "()Ljava/lang/String;", "PublicSportsIPTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final String getReferer() {
            return PublicSportsIPTV.Referer;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        ?? r1;
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
                String mainUrl = getMainUrl();
                c00001.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00001.I$0 = page;
                c00001.label = 1;
                r1 = 1;
                $result = Requests.get$default(app, mainUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00001.I$0;
                ResultKt.throwOnFailure($result);
                r1 = 1;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        ResponseParser parser = this_$iv.getParser();
        Intrinsics.checkNotNull(parser);
        Root data = (Root) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Root.class));
        Iterable matches = data.getMatches();
        Iterable $this$filter$iv = matches;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Match it = (Match) element$iv$iv;
            Root data2 = data;
            if (StringsKt.contains(StringsKt.trim(it.getStatus()).toString(), "LIVE", (boolean) r1)) {
                destination$iv$iv.add(element$iv$iv);
            }
            data = data2;
        }
        List live = (List) destination$iv$iv;
        Iterable $this$filter$iv2 = matches;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv2) {
            Match it2 = (Match) element$iv$iv2;
            List live2 = live;
            if (StringsKt.contains(StringsKt.trim(it2.getStatus()).toString(), "NOT_STARTED", (boolean) r1)) {
                destination$iv$iv2.add(element$iv$iv2);
            }
            live = live2;
        }
        List live3 = live;
        Iterable upcoming = (List) destination$iv$iv2;
        List $this$map$iv = live3;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Match it3 = (Match) item$iv$iv;
            destination$iv$iv3.add(toSearchResult(it3));
        }
        List liveList = (List) destination$iv$iv3;
        Iterable $this$map$iv2 = upcoming;
        Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            Match it4 = (Match) item$iv$iv2;
            destination$iv$iv4.add(toSearchResult(it4));
        }
        List upcomingList = (List) destination$iv$iv4;
        HomePageList[] homePageListArr = new HomePageList[2];
        homePageListArr[0] = new HomePageList("Live Now", liveList, (boolean) r1);
        homePageListArr[r1] = new HomePageList("Upcoming", upcomingList, (boolean) r1);
        return MainAPIKt.newHomePageResponse(CollectionsKt.listOf(homePageListArr), Boxing.boxBoolean(false));
    }

    private final SearchResponse toSearchResult(Match $this$toSearchResult) {
        String title = $this$toSearchResult.getTitle();
        LoadURL href = new LoadURL($this$toSearchResult.getStreamingCdn().getPrimaryPlaybackUrl(), $this$toSearchResult.getStreamingCdn().getFancodeCdn(), $this$toSearchResult.getStreamingCdn().getDaiGoogleCdn(), $this$toSearchResult.getStreamingCdn().getCloudfrontCdn(), $this$toSearchResult.getTitle(), $this$toSearchResult.getTournament(), $this$toSearchResult.getImage());
        String cloudfare = $this$toSearchResult.getImageCdn().getCloudfare();
        if (cloudfare == null) {
            cloudfare = $this$toSearchResult.getImage();
        }
        final String posterUrl = cloudfare;
        return MainAPIKt.newLiveSearchResponse$default(this, title, AppUtils.INSTANCE.toJson(href), TvType.Live, false, new Function1() { // from class: com.PublicSportsIPTV.PublicSportsIPTV$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return PublicSportsIPTV.toSearchResult$lambda$0(posterUrl, (LiveSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0066  */
    /* JADX WARN: Code duplicated, block: B:29:0x0082 A[Catch: Exception -> 0x0098, TRY_LEAVE, TryCatch #3 {Exception -> 0x0098, blocks: (B:10:0x0032, B:17:0x0060, B:20:0x0067, B:29:0x0082, B:28:0x007c, B:16:0x0055, B:9:0x0028, B:13:0x0039, B:6:0x000f, B:23:0x006d), top: B:53:0x000f, inners: #0, #2, #5 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        Object objDecodeFromString;
        Object obj;
        DeserializationStrategy deserializationStrategy;
        String title;
        String poster;
        String description;
        AppUtils appUtils = AppUtils.INSTANCE;
        if (url == null) {
            objDecodeFromString = null;
        } else {
            try {
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(LoadURL.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadURL.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    deserializationStrategy = (KSerializer) obj;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, url);
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv.readValue(url, new TypeReference<LoadURL>() { // from class: com.PublicSportsIPTV.PublicSportsIPTV$load$$inlined$tryParseJson$1
                        });
                    }
                } else {
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    deserializationStrategy = (KSerializer) obj;
                    if (deserializationStrategy != null) {
                        try {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, url);
                        } catch (SerializationException e) {
                            ArchComponentExtKt.logError(e);
                            ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(url, new TypeReference<LoadURL>() { // from class: com.PublicSportsIPTV.PublicSportsIPTV$load$$inlined$tryParseJson$1
                            });
                        } catch (Throwable th3) {
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(url, new TypeReference<LoadURL>() { // from class: com.PublicSportsIPTV.PublicSportsIPTV$load$$inlined$tryParseJson$1
                            });
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(url, new TypeReference<LoadURL>() { // from class: com.PublicSportsIPTV.PublicSportsIPTV$load$$inlined$tryParseJson$1
                        });
                    }
                }
            } catch (Exception e2) {
                objDecodeFromString = null;
            }
        }
        LoadURL parsed = (LoadURL) objDecodeFromString;
        if (parsed == null || (title = parsed.getTitle()) == null) {
            title = "PublicSportsIPTV";
        }
        String title2 = title;
        if (parsed == null || (poster = parsed.getPoster()) == null) {
            poster = "https://www.fancode.com/skillup-uploads/fc-web/home-page-new-arc/hero-image/v1/hero-image-dweb-v4.png";
        }
        if (parsed == null || (description = parsed.getTournament()) == null) {
            description = "FanCode was founded in 2019 by Yannick Colaco and Prasana Krishnan. It is an over-the-top streaming service and sports e-commerce company in India. It is part of the Dream Sports group";
        }
        return MainAPIKt.newMovieLoadResponse(this, title2, url, TvType.Live, url, new C00012(poster, description, null), continuation);
    }

    /* JADX INFO: renamed from: com.PublicSportsIPTV.PublicSportsIPTV$load$2 */
    /* JADX INFO: compiled from: PublicSportsIPTV.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.PublicSportsIPTV.PublicSportsIPTV$load$2", f = "PublicSportsIPTV.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00012 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00012(String str, String str2, Continuation<? super C00012> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00012 = new C00012(this.$poster, this.$description, continuation);
            c00012.L$0 = obj;
            return c00012;
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
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:40:0x010b A[Catch: Exception -> 0x0121, TRY_LEAVE, TryCatch #3 {Exception -> 0x0121, blocks: (B:21:0x00ba, B:28:0x00e9, B:31:0x00f0, B:40:0x010b, B:39:0x0105, B:27:0x00de, B:20:0x00b0, B:24:0x00c1, B:17:0x0097, B:34:0x00f6), top: B:73:0x0097, inners: #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0186  */
    /* JADX WARN: Code duplicated, block: B:59:0x018e  */
    /* JADX WARN: Code duplicated, block: B:62:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:64:0x021f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x0220  */
    /* JADX WARN: Code duplicated, block: B:67:0x0243  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0220 -> B:66:0x0231). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0243 -> B:68:0x024c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r23, boolean r24, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r25, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r26, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r27) {
        /*
            Method dump skipped, instruction units count: 612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.PublicSportsIPTV.PublicSportsIPTV.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
