package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import io.ktor.http.CodecsKt;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AnimePahe/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/Kwik;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/phisher98/Kwik\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,260:1\n1#2:261\n*E\n"})
public final class Kwik extends ExtractorApi {

    @NotNull
    private final String name = "Kwik";

    @NotNull
    private final String mainUrl = "https://kwik.cx";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.Kwik$getUrl$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Kwik", f = "Utils.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {58, 75, 88}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "res", "title", "script", "unpacked", "m3u8", "fileName", "mp4Url", "url", "referer", "subtitleCallback", "callback", "res", "title", "script", "unpacked", "m3u8", "fileName", "mp4Url"}, nl = {60, 74, 87}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
    static final class C00121 extends ContinuationImpl {
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

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Kwik.this.getUrl(null, null, null, null, (Continuation) this);
        }
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x014e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0153  */
    /* JADX WARN: Code duplicated, block: B:25:0x0157  */
    /* JADX WARN: Code duplicated, block: B:27:0x015a  */
    /* JADX WARN: Code duplicated, block: B:33:0x0180  */
    /* JADX WARN: Code duplicated, block: B:36:0x023a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x023b  */
    /* JADX WARN: Code duplicated, block: B:40:0x02cd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00121 c00121;
        Object obj;
        int i;
        Object obj2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        NiceResponse res;
        String title;
        Element elementSelectFirst;
        String strData;
        String script;
        String unpacked;
        MatchResult matchResultFind$default;
        String str;
        String m3u8;
        String fileName;
        String mp4Url;
        Object objNewExtractorLink;
        String unpacked2;
        String referer3;
        Function1<? super SubtitleFile, Unit> function5;
        String script2;
        String referer4;
        Function1<? super ExtractorLink, Unit> function6;
        String url3;
        String m3u9;
        String fileName2;
        List groupValues;
        Object objNewExtractorLink2;
        Function1<? super ExtractorLink, Unit> function7;
        if (continuation instanceof C00121) {
            c00121 = (C00121) continuation;
            if ((c00121.label & Integer.MIN_VALUE) != 0) {
                c00121.label -= Integer.MIN_VALUE;
            } else {
                c00121 = new C00121(continuation);
            }
        } else {
            c00121 = new C00121(continuation);
        }
        C00121 c00122 = c00121;
        Object $result = c00122.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00122.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                Requests app = MainActivityKt.getApp();
                String str2 = AnimePaheProviderPlugin.INSTANCE.getCurrentAnimepaheServer() + '/';
                c00122.L$0 = url;
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c00122.L$3 = function2;
                c00122.label = 1;
                i = 1;
                obj2 = Requests.get$default(app, url, (Map) null, str2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00122, 4090, (Object) null);
                c00122 = c00122;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                res = (NiceResponse) obj2;
                title = res.getDocument().title();
                elementSelectFirst = res.getDocument().selectFirst("script:containsData(function(p,a,c,k,e,d))");
                if (elementSelectFirst != null) {
                    strData = elementSelectFirst.data();
                } else {
                    strData = null;
                }
                script = strData;
                if (script == null) {
                    return Unit.INSTANCE;
                }
                unpacked = ExtractorApiKt.getAndUnpack(script);
                matchResultFind$default = Regex.find$default(new Regex("source=\\s*'(.*?m3u8.*?)'"), unpacked, 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = (String) CollectionsKt.getOrNull(groupValues, i)) == null) {
                    str = "";
                }
                m3u8 = str;
                fileName = StringsKt.substringBeforeLast$default(title, ".mp4", (String) null, 2, (Object) null) + ".mp4";
                String it = StringsKt.substringBeforeLast$default(StringsKt.replace$default(m3u8, "/stream/", "/mp4/", false, 4, (Object) null), "/", (String) null, 2, (Object) null);
                mp4Url = it + "?file=" + CodecsKt.encodeURLQueryComponent$default(fileName, false, false, (Charset) null, 7, (Object) null);
                String name = getName();
                String name2 = getName();
                ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                C00132 c00132 = new C00132(title, null);
                c00122.L$0 = url2;
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00122.L$3 = function4;
                c00122.L$4 = SpillingKt.nullOutSpilledVariable(res);
                c00122.L$5 = SpillingKt.nullOutSpilledVariable(title);
                c00122.L$6 = SpillingKt.nullOutSpilledVariable(script);
                c00122.L$7 = SpillingKt.nullOutSpilledVariable(unpacked);
                c00122.L$8 = SpillingKt.nullOutSpilledVariable(m3u8);
                c00122.L$9 = fileName;
                c00122.L$10 = mp4Url;
                c00122.L$11 = function4;
                c00122.label = 2;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, m3u8, infer_type, c00132, c00122);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                unpacked2 = referer2;
                referer3 = unpacked;
                function5 = function3;
                script2 = script;
                referer4 = url2;
                function6 = function4;
                url3 = m3u8;
                m3u9 = mp4Url;
                fileName2 = fileName;
                function6.invoke(objNewExtractorLink);
                String name3 = getName();
                String str3 = getName() + " [Download]";
                ExtractorLinkType extractorLinkType = ExtractorLinkType.VIDEO;
                C00143 c00143 = new C00143(referer4, fileName2, this, null);
                c00122.L$0 = SpillingKt.nullOutSpilledVariable(referer4);
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(unpacked2);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                c00122.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00122.L$4 = SpillingKt.nullOutSpilledVariable(res);
                c00122.L$5 = SpillingKt.nullOutSpilledVariable(title);
                c00122.L$6 = SpillingKt.nullOutSpilledVariable(script2);
                c00122.L$7 = SpillingKt.nullOutSpilledVariable(referer3);
                c00122.L$8 = SpillingKt.nullOutSpilledVariable(url3);
                c00122.L$9 = SpillingKt.nullOutSpilledVariable(fileName2);
                c00122.L$10 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00122.L$11 = function4;
                c00122.label = 3;
                objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name3, str3, m3u9, extractorLinkType, c00143, c00122);
                if (objNewExtractorLink2 == obj) {
                    return obj;
                }
                $result = objNewExtractorLink2;
                function7 = function4;
                function7.invoke($result);
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function8 = (Function1) c00122.L$3;
                Function1<? super SubtitleFile, Unit> function9 = (Function1) c00122.L$2;
                String referer5 = (String) c00122.L$1;
                String url4 = (String) c00122.L$0;
                ResultKt.throwOnFailure($result);
                function4 = function8;
                obj = coroutine_suspended;
                function3 = function9;
                referer2 = referer5;
                url2 = url4;
                obj2 = $result;
                i = 1;
                res = (NiceResponse) obj2;
                title = res.getDocument().title();
                elementSelectFirst = res.getDocument().selectFirst("script:containsData(function(p,a,c,k,e,d))");
                if (elementSelectFirst != null) {
                    strData = elementSelectFirst.data();
                } else {
                    strData = null;
                }
                script = strData;
                if (script == null) {
                    return Unit.INSTANCE;
                }
                unpacked = ExtractorApiKt.getAndUnpack(script);
                matchResultFind$default = Regex.find$default(new Regex("source=\\s*'(.*?m3u8.*?)'"), unpacked, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    str = "";
                } else {
                    str = "";
                }
                m3u8 = str;
                fileName = StringsKt.substringBeforeLast$default(title, ".mp4", (String) null, 2, (Object) null) + ".mp4";
                String it2 = StringsKt.substringBeforeLast$default(StringsKt.replace$default(m3u8, "/stream/", "/mp4/", false, 4, (Object) null), "/", (String) null, 2, (Object) null);
                mp4Url = it2 + "?file=" + CodecsKt.encodeURLQueryComponent$default(fileName, false, false, (Charset) null, 7, (Object) null);
                String name4 = getName();
                String name5 = getName();
                ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                C00132 c00133 = new C00132(title, null);
                c00122.L$0 = url2;
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00122.L$3 = function4;
                c00122.L$4 = SpillingKt.nullOutSpilledVariable(res);
                c00122.L$5 = SpillingKt.nullOutSpilledVariable(title);
                c00122.L$6 = SpillingKt.nullOutSpilledVariable(script);
                c00122.L$7 = SpillingKt.nullOutSpilledVariable(unpacked);
                c00122.L$8 = SpillingKt.nullOutSpilledVariable(m3u8);
                c00122.L$9 = fileName;
                c00122.L$10 = mp4Url;
                c00122.L$11 = function4;
                c00122.label = 2;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name4, name5, m3u8, infer_type2, c00133, c00122);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                unpacked2 = referer2;
                referer3 = unpacked;
                function5 = function3;
                script2 = script;
                referer4 = url2;
                function6 = function4;
                url3 = m3u8;
                m3u9 = mp4Url;
                fileName2 = fileName;
                function6.invoke(objNewExtractorLink);
                String name6 = getName();
                String str4 = getName() + " [Download]";
                ExtractorLinkType extractorLinkType2 = ExtractorLinkType.VIDEO;
                C00143 c00144 = new C00143(referer4, fileName2, this, null);
                c00122.L$0 = SpillingKt.nullOutSpilledVariable(referer4);
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(unpacked2);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                c00122.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00122.L$4 = SpillingKt.nullOutSpilledVariable(res);
                c00122.L$5 = SpillingKt.nullOutSpilledVariable(title);
                c00122.L$6 = SpillingKt.nullOutSpilledVariable(script2);
                c00122.L$7 = SpillingKt.nullOutSpilledVariable(referer3);
                c00122.L$8 = SpillingKt.nullOutSpilledVariable(url3);
                c00122.L$9 = SpillingKt.nullOutSpilledVariable(fileName2);
                c00122.L$10 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00122.L$11 = function4;
                c00122.label = 3;
                objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name6, str4, m3u9, extractorLinkType2, c00144, c00122);
                if (objNewExtractorLink2 == obj) {
                    return obj;
                }
                $result = objNewExtractorLink2;
                function7 = function4;
                function7.invoke($result);
                return Unit.INSTANCE;
            case 2:
                function6 = (Function1) c00122.L$11;
                m3u9 = (String) c00122.L$10;
                String fileName3 = (String) c00122.L$9;
                url3 = (String) c00122.L$8;
                referer3 = (String) c00122.L$7;
                script2 = (String) c00122.L$6;
                String title2 = (String) c00122.L$5;
                res = (NiceResponse) c00122.L$4;
                Function1<? super ExtractorLink, Unit> function10 = (Function1) c00122.L$3;
                function5 = (Function1) c00122.L$2;
                String referer6 = (String) c00122.L$1;
                String url5 = (String) c00122.L$0;
                ResultKt.throwOnFailure($result);
                title = title2;
                function4 = function10;
                unpacked2 = referer6;
                referer4 = url5;
                obj = coroutine_suspended;
                fileName2 = fileName3;
                objNewExtractorLink = $result;
                function6.invoke(objNewExtractorLink);
                String name7 = getName();
                String str5 = getName() + " [Download]";
                ExtractorLinkType extractorLinkType3 = ExtractorLinkType.VIDEO;
                C00143 c00145 = new C00143(referer4, fileName2, this, null);
                c00122.L$0 = SpillingKt.nullOutSpilledVariable(referer4);
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(unpacked2);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                c00122.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00122.L$4 = SpillingKt.nullOutSpilledVariable(res);
                c00122.L$5 = SpillingKt.nullOutSpilledVariable(title);
                c00122.L$6 = SpillingKt.nullOutSpilledVariable(script2);
                c00122.L$7 = SpillingKt.nullOutSpilledVariable(referer3);
                c00122.L$8 = SpillingKt.nullOutSpilledVariable(url3);
                c00122.L$9 = SpillingKt.nullOutSpilledVariable(fileName2);
                c00122.L$10 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00122.L$11 = function4;
                c00122.label = 3;
                objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name7, str5, m3u9, extractorLinkType3, c00145, c00122);
                if (objNewExtractorLink2 == obj) {
                    return obj;
                }
                $result = objNewExtractorLink2;
                function7 = function4;
                function7.invoke($result);
                return Unit.INSTANCE;
            case 3:
                function7 = (Function1) c00122.L$11;
                ResultKt.throwOnFailure($result);
                function7.invoke($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Kwik$getUrl$2 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Kwik$getUrl$2", f = "Utils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00132 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $title;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00132(String str, Continuation<? super C00132> continuation) {
            super(2, continuation);
            this.$title = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00132 = Kwik.this.new C00132(this.$title, continuation);
            c00132.L$0 = obj;
            return c00132;
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
                    $this$newExtractorLink.setReferer(Kwik.this.getMainUrl());
                    $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$title));
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(TuplesKt.to("origin", Kwik.this.getMainUrl())));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Kwik$getUrl$3 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Kwik$getUrl$3", f = "Utils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00143 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fileName;
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ Kwik this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00143(String str, String str2, Kwik kwik, Continuation<? super C00143> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$fileName = str2;
            this.this$0 = kwik;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00143 = new C00143(this.$url, this.$fileName, this.this$0, continuation);
            c00143.L$0 = obj;
            return c00143;
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
                    $this$newExtractorLink.setReferer(this.$url);
                    $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$fileName));
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(new Pair[]{TuplesKt.to("Referer", this.$url), TuplesKt.to("Origin", this.this$0.getMainUrl())}));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
