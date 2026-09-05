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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/Streamruby;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/Streamruby\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4003:1\n2068#2,2:4004\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/Streamruby\n*L\n515#1:4004,2\n*E\n"})
public class Streamruby extends ExtractorApi {

    @NotNull
    private final String name = "Streamruby";

    @NotNull
    private final String mainUrl = "https://streamruby.com";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.Streamruby$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Streamruby", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {497, 511}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "id", "$this", "url", "referer", "subtitleCallback", "callback", "id", "response", "script", "m3u8"}, nl = {505, 515}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C02961 extends ContinuationImpl {
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

        C02961(Continuation<? super C02961> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Streamruby.getUrl$suspendImpl(Streamruby.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:31:0x0190  */
    /* JADX WARN: Code duplicated, block: B:33:0x0193  */
    /* JADX WARN: Code duplicated, block: B:34:0x019c  */
    /* JADX WARN: Code duplicated, block: B:36:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:37:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:40:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:42:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:47:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:50:0x01df  */
    /* JADX WARN: Code duplicated, block: B:52:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:54:0x022b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x022c  */
    /* JADX WARN: Code duplicated, block: B:59:0x0247 A[LOOP:0: B:57:0x0241->B:59:0x0247, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Streamruby $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C02961 c02961;
        List groupValues;
        String id;
        String id2;
        Object obj;
        int i;
        int i2;
        Streamruby $this2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj2;
        Function1<? super ExtractorLink, Unit> function4;
        NiceResponse response;
        String packed;
        boolean z;
        Element elementSelectFirst;
        String strData;
        String script;
        Regex regex;
        MatchResult matchResultFind$default;
        String m3u8;
        M3u8Helper.Companion companion;
        String name;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super ExtractorLink, Unit> function6;
        List groupValues2;
        if (continuation instanceof C02961) {
            c02961 = (C02961) continuation;
            if ((c02961.label & Integer.MIN_VALUE) != 0) {
                c02961.label -= Integer.MIN_VALUE;
            } else {
                c02961 = $this.new C02961(continuation);
            }
        } else {
            c02961 = $this.new C02961(continuation);
        }
        C02961 c02962 = c02961;
        Object $result = c02962.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02962.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MatchResult matchResultFind$default2 = Regex.find$default(new Regex("/e/(\\w+)"), url, 0, 2, (Object) null);
                if (matchResultFind$default2 == null || (groupValues = matchResultFind$default2.getGroupValues()) == null || (id = (String) groupValues.get(1)) == null) {
                    return Unit.INSTANCE;
                }
                Requests app = MainActivityKt.getApp();
                String str = $this.getMainUrl() + "/dl";
                Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("op", "embed"), TuplesKt.to("file_code", id), TuplesKt.to("auto", "1"), TuplesKt.to("referer", "")});
                c02962.L$0 = $this;
                c02962.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c02962.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c02962.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c02962.L$4 = function2;
                c02962.L$5 = SpillingKt.nullOutSpilledVariable(id);
                c02962.label = 1;
                id2 = id;
                obj = coroutine_suspended;
                i = 0;
                i2 = 2;
                Object objPost$default = Requests.post$default(app, str, (Map) null, referer, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02962, 65498, (Object) null);
                if (objPost$default == obj) {
                    c02962 = c02962;
                    return obj;
                }
                c02962 = c02962;
                $this2 = $this;
                url2 = url;
                referer2 = referer;
                function3 = function1;
                obj2 = objPost$default;
                function4 = function2;
                response = (NiceResponse) obj2;
                packed = ExtractorApiKt.getPacked(response.getText());
                if (packed != null || packed.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
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
                regex = new Regex("file:\\s*\"(.*?m3u8.*?)\"");
                if (script == null) {
                    return Unit.INSTANCE;
                }
                matchResultFind$default = Regex.find$default(regex, script, i, i2, (Object) null);
                if (matchResultFind$default != null || (groupValues2 = matchResultFind$default.getGroupValues()) == null) {
                    m3u8 = null;
                } else {
                    m3u8 = (String) CollectionsKt.getOrNull(groupValues2, 1);
                }
                companion = M3u8Helper.Companion;
                name = $this2.getName();
                if (m3u8 == null) {
                    return Unit.INSTANCE;
                }
                String mainUrl = $this2.getMainUrl();
                c02962.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c02962.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c02962.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c02962.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c02962.L$4 = function4;
                c02962.L$5 = SpillingKt.nullOutSpilledVariable(id2);
                c02962.L$6 = SpillingKt.nullOutSpilledVariable(response);
                c02962.L$7 = SpillingKt.nullOutSpilledVariable(script);
                c02962.L$8 = SpillingKt.nullOutSpilledVariable(m3u8);
                c02962.label = i2;
                function5 = function4;
                $result = M3u8Helper.Companion.generateM3u8$default(companion, name, m3u8, mainUrl, (Integer) null, (Map) null, (String) null, c02962, 56, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                function6 = function5;
                Iterable $this$forEach$iv = (Iterable) $result;
                for (Object element$iv : $this$forEach$iv) {
                    function6.invoke(element$iv);
                }
                return Unit.INSTANCE;
            case 1:
                String id3 = (String) c02962.L$5;
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c02962.L$4;
                Function1<? super SubtitleFile, Unit> function8 = (Function1) c02962.L$3;
                String referer3 = (String) c02962.L$2;
                String url3 = (String) c02962.L$1;
                Streamruby $this3 = (Streamruby) c02962.L$0;
                ResultKt.throwOnFailure($result);
                id2 = id3;
                function3 = function8;
                referer2 = referer3;
                url2 = url3;
                i = 0;
                $this2 = $this3;
                obj2 = $result;
                obj = coroutine_suspended;
                function4 = function7;
                i2 = 2;
                response = (NiceResponse) obj2;
                packed = ExtractorApiKt.getPacked(response.getText());
                if (packed != null) {
                    z = true;
                } else {
                    z = true;
                }
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
                regex = new Regex("file:\\s*\"(.*?m3u8.*?)\"");
                if (script == null) {
                    return Unit.INSTANCE;
                }
                matchResultFind$default = Regex.find$default(regex, script, i, i2, (Object) null);
                if (matchResultFind$default != null) {
                    m3u8 = null;
                } else {
                    m3u8 = null;
                }
                companion = M3u8Helper.Companion;
                name = $this2.getName();
                if (m3u8 == null) {
                    return Unit.INSTANCE;
                }
                String mainUrl2 = $this2.getMainUrl();
                c02962.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c02962.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c02962.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c02962.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c02962.L$4 = function4;
                c02962.L$5 = SpillingKt.nullOutSpilledVariable(id2);
                c02962.L$6 = SpillingKt.nullOutSpilledVariable(response);
                c02962.L$7 = SpillingKt.nullOutSpilledVariable(script);
                c02962.L$8 = SpillingKt.nullOutSpilledVariable(m3u8);
                c02962.label = i2;
                function5 = function4;
                $result = M3u8Helper.Companion.generateM3u8$default(companion, name, m3u8, mainUrl2, (Integer) null, (Map) null, (String) null, c02962, 56, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                function6 = function5;
                Iterable $this$forEach$iv2 = (Iterable) $result;
                while (r12.hasNext()) {
                    function6.invoke(element$iv);
                }
                return Unit.INSTANCE;
            case 2:
                function6 = (Function1) c02962.L$4;
                ResultKt.throwOnFailure($result);
                Iterable $this$forEach$iv3 = (Iterable) $result;
                while (r12.hasNext()) {
                    function6.invoke(element$iv);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
