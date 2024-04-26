create table if not exists Run (
	run_id INT not null,
	title varchar(20) not null,
	distance FLOAT,
	primary key(run_id)
);
