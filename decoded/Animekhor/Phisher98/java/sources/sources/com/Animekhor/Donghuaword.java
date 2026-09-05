package com.Animekhor;

import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Donghuaword.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Animekhor/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000e2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020!0\u001fH\u0096@¢\u0006\u0002\u0010$R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/Animekhor/Donghuaword;", "Lcom/Animekhor/Animekhor;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Animekhor"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Donghuaword extends Animekhor {

    @NotNull
    private String mainUrl = "https://donghuaworld.com";

    @NotNull
    private String name = "Donghuaword";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "zh";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime});

    /* JADX INFO: renamed from: com.Animekhor.Donghuaword$loadLinks$1 */
    /* JADX INFO: compiled from: Donghuaword.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animekhor.Donghuaword", f = "Donghuaword.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {21, 22}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "isCasting"}, nl = {22, 31}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Donghuaword.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    @Override // com.Animekhor.Animekhor
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.Animekhor.Animekhor
    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @Override // com.Animekhor.Animekhor
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.Animekhor.Animekhor
    public void setName(@NotNull String str) {
        this.name = str;
    }

    @Override // com.Animekhor.Animekhor
    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @Override // com.Animekhor.Animekhor
    @NotNull
    public String getLang() {
        return this.lang;
    }

    @Override // com.Animekhor.Animekhor
    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    @Override // com.Animekhor.Animekhor
    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @Override // com.Animekhor.Animekhor
    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00fb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // com.Animekhor.Animekhor
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00071 c00071;
        Object obj;
        boolean z;
        C00071 c00072;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        List listSelect;
        C00082 c00082;
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
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00071.L$1 = function1;
                c00071.L$2 = function2;
                c00071.Z$0 = isCasting;
                c00071.label = 1;
                C00071 c00073 = c00071;
                obj = coroutine_suspended;
                z = true;
                $result = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00073, 4094, (Object) null);
                c00072 = c00073;
                if ($result == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                Document document = ((NiceResponse) $result).getDocument();
                listSelect = document.select("div.server-item a");
                c00082 = new C00082(function3, function4, null);
                c00072.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00072.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00072.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00072.L$3 = SpillingKt.nullOutSpilledVariable(document);
                c00072.Z$0 = isCasting2;
                c00072.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00082, c00072) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00071.Z$0;
                function4 = (Function1) c00071.L$2;
                function3 = (Function1) c00071.L$1;
                data2 = (String) c00071.L$0;
                ResultKt.throwOnFailure($result);
                c00072 = c00071;
                obj = coroutine_suspended;
                z = true;
                Document document2 = ((NiceResponse) $result).getDocument();
                listSelect = document2.select("div.server-item a");
                c00082 = new C00082(function3, function4, null);
                c00072.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00072.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00072.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00072.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                c00072.Z$0 = isCasting2;
                c00072.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00082, c00072) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00071.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Animekhor.Donghuaword$loadLinks$2 */
    /* JADX INFO: compiled from: Donghuaword.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animekhor.Donghuaword$loadLinks$2", f = "Donghuaword.kt", i = {0, 0, 0, 0, 0, 0}, l = {28}, m = "invokeSuspend", n = {"it", "base64", "decodedUrl", "regex", "matchResult", "url"}, nl = {-1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00082 extends SuspendLambda implements Function2<Element, Continuation<? super Boolean>, Object> {
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
        C00082(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00082> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00082 = Donghuaword.this.new C00082(this.$subtitleCallback, this.$callback, continuation);
            c00082.L$0 = obj;
            return c00082;
        }

        public final Object invoke(Element element, Continuation<? super Boolean> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String url;
            MatchGroupCollection groups;
            MatchGroup matchGroup;
            Element it = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String base64 = it.attr("data-hash");
                    String decodedUrl = MainAPIKt.base64Decode(base64);
                    Regex regex = new Regex("src=[\"']([^\"']+)[\"']", RegexOption.IGNORE_CASE);
                    MatchResult matchResult = Regex.find$default(regex, decodedUrl, 0, 2, (Object) null);
                    if (matchResult == null || (groups = matchResult.getGroups()) == null || (matchGroup = groups.get(1)) == null || (url = matchGroup.getValue()) == null) {
                        url = "Not found";
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(base64);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(decodedUrl);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(regex);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(matchResult);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(url);
                    this.label = 1;
                    Object objLoadExtractor = ExtractorApiKt.loadExtractor(url, Donghuaword.this.getMainUrl(), this.$subtitleCallback, this.$callback, (Continuation) this);
                    return objLoadExtractor == coroutine_suspended ? coroutine_suspended : objLoadExtractor;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
