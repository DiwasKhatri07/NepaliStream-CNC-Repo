package com.dudefilms;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
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
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/DudeFilms/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/dudefilms/GDFlix;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIndexQuality", "", "str", "DudeFilms"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/dudefilms/GDFlix\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,655:1\n1739#2:656\n1814#2,3:657\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/dudefilms/GDFlix\n*L\n520#1:656\n520#1:657,3\n*E\n"})
public final class GDFlix extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "GDFlix";

    @NotNull
    private final String mainUrl = "https://*.gdflix.*";

    /* JADX INFO: renamed from: com.dudefilms.GDFlix$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.dudefilms.GDFlix", f = "Extractors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {371, 381, 387, 521, 526}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "newUrl", "url", "referer", "subtitleCallback", "callback", "newUrl", "document", "fileName", "fileSize", "url", "referer", "subtitleCallback", "callback", "newUrl", "document", "fileName", "fileSize", "types", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "type", "url", "referer", "subtitleCallback", "callback", "newUrl", "document", "fileName", "fileSize", "types", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "type", "sourceurl"}, nl = {372, 382, 518, 522, 525}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
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

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GDFlix.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:47:0x0262  */
    /* JADX WARN: Code duplicated, block: B:64:0x0361 A[Catch: Exception -> 0x05a9, TRY_LEAVE, TryCatch #4 {Exception -> 0x05a9, blocks: (B:62:0x035b, B:64:0x0361), top: B:138:0x035b }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0414 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x0415  */
    /* JADX WARN: Code duplicated, block: B:78:0x044e  */
    /* JADX WARN: Code duplicated, block: B:79:0x0450  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x0454 A[Catch: Exception -> 0x0554, TRY_LEAVE, TryCatch #6 {Exception -> 0x0554, blocks: (B:76:0x0437, B:81:0x0454), top: B:142:0x0437 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x04d6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:86:0x04d7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x04d7 -> B:164:0x04ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x0517 -> B:94:0x0532). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUrl(@org.jetbrains.annotations.NotNull java.lang.String r45, @org.jetbrains.annotations.Nullable java.lang.String r46, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r47, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r48, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r49) {
        /*
            Method dump skipped, instruction units count: 1582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dudefilms.GDFlix.getUrl(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.dudefilms.GDFlix$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "anchor", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.dudefilms.GDFlix$getUrl$2", f = "Extractors.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 7, 8, 8}, l = {394, 403, 404, 428, 473, 477, 489, 490, 503}, m = "invokeSuspend", n = {"anchor", "text", "link", "anchor", "text", "link", "anchor", "text", "link", "anchor", "text", "driveLink", "id", "doId", "baseUrls", "anchor", "text", "instantLink", "anchor", "text", "instantLink", "link", "anchor", "text", "anchor", "text", "anchor", "text"}, nl = {393, 404, 416, 465, 474, 476, 490, 496, 502}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 2)
    static final class C00092 extends SuspendLambda implements Function2<Element, Continuation<? super Object>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $fileName;
        final /* synthetic */ String $fileSize;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ GDFlix this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00092(Function1<? super ExtractorLink, Unit> function1, String str, GDFlix gDFlix, String str2, Function1<? super SubtitleFile, Unit> function2, Continuation<? super C00092> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$fileSize = str;
            this.this$0 = gDFlix;
            this.$fileName = str2;
            this.$subtitleCallback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00092 = new C00092(this.$callback, this.$fileSize, this.this$0, this.$fileName, this.$subtitleCallback, continuation);
            c00092.L$0 = obj;
            return c00092;
        }

        public final Object invoke(Element element, Continuation<Object> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:100:0x03db A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:55:0x01e7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:77:0x02e3 A[Catch: Exception -> 0x034d, TryCatch #1 {Exception -> 0x034d, blocks: (B:85:0x0348, B:75:0x02d4, B:77:0x02e3, B:81:0x02ef), top: B:118:0x02d4 }] */
        /* JADX WARN: Code duplicated, block: B:78:0x02ea  */
        /* JADX WARN: Code duplicated, block: B:80:0x02ed  */
        /* JADX WARN: Code duplicated, block: B:83:0x0344 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:84:0x0345  */
        public final Object invokeSuspend(Object $result) {
            String text;
            String text2;
            Object objAmap;
            String text3;
            Object obj;
            String text4;
            String text5;
            Object objNewExtractorLink$default;
            Function1<ExtractorLink, Unit> function1;
            Object obj2;
            String text6;
            Object obj3;
            Object objNewExtractorLink$default2;
            Function1<ExtractorLink, Unit> function2;
            String text7;
            Object objAmap2;
            String str;
            String strSubstringAfter$default;
            Function1<ExtractorLink, Unit> function3;
            Object objNewExtractorLink$default3;
            Function1<ExtractorLink, Unit> function4;
            Object objAmap3;
            Element anchor = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                try {
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            text = anchor.select("a").text();
                            if (StringsKt.contains(text, "DIRECT DL", true)) {
                                String link = anchor.attr("href");
                                Function1<ExtractorLink, Unit> function5 = this.$callback;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(anchor);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(text);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                                this.L$3 = function5;
                                this.label = 1;
                                objNewExtractorLink$default2 = ExtractorApiKt.newExtractorLink$default("GDFlix [Direct]", "GDFlix [Direct] [" + this.$fileSize + ']', link, (ExtractorLinkType) null, new AnonymousClass1(this.this$0, this.$fileName, null), (Continuation) this, 8, (Object) null);
                                if (objNewExtractorLink$default2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                function2 = function5;
                                text7 = text;
                                function2.invoke(objNewExtractorLink$default2);
                                return Unit.INSTANCE;
                            }
                            if (StringsKt.contains(text, "Index Links", true)) {
                                text6 = anchor.attr("href");
                                this.L$0 = SpillingKt.nullOutSpilledVariable(anchor);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(text);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(text6);
                                this.label = 2;
                                obj3 = Requests.get$default(MainActivityKt.getApp(), "https://new6.gdflix.dad" + text6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                                if (obj3 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                this.L$0 = SpillingKt.nullOutSpilledVariable(anchor);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(text);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(text6);
                                this.label = 3;
                                objAmap2 = ParCollectionsKt.amap(((NiceResponse) obj3).getDocument().select("a.btn.btn-outline-info"), new AnonymousClass2(this.$callback, this.$fileSize, this.this$0, this.$fileName, null), (Continuation) this);
                                if (objAmap2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return objAmap2;
                            }
                            if (StringsKt.contains(text, "DRIVEBOT", true)) {
                                try {
                                    String driveLink = anchor.attr("href");
                                    String id = StringsKt.substringBefore$default(StringsKt.substringAfter$default(driveLink, "id=", (String) null, 2, (Object) null), "&", (String) null, 2, (Object) null);
                                    String doId = StringsKt.substringBefore$default(StringsKt.substringAfter$default(driveLink, "do=", (String) null, 2, (Object) null), "==", (String) null, 2, (Object) null);
                                    List baseUrls = CollectionsKt.listOf(new String[]{"https://drivebot.sbs", "https://drivebot.cfd"});
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(anchor);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(text);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(driveLink);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(id);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(doId);
                                    this.L$5 = SpillingKt.nullOutSpilledVariable(baseUrls);
                                    this.label = 4;
                                    objAmap = ParCollectionsKt.amap(baseUrls, new AnonymousClass3(id, doId, this.$callback, this.$fileSize, this.this$0, this.$fileName, null), (Continuation) this);
                                    if (objAmap == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return objAmap;
                                } catch (Exception e) {
                                    e = e;
                                    text2 = text;
                                    Log.INSTANCE.d("DriveBot", e.toString());
                                    return Unit.INSTANCE;
                                }
                            }
                            if (!StringsKt.contains(text, "Instant DL", true)) {
                                if (StringsKt.contains(text, "GoFile", true)) {
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(anchor);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(text);
                                    this.label = 7;
                                    obj2 = Requests.get$default(MainActivityKt.getApp(), anchor.attr("href"), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                                    if (obj2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(anchor);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(text);
                                    this.label = 8;
                                    objAmap3 = ParCollectionsKt.amap(((NiceResponse) obj2).getDocument().select(".row .row a"), new AnonymousClass5(this.$subtitleCallback, this.$callback, null), (Continuation) this);
                                    if (objAmap3 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return objAmap3;
                                }
                                if (!StringsKt.contains(text, "PixelDrain", true) && !StringsKt.contains(text, "Pixel", true)) {
                                    Log.INSTANCE.d("Error", "No Server matched");
                                    return Unit.INSTANCE;
                                }
                                Function1<ExtractorLink, Unit> function6 = this.$callback;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(anchor);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(text);
                                this.L$2 = function6;
                                this.label = 9;
                                objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("GDFlix [Pixeldrain]", "GDFlix [Pixeldrain] [" + this.$fileSize + ']', anchor.attr("href"), (ExtractorLinkType) null, new AnonymousClass6(null), (Continuation) this, 8, (Object) null);
                                if (objNewExtractorLink$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                function1 = function6;
                                function1.invoke(objNewExtractorLink$default);
                                return Unit.INSTANCE;
                            }
                            try {
                                String instantLink = anchor.attr("href");
                                this.L$0 = SpillingKt.nullOutSpilledVariable(anchor);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(text);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(instantLink);
                                this.label = 5;
                                obj = Requests.get$default(MainActivityKt.getApp(), instantLink, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4062, (Object) null);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                text4 = text;
                                text5 = instantLink;
                                try {
                                    str = ((NiceResponse) obj).getHeaders().get("location");
                                    if (str != null) {
                                        strSubstringAfter$default = StringsKt.substringAfter$default(str, "url=", (String) null, 2, (Object) null);
                                    } else {
                                        strSubstringAfter$default = null;
                                    }
                                    if (strSubstringAfter$default == null) {
                                        strSubstringAfter$default = "";
                                    }
                                    String link2 = strSubstringAfter$default;
                                    function3 = this.$callback;
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(anchor);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(text4);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(text5);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(link2);
                                    this.L$4 = function3;
                                    this.label = 6;
                                    objNewExtractorLink$default3 = ExtractorApiKt.newExtractorLink$default("GDFlix [Instant Download]", "GDFlix [Instant Download] [" + this.$fileSize + ']', link2, (ExtractorLinkType) null, new AnonymousClass4(this.this$0, this.$fileName, null), (Continuation) this, 8, (Object) null);
                                    if (objNewExtractorLink$default3 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    function4 = function3;
                                    function4.invoke(objNewExtractorLink$default3);
                                    return Unit.INSTANCE;
                                } catch (Exception e2) {
                                    e = e2;
                                    text3 = text4;
                                    Log.INSTANCE.d("Instant DL", e.toString());
                                }
                            } catch (Exception e3) {
                                e = e3;
                                text3 = text;
                                Log.INSTANCE.d("Instant DL", e.toString());
                            }
                            break;
                        case 1:
                            function2 = (Function1) this.L$3;
                            text7 = (String) this.L$1;
                            ResultKt.throwOnFailure($result);
                            objNewExtractorLink$default2 = $result;
                            function2.invoke(objNewExtractorLink$default2);
                            return Unit.INSTANCE;
                        case 2:
                            String link3 = (String) this.L$2;
                            String text8 = (String) this.L$1;
                            try {
                                ResultKt.throwOnFailure($result);
                                text6 = link3;
                                text = text8;
                                obj3 = $result;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(anchor);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(text);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(text6);
                                this.label = 3;
                                objAmap2 = ParCollectionsKt.amap(((NiceResponse) obj3).getDocument().select("a.btn.btn-outline-info"), new AnonymousClass2(this.$callback, this.$fileSize, this.this$0, this.$fileName, null), (Continuation) this);
                                if (objAmap2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return objAmap2;
                            } catch (Exception e4) {
                                e = e4;
                                Log.INSTANCE.d("Index Links", e.toString());
                                return Unit.INSTANCE;
                            }
                        case 3:
                            ResultKt.throwOnFailure($result);
                            objAmap2 = $result;
                            return objAmap2;
                        case 4:
                            text2 = (String) this.L$1;
                            try {
                                ResultKt.throwOnFailure($result);
                                objAmap = $result;
                                return objAmap;
                            } catch (Exception e5) {
                                e = e5;
                                Log.INSTANCE.d("DriveBot", e.toString());
                                return Unit.INSTANCE;
                            }
                        case 5:
                            text5 = (String) this.L$2;
                            String text9 = (String) this.L$1;
                            try {
                                ResultKt.throwOnFailure($result);
                                text4 = text9;
                                obj = $result;
                                str = ((NiceResponse) obj).getHeaders().get("location");
                                if (str != null) {
                                    strSubstringAfter$default = StringsKt.substringAfter$default(str, "url=", (String) null, 2, (Object) null);
                                } else {
                                    strSubstringAfter$default = null;
                                }
                                if (strSubstringAfter$default == null) {
                                    strSubstringAfter$default = "";
                                }
                                String link4 = strSubstringAfter$default;
                                function3 = this.$callback;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(anchor);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(text4);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(text5);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(link4);
                                this.L$4 = function3;
                                this.label = 6;
                                objNewExtractorLink$default3 = ExtractorApiKt.newExtractorLink$default("GDFlix [Instant Download]", "GDFlix [Instant Download] [" + this.$fileSize + ']', link4, (ExtractorLinkType) null, new AnonymousClass4(this.this$0, this.$fileName, null), (Continuation) this, 8, (Object) null);
                                if (objNewExtractorLink$default3 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                function4 = function3;
                                function4.invoke(objNewExtractorLink$default3);
                                return Unit.INSTANCE;
                            } catch (Exception e6) {
                                e = e6;
                                text3 = text9;
                                Log.INSTANCE.d("Instant DL", e.toString());
                            }
                            break;
                        case 6:
                            function4 = (Function1) this.L$4;
                            text3 = (String) this.L$1;
                            try {
                                ResultKt.throwOnFailure($result);
                                text4 = text3;
                                objNewExtractorLink$default3 = $result;
                                function4.invoke(objNewExtractorLink$default3);
                            } catch (Exception e7) {
                                e = e7;
                                Log.INSTANCE.d("Instant DL", e.toString());
                            }
                            return Unit.INSTANCE;
                        case 7:
                            text = (String) this.L$1;
                            ResultKt.throwOnFailure($result);
                            obj2 = $result;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(anchor);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(text);
                            this.label = 8;
                            objAmap3 = ParCollectionsKt.amap(((NiceResponse) obj2).getDocument().select(".row .row a"), new AnonymousClass5(this.$subtitleCallback, this.$callback, null), (Continuation) this);
                            if (objAmap3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return objAmap3;
                        case 8:
                            ResultKt.throwOnFailure($result);
                            objAmap3 = $result;
                            return objAmap3;
                        case 9:
                            function1 = (Function1) this.L$2;
                            ResultKt.throwOnFailure($result);
                            objNewExtractorLink$default = $result;
                            function1.invoke(objNewExtractorLink$default);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Exception e8) {
                    e = e8;
                }
            } catch (Exception e9) {
                Log.INSTANCE.d("Gofile", e9.toString());
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.dudefilms.GDFlix$getUrl$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.dudefilms.GDFlix$getUrl$2$1", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $fileName;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ GDFlix this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(GDFlix gDFlix, String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = gDFlix;
                this.$fileName = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, this.$fileName, continuation);
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
                        $this$newExtractorLink.setQuality(this.this$0.getIndexQuality(this.$fileName));
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.dudefilms.GDFlix$getUrl$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000b\u0010\u0003\u001a\u00070\u0004¢\u0006\u0002\b\u0005H\n"}, d2 = {"<anonymous>", "", "", "btn", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.dudefilms.GDFlix$getUrl$2$2", f = "Extractors.kt", i = {0, 0, 1, 1}, l = {406, 407}, m = "invokeSuspend", n = {"btn", "serverUrl", "btn", "serverUrl"}, nl = {407, 414}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<Element, Continuation<? super List<? extends Unit>>, Object> {
            final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
            final /* synthetic */ String $fileName;
            final /* synthetic */ String $fileSize;
            /* synthetic */ Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ GDFlix this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Function1<? super ExtractorLink, Unit> function1, String str, GDFlix gDFlix, String str2, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$fileSize = str;
                this.this$0 = gDFlix;
                this.$fileName = str2;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.$callback, this.$fileSize, this.this$0, this.$fileName, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            public final Object invoke(Element element, Continuation<? super List<Unit>> continuation) {
                return create(element, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                Object obj;
                String serverUrl;
                Element btn = (Element) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String serverUrl2 = "https://new6.gdflix.dad" + btn.attr("href");
                        this.L$0 = SpillingKt.nullOutSpilledVariable(btn);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(serverUrl2);
                        this.label = 1;
                        Object obj2 = Requests.get$default(MainActivityKt.getApp(), serverUrl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = obj2;
                        serverUrl = serverUrl2;
                        break;
                        break;
                    case 1:
                        serverUrl = (String) this.L$1;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(btn);
                this.L$1 = SpillingKt.nullOutSpilledVariable(serverUrl);
                this.label = 2;
                Object objAmap = ParCollectionsKt.amap(((NiceResponse) obj).getDocument().select("div.mb-4 > a"), new AnonymousClass1(this.$callback, this.$fileSize, this.this$0, this.$fileName, null), (Continuation) this);
                if (objAmap == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objAmap;
            }

            /* JADX INFO: renamed from: com.dudefilms.GDFlix$getUrl$2$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: Extractors.kt */
            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "sourceAnchor", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
            @DebugMetadata(c = "com.dudefilms.GDFlix$getUrl$2$2$1", f = "Extractors.kt", i = {0, 0}, l = {410}, m = "invokeSuspend", n = {"sourceAnchor", "sourceurl"}, nl = {409}, s = {"L$0", "L$1"}, v = 2)
            static final class AnonymousClass1 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
                final /* synthetic */ String $fileName;
                final /* synthetic */ String $fileSize;
                /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                int label;
                final /* synthetic */ GDFlix this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Function1<? super ExtractorLink, Unit> function1, String str, GDFlix gDFlix, String str2, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$callback = function1;
                    this.$fileSize = str;
                    this.this$0 = gDFlix;
                    this.$fileName = str2;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$callback, this.$fileSize, this.this$0, this.$fileName, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                public final Object invoke(Element element, Continuation<? super Unit> continuation) {
                    return create(element, continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object $result) {
                    Object objNewExtractorLink$default;
                    Function1<ExtractorLink, Unit> function1;
                    Element sourceAnchor = (Element) this.L$0;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            String sourceurl = sourceAnchor.attr("href");
                            Function1<ExtractorLink, Unit> function2 = this.$callback;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(sourceAnchor);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(sourceurl);
                            this.L$2 = function2;
                            this.label = 1;
                            objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("GDFlix [Index]", "GDFlix [Index] [" + this.$fileSize + ']', sourceurl, (ExtractorLinkType) null, new C00171(this.this$0, this.$fileName, null), (Continuation) this, 8, (Object) null);
                            if (objNewExtractorLink$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function1 = function2;
                            break;
                            break;
                        case 1:
                            function1 = (Function1) this.L$2;
                            ResultKt.throwOnFailure($result);
                            objNewExtractorLink$default = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1.invoke(objNewExtractorLink$default);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.dudefilms.GDFlix$getUrl$2$2$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Extractors.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
                @DebugMetadata(c = "com.dudefilms.GDFlix$getUrl$2$2$1$1", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class C00171 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
                    final /* synthetic */ String $fileName;
                    private /* synthetic */ Object L$0;
                    int label;
                    final /* synthetic */ GDFlix this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00171(GDFlix gDFlix, String str, Continuation<? super C00171> continuation) {
                        super(2, continuation);
                        this.this$0 = gDFlix;
                        this.$fileName = str;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        Continuation<Unit> c00171 = new C00171(this.this$0, this.$fileName, continuation);
                        c00171.L$0 = obj;
                        return c00171;
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
                                $this$newExtractorLink.setQuality(this.this$0.getIndexQuality(this.$fileName));
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
            }
        }

        /* JADX INFO: renamed from: com.dudefilms.GDFlix$getUrl$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "baseUrl", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.dudefilms.GDFlix$getUrl$2$3", f = "Extractors.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {430, 447, 458}, m = "invokeSuspend", n = {"baseUrl", "indexbotLink", "baseUrl", "indexbotLink", "indexbotResponse", "cookiesSSID", "indexbotDoc", "token", "postId", "postData", "headers", "cookies", "baseUrl", "indexbotLink", "indexbotResponse", "cookiesSSID", "indexbotDoc", "token", "postId", "postData", "headers", "cookies", "downloadLink"}, nl = {432, 453, 457}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
            final /* synthetic */ String $doId;
            final /* synthetic */ String $fileName;
            final /* synthetic */ String $fileSize;
            final /* synthetic */ String $id;
            /* synthetic */ Object L$0;
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
            final /* synthetic */ GDFlix this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(String str, String str2, Function1<? super ExtractorLink, Unit> function1, String str3, GDFlix gDFlix, String str4, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$id = str;
                this.$doId = str2;
                this.$callback = function1;
                this.$fileSize = str3;
                this.this$0 = gDFlix;
                this.$fileName = str4;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass3 = new AnonymousClass3(this.$id, this.$doId, this.$callback, this.$fileSize, this.this$0, this.$fileName, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            public final Object invoke(String str, Continuation<? super Unit> continuation) {
                return create(str, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:15:0x00f2  */
            /* JADX WARN: Code duplicated, block: B:20:0x0126  */
            /* JADX WARN: Code duplicated, block: B:22:0x0129  */
            /* JADX WARN: Code duplicated, block: B:28:0x0150  */
            /* JADX WARN: Code duplicated, block: B:30:0x0153  */
            /* JADX WARN: Code duplicated, block: B:33:0x01f7 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:34:0x01f8  */
            /* JADX WARN: Code duplicated, block: B:37:0x0221  */
            /* JADX WARN: Code duplicated, block: B:42:0x0241  */
            /* JADX WARN: Code duplicated, block: B:44:0x0244  */
            /* JADX WARN: Code duplicated, block: B:47:0x02cd A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:48:0x02ce  */
            public final Object invokeSuspend(Object $result) {
                Object obj;
                String indexbotLink;
                NiceResponse indexbotResponse;
                String cookiesSSID;
                Document indexbotDoc;
                MatchResult matchResultFind$default;
                String token;
                MatchResult matchResultFind$default2;
                String postId;
                Map postData;
                Map headers;
                Map cookies;
                Object objPost$default;
                Document indexbotDoc2;
                String token2;
                NiceResponse indexbotResponse2;
                String cookiesSSID2;
                Map cookies2;
                Map postData2;
                List groupValues;
                List groupValues2;
                MatchResult matchResultFind$default3;
                String strReplace$default;
                Function1<ExtractorLink, Unit> function1;
                Object objNewExtractorLink$default;
                Function1<ExtractorLink, Unit> function2;
                String token3;
                List groupValues3;
                String str;
                String baseUrl = (String) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String indexbotLink2 = baseUrl + "/download?id=" + this.$id + "&do=" + this.$doId;
                        this.L$0 = baseUrl;
                        this.L$1 = indexbotLink2;
                        this.label = 1;
                        obj = Requests.get$default(MainActivityKt.getApp(), indexbotLink2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 100L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 3838, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        indexbotLink = indexbotLink2;
                        indexbotResponse = (NiceResponse) obj;
                        if (indexbotResponse.isSuccessful()) {
                            cookiesSSID = (String) indexbotResponse.getCookies().get("PHPSESSID");
                            indexbotDoc = indexbotResponse.getDocument();
                            matchResultFind$default = Regex.find$default(new Regex("formData\\.append\\('token', '([a-f0-9]+)'\\)"), indexbotDoc.toString(), 0, 2, (Object) null);
                            if (matchResultFind$default != null || (groupValues2 = matchResultFind$default.getGroupValues()) == null) {
                                token = null;
                            } else {
                                token = (String) groupValues2.get(1);
                            }
                            if (token == null) {
                                token = "";
                            }
                            matchResultFind$default2 = Regex.find$default(new Regex("fetch\\('/download\\?id=([a-zA-Z0-9/+]+)'"), indexbotDoc.toString(), 0, 2, (Object) null);
                            if (matchResultFind$default2 != null || (groupValues = matchResultFind$default2.getGroupValues()) == null) {
                                postId = null;
                            } else {
                                postId = (String) groupValues.get(1);
                            }
                            if (postId == null) {
                                postId = "";
                            }
                            postData = MapsKt.mapOf(TuplesKt.to("token", token));
                            headers = MapsKt.mapOf(TuplesKt.to("Referer", indexbotLink));
                            cookies = MapsKt.mapOf(TuplesKt.to("PHPSESSID", String.valueOf(cookiesSSID)));
                            this.L$0 = baseUrl;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(indexbotLink);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(indexbotResponse);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(cookiesSSID);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(indexbotDoc);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(token);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(postId);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(postData);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(cookies);
                            this.label = 2;
                            objPost$default = Requests.post$default(MainActivityKt.getApp(), baseUrl + "/download?id=" + postId, headers, (String) null, (Map) null, cookies, postData, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 100L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 61388, (Object) null);
                            if (objPost$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            String str2 = token;
                            indexbotDoc2 = indexbotDoc;
                            token2 = str2;
                            indexbotResponse2 = indexbotResponse;
                            cookiesSSID2 = indexbotLink;
                            cookies2 = cookies;
                            postData2 = postData;
                            String it = ((NiceResponse) objPost$default).getText();
                            Map cookies3 = cookies2;
                            matchResultFind$default3 = Regex.find$default(new Regex("url\":\"(.*?)\""), it, 0, 2, (Object) null);
                            if (matchResultFind$default3 != null || (groupValues3 = matchResultFind$default3.getGroupValues()) == null || (str = (String) groupValues3.get(1)) == null) {
                                strReplace$default = null;
                            } else {
                                strReplace$default = StringsKt.replace$default(str, "\\", "", false, 4, (Object) null);
                            }
                            if (strReplace$default == null) {
                                strReplace$default = "";
                            }
                            String downloadLink = strReplace$default;
                            function1 = this.$callback;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(cookiesSSID2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(indexbotResponse2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(cookiesSSID);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(indexbotDoc2);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(token2);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(postId);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(postData2);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(cookies3);
                            this.L$10 = SpillingKt.nullOutSpilledVariable(downloadLink);
                            this.L$11 = function1;
                            this.label = 3;
                            objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("GDFlix [DriveBot]", "GDFlix [DriveBot] [" + this.$fileSize + ']', downloadLink, (ExtractorLinkType) null, new AnonymousClass1(baseUrl, this.this$0, this.$fileName, null), (Continuation) this, 8, (Object) null);
                            if (objNewExtractorLink$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function2 = function1;
                            token3 = cookiesSSID2;
                            function2.invoke(objNewExtractorLink$default);
                        }
                        return Unit.INSTANCE;
                    case 1:
                        String indexbotLink3 = (String) this.L$1;
                        ResultKt.throwOnFailure($result);
                        indexbotLink = indexbotLink3;
                        obj = $result;
                        indexbotResponse = (NiceResponse) obj;
                        if (indexbotResponse.isSuccessful()) {
                            cookiesSSID = (String) indexbotResponse.getCookies().get("PHPSESSID");
                            indexbotDoc = indexbotResponse.getDocument();
                            matchResultFind$default = Regex.find$default(new Regex("formData\\.append\\('token', '([a-f0-9]+)'\\)"), indexbotDoc.toString(), 0, 2, (Object) null);
                            if (matchResultFind$default != null) {
                                token = null;
                            } else {
                                token = null;
                            }
                            if (token == null) {
                                token = "";
                            }
                            matchResultFind$default2 = Regex.find$default(new Regex("fetch\\('/download\\?id=([a-zA-Z0-9/+]+)'"), indexbotDoc.toString(), 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                postId = null;
                            } else {
                                postId = null;
                            }
                            if (postId == null) {
                                postId = "";
                            }
                            postData = MapsKt.mapOf(TuplesKt.to("token", token));
                            headers = MapsKt.mapOf(TuplesKt.to("Referer", indexbotLink));
                            cookies = MapsKt.mapOf(TuplesKt.to("PHPSESSID", String.valueOf(cookiesSSID)));
                            this.L$0 = baseUrl;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(indexbotLink);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(indexbotResponse);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(cookiesSSID);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(indexbotDoc);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(token);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(postId);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(postData);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(cookies);
                            this.label = 2;
                            objPost$default = Requests.post$default(MainActivityKt.getApp(), baseUrl + "/download?id=" + postId, headers, (String) null, (Map) null, cookies, postData, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 100L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 61388, (Object) null);
                            if (objPost$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            String str3 = token;
                            indexbotDoc2 = indexbotDoc;
                            token2 = str3;
                            indexbotResponse2 = indexbotResponse;
                            cookiesSSID2 = indexbotLink;
                            cookies2 = cookies;
                            postData2 = postData;
                            String it2 = ((NiceResponse) objPost$default).getText();
                            Map cookies4 = cookies2;
                            matchResultFind$default3 = Regex.find$default(new Regex("url\":\"(.*?)\""), it2, 0, 2, (Object) null);
                            if (matchResultFind$default3 != null) {
                                strReplace$default = null;
                            } else {
                                strReplace$default = null;
                            }
                            if (strReplace$default == null) {
                                strReplace$default = "";
                            }
                            String downloadLink2 = strReplace$default;
                            function1 = this.$callback;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(cookiesSSID2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(indexbotResponse2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(cookiesSSID);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(indexbotDoc2);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(token2);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(postId);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(postData2);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(cookies4);
                            this.L$10 = SpillingKt.nullOutSpilledVariable(downloadLink2);
                            this.L$11 = function1;
                            this.label = 3;
                            objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("GDFlix [DriveBot]", "GDFlix [DriveBot] [" + this.$fileSize + ']', downloadLink2, (ExtractorLinkType) null, new AnonymousClass1(baseUrl, this.this$0, this.$fileName, null), (Continuation) this, 8, (Object) null);
                            if (objNewExtractorLink$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function2 = function1;
                            token3 = cookiesSSID2;
                            function2.invoke(objNewExtractorLink$default);
                        }
                        return Unit.INSTANCE;
                    case 2:
                        cookies2 = (Map) this.L$9;
                        Map headers2 = (Map) this.L$8;
                        Map postData3 = (Map) this.L$7;
                        String postId2 = (String) this.L$6;
                        token2 = (String) this.L$5;
                        indexbotDoc2 = (Document) this.L$4;
                        String cookiesSSID3 = (String) this.L$3;
                        NiceResponse indexbotResponse3 = (NiceResponse) this.L$2;
                        String indexbotLink4 = (String) this.L$1;
                        ResultKt.throwOnFailure($result);
                        cookiesSSID2 = indexbotLink4;
                        postData2 = postData3;
                        cookiesSSID = cookiesSSID3;
                        headers = headers2;
                        postId = postId2;
                        indexbotResponse2 = indexbotResponse3;
                        objPost$default = $result;
                        String it3 = ((NiceResponse) objPost$default).getText();
                        Map cookies5 = cookies2;
                        matchResultFind$default3 = Regex.find$default(new Regex("url\":\"(.*?)\""), it3, 0, 2, (Object) null);
                        if (matchResultFind$default3 != null) {
                            strReplace$default = null;
                        } else {
                            strReplace$default = null;
                        }
                        if (strReplace$default == null) {
                            strReplace$default = "";
                        }
                        String downloadLink3 = strReplace$default;
                        function1 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(baseUrl);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(cookiesSSID2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(indexbotResponse2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(cookiesSSID);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(indexbotDoc2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(token2);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(postId);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(postData2);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                        this.L$9 = SpillingKt.nullOutSpilledVariable(cookies5);
                        this.L$10 = SpillingKt.nullOutSpilledVariable(downloadLink3);
                        this.L$11 = function1;
                        this.label = 3;
                        objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("GDFlix [DriveBot]", "GDFlix [DriveBot] [" + this.$fileSize + ']', downloadLink3, (ExtractorLinkType) null, new AnonymousClass1(baseUrl, this.this$0, this.$fileName, null), (Continuation) this, 8, (Object) null);
                        if (objNewExtractorLink$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function2 = function1;
                        token3 = cookiesSSID2;
                        function2.invoke(objNewExtractorLink$default);
                        return Unit.INSTANCE;
                    case 3:
                        function2 = (Function1) this.L$11;
                        indexbotResponse2 = (NiceResponse) this.L$2;
                        token3 = (String) this.L$1;
                        ResultKt.throwOnFailure($result);
                        objNewExtractorLink$default = $result;
                        function2.invoke(objNewExtractorLink$default);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.dudefilms.GDFlix$getUrl$2$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: Extractors.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
            @DebugMetadata(c = "com.dudefilms.GDFlix$getUrl$2$3$1", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
            static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
                final /* synthetic */ String $baseUrl;
                final /* synthetic */ String $fileName;
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ GDFlix this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(String str, GDFlix gDFlix, String str2, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$baseUrl = str;
                    this.this$0 = gDFlix;
                    this.$fileName = str2;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$baseUrl, this.this$0, this.$fileName, continuation);
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
                            $this$newExtractorLink.setReferer(this.$baseUrl);
                            $this$newExtractorLink.setQuality(this.this$0.getIndexQuality(this.$fileName));
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
        }

        /* JADX INFO: renamed from: com.dudefilms.GDFlix$getUrl$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.dudefilms.GDFlix$getUrl$2$4", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass4 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $fileName;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ GDFlix this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(GDFlix gDFlix, String str, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.this$0 = gDFlix;
                this.$fileName = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass4 = new AnonymousClass4(this.this$0, this.$fileName, continuation);
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
                        $this$newExtractorLink.setQuality(this.this$0.getIndexQuality(this.$fileName));
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.dudefilms.GDFlix$getUrl$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "gofileAnchor", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.dudefilms.GDFlix$getUrl$2$5", f = "Extractors.kt", i = {0, 0}, l = {493}, m = "invokeSuspend", n = {"gofileAnchor", "link"}, nl = {495}, s = {"L$0", "L$1"}, v = 2)
        static final class AnonymousClass5 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
            final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
            /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.$subtitleCallback = function1;
                this.$callback = function2;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass5 = new AnonymousClass5(this.$subtitleCallback, this.$callback, continuation);
                anonymousClass5.L$0 = obj;
                return anonymousClass5;
            }

            public final Object invoke(Element element, Continuation<? super Unit> continuation) {
                return create(element, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                String link;
                Element gofileAnchor = (Element) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String link2 = gofileAnchor.attr("href");
                        if (StringsKt.contains$default(link2, "gofile", false, 2, (Object) null)) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(gofileAnchor);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(link2);
                            this.label = 1;
                            if (new Gofile().getUrl(link2, "", this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            link = link2;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        link = (String) this.L$1;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.dudefilms.GDFlix$getUrl$2$6, reason: invalid class name */
        /* JADX INFO: compiled from: Extractors.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.dudefilms.GDFlix$getUrl$2$6", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass6 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;

            AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass6 = new AnonymousClass6(continuation);
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
                        $this$newExtractorLink.setQuality($this$newExtractorLink.getQuality());
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    public final int getIndexQuality(@Nullable String str) {
        List groupValues;
        String str2;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("\\b(2160|1440|1080|720|576|540|480)\\s*[pP]\\b"), str == null ? "" : str, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? Qualities.Unknown.getValue() : intOrNull.intValue();
    }
}
