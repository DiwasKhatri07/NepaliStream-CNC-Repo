package com.fourKHDHub;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.MainActivityKt;
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

/* JADX INFO: compiled from: FourKHDHubProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/FourKHDHub/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016Ê\u0001\u0002\b\b¨\u0006\u0007"}, d2 = {"Lcom/fourKHDHub/FourKHDHubProvider;", "Lcom/lagradost/cloudstream3/plugins/BasePlugin;", "<init>", "()V", "load", "", "Companion", "FourKHDHub", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class FourKHDHubProvider extends BasePlugin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";

    @Nullable
    private static Companion.Domains cachedDomains;

    public void load() {
        registerMainAPI(new FourKHDHub());
        registerExtractorAPI(new HubCloud());
        registerExtractorAPI((ExtractorApi) new HdStream4u());
        registerExtractorAPI((ExtractorApi) new Hubstream());
        registerExtractorAPI(new Hubstreamdad());
        registerExtractorAPI(new Hubcdnn());
        registerExtractorAPI((ExtractorApi) new PixelDrainDev());
        registerExtractorAPI(new HUBCDN());
    }

    /* JADX INFO: compiled from: FourKHDHubProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/fourKHDHub/FourKHDHubProvider$Companion;", "", "<init>", "()V", "DOMAINS_URL", "", "cachedDomains", "Lcom/fourKHDHub/FourKHDHubProvider$Companion$Domains;", "getCachedDomains", "()Lcom/fourKHDHub/FourKHDHubProvider$Companion$Domains;", "setCachedDomains", "(Lcom/fourKHDHub/FourKHDHubProvider$Companion$Domains;)V", "getDomains", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Domains", "FourKHDHub"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nFourKHDHubProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FourKHDHubProvider.kt\ncom/fourKHDHub/FourKHDHubProvider$Companion\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,45:1\n73#2,5:46\n*S KotlinDebug\n*F\n+ 1 FourKHDHubProvider.kt\ncom/fourKHDHub/FourKHDHubProvider$Companion\n*L\n29#1:46,5\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Domains getCachedDomains() {
            return FourKHDHubProvider.cachedDomains;
        }

        public final void setCachedDomains(@Nullable Domains domains) {
            FourKHDHubProvider.cachedDomains = domains;
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
            FourKHDHubProvider$Companion$getDomains$1 fourKHDHubProvider$Companion$getDomains$1;
            Companion companion;
            Object safe;
            if (continuation instanceof FourKHDHubProvider$Companion$getDomains$1) {
                fourKHDHubProvider$Companion$getDomains$1 = (FourKHDHubProvider$Companion$getDomains$1) continuation;
                if ((fourKHDHubProvider$Companion$getDomains$1.label & Integer.MIN_VALUE) != 0) {
                    fourKHDHubProvider$Companion$getDomains$1.label -= Integer.MIN_VALUE;
                } else {
                    fourKHDHubProvider$Companion$getDomains$1 = new FourKHDHubProvider$Companion$getDomains$1(this, continuation);
                }
            } else {
                fourKHDHubProvider$Companion$getDomains$1 = new FourKHDHubProvider$Companion$getDomains$1(this, continuation);
            }
            FourKHDHubProvider$Companion$getDomains$1 fourKHDHubProvider$Companion$getDomains$2 = fourKHDHubProvider$Companion$getDomains$1;
            Object $result = fourKHDHubProvider$Companion$getDomains$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (fourKHDHubProvider$Companion$getDomains$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (getCachedDomains() == null || forceRefresh) {
                        try {
                            Requests app = MainActivityKt.getApp();
                            try {
                                fourKHDHubProvider$Companion$getDomains$2.L$0 = this;
                                fourKHDHubProvider$Companion$getDomains$2.Z$0 = forceRefresh;
                                fourKHDHubProvider$Companion$getDomains$2.label = 1;
                                try {
                                    $result = Requests.get$default(app, FourKHDHubProvider.DOMAINS_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, fourKHDHubProvider$Companion$getDomains$2, 4094, (Object) null);
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
                    boolean z = fourKHDHubProvider$Companion$getDomains$2.Z$0;
                    Companion companion2 = (Companion) fourKHDHubProvider$Companion$getDomains$2.L$0;
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

        /* JADX INFO: compiled from: FourKHDHubProvider.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J9\u0010\u000f\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/fourKHDHub/FourKHDHubProvider$Companion$Domains;", "", "n4khdhub", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "4khdhub", "hubcloud", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getN4khdhub", "()Ljava/lang/String;", "getHubcloud", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "FourKHDHub"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Domains {

            @NotNull
            private final String hubcloud;

            @NotNull
            private final String n4khdhub;

            public static /* synthetic */ Domains copy$default(Domains domains, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = domains.n4khdhub;
                }
                if ((i & 2) != 0) {
                    str2 = domains.hubcloud;
                }
                return domains.copy(str, str2);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getN4khdhub() {
                return this.n4khdhub;
            }

            @NotNull
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getHubcloud() {
                return this.hubcloud;
            }

            @NotNull
            public final Domains copy(@JsonProperty("4khdhub") @NotNull String n4khdhub, @JsonProperty("hubcloud") @NotNull String hubcloud) {
                return new Domains(n4khdhub, hubcloud);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Domains)) {
                    return false;
                }
                Domains domains = (Domains) other;
                return Intrinsics.areEqual(this.n4khdhub, domains.n4khdhub) && Intrinsics.areEqual(this.hubcloud, domains.hubcloud);
            }

            public int hashCode() {
                return (this.n4khdhub.hashCode() * 31) + this.hubcloud.hashCode();
            }

            @NotNull
            public String toString() {
                return "Domains(n4khdhub=" + this.n4khdhub + ", hubcloud=" + this.hubcloud + ')';
            }

            public Domains(@JsonProperty("4khdhub") @NotNull String n4khdhub, @JsonProperty("hubcloud") @NotNull String hubcloud) {
                this.n4khdhub = n4khdhub;
                this.hubcloud = hubcloud;
            }

            @NotNull
            public final String getN4khdhub() {
                return this.n4khdhub;
            }

            @NotNull
            public final String getHubcloud() {
                return this.hubcloud;
            }
        }
    }
}
