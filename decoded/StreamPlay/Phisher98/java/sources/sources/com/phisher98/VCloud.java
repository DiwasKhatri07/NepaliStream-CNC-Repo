package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/phisher98/VCloud;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanTitle", "title", "getIndexQuality", "", "str", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/VCloud\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,4003:1\n1#2:4004\n*E\n"})
public final class VCloud extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "V-Cloud";

    @NotNull
    private final String mainUrl = "https://vcloud.zip";

    /* JADX INFO: renamed from: com.phisher98.VCloud$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.VCloud", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {331, 335, 353, 365}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "href", "$this$getUrl_u24lambda_u240", "url", "referer", "subtitleCallback", "callback", "href", "$this$getUrl_u24lambda_u241", "url", "referer", "subtitleCallback", "callback", "href", "doc", "scriptTag", "urlValue", "$this$getUrl_u24lambda_u243", "url", "referer", "subtitleCallback", "callback", "href", "doc", "scriptTag", "urlValue", "document", "size", "header", "headerdetails", "labelExtras", "div"}, nl = {330, 335, 353, 471}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13"}, v = 2)
    static final class C03061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
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

        C03061(Continuation<? super C03061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VCloud.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:105:0x0357  */
    /* JADX WARN: Code duplicated, block: B:107:0x036c  */
    /* JADX WARN: Code duplicated, block: B:111:0x037d A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:114:0x0381  */
    /* JADX WARN: Code duplicated, block: B:117:0x038d  */
    /* JADX WARN: Code duplicated, block: B:118:0x038f  */
    /* JADX WARN: Code duplicated, block: B:120:0x0392  */
    /* JADX WARN: Code duplicated, block: B:122:0x0395  */
    /* JADX WARN: Code duplicated, block: B:128:0x040f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:129:0x0410  */
    /* JADX WARN: Code duplicated, block: B:141:0x0465  */
    /* JADX WARN: Code duplicated, block: B:144:0x046b  */
    /* JADX WARN: Code duplicated, block: B:146:0x046e  */
    /* JADX WARN: Code duplicated, block: B:148:0x0477  */
    /* JADX WARN: Code duplicated, block: B:149:0x047c  */
    /* JADX WARN: Code duplicated, block: B:151:0x0480  */
    /* JADX WARN: Code duplicated, block: B:154:0x0489  */
    /* JADX WARN: Code duplicated, block: B:156:0x0491  */
    /* JADX WARN: Code duplicated, block: B:157:0x0493  */
    /* JADX WARN: Code duplicated, block: B:160:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:161:0x04af  */
    /* JADX WARN: Code duplicated, block: B:163:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:164:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:167:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:168:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:170:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:171:0x04ed  */
    /* JADX WARN: Code duplicated, block: B:174:0x04fe  */
    /* JADX WARN: Code duplicated, block: B:176:0x0501  */
    /* JADX WARN: Code duplicated, block: B:178:0x057c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:179:0x057d  */
    /* JADX WARN: Code duplicated, block: B:39:0x01b7 A[Catch: all -> 0x01c4, TryCatch #2 {all -> 0x01c4, blocks: (B:37:0x01a9, B:39:0x01b7, B:41:0x01bf), top: B:186:0x01a9 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x01be  */
    /* JADX WARN: Code duplicated, block: B:52:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:55:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:57:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:65:0x028b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x028c  */
    /* JADX WARN: Code duplicated, block: B:78:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:83:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:85:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:87:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:90:0x0318  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C03061 c03061;
        Ref.ObjectRef href;
        C03061 c03062;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Ref.ObjectRef href2;
        Object obj;
        String url3;
        String referer3;
        Function1<? super SubtitleFile, Unit> function5;
        Function1<? super ExtractorLink, Unit> function6;
        Ref.ObjectRef href3;
        Object obj2;
        int i;
        String url4;
        String referer4;
        Function1<? super ExtractorLink, Unit> function7;
        Ref.ObjectRef href4;
        Function1<? super SubtitleFile, Unit> function8;
        Function1<? super ExtractorLink, Unit> function9;
        Function1<? super SubtitleFile, Unit> function10;
        C03061 c03063;
        Ref.ObjectRef href5;
        String url5;
        Object obj3;
        Ref.ObjectRef href6;
        Object obj4;
        Ref.ObjectRef objectRef;
        String str;
        Element elementSelectFirst;
        String strAttr;
        Function1<? super ExtractorLink, Unit> function11;
        Function1<? super SubtitleFile, Unit> function12;
        String referer5;
        String url6;
        Object obj5;
        Document doc;
        Element elementSelectFirst2;
        String strData;
        String scriptTag;
        MatchResult matchResultFind$default;
        String str2;
        String str3;
        List groupValues;
        String urlValue;
        boolean z;
        String strText;
        C03061 c03064;
        Function1<? super ExtractorLink, Unit> function13;
        String urlValue2;
        String url7;
        String urlValue3;
        Function1<? super SubtitleFile, Unit> function14;
        Ref.ObjectRef href7;
        Document doc2;
        Function1<? super ExtractorLink, Unit> function15;
        C03061 c03065;
        String urlValue4;
        Function1<? super SubtitleFile, Unit> function16;
        Object obj6;
        List groupValues2;
        String it;
        Object obj7;
        Object obj8;
        Function1<? super SubtitleFile, Unit> function17;
        Document document;
        Element elementSelectFirst3;
        String size;
        Element elementSelectFirst4;
        String header;
        String headerdetails;
        StringBuilder $this$getUrl_u24lambda_u244;
        boolean z2;
        StringBuilder $this$getUrl_u24lambda_u245;
        boolean z3;
        String labelExtras;
        Element div;
        List listSelect;
        String header2;
        C03073 c03073;
        if (continuation instanceof C03061) {
            c03061 = (C03061) continuation;
            if ((c03061.label & Integer.MIN_VALUE) != 0) {
                c03061.label -= Integer.MIN_VALUE;
            } else {
                c03061 = new C03061(continuation);
            }
        } else {
            c03061 = new C03061(continuation);
        }
        C03061 c03066 = c03061;
        Object $result = c03066.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03066.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.ObjectRef href8 = new Ref.ObjectRef();
                href8.element = url;
                if (StringsKt.contains$default((CharSequence) href8.element, "api/index.php", false, 2, (Object) null)) {
                    try {
                        Result.Companion companion = Result.Companion;
                        VCloud $this$getUrl_u24lambda_u240 = this;
                        Requests app = MainActivityKt.getApp();
                        c03066.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        c03066.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                        c03066.L$2 = function1;
                        c03066.L$3 = function2;
                        c03066.L$4 = href8;
                        c03066.L$5 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u240);
                        c03066.L$6 = href8;
                        c03066.label = 1;
                        href = href8;
                        try {
                            obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03066, 4094, (Object) null);
                            c03062 = c03066;
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            url2 = url;
                            referer2 = referer;
                            function3 = function1;
                            function4 = function2;
                            href2 = href;
                            try {
                                elementSelectFirst = ((NiceResponse) obj).getDocument().selectFirst("div.main h4 a");
                                if (elementSelectFirst != null) {
                                    strAttr = elementSelectFirst.attr("href");
                                } else {
                                    strAttr = null;
                                }
                                obj2 = Result.constructor-impl(strAttr);
                            } catch (Throwable th) {
                                th = th;
                                Result.Companion companion2 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            href6 = href2;
                            obj4 = obj2;
                            objectRef = href;
                            if (Result.isFailure-impl(obj4)) {
                                obj4 = null;
                            }
                            str = (String) obj4;
                            if (str == null) {
                                return Unit.INSTANCE;
                            }
                            objectRef.element = str;
                            href3 = href6;
                            function6 = function4;
                            function5 = function3;
                            referer3 = referer2;
                            url3 = url2;
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                            c03062 = c03066;
                            url2 = url;
                            referer2 = referer;
                            function3 = function1;
                            function4 = function2;
                            href2 = href;
                            Result.Companion companion3 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            href6 = href2;
                            obj4 = obj2;
                            objectRef = href;
                            if (Result.isFailure-impl(obj4)) {
                                obj4 = null;
                            }
                            str = (String) obj4;
                            if (str == null) {
                                return Unit.INSTANCE;
                            }
                            objectRef.element = str;
                            href3 = href6;
                            function6 = function4;
                            function5 = function3;
                            referer3 = referer2;
                            url3 = url2;
                            Log.INSTANCE.d("Phisher", (String) href3.element);
                            Result.Companion companion4 = Result.Companion;
                            VCloud $this$getUrl_u24lambda_u241 = this;
                            Requests app2 = MainActivityKt.getApp();
                            String str4 = (String) href3.element;
                            c03062.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c03062.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                            c03062.L$2 = function5;
                            c03062.L$3 = function6;
                            c03062.L$4 = SpillingKt.nullOutSpilledVariable(href3);
                            c03062.L$5 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u241);
                            c03062.L$6 = null;
                            c03062.label = 2;
                            function9 = function6;
                            function10 = function5;
                            c03063 = c03062;
                            href5 = href3;
                            url5 = url3;
                            i = 2;
                            obj3 = Requests.get$default(app2, str4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03063, 4094, (Object) null);
                            c03062 = c03063;
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            url4 = url5;
                            referer4 = referer3;
                            function7 = function9;
                            function8 = function10;
                            try {
                                Object obj9 = Result.constructor-impl(((NiceResponse) obj3).getDocument());
                                function11 = function7;
                                function12 = function8;
                                referer5 = referer4;
                                url6 = url4;
                                obj5 = obj9;
                            } catch (Throwable th3) {
                                th = th3;
                                href4 = href5;
                                Result.Companion companion5 = Result.Companion;
                                href5 = href4;
                                function11 = function7;
                                function12 = function8;
                                referer5 = referer4;
                                url6 = url4;
                                obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            if (Result.isFailure-impl(obj5)) {
                                obj5 = null;
                            }
                            doc = (Document) obj5;
                            if (doc == null) {
                                return Unit.INSTANCE;
                            }
                            elementSelectFirst2 = doc.selectFirst("script:containsData(url)");
                            if (elementSelectFirst2 != null) {
                                strData = "";
                            } else {
                                strData = "";
                            }
                            scriptTag = strData;
                            matchResultFind$default = Regex.find$default(new Regex("atob\\(atob\\('([^']+)'\\)\\)"), scriptTag, 0, i, (Object) null);
                            if (matchResultFind$default == null) {
                                str2 = null;
                                MatchResult matchResultFind$default2 = Regex.find$default(new Regex("var\\s+url\\s*=\\s*'([^']*)'"), scriptTag, 0, i, (Object) null);
                                if (matchResultFind$default2 != null) {
                                }
                                if (str3 == null) {
                                    str3 = "";
                                }
                            } else {
                                str2 = null;
                                MatchResult matchResultFind$default3 = Regex.find$default(new Regex("var\\s+url\\s*=\\s*'([^']*)'"), scriptTag, 0, i, (Object) null);
                                if (matchResultFind$default3 != null) {
                                }
                                if (str3 == null) {
                                    str3 = "";
                                }
                            }
                            urlValue = str3;
                            if (urlValue.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                return Unit.INSTANCE;
                            }
                            Log.INSTANCE.d("Phisher", urlValue);
                            try {
                                Result.Companion companion6 = Result.Companion;
                                VCloud $this$getUrl_u24lambda_u243 = this;
                                Requests app3 = MainActivityKt.getApp();
                                c03062.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                c03062.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                                c03062.L$2 = function12;
                                c03062.L$3 = function11;
                                c03062.L$4 = SpillingKt.nullOutSpilledVariable(href5);
                                c03062.L$5 = SpillingKt.nullOutSpilledVariable(doc);
                                c03062.L$6 = SpillingKt.nullOutSpilledVariable(scriptTag);
                                c03062.L$7 = SpillingKt.nullOutSpilledVariable(urlValue);
                                c03062.L$8 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u243);
                                c03062.label = 3;
                                function15 = function11;
                                c03065 = c03062;
                                urlValue4 = urlValue;
                                strText = str2;
                                function16 = function12;
                                try {
                                    obj6 = Requests.get$default(app3, urlValue4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03065, 4094, (Object) null);
                                    c03064 = c03065;
                                    if (obj6 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    function13 = function15;
                                    url7 = url6;
                                    urlValue3 = scriptTag;
                                    href7 = href5;
                                    doc2 = doc;
                                    try {
                                        obj8 = Result.constructor-impl(((NiceResponse) obj6).getDocument());
                                        urlValue2 = urlValue4;
                                        function17 = function16;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        urlValue2 = urlValue4;
                                        function14 = function16;
                                        Result.Companion companion7 = Result.Companion;
                                        obj8 = Result.constructor-impl(ResultKt.createFailure(th));
                                        function17 = function14;
                                    }
                                    if (Result.isFailure-impl(obj8)) {
                                        obj8 = strText;
                                    }
                                    document = (Document) obj8;
                                    if (document == null) {
                                        return Unit.INSTANCE;
                                    }
                                    elementSelectFirst3 = document.selectFirst("i#size");
                                    if (elementSelectFirst3 != null) {
                                        size = elementSelectFirst3.text();
                                    } else {
                                        size = strText;
                                    }
                                    if (size == null) {
                                        size = "";
                                    }
                                    elementSelectFirst4 = document.selectFirst("div.card-header");
                                    if (elementSelectFirst4 != null) {
                                        strText = elementSelectFirst4.text();
                                    }
                                    if (strText == null) {
                                        header = "";
                                    } else {
                                        header = strText;
                                    }
                                    headerdetails = cleanTitle(header);
                                    $this$getUrl_u24lambda_u244 = new StringBuilder();
                                    if (headerdetails.length() > 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                                        $this$getUrl_u24lambda_u245.append(headerdetails);
                                    } else {
                                        $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                                    }
                                    if (size.length() > 0) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (z3) {
                                        $this$getUrl_u24lambda_u245.append(" [" + size + ']');
                                    }
                                    labelExtras = $this$getUrl_u24lambda_u244.toString();
                                    div = document.selectFirst("div.card-body");
                                    if (div == null) {
                                        return Unit.INSTANCE;
                                    }
                                    listSelect = div.select("h2 a.btn");
                                    String size2 = size;
                                    Function1<? super ExtractorLink, Unit> function18 = function13;
                                    c03073 = new C03073(header2, function18, labelExtras, function17, null);
                                    c03064.L$0 = SpillingKt.nullOutSpilledVariable(url7);
                                    c03064.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                                    c03064.L$2 = SpillingKt.nullOutSpilledVariable(function17);
                                    c03064.L$3 = SpillingKt.nullOutSpilledVariable(function18);
                                    c03064.L$4 = SpillingKt.nullOutSpilledVariable(href7);
                                    c03064.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                                    c03064.L$6 = SpillingKt.nullOutSpilledVariable(urlValue3);
                                    c03064.L$7 = SpillingKt.nullOutSpilledVariable(urlValue2);
                                    c03064.L$8 = SpillingKt.nullOutSpilledVariable(document);
                                    c03064.L$9 = SpillingKt.nullOutSpilledVariable(size2);
                                    c03064.L$10 = SpillingKt.nullOutSpilledVariable(header2);
                                    c03064.L$11 = SpillingKt.nullOutSpilledVariable(headerdetails);
                                    c03064.L$12 = SpillingKt.nullOutSpilledVariable(labelExtras);
                                    c03064.L$13 = SpillingKt.nullOutSpilledVariable(div);
                                    c03064.label = 4;
                                    if (ParCollectionsKt.amap(listSelect, c03073, c03064) == coroutine_suspended) {
                                        header2 = header;
                                        return coroutine_suspended;
                                    }
                                    header2 = header;
                                    return Unit.INSTANCE;
                                } catch (Throwable th5) {
                                    th = th5;
                                    c03064 = c03065;
                                    function13 = function15;
                                    urlValue2 = urlValue4;
                                    url7 = url6;
                                    urlValue3 = scriptTag;
                                    function14 = function16;
                                    href7 = href5;
                                    doc2 = doc;
                                    Result.Companion companion8 = Result.Companion;
                                    obj8 = Result.constructor-impl(ResultKt.createFailure(th));
                                    function17 = function14;
                                    if (Result.isFailure-impl(obj8)) {
                                        obj8 = strText;
                                    }
                                    document = (Document) obj8;
                                    if (document == null) {
                                        return Unit.INSTANCE;
                                    }
                                    elementSelectFirst3 = document.selectFirst("i#size");
                                    if (elementSelectFirst3 != null) {
                                        size = elementSelectFirst3.text();
                                    } else {
                                        size = strText;
                                    }
                                    if (size == null) {
                                        size = "";
                                    }
                                    elementSelectFirst4 = document.selectFirst("div.card-header");
                                    if (elementSelectFirst4 != null) {
                                        strText = elementSelectFirst4.text();
                                    }
                                    if (strText == null) {
                                        header = "";
                                    } else {
                                        header = strText;
                                    }
                                    headerdetails = cleanTitle(header);
                                    $this$getUrl_u24lambda_u244 = new StringBuilder();
                                    if (headerdetails.length() > 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                                        $this$getUrl_u24lambda_u245.append(headerdetails);
                                    } else {
                                        $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                                    }
                                    if (size.length() > 0) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (z3) {
                                        $this$getUrl_u24lambda_u245.append(" [" + size + ']');
                                    }
                                    labelExtras = $this$getUrl_u24lambda_u244.toString();
                                    div = document.selectFirst("div.card-body");
                                    if (div == null) {
                                        return Unit.INSTANCE;
                                    }
                                    listSelect = div.select("h2 a.btn");
                                    String size3 = size;
                                    Function1<? super ExtractorLink, Unit> function19 = function13;
                                    c03073 = new C03073(header2, function19, labelExtras, function17, null);
                                    c03064.L$0 = SpillingKt.nullOutSpilledVariable(url7);
                                    c03064.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                                    c03064.L$2 = SpillingKt.nullOutSpilledVariable(function17);
                                    c03064.L$3 = SpillingKt.nullOutSpilledVariable(function19);
                                    c03064.L$4 = SpillingKt.nullOutSpilledVariable(href7);
                                    c03064.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                                    c03064.L$6 = SpillingKt.nullOutSpilledVariable(urlValue3);
                                    c03064.L$7 = SpillingKt.nullOutSpilledVariable(urlValue2);
                                    c03064.L$8 = SpillingKt.nullOutSpilledVariable(document);
                                    c03064.L$9 = SpillingKt.nullOutSpilledVariable(size3);
                                    c03064.L$10 = SpillingKt.nullOutSpilledVariable(header2);
                                    c03064.L$11 = SpillingKt.nullOutSpilledVariable(headerdetails);
                                    c03064.L$12 = SpillingKt.nullOutSpilledVariable(labelExtras);
                                    c03064.L$13 = SpillingKt.nullOutSpilledVariable(div);
                                    c03064.label = 4;
                                    if (ParCollectionsKt.amap(listSelect, c03073, c03064) == coroutine_suspended) {
                                        header2 = header;
                                        return coroutine_suspended;
                                    }
                                    header2 = header;
                                    return Unit.INSTANCE;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                Function1<? super SubtitleFile, Unit> function20 = function12;
                                Function1<? super ExtractorLink, Unit> function21 = function11;
                                strText = str2;
                                c03064 = c03062;
                                function13 = function21;
                                urlValue2 = urlValue;
                                url7 = url6;
                                urlValue3 = scriptTag;
                                function14 = function20;
                                href7 = href5;
                                doc2 = doc;
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        href = href8;
                        c03062 = c03066;
                        url2 = url;
                        referer2 = referer;
                        function3 = function1;
                        function4 = function2;
                        href2 = href;
                    }
                } else {
                    c03062 = c03066;
                    url3 = url;
                    referer3 = referer;
                    function5 = function1;
                    function6 = function2;
                    href3 = href8;
                }
                Log.INSTANCE.d("Phisher", (String) href3.element);
                try {
                    Result.Companion companion9 = Result.Companion;
                    VCloud $this$getUrl_u24lambda_u242 = this;
                    Requests app4 = MainActivityKt.getApp();
                    String str5 = (String) href3.element;
                    c03062.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c03062.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                    c03062.L$2 = function5;
                    c03062.L$3 = function6;
                    c03062.L$4 = SpillingKt.nullOutSpilledVariable(href3);
                    c03062.L$5 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u242);
                    c03062.L$6 = null;
                    c03062.label = 2;
                    function9 = function6;
                    function10 = function5;
                    c03063 = c03062;
                    href5 = href3;
                    url5 = url3;
                    i = 2;
                    try {
                        obj3 = Requests.get$default(app4, str5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03063, 4094, (Object) null);
                        c03062 = c03063;
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url4 = url5;
                        referer4 = referer3;
                        function7 = function9;
                        function8 = function10;
                        Object obj10 = Result.constructor-impl(((NiceResponse) obj3).getDocument());
                        function11 = function7;
                        function12 = function8;
                        referer5 = referer4;
                        url6 = url4;
                        obj5 = obj10;
                        if (Result.isFailure-impl(obj5)) {
                            obj5 = null;
                        }
                        doc = (Document) obj5;
                        if (doc == null) {
                            return Unit.INSTANCE;
                        }
                        elementSelectFirst2 = doc.selectFirst("script:containsData(url)");
                        if (elementSelectFirst2 != null || (strData = elementSelectFirst2.data()) == null) {
                            strData = "";
                        }
                        scriptTag = strData;
                        matchResultFind$default = Regex.find$default(new Regex("atob\\(atob\\('([^']+)'\\)\\)"), scriptTag, 0, i, (Object) null);
                        if (matchResultFind$default == null && (groupValues2 = matchResultFind$default.getGroupValues()) != null && (it = (String) CollectionsKt.getOrNull(groupValues2, 1)) != null) {
                            try {
                                Result.Companion companion10 = Result.Companion;
                                VCloud vCloud = this;
                                obj7 = Result.constructor-impl(MainAPIKt.base64Decode(MainAPIKt.base64Decode(it)));
                            } catch (Throwable th8) {
                                Result.Companion companion11 = Result.Companion;
                                obj7 = Result.constructor-impl(ResultKt.createFailure(th8));
                            }
                            if (Result.isFailure-impl(obj7)) {
                                obj7 = null;
                            }
                            str3 = (String) obj7;
                            if (str3 != null) {
                                str2 = null;
                            } else {
                                str2 = null;
                                MatchResult matchResultFind$default4 = Regex.find$default(new Regex("var\\s+url\\s*=\\s*'([^']*)'"), scriptTag, 0, i, (Object) null);
                                if (matchResultFind$default4 != null) {
                                }
                                if (str3 == null) {
                                    str3 = "";
                                }
                            }
                            break;
                        } else {
                            str2 = null;
                            MatchResult matchResultFind$default5 = Regex.find$default(new Regex("var\\s+url\\s*=\\s*'([^']*)'"), scriptTag, 0, i, (Object) null);
                            str3 = (matchResultFind$default5 != null || (groupValues = matchResultFind$default5.getGroupValues()) == null) ? null : (String) CollectionsKt.getOrNull(groupValues, 1);
                            if (str3 == null) {
                                str3 = "";
                            }
                        }
                        urlValue = str3;
                        if (urlValue.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            return Unit.INSTANCE;
                        }
                        Log.INSTANCE.d("Phisher", urlValue);
                        Result.Companion companion12 = Result.Companion;
                        VCloud $this$getUrl_u24lambda_u246 = this;
                        Requests app5 = MainActivityKt.getApp();
                        c03062.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c03062.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                        c03062.L$2 = function12;
                        c03062.L$3 = function11;
                        c03062.L$4 = SpillingKt.nullOutSpilledVariable(href5);
                        c03062.L$5 = SpillingKt.nullOutSpilledVariable(doc);
                        c03062.L$6 = SpillingKt.nullOutSpilledVariable(scriptTag);
                        c03062.L$7 = SpillingKt.nullOutSpilledVariable(urlValue);
                        c03062.L$8 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u246);
                        c03062.label = 3;
                        function15 = function11;
                        c03065 = c03062;
                        urlValue4 = urlValue;
                        strText = str2;
                        function16 = function12;
                        obj6 = Requests.get$default(app5, urlValue4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03065, 4094, (Object) null);
                        c03064 = c03065;
                        if (obj6 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function13 = function15;
                        url7 = url6;
                        urlValue3 = scriptTag;
                        href7 = href5;
                        doc2 = doc;
                        obj8 = Result.constructor-impl(((NiceResponse) obj6).getDocument());
                        urlValue2 = urlValue4;
                        function17 = function16;
                        if (Result.isFailure-impl(obj8)) {
                            obj8 = strText;
                        }
                        document = (Document) obj8;
                        if (document == null) {
                            return Unit.INSTANCE;
                        }
                        elementSelectFirst3 = document.selectFirst("i#size");
                        if (elementSelectFirst3 != null) {
                            size = elementSelectFirst3.text();
                        } else {
                            size = strText;
                        }
                        if (size == null) {
                            size = "";
                        }
                        elementSelectFirst4 = document.selectFirst("div.card-header");
                        if (elementSelectFirst4 != null) {
                            strText = elementSelectFirst4.text();
                        }
                        if (strText == null) {
                            header = "";
                        } else {
                            header = strText;
                        }
                        headerdetails = cleanTitle(header);
                        $this$getUrl_u24lambda_u244 = new StringBuilder();
                        if (headerdetails.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                            $this$getUrl_u24lambda_u245.append(headerdetails);
                        } else {
                            $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                        }
                        if (size.length() > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            $this$getUrl_u24lambda_u245.append(" [" + size + ']');
                        }
                        labelExtras = $this$getUrl_u24lambda_u244.toString();
                        div = document.selectFirst("div.card-body");
                        if (div == null) {
                            return Unit.INSTANCE;
                        }
                        listSelect = div.select("h2 a.btn");
                        String size4 = size;
                        Function1<? super ExtractorLink, Unit> function110 = function13;
                        c03073 = new C03073(header2, function110, labelExtras, function17, null);
                        c03064.L$0 = SpillingKt.nullOutSpilledVariable(url7);
                        c03064.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                        c03064.L$2 = SpillingKt.nullOutSpilledVariable(function17);
                        c03064.L$3 = SpillingKt.nullOutSpilledVariable(function110);
                        c03064.L$4 = SpillingKt.nullOutSpilledVariable(href7);
                        c03064.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                        c03064.L$6 = SpillingKt.nullOutSpilledVariable(urlValue3);
                        c03064.L$7 = SpillingKt.nullOutSpilledVariable(urlValue2);
                        c03064.L$8 = SpillingKt.nullOutSpilledVariable(document);
                        c03064.L$9 = SpillingKt.nullOutSpilledVariable(size4);
                        c03064.L$10 = SpillingKt.nullOutSpilledVariable(header2);
                        c03064.L$11 = SpillingKt.nullOutSpilledVariable(headerdetails);
                        c03064.L$12 = SpillingKt.nullOutSpilledVariable(labelExtras);
                        c03064.L$13 = SpillingKt.nullOutSpilledVariable(div);
                        c03064.label = 4;
                        if (ParCollectionsKt.amap(listSelect, c03073, c03064) == coroutine_suspended) {
                            header2 = header;
                            return coroutine_suspended;
                        }
                        header2 = header;
                        return Unit.INSTANCE;
                    } catch (Throwable th9) {
                        th = th9;
                        c03062 = c03063;
                        url4 = url5;
                        referer4 = referer3;
                        function7 = function9;
                        href4 = href5;
                        function8 = function10;
                        Result.Companion companion13 = Result.Companion;
                        href5 = href4;
                        function11 = function7;
                        function12 = function8;
                        referer5 = referer4;
                        url6 = url4;
                        obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.isFailure-impl(obj5)) {
                            obj5 = null;
                        }
                        doc = (Document) obj5;
                        if (doc == null) {
                            return Unit.INSTANCE;
                        }
                        elementSelectFirst2 = doc.selectFirst("script:containsData(url)");
                        if (elementSelectFirst2 != null) {
                            strData = "";
                        } else {
                            strData = "";
                        }
                        scriptTag = strData;
                        matchResultFind$default = Regex.find$default(new Regex("atob\\(atob\\('([^']+)'\\)\\)"), scriptTag, 0, i, (Object) null);
                        if (matchResultFind$default == null) {
                            str2 = null;
                            MatchResult matchResultFind$default6 = Regex.find$default(new Regex("var\\s+url\\s*=\\s*'([^']*)'"), scriptTag, 0, i, (Object) null);
                            if (matchResultFind$default6 != null) {
                            }
                            if (str3 == null) {
                                str3 = "";
                            }
                        } else {
                            str2 = null;
                            MatchResult matchResultFind$default7 = Regex.find$default(new Regex("var\\s+url\\s*=\\s*'([^']*)'"), scriptTag, 0, i, (Object) null);
                            if (matchResultFind$default7 != null) {
                            }
                            if (str3 == null) {
                                str3 = "";
                            }
                        }
                        urlValue = str3;
                        if (urlValue.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            return Unit.INSTANCE;
                        }
                        Log.INSTANCE.d("Phisher", urlValue);
                        Result.Companion companion14 = Result.Companion;
                        VCloud $this$getUrl_u24lambda_u247 = this;
                        Requests app6 = MainActivityKt.getApp();
                        c03062.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c03062.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                        c03062.L$2 = function12;
                        c03062.L$3 = function11;
                        c03062.L$4 = SpillingKt.nullOutSpilledVariable(href5);
                        c03062.L$5 = SpillingKt.nullOutSpilledVariable(doc);
                        c03062.L$6 = SpillingKt.nullOutSpilledVariable(scriptTag);
                        c03062.L$7 = SpillingKt.nullOutSpilledVariable(urlValue);
                        c03062.L$8 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u247);
                        c03062.label = 3;
                        function15 = function11;
                        c03065 = c03062;
                        urlValue4 = urlValue;
                        strText = str2;
                        function16 = function12;
                        obj6 = Requests.get$default(app6, urlValue4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03065, 4094, (Object) null);
                        c03064 = c03065;
                        if (obj6 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function13 = function15;
                        url7 = url6;
                        urlValue3 = scriptTag;
                        href7 = href5;
                        doc2 = doc;
                        obj8 = Result.constructor-impl(((NiceResponse) obj6).getDocument());
                        urlValue2 = urlValue4;
                        function17 = function16;
                        if (Result.isFailure-impl(obj8)) {
                            obj8 = strText;
                        }
                        document = (Document) obj8;
                        if (document == null) {
                            return Unit.INSTANCE;
                        }
                        elementSelectFirst3 = document.selectFirst("i#size");
                        if (elementSelectFirst3 != null) {
                            size = elementSelectFirst3.text();
                        } else {
                            size = strText;
                        }
                        if (size == null) {
                            size = "";
                        }
                        elementSelectFirst4 = document.selectFirst("div.card-header");
                        if (elementSelectFirst4 != null) {
                            strText = elementSelectFirst4.text();
                        }
                        if (strText == null) {
                            header = "";
                        } else {
                            header = strText;
                        }
                        headerdetails = cleanTitle(header);
                        $this$getUrl_u24lambda_u244 = new StringBuilder();
                        if (headerdetails.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                            $this$getUrl_u24lambda_u245.append(headerdetails);
                        } else {
                            $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                        }
                        if (size.length() > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            $this$getUrl_u24lambda_u245.append(" [" + size + ']');
                        }
                        labelExtras = $this$getUrl_u24lambda_u244.toString();
                        div = document.selectFirst("div.card-body");
                        if (div == null) {
                            return Unit.INSTANCE;
                        }
                        listSelect = div.select("h2 a.btn");
                        String size5 = size;
                        Function1<? super ExtractorLink, Unit> function111 = function13;
                        c03073 = new C03073(header2, function111, labelExtras, function17, null);
                        c03064.L$0 = SpillingKt.nullOutSpilledVariable(url7);
                        c03064.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                        c03064.L$2 = SpillingKt.nullOutSpilledVariable(function17);
                        c03064.L$3 = SpillingKt.nullOutSpilledVariable(function111);
                        c03064.L$4 = SpillingKt.nullOutSpilledVariable(href7);
                        c03064.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                        c03064.L$6 = SpillingKt.nullOutSpilledVariable(urlValue3);
                        c03064.L$7 = SpillingKt.nullOutSpilledVariable(urlValue2);
                        c03064.L$8 = SpillingKt.nullOutSpilledVariable(document);
                        c03064.L$9 = SpillingKt.nullOutSpilledVariable(size5);
                        c03064.L$10 = SpillingKt.nullOutSpilledVariable(header2);
                        c03064.L$11 = SpillingKt.nullOutSpilledVariable(headerdetails);
                        c03064.L$12 = SpillingKt.nullOutSpilledVariable(labelExtras);
                        c03064.L$13 = SpillingKt.nullOutSpilledVariable(div);
                        c03064.label = 4;
                        if (ParCollectionsKt.amap(listSelect, c03073, c03064) == coroutine_suspended) {
                            header2 = header;
                            return coroutine_suspended;
                        }
                        header2 = header;
                        return Unit.INSTANCE;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    String str6 = url3;
                    Ref.ObjectRef objectRef2 = href3;
                    i = 2;
                    url4 = str6;
                    referer4 = referer3;
                    function7 = function6;
                    href4 = objectRef2;
                    function8 = function5;
                }
                break;
            case 1:
                Ref.ObjectRef objectRef3 = (Ref.ObjectRef) c03066.L$6;
                href2 = (Ref.ObjectRef) c03066.L$4;
                function4 = (Function1) c03066.L$3;
                function3 = (Function1) c03066.L$2;
                referer2 = (String) c03066.L$1;
                url2 = (String) c03066.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    href = objectRef3;
                    c03062 = c03066;
                    elementSelectFirst = ((NiceResponse) obj).getDocument().selectFirst("div.main h4 a");
                    if (elementSelectFirst != null) {
                        strAttr = elementSelectFirst.attr("href");
                    } else {
                        strAttr = null;
                    }
                    obj2 = Result.constructor-impl(strAttr);
                    break;
                } catch (Throwable th11) {
                    th = th11;
                    href = objectRef3;
                    c03062 = c03066;
                    Result.Companion companion15 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                    href6 = href2;
                    obj4 = obj2;
                    objectRef = href;
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = null;
                    }
                    str = (String) obj4;
                    if (str == null) {
                        return Unit.INSTANCE;
                    }
                    objectRef.element = str;
                    href3 = href6;
                    function6 = function4;
                    function5 = function3;
                    referer3 = referer2;
                    url3 = url2;
                    Log.INSTANCE.d("Phisher", (String) href3.element);
                    Result.Companion companion16 = Result.Companion;
                    VCloud $this$getUrl_u24lambda_u248 = this;
                    Requests app7 = MainActivityKt.getApp();
                    String str7 = (String) href3.element;
                    c03062.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c03062.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                    c03062.L$2 = function5;
                    c03062.L$3 = function6;
                    c03062.L$4 = SpillingKt.nullOutSpilledVariable(href3);
                    c03062.L$5 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u248);
                    c03062.L$6 = null;
                    c03062.label = 2;
                    function9 = function6;
                    function10 = function5;
                    c03063 = c03062;
                    href5 = href3;
                    url5 = url3;
                    i = 2;
                    obj3 = Requests.get$default(app7, str7, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03063, 4094, (Object) null);
                    c03062 = c03063;
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    url4 = url5;
                    referer4 = referer3;
                    function7 = function9;
                    function8 = function10;
                    Object obj11 = Result.constructor-impl(((NiceResponse) obj3).getDocument());
                    function11 = function7;
                    function12 = function8;
                    referer5 = referer4;
                    url6 = url4;
                    obj5 = obj11;
                    if (Result.isFailure-impl(obj5)) {
                        obj5 = null;
                    }
                    doc = (Document) obj5;
                    if (doc == null) {
                        return Unit.INSTANCE;
                    }
                    elementSelectFirst2 = doc.selectFirst("script:containsData(url)");
                    if (elementSelectFirst2 != null) {
                        strData = "";
                    } else {
                        strData = "";
                    }
                    scriptTag = strData;
                    matchResultFind$default = Regex.find$default(new Regex("atob\\(atob\\('([^']+)'\\)\\)"), scriptTag, 0, i, (Object) null);
                    if (matchResultFind$default == null) {
                        str2 = null;
                        MatchResult matchResultFind$default8 = Regex.find$default(new Regex("var\\s+url\\s*=\\s*'([^']*)'"), scriptTag, 0, i, (Object) null);
                        if (matchResultFind$default8 != null) {
                        }
                        if (str3 == null) {
                            str3 = "";
                        }
                    } else {
                        str2 = null;
                        MatchResult matchResultFind$default9 = Regex.find$default(new Regex("var\\s+url\\s*=\\s*'([^']*)'"), scriptTag, 0, i, (Object) null);
                        if (matchResultFind$default9 != null) {
                        }
                        if (str3 == null) {
                            str3 = "";
                        }
                    }
                    urlValue = str3;
                    if (urlValue.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return Unit.INSTANCE;
                    }
                    Log.INSTANCE.d("Phisher", urlValue);
                    Result.Companion companion17 = Result.Companion;
                    VCloud $this$getUrl_u24lambda_u249 = this;
                    Requests app8 = MainActivityKt.getApp();
                    c03062.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c03062.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                    c03062.L$2 = function12;
                    c03062.L$3 = function11;
                    c03062.L$4 = SpillingKt.nullOutSpilledVariable(href5);
                    c03062.L$5 = SpillingKt.nullOutSpilledVariable(doc);
                    c03062.L$6 = SpillingKt.nullOutSpilledVariable(scriptTag);
                    c03062.L$7 = SpillingKt.nullOutSpilledVariable(urlValue);
                    c03062.L$8 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u249);
                    c03062.label = 3;
                    function15 = function11;
                    c03065 = c03062;
                    urlValue4 = urlValue;
                    strText = str2;
                    function16 = function12;
                    obj6 = Requests.get$default(app8, urlValue4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03065, 4094, (Object) null);
                    c03064 = c03065;
                    if (obj6 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function13 = function15;
                    url7 = url6;
                    urlValue3 = scriptTag;
                    href7 = href5;
                    doc2 = doc;
                    obj8 = Result.constructor-impl(((NiceResponse) obj6).getDocument());
                    urlValue2 = urlValue4;
                    function17 = function16;
                    if (Result.isFailure-impl(obj8)) {
                        obj8 = strText;
                    }
                    document = (Document) obj8;
                    if (document == null) {
                        return Unit.INSTANCE;
                    }
                    elementSelectFirst3 = document.selectFirst("i#size");
                    if (elementSelectFirst3 != null) {
                        size = elementSelectFirst3.text();
                    } else {
                        size = strText;
                    }
                    if (size == null) {
                        size = "";
                    }
                    elementSelectFirst4 = document.selectFirst("div.card-header");
                    if (elementSelectFirst4 != null) {
                        strText = elementSelectFirst4.text();
                    }
                    if (strText == null) {
                        header = "";
                    } else {
                        header = strText;
                    }
                    headerdetails = cleanTitle(header);
                    $this$getUrl_u24lambda_u244 = new StringBuilder();
                    if (headerdetails.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                        $this$getUrl_u24lambda_u245.append(headerdetails);
                    } else {
                        $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                    }
                    if (size.length() > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        $this$getUrl_u24lambda_u245.append(" [" + size + ']');
                    }
                    labelExtras = $this$getUrl_u24lambda_u244.toString();
                    div = document.selectFirst("div.card-body");
                    if (div == null) {
                        return Unit.INSTANCE;
                    }
                    listSelect = div.select("h2 a.btn");
                    String size6 = size;
                    Function1<? super ExtractorLink, Unit> function112 = function13;
                    c03073 = new C03073(header2, function112, labelExtras, function17, null);
                    c03064.L$0 = SpillingKt.nullOutSpilledVariable(url7);
                    c03064.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                    c03064.L$2 = SpillingKt.nullOutSpilledVariable(function17);
                    c03064.L$3 = SpillingKt.nullOutSpilledVariable(function112);
                    c03064.L$4 = SpillingKt.nullOutSpilledVariable(href7);
                    c03064.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                    c03064.L$6 = SpillingKt.nullOutSpilledVariable(urlValue3);
                    c03064.L$7 = SpillingKt.nullOutSpilledVariable(urlValue2);
                    c03064.L$8 = SpillingKt.nullOutSpilledVariable(document);
                    c03064.L$9 = SpillingKt.nullOutSpilledVariable(size6);
                    c03064.L$10 = SpillingKt.nullOutSpilledVariable(header2);
                    c03064.L$11 = SpillingKt.nullOutSpilledVariable(headerdetails);
                    c03064.L$12 = SpillingKt.nullOutSpilledVariable(labelExtras);
                    c03064.L$13 = SpillingKt.nullOutSpilledVariable(div);
                    c03064.label = 4;
                    if (ParCollectionsKt.amap(listSelect, c03073, c03064) == coroutine_suspended) {
                        header2 = header;
                        return coroutine_suspended;
                    }
                    header2 = header;
                    return Unit.INSTANCE;
                }
                href6 = href2;
                obj4 = obj2;
                objectRef = href;
                if (Result.isFailure-impl(obj4)) {
                    obj4 = null;
                }
                str = (String) obj4;
                if (str == null) {
                    return Unit.INSTANCE;
                }
                objectRef.element = str;
                href3 = href6;
                function6 = function4;
                function5 = function3;
                referer3 = referer2;
                url3 = url2;
                Log.INSTANCE.d("Phisher", (String) href3.element);
                Result.Companion companion18 = Result.Companion;
                VCloud $this$getUrl_u24lambda_u2410 = this;
                Requests app9 = MainActivityKt.getApp();
                String str8 = (String) href3.element;
                c03062.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c03062.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                c03062.L$2 = function5;
                c03062.L$3 = function6;
                c03062.L$4 = SpillingKt.nullOutSpilledVariable(href3);
                c03062.L$5 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u2410);
                c03062.L$6 = null;
                c03062.label = 2;
                function9 = function6;
                function10 = function5;
                c03063 = c03062;
                href5 = href3;
                url5 = url3;
                i = 2;
                obj3 = Requests.get$default(app9, str8, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03063, 4094, (Object) null);
                c03062 = c03063;
                if (obj3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url4 = url5;
                referer4 = referer3;
                function7 = function9;
                function8 = function10;
                Object obj12 = Result.constructor-impl(((NiceResponse) obj3).getDocument());
                function11 = function7;
                function12 = function8;
                referer5 = referer4;
                url6 = url4;
                obj5 = obj12;
                if (Result.isFailure-impl(obj5)) {
                    obj5 = null;
                }
                doc = (Document) obj5;
                if (doc == null) {
                    return Unit.INSTANCE;
                }
                elementSelectFirst2 = doc.selectFirst("script:containsData(url)");
                if (elementSelectFirst2 != null) {
                    strData = "";
                } else {
                    strData = "";
                }
                scriptTag = strData;
                matchResultFind$default = Regex.find$default(new Regex("atob\\(atob\\('([^']+)'\\)\\)"), scriptTag, 0, i, (Object) null);
                if (matchResultFind$default == null) {
                    str2 = null;
                    MatchResult matchResultFind$default10 = Regex.find$default(new Regex("var\\s+url\\s*=\\s*'([^']*)'"), scriptTag, 0, i, (Object) null);
                    if (matchResultFind$default10 != null) {
                    }
                    if (str3 == null) {
                        str3 = "";
                    }
                } else {
                    str2 = null;
                    MatchResult matchResultFind$default11 = Regex.find$default(new Regex("var\\s+url\\s*=\\s*'([^']*)'"), scriptTag, 0, i, (Object) null);
                    if (matchResultFind$default11 != null) {
                    }
                    if (str3 == null) {
                        str3 = "";
                    }
                }
                urlValue = str3;
                if (urlValue.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return Unit.INSTANCE;
                }
                Log.INSTANCE.d("Phisher", urlValue);
                Result.Companion companion19 = Result.Companion;
                VCloud $this$getUrl_u24lambda_u2411 = this;
                Requests app10 = MainActivityKt.getApp();
                c03062.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                c03062.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                c03062.L$2 = function12;
                c03062.L$3 = function11;
                c03062.L$4 = SpillingKt.nullOutSpilledVariable(href5);
                c03062.L$5 = SpillingKt.nullOutSpilledVariable(doc);
                c03062.L$6 = SpillingKt.nullOutSpilledVariable(scriptTag);
                c03062.L$7 = SpillingKt.nullOutSpilledVariable(urlValue);
                c03062.L$8 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u2411);
                c03062.label = 3;
                function15 = function11;
                c03065 = c03062;
                urlValue4 = urlValue;
                strText = str2;
                function16 = function12;
                obj6 = Requests.get$default(app10, urlValue4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03065, 4094, (Object) null);
                c03064 = c03065;
                if (obj6 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function13 = function15;
                url7 = url6;
                urlValue3 = scriptTag;
                href7 = href5;
                doc2 = doc;
                obj8 = Result.constructor-impl(((NiceResponse) obj6).getDocument());
                urlValue2 = urlValue4;
                function17 = function16;
                if (Result.isFailure-impl(obj8)) {
                    obj8 = strText;
                }
                document = (Document) obj8;
                if (document == null) {
                    return Unit.INSTANCE;
                }
                elementSelectFirst3 = document.selectFirst("i#size");
                if (elementSelectFirst3 != null) {
                    size = elementSelectFirst3.text();
                } else {
                    size = strText;
                }
                if (size == null) {
                    size = "";
                }
                elementSelectFirst4 = document.selectFirst("div.card-header");
                if (elementSelectFirst4 != null) {
                    strText = elementSelectFirst4.text();
                }
                if (strText == null) {
                    header = "";
                } else {
                    header = strText;
                }
                headerdetails = cleanTitle(header);
                $this$getUrl_u24lambda_u244 = new StringBuilder();
                if (headerdetails.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                    $this$getUrl_u24lambda_u245.append(headerdetails);
                } else {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                }
                if (size.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    $this$getUrl_u24lambda_u245.append(" [" + size + ']');
                }
                labelExtras = $this$getUrl_u24lambda_u244.toString();
                div = document.selectFirst("div.card-body");
                if (div == null) {
                    return Unit.INSTANCE;
                }
                listSelect = div.select("h2 a.btn");
                String size7 = size;
                Function1<? super ExtractorLink, Unit> function113 = function13;
                c03073 = new C03073(header2, function113, labelExtras, function17, null);
                c03064.L$0 = SpillingKt.nullOutSpilledVariable(url7);
                c03064.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                c03064.L$2 = SpillingKt.nullOutSpilledVariable(function17);
                c03064.L$3 = SpillingKt.nullOutSpilledVariable(function113);
                c03064.L$4 = SpillingKt.nullOutSpilledVariable(href7);
                c03064.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                c03064.L$6 = SpillingKt.nullOutSpilledVariable(urlValue3);
                c03064.L$7 = SpillingKt.nullOutSpilledVariable(urlValue2);
                c03064.L$8 = SpillingKt.nullOutSpilledVariable(document);
                c03064.L$9 = SpillingKt.nullOutSpilledVariable(size7);
                c03064.L$10 = SpillingKt.nullOutSpilledVariable(header2);
                c03064.L$11 = SpillingKt.nullOutSpilledVariable(headerdetails);
                c03064.L$12 = SpillingKt.nullOutSpilledVariable(labelExtras);
                c03064.L$13 = SpillingKt.nullOutSpilledVariable(div);
                c03064.label = 4;
                if (ParCollectionsKt.amap(listSelect, c03073, c03064) == coroutine_suspended) {
                    header2 = header;
                    return coroutine_suspended;
                }
                header2 = header;
                return Unit.INSTANCE;
            case 2:
                href4 = (Ref.ObjectRef) c03066.L$4;
                function7 = (Function1) c03066.L$3;
                function8 = (Function1) c03066.L$2;
                referer4 = (String) c03066.L$1;
                url4 = (String) c03066.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj3 = $result;
                    href5 = href4;
                    c03062 = c03066;
                    i = 2;
                    Object obj13 = Result.constructor-impl(((NiceResponse) obj3).getDocument());
                    function11 = function7;
                    function12 = function8;
                    referer5 = referer4;
                    url6 = url4;
                    obj5 = obj13;
                } catch (Throwable th12) {
                    th = th12;
                    c03062 = c03066;
                    i = 2;
                    Result.Companion companion110 = Result.Companion;
                    href5 = href4;
                    function11 = function7;
                    function12 = function8;
                    referer5 = referer4;
                    url6 = url4;
                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.isFailure-impl(obj5)) {
                        obj5 = null;
                    }
                    doc = (Document) obj5;
                    if (doc == null) {
                        return Unit.INSTANCE;
                    }
                    elementSelectFirst2 = doc.selectFirst("script:containsData(url)");
                    if (elementSelectFirst2 != null) {
                        strData = "";
                    } else {
                        strData = "";
                    }
                    scriptTag = strData;
                    matchResultFind$default = Regex.find$default(new Regex("atob\\(atob\\('([^']+)'\\)\\)"), scriptTag, 0, i, (Object) null);
                    if (matchResultFind$default == null) {
                        str2 = null;
                        MatchResult matchResultFind$default12 = Regex.find$default(new Regex("var\\s+url\\s*=\\s*'([^']*)'"), scriptTag, 0, i, (Object) null);
                        if (matchResultFind$default12 != null) {
                        }
                        if (str3 == null) {
                            str3 = "";
                        }
                    } else {
                        str2 = null;
                        MatchResult matchResultFind$default13 = Regex.find$default(new Regex("var\\s+url\\s*=\\s*'([^']*)'"), scriptTag, 0, i, (Object) null);
                        if (matchResultFind$default13 != null) {
                        }
                        if (str3 == null) {
                            str3 = "";
                        }
                    }
                    urlValue = str3;
                    if (urlValue.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return Unit.INSTANCE;
                    }
                    Log.INSTANCE.d("Phisher", urlValue);
                    Result.Companion companion111 = Result.Companion;
                    VCloud $this$getUrl_u24lambda_u2412 = this;
                    Requests app11 = MainActivityKt.getApp();
                    c03062.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c03062.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                    c03062.L$2 = function12;
                    c03062.L$3 = function11;
                    c03062.L$4 = SpillingKt.nullOutSpilledVariable(href5);
                    c03062.L$5 = SpillingKt.nullOutSpilledVariable(doc);
                    c03062.L$6 = SpillingKt.nullOutSpilledVariable(scriptTag);
                    c03062.L$7 = SpillingKt.nullOutSpilledVariable(urlValue);
                    c03062.L$8 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u2412);
                    c03062.label = 3;
                    function15 = function11;
                    c03065 = c03062;
                    urlValue4 = urlValue;
                    strText = str2;
                    function16 = function12;
                    obj6 = Requests.get$default(app11, urlValue4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03065, 4094, (Object) null);
                    c03064 = c03065;
                    if (obj6 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function13 = function15;
                    url7 = url6;
                    urlValue3 = scriptTag;
                    href7 = href5;
                    doc2 = doc;
                    obj8 = Result.constructor-impl(((NiceResponse) obj6).getDocument());
                    urlValue2 = urlValue4;
                    function17 = function16;
                    if (Result.isFailure-impl(obj8)) {
                        obj8 = strText;
                    }
                    document = (Document) obj8;
                    if (document == null) {
                        return Unit.INSTANCE;
                    }
                    elementSelectFirst3 = document.selectFirst("i#size");
                    if (elementSelectFirst3 != null) {
                        size = elementSelectFirst3.text();
                    } else {
                        size = strText;
                    }
                    if (size == null) {
                        size = "";
                    }
                    elementSelectFirst4 = document.selectFirst("div.card-header");
                    if (elementSelectFirst4 != null) {
                        strText = elementSelectFirst4.text();
                    }
                    if (strText == null) {
                        header = "";
                    } else {
                        header = strText;
                    }
                    headerdetails = cleanTitle(header);
                    $this$getUrl_u24lambda_u244 = new StringBuilder();
                    if (headerdetails.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                        $this$getUrl_u24lambda_u245.append(headerdetails);
                    } else {
                        $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                    }
                    if (size.length() > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        $this$getUrl_u24lambda_u245.append(" [" + size + ']');
                    }
                    labelExtras = $this$getUrl_u24lambda_u244.toString();
                    div = document.selectFirst("div.card-body");
                    if (div == null) {
                        return Unit.INSTANCE;
                    }
                    listSelect = div.select("h2 a.btn");
                    String size8 = size;
                    Function1<? super ExtractorLink, Unit> function114 = function13;
                    c03073 = new C03073(header2, function114, labelExtras, function17, null);
                    c03064.L$0 = SpillingKt.nullOutSpilledVariable(url7);
                    c03064.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                    c03064.L$2 = SpillingKt.nullOutSpilledVariable(function17);
                    c03064.L$3 = SpillingKt.nullOutSpilledVariable(function114);
                    c03064.L$4 = SpillingKt.nullOutSpilledVariable(href7);
                    c03064.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                    c03064.L$6 = SpillingKt.nullOutSpilledVariable(urlValue3);
                    c03064.L$7 = SpillingKt.nullOutSpilledVariable(urlValue2);
                    c03064.L$8 = SpillingKt.nullOutSpilledVariable(document);
                    c03064.L$9 = SpillingKt.nullOutSpilledVariable(size8);
                    c03064.L$10 = SpillingKt.nullOutSpilledVariable(header2);
                    c03064.L$11 = SpillingKt.nullOutSpilledVariable(headerdetails);
                    c03064.L$12 = SpillingKt.nullOutSpilledVariable(labelExtras);
                    c03064.L$13 = SpillingKt.nullOutSpilledVariable(div);
                    c03064.label = 4;
                    if (ParCollectionsKt.amap(listSelect, c03073, c03064) == coroutine_suspended) {
                        header2 = header;
                        return coroutine_suspended;
                    }
                    header2 = header;
                    return Unit.INSTANCE;
                }
                if (Result.isFailure-impl(obj5)) {
                    obj5 = null;
                }
                doc = (Document) obj5;
                if (doc == null) {
                    return Unit.INSTANCE;
                }
                elementSelectFirst2 = doc.selectFirst("script:containsData(url)");
                if (elementSelectFirst2 != null) {
                    strData = "";
                } else {
                    strData = "";
                }
                scriptTag = strData;
                matchResultFind$default = Regex.find$default(new Regex("atob\\(atob\\('([^']+)'\\)\\)"), scriptTag, 0, i, (Object) null);
                if (matchResultFind$default == null) {
                    str2 = null;
                    MatchResult matchResultFind$default14 = Regex.find$default(new Regex("var\\s+url\\s*=\\s*'([^']*)'"), scriptTag, 0, i, (Object) null);
                    if (matchResultFind$default14 != null) {
                    }
                    if (str3 == null) {
                        str3 = "";
                    }
                } else {
                    str2 = null;
                    MatchResult matchResultFind$default15 = Regex.find$default(new Regex("var\\s+url\\s*=\\s*'([^']*)'"), scriptTag, 0, i, (Object) null);
                    if (matchResultFind$default15 != null) {
                    }
                    if (str3 == null) {
                        str3 = "";
                    }
                }
                urlValue = str3;
                if (urlValue.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return Unit.INSTANCE;
                }
                Log.INSTANCE.d("Phisher", urlValue);
                Result.Companion companion112 = Result.Companion;
                VCloud $this$getUrl_u24lambda_u2413 = this;
                Requests app12 = MainActivityKt.getApp();
                c03062.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                c03062.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                c03062.L$2 = function12;
                c03062.L$3 = function11;
                c03062.L$4 = SpillingKt.nullOutSpilledVariable(href5);
                c03062.L$5 = SpillingKt.nullOutSpilledVariable(doc);
                c03062.L$6 = SpillingKt.nullOutSpilledVariable(scriptTag);
                c03062.L$7 = SpillingKt.nullOutSpilledVariable(urlValue);
                c03062.L$8 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u2413);
                c03062.label = 3;
                function15 = function11;
                c03065 = c03062;
                urlValue4 = urlValue;
                strText = str2;
                function16 = function12;
                obj6 = Requests.get$default(app12, urlValue4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03065, 4094, (Object) null);
                c03064 = c03065;
                if (obj6 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function13 = function15;
                url7 = url6;
                urlValue3 = scriptTag;
                href7 = href5;
                doc2 = doc;
                obj8 = Result.constructor-impl(((NiceResponse) obj6).getDocument());
                urlValue2 = urlValue4;
                function17 = function16;
                if (Result.isFailure-impl(obj8)) {
                    obj8 = strText;
                }
                document = (Document) obj8;
                if (document == null) {
                    return Unit.INSTANCE;
                }
                elementSelectFirst3 = document.selectFirst("i#size");
                if (elementSelectFirst3 != null) {
                    size = elementSelectFirst3.text();
                } else {
                    size = strText;
                }
                if (size == null) {
                    size = "";
                }
                elementSelectFirst4 = document.selectFirst("div.card-header");
                if (elementSelectFirst4 != null) {
                    strText = elementSelectFirst4.text();
                }
                if (strText == null) {
                    header = "";
                } else {
                    header = strText;
                }
                headerdetails = cleanTitle(header);
                $this$getUrl_u24lambda_u244 = new StringBuilder();
                if (headerdetails.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                    $this$getUrl_u24lambda_u245.append(headerdetails);
                } else {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                }
                if (size.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    $this$getUrl_u24lambda_u245.append(" [" + size + ']');
                }
                labelExtras = $this$getUrl_u24lambda_u244.toString();
                div = document.selectFirst("div.card-body");
                if (div == null) {
                    return Unit.INSTANCE;
                }
                listSelect = div.select("h2 a.btn");
                String size9 = size;
                Function1<? super ExtractorLink, Unit> function115 = function13;
                c03073 = new C03073(header2, function115, labelExtras, function17, null);
                c03064.L$0 = SpillingKt.nullOutSpilledVariable(url7);
                c03064.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                c03064.L$2 = SpillingKt.nullOutSpilledVariable(function17);
                c03064.L$3 = SpillingKt.nullOutSpilledVariable(function115);
                c03064.L$4 = SpillingKt.nullOutSpilledVariable(href7);
                c03064.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                c03064.L$6 = SpillingKt.nullOutSpilledVariable(urlValue3);
                c03064.L$7 = SpillingKt.nullOutSpilledVariable(urlValue2);
                c03064.L$8 = SpillingKt.nullOutSpilledVariable(document);
                c03064.L$9 = SpillingKt.nullOutSpilledVariable(size9);
                c03064.L$10 = SpillingKt.nullOutSpilledVariable(header2);
                c03064.L$11 = SpillingKt.nullOutSpilledVariable(headerdetails);
                c03064.L$12 = SpillingKt.nullOutSpilledVariable(labelExtras);
                c03064.L$13 = SpillingKt.nullOutSpilledVariable(div);
                c03064.label = 4;
                if (ParCollectionsKt.amap(listSelect, c03073, c03064) == coroutine_suspended) {
                    header2 = header;
                    return coroutine_suspended;
                }
                header2 = header;
                return Unit.INSTANCE;
            case 3:
                urlValue2 = (String) c03066.L$7;
                urlValue3 = (String) c03066.L$6;
                doc2 = (Document) c03066.L$5;
                href7 = (Ref.ObjectRef) c03066.L$4;
                function13 = (Function1) c03066.L$3;
                function14 = (Function1) c03066.L$2;
                String referer6 = (String) c03066.L$1;
                url7 = (String) c03066.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    function16 = function14;
                    referer5 = referer6;
                    strText = null;
                    c03064 = c03066;
                    urlValue4 = urlValue2;
                    obj6 = $result;
                    obj8 = Result.constructor-impl(((NiceResponse) obj6).getDocument());
                    urlValue2 = urlValue4;
                    function17 = function16;
                } catch (Throwable th13) {
                    th = th13;
                    referer5 = referer6;
                    strText = null;
                    c03064 = c03066;
                    Result.Companion companion20 = Result.Companion;
                    obj8 = Result.constructor-impl(ResultKt.createFailure(th));
                    function17 = function14;
                    if (Result.isFailure-impl(obj8)) {
                        obj8 = strText;
                    }
                    document = (Document) obj8;
                    if (document == null) {
                        return Unit.INSTANCE;
                    }
                    elementSelectFirst3 = document.selectFirst("i#size");
                    if (elementSelectFirst3 != null) {
                        size = elementSelectFirst3.text();
                    } else {
                        size = strText;
                    }
                    if (size == null) {
                        size = "";
                    }
                    elementSelectFirst4 = document.selectFirst("div.card-header");
                    if (elementSelectFirst4 != null) {
                        strText = elementSelectFirst4.text();
                    }
                    if (strText == null) {
                        header = "";
                    } else {
                        header = strText;
                    }
                    headerdetails = cleanTitle(header);
                    $this$getUrl_u24lambda_u244 = new StringBuilder();
                    if (headerdetails.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                        $this$getUrl_u24lambda_u245.append(headerdetails);
                    } else {
                        $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                    }
                    if (size.length() > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        $this$getUrl_u24lambda_u245.append(" [" + size + ']');
                    }
                    labelExtras = $this$getUrl_u24lambda_u244.toString();
                    div = document.selectFirst("div.card-body");
                    if (div == null) {
                        return Unit.INSTANCE;
                    }
                    listSelect = div.select("h2 a.btn");
                    String size10 = size;
                    Function1<? super ExtractorLink, Unit> function116 = function13;
                    c03073 = new C03073(header2, function116, labelExtras, function17, null);
                    c03064.L$0 = SpillingKt.nullOutSpilledVariable(url7);
                    c03064.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                    c03064.L$2 = SpillingKt.nullOutSpilledVariable(function17);
                    c03064.L$3 = SpillingKt.nullOutSpilledVariable(function116);
                    c03064.L$4 = SpillingKt.nullOutSpilledVariable(href7);
                    c03064.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                    c03064.L$6 = SpillingKt.nullOutSpilledVariable(urlValue3);
                    c03064.L$7 = SpillingKt.nullOutSpilledVariable(urlValue2);
                    c03064.L$8 = SpillingKt.nullOutSpilledVariable(document);
                    c03064.L$9 = SpillingKt.nullOutSpilledVariable(size10);
                    c03064.L$10 = SpillingKt.nullOutSpilledVariable(header2);
                    c03064.L$11 = SpillingKt.nullOutSpilledVariable(headerdetails);
                    c03064.L$12 = SpillingKt.nullOutSpilledVariable(labelExtras);
                    c03064.L$13 = SpillingKt.nullOutSpilledVariable(div);
                    c03064.label = 4;
                    if (ParCollectionsKt.amap(listSelect, c03073, c03064) == coroutine_suspended) {
                        header2 = header;
                        return coroutine_suspended;
                    }
                    header2 = header;
                    return Unit.INSTANCE;
                }
                if (Result.isFailure-impl(obj8)) {
                    obj8 = strText;
                }
                document = (Document) obj8;
                if (document == null) {
                    return Unit.INSTANCE;
                }
                elementSelectFirst3 = document.selectFirst("i#size");
                if (elementSelectFirst3 != null) {
                    size = elementSelectFirst3.text();
                } else {
                    size = strText;
                }
                if (size == null) {
                    size = "";
                }
                elementSelectFirst4 = document.selectFirst("div.card-header");
                if (elementSelectFirst4 != null) {
                    strText = elementSelectFirst4.text();
                }
                if (strText == null) {
                    header = "";
                } else {
                    header = strText;
                }
                headerdetails = cleanTitle(header);
                $this$getUrl_u24lambda_u244 = new StringBuilder();
                if (headerdetails.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                    $this$getUrl_u24lambda_u245.append(headerdetails);
                } else {
                    $this$getUrl_u24lambda_u245 = $this$getUrl_u24lambda_u244;
                }
                if (size.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    $this$getUrl_u24lambda_u245.append(" [" + size + ']');
                }
                labelExtras = $this$getUrl_u24lambda_u244.toString();
                div = document.selectFirst("div.card-body");
                if (div == null) {
                    return Unit.INSTANCE;
                }
                listSelect = div.select("h2 a.btn");
                String size11 = size;
                Function1<? super ExtractorLink, Unit> function117 = function13;
                c03073 = new C03073(header2, function117, labelExtras, function17, null);
                c03064.L$0 = SpillingKt.nullOutSpilledVariable(url7);
                c03064.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                c03064.L$2 = SpillingKt.nullOutSpilledVariable(function17);
                c03064.L$3 = SpillingKt.nullOutSpilledVariable(function117);
                c03064.L$4 = SpillingKt.nullOutSpilledVariable(href7);
                c03064.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                c03064.L$6 = SpillingKt.nullOutSpilledVariable(urlValue3);
                c03064.L$7 = SpillingKt.nullOutSpilledVariable(urlValue2);
                c03064.L$8 = SpillingKt.nullOutSpilledVariable(document);
                c03064.L$9 = SpillingKt.nullOutSpilledVariable(size11);
                c03064.L$10 = SpillingKt.nullOutSpilledVariable(header2);
                c03064.L$11 = SpillingKt.nullOutSpilledVariable(headerdetails);
                c03064.L$12 = SpillingKt.nullOutSpilledVariable(labelExtras);
                c03064.L$13 = SpillingKt.nullOutSpilledVariable(div);
                c03064.label = 4;
                if (ParCollectionsKt.amap(listSelect, c03073, c03064) == coroutine_suspended) {
                    header2 = header;
                    return coroutine_suspended;
                }
                header2 = header;
                return Unit.INSTANCE;
            case 4:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.VCloud$getUrl$3 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.VCloud$getUrl$3", f = "Extractors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10}, l = {376, 386, 395, 399, 416, 426, 435, 438, 448, 458, 467}, m = "invokeSuspend", n = {"it", "link", "text", "quality", "it", "link", "text", "quality", "it", "link", "text", "quality", "it", "link", "text", "dlink", "baseUrl", "quality", "it", "link", "text", "baseUrlLink", "finalURL", "quality", "it", "link", "text", "quality", "it", "link", "text", "quality", "it", "link", "text", "redirectUrl", "quality", "it", "link", "text", "quality", "it", "link", "text", "quality", "it", "link", "text", "quality"}, nl = {375, 385, 396, 398, 415, 425, 436, 437, 447, 457, 470}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C03073 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $header;
        final /* synthetic */ String $labelExtras;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int I$0;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03073(String str, Function1<? super ExtractorLink, Unit> function1, String str2, Function1<? super SubtitleFile, Unit> function2, Continuation<? super C03073> continuation) {
            super(2, continuation);
            this.$header = str;
            this.$callback = function1;
            this.$labelExtras = str2;
            this.$subtitleCallback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c03073 = VCloud.this.new C03073(this.$header, this.$callback, this.$labelExtras, this.$subtitleCallback, continuation);
            c03073.L$0 = obj;
            return c03073;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:40:0x026e  */
        /* JADX WARN: Code duplicated, block: B:43:0x027c  */
        /* JADX WARN: Code duplicated, block: B:45:0x027f  */
        /* JADX WARN: Code duplicated, block: B:47:0x02e7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:48:0x02e8  */
        /* JADX WARN: Code duplicated, block: B:50:0x02f2  */
        /* JADX WARN: Code duplicated, block: B:74:0x03c8  */
        /* JADX WARN: Code duplicated, block: B:76:0x03cb  */
        /* JADX WARN: Code duplicated, block: B:78:0x03d9  */
        /* JADX WARN: Code duplicated, block: B:81:0x0432 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:82:0x0433  */
        public final Object invokeSuspend(Object $result) {
            String link;
            String text;
            Function1<ExtractorLink, Unit> function1;
            Object obj;
            String link2;
            Object objNewExtractorLink$default;
            String text2;
            Function1<ExtractorLink, Unit> function2;
            String link3;
            Object objNewExtractorLink$default2;
            String text3;
            Function1<ExtractorLink, Unit> function3;
            String link4;
            Object objResolveFinalUrl;
            String link5;
            int quality;
            Object objNewExtractorLink$default3;
            String text4;
            Function1<ExtractorLink, Unit> function4;
            String link6;
            String text5;
            int quality2;
            Object obj2;
            String link7;
            Object objNewExtractorLink$default4;
            String text6;
            Function1<ExtractorLink, Unit> function5;
            String link8;
            Object objNewExtractorLink$default5;
            String text7;
            Function1<ExtractorLink, Unit> function6;
            String link9;
            String dlink;
            String baseUrl;
            Function1<ExtractorLink, Unit> function7;
            Object objNewExtractorLink$default6;
            Function1<ExtractorLink, Unit> function8;
            String redirectUrl;
            Function1<ExtractorLink, Unit> function9;
            Object objNewExtractorLink$default7;
            Object obj3;
            String text8;
            Function1<ExtractorLink, Unit> function10;
            String link10;
            Element it = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    link = it.attr("href");
                    String text9 = it.text();
                    int quality3 = VCloud.this.getIndexQuality(this.$header);
                    Log.INSTANCE.d("Phisher", link);
                    Log.INSTANCE.d("Phisher", text9);
                    if (StringsKt.contains(text9, "FSLv2", true)) {
                        Function1<ExtractorLink, Unit> function11 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text9);
                        this.L$3 = function11;
                        this.I$0 = quality3;
                        this.label = 1;
                        objNewExtractorLink$default5 = ExtractorApiKt.newExtractorLink$default("FSLv2", "[FSLv2] " + this.$labelExtras, link, (ExtractorLinkType) null, new AnonymousClass1(quality3, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default5 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        text7 = text9;
                        function6 = function11;
                        link9 = link;
                        function6.invoke(objNewExtractorLink$default5);
                        Unit unit = Unit.INSTANCE;
                    } else if (StringsKt.contains$default(text9, "FSL", false, 2, (Object) null)) {
                        Function1<ExtractorLink, Unit> function12 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text9);
                        this.L$3 = function12;
                        this.I$0 = quality3;
                        this.label = 2;
                        objNewExtractorLink$default4 = ExtractorApiKt.newExtractorLink$default("FSL Server", "[FSL Server] " + this.$labelExtras, link, (ExtractorLinkType) null, new AnonymousClass2(quality3, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        text6 = text9;
                        function5 = function12;
                        link8 = link;
                        function5.invoke(objNewExtractorLink$default4);
                        Unit unit2 = Unit.INSTANCE;
                    } else if (StringsKt.contains$default(text9, "BuzzServer", false, 2, (Object) null)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = link;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text9);
                        this.I$0 = quality3;
                        this.label = 3;
                        Object obj4 = Requests.get$default(MainActivityKt.getApp(), link + "/download", (Map) null, link, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4058, (Object) null);
                        if (obj4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        text5 = text9;
                        quality2 = quality3;
                        obj2 = obj4;
                        link7 = link;
                        String str = ((NiceResponse) obj2).getHeaders().get("hx-redirect");
                        dlink = str != null ? str : "";
                        baseUrl = StreamPlayUtilsKt.getBaseUrl(link7);
                        if (dlink.length() > 0) {
                            function7 = this.$callback;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(link7);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(text5);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(dlink);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(baseUrl);
                            this.L$5 = function7;
                            this.I$0 = quality2;
                            this.label = 4;
                            objNewExtractorLink$default6 = ExtractorApiKt.newExtractorLink$default("BuzzServer", "[BuzzServer] " + this.$labelExtras, baseUrl + dlink, (ExtractorLinkType) null, new AnonymousClass3(quality2, null), (Continuation) this, 8, (Object) null);
                            if (objNewExtractorLink$default6 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function8 = function7;
                            function8.invoke(objNewExtractorLink$default6);
                        } else {
                            Log.INSTANCE.w("Error:", "Not Found");
                        }
                        Unit unit3 = Unit.INSTANCE;
                    } else if (StringsKt.contains(text9, "pixeldra", true) || StringsKt.contains(text9, "pixel", true) || StringsKt.contains(text9, "PixeLServer", true)) {
                        String baseUrlLink = StreamPlayUtilsKt.getBaseUrl(link);
                        String finalURL = StringsKt.contains(link, "download", true) ? link : baseUrlLink + "/api/file/" + StringsKt.substringAfterLast$default(link, "/", (String) null, 2, (Object) null) + "?download";
                        Function1<ExtractorLink, Unit> function13 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text9);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(baseUrlLink);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(finalURL);
                        this.L$5 = function13;
                        this.I$0 = quality3;
                        this.label = 5;
                        Object objNewExtractorLink$default8 = ExtractorApiKt.newExtractorLink$default("Pixeldrain", "[Pixeldrain] " + this.$labelExtras, finalURL, (ExtractorLinkType) null, new AnonymousClass4(quality3, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default8 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        text = text9;
                        function1 = function13;
                        obj = objNewExtractorLink$default8;
                        link2 = link;
                        function1.invoke(obj);
                        Unit unit4 = Unit.INSTANCE;
                    } else if (StringsKt.contains$default(text9, "PDL Server", false, 2, (Object) null)) {
                        Function1<ExtractorLink, Unit> function14 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text9);
                        this.L$3 = function14;
                        this.I$0 = quality3;
                        this.label = 6;
                        objNewExtractorLink$default3 = ExtractorApiKt.newExtractorLink$default("PDL Server", "[PDL Server] " + this.$labelExtras, link, (ExtractorLinkType) null, new AnonymousClass5(quality3, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        text4 = text9;
                        function4 = function14;
                        link6 = link;
                        function4.invoke(objNewExtractorLink$default3);
                        Unit unit5 = Unit.INSTANCE;
                    } else if (StringsKt.contains(text9, "10Gbps", true)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text9);
                        this.I$0 = quality3;
                        this.label = 7;
                        objResolveFinalUrl = ExtractorsKt.resolveFinalUrl(link, (Continuation) this);
                        if (objResolveFinalUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        link5 = text9;
                        quality = quality3;
                        redirectUrl = (String) objResolveFinalUrl;
                        if (redirectUrl == null) {
                            return Unit.INSTANCE;
                        }
                        if (StringsKt.contains$default(redirectUrl, "link=", false, 2, (Object) null)) {
                            redirectUrl = StringsKt.substringAfter$default(redirectUrl, "link=", (String) null, 2, (Object) null);
                        }
                        String redirectUrl2 = redirectUrl;
                        function9 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(link5);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(redirectUrl2);
                        this.L$4 = function9;
                        this.I$0 = quality;
                        this.label = 8;
                        objNewExtractorLink$default7 = ExtractorApiKt.newExtractorLink$default("10Gbps [Download]", "10Gbps [Download] " + this.$labelExtras, redirectUrl2, (ExtractorLinkType) null, new AnonymousClass6(quality, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default7 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        String str2 = link5;
                        obj3 = objNewExtractorLink$default7;
                        text8 = str2;
                        function10 = function9;
                        link10 = link;
                        function10.invoke(obj3);
                        Unit unit6 = Unit.INSTANCE;
                    } else if (StringsKt.contains(text9, "S3 Server", true)) {
                        Function1<ExtractorLink, Unit> function15 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text9);
                        this.L$3 = function15;
                        this.I$0 = quality3;
                        this.label = 9;
                        objNewExtractorLink$default2 = ExtractorApiKt.newExtractorLink$default("S3 Server", "[S3 Server] " + this.$labelExtras, link, (ExtractorLinkType) null, new AnonymousClass7(quality3, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        text3 = text9;
                        function3 = function15;
                        link4 = link;
                        function3.invoke(objNewExtractorLink$default2);
                        Unit unit7 = Unit.INSTANCE;
                    } else if (StringsKt.contains(text9, "Mega Server", true)) {
                        Function1<ExtractorLink, Unit> function16 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text9);
                        this.L$3 = function16;
                        this.I$0 = quality3;
                        this.label = 10;
                        objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("Mega Server", "[Mega Server] " + this.$labelExtras, link, (ExtractorLinkType) null, new AnonymousClass8(quality3, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        text2 = text9;
                        function2 = function16;
                        link3 = link;
                        function2.invoke(objNewExtractorLink$default);
                        Unit unit8 = Unit.INSTANCE;
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text9);
                        this.I$0 = quality3;
                        this.label = 11;
                        if (ExtractorApiKt.loadExtractor(link, "", this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    int quality4 = this.I$0;
                    function6 = (Function1) this.L$3;
                    text7 = (String) this.L$2;
                    link9 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink$default5 = $result;
                    function6.invoke(objNewExtractorLink$default5);
                    Unit unit9 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 2:
                    int i = this.I$0;
                    function5 = (Function1) this.L$3;
                    text6 = (String) this.L$2;
                    link8 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink$default4 = $result;
                    function5.invoke(objNewExtractorLink$default4);
                    Unit unit10 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 3:
                    quality2 = this.I$0;
                    text5 = (String) this.L$2;
                    link7 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    obj2 = $result;
                    String str3 = ((NiceResponse) obj2).getHeaders().get("hx-redirect");
                    if (str3 != null) {
                    }
                    baseUrl = StreamPlayUtilsKt.getBaseUrl(link7);
                    if (dlink.length() > 0) {
                        function7 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(link7);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(text5);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(dlink);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(baseUrl);
                        this.L$5 = function7;
                        this.I$0 = quality2;
                        this.label = 4;
                        objNewExtractorLink$default6 = ExtractorApiKt.newExtractorLink$default("BuzzServer", "[BuzzServer] " + this.$labelExtras, baseUrl + dlink, (ExtractorLinkType) null, new AnonymousClass3(quality2, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default6 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function8 = function7;
                        function8.invoke(objNewExtractorLink$default6);
                    } else {
                        Log.INSTANCE.w("Error:", "Not Found");
                    }
                    Unit unit11 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 4:
                    int quality5 = this.I$0;
                    function8 = (Function1) this.L$5;
                    text5 = (String) this.L$2;
                    String link11 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    link7 = link11;
                    objNewExtractorLink$default6 = $result;
                    function8.invoke(objNewExtractorLink$default6);
                    Unit unit12 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 5:
                    int quality6 = this.I$0;
                    function1 = (Function1) this.L$5;
                    text = (String) this.L$2;
                    link2 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    function1.invoke(obj);
                    Unit unit13 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 6:
                    int i2 = this.I$0;
                    function4 = (Function1) this.L$3;
                    text4 = (String) this.L$2;
                    link6 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink$default3 = $result;
                    function4.invoke(objNewExtractorLink$default3);
                    Unit unit14 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 7:
                    quality = this.I$0;
                    String text10 = (String) this.L$2;
                    String link12 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    link = link12;
                    link5 = text10;
                    objResolveFinalUrl = $result;
                    redirectUrl = (String) objResolveFinalUrl;
                    if (redirectUrl == null) {
                        return Unit.INSTANCE;
                    }
                    if (StringsKt.contains$default(redirectUrl, "link=", false, 2, (Object) null)) {
                        redirectUrl = StringsKt.substringAfter$default(redirectUrl, "link=", (String) null, 2, (Object) null);
                    }
                    String redirectUrl3 = redirectUrl;
                    function9 = this.$callback;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(link5);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(redirectUrl3);
                    this.L$4 = function9;
                    this.I$0 = quality;
                    this.label = 8;
                    objNewExtractorLink$default7 = ExtractorApiKt.newExtractorLink$default("10Gbps [Download]", "10Gbps [Download] " + this.$labelExtras, redirectUrl3, (ExtractorLinkType) null, new AnonymousClass6(quality, null), (Continuation) this, 8, (Object) null);
                    if (objNewExtractorLink$default7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    String str4 = link5;
                    obj3 = objNewExtractorLink$default7;
                    text8 = str4;
                    function10 = function9;
                    link10 = link;
                    function10.invoke(obj3);
                    Unit unit15 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 8:
                    int quality7 = this.I$0;
                    function10 = (Function1) this.L$4;
                    text8 = (String) this.L$2;
                    link10 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    obj3 = $result;
                    function10.invoke(obj3);
                    Unit unit16 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 9:
                    int quality8 = this.I$0;
                    function3 = (Function1) this.L$3;
                    text3 = (String) this.L$2;
                    link4 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink$default2 = $result;
                    function3.invoke(objNewExtractorLink$default2);
                    Unit unit17 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 10:
                    int quality9 = this.I$0;
                    function2 = (Function1) this.L$3;
                    text2 = (String) this.L$2;
                    link3 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink$default = $result;
                    function2.invoke(objNewExtractorLink$default);
                    Unit unit18 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 11:
                    int i3 = this.I$0;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.phisher98.VCloud$getUrl$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.VCloud$getUrl$3$1", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(int i, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$quality, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
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
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.phisher98.VCloud$getUrl$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.VCloud$getUrl$3$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(int i, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.$quality, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
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
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.phisher98.VCloud$getUrl$3$3, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.VCloud$getUrl$3$3", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(int i, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass3 = new AnonymousClass3(this.$quality, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
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
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.phisher98.VCloud$getUrl$3$4, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.VCloud$getUrl$3$4", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass4 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(int i, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass4 = new AnonymousClass4(this.$quality, continuation);
                anonymousClass4.L$0 = obj;
                return anonymousClass4;
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
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.phisher98.VCloud$getUrl$3$5, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.VCloud$getUrl$3$5", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass5 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(int i, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass5 = new AnonymousClass5(this.$quality, continuation);
                anonymousClass5.L$0 = obj;
                return anonymousClass5;
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
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.phisher98.VCloud$getUrl$3$6, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.VCloud$getUrl$3$6", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass6 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass6(int i, Continuation<? super AnonymousClass6> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass6 = new AnonymousClass6(this.$quality, continuation);
                anonymousClass6.L$0 = obj;
                return anonymousClass6;
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
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.phisher98.VCloud$getUrl$3$7, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.VCloud$getUrl$3$7", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass7 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass7(int i, Continuation<? super AnonymousClass7> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass7 = new AnonymousClass7(this.$quality, continuation);
                anonymousClass7.L$0 = obj;
                return anonymousClass7;
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
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.phisher98.VCloud$getUrl$3$8, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.VCloud$getUrl$3$8", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass8 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass8(int i, Continuation<? super AnonymousClass8> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass8 = new AnonymousClass8(this.$quality, continuation);
                anonymousClass8.L$0 = obj;
                return anonymousClass8;
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
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    private final String cleanTitle(String title) {
        return ExtractorsKt.extractCleanTitle(title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getIndexQuality(String str) {
        return ExtractorsKt.extractIndexQuality$default(str, 0, 2, null);
    }
}
