package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u0014\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\tHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/phisher98/JikanData;", "", "title", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "external", "", "Lcom/phisher98/JikanExternal;", "season", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getExternal", "()Ljava/util/List;", "getSeason", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class JikanData {

    @Nullable
    private final List<JikanExternal> external;

    @Nullable
    private final String season;

    @Nullable
    private final String title;

    public JikanData() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JikanData copy$default(JikanData jikanData, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jikanData.title;
        }
        if ((i & 2) != 0) {
            list = jikanData.external;
        }
        if ((i & 4) != 0) {
            str2 = jikanData.season;
        }
        return jikanData.copy(str, list, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final List<JikanExternal> component2() {
        return this.external;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSeason() {
        return this.season;
    }

    @NotNull
    public final JikanData copy(@JsonProperty("title") @Nullable String title, @JsonProperty("external") @Nullable List<JikanExternal> external, @JsonProperty("season") @Nullable String season) {
        return new JikanData(title, external, season);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JikanData)) {
            return false;
        }
        JikanData jikanData = (JikanData) other;
        return Intrinsics.areEqual(this.title, jikanData.title) && Intrinsics.areEqual(this.external, jikanData.external) && Intrinsics.areEqual(this.season, jikanData.season);
    }

    public int hashCode() {
        return ((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.external == null ? 0 : this.external.hashCode())) * 31) + (this.season != null ? this.season.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "JikanData(title=" + this.title + ", external=" + this.external + ", season=" + this.season + ')';
    }

    public JikanData(@JsonProperty("title") @Nullable String title, @JsonProperty("external") @Nullable List<JikanExternal> list, @JsonProperty("season") @Nullable String season) {
        this.title = title;
        this.external = list;
        this.season = season;
    }

    public /* synthetic */ JikanData(String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2);
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final List<JikanExternal> getExternal() {
        return this.external;
    }

    @Nullable
    public final String getSeason() {
        return this.season;
    }
}
