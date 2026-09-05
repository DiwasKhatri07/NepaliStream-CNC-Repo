package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0004HÖ\u0081\u0004R-\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/phisher98/VaplayerData;", "", "streamUrls", "", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "stream_urls", "<init>", "(Ljava/util/List;)V", "getStreamUrls", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class VaplayerData {

    @JsonProperty("stream_urls")
    @Nullable
    private final List<String> streamUrls;

    /* JADX WARN: Illegal instructions before constructor call */
    public VaplayerData() {
        List list = null;
        this(list, 1, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VaplayerData copy$default(VaplayerData vaplayerData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = vaplayerData.streamUrls;
        }
        return vaplayerData.copy(list);
    }

    @Nullable
    public final List<String> component1() {
        return this.streamUrls;
    }

    @NotNull
    public final VaplayerData copy(@JsonProperty("stream_urls") @Nullable List<String> streamUrls) {
        return new VaplayerData(streamUrls);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VaplayerData) && Intrinsics.areEqual(this.streamUrls, ((VaplayerData) other).streamUrls);
    }

    public int hashCode() {
        if (this.streamUrls == null) {
            return 0;
        }
        return this.streamUrls.hashCode();
    }

    @NotNull
    public String toString() {
        return "VaplayerData(streamUrls=" + this.streamUrls + ')';
    }

    public VaplayerData(@JsonProperty("stream_urls") @Nullable List<String> list) {
        this.streamUrls = list;
    }

    public /* synthetic */ VaplayerData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    @Nullable
    public final List<String> getStreamUrls() {
        return this.streamUrls;
    }
}
