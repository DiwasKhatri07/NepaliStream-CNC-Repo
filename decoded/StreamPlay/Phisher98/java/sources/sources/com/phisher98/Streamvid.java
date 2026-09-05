package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/Streamvid;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/Streamvid\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4003:1\n2068#2,2:4004\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/Streamvid\n*L\n645#1:4004,2\n*E\n"})
public class Streamvid extends ExtractorApi {

    @NotNull
    private final String name = "Streamvid";

    @NotNull
    private final String mainUrl = "https://streamvid.net";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.Streamvid$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Streamvid", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {633, 641}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "response", "script", "m3u8"}, nl = {634, 645}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C02971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C02971(Continuation<? super C02971> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Streamvid.getUrl$suspendImpl(Streamvid.this, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
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

    /* JADX WARN: Code duplicated, block: B:24:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:27:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:28:0x0100  */
    /* JADX WARN: Code duplicated, block: B:30:0x010c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0111  */
    /* JADX WARN: Code duplicated, block: B:34:0x011d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0120  */
    /* JADX WARN: Code duplicated, block: B:43:0x0144  */
    /* JADX WARN: Code duplicated, block: B:45:0x0147  */
    /* JADX WARN: Code duplicated, block: B:47:0x018d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x018e  */
    /* JADX WARN: Code duplicated, block: B:52:0x01a5 A[LOOP:0: B:50:0x019f->B:52:0x01a5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Streamvid $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C02971 c02971;
        Object obj;
        Streamvid $this2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj2;
        Function1<? super ExtractorLink, Unit> function4;
        NiceResponse response;
        String packed;
        boolean z;
        String str;
        Element elementSelectFirst;
        String strData;
        String script;
        Regex regex;
        MatchResult matchResultFind$default;
        String m3u8;
        M3u8Helper.Companion companion;
        String name;
        Function1<? super ExtractorLink, Unit> function5;
        Object objGenerateM3u8$default;
        Function1<? super ExtractorLink, Unit> function6;
        List groupValues;
        if (continuation instanceof C02971) {
            c02971 = (C02971) continuation;
            if ((c02971.label & Integer.MIN_VALUE) != 0) {
                c02971.label -= Integer.MIN_VALUE;
            } else {
                c02971 = $this.new C02971(continuation);
            }
        } else {
            c02971 = $this.new C02971(continuation);
        }
        C02971 c02972 = c02971;
        Object $result = c02972.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02972.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c02972.L$0 = $this;
                c02972.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c02972.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c02972.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c02972.L$4 = function2;
                c02972.label = 1;
                obj = coroutine_suspended;
                Object obj3 = Requests.get$default(app, url, (Map) null, referer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02972, 4090, (Object) null);
                c02972 = c02972;
                if (obj3 == obj) {
                    return obj;
                }
                $this2 = $this;
                url2 = url;
                referer2 = referer;
                function3 = function1;
                obj2 = obj3;
                function4 = function2;
                response = (NiceResponse) obj2;
                packed = ExtractorApiKt.getPacked(response.getText());
                if (packed != null || packed.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                str = null;
                if (z) {
                    elementSelectFirst = response.getDocument().selectFirst("script:containsData(sources:)");
                    if (elementSelectFirst != null) {
                        strData = elementSelectFirst.data();
                    } else {
                        strData = null;
                    }
                } else {
                    strData = ExtractorApiKt.getAndUnpack(response.getText());
                }
                script = strData;
                regex = new Regex("src:\\s*\"(.*?m3u8.*?)\"");
                if (script == null) {
                    return Unit.INSTANCE;
                }
                matchResultFind$default = Regex.find$default(regex, script, 0, 2, (Object) null);
                if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                    str = (String) CollectionsKt.getOrNull(groupValues, 1);
                }
                m3u8 = str;
                companion = M3u8Helper.Companion;
                name = $this2.getName();
                if (m3u8 == null) {
                    return Unit.INSTANCE;
                }
                String mainUrl = $this2.getMainUrl();
                c02972.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c02972.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c02972.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c02972.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c02972.L$4 = function4;
                c02972.L$5 = SpillingKt.nullOutSpilledVariable(response);
                c02972.L$6 = SpillingKt.nullOutSpilledVariable(script);
                c02972.L$7 = SpillingKt.nullOutSpilledVariable(m3u8);
                c02972.label = 2;
                function5 = function4;
                objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion, name, m3u8, mainUrl, (Integer) null, (Map) null, (String) null, c02972, 56, (Object) null);
                if (objGenerateM3u8$default == obj) {
                    return obj;
                }
                function6 = function5;
                Iterable $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                for (Object element$iv : $this$forEach$iv) {
                    function6.invoke(element$iv);
                }
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c02972.L$4;
                Function1<? super SubtitleFile, Unit> function8 = (Function1) c02972.L$3;
                String referer3 = (String) c02972.L$2;
                String url3 = (String) c02972.L$1;
                Streamvid $this3 = (Streamvid) c02972.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this3;
                obj = coroutine_suspended;
                function4 = function7;
                function3 = function8;
                referer2 = referer3;
                url2 = url3;
                obj2 = $result;
                response = (NiceResponse) obj2;
                packed = ExtractorApiKt.getPacked(response.getText());
                if (packed != null) {
                    z = true;
                } else {
                    z = true;
                }
                str = null;
                if (z) {
                    strData = ExtractorApiKt.getAndUnpack(response.getText());
                } else {
                    elementSelectFirst = response.getDocument().selectFirst("script:containsData(sources:)");
                    if (elementSelectFirst != null) {
                        strData = elementSelectFirst.data();
                    } else {
                        strData = null;
                    }
                }
                script = strData;
                regex = new Regex("src:\\s*\"(.*?m3u8.*?)\"");
                if (script == null) {
                    return Unit.INSTANCE;
                }
                matchResultFind$default = Regex.find$default(regex, script, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    str = (String) CollectionsKt.getOrNull(groupValues, 1);
                }
                m3u8 = str;
                companion = M3u8Helper.Companion;
                name = $this2.getName();
                if (m3u8 == null) {
                    return Unit.INSTANCE;
                }
                String mainUrl2 = $this2.getMainUrl();
                c02972.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c02972.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c02972.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c02972.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c02972.L$4 = function4;
                c02972.L$5 = SpillingKt.nullOutSpilledVariable(response);
                c02972.L$6 = SpillingKt.nullOutSpilledVariable(script);
                c02972.L$7 = SpillingKt.nullOutSpilledVariable(m3u8);
                c02972.label = 2;
                function5 = function4;
                objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion, name, m3u8, mainUrl2, (Integer) null, (Map) null, (String) null, c02972, 56, (Object) null);
                if (objGenerateM3u8$default == obj) {
                    return obj;
                }
                function6 = function5;
                Iterable $this$forEach$iv2 = (Iterable) objGenerateM3u8$default;
                while (r12.hasNext()) {
                    function6.invoke(element$iv);
                }
                return Unit.INSTANCE;
            case 2:
                function6 = (Function1) c02972.L$4;
                ResultKt.throwOnFailure($result);
                objGenerateM3u8$default = $result;
                Iterable $this$forEach$iv3 = (Iterable) objGenerateM3u8$default;
                while (r12.hasNext()) {
                    function6.invoke(element$iv);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
