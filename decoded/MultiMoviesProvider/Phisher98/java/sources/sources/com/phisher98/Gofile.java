package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MultiMoviesProvider/classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0005#$%&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/phisher98/Gofile;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "mainApi", "browserLanguage", "secret", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQuality", "", "str", "sha256", "input", "formatBytes", "bytes", "", "AccountResponse", "AccountData", "GofileResponse", "GofileData", "GofileFile", "MultiMoviesProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/phisher98/Gofile\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,379:1\n73#2,5:380\n73#2,5:385\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/phisher98/Gofile\n*L\n297#1:380,5\n315#1:385,5\n*E\n"})
public class Gofile extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "Gofile";

    @NotNull
    private final String mainUrl = "https://gofile.io";

    @NotNull
    private final String mainApi = "https://api.gofile.io";

    @NotNull
    private final String browserLanguage = "en-GB";

    @NotNull
    private final String secret = "gf2026x";

    /* JADX INFO: renamed from: com.phisher98.Gofile$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Gofile", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {295, 312, 326}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "id", "$this", "url", "referer", "subtitleCallback", "callback", "id", "token", "interval", "message", "hashedToken", "headers", "currentTimeSeconds", "$this", "url", "referer", "subtitleCallback", "callback", "id", "token", "interval", "message", "hashedToken", "headers", "parsedResponse", "childrenMap", "file", "fileName", "formattedSize", "currentTimeSeconds", "size"}, nl = {297, 315, 325}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15", "L$16", "J$0", "J$1"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        long J$0;
        long J$1;
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

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Gofile.getUrl$suspendImpl(Gofile.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:110:0x040f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:67:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:71:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:73:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:78:0x0415  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x041d  */
    /* JADX WARN: Code duplicated, block: B:82:0x0422  */
    /* JADX WARN: Code duplicated, block: B:85:0x04df A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:86:0x04e0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x04e0 -> B:87:0x04ff). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.phisher98.Gofile r41, java.lang.String r42, java.lang.String r43, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r44, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r45, kotlin.coroutines.Continuation<? super kotlin.Unit> r46) {
        /*
            Method dump skipped, instruction units count: 1380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.Gofile.getUrl$suspendImpl(com.phisher98.Gofile, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.phisher98.Gofile$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Gofile$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00032 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fileName;
        final /* synthetic */ String $token;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00032(String str, String str2, Continuation<? super C00032> continuation) {
            super(2, continuation);
            this.$fileName = str;
            this.$token = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00032 = Gofile.this.new C00032(this.$fileName, this.$token, continuation);
            c00032.L$0 = obj;
            return c00032;
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
                    $this$newExtractorLink.setQuality(Gofile.this.getQuality(this.$fileName));
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(TuplesKt.to("Cookie", "accountToken=" + this.$token)));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getQuality(String str) {
        List groupValues;
        String str2;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(\\d{3,4})[pP]"), str == null ? "" : str, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? Qualities.Unknown.getValue() : intOrNull.intValue();
    }

    private final String sha256(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] bytes = input.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bytes2 = md.digest(bytes);
        return ArraysKt.joinToString$default(bytes2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.Gofile$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Gofile.sha256$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence sha256$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final String formatBytes(long bytes) {
        if (bytes < 1073741824) {
            String str = String.format("%.2f MB", Arrays.copyOf(new Object[]{Double.valueOf(bytes / 1048576.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        String str2 = String.format("%.2f GB", Arrays.copyOf(new Object[]{Double.valueOf(bytes / 1.073741824E9d)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/phisher98/Gofile$AccountResponse;", "", "data", "Lcom/phisher98/Gofile$AccountData;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/phisher98/Gofile$AccountData;)V", "getData", "()Lcom/phisher98/Gofile$AccountData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "MultiMoviesProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AccountResponse {

        @Nullable
        private final AccountData data;

        /* JADX WARN: Illegal instructions before constructor call */
        public AccountResponse() {
            AccountData accountData = null;
            this(accountData, 1, accountData);
        }

        public static /* synthetic */ AccountResponse copy$default(AccountResponse accountResponse, AccountData accountData, int i, Object obj) {
            if ((i & 1) != 0) {
                accountData = accountResponse.data;
            }
            return accountResponse.copy(accountData);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AccountData getData() {
            return this.data;
        }

        @NotNull
        public final AccountResponse copy(@JsonProperty("data") @Nullable AccountData data) {
            return new AccountResponse(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AccountResponse) && Intrinsics.areEqual(this.data, ((AccountResponse) other).data);
        }

        public int hashCode() {
            if (this.data == null) {
                return 0;
            }
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "AccountResponse(data=" + this.data + ')';
        }

        public AccountResponse(@JsonProperty("data") @Nullable AccountData data) {
            this.data = data;
        }

        public /* synthetic */ AccountResponse(AccountData accountData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : accountData);
        }

        @Nullable
        public final AccountData getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/phisher98/Gofile$AccountData;", "", "token", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "MultiMoviesProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AccountData {

        @Nullable
        private final String token;

        /* JADX WARN: Illegal instructions before constructor call */
        public AccountData() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ AccountData copy$default(AccountData accountData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = accountData.token;
            }
            return accountData.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        @NotNull
        public final AccountData copy(@JsonProperty("token") @Nullable String token) {
            return new AccountData(token);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AccountData) && Intrinsics.areEqual(this.token, ((AccountData) other).token);
        }

        public int hashCode() {
            if (this.token == null) {
                return 0;
            }
            return this.token.hashCode();
        }

        @NotNull
        public String toString() {
            return "AccountData(token=" + this.token + ')';
        }

        public AccountData(@JsonProperty("token") @Nullable String token) {
            this.token = token;
        }

        public /* synthetic */ AccountData(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @Nullable
        public final String getToken() {
            return this.token;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/phisher98/Gofile$GofileResponse;", "", "data", "Lcom/phisher98/Gofile$GofileData;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/phisher98/Gofile$GofileData;)V", "getData", "()Lcom/phisher98/Gofile$GofileData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "MultiMoviesProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class GofileResponse {

        @Nullable
        private final GofileData data;

        /* JADX WARN: Illegal instructions before constructor call */
        public GofileResponse() {
            GofileData gofileData = null;
            this(gofileData, 1, gofileData);
        }

        public static /* synthetic */ GofileResponse copy$default(GofileResponse gofileResponse, GofileData gofileData, int i, Object obj) {
            if ((i & 1) != 0) {
                gofileData = gofileResponse.data;
            }
            return gofileResponse.copy(gofileData);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GofileData getData() {
            return this.data;
        }

        @NotNull
        public final GofileResponse copy(@JsonProperty("data") @Nullable GofileData data) {
            return new GofileResponse(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GofileResponse) && Intrinsics.areEqual(this.data, ((GofileResponse) other).data);
        }

        public int hashCode() {
            if (this.data == null) {
                return 0;
            }
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "GofileResponse(data=" + this.data + ')';
        }

        public GofileResponse(@JsonProperty("data") @Nullable GofileData data) {
            this.data = data;
        }

        public /* synthetic */ GofileResponse(GofileData gofileData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : gofileData);
        }

        @Nullable
        public final GofileData getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012$\b\u0003\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J/\u0010\r\u001a\u00020\u00002$\b\u0003\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0004HÖ\u0081\u0004R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/phisher98/Gofile$GofileData;", "", "children", "", "", "Lcom/phisher98/Gofile$GofileFile;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/Map;)V", "getChildren", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "MultiMoviesProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class GofileData {

        @Nullable
        private final Map<String, GofileFile> children;

        /* JADX WARN: Illegal instructions before constructor call */
        public GofileData() {
            Map map = null;
            this(map, 1, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GofileData copy$default(GofileData gofileData, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = gofileData.children;
            }
            return gofileData.copy(map);
        }

        @Nullable
        public final Map<String, GofileFile> component1() {
            return this.children;
        }

        @NotNull
        public final GofileData copy(@JsonProperty("children") @Nullable Map<String, GofileFile> children) {
            return new GofileData(children);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GofileData) && Intrinsics.areEqual(this.children, ((GofileData) other).children);
        }

        public int hashCode() {
            if (this.children == null) {
                return 0;
            }
            return this.children.hashCode();
        }

        @NotNull
        public String toString() {
            return "GofileData(children=" + this.children + ')';
        }

        public GofileData(@JsonProperty("children") @Nullable Map<String, GofileFile> map) {
            this.children = map;
        }

        public /* synthetic */ GofileData(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : map);
        }

        @Nullable
        public final Map<String, GofileFile> getChildren() {
            return this.children;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0011Jv\u0010\u0017\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/phisher98/Gofile$GofileFile;", "", "type", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "link", "size", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getType", "()Ljava/lang/String;", "getName", "getLink", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/phisher98/Gofile$GofileFile;", "equals", "", "other", "hashCode", "", "toString", "MultiMoviesProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class GofileFile {

        @Nullable
        private final String link;

        @Nullable
        private final String name;

        @Nullable
        private final Long size;

        @Nullable
        private final String type;

        public GofileFile() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ GofileFile copy$default(GofileFile gofileFile, String str, String str2, String str3, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gofileFile.type;
            }
            if ((i & 2) != 0) {
                str2 = gofileFile.name;
            }
            if ((i & 4) != 0) {
                str3 = gofileFile.link;
            }
            if ((i & 8) != 0) {
                l = gofileFile.size;
            }
            return gofileFile.copy(str, str2, str3, l);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getSize() {
            return this.size;
        }

        @NotNull
        public final GofileFile copy(@JsonProperty("type") @Nullable String type, @JsonProperty("name") @Nullable String name, @JsonProperty("link") @Nullable String link, @JsonProperty("size") @Nullable Long size) {
            return new GofileFile(type, name, link, size);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GofileFile)) {
                return false;
            }
            GofileFile gofileFile = (GofileFile) other;
            return Intrinsics.areEqual(this.type, gofileFile.type) && Intrinsics.areEqual(this.name, gofileFile.name) && Intrinsics.areEqual(this.link, gofileFile.link) && Intrinsics.areEqual(this.size, gofileFile.size);
        }

        public int hashCode() {
            return ((((((this.type == null ? 0 : this.type.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.link == null ? 0 : this.link.hashCode())) * 31) + (this.size != null ? this.size.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "GofileFile(type=" + this.type + ", name=" + this.name + ", link=" + this.link + ", size=" + this.size + ')';
        }

        public GofileFile(@JsonProperty("type") @Nullable String type, @JsonProperty("name") @Nullable String name, @JsonProperty("link") @Nullable String link, @JsonProperty("size") @Nullable Long size) {
            this.type = type;
            this.name = name;
            this.link = link;
            this.size = size;
        }

        public /* synthetic */ GofileFile(String str, String str2, String str3, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? 0L : l);
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getLink() {
            return this.link;
        }

        @Nullable
        public final Long getSize() {
            return this.size;
        }
    }
}
