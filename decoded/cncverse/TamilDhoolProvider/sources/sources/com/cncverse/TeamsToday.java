package com.cncverse;

import com.lagradost.cloudstream3.MainActivityKt;
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
import kotlin.ResultKt;
import kotlin.Unit;
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
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/TamilDhoolProvider/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00160\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00160\u001aH\u0096@¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0003R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/cncverse/TeamsToday;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "name", "getName", "requiresReferer", "", "getRequiresReferer", "()Z", "tamildhoolReferer", "metaRefreshRegex", "Lkotlin/text/Regex;", "getMetaRefreshRegex$annotations", "jwFileRegex", "iframeSrcRegex", "rawM3u8Regex", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findStreamUrl", "html", "unescapeUrl", "raw", "TamilDhoolProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/cncverse/TeamsToday\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,233:1\n1#2:234\n*E\n"})
public class TeamsToday extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String mainUrl = "https://teamstoday.com";

    @NotNull
    private final String name = "TeamsToday";

    @NotNull
    private final String tamildhoolReferer = "https://www.tamildhool.tech/";

    @NotNull
    private final Regex metaRefreshRegex = new Regex("url=([^\"'\\s>]+)", RegexOption.IGNORE_CASE);

    @NotNull
    private final Regex jwFileRegex = new Regex("file\\s*:\\s*[\"']([^\"']+)[\"']", RegexOption.IGNORE_CASE);

    @NotNull
    private final Regex iframeSrcRegex = new Regex("<iframe[^>]+src=[\"']([^\"']+)[\"']", RegexOption.IGNORE_CASE);

    @NotNull
    private final Regex rawM3u8Regex = new Regex("https?:\\\\?/\\\\?/[^\\s\"'<>\\\\]+\\.m3u8", RegexOption.IGNORE_CASE);

    /* JADX INFO: renamed from: com.cncverse.TeamsToday$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TeamsToday", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {140, 150, 159, 181, 189, 206}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "entryReferer", "$this", "url", "referer", "subtitleCallback", "callback", "entryReferer", "teamstodayHtml", "redirectTarget", "$this", "url", "referer", "subtitleCallback", "callback", "entryReferer", "teamstodayHtml", "redirectTarget", "destinationHtml", "directStream", "$this", "url", "referer", "subtitleCallback", "callback", "entryReferer", "teamstodayHtml", "redirectTarget", "destinationHtml", "directStream", "iframeSrc", "$this", "url", "referer", "subtitleCallback", "callback", "entryReferer", "teamstodayHtml", "redirectTarget", "destinationHtml", "directStream", "iframeSrc", "iframeHtml", "iframeStream", "$this", "url", "referer", "subtitleCallback", "callback", "entryReferer", "teamstodayHtml", "redirectTarget", "destinationHtml", "directStream", "iframeSrc", "iframeHtml", "iframeStream"}, nl = {141, 156, 158, 182, 188, 207}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12"}, v = 2)
    static final class C00081 extends ContinuationImpl {
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

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TeamsToday.getUrl$suspendImpl(TeamsToday.this, null, null, null, null, (Continuation) this);
        }
    }

    private static /* synthetic */ void getMetaRefreshRegex$annotations() {
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:51:0x02da  */
    /* JADX WARN: Code duplicated, block: B:53:0x0337 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x0338  */
    /* JADX WARN: Code duplicated, block: B:57:0x0349  */
    /* JADX WARN: Code duplicated, block: B:78:0x040c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x0484 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:81:0x0485  */
    /* JADX WARN: Code duplicated, block: B:84:0x0493  */
    /* JADX WARN: Code duplicated, block: B:86:0x04ed A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:87:0x04ee  */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean, int] */
    static /* synthetic */ Object getUrl$suspendImpl(TeamsToday teamsToday, String str, String str2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00081 c00081;
        String str3;
        Object obj;
        String str4;
        int i;
        boolean z;
        String str5;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object obj2;
        String str6;
        TeamsToday teamsToday2;
        String str7;
        String text;
        MatchResult matchResultFind$default;
        List groupValues;
        String str8;
        String string;
        String strUnescapeUrl;
        String str9;
        Object obj3;
        String str10;
        TeamsToday teamsToday3;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        String str11;
        ?? r2;
        String text2;
        String strFindStreamUrl;
        String str12;
        MatchResult matchResultFind$default2;
        List groupValues2;
        String str13;
        String string2;
        String strUnescapeUrl2;
        TeamsToday teamsToday4;
        String str14;
        Object obj4;
        Function1<? super ExtractorLink, Unit> function7;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        Function1<? super SubtitleFile, Unit> function8;
        String str20;
        Object objNewExtractorLink;
        Function1<? super ExtractorLink, Unit> function9;
        String text3;
        String strFindStreamUrl2;
        Object objNewExtractorLink2;
        Function1<? super ExtractorLink, Unit> function10;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = teamsToday.new C00081(continuation);
            }
        } else {
            c00081 = teamsToday.new C00081(continuation);
        }
        C00081 c00082 = c00081;
        Object obj5 = c00082.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00082.label) {
            case 0:
                ResultKt.throwOnFailure(obj5);
                if (str2 == null) {
                    str3 = teamsToday.tamildhoolReferer;
                } else {
                    str3 = !StringsKt.isBlank(str2) ? str2 : null;
                    if (str3 == null) {
                        str3 = teamsToday.tamildhoolReferer;
                    }
                }
                Requests app = MainActivityKt.getApp();
                c00082.L$0 = teamsToday;
                c00082.L$1 = str;
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                c00082.L$3 = function1;
                c00082.L$4 = function2;
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(str3);
                c00082.label = 1;
                String str21 = str3;
                obj = coroutine_suspended;
                str4 = "http";
                i = 2;
                z = false;
                Object obj6 = Requests.get$default(app, str, (Map) null, str21, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 4090, (Object) null);
                c00082 = c00082;
                if (obj6 == obj) {
                    return obj;
                }
                str5 = str2;
                function3 = function1;
                function4 = function2;
                obj2 = obj6;
                str6 = str21;
                teamsToday2 = teamsToday;
                str7 = str;
                text = ((NiceResponse) obj2).getText();
                matchResultFind$default = Regex.find$default(teamsToday2.metaRefreshRegex, text, z ? 1 : 0, i, (Object) null);
                if (matchResultFind$default == null && (groupValues = matchResultFind$default.getGroupValues()) != null && (str8 = (String) groupValues.get(1)) != null && (string = StringsKt.trim(str8).toString()) != null && (strUnescapeUrl = teamsToday2.unescapeUrl(string)) != null) {
                    String str22 = str4;
                    if (!StringsKt.startsWith$default(strUnescapeUrl, str22, z, i, (Object) null)) {
                        strUnescapeUrl = null;
                    }
                    if (strUnescapeUrl != null) {
                        Requests app2 = MainActivityKt.getApp();
                        c00082.L$0 = teamsToday2;
                        c00082.L$1 = SpillingKt.nullOutSpilledVariable(str7);
                        c00082.L$2 = SpillingKt.nullOutSpilledVariable(str5);
                        c00082.L$3 = function3;
                        c00082.L$4 = function4;
                        c00082.L$5 = SpillingKt.nullOutSpilledVariable(str6);
                        c00082.L$6 = SpillingKt.nullOutSpilledVariable(text);
                        c00082.L$7 = strUnescapeUrl;
                        c00082.label = i;
                        Function1<? super ExtractorLink, Unit> function11 = function4;
                        TeamsToday teamsToday5 = teamsToday2;
                        C00081 c00083 = c00082;
                        Function1<? super SubtitleFile, Unit> function12 = function3;
                        String str23 = strUnescapeUrl;
                        str9 = str22;
                        obj3 = Requests.get$default(app2, str23, (Map) null, str7, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00083, 4090, (Object) null);
                        c00082 = c00083;
                        if (obj3 == obj) {
                            return obj;
                        }
                        str10 = str23;
                        teamsToday3 = teamsToday5;
                        function5 = function11;
                        function6 = function12;
                        str11 = str7;
                        r2 = z;
                        text2 = ((NiceResponse) obj3).getText();
                        strFindStreamUrl = teamsToday3.findStreamUrl(text2);
                        if (strFindStreamUrl == null) {
                            String name = teamsToday3.getName();
                            String name2 = teamsToday3.getName();
                            ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                            C00092 c00092 = new C00092(str10, null);
                            c00082.L$0 = SpillingKt.nullOutSpilledVariable(teamsToday3);
                            c00082.L$1 = SpillingKt.nullOutSpilledVariable(str11);
                            c00082.L$2 = SpillingKt.nullOutSpilledVariable(str5);
                            c00082.L$3 = SpillingKt.nullOutSpilledVariable(function6);
                            c00082.L$4 = SpillingKt.nullOutSpilledVariable(function5);
                            c00082.L$5 = SpillingKt.nullOutSpilledVariable(str6);
                            c00082.L$6 = SpillingKt.nullOutSpilledVariable(text);
                            c00082.L$7 = SpillingKt.nullOutSpilledVariable(str10);
                            c00082.L$8 = SpillingKt.nullOutSpilledVariable(text2);
                            c00082.L$9 = SpillingKt.nullOutSpilledVariable(strFindStreamUrl);
                            c00082.L$10 = function5;
                            c00082.label = 3;
                            objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, strFindStreamUrl, extractorLinkType, c00092, c00082);
                            if (objNewExtractorLink == obj) {
                                return obj;
                            }
                            function9 = function5;
                            function9.invoke(objNewExtractorLink);
                            return Unit.INSTANCE;
                        }
                        str12 = strFindStreamUrl;
                        matchResultFind$default2 = Regex.find$default(teamsToday3.iframeSrcRegex, text2, (int) r2, i, (Object) null);
                        if (matchResultFind$default2 == null && (groupValues2 = matchResultFind$default2.getGroupValues()) != null && (str13 = (String) groupValues2.get(1)) != null && (string2 = StringsKt.trim(str13).toString()) != null && (strUnescapeUrl2 = teamsToday3.unescapeUrl(string2)) != null) {
                            String str24 = StringsKt.startsWith$default(strUnescapeUrl2, str9, (boolean) r2, i, (Object) null) ? strUnescapeUrl2 : null;
                            if (str24 != null) {
                                Requests app3 = MainActivityKt.getApp();
                                c00082.L$0 = teamsToday3;
                                c00082.L$1 = SpillingKt.nullOutSpilledVariable(str11);
                                c00082.L$2 = SpillingKt.nullOutSpilledVariable(str5);
                                c00082.L$3 = function6;
                                c00082.L$4 = function5;
                                c00082.L$5 = SpillingKt.nullOutSpilledVariable(str6);
                                c00082.L$6 = SpillingKt.nullOutSpilledVariable(text);
                                c00082.L$7 = str10;
                                c00082.L$8 = SpillingKt.nullOutSpilledVariable(text2);
                                c00082.L$9 = SpillingKt.nullOutSpilledVariable(str12);
                                c00082.L$10 = str24;
                                c00082.label = 4;
                                C00081 c00084 = c00082;
                                teamsToday4 = teamsToday3;
                                Function1<? super ExtractorLink, Unit> function13 = function5;
                                String str25 = str10;
                                Function1<? super SubtitleFile, Unit> function14 = function6;
                                str14 = text2;
                                obj4 = Requests.get$default(app3, str24, (Map) null, str25, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00084, 4090, (Object) null);
                                c00082 = c00084;
                                if (obj4 == obj) {
                                    return obj;
                                }
                                function7 = function13;
                                str15 = str24;
                                str16 = str11;
                                str17 = str5;
                                str18 = str6;
                                str19 = text;
                                function8 = function14;
                                str20 = str25;
                                text3 = ((NiceResponse) obj4).getText();
                                strFindStreamUrl2 = teamsToday4.findStreamUrl(text3);
                                if (strFindStreamUrl2 != null) {
                                    c00082.L$0 = SpillingKt.nullOutSpilledVariable(teamsToday4);
                                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(str16);
                                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(str17);
                                    c00082.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00082.L$4 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(str18);
                                    c00082.L$6 = SpillingKt.nullOutSpilledVariable(str19);
                                    c00082.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                                    c00082.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                                    c00082.L$9 = SpillingKt.nullOutSpilledVariable(str12);
                                    c00082.L$10 = SpillingKt.nullOutSpilledVariable(str15);
                                    c00082.L$11 = SpillingKt.nullOutSpilledVariable(text3);
                                    c00082.L$12 = SpillingKt.nullOutSpilledVariable(strFindStreamUrl2);
                                    c00082.label = 6;
                                    if (ExtractorApiKt.loadExtractor(str15, str20, function8, function7, c00082) == obj) {
                                        return obj;
                                    }
                                    return Unit.INSTANCE;
                                }
                                String name3 = teamsToday4.getName();
                                String name4 = teamsToday4.getName();
                                ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                                TeamsToday teamsToday6 = teamsToday4;
                                C00103 c00103 = new C00103(str15, null);
                                c00082.L$0 = SpillingKt.nullOutSpilledVariable(teamsToday6);
                                c00082.L$1 = SpillingKt.nullOutSpilledVariable(str16);
                                c00082.L$2 = SpillingKt.nullOutSpilledVariable(str17);
                                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                                c00082.L$4 = SpillingKt.nullOutSpilledVariable(function7);
                                c00082.L$5 = SpillingKt.nullOutSpilledVariable(str18);
                                c00082.L$6 = SpillingKt.nullOutSpilledVariable(str19);
                                c00082.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                                c00082.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                                c00082.L$9 = SpillingKt.nullOutSpilledVariable(str12);
                                c00082.L$10 = SpillingKt.nullOutSpilledVariable(str15);
                                c00082.L$11 = SpillingKt.nullOutSpilledVariable(text3);
                                c00082.L$12 = SpillingKt.nullOutSpilledVariable(strFindStreamUrl2);
                                c00082.L$13 = function7;
                                c00082.label = 5;
                                objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name3, name4, strFindStreamUrl2, extractorLinkType2, c00103, c00082);
                                if (objNewExtractorLink2 == obj) {
                                    return obj;
                                }
                                function10 = function7;
                                function10.invoke(objNewExtractorLink2);
                                return Unit.INSTANCE;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                String str26 = (String) c00082.L$5;
                Function1<? super ExtractorLink, Unit> function15 = (Function1) c00082.L$4;
                Function1<? super SubtitleFile, Unit> function16 = (Function1) c00082.L$3;
                String str27 = (String) c00082.L$2;
                String str28 = (String) c00082.L$1;
                TeamsToday teamsToday7 = (TeamsToday) c00082.L$0;
                ResultKt.throwOnFailure(obj5);
                str6 = str26;
                obj = coroutine_suspended;
                str4 = "http";
                str5 = str27;
                str7 = str28;
                teamsToday2 = teamsToday7;
                function4 = function15;
                function3 = function16;
                i = 2;
                z = false;
                obj2 = obj5;
                text = ((NiceResponse) obj2).getText();
                matchResultFind$default = Regex.find$default(teamsToday2.metaRefreshRegex, text, z ? 1 : 0, i, (Object) null);
                if (matchResultFind$default == null) {
                }
                return Unit.INSTANCE;
            case 2:
                String str29 = (String) c00082.L$7;
                String str30 = (String) c00082.L$6;
                String str31 = (String) c00082.L$5;
                Function1<? super ExtractorLink, Unit> function17 = (Function1) c00082.L$4;
                Function1<? super SubtitleFile, Unit> function18 = (Function1) c00082.L$3;
                String str32 = (String) c00082.L$2;
                String str33 = (String) c00082.L$1;
                TeamsToday teamsToday8 = (TeamsToday) c00082.L$0;
                ResultKt.throwOnFailure(obj5);
                teamsToday3 = teamsToday8;
                text = str30;
                str9 = "http";
                str6 = str31;
                function5 = function17;
                function6 = function18;
                str5 = str32;
                str11 = str33;
                i = 2;
                str10 = str29;
                obj = coroutine_suspended;
                r2 = 0;
                obj3 = obj5;
                text2 = ((NiceResponse) obj3).getText();
                strFindStreamUrl = teamsToday3.findStreamUrl(text2);
                if (strFindStreamUrl == null) {
                    str12 = strFindStreamUrl;
                    matchResultFind$default2 = Regex.find$default(teamsToday3.iframeSrcRegex, text2, (int) r2, i, (Object) null);
                    if (matchResultFind$default2 == null) {
                    }
                    return Unit.INSTANCE;
                }
                String name5 = teamsToday3.getName();
                String name6 = teamsToday3.getName();
                ExtractorLinkType extractorLinkType3 = ExtractorLinkType.M3U8;
                C00092 c00093 = new C00092(str10, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(teamsToday3);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(str11);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(str5);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function6);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(function5);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(str6);
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(text);
                c00082.L$7 = SpillingKt.nullOutSpilledVariable(str10);
                c00082.L$8 = SpillingKt.nullOutSpilledVariable(text2);
                c00082.L$9 = SpillingKt.nullOutSpilledVariable(strFindStreamUrl);
                c00082.L$10 = function5;
                c00082.label = 3;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name5, name6, strFindStreamUrl, extractorLinkType3, c00093, c00082);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function9 = function5;
                function9.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            case 3:
                function9 = (Function1) c00082.L$10;
                ResultKt.throwOnFailure(obj5);
                objNewExtractorLink = obj5;
                function9.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            case 4:
                String str34 = (String) c00082.L$10;
                String str35 = (String) c00082.L$9;
                String str36 = (String) c00082.L$8;
                String str37 = (String) c00082.L$7;
                String str38 = (String) c00082.L$6;
                String str39 = (String) c00082.L$5;
                Function1<? super ExtractorLink, Unit> function19 = (Function1) c00082.L$4;
                Function1<? super SubtitleFile, Unit> function20 = (Function1) c00082.L$3;
                String str40 = (String) c00082.L$2;
                String str41 = (String) c00082.L$1;
                teamsToday4 = (TeamsToday) c00082.L$0;
                ResultKt.throwOnFailure(obj5);
                str12 = str35;
                str14 = str36;
                str19 = str38;
                str16 = str41;
                str15 = str34;
                obj = coroutine_suspended;
                str17 = str40;
                obj4 = obj5;
                function8 = function20;
                function7 = function19;
                str18 = str39;
                str20 = str37;
                text3 = ((NiceResponse) obj4).getText();
                strFindStreamUrl2 = teamsToday4.findStreamUrl(text3);
                if (strFindStreamUrl2 != null) {
                    c00082.L$0 = SpillingKt.nullOutSpilledVariable(teamsToday4);
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(str16);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(str17);
                    c00082.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                    c00082.L$4 = SpillingKt.nullOutSpilledVariable(function7);
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(str18);
                    c00082.L$6 = SpillingKt.nullOutSpilledVariable(str19);
                    c00082.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                    c00082.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                    c00082.L$9 = SpillingKt.nullOutSpilledVariable(str12);
                    c00082.L$10 = SpillingKt.nullOutSpilledVariable(str15);
                    c00082.L$11 = SpillingKt.nullOutSpilledVariable(text3);
                    c00082.L$12 = SpillingKt.nullOutSpilledVariable(strFindStreamUrl2);
                    c00082.label = 6;
                    if (ExtractorApiKt.loadExtractor(str15, str20, function8, function7, c00082) == obj) {
                        return obj;
                    }
                    return Unit.INSTANCE;
                }
                String name7 = teamsToday4.getName();
                String name8 = teamsToday4.getName();
                ExtractorLinkType extractorLinkType4 = ExtractorLinkType.M3U8;
                TeamsToday teamsToday9 = teamsToday4;
                C00103 c00104 = new C00103(str15, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(teamsToday9);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(str16);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(str17);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(function7);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(str18);
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(str19);
                c00082.L$7 = SpillingKt.nullOutSpilledVariable(str20);
                c00082.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                c00082.L$9 = SpillingKt.nullOutSpilledVariable(str12);
                c00082.L$10 = SpillingKt.nullOutSpilledVariable(str15);
                c00082.L$11 = SpillingKt.nullOutSpilledVariable(text3);
                c00082.L$12 = SpillingKt.nullOutSpilledVariable(strFindStreamUrl2);
                c00082.L$13 = function7;
                c00082.label = 5;
                objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name7, name8, strFindStreamUrl2, extractorLinkType4, c00104, c00082);
                if (objNewExtractorLink2 == obj) {
                    return obj;
                }
                function10 = function7;
                function10.invoke(objNewExtractorLink2);
                return Unit.INSTANCE;
            case 5:
                Function1<? super ExtractorLink, Unit> function21 = (Function1) c00082.L$13;
                ResultKt.throwOnFailure(obj5);
                function10 = function21;
                objNewExtractorLink2 = obj5;
                function10.invoke(objNewExtractorLink2);
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj5);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.cncverse.TeamsToday$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TeamsToday$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00092 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $redirectTarget;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00092(String str, Continuation<? super C00092> continuation) {
            super(2, continuation);
            this.$redirectTarget = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00092 = new C00092(this.$redirectTarget, continuation);
            c00092.L$0 = obj;
            return c00092;
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
                    $this$newExtractorLink.setReferer(this.$redirectTarget);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.TeamsToday$getUrl$3 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TeamsToday$getUrl$3", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00103 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $iframeSrc;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00103(String str, Continuation<? super C00103> continuation) {
            super(2, continuation);
            this.$iframeSrc = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00103 = new C00103(this.$iframeSrc, continuation);
            c00103.L$0 = obj;
            return c00103;
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
                    $this$newExtractorLink.setReferer(this.$iframeSrc);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final String findStreamUrl(String html) {
        String it;
        List groupValues;
        String raw;
        MatchResult matchResultFind$default = Regex.find$default(this.jwFileRegex, html, 0, 2, (Object) null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (raw = (String) groupValues.get(1)) != null) {
            String cleaned = unescapeUrl(raw);
            if (StringsKt.startsWith$default(cleaned, "http", false, 2, (Object) null) && StringsKt.contains$default(cleaned, ".m3u8", false, 2, (Object) null)) {
                return cleaned;
            }
        }
        MatchResult matchResultFind$default2 = Regex.find$default(this.rawM3u8Regex, html, 0, 2, (Object) null);
        if (matchResultFind$default2 == null || (it = matchResultFind$default2.getValue()) == null) {
            return null;
        }
        return unescapeUrl(it);
    }

    private final String unescapeUrl(String raw) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.trim(raw).toString(), "\\/", "/", false, 4, (Object) null), "\\u002F", "/", false, 4, (Object) null);
    }
}
