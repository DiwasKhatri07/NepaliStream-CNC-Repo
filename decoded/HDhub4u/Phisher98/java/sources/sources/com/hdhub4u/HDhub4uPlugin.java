package com.hdhub4u;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.extractors.StreamTape;
import com.lagradost.cloudstream3.plugins.BasePlugin;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HDhub4uPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/HDhub4u/Phisher98/java/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016Ê\u0001\u0002\b\b¨\u0006\u0007"}, d2 = {"Lcom/hdhub4u/HDhub4uPlugin;", "Lcom/lagradost/cloudstream3/plugins/BasePlugin;", "<init>", "()V", "load", "", "Companion", "HDhub4u", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class HDhub4uPlugin extends BasePlugin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";

    @Nullable
    private static Companion.Domains cachedDomains;

    public void load() {
        registerMainAPI(new HDhub4uProvider());
        registerExtractorAPI((ExtractorApi) new HdStream4u());
        registerExtractorAPI((ExtractorApi) new StreamTape());
        registerExtractorAPI(new Hblinks());
        registerExtractorAPI(new HubCloud());
        registerExtractorAPI(new Hubstream());
        registerExtractorAPI(new Hubcdnn());
        registerExtractorAPI(new Hubdrive());
        registerExtractorAPI(new Hubstreamdad());
        registerExtractorAPI(new HUBCDN());
        registerExtractorAPI((ExtractorApi) new PixelDrainDev());
    }

    /* JADX INFO: compiled from: HDhub4uPlugin.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/hdhub4u/HDhub4uPlugin$Companion;", "", "<init>", "()V", "DOMAINS_URL", "", "cachedDomains", "Lcom/hdhub4u/HDhub4uPlugin$Companion$Domains;", "getCachedDomains", "()Lcom/hdhub4u/HDhub4uPlugin$Companion$Domains;", "setCachedDomains", "(Lcom/hdhub4u/HDhub4uPlugin$Companion$Domains;)V", "getDomains", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Domains", "HDhub4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nHDhub4uPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HDhub4uPlugin.kt\ncom/hdhub4u/HDhub4uPlugin$Companion\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,50:1\n73#2,5:51\n*S KotlinDebug\n*F\n+ 1 HDhub4uPlugin.kt\ncom/hdhub4u/HDhub4uPlugin$Companion\n*L\n34#1:51,5\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Domains getCachedDomains() {
            return HDhub4uPlugin.cachedDomains;
        }

        public final void setCachedDomains(@Nullable Domains domains) {
            HDhub4uPlugin.cachedDomains = domains;
        }

        public static /* synthetic */ Object getDomains$default(Companion companion, boolean z, Continuation continuation, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.getDomains(z, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x001a  */
        @Nullable
        public final Object getDomains(boolean forceRefresh, @NotNull Continuation<? super Domains> continuation) {
            HDhub4uPlugin$Companion$getDomains$1 hDhub4uPlugin$Companion$getDomains$1;
            Companion companion;
            Object safe;
            if (continuation instanceof HDhub4uPlugin$Companion$getDomains$1) {
                hDhub4uPlugin$Companion$getDomains$1 = (HDhub4uPlugin$Companion$getDomains$1) continuation;
                if ((hDhub4uPlugin$Companion$getDomains$1.label & Integer.MIN_VALUE) != 0) {
                    hDhub4uPlugin$Companion$getDomains$1.label -= Integer.MIN_VALUE;
                } else {
                    hDhub4uPlugin$Companion$getDomains$1 = new HDhub4uPlugin$Companion$getDomains$1(this, continuation);
                }
            } else {
                hDhub4uPlugin$Companion$getDomains$1 = new HDhub4uPlugin$Companion$getDomains$1(this, continuation);
            }
            HDhub4uPlugin$Companion$getDomains$1 hDhub4uPlugin$Companion$getDomains$2 = hDhub4uPlugin$Companion$getDomains$1;
            Object $result = hDhub4uPlugin$Companion$getDomains$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (hDhub4uPlugin$Companion$getDomains$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (getCachedDomains() == null || forceRefresh) {
                        try {
                            Requests app = MainActivityKt.getApp();
                            try {
                                hDhub4uPlugin$Companion$getDomains$2.L$0 = this;
                                hDhub4uPlugin$Companion$getDomains$2.Z$0 = forceRefresh;
                                hDhub4uPlugin$Companion$getDomains$2.label = 1;
                                try {
                                    $result = Requests.get$default(app, HDhub4uPlugin.DOMAINS_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, hDhub4uPlugin$Companion$getDomains$2, 4094, (Object) null);
                                    if ($result == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    companion = this;
                                    try {
                                        NiceResponse this_$iv = (NiceResponse) $result;
                                        try {
                                            ResponseParser parser = this_$iv.getParser();
                                            Intrinsics.checkNotNull(parser);
                                            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Domains.class));
                                        } catch (Exception e$iv) {
                                            e$iv.printStackTrace();
                                            safe = null;
                                        }
                                        companion.setCachedDomains((Domains) safe);
                                    } catch (Exception e) {
                                        e = e;
                                        e.printStackTrace();
                                        return null;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    return null;
                                }
                            } catch (Exception e3) {
                                e = e3;
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                        break;
                    }
                    return getCachedDomains();
                case 1:
                    boolean z = hDhub4uPlugin$Companion$getDomains$2.Z$0;
                    Companion companion2 = (Companion) hDhub4uPlugin$Companion$getDomains$2.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        companion = companion2;
                        NiceResponse this_$iv2 = (NiceResponse) $result;
                        ResponseParser parser2 = this_$iv2.getParser();
                        Intrinsics.checkNotNull(parser2);
                        safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Domains.class));
                        companion.setCachedDomains((Domains) safe);
                        return getCachedDomains();
                    } catch (Exception e5) {
                        e = e5;
                        e.printStackTrace();
                        return null;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: HDhub4uPlugin.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J9\u0010\u000e\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/hdhub4u/HDhub4uPlugin$Companion$Domains;", "", "hubcloud", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "HDHUB4u", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getHubcloud", "()Ljava/lang/String;", "getHDHUB4u", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "HDhub4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Domains {

            @NotNull
            private final String HDHUB4u;

            @NotNull
            private final String hubcloud;

            public static /* synthetic */ Domains copy$default(Domains domains, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = domains.hubcloud;
                }
                if ((i & 2) != 0) {
                    str2 = domains.HDHUB4u;
                }
                return domains.copy(str, str2);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getHubcloud() {
                return this.hubcloud;
            }

            @NotNull
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getHDHUB4u() {
                return this.HDHUB4u;
            }

            @NotNull
            public final Domains copy(@JsonProperty("hubcloud") @NotNull String hubcloud, @JsonProperty("HDHUB4u") @NotNull String HDHUB4u) {
                return new Domains(hubcloud, HDHUB4u);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Domains)) {
                    return false;
                }
                Domains domains = (Domains) other;
                return Intrinsics.areEqual(this.hubcloud, domains.hubcloud) && Intrinsics.areEqual(this.HDHUB4u, domains.HDHUB4u);
            }

            public int hashCode() {
                return (this.hubcloud.hashCode() * 31) + this.HDHUB4u.hashCode();
            }

            @NotNull
            public String toString() {
                return "Domains(hubcloud=" + this.hubcloud + ", HDHUB4u=" + this.HDHUB4u + ')';
            }

            public Domains(@JsonProperty("hubcloud") @NotNull String hubcloud, @JsonProperty("HDHUB4u") @NotNull String HDHUB4u) {
                this.hubcloud = hubcloud;
                this.HDHUB4u = HDHUB4u;
            }

            @NotNull
            public final String getHubcloud() {
                return this.hubcloud;
            }

            @NotNull
            public final String getHDHUB4u() {
                return this.HDHUB4u;
            }
        }
    }
}
